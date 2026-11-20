package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyn extends zzgyt {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk;

    public /* synthetic */ zzgyn(byte[] bArr, int i11, int i12, boolean z11, zzgym zzgymVar) {
        super(null);
        this.zzk = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zze = bArr;
        this.zzf = i12 + i11;
        this.zzh = i11;
        this.zzi = i11;
    }

    private final void zzJ() {
        int i11 = this.zzf + this.zzg;
        this.zzf = i11;
        int i12 = i11 - this.zzi;
        int i13 = this.zzk;
        if (i12 <= i13) {
            this.zzg = 0;
            return;
        }
        int i14 = i12 - i13;
        this.zzg = i14;
        this.zzf = i11 - i14;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void zzA(int i11) {
        this.zzk = i11;
        zzJ();
    }

    public final void zzB(int i11) throws IOException {
        if (i11 >= 0) {
            int i12 = this.zzf;
            int i13 = this.zzh;
            if (i11 <= i12 - i13) {
                this.zzh = i13 + i11;
                return;
            }
        }
        if (i11 >= 0) {
            throw zzhag.zzj();
        }
        throw zzhag.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean zzC() throws IOException {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean zzE(int i11) throws IOException {
        int iZzm;
        int i12 = i11 & 7;
        int i13 = 0;
        if (i12 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i13 < 10) {
                    if (zza() < 0) {
                        i13++;
                    }
                }
                throw zzhag.zze();
            }
            while (i13 < 10) {
                byte[] bArr = this.zze;
                int i14 = this.zzh;
                this.zzh = i14 + 1;
                if (bArr[i14] < 0) {
                    i13++;
                }
            }
            throw zzhag.zze();
            return true;
        }
        if (i12 == 1) {
            zzB(8);
            return true;
        }
        if (i12 == 2) {
            zzB(zzj());
            return true;
        }
        if (i12 != 3) {
            if (i12 == 4) {
                return false;
            }
            if (i12 != 5) {
                throw zzhag.zza();
            }
            zzB(4);
            return true;
        }
        do {
            iZzm = zzm();
            if (iZzm == 0) {
                break;
            }
        } while (zzE(iZzm));
        zzz(((i11 >>> 3) << 3) | 4);
        return true;
    }

    public final byte zza() throws IOException {
        int i11 = this.zzh;
        if (i11 == this.zzf) {
            throw zzhag.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i11 + 1;
        return bArr[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzd() {
        return this.zzh - this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zze(int i11) throws zzhag {
        if (i11 < 0) {
            throw zzhag.zzf();
        }
        int i12 = i11 + (this.zzh - this.zzi);
        if (i12 < 0) {
            throw zzhag.zzg();
        }
        int i13 = this.zzk;
        if (i12 > i13) {
            throw zzhag.zzj();
        }
        this.zzk = i12;
        zzJ();
        return i13;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzf() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzg() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        int i11 = this.zzh;
        if (this.zzf - i11 < 4) {
            throw zzhag.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i11 + 4;
        int i12 = bArr[i11] & 255;
        int i13 = bArr[i11 + 1] & 255;
        int i14 = bArr[i11 + 2] & 255;
        return ((bArr[i11 + 3] & 255) << 24) | (i13 << 8) | i12 | (i14 << 16);
    }

    public final int zzj() throws IOException {
        int i11;
        int i12 = this.zzh;
        int i13 = this.zzf;
        if (i13 != i12) {
            byte[] bArr = this.zze;
            int i14 = i12 + 1;
            byte b11 = bArr[i12];
            if (b11 >= 0) {
                this.zzh = i14;
                return b11;
            }
            if (i13 - i14 >= 9) {
                int i15 = i12 + 2;
                int i16 = (bArr[i14] << 7) ^ b11;
                if (i16 < 0) {
                    i11 = i16 ^ (-128);
                } else {
                    int i17 = i12 + 3;
                    int i18 = (bArr[i15] << Ascii.SO) ^ i16;
                    if (i18 >= 0) {
                        i11 = i18 ^ 16256;
                    } else {
                        int i19 = i12 + 4;
                        int i21 = i18 ^ (bArr[i17] << Ascii.NAK);
                        if (i21 < 0) {
                            i11 = (-2080896) ^ i21;
                        } else {
                            i17 = i12 + 5;
                            byte b12 = bArr[i19];
                            int i22 = (i21 ^ (b12 << Ascii.FS)) ^ 266354560;
                            if (b12 < 0) {
                                i19 = i12 + 6;
                                if (bArr[i17] < 0) {
                                    i17 = i12 + 7;
                                    if (bArr[i19] < 0) {
                                        i19 = i12 + 8;
                                        if (bArr[i17] < 0) {
                                            i17 = i12 + 9;
                                            if (bArr[i19] < 0) {
                                                int i23 = i12 + 10;
                                                if (bArr[i17] >= 0) {
                                                    i15 = i23;
                                                    i11 = i22;
                                                }
                                            }
                                        }
                                    }
                                }
                                i11 = i22;
                            }
                            i11 = i22;
                        }
                        i15 = i19;
                    }
                    i15 = i17;
                }
                this.zzh = i15;
                return i11;
            }
        }
        return (int) zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzk() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzl() throws IOException {
        return zzgyt.zzF(zzj());
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int iZzj = zzj();
        this.zzj = iZzj;
        if ((iZzj >>> 3) != 0) {
            return iZzj;
        }
        throw zzhag.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzn() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzo() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        int i11 = this.zzh;
        if (this.zzf - i11 < 8) {
            throw zzhag.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i11 + 8;
        long j11 = bArr[i11];
        long j12 = (((long) bArr[i11 + 1]) & 255) << 8;
        long j13 = bArr[i11 + 2];
        long j14 = bArr[i11 + 3];
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (j11 & 255) | j12 | ((j13 & 255) << 16) | ((j14 & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i11 + 6] & 255) << 48);
    }

    public final long zzr() throws IOException {
        long j11;
        long j12;
        int i11 = this.zzh;
        int i12 = this.zzf;
        if (i12 != i11) {
            byte[] bArr = this.zze;
            int i13 = i11 + 1;
            byte b11 = bArr[i11];
            if (b11 >= 0) {
                this.zzh = i13;
                return b11;
            }
            if (i12 - i13 >= 9) {
                int i14 = i11 + 2;
                int i15 = (bArr[i13] << 7) ^ b11;
                if (i15 < 0) {
                    j11 = i15 ^ (-128);
                } else {
                    int i16 = i11 + 3;
                    int i17 = (bArr[i14] << Ascii.SO) ^ i15;
                    if (i17 >= 0) {
                        j11 = i17 ^ 16256;
                    } else {
                        int i18 = i11 + 4;
                        int i19 = i17 ^ (bArr[i16] << Ascii.NAK);
                        if (i19 < 0) {
                            long j13 = (-2080896) ^ i19;
                            i14 = i18;
                            j11 = j13;
                        } else {
                            i16 = i11 + 5;
                            long j14 = (((long) bArr[i18]) << 28) ^ ((long) i19);
                            if (j14 >= 0) {
                                j11 = j14 ^ 266354560;
                            } else {
                                i14 = i11 + 6;
                                long j15 = (((long) bArr[i16]) << 35) ^ j14;
                                if (j15 < 0) {
                                    j12 = -34093383808L;
                                } else {
                                    int i21 = i11 + 7;
                                    long j16 = j15 ^ (((long) bArr[i14]) << 42);
                                    if (j16 >= 0) {
                                        j11 = j16 ^ 4363953127296L;
                                    } else {
                                        i14 = i11 + 8;
                                        j15 = j16 ^ (((long) bArr[i21]) << 49);
                                        if (j15 < 0) {
                                            j12 = -558586000294016L;
                                        } else {
                                            i21 = i11 + 9;
                                            long j17 = (j15 ^ (((long) bArr[i14]) << 56)) ^ 71499008037633920L;
                                            if (j17 < 0) {
                                                i14 = i11 + 10;
                                                if (bArr[i21] >= 0) {
                                                    j11 = j17;
                                                }
                                            } else {
                                                j11 = j17;
                                            }
                                        }
                                    }
                                    i14 = i21;
                                }
                                j11 = j15 ^ j12;
                            }
                        }
                    }
                    i14 = i16;
                }
                this.zzh = i14;
                return j11;
            }
        }
        return zzs();
    }

    public final long zzs() throws IOException {
        long j11 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            byte bZza = zza();
            j11 |= ((long) (bZza & Ascii.DEL)) << i11;
            if ((bZza & 128) == 0) {
                return j11;
            }
        }
        throw zzhag.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzt() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzu() throws IOException {
        return zzgyt.zzG(zzr());
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzv() throws IOException {
        return zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final zzgyl zzw() throws IOException {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i11 = this.zzf;
            int i12 = this.zzh;
            if (iZzj <= i11 - i12) {
                zzgyl zzgylVarZzv = zzgyl.zzv(this.zze, i12, iZzj);
                this.zzh += iZzj;
                return zzgylVarZzv;
            }
        }
        if (iZzj == 0) {
            return zzgyl.zzb;
        }
        if (iZzj > 0) {
            int i13 = this.zzf;
            int i14 = this.zzh;
            if (iZzj <= i13 - i14) {
                int i15 = iZzj + i14;
                this.zzh = i15;
                return new zzgyh(Arrays.copyOfRange(this.zze, i14, i15));
            }
        }
        if (iZzj <= 0) {
            throw zzhag.zzf();
        }
        throw zzhag.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final String zzx() throws IOException {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i11 = this.zzf;
            int i12 = this.zzh;
            if (iZzj <= i11 - i12) {
                String str = new String(this.zze, i12, iZzj, zzhae.zzb);
                this.zzh += iZzj;
                return str;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj < 0) {
            throw zzhag.zzf();
        }
        throw zzhag.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final String zzy() throws IOException {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i11 = this.zzf;
            int i12 = this.zzh;
            if (iZzj <= i11 - i12) {
                String strZzh = zzhde.zzh(this.zze, i12, iZzj);
                this.zzh += iZzj;
                return strZzh;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj <= 0) {
            throw zzhag.zzf();
        }
        throw zzhag.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void zzz(int i11) throws zzhag {
        if (this.zzj != i11) {
            throw zzhag.zzb();
        }
    }
}
