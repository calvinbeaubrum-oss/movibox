package com.applovin.impl;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class of implements k8 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final o8 f21508u = new o8() { // from class: com.applovin.impl.r00
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return of.d();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final xa.a f21509v = new xa.a() { // from class: com.applovin.impl.s00
        @Override // com.applovin.impl.xa.a
        public final boolean a(int i11, int i12, int i13, int i14, int i15) {
            return of.a(i11, i12, i13, i14, i15);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f21511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bh f21512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final tf.a f21513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final z9 f21514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final za f21515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final qo f21516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private m8 f21517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private qo f21518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private qo f21519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f21520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private bf f21521l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f21522m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f21523n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f21524o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f21525p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private lj f21526q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f21527r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f21528s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f21529t;

    public of() {
        this(0);
    }

    public of(int i11) {
        this(i11, C.TIME_UNSET);
    }

    public of(int i11, long j11) {
        this.f21510a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f21511b = j11;
        this.f21512c = new bh(10);
        this.f21513d = new tf.a();
        this.f21514e = new z9();
        this.f21522m = C.TIME_UNSET;
        this.f21515f = new za();
        i7 i7Var = new i7();
        this.f21516g = i7Var;
        this.f21519j = i7Var;
    }

    private static int a(bh bhVar, int i11) {
        if (bhVar.e() >= i11 + 4) {
            bhVar.f(i11);
            int iJ = bhVar.j();
            if (iJ == 1483304551 || iJ == 1231971951) {
                return iJ;
            }
        }
        if (bhVar.e() < 40) {
            return 0;
        }
        bhVar.f(36);
        return bhVar.j() == 1447187017 ? 1447187017 : 0;
    }

    private long a(long j11) {
        return this.f21522m + ((j11 * 1000000) / ((long) this.f21513d.f23373d));
    }

    private static long a(bf bfVar) {
        if (bfVar == null) {
            return C.TIME_UNSET;
        }
        int iC = bfVar.c();
        for (int i11 = 0; i11 < iC; i11++) {
            bf.b bVarA = bfVar.a(i11);
            if (bVarA instanceof zn) {
                zn znVar = (zn) bVarA;
                if (znVar.f24575a.equals("TLEN")) {
                    return t2.a(Long.parseLong(znVar.f24899c));
                }
            }
        }
        return C.TIME_UNSET;
    }

    private static kf a(bf bfVar, long j11) {
        if (bfVar == null) {
            return null;
        }
        int iC = bfVar.c();
        for (int i11 = 0; i11 < iC; i11++) {
            bf.b bVarA = bfVar.a(i11);
            if (bVarA instanceof jf) {
                return kf.a(j11, (jf) bVarA, a(bfVar));
            }
        }
        return null;
    }

    private lj a(l8 l8Var, boolean z11) {
        l8Var.c(this.f21512c.c(), 0, 4);
        this.f21512c.f(0);
        this.f21513d.a(this.f21512c.j());
        return new q4(l8Var.a(), l8Var.f(), this.f21513d, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(int i11, int i12, int i13, int i14, int i15) {
        return (i12 == 67 && i13 == 79 && i14 == 77 && (i15 == 77 || i11 == 2)) || (i12 == 77 && i13 == 76 && i14 == 76 && (i15 == 84 || i11 == 2));
    }

    private static boolean a(int i11, long j11) {
        return ((long) (i11 & (-128000))) == (j11 & (-128000));
    }

    private lj b(l8 l8Var) {
        long jA;
        long jC;
        lj ljVarC = c(l8Var);
        kf kfVarA = a(this.f21521l, l8Var.f());
        if (this.f21527r) {
            return new lj.a();
        }
        if ((this.f21510a & 4) != 0) {
            if (kfVarA != null) {
                jA = kfVarA.d();
                jC = kfVarA.c();
            } else if (ljVarC != null) {
                jA = ljVarC.d();
                jC = ljVarC.c();
            } else {
                jA = a(this.f21521l);
                jC = -1;
            }
            ljVarC = new nb(jA, l8Var.f(), jC);
        } else if (kfVarA != null) {
            ljVarC = kfVarA;
        } else if (ljVarC == null) {
            ljVarC = null;
        }
        if (ljVarC == null || !(ljVarC.b() || (this.f21510a & 1) == 0)) {
            return a(l8Var, (this.f21510a & 2) != 0);
        }
        return ljVarC;
    }

    private void b() {
        b1.b(this.f21518i);
        xp.a(this.f21517h);
    }

    private boolean b(l8 l8Var, boolean z11) throws dh, EOFException {
        int i11;
        int iD;
        int iB;
        int i12 = z11 ? 32768 : 131072;
        l8Var.b();
        if (l8Var.f() == 0) {
            bf bfVarA = this.f21515f.a(l8Var, (this.f21510a & 8) == 0 ? null : f21509v);
            this.f21521l = bfVarA;
            if (bfVarA != null) {
                this.f21514e.a(bfVarA);
            }
            iD = (int) l8Var.d();
            if (!z11) {
                l8Var.a(iD);
            }
            i11 = 0;
        } else {
            i11 = 0;
            iD = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (d(l8Var)) {
                if (i13 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.f21512c.f(0);
            int iJ = this.f21512c.j();
            if ((i11 == 0 || a(iJ, i11)) && (iB = tf.b(iJ)) != -1) {
                i13++;
                if (i13 != 1) {
                    if (i13 == 4) {
                        break;
                    }
                } else {
                    this.f21513d.a(iJ);
                    i11 = iJ;
                }
                l8Var.c(iB - 4);
            } else {
                int i15 = i14 + 1;
                if (i14 == i12) {
                    if (z11) {
                        return false;
                    }
                    throw dh.a("Searched too many bytes.", null);
                }
                if (z11) {
                    l8Var.b();
                    l8Var.c(iD + i15);
                } else {
                    l8Var.a(1);
                }
                i14 = i15;
                i11 = 0;
                i13 = 0;
            }
        }
        if (z11) {
            l8Var.a(iD + i14);
        } else {
            l8Var.b();
        }
        this.f21520k = i11;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002a  */
    private lj c(l8 l8Var) {
        int i11;
        bh bhVar = new bh(this.f21513d.f23372c);
        l8Var.c(bhVar.c(), 0, this.f21513d.f23372c);
        tf.a aVar = this.f21513d;
        if ((aVar.f23370a & 1) != 0) {
            if (aVar.f23374e != 1) {
                i11 = 36;
            } else {
                i11 = 21;
            }
        } else if (aVar.f23374e != 1) {
            i11 = 21;
        } else {
            i11 = 13;
        }
        int iA = a(bhVar, i11);
        if (iA != 1483304551 && iA != 1231971951) {
            if (iA != 1447187017) {
                l8Var.b();
                return null;
            }
            pq pqVarA = pq.a(l8Var.a(), l8Var.f(), this.f21513d, bhVar);
            l8Var.a(this.f21513d.f23372c);
            return pqVarA;
        }
        ds dsVarA = ds.a(l8Var.a(), l8Var.f(), this.f21513d, bhVar);
        if (dsVarA != null && !this.f21514e.a()) {
            l8Var.b();
            l8Var.c(i11 + 141);
            l8Var.c(this.f21512c.c(), 0, 3);
            this.f21512c.f(0);
            this.f21514e.a(this.f21512c.z());
        }
        l8Var.a(this.f21513d.f23372c);
        return (dsVarA == null || dsVarA.b() || iA != 1231971951) ? dsVarA : a(l8Var, false);
    }

    private boolean d(l8 l8Var) {
        lj ljVar = this.f21526q;
        if (ljVar != null) {
            long jC = ljVar.c();
            if (jC != -1 && l8Var.d() > jC - 4) {
                return true;
            }
        }
        try {
            return !l8Var.b(this.f21512c.c(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] d() {
        return new k8[]{new of()};
    }

    private int e(l8 l8Var) throws dh {
        if (this.f21520k == 0) {
            try {
                b(l8Var, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f21526q == null) {
            lj ljVarB = b(l8Var);
            this.f21526q = ljVarB;
            this.f21517h.a(ljVarB);
            this.f21519j.a(new f9.b().f(this.f21513d.f23371b).i(4096).c(this.f21513d.f23374e).n(this.f21513d.f23373d).e(this.f21514e.f24824a).f(this.f21514e.f24825b).a((this.f21510a & 8) != 0 ? null : this.f21521l).a());
            this.f21524o = l8Var.f();
        } else if (this.f21524o != 0) {
            long jF = l8Var.f();
            long j11 = this.f21524o;
            if (jF < j11) {
                l8Var.a((int) (j11 - jF));
            }
        }
        return f(l8Var);
    }

    private int f(l8 l8Var) {
        if (this.f21525p == 0) {
            l8Var.b();
            if (d(l8Var)) {
                return -1;
            }
            this.f21512c.f(0);
            int iJ = this.f21512c.j();
            if (!a(iJ, this.f21520k) || tf.b(iJ) == -1) {
                l8Var.a(1);
                this.f21520k = 0;
                return 0;
            }
            this.f21513d.a(iJ);
            if (this.f21522m == C.TIME_UNSET) {
                this.f21522m = this.f21526q.a(l8Var.f());
                if (this.f21511b != C.TIME_UNSET) {
                    this.f21522m += this.f21511b - this.f21526q.a(0L);
                }
            }
            tf.a aVar = this.f21513d;
            this.f21525p = aVar.f23372c;
            lj ljVar = this.f21526q;
            if (ljVar instanceof nb) {
                nb nbVar = (nb) ljVar;
                nbVar.a(a(this.f21523n + ((long) aVar.f23376g)), l8Var.f() + ((long) this.f21513d.f23372c));
                if (this.f21528s && nbVar.c(this.f21529t)) {
                    this.f21528s = false;
                    this.f21519j = this.f21518i;
                }
            }
        }
        int iA = this.f21519j.a((g5) l8Var, this.f21525p, true);
        if (iA == -1) {
            return -1;
        }
        int i11 = this.f21525p - iA;
        this.f21525p = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f21519j.a(a(this.f21523n), 1, this.f21513d.f23372c, 0, null);
        this.f21523n += (long) this.f21513d.f23376g;
        this.f21525p = 0;
        return 0;
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) throws dh {
        b();
        int iE = e(l8Var);
        if (iE == -1 && (this.f21526q instanceof nb)) {
            long jA = a(this.f21523n);
            if (this.f21526q.d() != jA) {
                ((nb) this.f21526q).d(jA);
                this.f21517h.a(this.f21526q);
            }
        }
        return iE;
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        this.f21520k = 0;
        this.f21522m = C.TIME_UNSET;
        this.f21523n = 0L;
        this.f21525p = 0;
        this.f21529t = j12;
        lj ljVar = this.f21526q;
        if (!(ljVar instanceof nb) || ((nb) ljVar).c(j12)) {
            return;
        }
        this.f21528s = true;
        this.f21519j = this.f21516g;
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f21517h = m8Var;
        qo qoVarA = m8Var.a(0, 1);
        this.f21518i = qoVarA;
        this.f21519j = qoVarA;
        this.f21517h.c();
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        return b(l8Var, true);
    }

    public void c() {
        this.f21527r = true;
    }
}
