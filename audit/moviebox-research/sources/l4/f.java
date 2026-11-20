package l4;

import android.graphics.Bitmap;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.image.ImageDecoderException;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.source.l;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.x2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import z3.j0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends m {
    public int A;
    public int B;
    public y C;
    public c D;
    public DecoderInputBuffer E;
    public d F;
    public Bitmap G;
    public boolean H;
    public b I;
    public b J;
    public int K;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c.a f69783s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DecoderInputBuffer f69784t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayDeque<a> f69785u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f69786v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f69787w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f69788x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f69789y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f69790z;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f69791c = new a(C.TIME_UNSET, C.TIME_UNSET);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f69792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f69793b;

        public a(long j11, long j12) {
            this.f69792a = j11;
            this.f69793b = j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f69794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f69795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap f69796c;

        public b(int i11, long j11) {
            this.f69794a = i11;
            this.f69795b = j11;
        }

        public long a() {
            return this.f69795b;
        }

        public Bitmap b() {
            return this.f69796c;
        }

        public int c() {
            return this.f69794a;
        }

        public boolean d() {
            return this.f69796c != null;
        }

        public void e(Bitmap bitmap) {
            this.f69796c = bitmap;
        }
    }

    public f(c.a aVar, d dVar) {
        super(4);
        this.f69783s = aVar;
        this.F = R(dVar);
        this.f69784t = DecoderInputBuffer.e();
        this.f69788x = a.f69791c;
        this.f69785u = new ArrayDeque<>();
        this.f69790z = C.TIME_UNSET;
        this.f69789y = C.TIME_UNSET;
        this.A = 0;
        this.B = 1;
    }

    public static d R(d dVar) {
        return dVar == null ? d.f69781a : dVar;
    }

    private void W(long j11) {
        this.f69789y = j11;
        while (!this.f69785u.isEmpty() && j11 >= this.f69785u.peek().f69792a) {
            this.f69788x = this.f69785u.removeFirst();
        }
    }

    @Override // androidx.media3.exoplayer.m
    public void A(boolean z11, boolean z12) {
        this.B = z12 ? 1 : 0;
    }

    @Override // androidx.media3.exoplayer.m
    public void C(long j11, boolean z11) throws ExoPlaybackException {
        U(1);
        this.f69787w = false;
        this.f69786v = false;
        this.G = null;
        this.I = null;
        this.J = null;
        this.H = false;
        this.E = null;
        c cVar = this.D;
        if (cVar != null) {
            cVar.flush();
        }
        this.f69785u.clear();
    }

    @Override // androidx.media3.exoplayer.m
    public void D() {
        Y();
    }

    @Override // androidx.media3.exoplayer.m
    public void F() {
        Y();
        U(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r2 >= r5) goto L14;
     */
    @Override // androidx.media3.exoplayer.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I(y[] yVarArr, long j11, long j12, l.b bVar) throws ExoPlaybackException {
        super.I(yVarArr, j11, j12, bVar);
        if (this.f69788x.f69793b != C.TIME_UNSET) {
            if (this.f69785u.isEmpty()) {
                long j13 = this.f69790z;
                if (j13 != C.TIME_UNSET) {
                    long j14 = this.f69789y;
                    if (j14 != C.TIME_UNSET) {
                    }
                }
            }
            this.f69785u.add(new a(this.f69790z, j12));
            return;
        }
        this.f69788x = new a(C.TIME_UNSET, j12);
    }

    public final boolean N(y yVar) {
        int iA = this.f69783s.a(yVar);
        return iA == x2.a(4) || iA == x2.a(3);
    }

    public final Bitmap O(int i11) {
        z3.a.i(this.G);
        int width = this.G.getWidth() / ((y) z3.a.i(this.C)).G;
        int height = this.G.getHeight() / ((y) z3.a.i(this.C)).H;
        y yVar = this.C;
        return Bitmap.createBitmap(this.G, (i11 % yVar.H) * width, (i11 / yVar.G) * height, width, height);
    }

    public final boolean P(long j11, long j12) throws ExoPlaybackException, ImageDecoderException {
        if (this.G != null && this.I == null) {
            return false;
        }
        if (this.B == 0 && getState() != 2) {
            return false;
        }
        if (this.G == null) {
            z3.a.i(this.D);
            e eVarDequeueOutputBuffer = this.D.dequeueOutputBuffer();
            if (eVarDequeueOutputBuffer == null) {
                return false;
            }
            if (((e) z3.a.i(eVarDequeueOutputBuffer)).isEndOfStream()) {
                if (this.A == 3) {
                    Y();
                    z3.a.i(this.C);
                    S();
                } else {
                    ((e) z3.a.i(eVarDequeueOutputBuffer)).release();
                    if (this.f69785u.isEmpty()) {
                        this.f69787w = true;
                    }
                }
                return false;
            }
            z3.a.j(eVarDequeueOutputBuffer.f69782a, "Non-EOS buffer came back from the decoder without bitmap.");
            this.G = eVarDequeueOutputBuffer.f69782a;
            ((e) z3.a.i(eVarDequeueOutputBuffer)).release();
        }
        if (!this.H || this.G == null || this.I == null) {
            return false;
        }
        z3.a.i(this.C);
        y yVar = this.C;
        int i11 = yVar.G;
        boolean z11 = ((i11 == 1 && yVar.H == 1) || i11 == -1 || yVar.H == -1) ? false : true;
        if (!this.I.d()) {
            b bVar = this.I;
            bVar.e(z11 ? O(bVar.c()) : (Bitmap) z3.a.i(this.G));
        }
        if (!X(j11, j12, (Bitmap) z3.a.i(this.I.b()), this.I.a())) {
            return false;
        }
        W(((b) z3.a.i(this.I)).a());
        this.B = 3;
        if (!z11 || ((b) z3.a.i(this.I)).c() == (((y) z3.a.i(this.C)).H * ((y) z3.a.i(this.C)).G) - 1) {
            this.G = null;
        }
        this.I = this.J;
        this.J = null;
        return true;
    }

    public final boolean Q(long j11) throws DecoderException {
        if (this.H && this.I != null) {
            return false;
        }
        t1 t1VarT = t();
        c cVar = this.D;
        if (cVar == null || this.A == 3 || this.f69786v) {
            return false;
        }
        if (this.E == null) {
            DecoderInputBuffer decoderInputBufferDequeueInputBuffer = cVar.dequeueInputBuffer();
            this.E = decoderInputBufferDequeueInputBuffer;
            if (decoderInputBufferDequeueInputBuffer == null) {
                return false;
            }
        }
        if (this.A == 2) {
            z3.a.i(this.E);
            this.E.setFlags(4);
            ((c) z3.a.i(this.D)).b(this.E);
            this.E = null;
            this.A = 3;
            return false;
        }
        int iK = K(t1VarT, this.E, 0);
        if (iK == -5) {
            this.C = (y) z3.a.i(t1VarT.f11382b);
            this.A = 2;
            return true;
        }
        if (iK != -4) {
            if (iK == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        this.E.c();
        boolean z11 = ((ByteBuffer) z3.a.i(this.E.f9780c)).remaining() > 0 || ((DecoderInputBuffer) z3.a.i(this.E)).isEndOfStream();
        if (z11) {
            ((DecoderInputBuffer) z3.a.i(this.E)).clearFlag(Integer.MIN_VALUE);
            ((c) z3.a.i(this.D)).b((DecoderInputBuffer) z3.a.i(this.E));
            this.K = 0;
        }
        V(j11, (DecoderInputBuffer) z3.a.i(this.E));
        if (((DecoderInputBuffer) z3.a.i(this.E)).isEndOfStream()) {
            this.f69786v = true;
            this.E = null;
            return false;
        }
        this.f69790z = Math.max(this.f69790z, ((DecoderInputBuffer) z3.a.i(this.E)).f9782f);
        if (z11) {
            this.E = null;
        } else {
            ((DecoderInputBuffer) z3.a.i(this.E)).clear();
        }
        return !this.H;
    }

    public final void S() throws ExoPlaybackException {
        if (!N(this.C)) {
            throw p(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.C, 4005);
        }
        c cVar = this.D;
        if (cVar != null) {
            cVar.release();
        }
        this.D = this.f69783s.b();
    }

    public final boolean T(b bVar) {
        return ((y) z3.a.i(this.C)).G == -1 || this.C.H == -1 || bVar.c() == (((y) z3.a.i(this.C)).H * this.C.G) - 1;
    }

    public final void U(int i11) {
        this.B = Math.min(this.B, i11);
    }

    public final void V(long j11, DecoderInputBuffer decoderInputBuffer) {
        boolean z11 = true;
        if (decoderInputBuffer.isEndOfStream()) {
            this.H = true;
            return;
        }
        b bVar = new b(this.K, decoderInputBuffer.f9782f);
        this.J = bVar;
        this.K++;
        if (!this.H) {
            long jA = bVar.a();
            boolean z12 = jA - 30000 <= j11 && j11 <= 30000 + jA;
            b bVar2 = this.I;
            boolean z13 = bVar2 != null && bVar2.a() <= j11 && j11 < jA;
            boolean zT = T((b) z3.a.i(this.J));
            if (!z12 && !z13 && !zT) {
                z11 = false;
            }
            this.H = z11;
            if (z13 && !z12) {
                return;
            }
        }
        this.I = this.J;
        this.J = null;
    }

    public boolean X(long j11, long j12, Bitmap bitmap, long j13) throws ExoPlaybackException {
        long j14 = j13 - j11;
        if (!a0() && j14 >= 30000) {
            return false;
        }
        this.F.b(j13 - this.f69788x.f69793b, bitmap);
        return true;
    }

    public final void Y() {
        this.E = null;
        this.A = 0;
        this.f69790z = C.TIME_UNSET;
        c cVar = this.D;
        if (cVar != null) {
            cVar.release();
            this.D = null;
        }
    }

    public final void Z(d dVar) {
        this.F = R(dVar);
    }

    @Override // androidx.media3.exoplayer.y2
    public int a(y yVar) {
        return this.f69783s.a(yVar);
    }

    public final boolean a0() {
        boolean z11 = getState() == 2;
        int i11 = this.B;
        if (i11 == 0) {
            return z11;
        }
        if (i11 == 1) {
            return true;
        }
        if (i11 == 3) {
            return false;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public String getName() {
        return "ImageRenderer";
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.t2.b
    public void handleMessage(int i11, Object obj) throws ExoPlaybackException {
        if (i11 != 15) {
            super.handleMessage(i11, obj);
        } else {
            Z(obj instanceof d ? (d) obj : null);
        }
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isEnded() {
        return this.f69787w;
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isReady() {
        int i11 = this.B;
        return i11 == 3 || (i11 == 0 && this.H);
    }

    @Override // androidx.media3.exoplayer.w2
    public void render(long j11, long j12) throws ExoPlaybackException {
        if (this.f69787w) {
            return;
        }
        if (this.C == null) {
            t1 t1VarT = t();
            this.f69784t.clear();
            int iK = K(t1VarT, this.f69784t, 2);
            if (iK != -5) {
                if (iK == -4) {
                    z3.a.g(this.f69784t.isEndOfStream());
                    this.f69786v = true;
                    this.f69787w = true;
                    return;
                }
                return;
            }
            this.C = (y) z3.a.i(t1VarT.f11382b);
            S();
        }
        try {
            j0.a("drainAndFeedDecoder");
            while (P(j11, j12)) {
            }
            while (Q(j11)) {
            }
            j0.c();
        } catch (ImageDecoderException e11) {
            throw p(e11, null, 4003);
        }
    }

    @Override // androidx.media3.exoplayer.m
    public void z() {
        this.C = null;
        this.f69788x = a.f69791c;
        this.f69785u.clear();
        Y();
        this.F.a();
    }
}
