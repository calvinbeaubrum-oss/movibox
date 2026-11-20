package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.a;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzd extends zze {
    private final Map zza;
    private final Map zzb;
    private long zzc;

    public zzd(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzb = new a();
        this.zza = new a();
    }

    public static /* synthetic */ void zza(zzd zzdVar, String str, long j11) {
        zzdVar.zzg();
        Preconditions.checkNotEmpty(str);
        if (zzdVar.zzb.isEmpty()) {
            zzdVar.zzc = j11;
        }
        Integer num = (Integer) zzdVar.zzb.get(str);
        if (num != null) {
            zzdVar.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzdVar.zzb.size() >= 100) {
            zzdVar.zzt.zzay().zzk().zza("Too many ads visible");
        } else {
            zzdVar.zzb.put(str, 1);
            zzdVar.zza.put(str, Long.valueOf(j11));
        }
    }

    public static /* synthetic */ void zzb(zzd zzdVar, String str, long j11) {
        zzdVar.zzg();
        Preconditions.checkNotEmpty(str);
        Integer num = (Integer) zzdVar.zzb.get(str);
        if (num == null) {
            zzdVar.zzt.zzay().zzd().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        zzie zzieVarZzj = zzdVar.zzt.zzs().zzj(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            zzdVar.zzb.put(str, Integer.valueOf(iIntValue));
            return;
        }
        zzdVar.zzb.remove(str);
        Long l11 = (Long) zzdVar.zza.get(str);
        if (l11 == null) {
            zzdVar.zzt.zzay().zzd().zza("First ad unit exposure time was never set");
        } else {
            long jLongValue = l11.longValue();
            zzdVar.zza.remove(str);
            zzdVar.zzi(str, j11 - jLongValue, zzieVarZzj);
        }
        if (zzdVar.zzb.isEmpty()) {
            long j12 = zzdVar.zzc;
            if (j12 == 0) {
                zzdVar.zzt.zzay().zzd().zza("First ad exposure time was never set");
            } else {
                zzdVar.zzh(j11 - j12, zzieVarZzj);
                zzdVar.zzc = 0L;
            }
        }
    }

    private final void zzh(long j11, zzie zzieVar) {
        if (zzieVar == null) {
            this.zzt.zzay().zzj().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j11 < 1000) {
            this.zzt.zzay().zzj().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j11));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j11);
        zzlb.zzK(zzieVar, bundle, true);
        this.zzt.zzq().zzG("am", "_xa", bundle);
    }

    private final void zzi(String str, long j11, zzie zzieVar) {
        if (zzieVar == null) {
            this.zzt.zzay().zzj().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j11 < 1000) {
            this.zzt.zzay().zzj().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j11));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j11);
        zzlb.zzK(zzieVar, bundle, true);
        this.zzt.zzq().zzG("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(long j11) {
        Iterator it = this.zza.keySet().iterator();
        while (it.hasNext()) {
            this.zza.put((String) it.next(), Long.valueOf(j11));
        }
        if (this.zza.isEmpty()) {
            return;
        }
        this.zzc = j11;
    }

    public final void zzd(String str, long j11) {
        if (str == null || str.length() == 0) {
            this.zzt.zzay().zzd().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzt.zzaz().zzp(new zza(this, str, j11));
        }
    }

    public final void zze(String str, long j11) {
        if (str == null || str.length() == 0) {
            this.zzt.zzay().zzd().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzt.zzaz().zzp(new zzb(this, str, j11));
        }
    }

    public final void zzf(long j11) {
        zzie zzieVarZzj = this.zzt.zzs().zzj(false);
        for (String str : this.zza.keySet()) {
            zzi(str, j11 - ((Long) this.zza.get(str)).longValue(), zzieVarZzj);
        }
        if (!this.zza.isEmpty()) {
            zzh(j11 - this.zzc, zzieVarZzj);
        }
        zzj(j11);
    }
}
