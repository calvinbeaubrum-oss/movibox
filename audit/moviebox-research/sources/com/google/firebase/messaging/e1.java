package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e1 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f40837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f40838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<a> f40839d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public b1 f40840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f40841g;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f40842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TaskCompletionSource<Void> f40843b = new TaskCompletionSource<>();

        public a(Intent intent) {
            this.f40842a = intent;
        }

        public void c(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.messaging.c1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40829a.f();
                }
            }, 20L, TimeUnit.SECONDS);
            e().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener() { // from class: com.google.firebase.messaging.d1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    scheduledFutureSchedule.cancel(false);
                }
            });
        }

        public void d() {
            this.f40843b.trySetResult(null);
        }

        public Task<Void> e() {
            return this.f40843b.getTask();
        }

        public final /* synthetic */ void f() {
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + this.f40842a.getAction() + " finishing.");
            d();
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    public e1(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    public e1(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f40839d = new ArrayDeque();
        this.f40841g = false;
        Context applicationContext = context.getApplicationContext();
        this.f40836a = applicationContext;
        this.f40837b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f40838c = scheduledExecutorService;
    }

    public final void a() {
        while (!this.f40839d.isEmpty()) {
            this.f40839d.poll().d();
        }
    }

    public final synchronized void b() {
        try {
            Log.isLoggable("FirebaseMessaging", 3);
            while (!this.f40839d.isEmpty()) {
                Log.isLoggable("FirebaseMessaging", 3);
                b1 b1Var = this.f40840f;
                if (b1Var == null || !b1Var.isBinderAlive()) {
                    d();
                    return;
                } else {
                    Log.isLoggable("FirebaseMessaging", 3);
                    this.f40840f.c(this.f40839d.poll());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized Task<Void> c(Intent intent) {
        a aVar;
        Log.isLoggable("FirebaseMessaging", 3);
        aVar = new a(intent);
        aVar.c(this.f40838c);
        this.f40839d.add(aVar);
        b();
        return aVar.e();
    }

    public final void d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("binder is dead. start connection? ");
            sb2.append(!this.f40841g);
        }
        if (this.f40841g) {
            return;
        }
        this.f40841g = true;
        try {
            if (ConnectionTracker.getInstance().bindService(this.f40836a, this.f40837b, this, 65)) {
                return;
            } else {
                Log.e("FirebaseMessaging", "binding to the service failed");
            }
        } catch (SecurityException e11) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e11);
        }
        this.f40841g = false;
        a();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onServiceConnected: ");
                sb2.append(componentName);
            }
            this.f40841g = false;
            if (iBinder instanceof b1) {
                this.f40840f = (b1) iBinder;
                b();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            a();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServiceDisconnected: ");
            sb2.append(componentName);
        }
        b();
    }
}
