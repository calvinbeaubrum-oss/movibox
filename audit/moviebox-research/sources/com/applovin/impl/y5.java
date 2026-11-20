package com.applovin.impl;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class y5 implements b7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UUID f24512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z7.c f24513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final qd f24514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap f24515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f24516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f24517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f24518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final g f24519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final mc f24520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final h f24521l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f24522m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f24523n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Set f24524o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Set f24525p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f24526q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private z7 f24527r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private x5 f24528s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private x5 f24529t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Looper f24530u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Handler f24531v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f24532w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private byte[] f24533x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    volatile d f24534y;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f24538d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f24540f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashMap f24535a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private UUID f24536b = t2.f23170d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private z7.c f24537c = m9.f20633d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private mc f24541g = new g6();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f24539e = new int[0];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f24542h = 300000;

        public b a(UUID uuid, z7.c cVar) {
            this.f24536b = (UUID) b1.a(uuid);
            this.f24537c = (z7.c) b1.a(cVar);
            return this;
        }

        public b a(boolean z11) {
            this.f24538d = z11;
            return this;
        }

        public b a(int... iArr) {
            for (int i11 : iArr) {
                boolean z11 = true;
                if (i11 != 2 && i11 != 1) {
                    z11 = false;
                }
                b1.a(z11);
            }
            this.f24539e = (int[]) iArr.clone();
            return this;
        }

        public y5 a(qd qdVar) {
            return new y5(this.f24536b, this.f24537c, qdVar, this.f24535a, this.f24538d, this.f24539e, this.f24540f, this.f24541g, this.f24542h);
        }

        public b b(boolean z11) {
            this.f24540f = z11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements z7.b {
        private c() {
        }

        @Override // com.applovin.impl.z7.b
        public void a(z7 z7Var, byte[] bArr, int i11, int i12, byte[] bArr2) {
            ((d) b1.a(y5.this.f24534y)).obtainMessage(i11, bArr).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: source.java */
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
            for (x5 x5Var : y5.this.f24523n) {
                if (x5Var.a(bArr)) {
                    x5Var.a(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends Exception {
        private e(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements b7.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a7.a f24545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private z6 f24546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f24547d;

        public f(a7.a aVar) {
            this.f24545b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(f9 f9Var) {
            if (y5.this.f24526q == 0 || this.f24547d) {
                return;
            }
            y5 y5Var = y5.this;
            this.f24546c = y5Var.a((Looper) b1.a(y5Var.f24530u), this.f24545b, f9Var, false);
            y5.this.f24524o.add(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (this.f24547d) {
                return;
            }
            z6 z6Var = this.f24546c;
            if (z6Var != null) {
                z6Var.a(this.f24545b);
            }
            y5.this.f24524o.remove(this);
            this.f24547d = true;
        }

        @Override // com.applovin.impl.b7.b
        public void a() {
            xp.a((Handler) b1.a(y5.this.f24531v), new Runnable() { // from class: com.applovin.impl.t90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f23217a.c();
                }
            });
        }

        public void a(final f9 f9Var) {
            ((Handler) b1.a(y5.this.f24531v)).post(new Runnable() { // from class: com.applovin.impl.u90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f23557a.b(f9Var);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements x5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f24549a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private x5 f24550b;

        public g() {
        }

        @Override // com.applovin.impl.x5.a
        public void a() {
            this.f24550b = null;
            eb ebVarA = eb.a((Collection) this.f24549a);
            this.f24549a.clear();
            pp it = ebVarA.iterator();
            while (it.hasNext()) {
                ((x5) it.next()).i();
            }
        }

        @Override // com.applovin.impl.x5.a
        public void a(x5 x5Var) {
            this.f24549a.add(x5Var);
            if (this.f24550b != null) {
                return;
            }
            this.f24550b = x5Var;
            x5Var.k();
        }

        @Override // com.applovin.impl.x5.a
        public void a(Exception exc, boolean z11) {
            this.f24550b = null;
            eb ebVarA = eb.a((Collection) this.f24549a);
            this.f24549a.clear();
            pp it = ebVarA.iterator();
            while (it.hasNext()) {
                ((x5) it.next()).b(exc, z11);
            }
        }

        public void b(x5 x5Var) {
            this.f24549a.remove(x5Var);
            if (this.f24550b == x5Var) {
                this.f24550b = null;
                if (this.f24549a.isEmpty()) {
                    return;
                }
                x5 x5Var2 = (x5) this.f24549a.iterator().next();
                this.f24550b = x5Var2;
                x5Var2.k();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements x5.b {
        private h() {
        }

        @Override // com.applovin.impl.x5.b
        public void a(x5 x5Var, int i11) {
            if (y5.this.f24522m != C.TIME_UNSET) {
                y5.this.f24525p.remove(x5Var);
                ((Handler) b1.a(y5.this.f24531v)).removeCallbacksAndMessages(x5Var);
            }
        }

        @Override // com.applovin.impl.x5.b
        public void b(final x5 x5Var, int i11) {
            if (i11 == 1 && y5.this.f24526q > 0 && y5.this.f24522m != C.TIME_UNSET) {
                y5.this.f24525p.add(x5Var);
                ((Handler) b1.a(y5.this.f24531v)).postAtTime(new Runnable() { // from class: com.applovin.impl.v90
                    @Override // java.lang.Runnable
                    public final void run() {
                        x5Var.a((a7.a) null);
                    }
                }, x5Var, SystemClock.uptimeMillis() + y5.this.f24522m);
            } else if (i11 == 0) {
                y5.this.f24523n.remove(x5Var);
                if (y5.this.f24528s == x5Var) {
                    y5.this.f24528s = null;
                }
                if (y5.this.f24529t == x5Var) {
                    y5.this.f24529t = null;
                }
                y5.this.f24519j.b(x5Var);
                if (y5.this.f24522m != C.TIME_UNSET) {
                    ((Handler) b1.a(y5.this.f24531v)).removeCallbacksAndMessages(x5Var);
                    y5.this.f24525p.remove(x5Var);
                }
            }
            y5.this.c();
        }
    }

    private y5(UUID uuid, z7.c cVar, qd qdVar, HashMap map, boolean z11, int[] iArr, boolean z12, mc mcVar, long j11) {
        b1.a(uuid);
        b1.a(!t2.f23168b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f24512c = uuid;
        this.f24513d = cVar;
        this.f24514e = qdVar;
        this.f24515f = map;
        this.f24516g = z11;
        this.f24517h = iArr;
        this.f24518i = z12;
        this.f24520k = mcVar;
        this.f24519j = new g();
        this.f24521l = new h();
        this.f24532w = 0;
        this.f24523n = new ArrayList();
        this.f24524o = rj.b();
        this.f24525p = rj.b();
        this.f24522m = j11;
    }

    private x5 a(List list, boolean z11, a7.a aVar) {
        b1.a(this.f24527r);
        x5 x5Var = new x5(this.f24512c, this.f24527r, this.f24519j, this.f24521l, list, this.f24532w, this.f24518i | z11, z11, this.f24533x, this.f24515f, this.f24514e, (Looper) b1.a(this.f24530u), this.f24520k);
        x5Var.b(aVar);
        if (this.f24522m != C.TIME_UNSET) {
            x5Var.b(null);
        }
        return x5Var;
    }

    private x5 a(List list, boolean z11, a7.a aVar, boolean z12) {
        x5 x5VarA = a(list, z11, aVar);
        if (a(x5VarA) && !this.f24525p.isEmpty()) {
            d();
            a(x5VarA, aVar);
            x5VarA = a(list, z11, aVar);
        }
        if (!a(x5VarA) || !z12 || this.f24524o.isEmpty()) {
            return x5VarA;
        }
        e();
        if (!this.f24525p.isEmpty()) {
            d();
        }
        a(x5VarA, aVar);
        return a(list, z11, aVar);
    }

    private z6 a(int i11, boolean z11) {
        z7 z7Var = (z7) b1.a(this.f24527r);
        if ((z7Var.c() == 2 && l9.f20366d) || xp.a(this.f24517h, i11) == -1 || z7Var.c() == 1) {
            return null;
        }
        x5 x5Var = this.f24528s;
        if (x5Var == null) {
            x5 x5VarA = a((List) eb.h(), true, (a7.a) null, z11);
            this.f24523n.add(x5VarA);
            this.f24528s = x5VarA;
        } else {
            x5Var.b(null);
        }
        return this.f24528s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public z6 a(Looper looper, a7.a aVar, f9 f9Var, boolean z11) {
        List listA;
        b(looper);
        y6 y6Var = f9Var.f18903p;
        if (y6Var == null) {
            return a(Cif.e(f9Var.f18900m), z11);
        }
        x5 x5VarA = null;
        Object[] objArr = 0;
        if (this.f24533x == null) {
            listA = a((y6) b1.a(y6Var), this.f24512c, false);
            if (listA.isEmpty()) {
                e eVar = new e(this.f24512c);
                pc.a("DefaultDrmSessionMgr", "DRM error", eVar);
                if (aVar != null) {
                    aVar.a(eVar);
                }
                return new u7(new z6.a(eVar, 6003));
            }
        } else {
            listA = null;
        }
        if (this.f24516g) {
            for (x5 x5Var : this.f24523n) {
                if (xp.a(x5Var.f24228a, listA)) {
                    x5VarA = x5Var;
                    break;
                }
            }
        } else {
            x5VarA = this.f24529t;
        }
        if (x5VarA == null) {
            x5VarA = a(listA, false, aVar, z11);
            if (!this.f24516g) {
                this.f24529t = x5VarA;
            }
            this.f24523n.add(x5VarA);
        } else {
            x5VarA.b(aVar);
        }
        return x5VarA;
    }

    private static List a(y6 y6Var, UUID uuid, boolean z11) {
        ArrayList arrayList = new ArrayList(y6Var.f24558d);
        for (int i11 = 0; i11 < y6Var.f24558d; i11++) {
            y6.b bVarA = y6Var.a(i11);
            if ((bVarA.a(uuid) || (t2.f23169c.equals(uuid) && bVarA.a(t2.f23168b))) && (bVarA.f24563f != null || z11)) {
                arrayList.add(bVarA);
            }
        }
        return arrayList;
    }

    private synchronized void a(Looper looper) {
        try {
            Looper looper2 = this.f24530u;
            if (looper2 == null) {
                this.f24530u = looper;
                this.f24531v = new Handler(looper);
            } else {
                b1.b(looper2 == looper);
                b1.a(this.f24531v);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void a(z6 z6Var, a7.a aVar) {
        z6Var.a(aVar);
        if (this.f24522m != C.TIME_UNSET) {
            z6Var.a((a7.a) null);
        }
    }

    private boolean a(y6 y6Var) {
        if (this.f24533x != null) {
            return true;
        }
        if (a(y6Var, this.f24512c, true).isEmpty()) {
            if (y6Var.f24558d != 1 || !y6Var.a(0).a(t2.f23168b)) {
                return false;
            }
            pc.d("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f24512c);
        }
        String str = y6Var.f24557c;
        if (str == null || C.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        if (C.CENC_TYPE_cbcs.equals(str)) {
            return xp.f24372a >= 25;
        }
        return (C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str)) ? false : true;
    }

    private static boolean a(z6 z6Var) {
        return z6Var.b() == 1 && (xp.f24372a < 19 || (((z6.a) b1.a(z6Var.getError())).getCause() instanceof ResourceBusyException));
    }

    private void b(Looper looper) {
        if (this.f24534y == null) {
            this.f24534y = new d(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f24527r != null && this.f24526q == 0 && this.f24523n.isEmpty() && this.f24524o.isEmpty()) {
            ((z7) b1.a(this.f24527r)).a();
            this.f24527r = null;
        }
    }

    private void d() {
        pp it = ib.a((Collection) this.f24525p).iterator();
        while (it.hasNext()) {
            ((z6) it.next()).a((a7.a) null);
        }
    }

    private void e() {
        pp it = ib.a((Collection) this.f24524o).iterator();
        while (it.hasNext()) {
            ((f) it.next()).a();
        }
    }

    @Override // com.applovin.impl.b7
    public int a(f9 f9Var) {
        int iC = ((z7) b1.a(this.f24527r)).c();
        y6 y6Var = f9Var.f18903p;
        if (y6Var != null) {
            if (a(y6Var)) {
                return iC;
            }
            return 1;
        }
        if (xp.a(this.f24517h, Cif.e(f9Var.f18900m)) != -1) {
            return iC;
        }
        return 0;
    }

    @Override // com.applovin.impl.b7
    public z6 a(Looper looper, a7.a aVar, f9 f9Var) {
        b1.b(this.f24526q > 0);
        a(looper);
        return a(looper, aVar, f9Var, true);
    }

    @Override // com.applovin.impl.b7
    public final void a() {
        int i11 = this.f24526q - 1;
        this.f24526q = i11;
        if (i11 != 0) {
            return;
        }
        if (this.f24522m != C.TIME_UNSET) {
            ArrayList arrayList = new ArrayList(this.f24523n);
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                ((x5) arrayList.get(i12)).a((a7.a) null);
            }
        }
        e();
        c();
    }

    public void a(int i11, byte[] bArr) {
        b1.b(this.f24523n.isEmpty());
        if (i11 == 1 || i11 == 3) {
            b1.a(bArr);
        }
        this.f24532w = i11;
        this.f24533x = bArr;
    }

    @Override // com.applovin.impl.b7
    public b7.b b(Looper looper, a7.a aVar, f9 f9Var) {
        b1.b(this.f24526q > 0);
        a(looper);
        f fVar = new f(aVar);
        fVar.a(f9Var);
        return fVar;
    }

    @Override // com.applovin.impl.b7
    public final void b() {
        int i11 = this.f24526q;
        this.f24526q = i11 + 1;
        if (i11 != 0) {
            return;
        }
        if (this.f24527r == null) {
            z7 z7VarA = this.f24513d.a(this.f24512c);
            this.f24527r = z7VarA;
            z7VarA.a(new c());
        } else if (this.f24522m != C.TIME_UNSET) {
            for (int i12 = 0; i12 < this.f24523n.size(); i12++) {
                ((x5) this.f24523n.get(i12)).b(null);
            }
        }
    }
}
