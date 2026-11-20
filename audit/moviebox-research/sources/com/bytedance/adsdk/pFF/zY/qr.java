package com.bytedance.adsdk.pFF.zY;

import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class qr<T> {
    T pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    T f26261sc;

    private static boolean pFF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return pFF(pair.first, this.f26261sc) && pFF(pair.second, this.pFF);
    }

    public int hashCode() {
        T t11 = this.f26261sc;
        int iHashCode = t11 == null ? 0 : t11.hashCode();
        T t12 = this.pFF;
        return iHashCode ^ (t12 != null ? t12.hashCode() : 0);
    }

    public void sc(T t11, T t12) {
        this.f26261sc = t11;
        this.pFF = t12;
    }

    public String toString() {
        return "Pair{" + this.f26261sc + " " + this.pFF + "}";
    }
}
