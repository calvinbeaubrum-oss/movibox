package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyy extends zzgyv {
    private final OutputStream zzg;

    public zzgyy(OutputStream outputStream, int i11) {
        super(i11);
        this.zzg = outputStream;
    }

    private final void zzF() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzG(int i11) throws IOException {
        if (this.zzb - this.zzc < i11) {
            zzF();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzH() throws IOException {
        if (this.zzc > 0) {
            zzF();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzI(byte b11) throws IOException {
        if (this.zzc == this.zzb) {
            zzF();
        }
        zzc(b11);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzJ(int i11, boolean z11) throws IOException {
        zzG(11);
        zzf(i11 << 3);
        zzc(z11 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzK(int i11, zzgyl zzgylVar) throws IOException {
        zzs((i11 << 3) | 2);
        zzs(zzgylVar.zzd());
        zzgylVar.zzo(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgza, com.google.android.gms.internal.ads.zzgya
    public final void zza(byte[] bArr, int i11, int i12) throws IOException {
        zzp(bArr, i11, i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzh(int i11, int i12) throws IOException {
        zzG(14);
        zzf((i11 << 3) | 5);
        zzd(i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzi(int i11) throws IOException {
        zzG(4);
        zzd(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzj(int i11, long j11) throws IOException {
        zzG(18);
        zzf((i11 << 3) | 1);
        zze(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzk(long j11) throws IOException {
        zzG(8);
        zze(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzl(int i11, int i12) throws IOException {
        zzG(20);
        zzf(i11 << 3);
        if (i12 >= 0) {
            zzf(i12);
        } else {
            zzg(i12);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzm(int i11) throws IOException {
        if (i11 >= 0) {
            zzs(i11);
        } else {
            zzu(i11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzn(int i11, zzhbe zzhbeVar, zzhby zzhbyVar) throws IOException {
        zzs((i11 << 3) | 2);
        zzs(((zzgxt) zzhbeVar).zzat(zzhbyVar));
        zzhbyVar.zzm(zzhbeVar, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzo(int i11, String str) throws IOException {
        zzs((i11 << 3) | 2);
        zzv(str);
    }

    public final void zzp(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this.zzb;
        int i14 = this.zzc;
        int i15 = i13 - i14;
        if (i15 >= i12) {
            System.arraycopy(bArr, i11, this.zza, i14, i12);
            this.zzc += i12;
            this.zzd += i12;
            return;
        }
        System.arraycopy(bArr, i11, this.zza, i14, i15);
        int i16 = i11 + i15;
        this.zzc = this.zzb;
        this.zzd += i15;
        zzF();
        int i17 = i12 - i15;
        if (i17 <= this.zzb) {
            System.arraycopy(bArr, i16, this.zza, 0, i17);
            this.zzc = i17;
        } else {
            this.zzg.write(bArr, i16, i17);
        }
        this.zzd += i17;
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzq(int i11, int i12) throws IOException {
        zzs((i11 << 3) | i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzr(int i11, int i12) throws IOException {
        zzG(20);
        zzf(i11 << 3);
        zzf(i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzs(int i11) throws IOException {
        zzG(5);
        zzf(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzt(int i11, long j11) throws IOException {
        zzG(20);
        zzf(i11 << 3);
        zzg(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzu(long j11) throws IOException {
        zzG(10);
        zzg(j11);
    }

    public final void zzv(String str) throws IOException {
        int iZze;
        try {
            int length = str.length() * 3;
            int iZzz = zzgza.zzz(length);
            int i11 = iZzz + length;
            int i12 = this.zzb;
            if (i11 > i12) {
                byte[] bArr = new byte[length];
                int iZzd = zzhde.zzd(str, bArr, 0, length);
                zzs(iZzd);
                zzp(bArr, 0, iZzd);
                return;
            }
            if (i11 > i12 - this.zzc) {
                zzF();
            }
            int iZzz2 = zzgza.zzz(str.length());
            int i13 = this.zzc;
            try {
                if (iZzz2 == iZzz) {
                    int i14 = i13 + iZzz2;
                    this.zzc = i14;
                    int iZzd2 = zzhde.zzd(str, this.zza, i14, this.zzb - i14);
                    this.zzc = i13;
                    iZze = (iZzd2 - i13) - iZzz2;
                    zzf(iZze);
                    this.zzc = iZzd2;
                } else {
                    iZze = zzhde.zze(str);
                    zzf(iZze);
                    this.zzc = zzhde.zzd(str, this.zza, this.zzc, iZze);
                }
                this.zzd += iZze;
            } catch (zzhdd e11) {
                this.zzd -= this.zzc - i13;
                this.zzc = i13;
                throw e11;
            } catch (ArrayIndexOutOfBoundsException e12) {
                throw new zzgyx(e12);
            }
        } catch (zzhdd e13) {
            zzD(str, e13);
        }
    }
}
