package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyp extends zzgyt {
    private final Iterable zze;
    private final Iterator zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    public /* synthetic */ zzgyp(Iterable iterable, int i11, boolean z11, zzgyo zzgyoVar) {
        super(null);
        this.zzj = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzh = i11;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (i11 != 0) {
            zzN();
            return;
        }
        this.zzg = zzhae.zze;
        this.zzm = 0L;
        this.zzn = 0L;
        this.zzo = 0L;
    }

    private final int zzJ() {
        return (int) ((((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn);
    }

    private final void zzK() throws zzhag {
        if (!this.zzf.hasNext()) {
            throw zzhag.zzj();
        }
        zzN();
    }

    private final void zzL(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 > zzJ()) {
            if (i12 > 0) {
                throw zzhag.zzj();
            }
            return;
        }
        int i13 = i12;
        while (i13 > 0) {
            if (this.zzo - this.zzm == 0) {
                zzK();
            }
            int iMin = Math.min(i13, (int) (this.zzo - this.zzm));
            long j11 = iMin;
            zzhcz.zzo(this.zzm, bArr, i12 - i13, j11);
            i13 -= iMin;
            this.zzm += j11;
        }
    }

    private final void zzM() {
        int i11 = this.zzh + this.zzi;
        this.zzh = i11;
        int i12 = this.zzj;
        if (i11 <= i12) {
            this.zzi = 0;
            return;
        }
        int i13 = i11 - i12;
        this.zzi = i13;
        this.zzh = i11 - i13;
    }

    private final void zzN() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzf.next();
        this.zzg = byteBuffer;
        this.zzl += (int) (this.zzm - this.zzn);
        long jPosition = byteBuffer.position();
        this.zzm = jPosition;
        this.zzn = jPosition;
        this.zzo = this.zzg.limit();
        long jZze = zzhcz.zze(this.zzg);
        this.zzm += jZze;
        this.zzn += jZze;
        this.zzo += jZze;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void zzA(int i11) {
        this.zzj = i11;
        zzM();
    }

    public final void zzB(int i11) throws IOException {
        if (i11 >= 0) {
            if (i11 <= (((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn) {
                while (i11 > 0) {
                    if (this.zzo - this.zzm == 0) {
                        zzK();
                    }
                    int iMin = Math.min(i11, (int) (this.zzo - this.zzm));
                    i11 -= iMin;
                    this.zzm += (long) iMin;
                }
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
        return (((long) this.zzl) + this.zzm) - this.zzn == ((long) this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean zzE(int i11) throws IOException {
        int iZzm;
        int i12 = i11 & 7;
        if (i12 == 0) {
            for (int i13 = 0; i13 < 10; i13++) {
                if (zza() >= 0) {
                    return true;
                }
            }
            throw zzhag.zze();
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
        if (this.zzo - this.zzm == 0) {
            zzK();
        }
        long j11 = this.zzm;
        this.zzm = 1 + j11;
        return zzhcz.zza(j11);
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
        return (int) ((((long) this.zzl) + this.zzm) - this.zzn);
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zze(int i11) throws zzhag {
        if (i11 < 0) {
            throw zzhag.zzf();
        }
        int iZzd = i11 + zzd();
        int i12 = this.zzj;
        if (iZzd > i12) {
            throw zzhag.zzj();
        }
        this.zzj = iZzd;
        zzM();
        return i12;
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
        long j11 = this.zzo;
        long j12 = this.zzm;
        if (j11 - j12 < 4) {
            int iZza = zza() & 255;
            int iZza2 = (zza() & 255) << 8;
            return iZza | iZza2 | ((zza() & 255) << 16) | ((zza() & 255) << 24);
        }
        this.zzm = 4 + j12;
        int iZza3 = zzhcz.zza(j12) & 255;
        int iZza4 = (zzhcz.zza(1 + j12) & 255) << 8;
        return iZza3 | iZza4 | ((zzhcz.zza(2 + j12) & 255) << 16) | ((zzhcz.zza(j12 + 3) & 255) << 24);
    }

    public final int zzj() throws IOException {
        int i11;
        long j11 = this.zzm;
        if (this.zzo != j11) {
            long j12 = j11 + 1;
            byte bZza = zzhcz.zza(j11);
            if (bZza >= 0) {
                this.zzm++;
                return bZza;
            }
            if (this.zzo - this.zzm >= 10) {
                long j13 = 2 + j11;
                int iZza = (zzhcz.zza(j12) << 7) ^ bZza;
                if (iZza < 0) {
                    i11 = iZza ^ (-128);
                } else {
                    long j14 = 3 + j11;
                    int iZza2 = (zzhcz.zza(j13) << Ascii.SO) ^ iZza;
                    if (iZza2 >= 0) {
                        i11 = iZza2 ^ 16256;
                    } else {
                        long j15 = 4 + j11;
                        int iZza3 = iZza2 ^ (zzhcz.zza(j14) << Ascii.NAK);
                        if (iZza3 < 0) {
                            i11 = (-2080896) ^ iZza3;
                        } else {
                            j14 = 5 + j11;
                            byte bZza2 = zzhcz.zza(j15);
                            int i12 = (iZza3 ^ (bZza2 << Ascii.FS)) ^ 266354560;
                            if (bZza2 < 0) {
                                j15 = 6 + j11;
                                if (zzhcz.zza(j14) < 0) {
                                    j14 = 7 + j11;
                                    if (zzhcz.zza(j15) < 0) {
                                        j15 = 8 + j11;
                                        if (zzhcz.zza(j14) < 0) {
                                            j14 = 9 + j11;
                                            if (zzhcz.zza(j15) < 0) {
                                                long j16 = j11 + 10;
                                                if (zzhcz.zza(j14) >= 0) {
                                                    i11 = i12;
                                                    j13 = j16;
                                                }
                                            }
                                        }
                                    }
                                }
                                i11 = i12;
                            }
                            i11 = i12;
                        }
                        j13 = j15;
                    }
                    j13 = j14;
                }
                this.zzm = j13;
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
            this.zzk = 0;
            return 0;
        }
        int iZzj = zzj();
        this.zzk = iZzj;
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
        long j11 = this.zzo;
        long j12 = this.zzm;
        if (j11 - j12 < 8) {
            long jZza = ((long) zza()) & 255;
            long jZza2 = (((long) zza()) & 255) << 8;
            long jZza3 = (((long) zza()) & 255) << 16;
            long jZza4 = (((long) zza()) & 255) << 24;
            long jZza5 = (((long) zza()) & 255) << 32;
            long jZza6 = (((long) zza()) & 255) << 40;
            return jZza | jZza2 | jZza3 | jZza4 | jZza5 | jZza6 | ((((long) zza()) & 255) << 48) | ((((long) zza()) & 255) << 56);
        }
        this.zzm = 8 + j12;
        long jZza7 = ((long) zzhcz.zza(j12)) & 255;
        long jZza8 = (((long) zzhcz.zza(1 + j12)) & 255) << 8;
        long jZza9 = (((long) zzhcz.zza(j12 + 2)) & 255) << 16;
        long jZza10 = (((long) zzhcz.zza(3 + j12)) & 255) << 24;
        long jZza11 = (((long) zzhcz.zza(j12 + 4)) & 255) << 32;
        long jZza12 = (((long) zzhcz.zza(5 + j12)) & 255) << 40;
        return jZza7 | jZza8 | jZza9 | jZza10 | jZza11 | jZza12 | ((((long) zzhcz.zza(j12 + 6)) & 255) << 48) | ((((long) zzhcz.zza(j12 + 7)) & 255) << 56);
    }

    public final long zzr() throws IOException {
        long j11;
        long j12;
        long j13 = this.zzm;
        if (this.zzo != j13) {
            long j14 = j13 + 1;
            byte bZza = zzhcz.zza(j13);
            if (bZza >= 0) {
                this.zzm++;
                return bZza;
            }
            if (this.zzo - this.zzm >= 10) {
                long j15 = 2 + j13;
                int iZza = (zzhcz.zza(j14) << 7) ^ bZza;
                if (iZza < 0) {
                    j11 = iZza ^ (-128);
                } else {
                    long j16 = 3 + j13;
                    int iZza2 = (zzhcz.zza(j15) << Ascii.SO) ^ iZza;
                    if (iZza2 >= 0) {
                        j11 = iZza2 ^ 16256;
                    } else {
                        long j17 = 4 + j13;
                        int iZza3 = iZza2 ^ (zzhcz.zza(j16) << Ascii.NAK);
                        if (iZza3 < 0) {
                            j11 = (-2080896) ^ iZza3;
                            j15 = j17;
                        } else {
                            j16 = 5 + j13;
                            long jZza = (((long) zzhcz.zza(j17)) << 28) ^ ((long) iZza3);
                            if (jZza >= 0) {
                                j11 = 266354560 ^ jZza;
                            } else {
                                long j18 = 6 + j13;
                                long jZza2 = jZza ^ (((long) zzhcz.zza(j16)) << 35);
                                if (jZza2 < 0) {
                                    j12 = -34093383808L;
                                } else {
                                    long j19 = 7 + j13;
                                    long jZza3 = jZza2 ^ (((long) zzhcz.zza(j18)) << 42);
                                    if (jZza3 >= 0) {
                                        j11 = 4363953127296L ^ jZza3;
                                    } else {
                                        j18 = 8 + j13;
                                        jZza2 = jZza3 ^ (((long) zzhcz.zza(j19)) << 49);
                                        if (jZza2 < 0) {
                                            j12 = -558586000294016L;
                                        } else {
                                            j19 = 9 + j13;
                                            long jZza4 = (jZza2 ^ (((long) zzhcz.zza(j18)) << 56)) ^ 71499008037633920L;
                                            if (jZza4 < 0) {
                                                long j21 = j13 + 10;
                                                if (zzhcz.zza(j19) >= 0) {
                                                    j11 = jZza4;
                                                    j15 = j21;
                                                }
                                            } else {
                                                j11 = jZza4;
                                            }
                                        }
                                    }
                                    j15 = j19;
                                }
                                j11 = j12 ^ jZza2;
                                j15 = j18;
                            }
                        }
                    }
                    j15 = j16;
                }
                this.zzm = j15;
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
            long j11 = this.zzo;
            long j12 = this.zzm;
            long j13 = iZzj;
            if (j13 <= j11 - j12) {
                byte[] bArr = new byte[iZzj];
                zzhcz.zzo(j12, bArr, 0L, j13);
                this.zzm += j13;
                return new zzgyh(bArr);
            }
        }
        if (iZzj > 0 && iZzj <= zzJ()) {
            byte[] bArr2 = new byte[iZzj];
            zzL(bArr2, 0, iZzj);
            return new zzgyh(bArr2);
        }
        if (iZzj == 0) {
            return zzgyl.zzb;
        }
        if (iZzj < 0) {
            throw zzhag.zzf();
        }
        throw zzhag.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final String zzx() throws IOException {
        int iZzj = zzj();
        if (iZzj > 0) {
            long j11 = this.zzo;
            long j12 = this.zzm;
            long j13 = iZzj;
            if (j13 <= j11 - j12) {
                byte[] bArr = new byte[iZzj];
                zzhcz.zzo(j12, bArr, 0L, j13);
                String str = new String(bArr, zzhae.zzb);
                this.zzm += j13;
                return str;
            }
        }
        if (iZzj > 0 && iZzj <= zzJ()) {
            byte[] bArr2 = new byte[iZzj];
            zzL(bArr2, 0, iZzj);
            return new String(bArr2, zzhae.zzb);
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
            long j11 = this.zzo;
            long j12 = this.zzm;
            long j13 = iZzj;
            if (j13 <= j11 - j12) {
                String strZzg = zzhde.zzg(this.zzg, (int) (j12 - this.zzn), iZzj);
                this.zzm += j13;
                return strZzg;
            }
        }
        if (iZzj >= 0 && iZzj <= zzJ()) {
            byte[] bArr = new byte[iZzj];
            zzL(bArr, 0, iZzj);
            return zzhde.zzh(bArr, 0, iZzj);
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
        if (this.zzk != i11) {
            throw zzhag.zzb();
        }
    }
}
