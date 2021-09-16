package launch.persistence;

import launch.model.Task;

public interface TaskDAO {

    public Integer save(Task task);

    public void delete(Integer id);

    public void edit(Integer id,String text);

    public void deleteAll();

}
