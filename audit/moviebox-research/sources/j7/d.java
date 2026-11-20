package j7;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import l7.h;
import n7.h1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface d {
    boolean alphabetic() default true;

    boolean asm() default true;

    Class<? extends h.c> autoTypeCheckHandler() default h.c.class;

    Class<?> builder() default Void.class;

    Class<?> deserializer() default Void.class;

    String[] ignores() default {};

    String[] includes() default {};

    Class<?> mappingTo() default Void.class;

    PropertyNamingStrategy naming() default PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue;

    String[] orders() default {};

    Feature[] parseFeatures() default {};

    Class<?>[] seeAlso() default {};

    boolean serializeEnumAsJavaBean() default false;

    Class<?> serializer() default Void.class;

    SerializerFeature[] serialzeFeatures() default {};

    Class<? extends h1>[] serialzeFilters() default {};

    String typeKey() default "";

    String typeName() default "";
}
