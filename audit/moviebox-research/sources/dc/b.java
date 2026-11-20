package dc;

import com.cloud.tmc.kernel.bridge.extension.bind.BindException;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface b<A extends Annotation, T> {
    T a(Class<T> cls, A a11) throws BindException;
}
