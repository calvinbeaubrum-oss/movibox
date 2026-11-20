package p4;

import androidx.media3.common.m0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.media3.common.b0 f73567g;

    public i0(m0 m0Var, androidx.media3.common.b0 b0Var) {
        super(m0Var);
        this.f73567g = b0Var;
    }

    @Override // p4.m, androidx.media3.common.m0
    public m0.c o(int i11, m0.c cVar, long j11) {
        super.o(i11, cVar, j11);
        androidx.media3.common.b0 b0Var = this.f73567g;
        cVar.f9311c = b0Var;
        androidx.media3.common.b0.h hVar = b0Var.f8951b;
        cVar.f9310b = hVar != null ? hVar.f9054h : null;
        return cVar;
    }
}
