package eu;

import com.transsion.json.b.n;
import com.transsion.json.p;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    boolean include() default true;

    String name() default "";

    Class<? extends p> objectFactory() default p.class;

    Class<? extends n> transformer() default n.class;
}
