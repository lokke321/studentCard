package ProjectStudentCard.service.impl;

import ProjectStudentCard.dto.UserInfo;
import ProjectStudentCard.entity.UserInfoEntity;
import ProjectStudentCard.exeption.MyException;
import ProjectStudentCard.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ProjectStudentCard.service.UserInfoService;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserInfoServiceImpl(UserInfoRepository userInfoRepository, ModelMapper modelMapper) {
        this.userInfoRepository = userInfoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<UserInfo> getAll() {
        Iterable<UserInfoEntity> iterable = userInfoRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(entity -> modelMapper.map(entity, UserInfo.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserInfoEntity findById(Integer id) {
        return userInfoRepository.findById(id)
                .map(entity -> modelMapper.map(entity, UserInfoEntity.class))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public boolean deleteUser(UserInfoEntity userInfoEntity) {
        userInfoRepository.delete(userInfoEntity);
        return true;
    }

    @Override
    public boolean saveUserInfo(UserInfo userInfo) {

        String name = userInfo.getName();
        String dOfb = userInfo.getDateOfBirth();
        String course = userInfo.getCourse();
        String faculty = userInfo.getFaculty();

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setName(name);
        userInfoEntity.setDateOfBirth(dOfb);
        userInfoEntity.setCourse(course);
        userInfoEntity.setFaculty(faculty);

        userInfoRepository.save(userInfoEntity);

        return true;

    }

    @Override
    public UserInfoEntity changeUserInfo(UserInfo userInfo, UserInfoEntity userInfoEntity) {

        String name = userInfo.getName();
        String dateOfBirth = userInfo.getDateOfBirth();
        String course = userInfo.getCourse();
        String faculty = userInfo.getFaculty();

        if (name != null) {
            userInfoEntity.setName(name);
        }
        if (dateOfBirth != null) {
            userInfoEntity.setDateOfBirth(dateOfBirth);
        }
        if (course != null) {
            userInfoEntity.setCourse(course);
        }
        if (faculty != null) {
            userInfoEntity.setFaculty(faculty);
        }
        userInfoRepository.save(userInfoEntity);

        return userInfoEntity;
    }
}