package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f35592a;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseBooleanArray f35593a = new SparseBooleanArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f35594b;

        public b a(int i11) {
            com.google.android.exoplayer2.util.a.g(!this.f35594b);
            this.f35593a.append(i11, true);
            return this;
        }

        public b b(m mVar) {
            for (int i11 = 0; i11 < mVar.d(); i11++) {
                a(mVar.c(i11));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i11 : iArr) {
                a(i11);
            }
            return this;
        }

        public b d(int i11, boolean z11) {
            return z11 ? a(i11) : this;
        }

        public m e() {
            com.google.android.exoplayer2.util.a.g(!this.f35594b);
            this.f35594b = true;
            return new m(this.f35593a);
        }
    }

    public m(SparseBooleanArray sparseBooleanArray) {
        this.f35592a = sparseBooleanArray;
    }

    public boolean a(int i11) {
        return this.f35592a.get(i11);
    }

    public boolean b(int... iArr) {
        for (int i11 : iArr) {
            if (a(i11)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i11) {
        com.google.android.exoplayer2.util.a.c(i11, 0, d());
        return this.f35592a.keyAt(i11);
    }

    public int d() {
        return this.f35592a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (o0.f35608a >= 24) {
            return this.f35592a.equals(mVar.f35592a);
        }
        if (d() != mVar.d()) {
            return false;
        }
        for (int i11 = 0; i11 < d(); i11++) {
            if (c(i11) != mVar.c(i11)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (o0.f35608a >= 24) {
            return this.f35592a.hashCode();
        }
        int iD = d();
        for (int i11 = 0; i11 < d(); i11++) {
            iD = (iD * 31) + c(i11);
        }
        return iD;
    }
}
