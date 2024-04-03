package org.example.assignment.domain.mapper;

import org.example.assignment.domain.dto.StudentDto;
import org.example.assignment.domain.entity.Score;
import org.example.assignment.domain.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

  public abstract StudentDto toDto(Student entity);

  public abstract Student toEntity(StudentDto dto);

}
