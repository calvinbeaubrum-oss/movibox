package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzake {
    private zzaea zzb;
    private zzacx zzc;
    private zzajz zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzajx zza = new zzajx();
    private zzakb zzj = new zzakb();

    public abstract long zza(zzfp zzfpVar);

    public void zzb(boolean z11) {
        int i11;
        if (z11) {
            this.zzj = new zzakb();
            this.zzf = 0L;
            i11 = 0;
        } else {
            i11 = 1;
        }
        this.zzh = i11;
        this.zze = -1L;
        this.zzg = 0L;
    }

    public abstract boolean zzc(zzfp zzfpVar, long j11, zzakb zzakbVar) throws IOException;

    public final int zze(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzb);
        int i11 = zzfy.zza;
        int i12 = this.zzh;
        if (i12 == 0) {
            while (this.zza.zze(zzacvVar)) {
                long jZzf = zzacvVar.zzf();
                long j11 = this.zzf;
                this.zzk = jZzf - j11;
                if (zzc(this.zza.zza(), j11, this.zzj)) {
                    this.zzf = zzacvVar.zzf();
                } else {
                    zzam zzamVar = this.zzj.zza;
                    this.zzi = zzamVar.zzA;
                    if (!this.zzm) {
                        this.zzb.zzl(zzamVar);
                        this.zzm = true;
                    }
                    zzajz zzajzVar = this.zzj.zzb;
                    if (zzajzVar != null) {
                        this.zzd = zzajzVar;
                    } else if (zzacvVar.zzd() == -1) {
                        this.zzd = new zzakd(null);
                    } else {
                        zzajy zzajyVarZzb = this.zza.zzb();
                        this.zzd = new zzajs(this, this.zzf, zzacvVar.zzd(), zzajyVarZzb.zzd + zzajyVarZzb.zze, zzajyVarZzb.zzb, (zzajyVarZzb.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                }
            }
            this.zzh = 3;
            return -1;
        }
        if (i12 == 1) {
            ((zzack) zzacvVar).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        }
        if (i12 != 2) {
            return -1;
        }
        long jZzd = this.zzd.zzd(zzacvVar);
        if (jZzd >= 0) {
            zzadrVar.zza = jZzd;
            return 1;
        }
        if (jZzd < -1) {
            zzi(-(jZzd + 2));
        }
        if (!this.zzl) {
            zzadu zzaduVarZze = this.zzd.zze();
            zzek.zzb(zzaduVarZze);
            this.zzc.zzO(zzaduVarZze);
            this.zzl = true;
        }
        if (this.zzk <= 0 && !this.zza.zze(zzacvVar)) {
            this.zzh = 3;
            return -1;
        }
        this.zzk = 0L;
        zzfp zzfpVarZza = this.zza.zza();
        long jZza = zza(zzfpVarZza);
        if (jZza >= 0) {
            long j12 = this.zzg;
            if (j12 + jZza >= this.zze) {
                long jZzf2 = zzf(j12);
                zzady.zzb(this.zzb, zzfpVarZza, zzfpVarZza.zze());
                this.zzb.zzt(jZzf2, 1, zzfpVarZza.zze(), 0, null);
                this.zze = -1L;
            }
        }
        this.zzg += jZza;
        return 0;
    }

    public final long zzf(long j11) {
        return (j11 * 1000000) / ((long) this.zzi);
    }

    public final long zzg(long j11) {
        return (((long) this.zzi) * j11) / 1000000;
    }

    public final void zzh(zzacx zzacxVar, zzaea zzaeaVar) {
        this.zzc = zzacxVar;
        this.zzb = zzaeaVar;
        zzb(true);
    }

    public void zzi(long j11) {
        this.zzg = j11;
    }

    public final void zzj(long j11, long j12) {
        this.zza.zzc();
        if (j11 == 0) {
            zzb(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            long jZzg = zzg(j12);
            this.zze = jZzg;
            zzajz zzajzVar = this.zzd;
            int i11 = zzfy.zza;
            zzajzVar.zzg(jZzg);
            this.zzh = 2;
        }
    }
}
