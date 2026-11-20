package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzand implements zzamy {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    @Nullable
    private final zzaon zzb;

    @Nullable
    private final zzfp zzc;
    private final boolean[] zzd;
    private final zzanb zze;

    @Nullable
    private final zzann zzf;
    private zzanc zzg;
    private long zzh;
    private String zzi;
    private zzaea zzj;
    private boolean zzk;
    private long zzl;

    public zzand() {
        this(null);
    }

    public zzand(@Nullable zzaon zzaonVar) {
        this.zzb = zzaonVar;
        this.zzd = new boolean[4];
        this.zze = new zzanb(128);
        this.zzl = C.TIME_UNSET;
        this.zzf = new zzann(178, 128);
        this.zzc = new zzfp();
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        int i11;
        float f11;
        float f12;
        zzek.zzb(this.zzg);
        zzek.zzb(this.zzj);
        int iZzd = zzfpVar.zzd();
        int iZze = zzfpVar.zze();
        byte[] bArrZzM = zzfpVar.zzM();
        this.zzh += (long) zzfpVar.zzb();
        this.zzj.zzr(zzfpVar, zzfpVar.zzb());
        while (true) {
            int iZza = zzgm.zza(bArrZzM, iZzd, iZze, this.zzd);
            if (iZza == iZze) {
                break;
            }
            int i12 = iZza + 3;
            int i13 = zzfpVar.zzM()[i12] & 255;
            int i14 = iZza - iZzd;
            if (!this.zzk) {
                if (i14 > 0) {
                    this.zze.zza(bArrZzM, iZzd, iZza);
                }
                if (this.zze.zzc(i13, i14 < 0 ? -i14 : 0)) {
                    zzaea zzaeaVar = this.zzj;
                    zzanb zzanbVar = this.zze;
                    int i15 = zzanbVar.zzb;
                    String str = this.zzi;
                    str.getClass();
                    byte[] bArrCopyOf = Arrays.copyOf(zzanbVar.zzc, zzanbVar.zza);
                    zzfo zzfoVar = new zzfo(bArrCopyOf, bArrCopyOf.length);
                    zzfoVar.zzn(i15);
                    zzfoVar.zzn(4);
                    zzfoVar.zzl();
                    zzfoVar.zzm(8);
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(4);
                        zzfoVar.zzm(3);
                    }
                    int iZzd2 = zzfoVar.zzd(4);
                    if (iZzd2 == 15) {
                        int iZzd3 = zzfoVar.zzd(8);
                        int iZzd4 = zzfoVar.zzd(8);
                        if (iZzd4 == 0) {
                            zzff.zzf("H263Reader", "Invalid aspect ratio");
                            f12 = 1.0f;
                        } else {
                            f11 = iZzd3 / iZzd4;
                            f12 = f11;
                        }
                    } else if (iZzd2 < 7) {
                        f11 = zza[iZzd2];
                        f12 = f11;
                    } else {
                        zzff.zzf("H263Reader", "Invalid aspect ratio");
                        f12 = 1.0f;
                    }
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(2);
                        zzfoVar.zzm(1);
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(15);
                            zzfoVar.zzl();
                            zzfoVar.zzm(15);
                            zzfoVar.zzl();
                            zzfoVar.zzm(15);
                            zzfoVar.zzl();
                            zzfoVar.zzm(3);
                            zzfoVar.zzm(11);
                            zzfoVar.zzl();
                            zzfoVar.zzm(15);
                            zzfoVar.zzl();
                        }
                    }
                    if (zzfoVar.zzd(2) != 0) {
                        zzff.zzf("H263Reader", "Unhandled video object layer shape");
                    }
                    zzfoVar.zzl();
                    int iZzd5 = zzfoVar.zzd(16);
                    zzfoVar.zzl();
                    if (zzfoVar.zzo()) {
                        if (iZzd5 == 0) {
                            zzff.zzf("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            int i16 = iZzd5 - 1;
                            int i17 = 0;
                            while (i16 > 0) {
                                i16 >>= 1;
                                i17++;
                            }
                            zzfoVar.zzm(i17);
                        }
                    }
                    zzfoVar.zzl();
                    int iZzd6 = zzfoVar.zzd(13);
                    zzfoVar.zzl();
                    int iZzd7 = zzfoVar.zzd(13);
                    zzfoVar.zzl();
                    zzfoVar.zzl();
                    zzak zzakVar = new zzak();
                    zzakVar.zzK(str);
                    zzakVar.zzW(MimeTypes.VIDEO_MP4V);
                    zzakVar.zzab(iZzd6);
                    zzakVar.zzI(iZzd7);
                    zzakVar.zzS(f12);
                    zzakVar.zzL(Collections.singletonList(bArrCopyOf));
                    zzaeaVar.zzl(zzakVar.zzac());
                    this.zzk = true;
                }
            }
            this.zzg.zza(bArrZzM, iZzd, iZza);
            zzann zzannVar = this.zzf;
            if (i14 > 0) {
                zzannVar.zza(bArrZzM, iZzd, iZza);
                i11 = 0;
            } else {
                i11 = -i14;
            }
            if (this.zzf.zzd(i11)) {
                zzann zzannVar2 = this.zzf;
                int iZzb = zzgm.zzb(zzannVar2.zza, zzannVar2.zzb);
                zzfp zzfpVar2 = this.zzc;
                int i18 = zzfy.zza;
                zzfpVar2.zzI(this.zzf.zza, iZzb);
                this.zzb.zza(this.zzl, this.zzc);
            }
            if (i13 == 178) {
                if (zzfpVar.zzM()[iZza + 2] == 1) {
                    this.zzf.zzc(178);
                }
                i13 = 178;
            }
            int i19 = iZze - iZza;
            this.zzg.zzb(this.zzh - ((long) i19), i19, this.zzk);
            this.zzg.zzc(i13, this.zzl);
            iZzd = i12;
        }
        if (!this.zzk) {
            this.zze.zza(bArrZzM, iZzd, iZze);
        }
        this.zzg.zza(bArrZzM, iZzd, iZze);
        this.zzf.zza(bArrZzM, iZzd, iZze);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzi = zzaokVar.zzb();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 2);
        this.zzj = zzaeaVarZzw;
        this.zzg = new zzanc(zzaeaVarZzw);
        this.zzb.zzb(zzacxVar, zzaokVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z11) {
        zzek.zzb(this.zzg);
        if (z11) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j11, int i11) {
        this.zzl = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        zzgm.zzf(this.zzd);
        this.zze.zzb();
        zzanc zzancVar = this.zzg;
        if (zzancVar != null) {
            zzancVar.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0L;
        this.zzl = C.TIME_UNSET;
    }
}
