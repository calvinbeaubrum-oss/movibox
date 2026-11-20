package com.google.android.exoplayer2.source.rtsp;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l0 implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34561a;

    public l0(long j11) {
        this.f34561a = j11;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c.a
    public c a(int i11) throws IOException {
        k0 k0Var = new k0(this.f34561a);
        k0 k0Var2 = new k0(this.f34561a);
        try {
            k0Var.a(k.a(0));
            int iD = k0Var.d();
            boolean z11 = iD % 2 == 0;
            k0Var2.a(k.a(z11 ? iD + 1 : iD - 1));
            if (z11) {
                k0Var.f(k0Var2);
                return k0Var;
            }
            k0Var2.f(k0Var);
            return k0Var2;
        } catch (IOException e11) {
            com.google.android.exoplayer2.upstream.m.a(k0Var);
            com.google.android.exoplayer2.upstream.m.a(k0Var2);
            throw e11;
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c.a
    public c.a b() {
        return new j0(this.f34561a);
    }
}
