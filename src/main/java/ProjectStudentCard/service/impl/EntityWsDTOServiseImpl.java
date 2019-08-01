package ProjectStudentCard.service.impl;

import ProjectStudentCard.dto.UserInfo;
import ProjectStudentCard.entity.UserInfoEntity;
import ProjectStudentCard.service.EntityWsDTOServise;
import org.springframework.stereotype.Service;

@Service
public class EntityWsDTOServiseImpl implements EntityWsDTOServise {

    @Override
    public UserInfo userInfoEntityToDTO(UserInfoEntity userInfoEntity) {
     Integer id = userInfoEntity.getId();
     String name = userInfoEntity.getName();
     String dob = userInfoEntity.getDateOfBirth();
     String course = userInfoEntity.getCourse();
     String faculty = userInfoEntity.getFaculty();

    UserInfo userInfo = new UserInfo(id , name, dob, course, faculty);
     return userInfo;
    }
}
