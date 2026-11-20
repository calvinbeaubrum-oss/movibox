package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzcc implements RemoteCall {
    static final /* synthetic */ zzcc zza = new zzcc();

    private /* synthetic */ zzcc() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        ((zzdz) obj).zzz((TaskCompletionSource) obj2);
    }
}
