package ProjectStudentCard.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    @Column(name = "date_of_birth")
    String dateOfBirth;
    String course;
    String faculty;

    public UserInfoEntity (String name, String dateOfBirth, String course, String faculty){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.course = course;
        this.faculty = faculty;

    }

    public  UserInfoEntity (Integer id){
        this.id = id;
    }

}
