package vg;

import com.google.android.exoplayer2.util.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f78790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f78793d;

    public c(int i11, int i12, int i13, int i14) {
        this.f78790a = i11;
        this.f78791b = i12;
        this.f78792c = i13;
        this.f78793d = i14;
    }

    public static c b(c0 c0Var) {
        int iQ = c0Var.q();
        c0Var.Q(8);
        int iQ2 = c0Var.q();
        int iQ3 = c0Var.q();
        c0Var.Q(4);
        int iQ4 = c0Var.q();
        c0Var.Q(12);
        return new c(iQ, iQ2, iQ3, iQ4);
    }

    public boolean a() {
        return (this.f78791b & 16) == 16;
    }

    @Override // vg.a
    public int getType() {
        return 1751742049;
    }
}
