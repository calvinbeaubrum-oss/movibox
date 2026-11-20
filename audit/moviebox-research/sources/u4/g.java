package u4;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static void a(long j11, z3.c0 c0Var, r0[] r0VarArr) {
        while (true) {
            if (c0Var.a() <= 1) {
                return;
            }
            int iC = c(c0Var);
            int iC2 = c(c0Var);
            int iF = c0Var.f() + iC2;
            if (iC2 == -1 || iC2 > c0Var.a()) {
                z3.o.h("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iF = c0Var.g();
            } else if (iC == 4 && iC2 >= 8) {
                int iH = c0Var.H();
                int iN = c0Var.N();
                int iQ = iN == 49 ? c0Var.q() : 0;
                int iH2 = c0Var.H();
                if (iN == 47) {
                    c0Var.V(1);
                }
                boolean z11 = iH == 181 && (iN == 49 || iN == 47) && iH2 == 3;
                if (iN == 49) {
                    z11 &= iQ == 1195456820;
                }
                if (z11) {
                    b(j11, c0Var, r0VarArr);
                }
            }
            c0Var.U(iF);
        }
    }

    public static void b(long j11, z3.c0 c0Var, r0[] r0VarArr) {
        int iH = c0Var.H();
        if ((iH & 64) != 0) {
            c0Var.V(1);
            int i11 = (iH & 31) * 3;
            int iF = c0Var.f();
            for (r0 r0Var : r0VarArr) {
                c0Var.U(iF);
                r0Var.c(c0Var, i11);
                z3.a.g(j11 != C.TIME_UNSET);
                r0Var.f(j11, 1, i11, 0, null);
            }
        }
    }

    public static int c(z3.c0 c0Var) {
        int i11 = 0;
        while (c0Var.a() != 0) {
            int iH = c0Var.H();
            i11 += iH;
            if (iH != 255) {
                return i11;
            }
        }
        return -1;
    }
}
