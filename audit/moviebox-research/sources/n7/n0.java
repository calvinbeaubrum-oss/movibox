package n7;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class n0 implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n0 f71698a = new n0();

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        m0 m0Var = (m0) obj;
        if (m0Var == null) {
            o0Var.J();
        } else {
            m0Var.a(o0Var, obj2, type, i11);
        }
    }
}
