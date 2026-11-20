package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaos implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaoo
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzaos()};
        }
    };
    private zzacx zzb;
    private zzaea zzc;
    private zzaoq zzf;
    private int zzd = 0;
    private long zze = -1;
    private int zzg = -1;
    private long zzh = -1;

    /* JADX WARN: Code duplicated, block: B:47:0x00f5  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        int iZzk;
        zzek.zzb(this.zzc);
        int i11 = zzfy.zza;
        int i12 = this.zzd;
        if (i12 == 0) {
            zzek.zzf(zzacvVar.zzf() == 0);
            int i13 = this.zzg;
            if (i13 != -1) {
                ((zzack) zzacvVar).zzo(i13, false);
                this.zzd = 4;
            } else {
                if (!zzaov.zzc(zzacvVar)) {
                    throw zzcc.zza("Unsupported or unrecognized wav file type.", null);
                }
                ((zzack) zzacvVar).zzo((int) (zzacvVar.zze() - zzacvVar.zzf()), false);
                this.zzd = 1;
            }
            return 0;
        }
        long jZzr = -1;
        if (i12 == 1) {
            zzfp zzfpVar = new zzfp(8);
            zzaou zzaouVarZza = zzaou.zza(zzacvVar, zzfpVar);
            if (zzaouVarZza.zza != 1685272116) {
                zzacvVar.zzj();
            } else {
                zzack zzackVar = (zzack) zzacvVar;
                zzackVar.zzl(8, false);
                zzfpVar.zzK(0);
                zzackVar.zzm(zzfpVar.zzM(), 0, 8, false);
                jZzr = zzfpVar.zzr();
                zzackVar.zzo(((int) zzaouVarZza.zzb) + 8, false);
            }
            this.zze = jZzr;
            this.zzd = 2;
            return 0;
        }
        if (i12 == 2) {
            zzaot zzaotVarZzb = zzaov.zzb(zzacvVar);
            int i14 = zzaotVarZzb.zza;
            if (i14 == 17) {
                this.zzf = new zzaop(this.zzb, this.zzc, zzaotVarZzb);
            } else if (i14 == 6) {
                this.zzf = new zzaor(this.zzb, this.zzc, zzaotVarZzb, MimeTypes.AUDIO_ALAW, -1);
            } else if (i14 == 7) {
                this.zzf = new zzaor(this.zzb, this.zzc, zzaotVarZzb, MimeTypes.AUDIO_MLAW, -1);
            } else {
                int i15 = zzaotVarZzb.zze;
                if (i14 == 1) {
                    iZzk = zzfy.zzk(i15);
                } else {
                    if (i14 != 3) {
                        if (i14 == 65534) {
                            iZzk = zzfy.zzk(i15);
                        }
                    } else if (i15 == 32) {
                        iZzk = 4;
                    }
                    iZzk = 0;
                }
                if (iZzk == 0) {
                    throw zzcc.zzc("Unsupported WAV format type: " + i14);
                }
                this.zzf = new zzaor(this.zzb, this.zzc, zzaotVarZzb, MimeTypes.AUDIO_RAW, iZzk);
            }
            this.zzd = 3;
            return 0;
        }
        if (i12 != 3) {
            zzek.zzf(this.zzh != -1);
            long jZzf = this.zzh - zzacvVar.zzf();
            zzaoq zzaoqVar = this.zzf;
            zzaoqVar.getClass();
            return zzaoqVar.zzc(zzacvVar, jZzf) ? -1 : 0;
        }
        Pair pairZza = zzaov.zza(zzacvVar);
        this.zzg = ((Long) pairZza.first).intValue();
        long jLongValue = ((Long) pairZza.second).longValue();
        long j11 = this.zze;
        if (j11 != -1 && jLongValue == 4294967295L) {
            jLongValue = j11;
        }
        long j12 = ((long) this.zzg) + jLongValue;
        this.zzh = j12;
        long jZzd = zzacvVar.zzd();
        if (jZzd != -1 && j12 > jZzd) {
            zzff.zzf("WavExtractor", "Data exceeds input length: " + j12 + ", " + jZzd);
            this.zzh = jZzd;
            j12 = jZzd;
        }
        zzaoq zzaoqVar2 = this.zzf;
        zzaoqVar2.getClass();
        zzaoqVar2.zza(this.zzg, j12);
        this.zzd = 4;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzb = zzacxVar;
        this.zzc = zzacxVar.zzw(0, 1);
        zzacxVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        this.zzd = j11 == 0 ? 0 : 4;
        zzaoq zzaoqVar = this.zzf;
        if (zzaoqVar != null) {
            zzaoqVar.zzb(j12);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzaov.zzc(zzacvVar);
    }
}
