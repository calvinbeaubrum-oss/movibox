package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarl {
    public static double zza(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i11 = bArr[0] << Ascii.CAN;
        int i12 = bArr[1] << Ascii.DLE;
        int i13 = bArr[2] << 8;
        return ((double) ((((i11 & ViewCompat.MEASURED_STATE_MASK) | (i12 & 16711680)) | (65280 & i13)) | (bArr[3] & 255))) / 1.073741824E9d;
    }

    public static double zzb(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i11 = bArr[0] << Ascii.CAN;
        int i12 = bArr[1] << Ascii.DLE;
        int i13 = bArr[2] << 8;
        return ((double) ((((i11 & ViewCompat.MEASURED_STATE_MASK) | (i12 & 16711680)) | (65280 & i13)) | (bArr[3] & 255))) / 65536.0d;
    }

    public static int zzc(byte b11) {
        return b11 < 0 ? b11 + Ascii.NUL : b11;
    }

    public static int zzd(ByteBuffer byteBuffer) {
        return (zzc(byteBuffer.get()) << 8) + zzc(byteBuffer.get());
    }

    public static long zze(ByteBuffer byteBuffer) {
        long j11 = byteBuffer.getInt();
        return j11 < 0 ? j11 + 4294967296L : j11;
    }

    public static long zzf(ByteBuffer byteBuffer) {
        long jZze = zze(byteBuffer) << 32;
        if (jZze >= 0) {
            return jZze + zze(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }
}
