package com.courses.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "Courses")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
  @Id
  @GeneratedValue()
  @Column(updatable = false, nullable = false)
  private UUID id;

  private String name;
  private String category;
  private String teacher;
  @Builder.Default private boolean active = true;

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime created_at;

  @UpdateTimestamp private LocalDateTime updated_at;

  public Course(String name, String category, String teacher) {
    this.name = name;
    this.category = category;
    this.teacher = teacher;
  }
}
