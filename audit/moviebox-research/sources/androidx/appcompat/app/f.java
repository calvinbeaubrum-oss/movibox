package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f883a = new c(new d());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f884b = -100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static androidx.core.os.h f885c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static androidx.core.os.h f886d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Boolean f887f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f888g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final androidx.collection.b<WeakReference<f>> f889h = new androidx.collection.b<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f890i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f891j = new Object();

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(33)
    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f892a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Queue<Runnable> f893b = new ArrayDeque();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Executor f894c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Runnable f895d;

        public c(Executor executor) {
            this.f894c = executor;
        }

        public final /* synthetic */ void b(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                c();
            }
        }

        public void c() {
            synchronized (this.f892a) {
                try {
                    Runnable runnablePoll = this.f893b.poll();
                    this.f895d = runnablePoll;
                    if (runnablePoll != null) {
                        this.f894c.execute(runnablePoll);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f892a) {
                try {
                    this.f893b.add(new Runnable() { // from class: androidx.appcompat.app.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f896a.b(runnable);
                        }
                    });
                    if (this.f895d == null) {
                        c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    public static void I(@NonNull f fVar) {
        synchronized (f890i) {
            J(fVar);
        }
    }

    public static void J(@NonNull f fVar) {
        synchronized (f890i) {
            try {
                Iterator<WeakReference<f>> it = f889h.iterator();
                while (it.hasNext()) {
                    f fVar2 = it.next().get();
                    if (fVar2 == fVar || fVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void O(int i11) {
        if ((i11 == -1 || i11 == 0 || i11 == 1 || i11 == 2 || i11 == 3) && f884b != i11) {
            f884b = i11;
            g();
        }
    }

    public static void U(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (n().f()) {
                    String strB = androidx.core.app.c.b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        b.b(systemService, a.a(strB));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    public static void V(final Context context) {
        if (y(context)) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (f888g) {
                    return;
                }
                f883a.execute(new Runnable() { // from class: androidx.appcompat.app.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.z(context);
                    }
                });
                return;
            }
            synchronized (f891j) {
                try {
                    androidx.core.os.h hVar = f885c;
                    if (hVar == null) {
                        if (f886d == null) {
                            f886d = androidx.core.os.h.c(androidx.core.app.c.b(context));
                        }
                        if (f886d.f()) {
                        } else {
                            f885c = f886d;
                        }
                    } else if (!hVar.equals(f886d)) {
                        androidx.core.os.h hVar2 = f885c;
                        f886d = hVar2;
                        androidx.core.app.c.a(context, hVar2.h());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void d(@NonNull f fVar) {
        synchronized (f890i) {
            J(fVar);
            f889h.add(new WeakReference<>(fVar));
        }
    }

    public static void g() {
        synchronized (f890i) {
            try {
                Iterator<WeakReference<f>> it = f889h.iterator();
                while (it.hasNext()) {
                    f fVar = it.next().get();
                    if (fVar != null) {
                        fVar.f();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    public static f j(@NonNull Activity activity, @Nullable androidx.appcompat.app.d dVar) {
        return new AppCompatDelegateImpl(activity, dVar);
    }

    @NonNull
    public static f k(@NonNull Dialog dialog, @Nullable androidx.appcompat.app.d dVar) {
        return new AppCompatDelegateImpl(dialog, dVar);
    }

    @NonNull
    public static androidx.core.os.h n() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object objS = s();
            if (objS != null) {
                return androidx.core.os.h.j(b.a(objS));
            }
        } else {
            androidx.core.os.h hVar = f885c;
            if (hVar != null) {
                return hVar;
            }
        }
        return androidx.core.os.h.e();
    }

    public static int p() {
        return f884b;
    }

    @RequiresApi(33)
    public static Object s() {
        Context contextO;
        Iterator<WeakReference<f>> it = f889h.iterator();
        while (it.hasNext()) {
            f fVar = it.next().get();
            if (fVar != null && (contextO = fVar.o()) != null) {
                return contextO.getSystemService("locale");
            }
        }
        return null;
    }

    @Nullable
    public static androidx.core.os.h u() {
        return f885c;
    }

    public static boolean y(Context context) {
        if (f887f == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f887f = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f887f = Boolean.FALSE;
            }
        }
        return f887f.booleanValue();
    }

    public static /* synthetic */ void z(Context context) {
        U(context);
        f888g = true;
    }

    public abstract void A(Configuration configuration);

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D(Bundle bundle);

    public abstract void E();

    public abstract void F(Bundle bundle);

    public abstract void G();

    public abstract void H();

    public abstract boolean K(int i11);

    public abstract void L(int i11);

    public abstract void M(View view);

    public abstract void N(View view, ViewGroup.LayoutParams layoutParams);

    @RequiresApi(33)
    @CallSuper
    public void P(@Nullable OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void Q(@Nullable Toolbar toolbar);

    public void R(int i11) {
    }

    public abstract void S(@Nullable CharSequence charSequence);

    @Nullable
    public abstract g1.b T(@NonNull g1.b.a aVar);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean f();

    @Deprecated
    public void h(Context context) {
    }

    @NonNull
    @CallSuper
    public Context i(@NonNull Context context) {
        h(context);
        return context;
    }

    public abstract View l(@Nullable View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet);

    @Nullable
    public abstract <T extends View> T m(int i11);

    @Nullable
    public Context o() {
        return null;
    }

    @Nullable
    public abstract androidx.appcompat.app.b q();

    public int r() {
        return -100;
    }

    public abstract MenuInflater t();

    @Nullable
    public abstract androidx.appcompat.app.a v();

    public abstract void w();

    public abstract void x();
}
