/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

/**
 *
 * @author Nhat Anh
 */
public class Constant {

    public static final String MESSAGE__USER_EXIST = "User name already exist ";

    public static final String MESSAGE_WRONG_PASSWORD = "Password not valid";

    public static final String MESSAGE_NEW_PASSWORD_NOT_MATCH = "New pass not match with renew pass";

    public static final String REGEX_USER_NAME = "^[a-zA-Z0-9]{1,}$";

    public static final String REGEX_PASS_WORD = "^[a-zA-Z0-9]{5,}$";

    public static final String REGEX_NAME = "^[a-zA-Z]{1,}$";

    public static final String REGEX_PHONE = "^[0-9]{10,11}$";

    public static final String REGEX_EMAIL
            = "^[\\w-\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    public static final String REGEX_ADDRESS = "^[a-zA-Z0-9]{1,}$";

    public static final String REGEX_DATE_OF_BIRTH
            = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|"
            + "(?:(?:29|30)(\\/|-|\\.)"
            + "(?:0?[1,3-9]|1[0-2])\\2))"
            + "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"
            + "|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)"
            + "?(?:0[48]|[2468][048]|[13579][26])|"
            + "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]"
            + "|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])"
            + "|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
}
