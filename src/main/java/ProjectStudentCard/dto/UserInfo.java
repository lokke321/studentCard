package ProjectStudentCard.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserInfo {

    Integer id;
    String name;
    String dateOfBirth;
    String course;
    String faculty;


    public UserInfo (Integer id){
        this.id = id;
    }
}
