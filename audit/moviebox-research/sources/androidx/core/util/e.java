package androidx.core.util;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f7889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f7890b;

    public e(F f11, S s11) {
        this.f7889a = f11;
        this.f7890b = s11;
    }

    @NonNull
    public static <A, B> e<A, B> a(A a11, B b11) {
        return new e<>(a11, b11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return d.a(eVar.f7889a, this.f7889a) && d.a(eVar.f7890b, this.f7890b);
    }

    public int hashCode() {
        F f11 = this.f7889a;
        int iHashCode = f11 == null ? 0 : f11.hashCode();
        S s11 = this.f7890b;
        return iHashCode ^ (s11 != null ? s11.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.f7889a + " " + this.f7890b + "}";
    }
}
