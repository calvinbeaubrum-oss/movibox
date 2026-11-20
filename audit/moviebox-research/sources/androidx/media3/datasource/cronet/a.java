package androidx.media3.datasource.cronet;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends UploadDataProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f9774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9775b;

    public a(byte[] bArr) {
        this.f9774a = bArr;
    }

    @Override // org.chromium.net.UploadDataProvider
    public long getLength() {
        return this.f9774a.length;
    }

    @Override // org.chromium.net.UploadDataProvider
    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
        int iMin = Math.min(byteBuffer.remaining(), this.f9774a.length - this.f9775b);
        byteBuffer.put(this.f9774a, this.f9775b, iMin);
        this.f9775b += iMin;
        uploadDataSink.onReadSucceeded(false);
    }

    @Override // org.chromium.net.UploadDataProvider
    public void rewind(UploadDataSink uploadDataSink) throws IOException {
        this.f9775b = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
