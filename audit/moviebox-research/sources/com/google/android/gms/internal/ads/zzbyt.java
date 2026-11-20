package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbyt extends zzayh implements zzbyu {
    public zzbyt() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final boolean zzbO(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        zzbyx zzbyvVar = null;
        if (i11 == 1) {
            zzbyi zzbyiVar = (zzbyi) zzayi.zza(parcel, zzbyi.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbyvVar = iInterfaceQueryLocalInterface instanceof zzbyx ? (zzbyx) iInterfaceQueryLocalInterface : new zzbyv(strongBinder);
            }
            zzayi.zzc(parcel);
            zzf(zzbyiVar, zzbyvVar);
        } else if (i11 == 2) {
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (iInterfaceQueryLocalInterface2 instanceof zzbyx) {
                }
            }
            zzayi.zzc(parcel);
        } else {
            if (i11 != 3) {
                return false;
            }
            zzbym zzbymVar = (zzbym) zzayi.zza(parcel, zzbym.CREATOR);
            IBinder strongBinder3 = parcel.readStrongBinder();
            if (strongBinder3 != null) {
                IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbyvVar = iInterfaceQueryLocalInterface3 instanceof zzbyx ? (zzbyx) iInterfaceQueryLocalInterface3 : new zzbyv(strongBinder3);
            }
            zzayi.zzc(parcel);
            zze(zzbymVar, zzbyvVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
