package v4;

import android.net.Uri;
import androidx.media3.common.ParserException;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import u4.i;
import u4.l0;
import u4.m0;
import u4.r;
import u4.r0;
import u4.s;
import u4.t;
import u4.u;
import u4.x;
import u4.y;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements s {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f78732r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f78735u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f78736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f78738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f78739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f78740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f78741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f78742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f78743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f78744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f78745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f78746k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u f78747l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public r0 f78748m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m0 f78749n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f78750o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final y f78730p = new y() { // from class: v4.a
        @Override // u4.y
        public /* synthetic */ y a(o5.s.a aVar) {
            return x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ s[] b(Uri uri, Map map) {
            return x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ y c(boolean z11) {
            return x.b(this, z11);
        }

        @Override // u4.y
        public final s[] createExtractors() {
            return b.m();
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f78731q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte[] f78733s = u0.w0("#!AMR\n");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte[] f78734t = u0.w0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f78732r = iArr;
        f78735u = iArr[8];
    }

    public b() {
        this(0);
    }

    public b(int i11) {
        this.f78737b = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f78736a = new byte[1];
        this.f78744i = -1;
    }

    public static int g(int i11, long j11) {
        return (int) ((((long) i11) * 8000000) / j11);
    }

    public static /* synthetic */ s[] m() {
        return new s[]{new b()};
    }

    public static boolean p(t tVar, byte[] bArr) throws IOException {
        tVar.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        tVar.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        return r(tVar);
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        e();
        if (tVar.getPosition() == 0 && !r(tVar)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
        }
        n();
        int iS = s(tVar);
        o(tVar.getLength(), iS);
        return iS;
    }

    public final void e() {
        z3.a.i(this.f78748m);
        u0.i(this.f78747l);
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f78747l = uVar;
        this.f78748m = uVar.track(0, 1);
        uVar.endTracks();
    }

    public final m0 h(long j11, boolean z11) {
        return new i(j11, this.f78743h, g(this.f78744i, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT), this.f78744i, z11);
    }

    public final int i(int i11) throws ParserException {
        if (k(i11)) {
            return this.f78738c ? f78732r[i11] : f78731q[i11];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal AMR ");
        sb2.append(this.f78738c ? "WB" : "NB");
        sb2.append(" frame type ");
        sb2.append(i11);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    public final boolean j(int i11) {
        return !this.f78738c && (i11 < 12 || i11 > 14);
    }

    public final boolean k(int i11) {
        return i11 >= 0 && i11 <= 15 && (l(i11) || j(i11));
    }

    public final boolean l(int i11) {
        return this.f78738c && (i11 < 10 || i11 > 13);
    }

    public final void n() {
        if (this.f78750o) {
            return;
        }
        this.f78750o = true;
        boolean z11 = this.f78738c;
        this.f78748m.b(new androidx.media3.common.y.b().k0(z11 ? MimeTypes.AUDIO_AMR_WB : MimeTypes.AUDIO_AMR_NB).c0(f78735u).L(1).l0(z11 ? 16000 : 8000).I());
    }

    public final void o(long j11, int i11) {
        int i12;
        if (this.f78742g) {
            return;
        }
        int i13 = this.f78737b;
        if ((i13 & 1) == 0 || j11 == -1 || !((i12 = this.f78744i) == -1 || i12 == this.f78740e)) {
            m0.b bVar = new m0.b(C.TIME_UNSET);
            this.f78749n = bVar;
            this.f78747l.f(bVar);
            this.f78742g = true;
            return;
        }
        if (this.f78745j >= 20 || i11 == -1) {
            m0 m0VarH = h(j11, (i13 & 2) != 0);
            this.f78749n = m0VarH;
            this.f78747l.f(m0VarH);
            this.f78742g = true;
        }
    }

    public final int q(t tVar) throws IOException {
        tVar.resetPeekPosition();
        tVar.peekFully(this.f78736a, 0, 1);
        byte b11 = this.f78736a[0];
        if ((b11 & 131) <= 0) {
            return i((b11 >> 3) & 15);
        }
        throw ParserException.createForMalformedContainer("Invalid padding bits for frame header " + ((int) b11), null);
    }

    public final boolean r(t tVar) throws IOException {
        byte[] bArr = f78733s;
        if (p(tVar, bArr)) {
            this.f78738c = false;
            tVar.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = f78734t;
        if (!p(tVar, bArr2)) {
            return false;
        }
        this.f78738c = true;
        tVar.skipFully(bArr2.length);
        return true;
    }

    @Override // u4.s
    public void release() {
    }

    public final int s(t tVar) throws IOException {
        if (this.f78741f == 0) {
            try {
                int iQ = q(tVar);
                this.f78740e = iQ;
                this.f78741f = iQ;
                if (this.f78744i == -1) {
                    this.f78743h = tVar.getPosition();
                    this.f78744i = this.f78740e;
                }
                if (this.f78744i == this.f78740e) {
                    this.f78745j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iD = this.f78748m.d(tVar, this.f78741f, true);
        if (iD == -1) {
            return -1;
        }
        int i11 = this.f78741f - iD;
        this.f78741f = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f78748m.f(this.f78746k + this.f78739d, 1, this.f78740e, 0, null);
        this.f78739d += DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        return 0;
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f78739d = 0L;
        this.f78740e = 0;
        this.f78741f = 0;
        if (j11 != 0) {
            m0 m0Var = this.f78749n;
            if (m0Var instanceof i) {
                this.f78746k = ((i) m0Var).c(j11);
                return;
            }
        }
        this.f78746k = 0L;
    }
}
