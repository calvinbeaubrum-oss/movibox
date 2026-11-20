package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Executor f12631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Executor f12632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final DiffUtil.e<T> f12633c;

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Object f12634d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Executor f12635e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Executor f12636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f12637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DiffUtil.e<T> f12638c;

        public a(@NonNull DiffUtil.e<T> eVar) {
            this.f12638c = eVar;
        }

        @NonNull
        public c<T> a() {
            if (this.f12637b == null) {
                synchronized (f12634d) {
                    try {
                        if (f12635e == null) {
                            f12635e = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                this.f12637b = f12635e;
            }
            return new c<>(this.f12636a, this.f12637b, this.f12638c);
        }
    }

    public c(@Nullable Executor executor, @NonNull Executor executor2, @NonNull DiffUtil.e<T> eVar) {
        this.f12631a = executor;
        this.f12632b = executor2;
        this.f12633c = eVar;
    }

    @NonNull
    public Executor a() {
        return this.f12632b;
    }

    @NonNull
    public DiffUtil.e<T> b() {
        return this.f12633c;
    }

    @Nullable
    public Executor c() {
        return this.f12631a;
    }
}
