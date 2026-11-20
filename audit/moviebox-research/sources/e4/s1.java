package e4;

import android.util.Base64;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s1 implements w3 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.google.common.base.q<String> f63942i = new com.google.common.base.q() { // from class: e4.r1
        @Override // com.google.common.base.q
        /* JADX INFO: renamed from: get */
        public final Object get2() {
            return s1.m();
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Random f63943j = new Random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.common.m0.c f63944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.common.m0.b f63945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, a> f63946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.common.base.q<String> f63947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w3.a f63948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.media3.common.m0 f63949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public String f63950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f63951h;

    /* JADX INFO: compiled from: source.java */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f63952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f63953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f63954c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.media3.exoplayer.source.l.b f63955d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f63956e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f63957f;

        public a(String str, @Nullable int i11, androidx.media3.exoplayer.source.l.b bVar) {
            this.f63952a = str;
            this.f63953b = i11;
            this.f63954c = bVar == null ? -1L : bVar.f11212d;
            if (bVar == null || !bVar.b()) {
                return;
            }
            this.f63955d = bVar;
        }

        public boolean i(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
            if (bVar == null) {
                return i11 == this.f63953b;
            }
            androidx.media3.exoplayer.source.l.b bVar2 = this.f63955d;
            if (bVar2 == null) {
                return !bVar.b() && bVar.f11212d == this.f63954c;
            }
            return bVar.f11212d == bVar2.f11212d && bVar.f11210b == bVar2.f11210b && bVar.f11211c == bVar2.f11211c;
        }

        public boolean j(c.a aVar) {
            androidx.media3.exoplayer.source.l.b bVar = aVar.f63815d;
            if (bVar == null) {
                return this.f63953b != aVar.f63814c;
            }
            long j11 = this.f63954c;
            if (j11 == -1) {
                return false;
            }
            if (bVar.f11212d > j11) {
                return true;
            }
            if (this.f63955d == null) {
                return false;
            }
            int iB = aVar.f63813b.b(bVar.f11209a);
            int iB2 = aVar.f63813b.b(this.f63955d.f11209a);
            androidx.media3.exoplayer.source.l.b bVar2 = aVar.f63815d;
            if (bVar2.f11212d < this.f63955d.f11212d || iB < iB2) {
                return false;
            }
            if (iB > iB2) {
                return true;
            }
            if (!bVar2.b()) {
                int i11 = aVar.f63815d.f11213e;
                return i11 == -1 || i11 > this.f63955d.f11210b;
            }
            androidx.media3.exoplayer.source.l.b bVar3 = aVar.f63815d;
            int i12 = bVar3.f11210b;
            int i13 = bVar3.f11211c;
            androidx.media3.exoplayer.source.l.b bVar4 = this.f63955d;
            int i14 = bVar4.f11210b;
            if (i12 <= i14) {
                return i12 == i14 && i13 > bVar4.f11211c;
            }
            return true;
        }

        public void k(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
            if (this.f63954c != -1 || i11 != this.f63953b || bVar == null || bVar.f11212d < s1.this.n()) {
                return;
            }
            this.f63954c = bVar.f11212d;
        }

        public final int l(androidx.media3.common.m0 m0Var, androidx.media3.common.m0 m0Var2, int i11) {
            if (i11 >= m0Var.p()) {
                if (i11 < m0Var2.p()) {
                    return i11;
                }
                return -1;
            }
            m0Var.n(i11, s1.this.f63944a);
            for (int i12 = s1.this.f63944a.f9323o; i12 <= s1.this.f63944a.f9324p; i12++) {
                int iB = m0Var2.b(m0Var.m(i12));
                if (iB != -1) {
                    return m0Var2.f(iB, s1.this.f63945b).f9295c;
                }
            }
            return -1;
        }

        public boolean m(androidx.media3.common.m0 m0Var, androidx.media3.common.m0 m0Var2) {
            int iL = l(m0Var, m0Var2, this.f63953b);
            this.f63953b = iL;
            if (iL == -1) {
                return false;
            }
            androidx.media3.exoplayer.source.l.b bVar = this.f63955d;
            return bVar == null || m0Var2.b(bVar.f11209a) != -1;
        }
    }

    public s1() {
        this(f63942i);
    }

    public s1(com.google.common.base.q<String> qVar) {
        this.f63947d = qVar;
        this.f63944a = new androidx.media3.common.m0.c();
        this.f63945b = new androidx.media3.common.m0.b();
        this.f63946c = new HashMap<>();
        this.f63949f = androidx.media3.common.m0.f9282a;
        this.f63951h = -1L;
    }

    public static String m() {
        byte[] bArr = new byte[12];
        f63943j.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // e4.w3
    @Nullable
    public synchronized String a() {
        return this.f63950g;
    }

    @Override // e4.w3
    public synchronized String b(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar) {
        return o(m0Var.h(bVar.f11209a, this.f63945b).f9295c, bVar).f63952a;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d6  */
    @Override // e4.w3
    public synchronized void c(c.a aVar) {
        c.a aVar2;
        a aVar3;
        z3.a.e(this.f63948e);
        if (aVar.f63813b.q()) {
            return;
        }
        androidx.media3.exoplayer.source.l.b bVar = aVar.f63815d;
        if (bVar != null) {
            if (bVar.f11212d < n()) {
                return;
            }
            a aVar4 = this.f63946c.get(this.f63950g);
            if (aVar4 != null && aVar4.f63954c == -1 && aVar4.f63953b != aVar.f63814c) {
                return;
            }
        }
        a aVarO = o(aVar.f63814c, aVar.f63815d);
        if (this.f63950g == null) {
            this.f63950g = aVarO.f63952a;
        }
        androidx.media3.exoplayer.source.l.b bVar2 = aVar.f63815d;
        if (bVar2 != null && bVar2.b()) {
            androidx.media3.exoplayer.source.l.b bVar3 = aVar.f63815d;
            androidx.media3.exoplayer.source.l.b bVar4 = new androidx.media3.exoplayer.source.l.b(bVar3.f11209a, bVar3.f11212d, bVar3.f11210b);
            a aVarO2 = o(aVar.f63814c, bVar4);
            if (!aVarO2.f63956e) {
                aVarO2.f63956e = true;
                aVar.f63813b.h(aVar.f63815d.f11209a, this.f63945b);
                this.f63948e.o0(new c.a(aVar.f63812a, aVar.f63813b, aVar.f63814c, bVar4, Math.max(0L, z3.u0.B1(this.f63945b.f(aVar.f63815d.f11210b)) + this.f63945b.n()), aVar.f63817f, aVar.f63818g, aVar.f63819h, aVar.f63820i, aVar.f63821j), aVarO2.f63952a);
            }
        }
        if (aVarO.f63956e) {
            aVar2 = aVar;
            aVar3 = aVarO;
        } else {
            aVar3 = aVarO;
            aVar3.f63956e = true;
            aVar2 = aVar;
            this.f63948e.o0(aVar2, aVar3.f63952a);
        }
        if (aVar3.f63952a.equals(this.f63950g) && !aVar3.f63957f) {
            aVar3.f63957f = true;
            this.f63948e.p0(aVar2, aVar3.f63952a);
        }
    }

    @Override // e4.w3
    public synchronized void d(c.a aVar) {
        w3.a aVar2;
        try {
            String str = this.f63950g;
            if (str != null) {
                l((a) z3.a.e(this.f63946c.get(str)));
            }
            Iterator<a> it = this.f63946c.values().iterator();
            while (it.hasNext()) {
                a next = it.next();
                it.remove();
                if (next.f63956e && (aVar2 = this.f63948e) != null) {
                    aVar2.q0(aVar, next.f63952a, false);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // e4.w3
    public synchronized void e(c.a aVar, int i11) {
        try {
            z3.a.e(this.f63948e);
            boolean z11 = i11 == 0;
            Iterator<a> it = this.f63946c.values().iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.j(aVar)) {
                    it.remove();
                    if (next.f63956e) {
                        boolean zEquals = next.f63952a.equals(this.f63950g);
                        boolean z12 = z11 && zEquals && next.f63957f;
                        if (zEquals) {
                            l(next);
                        }
                        this.f63948e.q0(aVar, next.f63952a, z12);
                    }
                }
            }
            p(aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // e4.w3
    public void f(w3.a aVar) {
        this.f63948e = aVar;
    }

    @Override // e4.w3
    public synchronized void g(c.a aVar) {
        try {
            z3.a.e(this.f63948e);
            androidx.media3.common.m0 m0Var = this.f63949f;
            this.f63949f = aVar.f63813b;
            Iterator<a> it = this.f63946c.values().iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (!next.m(m0Var, this.f63949f) || next.j(aVar)) {
                    it.remove();
                    if (next.f63956e) {
                        if (next.f63952a.equals(this.f63950g)) {
                            l(next);
                        }
                        this.f63948e.q0(aVar, next.f63952a, false);
                    }
                }
            }
            p(aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void l(a aVar) {
        if (aVar.f63954c != -1) {
            this.f63951h = aVar.f63954c;
        }
        this.f63950g = null;
    }

    public final long n() {
        a aVar = this.f63946c.get(this.f63950g);
        return (aVar == null || aVar.f63954c == -1) ? this.f63951h + 1 : aVar.f63954c;
    }

    public final a o(int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
        a aVar = null;
        long j11 = Long.MAX_VALUE;
        for (a aVar2 : this.f63946c.values()) {
            aVar2.k(i11, bVar);
            if (aVar2.i(i11, bVar)) {
                long j12 = aVar2.f63954c;
                if (j12 == -1 || j12 < j11) {
                    aVar = aVar2;
                    j11 = j12;
                } else if (j12 == j11 && ((a) z3.u0.i(aVar)).f63955d != null && aVar2.f63955d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = this.f63947d.get2();
        a aVar3 = new a(str, i11, bVar);
        this.f63946c.put(str, aVar3);
        return aVar3;
    }

    public final void p(c.a aVar) {
        if (aVar.f63813b.q()) {
            String str = this.f63950g;
            if (str != null) {
                l((a) z3.a.e(this.f63946c.get(str)));
                return;
            }
            return;
        }
        a aVar2 = this.f63946c.get(this.f63950g);
        a aVarO = o(aVar.f63814c, aVar.f63815d);
        this.f63950g = aVarO.f63952a;
        c(aVar);
        androidx.media3.exoplayer.source.l.b bVar = aVar.f63815d;
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (aVar2 != null && aVar2.f63954c == aVar.f63815d.f11212d && aVar2.f63955d != null && aVar2.f63955d.f11210b == aVar.f63815d.f11210b && aVar2.f63955d.f11211c == aVar.f63815d.f11211c) {
            return;
        }
        androidx.media3.exoplayer.source.l.b bVar2 = aVar.f63815d;
        this.f63948e.a(aVar, o(aVar.f63814c, new androidx.media3.exoplayer.source.l.b(bVar2.f11209a, bVar2.f11212d)).f63952a, aVarO.f63952a);
    }
}
