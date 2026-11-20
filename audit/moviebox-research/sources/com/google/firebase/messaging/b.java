package com.google.firebase.messaging;

import com.google.android.gms.common.api.Api;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f40821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f40822b;

        public a(InputStream inputStream, long j11) {
            super(inputStream);
            this.f40822b = -1L;
            this.f40821a = j11;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f40821a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i11) {
            ((FilterInputStream) this).in.mark(i11);
            this.f40822b = this.f40821a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f40821a == 0) {
                return -1;
            }
            int i11 = ((FilterInputStream) this).in.read();
            if (i11 != -1) {
                this.f40821a--;
            }
            return i11;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            long j11 = this.f40821a;
            if (j11 == 0) {
                return -1;
            }
            int i13 = ((FilterInputStream) this).in.read(bArr, i11, (int) Math.min(i12, j11));
            if (i13 != -1) {
                this.f40821a -= (long) i13;
            }
            return i13;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f40822b == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f40821a = this.f40822b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j11) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(j11, this.f40821a));
            this.f40821a -= jSkip;
            return jSkip;
        }
    }

    public static byte[] a(Queue<byte[]> queue, int i11) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArrRemove = queue.remove();
        if (bArrRemove.length == i11) {
            return bArrRemove;
        }
        int length = i11 - bArrRemove.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArrRemove, i11);
        while (length > 0) {
            byte[] bArrRemove2 = queue.remove();
            int iMin = Math.min(length, bArrRemove2.length);
            System.arraycopy(bArrRemove2, 0, bArrCopyOf, i11 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static InputStream b(InputStream inputStream, long j11) {
        return new a(inputStream, j11);
    }

    public static int c(long j11) {
        if (j11 > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (j11 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j11;
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        return e(inputStream, new ArrayDeque(20), 0);
    }

    public static byte[] e(InputStream inputStream, Queue<byte[]> queue, int i11) throws IOException {
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(i11) * 2));
        while (i11 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i11);
            byte[] bArr = new byte[iMin2];
            queue.add(bArr);
            int i12 = 0;
            while (i12 < iMin2) {
                int i13 = inputStream.read(bArr, i12, iMin2 - i12);
                if (i13 == -1) {
                    return a(queue, i11);
                }
                i12 += i13;
                i11 += i13;
            }
            iMin = c(((long) iMin) * ((long) (iMin < 4096 ? 4 : 2)));
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
