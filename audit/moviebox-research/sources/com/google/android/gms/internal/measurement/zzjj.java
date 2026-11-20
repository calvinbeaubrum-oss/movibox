package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzjj extends zzjm {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzjj(byte[] bArr, int i11, int i12) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int length = bArr.length;
        if (((length - i12) | i12) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i12)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i12;
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzb(byte b11) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i11 = this.zzd;
            this.zzd = i11 + 1;
            bArr[i11] = b11;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e11);
        }
    }

    public final void zzc(byte[] bArr, int i11, int i12) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i12);
            this.zzd += i12;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i12)), e11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzd(int i11, boolean z11) throws IOException {
        zzq(i11 << 3);
        zzb(z11 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zze(int i11, zzje zzjeVar) throws IOException {
        zzq((i11 << 3) | 2);
        zzq(zzjeVar.zzd());
        zzjeVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzf(int i11, int i12) throws IOException {
        zzq((i11 << 3) | 5);
        zzg(i12);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzg(int i11) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i12 = this.zzd;
            bArr[i12] = (byte) (i11 & 255);
            bArr[i12 + 1] = (byte) ((i11 >> 8) & 255);
            bArr[i12 + 2] = (byte) ((i11 >> 16) & 255);
            this.zzd = i12 + 4;
            bArr[i12 + 3] = (byte) ((i11 >> 24) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzh(int i11, long j11) throws IOException {
        zzq((i11 << 3) | 1);
        zzi(j11);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzi(long j11) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i11 = this.zzd;
            bArr[i11] = (byte) (((int) j11) & 255);
            bArr[i11 + 1] = (byte) (((int) (j11 >> 8)) & 255);
            bArr[i11 + 2] = (byte) (((int) (j11 >> 16)) & 255);
            bArr[i11 + 3] = (byte) (((int) (j11 >> 24)) & 255);
            bArr[i11 + 4] = (byte) (((int) (j11 >> 32)) & 255);
            bArr[i11 + 5] = (byte) (((int) (j11 >> 40)) & 255);
            bArr[i11 + 6] = (byte) (((int) (j11 >> 48)) & 255);
            this.zzd = i11 + 8;
            bArr[i11 + 7] = (byte) (((int) (j11 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzj(int i11, int i12) throws IOException {
        zzq(i11 << 3);
        zzk(i12);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzk(int i11) throws IOException {
        if (i11 >= 0) {
            zzq(i11);
        } else {
            zzs(i11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzl(byte[] bArr, int i11, int i12) throws IOException {
        zzc(bArr, 0, i12);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzm(int i11, String str) throws IOException {
        zzq((i11 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i11 = this.zzd;
        try {
            int iZzA = zzjm.zzA(str.length() * 3);
            int iZzA2 = zzjm.zzA(str.length());
            if (iZzA2 != iZzA) {
                zzq(zznd.zzc(str));
                byte[] bArr = this.zzb;
                int i12 = this.zzd;
                this.zzd = zznd.zzb(str, bArr, i12, this.zzc - i12);
                return;
            }
            int i13 = i11 + iZzA2;
            this.zzd = i13;
            int iZzb = zznd.zzb(str, this.zzb, i13, this.zzc - i13);
            this.zzd = i11;
            zzq((iZzb - i11) - iZzA2);
            this.zzd = iZzb;
        } catch (zznc e11) {
            this.zzd = i11;
            zzE(str, e11);
        } catch (IndexOutOfBoundsException e12) {
            throw new zzjk(e12);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzo(int i11, int i12) throws IOException {
        zzq((i11 << 3) | i12);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzp(int i11, int i12) throws IOException {
        zzq(i11 << 3);
        zzq(i12);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzq(int i11) throws IOException {
        while ((i11 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i12 = this.zzd;
                this.zzd = i12 + 1;
                bArr[i12] = (byte) ((i11 & 127) | 128);
                i11 >>>= 7;
            } catch (IndexOutOfBoundsException e11) {
                throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e11);
            }
        }
        byte[] bArr2 = this.zzb;
        int i13 = this.zzd;
        this.zzd = i13 + 1;
        bArr2[i13] = (byte) i11;
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzr(int i11, long j11) throws IOException {
        zzq(i11 << 3);
        zzs(j11);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzs(long j11) throws IOException {
        if (zzjm.zzc && this.zzc - this.zzd >= 10) {
            while ((j11 & (-128)) != 0) {
                byte[] bArr = this.zzb;
                int i11 = this.zzd;
                this.zzd = i11 + 1;
                zzmy.zzn(bArr, i11, (byte) ((((int) j11) & 127) | 128));
                j11 >>>= 7;
            }
            byte[] bArr2 = this.zzb;
            int i12 = this.zzd;
            this.zzd = i12 + 1;
            zzmy.zzn(bArr2, i12, (byte) j11);
            return;
        }
        while ((j11 & (-128)) != 0) {
            try {
                byte[] bArr3 = this.zzb;
                int i13 = this.zzd;
                this.zzd = i13 + 1;
                bArr3[i13] = (byte) ((((int) j11) & 127) | 128);
                j11 >>>= 7;
            } catch (IndexOutOfBoundsException e11) {
                throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e11);
            }
        }
        byte[] bArr4 = this.zzb;
        int i14 = this.zzd;
        this.zzd = i14 + 1;
        bArr4[i14] = (byte) j11;
    }
}
