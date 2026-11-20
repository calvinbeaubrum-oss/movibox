package vg;

import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f78794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f78797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f78798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f78799f;

    public d(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f78794a = i11;
        this.f78795b = i12;
        this.f78796c = i13;
        this.f78797d = i14;
        this.f78798e = i15;
        this.f78799f = i16;
    }

    public static d c(c0 c0Var) {
        int iQ = c0Var.q();
        c0Var.Q(12);
        int iQ2 = c0Var.q();
        int iQ3 = c0Var.q();
        int iQ4 = c0Var.q();
        c0Var.Q(4);
        int iQ5 = c0Var.q();
        int iQ6 = c0Var.q();
        c0Var.Q(8);
        return new d(iQ, iQ2, iQ3, iQ4, iQ5, iQ6);
    }

    public long a() {
        return o0.O0(this.f78798e, ((long) this.f78796c) * 1000000, this.f78797d);
    }

    public int b() {
        int i11 = this.f78794a;
        if (i11 == 1935960438) {
            return 2;
        }
        if (i11 == 1935963489) {
            return 1;
        }
        if (i11 == 1937012852) {
            return 3;
        }
        s.i("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f78794a));
        return -1;
    }

    @Override // vg.a
    public int getType() {
        return 1752331379;
    }
}
