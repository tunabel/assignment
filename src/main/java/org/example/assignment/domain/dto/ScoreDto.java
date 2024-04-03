package org.example.assignment.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class ScoreDto implements Serializable {

  @JsonProperty("student_id")
  private Long studentId;
  @JsonProperty("class_id")
  private Long classesId;
  @JsonProperty("number_score")
  private Integer numberScore;


}
