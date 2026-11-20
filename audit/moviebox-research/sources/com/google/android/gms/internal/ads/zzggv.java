package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzggv implements Comparable {
    private final byte[] zza;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzggv zzggvVar = (zzggv) obj;
        int length = this.zza.length;
        int length2 = zzggvVar.zza.length;
        if (length != length2) {
            return length - length2;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i11 >= bArr.length) {
                return 0;
            }
            byte b11 = bArr[i11];
            byte b12 = zzggvVar.zza[i11];
            if (b11 != b12) {
                return b11 - b12;
            }
            i11++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzggv) {
            return Arrays.equals(this.zza, ((zzggv) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzgxi.zza(this.zza);
    }
}
