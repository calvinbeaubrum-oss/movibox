package ug;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import tg.a0;
import tg.b0;
import tg.e;
import tg.e0;
import tg.l;
import tg.m;
import tg.n;
import tg.q;
import tg.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements l {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f78539r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f78542u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f78543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f78545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f78546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f78547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f78548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f78549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f78550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f78551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f78552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f78553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n f78554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e0 f78555m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b0 f78556n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f78557o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final r f78537p = new r() { // from class: ug.a
        @Override // tg.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // tg.r
        public final l[] createExtractors() {
            return b.l();
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f78538q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte[] f78540s = o0.n0("#!AMR\n");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte[] f78541t = o0.n0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f78539r = iArr;
        f78542u = iArr[8];
    }

    public b() {
        this(0);
    }

    public b(int i11) {
        this.f78544b = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f78543a = new byte[1];
        this.f78551i = -1;
    }

    public static int f(int i11, long j11) {
        return (int) ((((long) i11) * 8000000) / j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] l() {
        return new l[]{new b()};
    }

    public static boolean o(m mVar, byte[] bArr) throws IOException {
        mVar.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        mVar.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // tg.l
    public boolean b(m mVar) throws IOException {
        return q(mVar);
    }

    @Override // tg.l
    public int c(m mVar, a0 a0Var) throws IOException {
        e();
        if (mVar.getPosition() == 0 && !q(mVar)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
        }
        m();
        int iR = r(mVar);
        n(mVar.getLength(), iR);
        return iR;
    }

    @Override // tg.l
    public void d(n nVar) {
        this.f78554l = nVar;
        this.f78555m = nVar.track(0, 1);
        nVar.endTracks();
    }

    public final void e() {
        com.google.android.exoplayer2.util.a.i(this.f78555m);
        o0.j(this.f78554l);
    }

    public final b0 g(long j11, boolean z11) {
        return new e(j11, this.f78550h, f(this.f78551i, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT), this.f78551i, z11);
    }

    public final int h(int i11) throws ParserException {
        if (j(i11)) {
            return this.f78545c ? f78539r[i11] : f78538q[i11];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal AMR ");
        sb2.append(this.f78545c ? "WB" : "NB");
        sb2.append(" frame type ");
        sb2.append(i11);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    public final boolean i(int i11) {
        return !this.f78545c && (i11 < 12 || i11 > 14);
    }

    public final boolean j(int i11) {
        return i11 >= 0 && i11 <= 15 && (k(i11) || i(i11));
    }

    public final boolean k(int i11) {
        return this.f78545c && (i11 < 10 || i11 > 13);
    }

    public final void m() {
        if (this.f78557o) {
            return;
        }
        this.f78557o = true;
        boolean z11 = this.f78545c;
        this.f78555m.e(new m1.b().e0(z11 ? MimeTypes.AUDIO_AMR_WB : MimeTypes.AUDIO_AMR_NB).W(f78542u).H(1).f0(z11 ? 16000 : 8000).E());
    }

    public final void n(long j11, int i11) {
        int i12;
        if (this.f78549g) {
            return;
        }
        int i13 = this.f78544b;
        if ((i13 & 1) == 0 || j11 == -1 || !((i12 = this.f78551i) == -1 || i12 == this.f78547e)) {
            b0.b bVar = new b0.b(C.TIME_UNSET);
            this.f78556n = bVar;
            this.f78554l.g(bVar);
            this.f78549g = true;
            return;
        }
        if (this.f78552j >= 20 || i11 == -1) {
            b0 b0VarG = g(j11, (i13 & 2) != 0);
            this.f78556n = b0VarG;
            this.f78554l.g(b0VarG);
            this.f78549g = true;
        }
    }

    public final int p(m mVar) throws IOException {
        mVar.resetPeekPosition();
        mVar.peekFully(this.f78543a, 0, 1);
        byte b11 = this.f78543a[0];
        if ((b11 & 131) <= 0) {
            return h((b11 >> 3) & 15);
        }
        throw ParserException.createForMalformedContainer("Invalid padding bits for frame header " + ((int) b11), null);
    }

    public final boolean q(m mVar) throws IOException {
        byte[] bArr = f78540s;
        if (o(mVar, bArr)) {
            this.f78545c = false;
            mVar.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = f78541t;
        if (!o(mVar, bArr2)) {
            return false;
        }
        this.f78545c = true;
        mVar.skipFully(bArr2.length);
        return true;
    }

    public final int r(m mVar) throws IOException {
        if (this.f78548f == 0) {
            try {
                int iP = p(mVar);
                this.f78547e = iP;
                this.f78548f = iP;
                if (this.f78551i == -1) {
                    this.f78550h = mVar.getPosition();
                    this.f78551i = this.f78547e;
                }
                if (this.f78551i == this.f78547e) {
                    this.f78552j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iB = this.f78555m.b(mVar, this.f78548f, true);
        if (iB == -1) {
            return -1;
        }
        int i11 = this.f78548f - iB;
        this.f78548f = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f78555m.d(this.f78553k + this.f78546d, 1, this.f78547e, 0, null);
        this.f78546d += DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        return 0;
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        this.f78546d = 0L;
        this.f78547e = 0;
        this.f78548f = 0;
        if (j11 != 0) {
            b0 b0Var = this.f78556n;
            if (b0Var instanceof e) {
                this.f78553k = ((e) b0Var).c(j11);
                return;
            }
        }
        this.f78553k = 0L;
    }
}
