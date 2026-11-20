package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbpr extends zzayh implements zzbps {
    public zzbpr() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final boolean zzbO(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        zzbpv zzbptVar;
        if (i11 == 3) {
            com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = zzb();
            parcel2.writeNoException();
            zzayi.zzf(parcel2, zzdqVarZzb);
            return true;
        }
        if (i11 == 4) {
            zzd();
            parcel2.writeNoException();
            return true;
        }
        if (i11 == 5) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbptVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                zzbptVar = iInterfaceQueryLocalInterface instanceof zzbpv ? (zzbpv) iInterfaceQueryLocalInterface : new zzbpt(strongBinder);
            }
            zzayi.zzc(parcel);
            zzf(iObjectWrapperAsInterface, zzbptVar);
            parcel2.writeNoException();
            return true;
        }
        if (i11 == 6) {
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzayi.zzc(parcel);
            zze(iObjectWrapperAsInterface2);
            parcel2.writeNoException();
            return true;
        }
        if (i11 != 7) {
            return false;
        }
        zzbjj zzbjjVarZzc = zzc();
        parcel2.writeNoException();
        zzayi.zzf(parcel2, zzbjjVarZzc);
        return true;
    }
}
