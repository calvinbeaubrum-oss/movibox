package cc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@a
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface f {
    Class<? extends com.cloud.tmc.kernel.node.d> value();
}
