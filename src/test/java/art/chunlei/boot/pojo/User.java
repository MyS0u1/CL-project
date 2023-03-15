package art.chunlei.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data  // set/get/canEqual/equals/hashCode/toString
public class User {
    @TableId("user_id")
    private Long userId;

    private String email;

    private String password;

    @TableLogic
    private Integer isDeleted;

    public User() {}

    public User(Long userId, String email, String password, Integer isDeleted) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.isDeleted = isDeleted;
    }
}