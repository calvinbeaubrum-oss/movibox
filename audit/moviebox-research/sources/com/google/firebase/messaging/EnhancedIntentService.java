package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class EnhancedIntentService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Binder f40735b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f40737d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f40734a = n.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f40736c = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f40738f = 0;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a implements b1.a {
        public a() {
        }

        @Override // com.google.firebase.messaging.b1.a
        @KeepForSdk
        public Task<Void> a(Intent intent) {
            return EnhancedIntentService.this.j(intent);
        }
    }

    public final void d(Intent intent) {
        if (intent != null) {
            z0.c(intent);
        }
        synchronized (this.f40736c) {
            try {
                int i11 = this.f40738f - 1;
                this.f40738f = i11;
                if (i11 == 0) {
                    k(this.f40737d);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Intent e(Intent intent) {
        return intent;
    }

    public abstract void f(Intent intent);

    public boolean g(Intent intent) {
        return false;
    }

    public final /* synthetic */ void h(Intent intent, Task task) {
        d(intent);
    }

    public final /* synthetic */ void i(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            f(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }

    public final Task<Void> j(final Intent intent) {
        if (g(intent)) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f40734a.execute(new Runnable() { // from class: com.google.firebase.messaging.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f40855a.i(intent, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public boolean k(int i11) {
        return stopSelfResult(i11);
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            Log.isLoggable("EnhancedIntentService", 3);
            if (this.f40735b == null) {
                this.f40735b = new b1(new a());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f40735b;
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.f40734a.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i11, int i12) {
        synchronized (this.f40736c) {
            this.f40737d = i12;
            this.f40738f++;
        }
        Intent intentE = e(intent);
        if (intentE == null) {
            d(intent);
            return 2;
        }
        Task<Void> taskJ = j(intentE);
        if (taskJ.isComplete()) {
            d(intent);
            return 2;
        }
        taskJ.addOnCompleteListener(new c6.e(), new OnCompleteListener() { // from class: com.google.firebase.messaging.g
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f40852a.h(intent, task);
            }
        });
        return 3;
    }
}
