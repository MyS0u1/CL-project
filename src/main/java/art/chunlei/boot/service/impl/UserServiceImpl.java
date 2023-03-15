package art.chunlei.boot.service.impl;

import art.chunlei.boot.pojo.User;
import art.chunlei.boot.mapper.UserMapper;
import art.chunlei.boot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
