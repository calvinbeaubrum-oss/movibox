package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamu implements zzamy {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzfo zzc = new zzfo(new byte[7], 7);
    private final zzfp zzd = new zzfp(Arrays.copyOf(zza, 10));

    @Nullable
    private final String zze;
    private String zzf;
    private zzaea zzg;
    private zzaea zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private zzaea zzu;
    private long zzv;

    public zzamu(boolean z11, @Nullable String str) {
        zzh();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = C.TIME_UNSET;
        this.zzt = C.TIME_UNSET;
        this.zzb = z11;
        this.zze = str;
    }

    public static boolean zzf(int i11) {
        return (i11 & 65526) == 65520;
    }

    private final void zzg() {
        this.zzm = false;
        zzh();
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 256;
    }

    private final void zzi() {
        this.zzi = 3;
        this.zzj = 0;
    }

    private final void zzj(zzaea zzaeaVar, long j11, int i11, int i12) {
        this.zzi = 4;
        this.zzj = i11;
        this.zzu = zzaeaVar;
        this.zzv = j11;
        this.zzs = i12;
    }

    private final boolean zzk(zzfp zzfpVar, byte[] bArr, int i11) {
        int iMin = Math.min(zzfpVar.zzb(), i11 - this.zzj);
        zzfpVar.zzG(bArr, this.zzj, iMin);
        int i12 = this.zzj + iMin;
        this.zzj = i12;
        return i12 == i11;
    }

    private static final boolean zzl(byte b11, byte b12) {
        return zzf((b12 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzfp zzfpVar, byte[] bArr, int i11) {
        if (zzfpVar.zzb() < i11) {
            return false;
        }
        zzfpVar.zzG(bArr, 0, i11);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0284  */
    /* JADX WARN: Code duplicated, block: B:108:0x0288  */
    /* JADX WARN: Code duplicated, block: B:110:0x028c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0290  */
    /* JADX WARN: Code duplicated, block: B:114:0x0294  */
    /* JADX WARN: Code duplicated, block: B:116:0x029e  */
    /* JADX WARN: Code duplicated, block: B:118:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:120:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:144:0x025a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x025a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x025a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:72:0x0210  */
    /* JADX WARN: Code duplicated, block: B:74:0x0220  */
    /* JADX WARN: Code duplicated, block: B:76:0x022b  */
    /* JADX WARN: Code duplicated, block: B:78:0x022f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0233  */
    /* JADX WARN: Code duplicated, block: B:85:0x0242  */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) throws zzcc {
        int i11;
        int i12;
        int i13;
        int iZzd;
        byte[] bArrZzM;
        int iZze;
        int i14;
        byte b11;
        int i15;
        int i16;
        int i17;
        byte b12;
        this.zzg.getClass();
        int i18 = zzfy.zza;
        while (zzfpVar.zzb() > 0) {
            int i19 = this.zzi;
            int i21 = 13;
            int i22 = 2;
            if (i19 == 0) {
                byte[] bArrZzM2 = zzfpVar.zzM();
                int iZzd2 = zzfpVar.zzd();
                int iZze2 = zzfpVar.zze();
                while (true) {
                    if (iZzd2 < iZze2) {
                        int i23 = iZzd2 + 1;
                        byte b13 = bArrZzM2[iZzd2];
                        int i24 = b13 & 255;
                        if (this.zzk == 512 && zzl((byte) -1, (byte) i24)) {
                            if (!this.zzm) {
                                int i25 = iZzd2 - 1;
                                zzfpVar.zzK(iZzd2);
                                if (zzm(zzfpVar, this.zzc.zza, 1)) {
                                    this.zzc.zzk(4);
                                    int iZzd3 = this.zzc.zzd(1);
                                    int i26 = this.zzn;
                                    if (i26 == -1 || iZzd3 == i26) {
                                        if (this.zzo == -1) {
                                            if (zzm(zzfpVar, this.zzc.zza, 4)) {
                                                this.zzc.zzk(14);
                                                iZzd = this.zzc.zzd(i21);
                                                if (iZzd >= 7) {
                                                    bArrZzM = zzfpVar.zzM();
                                                    iZze = zzfpVar.zze();
                                                    i14 = i25 + iZzd;
                                                    if (i14 >= iZze) {
                                                        b11 = bArrZzM[i14];
                                                        if (b11 == -1) {
                                                            i17 = i14 + 1;
                                                            if (i17 != iZze) {
                                                                b12 = bArrZzM[i17];
                                                                if (zzl((byte) -1, b12) || ((b12 & 8) >> 3) != iZzd3) {
                                                                }
                                                            }
                                                        } else if (b11 == 73 || ((i15 = i14 + 1) != iZze && (bArrZzM[i15] != 68 || ((i16 = i14 + 2) != iZze && bArrZzM[i16] != 51)))) {
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (zzm(zzfpVar, this.zzc.zza, 1)) {
                                            this.zzc.zzk(i22);
                                            if (this.zzc.zzd(4) == this.zzo) {
                                                zzfpVar.zzK(iZzd2 + 1);
                                                if (zzm(zzfpVar, this.zzc.zza, 4)) {
                                                    this.zzc.zzk(14);
                                                    iZzd = this.zzc.zzd(i21);
                                                    if (iZzd >= 7) {
                                                        bArrZzM = zzfpVar.zzM();
                                                        iZze = zzfpVar.zze();
                                                        i14 = i25 + iZzd;
                                                        if (i14 >= iZze) {
                                                            b11 = bArrZzM[i14];
                                                            if (b11 == -1) {
                                                                i17 = i14 + 1;
                                                                if (i17 != iZze) {
                                                                    b12 = bArrZzM[i17];
                                                                    if (zzl((byte) -1, b12)) {
                                                                    }
                                                                }
                                                            } else if (b11 == 73) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                i11 = this.zzk;
                                i12 = i11 | i24;
                                if (i12 != 329) {
                                    i13 = 768;
                                } else if (i12 != 511) {
                                    if (i12 != 836) {
                                        i13 = 1024;
                                    } else if (i12 != 1075) {
                                        this.zzi = 2;
                                        this.zzj = 3;
                                        this.zzs = 0;
                                        this.zzd.zzK(0);
                                        zzfpVar.zzK(i23);
                                    } else if (i11 != 256) {
                                        this.zzk = 256;
                                    } else {
                                        iZzd2 = i23;
                                    }
                                    i21 = 13;
                                    i22 = 2;
                                } else {
                                    i13 = 512;
                                }
                                this.zzk = i13;
                                iZzd2 = i23;
                                i21 = 13;
                                i22 = 2;
                            }
                            this.zzp = (b13 & 8) >> 3;
                            this.zzl = 1 == ((b13 & 1) ^ 1);
                            if (this.zzm) {
                                zzi();
                            } else {
                                this.zzi = 1;
                                this.zzj = 0;
                            }
                            zzfpVar.zzK(i23);
                        } else {
                            i11 = this.zzk;
                            i12 = i11 | i24;
                            if (i12 != 329) {
                                i13 = 768;
                            } else if (i12 != 511) {
                                if (i12 != 836) {
                                    i13 = 1024;
                                } else if (i12 != 1075) {
                                    this.zzi = 2;
                                    this.zzj = 3;
                                    this.zzs = 0;
                                    this.zzd.zzK(0);
                                    zzfpVar.zzK(i23);
                                } else if (i11 != 256) {
                                    this.zzk = 256;
                                } else {
                                    iZzd2 = i23;
                                }
                                i21 = 13;
                                i22 = 2;
                            } else {
                                i13 = 512;
                            }
                            this.zzk = i13;
                            iZzd2 = i23;
                            i21 = 13;
                            i22 = 2;
                        }
                    } else {
                        zzfpVar.zzK(iZzd2);
                    }
                }
            } else if (i19 != 1) {
                if (i19 != 2) {
                    if (i19 != 3) {
                        int iMin = Math.min(zzfpVar.zzb(), this.zzs - this.zzj);
                        this.zzu.zzr(zzfpVar, iMin);
                        int i27 = this.zzj + iMin;
                        this.zzj = i27;
                        if (i27 == this.zzs) {
                            zzek.zzf(this.zzt != C.TIME_UNSET);
                            this.zzu.zzt(this.zzt, 1, this.zzs, 0, null);
                            this.zzt += this.zzv;
                            zzh();
                        }
                    } else {
                        if (zzk(zzfpVar, this.zzc.zza, true != this.zzl ? 5 : 7)) {
                            this.zzc.zzk(0);
                            if (this.zzq) {
                                this.zzc.zzm(10);
                            } else {
                                int iZzd4 = this.zzc.zzd(2) + 1;
                                if (iZzd4 != 2) {
                                    zzff.zzf("AdtsReader", "Detected audio object type: " + iZzd4 + ", but assuming AAC LC.");
                                }
                                this.zzc.zzm(5);
                                int iZzd5 = this.zzc.zzd(3);
                                int i28 = this.zzo;
                                byte[] bArr = {(byte) (((i28 >> 1) & 7) | 16), (byte) (((iZzd5 << 3) & 120) | ((i28 << 7) & 128))};
                                zzabr zzabrVarZza = zzabs.zza(bArr);
                                zzak zzakVar = new zzak();
                                zzakVar.zzK(this.zzf);
                                zzakVar.zzW(MimeTypes.AUDIO_AAC);
                                zzakVar.zzz(zzabrVarZza.zzc);
                                zzakVar.zzy(zzabrVarZza.zzb);
                                zzakVar.zzX(zzabrVarZza.zza);
                                zzakVar.zzL(Collections.singletonList(bArr));
                                zzakVar.zzN(this.zze);
                                zzam zzamVarZzac = zzakVar.zzac();
                                this.zzr = 1024000000 / ((long) zzamVarZzac.zzA);
                                this.zzg.zzl(zzamVarZzac);
                                this.zzq = true;
                            }
                            this.zzc.zzm(4);
                            int iZzd6 = this.zzc.zzd(13);
                            zzj(this.zzg, this.zzr, 0, this.zzl ? iZzd6 - 9 : iZzd6 - 7);
                        }
                    }
                } else if (zzk(zzfpVar, this.zzd.zzM(), 10)) {
                    this.zzh.zzr(this.zzd, 10);
                    this.zzd.zzK(6);
                    zzj(this.zzh, 0L, 10, this.zzd.zzl() + 10);
                }
            } else if (zzfpVar.zzb() != 0) {
                zzfo zzfoVar = this.zzc;
                zzfoVar.zza[0] = zzfpVar.zzM()[zzfpVar.zzd()];
                zzfoVar.zzk(2);
                int iZzd7 = this.zzc.zzd(4);
                int i29 = this.zzo;
                if (i29 == -1 || iZzd7 == i29) {
                    if (!this.zzm) {
                        this.zzm = true;
                        this.zzn = this.zzp;
                        this.zzo = iZzd7;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzf = zzaokVar.zzb();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 1);
        this.zzg = zzaeaVarZzw;
        this.zzu = zzaeaVarZzw;
        if (!this.zzb) {
            this.zzh = new zzact();
            return;
        }
        zzaokVar.zzc();
        zzaea zzaeaVarZzw2 = zzacxVar.zzw(zzaokVar.zza(), 5);
        this.zzh = zzaeaVarZzw2;
        zzak zzakVar = new zzak();
        zzakVar.zzK(zzaokVar.zzb());
        zzakVar.zzW(MimeTypes.APPLICATION_ID3);
        zzaeaVarZzw2.zzl(zzakVar.zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z11) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j11, int i11) {
        this.zzt = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzt = C.TIME_UNSET;
        zzg();
    }
}
