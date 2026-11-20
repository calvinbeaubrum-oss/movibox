package com.vungle.warren.utility;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ActivityManager implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f62553k = "ActivityManager";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ActivityManager f62554l = new ActivityManager();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f62555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f62556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f62557c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f62560g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CopyOnWriteArraySet<e> f62558d = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<d, e> f62559f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f62561h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f62562i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f62563j = new Runnable() { // from class: com.vungle.warren.utility.ActivityManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (ActivityManager.this.f62557c == 0 && !ActivityManager.this.f62561h) {
                ActivityManager.this.f62561h = true;
                Iterator it = ActivityManager.this.f62558d.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a();
                }
            }
            if (ActivityManager.this.f62556b == 0 && ActivityManager.this.f62561h && !ActivityManager.this.f62562i) {
                ActivityManager.this.f62562i = true;
                Iterator it2 = ActivityManager.this.f62558d.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).d();
                }
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    public class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f62564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f62565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f62566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PresenterAdOpenCallback f62567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d f62568e;

        public a(WeakReference weakReference, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback, d dVar) {
            this.f62564a = weakReference;
            this.f62565b = intent;
            this.f62566c = intent2;
            this.f62567d = presenterAdOpenCallback;
            this.f62568e = dVar;
        }

        @Override // com.vungle.warren.utility.ActivityManager.e
        public void c() {
            super.c();
            ActivityManager.f62554l.t(this);
            Context context = (Context) this.f62564a.get();
            if (context == null || !ActivityManager.v(context, this.f62565b, this.f62566c, this.f62567d)) {
                return;
            }
            ActivityManager.f62554l.o(this.f62568e);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f62569a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f62570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f62571c;

        public b(WeakReference weakReference, Runnable runnable) {
            this.f62570b = weakReference;
            this.f62571c = runnable;
        }

        @Override // com.vungle.warren.utility.ActivityManager.e
        public void a() {
            super.a();
            this.f62569a = true;
            ActivityManager.this.f62560g.removeCallbacks(this.f62571c);
        }

        @Override // com.vungle.warren.utility.ActivityManager.e
        public void b() {
            super.b();
            ActivityManager.this.f62560g.postDelayed(this.f62571c, 1400L);
        }

        @Override // com.vungle.warren.utility.ActivityManager.e
        public void d() {
            super.d();
            d dVar = (d) this.f62570b.get();
            if (this.f62569a && dVar != null && ActivityManager.this.f62559f.containsKey(dVar)) {
                dVar.a();
            }
            ActivityManager.this.u(dVar);
            ActivityManager.this.f62560g.removeCallbacks(this.f62571c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f62573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f62574b;

        public c(WeakReference weakReference, Runnable runnable) {
            this.f62573a = weakReference;
            this.f62574b = runnable;
        }

        @Override // com.vungle.warren.utility.ActivityManager.e
        public void c() {
            ActivityManager.f62554l.t(this);
            e eVar = (e) ActivityManager.this.f62559f.get(this.f62573a.get());
            if (eVar != null) {
                ActivityManager.this.f62560g.postDelayed(this.f62574b, 3000L);
                ActivityManager.this.n(eVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a();
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public static ActivityManager p() {
        return f62554l;
    }

    public static boolean v(Context context, @Nullable Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback) {
        if (intent == null && intent2 == null) {
            return false;
        }
        try {
            if (intent != null) {
                context.startActivity(intent);
            } else {
                context.startActivity(intent2);
            }
            if (presenterAdOpenCallback != null) {
                presenterAdOpenCallback.a(intent != null ? PresenterAdOpenCallback.AdOpenType.DEEP_LINK : PresenterAdOpenCallback.AdOpenType.DEFAULT);
            }
            return true;
        } catch (ActivityNotFoundException e11) {
            Log.e(f62553k, "Cannot find activity to handle the Implicit intent: " + e11.getLocalizedMessage());
            if (intent != null && intent2 != null) {
                try {
                    context.startActivity(intent2);
                    if (presenterAdOpenCallback != null) {
                        presenterAdOpenCallback.a(PresenterAdOpenCallback.AdOpenType.DEFAULT);
                    }
                    return true;
                } catch (ActivityNotFoundException unused) {
                    return false;
                }
            }
            return false;
        }
    }

    public static void w(Context context, @Nullable Intent intent, Intent intent2, @Nullable d dVar) {
        x(context, intent, intent2, dVar, null);
    }

    public static void x(Context context, @Nullable Intent intent, Intent intent2, @Nullable d dVar, @Nullable PresenterAdOpenCallback presenterAdOpenCallback) {
        WeakReference weakReference = new WeakReference(context);
        ActivityManager activityManager = f62554l;
        if (!activityManager.q()) {
            activityManager.n(new a(weakReference, intent, intent2, presenterAdOpenCallback, dVar));
        } else if (v(context, intent, intent2, presenterAdOpenCallback)) {
            activityManager.o(dVar);
        }
    }

    public void n(e eVar) {
        this.f62558d.add(eVar);
    }

    public void o(@Nullable d dVar) {
        if (dVar == null) {
            return;
        }
        if (!this.f62555a) {
            dVar.a();
            return;
        }
        final WeakReference weakReference = new WeakReference(dVar);
        Runnable runnable = new Runnable() { // from class: com.vungle.warren.utility.ActivityManager.3
            @Override // java.lang.Runnable
            public void run() {
                ActivityManager.this.f62560g.removeCallbacks(this);
                ActivityManager.this.u((d) weakReference.get());
            }
        };
        b bVar = new b(weakReference, runnable);
        this.f62559f.put(dVar, bVar);
        if (!q()) {
            p().n(new c(weakReference, runnable));
        } else {
            this.f62560g.postDelayed(runnable, 3000L);
            n(bVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        this.f62557c = Math.max(0, this.f62557c - 1);
        this.f62560g.postDelayed(this.f62563j, 700L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        int i11 = this.f62557c + 1;
        this.f62557c = i11;
        if (i11 == 1) {
            if (!this.f62561h) {
                this.f62560g.removeCallbacks(this.f62563j);
                return;
            }
            this.f62561h = false;
            Iterator<e> it = this.f62558d.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        int i11 = this.f62556b + 1;
        this.f62556b = i11;
        if (i11 == 1 && this.f62562i) {
            this.f62562i = false;
            Iterator<e> it = this.f62558d.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        this.f62556b = Math.max(0, this.f62556b - 1);
        this.f62560g.postDelayed(this.f62563j, 700L);
    }

    public boolean q() {
        return !this.f62555a || this.f62556b > 0;
    }

    public void r(Context context) {
        if (this.f62555a) {
            return;
        }
        this.f62560g = new Handler(Looper.getMainLooper());
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
        this.f62555a = true;
    }

    public boolean s() {
        return this.f62555a;
    }

    public final void t(e eVar) {
        this.f62558d.remove(eVar);
    }

    public final void u(@Nullable d dVar) {
        e eVarRemove;
        if (dVar == null || (eVarRemove = this.f62559f.remove(dVar)) == null) {
            return;
        }
        t(eVarRemove);
    }
}
