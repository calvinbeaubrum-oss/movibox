package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class t extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f38099d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ u f38100f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, TaskCompletionSource taskCompletionSource, String str) {
        super(uVar, new com.google.android.play.core.appupdate.internal.s("OnRequestInstallCallback"), taskCompletionSource);
        this.f38100f = uVar;
        this.f38099d = str;
    }

    @Override // com.google.android.play.core.appupdate.r, com.google.android.play.core.appupdate.internal.n
    public final void L(Bundle bundle) throws RemoteException {
        super.L(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f38097b.trySetException(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f38097b.trySetResult(u.f(this.f38100f, bundle, this.f38099d));
        }
    }
}
