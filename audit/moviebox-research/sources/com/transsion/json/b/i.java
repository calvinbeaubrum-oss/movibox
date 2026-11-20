package com.transsion.json.b;

import com.transsion.json.r;
import com.transsion.json.x;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        com.transsion.json.i iVarB = b();
        r rVarX = iVarB.x();
        Map map = (Map) obj;
        try {
            x xVarH = b().H();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                Object next = it.next();
                rVarX.a(next != null ? next.toString() : null);
                if (iVarB.o(next != null ? next.toString() : null, map.get(next))) {
                    n nVarA = iVarB.a(null, map.get(next));
                    if (!(nVarA instanceof g) || !((g) nVarA).a().booleanValue()) {
                        if (xVarH.e()) {
                            b().E();
                        }
                        xVarH.d();
                        if (next != null) {
                            b().u(next.toString());
                        } else {
                            b().u(null);
                        }
                    }
                    if (next != null) {
                        xVarH.b(next.toString());
                    } else {
                        xVarH.b(null);
                    }
                    nVarA.a(map.get(next));
                }
                rVarX.d();
            }
            b().D();
        } catch (Exception e11) {
            throw new com.transsion.json.k(String.format("%s: Error while trying to serialize.", rVarX), e11);
        }
    }
}
