package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbxw;
import com.google.android.gms.internal.ads.zzbxy;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcee;
import com.google.android.gms.internal.ads.zzcef;
import com.google.android.gms.internal.ads.zzceg;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzk extends RemoteCreator {
    private zzbxy zza;

    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzbv ? (zzbv) iInterfaceQueryLocalInterface : new zzbv(iBinder);
    }

    @Nullable
    public final zzbu zza(Context context, zzq zzqVar, String str, zzbsv zzbsvVar, int i11) {
        zzbgc.zza(context);
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzki)).booleanValue()) {
            try {
                IBinder iBinderZze = ((zzbv) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzqVar, str, zzbsvVar, 240304000, i11);
                if (iBinderZze == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                return iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(iBinderZze);
            } catch (RemoteException e11) {
                e = e11;
                zzcec.zzf("Could not create remote AdManager.", e);
                return null;
            } catch (RemoteCreator.RemoteCreatorException e12) {
                e = e12;
                zzcec.zzf("Could not create remote AdManager.", e);
                return null;
            }
        }
        try {
            IBinder iBinderZze2 = ((zzbv) zzceg.zzb(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", new zzcee() { // from class: com.google.android.gms.ads.internal.client.zzj
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzcee
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface iInterfaceQueryLocalInterface2 = obj.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return iInterfaceQueryLocalInterface2 instanceof zzbv ? (zzbv) iInterfaceQueryLocalInterface2 : new zzbv(obj);
                }
            })).zze(ObjectWrapper.wrap(context), zzqVar, str, zzbsvVar, 240304000, i11);
            if (iBinderZze2 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface2 = iBinderZze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return iInterfaceQueryLocalInterface2 instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface2 : new zzbs(iBinderZze2);
        } catch (RemoteException e13) {
            e = e13;
            zzbxy zzbxyVarZza = zzbxw.zza(context);
            this.zza = zzbxyVarZza;
            zzbxyVarZza.zzg(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
            zzcec.zzl("#007 Could not call remote method.", e);
            return null;
        } catch (zzcef e14) {
            e = e14;
            zzbxy zzbxyVarZza2 = zzbxw.zza(context);
            this.zza = zzbxyVarZza2;
            zzbxyVarZza2.zzg(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
            zzcec.zzl("#007 Could not call remote method.", e);
            return null;
        } catch (NullPointerException e15) {
            e = e15;
            zzbxy zzbxyVarZza3 = zzbxw.zza(context);
            this.zza = zzbxyVarZza3;
            zzbxyVarZza3.zzg(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
            zzcec.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }
}
