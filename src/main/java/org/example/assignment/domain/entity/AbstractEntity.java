package org.example.assignment.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;
import org.example.assignment.config.CustomAuditingEntityListener;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(value = {CustomAuditingEntityListener.class})
public class AbstractEntity {

  @CreationTimestamp
  @Column(name = "created_on")
  private ZonedDateTime createdOn;

  @CreatedBy
  @Column(name = "created_by")
  private String createdBy;

  @UpdateTimestamp
  @Column(name = "last_modified_on")
  private ZonedDateTime lastModifiedOn;

  @LastModifiedBy
  @Column(name = "last_modified_by")
  private String lastModifiedBy;

}
