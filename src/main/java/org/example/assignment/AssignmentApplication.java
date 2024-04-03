package org.example.assignment;

import org.example.assignment.config.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication {

  public static void main(String[] args) {
    SpringApplication.run(AssignmentApplication.class, args);
    Logger.getInstance().log("hehe");
  }

}
