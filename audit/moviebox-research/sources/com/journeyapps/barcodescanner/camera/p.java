package com.journeyapps.barcodescanner.camera;

import xn.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class p extends PreviewScalingStrategy {
    public static t e(t tVar, t tVar2) {
        t tVarD;
        if (tVar2.b(tVar)) {
            while (true) {
                tVarD = tVar.d(2, 3);
                t tVarD2 = tVar.d(1, 2);
                if (!tVar2.b(tVarD2)) {
                    break;
                }
                tVar = tVarD2;
            }
            return tVar2.b(tVarD) ? tVarD : tVar;
        }
        do {
            t tVarD3 = tVar.d(3, 2);
            tVar = tVar.d(2, 1);
            if (tVar2.b(tVarD3)) {
                return tVarD3;
            }
        } while (!tVar2.b(tVar));
        return tVar;
    }
}
