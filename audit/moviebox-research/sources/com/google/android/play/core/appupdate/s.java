package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class s extends r {
    public s(u uVar, TaskCompletionSource taskCompletionSource) {
        super(uVar, new com.google.android.play.core.appupdate.internal.s("OnCompleteUpdateCallback"), taskCompletionSource);
    }

    @Override // com.google.android.play.core.appupdate.r, com.google.android.play.core.appupdate.internal.n
    public final void zzb(Bundle bundle) throws RemoteException {
        super.zzb(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f38097b.trySetException(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f38097b.trySetResult(null);
        }
    }
}
