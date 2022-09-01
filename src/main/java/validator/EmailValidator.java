package validator;

import com.company.annotation.EmailExist;
import com.company.dto.UserDto;
import com.company.entity.User;
import com.company.service.UserService;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailValidator
  implements ConstraintValidator<EmailExist, Object> {
    
    @Autowired
    UserService userService;
    
    @Override
    public void initialize(EmailExist constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDto userDto = (UserDto) obj;
        List<User> users = userService.findByEmail(userDto.getEmail());
        return users.isEmpty();
    }
}
