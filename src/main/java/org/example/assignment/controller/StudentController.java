package org.example.assignment.controller;

import lombok.RequiredArgsConstructor;
import org.example.assignment.domain.dto.ScoreDto;
import org.example.assignment.domain.dto.StudentDto;
import org.example.assignment.service.ScoreService;
import org.example.assignment.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;
  private final ScoreService scoreService;

  @GetMapping
  public ResponseEntity<Page<StudentDto>> findAll(@PageableDefault Pageable pageable) {
    return ResponseEntity.ok(studentService.findAll(pageable));
  }

  @PostMapping
  public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(studentService.create(studentDto));
  }

  @PostMapping("/score")
  public ResponseEntity<Void> addScore(@RequestBody ScoreDto scoreDto) {
    scoreService.addScore(scoreDto);
    return ResponseEntity.ok().build();
  }


}
