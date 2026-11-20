package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Charsets;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a1 extends dk {
    private static bf a(ah ahVar) {
        ahVar.d(12);
        int iD = (ahVar.d() + ahVar.a(12)) - 4;
        ahVar.d(44);
        ahVar.e(ahVar.a(12));
        ahVar.d(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strA = null;
            if (ahVar.d() >= iD) {
                break;
            }
            ahVar.d(48);
            int iA = ahVar.a(8);
            ahVar.d(4);
            int iD2 = ahVar.d() + ahVar.a(12);
            String strA2 = null;
            while (ahVar.d() < iD2) {
                int iA2 = ahVar.a(8);
                int iA3 = ahVar.a(8);
                int iD3 = ahVar.d() + iA3;
                if (iA2 == 2) {
                    int iA4 = ahVar.a(16);
                    ahVar.d(8);
                    if (iA4 == 3) {
                        while (ahVar.d() < iD3) {
                            strA = ahVar.a(ahVar.a(8), Charsets.US_ASCII);
                            int iA5 = ahVar.a(8);
                            for (int i11 = 0; i11 < iA5; i11++) {
                                ahVar.e(ahVar.a(8));
                            }
                        }
                    }
                } else if (iA2 == 21) {
                    strA2 = ahVar.a(iA3, Charsets.US_ASCII);
                }
                ahVar.c(iD3 * 8);
            }
            ahVar.c(iD2 * 8);
            if (strA != null && strA2 != null) {
                arrayList.add(new z0(iA, strA + strA2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new bf(arrayList);
    }

    @Override // com.applovin.impl.dk
    public bf a(ef efVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return a(new ah(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
