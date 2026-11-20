package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfp {
    private static final char[] zza = {'\r', '\n'};
    private static final char[] zzb = {'\n'};
    private static final zzgaf zzc = zzgaf.zzr(zzfwq.zza, zzfwq.zzc, zzfwq.zzf, zzfwq.zzd, zzfwq.zze);
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzfp() {
        this.zzd = zzfy.zzf;
    }

    public zzfp(int i11) {
        this.zzd = new byte[i11];
        this.zzf = i11;
    }

    public zzfp(byte[] bArr) {
        this.zzd = bArr;
        this.zzf = bArr.length;
    }

    public zzfp(byte[] bArr, int i11) {
        this.zzd = bArr;
        this.zzf = i11;
    }

    private final char zzN(Charset charset, char[] cArr) {
        int iZzO = zzO(charset);
        if (iZzO != 0) {
            int i11 = iZzO >> 16;
            for (char c11 : cArr) {
                char c12 = (char) i11;
                if (c11 == c12) {
                    this.zze += (char) iZzO;
                    return c12;
                }
            }
        }
        return (char) 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0036  */
    /* JADX WARN: Code duplicated, block: B:15:0x003d  */
    /* JADX WARN: Code duplicated, block: B:17:0x004b  */
    /* JADX WARN: Code duplicated, block: B:19:0x0053  */
    /* JADX WARN: Code duplicated, block: B:21:0x005a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0070 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    private final int zzO(Charset charset) {
        byte bZza;
        int i11;
        int i12;
        char cZzb;
        int i13;
        int i14;
        int i15 = 1;
        if (charset.equals(zzfwq.zzc) || charset.equals(zzfwq.zza)) {
            int i16 = this.zzf;
            int i17 = this.zze;
            if (i16 - i17 > 0) {
                bZza = (byte) zzgct.zza(this.zzd[i17] & 255);
            } else {
                if (!charset.equals(zzfwq.zzf) || charset.equals(zzfwq.zzd)) {
                    i11 = this.zzf;
                    i12 = this.zze;
                    if (i11 - i12 >= 2) {
                        byte[] bArr = this.zzd;
                        cZzb = zzgct.zzb(bArr[i12], bArr[i12 + 1]);
                    } else {
                        if (charset.equals(zzfwq.zze)) {
                            return 0;
                        }
                        i13 = this.zzf;
                        i14 = this.zze;
                        if (i13 - i14 >= 2) {
                            return 0;
                        }
                        byte[] bArr2 = this.zzd;
                        cZzb = zzgct.zzb(bArr2[i14 + 1], bArr2[i14]);
                    }
                } else {
                    if (charset.equals(zzfwq.zze)) {
                        return 0;
                    }
                    i13 = this.zzf;
                    i14 = this.zze;
                    if (i13 - i14 >= 2) {
                        return 0;
                    }
                    byte[] bArr3 = this.zzd;
                    cZzb = zzgct.zzb(bArr3[i14 + 1], bArr3[i14]);
                }
                bZza = (byte) cZzb;
                i15 = 2;
            }
        } else {
            if (charset.equals(zzfwq.zzf)) {
                i11 = this.zzf;
                i12 = this.zze;
                if (i11 - i12 >= 2) {
                    byte[] bArr4 = this.zzd;
                    cZzb = zzgct.zzb(bArr4[i12], bArr4[i12 + 1]);
                } else {
                    if (charset.equals(zzfwq.zze)) {
                        return 0;
                    }
                    i13 = this.zzf;
                    i14 = this.zze;
                    if (i13 - i14 >= 2) {
                        return 0;
                    }
                    byte[] bArr5 = this.zzd;
                    cZzb = zzgct.zzb(bArr5[i14 + 1], bArr5[i14]);
                }
            } else {
                i11 = this.zzf;
                i12 = this.zze;
                if (i11 - i12 >= 2) {
                    byte[] bArr6 = this.zzd;
                    cZzb = zzgct.zzb(bArr6[i12], bArr6[i12 + 1]);
                } else {
                    if (charset.equals(zzfwq.zze)) {
                        return 0;
                    }
                    i13 = this.zzf;
                    i14 = this.zze;
                    if (i13 - i14 >= 2) {
                        return 0;
                    }
                    byte[] bArr7 = this.zzd;
                    cZzb = zzgct.zzb(bArr7[i14 + 1], bArr7[i14]);
                }
            }
            bZza = (byte) cZzb;
            i15 = 2;
        }
        return (zzgct.zza(bZza) << 16) + i15;
    }

    public final String zzA(int i11, Charset charset) {
        byte[] bArr = this.zzd;
        int i12 = this.zze;
        String str = new String(bArr, i12, i11, charset);
        this.zze = i12 + i11;
        return str;
    }

    @Nullable
    public final Charset zzB() {
        int i11 = this.zzf;
        int i12 = this.zze;
        int i13 = i11 - i12;
        if (i13 >= 3) {
            byte[] bArr = this.zzd;
            if (bArr[i12] == -17 && bArr[i12 + 1] == -69 && bArr[i12 + 2] == -65) {
                this.zze = i12 + 3;
                return zzfwq.zzc;
            }
        }
        if (i13 < 2) {
            return null;
        }
        byte[] bArr2 = this.zzd;
        byte b11 = bArr2[i12];
        if (b11 == -2) {
            if (bArr2[i12 + 1] != -1) {
                return null;
            }
            this.zze = i12 + 2;
            return zzfwq.zzd;
        }
        if (b11 != -1 || bArr2[i12 + 1] != -2) {
            return null;
        }
        this.zze = i12 + 2;
        return zzfwq.zze;
    }

    public final short zzC() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.zze = i11 + 2;
        return (short) (((bArr[i12] & 255) << 8) | i13);
    }

    public final short zzD() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.zze = i11 + 2;
        return (short) ((bArr[i12] & 255) | (i13 << 8));
    }

    public final void zzE(int i11) {
        byte[] bArr = this.zzd;
        if (i11 > bArr.length) {
            this.zzd = Arrays.copyOf(bArr, i11);
        }
    }

    public final void zzF(zzfo zzfoVar, int i11) {
        zzG(zzfoVar.zza, 0, i11);
        zzfoVar.zzk(0);
    }

    public final void zzG(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.zzd, this.zze, bArr, i11, i12);
        this.zze += i12;
    }

    public final void zzH(int i11) {
        byte[] bArr = this.zzd;
        if (bArr.length < i11) {
            bArr = new byte[i11];
        }
        zzI(bArr, i11);
    }

    public final void zzI(byte[] bArr, int i11) {
        this.zzd = bArr;
        this.zzf = i11;
        this.zze = 0;
    }

    public final void zzJ(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= this.zzd.length) {
            z11 = true;
        }
        zzek.zzd(z11);
        this.zzf = i11;
    }

    public final void zzK(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= this.zzf) {
            z11 = true;
        }
        zzek.zzd(z11);
        this.zze = i11;
    }

    public final void zzL(int i11) {
        zzK(this.zze + i11);
    }

    public final byte[] zzM() {
        return this.zzd;
    }

    public final char zza(Charset charset) {
        zzek.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(charset)));
        return (char) (zzO(charset) >> 16);
    }

    public final int zzb() {
        return this.zzf - this.zze;
    }

    public final int zzc() {
        return this.zzd.length;
    }

    public final int zzd() {
        return this.zze;
    }

    public final int zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzd[this.zze] & 255;
    }

    public final int zzg() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        int i12 = bArr[i11] & 255;
        int i13 = bArr[i11 + 1] & 255;
        int i14 = i11 + 3;
        int i15 = bArr[i11 + 2] & 255;
        this.zze = i11 + 4;
        return (bArr[i14] & 255) | (i12 << 24) | (i13 << 16) | (i15 << 8);
    }

    public final int zzh() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        int i12 = bArr[i11] & 255;
        int i13 = i11 + 2;
        int i14 = bArr[i11 + 1] & 255;
        this.zze = i11 + 3;
        return (bArr[i13] & 255) | ((i12 << 24) >> 8) | (i14 << 8);
    }

    public final int zzi() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        int i12 = bArr[i11] & 255;
        int i13 = bArr[i11 + 1] & 255;
        int i14 = bArr[i11 + 2] & 255;
        this.zze = i11 + 4;
        return ((bArr[i11 + 3] & 255) << 24) | (i13 << 8) | i12 | (i14 << 16);
    }

    public final int zzj() {
        int iZzi = zzi();
        if (iZzi >= 0) {
            return iZzi;
        }
        throw new IllegalStateException("Top bit not zero: " + iZzi);
    }

    public final int zzk() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.zze = i11 + 2;
        return ((bArr[i12] & 255) << 8) | i13;
    }

    public final int zzl() {
        return (zzm() << 21) | (zzm() << 14) | (zzm() << 7) | zzm();
    }

    public final int zzm() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        this.zze = i11 + 1;
        return bArr[i11] & 255;
    }

    public final int zzn() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        int i12 = bArr[i11] & 255;
        int i13 = bArr[i11 + 1] & 255;
        this.zze = i11 + 4;
        return i13 | (i12 << 8);
    }

    public final int zzo() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        int i12 = bArr[i11] & 255;
        int i13 = i11 + 2;
        int i14 = bArr[i11 + 1] & 255;
        this.zze = i11 + 3;
        return (bArr[i13] & 255) | (i12 << 16) | (i14 << 8);
    }

    public final int zzp() {
        int iZzg = zzg();
        if (iZzg >= 0) {
            return iZzg;
        }
        throw new IllegalStateException("Top bit not zero: " + iZzg);
    }

    public final int zzq() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.zze = i11 + 2;
        return (bArr[i12] & 255) | (i13 << 8);
    }

    public final long zzr() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        long j11 = bArr[i11];
        long j12 = bArr[i11 + 1];
        long j13 = bArr[i11 + 2];
        long j14 = bArr[i11 + 3];
        long j15 = bArr[i11 + 4];
        long j16 = bArr[i11 + 5];
        long j17 = bArr[i11 + 6];
        this.zze = i11 + 8;
        long j18 = j16 & 255;
        return ((((long) bArr[i11 + 7]) & 255) << 56) | ((j17 & 255) << 48) | ((j12 & 255) << 8) | (j11 & 255) | ((j13 & 255) << 16) | ((j14 & 255) << 24) | ((j15 & 255) << 32) | (j18 << 40);
    }

    public final long zzs() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        long j11 = bArr[i11];
        long j12 = bArr[i11 + 1];
        long j13 = bArr[i11 + 2];
        this.zze = i11 + 4;
        return ((((long) bArr[i11 + 3]) & 255) << 24) | (j11 & 255) | ((j12 & 255) << 8) | ((j13 & 255) << 16);
    }

    public final long zzt() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        long j11 = bArr[i11];
        long j12 = bArr[i11 + 1];
        long j13 = bArr[i11 + 2];
        long j14 = bArr[i11 + 3];
        long j15 = bArr[i11 + 4];
        long j16 = bArr[i11 + 5];
        long j17 = bArr[i11 + 6];
        this.zze = i11 + 8;
        return (((long) bArr[i11 + 7]) & 255) | ((j11 & 255) << 56) | ((j12 & 255) << 48) | ((j13 & 255) << 40) | ((j14 & 255) << 32) | ((j15 & 255) << 24) | ((j16 & 255) << 16) | ((j17 & 255) << 8);
    }

    public final long zzu() {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        long j11 = bArr[i11];
        long j12 = bArr[i11 + 1];
        long j13 = bArr[i11 + 2];
        this.zze = i11 + 4;
        return (((long) bArr[i11 + 3]) & 255) | ((j11 & 255) << 24) | ((j12 & 255) << 16) | ((j13 & 255) << 8);
    }

    public final long zzv() {
        long jZzt = zzt();
        if (jZzt >= 0) {
            return jZzt;
        }
        throw new IllegalStateException("Top bit not zero: " + jZzt);
    }

    public final long zzw() {
        int i11;
        int i12;
        long j11 = this.zzd[this.zze];
        int i13 = 7;
        while (true) {
            i11 = 0;
            if (i13 < 0) {
                break;
            }
            int i14 = 1 << i13;
            if ((((long) i14) & j11) == 0) {
                if (i13 >= 6) {
                    if (i13 != 7) {
                        break;
                    }
                    i11 = 1;
                    break;
                }
                j11 &= (long) (i14 - 1);
                i11 = 7 - i13;
                break;
            }
            i13--;
        }
        if (i11 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j11);
        }
        for (i12 = 1; i12 < i11; i12++) {
            byte b11 = this.zzd[this.zze + i12];
            if ((b11 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j11);
            }
            j11 = (j11 << 6) | ((long) (b11 & Utf8.REPLACEMENT_BYTE));
        }
        this.zze += i11;
        return j11;
    }

    @Nullable
    public final String zzx(char c11) {
        int i11 = this.zzf;
        int i12 = this.zze;
        if (i11 - i12 == 0) {
            return null;
        }
        while (i12 < this.zzf && this.zzd[i12] != 0) {
            i12++;
        }
        byte[] bArr = this.zzd;
        int i13 = this.zze;
        String strZzA = zzfy.zzA(bArr, i13, i12 - i13);
        this.zze = i12;
        if (i12 < this.zzf) {
            this.zze = i12 + 1;
        }
        return strZzA;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bc A[SYNTHETIC] */
    @Nullable
    public final String zzy(Charset charset) {
        byte[] bArr;
        zzek.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(charset)));
        if (this.zzf - this.zze == 0) {
            return null;
        }
        Charset charset2 = zzfwq.zza;
        if (!charset.equals(charset2)) {
            zzB();
        }
        int i11 = 1;
        if (!charset.equals(zzfwq.zzc) && !charset.equals(charset2)) {
            i11 = 2;
            if (!charset.equals(zzfwq.zzf) && !charset.equals(zzfwq.zze) && !charset.equals(zzfwq.zzd)) {
                throw new IllegalArgumentException("Unsupported charset: ".concat(String.valueOf(charset)));
            }
        }
        int i12 = this.zze;
        while (true) {
            int i13 = this.zzf;
            if (i12 >= i13 - (i11 - 1)) {
                i12 = i13;
                break;
            }
            if ((charset.equals(zzfwq.zzc) || charset.equals(zzfwq.zza)) && zzfy.zzI(this.zzd[i12])) {
                break;
            }
            if (charset.equals(zzfwq.zzf) || charset.equals(zzfwq.zzd)) {
                byte[] bArr2 = this.zzd;
                if (bArr2[i12] == 0 && zzfy.zzI(bArr2[i12 + 1])) {
                    break;
                }
                if (charset.equals(zzfwq.zze)) {
                    bArr = this.zzd;
                    if (bArr[i12 + 1] == 0 && zzfy.zzI(bArr[i12])) {
                        break;
                    }
                }
                i12 += i11;
            } else {
                if (charset.equals(zzfwq.zze)) {
                    bArr = this.zzd;
                    if (bArr[i12 + 1] == 0) {
                        continue;
                    }
                }
                i12 += i11;
            }
        }
        String strZzA = zzA(i12 - this.zze, charset);
        if (this.zze != this.zzf && zzN(charset, zza) == '\r') {
            zzN(charset, zzb);
        }
        return strZzA;
    }

    public final String zzz(int i11) {
        if (i11 == 0) {
            return "";
        }
        int i12 = this.zze;
        int i13 = (i12 + i11) - 1;
        String strZzA = zzfy.zzA(this.zzd, i12, (i13 >= this.zzf || this.zzd[i13] != 0) ? i11 : i11 - 1);
        this.zze += i11;
        return strZzA;
    }
}
