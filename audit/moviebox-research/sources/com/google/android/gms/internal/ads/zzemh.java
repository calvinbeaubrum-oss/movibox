package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzemh {
    private final Clock zza;
    private final zzemj zzb;
    private final zzfny zzc;
    private final LinkedHashMap zzd = new LinkedHashMap();
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgS)).booleanValue();
    private final zzeis zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;

    public zzemh(Clock clock, zzemj zzemjVar, zzeis zzeisVar, zzfny zzfnyVar) {
        this.zza = clock;
        this.zzb = zzemjVar;
        this.zzf = zzeisVar;
        this.zzc = zzfnyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean zzq(zzfgm zzfgmVar) {
        zzemg zzemgVar = (zzemg) this.zzd.get(zzfgmVar);
        if (zzemgVar == null) {
            return false;
        }
        return zzemgVar.zzc == 8;
    }

    public final synchronized long zza() {
        return this.zzh;
    }

    public final synchronized s zzf(zzfgy zzfgyVar, zzfgm zzfgmVar, s sVar, zzfnu zzfnuVar) {
        zzfgp zzfgpVar = zzfgyVar.zzb.zzb;
        long jElapsedRealtime = this.zza.elapsedRealtime();
        String str = zzfgmVar.zzx;
        if (str != null) {
            this.zzd.put(zzfgmVar, new zzemg(str, zzfgmVar.zzag, 9, 0L, null));
            zzgen.zzr(sVar, new zzemf(this, jElapsedRealtime, zzfgpVar, zzfgmVar, str, zzfnuVar, zzfgyVar), zzcep.zzf);
        }
        return sVar;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.zzd.entrySet().iterator();
            while (it.hasNext()) {
                zzemg zzemgVar = (zzemg) ((Map.Entry) it.next()).getValue();
                if (zzemgVar.zzc != Integer.MAX_VALUE) {
                    arrayList.add(zzemgVar.toString());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized void zzi(@Nullable zzfgm zzfgmVar) {
        try {
            this.zzh = this.zza.elapsedRealtime() - this.zzi;
            if (zzfgmVar != null) {
                this.zzf.zze(zzfgmVar);
            }
            this.zzg = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzj() {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzk(List list) {
        this.zzi = this.zza.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfgm zzfgmVar = (zzfgm) it.next();
            if (!TextUtils.isEmpty(zzfgmVar.zzx)) {
                this.zzd.put(zzfgmVar, new zzemg(zzfgmVar.zzx, zzfgmVar.zzag, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0L, null));
            }
        }
    }

    public final synchronized void zzl() {
        this.zzi = this.zza.elapsedRealtime();
    }

    public final synchronized void zzm(zzfgm zzfgmVar) {
        zzemg zzemgVar = (zzemg) this.zzd.get(zzfgmVar);
        if (zzemgVar == null || this.zzg) {
            return;
        }
        zzemgVar.zzc = 8;
    }
}
