package art.chunlei.boot.controller;

import art.chunlei.boot.service.impl.VerifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class VerifyController {
    @Autowired
    VerifyServiceImpl verifyService;

    @RequestMapping("/getVerificationCode")
    @ResponseBody
    public String getVerificationCode(String email) {
        try{
            verifyService.sendVerifyCode(email);
            return "发送成功！";
        } catch(Exception e) {
            e.printStackTrace();
            return "发送失败！";
        }
    }
}
