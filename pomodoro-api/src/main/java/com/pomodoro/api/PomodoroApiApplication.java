package com.pomodoro.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication()
@Controller
public class PomodoroApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(PomodoroApiApplication.class, args);
  }

  @GetMapping("/")
  public String hello() {
    return "hello world!";
  }
}
