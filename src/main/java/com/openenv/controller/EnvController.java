package com.openenv.controller;

import com.openenv.env.CodeReviewEnv;
import com.openenv.model.Action;
import com.openenv.service.GraderService;

import org.springframework.web.bind.annotation.*;

@RestController
public class EnvController {

    private CodeReviewEnv env = new CodeReviewEnv();

    @GetMapping("/reset")
    public Object reset(@RequestParam(defaultValue = "easy") String task) {
        return env.reset(task);
    }

    @PostMapping("/step")
    public Object step(@RequestBody Action action) {
        return env.step(action);
    }

    @GetMapping("/state")
    public Object state() {
        return env.state();
    }

    @GetMapping("/grader")
    public Object grader() {
        return GraderService.grade(env.state());
    }

    @GetMapping("/tasks")
    public String[] tasks() {
        return new String[]{"easy", "medium", "hard"};
    }
}