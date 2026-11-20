package nl;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ql.a f72059c = ql.a.e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static w f72060d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile SharedPreferences f72061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f72062b;

    public w(ExecutorService executorService) {
        this.f72062b = executorService;
    }

    public static synchronized w e() {
        try {
            if (f72060d == null) {
                f72060d = new w(Executors.newSingleThreadExecutor());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72060d;
    }

    public com.google.firebase.perf.util.e<Boolean> b(String str) {
        if (str == null) {
            f72059c.a("Key is null when getting boolean value on device cache.");
            return com.google.firebase.perf.util.e.a();
        }
        if (this.f72061a == null) {
            i(c());
            if (this.f72061a == null) {
                return com.google.firebase.perf.util.e.a();
            }
        }
        if (!this.f72061a.contains(str)) {
            return com.google.firebase.perf.util.e.a();
        }
        try {
            return com.google.firebase.perf.util.e.e(Boolean.valueOf(this.f72061a.getBoolean(str, false)));
        } catch (ClassCastException e11) {
            f72059c.b("Key %s from sharedPreferences has type other than long: %s", str, e11.getMessage());
            return com.google.firebase.perf.util.e.a();
        }
    }

    @Nullable
    public final Context c() {
        try {
            jj.e.k();
            return jj.e.k().j();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public com.google.firebase.perf.util.e<Float> d(String str) {
        if (str == null) {
            f72059c.a("Key is null when getting float value on device cache.");
            return com.google.firebase.perf.util.e.a();
        }
        if (this.f72061a == null) {
            i(c());
            if (this.f72061a == null) {
                return com.google.firebase.perf.util.e.a();
            }
        }
        if (!this.f72061a.contains(str)) {
            return com.google.firebase.perf.util.e.a();
        }
        try {
            return com.google.firebase.perf.util.e.e(Float.valueOf(this.f72061a.getFloat(str, 0.0f)));
        } catch (ClassCastException e11) {
            f72059c.b("Key %s from sharedPreferences has type other than float: %s", str, e11.getMessage());
            return com.google.firebase.perf.util.e.a();
        }
    }

    public com.google.firebase.perf.util.e<Long> f(String str) {
        if (str == null) {
            f72059c.a("Key is null when getting long value on device cache.");
            return com.google.firebase.perf.util.e.a();
        }
        if (this.f72061a == null) {
            i(c());
            if (this.f72061a == null) {
                return com.google.firebase.perf.util.e.a();
            }
        }
        if (!this.f72061a.contains(str)) {
            return com.google.firebase.perf.util.e.a();
        }
        try {
            return com.google.firebase.perf.util.e.e(Long.valueOf(this.f72061a.getLong(str, 0L)));
        } catch (ClassCastException e11) {
            f72059c.b("Key %s from sharedPreferences has type other than long: %s", str, e11.getMessage());
            return com.google.firebase.perf.util.e.a();
        }
    }

    public com.google.firebase.perf.util.e<String> g(String str) {
        if (str == null) {
            f72059c.a("Key is null when getting String value on device cache.");
            return com.google.firebase.perf.util.e.a();
        }
        if (this.f72061a == null) {
            i(c());
            if (this.f72061a == null) {
                return com.google.firebase.perf.util.e.a();
            }
        }
        if (!this.f72061a.contains(str)) {
            return com.google.firebase.perf.util.e.a();
        }
        try {
            return com.google.firebase.perf.util.e.e(this.f72061a.getString(str, ""));
        } catch (ClassCastException e11) {
            f72059c.b("Key %s from sharedPreferences has type other than String: %s", str, e11.getMessage());
            return com.google.firebase.perf.util.e.a();
        }
    }

    public final /* synthetic */ void h(Context context) {
        if (this.f72061a != null || context == null) {
            return;
        }
        this.f72061a = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
    }

    public synchronized void i(final Context context) {
        if (this.f72061a == null && context != null) {
            this.f72062b.execute(new Runnable() { // from class: nl.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.f72057a.h(context);
                }
            });
        }
    }

    public boolean j(String str, float f11) {
        if (str == null) {
            f72059c.a("Key is null when setting float value on device cache.");
            return false;
        }
        if (this.f72061a == null) {
            i(c());
            if (this.f72061a == null) {
                return false;
            }
        }
        this.f72061a.edit().putFloat(str, f11).apply();
        return true;
    }

    public boolean k(String str, long j11) {
        if (str == null) {
            f72059c.a("Key is null when setting long value on device cache.");
            return false;
        }
        if (this.f72061a == null) {
            i(c());
            if (this.f72061a == null) {
                return false;
            }
        }
        this.f72061a.edit().putLong(str, j11).apply();
        return true;
    }

    public boolean l(String str, String str2) {
        if (str == null) {
            f72059c.a("Key is null when setting String value on device cache.");
            return false;
        }
        if (this.f72061a == null) {
            i(c());
            if (this.f72061a == null) {
                return false;
            }
        }
        if (str2 == null) {
            this.f72061a.edit().remove(str).apply();
            return true;
        }
        this.f72061a.edit().putString(str, str2).apply();
        return true;
    }

    public boolean m(String str, boolean z11) {
        if (str == null) {
            f72059c.a("Key is null when setting boolean value on device cache.");
            return false;
        }
        if (this.f72061a == null) {
            i(c());
            if (this.f72061a == null) {
                return false;
            }
        }
        this.f72061a.edit().putBoolean(str, z11).apply();
        return true;
    }
}
