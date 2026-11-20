package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zziq implements zzmf, zzmh {
    private final int zzb;

    @Nullable
    private zzmi zzd;
    private int zze;
    private zzpb zzf;
    private zzel zzg;
    private int zzh;

    @Nullable
    private zzwh zzi;

    @Nullable
    private zzam[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;

    @Nullable
    private zzmg zzq;
    private final Object zza = new Object();
    private final zzlb zzc = new zzlb();
    private long zzm = Long.MIN_VALUE;
    private zzcx zzp = zzcx.zza;

    public zziq(int i11) {
        this.zzb = i11;
    }

    private final void zzY(long j11, boolean z11) throws zziz {
        this.zzn = false;
        this.zzl = j11;
        this.zzm = j11;
        zzz(j11, z11);
    }

    public void zzA() {
    }

    public void zzB() {
    }

    public void zzC() throws zziz {
    }

    public void zzD() {
    }

    public void zzE(zzam[] zzamVarArr, long j11, long j12, zzur zzurVar) throws zziz {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzF() {
        zzek.zzf(this.zzh == 0);
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzG(zzam[] zzamVarArr, zzwh zzwhVar, long j11, long j12, zzur zzurVar) throws zziz {
        zzek.zzf(!this.zzn);
        this.zzi = zzwhVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j11;
        }
        this.zzj = zzamVarArr;
        this.zzk = j12;
        zzE(zzamVarArr, j11, j12, zzurVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzH() {
        zzek.zzf(this.zzh == 0);
        zzlb zzlbVar = this.zzc;
        zzlbVar.zzb = null;
        zzlbVar.zza = null;
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzI(long j11) throws zziz {
        zzY(j11, false);
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzJ() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public final void zzK(zzmg zzmgVar) {
        synchronized (this.zza) {
            this.zzq = zzmgVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public /* synthetic */ void zzL(float f11, float f12) {
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzM(zzcx zzcxVar) {
        if (zzfy.zzF(this.zzp, zzcxVar)) {
            return;
        }
        this.zzp = zzcxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzN() throws zziz {
        zzek.zzf(this.zzh == 1);
        this.zzh = 2;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzO() {
        zzek.zzf(this.zzh == 2);
        this.zzh = 1;
        zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final boolean zzP() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final boolean zzQ() {
        return this.zzn;
    }

    public final boolean zzR() {
        if (zzP()) {
            return this.zzn;
        }
        zzwh zzwhVar = this.zzi;
        zzwhVar.getClass();
        return zzwhVar.zze();
    }

    public final zzam[] zzS() {
        zzam[] zzamVarArr = this.zzj;
        zzamVarArr.getClass();
        return zzamVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final int zzbf() {
        return this.zzh;
    }

    public final int zzbg(zzlb zzlbVar, zzih zzihVar, int i11) {
        zzwh zzwhVar = this.zzi;
        zzwhVar.getClass();
        int iZza = zzwhVar.zza(zzlbVar, zzihVar, i11);
        if (iZza == -4) {
            if (zzihVar.zzf()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j11 = zzihVar.zze + this.zzk;
            zzihVar.zze = j11;
            this.zzm = Math.max(this.zzm, j11);
        } else if (iZza == -5) {
            zzam zzamVar = zzlbVar.zza;
            zzamVar.getClass();
            long j12 = zzamVar.zzq;
            if (j12 != Long.MAX_VALUE) {
                zzak zzakVarZzb = zzamVar.zzb();
                zzakVarZzb.zzaa(j12 + this.zzk);
                zzlbVar.zza = zzakVarZzb.zzac();
                return -5;
            }
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final long zzbh() {
        return this.zzm;
    }

    public final zzlb zzbi() {
        zzlb zzlbVar = this.zzc;
        zzlbVar.zzb = null;
        zzlbVar.zza = null;
        return zzlbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmf, com.google.android.gms.internal.ads.zzmh
    public final int zzbj() {
        return this.zzb;
    }

    public final int zzd(long j11) {
        zzwh zzwhVar = this.zzi;
        zzwhVar.getClass();
        return zzwhVar.zzb(j11 - this.zzk);
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public int zze() throws zziz {
        return 0;
    }

    public final long zzf() {
        return this.zzl;
    }

    public final zzel zzh() {
        zzel zzelVar = this.zzg;
        zzelVar.getClass();
        return zzelVar;
    }

    public final zziz zzi(Throwable th2, @Nullable zzam zzamVar, boolean z11, int i11) {
        int i12;
        if (zzamVar == null || this.zzo) {
            i12 = 4;
        } else {
            this.zzo = true;
            try {
                int iZzX = zzX(zzamVar) & 7;
                this.zzo = false;
                i12 = iZzX;
            } catch (zziz unused) {
                this.zzo = false;
                i12 = 4;
            } catch (Throwable th3) {
                this.zzo = false;
                throw th3;
            }
        }
        return zziz.zzb(th2, zzT(), this.zze, zzamVar, i12, z11, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    @Nullable
    public zzlh zzk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final zzmh zzl() {
        return this;
    }

    public final zzmi zzm() {
        zzmi zzmiVar = this.zzd;
        zzmiVar.getClass();
        return zzmiVar;
    }

    public final zzpb zzn() {
        zzpb zzpbVar = this.zzf;
        zzpbVar.getClass();
        return zzpbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    @Nullable
    public final zzwh zzo() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public final void zzp() {
        synchronized (this.zza) {
            this.zzq = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzq() {
        zzek.zzf(this.zzh == 1);
        zzlb zzlbVar = this.zzc;
        zzlbVar.zzb = null;
        zzlbVar.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzr(zzmi zzmiVar, zzam[] zzamVarArr, zzwh zzwhVar, long j11, boolean z11, boolean z12, long j12, long j13, zzur zzurVar) throws zziz {
        zzek.zzf(this.zzh == 0);
        this.zzd = zzmiVar;
        this.zzh = 1;
        zzx(z11, z12);
        zzG(zzamVarArr, zzwhVar, j12, j13, zzurVar);
        zzY(j12, z11);
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public /* synthetic */ void zzs() {
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public void zzt(int i11, @Nullable Object obj) throws zziz {
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzu(int i11, zzpb zzpbVar, zzel zzelVar) {
        this.zze = i11;
        this.zzf = zzpbVar;
        this.zzg = zzelVar;
        zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public final void zzv() throws IOException {
        zzwh zzwhVar = this.zzi;
        zzwhVar.getClass();
        zzwhVar.zzd();
    }

    public void zzw() {
        throw null;
    }

    public void zzx(boolean z11, boolean z12) throws zziz {
    }

    public void zzy() {
    }

    public void zzz(long j11, boolean z11) throws zziz {
        throw null;
    }
}
