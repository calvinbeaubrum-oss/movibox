package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.IntentSender;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface b {
    void a(@NonNull cj.a aVar);

    void b(@NonNull cj.a aVar);

    @NonNull
    Task<Void> c();

    @NonNull
    Task<a> d();

    @Deprecated
    boolean e(@NonNull a aVar, int i11, @NonNull Activity activity, int i12) throws IntentSender.SendIntentException;
}
