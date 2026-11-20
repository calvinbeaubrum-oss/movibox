package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f40876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Task<String>> f40877b = new androidx.collection.a();

    /* JADX INFO: compiled from: source.java */
    public interface a {
        Task<String> start();
    }

    public p0(Executor executor) {
        this.f40876a = executor;
    }

    public synchronized Task<String> b(final String str, a aVar) {
        Task<String> task = this.f40877b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Joining ongoing request for: ");
                sb2.append(str);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Making new request for: ");
            sb3.append(str);
        }
        Task taskContinueWithTask = aVar.start().continueWithTask(this.f40876a, new Continuation() { // from class: com.google.firebase.messaging.o0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f40873a.c(str, task2);
            }
        });
        this.f40877b.put(str, (Task<String>) taskContinueWithTask);
        return taskContinueWithTask;
    }

    public final /* synthetic */ Task c(String str, Task task) throws Exception {
        synchronized (this) {
            this.f40877b.remove(str);
        }
        return task;
    }
}
