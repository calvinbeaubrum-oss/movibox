package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcv extends zzdu {
    final /* synthetic */ zzef zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcv(zzef zzefVar) {
        super(zzefVar, true);
        this.zza = zzefVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zza.zzj)).resetAnalyticsData(this.zzh);
    }
}
