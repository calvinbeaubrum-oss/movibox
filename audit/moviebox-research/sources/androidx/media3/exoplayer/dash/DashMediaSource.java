package androidx.media3.exoplayer.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.StreamKey;
import androidx.media3.common.b0;
import androidx.media3.common.c0;
import androidx.media3.common.m0;
import androidx.media3.exoplayer.offline.r;
import androidx.media3.exoplayer.source.l;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.k;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.upstream.n;
import c4.o;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import h4.j;
import i4.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o5.s;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class DashMediaSource extends androidx.media3.exoplayer.source.a {
    public Loader A;

    @Nullable
    public o B;
    public IOException C;
    public Handler D;
    public b0.g E;
    public Uri F;
    public Uri G;
    public h4.c H;
    public boolean I;
    public long J;
    public long K;
    public long L;
    public int M;
    public long N;
    public int O;
    public b0 P;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f10086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.media3.datasource.a.InterfaceC0090a f10087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.media3.exoplayer.dash.a.InterfaceC0095a f10088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p4.d f10089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.c f10090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m f10091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g4.b f10092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f10093o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f10094p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.m.a f10095q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.o.a<? extends h4.c> f10096r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e f10097s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Object f10098t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SparseArray<androidx.media3.exoplayer.dash.b> f10099u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Runnable f10100v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f10101w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final androidx.media3.exoplayer.dash.d.b f10102x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final n f10103y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.media3.datasource.a f10104z;

    /* JADX INFO: compiled from: source.java */
    public static final class Factory implements l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.exoplayer.dash.a.InterfaceC0095a f10105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final androidx.media3.datasource.a.InterfaceC0090a f10106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.media3.exoplayer.upstream.f.a f10107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public u f10108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public p4.d f10109e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public m f10110f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f10111g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f10112h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public androidx.media3.exoplayer.upstream.o.a<? extends h4.c> f10113i;

        public Factory(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            this(new androidx.media3.exoplayer.dash.c.a(interfaceC0090a), interfaceC0090a);
        }

        public Factory(androidx.media3.exoplayer.dash.a.InterfaceC0095a interfaceC0095a, @Nullable androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            this.f10105a = (androidx.media3.exoplayer.dash.a.InterfaceC0095a) z3.a.e(interfaceC0095a);
            this.f10106b = interfaceC0090a;
            this.f10108d = new androidx.media3.exoplayer.drm.a();
            this.f10110f = new k();
            this.f10111g = 30000L;
            this.f10112h = 5000000L;
            this.f10109e = new p4.e();
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public DashMediaSource c(b0 b0Var) {
            z3.a.e(b0Var.f8951b);
            androidx.media3.exoplayer.upstream.o.a dVar = this.f10113i;
            if (dVar == null) {
                dVar = new h4.d();
            }
            List<StreamKey> list = b0Var.f8951b.f9050d;
            androidx.media3.exoplayer.upstream.o.a rVar = !list.isEmpty() ? new r(dVar, list) : dVar;
            androidx.media3.exoplayer.upstream.f.a aVar = this.f10107c;
            if (aVar != null) {
                aVar.a(b0Var);
            }
            return new DashMediaSource(b0Var, null, this.f10106b, rVar, this.f10105a, this.f10109e, null, this.f10108d.a(b0Var), this.f10110f, this.f10111g, this.f10112h, null);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory b(boolean z11) {
            this.f10105a.b(z11);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Factory f(androidx.media3.exoplayer.upstream.f.a aVar) {
            this.f10107c = (androidx.media3.exoplayer.upstream.f.a) z3.a.e(aVar);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory d(u uVar) {
            this.f10108d = (u) z3.a.f(uVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Factory e(m mVar) {
            this.f10110f = (m) z3.a.f(mVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Factory a(s.a aVar) {
            this.f10105a.a((s.a) z3.a.e(aVar));
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements androidx.media3.exoplayer.util.b.InterfaceC0107b {
        public a() {
        }

        @Override // androidx.media3.exoplayer.util.b.InterfaceC0107b
        public void a(IOException iOException) {
            DashMediaSource.this.X(iOException);
        }

        @Override // androidx.media3.exoplayer.util.b.InterfaceC0107b
        public void onInitialized() {
            DashMediaSource.this.Y(androidx.media3.exoplayer.util.b.h());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends m0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f10115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f10116g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f10117h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f10118i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f10119j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f10120k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f10121l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final h4.c f10122m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final b0 f10123n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @Nullable
        public final b0.g f10124o;

        public b(long j11, long j12, long j13, int i11, long j14, long j15, long j16, h4.c cVar, b0 b0Var, @Nullable b0.g gVar) {
            z3.a.g(cVar.f66255d == (gVar != null));
            this.f10115f = j11;
            this.f10116g = j12;
            this.f10117h = j13;
            this.f10118i = i11;
            this.f10119j = j14;
            this.f10120k = j15;
            this.f10121l = j16;
            this.f10122m = cVar;
            this.f10123n = b0Var;
            this.f10124o = gVar;
        }

        public static boolean t(h4.c cVar) {
            return cVar.f66255d && cVar.f66256e != C.TIME_UNSET && cVar.f66253b == C.TIME_UNSET;
        }

        @Override // androidx.media3.common.m0
        public int b(Object obj) {
            int iIntValue;
            if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.f10118i) >= 0 && iIntValue < i()) {
                return iIntValue;
            }
            return -1;
        }

        @Override // androidx.media3.common.m0
        public m0.b g(int i11, m0.b bVar, boolean z11) {
            z3.a.c(i11, 0, i());
            return bVar.t(z11 ? this.f10122m.c(i11).f66287a : null, z11 ? Integer.valueOf(this.f10118i + i11) : null, 0, this.f10122m.f(i11), u0.S0(this.f10122m.c(i11).f66288b - this.f10122m.c(0).f66288b) - this.f10119j);
        }

        @Override // androidx.media3.common.m0
        public int i() {
            return this.f10122m.d();
        }

        @Override // androidx.media3.common.m0
        public Object m(int i11) {
            z3.a.c(i11, 0, i());
            return Integer.valueOf(this.f10118i + i11);
        }

        @Override // androidx.media3.common.m0
        public m0.c o(int i11, m0.c cVar, long j11) {
            z3.a.c(i11, 0, 1);
            long jS = s(j11);
            Object obj = m0.c.f9300r;
            b0 b0Var = this.f10123n;
            h4.c cVar2 = this.f10122m;
            return cVar.g(obj, b0Var, cVar2, this.f10115f, this.f10116g, this.f10117h, true, t(cVar2), this.f10124o, jS, this.f10120k, 0, i() - 1, this.f10119j);
        }

        @Override // androidx.media3.common.m0
        public int p() {
            return 1;
        }

        public final long s(long j11) {
            g4.f fVarK;
            long j12 = this.f10121l;
            if (!t(this.f10122m)) {
                return j12;
            }
            if (j11 > 0) {
                j12 += j11;
                if (j12 > this.f10120k) {
                    return C.TIME_UNSET;
                }
            }
            long j13 = this.f10119j + j12;
            long jF = this.f10122m.f(0);
            int i11 = 0;
            while (i11 < this.f10122m.d() - 1 && j13 >= jF) {
                j13 -= jF;
                i11++;
                jF = this.f10122m.f(i11);
            }
            h4.g gVarC = this.f10122m.c(i11);
            int iA = gVarC.a(2);
            return (iA == -1 || (fVarK = gVarC.f66289c.get(iA).f66244c.get(0).k()) == null || fVarK.f(jF) == 0) ? j12 : (j12 + fVarK.getTimeUs(fVarK.e(j13, jF))) - j13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements androidx.media3.exoplayer.dash.d.b {
        public c() {
        }

        public /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // androidx.media3.exoplayer.dash.d.b
        public void a(long j11) {
            DashMediaSource.this.Q(j11);
        }

        @Override // androidx.media3.exoplayer.dash.d.b
        public void b() {
            DashMediaSource.this.R();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements androidx.media3.exoplayer.upstream.o.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f10126a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // androidx.media3.exoplayer.upstream.o.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            String line = new BufferedReader(new InputStreamReader(inputStream, com.google.common.base.c.f38165c)).readLine();
            try {
                Matcher matcher = f10126a.matcher(line);
                if (!matcher.matches()) {
                    throw ParserException.createForMalformedManifest("Couldn't parse timestamp: " + line, null);
                }
                String strGroup = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(strGroup).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j11 = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long j12 = Long.parseLong(matcher.group(5));
                    String strGroup2 = matcher.group(7);
                    time -= j11 * (((j12 * 60) + (TextUtils.isEmpty(strGroup2) ? 0L : Long.parseLong(strGroup2))) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                }
                return Long.valueOf(time);
            } catch (ParseException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class e implements Loader.b<androidx.media3.exoplayer.upstream.o<h4.c>> {
        public e() {
        }

        public /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void o(androidx.media3.exoplayer.upstream.o<h4.c> oVar, long j11, long j12, boolean z11) {
            DashMediaSource.this.S(oVar, j11, j12);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void n(androidx.media3.exoplayer.upstream.o<h4.c> oVar, long j11, long j12) {
            DashMediaSource.this.T(oVar, j11, j12);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c k(androidx.media3.exoplayer.upstream.o<h4.c> oVar, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.U(oVar, j11, j12, iOException, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f implements n {
        public f() {
        }

        public final void a() throws IOException {
            if (DashMediaSource.this.C != null) {
                throw DashMediaSource.this.C;
            }
        }

        @Override // androidx.media3.exoplayer.upstream.n
        public void maybeThrowError() throws IOException {
            DashMediaSource.this.A.maybeThrowError();
            a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class g implements Loader.b<androidx.media3.exoplayer.upstream.o<Long>> {
        public g() {
        }

        public /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void o(androidx.media3.exoplayer.upstream.o<Long> oVar, long j11, long j12, boolean z11) {
            DashMediaSource.this.S(oVar, j11, j12);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void n(androidx.media3.exoplayer.upstream.o<Long> oVar, long j11, long j12) {
            DashMediaSource.this.V(oVar, j11, j12);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c k(androidx.media3.exoplayer.upstream.o<Long> oVar, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.W(oVar, j11, j12, iOException);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h implements androidx.media3.exoplayer.upstream.o.a<Long> {
        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        @Override // androidx.media3.exoplayer.upstream.o.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(u0.Z0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        c0.a("media3.exoplayer.dash");
    }

    public DashMediaSource(b0 b0Var, @Nullable h4.c cVar, @Nullable androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, @Nullable androidx.media3.exoplayer.upstream.o.a<? extends h4.c> aVar, androidx.media3.exoplayer.dash.a.InterfaceC0095a interfaceC0095a, p4.d dVar, @Nullable androidx.media3.exoplayer.upstream.f fVar, androidx.media3.exoplayer.drm.c cVar2, m mVar, long j11, long j12) {
        this.P = b0Var;
        this.E = b0Var.f8953d;
        this.F = ((b0.h) z3.a.e(b0Var.f8951b)).f9047a;
        this.G = b0Var.f8951b.f9047a;
        this.H = cVar;
        this.f10087i = interfaceC0090a;
        this.f10096r = aVar;
        this.f10088j = interfaceC0095a;
        this.f10090l = cVar2;
        this.f10091m = mVar;
        this.f10093o = j11;
        this.f10094p = j12;
        this.f10089k = dVar;
        this.f10092n = new g4.b();
        boolean z11 = cVar != null;
        this.f10086h = z11;
        a aVar2 = null;
        this.f10095q = u(null);
        this.f10098t = new Object();
        this.f10099u = new SparseArray<>();
        this.f10102x = new c(this, aVar2);
        this.N = C.TIME_UNSET;
        this.L = C.TIME_UNSET;
        if (!z11) {
            this.f10097s = new e(this, aVar2);
            this.f10103y = new f();
            this.f10100v = new Runnable() { // from class: g4.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f65392a.f0();
                }
            };
            this.f10101w = new Runnable() { // from class: g4.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f65393a.O();
                }
            };
            return;
        }
        z3.a.g(true ^ cVar.f66255d);
        this.f10097s = null;
        this.f10100v = null;
        this.f10101w = null;
        this.f10103y = new n.a();
    }

    public /* synthetic */ DashMediaSource(b0 b0Var, h4.c cVar, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, androidx.media3.exoplayer.upstream.o.a aVar, androidx.media3.exoplayer.dash.a.InterfaceC0095a interfaceC0095a, p4.d dVar, androidx.media3.exoplayer.upstream.f fVar, androidx.media3.exoplayer.drm.c cVar2, m mVar, long j11, long j12, a aVar2) {
        this(b0Var, cVar, interfaceC0090a, aVar, interfaceC0095a, dVar, fVar, cVar2, mVar, j11, j12);
    }

    public static long I(h4.g gVar, long j11, long j12) {
        long jS0 = u0.S0(gVar.f66288b);
        boolean zM = M(gVar);
        long jMin = Long.MAX_VALUE;
        for (int i11 = 0; i11 < gVar.f66289c.size(); i11++) {
            h4.a aVar = gVar.f66289c.get(i11);
            List<j> list = aVar.f66244c;
            int i12 = aVar.f66243b;
            boolean z11 = (i12 == 1 || i12 == 2) ? false : true;
            if ((!zM || !z11) && !list.isEmpty()) {
                g4.f fVarK = list.get(0).k();
                if (fVarK == null) {
                    return jS0 + j11;
                }
                long jI = fVarK.i(j11, j12);
                if (jI == 0) {
                    return jS0;
                }
                long jB = (fVarK.b(j11, j12) + jI) - 1;
                jMin = Math.min(jMin, fVarK.a(jB, j11) + fVarK.getTimeUs(jB) + jS0);
            }
        }
        return jMin;
    }

    public static long J(h4.g gVar, long j11, long j12) {
        long jS0 = u0.S0(gVar.f66288b);
        boolean zM = M(gVar);
        long jMax = jS0;
        for (int i11 = 0; i11 < gVar.f66289c.size(); i11++) {
            h4.a aVar = gVar.f66289c.get(i11);
            List<j> list = aVar.f66244c;
            int i12 = aVar.f66243b;
            boolean z11 = (i12 == 1 || i12 == 2) ? false : true;
            if ((!zM || !z11) && !list.isEmpty()) {
                g4.f fVarK = list.get(0).k();
                if (fVarK == null || fVarK.i(j11, j12) == 0) {
                    return jS0;
                }
                jMax = Math.max(jMax, fVarK.getTimeUs(fVarK.b(j11, j12)) + jS0);
            }
        }
        return jMax;
    }

    public static long K(h4.c cVar, long j11) {
        g4.f fVarK;
        int iD = cVar.d() - 1;
        h4.g gVarC = cVar.c(iD);
        long jS0 = u0.S0(gVarC.f66288b);
        long jF = cVar.f(iD);
        long jS1 = u0.S0(j11);
        long jS2 = u0.S0(cVar.f66252a);
        long jS3 = u0.S0(5000L);
        for (int i11 = 0; i11 < gVarC.f66289c.size(); i11++) {
            List<j> list = gVarC.f66289c.get(i11).f66244c;
            if (!list.isEmpty() && (fVarK = list.get(0).k()) != null) {
                long jC = ((jS2 + jS0) + fVarK.c(jF, jS1)) - jS1;
                if (jC < jS3 - 100000 || (jC > jS3 && jC < jS3 + 100000)) {
                    jS3 = jC;
                }
            }
        }
        return com.google.common.math.f.b(jS3, 1000L, RoundingMode.CEILING);
    }

    public static boolean M(h4.g gVar) {
        for (int i11 = 0; i11 < gVar.f66289c.size(); i11++) {
            int i12 = gVar.f66289c.get(i11).f66243b;
            if (i12 == 1 || i12 == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean N(h4.g gVar) {
        for (int i11 = 0; i11 < gVar.f66289c.size(); i11++) {
            g4.f fVarK = gVar.f66289c.get(i11).f66244c.get(0).k();
            if (fVarK == null || fVarK.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.a
    public void B() {
        this.I = false;
        this.f10104z = null;
        Loader loader = this.A;
        if (loader != null) {
            loader.k();
            this.A = null;
        }
        this.J = 0L;
        this.K = 0L;
        this.H = this.f10086h ? this.H : null;
        this.F = this.G;
        this.C = null;
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.D = null;
        }
        this.L = C.TIME_UNSET;
        this.M = 0;
        this.N = C.TIME_UNSET;
        this.f10099u.clear();
        this.f10092n.i();
        this.f10090l.release();
    }

    public final long L() {
        return Math.min((this.M - 1) * 1000, 5000);
    }

    public final /* synthetic */ void O() {
        Z(false);
    }

    public final void P() {
        androidx.media3.exoplayer.util.b.j(this.A, new a());
    }

    public void Q(long j11) {
        long j12 = this.N;
        if (j12 == C.TIME_UNSET || j12 < j11) {
            this.N = j11;
        }
    }

    public void R() {
        this.D.removeCallbacks(this.f10101w);
        f0();
    }

    public void S(androidx.media3.exoplayer.upstream.o<?> oVar, long j11, long j12) {
        p4.n nVar = new p4.n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
        this.f10091m.b(oVar.f11500a);
        this.f10095q.p(nVar, oVar.f11502c);
    }

    public void T(androidx.media3.exoplayer.upstream.o<h4.c> oVar, long j11, long j12) {
        p4.n nVar = new p4.n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
        this.f10091m.b(oVar.f11500a);
        this.f10095q.s(nVar, oVar.f11502c);
        h4.c cVarC = oVar.c();
        h4.c cVar = this.H;
        int iD = cVar == null ? 0 : cVar.d();
        long j13 = cVarC.c(0).f66288b;
        int i11 = 0;
        while (i11 < iD && this.H.c(i11).f66288b < j13) {
            i11++;
        }
        if (cVarC.f66255d) {
            if (iD - i11 > cVarC.d()) {
                z3.o.h("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j14 = this.N;
                if (j14 == C.TIME_UNSET || cVarC.f66259h * 1000 > j14) {
                    this.M = 0;
                } else {
                    z3.o.h("DashMediaSource", "Loaded stale dynamic manifest: " + cVarC.f66259h + ", " + this.N);
                }
            }
            int i12 = this.M;
            this.M = i12 + 1;
            if (i12 < this.f10091m.a(oVar.f11502c)) {
                d0(L());
                return;
            } else {
                this.C = new DashManifestStaleException();
                return;
            }
        }
        this.H = cVarC;
        this.I = cVarC.f66255d & this.I;
        this.J = j11 - j12;
        this.K = j11;
        synchronized (this.f10098t) {
            try {
                if (oVar.f11501b.f14598a == this.F) {
                    Uri uriD = this.H.f66262k;
                    if (uriD == null) {
                        uriD = oVar.d();
                    }
                    this.F = uriD;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (iD != 0) {
            this.O += i11;
            Z(true);
            return;
        }
        h4.c cVar2 = this.H;
        if (!cVar2.f66255d) {
            Z(true);
            return;
        }
        h4.o oVar2 = cVar2.f66260i;
        if (oVar2 != null) {
            a0(oVar2);
        } else {
            P();
        }
    }

    public Loader.c U(androidx.media3.exoplayer.upstream.o<h4.c> oVar, long j11, long j12, IOException iOException, int i11) {
        p4.n nVar = new p4.n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
        long jC = this.f10091m.c(new m.c(nVar, new p4.o(oVar.f11502c), iOException, i11));
        Loader.c cVarG = jC == C.TIME_UNSET ? Loader.f11437g : Loader.g(false, jC);
        boolean z11 = !cVarG.c();
        this.f10095q.w(nVar, oVar.f11502c, iOException, z11);
        if (z11) {
            this.f10091m.b(oVar.f11500a);
        }
        return cVarG;
    }

    public void V(androidx.media3.exoplayer.upstream.o<Long> oVar, long j11, long j12) {
        p4.n nVar = new p4.n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a());
        this.f10091m.b(oVar.f11500a);
        this.f10095q.s(nVar, oVar.f11502c);
        Y(oVar.c().longValue() - j11);
    }

    public Loader.c W(androidx.media3.exoplayer.upstream.o<Long> oVar, long j11, long j12, IOException iOException) {
        this.f10095q.w(new p4.n(oVar.f11500a, oVar.f11501b, oVar.d(), oVar.b(), j11, j12, oVar.a()), oVar.f11502c, iOException, true);
        this.f10091m.b(oVar.f11500a);
        X(iOException);
        return Loader.f11436f;
    }

    public final void X(IOException iOException) {
        z3.o.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        Z(true);
    }

    public final void Y(long j11) {
        this.L = j11;
        Z(true);
    }

    public final void Z(boolean z11) {
        long j11;
        long j12;
        for (int i11 = 0; i11 < this.f10099u.size(); i11++) {
            int iKeyAt = this.f10099u.keyAt(i11);
            if (iKeyAt >= this.O) {
                this.f10099u.valueAt(i11).F(this.H, iKeyAt - this.O);
            }
        }
        h4.g gVarC = this.H.c(0);
        int iD = this.H.d() - 1;
        h4.g gVarC2 = this.H.c(iD);
        long jF = this.H.f(iD);
        long jS0 = u0.S0(u0.i0(this.L));
        long J = J(gVarC, this.H.f(0), jS0);
        long jI = I(gVarC2, jF, jS0);
        boolean z12 = this.H.f66255d && !N(gVarC2);
        if (z12) {
            long j13 = this.H.f66257f;
            if (j13 != C.TIME_UNSET) {
                J = Math.max(J, jI - u0.S0(j13));
            }
        }
        long j14 = jI - J;
        h4.c cVar = this.H;
        if (cVar.f66255d) {
            z3.a.g(cVar.f66252a != C.TIME_UNSET);
            long jS1 = (jS0 - u0.S0(this.H.f66252a)) - J;
            g0(jS1, j14);
            long jB1 = this.H.f66252a + u0.B1(J);
            long jS2 = jS1 - u0.S0(this.E.f9028a);
            long jMin = Math.min(this.f10094p, j14 / 2);
            j11 = jB1;
            j12 = jS2 < jMin ? jMin : jS2;
        } else {
            j11 = C.TIME_UNSET;
            j12 = 0;
        }
        long jS3 = J - u0.S0(gVarC.f66288b);
        h4.c cVar2 = this.H;
        A(new b(cVar2.f66252a, j11, this.L, this.O, jS3, j14, j12, cVar2, a(), this.H.f66255d ? this.E : null));
        if (this.f10086h) {
            return;
        }
        this.D.removeCallbacks(this.f10101w);
        if (z12) {
            this.D.postDelayed(this.f10101w, K(this.H, u0.i0(this.L)));
        }
        if (this.I) {
            f0();
            return;
        }
        if (z11) {
            h4.c cVar3 = this.H;
            if (cVar3.f66255d) {
                long j15 = cVar3.f66256e;
                if (j15 != C.TIME_UNSET) {
                    if (j15 == 0) {
                        j15 = 5000;
                    }
                    d0(Math.max(0L, (this.J + j15) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.l
    public synchronized b0 a() {
        return this.P;
    }

    public final void a0(h4.o oVar) {
        String str = oVar.f66341a;
        if (u0.c(str, "urn:mpeg:dash:utc:direct:2014") || u0.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            b0(oVar);
            return;
        }
        if (u0.c(str, "urn:mpeg:dash:utc:http-iso:2014") || u0.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            c0(oVar, new d());
            return;
        }
        if (u0.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") || u0.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            c0(oVar, new h(null));
        } else if (u0.c(str, "urn:mpeg:dash:utc:ntp:2014") || u0.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
            P();
        } else {
            X(new IOException("Unsupported UTC timing scheme"));
        }
    }

    public final void b0(h4.o oVar) {
        try {
            Y(u0.Z0(oVar.f66342b) - this.K);
        } catch (ParserException e11) {
            X(e11);
        }
    }

    public final void c0(h4.o oVar, androidx.media3.exoplayer.upstream.o.a<Long> aVar) {
        e0(new androidx.media3.exoplayer.upstream.o(this.f10104z, Uri.parse(oVar.f66342b), 5, aVar), new g(this, null), 1);
    }

    public final void d0(long j11) {
        this.D.postDelayed(this.f10100v, j11);
    }

    public final <T> void e0(androidx.media3.exoplayer.upstream.o<T> oVar, Loader.b<androidx.media3.exoplayer.upstream.o<T>> bVar, int i11) {
        this.f10095q.y(new p4.n(oVar.f11500a, oVar.f11501b, this.A.m(oVar, bVar, i11)), oVar.f11502c);
    }

    public final void f0() {
        Uri uri;
        this.D.removeCallbacks(this.f10100v);
        if (this.A.h()) {
            return;
        }
        if (this.A.i()) {
            this.I = true;
            return;
        }
        synchronized (this.f10098t) {
            uri = this.F;
        }
        this.I = false;
        e0(new androidx.media3.exoplayer.upstream.o(this.f10104z, uri, 4, this.f10096r), this.f10097s, this.f10091m.a(4));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003b  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059  */
    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0065  */
    /* JADX WARN: Code duplicated, block: B:30:0x006d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0077  */
    /* JADX WARN: Code duplicated, block: B:36:0x007d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0083  */
    /* JADX WARN: Code duplicated, block: B:39:0x0085  */
    /* JADX WARN: Code duplicated, block: B:42:0x008c  */
    /* JADX WARN: Code duplicated, block: B:45:0x0092  */
    /* JADX WARN: Code duplicated, block: B:48:0x0097  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00be  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00db  */
    public final void g0(long j11, long j12) {
        long j13;
        long jMin;
        long jB1;
        long j14;
        long jQ;
        long j15;
        h4.l lVar;
        long j16;
        long jQ2;
        float f11;
        float f12;
        h4.l lVar2;
        h4.l lVar3;
        h4.l lVar4;
        h4.c cVar;
        h4.l lVar5;
        long j17;
        b0.g gVar = a().f8953d;
        long jB2 = u0.B1(j11);
        long j18 = gVar.f9030c;
        if (j18 == C.TIME_UNSET) {
            h4.l lVar6 = this.H.f66261j;
            if (lVar6 != null) {
                long j19 = lVar6.f66334c;
                if (j19 != C.TIME_UNSET) {
                    jMin = Math.min(jB2, j19);
                }
                jB1 = u0.B1(j11 - j12);
                if (jB1 < 0 && j13 > 0) {
                    jB1 = 0;
                }
                j14 = this.H.f66254c;
                if (j14 != C.TIME_UNSET) {
                    jB1 = Math.min(jB1 + j14, jB2);
                }
                jQ = jB1;
                j15 = gVar.f9029b;
                if (j15 != C.TIME_UNSET) {
                    jQ = u0.q(j15, jQ, jB2);
                } else {
                    lVar = this.H.f66261j;
                    if (lVar != null) {
                        j16 = lVar.f66333b;
                        if (j16 != C.TIME_UNSET) {
                            jQ = u0.q(j16, jQ, jB2);
                        }
                    }
                }
                if (jQ > j13) {
                    j13 = jQ;
                }
                jQ2 = this.E.f9028a;
                if (jQ2 == C.TIME_UNSET) {
                    cVar = this.H;
                    lVar5 = cVar.f66261j;
                    if (lVar5 != null) {
                        j17 = lVar5.f66332a;
                        if (j17 != C.TIME_UNSET) {
                            jQ2 = j17;
                        } else {
                            jQ2 = cVar.f66258g;
                            if (jQ2 == C.TIME_UNSET) {
                                jQ2 = this.f10093o;
                            }
                        }
                    } else {
                        jQ2 = cVar.f66258g;
                        if (jQ2 == C.TIME_UNSET) {
                            jQ2 = this.f10093o;
                        }
                    }
                }
                if (jQ2 < jQ) {
                    jQ2 = jQ;
                }
                if (jQ2 > j13) {
                    jQ2 = u0.q(u0.B1(j11 - Math.min(this.f10094p, j12 / 2)), jQ, j13);
                }
                f11 = gVar.f9031d;
                if (f11 == -3.4028235E38f) {
                    lVar4 = this.H.f66261j;
                    if (lVar4 != null) {
                        f11 = lVar4.f66335d;
                    } else {
                        f11 = -3.4028235E38f;
                    }
                }
                f12 = gVar.f9032e;
                if (f12 == -3.4028235E38f) {
                    lVar3 = this.H.f66261j;
                    if (lVar3 != null) {
                        f12 = lVar3.f66336e;
                    } else {
                        f12 = -3.4028235E38f;
                    }
                }
                if (f11 == -3.4028235E38f && f12 == -3.4028235E38f && ((lVar2 = this.H.f66261j) == null || lVar2.f66332a == C.TIME_UNSET)) {
                    f11 = 1.0f;
                    f12 = 1.0f;
                }
                this.E = new b0.g.a().k(jQ2).i(jQ).g(j13).j(f11).h(f12).f();
            }
            j13 = jB2;
            jB1 = u0.B1(j11 - j12);
            if (jB1 < 0) {
                jB1 = 0;
            }
            j14 = this.H.f66254c;
            if (j14 != C.TIME_UNSET) {
                jB1 = Math.min(jB1 + j14, jB2);
            }
            jQ = jB1;
            j15 = gVar.f9029b;
            if (j15 != C.TIME_UNSET) {
                jQ = u0.q(j15, jQ, jB2);
            } else {
                lVar = this.H.f66261j;
                if (lVar != null) {
                    j16 = lVar.f66333b;
                    if (j16 != C.TIME_UNSET) {
                        jQ = u0.q(j16, jQ, jB2);
                    }
                }
            }
            if (jQ > j13) {
                j13 = jQ;
            }
            jQ2 = this.E.f9028a;
            if (jQ2 == C.TIME_UNSET) {
                cVar = this.H;
                lVar5 = cVar.f66261j;
                if (lVar5 != null) {
                    j17 = lVar5.f66332a;
                    if (j17 != C.TIME_UNSET) {
                        jQ2 = j17;
                    } else {
                        jQ2 = cVar.f66258g;
                        if (jQ2 == C.TIME_UNSET) {
                            jQ2 = this.f10093o;
                        }
                    }
                } else {
                    jQ2 = cVar.f66258g;
                    if (jQ2 == C.TIME_UNSET) {
                        jQ2 = this.f10093o;
                    }
                }
            }
            if (jQ2 < jQ) {
                jQ2 = jQ;
            }
            if (jQ2 > j13) {
                jQ2 = u0.q(u0.B1(j11 - Math.min(this.f10094p, j12 / 2)), jQ, j13);
            }
            f11 = gVar.f9031d;
            if (f11 == -3.4028235E38f) {
                lVar4 = this.H.f66261j;
                if (lVar4 != null) {
                    f11 = lVar4.f66335d;
                } else {
                    f11 = -3.4028235E38f;
                }
            }
            f12 = gVar.f9032e;
            if (f12 == -3.4028235E38f) {
                lVar3 = this.H.f66261j;
                if (lVar3 != null) {
                    f12 = lVar3.f66336e;
                } else {
                    f12 = -3.4028235E38f;
                }
            }
            if (f11 == -3.4028235E38f) {
                f11 = 1.0f;
                f12 = 1.0f;
            }
            this.E = new b0.g.a().k(jQ2).i(jQ).g(j13).j(f11).h(f12).f();
        }
        jMin = Math.min(jB2, j18);
        j13 = jMin;
        jB1 = u0.B1(j11 - j12);
        if (jB1 < 0) {
            jB1 = 0;
        }
        j14 = this.H.f66254c;
        if (j14 != C.TIME_UNSET) {
            jB1 = Math.min(jB1 + j14, jB2);
        }
        jQ = jB1;
        j15 = gVar.f9029b;
        if (j15 != C.TIME_UNSET) {
            jQ = u0.q(j15, jQ, jB2);
        } else {
            lVar = this.H.f66261j;
            if (lVar != null) {
                j16 = lVar.f66333b;
                if (j16 != C.TIME_UNSET) {
                    jQ = u0.q(j16, jQ, jB2);
                }
            }
        }
        if (jQ > j13) {
            j13 = jQ;
        }
        jQ2 = this.E.f9028a;
        if (jQ2 == C.TIME_UNSET) {
            cVar = this.H;
            lVar5 = cVar.f66261j;
            if (lVar5 != null) {
                j17 = lVar5.f66332a;
                if (j17 != C.TIME_UNSET) {
                    jQ2 = j17;
                } else {
                    jQ2 = cVar.f66258g;
                    if (jQ2 == C.TIME_UNSET) {
                        jQ2 = this.f10093o;
                    }
                }
            } else {
                jQ2 = cVar.f66258g;
                if (jQ2 == C.TIME_UNSET) {
                    jQ2 = this.f10093o;
                }
            }
        }
        if (jQ2 < jQ) {
            jQ2 = jQ;
        }
        if (jQ2 > j13) {
            jQ2 = u0.q(u0.B1(j11 - Math.min(this.f10094p, j12 / 2)), jQ, j13);
        }
        f11 = gVar.f9031d;
        if (f11 == -3.4028235E38f) {
            lVar4 = this.H.f66261j;
            if (lVar4 != null) {
                f11 = lVar4.f66335d;
            } else {
                f11 = -3.4028235E38f;
            }
        }
        f12 = gVar.f9032e;
        if (f12 == -3.4028235E38f) {
            lVar3 = this.H.f66261j;
            if (lVar3 != null) {
                f12 = lVar3.f66336e;
            } else {
                f12 = -3.4028235E38f;
            }
        }
        if (f11 == -3.4028235E38f) {
            f11 = 1.0f;
            f12 = 1.0f;
        }
        this.E = new b0.g.a().k(jQ2).i(jQ).g(j13).j(f11).h(f12).f();
    }

    @Override // androidx.media3.exoplayer.source.l
    public androidx.media3.exoplayer.source.k h(l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        int iIntValue = ((Integer) bVar.f11209a).intValue() - this.O;
        androidx.media3.exoplayer.source.m.a aVarU = u(bVar);
        androidx.media3.exoplayer.dash.b bVar3 = new androidx.media3.exoplayer.dash.b(iIntValue + this.O, this.H, this.f10092n, iIntValue, this.f10088j, this.B, null, this.f10090l, s(bVar), this.f10091m, aVarU, this.L, this.f10103y, bVar2, this.f10089k, this.f10102x, x());
        this.f10099u.put(bVar3.f10131a, bVar3);
        return bVar3;
    }

    @Override // androidx.media3.exoplayer.source.l
    public void l(androidx.media3.exoplayer.source.k kVar) {
        androidx.media3.exoplayer.dash.b bVar = (androidx.media3.exoplayer.dash.b) kVar;
        bVar.B();
        this.f10099u.remove(bVar.f10131a);
    }

    @Override // androidx.media3.exoplayer.source.l
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f10103y.maybeThrowError();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public synchronized void n(b0 b0Var) {
        this.P = b0Var;
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public boolean q(b0 b0Var) {
        b0 b0VarA = a();
        b0.h hVar = (b0.h) z3.a.e(b0VarA.f8951b);
        b0.h hVar2 = b0Var.f8951b;
        return hVar2 != null && hVar2.f9047a.equals(hVar.f9047a) && hVar2.f9050d.equals(hVar.f9050d) && u0.c(hVar2.f9049c, hVar.f9049c) && b0VarA.f8953d.equals(b0Var.f8953d);
    }

    @Override // androidx.media3.exoplayer.source.a
    public void z(@Nullable o oVar) {
        this.B = oVar;
        this.f10090l.a(Looper.myLooper(), x());
        this.f10090l.prepare();
        if (this.f10086h) {
            Z(false);
            return;
        }
        this.f10104z = this.f10087i.createDataSource();
        this.A = new Loader("DashMediaSource");
        this.D = u0.A();
        f0();
    }
}
