package launch.persistence;

import launch.Storage.Storage;
import launch.model.Task;
import org.springframework.stereotype.Repository;


import java.util.Map;


public class TaskDaoInMemImpl implements TaskDAO {

    public TaskDaoInMemImpl() {
    }

    @Override
    public Integer save(Task task) {
        return Storage.putTaskInStorage(task);
    }

    @Override
    public void delete(Integer id) {
        Storage.DeleteTaskFromStorage(id);
    }

    @Override
    public void deleteAll() {
        Storage.DeleteAllFromStorage();
    }

    @Override
    public void edit(Integer id,String text) {
        Storage.editTask(id,text);
    }

    @Override
    public Map<Integer, Task> getAll() {
        return Storage.getAll();
    }
}
