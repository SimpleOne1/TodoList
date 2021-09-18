package launch.persistence;

import launch.Storage.Storage;
import launch.model.Task;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class TaskDaoInMemImpl implements TaskDAO {

    private final Storage storage = new Storage();
    private final Map<Integer,Task> taskStorage = new HashMap<>();

    public TaskDaoInMemImpl() {
    }

    @Override
    public Integer save(Task task) {
        taskStorage.put(task.getId(),task);
        return task.getId();
    }

    @Override
    public void delete(Integer id) {
        taskStorage.remove(id);
    }

    @Override
    public void deleteAll() {
        taskStorage.clear();
    }

    @Override
    public void edit(Integer id,String text) {
        taskStorage.get(id).setText(text);
    }

    @Override
    public Collection<Task> getAll() {
        return taskStorage.values();
    }
}
