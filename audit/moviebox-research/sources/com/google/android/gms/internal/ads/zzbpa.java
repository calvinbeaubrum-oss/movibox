package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbpa implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzceu zza;
    final /* synthetic */ zzbpc zzb;

    public zzbpa(zzbpc zzbpcVar, zzceu zzceuVar) {
        this.zza = zzceuVar;
        this.zzb = zzbpcVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        try {
            this.zza.zzc(this.zzb.zza.zzp());
        } catch (DeadObjectException e11) {
            this.zza.zzd(e11);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i11) {
        this.zza.zzd(new RuntimeException("onConnectionSuspended: " + i11));
    }
}
