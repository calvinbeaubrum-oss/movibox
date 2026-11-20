package com.vungle.warren.utility;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class p implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f62614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w f62615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w f62616d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w f62618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w f62619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final w f62620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final w f62621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final w f62622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final w f62623k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final w f62624l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f62613a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorService f62617e = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends AbstractExecutorService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f62625a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j11, @NonNull TimeUnit timeUnit) {
            return false;
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f62625a.post(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return null;
        }
    }

    static {
        int i11 = f62613a;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f62616d = new w(i11, i11, 1L, timeUnit, new PriorityBlockingQueue(), new n("vng_jr"));
        f62614b = new w(1, 1, 5L, timeUnit, new LinkedBlockingQueue(), new n("vng_io"));
        f62619g = new w(1, 1, 5L, timeUnit, new LinkedBlockingQueue(), new n("vng_logger"));
        f62615c = new w(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new n("vng_background"));
        f62618f = new w(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new n("vng_api"));
        f62620h = new w(1, 20, 10L, timeUnit, new SynchronousQueue(), new n("vng_task"));
        f62621i = new w(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new n("vng_ua"));
        f62622j = new w(4, 4, 1L, timeUnit, new PriorityBlockingQueue(), new n("vng_down"));
        f62623k = new w(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new n("vng_ol"));
        f62624l = new w(1, 1, 5L, timeUnit, new LinkedBlockingQueue(), new n("vng_session"));
    }

    @Override // com.vungle.warren.utility.f
    public w a() {
        return f62618f;
    }

    @Override // com.vungle.warren.utility.f
    public w b() {
        return f62620h;
    }

    @Override // com.vungle.warren.utility.f
    public w c() {
        return f62619g;
    }

    @Override // com.vungle.warren.utility.f
    public w d() {
        return f62614b;
    }

    @Override // com.vungle.warren.utility.f
    public w e() {
        return f62616d;
    }

    @Override // com.vungle.warren.utility.f
    public ExecutorService f() {
        return f62617e;
    }

    @Override // com.vungle.warren.utility.f
    public w g() {
        return f62623k;
    }

    @Override // com.vungle.warren.utility.f
    public w h() {
        return f62621i;
    }

    @Override // com.vungle.warren.utility.f
    public w i() {
        return f62622j;
    }

    @Override // com.vungle.warren.utility.f
    public w j() {
        return f62615c;
    }

    public w k() {
        return f62624l;
    }
}
