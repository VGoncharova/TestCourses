package Reflection.boxes;

import java.lang.annotation.Annotation;

public class RestrictedBox extends Box {
    @Override
    protected void addToBox(Object value) {
        boolean accessOk = false;
        Class valueClass = value.getClass();
        for (Annotation annotation:
             valueClass.getAnnotations()) {
           if(annotation instanceof AccessToRestrictedBox) {
               accessOk = true;
           }
        }

        if(accessOk) {
            super.addToBox(value);
        } else {
            System.out.println("Access denied!");
        }
    }
}
