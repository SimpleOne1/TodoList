package launch.Storage;

import launch.model.Task;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<Integer, Task> taskStorage = new HashMap<>();

    private Storage(){

    }
    public static Storage getInstance(){
        return StorageHolder.instance;
    }
    private static class StorageHolder {
        private static final Storage instance = new Storage();
    }

    public static Integer putTaskInStorage(Task task){
        getInstance().taskStorage.put(task.getId(),task);
        return task.getId();
    }

    public static void DeleteTaskFromStorage(Integer id){
        getInstance().taskStorage.remove(id);
    }
    public static void DeleteAllFromStorage(){
        getInstance().taskStorage.clear();
    }
    public static void editTask(Integer id,String text){
        getInstance().taskStorage.get(id).setText(text);
    }

    public static Map<Integer,Task> getAll(){
        return getInstance().taskStorage;
    }
}
