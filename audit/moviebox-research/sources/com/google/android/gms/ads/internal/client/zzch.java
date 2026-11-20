package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzch extends zzayh implements zzci {
    public zzch() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final boolean zzbO(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zze zzeVar = (zze) zzayi.zza(parcel, zze.CREATOR);
            zzayi.zzc(parcel);
            zzd(zzeVar);
        } else if (i11 == 2) {
            zzf();
        } else if (i11 == 3) {
            zzc();
        } else if (i11 == 4) {
            zze();
        } else {
            if (i11 != 5) {
                return false;
            }
            zzb();
        }
        parcel2.writeNoException();
        return true;
    }
}
