package com.vungle.warren;

import com.vungle.warren.persistence.Repository;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class PrivacyManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<Boolean> f61775c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference<Boolean> f61776d = new AtomicReference<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static PrivacyManager f61777e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Repository f61778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExecutorService f61779b;

    /* JADX INFO: compiled from: source.java */
    public enum COPPA {
        COPPA_ENABLED(Boolean.TRUE),
        COPPA_DISABLED(Boolean.FALSE),
        COPPA_NOTSET(null);

        private Boolean value;

        COPPA(Boolean bool) {
            this.value = bool;
        }

        public boolean getValue() {
            Boolean bool = this.value;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
    }

    public static synchronized PrivacyManager d() {
        try {
            if (f61777e == null) {
                f61777e = new PrivacyManager();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f61777e;
    }

    public final void b() {
        this.f61778a.v(com.vungle.warren.model.c.class);
        this.f61778a.v(com.vungle.warren.model.e.class);
    }

    public COPPA c() {
        AtomicReference<Boolean> atomicReference = f61775c;
        if (atomicReference == null || atomicReference.get() == null) {
            return COPPA.COPPA_NOTSET;
        }
        if (atomicReference.get().booleanValue()) {
            return COPPA.COPPA_ENABLED;
        }
        return !atomicReference.get().booleanValue() ? COPPA.COPPA_DISABLED : COPPA.COPPA_NOTSET;
    }

    public synchronized void e(ExecutorService executorService, Repository repository) {
        try {
            this.f61778a = repository;
            this.f61779b = executorService;
            Boolean boolA = com.vungle.warren.utility.e.a(repository, "coppa_cookie", "is_coppa");
            AtomicReference<Boolean> atomicReference = f61775c;
            if (atomicReference.get() != null) {
                g(atomicReference.get());
            } else if (boolA != null) {
                atomicReference.set(boolA);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public boolean f() {
        AtomicReference<Boolean> atomicReference = f61776d;
        if (atomicReference == null || atomicReference.get() == null) {
            return false;
        }
        return !atomicReference.get().booleanValue();
    }

    public void g(final Boolean bool) {
        ExecutorService executorService;
        if (bool != null) {
            f61775c.set(bool);
            if (this.f61778a == null || (executorService = this.f61779b) == null) {
                return;
            }
            executorService.execute(new Runnable() { // from class: com.vungle.warren.PrivacyManager.1
                @Override // java.lang.Runnable
                public void run() {
                    com.vungle.warren.utility.e.b(PrivacyManager.this.f61778a, "coppa_cookie", "is_coppa", bool);
                }
            });
        }
    }

    public void h(boolean z11) {
        f61776d.set(Boolean.valueOf(z11));
        Repository repository = this.f61778a;
        if (repository == null) {
            return;
        }
        Boolean boolA = com.vungle.warren.utility.e.a(repository, "coppa_cookie", "disable_ad_id");
        if ((boolA == null || !boolA.booleanValue()) && z11) {
            b();
        }
        com.vungle.warren.utility.e.b(this.f61778a, "coppa_cookie", "disable_ad_id", Boolean.valueOf(z11));
    }
}
