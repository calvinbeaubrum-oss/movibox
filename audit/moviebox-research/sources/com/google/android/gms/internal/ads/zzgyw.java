package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyw extends zzgza {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    public zzgyw(byte[] bArr, int i11, int i12) {
        super(null);
        int length = bArr.length;
        if (((length - i12) | i12) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i12)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i12;
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzH() {
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzI(byte b11) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i11 = this.zzc;
            this.zzc = i11 + 1;
            bArr[i11] = b11;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzJ(int i11, boolean z11) throws IOException {
        zzs(i11 << 3);
        zzI(z11 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzK(int i11, zzgyl zzgylVar) throws IOException {
        zzs((i11 << 3) | 2);
        zzs(zzgylVar.zzd());
        zzgylVar.zzo(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgza, com.google.android.gms.internal.ads.zzgya
    public final void zza(byte[] bArr, int i11, int i12) throws IOException {
        zze(bArr, i11, i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i11, int i12) throws IOException {
        try {
            System.arraycopy(bArr, i11, this.zza, this.zzc, i12);
            this.zzc += i12;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i12)), e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzh(int i11, int i12) throws IOException {
        zzs((i11 << 3) | 5);
        zzi(i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzi(int i11) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i12 = this.zzc;
            bArr[i12] = (byte) (i11 & 255);
            bArr[i12 + 1] = (byte) ((i11 >> 8) & 255);
            bArr[i12 + 2] = (byte) ((i11 >> 16) & 255);
            this.zzc = i12 + 4;
            bArr[i12 + 3] = (byte) ((i11 >> 24) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzj(int i11, long j11) throws IOException {
        zzs((i11 << 3) | 1);
        zzk(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzk(long j11) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i11 = this.zzc;
            bArr[i11] = (byte) (((int) j11) & 255);
            bArr[i11 + 1] = (byte) (((int) (j11 >> 8)) & 255);
            bArr[i11 + 2] = (byte) (((int) (j11 >> 16)) & 255);
            bArr[i11 + 3] = (byte) (((int) (j11 >> 24)) & 255);
            bArr[i11 + 4] = (byte) (((int) (j11 >> 32)) & 255);
            bArr[i11 + 5] = (byte) (((int) (j11 >> 40)) & 255);
            bArr[i11 + 6] = (byte) (((int) (j11 >> 48)) & 255);
            this.zzc = i11 + 8;
            bArr[i11 + 7] = (byte) (((int) (j11 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzl(int i11, int i12) throws IOException {
        zzs(i11 << 3);
        zzm(i12);
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
        zzp(str);
    }

    public final void zzp(String str) throws IOException {
        int i11 = this.zzc;
        try {
            int iZzz = zzgza.zzz(str.length() * 3);
            int iZzz2 = zzgza.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzs(zzhde.zze(str));
                byte[] bArr = this.zza;
                int i12 = this.zzc;
                this.zzc = zzhde.zzd(str, bArr, i12, this.zzb - i12);
                return;
            }
            int i13 = i11 + iZzz2;
            this.zzc = i13;
            int iZzd = zzhde.zzd(str, this.zza, i13, this.zzb - i13);
            this.zzc = i11;
            zzs((iZzd - i11) - iZzz2);
            this.zzc = iZzd;
        } catch (zzhdd e11) {
            this.zzc = i11;
            zzD(str, e11);
        } catch (IndexOutOfBoundsException e12) {
            throw new zzgyx(e12);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzq(int i11, int i12) throws IOException {
        zzs((i11 << 3) | i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzr(int i11, int i12) throws IOException {
        zzs(i11 << 3);
        zzs(i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzs(int i11) throws IOException {
        while ((i11 & (-128)) != 0) {
            try {
                byte[] bArr = this.zza;
                int i12 = this.zzc;
                this.zzc = i12 + 1;
                bArr[i12] = (byte) ((i11 | 128) & 255);
                i11 >>>= 7;
            } catch (IndexOutOfBoundsException e11) {
                throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e11);
            }
        }
        byte[] bArr2 = this.zza;
        int i13 = this.zzc;
        this.zzc = i13 + 1;
        bArr2[i13] = (byte) i11;
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzt(int i11, long j11) throws IOException {
        zzs(i11 << 3);
        zzu(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzgza
    public final void zzu(long j11) throws IOException {
        if (!zzgza.zzb || this.zzb - this.zzc < 10) {
            while ((j11 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zza;
                    int i11 = this.zzc;
                    this.zzc = i11 + 1;
                    bArr[i11] = (byte) ((((int) j11) | 128) & 255);
                    j11 >>>= 7;
                } catch (IndexOutOfBoundsException e11) {
                    throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e11);
                }
            }
            byte[] bArr2 = this.zza;
            int i12 = this.zzc;
            this.zzc = i12 + 1;
            bArr2[i12] = (byte) j11;
            return;
        }
        while (true) {
            int i13 = (int) j11;
            if ((j11 & (-128)) == 0) {
                byte[] bArr3 = this.zza;
                int i14 = this.zzc;
                this.zzc = i14 + 1;
                zzhcz.zzq(bArr3, i14, (byte) i13);
                return;
            }
            byte[] bArr4 = this.zza;
            int i15 = this.zzc;
            this.zzc = i15 + 1;
            zzhcz.zzq(bArr4, i15, (byte) ((i13 | 128) & 255));
            j11 >>>= 7;
        }
    }
}
