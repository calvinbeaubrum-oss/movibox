package androidx.media3.exoplayer.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.upstream.k;
import androidx.media3.exoplayer.upstream.m;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.g1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.x3;
import i4.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(18)
public class DefaultDrmSessionManager implements androidx.media3.exoplayer.drm.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UUID f10240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.g.c f10241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f10242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, String> f10243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f10245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f10246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f10247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m f10248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f10249l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f10250m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<DefaultDrmSession> f10251n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Set<e> f10252o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set<DefaultDrmSession> f10253p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10254q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public androidx.media3.exoplayer.drm.g f10255r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public DefaultDrmSession f10256s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public DefaultDrmSession f10257t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Looper f10258u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Handler f10259v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10260w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public byte[] f10261x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public x3 f10262y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public volatile d f10263z;

    /* JADX INFO: compiled from: source.java */
    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10267d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, String> f10264a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public UUID f10265b = androidx.media3.common.j.f9254d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.media3.exoplayer.drm.g.c f10266c = h.f10301d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f10268e = new int[0];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f10269f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public m f10270g = new k();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f10271h = 300000;

        public DefaultDrmSessionManager a(j jVar) {
            return new DefaultDrmSessionManager(this.f10265b, this.f10266c, jVar, this.f10264a, this.f10267d, this.f10268e, this.f10269f, this.f10270g, this.f10271h);
        }

        public b b(boolean z11) {
            this.f10267d = z11;
            return this;
        }

        public b c(boolean z11) {
            this.f10269f = z11;
            return this;
        }

        public b d(int... iArr) {
            for (int i11 : iArr) {
                boolean z11 = true;
                if (i11 != 2 && i11 != 1) {
                    z11 = false;
                }
                z3.a.a(z11);
            }
            this.f10268e = (int[]) iArr.clone();
            return this;
        }

        public b e(UUID uuid, androidx.media3.exoplayer.drm.g.c cVar) {
            this.f10265b = (UUID) z3.a.e(uuid);
            this.f10266c = (androidx.media3.exoplayer.drm.g.c) z3.a.e(cVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements androidx.media3.exoplayer.drm.g.b {
        public c() {
        }

        @Override // androidx.media3.exoplayer.drm.g.b
        public void a(androidx.media3.exoplayer.drm.g gVar, @Nullable byte[] bArr, int i11, int i12, @Nullable byte[] bArr2) {
            ((d) z3.a.e(DefaultDrmSessionManager.this.f10263z)).obtainMessage(i11, bArr).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @SuppressLint({"HandlerLeak"})
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f10251n) {
                if (defaultDrmSession.r(bArr)) {
                    defaultDrmSession.z(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements androidx.media3.exoplayer.drm.c.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final androidx.media3.exoplayer.drm.b.a f10274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public DrmSession f10275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10276d;

        public e(androidx.media3.exoplayer.drm.b.a aVar) {
            this.f10274b = aVar;
        }

        public void c(final y yVar) {
            ((Handler) z3.a.e(DefaultDrmSessionManager.this.f10259v)).post(new Runnable() { // from class: i4.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f67122a.d(yVar);
                }
            });
        }

        public final /* synthetic */ void d(y yVar) {
            if (DefaultDrmSessionManager.this.f10254q == 0 || this.f10276d) {
                return;
            }
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            this.f10275c = defaultDrmSessionManager.s((Looper) z3.a.e(defaultDrmSessionManager.f10258u), this.f10274b, yVar, false);
            DefaultDrmSessionManager.this.f10252o.add(this);
        }

        public final /* synthetic */ void e() {
            if (this.f10276d) {
                return;
            }
            DrmSession drmSession = this.f10275c;
            if (drmSession != null) {
                drmSession.f(this.f10274b);
            }
            DefaultDrmSessionManager.this.f10252o.remove(this);
            this.f10276d = true;
        }

        @Override // androidx.media3.exoplayer.drm.c.b
        public void release() {
            u0.b1((Handler) z3.a.e(DefaultDrmSessionManager.this.f10259v), new Runnable() { // from class: i4.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f67121a.e();
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements DefaultDrmSession.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<DefaultDrmSession> f10278a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public DefaultDrmSession f10279b;

        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.a
        public void a(Exception exc, boolean z11) {
            this.f10279b = null;
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f10278a);
            this.f10278a.clear();
            g1 it = immutableListCopyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).B(exc, z11);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.a
        public void b(DefaultDrmSession defaultDrmSession) {
            this.f10278a.add(defaultDrmSession);
            if (this.f10279b != null) {
                return;
            }
            this.f10279b = defaultDrmSession;
            defaultDrmSession.F();
        }

        public void c(DefaultDrmSession defaultDrmSession) {
            this.f10278a.remove(defaultDrmSession);
            if (this.f10279b == defaultDrmSession) {
                this.f10279b = null;
                if (this.f10278a.isEmpty()) {
                    return;
                }
                DefaultDrmSession next = this.f10278a.iterator().next();
                this.f10279b = next;
                next.F();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.a
        public void onProvisionCompleted() {
            this.f10279b = null;
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f10278a);
            this.f10278a.clear();
            g1 it = immutableListCopyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).A();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements DefaultDrmSession.b {
        public g() {
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.b
        public void a(DefaultDrmSession defaultDrmSession, int i11) {
            if (DefaultDrmSessionManager.this.f10250m != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.f10253p.remove(defaultDrmSession);
                ((Handler) z3.a.e(DefaultDrmSessionManager.this.f10259v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.b
        public void b(final DefaultDrmSession defaultDrmSession, int i11) {
            if (i11 == 1 && DefaultDrmSessionManager.this.f10254q > 0 && DefaultDrmSessionManager.this.f10250m != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.f10253p.add(defaultDrmSession);
                ((Handler) z3.a.e(DefaultDrmSessionManager.this.f10259v)).postAtTime(new Runnable() { // from class: i4.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        defaultDrmSession.f(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f10250m);
            } else if (i11 == 0) {
                DefaultDrmSessionManager.this.f10251n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f10256s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f10256s = null;
                }
                if (DefaultDrmSessionManager.this.f10257t == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f10257t = null;
                }
                DefaultDrmSessionManager.this.f10247j.c(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f10250m != C.TIME_UNSET) {
                    ((Handler) z3.a.e(DefaultDrmSessionManager.this.f10259v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f10253p.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.B();
        }
    }

    public DefaultDrmSessionManager(UUID uuid, androidx.media3.exoplayer.drm.g.c cVar, j jVar, HashMap<String, String> map, boolean z11, int[] iArr, boolean z12, m mVar, long j11) {
        z3.a.e(uuid);
        z3.a.b(!androidx.media3.common.j.f9252b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f10240c = uuid;
        this.f10241d = cVar;
        this.f10242e = jVar;
        this.f10243f = map;
        this.f10244g = z11;
        this.f10245h = iArr;
        this.f10246i = z12;
        this.f10248k = mVar;
        this.f10247j = new f();
        this.f10249l = new g();
        this.f10260w = 0;
        this.f10251n = new ArrayList();
        this.f10252o = Sets.h();
        this.f10253p = Sets.h();
        this.f10250m = j11;
    }

    public static boolean t(DrmSession drmSession) {
        if (drmSession.getState() != 1) {
            return false;
        }
        Throwable cause = ((DrmSession.DrmSessionException) z3.a.e(drmSession.getError())).getCause();
        return u0.f81838a < 19 || (cause instanceof ResourceBusyException) || androidx.media3.exoplayer.drm.d.c(cause);
    }

    public static List<DrmInitData.SchemeData> x(DrmInitData drmInitData, UUID uuid, boolean z11) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i11 = 0; i11 < drmInitData.schemeDataCount; i11++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i11);
            if ((schemeData.matches(uuid) || (androidx.media3.common.j.f9253c.equals(uuid) && schemeData.matches(androidx.media3.common.j.f9252b))) && (schemeData.data != null || z11)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    public final void A(Looper looper) {
        if (this.f10263z == null) {
            this.f10263z = new d(looper);
        }
    }

    public final void B() {
        if (this.f10255r != null && this.f10254q == 0 && this.f10251n.isEmpty() && this.f10252o.isEmpty()) {
            ((androidx.media3.exoplayer.drm.g) z3.a.e(this.f10255r)).release();
            this.f10255r = null;
        }
    }

    public final void C() {
        g1 it = ImmutableSet.copyOf((Collection) this.f10253p).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).f(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D() {
        g1 it = ImmutableSet.copyOf((Collection) this.f10252o).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
    }

    public void E(int i11, @Nullable byte[] bArr) {
        z3.a.g(this.f10251n.isEmpty());
        if (i11 == 1 || i11 == 3) {
            z3.a.e(bArr);
        }
        this.f10260w = i11;
        this.f10261x = bArr;
    }

    public final void F(DrmSession drmSession, @Nullable androidx.media3.exoplayer.drm.b.a aVar) {
        drmSession.f(aVar);
        if (this.f10250m != C.TIME_UNSET) {
            drmSession.f(null);
        }
    }

    public final void G(boolean z11) {
        if (z11 && this.f10258u == null) {
            o.i("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        if (Thread.currentThread() != ((Looper) z3.a.e(this.f10258u)).getThread()) {
            o.i("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f10258u.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // androidx.media3.exoplayer.drm.c
    public void a(Looper looper, x3 x3Var) {
        y(looper);
        this.f10262y = x3Var;
    }

    @Override // androidx.media3.exoplayer.drm.c
    @Nullable
    public DrmSession b(@Nullable androidx.media3.exoplayer.drm.b.a aVar, y yVar) {
        G(false);
        z3.a.g(this.f10254q > 0);
        z3.a.i(this.f10258u);
        return s(this.f10258u, aVar, yVar, true);
    }

    @Override // androidx.media3.exoplayer.drm.c
    public int c(y yVar) {
        G(false);
        int iA = ((androidx.media3.exoplayer.drm.g) z3.a.e(this.f10255r)).a();
        DrmInitData drmInitData = yVar.f9504p;
        if (drmInitData != null) {
            if (u(drmInitData)) {
                return iA;
            }
            return 1;
        }
        if (u0.P0(this.f10245h, f0.k(yVar.f9501m)) != -1) {
            return iA;
        }
        return 0;
    }

    @Override // androidx.media3.exoplayer.drm.c
    public androidx.media3.exoplayer.drm.c.b d(@Nullable androidx.media3.exoplayer.drm.b.a aVar, y yVar) {
        z3.a.g(this.f10254q > 0);
        z3.a.i(this.f10258u);
        e eVar = new e(aVar);
        eVar.c(yVar);
        return eVar;
    }

    @Override // androidx.media3.exoplayer.drm.c
    public final void prepare() {
        G(true);
        int i11 = this.f10254q;
        this.f10254q = i11 + 1;
        if (i11 != 0) {
            return;
        }
        if (this.f10255r == null) {
            androidx.media3.exoplayer.drm.g gVarA = this.f10241d.a(this.f10240c);
            this.f10255r = gVarA;
            gVarA.f(new c());
        } else if (this.f10250m != C.TIME_UNSET) {
            for (int i12 = 0; i12 < this.f10251n.size(); i12++) {
                this.f10251n.get(i12).e(null);
            }
        }
    }

    @Override // androidx.media3.exoplayer.drm.c
    public final void release() {
        G(true);
        int i11 = this.f10254q - 1;
        this.f10254q = i11;
        if (i11 != 0) {
            return;
        }
        if (this.f10250m != C.TIME_UNSET) {
            ArrayList arrayList = new ArrayList(this.f10251n);
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                ((DefaultDrmSession) arrayList.get(i12)).f(null);
            }
        }
        D();
        B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Nullable
    public final DrmSession s(Looper looper, @Nullable androidx.media3.exoplayer.drm.b.a aVar, y yVar, boolean z11) {
        List<DrmInitData.SchemeData> listX;
        A(looper);
        DrmInitData drmInitData = yVar.f9504p;
        if (drmInitData == null) {
            return z(f0.k(yVar.f9501m), z11);
        }
        DefaultDrmSession defaultDrmSessionW = null;
        Object[] objArr = 0;
        if (this.f10261x == null) {
            listX = x((DrmInitData) z3.a.e(drmInitData), this.f10240c, false);
            if (listX.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f10240c);
                o.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.l(missingSchemeDataException);
                }
                return new androidx.media3.exoplayer.drm.f(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            listX = null;
        }
        if (this.f10244g) {
            for (DefaultDrmSession defaultDrmSession : this.f10251n) {
                if (u0.c(defaultDrmSession.f10207a, listX)) {
                    defaultDrmSessionW = defaultDrmSession;
                    break;
                }
            }
        } else {
            defaultDrmSessionW = this.f10257t;
        }
        if (defaultDrmSessionW == null) {
            defaultDrmSessionW = w(listX, false, aVar, z11);
            if (!this.f10244g) {
                this.f10257t = defaultDrmSessionW;
            }
            this.f10251n.add(defaultDrmSessionW);
        } else {
            defaultDrmSessionW.e(aVar);
        }
        return defaultDrmSessionW;
    }

    public final boolean u(DrmInitData drmInitData) {
        if (this.f10261x != null) {
            return true;
        }
        if (x(drmInitData, this.f10240c, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(androidx.media3.common.j.f9252b)) {
                return false;
            }
            o.h("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f10240c);
        }
        String str = drmInitData.schemeType;
        if (str == null || C.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        if (C.CENC_TYPE_cbcs.equals(str)) {
            return u0.f81838a >= 25;
        }
        return (C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str)) ? false : true;
    }

    public final DefaultDrmSession v(@Nullable List<DrmInitData.SchemeData> list, boolean z11, @Nullable androidx.media3.exoplayer.drm.b.a aVar) {
        z3.a.e(this.f10255r);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f10240c, this.f10255r, this.f10247j, this.f10249l, list, this.f10260w, this.f10246i | z11, z11, this.f10261x, this.f10243f, this.f10242e, (Looper) z3.a.e(this.f10258u), this.f10248k, (x3) z3.a.e(this.f10262y));
        defaultDrmSession.e(aVar);
        if (this.f10250m != C.TIME_UNSET) {
            defaultDrmSession.e(null);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession w(@Nullable List<DrmInitData.SchemeData> list, boolean z11, @Nullable androidx.media3.exoplayer.drm.b.a aVar, boolean z12) {
        DefaultDrmSession defaultDrmSessionV = v(list, z11, aVar);
        if (t(defaultDrmSessionV) && !this.f10253p.isEmpty()) {
            C();
            F(defaultDrmSessionV, aVar);
            defaultDrmSessionV = v(list, z11, aVar);
        }
        if (!t(defaultDrmSessionV) || !z12 || this.f10252o.isEmpty()) {
            return defaultDrmSessionV;
        }
        D();
        if (!this.f10253p.isEmpty()) {
            C();
        }
        F(defaultDrmSessionV, aVar);
        return v(list, z11, aVar);
    }

    public final synchronized void y(Looper looper) {
        try {
            Looper looper2 = this.f10258u;
            if (looper2 == null) {
                this.f10258u = looper;
                this.f10259v = new Handler(looper);
            } else {
                z3.a.g(looper2 == looper);
                z3.a.e(this.f10259v);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Nullable
    public final DrmSession z(int i11, boolean z11) {
        androidx.media3.exoplayer.drm.g gVar = (androidx.media3.exoplayer.drm.g) z3.a.e(this.f10255r);
        if ((gVar.a() == 2 && w.f67139d) || u0.P0(this.f10245h, i11) == -1 || gVar.a() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f10256s;
        if (defaultDrmSession == null) {
            DefaultDrmSession defaultDrmSessionW = w(ImmutableList.of(), true, null, z11);
            this.f10251n.add(defaultDrmSessionW);
            this.f10256s = defaultDrmSessionW;
        } else {
            defaultDrmSession.e(null);
        }
        return this.f10256s;
    }
}
