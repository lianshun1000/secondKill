package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewObject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EnumBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;


@Controller("user")
@RequestMapping("/user")
@CrossOrigin
public class UserController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    //用户获取otp短信接口
    @RequestMapping(value = "/getOtp",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name="telephone") String telephone){

        //需要按照一定规则生成otp验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);
        //将otp验证码同对应的用户手机号关联,使用httpsession方式绑定他的手机号与OTPCODE
        httpServletRequest.getSession().setAttribute(telephone,otpCode);
        //将otp验证码通过短信通道发送给用户，省略
        System.out.println("telephone="+telephone+"&otpCode="+otpCode);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name="id") Integer id) throws BusinessException {
         //调用service的服务获取对应id的用户对象并返回前端
         UserModel userModel = userService.getUserById(id);

         //若获取的用户信息不存在
        if(userModel == null){
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }

         //将核心领域模型用户对象转换为展示在前端的ViewObject
         UserVO userVO = convertFromModel(userModel);

         return CommonReturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }



}
