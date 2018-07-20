package user;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User)o;

        String userID = user.getId();
        if(userID == null||StringUtils.isEmpty(userID.trim())){
            errors.rejectValue("id", "trouble");
        }

        String userName = user.getName();
        if(userName == null||StringUtils.isEmpty(userName.trim())){
            errors.rejectValue("name", "trouble");
        }

    }
}
