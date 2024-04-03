package org.example.assignment.service;

import org.example.assignment.domain.dto.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

  Page<StudentDto> findAll(Pageable pageable);

  StudentDto create(StudentDto studentDto);

  void doSomethingDeadlock();
}
