package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.AccountDao;
import com.example.tagtool.tagEntity.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService {
    @Resource
    private AccountDao accountDao;
//    插入账号
    public int insertAccount(Account account){return accountDao.insertAccount(account);}
//    找到所有账号信息
    public String findRoleByAccount(String account){
        return accountDao.findRoleByAccount(account);
    }
//    根据账号找到对应角色
    public List<Account> findAllAccount(){return accountDao.findAllAccount();}
//    删除账号信息
    public int deleteAccount(String account){
        return accountDao.deleteAccount(account);
    }
//    更新密码
    public  int updatePassword(Account account) {return accountDao.updatePassword(account);}
//    根据账号查询用户账号信息
    public Account findAccountByAccount(String account){return accountDao.findAccountByAccount(account);}
//    根据用户名查询用户账号信息
    public Account findAccountByName(String name){return accountDao.findAccountByName(name);}
//    根据账号查询是否有重复账号
    public int findAccountNumberByAccount(String account){return accountDao.findAccountNumberByAccount(account);}
//    根据用户名查询是否有重复账号
    public int findAccountNumberByName(String name){return accountDao.findAccountNumberByName(name);}
}
