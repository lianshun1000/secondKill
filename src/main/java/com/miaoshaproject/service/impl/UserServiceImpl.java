package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.UserDoMapper;
import com.miaoshaproject.dao.UserPasswordDoMapper;
import com.miaoshaproject.dataobject.UserDo;
import com.miaoshaproject.dataobject.UserPasswordDo;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDoMapper userDoMapper;
    @Autowired
    private UserPasswordDoMapper userPasswordDoMapper;


    @Override
    public UserModel getUserById(Integer id) {
        //调用userDoMapper获取到对应用户的dataobject
       UserDo userDo = userDoMapper.selectByPrimaryKey(id);
       if(userDo == null){
           return null;
       }
       //通过用户id获取用户对应的加密密码信息
       UserPasswordDo userPasswordDo = userPasswordDoMapper.selectByUserId(userDo.getId());
       return convertFormDataObject(userDo,userPasswordDo);
    }

    private UserModel convertFormDataObject(UserDo userDo, UserPasswordDo userPasswordDo){
        if(userDo == null){
            return  null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDo,userModel);
        if(userPasswordDo != null) {
            userModel.setEncrptPassword(userPasswordDo.getEncrptPassword());
        }
        return userModel;
    }
}
