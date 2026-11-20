package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbm extends zzayh implements zzbn {
    public zzbm() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final boolean zzbO(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzl zzlVar = (zzl) zzayi.zza(parcel, zzl.CREATOR);
            zzayi.zzc(parcel);
            zzg(zzlVar);
            parcel2.writeNoException();
        } else if (i11 == 2) {
            String strZze = zze();
            parcel2.writeNoException();
            parcel2.writeString(strZze);
        } else if (i11 == 3) {
            boolean zZzi = zzi();
            parcel2.writeNoException();
            int i13 = zzayi.zza;
            parcel2.writeInt(zZzi ? 1 : 0);
        } else if (i11 == 4) {
            String strZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(strZzf);
        } else {
            if (i11 != 5) {
                return false;
            }
            zzl zzlVar2 = (zzl) zzayi.zza(parcel, zzl.CREATOR);
            int i14 = parcel.readInt();
            zzayi.zzc(parcel);
            zzh(zzlVar2, i14);
            parcel2.writeNoException();
        }
        return true;
    }
}
