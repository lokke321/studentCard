package ProjectStudentCard.controller;


import ProjectStudentCard.dto.UserInfo;
import ProjectStudentCard.entity.UserInfoEntity;
import ProjectStudentCard.repository.UserInfoRepository;
import ProjectStudentCard.service.EntityWsDTOServise;
import ProjectStudentCard.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class StudentController {


    private final UserInfoService userInfoService;
    private final EntityWsDTOServise entityWsDTOServise;
    private  final UserInfoRepository userInfoRepository;
    Collection<UserInfo> userInfoCollection;


    @Autowired
    public StudentController(UserInfoService userInfoService, EntityWsDTOServise entityWsDTOServise, UserInfoRepository userInfoRepository) {
    this.userInfoService = userInfoService;
    this.entityWsDTOServise = entityWsDTOServise;
    this.userInfoRepository = userInfoRepository;
    }

    @RequestMapping(value="/students", method = RequestMethod.GET)
    public Collection<UserInfo> displayAllStudentsCard( ) {
        userInfoCollection = userInfoService.getAll();
        return userInfoCollection;
    }

    @RequestMapping(value="/deleteStudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
    public HttpStatus displayAllStudentsCardAfterDelet(@RequestBody UserInfo userInfoID) {

        Integer id = userInfoID.getId();

        if (id != null) {

            Optional<UserInfoEntity> byId = userInfoRepository.findById(id);

            if (byId.isPresent()) {

                UserInfoEntity delUserInfo = userInfoService.findById(id);
                userInfoService.deleteUser(delUserInfo);

                return HttpStatus.OK;
            }
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value= "/addStudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createUserInfo(@RequestBody UserInfo userInfo ) {

         userInfoService.saveUserInfo(userInfo);

         return  HttpStatus.OK;
    }
     @RequestMapping(value= "/changeStudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
     public HttpStatus changeUserInfo(@RequestBody UserInfo userInfo ) {

         Integer id = userInfo.getId();

         if (id != null) {

             Optional<UserInfoEntity> byId = userInfoRepository.findById(id);

             if (byId.isPresent()) {

                 UserInfoEntity changeUserInfoEntity = userInfoService.findById(id);
                 userInfoService.changeUserInfo(userInfo, changeUserInfoEntity);

                 return HttpStatus.OK;
             }
             return HttpStatus.BAD_REQUEST;
         }
         return HttpStatus.BAD_REQUEST;

     }
}
