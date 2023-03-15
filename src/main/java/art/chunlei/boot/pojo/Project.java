package art.chunlei.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.Date;


@Data
public class Project {
    @TableId("project_id")
    private Integer projectId;

    private String projectName;

    private Date projectDeadline;

    private String projectType;

    private String projectDetails;

    private String projectFile;

    public Project() {}

    public Project(Integer projectId, String projectName, Date projectDeadline, String projectType, String projectDetails, String projectFile) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDeadline = projectDeadline;
        this.projectType = projectType;
        this.projectDetails = projectDetails;
        this.projectFile = projectFile;
    }
}