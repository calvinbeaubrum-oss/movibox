package com.applovin.impl;

import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class hi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19491e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ho f19487a = new ho(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f19492f = C.TIME_UNSET;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f19493g = C.TIME_UNSET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f19494h = C.TIME_UNSET;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f19488b = new bh();

    private int a(l8 l8Var) {
        this.f19488b.a(xp.f24377f);
        this.f19489c = true;
        l8Var.b();
        return 0;
    }

    private int a(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    private long a(bh bhVar) {
        int iE = bhVar.e();
        for (int iD = bhVar.d(); iD < iE - 3; iD++) {
            if (a(bhVar.c(), iD) == 442) {
                bhVar.f(iD + 4);
                long jC = c(bhVar);
                if (jC != C.TIME_UNSET) {
                    return jC;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(l8 l8Var, th thVar) {
        int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, l8Var.a());
        long j11 = 0;
        if (l8Var.f() != j11) {
            thVar.f23379a = j11;
            return 1;
        }
        this.f19488b.d(iMin);
        l8Var.b();
        l8Var.c(this.f19488b.c(), 0, iMin);
        this.f19492f = a(this.f19488b);
        this.f19490d = true;
        return 0;
    }

    private long b(bh bhVar) {
        int iD = bhVar.d();
        for (int iE = bhVar.e() - 4; iE >= iD; iE--) {
            if (a(bhVar.c(), iE) == 442) {
                bhVar.f(iE + 4);
                long jC = c(bhVar);
                if (jC != C.TIME_UNSET) {
                    return jC;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private static long b(byte[] bArr) {
        long j11 = bArr[0];
        long j12 = ((j11 & 3) << 28) | (((56 & j11) >> 3) << 30) | ((((long) bArr[1]) & 255) << 20);
        long j13 = bArr[2];
        return j12 | (((j13 & 248) >> 3) << 15) | ((j13 & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    private int c(l8 l8Var, th thVar) {
        long jA = l8Var.a();
        int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, jA);
        long j11 = jA - ((long) iMin);
        if (l8Var.f() != j11) {
            thVar.f23379a = j11;
            return 1;
        }
        this.f19488b.d(iMin);
        l8Var.b();
        l8Var.c(this.f19488b.c(), 0, iMin);
        this.f19493g = b(this.f19488b);
        this.f19491e = true;
        return 0;
    }

    public static long c(bh bhVar) {
        int iD = bhVar.d();
        if (bhVar.a() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        bhVar.a(bArr, 0, 9);
        bhVar.f(iD);
        return !a(bArr) ? C.TIME_UNSET : b(bArr);
    }

    public int a(l8 l8Var, th thVar) {
        if (!this.f19491e) {
            return c(l8Var, thVar);
        }
        if (this.f19493g == C.TIME_UNSET) {
            return a(l8Var);
        }
        if (!this.f19490d) {
            return b(l8Var, thVar);
        }
        long j11 = this.f19492f;
        if (j11 == C.TIME_UNSET) {
            return a(l8Var);
        }
        long jB = this.f19487a.b(this.f19493g) - this.f19487a.b(j11);
        this.f19494h = jB;
        if (jB < 0) {
            pc.d("PsDurationReader", "Invalid duration: " + this.f19494h + ". Using TIME_UNSET instead.");
            this.f19494h = C.TIME_UNSET;
        }
        return a(l8Var);
    }

    public long a() {
        return this.f19494h;
    }

    public ho b() {
        return this.f19487a;
    }

    public boolean c() {
        return this.f19489c;
    }
}
