package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzv extends com.google.android.gms.internal.location.zzb implements zzw {
    public zzv() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzw zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterfaceQueryLocalInterface instanceof zzw ? (zzw) iInterfaceQueryLocalInterface : new zzu(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            LocationResult locationResult = (LocationResult) com.google.android.gms.internal.location.zzc.zza(parcel, LocationResult.CREATOR);
            com.google.android.gms.internal.location.zzc.zzd(parcel);
            zzd(locationResult);
        } else if (i11 == 2) {
            LocationAvailability locationAvailability = (LocationAvailability) com.google.android.gms.internal.location.zzc.zza(parcel, LocationAvailability.CREATOR);
            com.google.android.gms.internal.location.zzc.zzd(parcel);
            zze(locationAvailability);
        } else {
            if (i11 != 3) {
                return false;
            }
            zzf();
        }
        return true;
    }
}
