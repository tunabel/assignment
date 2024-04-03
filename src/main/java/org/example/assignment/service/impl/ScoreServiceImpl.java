package org.example.assignment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.assignment.domain.dto.ScoreDto;
import org.example.assignment.domain.entity.Classes;
import org.example.assignment.domain.entity.Score;
import org.example.assignment.domain.entity.Student;
import org.example.assignment.exception.StudentException;
import org.example.assignment.repository.ClassRepository;
import org.example.assignment.repository.ScoreRepository;
import org.example.assignment.repository.StudentRepository;
import org.example.assignment.service.ScoreService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

  private final ScoreRepository scoreRepository;
  private final StudentRepository studentRepository;
  private final ClassRepository classRepository;

  @Override
  public void addScore(ScoreDto scoreDto) {
    Student student = studentRepository.findById(scoreDto.getStudentId())
        .orElseThrow(() -> new StudentException("Student doesn't exist"));
    Classes classes = classRepository.findById(scoreDto.getClassesId())
        .orElseThrow(() -> new StudentException("Class doesn't exist"));

    Score score = Score.builder()
        .classes(classes)
        .student(student)
        .scoreNumber(scoreDto.getNumberScore())
        .build();
    scoreRepository.save(score);
  }
}
