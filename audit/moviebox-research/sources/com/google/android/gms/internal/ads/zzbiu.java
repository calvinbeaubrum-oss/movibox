package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbiu {
    private final Context zza;

    public zzbiu(Context context) {
        this.zza = context;
    }

    public final void zza(zzbyd zzbydVar) {
        try {
            ((zzbiv) zzceg.zzb(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", new zzcee() { // from class: com.google.android.gms.internal.ads.zzbit
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzcee
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
                    return iInterfaceQueryLocalInterface instanceof zzbiv ? (zzbiv) iInterfaceQueryLocalInterface : new zzbiv(obj);
                }
            })).zze(zzbydVar);
        } catch (RemoteException e11) {
            zzcec.zzj("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(e11.getMessage())));
        } catch (zzcef e12) {
            zzcec.zzj("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e12.getMessage())));
        }
    }
}
