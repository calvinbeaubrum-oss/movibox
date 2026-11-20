package u4;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f78379a = new byte[4096];

    @Override // u4.r0
    public void a(z3.c0 c0Var, int i11, int i12) {
        c0Var.V(i11);
    }

    @Override // u4.r0
    public void b(androidx.media3.common.y yVar) {
    }

    @Override // u4.r0
    public /* synthetic */ void c(z3.c0 c0Var, int i11) {
        q0.b(this, c0Var, i11);
    }

    @Override // u4.r0
    public /* synthetic */ int d(androidx.media3.common.l lVar, int i11, boolean z11) {
        return q0.a(this, lVar, i11, z11);
    }

    @Override // u4.r0
    public int e(androidx.media3.common.l lVar, int i11, boolean z11, int i12) throws IOException {
        int i13 = lVar.read(this.f78379a, 0, Math.min(this.f78379a.length, i11));
        if (i13 != -1) {
            return i13;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // u4.r0
    public void f(long j11, int i11, int i12, int i13, @Nullable r0.a aVar) {
    }
}
