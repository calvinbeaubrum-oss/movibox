package h1;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f66112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public static final Executor f66113d = new Executor() { // from class: h1.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.i(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public static final Executor f66114e = new Executor() { // from class: h1.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.j(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public e f66115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final e f66116b;

    public c() {
        d dVar = new d();
        this.f66116b = dVar;
        this.f66115a = dVar;
    }

    @NonNull
    public static Executor g() {
        return f66114e;
    }

    @NonNull
    public static c h() {
        if (f66112c != null) {
            return f66112c;
        }
        synchronized (c.class) {
            try {
                if (f66112c == null) {
                    f66112c = new c();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f66112c;
    }

    public static /* synthetic */ void i(Runnable runnable) {
        h().d(runnable);
    }

    public static /* synthetic */ void j(Runnable runnable) {
        h().a(runnable);
    }

    @Override // h1.e
    public void a(@NonNull Runnable runnable) {
        this.f66115a.a(runnable);
    }

    @Override // h1.e
    public boolean c() {
        return this.f66115a.c();
    }

    @Override // h1.e
    public void d(@NonNull Runnable runnable) {
        this.f66115a.d(runnable);
    }
}
