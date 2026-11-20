package tg;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static void a(long j11, com.google.android.exoplayer2.util.c0 c0Var, e0[] e0VarArr) {
        while (true) {
            if (c0Var.a() <= 1) {
                return;
            }
            int iC = c(c0Var);
            int iC2 = c(c0Var);
            int iE = c0Var.e() + iC2;
            if (iC2 == -1 || iC2 > c0Var.a()) {
                com.google.android.exoplayer2.util.s.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iE = c0Var.f();
            } else if (iC == 4 && iC2 >= 8) {
                int iD = c0Var.D();
                int iJ = c0Var.J();
                int iN = iJ == 49 ? c0Var.n() : 0;
                int iD2 = c0Var.D();
                if (iJ == 47) {
                    c0Var.Q(1);
                }
                boolean z11 = iD == 181 && (iJ == 49 || iJ == 47) && iD2 == 3;
                if (iJ == 49) {
                    z11 &= iN == 1195456820;
                }
                if (z11) {
                    b(j11, c0Var, e0VarArr);
                }
            }
            c0Var.P(iE);
        }
    }

    public static void b(long j11, com.google.android.exoplayer2.util.c0 c0Var, e0[] e0VarArr) {
        int iD = c0Var.D();
        if ((iD & 64) != 0) {
            c0Var.Q(1);
            int i11 = (iD & 31) * 3;
            int iE = c0Var.e();
            for (e0 e0Var : e0VarArr) {
                c0Var.P(iE);
                e0Var.c(c0Var, i11);
                if (j11 != C.TIME_UNSET) {
                    e0Var.d(j11, 1, i11, 0, null);
                }
            }
        }
    }

    public static int c(com.google.android.exoplayer2.util.c0 c0Var) {
        int i11 = 0;
        while (c0Var.a() != 0) {
            int iD = c0Var.D();
            i11 += iD;
            if (iD != 255) {
                return i11;
            }
        }
        return -1;
    }
}
