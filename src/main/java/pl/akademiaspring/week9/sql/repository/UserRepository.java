package pl.akademiaspring.week9.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiaspring.week9.sql.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
