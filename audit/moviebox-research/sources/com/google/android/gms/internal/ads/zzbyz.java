package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbyz extends zzayh implements zzbza {
    public zzbyz() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final boolean zzbO(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzayi.zza(parcel, ParcelFileDescriptor.CREATOR);
            zzayi.zzc(parcel);
            zzf(parcelFileDescriptor);
        } else {
            if (i11 != 2) {
                return false;
            }
            com.google.android.gms.ads.internal.util.zzbb zzbbVar = (com.google.android.gms.ads.internal.util.zzbb) zzayi.zza(parcel, com.google.android.gms.ads.internal.util.zzbb.CREATOR);
            zzayi.zzc(parcel);
            zze(zzbbVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
