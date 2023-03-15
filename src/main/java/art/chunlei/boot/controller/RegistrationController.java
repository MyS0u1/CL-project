package art.chunlei.boot.controller;

import art.chunlei.boot.pojo.User;
import art.chunlei.boot.service.UserService;
import art.chunlei.boot.service.impl.VerifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    VerifyServiceImpl verifyService;

    @Autowired
    UserService userService;

    @RequestMapping("/goRegister")
    @ResponseBody
    public String goRegister(String email, String verificationCode, String password) {
        boolean isVerify = verifyService.doVerify(email, verificationCode);
        if(isVerify) {
            Map map = new HashMap();
            map.put("email", email);
            List<User> users = userService.getBaseMapper().selectByMap(map);
            if(users.isEmpty()) {
                User user = new User(null, email, password, 0, 0, 0, 0);
                userService.getBaseMapper().insert(user);
                return "注册成功！";
            }
        }
        return "注册失败！";
    }
}
