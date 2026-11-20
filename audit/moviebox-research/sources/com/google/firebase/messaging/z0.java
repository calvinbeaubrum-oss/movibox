package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f40963a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f40964b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WakeLock f40965c;

    public static void b(Context context) {
        if (f40965c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f40965c = wakeLock;
            wakeLock.setReferenceCounted(true);
        }
    }

    public static void c(@NonNull Intent intent) {
        synchronized (f40964b) {
            try {
                if (f40965c != null && d(intent)) {
                    g(intent, false);
                    f40965c.release();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean d(@NonNull Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    @SuppressLint({"TaskMainThread"})
    public static void f(Context context, e1 e1Var, final Intent intent) {
        synchronized (f40964b) {
            try {
                b(context);
                boolean zD = d(intent);
                g(intent, true);
                if (!zD) {
                    f40965c.acquire(f40963a);
                }
                e1Var.c(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.y0
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        z0.c(intent);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void g(@NonNull Intent intent, boolean z11) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z11);
    }

    public static ComponentName h(@NonNull Context context, @NonNull Intent intent) {
        synchronized (f40964b) {
            try {
                b(context);
                boolean zD = d(intent);
                g(intent, true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!zD) {
                    f40965c.acquire(f40963a);
                }
                return componentNameStartService;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
