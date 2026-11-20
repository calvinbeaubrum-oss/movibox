package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class r extends com.google.android.play.core.appupdate.internal.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.play.core.appupdate.internal.s f38096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f38097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f38098c;

    public r(u uVar, com.google.android.play.core.appupdate.internal.s sVar, TaskCompletionSource taskCompletionSource) {
        this.f38098c = uVar;
        this.f38096a = sVar;
        this.f38097b = taskCompletionSource;
    }

    @Override // com.google.android.play.core.appupdate.internal.n
    public void L(Bundle bundle) throws RemoteException {
        this.f38098c.f38103a.u(this.f38097b);
        this.f38096a.d("onRequestInfo", new Object[0]);
    }

    @Override // com.google.android.play.core.appupdate.internal.n
    public void zzb(Bundle bundle) throws RemoteException {
        this.f38098c.f38103a.u(this.f38097b);
        this.f38096a.d("onCompleteUpdate", new Object[0]);
    }
}
