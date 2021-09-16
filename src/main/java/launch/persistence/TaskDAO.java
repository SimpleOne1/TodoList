package launch.persistence;

import launch.model.Task;
import org.springframework.stereotype.Repository;

import java.util.Map;

public interface TaskDAO {

    public Integer save(Task task);

    public void delete(Integer id);

    public void edit(Integer id,String text);

    public void deleteAll();

    public Map<Integer,Task> getAll();

}
