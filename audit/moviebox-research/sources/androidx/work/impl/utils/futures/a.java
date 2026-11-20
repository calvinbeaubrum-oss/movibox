package androidx.work.impl.utils.futures;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<V> extends AbstractFuture<V> {
    public static <V> a<V> x() {
        return new a<>();
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean t(@Nullable V v11) {
        return super.t(v11);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean u(Throwable th2) {
        return super.u(th2);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean v(s<? extends V> sVar) {
        return super.v(sVar);
    }
}
