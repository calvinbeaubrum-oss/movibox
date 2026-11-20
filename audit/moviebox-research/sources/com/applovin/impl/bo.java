package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class bo extends e2 implements Handler.Callback {
    private int A;
    private long B;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Handler f18011n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ao f18012o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ql f18013p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final g9 f18014q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f18015r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f18016s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f18017t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f18018u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private f9 f18019v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ol f18020w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private rl f18021x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private sl f18022y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private sl f18023z;

    public bo(ao aoVar, Looper looper) {
        this(aoVar, looper, ql.f21954a);
    }

    public bo(ao aoVar, Looper looper, ql qlVar) {
        super(3);
        this.f18012o = (ao) b1.a(aoVar);
        this.f18011n = looper == null ? null : xp.a(looper, (Handler.Callback) this);
        this.f18013p = qlVar;
        this.f18014q = new g9();
        this.B = C.TIME_UNSET;
    }

    private long A() {
        if (this.A == -1) {
            return Long.MAX_VALUE;
        }
        b1.a(this.f18022y);
        if (this.A >= this.f18022y.a()) {
            return Long.MAX_VALUE;
        }
        return this.f18022y.a(this.A);
    }

    private void B() {
        this.f18017t = true;
        this.f18020w = this.f18013p.b((f9) b1.a(this.f18019v));
    }

    private void C() {
        this.f18021x = null;
        this.A = -1;
        sl slVar = this.f18022y;
        if (slVar != null) {
            slVar.g();
            this.f18022y = null;
        }
        sl slVar2 = this.f18023z;
        if (slVar2 != null) {
            slVar2.g();
            this.f18023z = null;
        }
    }

    private void D() {
        C();
        ((ol) b1.a(this.f18020w)).a();
        this.f18020w = null;
        this.f18018u = 0;
    }

    private void E() {
        D();
        B();
    }

    private void a(pl plVar) {
        pc.a("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f18019v, plVar);
        z();
        E();
    }

    private void a(List list) {
        this.f18012o.a(list);
    }

    private void b(List list) {
        Handler handler = this.f18011n;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            a(list);
        }
    }

    private void z() {
        b(Collections.emptyList());
    }

    @Override // com.applovin.impl.ri
    public int a(f9 f9Var) {
        if (this.f18013p.a(f9Var)) {
            return v40.a(f9Var.F == 0 ? 4 : 2);
        }
        return Cif.h(f9Var.f18900m) ? v40.a(1) : v40.a(0);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00a9  */
    @Override // com.applovin.impl.qi
    public void a(long j11, long j12) {
        boolean z11;
        if (k()) {
            long j13 = this.B;
            if (j13 != C.TIME_UNSET && j11 >= j13) {
                C();
                this.f18016s = true;
            }
        }
        if (this.f18016s) {
            return;
        }
        if (this.f18023z == null) {
            ((ol) b1.a(this.f18020w)).a(j11);
            try {
                this.f18023z = (sl) ((ol) b1.a(this.f18020w)).c();
            } catch (pl e11) {
                a(e11);
                return;
            }
        }
        if (b() != 2) {
            return;
        }
        if (this.f18022y != null) {
            long jA = A();
            z11 = false;
            while (jA <= j11) {
                this.A++;
                jA = A();
                z11 = true;
            }
        } else {
            z11 = false;
        }
        sl slVar = this.f18023z;
        if (slVar != null) {
            if (!slVar.e()) {
                if (slVar.f24865b <= j11) {
                    sl slVar2 = this.f18022y;
                    if (slVar2 != null) {
                        slVar2.g();
                    }
                    this.A = slVar.a(j11);
                    this.f18022y = slVar;
                    this.f18023z = null;
                }
                b1.a(this.f18022y);
                b(this.f18022y.b(j11));
            } else if (!z11 && A() == Long.MAX_VALUE) {
                if (this.f18018u == 2) {
                    E();
                } else {
                    C();
                    this.f18016s = true;
                }
            }
            if (z11) {
                b1.a(this.f18022y);
                b(this.f18022y.b(j11));
            }
        } else if (z11) {
            b1.a(this.f18022y);
            b(this.f18022y.b(j11));
        }
        if (this.f18018u == 2) {
            return;
        }
        while (!this.f18015r) {
            try {
                rl rlVar = this.f18021x;
                if (rlVar == null) {
                    rlVar = (rl) ((ol) b1.a(this.f18020w)).d();
                    if (rlVar == null) {
                        return;
                    } else {
                        this.f18021x = rlVar;
                    }
                }
                if (this.f18018u == 1) {
                    rlVar.e(4);
                    ((ol) b1.a(this.f18020w)).a(rlVar);
                    this.f18021x = null;
                    this.f18018u = 2;
                    return;
                }
                int iA = a(this.f18014q, rlVar, 0);
                if (iA == -4) {
                    if (rlVar.e()) {
                        this.f18015r = true;
                        this.f18017t = false;
                    } else {
                        f9 f9Var = this.f18014q.f19165b;
                        if (f9Var == null) {
                            return;
                        }
                        rlVar.f22145j = f9Var.f18904q;
                        rlVar.g();
                        this.f18017t &= !rlVar.f();
                    }
                    if (!this.f18017t) {
                        ((ol) b1.a(this.f18020w)).a(rlVar);
                        this.f18021x = null;
                    }
                } else if (iA == -3) {
                    return;
                }
            } catch (pl e12) {
                a(e12);
                return;
            }
        }
    }

    @Override // com.applovin.impl.e2
    public void a(long j11, boolean z11) {
        z();
        this.f18015r = false;
        this.f18016s = false;
        this.B = C.TIME_UNSET;
        if (this.f18018u != 0) {
            E();
        } else {
            C();
            ((ol) b1.a(this.f18020w)).b();
        }
    }

    @Override // com.applovin.impl.e2
    public void a(f9[] f9VarArr, long j11, long j12) {
        this.f18019v = f9VarArr[0];
        if (this.f18020w != null) {
            this.f18018u = 1;
        } else {
            B();
        }
    }

    public void c(long j11) {
        b1.b(k());
        this.B = j11;
    }

    @Override // com.applovin.impl.qi
    public boolean c() {
        return this.f18016s;
    }

    @Override // com.applovin.impl.qi
    public boolean d() {
        return true;
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        a((List) message.obj);
        return true;
    }

    @Override // com.applovin.impl.e2
    public void v() {
        this.f18019v = null;
        this.B = C.TIME_UNSET;
        z();
        D();
    }
}
