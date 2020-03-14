package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.User;
import com.example.tagtool.tagService.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

//    插入人员信息
    @RequestMapping("/insertUserInfo")
    @ResponseBody
    public ResponseBean insertUserInfo(User user){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(userService.insertUserInfo(user));
        responseBean.setMessage("插入成功");
        return responseBean;
    }
//根据用户账号查询任务情况
    @RequestMapping("/findInfoByUserAccount")
    @ResponseBody
    public ResponseBean findInfoByUserAccount(String account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(userService.findInfoByUserAccount(account));
        return responseBean;
    }

//    根据用户账号更新任务情况
    @RequestMapping("/updateTasksByUserAccount")
    @ResponseBody
    public ResponseBean updateTasksByUserAccount(String account,String involved_tasks,String finished_tasks,String progress_tasks,String issue_tasks){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userService.updateTasksByUserAccount(account,involved_tasks,finished_tasks,progress_tasks,issue_tasks));
        return responseBean;
    }
//    根据用户账号更新成绩
    @RequestMapping("/updateScoreByUserAccount")
    @ResponseBody
    public ResponseBean updateScoreByUserAccount(String account,String sds_score,String overall_score){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userService.updateScoreByUserAccount(account,sds_score,overall_score));
        return responseBean;
    }
//    根据用户账号查询成绩
//    @RequestMapping("/findScoreByUserAccount")
//    @ResponseBody
//    public ResponseBean findScoreByUserAccount(String account){
//        ResponseBean responseBean = new ResponseBean();
//        responseBean.setMessage("查询成功");
//        responseBean.setData(userService.findScoreByUserAccount(account));
//        return responseBean;
//    }
}
