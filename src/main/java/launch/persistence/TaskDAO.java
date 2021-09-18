package launch.persistence;

import launch.model.Task;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

public interface TaskDAO {

    Integer save(Task task);

    void delete(Integer id);

    void edit(Integer id, String text);

    void deleteAll();

    Collection<Task> getAll();

}
