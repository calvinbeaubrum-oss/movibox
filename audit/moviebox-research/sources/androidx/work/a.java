package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Executor f13255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Executor f13256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final s f13257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final h f13258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final o f13259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final androidx.core.util.a<Throwable> f13260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final androidx.core.util.a<Throwable> f13261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f13262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f13265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f13266l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f13267m;

    /* JADX INFO: renamed from: androidx.work.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class ThreadFactoryC0123a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f13268a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f13269b;

        public ThreadFactoryC0123a(boolean z11) {
            this.f13269b = z11;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, (this.f13269b ? "WM.task-" : "androidx.work-") + this.f13268a.incrementAndGet());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f13271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s f13272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f13273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Executor f13274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public o f13275e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public androidx.core.util.a<Throwable> f13276f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public androidx.core.util.a<Throwable> f13277g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f13278h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f13279i = 4;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f13280j = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f13281k = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f13282l = 20;

        @NonNull
        public a a() {
            return new a(this);
        }

        @NonNull
        public b b(int i11) {
            this.f13279i = i11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        @NonNull
        a a();
    }

    public a(@NonNull b bVar) {
        Executor executor = bVar.f13271a;
        if (executor == null) {
            this.f13255a = a(false);
        } else {
            this.f13255a = executor;
        }
        Executor executor2 = bVar.f13274d;
        if (executor2 == null) {
            this.f13267m = true;
            this.f13256b = a(true);
        } else {
            this.f13267m = false;
            this.f13256b = executor2;
        }
        s sVar = bVar.f13272b;
        if (sVar == null) {
            this.f13257c = s.c();
        } else {
            this.f13257c = sVar;
        }
        h hVar = bVar.f13273c;
        if (hVar == null) {
            this.f13258d = h.c();
        } else {
            this.f13258d = hVar;
        }
        o oVar = bVar.f13275e;
        if (oVar == null) {
            this.f13259e = new androidx.work.impl.d();
        } else {
            this.f13259e = oVar;
        }
        this.f13263i = bVar.f13279i;
        this.f13264j = bVar.f13280j;
        this.f13265k = bVar.f13281k;
        this.f13266l = bVar.f13282l;
        this.f13260f = bVar.f13276f;
        this.f13261g = bVar.f13277g;
        this.f13262h = bVar.f13278h;
    }

    @NonNull
    public final Executor a(boolean z11) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z11));
    }

    @NonNull
    public final ThreadFactory b(boolean z11) {
        return new ThreadFactoryC0123a(z11);
    }

    @Nullable
    public String c() {
        return this.f13262h;
    }

    @NonNull
    public Executor d() {
        return this.f13255a;
    }

    @Nullable
    public androidx.core.util.a<Throwable> e() {
        return this.f13260f;
    }

    @NonNull
    public h f() {
        return this.f13258d;
    }

    public int g() {
        return this.f13265k;
    }

    public int h() {
        return Build.VERSION.SDK_INT == 23 ? this.f13266l / 2 : this.f13266l;
    }

    public int i() {
        return this.f13264j;
    }

    public int j() {
        return this.f13263i;
    }

    @NonNull
    public o k() {
        return this.f13259e;
    }

    @Nullable
    public androidx.core.util.a<Throwable> l() {
        return this.f13261g;
    }

    @NonNull
    public Executor m() {
        return this.f13256b;
    }

    @NonNull
    public s n() {
        return this.f13257c;
    }
}
