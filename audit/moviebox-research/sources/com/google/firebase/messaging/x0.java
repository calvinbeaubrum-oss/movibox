package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class x0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f40952i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f40954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f40955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f40956d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f40958f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v0 f40960h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, ArrayDeque<TaskCompletionSource<Void>>> f40957e = new androidx.collection.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f40959g = false;

    public x0(FirebaseMessaging firebaseMessaging, f0 f0Var, v0 v0Var, a0 a0Var, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.f40956d = firebaseMessaging;
        this.f40954b = f0Var;
        this.f40960h = v0Var;
        this.f40955c = a0Var;
        this.f40953a = context;
        this.f40958f = scheduledExecutorService;
    }

    public static <T> void b(Task<T> task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            e = e11;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e12);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e13) {
            e = e13;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    public static Task<x0> e(final FirebaseMessaging firebaseMessaging, final f0 f0Var, final a0 a0Var, final Context context, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.w0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x0.i(context, scheduledExecutorService, firebaseMessaging, f0Var, a0Var);
            }
        });
    }

    public static boolean g() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    public static /* synthetic */ x0 i(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, f0 f0Var, a0 a0Var) throws Exception {
        return new x0(firebaseMessaging, f0Var, v0.a(context, scheduledExecutorService), a0Var, context, scheduledExecutorService);
    }

    public final void c(String str) throws IOException {
        b(this.f40955c.k(this.f40956d.j(), str));
    }

    public final void d(String str) throws IOException {
        b(this.f40955c.l(this.f40956d.j(), str));
    }

    public boolean f() {
        return this.f40960h.b() != null;
    }

    public synchronized boolean h() {
        return this.f40959g;
    }

    public final void j(u0 u0Var) {
        synchronized (this.f40957e) {
            try {
                String strE = u0Var.e();
                if (this.f40957e.containsKey(strE)) {
                    ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.f40957e.get(strE);
                    TaskCompletionSource<Void> taskCompletionSourcePoll = arrayDeque.poll();
                    if (taskCompletionSourcePoll != null) {
                        taskCompletionSourcePoll.setResult(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.f40957e.remove(strE);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    public boolean k(u0 u0Var) throws IOException {
        byte b11;
        try {
            String strB = u0Var.b();
            int iHashCode = strB.hashCode();
            if (iHashCode != 83) {
                if (iHashCode == 85 && strB.equals("U")) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
            } else if (strB.equals("S")) {
                b11 = 0;
            } else {
                b11 = -1;
            }
            if (b11 == 0) {
                c(u0Var.c());
                if (g()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Subscribe to topic: ");
                    sb2.append(u0Var.c());
                    sb2.append(" succeeded.");
                }
            } else if (b11 == 1) {
                d(u0Var.c());
                if (g()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unsubscribe from topic: ");
                    sb3.append(u0Var.c());
                    sb3.append(" succeeded.");
                }
            } else if (g()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Unknown topic operation");
                sb4.append(u0Var);
                sb4.append(InstructionFileId.DOT);
            }
            return true;
        } catch (IOException e11) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e11.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e11.getMessage())) {
                if (e11.getMessage() != null) {
                    throw e11;
                }
                Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                return false;
            }
            Log.e("FirebaseMessaging", "Topic operation failed: " + e11.getMessage() + ". Will retry Topic operation.");
            return false;
        }
    }

    public void l(Runnable runnable, long j11) {
        this.f40958f.schedule(runnable, j11, TimeUnit.SECONDS);
    }

    public synchronized void m(boolean z11) {
        this.f40959g = z11;
    }

    public final void n() {
        if (h()) {
            return;
        }
        q(0L);
    }

    public void o() {
        if (f()) {
            n();
        }
    }

    public boolean p() throws IOException {
        while (true) {
            synchronized (this) {
                try {
                    u0 u0VarB = this.f40960h.b();
                    if (u0VarB == null) {
                        g();
                        return true;
                    }
                    if (!k(u0VarB)) {
                        return false;
                    }
                    this.f40960h.d(u0VarB);
                    j(u0VarB);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void q(long j11) {
        l(new TopicsSyncTask(this, this.f40953a, this.f40954b, Math.min(Math.max(30L, 2 * j11), f40952i)), j11);
        m(true);
    }
}
