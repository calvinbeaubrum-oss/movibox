package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.g1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(18)
public class DefaultDrmSessionManager implements com.google.android.exoplayer2.drm.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UUID f33119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.g.c f33120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f33121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, String> f33122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f33123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f33124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f33125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f33126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z f33127k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f33128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f33129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<DefaultDrmSession> f33130n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Set<e> f33131o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set<DefaultDrmSession> f33132p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f33133q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.drm.g f33134r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public DefaultDrmSession f33135s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public DefaultDrmSession f33136t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Looper f33137u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Handler f33138v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f33139w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public byte[] f33140x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public u1 f33141y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public volatile d f33142z;

    /* JADX INFO: compiled from: source.java */
    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33146d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f33148f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, String> f33143a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public UUID f33144b = com.google.android.exoplayer2.h.f33256d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.google.android.exoplayer2.drm.g.c f33145c = h.f33179d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public z f33149g = new v();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f33147e = new int[0];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f33150h = 300000;

        public DefaultDrmSessionManager a(j jVar) {
            return new DefaultDrmSessionManager(this.f33144b, this.f33145c, jVar, this.f33143a, this.f33146d, this.f33147e, this.f33148f, this.f33149g, this.f33150h);
        }

        public b b(boolean z11) {
            this.f33146d = z11;
            return this;
        }

        public b c(boolean z11) {
            this.f33148f = z11;
            return this;
        }

        public b d(int... iArr) {
            for (int i11 : iArr) {
                boolean z11 = true;
                if (i11 != 2 && i11 != 1) {
                    z11 = false;
                }
                com.google.android.exoplayer2.util.a.a(z11);
            }
            this.f33147e = (int[]) iArr.clone();
            return this;
        }

        public b e(UUID uuid, com.google.android.exoplayer2.drm.g.c cVar) {
            this.f33144b = (UUID) com.google.android.exoplayer2.util.a.e(uuid);
            this.f33145c = (com.google.android.exoplayer2.drm.g.c) com.google.android.exoplayer2.util.a.e(cVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements com.google.android.exoplayer2.drm.g.b {
        public c() {
        }

        @Override // com.google.android.exoplayer2.drm.g.b
        public void a(com.google.android.exoplayer2.drm.g gVar, @Nullable byte[] bArr, int i11, int i12, @Nullable byte[] bArr2) {
            ((d) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f33142z)).obtainMessage(i11, bArr).sendToTarget();
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
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f33130n) {
                if (defaultDrmSession.o(bArr)) {
                    defaultDrmSession.w(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements com.google.android.exoplayer2.drm.c.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final com.google.android.exoplayer2.drm.b.a f33153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public DrmSession f33154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33155d;

        public e(com.google.android.exoplayer2.drm.b.a aVar) {
            this.f33153b = aVar;
        }

        public void c(final m1 m1Var) {
            ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f33138v)).post(new Runnable() { // from class: sg.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f76332a.d(m1Var);
                }
            });
        }

        public final /* synthetic */ void d(m1 m1Var) {
            if (DefaultDrmSessionManager.this.f33133q == 0 || this.f33155d) {
                return;
            }
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            this.f33154c = defaultDrmSessionManager.s((Looper) com.google.android.exoplayer2.util.a.e(defaultDrmSessionManager.f33137u), this.f33153b, m1Var, false);
            DefaultDrmSessionManager.this.f33131o.add(this);
        }

        public final /* synthetic */ void e() {
            if (this.f33155d) {
                return;
            }
            DrmSession drmSession = this.f33154c;
            if (drmSession != null) {
                drmSession.f(this.f33153b);
            }
            DefaultDrmSessionManager.this.f33131o.remove(this);
            this.f33155d = true;
        }

        @Override // com.google.android.exoplayer2.drm.c.b
        public void release() {
            o0.L0((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f33138v), new Runnable() { // from class: sg.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f76331a.e();
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements DefaultDrmSession.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<DefaultDrmSession> f33157a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public DefaultDrmSession f33158b;

        public f(DefaultDrmSessionManager defaultDrmSessionManager) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void a(Exception exc, boolean z11) {
            this.f33158b = null;
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f33157a);
            this.f33157a.clear();
            g1 it = immutableListCopyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).y(exc, z11);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void b(DefaultDrmSession defaultDrmSession) {
            this.f33157a.add(defaultDrmSession);
            if (this.f33158b != null) {
                return;
            }
            this.f33158b = defaultDrmSession;
            defaultDrmSession.C();
        }

        public void c(DefaultDrmSession defaultDrmSession) {
            this.f33157a.remove(defaultDrmSession);
            if (this.f33158b == defaultDrmSession) {
                this.f33158b = null;
                if (this.f33157a.isEmpty()) {
                    return;
                }
                DefaultDrmSession next = this.f33157a.iterator().next();
                this.f33158b = next;
                next.C();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void onProvisionCompleted() {
            this.f33158b = null;
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f33157a);
            this.f33157a.clear();
            g1 it = immutableListCopyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).x();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements DefaultDrmSession.b {
        public g() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void a(DefaultDrmSession defaultDrmSession, int i11) {
            if (DefaultDrmSessionManager.this.f33129m != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.f33132p.remove(defaultDrmSession);
                ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f33138v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void b(final DefaultDrmSession defaultDrmSession, int i11) {
            if (i11 == 1 && DefaultDrmSessionManager.this.f33133q > 0 && DefaultDrmSessionManager.this.f33129m != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.f33132p.add(defaultDrmSession);
                ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f33138v)).postAtTime(new Runnable() { // from class: sg.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        defaultDrmSession.f(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f33129m);
            } else if (i11 == 0) {
                DefaultDrmSessionManager.this.f33130n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f33135s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f33135s = null;
                }
                if (DefaultDrmSessionManager.this.f33136t == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f33136t = null;
                }
                DefaultDrmSessionManager.this.f33126j.c(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f33129m != C.TIME_UNSET) {
                    ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f33138v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f33132p.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.B();
        }
    }

    public DefaultDrmSessionManager(UUID uuid, com.google.android.exoplayer2.drm.g.c cVar, j jVar, HashMap<String, String> map, boolean z11, int[] iArr, boolean z12, z zVar, long j11) {
        com.google.android.exoplayer2.util.a.e(uuid);
        com.google.android.exoplayer2.util.a.b(!com.google.android.exoplayer2.h.f33254b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f33119c = uuid;
        this.f33120d = cVar;
        this.f33121e = jVar;
        this.f33122f = map;
        this.f33123g = z11;
        this.f33124h = iArr;
        this.f33125i = z12;
        this.f33127k = zVar;
        this.f33126j = new f(this);
        this.f33128l = new g();
        this.f33139w = 0;
        this.f33130n = new ArrayList();
        this.f33131o = Sets.h();
        this.f33132p = Sets.h();
        this.f33129m = j11;
    }

    public static boolean t(DrmSession drmSession) {
        return drmSession.getState() == 1 && (o0.f35608a < 19 || (((DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(drmSession.getError())).getCause() instanceof ResourceBusyException));
    }

    public static List<DrmInitData.SchemeData> x(DrmInitData drmInitData, UUID uuid, boolean z11) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i11 = 0; i11 < drmInitData.schemeDataCount; i11++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i11);
            if ((schemeData.matches(uuid) || (com.google.android.exoplayer2.h.f33255c.equals(uuid) && schemeData.matches(com.google.android.exoplayer2.h.f33254b))) && (schemeData.data != null || z11)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    public final void A(Looper looper) {
        if (this.f33142z == null) {
            this.f33142z = new d(looper);
        }
    }

    public final void B() {
        if (this.f33134r != null && this.f33133q == 0 && this.f33130n.isEmpty() && this.f33131o.isEmpty()) {
            ((com.google.android.exoplayer2.drm.g) com.google.android.exoplayer2.util.a.e(this.f33134r)).release();
            this.f33134r = null;
        }
    }

    public final void C() {
        g1 it = ImmutableSet.copyOf((Collection) this.f33132p).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).f(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D() {
        g1 it = ImmutableSet.copyOf((Collection) this.f33131o).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
    }

    public void E(int i11, @Nullable byte[] bArr) {
        com.google.android.exoplayer2.util.a.g(this.f33130n.isEmpty());
        if (i11 == 1 || i11 == 3) {
            com.google.android.exoplayer2.util.a.e(bArr);
        }
        this.f33139w = i11;
        this.f33140x = bArr;
    }

    public final void F(DrmSession drmSession, @Nullable com.google.android.exoplayer2.drm.b.a aVar) {
        drmSession.f(aVar);
        if (this.f33129m != C.TIME_UNSET) {
            drmSession.f(null);
        }
    }

    @Override // com.google.android.exoplayer2.drm.c
    public int a(m1 m1Var) {
        int iA = ((com.google.android.exoplayer2.drm.g) com.google.android.exoplayer2.util.a.e(this.f33134r)).a();
        DrmInitData drmInitData = m1Var.f33448p;
        if (drmInitData != null) {
            if (u(drmInitData)) {
                return iA;
            }
            return 1;
        }
        if (o0.z0(this.f33124h, w.k(m1Var.f33445m)) != -1) {
            return iA;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.drm.c
    public void b(Looper looper, u1 u1Var) {
        y(looper);
        this.f33141y = u1Var;
    }

    @Override // com.google.android.exoplayer2.drm.c
    @Nullable
    public DrmSession c(@Nullable com.google.android.exoplayer2.drm.b.a aVar, m1 m1Var) {
        com.google.android.exoplayer2.util.a.g(this.f33133q > 0);
        com.google.android.exoplayer2.util.a.i(this.f33137u);
        return s(this.f33137u, aVar, m1Var, true);
    }

    @Override // com.google.android.exoplayer2.drm.c
    public com.google.android.exoplayer2.drm.c.b d(@Nullable com.google.android.exoplayer2.drm.b.a aVar, m1 m1Var) {
        com.google.android.exoplayer2.util.a.g(this.f33133q > 0);
        com.google.android.exoplayer2.util.a.i(this.f33137u);
        e eVar = new e(aVar);
        eVar.c(m1Var);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.drm.c
    public final void prepare() {
        int i11 = this.f33133q;
        this.f33133q = i11 + 1;
        if (i11 != 0) {
            return;
        }
        if (this.f33134r == null) {
            com.google.android.exoplayer2.drm.g gVarA = this.f33120d.a(this.f33119c);
            this.f33134r = gVarA;
            gVarA.e(new c());
        } else if (this.f33129m != C.TIME_UNSET) {
            for (int i12 = 0; i12 < this.f33130n.size(); i12++) {
                this.f33130n.get(i12).e(null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.c
    public final void release() {
        int i11 = this.f33133q - 1;
        this.f33133q = i11;
        if (i11 != 0) {
            return;
        }
        if (this.f33129m != C.TIME_UNSET) {
            ArrayList arrayList = new ArrayList(this.f33130n);
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
    public final DrmSession s(Looper looper, @Nullable com.google.android.exoplayer2.drm.b.a aVar, m1 m1Var, boolean z11) {
        List<DrmInitData.SchemeData> listX;
        A(looper);
        DrmInitData drmInitData = m1Var.f33448p;
        if (drmInitData == null) {
            return z(w.k(m1Var.f33445m), z11);
        }
        DefaultDrmSession defaultDrmSessionW = null;
        Object[] objArr = 0;
        if (this.f33140x == null) {
            listX = x((DrmInitData) com.google.android.exoplayer2.util.a.e(drmInitData), this.f33119c, false);
            if (listX.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f33119c);
                s.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.l(missingSchemeDataException);
                }
                return new com.google.android.exoplayer2.drm.f(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            listX = null;
        }
        if (this.f33123g) {
            for (DefaultDrmSession defaultDrmSession : this.f33130n) {
                if (o0.c(defaultDrmSession.f33087a, listX)) {
                    defaultDrmSessionW = defaultDrmSession;
                    break;
                }
            }
        } else {
            defaultDrmSessionW = this.f33136t;
        }
        if (defaultDrmSessionW == null) {
            defaultDrmSessionW = w(listX, false, aVar, z11);
            if (!this.f33123g) {
                this.f33136t = defaultDrmSessionW;
            }
            this.f33130n.add(defaultDrmSessionW);
        } else {
            defaultDrmSessionW.e(aVar);
        }
        return defaultDrmSessionW;
    }

    public final boolean u(DrmInitData drmInitData) {
        if (this.f33140x != null) {
            return true;
        }
        if (x(drmInitData, this.f33119c, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(com.google.android.exoplayer2.h.f33254b)) {
                return false;
            }
            s.i("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f33119c);
        }
        String str = drmInitData.schemeType;
        if (str == null || C.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        if (C.CENC_TYPE_cbcs.equals(str)) {
            return o0.f35608a >= 25;
        }
        return (C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str)) ? false : true;
    }

    public final DefaultDrmSession v(@Nullable List<DrmInitData.SchemeData> list, boolean z11, @Nullable com.google.android.exoplayer2.drm.b.a aVar) {
        com.google.android.exoplayer2.util.a.e(this.f33134r);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f33119c, this.f33134r, this.f33126j, this.f33128l, list, this.f33139w, this.f33125i | z11, z11, this.f33140x, this.f33122f, this.f33121e, (Looper) com.google.android.exoplayer2.util.a.e(this.f33137u), this.f33127k, (u1) com.google.android.exoplayer2.util.a.e(this.f33141y));
        defaultDrmSession.e(aVar);
        if (this.f33129m != C.TIME_UNSET) {
            defaultDrmSession.e(null);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession w(@Nullable List<DrmInitData.SchemeData> list, boolean z11, @Nullable com.google.android.exoplayer2.drm.b.a aVar, boolean z12) {
        DefaultDrmSession defaultDrmSessionV = v(list, z11, aVar);
        if (t(defaultDrmSessionV) && !this.f33132p.isEmpty()) {
            C();
            F(defaultDrmSessionV, aVar);
            defaultDrmSessionV = v(list, z11, aVar);
        }
        if (!t(defaultDrmSessionV) || !z12 || this.f33131o.isEmpty()) {
            return defaultDrmSessionV;
        }
        D();
        if (!this.f33132p.isEmpty()) {
            C();
        }
        F(defaultDrmSessionV, aVar);
        return v(list, z11, aVar);
    }

    public final synchronized void y(Looper looper) {
        try {
            Looper looper2 = this.f33137u;
            if (looper2 == null) {
                this.f33137u = looper;
                this.f33138v = new Handler(looper);
            } else {
                com.google.android.exoplayer2.util.a.g(looper2 == looper);
                com.google.android.exoplayer2.util.a.e(this.f33138v);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Nullable
    public final DrmSession z(int i11, boolean z11) {
        com.google.android.exoplayer2.drm.g gVar = (com.google.android.exoplayer2.drm.g) com.google.android.exoplayer2.util.a.e(this.f33134r);
        if ((gVar.a() == 2 && sg.w.f76349d) || o0.z0(this.f33124h, i11) == -1 || gVar.a() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f33135s;
        if (defaultDrmSession == null) {
            DefaultDrmSession defaultDrmSessionW = w(ImmutableList.of(), true, null, z11);
            this.f33130n.add(defaultDrmSessionW);
            this.f33135s = defaultDrmSessionW;
        } else {
            defaultDrmSession.e(null);
        }
        return this.f33135s;
    }
}
