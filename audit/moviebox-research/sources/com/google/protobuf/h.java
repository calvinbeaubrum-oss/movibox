package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<SoftReference<byte[]>> f41278a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f41279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f41280c;

    static {
        Class<?> clsE = e("java.io.FileOutputStream");
        f41279b = clsE;
        f41280c = b(clsE);
    }

    public static byte[] a() {
        SoftReference<byte[]> softReference = f41278a.get();
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public static long b(Class<?> cls) {
        if (cls == null) {
            return -1L;
        }
        try {
            if (l1.I()) {
                return l1.L(cls.getDeclaredField("channel"));
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static byte[] c(int i11) {
        int iMax = Math.max(i11, 1024);
        byte[] bArrA = a();
        if (bArrA == null || d(iMax, bArrA.length)) {
            bArrA = new byte[iMax];
            if (iMax <= 16384) {
                f(bArrA);
            }
        }
        return bArrA;
    }

    public static boolean d(int i11, int i12) {
        return i12 < i11 && ((float) i12) < ((float) i11) * 0.5f;
    }

    public static Class<?> e(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static void f(byte[] bArr) {
        f41278a.set(new SoftReference<>(bArr));
    }

    public static void g(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        int iPosition = byteBuffer.position();
        try {
            if (byteBuffer.hasArray()) {
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            } else if (!h(byteBuffer, outputStream)) {
                byte[] bArrC = c(byteBuffer.remaining());
                while (byteBuffer.hasRemaining()) {
                    int iMin = Math.min(byteBuffer.remaining(), bArrC.length);
                    byteBuffer.get(bArrC, 0, iMin);
                    outputStream.write(bArrC, 0, iMin);
                }
            }
        } finally {
            byteBuffer.position(iPosition);
        }
    }

    public static boolean h(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        WritableByteChannel writableByteChannel;
        long j11 = f41280c;
        if (j11 < 0 || !f41279b.isInstance(outputStream)) {
            return false;
        }
        try {
            writableByteChannel = (WritableByteChannel) l1.G(outputStream, j11);
        } catch (ClassCastException unused) {
            writableByteChannel = null;
        }
        if (writableByteChannel == null) {
            return false;
        }
        writableByteChannel.write(byteBuffer);
        return true;
    }
}
