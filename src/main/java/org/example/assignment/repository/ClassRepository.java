package org.example.assignment.repository;

import org.example.assignment.domain.entity.Classes;
import org.example.assignment.domain.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classes, Long> {

}
