package com.springLearn.springApp.db.services.impl;

import com.springLearn.springApp.model.Task;
import com.springLearn.springApp.db.repository.TaskRepository;
import com.springLearn.springApp.db.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.getAll();
    }

    @Override
    public void remove(int id) {
        taskRepository.remove(id);
    }

    @Override
    public Integer add(Task task) {
        return taskRepository.add(task);
    }

}
