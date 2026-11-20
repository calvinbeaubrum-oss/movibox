package n7;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class l0 implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f71695a = new l0();

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        v0 v0Var = v0.f71758j;
        try {
            Field declaredField = obj.getClass().getDeclaredField("map");
            if (Modifier.isPrivate(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
            }
            v0Var.d(o0Var, declaredField.get(obj), obj2, type, i11);
        } catch (Exception unused) {
            j1Var.g0();
        }
    }
}
