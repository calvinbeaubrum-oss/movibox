package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0<T> extends c0<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i1.b<LiveData<?>, a<?>> f8702l;

    /* JADX INFO: compiled from: source.java */
    public static class a<V> implements d0<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveData<V> f8703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d0<? super V> f8704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8705c = -1;

        public a(LiveData<V> liveData, d0<? super V> d0Var) {
            this.f8703a = liveData;
            this.f8704b = d0Var;
        }

        public void a() {
            this.f8703a.k(this);
        }

        public void b() {
            this.f8703a.o(this);
        }

        @Override // androidx.lifecycle.d0
        public void onChanged(@Nullable V v11) {
            if (this.f8705c != this.f8703a.g()) {
                this.f8705c = this.f8703a.g();
                this.f8704b.onChanged(v11);
            }
        }
    }

    public a0() {
        this.f8702l = new i1.b<>();
    }

    public a0(T t11) {
        super(t11);
        this.f8702l = new i1.b<>();
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void l() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f8702l.iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void m() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f8702l.iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    public <S> void r(@NonNull LiveData<S> liveData, @NonNull d0<? super S> d0Var) {
        if (liveData == null) {
            throw new NullPointerException("source cannot be null");
        }
        a<?> aVar = new a<>(liveData, d0Var);
        a<?> aVarI = this.f8702l.i(liveData, aVar);
        if (aVarI != null && aVarI.f8704b != d0Var) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (aVarI == null && h()) {
            aVar.a();
        }
    }
}
