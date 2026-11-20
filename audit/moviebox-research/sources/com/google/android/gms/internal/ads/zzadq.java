package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadq {
    public static int zza(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static int zzb(ByteBuffer byteBuffer) {
        int i11;
        if ((byteBuffer.get(5) & 2) == 0) {
            i11 = 0;
        } else {
            byte b11 = byteBuffer.get(26);
            int i12 = 28;
            int i13 = 28;
            for (int i14 = 0; i14 < b11; i14++) {
                i13 += byteBuffer.get(i14 + 27);
            }
            byte b12 = byteBuffer.get(i13 + 26);
            for (int i15 = 0; i15 < b12; i15++) {
                i12 += byteBuffer.get(i13 + 27 + i15);
            }
            i11 = i13 + i12;
        }
        int i16 = byteBuffer.get(i11 + 26) + Ascii.ESC + i11;
        return (int) ((zzg(byteBuffer.get(i16), byteBuffer.limit() - i16 > 1 ? byteBuffer.get(i16 + 1) : (byte) 0) * 48000) / 1000000);
    }

    public static int zzc(ByteBuffer byteBuffer) {
        return (int) ((zzg(byteBuffer.get(0), byteBuffer.limit() > 1 ? byteBuffer.get(1) : (byte) 0) * 48000) / 1000000);
    }

    public static long zzd(byte[] bArr) {
        return zzg(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0);
    }

    public static List zze(byte[] bArr) {
        long jZza = zza(bArr);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(zzi(zzh(jZza)));
        arrayList.add(zzi(zzh(3840L)));
        return arrayList;
    }

    public static boolean zzf(long j11, long j12) {
        return j11 - j12 <= zzh(3840L) / 1000;
    }

    private static long zzg(byte b11, byte b12) {
        int i11;
        int i12;
        int i13 = b11 & 255;
        int i14 = b11 & 3;
        if (i14 != 0) {
            i11 = 2;
            if (i14 != 1 && i14 != 2) {
                i11 = b12 & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            i11 = 1;
        }
        int i15 = i13 >> 3;
        int i16 = i15 & 3;
        if (i15 >= 16) {
            i12 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << i16;
        } else if (i15 >= 12) {
            i12 = 10000 << (i15 & 1);
        } else {
            i12 = i16 == 3 ? 60000 : 10000 << i16;
        }
        return ((long) i11) * ((long) i12);
    }

    private static long zzh(long j11) {
        return (j11 * C.NANOS_PER_SECOND) / 48000;
    }

    private static byte[] zzi(long j11) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j11).array();
    }
}
