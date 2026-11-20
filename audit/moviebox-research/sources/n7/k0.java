package n7;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class k0 implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k0 f71691a = new k0();

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.g0();
        } else {
            j1Var.write(((com.alibaba.fastjson.b) obj).toJSONString());
        }
    }
}
