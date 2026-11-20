package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class CallbackToFutureAdapter {

    /* JADX INFO: compiled from: source.java */
    public static final class FutureGarbageCollectedException extends Throwable {
        public FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<T> f6291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.concurrent.futures.b<Void> f6292c = androidx.concurrent.futures.b.z();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6293d;

        public void a() {
            this.f6290a = null;
            this.f6291b = null;
            this.f6292c.v(null);
        }

        public boolean b(T t11) {
            this.f6293d = true;
            c<T> cVar = this.f6291b;
            boolean z11 = cVar != null && cVar.c(t11);
            if (z11) {
                d();
            }
            return z11;
        }

        public boolean c() {
            this.f6293d = true;
            c<T> cVar = this.f6291b;
            boolean z11 = cVar != null && cVar.b(true);
            if (z11) {
                d();
            }
            return z11;
        }

        public final void d() {
            this.f6290a = null;
            this.f6291b = null;
            this.f6292c = null;
        }

        public boolean e(@NonNull Throwable th2) {
            this.f6293d = true;
            c<T> cVar = this.f6291b;
            boolean z11 = cVar != null && cVar.d(th2);
            if (z11) {
                d();
            }
            return z11;
        }

        public void finalize() {
            androidx.concurrent.futures.b<Void> bVar;
            c<T> cVar = this.f6291b;
            if (cVar != null && !cVar.isDone()) {
                cVar.d(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f6290a));
            }
            if (this.f6293d || (bVar = this.f6292c) == null) {
                return;
            }
            bVar.v(null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        @Nullable
        Object a(@NonNull a<T> aVar) throws Exception;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<T> implements s<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<a<T>> f6294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractResolvableFuture<T> f6295b = new a();

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractResolvableFuture<T> {
            public a() {
            }

            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            public String q() {
                a<T> aVar = c.this.f6294a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f6290a + "]";
            }
        }

        public c(a<T> aVar) {
            this.f6294a = new WeakReference<>(aVar);
        }

        @Override // com.google.common.util.concurrent.s
        public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.f6295b.addListener(runnable, executor);
        }

        public boolean b(boolean z11) {
            return this.f6295b.cancel(z11);
        }

        public boolean c(T t11) {
            return this.f6295b.v(t11);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z11) {
            a<T> aVar = this.f6294a.get();
            boolean zCancel = this.f6295b.cancel(z11);
            if (zCancel && aVar != null) {
                aVar.a();
            }
            return zCancel;
        }

        public boolean d(Throwable th2) {
            return this.f6295b.w(th2);
        }

        @Override // java.util.concurrent.Future
        public T get() throws ExecutionException, InterruptedException {
            return this.f6295b.get();
        }

        @Override // java.util.concurrent.Future
        public T get(long j11, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.f6295b.get(j11, timeUnit);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f6295b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f6295b.isDone();
        }

        public String toString() {
            return this.f6295b.toString();
        }
    }

    @NonNull
    public static <T> s<T> a(@NonNull b<T> bVar) {
        a<T> aVar = new a<>();
        c<T> cVar = new c<>(aVar);
        aVar.f6291b = cVar;
        aVar.f6290a = bVar.getClass();
        try {
            Object objA = bVar.a(aVar);
            if (objA != null) {
                aVar.f6290a = objA;
            }
        } catch (Exception e11) {
            cVar.d(e11);
        }
        return cVar;
    }
}
