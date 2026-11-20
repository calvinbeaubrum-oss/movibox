package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajs implements zzajz {
    private final zzajy zza;
    private final long zzb;
    private final long zzc;
    private final zzake zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzajs(zzake zzakeVar, long j11, long j12, long j13, long j14, boolean z11) {
        zzek.zzd(j11 >= 0 && j12 > j11);
        this.zzd = zzakeVar;
        this.zzb = j11;
        this.zzc = j12;
        if (j13 == j12 - j11 || z11) {
            this.zzf = j14;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzajy();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    @Override // com.google.android.gms.internal.ads.zzajz
    public final long zzd(zzacv zzacvVar) throws IOException {
        long jMax;
        int i11 = this.zze;
        if (i11 == 0) {
            long jZzf = zzacvVar.zzf();
            this.zzg = jZzf;
            this.zze = 1;
            long j11 = this.zzc - 65307;
            if (j11 > jZzf) {
                return j11;
            }
        } else if (i11 != 1) {
            if (i11 == 2) {
                long j12 = this.zzi;
                long j13 = this.zzj;
                if (j12 == j13) {
                    jMax = -1;
                } else {
                    long jZzf2 = zzacvVar.zzf();
                    if (this.zza.zzc(zzacvVar, j13)) {
                        this.zza.zzb(zzacvVar, false);
                        zzacvVar.zzj();
                        long j14 = this.zzh;
                        zzajy zzajyVar = this.zza;
                        long j15 = zzajyVar.zzb;
                        long j16 = j14 - j15;
                        int i12 = zzajyVar.zzd + zzajyVar.zze;
                        if (j16 < 0 || j16 >= 72000) {
                            if (j16 < 0) {
                                this.zzj = jZzf2;
                                this.zzl = j15;
                            } else {
                                this.zzi = zzacvVar.zzf() + ((long) i12);
                                this.zzk = j15;
                            }
                            long j17 = this.zzj;
                            long j18 = this.zzi;
                            long j19 = j17 - j18;
                            if (j19 < 100000) {
                                this.zzj = j18;
                                jMax = j18;
                            } else {
                                jMax = Math.max(j18, Math.min((zzacvVar.zzf() - (((long) i12) * (j16 <= 0 ? 2L : 1L))) + ((j16 * j19) / (this.zzl - this.zzk)), j17 - 1));
                            }
                        } else {
                            jMax = -1;
                        }
                    } else {
                        jMax = this.zzi;
                        if (jMax == jZzf2) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                if (jMax != -1) {
                    return jMax;
                }
                this.zze = 3;
            } else if (i11 != 3) {
                return -1L;
            }
            while (true) {
                this.zza.zzc(zzacvVar, -1L);
                this.zza.zzb(zzacvVar, false);
                zzajy zzajyVar2 = this.zza;
                if (zzajyVar2.zzb > this.zzh) {
                    zzacvVar.zzj();
                    this.zze = 4;
                    return -(this.zzk + 2);
                }
                ((zzack) zzacvVar).zzo(zzajyVar2.zzd + zzajyVar2.zze, false);
                this.zzi = zzacvVar.zzf();
                this.zzk = this.zza.zzb;
            }
        }
        this.zza.zza();
        if (!this.zza.zzc(zzacvVar, -1L)) {
            throw new EOFException();
        }
        this.zza.zzb(zzacvVar, false);
        zzajy zzajyVar3 = this.zza;
        ((zzack) zzacvVar).zzo(zzajyVar3.zzd + zzajyVar3.zze, false);
        long j21 = this.zza.zzb;
        while (true) {
            zzajy zzajyVar4 = this.zza;
            if ((zzajyVar4.zza & 4) == 4 || !zzajyVar4.zzc(zzacvVar, -1L) || zzacvVar.zzf() >= this.zzc || !this.zza.zzb(zzacvVar, true)) {
                break;
            }
            zzajy zzajyVar5 = this.zza;
            if (!zzacy.zze(zzacvVar, zzajyVar5.zzd + zzajyVar5.zze)) {
                break;
            }
            j21 = this.zza.zzb;
        }
        this.zzf = j21;
        this.zze = 4;
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    @Nullable
    public final /* bridge */ /* synthetic */ zzadu zze() {
        zzajq zzajqVar = null;
        if (this.zzf != 0) {
            return new zzajr(this, zzajqVar);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final void zzg(long j11) {
        this.zzh = Math.max(0L, Math.min(j11, this.zzf - 1));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }
}
