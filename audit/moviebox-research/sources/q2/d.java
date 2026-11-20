package q2;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d {
    public static int a(e eVar, float f11) {
        float fN0 = eVar.N0(f11);
        return Float.isInfinite(fN0) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : Math.round(fN0);
    }

    public static float b(e eVar, float f11) {
        return i.h(f11 / eVar.getDensity());
    }

    public static float c(e eVar, long j11) {
        if (y.g(w.g(j11), y.f74261b.b())) {
            return eVar.N0(eVar.O(j11));
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    public static float d(e eVar, float f11) {
        return f11 * eVar.getDensity();
    }

    public static long e(e eVar, long j11) {
        return j11 != 9205357640488583168L ? y1.n.a(eVar.N0(l.d(j11)), eVar.N0(l.c(j11))) : y1.m.f81091b.a();
    }

    public static long f(e eVar, float f11) {
        return eVar.M(eVar.H0(f11));
    }
}
