package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzwa {
    private final zzfp zza = new zzfp(32);
    private zzvz zzb;
    private zzvz zzc;
    private zzvz zzd;
    private long zze;
    private final zzyx zzf;

    public zzwa(zzyx zzyxVar) {
        this.zzf = zzyxVar;
        zzvz zzvzVar = new zzvz(0L, 65536);
        this.zzb = zzvzVar;
        this.zzc = zzvzVar;
        this.zzd = zzvzVar;
    }

    private final int zzi(int i11) {
        zzvz zzvzVar = this.zzd;
        if (zzvzVar.zzc == null) {
            zzyq zzyqVarZzb = this.zzf.zzb();
            zzvz zzvzVar2 = new zzvz(this.zzd.zzb, 65536);
            zzvzVar.zzc = zzyqVarZzb;
            zzvzVar.zzd = zzvzVar2;
        }
        return Math.min(i11, (int) (this.zzd.zzb - this.zze));
    }

    private static zzvz zzj(zzvz zzvzVar, long j11) {
        while (j11 >= zzvzVar.zzb) {
            zzvzVar = zzvzVar.zzd;
        }
        return zzvzVar;
    }

    private static zzvz zzk(zzvz zzvzVar, long j11, ByteBuffer byteBuffer, int i11) {
        zzvz zzvzVarZzj = zzj(zzvzVar, j11);
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (zzvzVarZzj.zzb - j11));
            byteBuffer.put(zzvzVarZzj.zzc.zza, zzvzVarZzj.zza(j11), iMin);
            i11 -= iMin;
            j11 += (long) iMin;
            if (j11 == zzvzVarZzj.zzb) {
                zzvzVarZzj = zzvzVarZzj.zzd;
            }
        }
        return zzvzVarZzj;
    }

    private static zzvz zzl(zzvz zzvzVar, long j11, byte[] bArr, int i11) {
        zzvz zzvzVarZzj = zzj(zzvzVar, j11);
        int i12 = i11;
        while (i12 > 0) {
            int iMin = Math.min(i12, (int) (zzvzVarZzj.zzb - j11));
            System.arraycopy(zzvzVarZzj.zzc.zza, zzvzVarZzj.zza(j11), bArr, i11 - i12, iMin);
            i12 -= iMin;
            j11 += (long) iMin;
            if (j11 == zzvzVarZzj.zzb) {
                zzvzVarZzj = zzvzVarZzj.zzd;
            }
        }
        return zzvzVarZzj;
    }

    private static zzvz zzm(zzvz zzvzVar, zzih zzihVar, zzwc zzwcVar, zzfp zzfpVar) {
        zzvz zzvzVarZzl;
        int iZzq;
        if (zzihVar.zzk()) {
            long j11 = zzwcVar.zzb;
            zzfpVar.zzH(1);
            zzvz zzvzVarZzl2 = zzl(zzvzVar, j11, zzfpVar.zzM(), 1);
            long j12 = j11 + 1;
            byte b11 = zzfpVar.zzM()[0];
            int i11 = b11 & 128;
            int i12 = b11 & Ascii.DEL;
            zzie zzieVar = zzihVar.zzb;
            byte[] bArr = zzieVar.zza;
            if (bArr == null) {
                zzieVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z11 = i11 != 0;
            zzvzVarZzl = zzl(zzvzVarZzl2, j12, zzieVar.zza, i12);
            long j13 = j12 + ((long) i12);
            if (z11) {
                zzfpVar.zzH(2);
                zzvzVarZzl = zzl(zzvzVarZzl, j13, zzfpVar.zzM(), 2);
                j13 += 2;
                iZzq = zzfpVar.zzq();
            } else {
                iZzq = 1;
            }
            int[] iArr = zzieVar.zzd;
            if (iArr == null || iArr.length < iZzq) {
                iArr = new int[iZzq];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzieVar.zze;
            if (iArr3 == null || iArr3.length < iZzq) {
                iArr3 = new int[iZzq];
            }
            int[] iArr4 = iArr3;
            if (z11) {
                int i13 = iZzq * 6;
                zzfpVar.zzH(i13);
                zzvzVarZzl = zzl(zzvzVarZzl, j13, zzfpVar.zzM(), i13);
                j13 += (long) i13;
                zzfpVar.zzK(0);
                for (int i14 = 0; i14 < iZzq; i14++) {
                    iArr2[i14] = zzfpVar.zzq();
                    iArr4[i14] = zzfpVar.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwcVar.zza - ((int) (j13 - zzwcVar.zzb));
            }
            zzadz zzadzVar = zzwcVar.zzc;
            int i15 = zzfy.zza;
            zzieVar.zzc(iZzq, iArr2, iArr4, zzadzVar.zzb, zzieVar.zza, zzadzVar.zza, zzadzVar.zzc, zzadzVar.zzd);
            long j14 = zzwcVar.zzb;
            int i16 = (int) (j13 - j14);
            zzwcVar.zzb = j14 + ((long) i16);
            zzwcVar.zza -= i16;
        } else {
            zzvzVarZzl = zzvzVar;
        }
        if (!zzihVar.zze()) {
            zzihVar.zzi(zzwcVar.zza);
            return zzk(zzvzVarZzl, zzwcVar.zzb, zzihVar.zzc, zzwcVar.zza);
        }
        zzfpVar.zzH(4);
        zzvz zzvzVarZzl3 = zzl(zzvzVarZzl, zzwcVar.zzb, zzfpVar.zzM(), 4);
        int iZzp = zzfpVar.zzp();
        zzwcVar.zzb += 4;
        zzwcVar.zza -= 4;
        zzihVar.zzi(iZzp);
        zzvz zzvzVarZzk = zzk(zzvzVarZzl3, zzwcVar.zzb, zzihVar.zzc, iZzp);
        zzwcVar.zzb += (long) iZzp;
        int i17 = zzwcVar.zza - iZzp;
        zzwcVar.zza = i17;
        ByteBuffer byteBuffer = zzihVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i17) {
            zzihVar.zzf = ByteBuffer.allocate(i17);
        } else {
            zzihVar.zzf.clear();
        }
        return zzk(zzvzVarZzk, zzwcVar.zzb, zzihVar.zzf, zzwcVar.zza);
    }

    private final void zzn(int i11) {
        long j11 = this.zze + ((long) i11);
        this.zze = j11;
        zzvz zzvzVar = this.zzd;
        if (j11 == zzvzVar.zzb) {
            this.zzd = zzvzVar.zzd;
        }
    }

    public final int zza(zzu zzuVar, int i11, boolean z11) throws IOException {
        int iZzi = zzi(i11);
        zzvz zzvzVar = this.zzd;
        int iZza = zzuVar.zza(zzvzVar.zzc.zza, zzvzVar.zza(this.zze), iZzi);
        if (iZza != -1) {
            zzn(iZza);
            return iZza;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j11) {
        zzvz zzvzVar;
        if (j11 != -1) {
            while (true) {
                zzvzVar = this.zzb;
                if (j11 < zzvzVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzvzVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzvzVar.zza) {
                this.zzc = zzvzVar;
            }
        }
    }

    public final void zzd(zzih zzihVar, zzwc zzwcVar) {
        zzm(this.zzc, zzihVar, zzwcVar, this.zza);
    }

    public final void zze(zzih zzihVar, zzwc zzwcVar) {
        this.zzc = zzm(this.zzc, zzihVar, zzwcVar, this.zza);
    }

    public final void zzf() {
        zzvz zzvzVar = this.zzb;
        if (zzvzVar.zzc != null) {
            this.zzf.zzd(zzvzVar);
            zzvzVar.zzb();
        }
        this.zzb.zze(0L, 65536);
        zzvz zzvzVar2 = this.zzb;
        this.zzc = zzvzVar2;
        this.zzd = zzvzVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzfp zzfpVar, int i11) {
        while (i11 > 0) {
            int iZzi = zzi(i11);
            zzvz zzvzVar = this.zzd;
            zzfpVar.zzG(zzvzVar.zzc.zza, zzvzVar.zza(this.zze), iZzi);
            i11 -= iZzi;
            zzn(iZzi);
        }
    }
}
