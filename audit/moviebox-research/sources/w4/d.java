package w4;

import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f79267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f79270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f79271f;

    public d(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f79266a = i11;
        this.f79267b = i12;
        this.f79268c = i13;
        this.f79269d = i14;
        this.f79270e = i15;
        this.f79271f = i16;
    }

    public static d c(c0 c0Var) {
        int iU = c0Var.u();
        c0Var.V(12);
        int iU2 = c0Var.u();
        int iU3 = c0Var.u();
        int iU4 = c0Var.u();
        c0Var.V(4);
        int iU5 = c0Var.u();
        int iU6 = c0Var.u();
        c0Var.V(8);
        return new d(iU, iU2, iU3, iU4, iU5, iU6);
    }

    public long a() {
        return u0.f1(this.f79270e, ((long) this.f79268c) * 1000000, this.f79269d);
    }

    public int b() {
        int i11 = this.f79266a;
        if (i11 == 1935960438) {
            return 2;
        }
        if (i11 == 1935963489) {
            return 1;
        }
        if (i11 == 1937012852) {
            return 3;
        }
        o.h("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f79266a));
        return -1;
    }

    @Override // w4.a
    public int getType() {
        return 1752331379;
    }
}
