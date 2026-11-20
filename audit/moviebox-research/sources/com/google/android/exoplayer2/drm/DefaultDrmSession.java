package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import nh.n;
import nh.o;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(18)
public class DefaultDrmSession implements DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final List<DrmInitData.SchemeData> f33087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f33088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f33089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f33090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f33093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, String> f33094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.j<com.google.android.exoplayer2.drm.b.a> f33095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z f33096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u1 f33097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j f33098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final UUID f33099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f33100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f33101o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f33102p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public HandlerThread f33103q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public c f33104r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.decoder.b f33105s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public DrmSession.DrmSessionException f33106t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public byte[] f33107u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f33108v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public g.a f33109w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public g.d f33110x;

    /* JADX INFO: compiled from: source.java */
    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th2) {
            super(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Exception exc, boolean z11);

        void b(DefaultDrmSession defaultDrmSession);

        void onProvisionCompleted();
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(DefaultDrmSession defaultDrmSession, int i11);

        void b(DefaultDrmSession defaultDrmSession, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f33111a;

        public c(Looper looper) {
            super(looper);
        }

        public final boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            d dVar = (d) message.obj;
            if (!dVar.f33114b) {
                return false;
            }
            int i11 = dVar.f33117e + 1;
            dVar.f33117e = i11;
            if (i11 > DefaultDrmSession.this.f33096j.a(3)) {
                return false;
            }
            long jC = DefaultDrmSession.this.f33096j.c(new z.c(new n(dVar.f33113a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f33115c, mediaDrmCallbackException.bytesLoaded), new o(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), dVar.f33117e));
            if (jC == C.TIME_UNSET) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.f33111a) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), jC);
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void b(int i11, Object obj, boolean z11) {
            obtainMessage(i11, new d(n.a(), z11, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f33111a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objA;
            d dVar = (d) message.obj;
            try {
                int i11 = message.what;
                if (i11 == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    objA = defaultDrmSession.f33098l.a(defaultDrmSession.f33099m, (g.d) dVar.f33116d);
                } else {
                    if (i11 != 1) {
                        throw new RuntimeException();
                    }
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    objA = defaultDrmSession2.f33098l.b(defaultDrmSession2.f33099m, (g.a) dVar.f33116d);
                }
            } catch (MediaDrmCallbackException e11) {
                boolean zA = a(message, e11);
                objA = e11;
                if (zA) {
                    return;
                }
            } catch (Exception e12) {
                s.j("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e12);
                objA = e12;
            }
            DefaultDrmSession.this.f33096j.b(dVar.f33113a);
            synchronized (this) {
                try {
                    if (!this.f33111a) {
                        DefaultDrmSession.this.f33100n.obtainMessage(message.what, Pair.create(dVar.f33116d, objA)).sendToTarget();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f33113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f33114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f33115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f33116d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f33117e;

        public d(long j11, boolean z11, long j12, Object obj) {
            this.f33113a = j11;
            this.f33114b = z11;
            this.f33115c = j12;
            this.f33116d = obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @SuppressLint({"HandlerLeak"})
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i11 = message.what;
            if (i11 == 0) {
                DefaultDrmSession.this.z(obj, obj2);
            } else {
                if (i11 != 1) {
                    return;
                }
                DefaultDrmSession.this.t(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, g gVar, a aVar, b bVar, @Nullable List<DrmInitData.SchemeData> list, int i11, boolean z11, boolean z12, @Nullable byte[] bArr, HashMap<String, String> map, j jVar, Looper looper, z zVar, u1 u1Var) {
        if (i11 == 1 || i11 == 3) {
            com.google.android.exoplayer2.util.a.e(bArr);
        }
        this.f33099m = uuid;
        this.f33089c = aVar;
        this.f33090d = bVar;
        this.f33088b = gVar;
        this.f33091e = i11;
        this.f33092f = z11;
        this.f33093g = z12;
        if (bArr != null) {
            this.f33108v = bArr;
            this.f33087a = null;
        } else {
            this.f33087a = Collections.unmodifiableList((List) com.google.android.exoplayer2.util.a.e(list));
        }
        this.f33094h = map;
        this.f33098l = jVar;
        this.f33095i = new com.google.android.exoplayer2.util.j<>();
        this.f33096j = zVar;
        this.f33097k = u1Var;
        this.f33101o = 2;
        this.f33100n = new e(looper);
    }

    public final boolean A() {
        if (p()) {
            return true;
        }
        try {
            byte[] bArrOpenSession = this.f33088b.openSession();
            this.f33107u = bArrOpenSession;
            this.f33088b.f(bArrOpenSession, this.f33097k);
            this.f33105s = this.f33088b.b(this.f33107u);
            final int i11 = 3;
            this.f33101o = 3;
            l(new com.google.android.exoplayer2.util.i() { // from class: sg.d
                @Override // com.google.android.exoplayer2.util.i
                public final void accept(Object obj) {
                    ((com.google.android.exoplayer2.drm.b.a) obj).k(i11);
                }
            });
            com.google.android.exoplayer2.util.a.e(this.f33107u);
            return true;
        } catch (NotProvisionedException unused) {
            this.f33089c.b(this);
            return false;
        } catch (Exception e11) {
            s(e11, 1);
            return false;
        }
    }

    public final void B(byte[] bArr, int i11, boolean z11) {
        try {
            this.f33109w = this.f33088b.d(bArr, this.f33087a, i11, this.f33094h);
            ((c) o0.j(this.f33104r)).b(1, com.google.android.exoplayer2.util.a.e(this.f33109w), z11);
        } catch (Exception e11) {
            u(e11, true);
        }
    }

    public void C() {
        this.f33110x = this.f33088b.getProvisionRequest();
        ((c) o0.j(this.f33104r)).b(0, com.google.android.exoplayer2.util.a.e(this.f33110x), true);
    }

    public final boolean D() {
        try {
            this.f33088b.restoreKeys(this.f33107u, this.f33108v);
            return true;
        } catch (Exception e11) {
            s(e11, 1);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID a() {
        return this.f33099m;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean b() {
        return this.f33092f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final com.google.android.exoplayer2.decoder.b c() {
        return this.f33105s;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d(String str) {
        return this.f33088b.c((byte[]) com.google.android.exoplayer2.util.a.i(this.f33107u), str);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void e(@Nullable com.google.android.exoplayer2.drm.b.a aVar) {
        if (this.f33102p < 0) {
            s.c("DefaultDrmSession", "Session reference count less than zero: " + this.f33102p);
            this.f33102p = 0;
        }
        if (aVar != null) {
            this.f33095i.a(aVar);
        }
        int i11 = this.f33102p + 1;
        this.f33102p = i11;
        if (i11 == 1) {
            com.google.android.exoplayer2.util.a.g(this.f33101o == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f33103q = handlerThread;
            handlerThread.start();
            this.f33104r = new c(this.f33103q.getLooper());
            if (A()) {
                m(true);
            }
        } else if (aVar != null && p() && this.f33095i.count(aVar) == 1) {
            aVar.k(this.f33101o);
        }
        this.f33090d.a(this, this.f33102p);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void f(@Nullable com.google.android.exoplayer2.drm.b.a aVar) {
        int i11 = this.f33102p;
        if (i11 <= 0) {
            s.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i12 = i11 - 1;
        this.f33102p = i12;
        if (i12 == 0) {
            this.f33101o = 0;
            ((e) o0.j(this.f33100n)).removeCallbacksAndMessages(null);
            ((c) o0.j(this.f33104r)).c();
            this.f33104r = null;
            ((HandlerThread) o0.j(this.f33103q)).quit();
            this.f33103q = null;
            this.f33105s = null;
            this.f33106t = null;
            this.f33109w = null;
            this.f33110x = null;
            byte[] bArr = this.f33107u;
            if (bArr != null) {
                this.f33088b.closeSession(bArr);
                this.f33107u = null;
            }
        }
        if (aVar != null) {
            this.f33095i.b(aVar);
            if (this.f33095i.count(aVar) == 0) {
                aVar.m();
            }
        }
        this.f33090d.b(this, this.f33102p);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException getError() {
        if (this.f33101o == 1) {
            return this.f33106t;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.f33101o;
    }

    public final void l(com.google.android.exoplayer2.util.i<com.google.android.exoplayer2.drm.b.a> iVar) {
        Iterator<com.google.android.exoplayer2.drm.b.a> it = this.f33095i.elementSet().iterator();
        while (it.hasNext()) {
            iVar.accept(it.next());
        }
    }

    public final void m(boolean z11) {
        if (this.f33093g) {
            return;
        }
        byte[] bArr = (byte[]) o0.j(this.f33107u);
        int i11 = this.f33091e;
        if (i11 != 0 && i11 != 1) {
            if (i11 == 2) {
                if (this.f33108v == null || D()) {
                    B(bArr, 2, z11);
                    return;
                }
                return;
            }
            if (i11 != 3) {
                return;
            }
            com.google.android.exoplayer2.util.a.e(this.f33108v);
            com.google.android.exoplayer2.util.a.e(this.f33107u);
            B(this.f33108v, 3, z11);
            return;
        }
        if (this.f33108v == null) {
            B(bArr, 1, z11);
            return;
        }
        if (this.f33101o == 4 || D()) {
            long jN = n();
            if (this.f33091e != 0 || jN > 60) {
                if (jN <= 0) {
                    s(new KeysExpiredException(), 2);
                    return;
                } else {
                    this.f33101o = 4;
                    l(new com.google.android.exoplayer2.util.i() { // from class: sg.f
                        @Override // com.google.android.exoplayer2.util.i
                        public final void accept(Object obj) {
                            ((com.google.android.exoplayer2.drm.b.a) obj).j();
                        }
                    });
                    return;
                }
            }
            s.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jN);
            B(bArr, 2, z11);
        }
    }

    public final long n() {
        if (!com.google.android.exoplayer2.h.f33256d.equals(this.f33099m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) com.google.android.exoplayer2.util.a.e(sg.z.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    public boolean o(byte[] bArr) {
        return Arrays.equals(this.f33107u, bArr);
    }

    public final boolean p() {
        int i11 = this.f33101o;
        return i11 == 3 || i11 == 4;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.f33107u;
        if (bArr == null) {
            return null;
        }
        return this.f33088b.queryKeyStatus(bArr);
    }

    public final void s(final Exception exc, int i11) {
        this.f33106t = new DrmSession.DrmSessionException(exc, com.google.android.exoplayer2.drm.d.a(exc, i11));
        s.d("DefaultDrmSession", "DRM session error", exc);
        l(new com.google.android.exoplayer2.util.i() { // from class: sg.e
            @Override // com.google.android.exoplayer2.util.i
            public final void accept(Object obj) {
                ((com.google.android.exoplayer2.drm.b.a) obj).l(exc);
            }
        });
        if (this.f33101o != 4) {
            this.f33101o = 1;
        }
    }

    public final void t(Object obj, Object obj2) {
        if (obj == this.f33109w && p()) {
            this.f33109w = null;
            if (obj2 instanceof Exception) {
                u((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f33091e == 3) {
                    this.f33088b.provideKeyResponse((byte[]) o0.j(this.f33108v), bArr);
                    l(new com.google.android.exoplayer2.util.i() { // from class: sg.b
                        @Override // com.google.android.exoplayer2.util.i
                        public final void accept(Object obj3) {
                            ((com.google.android.exoplayer2.drm.b.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] bArrProvideKeyResponse = this.f33088b.provideKeyResponse(this.f33107u, bArr);
                int i11 = this.f33091e;
                if ((i11 == 2 || (i11 == 0 && this.f33108v != null)) && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                    this.f33108v = bArrProvideKeyResponse;
                }
                this.f33101o = 4;
                l(new com.google.android.exoplayer2.util.i() { // from class: sg.c
                    @Override // com.google.android.exoplayer2.util.i
                    public final void accept(Object obj3) {
                        ((com.google.android.exoplayer2.drm.b.a) obj3).h();
                    }
                });
            } catch (Exception e11) {
                u(e11, true);
            }
        }
    }

    public final void u(Exception exc, boolean z11) {
        if (exc instanceof NotProvisionedException) {
            this.f33089c.b(this);
        } else {
            s(exc, z11 ? 1 : 2);
        }
    }

    public final void v() {
        if (this.f33091e == 0 && this.f33101o == 4) {
            o0.j(this.f33107u);
            m(false);
        }
    }

    public void w(int i11) {
        if (i11 != 2) {
            return;
        }
        v();
    }

    public void x() {
        if (A()) {
            m(true);
        }
    }

    public void y(Exception exc, boolean z11) {
        s(exc, z11 ? 1 : 3);
    }

    public final void z(Object obj, Object obj2) {
        if (obj == this.f33110x) {
            if (this.f33101o == 2 || p()) {
                this.f33110x = null;
                if (obj2 instanceof Exception) {
                    this.f33089c.a((Exception) obj2, false);
                    return;
                }
                try {
                    this.f33088b.provideProvisionResponse((byte[]) obj2);
                    this.f33089c.onProvisionCompleted();
                } catch (Exception e11) {
                    this.f33089c.a(e11, true);
                }
            }
        }
    }
}
