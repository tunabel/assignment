package org.example.assignment.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "classes")
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Classes extends AbstractEntity {

  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classes_seq")
  @SequenceGenerator(sequenceName = "classes_seq", name = "classes_seq", allocationSize = 1)
  @Id
  private long id;

  @Column(name = "name")
  private String name;

  @OneToMany(targetEntity = Score.class, mappedBy = "classes")
  private List<Score> scores;

}
