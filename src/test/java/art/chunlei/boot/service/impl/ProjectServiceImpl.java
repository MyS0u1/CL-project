package art.chunlei.boot.service.impl;

import art.chunlei.boot.mapper.ProjectMapper;
import art.chunlei.boot.pojo.Project;
import art.chunlei.boot.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
}
