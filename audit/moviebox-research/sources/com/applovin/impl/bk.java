package com.applovin.impl;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bk implements m5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f17973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f17974b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f17975c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayDeque f17976d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final p5[] f17977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zg[] f17978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private p5 f17981i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private o5 f17982j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f17983k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17984l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f17985m;

    /* JADX INFO: compiled from: source.java */
    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            bk.this.m();
        }
    }

    public bk(p5[] p5VarArr, zg[] zgVarArr) {
        this.f17977e = p5VarArr;
        this.f17979g = p5VarArr.length;
        for (int i11 = 0; i11 < this.f17979g; i11++) {
            this.f17977e[i11] = f();
        }
        this.f17978f = zgVarArr;
        this.f17980h = zgVarArr.length;
        for (int i12 = 0; i12 < this.f17980h; i12++) {
            this.f17978f[i12] = g();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f17973a = aVar;
        aVar.start();
    }

    private void b(p5 p5Var) {
        p5Var.b();
        p5[] p5VarArr = this.f17977e;
        int i11 = this.f17979g;
        this.f17979g = i11 + 1;
        p5VarArr[i11] = p5Var;
    }

    private void b(zg zgVar) {
        zgVar.b();
        zg[] zgVarArr = this.f17978f;
        int i11 = this.f17980h;
        this.f17980h = i11 + 1;
        zgVarArr[i11] = zgVar;
    }

    private boolean e() {
        return !this.f17975c.isEmpty() && this.f17980h > 0;
    }

    private boolean h() {
        o5 o5VarA;
        synchronized (this.f17974b) {
            while (!this.f17984l && !e()) {
                try {
                    this.f17974b.wait();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.f17984l) {
                return false;
            }
            p5 p5Var = (p5) this.f17975c.removeFirst();
            zg[] zgVarArr = this.f17978f;
            int i11 = this.f17980h - 1;
            this.f17980h = i11;
            zg zgVar = zgVarArr[i11];
            boolean z11 = this.f17983k;
            this.f17983k = false;
            if (p5Var.e()) {
                zgVar.b(4);
            } else {
                if (p5Var.d()) {
                    zgVar.b(Integer.MIN_VALUE);
                }
                try {
                    o5VarA = a(p5Var, zgVar, z11);
                } catch (OutOfMemoryError e11) {
                    o5VarA = a((Throwable) e11);
                } catch (RuntimeException e12) {
                    o5VarA = a((Throwable) e12);
                }
                if (o5VarA != null) {
                    synchronized (this.f17974b) {
                        this.f17982j = o5VarA;
                    }
                    return false;
                }
            }
            synchronized (this.f17974b) {
                try {
                    if (this.f17983k) {
                        zgVar.g();
                    } else if (zgVar.d()) {
                        this.f17985m++;
                        zgVar.g();
                    } else {
                        zgVar.f24866c = this.f17985m;
                        this.f17985m = 0;
                        this.f17976d.addLast(zgVar);
                    }
                    b(p5Var);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            return true;
        }
    }

    private void k() {
        if (e()) {
            this.f17974b.notify();
        }
    }

    private void l() throws o5 {
        o5 o5Var = this.f17982j;
        if (o5Var != null) {
            throw o5Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        do {
            try {
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11);
            }
        } while (h());
    }

    public abstract o5 a(p5 p5Var, zg zgVar, boolean z11);

    public abstract o5 a(Throwable th2);

    @Override // com.applovin.impl.m5
    public void a() {
        synchronized (this.f17974b) {
            this.f17984l = true;
            this.f17974b.notify();
        }
        try {
            this.f17973a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void a(int i11) {
        b1.b(this.f17979g == this.f17977e.length);
        for (p5 p5Var : this.f17977e) {
            p5Var.g(i11);
        }
    }

    @Override // com.applovin.impl.m5
    public final void a(p5 p5Var) {
        synchronized (this.f17974b) {
            l();
            b1.a(p5Var == this.f17981i);
            this.f17975c.addLast(p5Var);
            k();
            this.f17981i = null;
        }
    }

    public void a(zg zgVar) {
        synchronized (this.f17974b) {
            b(zgVar);
            k();
        }
    }

    @Override // com.applovin.impl.m5
    public final void b() {
        synchronized (this.f17974b) {
            try {
                this.f17983k = true;
                this.f17985m = 0;
                p5 p5Var = this.f17981i;
                if (p5Var != null) {
                    b(p5Var);
                    this.f17981i = null;
                }
                while (!this.f17975c.isEmpty()) {
                    b((p5) this.f17975c.removeFirst());
                }
                while (!this.f17976d.isEmpty()) {
                    ((zg) this.f17976d.removeFirst()).g();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract p5 f();

    public abstract zg g();

    @Override // com.applovin.impl.m5
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final p5 d() {
        p5 p5Var;
        synchronized (this.f17974b) {
            l();
            b1.b(this.f17981i == null);
            int i11 = this.f17979g;
            if (i11 == 0) {
                p5Var = null;
            } else {
                p5[] p5VarArr = this.f17977e;
                int i12 = i11 - 1;
                this.f17979g = i12;
                p5Var = p5VarArr[i12];
            }
            this.f17981i = p5Var;
        }
        return p5Var;
    }

    @Override // com.applovin.impl.m5
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final zg c() {
        synchronized (this.f17974b) {
            try {
                l();
                if (this.f17976d.isEmpty()) {
                    return null;
                }
                return (zg) this.f17976d.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
