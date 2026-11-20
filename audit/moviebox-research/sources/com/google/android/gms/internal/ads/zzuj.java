package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzuj implements zzup, zzuo {
    public final zzur zza;
    private final long zzb;
    private zzut zzc;
    private zzup zzd;

    @Nullable
    private zzuo zze;
    private long zzf = C.TIME_UNSET;
    private final zzyx zzg;

    public zzuj(zzur zzurVar, zzyx zzyxVar, long j11) {
        this.zza = zzurVar;
        this.zzg = zzyxVar;
        this.zzb = j11;
    }

    private final long zzv(long j11) {
        long j12 = this.zzf;
        return j12 != C.TIME_UNSET ? j12 : j11;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zza(long j11, zzmj zzmjVar) {
        zzup zzupVar = this.zzd;
        int i11 = zzfy.zza;
        return zzupVar.zza(j11, zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        zzup zzupVar = this.zzd;
        int i11 = zzfy.zza;
        return zzupVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        zzup zzupVar = this.zzd;
        int i11 = zzfy.zza;
        return zzupVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzd() {
        zzup zzupVar = this.zzd;
        int i11 = zzfy.zza;
        return zzupVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zze(long j11) {
        zzup zzupVar = this.zzd;
        int i11 = zzfy.zza;
        return zzupVar.zze(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzf(zzyi[] zzyiVarArr, boolean[] zArr, zzwh[] zzwhVarArr, boolean[] zArr2, long j11) {
        long j12 = this.zzf;
        long j13 = (j12 == C.TIME_UNSET || j11 != this.zzb) ? j11 : j12;
        this.zzf = C.TIME_UNSET;
        zzup zzupVar = this.zzd;
        int i11 = zzfy.zza;
        return zzupVar.zzf(zzyiVarArr, zArr, zzwhVarArr, zArr2, j13);
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final /* bridge */ /* synthetic */ void zzg(zzwj zzwjVar) {
        zzuo zzuoVar = this.zze;
        int i11 = zzfy.zza;
        zzuoVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final zzws zzh() {
        zzup zzupVar = this.zzd;
        int i11 = zzfy.zza;
        return zzupVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzuo
    public final void zzi(zzup zzupVar) {
        zzuo zzuoVar = this.zze;
        int i11 = zzfy.zza;
        zzuoVar.zzi(this);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzj(long j11, boolean z11) {
        zzup zzupVar = this.zzd;
        int i11 = zzfy.zza;
        zzupVar.zzj(j11, false);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzk() throws IOException {
        zzup zzupVar = this.zzd;
        if (zzupVar != null) {
            zzupVar.zzk();
            return;
        }
        zzut zzutVar = this.zzc;
        if (zzutVar != null) {
            zzutVar.zzz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzl(zzuo zzuoVar, long j11) {
        this.zze = zzuoVar;
        zzup zzupVar = this.zzd;
        if (zzupVar != null) {
            zzupVar.zzl(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j11) {
        zzup zzupVar = this.zzd;
        int i11 = zzfy.zza;
        zzupVar.zzm(j11);
    }

    public final long zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        zzup zzupVar = this.zzd;
        return zzupVar != null && zzupVar.zzo(zzlgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        zzup zzupVar = this.zzd;
        return zzupVar != null && zzupVar.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzur zzurVar) {
        long jZzv = zzv(this.zzb);
        zzut zzutVar = this.zzc;
        zzutVar.getClass();
        zzup zzupVarZzI = zzutVar.zzI(zzurVar, this.zzg, jZzv);
        this.zzd = zzupVarZzI;
        if (this.zze != null) {
            zzupVarZzI.zzl(this, jZzv);
        }
    }

    public final void zzs(long j11) {
        this.zzf = j11;
    }

    public final void zzt() {
        zzup zzupVar = this.zzd;
        if (zzupVar != null) {
            zzut zzutVar = this.zzc;
            zzutVar.getClass();
            zzutVar.zzG(zzupVar);
        }
    }

    public final void zzu(zzut zzutVar) {
        zzek.zzf(this.zzc == null);
        this.zzc = zzutVar;
    }
}
