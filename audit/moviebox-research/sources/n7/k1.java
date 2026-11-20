package n7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class k1 implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k1 f71692a = new k1();

    public static <T> T f(l7.a aVar) {
        l7.b bVarP = aVar.p();
        if (bVarP.k0() == 4) {
            T t11 = (T) bVarP.g0();
            bVarP.W(16);
            return t11;
        }
        if (bVarP.k0() == 2) {
            T t12 = (T) bVarP.v0();
            bVarP.W(16);
            return t12;
        }
        Object objX = aVar.x();
        if (objX == null) {
            return null;
        }
        return (T) objX.toString();
    }

    @Override // m7.b2
    public int b() {
        return 4;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        g(o0Var, (String) obj);
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        if (type == StringBuffer.class) {
            l7.b bVar = aVar.f70077g;
            if (bVar.k0() == 4) {
                String strG0 = bVar.g0();
                bVar.W(16);
                return (T) new StringBuffer(strG0);
            }
            Object objX = aVar.x();
            if (objX == null) {
                return null;
            }
            return (T) new StringBuffer(objX.toString());
        }
        if (type != StringBuilder.class) {
            return (T) f(aVar);
        }
        l7.b bVar2 = aVar.f70077g;
        if (bVar2.k0() == 4) {
            String strG1 = bVar2.g0();
            bVar2.W(16);
            return (T) new StringBuilder(strG1);
        }
        Object objX2 = aVar.x();
        if (objX2 == null) {
            return null;
        }
        return (T) new StringBuilder(objX2.toString());
    }

    public void g(o0 o0Var, String str) {
        j1 j1Var = o0Var.f71701k;
        if (str == null) {
            j1Var.i0(SerializerFeature.WriteNullStringAsEmpty);
        } else {
            j1Var.j0(str);
        }
    }
}
