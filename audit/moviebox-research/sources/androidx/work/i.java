package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    @NonNull
    private Context mAppContext;
    private volatile boolean mStopped;
    private boolean mUsed;

    @NonNull
    private WorkerParameters mWorkerParams;

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {

        /* JADX INFO: renamed from: androidx.work.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0125a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final d f13312a;

            public C0125a() {
                this(d.f13305c);
            }

            public C0125a(@NonNull d dVar) {
                this.f13312a = dVar;
            }

            @NonNull
            public d e() {
                return this.f13312a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0125a.class != obj.getClass()) {
                    return false;
                }
                return this.f13312a.equals(((C0125a) obj).f13312a);
            }

            public int hashCode() {
                return (C0125a.class.getName().hashCode() * 31) + this.f13312a.hashCode();
            }

            @NonNull
            public String toString() {
                return "Failure {mOutputData=" + this.f13312a + '}';
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            @NonNull
            public String toString() {
                return "Retry";
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final d f13313a;

            public c() {
                this(d.f13305c);
            }

            public c(@NonNull d dVar) {
                this.f13313a = dVar;
            }

            @NonNull
            public d e() {
                return this.f13313a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f13313a.equals(((c) obj).f13313a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f13313a.hashCode();
            }

            @NonNull
            public String toString() {
                return "Success {mOutputData=" + this.f13313a + '}';
            }
        }

        @NonNull
        public static a a() {
            return new C0125a();
        }

        @NonNull
        public static a b() {
            return new b();
        }

        @NonNull
        public static a c() {
            return new c();
        }

        @NonNull
        public static a d(@NonNull d dVar) {
            return new c(dVar);
        }
    }

    public i(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    @NonNull
    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    @NonNull
    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.a();
    }

    @NonNull
    public com.google.common.util.concurrent.s<e> getForegroundInfoAsync() {
        androidx.work.impl.utils.futures.a aVarX = androidx.work.impl.utils.futures.a.x();
        aVarX.u(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return aVarX;
    }

    @NonNull
    public final UUID getId() {
        return this.mWorkerParams.c();
    }

    @NonNull
    public final d getInputData() {
        return this.mWorkerParams.d();
    }

    @Nullable
    @RequiresApi(28)
    public final Network getNetwork() {
        return this.mWorkerParams.e();
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.g();
    }

    @NonNull
    public final Set<String> getTags() {
        return this.mWorkerParams.h();
    }

    @NonNull
    public t6.c getTaskExecutor() {
        return this.mWorkerParams.i();
    }

    @NonNull
    @RequiresApi(24)
    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.j();
    }

    @NonNull
    @RequiresApi(24)
    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.k();
    }

    @NonNull
    public s getWorkerFactory() {
        return this.mWorkerParams.l();
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    @NonNull
    public final com.google.common.util.concurrent.s<Void> setForegroundAsync(@NonNull e eVar) {
        return this.mWorkerParams.b().a(getApplicationContext(), getId(), eVar);
    }

    @NonNull
    public com.google.common.util.concurrent.s<Void> setProgressAsync(@NonNull d dVar) {
        return this.mWorkerParams.f().a(getApplicationContext(), getId(), dVar);
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    @NonNull
    public abstract com.google.common.util.concurrent.s<a> startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }
}
