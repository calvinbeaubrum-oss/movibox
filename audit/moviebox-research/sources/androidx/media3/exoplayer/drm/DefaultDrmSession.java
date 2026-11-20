package androidx.media3.exoplayer.drm;

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
import androidx.media3.common.DrmInitData;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.exoplayer.upstream.m;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.x3;
import i4.e0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import p4.n;
import p4.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(18)
public class DefaultDrmSession implements DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final List<DrmInitData.SchemeData> f10207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f10208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f10209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f10210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f10212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, String> f10214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z3.i<androidx.media3.exoplayer.drm.b.a> f10215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m f10216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x3 f10217k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j f10218l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final UUID f10219m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Looper f10220n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e f10221o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10222p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10223q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public HandlerThread f10224r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public c f10225s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public androidx.media3.decoder.b f10226t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public DrmSession.DrmSessionException f10227u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public byte[] f10228v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte[] f10229w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public g.a f10230x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public g.d f10231y;

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
        public boolean f10232a;

        public c(Looper looper) {
            super(looper);
        }

        public final boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            d dVar = (d) message.obj;
            if (!dVar.f10235b) {
                return false;
            }
            int i11 = dVar.f10238e + 1;
            dVar.f10238e = i11;
            if (i11 > DefaultDrmSession.this.f10216j.a(3)) {
                return false;
            }
            long jC = DefaultDrmSession.this.f10216j.c(new m.c(new n(dVar.f10234a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f10236c, mediaDrmCallbackException.bytesLoaded), new o(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), dVar.f10238e));
            if (jC == C.TIME_UNSET) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.f10232a) {
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
            this.f10232a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objB;
            d dVar = (d) message.obj;
            try {
                int i11 = message.what;
                if (i11 == 0) {
                    objB = DefaultDrmSession.this.f10218l.b(DefaultDrmSession.this.f10219m, (g.d) dVar.f10237d);
                } else {
                    if (i11 != 1) {
                        throw new RuntimeException();
                    }
                    objB = DefaultDrmSession.this.f10218l.a(DefaultDrmSession.this.f10219m, (g.a) dVar.f10237d);
                }
            } catch (MediaDrmCallbackException e11) {
                boolean zA = a(message, e11);
                objB = e11;
                if (zA) {
                    return;
                }
            } catch (Exception e12) {
                z3.o.i("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e12);
                objB = e12;
            }
            DefaultDrmSession.this.f10216j.b(dVar.f10234a);
            synchronized (this) {
                try {
                    if (!this.f10232a) {
                        DefaultDrmSession.this.f10221o.obtainMessage(message.what, Pair.create(dVar.f10237d, objB)).sendToTarget();
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
        public final long f10234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f10236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f10237d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10238e;

        public d(long j11, boolean z11, long j12, Object obj) {
            this.f10234a = j11;
            this.f10235b = z11;
            this.f10236c = j12;
            this.f10237d = obj;
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
                DefaultDrmSession.this.C(obj, obj2);
            } else {
                if (i11 != 1) {
                    return;
                }
                DefaultDrmSession.this.w(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, g gVar, a aVar, b bVar, @Nullable List<DrmInitData.SchemeData> list, int i11, boolean z11, boolean z12, @Nullable byte[] bArr, HashMap<String, String> map, j jVar, Looper looper, m mVar, x3 x3Var) {
        if (i11 == 1 || i11 == 3) {
            z3.a.e(bArr);
        }
        this.f10219m = uuid;
        this.f10209c = aVar;
        this.f10210d = bVar;
        this.f10208b = gVar;
        this.f10211e = i11;
        this.f10212f = z11;
        this.f10213g = z12;
        if (bArr != null) {
            this.f10229w = bArr;
            this.f10207a = null;
        } else {
            this.f10207a = Collections.unmodifiableList((List) z3.a.e(list));
        }
        this.f10214h = map;
        this.f10218l = jVar;
        this.f10215i = new z3.i<>();
        this.f10216j = mVar;
        this.f10217k = x3Var;
        this.f10222p = 2;
        this.f10220n = looper;
        this.f10221o = new e(looper);
    }

    public static /* synthetic */ void t(Throwable th2, androidx.media3.exoplayer.drm.b.a aVar) {
        aVar.l((Exception) th2);
    }

    public void A() {
        if (D()) {
            p(true);
        }
    }

    public void B(Exception exc, boolean z11) {
        v(exc, z11 ? 1 : 3);
    }

    public final void C(Object obj, Object obj2) {
        if (obj == this.f10231y) {
            if (this.f10222p == 2 || s()) {
                this.f10231y = null;
                if (obj2 instanceof Exception) {
                    this.f10209c.a((Exception) obj2, false);
                    return;
                }
                try {
                    this.f10208b.provideProvisionResponse((byte[]) obj2);
                    this.f10209c.onProvisionCompleted();
                } catch (Exception e11) {
                    this.f10209c.a(e11, true);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b  */
    /* JADX WARN: Code duplicated, block: B:13:0x0041  */
    public final boolean D() {
        if (s()) {
            return true;
        }
        try {
            byte[] bArrOpenSession = this.f10208b.openSession();
            this.f10228v = bArrOpenSession;
            this.f10208b.e(bArrOpenSession, this.f10217k);
            this.f10226t = this.f10208b.b(this.f10228v);
            final int i11 = 3;
            this.f10222p = 3;
            o(new z3.h() { // from class: i4.c
                @Override // z3.h
                public final void accept(Object obj) {
                    ((androidx.media3.exoplayer.drm.b.a) obj).k(i11);
                }
            });
            z3.a.e(this.f10228v);
            return true;
        } catch (NotProvisionedException unused) {
            this.f10209c.b(this);
            return false;
        } catch (Exception e11) {
            e = e11;
            if (androidx.media3.exoplayer.drm.d.b(e)) {
                this.f10209c.b(this);
                return false;
            }
            v(e, 1);
            return false;
        } catch (NoSuchMethodError e12) {
            e = e12;
            if (androidx.media3.exoplayer.drm.d.b(e)) {
                this.f10209c.b(this);
                return false;
            }
            v(e, 1);
            return false;
        }
    }

    public final void E(byte[] bArr, int i11, boolean z11) {
        try {
            this.f10230x = this.f10208b.d(bArr, this.f10207a, i11, this.f10214h);
            ((c) u0.i(this.f10225s)).b(1, z3.a.e(this.f10230x), z11);
        } catch (Exception | NoSuchMethodError e11) {
            x(e11, true);
        }
    }

    public void F() {
        this.f10231y = this.f10208b.getProvisionRequest();
        ((c) u0.i(this.f10225s)).b(0, z3.a.e(this.f10231y), true);
    }

    public final boolean G() {
        try {
            this.f10208b.restoreKeys(this.f10228v, this.f10229w);
            return true;
        } catch (Exception | NoSuchMethodError e11) {
            v(e11, 1);
            return false;
        }
    }

    public final void H() {
        if (Thread.currentThread() != this.f10220n.getThread()) {
            z3.o.i("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f10220n.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final UUID a() {
        H();
        return this.f10219m;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean b() {
        H();
        return this.f10212f;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    @Nullable
    public final androidx.media3.decoder.b c() {
        H();
        return this.f10226t;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean d(String str) {
        H();
        return this.f10208b.c((byte[]) z3.a.i(this.f10228v), str);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void e(@Nullable androidx.media3.exoplayer.drm.b.a aVar) {
        H();
        if (this.f10223q < 0) {
            z3.o.c("DefaultDrmSession", "Session reference count less than zero: " + this.f10223q);
            this.f10223q = 0;
        }
        if (aVar != null) {
            this.f10215i.a(aVar);
        }
        int i11 = this.f10223q + 1;
        this.f10223q = i11;
        if (i11 == 1) {
            z3.a.g(this.f10222p == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f10224r = handlerThread;
            handlerThread.start();
            this.f10225s = new c(this.f10224r.getLooper());
            if (D()) {
                p(true);
            }
        } else if (aVar != null && s() && this.f10215i.count(aVar) == 1) {
            aVar.k(this.f10222p);
        }
        this.f10210d.a(this, this.f10223q);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void f(@Nullable androidx.media3.exoplayer.drm.b.a aVar) {
        H();
        int i11 = this.f10223q;
        if (i11 <= 0) {
            z3.o.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i12 = i11 - 1;
        this.f10223q = i12;
        if (i12 == 0) {
            this.f10222p = 0;
            ((e) u0.i(this.f10221o)).removeCallbacksAndMessages(null);
            ((c) u0.i(this.f10225s)).c();
            this.f10225s = null;
            ((HandlerThread) u0.i(this.f10224r)).quit();
            this.f10224r = null;
            this.f10226t = null;
            this.f10227u = null;
            this.f10230x = null;
            this.f10231y = null;
            byte[] bArr = this.f10228v;
            if (bArr != null) {
                this.f10208b.closeSession(bArr);
                this.f10228v = null;
            }
        }
        if (aVar != null) {
            this.f10215i.b(aVar);
            if (this.f10215i.count(aVar) == 0) {
                aVar.m();
            }
        }
        this.f10210d.b(this, this.f10223q);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException getError() {
        H();
        if (this.f10222p == 1) {
            return this.f10227u;
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final int getState() {
        H();
        return this.f10222p;
    }

    public final void o(z3.h<androidx.media3.exoplayer.drm.b.a> hVar) {
        Iterator<androidx.media3.exoplayer.drm.b.a> it = this.f10215i.elementSet().iterator();
        while (it.hasNext()) {
            hVar.accept(it.next());
        }
    }

    public final void p(boolean z11) {
        if (this.f10213g) {
            return;
        }
        byte[] bArr = (byte[]) u0.i(this.f10228v);
        int i11 = this.f10211e;
        if (i11 != 0 && i11 != 1) {
            if (i11 == 2) {
                if (this.f10229w == null || G()) {
                    E(bArr, 2, z11);
                    return;
                }
                return;
            }
            if (i11 != 3) {
                return;
            }
            z3.a.e(this.f10229w);
            z3.a.e(this.f10228v);
            E(this.f10229w, 3, z11);
            return;
        }
        if (this.f10229w == null) {
            E(bArr, 1, z11);
            return;
        }
        if (this.f10222p == 4 || G()) {
            long jQ = q();
            if (this.f10211e != 0 || jQ > 60) {
                if (jQ <= 0) {
                    v(new KeysExpiredException(), 2);
                    return;
                } else {
                    this.f10222p = 4;
                    o(new z3.h() { // from class: i4.d
                        @Override // z3.h
                        public final void accept(Object obj) {
                            ((androidx.media3.exoplayer.drm.b.a) obj).j();
                        }
                    });
                    return;
                }
            }
            z3.o.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jQ);
            E(bArr, 2, z11);
        }
    }

    public final long q() {
        if (!androidx.media3.common.j.f9254d.equals(this.f10219m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) z3.a.e(e0.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    @Nullable
    public Map<String, String> queryKeyStatus() {
        H();
        byte[] bArr = this.f10228v;
        if (bArr == null) {
            return null;
        }
        return this.f10208b.queryKeyStatus(bArr);
    }

    public boolean r(byte[] bArr) {
        H();
        return Arrays.equals(this.f10228v, bArr);
    }

    public final boolean s() {
        int i11 = this.f10222p;
        return i11 == 3 || i11 == 4;
    }

    public final void v(final Throwable th2, int i11) {
        this.f10227u = new DrmSession.DrmSessionException(th2, androidx.media3.exoplayer.drm.d.a(th2, i11));
        z3.o.d("DefaultDrmSession", "DRM session error", th2);
        if (th2 instanceof Exception) {
            o(new z3.h() { // from class: i4.b
                @Override // z3.h
                public final void accept(Object obj) {
                    DefaultDrmSession.t(th2, (androidx.media3.exoplayer.drm.b.a) obj);
                }
            });
        } else {
            if (!(th2 instanceof Error)) {
                throw new IllegalStateException("Unexpected Throwable subclass", th2);
            }
            if (!androidx.media3.exoplayer.drm.d.c(th2) && !androidx.media3.exoplayer.drm.d.b(th2)) {
                throw ((Error) th2);
            }
        }
        if (this.f10222p != 4) {
            this.f10222p = 1;
        }
    }

    public final void w(Object obj, Object obj2) {
        if (obj == this.f10230x && s()) {
            this.f10230x = null;
            if ((obj2 instanceof Exception) || (obj2 instanceof NoSuchMethodError)) {
                x((Throwable) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f10211e == 3) {
                    this.f10208b.provideKeyResponse((byte[]) u0.i(this.f10229w), bArr);
                    o(new z3.h() { // from class: i4.e
                        @Override // z3.h
                        public final void accept(Object obj3) {
                            ((androidx.media3.exoplayer.drm.b.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] bArrProvideKeyResponse = this.f10208b.provideKeyResponse(this.f10228v, bArr);
                int i11 = this.f10211e;
                if ((i11 == 2 || (i11 == 0 && this.f10229w != null)) && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                    this.f10229w = bArrProvideKeyResponse;
                }
                this.f10222p = 4;
                o(new z3.h() { // from class: i4.f
                    @Override // z3.h
                    public final void accept(Object obj3) {
                        ((androidx.media3.exoplayer.drm.b.a) obj3).h();
                    }
                });
            } catch (Exception e11) {
                e = e11;
                x(e, true);
            } catch (NoSuchMethodError e12) {
                e = e12;
                x(e, true);
            }
        }
    }

    public final void x(Throwable th2, boolean z11) {
        if ((th2 instanceof NotProvisionedException) || androidx.media3.exoplayer.drm.d.b(th2)) {
            this.f10209c.b(this);
        } else {
            v(th2, z11 ? 1 : 2);
        }
    }

    public final void y() {
        if (this.f10211e == 0 && this.f10222p == 4) {
            u0.i(this.f10228v);
            p(false);
        }
    }

    public void z(int i11) {
        if (i11 != 2) {
            return;
        }
        y();
    }
}
