package com.example.converterapispring.service;

import com.example.converterapispring.logic.ISolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller                                // REST-контроллер
@RequestMapping("/service")             // маршрутизация
public class SolverService {
    @Autowired                   // аннотация автосвязывания
    private ISolver solver;     // объект интерфейс решателя (DI)

    // 1. ping
    @GetMapping("/ping")
    public @ResponseBody ClassMessages.Message ping() {
        return new ClassMessages.Message("pong");
    }

    // 2. статус сервера
    @GetMapping("/status")
    public @ResponseBody ClassMessages.Message status() {
        return new ClassMessages.Message("Server status OK at port 8080");
    }

//     3. решение
    @PostMapping("/solve")
    public @ResponseBody ClassMessages.IMessage solve(@RequestBody ClassMessages.InputMessage input) {
        System.out.println("Received data: " + input);
        ClassMessages.OutputMessage out = solver.solve(input);
        if (out == null) {
            return new ClassMessages.ErrorMessage("coefficient a should be != 0");
        }
        return out;
    }
}
