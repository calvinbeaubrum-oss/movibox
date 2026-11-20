package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzafk implements zzacu {
    private zzacx zzb;
    private int zzc;
    private int zzd;
    private int zze;

    @Nullable
    private zzahe zzg;
    private zzacv zzh;
    private zzafn zzi;

    @Nullable
    private zzajh zzj;
    private final zzfp zza = new zzfp(6);
    private long zzf = -1;

    private final int zza(zzacv zzacvVar) throws IOException {
        this.zza.zzH(2);
        ((zzack) zzacvVar).zzm(this.zza.zzM(), 0, 2, false);
        return this.zza.zzq();
    }

    private final void zzf() {
        zzg(new zzbx[0]);
        zzacx zzacxVar = this.zzb;
        zzacxVar.getClass();
        zzacxVar.zzD();
        this.zzb.zzO(new zzadt(C.TIME_UNSET, 0L));
        this.zzc = 6;
    }

    private final void zzg(zzbx... zzbxVarArr) {
        zzacx zzacxVar = this.zzb;
        zzacxVar.getClass();
        zzaea zzaeaVarZzw = zzacxVar.zzw(1024, 4);
        zzak zzakVar = new zzak();
        zzakVar.zzB("image/jpeg");
        zzakVar.zzP(new zzby(C.TIME_UNSET, zzbxVarArr));
        zzaeaVarZzw.zzl(zzakVar.zzac());
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e8  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        int i11;
        String strZzx;
        zzafm zzafmVarZza;
        zzahe zzaheVar;
        long j11;
        int i12 = this.zzc;
        if (i12 == 0) {
            this.zza.zzH(2);
            ((zzack) zzacvVar).zzn(this.zza.zzM(), 0, 2, false);
            int iZzq = this.zza.zzq();
            this.zzd = iZzq;
            if (iZzq == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                    return 0;
                }
                zzf();
                return 0;
            }
            if ((iZzq >= 65488 && iZzq <= 65497) || iZzq == 65281) {
                return 0;
            }
            this.zzc = 1;
            return 0;
        }
        if (i12 == 1) {
            this.zza.zzH(2);
            ((zzack) zzacvVar).zzn(this.zza.zzM(), 0, 2, false);
            this.zze = this.zza.zzq() - 2;
            this.zzc = 2;
            return 0;
        }
        if (i12 != 2) {
            if (i12 != 4) {
                if (i12 != 5) {
                    if (i12 == 6) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                if (this.zzi == null || zzacvVar != this.zzh) {
                    this.zzh = zzacvVar;
                    this.zzi = new zzafn(zzacvVar, this.zzf);
                }
                zzajh zzajhVar = this.zzj;
                zzajhVar.getClass();
                int iZzb = zzajhVar.zzb(this.zzi, zzadrVar);
                if (iZzb == 1) {
                    zzadrVar.zza += this.zzf;
                }
                return iZzb;
            }
            long jZzf = zzacvVar.zzf();
            long j12 = this.zzf;
            if (jZzf != j12) {
                zzadrVar.zza = j12;
                return 1;
            }
            if (zzacvVar.zzm(this.zza.zzM(), 0, 1, true)) {
                zzacvVar.zzj();
                if (this.zzj == null) {
                    this.zzj = new zzajh(zzakp.zza, 8);
                }
                zzafn zzafnVar = new zzafn(zzacvVar, this.zzf);
                this.zzi = zzafnVar;
                if (this.zzj.zze(zzafnVar)) {
                    zzajh zzajhVar2 = this.zzj;
                    long j13 = this.zzf;
                    zzacx zzacxVar = this.zzb;
                    zzacxVar.getClass();
                    zzajhVar2.zzc(new zzafp(j13, zzacxVar));
                    zzahe zzaheVar2 = this.zzg;
                    zzaheVar2.getClass();
                    zzg(zzaheVar2);
                    this.zzc = 5;
                } else {
                    zzf();
                }
            } else {
                zzf();
            }
            return 0;
        }
        if (this.zzd == 65505) {
            zzfp zzfpVar = new zzfp(this.zze);
            ((zzack) zzacvVar).zzn(zzfpVar.zzM(), 0, this.zze, false);
            if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzfpVar.zzx((char) 0)) && (strZzx = zzfpVar.zzx((char) 0)) != null) {
                long jZzd = zzacvVar.zzd();
                if (jZzd == -1 || (zzafmVarZza = zzafq.zza(strZzx)) == null || zzafmVarZza.zzb.size() < 2) {
                    zzaheVar = null;
                } else {
                    int size = zzafmVarZza.zzb.size() - 1;
                    long j14 = -1;
                    long j15 = -1;
                    long j16 = -1;
                    long j17 = -1;
                    boolean z11 = false;
                    while (size >= 0) {
                        zzafl zzaflVar = (zzafl) zzafmVarZza.zzb.get(size);
                        boolean zEquals = MimeTypes.VIDEO_MP4.equals(zzaflVar.zza) | z11;
                        if (size == 0) {
                            jZzd -= zzaflVar.zzd;
                            j11 = 0;
                        } else {
                            j11 = jZzd - zzaflVar.zzc;
                        }
                        long j18 = jZzd;
                        jZzd = j11;
                        if (zEquals && jZzd != j18) {
                            j17 = j18 - jZzd;
                            j16 = jZzd;
                            zEquals = false;
                        }
                        if (size == 0) {
                            j15 = j18;
                        }
                        if (size == 0) {
                            j14 = jZzd;
                        }
                        size--;
                        z11 = zEquals;
                    }
                    if (j16 == -1 || j17 == -1 || j14 == -1 || j15 == -1) {
                        zzaheVar = null;
                    } else {
                        zzaheVar = new zzahe(j14, j15, zzafmVarZza.zza, j16, j17);
                    }
                }
                this.zzg = zzaheVar;
                if (zzaheVar != null) {
                    this.zzf = zzaheVar.zzd;
                }
            }
            i11 = 0;
        } else {
            i11 = 0;
            ((zzack) zzacvVar).zzo(this.zze, false);
        }
        this.zzc = i11;
        return i11;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzb = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        if (j11 == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzajh zzajhVar = this.zzj;
            zzajhVar.getClass();
            zzajhVar.zzd(j11, j12);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        if (zza(zzacvVar) != 65496) {
            return false;
        }
        int iZza = zza(zzacvVar);
        this.zzd = iZza;
        if (iZza == 65504) {
            this.zza.zzH(2);
            zzack zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(this.zza.zzM(), 0, 2, false);
            zzackVar.zzl(this.zza.zzq() - 2, false);
            iZza = zza(zzacvVar);
            this.zzd = iZza;
        }
        if (iZza == 65505) {
            zzack zzackVar2 = (zzack) zzacvVar;
            zzackVar2.zzl(2, false);
            this.zza.zzH(6);
            zzackVar2.zzm(this.zza.zzM(), 0, 6, false);
            if (this.zza.zzu() == 1165519206 && this.zza.zzq() == 0) {
                return true;
            }
        }
        return false;
    }
}
