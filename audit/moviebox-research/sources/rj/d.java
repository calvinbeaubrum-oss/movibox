package rj;

import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d {
    public static Object a(e eVar, Class cls) {
        return eVar.e(b0.b(cls));
    }

    public static Object b(e eVar, b0 b0Var) {
        bl.b bVarD = eVar.d(b0Var);
        if (bVarD == null) {
            return null;
        }
        return bVarD.get();
    }

    public static bl.a c(e eVar, Class cls) {
        return eVar.a(b0.b(cls));
    }

    public static bl.b d(e eVar, Class cls) {
        return eVar.d(b0.b(cls));
    }

    public static Set e(e eVar, Class cls) {
        return eVar.g(b0.b(cls));
    }

    public static Set f(e eVar, b0 b0Var) {
        return (Set) eVar.h(b0Var).get();
    }
}
