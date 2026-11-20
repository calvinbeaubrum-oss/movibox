package com.applovin.impl;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseBooleanArray f17884a;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseBooleanArray f17885a = new SparseBooleanArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f17886b;

        public b a(int i11) {
            b1.b(!this.f17886b);
            this.f17885a.append(i11, true);
            return this;
        }

        public b a(int i11, boolean z11) {
            return z11 ? a(i11) : this;
        }

        public b a(b9 b9Var) {
            for (int i11 = 0; i11 < b9Var.a(); i11++) {
                a(b9Var.b(i11));
            }
            return this;
        }

        public b a(int... iArr) {
            for (int i11 : iArr) {
                a(i11);
            }
            return this;
        }

        public b9 a() {
            b1.b(!this.f17886b);
            this.f17886b = true;
            return new b9(this.f17885a);
        }
    }

    private b9(SparseBooleanArray sparseBooleanArray) {
        this.f17884a = sparseBooleanArray;
    }

    public int a() {
        return this.f17884a.size();
    }

    public boolean a(int i11) {
        return this.f17884a.get(i11);
    }

    public boolean a(int... iArr) {
        for (int i11 : iArr) {
            if (a(i11)) {
                return true;
            }
        }
        return false;
    }

    public int b(int i11) {
        b1.a(i11, 0, a());
        return this.f17884a.keyAt(i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b9)) {
            return false;
        }
        b9 b9Var = (b9) obj;
        if (xp.f24372a >= 24) {
            return this.f17884a.equals(b9Var.f17884a);
        }
        if (a() != b9Var.a()) {
            return false;
        }
        for (int i11 = 0; i11 < a(); i11++) {
            if (b(i11) != b9Var.b(i11)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (xp.f24372a >= 24) {
            return this.f17884a.hashCode();
        }
        int iA = a();
        for (int i11 = 0; i11 < a(); i11++) {
            iA = (iA * 31) + b(i11);
        }
        return iA;
    }
}
