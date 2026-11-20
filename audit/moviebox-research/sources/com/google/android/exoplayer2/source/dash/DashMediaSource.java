package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.k1;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.f0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
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
import nh.n;
import rh.l;
import rh.o;
import sg.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class DashMediaSource extends com.google.android.exoplayer2.source.a {
    public k A;
    public Loader B;

    @Nullable
    public k0 C;
    public IOException D;
    public Handler E;
    public u1.g F;
    public Uri G;
    public Uri H;
    public rh.c I;
    public boolean J;
    public long K;
    public long L;
    public long M;
    public int N;
    public long O;
    public int P;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u1 f33807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f33808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k.a f33809k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.dash.a.InterfaceC0363a f33810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final nh.d f33811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f33812n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final z f33813o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final qh.b f33814p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f33815q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j.a f33816r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b0.a<? extends rh.c> f33817s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final e f33818t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f33819u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SparseArray<com.google.android.exoplayer2.source.dash.b> f33820v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f33821w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Runnable f33822x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.dash.d.b f33823y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a0 f33824z;

    /* JADX INFO: compiled from: source.java */
    public static final class Factory implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.dash.a.InterfaceC0363a f33825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final k.a f33826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u f33827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public nh.d f33828d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public z f33829e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f33830f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public b0.a<? extends rh.c> f33831g;

        public Factory(com.google.android.exoplayer2.source.dash.a.InterfaceC0363a interfaceC0363a, @Nullable k.a aVar) {
            this.f33825a = (com.google.android.exoplayer2.source.dash.a.InterfaceC0363a) com.google.android.exoplayer2.util.a.e(interfaceC0363a);
            this.f33826b = aVar;
            this.f33827c = new com.google.android.exoplayer2.drm.a();
            this.f33829e = new v();
            this.f33830f = 30000L;
            this.f33828d = new nh.e();
        }

        public Factory(k.a aVar) {
            this(new com.google.android.exoplayer2.source.dash.c.a(aVar), aVar);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public DashMediaSource a(u1 u1Var) {
            com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
            b0.a dVar = this.f33831g;
            if (dVar == null) {
                dVar = new rh.d();
            }
            List<StreamKey> list = u1Var.f34776b.f34842d;
            return new DashMediaSource(u1Var, null, this.f33826b, !list.isEmpty() ? new com.google.android.exoplayer2.offline.d(dVar, list) : dVar, this.f33825a, this.f33828d, this.f33827c.a(u1Var), this.f33829e, this.f33830f, null);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Factory b(u uVar) {
            this.f33827c = (u) com.google.android.exoplayer2.util.a.f(uVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory c(z zVar) {
            this.f33829e = (z) com.google.android.exoplayer2.util.a.f(zVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements f0.b {
        public a() {
        }

        @Override // com.google.android.exoplayer2.util.f0.b
        public void a(IOException iOException) {
            DashMediaSource.this.Z(iOException);
        }

        @Override // com.google.android.exoplayer2.util.f0.b
        public void onInitialized() {
            DashMediaSource.this.a0(f0.h());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends j3 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f33833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f33834d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f33835f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f33836g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f33837h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f33838i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f33839j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final rh.c f33840k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final u1 f33841l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        public final u1.g f33842m;

        public b(long j11, long j12, long j13, int i11, long j14, long j15, long j16, rh.c cVar, u1 u1Var, @Nullable u1.g gVar) {
            com.google.android.exoplayer2.util.a.g(cVar.f75397d == (gVar != null));
            this.f33833c = j11;
            this.f33834d = j12;
            this.f33835f = j13;
            this.f33836g = i11;
            this.f33837h = j14;
            this.f33838i = j15;
            this.f33839j = j16;
            this.f33840k = cVar;
            this.f33841l = u1Var;
            this.f33842m = gVar;
        }

        public static boolean z(rh.c cVar) {
            return cVar.f75397d && cVar.f75398e != C.TIME_UNSET && cVar.f75395b == C.TIME_UNSET;
        }

        @Override // com.google.android.exoplayer2.j3
        public int f(Object obj) {
            int iIntValue;
            if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.f33836g) >= 0 && iIntValue < m()) {
                return iIntValue;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.j3
        public j3.b k(int i11, j3.b bVar, boolean z11) {
            com.google.android.exoplayer2.util.a.c(i11, 0, m());
            return bVar.v(z11 ? this.f33840k.c(i11).f75429a : null, z11 ? Integer.valueOf(this.f33836g + i11) : null, 0, this.f33840k.f(i11), o0.C0(this.f33840k.c(i11).f75430b - this.f33840k.c(0).f75430b) - this.f33837h);
        }

        @Override // com.google.android.exoplayer2.j3
        public int m() {
            return this.f33840k.d();
        }

        @Override // com.google.android.exoplayer2.j3
        public Object q(int i11) {
            com.google.android.exoplayer2.util.a.c(i11, 0, m());
            return Integer.valueOf(this.f33836g + i11);
        }

        @Override // com.google.android.exoplayer2.j3
        public j3.d s(int i11, j3.d dVar, long j11) {
            com.google.android.exoplayer2.util.a.c(i11, 0, 1);
            long jY = y(j11);
            Object obj = j3.d.f33373s;
            u1 u1Var = this.f33841l;
            rh.c cVar = this.f33840k;
            return dVar.k(obj, u1Var, cVar, this.f33833c, this.f33834d, this.f33835f, true, z(cVar), this.f33842m, jY, this.f33838i, 0, m() - 1, this.f33837h);
        }

        @Override // com.google.android.exoplayer2.j3
        public int t() {
            return 1;
        }

        public final long y(long j11) {
            qh.e eVarK;
            long j12 = this.f33839j;
            if (!z(this.f33840k)) {
                return j12;
            }
            if (j11 > 0) {
                j12 += j11;
                if (j12 > this.f33838i) {
                    return C.TIME_UNSET;
                }
            }
            long j13 = this.f33837h + j12;
            long jF = this.f33840k.f(0);
            int i11 = 0;
            while (i11 < this.f33840k.d() - 1 && j13 >= jF) {
                j13 -= jF;
                i11++;
                jF = this.f33840k.f(i11);
            }
            rh.g gVarC = this.f33840k.c(i11);
            int iA = gVarC.a(2);
            return (iA == -1 || (eVarK = gVarC.f75431c.get(iA).f75386c.get(0).k()) == null || eVarK.f(jF) == 0) ? j12 : (j12 + eVarK.getTimeUs(eVarK.e(j13, jF))) - j13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements com.google.android.exoplayer2.source.dash.d.b {
        public c() {
        }

        public /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.source.dash.d.b
        public void a(long j11) {
            DashMediaSource.this.S(j11);
        }

        @Override // com.google.android.exoplayer2.source.dash.d.b
        public void b() {
            DashMediaSource.this.T();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements b0.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f33844a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // com.google.android.exoplayer2.upstream.b0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            String line = new BufferedReader(new InputStreamReader(inputStream, com.google.common.base.c.f38165c)).readLine();
            try {
                Matcher matcher = f33844a.matcher(line);
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
    public final class e implements Loader.b<b0<rh.c>> {
        public e() {
        }

        public /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(b0<rh.c> b0Var, long j11, long j12, boolean z11) {
            DashMediaSource.this.U(b0Var, j11, j12);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(b0<rh.c> b0Var, long j11, long j12) {
            DashMediaSource.this.V(b0Var, j11, j12);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c n(b0<rh.c> b0Var, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.W(b0Var, j11, j12, iOException, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f implements a0 {
        public f() {
        }

        public final void a() throws IOException {
            if (DashMediaSource.this.D != null) {
                throw DashMediaSource.this.D;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.a0
        public void maybeThrowError() throws IOException {
            DashMediaSource.this.B.maybeThrowError();
            a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class g implements Loader.b<b0<Long>> {
        public g() {
        }

        public /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(b0<Long> b0Var, long j11, long j12, boolean z11) {
            DashMediaSource.this.U(b0Var, j11, j12);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(b0<Long> b0Var, long j11, long j12) {
            DashMediaSource.this.X(b0Var, j11, j12);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c n(b0<Long> b0Var, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.Y(b0Var, j11, j12, iOException);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h implements b0.a<Long> {
        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.b0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(o0.J0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        k1.a("goog.exo.dash");
    }

    public DashMediaSource(u1 u1Var, @Nullable rh.c cVar, @Nullable k.a aVar, @Nullable b0.a<? extends rh.c> aVar2, com.google.android.exoplayer2.source.dash.a.InterfaceC0363a interfaceC0363a, nh.d dVar, com.google.android.exoplayer2.drm.c cVar2, z zVar, long j11) {
        this.f33807i = u1Var;
        this.F = u1Var.f34778d;
        this.G = ((u1.h) com.google.android.exoplayer2.util.a.e(u1Var.f34776b)).f34839a;
        this.H = u1Var.f34776b.f34839a;
        this.I = cVar;
        this.f33809k = aVar;
        this.f33817s = aVar2;
        this.f33810l = interfaceC0363a;
        this.f33812n = cVar2;
        this.f33813o = zVar;
        this.f33815q = j11;
        this.f33811m = dVar;
        this.f33814p = new qh.b();
        boolean z11 = cVar != null;
        this.f33808j = z11;
        a aVar3 = null;
        this.f33816r = v(null);
        this.f33819u = new Object();
        this.f33820v = new SparseArray<>();
        this.f33823y = new c(this, aVar3);
        this.O = C.TIME_UNSET;
        this.M = C.TIME_UNSET;
        if (!z11) {
            this.f33818t = new e(this, aVar3);
            this.f33824z = new f();
            this.f33821w = new Runnable() { // from class: qh.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f74784a.h0();
                }
            };
            this.f33822x = new Runnable() { // from class: qh.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f74785a.Q();
                }
            };
            return;
        }
        com.google.android.exoplayer2.util.a.g(true ^ cVar.f75397d);
        this.f33818t = null;
        this.f33821w = null;
        this.f33822x = null;
        this.f33824z = new a0.a();
    }

    public /* synthetic */ DashMediaSource(u1 u1Var, rh.c cVar, k.a aVar, b0.a aVar2, com.google.android.exoplayer2.source.dash.a.InterfaceC0363a interfaceC0363a, nh.d dVar, com.google.android.exoplayer2.drm.c cVar2, z zVar, long j11, a aVar3) {
        this(u1Var, cVar, aVar, aVar2, interfaceC0363a, dVar, cVar2, zVar, j11);
    }

    public static long K(rh.g gVar, long j11, long j12) {
        long jC0 = o0.C0(gVar.f75430b);
        boolean zO = O(gVar);
        long jMin = Long.MAX_VALUE;
        for (int i11 = 0; i11 < gVar.f75431c.size(); i11++) {
            rh.a aVar = gVar.f75431c.get(i11);
            List<rh.j> list = aVar.f75386c;
            if ((!zO || aVar.f75385b != 3) && !list.isEmpty()) {
                qh.e eVarK = list.get(0).k();
                if (eVarK == null) {
                    return jC0 + j11;
                }
                long jI = eVarK.i(j11, j12);
                if (jI == 0) {
                    return jC0;
                }
                long jB = (eVarK.b(j11, j12) + jI) - 1;
                jMin = Math.min(jMin, eVarK.a(jB, j11) + eVarK.getTimeUs(jB) + jC0);
            }
        }
        return jMin;
    }

    public static long L(rh.g gVar, long j11, long j12) {
        long jC0 = o0.C0(gVar.f75430b);
        boolean zO = O(gVar);
        long jMax = jC0;
        for (int i11 = 0; i11 < gVar.f75431c.size(); i11++) {
            rh.a aVar = gVar.f75431c.get(i11);
            List<rh.j> list = aVar.f75386c;
            if ((!zO || aVar.f75385b != 3) && !list.isEmpty()) {
                qh.e eVarK = list.get(0).k();
                if (eVarK == null || eVarK.i(j11, j12) == 0) {
                    return jC0;
                }
                jMax = Math.max(jMax, eVarK.getTimeUs(eVarK.b(j11, j12)) + jC0);
            }
        }
        return jMax;
    }

    public static long M(rh.c cVar, long j11) {
        qh.e eVarK;
        int iD = cVar.d() - 1;
        rh.g gVarC = cVar.c(iD);
        long jC0 = o0.C0(gVarC.f75430b);
        long jF = cVar.f(iD);
        long jC1 = o0.C0(j11);
        long jC2 = o0.C0(cVar.f75394a);
        long jC3 = o0.C0(5000L);
        for (int i11 = 0; i11 < gVarC.f75431c.size(); i11++) {
            List<rh.j> list = gVarC.f75431c.get(i11).f75386c;
            if (!list.isEmpty() && (eVarK = list.get(0).k()) != null) {
                long jC = ((jC2 + jC0) + eVarK.c(jF, jC1)) - jC1;
                if (jC < jC3 - 100000 || (jC > jC3 && jC < jC3 + 100000)) {
                    jC3 = jC;
                }
            }
        }
        return com.google.common.math.f.b(jC3, 1000L, RoundingMode.CEILING);
    }

    public static boolean O(rh.g gVar) {
        for (int i11 = 0; i11 < gVar.f75431c.size(); i11++) {
            int i12 = gVar.f75431c.get(i11).f75385b;
            if (i12 == 1 || i12 == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean P(rh.g gVar) {
        for (int i11 = 0; i11 < gVar.f75431c.size(); i11++) {
            qh.e eVarK = gVar.f75431c.get(i11).f75386c.get(0).k();
            if (eVarK == null || eVarK.g()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        b0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        Uri uri;
        this.E.removeCallbacks(this.f33821w);
        if (this.B.h()) {
            return;
        }
        if (this.B.i()) {
            this.J = true;
            return;
        }
        synchronized (this.f33819u) {
            uri = this.G;
        }
        this.J = false;
        g0(new b0(this.A, uri, 4, this.f33817s), this.f33818t, this.f33813o.a(4));
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable k0 k0Var) {
        this.C = k0Var;
        this.f33812n.prepare();
        this.f33812n.b(Looper.myLooper(), z());
        if (this.f33808j) {
            b0(false);
            return;
        }
        this.A = this.f33809k.createDataSource();
        this.B = new Loader("DashMediaSource");
        this.E = o0.w();
        h0();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
        this.J = false;
        this.A = null;
        Loader loader = this.B;
        if (loader != null) {
            loader.k();
            this.B = null;
        }
        this.K = 0L;
        this.L = 0L;
        this.I = this.f33808j ? this.I : null;
        this.G = this.H;
        this.D = null;
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.E = null;
        }
        this.M = C.TIME_UNSET;
        this.N = 0;
        this.O = C.TIME_UNSET;
        this.P = 0;
        this.f33820v.clear();
        this.f33814p.i();
        this.f33812n.release();
    }

    public final long N() {
        return Math.min((this.N - 1) * 1000, 5000);
    }

    public final void R() {
        f0.j(this.B, new a());
    }

    public void S(long j11) {
        long j12 = this.O;
        if (j12 == C.TIME_UNSET || j12 < j11) {
            this.O = j11;
        }
    }

    public void T() {
        this.E.removeCallbacks(this.f33822x);
        h0();
    }

    public void U(b0<?> b0Var, long j11, long j12) {
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f33813o.b(b0Var.f35256a);
        this.f33816r.q(nVar, b0Var.f35258c);
    }

    public void V(b0<rh.c> b0Var, long j11, long j12) {
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f33813o.b(b0Var.f35256a);
        this.f33816r.t(nVar, b0Var.f35258c);
        rh.c cVarC = b0Var.c();
        rh.c cVar = this.I;
        int iD = cVar == null ? 0 : cVar.d();
        long j13 = cVarC.c(0).f75430b;
        int i11 = 0;
        while (i11 < iD && this.I.c(i11).f75430b < j13) {
            i11++;
        }
        if (cVarC.f75397d) {
            if (iD - i11 > cVarC.d()) {
                s.i("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j14 = this.O;
                if (j14 == C.TIME_UNSET || cVarC.f75401h * 1000 > j14) {
                    this.N = 0;
                } else {
                    s.i("DashMediaSource", "Loaded stale dynamic manifest: " + cVarC.f75401h + ", " + this.O);
                }
            }
            int i12 = this.N;
            this.N = i12 + 1;
            if (i12 < this.f33813o.a(b0Var.f35258c)) {
                f0(N());
                return;
            } else {
                this.D = new DashManifestStaleException();
                return;
            }
        }
        this.I = cVarC;
        this.J = cVarC.f75397d & this.J;
        this.K = j11 - j12;
        this.L = j11;
        synchronized (this.f33819u) {
            try {
                if (b0Var.f35257b.f35422a == this.G) {
                    Uri uriD = this.I.f75404k;
                    if (uriD == null) {
                        uriD = b0Var.d();
                    }
                    this.G = uriD;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (iD != 0) {
            this.P += i11;
            b0(true);
            return;
        }
        rh.c cVar2 = this.I;
        if (!cVar2.f75397d) {
            b0(true);
            return;
        }
        o oVar = cVar2.f75402i;
        if (oVar != null) {
            c0(oVar);
        } else {
            R();
        }
    }

    public Loader.c W(b0<rh.c> b0Var, long j11, long j12, IOException iOException, int i11) {
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        long jC = this.f33813o.c(new z.c(nVar, new nh.o(b0Var.f35258c), iOException, i11));
        Loader.c cVarG = jC == C.TIME_UNSET ? Loader.f35232g : Loader.g(false, jC);
        boolean z11 = !cVarG.c();
        this.f33816r.x(nVar, b0Var.f35258c, iOException, z11);
        if (z11) {
            this.f33813o.b(b0Var.f35256a);
        }
        return cVarG;
    }

    public void X(b0<Long> b0Var, long j11, long j12) {
        n nVar = new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f33813o.b(b0Var.f35256a);
        this.f33816r.t(nVar, b0Var.f35258c);
        a0(b0Var.c().longValue() - j11);
    }

    public Loader.c Y(b0<Long> b0Var, long j11, long j12, IOException iOException) {
        this.f33816r.x(new n(b0Var.f35256a, b0Var.f35257b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a()), b0Var.f35258c, iOException, true);
        this.f33813o.b(b0Var.f35256a);
        Z(iOException);
        return Loader.f35231f;
    }

    public final void Z(IOException iOException) {
        s.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        b0(true);
    }

    @Override // com.google.android.exoplayer2.source.i
    public u1 a() {
        return this.f33807i;
    }

    public final void a0(long j11) {
        this.M = j11;
        b0(true);
    }

    public final void b0(boolean z11) {
        long j11;
        long j12;
        for (int i11 = 0; i11 < this.f33820v.size(); i11++) {
            int iKeyAt = this.f33820v.keyAt(i11);
            if (iKeyAt >= this.P) {
                this.f33820v.valueAt(i11).B(this.I, iKeyAt - this.P);
            }
        }
        rh.g gVarC = this.I.c(0);
        int iD = this.I.d() - 1;
        rh.g gVarC2 = this.I.c(iD);
        long jF = this.I.f(iD);
        long jC0 = o0.C0(o0.b0(this.M));
        long jL = L(gVarC, this.I.f(0), jC0);
        long jK = K(gVarC2, jF, jC0);
        boolean z12 = this.I.f75397d && !P(gVarC2);
        if (z12) {
            long j13 = this.I.f75399f;
            if (j13 != C.TIME_UNSET) {
                jL = Math.max(jL, jK - o0.C0(j13));
            }
        }
        long j14 = jK - jL;
        rh.c cVar = this.I;
        if (cVar.f75397d) {
            com.google.android.exoplayer2.util.a.g(cVar.f75394a != C.TIME_UNSET);
            long jC1 = (jC0 - o0.C0(this.I.f75394a)) - jL;
            i0(jC1, j14);
            long jF1 = this.I.f75394a + o0.f1(jL);
            long jC2 = jC1 - o0.C0(this.F.f34829a);
            long jMin = Math.min(5000000L, j14 / 2);
            j11 = jF1;
            j12 = jC2 < jMin ? jMin : jC2;
        } else {
            j11 = C.TIME_UNSET;
            j12 = 0;
        }
        long jC3 = jL - o0.C0(gVarC.f75430b);
        rh.c cVar2 = this.I;
        C(new b(cVar2.f75394a, j11, this.M, this.P, jC3, j14, j12, cVar2, this.f33807i, cVar2.f75397d ? this.F : null));
        if (this.f33808j) {
            return;
        }
        this.E.removeCallbacks(this.f33822x);
        if (z12) {
            this.E.postDelayed(this.f33822x, M(this.I, o0.b0(this.M)));
        }
        if (this.J) {
            h0();
            return;
        }
        if (z11) {
            rh.c cVar3 = this.I;
            if (cVar3.f75397d) {
                long j15 = cVar3.f75398e;
                if (j15 != C.TIME_UNSET) {
                    if (j15 == 0) {
                        j15 = 5000;
                    }
                    f0(Math.max(0L, (this.K + j15) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    public final void c0(o oVar) {
        String str = oVar.f75484a;
        if (o0.c(str, "urn:mpeg:dash:utc:direct:2014") || o0.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            d0(oVar);
            return;
        }
        if (o0.c(str, "urn:mpeg:dash:utc:http-iso:2014") || o0.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            e0(oVar, new d());
            return;
        }
        if (o0.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") || o0.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            e0(oVar, new h(null));
        } else if (o0.c(str, "urn:mpeg:dash:utc:ntp:2014") || o0.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
            R();
        } else {
            Z(new IOException("Unsupported UTC timing scheme"));
        }
    }

    public final void d0(o oVar) {
        try {
            a0(o0.J0(oVar.f75485b) - this.L);
        } catch (ParserException e11) {
            Z(e11);
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public com.google.android.exoplayer2.source.h e(i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        int iIntValue = ((Integer) bVar.f71960a).intValue() - this.P;
        j.a aVarW = w(bVar, this.I.c(iIntValue).f75430b);
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(iIntValue + this.P, this.I, this.f33814p, iIntValue, this.f33810l, this.C, this.f33812n, t(bVar), this.f33813o, aVarW, this.M, this.f33824z, bVar2, this.f33811m, this.f33823y, z());
        this.f33820v.put(bVar3.f33849a, bVar3);
        return bVar3;
    }

    public final void e0(o oVar, b0.a<Long> aVar) {
        g0(new b0(this.A, Uri.parse(oVar.f75485b), 5, aVar), new g(this, null), 1);
    }

    public final void f0(long j11) {
        this.E.postDelayed(this.f33821w, j11);
    }

    public final <T> void g0(b0<T> b0Var, Loader.b<b0<T>> bVar, int i11) {
        this.f33816r.z(new n(b0Var.f35256a, b0Var.f35257b, this.B.m(b0Var, bVar, i11)), b0Var.f35258c);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    /* JADX WARN: Code duplicated, block: B:19:0x0046  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056  */
    /* JADX WARN: Code duplicated, block: B:23:0x005b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0061  */
    /* JADX WARN: Code duplicated, block: B:27:0x0067  */
    /* JADX WARN: Code duplicated, block: B:30:0x006f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0079  */
    /* JADX WARN: Code duplicated, block: B:36:0x007f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x0087  */
    /* JADX WARN: Code duplicated, block: B:42:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x0099  */
    /* JADX WARN: Code duplicated, block: B:52:0x00be  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00da  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e1  */
    public final void i0(long j11, long j12) {
        long j13;
        long jMin;
        long jF1;
        long j14;
        long jR;
        long j15;
        l lVar;
        long j16;
        long jR2;
        float f11;
        float f12;
        l lVar2;
        l lVar3;
        l lVar4;
        rh.c cVar;
        l lVar5;
        long j17;
        long jF2 = o0.f1(j11);
        long j18 = this.f33807i.f34778d.f34831c;
        if (j18 == C.TIME_UNSET) {
            l lVar6 = this.I.f75403j;
            if (lVar6 != null) {
                long j19 = lVar6.f75476c;
                if (j19 != C.TIME_UNSET) {
                    jMin = Math.min(jF2, j19);
                }
                jF1 = o0.f1(j11 - j12);
                if (jF1 < 0 && j13 > 0) {
                    jF1 = 0;
                }
                j14 = this.I.f75396c;
                if (j14 != C.TIME_UNSET) {
                    jF1 = Math.min(jF1 + j14, jF2);
                }
                jR = jF1;
                j15 = this.f33807i.f34778d.f34830b;
                if (j15 != C.TIME_UNSET) {
                    jR = o0.r(j15, jR, jF2);
                } else {
                    lVar = this.I.f75403j;
                    if (lVar != null) {
                        j16 = lVar.f75475b;
                        if (j16 != C.TIME_UNSET) {
                            jR = o0.r(j16, jR, jF2);
                        }
                    }
                }
                if (jR > j13) {
                    j13 = jR;
                }
                jR2 = this.F.f34829a;
                if (jR2 == C.TIME_UNSET) {
                    cVar = this.I;
                    lVar5 = cVar.f75403j;
                    if (lVar5 != null) {
                        j17 = lVar5.f75474a;
                        if (j17 != C.TIME_UNSET) {
                            jR2 = j17;
                        } else {
                            jR2 = cVar.f75400g;
                            if (jR2 == C.TIME_UNSET) {
                                jR2 = this.f33815q;
                            }
                        }
                    } else {
                        jR2 = cVar.f75400g;
                        if (jR2 == C.TIME_UNSET) {
                            jR2 = this.f33815q;
                        }
                    }
                }
                if (jR2 < jR) {
                    jR2 = jR;
                }
                if (jR2 > j13) {
                    jR2 = o0.r(o0.f1(j11 - Math.min(5000000L, j12 / 2)), jR, j13);
                }
                u1.g gVar = this.f33807i.f34778d;
                f11 = gVar.f34832d;
                if (f11 == -3.4028235E38f) {
                    lVar4 = this.I.f75403j;
                    if (lVar4 != null) {
                        f11 = lVar4.f75477d;
                    } else {
                        f11 = -3.4028235E38f;
                    }
                }
                f12 = gVar.f34833f;
                if (f12 == -3.4028235E38f) {
                    lVar3 = this.I.f75403j;
                    if (lVar3 != null) {
                        f12 = lVar3.f75478e;
                    } else {
                        f12 = -3.4028235E38f;
                    }
                }
                if (f11 == -3.4028235E38f && f12 == -3.4028235E38f && ((lVar2 = this.I.f75403j) == null || lVar2.f75474a == C.TIME_UNSET)) {
                    f11 = 1.0f;
                    f12 = 1.0f;
                }
                this.F = new u1.g.a().k(jR2).i(jR).g(j13).j(f11).h(f12).f();
            }
            j13 = jF2;
            jF1 = o0.f1(j11 - j12);
            if (jF1 < 0) {
                jF1 = 0;
            }
            j14 = this.I.f75396c;
            if (j14 != C.TIME_UNSET) {
                jF1 = Math.min(jF1 + j14, jF2);
            }
            jR = jF1;
            j15 = this.f33807i.f34778d.f34830b;
            if (j15 != C.TIME_UNSET) {
                jR = o0.r(j15, jR, jF2);
            } else {
                lVar = this.I.f75403j;
                if (lVar != null) {
                    j16 = lVar.f75475b;
                    if (j16 != C.TIME_UNSET) {
                        jR = o0.r(j16, jR, jF2);
                    }
                }
            }
            if (jR > j13) {
                j13 = jR;
            }
            jR2 = this.F.f34829a;
            if (jR2 == C.TIME_UNSET) {
                cVar = this.I;
                lVar5 = cVar.f75403j;
                if (lVar5 != null) {
                    j17 = lVar5.f75474a;
                    if (j17 != C.TIME_UNSET) {
                        jR2 = j17;
                    } else {
                        jR2 = cVar.f75400g;
                        if (jR2 == C.TIME_UNSET) {
                            jR2 = this.f33815q;
                        }
                    }
                } else {
                    jR2 = cVar.f75400g;
                    if (jR2 == C.TIME_UNSET) {
                        jR2 = this.f33815q;
                    }
                }
            }
            if (jR2 < jR) {
                jR2 = jR;
            }
            if (jR2 > j13) {
                jR2 = o0.r(o0.f1(j11 - Math.min(5000000L, j12 / 2)), jR, j13);
            }
            u1.g gVar2 = this.f33807i.f34778d;
            f11 = gVar2.f34832d;
            if (f11 == -3.4028235E38f) {
                lVar4 = this.I.f75403j;
                if (lVar4 != null) {
                    f11 = lVar4.f75477d;
                } else {
                    f11 = -3.4028235E38f;
                }
            }
            f12 = gVar2.f34833f;
            if (f12 == -3.4028235E38f) {
                lVar3 = this.I.f75403j;
                if (lVar3 != null) {
                    f12 = lVar3.f75478e;
                } else {
                    f12 = -3.4028235E38f;
                }
            }
            if (f11 == -3.4028235E38f) {
                f11 = 1.0f;
                f12 = 1.0f;
            }
            this.F = new u1.g.a().k(jR2).i(jR).g(j13).j(f11).h(f12).f();
        }
        jMin = Math.min(jF2, j18);
        j13 = jMin;
        jF1 = o0.f1(j11 - j12);
        if (jF1 < 0) {
            jF1 = 0;
        }
        j14 = this.I.f75396c;
        if (j14 != C.TIME_UNSET) {
            jF1 = Math.min(jF1 + j14, jF2);
        }
        jR = jF1;
        j15 = this.f33807i.f34778d.f34830b;
        if (j15 != C.TIME_UNSET) {
            jR = o0.r(j15, jR, jF2);
        } else {
            lVar = this.I.f75403j;
            if (lVar != null) {
                j16 = lVar.f75475b;
                if (j16 != C.TIME_UNSET) {
                    jR = o0.r(j16, jR, jF2);
                }
            }
        }
        if (jR > j13) {
            j13 = jR;
        }
        jR2 = this.F.f34829a;
        if (jR2 == C.TIME_UNSET) {
            cVar = this.I;
            lVar5 = cVar.f75403j;
            if (lVar5 != null) {
                j17 = lVar5.f75474a;
                if (j17 != C.TIME_UNSET) {
                    jR2 = j17;
                } else {
                    jR2 = cVar.f75400g;
                    if (jR2 == C.TIME_UNSET) {
                        jR2 = this.f33815q;
                    }
                }
            } else {
                jR2 = cVar.f75400g;
                if (jR2 == C.TIME_UNSET) {
                    jR2 = this.f33815q;
                }
            }
        }
        if (jR2 < jR) {
            jR2 = jR;
        }
        if (jR2 > j13) {
            jR2 = o0.r(o0.f1(j11 - Math.min(5000000L, j12 / 2)), jR, j13);
        }
        u1.g gVar3 = this.f33807i.f34778d;
        f11 = gVar3.f34832d;
        if (f11 == -3.4028235E38f) {
            lVar4 = this.I.f75403j;
            if (lVar4 != null) {
                f11 = lVar4.f75477d;
            } else {
                f11 = -3.4028235E38f;
            }
        }
        f12 = gVar3.f34833f;
        if (f12 == -3.4028235E38f) {
            lVar3 = this.I.f75403j;
            if (lVar3 != null) {
                f12 = lVar3.f75478e;
            } else {
                f12 = -3.4028235E38f;
            }
        }
        if (f11 == -3.4028235E38f) {
            f11 = 1.0f;
            f12 = 1.0f;
        }
        this.F = new u1.g.a().k(jR2).i(jR).g(j13).j(f11).h(f12).f();
    }

    @Override // com.google.android.exoplayer2.source.i
    public void k(com.google.android.exoplayer2.source.h hVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) hVar;
        bVar.x();
        this.f33820v.remove(bVar.f33849a);
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f33824z.maybeThrowError();
    }
}
