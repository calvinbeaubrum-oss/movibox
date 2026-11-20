package n7;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class x implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f71764a = new x();

    @Override // m7.b2
    public int b() {
        return 4;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        Character ch2 = (Character) obj;
        if (ch2 == null) {
            j1Var.j0("");
        } else if (ch2.charValue() == 0) {
            j1Var.j0("\u0000");
        } else {
            j1Var.j0(ch2.toString());
        }
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        Object objX = aVar.x();
        if (objX == null) {
            return null;
        }
        return (T) TypeUtils.n(objX);
    }
}
