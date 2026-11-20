package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import androidx.work.impl.d0;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StatusRunnable<T> implements Runnable {
    private final androidx.work.impl.utils.futures.a<T> mFuture = androidx.work.impl.utils.futures.a.x();

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forStringIds(@NonNull final d0 d0Var, @NonNull final List<String> list) {
        return new StatusRunnable<List<WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable.1
            @Override // androidx.work.impl.utils.StatusRunnable
            public List<WorkInfo> runInternal() {
                return s6.u.f76198w.apply(d0Var.u().N().D(list));
            }
        };
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forTag(@NonNull final d0 d0Var, @NonNull final String str) {
        return new StatusRunnable<List<WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable.3
            @Override // androidx.work.impl.utils.StatusRunnable
            public List<WorkInfo> runInternal() {
                return s6.u.f76198w.apply(d0Var.u().N().A(str));
            }
        };
    }

    @NonNull
    public static StatusRunnable<WorkInfo> forUUID(@NonNull final d0 d0Var, @NonNull final UUID uuid) {
        return new StatusRunnable<WorkInfo>() { // from class: androidx.work.impl.utils.StatusRunnable.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.work.impl.utils.StatusRunnable
            public WorkInfo runInternal() {
                s6.u.c cVarH = d0Var.u().N().h(uuid.toString());
                if (cVarH != null) {
                    return cVarH.a();
                }
                return null;
            }
        };
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forUniqueWork(@NonNull final d0 d0Var, @NonNull final String str) {
        return new StatusRunnable<List<WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable.4
            @Override // androidx.work.impl.utils.StatusRunnable
            public List<WorkInfo> runInternal() {
                return s6.u.f76198w.apply(d0Var.u().N().n(str));
            }
        };
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forWorkQuerySpec(@NonNull d0 d0Var, @NonNull androidx.work.q qVar) {
        return new StatusRunnable<List<WorkInfo>>(qVar) { // from class: androidx.work.impl.utils.StatusRunnable.5
            final /* synthetic */ androidx.work.q val$querySpec;

            @Override // androidx.work.impl.utils.StatusRunnable
            public List<WorkInfo> runInternal() {
                return s6.u.f76198w.apply(this.val$workManager.u().J().a(q.a(null)));
            }
        };
    }

    @NonNull
    public com.google.common.util.concurrent.s<T> getFuture() {
        return this.mFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.mFuture.t(runInternal());
        } catch (Throwable th2) {
            this.mFuture.u(th2);
        }
    }

    public abstract T runInternal();
}
