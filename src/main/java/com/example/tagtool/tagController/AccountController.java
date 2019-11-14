package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.Account;
import com.example.tagtool.tagService.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

//    登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean login(String account, String password, HttpSession session){
        ResponseBean responseBean = new ResponseBean();
        Object accountLast = session.getAttribute("account");
        if(accountLast !=null){
            responseBean.setMessage("已经登录");
            responseBean.setData(0);
            return responseBean;
        }
        int accountNumber = accountService.findAccountNumberByAccount(account);
        if(accountNumber ==0){
            responseBean.setMessage("账号错误");
            responseBean.setData(1);
            return responseBean;
        }
        Account accountNow = accountService.findAccountByAccount(account);
//        String dPassword = null;
//        dPassword = AesEncryptUtil.decrypt(password);
        if(accountNow.getPassword().equals(Md5Encrypt.string1MD5(password))) {
            session.setAttribute("account", accountNow);

            responseBean.setMessage("登录成功");
            if (accountNow.getRole().equals("管理员")) {
                responseBean.setData("system");
            } else if (accountNow.getRole().equals("实验室用户")) {
                responseBean.setData("labUser");
            }
        }else{
            responseBean.setMessage("密码错误");
            responseBean.setData(2);
        }
        return responseBean;
    }

//    @RequestMapping(value = "/findAccountByAccount")
//    @ResponseBody
//    public ResponseBean findAccountByAccount(String account){
//        ResponseBean response = new ResponseBean();
//        response.setMessage("查询成功");
//        response.setData(accountService.findAccountByAccount(account));
//        return response;
//    }

//    注销
    @RequestMapping(value = "/loginOut")
    @ResponseBody
    public ResponseBean loginOut(HttpSession session){
        ResponseBean responseBean = new ResponseBean();
        session.removeAttribute("account");
        Object userInfo = session.getAttribute("account");
        if(userInfo == null){
            responseBean.setMessage("账号已退出登录");
            responseBean.setData(1);
        }else {
            responseBean.setMessage("退出登录失败");
            responseBean.setData(0);
        }
        return responseBean;
    }

//    修改密码
@AuthController(value = AuthLevel.LOGGED,roles = {RoleType.MANAGER_ROLE_ID,RoleType.USER_ROLE_ID})
@RequestMapping(value="/rePassword",method= RequestMethod.POST)
@ResponseBody
public ResponseBean rePassword(String account, String oldPassword, String newPassword,HttpSession session){
    ResponseBean responseBean = new ResponseBean();
    int accountNumber = accountService.findAccountNumberByAccount(account);
    if (accountNumber==0){
        responseBean.setMessage("账号错误");
        responseBean.setData(0);
        return responseBean;
    }
    Account user = (Account) session.getAttribute("account");
    if(user == null) {
        responseBean.setMessage("未登录");
        responseBean.setData(0);
        return responseBean;
    }else if(!user.getAccount().equals(account)){
        responseBean.setMessage("只能修改自己的密码");
        responseBean.setData(0);
        return responseBean;
    }
    Account accountNow = accountService.findAccountByAccount(account);
    String dPassword = null;
    String nPassword = null;
    dPassword = AesEncryptUtil.decrypt(oldPassword);
    nPassword = AesEncryptUtil.decrypt(newPassword);
    if (accountNow.getPassword().equals(Md5Encrypt.string1MD5(dPassword))){
        accountNow.setPassword(Md5Encrypt.string1MD5(nPassword));
        int data = accountService.updatePassword(accountNow);
        if (data == 1){
            responseBean.setMessage("修改成功");
            responseBean.setData(1);
        }else{
            responseBean.setMessage("修改失败");
            responseBean.setData(0);
        }
    }else{
        responseBean.setMessage("密码错误");
        responseBean.setData(0);
    }
    return responseBean;
    }

    //插入账号
    @AuthController(value = AuthLevel.LOGGED,roles = {RoleType.MANAGER_ROLE_ID})
    @RequestMapping("/insertAccount")
    @ResponseBody
    public ResponseBean insertAccount(Account account){
        ResponseBean responseBean = new ResponseBean();
        //设置默认密码为123456
        String password = "123456";
        account.setPassword(Md5Encrypt.string1MD5(password));
        int accountNumber = accountService.findAccountNumberByAccount(account.getAccount());
        if ( account.getAccount() != null && account.getAccount().length() != 0 && accountNumber == 0){

                int accountResult = accountService.insertAccount(account);
                if (accountResult == 1){
                    responseBean.setMessage("插入成功");
                    responseBean.setData(1);
                }else {
                    responseBean.setMessage("插入失败");
                    responseBean.setData(0);
                }

        }else{
            responseBean.setMessage("角色为空或账号重复，插入失败");
            responseBean.setData(0);
        }

        return responseBean;
    }

    //查找所有账号信息
    @AuthController(value = AuthLevel.LOGGED,roles = {RoleType.MANAGER_ROLE_ID})
    @RequestMapping("/findAllAccount")
    @ResponseBody
    public ResponseBean findAllAccount(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(accountService.findAllAccount());
        responseBean.setMessage("查询成功");
        return responseBean;
    }

//    删除账号
    @AuthController(value = AuthLevel.LOGGED,roles = {RoleType.MANAGER_ROLE_ID})
    @RequestMapping("deleteAccountByAccountAndRole")
    @ResponseBody
    public ResponseBean deleteAccountByAccount(Account account){
        account.setPassword("123456");//若删除失败，则回填入账号表
        account.setName("错误");
        ResponseBean responseBean = new ResponseBean();
        String role = account.getRole();
        if (role.equals("实验室用户")){
            int accountResult = accountService.deleteAccount(account.getAccount());
            if (accountResult == 1){
                responseBean.setMessage("删除成功");
                responseBean.setData(1);
            }else if(accountResult == 0){
                responseBean.setMessage("删除失败");
                responseBean.setData(0);
            }
        }else{
            responseBean.setMessage("角色有误，删除失败");
            responseBean.setData(0);
        }
        return responseBean;
    }
}
