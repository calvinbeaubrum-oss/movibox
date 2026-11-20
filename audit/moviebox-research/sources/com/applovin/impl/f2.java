package com.applovin.impl;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f2 implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final oo f18844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f18845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int[] f18846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f9[] f18848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long[] f18849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18850g;

    public f2(oo ooVar, int[] iArr, int i11) {
        int i12 = 0;
        b1.b(iArr.length > 0);
        this.f18847d = i11;
        this.f18844a = (oo) b1.a(ooVar);
        int length = iArr.length;
        this.f18845b = length;
        this.f18848e = new f9[length];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            this.f18848e[i13] = ooVar.a(iArr[i13]);
        }
        Arrays.sort(this.f18848e, new Comparator() { // from class: com.applovin.impl.lv
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f2.a((f9) obj, (f9) obj2);
            }
        });
        this.f18846c = new int[this.f18845b];
        while (true) {
            int i14 = this.f18845b;
            if (i12 >= i14) {
                this.f18849f = new long[i14];
                return;
            } else {
                this.f18846c[i12] = ooVar.a(this.f18848e[i12]);
                i12++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(f9 f9Var, f9 f9Var2) {
        return f9Var2.f18896i - f9Var.f18896i;
    }

    @Override // com.applovin.impl.so
    public final f9 a(int i11) {
        return this.f18848e[i11];
    }

    @Override // com.applovin.impl.so
    public final oo a() {
        return this.f18844a;
    }

    @Override // com.applovin.impl.h8
    public void a(float f11) {
    }

    @Override // com.applovin.impl.h8
    public /* synthetic */ void a(boolean z11) {
        dy.a(this, z11);
    }

    @Override // com.applovin.impl.so
    public final int b() {
        return this.f18846c.length;
    }

    @Override // com.applovin.impl.so
    public final int b(int i11) {
        return this.f18846c[i11];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f2 f2Var = (f2) obj;
        return this.f18844a == f2Var.f18844a && Arrays.equals(this.f18846c, f2Var.f18846c);
    }

    @Override // com.applovin.impl.h8
    public void f() {
    }

    @Override // com.applovin.impl.h8
    public final f9 g() {
        return this.f18848e[h()];
    }

    public int hashCode() {
        if (this.f18850g == 0) {
            this.f18850g = (System.identityHashCode(this.f18844a) * 31) + Arrays.hashCode(this.f18846c);
        }
        return this.f18850g;
    }

    @Override // com.applovin.impl.h8
    public void i() {
    }

    @Override // com.applovin.impl.h8
    public /* synthetic */ void j() {
        dy.b(this);
    }

    @Override // com.applovin.impl.h8
    public /* synthetic */ void k() {
        dy.c(this);
    }
}
