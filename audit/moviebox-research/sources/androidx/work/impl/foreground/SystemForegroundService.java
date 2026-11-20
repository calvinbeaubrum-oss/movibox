package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.lifecycle.LifecycleService;
import androidx.work.j;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13447g = j.i("SystemFgService");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public static SystemForegroundService f13448h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f13449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SystemForegroundDispatcher f13451d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NotificationManager f13452f;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class a {
        public static void a(Service service, int i11, Notification notification, int i12) {
            service.startForeground(i11, notification, i12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static class b {
        public static void a(Service service, int i11, Notification notification, int i12) {
            try {
                service.startForeground(i11, notification, i12);
            } catch (ForegroundServiceStartNotAllowedException e11) {
                j.e().l(SystemForegroundService.f13447g, "Unable to start foreground service", e11);
            }
        }
    }

    private void f() {
        this.f13449b = new Handler(Looper.getMainLooper());
        this.f13452f = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.f13451d = systemForegroundDispatcher;
        systemForegroundDispatcher.n(this);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void a(final int i11, @NonNull final Notification notification) {
        this.f13449b.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.2
            @Override // java.lang.Runnable
            public void run() {
                SystemForegroundService.this.f13452f.notify(i11, notification);
            }
        });
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void c(final int i11, final int i12, @NonNull final Notification notification) {
        this.f13449b.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.1
            @Override // java.lang.Runnable
            public void run() {
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 31) {
                    b.a(SystemForegroundService.this, i11, notification, i12);
                } else if (i13 >= 29) {
                    a.a(SystemForegroundService.this, i11, notification, i12);
                } else {
                    SystemForegroundService.this.startForeground(i11, notification);
                }
            }
        });
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void d(final int i11) {
        this.f13449b.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.3
            @Override // java.lang.Runnable
            public void run() {
                SystemForegroundService.this.f13452f.cancel(i11);
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f13448h = this;
        f();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f13451d.l();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i11, int i12) {
        super.onStartCommand(intent, i11, i12);
        if (this.f13450c) {
            j.e().f(f13447g, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f13451d.l();
            f();
            this.f13450c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f13451d.m(intent);
        return 3;
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void stop() {
        this.f13450c = true;
        j.e().a(f13447g, "All commands completed.");
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f13448h = null;
        stopSelf();
    }
}
