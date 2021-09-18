package launch.services;

import launch.model.Task;
import launch.persistence.TaskDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

public class TaskService {
    private int id =0;

    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void saveTask(Task task){
        if(task.getId()==null){
            task.setId(++id);
        }
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
    public Collection<Task> getAll(){
        return taskDAO.getAll();
    }

}
