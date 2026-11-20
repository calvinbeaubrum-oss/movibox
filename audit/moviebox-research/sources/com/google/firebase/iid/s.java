package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f40663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Pair<String, String>, Task<l>> f40664b = new androidx.collection.a();

    /* JADX INFO: compiled from: source.java */
    public interface a {
        Task<l> start();
    }

    public s(Executor executor) {
        this.f40663a = executor;
    }

    public synchronized Task<l> a(String str, String str2, a aVar) {
        final Pair<String, String> pair = new Pair<>(str, str2);
        Task<l> task = this.f40664b.get(pair);
        if (task != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(pair);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 29);
                sb2.append("Joining ongoing request for: ");
                sb2.append(strValueOf);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf2 = String.valueOf(pair);
            StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 24);
            sb3.append("Making new request for: ");
            sb3.append(strValueOf2);
        }
        Task taskContinueWithTask = aVar.start().continueWithTask(this.f40663a, new Continuation(this, pair) { // from class: com.google.firebase.iid.r

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final s f40661a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Pair f40662b;

            {
                this.f40661a = this;
                this.f40662b = pair;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) throws Exception {
                this.f40661a.b(this.f40662b, task2);
                return task2;
            }
        });
        this.f40664b.put(pair, (Task<l>) taskContinueWithTask);
        return taskContinueWithTask;
    }

    public final /* synthetic */ Task b(Pair pair, Task task) throws Exception {
        synchronized (this) {
            this.f40664b.remove(pair);
        }
        return task;
    }
}
