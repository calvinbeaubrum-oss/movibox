package zl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, d> f82070d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f82071e = new b6.m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f82072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f82073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Task<com.google.firebase.remoteconfig.internal.a> f82074c = null;

    /* JADX INFO: compiled from: source.java */
    public static class b<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f82075a;

        public b() {
            this.f82075a = new CountDownLatch(1);
        }

        public boolean a(long j11, TimeUnit timeUnit) throws InterruptedException {
            return this.f82075a.await(j11, timeUnit);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public void onCanceled() {
            this.f82075a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            this.f82075a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(TResult tresult) {
            this.f82075a.countDown();
        }
    }

    public d(Executor executor, k kVar) {
        this.f82072a = executor;
        this.f82073b = kVar;
    }

    public static <TResult> TResult c(Task<TResult> task, long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        b bVar = new b();
        Executor executor = f82071e;
        task.addOnSuccessListener(executor, bVar);
        task.addOnFailureListener(executor, bVar);
        task.addOnCanceledListener(executor, bVar);
        if (!bVar.a(j11, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    public static synchronized d h(Executor executor, k kVar) {
        String strB;
        Map<String, d> map;
        try {
            strB = kVar.b();
            map = f82070d;
            if (!map.containsKey(strB)) {
                map.put(strB, new d(executor, kVar));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return map.get(strB);
    }

    public void d() {
        synchronized (this) {
            this.f82074c = Tasks.forResult(null);
        }
        this.f82073b.a();
    }

    public synchronized Task<com.google.firebase.remoteconfig.internal.a> e() {
        try {
            Task<com.google.firebase.remoteconfig.internal.a> task = this.f82074c;
            if (task == null || (task.isComplete() && !this.f82074c.isSuccessful())) {
                Executor executor = this.f82072a;
                final k kVar = this.f82073b;
                Objects.requireNonNull(kVar);
                this.f82074c = Tasks.call(executor, new Callable() { // from class: zl.a
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return kVar.d();
                    }
                });
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f82074c;
    }

    @Nullable
    public com.google.firebase.remoteconfig.internal.a f() {
        return g(5L);
    }

    @Nullable
    public com.google.firebase.remoteconfig.internal.a g(long j11) {
        synchronized (this) {
            try {
                Task<com.google.firebase.remoteconfig.internal.a> task = this.f82074c;
                if (task == null || !task.isSuccessful()) {
                    try {
                        return (com.google.firebase.remoteconfig.internal.a) c(e(), j11, TimeUnit.SECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                        return null;
                    }
                }
                return this.f82074c.getResult();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final /* synthetic */ Void i(com.google.firebase.remoteconfig.internal.a aVar) throws Exception {
        return this.f82073b.e(aVar);
    }

    public final /* synthetic */ Task j(boolean z11, com.google.firebase.remoteconfig.internal.a aVar, Void r11) throws Exception {
        if (z11) {
            m(aVar);
        }
        return Tasks.forResult(aVar);
    }

    public Task<com.google.firebase.remoteconfig.internal.a> k(com.google.firebase.remoteconfig.internal.a aVar) {
        return l(aVar, true);
    }

    public Task<com.google.firebase.remoteconfig.internal.a> l(final com.google.firebase.remoteconfig.internal.a aVar, final boolean z11) {
        return Tasks.call(this.f82072a, new Callable() { // from class: zl.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f82065a.i(aVar);
            }
        }).onSuccessTask(this.f82072a, new SuccessContinuation() { // from class: zl.c
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f82067a.j(z11, aVar, (Void) obj);
            }
        });
    }

    public final synchronized void m(com.google.firebase.remoteconfig.internal.a aVar) {
        this.f82074c = Tasks.forResult(aVar);
    }
}
