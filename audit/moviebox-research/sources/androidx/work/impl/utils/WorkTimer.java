package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class WorkTimer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13503e = androidx.work.j.i("WorkTimer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.work.o f13504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<s6.m, WorkTimerRunnable> f13505b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<s6.m, a> f13506c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f13507d = new Object();

    /* JADX INFO: compiled from: source.java */
    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final s6.m mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        public WorkTimerRunnable(@NonNull WorkTimer workTimer, @NonNull s6.m mVar) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.mWorkTimer.f13507d) {
                try {
                    if (this.mWorkTimer.f13505b.remove(this.mWorkGenerationalId) != null) {
                        a aVarRemove = this.mWorkTimer.f13506c.remove(this.mWorkGenerationalId);
                        if (aVarRemove != null) {
                            aVarRemove.a(this.mWorkGenerationalId);
                        }
                    } else {
                        androidx.work.j.e().a(TAG, String.format("Timer with %s is already marked as complete.", this.mWorkGenerationalId));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(@NonNull s6.m mVar);
    }

    public WorkTimer(@NonNull androidx.work.o oVar) {
        this.f13504a = oVar;
    }

    public void a(@NonNull s6.m mVar, long j11, @NonNull a aVar) {
        synchronized (this.f13507d) {
            androidx.work.j.e().a(f13503e, "Starting timer for " + mVar);
            b(mVar);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, mVar);
            this.f13505b.put(mVar, workTimerRunnable);
            this.f13506c.put(mVar, aVar);
            this.f13504a.b(j11, workTimerRunnable);
        }
    }

    public void b(@NonNull s6.m mVar) {
        synchronized (this.f13507d) {
            try {
                if (this.f13505b.remove(mVar) != null) {
                    androidx.work.j.e().a(f13503e, "Stopping timer for " + mVar);
                    this.f13506c.remove(mVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
