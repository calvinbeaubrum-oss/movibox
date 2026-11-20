package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzlt implements zzvb, zzrt {
    final /* synthetic */ zzlx zza;
    private final zzlv zzb;

    public zzlt(zzlx zzlxVar, zzlv zzlvVar) {
        this.zza = zzlxVar;
        this.zzb = zzlvVar;
    }

    @Nullable
    private final Pair zzf(int i11, @Nullable zzur zzurVar) {
        zzur zzurVarZza;
        zzur zzurVar2 = null;
        if (zzurVar != null) {
            zzlv zzlvVar = this.zzb;
            int i12 = 0;
            while (true) {
                if (i12 >= zzlvVar.zzc.size()) {
                    zzurVarZza = null;
                    break;
                }
                if (((zzur) zzlvVar.zzc.get(i12)).zzd == zzurVar.zzd) {
                    zzurVarZza = zzurVar.zza(Pair.create(zzlvVar.zzb, zzurVar.zza));
                    break;
                }
                i12++;
            }
            if (zzurVarZza == null) {
                return null;
            }
            zzurVar2 = zzurVarZza;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzurVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzae(int i11, @Nullable zzur zzurVar, final zzun zzunVar) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlr
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzae(((Integer) pair.first).intValue(), (zzur) pair.second, zzunVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzaf(int i11, @Nullable zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlp
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzaf(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzag(int i11, @Nullable zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzls
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzag(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzah(int i11, @Nullable zzur zzurVar, final zzui zzuiVar, final zzun zzunVar, final IOException iOException, final boolean z11) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlo
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzah(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar, iOException, z11);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzai(int i11, @Nullable zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlq
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzai(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar);
                }
            });
        }
    }
}
