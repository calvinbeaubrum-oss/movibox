package w30;

import retrofit2.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0<T> f79226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f79227b;

    public d(b0<T> b0Var, Throwable th2) {
        this.f79226a = b0Var;
        this.f79227b = th2;
    }

    public static <T> d<T> a(Throwable th2) {
        if (th2 != null) {
            return new d<>(null, th2);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> d<T> b(b0<T> b0Var) {
        if (b0Var != null) {
            return new d<>(b0Var, null);
        }
        throw new NullPointerException("response == null");
    }
}
