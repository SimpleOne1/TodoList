package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import launch.model.Task;
import launch.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/todo"}
)


public class TODOServlet extends HttpServlet {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private TaskService taskService;
    private ConfigurableApplicationContext context;

    public TODOServlet(TaskService taskService) {
        this.taskService = taskService;
    }

    public TODOServlet() {
    }


    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = new ClassPathXmlApplicationContext("Application.xml");
        setTaskService(context.getBean(TaskService.class));
    }

    @Override
    public void destroy() {
        context.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        mapper.writeValue(resp.getOutputStream(), taskService.getAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Task task = mapper.readValue(req.getInputStream(), Task.class);
        taskService.saveTask(task);
        mapper.writeValue(resp.getOutputStream(), task);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (id == null) {
            taskService.deleteAll();
        } else {
            taskService.deleteTask(Integer.parseInt(id));
        }
    }

}
