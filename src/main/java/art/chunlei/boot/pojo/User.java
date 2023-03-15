package art.chunlei.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data  // set/get/canEqual/equals/hashCode/toString
public class User {
    @TableId("user_id")
    private Integer userId;

    private String email;

    private String password;

    private Integer releaseProject;

    private Integer historyRelease;

    private Integer participateProject;

    private Integer historyParticipate;

    public User() {}

    public User(Integer userId, String email, String password, Integer releaseProject, Integer historyRelease, Integer participateProject, Integer historyParticipate) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.releaseProject = releaseProject;
        this.historyRelease = historyRelease;
        this.participateProject = participateProject;
        this.historyParticipate = historyParticipate;
    }
}
