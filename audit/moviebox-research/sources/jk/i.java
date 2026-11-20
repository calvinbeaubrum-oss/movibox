package jk;

import androidx.annotation.Nullable;
import androidx.compose.animation.core.j0;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f68070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CrashlyticsBackgroundWorker f68071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f68072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f68073d = new a(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f68074e = new a(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicMarkableReference<String> f68075f = new AtomicMarkableReference<>(null, false);

    /* JADX INFO: compiled from: source.java */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicMarkableReference<b> f68076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<Callable<Void>> f68077b = new AtomicReference<>(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f68078c;

        public a(boolean z11) {
            this.f68078c = z11;
            this.f68076a = new AtomicMarkableReference<>(new b(64, z11 ? 8192 : 1024), false);
        }

        public Map<String, String> b() {
            return this.f68076a.getReference().a();
        }

        public final /* synthetic */ Void c() throws Exception {
            this.f68077b.set(null);
            e();
            return null;
        }

        public final void d() {
            Callable callable = new Callable() { // from class: jk.h
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f68069a.c();
                }
            };
            if (j0.a(this.f68077b, null, callable)) {
                i.this.f68071b.h(callable);
            }
        }

        public final void e() throws Throwable {
            Map<String, String> mapA;
            synchronized (this) {
                try {
                    if (this.f68076a.isMarked()) {
                        mapA = this.f68076a.getReference().a();
                        AtomicMarkableReference<b> atomicMarkableReference = this.f68076a;
                        atomicMarkableReference.set(atomicMarkableReference.getReference(), false);
                    } else {
                        mapA = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (mapA != null) {
                i.this.f68070a.l(i.this.f68072c, mapA, this.f68078c);
            }
        }

        public boolean f(String str, String str2) {
            synchronized (this) {
                try {
                    if (!this.f68076a.getReference().d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference<b> atomicMarkableReference = this.f68076a;
                    atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
                    d();
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public i(String str, nk.f fVar, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        this.f68072c = str;
        this.f68070a = new d(fVar);
        this.f68071b = crashlyticsBackgroundWorker;
    }

    public static i i(String str, nk.f fVar, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        d dVar = new d(fVar);
        i iVar = new i(str, fVar, crashlyticsBackgroundWorker);
        iVar.f68073d.f68076a.getReference().e(dVar.g(str, false));
        iVar.f68074e.f68076a.getReference().e(dVar.g(str, true));
        iVar.f68075f.set(dVar.h(str), false);
        return iVar;
    }

    @Nullable
    public static String j(String str, nk.f fVar) {
        return new d(fVar).h(str);
    }

    public Map<String, String> e() {
        return this.f68073d.b();
    }

    public Map<String, String> f() {
        return this.f68074e.b();
    }

    @Nullable
    public String g() {
        return this.f68075f.getReference();
    }

    public final /* synthetic */ Object h() throws Exception {
        k();
        return null;
    }

    public final void k() throws Throwable {
        boolean z11;
        String strG;
        synchronized (this.f68075f) {
            try {
                z11 = false;
                if (this.f68075f.isMarked()) {
                    strG = g();
                    this.f68075f.set(strG, false);
                    z11 = true;
                } else {
                    strG = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            this.f68070a.m(this.f68072c, strG);
        }
    }

    public boolean l(String str, String str2) {
        return this.f68073d.f(str, str2);
    }

    public void m(String str) {
        String strC = b.c(str, 1024);
        synchronized (this.f68075f) {
            try {
                if (CommonUtils.A(strC, this.f68075f.getReference())) {
                    return;
                }
                this.f68075f.set(strC, true);
                this.f68071b.h(new Callable() { // from class: jk.g
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f68068a.h();
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
