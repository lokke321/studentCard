package ProjectStudentCard.service;

import ProjectStudentCard.dto.UserInfo;
import ProjectStudentCard.entity.UserInfoEntity;

public interface EntityWsDTOServise {

    UserInfo userInfoEntityToDTO (UserInfoEntity userInfoEntity);

}
