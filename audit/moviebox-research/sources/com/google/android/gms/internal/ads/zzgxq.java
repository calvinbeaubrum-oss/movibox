package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgxq {
    private final byte[] zza;

    private zzgxq(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i12);
    }

    public static zzgxq zzb(byte[] bArr) {
        if (bArr != null) {
            return new zzgxq(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgxq) {
            return Arrays.equals(((zzgxq) obj).zza, this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return "Bytes(" + zzgxi.zza(this.zza) + ")";
    }

    public final int zza() {
        return this.zza.length;
    }

    public final byte[] zzc() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
