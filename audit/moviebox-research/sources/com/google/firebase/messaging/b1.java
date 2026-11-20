package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b1 extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f40825a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        Task<Void> a(Intent intent);
    }

    public b1(a aVar) {
        this.f40825a = aVar;
    }

    public void c(final e1.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        Log.isLoggable("FirebaseMessaging", 3);
        this.f40825a.a(aVar.f40842a).addOnCompleteListener(new b6.m(), new OnCompleteListener() { // from class: com.google.firebase.messaging.a1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                aVar.d();
            }
        });
    }
}
