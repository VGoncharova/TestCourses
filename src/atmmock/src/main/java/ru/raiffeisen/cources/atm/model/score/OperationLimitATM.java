package atmmock.src.main.java.ru.raiffeisen.cources.atm.model.score;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OperationLimitATM {
    int limit();
}
