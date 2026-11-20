package androidx.concurrent.futures;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<V> extends AbstractResolvableFuture<V> {
    public static <V> b<V> z() {
        return new b<>();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean v(@Nullable V v11) {
        return super.v(v11);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean w(Throwable th2) {
        return super.w(th2);
    }
}
