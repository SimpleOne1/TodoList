package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import launch.Storage.Storage;
import launch.model.Task;
import org.springframework.stereotype.Controller;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/todo"}
)

@Controller
public class HelloServlet extends HttpServlet {
    private int id = 0;
    private final ObjectMapper mapper = new ObjectMapper();
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final Storage storage = Storage.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        mapper.writeValue(resp.getOutputStream(), taskMap.values());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Task task = mapper.readValue(req.getInputStream(), Task.class);

        if (Objects.isNull(task.getId())) {
            task.setId(++id);
        }
        taskMap.put(task.getId(), task);
        mapper.writeValue(resp.getOutputStream(), task);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String id = req.getParameter("id");
        if (id == null) {
            taskMap.clear();
        } else {
            taskMap.remove(Integer.parseInt(id));
        }
    }

}
