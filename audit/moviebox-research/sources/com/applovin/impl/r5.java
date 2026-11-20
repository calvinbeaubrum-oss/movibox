package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r5 implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f22040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f22042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m0[] f22043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f22045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f22046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private m0[] f22047h;

    public r5(boolean z11, int i11) {
        this(z11, i11, 0);
    }

    public r5(boolean z11, int i11, int i12) {
        b1.a(i11 > 0);
        b1.a(i12 >= 0);
        this.f22040a = z11;
        this.f22041b = i11;
        this.f22046g = i12;
        this.f22047h = new m0[i12 + 100];
        if (i12 > 0) {
            this.f22042c = new byte[i12 * i11];
            for (int i13 = 0; i13 < i12; i13++) {
                this.f22047h[i13] = new m0(this.f22042c, i13 * i11);
            }
        } else {
            this.f22042c = null;
        }
        this.f22043d = new m0[1];
    }

    @Override // com.applovin.impl.n0
    public synchronized void a() {
        try {
            int i11 = 0;
            int iMax = Math.max(0, xp.a(this.f22044e, this.f22041b) - this.f22045f);
            int i12 = this.f22046g;
            if (iMax >= i12) {
                return;
            }
            if (this.f22042c != null) {
                int i13 = i12 - 1;
                while (i11 <= i13) {
                    m0 m0Var = (m0) b1.a(this.f22047h[i11]);
                    if (m0Var.f20557a == this.f22042c) {
                        i11++;
                    } else {
                        m0 m0Var2 = (m0) b1.a(this.f22047h[i13]);
                        if (m0Var2.f20557a != this.f22042c) {
                            i13--;
                        } else {
                            m0[] m0VarArr = this.f22047h;
                            m0VarArr[i11] = m0Var2;
                            m0VarArr[i13] = m0Var;
                            i13--;
                            i11++;
                        }
                    }
                }
                iMax = Math.max(iMax, i11);
                if (iMax >= this.f22046g) {
                    return;
                }
            }
            Arrays.fill(this.f22047h, iMax, this.f22046g, (Object) null);
            this.f22046g = iMax;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(int i11) {
        boolean z11 = i11 < this.f22044e;
        this.f22044e = i11;
        if (z11) {
            a();
        }
    }

    @Override // com.applovin.impl.n0
    public synchronized void a(m0 m0Var) {
        m0[] m0VarArr = this.f22043d;
        m0VarArr[0] = m0Var;
        a(m0VarArr);
    }

    @Override // com.applovin.impl.n0
    public synchronized void a(m0[] m0VarArr) {
        try {
            int i11 = this.f22046g;
            int length = m0VarArr.length + i11;
            m0[] m0VarArr2 = this.f22047h;
            if (length >= m0VarArr2.length) {
                this.f22047h = (m0[]) Arrays.copyOf(m0VarArr2, Math.max(m0VarArr2.length * 2, i11 + m0VarArr.length));
            }
            for (m0 m0Var : m0VarArr) {
                m0[] m0VarArr3 = this.f22047h;
                int i12 = this.f22046g;
                this.f22046g = i12 + 1;
                m0VarArr3[i12] = m0Var;
            }
            this.f22045f -= m0VarArr.length;
            notifyAll();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.applovin.impl.n0
    public synchronized m0 b() {
        m0 m0Var;
        try {
            this.f22045f++;
            int i11 = this.f22046g;
            if (i11 > 0) {
                m0[] m0VarArr = this.f22047h;
                int i12 = i11 - 1;
                this.f22046g = i12;
                m0Var = (m0) b1.a(m0VarArr[i12]);
                this.f22047h[this.f22046g] = null;
            } else {
                m0Var = new m0(new byte[this.f22041b], 0);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return m0Var;
    }

    @Override // com.applovin.impl.n0
    public int c() {
        return this.f22041b;
    }

    public synchronized int d() {
        return this.f22045f * this.f22041b;
    }

    public synchronized void e() {
        if (this.f22040a) {
            a(0);
        }
    }
}
