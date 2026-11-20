package com.bykv.vk.openvk.preload.geckox.buffer.a;

import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.bykv.vk.openvk.preload.geckox.buffer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RandomAccessFile f25744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f25745b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f25746c;

    private a(File file) throws IOException {
        this.f25746c = file;
        file.getParentFile().mkdirs();
        try {
            this.f25744a = new RandomAccessFile(file, "rw");
        } catch (Exception e11) {
            CloseableUtils.close(this.f25744a);
            throw new IOException("create raf mSwap failed! path: " + file.getAbsolutePath() + " caused by: " + e11.getMessage(), e11);
        }
    }

    public static com.bykv.vk.openvk.preload.geckox.buffer.a a(File file, long j11) throws IOException {
        com.bykv.vk.openvk.preload.geckox.buffer.a aVarB = b(file, j11);
        GeckoLogger.d("gecko-debug-tag", "buffer type:" + aVarB.getClass());
        return aVarB;
    }

    private static com.bykv.vk.openvk.preload.geckox.buffer.a b(File file, long j11) throws IOException {
        if (j11 <= 0) {
            try {
                return new a(file);
            } catch (Exception e11) {
                throw new IOException("create FileBuffer failed! file:" + file.getAbsolutePath() + " caused by:" + e11.getMessage(), e11);
            }
        }
        try {
            return new b(j11, file);
        } catch (Exception e12) {
            throw new RuntimeException("create random access file failed! file:" + file.getAbsolutePath() + " caused by:" + e12.getMessage(), e12);
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int a(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f25745b.get()) {
            throw new IOException("released!");
        }
        if (bArr == null || bArr.length == 0 || i12 <= 0 || i11 < 0 || i11 >= bArr.length) {
            return 0;
        }
        if (i11 + i12 > bArr.length) {
            i12 = bArr.length - i11;
        }
        synchronized (this) {
            this.f25744a.write(bArr, i11, i12);
        }
        return i12;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final synchronized long a(long j11) throws IOException {
        int i11;
        if (this.f25745b.get()) {
            throw new IOException("released!");
        }
        i11 = (int) j11;
        if (i11 != j11) {
            throw new IOException("too large:".concat(String.valueOf(j11)));
        }
        return this.f25744a.skipBytes(i11);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a() throws IOException {
        if (this.f25745b.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a(int i11) throws IOException {
        a(new byte[]{(byte) i11});
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int b(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (this.f25745b.get()) {
            throw new IOException("released!");
        }
        if (bArr == null || i12 <= 0 || i11 < 0 || i11 >= bArr.length) {
            return 0;
        }
        if (i11 + i12 > bArr.length) {
            i12 = bArr.length - i11;
        }
        synchronized (this) {
            i13 = this.f25744a.read(bArr, i11, i12);
        }
        return i13;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long b() throws IOException {
        return this.f25744a.length();
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void b(long j11) throws IOException {
        if (this.f25745b.get()) {
            throw new IOException("released!");
        }
        if (j11 < 0) {
            j11 = 0;
        }
        this.f25744a.seek(j11);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long c() throws IOException {
        if (this.f25745b.get()) {
            throw new IOException("released!");
        }
        return this.f25744a.getFilePointer();
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) <= 0) {
            return -1;
        }
        return bArr[0];
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void e() {
        if (this.f25745b.getAndSet(true)) {
            return;
        }
        CloseableUtils.close(this.f25744a);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final File f() {
        return this.f25746c;
    }
}
