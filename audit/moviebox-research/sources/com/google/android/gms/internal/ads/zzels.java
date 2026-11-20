package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzels {
    private final zzgfg zzc;
    private zzemi zzf;
    private final String zzh;
    private final int zzi;
    private final zzemh zzj;
    private zzfgm zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public zzels(zzfgy zzfgyVar, zzemh zzemhVar, zzgfg zzgfgVar) {
        this.zzi = zzfgyVar.zzb.zzb.zzp;
        this.zzj = zzemhVar;
        this.zzc = zzgfgVar;
        this.zzh = zzemo.zzc(zzfgyVar);
        List list = zzfgyVar.zzb.zza;
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zza.put((zzfgm) list.get(i11), Integer.valueOf(i11));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zzf() {
        this.zzj.zzi(this.zzk);
        zzemi zzemiVar = this.zzf;
        if (zzemiVar != null) {
            this.zzc.zzc(zzemiVar);
        } else {
            this.zzc.zzd(new zzeml(3, this.zzh));
        }
    }

    private final synchronized boolean zzg(boolean z11) {
        try {
            for (zzfgm zzfgmVar : this.zzb) {
                Integer num = (Integer) this.zza.get(zzfgmVar);
                Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER);
                if (z11 || !this.zze.contains(zzfgmVar.zzat)) {
                    if (numValueOf.intValue() < this.zzg) {
                        return true;
                    }
                    if (numValueOf.intValue() > this.zzg) {
                        break;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private final synchronized boolean zzh() {
        try {
            Iterator it = this.zzd.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) this.zza.get((zzfgm) it.next());
                if (Integer.valueOf(num != null ? num.intValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER).intValue() < this.zzg) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private final synchronized boolean zzi() {
        return zzg(true) || zzh();
    }

    public final synchronized zzfgm zza() {
        for (int i11 = 0; i11 < this.zzb.size(); i11++) {
            try {
                zzfgm zzfgmVar = (zzfgm) this.zzb.get(i11);
                String str = zzfgmVar.zzat;
                if (!this.zze.contains(str)) {
                    if (!TextUtils.isEmpty(str)) {
                        this.zze.add(str);
                    }
                    this.zzd.add(zzfgmVar);
                    return (zzfgm) this.zzb.remove(i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return null;
    }

    public final synchronized void zzb(Throwable th2, zzfgm zzfgmVar) {
        this.zzd.remove(zzfgmVar);
        this.zze.remove(zzfgmVar.zzat);
        if (zzd() || zzi()) {
            return;
        }
        zzf();
    }

    public final synchronized void zzc(zzemi zzemiVar, zzfgm zzfgmVar) {
        this.zzd.remove(zzfgmVar);
        if (zzd()) {
            zzemiVar.zzq();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfgmVar);
        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (numValueOf.intValue() > this.zzg) {
            this.zzj.zzm(zzfgmVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = numValueOf.intValue();
        this.zzf = zzemiVar;
        this.zzk = zzfgmVar;
        if (zzi()) {
            return;
        }
        zzf();
    }

    public final synchronized boolean zzd() {
        return this.zzc.isDone();
    }

    public final synchronized boolean zze() {
        if (!zzd()) {
            List list = this.zzd;
            if (list.size() < this.zzi && zzg(false)) {
                return true;
            }
        }
        return false;
    }
}
