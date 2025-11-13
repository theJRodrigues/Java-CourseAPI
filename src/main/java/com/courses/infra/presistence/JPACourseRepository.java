package com.courses.infra.presistence;

import com.courses.domain.Course;
import com.courses.domain.CourseRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPACourseRepository extends JpaRepository<Course, UUID>, CourseRepository {}
