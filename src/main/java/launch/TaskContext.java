package launch;

import launch.persistence.TaskDAO;
import launch.persistence.TaskDaoInMemImpl;
import launch.services.TaskService;
import org.springframework.context.annotation.Bean;
import servlet.HelloServlet;

public class TaskContext {
    @Bean
    public HelloServlet helloServlet(TaskService taskService){
        return  new HelloServlet(taskService);
    }
    @Bean
    public TaskService taskService(TaskDAO taskDAO){
        return new TaskService(taskDAO);
    }
    @Bean
    public TaskDAO taskDAO(){
        return new TaskDaoInMemImpl();
    }
}
