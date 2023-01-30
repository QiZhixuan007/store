package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {

    public static final int OK = 200;

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        }else if(e instanceof UserNotFoundException){
            result.setState(4001);
            result.setMessage("用户数据不存在的异常");
        }else if(e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("用户密码错误的异常");
        }else if(e instanceof AddressCountLimitException){
            result.setState(4003);
            result.setMessage("用户的收获地址超出上限");
        }else if(e instanceof AddressNotFoundException){
            result.setState(4004);
            result.setMessage("用户的收获地址不存在");
        }else if(e instanceof AccessDeniedException){
            result.setState(4005);
            result.setMessage("收货地址数据非法访问");
        }else if(e instanceof ProductNotFoundException){
            result.setState(4006);
            result.setMessage("商品数据不存在");
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生未知异常");
        }else if(e instanceof UpdateException){
            result.setState(5001);
            result.setMessage("更新数据时产生未知异常");
        }else if(e instanceof DeleteException){
            result.setState(5002);
            result.setMessage("删除数据时产生未知异常");
        }else if(e instanceof FileEmptyException){
            result.setState(6000);
            result.setMessage("文件为空");
        }else if(e instanceof FileSizeException){
            result.setState(6001);
            result.setMessage("文件大小错误");
        }else if(e instanceof FileTypeException){
            result.setState(6002);
            result.setMessage("文件格式错误");
        }else if(e instanceof FileStateException){
            result.setState(6003);
            result.setMessage("文件状态异常");
        }else if(e instanceof FileUploadException){
            result.setState(6004);
            result.setMessage("文件上传异常");
        }
        return result;
    }

    /**
     * 获取session对象中的uid
     * @param session
     * @return 当前登录用户的uid
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取session对象中的username
     * @param session
     * @return 当前登录用户的username
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
