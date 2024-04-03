package org.example.assignment.config;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.util.Optional;
import org.example.assignment.domain.entity.AbstractEntity;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class CustomAuditingEntityListener extends AuditingEntityListener {

  public CustomAuditingEntityListener(ObjectFactory<AuditingHandler> handler) {
    super.setAuditingHandler(handler);
  }

  public CustomAuditingEntityListener() {

  }

  @Bean
  public AuditorAware<String> auditorAware() {
    return () -> Optional.of("System");
  }

  @Override
  @PrePersist
  public void touchForCreate(Object target) {
    AbstractEntity entity = (AbstractEntity) target;
    if (entity.getCreatedBy() == null) {
      super.touchForCreate(target);
    } else {
      if (entity.getLastModifiedBy() == null) {
        entity.setLastModifiedBy(entity.getCreatedBy());
      }
    }
  }

  @Override
  @PreUpdate
  public void touchForUpdate(Object target) {
    AbstractEntity entity = (AbstractEntity) target;
    if (entity.getLastModifiedBy() == null) {
      super.touchForUpdate(target);
    }
  }
}
