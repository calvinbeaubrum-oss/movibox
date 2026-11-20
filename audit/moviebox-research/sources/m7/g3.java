package m7;

import com.alibaba.fastjson.JSONException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g3 implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<f3> f70885a;

    public g3(Class<f3> cls) {
        this.f70885a = cls;
    }

    @Override // m7.b2
    public int b() {
        return 12;
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        try {
            return (T) aVar.U(this.f70885a.newInstance(), obj);
        } catch (Exception unused) {
            throw new JSONException("craete instance error");
        }
    }
}
