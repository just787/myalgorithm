package javalearn.proxy;

/**
 * @description: 用户管理接口
 * @author: leo
 * @createDate: 2021/7/23 16:57
 * @version: 1.0
 */
public interface UserManager {
    //新增用户抽象方法
    void addUser(String userName, String password);

    //删除用户抽象方法
    void delUser(String userName);
}