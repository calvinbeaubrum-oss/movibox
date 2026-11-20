package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class gf extends e2 implements Handler.Callback {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final df f19218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ff f19219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Handler f19220p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ef f19221q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private cf f19222r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f19223s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f19224t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f19225u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f19226v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private bf f19227w;

    public gf(ff ffVar, Looper looper) {
        this(ffVar, looper, df.f18444a);
    }

    public gf(ff ffVar, Looper looper, df dfVar) {
        super(5);
        this.f19219o = (ff) b1.a(ffVar);
        this.f19220p = looper == null ? null : xp.a(looper, (Handler.Callback) this);
        this.f19218n = (df) b1.a(dfVar);
        this.f19221q = new ef();
        this.f19226v = C.TIME_UNSET;
    }

    private void a(bf bfVar) {
        Handler handler = this.f19220p;
        if (handler != null) {
            handler.obtainMessage(0, bfVar).sendToTarget();
        } else {
            b(bfVar);
        }
    }

    private void a(bf bfVar, List list) {
        for (int i11 = 0; i11 < bfVar.c(); i11++) {
            f9 f9VarB = bfVar.a(i11).b();
            if (f9VarB == null || !this.f19218n.a(f9VarB)) {
                list.add(bfVar.a(i11));
            } else {
                cf cfVarB = this.f19218n.b(f9VarB);
                byte[] bArr = (byte[]) b1.a(bfVar.a(i11).a());
                this.f19221q.b();
                this.f19221q.g(bArr.length);
                ((ByteBuffer) xp.a(this.f19221q.f21655c)).put(bArr);
                this.f19221q.g();
                bf bfVarA = cfVarB.a(this.f19221q);
                if (bfVarA != null) {
                    a(bfVarA, list);
                }
            }
        }
    }

    private void b(bf bfVar) {
        this.f19219o.a(bfVar);
    }

    private boolean c(long j11) {
        boolean z11;
        bf bfVar = this.f19227w;
        if (bfVar == null || this.f19226v > j11) {
            z11 = false;
        } else {
            a(bfVar);
            this.f19227w = null;
            this.f19226v = C.TIME_UNSET;
            z11 = true;
        }
        if (this.f19223s && this.f19227w == null) {
            this.f19224t = true;
        }
        return z11;
    }

    private void z() {
        if (this.f19223s || this.f19227w != null) {
            return;
        }
        this.f19221q.b();
        g9 g9VarR = r();
        int iA = a(g9VarR, this.f19221q, 0);
        if (iA != -4) {
            if (iA == -5) {
                this.f19225u = ((f9) b1.a(g9VarR.f19165b)).f18904q;
                return;
            }
            return;
        }
        if (this.f19221q.e()) {
            this.f19223s = true;
            return;
        }
        ef efVar = this.f19221q;
        efVar.f18693j = this.f19225u;
        efVar.g();
        bf bfVarA = ((cf) xp.a(this.f19222r)).a(this.f19221q);
        if (bfVarA != null) {
            ArrayList arrayList = new ArrayList(bfVarA.c());
            a(bfVarA, arrayList);
            if (arrayList.isEmpty()) {
                return;
            }
            this.f19227w = new bf(arrayList);
            this.f19226v = this.f19221q.f21657f;
        }
    }

    @Override // com.applovin.impl.ri
    public int a(f9 f9Var) {
        if (this.f19218n.a(f9Var)) {
            return v40.a(f9Var.F == 0 ? 4 : 2);
        }
        return v40.a(0);
    }

    @Override // com.applovin.impl.qi
    public void a(long j11, long j12) {
        boolean zC = true;
        while (zC) {
            z();
            zC = c(j11);
        }
    }

    @Override // com.applovin.impl.e2
    public void a(long j11, boolean z11) {
        this.f19227w = null;
        this.f19226v = C.TIME_UNSET;
        this.f19223s = false;
        this.f19224t = false;
    }

    @Override // com.applovin.impl.e2
    public void a(f9[] f9VarArr, long j11, long j12) {
        this.f19222r = this.f19218n.b(f9VarArr[0]);
    }

    @Override // com.applovin.impl.qi
    public boolean c() {
        return this.f19224t;
    }

    @Override // com.applovin.impl.qi
    public boolean d() {
        return true;
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        b((bf) message.obj);
        return true;
    }

    @Override // com.applovin.impl.e2
    public void v() {
        this.f19227w = null;
        this.f19226v = C.TIME_UNSET;
        this.f19222r = null;
    }
}
