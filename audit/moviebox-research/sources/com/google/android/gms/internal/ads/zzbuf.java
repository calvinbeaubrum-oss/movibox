package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbuf extends zzayh implements zzbug {
    public zzbuf() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final boolean zzbO(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzayi.zzc(parcel);
            zzg(iObjectWrapperAsInterface);
        } else if (i11 == 2) {
            String string = parcel.readString();
            zzayi.zzc(parcel);
            zze(string);
        } else if (i11 == 3) {
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzayi.zzc(parcel);
            zzf(zzeVar);
        } else {
            if (i11 != 4) {
                return false;
            }
            zzbte zzbteVarZzb = zzbtd.zzb(parcel.readStrongBinder());
            zzayi.zzc(parcel);
            zzh(zzbteVarZzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
