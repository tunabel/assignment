package org.example.assignment.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "score")
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Score extends AbstractEntity {

  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_seq")
  @SequenceGenerator(sequenceName = "score_seq", name = "score_seq", allocationSize = 1)
  @Id
  private long id;

  @Column(name = "name")
  private String name;

  @ManyToOne(targetEntity = Student.class)
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne(targetEntity = Classes.class)
  @JoinColumn(name = "class_id")
  private Classes classes;

  @Column(name = "score_number")
  private Integer scoreNumber;

}
