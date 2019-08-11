package com.springLearn.springApp.controller;

import com.springLearn.springApp.model.Task;
import com.springLearn.springApp.db.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

        private final TaskService taskService;

        public TaskController(TaskService taskService){
            this.taskService = taskService;
        }

        @PostMapping()
        public ResponseEntity add(@RequestBody Task task){
            Integer id = taskService.add(task);
            if (id != null) {
                return new ResponseEntity<>(id, HttpStatus.CREATED);
            }
            return new ResponseEntity<>( null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @GetMapping("{id}")
        public ResponseEntity remove(@PathVariable("id") int id){
            taskService.remove(id);
            return new ResponseEntity<>( HttpStatus.OK);
        }

        @GetMapping()
        public ResponseEntity getAll() {
            List<Task> taskList = taskService.getTasks();
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        }
}
