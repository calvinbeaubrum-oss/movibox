package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzds extends zzayh implements zzdt {
    public zzds() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final boolean zzbO(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            zzi();
        } else if (i11 == 2) {
            zzh();
        } else if (i11 == 3) {
            zzg();
        } else if (i11 == 4) {
            zze();
        } else {
            if (i11 != 5) {
                return false;
            }
            boolean zZzg = zzayi.zzg(parcel);
            zzayi.zzc(parcel);
            zzf(zZzg);
        }
        parcel2.writeNoException();
        return true;
    }
}
