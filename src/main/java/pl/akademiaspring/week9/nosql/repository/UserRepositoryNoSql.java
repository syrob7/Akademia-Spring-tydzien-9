package pl.akademiaspring.week9.nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.akademiaspring.week9.nosql.model.UserNoSql;

@Repository
public interface UserRepositoryNoSql extends MongoRepository<UserNoSql, Long> {
}
