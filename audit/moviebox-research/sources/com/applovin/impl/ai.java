package com.applovin.impl;

import android.net.Uri;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ai implements wd, m8, oc.b, oc.f, bj.d {
    private static final Map N = l();
    private static final f9 O = new f9.b().c("icy").f("application/x-icy").a();
    private boolean B;
    private boolean D;
    private boolean E;
    private int F;
    private long H;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f17661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i5 f17662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b7 f17663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final mc f17664d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ce.a f17665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a7.a f17666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f17667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final n0 f17668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f17669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f17670k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zh f17672m;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private wd.a f17677r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private va f17678s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f17681v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f17682w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f17683x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private e f17684y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ij f17685z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final oc f17671l = new oc("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final c4 f17673n = new c4();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Runnable f17674o = new Runnable() { // from class: com.applovin.impl.ss
        @Override // java.lang.Runnable
        public final void run() {
            this.f23133a.r();
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Runnable f17675p = new Runnable() { // from class: com.applovin.impl.ts
        @Override // java.lang.Runnable
        public final void run() {
            this.f23426a.q();
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Handler f17676q = xp.a();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private d[] f17680u = new d[0];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private bj[] f17679t = new bj[0];
    private long I = C.TIME_UNSET;
    private long G = -1;
    private long A = C.TIME_UNSET;
    private int C = 1;

    /* JADX INFO: compiled from: source.java */
    public final class a implements oc.e, ta.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f17687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final fl f17688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final zh f17689d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final m8 f17690e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final c4 f17691f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile boolean f17693h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f17695j;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private qo f17698m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f17699n;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final th f17692g = new th();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f17694i = true;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f17697l = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f17686a = nc.a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private l5 f17696k = a(0);

        public a(Uri uri, i5 i5Var, zh zhVar, m8 m8Var, c4 c4Var) {
            this.f17687b = uri;
            this.f17688c = new fl(i5Var);
            this.f17689d = zhVar;
            this.f17690e = m8Var;
            this.f17691f = c4Var;
        }

        private l5 a(long j11) {
            return new l5.b().a(this.f17687b).a(j11).a(ai.this.f17669j).a(6).a(ai.N).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j11, long j12) {
            this.f17692g.f23379a = j11;
            this.f17695j = j12;
            this.f17694i = true;
            this.f17699n = false;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0027 */
        @Override // com.applovin.impl.oc.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() {
            int iA = 0;
            while (iA == 0 && !this.f17693h) {
                long j11 = this.f17692g.f23379a;
                l5 l5VarA = a(j11);
                this.f17696k = l5VarA;
                long jA = this.f17688c.a(l5VarA);
                this.f17697l = jA;
                if (jA != -1) {
                    this.f17697l = jA + j11;
                }
                ai.this.f17678s = va.a(this.f17688c.e());
                g5 taVar = this.f17688c;
                if (ai.this.f17678s != null && ai.this.f17678s.f23816g != -1) {
                    taVar = new ta(this.f17688c, ai.this.f17678s.f23816g, this);
                    qo qoVarO = ai.this.o();
                    this.f17698m = qoVarO;
                    qoVarO.a(ai.O);
                }
                long jB = j11;
                this.f17689d.a(taVar, this.f17687b, this.f17688c.e(), j11, this.f17697l, this.f17690e);
                if (ai.this.f17678s != null) {
                    this.f17689d.c();
                }
                if (this.f17694i) {
                    this.f17689d.a(jB, this.f17695j);
                    this.f17694i = false;
                }
                while (true) {
                    long j12 = jB;
                    while (true) {
                        if (iA != 0 || this.f17693h) {
                            break;
                        }
                        try {
                            this.f17691f.a();
                            iA = this.f17689d.a(this.f17692g);
                            jB = this.f17689d.b();
                            if (jB > ai.this.f17670k + j12) {
                                this.f17691f.c();
                                ai.this.f17676q.post(ai.this.f17675p);
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                }
                if (iA == 1) {
                    iA = 0;
                } else if (this.f17689d.b() != -1) {
                    this.f17692g.f23379a = this.f17689d.b();
                }
                xp.a((i5) this.f17688c);
            }
        }

        @Override // com.applovin.impl.ta.a
        public void a(bh bhVar) {
            long jMax = !this.f17699n ? this.f17695j : Math.max(ai.this.n(), this.f17695j);
            int iA = bhVar.a();
            qo qoVar = (qo) b1.a(this.f17698m);
            qoVar.a(bhVar, iA);
            qoVar.a(jMax, 1, iA, 0, null);
            this.f17699n = true;
        }

        @Override // com.applovin.impl.oc.e
        public void b() {
            this.f17693h = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(long j11, boolean z11, boolean z12);
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements cj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17701a;

        public c(int i11) {
            this.f17701a = i11;
        }

        @Override // com.applovin.impl.cj
        public int a(long j11) {
            return ai.this.a(this.f17701a, j11);
        }

        @Override // com.applovin.impl.cj
        public int a(g9 g9Var, p5 p5Var, int i11) {
            return ai.this.a(this.f17701a, g9Var, p5Var, i11);
        }

        @Override // com.applovin.impl.cj
        public void a() throws IOException {
            ai.this.d(this.f17701a);
        }

        @Override // com.applovin.impl.cj
        public boolean d() {
            return ai.this.a(this.f17701a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17704b;

        public d(int i11, boolean z11) {
            this.f17703a = i11;
            this.f17704b = z11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f17703a == dVar.f17703a && this.f17704b == dVar.f17704b;
        }

        public int hashCode() {
            return (this.f17703a * 31) + (this.f17704b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final po f17705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f17706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean[] f17707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean[] f17708d;

        public e(po poVar, boolean[] zArr) {
            this.f17705a = poVar;
            this.f17706b = zArr;
            int i11 = poVar.f21810a;
            this.f17707c = new boolean[i11];
            this.f17708d = new boolean[i11];
        }
    }

    public ai(Uri uri, i5 i5Var, zh zhVar, b7 b7Var, a7.a aVar, mc mcVar, ce.a aVar2, b bVar, n0 n0Var, String str, int i11) {
        this.f17661a = uri;
        this.f17662b = i5Var;
        this.f17663c = b7Var;
        this.f17666g = aVar;
        this.f17664d = mcVar;
        this.f17665f = aVar2;
        this.f17667h = bVar;
        this.f17668i = n0Var;
        this.f17669j = str;
        this.f17670k = i11;
        this.f17672m = zhVar;
    }

    private qo a(d dVar) {
        int length = this.f17679t.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (dVar.equals(this.f17680u[i11])) {
                return this.f17679t[i11];
            }
        }
        bj bjVarA = bj.a(this.f17668i, this.f17676q.getLooper(), this.f17663c, this.f17666g);
        bjVarA.a(this);
        int i12 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f17680u, i12);
        dVarArr[length] = dVar;
        this.f17680u = (d[]) xp.a((Object[]) dVarArr);
        bj[] bjVarArr = (bj[]) Arrays.copyOf(this.f17679t, i12);
        bjVarArr[length] = bjVarA;
        this.f17679t = (bj[]) xp.a((Object[]) bjVarArr);
        return bjVarA;
    }

    private void a(a aVar) {
        if (this.G == -1) {
            this.G = aVar.f17697l;
        }
    }

    private boolean a(a aVar, int i11) {
        ij ijVar;
        if (this.G != -1 || ((ijVar = this.f17685z) != null && ijVar.d() != C.TIME_UNSET)) {
            this.K = i11;
            return true;
        }
        if (this.f17682w && !v()) {
            this.J = true;
            return false;
        }
        this.E = this.f17682w;
        this.H = 0L;
        this.K = 0;
        for (bj bjVar : this.f17679t) {
            bjVar.n();
        }
        aVar.a(0L, 0L);
        return true;
    }

    private boolean a(boolean[] zArr, long j11) {
        int length = this.f17679t.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (!this.f17679t[i11].b(j11, false) && (zArr[i11] || !this.f17683x)) {
                return false;
            }
        }
        return true;
    }

    private void b(int i11) {
        k();
        e eVar = this.f17684y;
        boolean[] zArr = eVar.f17708d;
        if (zArr[i11]) {
            return;
        }
        f9 f9VarA = eVar.f17705a.a(i11).a(0);
        this.f17665f.a(Cif.e(f9VarA.f18900m), f9VarA, 0, (Object) null, this.H);
        zArr[i11] = true;
    }

    private void c(int i11) {
        k();
        boolean[] zArr = this.f17684y.f17706b;
        if (this.J && zArr[i11]) {
            if (this.f17679t[i11].a(false)) {
                return;
            }
            this.I = 0L;
            this.J = false;
            this.E = true;
            this.H = 0L;
            this.K = 0;
            for (bj bjVar : this.f17679t) {
                bjVar.n();
            }
            ((wd.a) b1.a(this.f17677r)).a((pj) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(ij ijVar) {
        this.f17685z = this.f17678s == null ? ijVar : new ij.b(C.TIME_UNSET);
        this.A = ijVar.d();
        boolean z11 = this.G == -1 && ijVar.d() == C.TIME_UNSET;
        this.B = z11;
        this.C = z11 ? 7 : 1;
        this.f17667h.a(this.A, ijVar.b(), this.B);
        if (this.f17682w) {
            return;
        }
        r();
    }

    private void k() {
        b1.b(this.f17682w);
        b1.a(this.f17684y);
        b1.a(this.f17685z);
    }

    private static Map l() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(map);
    }

    private int m() {
        int iG = 0;
        for (bj bjVar : this.f17679t) {
            iG += bjVar.g();
        }
        return iG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long n() {
        long jMax = Long.MIN_VALUE;
        for (bj bjVar : this.f17679t) {
            jMax = Math.max(jMax, bjVar.c());
        }
        return jMax;
    }

    private boolean p() {
        return this.I != C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        if (this.M) {
            return;
        }
        ((wd.a) b1.a(this.f17677r)).a((pj) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.M || this.f17682w || !this.f17681v || this.f17685z == null) {
            return;
        }
        for (bj bjVar : this.f17679t) {
            if (bjVar.f() == null) {
                return;
            }
        }
        this.f17673n.c();
        int length = this.f17679t.length;
        oo[] ooVarArr = new oo[length];
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            f9 f9VarA = (f9) b1.a(this.f17679t[i11].f());
            String str = f9VarA.f18900m;
            boolean zG = Cif.g(str);
            boolean z11 = zG || Cif.i(str);
            zArr[i11] = z11;
            this.f17683x = z11 | this.f17683x;
            va vaVar = this.f17678s;
            if (vaVar != null) {
                if (zG || this.f17680u[i11].f17704b) {
                    bf bfVar = f9VarA.f18898k;
                    f9VarA = f9VarA.a().a(bfVar == null ? new bf(vaVar) : bfVar.a(vaVar)).a();
                }
                if (zG && f9VarA.f18894g == -1 && f9VarA.f18895h == -1 && vaVar.f23811a != -1) {
                    f9VarA = f9VarA.a().b(vaVar.f23811a).a();
                }
            }
            ooVarArr[i11] = new oo(f9VarA.a(this.f17663c.a(f9VarA)));
        }
        this.f17684y = new e(new po(ooVarArr), zArr);
        this.f17682w = true;
        ((wd.a) b1.a(this.f17677r)).a((wd) this);
    }

    private void u() {
        a aVar = new a(this.f17661a, this.f17662b, this.f17672m, this, this.f17673n);
        if (this.f17682w) {
            b1.b(p());
            long j11 = this.A;
            if (j11 != C.TIME_UNSET && this.I > j11) {
                this.L = true;
                this.I = C.TIME_UNSET;
                return;
            }
            aVar.a(((ij) b1.a(this.f17685z)).b(this.I).f19729a.f20257b, this.I);
            for (bj bjVar : this.f17679t) {
                bjVar.c(this.I);
            }
            this.I = C.TIME_UNSET;
        }
        this.K = m();
        this.f17665f.c(new nc(aVar.f17686a, aVar.f17696k, this.f17671l.a(aVar, this, this.f17664d.a(this.C))), 1, -1, null, 0, null, aVar.f17695j, this.A);
    }

    private boolean v() {
        return this.E || p();
    }

    public int a(int i11, long j11) {
        if (v()) {
            return 0;
        }
        b(i11);
        bj bjVar = this.f17679t[i11];
        int iA = bjVar.a(j11, this.L);
        bjVar.f(iA);
        if (iA == 0) {
            c(i11);
        }
        return iA;
    }

    public int a(int i11, g9 g9Var, p5 p5Var, int i12) {
        if (v()) {
            return -3;
        }
        b(i11);
        int iA = this.f17679t[i11].a(g9Var, p5Var, i12, this.L);
        if (iA == -3) {
            c(i11);
        }
        return iA;
    }

    @Override // com.applovin.impl.wd
    public long a(long j11) {
        k();
        boolean[] zArr = this.f17684y.f17706b;
        if (!this.f17685z.b()) {
            j11 = 0;
        }
        int i11 = 0;
        this.E = false;
        this.H = j11;
        if (p()) {
            this.I = j11;
            return j11;
        }
        if (this.C != 7 && a(zArr, j11)) {
            return j11;
        }
        this.J = false;
        this.I = j11;
        this.L = false;
        if (this.f17671l.d()) {
            bj[] bjVarArr = this.f17679t;
            int length = bjVarArr.length;
            while (i11 < length) {
                bjVarArr[i11].b();
                i11++;
            }
            this.f17671l.a();
        } else {
            this.f17671l.b();
            bj[] bjVarArr2 = this.f17679t;
            int length2 = bjVarArr2.length;
            while (i11 < length2) {
                bjVarArr2[i11].n();
                i11++;
            }
        }
        return j11;
    }

    @Override // com.applovin.impl.wd
    public long a(long j11, jj jjVar) {
        k();
        if (!this.f17685z.b()) {
            return 0L;
        }
        ij.a aVarB = this.f17685z.b(j11);
        return jjVar.a(j11, aVarB.f19729a.f20256a, aVarB.f19730b.f20256a);
    }

    @Override // com.applovin.impl.wd
    public long a(h8[] h8VarArr, boolean[] zArr, cj[] cjVarArr, boolean[] zArr2, long j11) {
        h8 h8Var;
        k();
        e eVar = this.f17684y;
        po poVar = eVar.f17705a;
        boolean[] zArr3 = eVar.f17707c;
        int i11 = this.F;
        int i12 = 0;
        for (int i13 = 0; i13 < h8VarArr.length; i13++) {
            cj cjVar = cjVarArr[i13];
            if (cjVar != null && (h8VarArr[i13] == null || !zArr[i13])) {
                int i14 = ((c) cjVar).f17701a;
                b1.b(zArr3[i14]);
                this.F--;
                zArr3[i14] = false;
                cjVarArr[i13] = null;
            }
        }
        boolean z11 = !this.D ? j11 == 0 : i11 != 0;
        for (int i15 = 0; i15 < h8VarArr.length; i15++) {
            if (cjVarArr[i15] == null && (h8Var = h8VarArr[i15]) != null) {
                b1.b(h8Var.b() == 1);
                b1.b(h8Var.b(0) == 0);
                int iA = poVar.a(h8Var.a());
                b1.b(!zArr3[iA]);
                this.F++;
                zArr3[iA] = true;
                cjVarArr[i15] = new c(iA);
                zArr2[i15] = true;
                if (!z11) {
                    bj bjVar = this.f17679t[iA];
                    z11 = (bjVar.b(j11, true) || bjVar.e() == 0) ? false : true;
                }
            }
        }
        if (this.F == 0) {
            this.J = false;
            this.E = false;
            if (this.f17671l.d()) {
                bj[] bjVarArr = this.f17679t;
                int length = bjVarArr.length;
                while (i12 < length) {
                    bjVarArr[i12].b();
                    i12++;
                }
                this.f17671l.a();
            } else {
                bj[] bjVarArr2 = this.f17679t;
                int length2 = bjVarArr2.length;
                while (i12 < length2) {
                    bjVarArr2[i12].n();
                    i12++;
                }
            }
        } else if (z11) {
            j11 = a(j11);
            while (i12 < cjVarArr.length) {
                if (cjVarArr[i12] != null) {
                    zArr2[i12] = true;
                }
                i12++;
            }
        }
        this.D = true;
        return j11;
    }

    @Override // com.applovin.impl.oc.b
    public oc.c a(a aVar, long j11, long j12, IOException iOException, int i11) {
        oc.c cVarA;
        a(aVar);
        fl flVar = aVar.f17688c;
        nc ncVar = new nc(aVar.f17686a, aVar.f17696k, flVar.h(), flVar.i(), j11, j12, flVar.g());
        long jA = this.f17664d.a(new mc.a(ncVar, new ud(1, -1, null, 0, null, t2.b(aVar.f17695j), t2.b(this.A)), iOException, i11));
        if (jA == C.TIME_UNSET) {
            cVarA = oc.f21488g;
        } else {
            int iM = m();
            cVarA = a(aVar, iM) ? oc.a(iM > this.K, jA) : oc.f21487f;
        }
        boolean z11 = !cVarA.a();
        this.f17665f.a(ncVar, 1, -1, null, 0, null, aVar.f17695j, this.A, iOException, z11);
        if (z11) {
            this.f17664d.a(aVar.f17686a);
        }
        return cVarA;
    }

    @Override // com.applovin.impl.m8
    public qo a(int i11, int i12) {
        return a(new d(i11, false));
    }

    @Override // com.applovin.impl.wd
    public void a(long j11, boolean z11) {
        k();
        if (p()) {
            return;
        }
        boolean[] zArr = this.f17684y.f17707c;
        int length = this.f17679t.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f17679t[i11].b(j11, z11, zArr[i11]);
        }
    }

    @Override // com.applovin.impl.oc.b
    public void a(a aVar, long j11, long j12) {
        ij ijVar;
        if (this.A == C.TIME_UNSET && (ijVar = this.f17685z) != null) {
            boolean zB = ijVar.b();
            long jN = n();
            long j13 = jN == Long.MIN_VALUE ? 0L : jN + 10000;
            this.A = j13;
            this.f17667h.a(j13, zB, this.B);
        }
        fl flVar = aVar.f17688c;
        nc ncVar = new nc(aVar.f17686a, aVar.f17696k, flVar.h(), flVar.i(), j11, j12, flVar.g());
        this.f17664d.a(aVar.f17686a);
        this.f17665f.b(ncVar, 1, -1, null, 0, null, aVar.f17695j, this.A);
        a(aVar);
        this.L = true;
        ((wd.a) b1.a(this.f17677r)).a((pj) this);
    }

    @Override // com.applovin.impl.oc.b
    public void a(a aVar, long j11, long j12, boolean z11) {
        fl flVar = aVar.f17688c;
        nc ncVar = new nc(aVar.f17686a, aVar.f17696k, flVar.h(), flVar.i(), j11, j12, flVar.g());
        this.f17664d.a(aVar.f17686a);
        this.f17665f.a(ncVar, 1, -1, null, 0, null, aVar.f17695j, this.A);
        if (z11) {
            return;
        }
        a(aVar);
        for (bj bjVar : this.f17679t) {
            bjVar.n();
        }
        if (this.F > 0) {
            ((wd.a) b1.a(this.f17677r)).a((pj) this);
        }
    }

    @Override // com.applovin.impl.bj.d
    public void a(f9 f9Var) {
        this.f17676q.post(this.f17674o);
    }

    @Override // com.applovin.impl.m8
    public void a(final ij ijVar) {
        this.f17676q.post(new Runnable() { // from class: com.applovin.impl.us
            @Override // java.lang.Runnable
            public final void run() {
                this.f23704a.b(ijVar);
            }
        });
    }

    @Override // com.applovin.impl.wd
    public void a(wd.a aVar, long j11) {
        this.f17677r = aVar;
        this.f17673n.e();
        u();
    }

    @Override // com.applovin.impl.wd
    public boolean a() {
        return this.f17671l.d() && this.f17673n.d();
    }

    public boolean a(int i11) {
        return !v() && this.f17679t[i11].a(this.L);
    }

    @Override // com.applovin.impl.wd
    public po b() {
        k();
        return this.f17684y.f17705a;
    }

    @Override // com.applovin.impl.wd
    public boolean b(long j11) {
        if (this.L || this.f17671l.c() || this.J) {
            return false;
        }
        if (this.f17682w && this.F == 0) {
            return false;
        }
        boolean zE = this.f17673n.e();
        if (this.f17671l.d()) {
            return zE;
        }
        u();
        return true;
    }

    @Override // com.applovin.impl.m8
    public void c() {
        this.f17681v = true;
        this.f17676q.post(this.f17674o);
    }

    @Override // com.applovin.impl.wd
    public void c(long j11) {
    }

    @Override // com.applovin.impl.oc.f
    public void d() {
        for (bj bjVar : this.f17679t) {
            bjVar.l();
        }
        this.f17672m.a();
    }

    public void d(int i11) throws IOException {
        this.f17679t[i11].j();
        s();
    }

    @Override // com.applovin.impl.wd
    public long e() {
        long jN;
        k();
        boolean[] zArr = this.f17684y.f17706b;
        if (this.L) {
            return Long.MIN_VALUE;
        }
        if (p()) {
            return this.I;
        }
        if (this.f17683x) {
            int length = this.f17679t.length;
            jN = Long.MAX_VALUE;
            for (int i11 = 0; i11 < length; i11++) {
                if (zArr[i11] && !this.f17679t[i11].i()) {
                    jN = Math.min(jN, this.f17679t[i11].c());
                }
            }
        } else {
            jN = Long.MAX_VALUE;
        }
        if (jN == Long.MAX_VALUE) {
            jN = n();
        }
        return jN == Long.MIN_VALUE ? this.H : jN;
    }

    @Override // com.applovin.impl.wd
    public void f() throws IOException {
        s();
        if (this.L && !this.f17682w) {
            throw dh.a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.applovin.impl.wd
    public long g() {
        if (this.F == 0) {
            return Long.MIN_VALUE;
        }
        return e();
    }

    @Override // com.applovin.impl.wd
    public long h() {
        if (!this.E) {
            return C.TIME_UNSET;
        }
        if (!this.L && m() <= this.K) {
            return C.TIME_UNSET;
        }
        this.E = false;
        return this.H;
    }

    public qo o() {
        return a(new d(0, true));
    }

    public void s() throws IOException {
        this.f17671l.a(this.f17664d.a(this.C));
    }

    public void t() {
        if (this.f17682w) {
            for (bj bjVar : this.f17679t) {
                bjVar.k();
            }
        }
        this.f17671l.a(this);
        this.f17676q.removeCallbacksAndMessages(null);
        this.f17677r = null;
        this.M = true;
    }
}
