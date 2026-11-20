package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvh extends zzua {
    private static final zzbp zza;
    private final zzut[] zzb;
    private final zzcx[] zzc;
    private final ArrayList zzd;
    private final Map zze;
    private final zzgaw zzf;
    private int zzg;
    private long[][] zzh;

    @Nullable
    private zzvg zzi;
    private final zzuc zzj;

    static {
        zzar zzarVar = new zzar();
        zzarVar.zza("MergingMediaSource");
        zza = zzarVar.zzc();
    }

    public zzvh(boolean z11, boolean z12, zzut... zzutVarArr) {
        zzuc zzucVar = new zzuc();
        this.zzb = zzutVarArr;
        this.zzj = zzucVar;
        this.zzd = new ArrayList(Arrays.asList(zzutVarArr));
        this.zzg = -1;
        this.zzc = new zzcx[zzutVarArr.length];
        this.zzh = new long[0][];
        this.zze = new HashMap();
        this.zzf = zzgbe.zzb(8).zzb(2).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzua
    public final /* bridge */ /* synthetic */ void zzA(Object obj, zzut zzutVar, zzcx zzcxVar) {
        int iZzb;
        if (this.zzi != null) {
            return;
        }
        if (this.zzg == -1) {
            iZzb = zzcxVar.zzb();
            this.zzg = iZzb;
        } else {
            int iZzb2 = zzcxVar.zzb();
            int i11 = this.zzg;
            if (iZzb2 != i11) {
                this.zzi = new zzvg(0);
                return;
            }
            iZzb = i11;
        }
        if (this.zzh.length == 0) {
            this.zzh = (long[][]) Array.newInstance((Class<?>) Long.TYPE, iZzb, this.zzc.length);
        }
        this.zzd.remove(zzutVar);
        this.zzc[((Integer) obj).intValue()] = zzcxVar;
        if (this.zzd.isEmpty()) {
            zzo(this.zzc[0]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void zzG(zzup zzupVar) {
        zzvf zzvfVar = (zzvf) zzupVar;
        int i11 = 0;
        while (true) {
            zzut[] zzutVarArr = this.zzb;
            if (i11 >= zzutVarArr.length) {
                return;
            }
            zzutVarArr[i11].zzG(zzvfVar.zzn(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final zzup zzI(zzur zzurVar, zzyx zzyxVar, long j11) {
        zzcx[] zzcxVarArr = this.zzc;
        int length = this.zzb.length;
        zzup[] zzupVarArr = new zzup[length];
        int iZza = zzcxVarArr[0].zza(zzurVar.zza);
        for (int i11 = 0; i11 < length; i11++) {
            zzupVarArr[i11] = this.zzb[i11].zzI(zzurVar.zza(this.zzc[i11].zzf(iZza)), zzyxVar, j11 - this.zzh[iZza][i11]);
        }
        return new zzvf(this.zzj, this.zzh[iZza], zzupVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final zzbp zzJ() {
        zzut[] zzutVarArr = this.zzb;
        return zzutVarArr.length > 0 ? zzutVarArr[0].zzJ() : zza;
    }

    @Override // com.google.android.gms.internal.ads.zzua, com.google.android.gms.internal.ads.zzts
    public final void zzn(@Nullable zzhy zzhyVar) {
        super.zzn(zzhyVar);
        int i11 = 0;
        while (true) {
            zzut[] zzutVarArr = this.zzb;
            if (i11 >= zzutVarArr.length) {
                return;
            }
            zzB(Integer.valueOf(i11), zzutVarArr[i11]);
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzua, com.google.android.gms.internal.ads.zzts
    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzc, (Object) null);
        this.zzg = -1;
        this.zzi = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzts, com.google.android.gms.internal.ads.zzut
    public final void zzt(zzbp zzbpVar) {
        this.zzb[0].zzt(zzbpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzua
    @Nullable
    public final /* bridge */ /* synthetic */ zzur zzy(Object obj, zzur zzurVar) {
        if (((Integer) obj).intValue() == 0) {
            return zzurVar;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzua, com.google.android.gms.internal.ads.zzut
    public final void zzz() throws IOException {
        zzvg zzvgVar = this.zzi;
        if (zzvgVar != null) {
            throw zzvgVar;
        }
        super.zzz();
    }
}
