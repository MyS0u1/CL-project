package art.chunlei.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Project {
    @TableId("project_id")
    private Long projectId;

    private String projectName;

    private String projectType;

    private Timestamp projectDeadline;

    private float projectBudget;

    private Integer isBargaining;

    @TableLogic
    private Integer isDeleted;

    public Project() {}

    public Project(Long projectId, String projectName, String projectType, Timestamp projectDeadline, float projectBudget, Integer isBargaining, Integer isDeleted) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectType = projectType;
        this.projectDeadline = projectDeadline;
        this.projectBudget = projectBudget;
        this.isBargaining = isBargaining;
        this.isDeleted = isDeleted;
    }
}
