package Qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by reuben on 9/20/17.
 */
@Qualifier
@Retention(RUNTIME)
@Target({TYPE,METHOD,FIELD,PARAMETER})
public @interface LoginQualifier {
    LoginChoice value();
    public enum LoginChoice{
        admin,
        member,
        librarian,
    }
}
