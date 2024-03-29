package javalearn.proxy;

/**
 * @description: 用户管理实现类, 实现用户管理接口
 * @author: leo
 * @createDate: 2021/7/23 16:58
 * @version: 1.0
 */
public class UserManagerImpl implements UserManager {
    //重写新增用户方法
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName: " + userName + " password: " + password);
    }

    //重写删除用户方法
    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName: " + userName);
    }

}