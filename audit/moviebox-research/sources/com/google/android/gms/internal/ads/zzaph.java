package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaph {
    public static long zza(ByteBuffer byteBuffer) {
        zzg(byteBuffer);
        return zze(byteBuffer, byteBuffer.position() + 16);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        zzg(byteBuffer);
        return zze(byteBuffer, byteBuffer.position() + 12);
    }

    public static Pair zzc(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair pairZzf = zzf(randomAccessFile, 0);
        return pairZzf != null ? pairZzf : zzf(randomAccessFile, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
    }

    public static void zzd(ByteBuffer byteBuffer, long j11) {
        zzg(byteBuffer);
        int iPosition = byteBuffer.position() + 16;
        if (j11 >= 0 && j11 <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + iPosition, (int) j11);
            return;
        }
        throw new IllegalArgumentException("uint32 value of out range: " + j11);
    }

    private static long zze(ByteBuffer byteBuffer, int i11) {
        return ((long) byteBuffer.getInt(i11)) & 4294967295L;
    }

    private static Pair zzf(RandomAccessFile randomAccessFile, int i11) throws IOException {
        int i12;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i11, (-22) + length)) + 22);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        zzg(byteBufferAllocate);
        int iCapacity = byteBufferAllocate.capacity();
        if (iCapacity >= 22) {
            int i13 = iCapacity - 22;
            int iMin = Math.min(i13, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            int i14 = 0;
            while (true) {
                if (i14 >= iMin) {
                    i12 = -1;
                    break;
                }
                i12 = i13 - i14;
                if (byteBufferAllocate.getInt(i12) == 101010256 && ((char) byteBufferAllocate.getShort(i12 + 20)) == i14) {
                    break;
                }
                i14++;
            }
        } else {
            i12 = -1;
            break;
        }
        if (i12 == -1) {
            return null;
        }
        byteBufferAllocate.position(i12);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) i12)));
    }

    private static void zzg(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
