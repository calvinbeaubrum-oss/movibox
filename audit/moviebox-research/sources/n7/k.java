package n7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class k implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f71690a = new k();

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        if (obj == null) {
            o0Var.f71701k.i0(SerializerFeature.WriteNullStringAsEmpty);
        } else {
            o0Var.I(obj.toString());
        }
    }
}
