package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamw implements zzamy {

    @Nullable
    private final String zzb;
    private String zzc;
    private zzaea zzd;
    private int zzf;
    private int zzg;
    private long zzh;
    private zzam zzi;
    private int zzj;
    private final zzfp zza = new zzfp(new byte[18]);
    private int zze = 0;
    private long zzk = C.TIME_UNSET;

    public zzamw(@Nullable String str) {
        this.zzb = str;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0100  */
    /* JADX WARN: Code duplicated, block: B:39:0x010c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0115  */
    /* JADX WARN: Code duplicated, block: B:42:0x011c  */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        int i11;
        int i12;
        byte b11;
        boolean z11;
        int i13;
        int i14;
        byte b12;
        int i15;
        byte b13;
        int i16;
        zzek.zzb(this.zzd);
        while (zzfpVar.zzb() > 0) {
            int i17 = this.zze;
            if (i17 == 0) {
                while (zzfpVar.zzb() > 0) {
                    int i18 = this.zzg << 8;
                    this.zzg = i18;
                    int iZzm = i18 | zzfpVar.zzm();
                    this.zzg = iZzm;
                    int i19 = zzacr.zza;
                    if (iZzm == 2147385345 || iZzm == -25230976 || iZzm == 536864768 || iZzm == -14745368) {
                        byte[] bArrZzM = this.zza.zzM();
                        int i21 = this.zzg;
                        bArrZzM[0] = (byte) ((i21 >> 24) & 255);
                        bArrZzM[1] = (byte) ((i21 >> 16) & 255);
                        bArrZzM[2] = (byte) ((i21 >> 8) & 255);
                        bArrZzM[3] = (byte) (i21 & 255);
                        this.zzf = 4;
                        this.zzg = 0;
                        this.zze = 1;
                        break;
                    }
                }
            } else if (i17 != 1) {
                int iMin = Math.min(zzfpVar.zzb(), this.zzj - this.zzf);
                this.zzd.zzr(zzfpVar, iMin);
                int i22 = this.zzf + iMin;
                this.zzf = i22;
                if (i22 == this.zzj) {
                    zzek.zzf(this.zzk != C.TIME_UNSET);
                    this.zzd.zzt(this.zzk, 1, this.zzj, 0, null);
                    this.zzk += this.zzh;
                    this.zze = 0;
                }
            } else {
                byte[] bArrZzM2 = this.zza.zzM();
                int iMin2 = Math.min(zzfpVar.zzb(), 18 - this.zzf);
                zzfpVar.zzG(bArrZzM2, this.zzf, iMin2);
                int i23 = this.zzf + iMin2;
                this.zzf = i23;
                if (i23 == 18) {
                    byte[] bArrZzM3 = this.zza.zzM();
                    if (this.zzi == null) {
                        zzam zzamVarZza = zzacr.zza(bArrZzM3, this.zzc, this.zzb, null);
                        this.zzi = zzamVarZza;
                        this.zzd.zzl(zzamVarZza);
                    }
                    int i24 = zzacr.zza;
                    byte b14 = bArrZzM3[0];
                    if (b14 != -2) {
                        if (b14 == -1) {
                            i16 = ((bArrZzM3[7] & 3) << 12) | ((bArrZzM3[6] & 255) << 4) | ((bArrZzM3[9] & 60) >> 2);
                        } else if (b14 != 31) {
                            i11 = (bArrZzM3[5] & 3) << 12;
                            i12 = (bArrZzM3[6] & 255) << 4;
                            b11 = bArrZzM3[7];
                        } else {
                            i16 = ((bArrZzM3[8] & 60) >> 2) | ((3 & bArrZzM3[6]) << 12) | ((bArrZzM3[7] & 255) << 4);
                        }
                        i13 = i16 + 1;
                        z11 = true;
                        if (z11) {
                            i13 = (i13 * 16) / 14;
                        }
                        this.zzj = i13;
                        if (b14 != -2) {
                            if (b14 != -1) {
                                i14 = (bArrZzM3[4] & 7) << 4;
                                b13 = bArrZzM3[7];
                            } else if (b14 != 31) {
                                i14 = (bArrZzM3[4] & 1) << 6;
                                b12 = bArrZzM3[5];
                            } else {
                                i14 = (bArrZzM3[5] & 7) << 4;
                                b13 = bArrZzM3[6];
                            }
                            i15 = b13 & 60;
                            this.zzh = (int) ((((long) ((((i15 >> 2) | i14) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                            this.zza.zzK(0);
                            this.zzd.zzr(this.zza, 18);
                            this.zze = 2;
                        } else {
                            i14 = (bArrZzM3[5] & 1) << 6;
                            b12 = bArrZzM3[4];
                        }
                        i15 = b12 & 252;
                        this.zzh = (int) ((((long) ((((i15 >> 2) | i14) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                        this.zza.zzK(0);
                        this.zzd.zzr(this.zza, 18);
                        this.zze = 2;
                    } else {
                        i11 = (bArrZzM3[4] & 3) << 12;
                        i12 = (bArrZzM3[7] & 255) << 4;
                        b11 = bArrZzM3[6];
                    }
                    i13 = (i11 | i12 | ((b11 & 240) >> 4)) + 1;
                    z11 = false;
                    if (z11) {
                        i13 = (i13 * 16) / 14;
                    }
                    this.zzj = i13;
                    if (b14 != -2) {
                        if (b14 != -1) {
                            i14 = (bArrZzM3[4] & 7) << 4;
                            b13 = bArrZzM3[7];
                        } else if (b14 != 31) {
                            i14 = (bArrZzM3[4] & 1) << 6;
                            b12 = bArrZzM3[5];
                        } else {
                            i14 = (bArrZzM3[5] & 7) << 4;
                            b13 = bArrZzM3[6];
                        }
                        i15 = b13 & 60;
                        this.zzh = (int) ((((long) ((((i15 >> 2) | i14) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                        this.zza.zzK(0);
                        this.zzd.zzr(this.zza, 18);
                        this.zze = 2;
                    } else {
                        i14 = (bArrZzM3[5] & 1) << 6;
                        b12 = bArrZzM3[4];
                    }
                    i15 = b12 & 252;
                    this.zzh = (int) ((((long) ((((i15 >> 2) | i14) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                    this.zza.zzK(0);
                    this.zzd.zzr(this.zza, 18);
                    this.zze = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzc = zzaokVar.zzb();
        this.zzd = zzacxVar.zzw(zzaokVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z11) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j11, int i11) {
        this.zzk = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzk = C.TIME_UNSET;
    }
}
