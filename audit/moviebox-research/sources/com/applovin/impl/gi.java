package com.applovin.impl;

import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class gi extends i2 {

    /* JADX INFO: compiled from: source.java */
    public static final class b implements i2.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ho f19230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final bh f19231b;

        private b(ho hoVar) {
            this.f19230a = hoVar;
            this.f19231b = new bh();
        }

        private i2.e a(bh bhVar, long j11, long j12) {
            int iD = -1;
            long j13 = -9223372036854775807L;
            int iD2 = -1;
            while (bhVar.a() >= 4) {
                if (gi.b(bhVar.c(), bhVar.d()) != 442) {
                    bhVar.g(1);
                } else {
                    bhVar.g(4);
                    long jC = hi.c(bhVar);
                    if (jC != C.TIME_UNSET) {
                        long jB = this.f19230a.b(jC);
                        if (jB > j11) {
                            return j13 == C.TIME_UNSET ? i2.e.a(jB, j12) : i2.e.a(j12 + ((long) iD2));
                        }
                        if (100000 + jB > j11) {
                            return i2.e.a(j12 + ((long) bhVar.d()));
                        }
                        iD2 = bhVar.d();
                        j13 = jB;
                    }
                    a(bhVar);
                    iD = bhVar.d();
                }
            }
            return j13 != C.TIME_UNSET ? i2.e.b(j13, j12 + ((long) iD)) : i2.e.f19610d;
        }

        private static void a(bh bhVar) {
            int iB;
            int iE = bhVar.e();
            if (bhVar.a() < 10) {
                bhVar.f(iE);
                return;
            }
            bhVar.g(9);
            int iW = bhVar.w() & 7;
            if (bhVar.a() < iW) {
                bhVar.f(iE);
                return;
            }
            bhVar.g(iW);
            if (bhVar.a() < 4) {
                bhVar.f(iE);
                return;
            }
            if (gi.b(bhVar.c(), bhVar.d()) == 443) {
                bhVar.g(4);
                int iC = bhVar.C();
                if (bhVar.a() < iC) {
                    bhVar.f(iE);
                    return;
                }
                bhVar.g(iC);
            }
            while (bhVar.a() >= 4 && (iB = gi.b(bhVar.c(), bhVar.d())) != 442 && iB != 441 && (iB >>> 8) == 1) {
                bhVar.g(4);
                if (bhVar.a() < 2) {
                    bhVar.f(iE);
                    return;
                }
                bhVar.f(Math.min(bhVar.e(), bhVar.d() + bhVar.C()));
            }
        }

        @Override // com.applovin.impl.i2.f
        public i2.e a(l8 l8Var, long j11) {
            long jF = l8Var.f();
            int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, l8Var.a() - jF);
            this.f19231b.d(iMin);
            l8Var.c(this.f19231b.c(), 0, iMin);
            return a(this.f19231b, j11, jF);
        }

        @Override // com.applovin.impl.i2.f
        public void a() {
            this.f19231b.a(xp.f24377f);
        }
    }

    public gi(ho hoVar, long j11, long j12) {
        super(new i2.b(), new b(hoVar), j11, 0L, j11 + 1, 0L, j12, 188L, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }
}
