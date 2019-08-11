package com.springLearn.springApp.db.services;

import com.springLearn.springApp.model.Task;
import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    void remove(int id);

    Integer add(Task task);
}
