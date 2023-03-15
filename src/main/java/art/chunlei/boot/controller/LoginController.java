package art.chunlei.boot.controller;

import art.chunlei.boot.pojo.User;
import art.chunlei.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/isLogin")
    public String isLogin(User user, HttpSession session, Model model) {
        List<User> users;
        Map<String, Object> map = new HashMap<>();
        map.put("email", user.getEmail());
        users = userService.getBaseMapper().selectByMap(map);

        if(!users.isEmpty()) {
            if(users.get(0).getPassword().equals(user.getPassword())) {
                session.setAttribute("loginUser", user);
                model.addAttribute("loginMsg", "登录成功！");
                return "index_";
            } else {
                model.addAttribute("loginMsg", "密码错误！");
                return "login";
            }
        } else {
            model.addAttribute("loginMsg", "用户不存在！");
            return "login";
        }
    }
}
