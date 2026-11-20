package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c3 {
    private static int a(bh bhVar) {
        int i11 = 0;
        while (bhVar.a() != 0) {
            int iW = bhVar.w();
            i11 += iW;
            if (iW != 255) {
                return i11;
            }
        }
        return -1;
    }

    public static void a(long j11, bh bhVar, qo[] qoVarArr) {
        while (true) {
            if (bhVar.a() <= 1) {
                return;
            }
            int iA = a(bhVar);
            int iA2 = a(bhVar);
            int iD = bhVar.d() + iA2;
            if (iA2 == -1 || iA2 > bhVar.a()) {
                pc.d("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iD = bhVar.e();
            } else if (iA == 4 && iA2 >= 8) {
                int iW = bhVar.w();
                int iC = bhVar.C();
                int iJ = iC == 49 ? bhVar.j() : 0;
                int iW2 = bhVar.w();
                if (iC == 47) {
                    bhVar.g(1);
                }
                boolean z11 = iW == 181 && (iC == 49 || iC == 47) && iW2 == 3;
                if (iC == 49) {
                    z11 &= iJ == 1195456820;
                }
                if (z11) {
                    b(j11, bhVar, qoVarArr);
                }
            }
            bhVar.f(iD);
        }
    }

    public static void b(long j11, bh bhVar, qo[] qoVarArr) {
        int iW = bhVar.w();
        if ((iW & 64) != 0) {
            bhVar.g(1);
            int i11 = (iW & 31) * 3;
            int iD = bhVar.d();
            for (qo qoVar : qoVarArr) {
                bhVar.f(iD);
                qoVar.a(bhVar, i11);
                if (j11 != C.TIME_UNSET) {
                    qoVar.a(j11, 1, i11, 0, null);
                }
            }
        }
    }
}
