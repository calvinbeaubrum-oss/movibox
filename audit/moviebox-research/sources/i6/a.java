package i6;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.startup.InitializationProvider;
import androidx.startup.R$string;
import androidx.startup.StartupException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f67148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f67149e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Context f67152c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Set<Class<? extends b<?>>> f67151b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Map<Class<?>, Object> f67150a = new HashMap();

    public a(@NonNull Context context) {
        this.f67152c = context.getApplicationContext();
    }

    @NonNull
    public static a e(@NonNull Context context) {
        if (f67148d == null) {
            synchronized (f67149e) {
                try {
                    if (f67148d == null) {
                        f67148d = new a(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f67148d;
    }

    public void a() {
        try {
            try {
                j6.b.a("Startup");
                b(this.f67152c.getPackageManager().getProviderInfo(new ComponentName(this.f67152c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                j6.b.b();
            } catch (PackageManager.NameNotFoundException e11) {
                throw new StartupException(e11);
            }
        } catch (Throwable th2) {
            j6.b.b();
            throw th2;
        }
    }

    public void b(@Nullable Bundle bundle) {
        String string = this.f67152c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f67151b.add((Class<? extends b<?>>) cls);
                        }
                    }
                }
                Iterator<Class<? extends b<?>>> it = this.f67151b.iterator();
                while (it.hasNext()) {
                    d(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e11) {
                throw new StartupException(e11);
            }
        }
    }

    @NonNull
    public <T> T c(@NonNull Class<? extends b<?>> cls) {
        T t11;
        synchronized (f67149e) {
            try {
                t11 = (T) this.f67150a.get(cls);
                if (t11 == null) {
                    t11 = (T) d(cls, new HashSet());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return t11;
    }

    @NonNull
    public final <T> T d(@NonNull Class<? extends b<?>> cls, @NonNull Set<Class<?>> set) {
        T t11;
        if (j6.b.d()) {
            try {
                j6.b.a(cls.getSimpleName());
            } catch (Throwable th2) {
                j6.b.b();
                throw th2;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f67150a.containsKey(cls)) {
            t11 = (T) this.f67150a.get(cls);
        } else {
            set.add(cls);
            try {
                b<?> bVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends b<?>>> listA = bVarNewInstance.a();
                if (!listA.isEmpty()) {
                    for (Class<? extends b<?>> cls2 : listA) {
                        if (!this.f67150a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                t11 = (T) bVarNewInstance.create(this.f67152c);
                set.remove(cls);
                this.f67150a.put(cls, t11);
            } catch (Throwable th3) {
                throw new StartupException(th3);
            }
        }
        j6.b.b();
        return t11;
    }

    @NonNull
    public <T> T f(@NonNull Class<? extends b<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(@NonNull Class<? extends b<?>> cls) {
        return this.f67151b.contains(cls);
    }
}
