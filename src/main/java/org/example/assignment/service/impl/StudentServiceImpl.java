package org.example.assignment.service.impl;

import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.example.assignment.config.Logger;
import org.example.assignment.domain.dto.StudentDto;
import org.example.assignment.domain.entity.Score;
import org.example.assignment.domain.entity.Student;
import org.example.assignment.domain.mapper.StudentMapper;
import org.example.assignment.repository.StudentRepository;
import org.example.assignment.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;

  @Override
  public Page<StudentDto> findAll(Pageable pageable) {
    return studentRepository.findAll(pageable).map(student -> {
      StudentDto studentDto = studentMapper.toDto(student);
      studentDto.setScore(setScore(student));
      return studentDto;
    });
  }

  private Integer setScore(Student student) {
    return student.getScores()
        .stream()
        .map(Score::getScoreNumber)
        .mapToInt(Integer::intValue)
        .sum();
  }

  @Override
  public StudentDto create(StudentDto studentDto) {
    return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(studentDto)));
  }

  private static final Object lock1 = new Object();
  private static final Object lock2 = new Object();

  @Override
  public void doSomethingDeadlock() {
    CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
      synchronized (lock1) {
        Logger.getInstance().log("Thread 1 acquired lock1");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          Logger.getInstance().log("Something wrong while attempting to access the resource");
        }
        Logger.getInstance().log("Thread 1 waiting for lock2");
        synchronized (lock2) {
          Logger.getInstance().log("Thread 1 acquired lock2");
        }
      }
    });

    CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
      synchronized (lock2) {
        Logger.getInstance().log("Thread 2 acquired lock2");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          Logger.getInstance().log("Something wrong while attempting to access the resource");
        }
        Logger.getInstance().log("Thread 2 waiting for lock1");
        synchronized (lock1) {
          Logger.getInstance().log("Thread 2 acquired lock1");
        }
      }
    });
    CompletableFuture.allOf(future1, future2).join();
  }


}
