package launch.services;

import launch.model.Task;
import launch.persistence.TaskDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

public class TaskService {

    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void saveTask(Task task){
        taskDAO.save(task);
    }
    public void deleteTask(Integer id){
        taskDAO.delete(id);
    }
    public void deleteAll(){
        taskDAO.deleteAll();
    }
    public void editTask(Integer id,String text){
        taskDAO.edit(id,text);
    }
    public Map<Integer, Task> getAll(){
        return taskDAO.getAll();
    }

}
