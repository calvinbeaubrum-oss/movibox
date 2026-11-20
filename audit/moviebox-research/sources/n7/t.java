package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class t implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f71749a = new t();

    @Override // m7.b2
    public int b() {
        return 6;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            j1Var.i0(SerializerFeature.WriteNullBooleanAsFalse);
        } else if (bool.booleanValue()) {
            j1Var.write("true");
        } else {
            j1Var.write("false");
        }
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        Object obj2;
        l7.b bVar = aVar.f70077g;
        try {
            if (bVar.k0() == 6) {
                bVar.W(16);
                obj2 = (T) Boolean.TRUE;
            } else if (bVar.k0() == 7) {
                bVar.W(16);
                obj2 = (T) Boolean.FALSE;
            } else if (bVar.k0() == 2) {
                int iH = bVar.h();
                bVar.W(16);
                obj2 = iH == 1 ? (T) Boolean.TRUE : (T) Boolean.FALSE;
            } else {
                Object objX = aVar.x();
                if (objX == null) {
                    return null;
                }
                obj2 = (T) TypeUtils.k(objX);
            }
            return type == AtomicBoolean.class ? (T) new AtomicBoolean(((Boolean) obj2).booleanValue()) : (T) obj2;
        } catch (Exception e11) {
            throw new JSONException("parseBoolean error, field : " + obj, e11);
        }
    }
}
