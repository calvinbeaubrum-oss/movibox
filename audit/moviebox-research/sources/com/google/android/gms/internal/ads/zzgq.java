package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgq implements zzgw {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;

    @Nullable
    private zzhb zzd;

    public zzgq(boolean z11) {
        this.zza = z11;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzf(zzhy zzhyVar) {
        zzhyVar.getClass();
        if (this.zzb.contains(zzhyVar)) {
            return;
        }
        this.zzb.add(zzhyVar);
        this.zzc++;
    }

    public final void zzg(int i11) {
        zzhb zzhbVar = this.zzd;
        int i12 = zzfy.zza;
        for (int i13 = 0; i13 < this.zzc; i13++) {
            ((zzhy) this.zzb.get(i13)).zza(this, zzhbVar, this.zza, i11);
        }
    }

    public final void zzh() {
        zzhb zzhbVar = this.zzd;
        int i11 = zzfy.zza;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            ((zzhy) this.zzb.get(i12)).zzb(this, zzhbVar, this.zza);
        }
        this.zzd = null;
    }

    public final void zzi(zzhb zzhbVar) {
        for (int i11 = 0; i11 < this.zzc; i11++) {
            ((zzhy) this.zzb.get(i11)).zzc(this, zzhbVar, this.zza);
        }
    }

    public final void zzj(zzhb zzhbVar) {
        this.zzd = zzhbVar;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            ((zzhy) this.zzb.get(i11)).zzd(this, zzhbVar, this.zza);
        }
    }
}
