package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
//    插入账号
    int insertAccount(Account account);
//    找到所有账号信息
    List<Account> findAllAccount();
//    根据账号找到对应角色
    String findRoleByAccount(String account);
//    删除账号信息
    int deleteAccount(String account);
//    更新密码
    int updatePassword(Account account);
//    根据账号查询用户账号信息
    Account findAccountByAccount(String account);
//    根据用户名查询用户账号信息
    Account findAccountByName(String name);
//    根据账号查询是否有重复账号
    int findAccountNumberByAccount(String account);
//    根据用户名查询是否有重复账号
    int findAccountNumberByName(String name);
}
