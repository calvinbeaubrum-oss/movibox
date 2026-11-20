package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbpc implements zzapt {
    private volatile zzbop zza;
    private final Context zzb;

    public zzbpc(Context context) {
        this.zzb = context;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzbpc zzbpcVar) {
        if (zzbpcVar.zza == null) {
            return;
        }
        zzbpcVar.zza.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzapt
    @Nullable
    public final zzapw zza(zzaqa zzaqaVar) throws zzaqj {
        Parcelable.Creator<zzboq> creator = zzboq.CREATOR;
        Map mapZzl = zzaqaVar.zzl();
        int size = mapZzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i11 = 0;
        int i12 = 0;
        for (Map.Entry entry : mapZzl.entrySet()) {
            strArr[i12] = (String) entry.getKey();
            strArr2[i12] = (String) entry.getValue();
            i12++;
        }
        zzboq zzboqVar = new zzboq(zzaqaVar.zzk(), strArr, strArr2);
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        try {
            zzceu zzceuVar = new zzceu();
            this.zza = new zzbop(this.zzb, com.google.android.gms.ads.internal.zzt.zzt().zzb(), new zzbpa(this, zzceuVar), new zzbpb(this, zzceuVar));
            this.zza.checkAvailabilityAndConnect();
            zzboy zzboyVar = new zzboy(this, zzboqVar);
            zzgey zzgeyVar = zzcep.zza;
            s sVarZzo = zzgen.zzo(zzgen.zzn(zzceuVar, zzboyVar, zzgeyVar), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzet)).intValue(), TimeUnit.MILLISECONDS, zzcep.zzd);
            sVarZzo.addListener(new zzboz(this), zzgeyVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) sVarZzo.get();
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime) + "ms");
            zzbos zzbosVar = (zzbos) new zzbzc(parcelFileDescriptor).zza(zzbos.CREATOR);
            if (zzbosVar == null) {
                return null;
            }
            if (zzbosVar.zza) {
                throw new zzaqj(zzbosVar.zzb);
            }
            if (zzbosVar.zze.length != zzbosVar.zzf.length) {
                return null;
            }
            HashMap map = new HashMap();
            while (true) {
                String[] strArr3 = zzbosVar.zze;
                if (i11 >= strArr3.length) {
                    return new zzapw(zzbosVar.zzc, zzbosVar.zzd, map, zzbosVar.zzg, zzbosVar.zzh);
                }
                map.put(strArr3[i11], zzbosVar.zzf[i11]);
                i11++;
            }
        } catch (InterruptedException | ExecutionException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime) + "ms");
            return null;
        } catch (Throwable th2) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime) + "ms");
            throw th2;
        }
    }
}
