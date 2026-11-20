package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f40844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f40845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f40846c;

    public f(Context context, g0 g0Var, ExecutorService executorService) {
        this.f40844a = executorService;
        this.f40845b = context;
        this.f40846c = g0Var;
    }

    public boolean a() {
        if (this.f40846c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        c0 c0VarD = d();
        d.a aVarE = d.e(this.f40845b, this.f40846c);
        e(aVarE.f40831a, c0VarD);
        c(aVarE);
        return true;
    }

    public final boolean b() {
        if (((KeyguardManager) this.f40845b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.isAtLeastLollipop()) {
            SystemClock.sleep(10L);
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f40845b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    public final void c(d.a aVar) {
        Log.isLoggable("FirebaseMessaging", 3);
        ((NotificationManager) this.f40845b.getSystemService("notification")).notify(aVar.f40832b, aVar.f40833c, aVar.f40831a.c());
    }

    @Nullable
    public final c0 d() {
        c0 c0VarD = c0.d(this.f40846c.p("gcm.n.image"));
        if (c0VarD != null) {
            c0VarD.h(this.f40844a);
        }
        return c0VarD;
    }

    public final void e(NotificationCompat.m mVar, @Nullable c0 c0Var) {
        if (c0Var == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(c0Var.e(), 5L, TimeUnit.SECONDS);
            mVar.B(bitmap);
            mVar.M(new NotificationCompat.j().r(bitmap).q(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            c0Var.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e11) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e11.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            c0Var.close();
        }
    }
}
