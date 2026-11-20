package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgci {
    private static final OutputStream zza = new zzgcg();

    public static InputStream zza(InputStream inputStream, long j11) {
        return new zzgch(inputStream, j11);
    }

    public static byte[] zzb(InputStream inputStream) throws IOException {
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iHighestOneBit = Integer.highestOneBit(0);
        int iMin = Math.min(8192, Math.max(128, iHighestOneBit + iHighestOneBit));
        int i11 = 0;
        while (i11 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i11);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i12 = 0;
            while (i12 < iMin2) {
                int i13 = inputStream.read(bArr, i12, iMin2 - i12);
                if (i13 == -1) {
                    return zzc(arrayDeque, i11);
                }
                i12 += i13;
                i11 += i13;
            }
            iMin = zzgcu.zzc(((long) iMin) * ((long) (iMin < 4096 ? 4 : 2)));
        }
        if (inputStream.read() == -1) {
            return zzc(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] zzc(Queue queue, int i11) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        int length = bArr.length;
        if (length == i11) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i11);
        int i12 = i11 - length;
        while (i12 > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(i12, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i11 - i12, iMin);
            i12 -= iMin;
        }
        return bArrCopyOf;
    }
}
