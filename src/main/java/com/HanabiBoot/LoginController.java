package com.HanabiBoot;

import com.HanabiBoot.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PrintWriter;
import com.HanabiBoot.domain.User;


/**
 * Created by chengkang on 2019/4/28.
 */

@RestController
public class LoginController {
//    @RequestMapping("/login")
//    public String index2(){
//        return "欢迎使用 hanabi boot！index2";
//    }

    @RequestMapping(value = "/login",method= RequestMethod.GET)
    public String sayHello(@RequestParam("username") String usr,@RequestParam("password") String pwd){
//        2.接受用户名和密码
        String username = usr;
		String password = pwd;

		//3.调用userservice getUserByUsernameAndPwd()  返回值 user
		User user=null;
		try {
			user = new UserService().getUserByUsernameAndPwd(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String jsonStr = null;

		//4.判断user
		if(user==null){
			//4.1若user为空 提示信息,请求转发到login.jsp
			jsonStr = "{\"msg\":\"登录出错\",\"ret\":\"-1\"}";
		}else{
			jsonStr = "{\"msg\":\"欢迎光临\",\"ret\":\"0\"}";
		}

        return jsonStr;
    }
}
