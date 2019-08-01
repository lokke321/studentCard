package ProjectStudentCard.repository;

import ProjectStudentCard.entity.UserInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Integer> {

    }
