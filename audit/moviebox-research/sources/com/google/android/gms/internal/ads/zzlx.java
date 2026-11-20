package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzlx {
    private final zzpb zza;
    private final zzlw zze;
    private final zzmp zzh;
    private final zzew zzi;
    private boolean zzj;

    @Nullable
    private zzhy zzk;
    private zzwk zzl = new zzwk(0);
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final List zzb = new ArrayList();
    private final HashMap zzf = new HashMap();
    private final Set zzg = new HashSet();

    public zzlx(zzlw zzlwVar, zzmp zzmpVar, zzew zzewVar, zzpb zzpbVar) {
        this.zza = zzpbVar;
        this.zze = zzlwVar;
        this.zzh = zzmpVar;
        this.zzi = zzewVar;
    }

    private final void zzr(int i11, int i12) {
        while (i11 < this.zzb.size()) {
            ((zzlv) this.zzb.get(i11)).zzd += i12;
            i11++;
        }
    }

    private final void zzs(zzlv zzlvVar) {
        zzlu zzluVar = (zzlu) this.zzf.get(zzlvVar);
        if (zzluVar != null) {
            zzluVar.zza.zzi(zzluVar.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzlv zzlvVar = (zzlv) it.next();
            if (zzlvVar.zzc.isEmpty()) {
                zzs(zzlvVar);
                it.remove();
            }
        }
    }

    private final void zzu(zzlv zzlvVar) {
        if (zzlvVar.zze && zzlvVar.zzc.isEmpty()) {
            zzlu zzluVar = (zzlu) this.zzf.remove(zzlvVar);
            zzluVar.getClass();
            zzluVar.zza.zzp(zzluVar.zzb);
            zzluVar.zza.zzs(zzluVar.zzc);
            zzluVar.zza.zzr(zzluVar.zzc);
            this.zzg.remove(zzlvVar);
        }
    }

    private final void zzv(zzlv zzlvVar) {
        zzum zzumVar = zzlvVar.zza;
        zzus zzusVar = new zzus() { // from class: com.google.android.gms.internal.ads.zzln
            @Override // com.google.android.gms.internal.ads.zzus
            public final void zza(zzut zzutVar, zzcx zzcxVar) {
                this.zza.zzf(zzutVar, zzcxVar);
            }
        };
        zzlt zzltVar = new zzlt(this, zzlvVar);
        this.zzf.put(zzlvVar, new zzlu(zzumVar, zzusVar, zzltVar));
        zzumVar.zzh(new Handler(zzfy.zzx(), null), zzltVar);
        zzumVar.zzg(new Handler(zzfy.zzx(), null), zzltVar);
        zzumVar.zzm(zzusVar, this.zzk, this.zza);
    }

    private final void zzw(int i11, int i12) {
        while (true) {
            i12--;
            if (i12 < i11) {
                return;
            }
            zzlv zzlvVar = (zzlv) this.zzb.remove(i12);
            this.zzd.remove(zzlvVar.zzb);
            zzr(i12, -zzlvVar.zza.zzC().zzc());
            zzlvVar.zze = true;
            if (this.zzj) {
                zzu(zzlvVar);
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzcx zzb() {
        if (this.zzb.isEmpty()) {
            return zzcx.zza;
        }
        int iZzc = 0;
        for (int i11 = 0; i11 < this.zzb.size(); i11++) {
            zzlv zzlvVar = (zzlv) this.zzb.get(i11);
            zzlvVar.zzd = iZzc;
            iZzc += zzlvVar.zza.zzC().zzc();
        }
        return new zzmd(this.zzb, this.zzl);
    }

    public final zzcx zzc(int i11, int i12, List list) {
        zzek.zzd(i11 >= 0 && i11 <= i12 && i12 <= zza());
        zzek.zzd(list.size() == i12 - i11);
        for (int i13 = i11; i13 < i12; i13++) {
            ((zzlv) this.zzb.get(i13)).zza.zzt((zzbp) list.get(i13 - i11));
        }
        return zzb();
    }

    public final /* synthetic */ void zzf(zzut zzutVar, zzcx zzcxVar) {
        this.zze.zzh();
    }

    public final void zzg(@Nullable zzhy zzhyVar) {
        zzek.zzf(!this.zzj);
        this.zzk = zzhyVar;
        for (int i11 = 0; i11 < this.zzb.size(); i11++) {
            zzlv zzlvVar = (zzlv) this.zzb.get(i11);
            zzv(zzlvVar);
            this.zzg.add(zzlvVar);
        }
        this.zzj = true;
    }

    public final void zzh() {
        for (zzlu zzluVar : this.zzf.values()) {
            try {
                zzluVar.zza.zzp(zzluVar.zzb);
            } catch (RuntimeException e11) {
                zzff.zzd("MediaSourceList", "Failed to release child source.", e11);
            }
            zzluVar.zza.zzs(zzluVar.zzc);
            zzluVar.zza.zzr(zzluVar.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzup zzupVar) {
        zzlv zzlvVar = (zzlv) this.zzc.remove(zzupVar);
        zzlvVar.getClass();
        zzlvVar.zza.zzG(zzupVar);
        zzlvVar.zzc.remove(((zzuj) zzupVar).zza);
        if (!this.zzc.isEmpty()) {
            zzt();
        }
        zzu(zzlvVar);
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzcx zzk(int i11, List list, zzwk zzwkVar) {
        if (!list.isEmpty()) {
            this.zzl = zzwkVar;
            for (int i12 = i11; i12 < list.size() + i11; i12++) {
                zzlv zzlvVar = (zzlv) list.get(i12 - i11);
                if (i12 > 0) {
                    zzlv zzlvVar2 = (zzlv) this.zzb.get(i12 - 1);
                    zzlvVar.zzc(zzlvVar2.zzd + zzlvVar2.zza.zzC().zzc());
                } else {
                    zzlvVar.zzc(0);
                }
                zzr(i12, zzlvVar.zza.zzC().zzc());
                this.zzb.add(i12, zzlvVar);
                this.zzd.put(zzlvVar.zzb, zzlvVar);
                if (this.zzj) {
                    zzv(zzlvVar);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzlvVar);
                    } else {
                        zzs(zzlvVar);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcx zzl(int i11, int i12, int i13, zzwk zzwkVar) {
        zzek.zzd(zza() >= 0);
        this.zzl = null;
        return zzb();
    }

    public final zzcx zzm(int i11, int i12, zzwk zzwkVar) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= i12 && i12 <= zza()) {
            z11 = true;
        }
        zzek.zzd(z11);
        this.zzl = zzwkVar;
        zzw(i11, i12);
        return zzb();
    }

    public final zzcx zzn(List list, zzwk zzwkVar) {
        zzw(0, this.zzb.size());
        return zzk(this.zzb.size(), list, zzwkVar);
    }

    public final zzcx zzo(zzwk zzwkVar) {
        int iZza = zza();
        if (zzwkVar.zzc() != iZza) {
            zzwkVar = zzwkVar.zzf().zzg(0, iZza);
        }
        this.zzl = zzwkVar;
        return zzb();
    }

    public final zzup zzp(zzur zzurVar, zzyx zzyxVar, long j11) {
        int i11 = zzmd.zzc;
        Object obj = zzurVar.zza;
        Object obj2 = ((Pair) obj).first;
        zzur zzurVarZza = zzurVar.zza(((Pair) obj).second);
        zzlv zzlvVar = (zzlv) this.zzd.get(obj2);
        zzlvVar.getClass();
        this.zzg.add(zzlvVar);
        zzlu zzluVar = (zzlu) this.zzf.get(zzlvVar);
        if (zzluVar != null) {
            zzluVar.zza.zzk(zzluVar.zzb);
        }
        zzlvVar.zzc.add(zzurVarZza);
        zzuj zzujVarZzH = zzlvVar.zza.zzI(zzurVarZza, zzyxVar, j11);
        this.zzc.put(zzujVarZzH, zzlvVar);
        zzt();
        return zzujVarZzH;
    }

    public final zzwk zzq() {
        return this.zzl;
    }
}
