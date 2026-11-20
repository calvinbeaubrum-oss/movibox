package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcg extends zzbm implements zzci {
    public zzcg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final int zzd() throws RemoteException {
        Parcel parcelZzb = zzb(2, zza());
        int i11 = parcelZzb.readInt();
        parcelZzb.recycle();
        return i11;
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final void zze(String str, String str2, Bundle bundle, long j11) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbo.zze(parcelZza, bundle);
        parcelZza.writeLong(j11);
        zzc(1, parcelZza);
    }
}
