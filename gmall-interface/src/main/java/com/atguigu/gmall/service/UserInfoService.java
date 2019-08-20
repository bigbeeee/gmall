package com.atguigu.gmall.service;



import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

//业务逻辑层
public interface UserInfoService {

    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAll();


    UserInfo getUserInfoByName(String name);
    /**
     * 根据用户的属性查询  高度封装
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoListByName(UserInfo userInfo);

    /**
     * 根据用户的属性查询  高度封装
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoListByNickName(UserInfo userInfo);

    //添加   的返回值  int boolean
    void addUser(UserInfo userInfo);

    //更新
    void updateUser(UserInfo userInfo);

    //删除
     void deleteUser(UserInfo userInfo);

    /**
     *
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddressByUserId(String userId);

    /**
     *
     * @param userAddress
     * @return
     */
    List<UserAddress> getUserAddressByUserId(UserAddress userAddress);
}
