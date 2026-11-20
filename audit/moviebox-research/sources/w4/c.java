package w4;

import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f79263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79265d;

    public c(int i11, int i12, int i13, int i14) {
        this.f79262a = i11;
        this.f79263b = i12;
        this.f79264c = i13;
        this.f79265d = i14;
    }

    public static c b(c0 c0Var) {
        int iU = c0Var.u();
        c0Var.V(8);
        int iU2 = c0Var.u();
        int iU3 = c0Var.u();
        c0Var.V(4);
        int iU4 = c0Var.u();
        c0Var.V(12);
        return new c(iU, iU2, iU3, iU4);
    }

    public boolean a() {
        return (this.f79263b & 16) == 16;
    }

    @Override // w4.a
    public int getType() {
        return 1751742049;
    }
}
