package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcaz {
    @Nullable
    public static final zzcan zza(Context context, String str, zzbsv zzbsvVar) {
        try {
            IBinder iBinderZze = ((zzcar) zzceg.zzb(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", new zzcee() { // from class: com.google.android.gms.internal.ads.zzcay
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzcee
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
                    return iInterfaceQueryLocalInterface instanceof zzcar ? (zzcar) iInterfaceQueryLocalInterface : new zzcar(obj);
                }
            })).zze(ObjectWrapper.wrap(context), str, zzbsvVar, 240304000);
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return iInterfaceQueryLocalInterface instanceof zzcan ? (zzcan) iInterfaceQueryLocalInterface : new zzcal(iBinderZze);
        } catch (RemoteException e11) {
            e = e11;
            zzcec.zzl("#007 Could not call remote method.", e);
            return null;
        } catch (zzcef e12) {
            e = e12;
            zzcec.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }
}
