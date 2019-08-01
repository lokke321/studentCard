package ProjectStudentCard.service;

import ProjectStudentCard.dto.UserInfo;
import ProjectStudentCard.entity.UserEntity;
import ProjectStudentCard.entity.UserInfoEntity;

import java.util.Collection;

public interface UserInfoService {

    Collection<UserInfo> getAll();
    UserInfoEntity findById(Integer id);
    boolean deleteUser(UserInfoEntity userInfoEntity);
    boolean saveUserInfo(UserInfo userInfo);
    UserInfoEntity changeUserInfo(UserInfo userInfo, UserInfoEntity userInfoEntity);
}
