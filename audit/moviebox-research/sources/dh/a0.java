package dh;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a0 implements tg.l {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final tg.r f63050l = new tg.r() { // from class: dh.z
        @Override // tg.r
        public /* synthetic */ tg.l[] b(Uri uri, Map map) {
            return tg.q.a(this, uri, map);
        }

        @Override // tg.r
        public final tg.l[] createExtractors() {
            return a0.e();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.k0 f63051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a> f63052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f63054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f63055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f63056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f63057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f63058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public x f63059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public tg.n f63060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f63061k;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f63062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.k0 f63063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.b0 f63064c = new com.google.android.exoplayer2.util.b0(new byte[64]);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f63065d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f63066e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f63067f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f63068g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f63069h;

        public a(m mVar, com.google.android.exoplayer2.util.k0 k0Var) {
            this.f63062a = mVar;
            this.f63063b = k0Var;
        }

        public void a(com.google.android.exoplayer2.util.c0 c0Var) throws ParserException {
            c0Var.j(this.f63064c.f35543a, 0, 3);
            this.f63064c.p(0);
            b();
            c0Var.j(this.f63064c.f35543a, 0, this.f63068g);
            this.f63064c.p(0);
            c();
            this.f63062a.c(this.f63069h, 4);
            this.f63062a.b(c0Var);
            this.f63062a.packetFinished();
        }

        public final void b() {
            this.f63064c.r(8);
            this.f63065d = this.f63064c.g();
            this.f63066e = this.f63064c.g();
            this.f63064c.r(6);
            this.f63068g = this.f63064c.h(8);
        }

        public final void c() {
            this.f63069h = 0L;
            if (this.f63065d) {
                this.f63064c.r(4);
                long jH = ((long) this.f63064c.h(3)) << 30;
                this.f63064c.r(1);
                long jH2 = jH | ((long) (this.f63064c.h(15) << 15));
                this.f63064c.r(1);
                long jH3 = jH2 | ((long) this.f63064c.h(15));
                this.f63064c.r(1);
                if (!this.f63067f && this.f63066e) {
                    this.f63064c.r(4);
                    long jH4 = ((long) this.f63064c.h(3)) << 30;
                    this.f63064c.r(1);
                    long jH5 = jH4 | ((long) (this.f63064c.h(15) << 15));
                    this.f63064c.r(1);
                    long jH6 = jH5 | ((long) this.f63064c.h(15));
                    this.f63064c.r(1);
                    this.f63063b.b(jH6);
                    this.f63067f = true;
                }
                this.f63069h = this.f63063b.b(jH3);
            }
        }

        public void d() {
            this.f63067f = false;
            this.f63062a.seek();
        }
    }

    public a0() {
        this(new com.google.android.exoplayer2.util.k0(0L));
    }

    public a0(com.google.android.exoplayer2.util.k0 k0Var) {
        this.f63051a = k0Var;
        this.f63053c = new com.google.android.exoplayer2.util.c0(4096);
        this.f63052b = new SparseArray<>();
        this.f63054d = new y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ tg.l[] e() {
        return new tg.l[]{new a0()};
    }

    @Override // tg.l
    public boolean b(tg.m mVar) throws IOException {
        byte[] bArr = new byte[14];
        mVar.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        mVar.advancePeekPosition(bArr[13] & 7);
        mVar.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // tg.l
    public int c(tg.m mVar, tg.a0 a0Var) throws IOException {
        m nVar;
        com.google.android.exoplayer2.util.a.i(this.f63060j);
        long length = mVar.getLength();
        if (length != -1 && !this.f63054d.e()) {
            return this.f63054d.g(mVar, a0Var);
        }
        f(length);
        x xVar = this.f63059i;
        if (xVar != null && xVar.d()) {
            return this.f63059i.c(mVar, a0Var);
        }
        mVar.resetPeekPosition();
        long peekPosition = length != -1 ? length - mVar.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !mVar.peekFully(this.f63053c.d(), 0, 4, true)) {
            return -1;
        }
        this.f63053c.P(0);
        int iN = this.f63053c.n();
        if (iN == 441) {
            return -1;
        }
        if (iN == 442) {
            mVar.peekFully(this.f63053c.d(), 0, 10);
            this.f63053c.P(9);
            mVar.skipFully((this.f63053c.D() & 7) + 14);
            return 0;
        }
        if (iN == 443) {
            mVar.peekFully(this.f63053c.d(), 0, 2);
            this.f63053c.P(0);
            mVar.skipFully(this.f63053c.J() + 6);
            return 0;
        }
        if (((iN & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            mVar.skipFully(1);
            return 0;
        }
        int i11 = iN & 255;
        a aVar = this.f63052b.get(i11);
        if (!this.f63055e) {
            if (aVar == null) {
                if (i11 == 189) {
                    nVar = new c();
                    this.f63056f = true;
                    this.f63058h = mVar.getPosition();
                } else if ((iN & 224) == 192) {
                    nVar = new t();
                    this.f63056f = true;
                    this.f63058h = mVar.getPosition();
                } else if ((iN & 240) == 224) {
                    nVar = new n();
                    this.f63057g = true;
                    this.f63058h = mVar.getPosition();
                } else {
                    nVar = null;
                }
                if (nVar != null) {
                    nVar.d(this.f63060j, new i0.d(i11, 256));
                    aVar = new a(nVar, this.f63051a);
                    this.f63052b.put(i11, aVar);
                }
            }
            if (mVar.getPosition() > ((this.f63056f && this.f63057g) ? this.f63058h + PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                this.f63055e = true;
                this.f63060j.endTracks();
            }
        }
        mVar.peekFully(this.f63053c.d(), 0, 2);
        this.f63053c.P(0);
        int iJ = this.f63053c.J() + 6;
        if (aVar == null) {
            mVar.skipFully(iJ);
        } else {
            this.f63053c.L(iJ);
            mVar.readFully(this.f63053c.d(), 0, iJ);
            this.f63053c.P(6);
            aVar.a(this.f63053c);
            com.google.android.exoplayer2.util.c0 c0Var = this.f63053c;
            c0Var.O(c0Var.b());
        }
        return 0;
    }

    @Override // tg.l
    public void d(tg.n nVar) {
        this.f63060j = nVar;
    }

    public final void f(long j11) {
        if (this.f63061k) {
            return;
        }
        this.f63061k = true;
        if (this.f63054d.c() == C.TIME_UNSET) {
            this.f63060j.g(new tg.b0.b(this.f63054d.c()));
            return;
        }
        x xVar = new x(this.f63054d.d(), this.f63054d.c(), j11);
        this.f63059i = xVar;
        this.f63060j.g(xVar.b());
    }

    @Override // tg.l
    public void release() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    @Override // tg.l
    public void seek(long j11, long j12) {
        boolean z11 = this.f63051a.e() == C.TIME_UNSET;
        if (!z11) {
            long jC = this.f63051a.c();
            if (jC != C.TIME_UNSET && jC != 0 && jC != j12) {
                this.f63051a.g(j12);
            }
        } else if (z11) {
            this.f63051a.g(j12);
        }
        x xVar = this.f63059i;
        if (xVar != null) {
            xVar.h(j12);
        }
        for (int i11 = 0; i11 < this.f63052b.size(); i11++) {
            this.f63052b.valueAt(i11).d();
        }
    }
}
