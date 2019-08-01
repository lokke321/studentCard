package ProjectStudentCard.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyException extends RuntimeException {

     public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

}