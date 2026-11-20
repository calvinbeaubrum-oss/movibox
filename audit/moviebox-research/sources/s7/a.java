package s7;

import java.io.IOException;
import java.lang.reflect.Type;
import n7.o0;
import n7.z0;
import springfox.documentation.spring.web.json.Json;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f76259a = new a();

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        o0Var.y().write(((Json) obj).value());
    }
}
