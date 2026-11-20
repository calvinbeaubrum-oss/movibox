package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzbij;
import com.google.android.gms.internal.ads.zzcdv;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzax {

    @Nullable
    private static final zzce zza;

    static {
        zzce zzccVar = null;
        try {
            Object objNewInstance = zzaw.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (objNewInstance instanceof IBinder) {
                IBinder iBinder = (IBinder) objNewInstance;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzccVar = iInterfaceQueryLocalInterface instanceof zzce ? (zzce) iInterfaceQueryLocalInterface : new zzcc(iBinder);
                }
            } else {
                zzcec.zzj("ClientApi class is not an instance of IBinder.");
            }
        } catch (Exception unused) {
            zzcec.zzj("Failed to instantiate ClientApi class.");
        }
        zza = zzccVar;
    }

    @Nullable
    private final Object zze() {
        zzce zzceVar = zza;
        if (zzceVar == null) {
            zzcec.zzj("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zzb(zzceVar);
        } catch (RemoteException e11) {
            zzcec.zzk("Cannot invoke local loader using ClientApi class.", e11);
            return null;
        }
    }

    @Nullable
    private final Object zzf() {
        try {
            return zzc();
        } catch (RemoteException e11) {
            zzcec.zzk("Cannot invoke remote loader.", e11);
            return null;
        }
    }

    @NonNull
    public abstract Object zza();

    @Nullable
    public abstract Object zzb(zzce zzceVar) throws RemoteException;

    @Nullable
    public abstract Object zzc() throws RemoteException;

    public final Object zzd(Context context, boolean z11) {
        boolean z12;
        Object objZze;
        if (!z11) {
            zzay.zzb();
            if (!zzcdv.zzs(context, 12451000)) {
                zzcec.zze("Google Play Services is not available.");
                z11 = true;
            }
        }
        boolean z13 = false;
        boolean z14 = !(DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) <= DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
        zzbgc.zza(context);
        if (((Boolean) zzbhv.zza.zze()).booleanValue()) {
            z12 = false;
        } else if (((Boolean) zzbhv.zzb.zze()).booleanValue()) {
            z12 = true;
            z13 = true;
        } else {
            z13 = z11 | z14;
            z12 = false;
        }
        if (z13) {
            objZze = zze();
            if (objZze == null && !z12) {
                objZze = zzf();
            }
        } else {
            Object objZzf = zzf();
            if (objZzf == null) {
                if (zzay.zze().nextInt(((Long) zzbij.zza.zze()).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzay.zzb().zzn(context, zzay.zzc().zza, "gmob-apps", bundle, true);
                }
            }
            objZze = objZzf == null ? zze() : objZzf;
        }
        return objZze == null ? zza() : objZze;
    }
}
