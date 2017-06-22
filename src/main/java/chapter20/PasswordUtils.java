package chapter20;

import java.util.List;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-06-21 17:47.
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "password must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "New Password can't equal previously used one")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
