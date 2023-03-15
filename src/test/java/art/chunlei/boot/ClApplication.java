package art.chunlei.boot;

import art.chunlei.boot.pojo.User;
import art.chunlei.boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("art.chunlei.boot.mapper")
@SpringBootTest
public class ClApplication {

    public static void main(String[] args) {
        SpringApplication.run(art.ClApplication.class, args);

    }

    @Autowired
    UserService userService;

    @Test
    public void insert1() {
        userService.save(new User(null, "123@qq.com", "123", null));
    }

    @Test
    public void update1() {
//        userService.update(new User(null, "123456@qq.com", "123", null), null);
        userService.updateById(new User(1L, "123@163.com", "123", null));
    }

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test1() {
        System.out.println(redisTemplate);
    }
}
