package com.applovin.impl;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class x5 implements z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z7 f24229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f24230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f24231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f24233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f24234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap f24235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u4 f24236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final mc f24237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final qd f24238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final UUID f24239l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final e f24240m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f24241n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f24242o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private HandlerThread f24243p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private c f24244q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private z4 f24245r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private z6.a f24246s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private byte[] f24247t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private byte[] f24248u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private z7.a f24249v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private z7.d f24250w;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();

        void a(x5 x5Var);

        void a(Exception exc, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(x5 x5Var, int i11);

        void b(x5 x5Var, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f24251a;

        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, rd rdVar) {
            d dVar = (d) message.obj;
            if (!dVar.f24254b) {
                return false;
            }
            int i11 = dVar.f24257e + 1;
            dVar.f24257e = i11;
            if (i11 > x5.this.f24237j.a(3)) {
                return false;
            }
            long jA = x5.this.f24237j.a(new mc.a(new nc(dVar.f24253a, rdVar.f22079a, rdVar.f22080b, rdVar.f22081c, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f24255c, rdVar.f22082d), new ud(3), rdVar.getCause() instanceof IOException ? (IOException) rdVar.getCause() : new f(rdVar.getCause()), dVar.f24257e));
            if (jA == C.TIME_UNSET) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.f24251a) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), jA);
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public synchronized void a() {
            removeCallbacksAndMessages(null);
            this.f24251a = true;
        }

        public void a(int i11, Object obj, boolean z11) {
            obtainMessage(i11, new d(nc.a(), z11, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objA;
            d dVar = (d) message.obj;
            try {
                int i11 = message.what;
                if (i11 == 0) {
                    x5 x5Var = x5.this;
                    objA = x5Var.f24238k.a(x5Var.f24239l, (z7.d) dVar.f24256d);
                } else {
                    if (i11 != 1) {
                        throw new RuntimeException();
                    }
                    x5 x5Var2 = x5.this;
                    objA = x5Var2.f24238k.a(x5Var2.f24239l, (z7.a) dVar.f24256d);
                }
            } catch (rd e11) {
                boolean zA = a(message, e11);
                objA = e11;
                if (zA) {
                    return;
                }
            } catch (Exception e12) {
                pc.c("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e12);
                objA = e12;
            }
            x5.this.f24237j.a(dVar.f24253a);
            synchronized (this) {
                try {
                    if (!this.f24251a) {
                        x5.this.f24240m.obtainMessage(message.what, Pair.create(dVar.f24256d, objA)).sendToTarget();
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
        public final long f24253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f24254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f24255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f24256d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f24257e;

        public d(long j11, boolean z11, long j12, Object obj) {
            this.f24253a = j11;
            this.f24254b = z11;
            this.f24255c = j12;
            this.f24256d = obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
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
                x5.this.b(obj, obj2);
            } else {
                if (i11 != 1) {
                    return;
                }
                x5.this.a(obj, obj2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f extends IOException {
        public f(Throwable th2) {
            super(th2);
        }
    }

    public x5(UUID uuid, z7 z7Var, a aVar, b bVar, List list, int i11, boolean z11, boolean z12, byte[] bArr, HashMap map, qd qdVar, Looper looper, mc mcVar) {
        if (i11 == 1 || i11 == 3) {
            b1.a(bArr);
        }
        this.f24239l = uuid;
        this.f24230c = aVar;
        this.f24231d = bVar;
        this.f24229b = z7Var;
        this.f24232e = i11;
        this.f24233f = z11;
        this.f24234g = z12;
        if (bArr != null) {
            this.f24248u = bArr;
            this.f24228a = null;
        } else {
            this.f24228a = Collections.unmodifiableList((List) b1.a(list));
        }
        this.f24235h = map;
        this.f24238k = qdVar;
        this.f24236i = new u4();
        this.f24237j = mcVar;
        this.f24241n = 2;
        this.f24240m = new e(looper);
    }

    private long a() {
        if (!t2.f23170d.equals(this.f24239l)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) b1.a(bs.a(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private void a(r4 r4Var) {
        Iterator it = this.f24236i.a().iterator();
        while (it.hasNext()) {
            r4Var.accept((a7.a) it.next());
        }
    }

    private void a(final Exception exc, int i11) {
        this.f24246s = new z6.a(exc, d7.a(exc, i11));
        pc.a("DefaultDrmSession", "DRM session error", exc);
        a(new r4() { // from class: com.applovin.impl.w80
            @Override // com.applovin.impl.r4
            public final void accept(Object obj) {
                ((a7.a) obj).a(exc);
            }
        });
        if (this.f24241n != 4) {
            this.f24241n = 1;
        }
    }

    private void a(Exception exc, boolean z11) {
        if (exc instanceof NotProvisionedException) {
            this.f24230c.a(this);
        } else {
            a(exc, z11 ? 1 : 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj, Object obj2) {
        if (obj == this.f24249v && g()) {
            this.f24249v = null;
            if (obj2 instanceof Exception) {
                a((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f24232e == 3) {
                    this.f24229b.b((byte[]) xp.a((Object) this.f24248u), bArr);
                    a(new r4() { // from class: com.applovin.impl.z80
                        @Override // com.applovin.impl.r4
                        public final void accept(Object obj3) {
                            ((a7.a) obj3).b();
                        }
                    });
                    return;
                }
                byte[] bArrB = this.f24229b.b(this.f24247t, bArr);
                int i11 = this.f24232e;
                if ((i11 == 2 || (i11 == 0 && this.f24248u != null)) && bArrB != null && bArrB.length != 0) {
                    this.f24248u = bArrB;
                }
                this.f24241n = 4;
                a(new r4() { // from class: com.applovin.impl.a90
                    @Override // com.applovin.impl.r4
                    public final void accept(Object obj3) {
                        ((a7.a) obj3).a();
                    }
                });
            } catch (Exception e11) {
                a(e11, true);
            }
        }
    }

    private void a(boolean z11) {
        if (this.f24234g) {
            return;
        }
        byte[] bArr = (byte[]) xp.a((Object) this.f24247t);
        int i11 = this.f24232e;
        if (i11 != 0 && i11 != 1) {
            if (i11 == 2) {
                if (this.f24248u == null || l()) {
                    a(bArr, 2, z11);
                    return;
                }
                return;
            }
            if (i11 != 3) {
                return;
            }
            b1.a(this.f24248u);
            b1.a(this.f24247t);
            a(this.f24248u, 3, z11);
            return;
        }
        if (this.f24248u == null) {
            a(bArr, 1, z11);
            return;
        }
        if (this.f24241n == 4 || l()) {
            long jA = a();
            if (this.f24232e != 0 || jA > 60) {
                if (jA <= 0) {
                    a(new zb(), 2);
                    return;
                } else {
                    this.f24241n = 4;
                    a(new r4() { // from class: com.applovin.impl.x80
                        @Override // com.applovin.impl.r4
                        public final void accept(Object obj) {
                            ((a7.a) obj).c();
                        }
                    });
                    return;
                }
            }
            pc.a("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jA);
            a(bArr, 2, z11);
        }
    }

    private void a(byte[] bArr, int i11, boolean z11) {
        try {
            this.f24249v = this.f24229b.a(bArr, this.f24228a, i11, this.f24235h);
            ((c) xp.a(this.f24244q)).a(1, b1.a(this.f24249v), z11);
        } catch (Exception e11) {
            a(e11, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj, Object obj2) {
        if (obj == this.f24250w) {
            if (this.f24241n == 2 || g()) {
                this.f24250w = null;
                if (obj2 instanceof Exception) {
                    this.f24230c.a((Exception) obj2, false);
                    return;
                }
                try {
                    this.f24229b.a((byte[]) obj2);
                    this.f24230c.a();
                } catch (Exception e11) {
                    this.f24230c.a(e11, true);
                }
            }
        }
    }

    private boolean g() {
        int i11 = this.f24241n;
        return i11 == 3 || i11 == 4;
    }

    private void h() {
        if (this.f24232e == 0 && this.f24241n == 4) {
            xp.a((Object) this.f24247t);
            a(false);
        }
    }

    private boolean j() {
        if (g()) {
            return true;
        }
        try {
            byte[] bArrD = this.f24229b.d();
            this.f24247t = bArrD;
            this.f24245r = this.f24229b.d(bArrD);
            final int i11 = 3;
            this.f24241n = 3;
            a(new r4() { // from class: com.applovin.impl.y80
                @Override // com.applovin.impl.r4
                public final void accept(Object obj) {
                    ((a7.a) obj).a(i11);
                }
            });
            b1.a(this.f24247t);
            return true;
        } catch (NotProvisionedException unused) {
            this.f24230c.a(this);
            return false;
        } catch (Exception e11) {
            a(e11, 1);
            return false;
        }
    }

    private boolean l() {
        try {
            this.f24229b.a(this.f24247t, this.f24248u);
            return true;
        } catch (Exception e11) {
            a(e11, 1);
            return false;
        }
    }

    public void a(int i11) {
        if (i11 != 2) {
            return;
        }
        h();
    }

    @Override // com.applovin.impl.z6
    public void a(a7.a aVar) {
        b1.b(this.f24242o > 0);
        int i11 = this.f24242o - 1;
        this.f24242o = i11;
        if (i11 == 0) {
            this.f24241n = 0;
            ((e) xp.a(this.f24240m)).removeCallbacksAndMessages(null);
            ((c) xp.a(this.f24244q)).a();
            this.f24244q = null;
            ((HandlerThread) xp.a(this.f24243p)).quit();
            this.f24243p = null;
            this.f24245r = null;
            this.f24246s = null;
            this.f24249v = null;
            this.f24250w = null;
            byte[] bArr = this.f24247t;
            if (bArr != null) {
                this.f24229b.c(bArr);
                this.f24247t = null;
            }
        }
        if (aVar != null) {
            this.f24236i.c(aVar);
            if (this.f24236i.b(aVar) == 0) {
                aVar.d();
            }
        }
        this.f24231d.b(this, this.f24242o);
    }

    @Override // com.applovin.impl.z6
    public boolean a(String str) {
        return this.f24229b.a((byte[]) b1.b(this.f24247t), str);
    }

    public boolean a(byte[] bArr) {
        return Arrays.equals(this.f24247t, bArr);
    }

    @Override // com.applovin.impl.z6
    public final int b() {
        return this.f24241n;
    }

    @Override // com.applovin.impl.z6
    public void b(a7.a aVar) {
        b1.b(this.f24242o >= 0);
        if (aVar != null) {
            this.f24236i.a(aVar);
        }
        int i11 = this.f24242o + 1;
        this.f24242o = i11;
        if (i11 == 1) {
            b1.b(this.f24241n == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f24243p = handlerThread;
            handlerThread.start();
            this.f24244q = new c(this.f24243p.getLooper());
            if (j()) {
                a(true);
            }
        } else if (aVar != null && g() && this.f24236i.b(aVar) == 1) {
            aVar.a(this.f24241n);
        }
        this.f24231d.a(this, this.f24242o);
    }

    public void b(Exception exc, boolean z11) {
        a(exc, z11 ? 1 : 3);
    }

    @Override // com.applovin.impl.z6
    public boolean c() {
        return this.f24233f;
    }

    @Override // com.applovin.impl.z6
    public Map d() {
        byte[] bArr = this.f24247t;
        if (bArr == null) {
            return null;
        }
        return this.f24229b.b(bArr);
    }

    @Override // com.applovin.impl.z6
    public final UUID e() {
        return this.f24239l;
    }

    @Override // com.applovin.impl.z6
    public final z4 f() {
        return this.f24245r;
    }

    @Override // com.applovin.impl.z6
    public final z6.a getError() {
        if (this.f24241n == 1) {
            return this.f24246s;
        }
        return null;
    }

    public void i() {
        if (j()) {
            a(true);
        }
    }

    public void k() {
        this.f24250w = this.f24229b.b();
        ((c) xp.a(this.f24244q)).a(0, b1.a(this.f24250w), true);
    }
}
