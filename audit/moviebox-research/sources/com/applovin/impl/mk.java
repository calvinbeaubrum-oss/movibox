package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f21174a = new bh(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21175b;

    private long a(l8 l8Var) {
        int i11 = 0;
        l8Var.c(this.f21174a.c(), 0, 1);
        int i12 = this.f21174a.c()[0] & 255;
        if (i12 == 0) {
            return Long.MIN_VALUE;
        }
        int i13 = 128;
        int i14 = 0;
        while ((i12 & i13) == 0) {
            i13 >>= 1;
            i14++;
        }
        int i15 = i12 & (~i13);
        l8Var.c(this.f21174a.c(), 1, i14);
        while (i11 < i14) {
            i11++;
            i15 = (this.f21174a.c()[i11] & 255) + (i15 << 8);
        }
        this.f21175b += i14 + 1;
        return i15;
    }

    public boolean b(l8 l8Var) {
        long jA = l8Var.a();
        long j11 = 1024;
        if (jA != -1 && jA <= 1024) {
            j11 = jA;
        }
        int i11 = (int) j11;
        l8Var.c(this.f21174a.c(), 0, 4);
        long jY = this.f21174a.y();
        this.f21175b = 4;
        while (jY != 440786851) {
            int i12 = this.f21175b + 1;
            this.f21175b = i12;
            if (i12 == i11) {
                return false;
            }
            l8Var.c(this.f21174a.c(), 0, 1);
            jY = ((jY << 8) & (-256)) | ((long) (this.f21174a.c()[0] & 255));
        }
        long jA2 = a(l8Var);
        long j12 = this.f21175b;
        if (jA2 == Long.MIN_VALUE) {
            return false;
        }
        if (jA != -1 && j12 + jA2 >= jA) {
            return false;
        }
        while (true) {
            long j13 = this.f21175b;
            long j14 = j12 + jA2;
            if (j13 >= j14) {
                return j13 == j14;
            }
            if (a(l8Var) == Long.MIN_VALUE) {
                return false;
            }
            long jA3 = a(l8Var);
            if (jA3 < 0 || jA3 > 2147483647L) {
                return false;
            }
            if (jA3 != 0) {
                int i13 = (int) jA3;
                l8Var.c(i13);
                this.f21175b += i13;
            }
        }
    }
}
