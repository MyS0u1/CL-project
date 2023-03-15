package art.chunlei.boot.service.impl;

import art.chunlei.boot.service.VerifyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class VerifyServiceImpl implements VerifyService {
    @Resource
    JavaMailSender sender;  // 一个用于发送邮箱的类

    @Resource
    StringRedisTemplate template;   //用于Redis数据库操作

    @Value("${spring.mail.username}")
    String senderEmail;

    @Override
    public void sendVerifyCode(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件标题
        message.setSubject("【CL软件外包】您的验证码为: ");
        //设置随机数作为验证码
        Random random = new Random();
        int code = random.nextInt(89999) + 10001;  // [10001, 99999]
        //用redis保存验证码
        //提前验证一下，如果发送了多次则删除上一次的验证码，保留最新的验证码
        if (template.opsForValue().get("verify:code:"+email)!=null){
            template.delete("verify:code:"+email);
        }
        template.opsForValue().set("verify:code:"+email,code+"",5, TimeUnit.MINUTES);//设置五分钟过期时间
        //邮件内容
        message.setText("您的验证码是："+code+"，五分钟有效，请及时完成注册。若不是本人操作请忽略");
        message.setFrom(senderEmail); //谁发送，必须和yaml文件中的账号一致
        message.setTo(email);   //谁接收
        sender.send(message);
    }

    @Override
    public boolean doVerify(String email, String code) {
        String str = template.opsForValue().get("verify:code:"+email);
        if (str.equals(code)){
            template.delete("verify:code:"+email);
            return true;
        }
        return false;
    }
}