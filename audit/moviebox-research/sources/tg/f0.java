package tg;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f77022a = new byte[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f77023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f77024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f77025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f77027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77028g;

    public void a(e0 e0Var, @Nullable e0.a aVar) {
        if (this.f77024c > 0) {
            e0Var.d(this.f77025d, this.f77026e, this.f77027f, this.f77028g, aVar);
            this.f77024c = 0;
        }
    }

    public void b() {
        this.f77023b = false;
        this.f77024c = 0;
    }

    public void c(e0 e0Var, long j11, int i11, int i12, int i13, @Nullable e0.a aVar) {
        com.google.android.exoplayer2.util.a.h(this.f77028g <= i12 + i13, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f77023b) {
            int i14 = this.f77024c;
            int i15 = i14 + 1;
            this.f77024c = i15;
            if (i14 == 0) {
                this.f77025d = j11;
                this.f77026e = i11;
                this.f77027f = 0;
            }
            this.f77027f += i12;
            this.f77028g = i13;
            if (i15 >= 16) {
                a(e0Var, aVar);
            }
        }
    }

    public void d(m mVar) throws IOException {
        if (this.f77023b) {
            return;
        }
        mVar.peekFully(this.f77022a, 0, 10);
        mVar.resetPeekPosition();
        if (com.google.android.exoplayer2.audio.b.i(this.f77022a) == 0) {
            return;
        }
        this.f77023b = true;
    }
}
