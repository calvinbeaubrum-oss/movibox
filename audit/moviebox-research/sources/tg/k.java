package tg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f77073a = new byte[4096];

    @Override // tg.e0
    public int a(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11, int i12) throws IOException {
        int i13 = gVar.read(this.f77073a, 0, Math.min(this.f77073a.length, i11));
        if (i13 != -1) {
            return i13;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // tg.e0
    public /* synthetic */ int b(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11) {
        return d0.a(this, gVar, i11, z11);
    }

    @Override // tg.e0
    public /* synthetic */ void c(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
        d0.b(this, c0Var, i11);
    }

    @Override // tg.e0
    public void d(long j11, int i11, int i12, int i13, @Nullable e0.a aVar) {
    }

    @Override // tg.e0
    public void e(m1 m1Var) {
    }

    @Override // tg.e0
    public void f(com.google.android.exoplayer2.util.c0 c0Var, int i11, int i12) {
        c0Var.Q(i11);
    }
}
