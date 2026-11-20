package qg;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r1 implements t1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.common.base.q<String> f74694h = new com.google.common.base.q() { // from class: qg.q1
        @Override // com.google.common.base.q
        /* JADX INFO: renamed from: get */
        public final Object get2() {
            return r1.k();
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Random f74695i = new Random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.d f74696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.b f74697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, a> f74698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.common.base.q<String> f74699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t1.a f74700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j3 f74701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public String f74702g;

    /* JADX INFO: compiled from: source.java */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f74703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f74704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f74705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.google.android.exoplayer2.source.i.b f74706d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f74707e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f74708f;

        public a(String str, @Nullable int i11, com.google.android.exoplayer2.source.i.b bVar) {
            this.f74703a = str;
            this.f74704b = i11;
            this.f74705c = bVar == null ? -1L : bVar.f71963d;
            if (bVar == null || !bVar.b()) {
                return;
            }
            this.f74706d = bVar;
        }

        public boolean i(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
            if (bVar == null) {
                return i11 == this.f74704b;
            }
            com.google.android.exoplayer2.source.i.b bVar2 = this.f74706d;
            if (bVar2 == null) {
                return !bVar.b() && bVar.f71963d == this.f74705c;
            }
            return bVar.f71963d == bVar2.f71963d && bVar.f71961b == bVar2.f71961b && bVar.f71962c == bVar2.f71962c;
        }

        public boolean j(c.a aVar) {
            long j11 = this.f74705c;
            if (j11 == -1) {
                return false;
            }
            com.google.android.exoplayer2.source.i.b bVar = aVar.f74573d;
            if (bVar == null) {
                return this.f74704b != aVar.f74572c;
            }
            if (bVar.f71963d > j11) {
                return true;
            }
            if (this.f74706d == null) {
                return false;
            }
            int iF = aVar.f74571b.f(bVar.f71960a);
            int iF2 = aVar.f74571b.f(this.f74706d.f71960a);
            com.google.android.exoplayer2.source.i.b bVar2 = aVar.f74573d;
            if (bVar2.f71963d < this.f74706d.f71963d || iF < iF2) {
                return false;
            }
            if (iF > iF2) {
                return true;
            }
            if (!bVar2.b()) {
                int i11 = aVar.f74573d.f71964e;
                return i11 == -1 || i11 > this.f74706d.f71961b;
            }
            com.google.android.exoplayer2.source.i.b bVar3 = aVar.f74573d;
            int i12 = bVar3.f71961b;
            int i13 = bVar3.f71962c;
            com.google.android.exoplayer2.source.i.b bVar4 = this.f74706d;
            int i14 = bVar4.f71961b;
            return i12 > i14 || (i12 == i14 && i13 > bVar4.f71962c);
        }

        public void k(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
            if (this.f74705c == -1 && i11 == this.f74704b && bVar != null) {
                this.f74705c = bVar.f71963d;
            }
        }

        public final int l(j3 j3Var, j3 j3Var2, int i11) {
            if (i11 >= j3Var.t()) {
                if (i11 < j3Var2.t()) {
                    return i11;
                }
                return -1;
            }
            j3Var.r(i11, r1.this.f74696a);
            for (int i12 = r1.this.f74696a.f33391p; i12 <= r1.this.f74696a.f33392q; i12++) {
                int iF = j3Var2.f(j3Var.q(i12));
                if (iF != -1) {
                    return j3Var2.j(iF, r1.this.f74697b).f33364c;
                }
            }
            return -1;
        }

        public boolean m(j3 j3Var, j3 j3Var2) {
            int iL = l(j3Var, j3Var2, this.f74704b);
            this.f74704b = iL;
            if (iL == -1) {
                return false;
            }
            com.google.android.exoplayer2.source.i.b bVar = this.f74706d;
            return bVar == null || j3Var2.f(bVar.f71960a) != -1;
        }
    }

    public r1() {
        this(f74694h);
    }

    public r1(com.google.common.base.q<String> qVar) {
        this.f74699d = qVar;
        this.f74696a = new j3.d();
        this.f74697b = new j3.b();
        this.f74698c = new HashMap<>();
        this.f74701f = j3.f33359a;
    }

    public static String k() {
        byte[] bArr = new byte[12];
        f74695i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // qg.t1
    @Nullable
    public synchronized String a() {
        return this.f74702g;
    }

    @Override // qg.t1
    public void b(t1.a aVar) {
        this.f74700e = aVar;
    }

    @Override // qg.t1
    public synchronized void c(c.a aVar) {
        t1.a aVar2;
        this.f74702g = null;
        Iterator<a> it = this.f74698c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            it.remove();
            if (next.f74707e && (aVar2 = this.f74700e) != null) {
                aVar2.M(aVar, next.f74703a, false);
            }
        }
    }

    @Override // qg.t1
    public synchronized void d(c.a aVar) {
        try {
            com.google.android.exoplayer2.util.a.e(this.f74700e);
            j3 j3Var = this.f74701f;
            this.f74701f = aVar.f74571b;
            Iterator<a> it = this.f74698c.values().iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (!next.m(j3Var, this.f74701f) || next.j(aVar)) {
                    it.remove();
                    if (next.f74707e) {
                        if (next.f74703a.equals(this.f74702g)) {
                            this.f74702g = null;
                        }
                        this.f74700e.M(aVar, next.f74703a, false);
                    }
                }
            }
            m(aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00d7  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        if (r25.f74573d.f71963d < r2.f74705c) goto L21;
     */
    @Override // qg.t1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void e(c.a aVar) {
        c.a aVar2;
        a aVar3;
        try {
            com.google.android.exoplayer2.util.a.e(this.f74700e);
            if (aVar.f74571b.u()) {
                return;
            }
            a aVar4 = this.f74698c.get(this.f74702g);
            if (aVar.f74573d != null && aVar4 != null) {
                if (aVar4.f74705c == -1) {
                    if (aVar4.f74704b != aVar.f74572c) {
                        return;
                    }
                }
            }
            a aVarL = l(aVar.f74572c, aVar.f74573d);
            if (this.f74702g == null) {
                this.f74702g = aVarL.f74703a;
            }
            com.google.android.exoplayer2.source.i.b bVar = aVar.f74573d;
            if (bVar != null && bVar.b()) {
                com.google.android.exoplayer2.source.i.b bVar2 = aVar.f74573d;
                com.google.android.exoplayer2.source.i.b bVar3 = new com.google.android.exoplayer2.source.i.b(bVar2.f71960a, bVar2.f71963d, bVar2.f71961b);
                a aVarL2 = l(aVar.f74572c, bVar3);
                if (!aVarL2.f74707e) {
                    aVarL2.f74707e = true;
                    aVar.f74571b.l(aVar.f74573d.f71960a, this.f74697b);
                    this.f74700e.W(new c.a(aVar.f74570a, aVar.f74571b, aVar.f74572c, bVar3, Math.max(0L, com.google.android.exoplayer2.util.o0.f1(this.f74697b.i(aVar.f74573d.f71961b)) + this.f74697b.p()), aVar.f74575f, aVar.f74576g, aVar.f74577h, aVar.f74578i, aVar.f74579j), aVarL2.f74703a);
                }
            }
            if (aVarL.f74707e) {
                aVar2 = aVar;
                aVar3 = aVarL;
            } else {
                aVar3 = aVarL;
                aVar3.f74707e = true;
                aVar2 = aVar;
                this.f74700e.W(aVar2, aVar3.f74703a);
            }
            if (aVar3.f74703a.equals(this.f74702g) && !aVar3.f74708f) {
                aVar3.f74708f = true;
                this.f74700e.m(aVar2, aVar3.f74703a);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // qg.t1
    public synchronized String f(j3 j3Var, com.google.android.exoplayer2.source.i.b bVar) {
        return l(j3Var.l(bVar.f71960a, this.f74697b).f33364c, bVar).f74703a;
    }

    @Override // qg.t1
    public synchronized void g(c.a aVar, int i11) {
        try {
            com.google.android.exoplayer2.util.a.e(this.f74700e);
            boolean z11 = i11 == 0;
            Iterator<a> it = this.f74698c.values().iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.j(aVar)) {
                    it.remove();
                    if (next.f74707e) {
                        boolean zEquals = next.f74703a.equals(this.f74702g);
                        boolean z12 = z11 && zEquals && next.f74708f;
                        if (zEquals) {
                            this.f74702g = null;
                        }
                        this.f74700e.M(aVar, next.f74703a, z12);
                    }
                }
            }
            m(aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final a l(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
        a aVar = null;
        long j11 = Long.MAX_VALUE;
        for (a aVar2 : this.f74698c.values()) {
            aVar2.k(i11, bVar);
            if (aVar2.i(i11, bVar)) {
                long j12 = aVar2.f74705c;
                if (j12 == -1 || j12 < j11) {
                    aVar = aVar2;
                    j11 = j12;
                } else if (j12 == j11 && ((a) com.google.android.exoplayer2.util.o0.j(aVar)).f74706d != null && aVar2.f74706d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = this.f74699d.get2();
        a aVar3 = new a(str, i11, bVar);
        this.f74698c.put(str, aVar3);
        return aVar3;
    }

    public final void m(c.a aVar) {
        if (aVar.f74571b.u()) {
            this.f74702g = null;
            return;
        }
        a aVar2 = this.f74698c.get(this.f74702g);
        a aVarL = l(aVar.f74572c, aVar.f74573d);
        this.f74702g = aVarL.f74703a;
        e(aVar);
        com.google.android.exoplayer2.source.i.b bVar = aVar.f74573d;
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (aVar2 != null && aVar2.f74705c == aVar.f74573d.f71963d && aVar2.f74706d != null && aVar2.f74706d.f71961b == aVar.f74573d.f71961b && aVar2.f74706d.f71962c == aVar.f74573d.f71962c) {
            return;
        }
        com.google.android.exoplayer2.source.i.b bVar2 = aVar.f74573d;
        this.f74700e.j(aVar, l(aVar.f74572c, new com.google.android.exoplayer2.source.i.b(bVar2.f71960a, bVar2.f71963d)).f74703a, aVarL.f74703a);
    }
}
