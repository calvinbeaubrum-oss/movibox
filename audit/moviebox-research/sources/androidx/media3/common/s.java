package androidx.media3.common;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f9440a;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseBooleanArray f9441a = new SparseBooleanArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9442b;

        public b a(int i11) {
            z3.a.g(!this.f9442b);
            this.f9441a.append(i11, true);
            return this;
        }

        public b b(s sVar) {
            for (int i11 = 0; i11 < sVar.d(); i11++) {
                a(sVar.c(i11));
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

        public s e() {
            z3.a.g(!this.f9442b);
            this.f9442b = true;
            return new s(this.f9441a);
        }
    }

    public s(SparseBooleanArray sparseBooleanArray) {
        this.f9440a = sparseBooleanArray;
    }

    public boolean a(int i11) {
        return this.f9440a.get(i11);
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
        z3.a.c(i11, 0, d());
        return this.f9440a.keyAt(i11);
    }

    public int d() {
        return this.f9440a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (u0.f81838a >= 24) {
            return this.f9440a.equals(sVar.f9440a);
        }
        if (d() != sVar.d()) {
            return false;
        }
        for (int i11 = 0; i11 < d(); i11++) {
            if (c(i11) != sVar.c(i11)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (u0.f81838a >= 24) {
            return this.f9440a.hashCode();
        }
        int iD = d();
        for (int i11 = 0; i11 < d(); i11++) {
            iD = (iD * 31) + c(i11);
        }
        return iD;
    }
}
