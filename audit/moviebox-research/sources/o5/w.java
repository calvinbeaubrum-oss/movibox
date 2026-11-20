package o5;

import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import u4.q0;
import u4.r0;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f72365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s.a f72366b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public s f72372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y f72373i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f72367c = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f72369e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f72370f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f72371g = u0.f81843f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f72368d = new c0();

    public w(r0 r0Var, s.a aVar) {
        this.f72365a = r0Var;
        this.f72366b = aVar;
    }

    @Override // u4.r0
    public void a(c0 c0Var, int i11, int i12) {
        if (this.f72372h == null) {
            this.f72365a.a(c0Var, i11, i12);
            return;
        }
        h(i11);
        c0Var.l(this.f72371g, this.f72370f, i11);
        this.f72370f += i11;
    }

    @Override // u4.r0
    public void b(y yVar) {
        z3.a.e(yVar.f9501m);
        z3.a.a(f0.k(yVar.f9501m) == 3);
        if (!yVar.equals(this.f72373i)) {
            this.f72373i = yVar;
            this.f72372h = this.f72366b.a(yVar) ? this.f72366b.c(yVar) : null;
        }
        if (this.f72372h == null) {
            this.f72365a.b(yVar);
        } else {
            this.f72365a.b(yVar.b().k0("application/x-media3-cues").M(yVar.f9501m).o0(Long.MAX_VALUE).Q(this.f72366b.b(yVar)).I());
        }
    }

    @Override // u4.r0
    public /* synthetic */ void c(c0 c0Var, int i11) {
        q0.b(this, c0Var, i11);
    }

    @Override // u4.r0
    public /* synthetic */ int d(androidx.media3.common.l lVar, int i11, boolean z11) {
        return q0.a(this, lVar, i11, z11);
    }

    @Override // u4.r0
    public int e(androidx.media3.common.l lVar, int i11, boolean z11, int i12) throws IOException {
        if (this.f72372h == null) {
            return this.f72365a.e(lVar, i11, z11, i12);
        }
        h(i11);
        int i13 = lVar.read(this.f72371g, this.f72370f, i11);
        if (i13 != -1) {
            this.f72370f += i13;
            return i13;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // u4.r0
    public void f(final long j11, final int i11, int i12, int i13, @Nullable r0.a aVar) {
        if (this.f72372h == null) {
            this.f72365a.f(j11, i11, i12, i13, aVar);
            return;
        }
        z3.a.b(aVar == null, "DRM on subtitles is not supported");
        int i14 = (this.f72370f - i13) - i12;
        this.f72372h.c(this.f72371g, i14, i12, s.b.b(), new z3.h() { // from class: o5.v
            @Override // z3.h
            public final void accept(Object obj) {
                this.f72362a.i(j11, i11, (e) obj);
            }
        });
        int i15 = i14 + i12;
        this.f72369e = i15;
        if (i15 == this.f72370f) {
            this.f72369e = 0;
            this.f72370f = 0;
        }
    }

    public final void h(int i11) {
        int length = this.f72371g.length;
        int i12 = this.f72370f;
        if (length - i12 >= i11) {
            return;
        }
        int i13 = i12 - this.f72369e;
        int iMax = Math.max(i13 * 2, i11 + i13);
        byte[] bArr = this.f72371g;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.f72369e, bArr2, 0, i13);
        this.f72369e = 0;
        this.f72370f = i13;
        this.f72371g = bArr2;
    }

    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void i(e eVar, long j11, int i11) {
        z3.a.i(this.f72373i);
        byte[] bArrA = this.f72367c.a(eVar.f72325a, eVar.f72327c);
        this.f72368d.R(bArrA);
        this.f72365a.c(this.f72368d, bArrA.length);
        int i12 = i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        long j12 = eVar.f72326b;
        if (j12 == C.TIME_UNSET) {
            z3.a.g(this.f72373i.f9505q == Long.MAX_VALUE);
        } else {
            long j13 = this.f72373i.f9505q;
            j11 = j13 == Long.MAX_VALUE ? j11 + j12 : j12 + j13;
        }
        this.f72365a.f(j11, i12, bArrA.length, 0, null);
    }

    public void k() {
        s sVar = this.f72372h;
        if (sVar != null) {
            sVar.reset();
        }
    }
}
