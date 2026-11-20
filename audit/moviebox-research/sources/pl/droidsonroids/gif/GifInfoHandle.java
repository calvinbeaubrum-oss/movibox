package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class GifInfoHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f73908a;

    static {
        g.b();
    }

    public GifInfoHandle() {
    }

    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.f73908a = q(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    public GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.f73908a = q(fileDescriptor, 0L, true);
    }

    public GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("InputStream does not support marking");
        }
        this.f73908a = openStream(inputStream);
    }

    public GifInfoHandle(String str) throws GifIOException {
        this.f73908a = openFile(str);
    }

    public GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.f73908a = openDirectByteBuffer(byteBuffer);
    }

    public GifInfoHandle(byte[] bArr) throws GifIOException {
        this.f73908a = openByteArray(bArr);
    }

    private static native void bindSurface(long j11, Surface surface, long[] jArr);

    public static native int createTempNativeFileDescriptor() throws GifIOException;

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z11) throws GifIOException;

    private static native void free(long j11);

    private static native long getAllocationByteCount(long j11);

    private static native int getCurrentFrameIndex(long j11);

    private static native int getCurrentLoop(long j11);

    private static native int getCurrentPosition(long j11);

    private static native int getDuration(long j11);

    private static native int getHeight(long j11);

    private static native int getLoopCount(long j11);

    private static native long getMetadataByteCount(long j11);

    private static native int getNativeErrorCode(long j11);

    private static native int getNumberOfFrames(long j11);

    private static native long[] getSavedState(long j11);

    private static native int getWidth(long j11);

    private static native boolean isOpaque(long j11);

    @RequiresApi(21)
    public static int k(FileDescriptor fileDescriptor, boolean z11) throws GifIOException, ErrnoException {
        try {
            int iCreateTempNativeFileDescriptor = createTempNativeFileDescriptor();
            Os.dup2(fileDescriptor, iCreateTempNativeFileDescriptor);
            return iCreateTempNativeFileDescriptor;
        } finally {
            if (z11) {
                Os.close(fileDescriptor);
            }
        }
    }

    public static native long openByteArray(byte[] bArr) throws GifIOException;

    public static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    public static native long openFile(String str) throws GifIOException;

    public static native long openNativeFileDescriptor(int i11, long j11) throws GifIOException;

    public static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j11);

    public static long q(FileDescriptor fileDescriptor, long j11, boolean z11) throws GifIOException {
        int iK;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                iK = k(fileDescriptor, z11);
            } catch (Exception e11) {
                throw new GifIOException(GifError.OPEN_FAILED.errorCode, e11.getMessage());
            }
        } else {
            iK = extractNativeFileDescriptor(fileDescriptor, z11);
        }
        return openNativeFileDescriptor(iK, j11);
    }

    public static GifInfoHandle r(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return new GifInfoHandle(assetFileDescriptorOpenAssetFileDescriptor);
        }
        throw new IOException("Could not open AssetFileDescriptor for " + uri);
    }

    private static native long renderFrame(long j11, Bitmap bitmap);

    private static native boolean reset(long j11);

    private static native long restoreRemainder(long j11);

    private static native int restoreSavedState(long j11, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j11);

    private static native void seekToFrame(long j11, int i11, Bitmap bitmap);

    private static native void seekToTime(long j11, int i11, Bitmap bitmap);

    private static native void setLoopCount(long j11, char c11);

    private static native void setOptions(long j11, char c11, boolean z11);

    private static native void setSpeedFactor(long j11, float f11);

    public synchronized void A(int i11, Bitmap bitmap) {
        seekToTime(this.f73908a, i11, bitmap);
    }

    public void B(int i11) {
        if (i11 < 0 || i11 > 65535) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.f73908a, (char) i11);
        }
    }

    public void C(char c11, boolean z11) {
        setOptions(this.f73908a, c11, z11);
    }

    public void D(float f11) {
        if (f11 <= 0.0f || Float.isNaN(f11)) {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        if (f11 < 4.656613E-10f) {
            f11 = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.f73908a, f11);
        }
    }

    public void a(Surface surface, long[] jArr) {
        bindSurface(this.f73908a, surface, jArr);
    }

    public synchronized long b() {
        return getAllocationByteCount(this.f73908a);
    }

    public synchronized int c() {
        return getCurrentFrameIndex(this.f73908a);
    }

    public synchronized int d() {
        return getCurrentLoop(this.f73908a);
    }

    public synchronized int e() {
        return getCurrentPosition(this.f73908a);
    }

    public synchronized int f() {
        return getDuration(this.f73908a);
    }

    public void finalize() throws Throwable {
        try {
            t();
        } finally {
            super.finalize();
        }
    }

    public synchronized int g() {
        return getHeight(this.f73908a);
    }

    public synchronized int h() {
        return getLoopCount(this.f73908a);
    }

    public synchronized long i() {
        return getMetadataByteCount(this.f73908a);
    }

    public synchronized int j() {
        return getNativeErrorCode(this.f73908a);
    }

    public synchronized int l() {
        return getNumberOfFrames(this.f73908a);
    }

    public synchronized long[] m() {
        return getSavedState(this.f73908a);
    }

    public synchronized int n() {
        return getWidth(this.f73908a);
    }

    public synchronized boolean o() {
        return isOpaque(this.f73908a);
    }

    public synchronized boolean p() {
        return this.f73908a == 0;
    }

    public synchronized void s() {
        postUnbindSurface(this.f73908a);
    }

    public synchronized void t() {
        free(this.f73908a);
        this.f73908a = 0L;
    }

    public synchronized long u(Bitmap bitmap) {
        return renderFrame(this.f73908a, bitmap);
    }

    public synchronized boolean v() {
        return reset(this.f73908a);
    }

    public synchronized long w() {
        return restoreRemainder(this.f73908a);
    }

    public synchronized int x(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f73908a, jArr, bitmap);
    }

    public synchronized void y() {
        saveRemainder(this.f73908a);
    }

    public synchronized void z(int i11, Bitmap bitmap) {
        seekToFrame(this.f73908a, i11, bitmap);
    }
}
