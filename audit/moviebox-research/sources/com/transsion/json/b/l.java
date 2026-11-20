package com.transsion.json.b;

import com.transsion.json.r;
import com.transsion.json.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        com.transsion.json.i iVarB = b();
        r rVarX = iVarB.x();
        com.transsion.json.f fVarZ = iVarB.z();
        try {
            if (fVarZ.contains(obj)) {
                x xVarA = b().A();
                if (xVarA != null) {
                    xVarA.a();
                    return;
                }
                return;
            }
            iVarB.f(new com.transsion.json.f(fVarZ));
            iVarB.z().add(obj);
            com.transsion.json.c cVarA = com.transsion.json.c.a(c(obj));
            x xVarH = iVarB.H();
            for (com.transsion.json.d dVar : cVarA != null ? cVarA.c() : null) {
                rVarX.a(dVar.e());
                if (iVarB.n(dVar) && dVar.n().booleanValue()) {
                    Object objA = dVar.a(obj);
                    if (!iVarB.z().contains(objA)) {
                        n nVarA = iVarB.a(dVar, objA);
                        if (!(nVarA instanceof g) || !((g) nVarA).a().booleanValue()) {
                            if (xVarH.e()) {
                                iVarB.E();
                            }
                            xVarH.d();
                            iVarB.u(dVar.b());
                        }
                        xVarH.b(dVar.b());
                        nVarA.a(objA);
                    }
                }
                rVarX.d();
            }
            iVarB.D();
            iVarB.f((com.transsion.json.f) iVarB.z().a());
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
        } catch (InstantiationException e12) {
            e12.printStackTrace();
        }
    }

    public Class c(Object obj) {
        return obj.getClass();
    }
}
