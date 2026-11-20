package u4;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f78384a = new byte[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f78385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f78386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f78387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f78388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f78389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f78390g;

    public void a(r0 r0Var, @Nullable r0.a aVar) {
        if (this.f78386c > 0) {
            r0Var.f(this.f78387d, this.f78388e, this.f78389f, this.f78390g, aVar);
            this.f78386c = 0;
        }
    }

    public void b() {
        this.f78385b = false;
        this.f78386c = 0;
    }

    public void c(r0 r0Var, long j11, int i11, int i12, int i13, @Nullable r0.a aVar) {
        z3.a.h(this.f78390g <= i12 + i13, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f78385b) {
            int i14 = this.f78386c;
            int i15 = i14 + 1;
            this.f78386c = i15;
            if (i14 == 0) {
                this.f78387d = j11;
                this.f78388e = i11;
                this.f78389f = 0;
            }
            this.f78389f += i12;
            this.f78390g = i13;
            if (i15 >= 16) {
                a(r0Var, aVar);
            }
        }
    }

    public void d(t tVar) throws IOException {
        if (this.f78385b) {
            return;
        }
        tVar.peekFully(this.f78384a, 0, 10);
        tVar.resetPeekPosition();
        if (b.j(this.f78384a) == 0) {
            return;
        }
        this.f78385b = true;
    }
}
