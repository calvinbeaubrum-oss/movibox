package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbxw;
import com.google.android.gms.internal.ads.zzcee;
import com.google.android.gms.internal.ads.zzcef;
import com.google.android.gms.internal.ads.zzceg;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzac extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbsv zzb;

    public zzac(zzaw zzawVar, Context context, zzbsv zzbsvVar) {
        this.zza = context;
        this.zzb = zzbsvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "out_of_context_tester");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object zzb(zzce zzceVar) throws RemoteException {
        Context context = this.zza;
        IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(context);
        zzbgc.zza(context);
        if (((Boolean) zzba.zzc().zza(zzbgc.zzjm)).booleanValue()) {
            return zzceVar.zzh(iObjectWrapperWrap, this.zzb, 240304000);
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Context context = this.zza;
        IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(context);
        zzbgc.zza(context);
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzjm)).booleanValue()) {
            return null;
        }
        try {
            return ((zzdk) zzceg.zzb(this.zza, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", new zzcee() { // from class: com.google.android.gms.ads.internal.client.zzab
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzcee
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTesterCreator");
                    return iInterfaceQueryLocalInterface instanceof zzdk ? (zzdk) iInterfaceQueryLocalInterface : new zzdk(obj);
                }
            })).zze(iObjectWrapperWrap, this.zzb, 240304000);
        } catch (RemoteException | zzcef | NullPointerException e11) {
            zzbxw.zza(this.zza).zzg(e11, "ClientApiBroker.getOutOfContextTester");
            return null;
        }
    }
}
