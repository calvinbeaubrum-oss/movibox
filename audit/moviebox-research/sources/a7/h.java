package a7;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public T f438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public T f439b;

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t11, T t12) {
        this.f438a = t11;
        this.f439b = t12;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof androidx.core.util.e)) {
            return false;
        }
        androidx.core.util.e eVar = (androidx.core.util.e) obj;
        return a(eVar.f7889a, this.f438a) && a(eVar.f7890b, this.f439b);
    }

    public int hashCode() {
        T t11 = this.f438a;
        int iHashCode = t11 == null ? 0 : t11.hashCode();
        T t12 = this.f439b;
        return iHashCode ^ (t12 != null ? t12.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f438a + " " + this.f439b + "}";
    }
}
