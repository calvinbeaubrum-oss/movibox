package com.applovin.impl;

import android.util.SparseArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class qk {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r4 f21953c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray f21952b = new SparseArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f21951a = -1;

    public qk(r4 r4Var) {
        this.f21953c = r4Var;
    }

    public void a() {
        for (int i11 = 0; i11 < this.f21952b.size(); i11++) {
            this.f21953c.accept(this.f21952b.valueAt(i11));
        }
        this.f21951a = -1;
        this.f21952b.clear();
    }

    public void a(int i11) {
        for (int size = this.f21952b.size() - 1; size >= 0 && i11 < this.f21952b.keyAt(size); size--) {
            this.f21953c.accept(this.f21952b.valueAt(size));
            this.f21952b.removeAt(size);
        }
        this.f21951a = this.f21952b.size() > 0 ? Math.min(this.f21951a, this.f21952b.size() - 1) : -1;
    }

    public void a(int i11, Object obj) {
        if (this.f21951a == -1) {
            b1.b(this.f21952b.size() == 0);
            this.f21951a = 0;
        }
        if (this.f21952b.size() > 0) {
            SparseArray sparseArray = this.f21952b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            b1.a(i11 >= iKeyAt);
            if (iKeyAt == i11) {
                r4 r4Var = this.f21953c;
                SparseArray sparseArray2 = this.f21952b;
                r4Var.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f21952b.append(i11, obj);
    }

    public Object b() {
        SparseArray sparseArray = this.f21952b;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public void b(int i11) {
        int i12 = 0;
        while (i12 < this.f21952b.size() - 1) {
            int i13 = i12 + 1;
            if (i11 < this.f21952b.keyAt(i13)) {
                return;
            }
            this.f21953c.accept(this.f21952b.valueAt(i12));
            this.f21952b.removeAt(i12);
            int i14 = this.f21951a;
            if (i14 > 0) {
                this.f21951a = i14 - 1;
            }
            i12 = i13;
        }
    }

    public Object c(int i11) {
        if (this.f21951a == -1) {
            this.f21951a = 0;
        }
        while (true) {
            int i12 = this.f21951a;
            if (i12 <= 0 || i11 >= this.f21952b.keyAt(i12)) {
                break;
            }
            this.f21951a--;
        }
        while (this.f21951a < this.f21952b.size() - 1 && i11 >= this.f21952b.keyAt(this.f21951a + 1)) {
            this.f21951a++;
        }
        return this.f21952b.valueAt(this.f21951a);
    }

    public boolean c() {
        return this.f21952b.size() == 0;
    }
}
