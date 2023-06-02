package kz.sprint.techboot.sprintSecond.repository;

import kz.sprint.techboot.sprintSecond.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationRequest, Long> {
    List<ApplicationRequest> findAllByOrderByHandled();
}
