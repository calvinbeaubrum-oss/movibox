package bm;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import rj.e;
import rj.h;
import rj.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b implements j {
    public static /* synthetic */ Object c(String str, rj.c cVar, e eVar) {
        try {
            c.b(str);
            return cVar.h().a(eVar);
        } finally {
            c.a();
        }
    }

    @Override // rj.j
    public List<rj.c<?>> a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final rj.c<?> cVarT : componentRegistrar.getComponents()) {
            final String strI = cVarT.i();
            if (strI != null) {
                cVarT = cVarT.t(new h() { // from class: bm.a
                    @Override // rj.h
                    public final Object a(e eVar) {
                        return b.c(strI, cVarT, eVar);
                    }
                });
            }
            arrayList.add(cVarT);
        }
        return arrayList;
    }
}
