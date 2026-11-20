package b30;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: b30.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0140a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f14003a;

        public C0140a(File file) {
            this.f14003a = file;
        }

        @Override // b30.a.d
        public FileChannel a() throws IOException {
            return new FileInputStream(this.f14003a).getChannel();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptor f14004a;

        public b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f14004a = parcelFileDescriptor;
        }

        @Override // b30.a.d
        public FileChannel a() throws IOException {
            if (this.f14004a.getStatSize() != -1) {
                return new ParcelFileDescriptor.AutoCloseInputStream(this.f14004a).getChannel();
            }
            this.f14004a.close();
            throw new IllegalArgumentException("Not a file: " + this.f14004a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends UploadDataProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f14005a;

        public c(ByteBuffer byteBuffer) {
            this.f14005a = byteBuffer;
        }

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() {
            return this.f14005a.limit();
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            if (byteBuffer.remaining() >= this.f14005a.remaining()) {
                byteBuffer.put(this.f14005a);
            } else {
                int iLimit = this.f14005a.limit();
                ByteBuffer byteBuffer2 = this.f14005a;
                byteBuffer.put(this.f14005a);
            }
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            uploadDataSink.onRewindSucceeded();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        FileChannel a() throws IOException;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends UploadDataProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile FileChannel f14006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f14007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f14008c;

        public e(d dVar) {
            this.f14008c = new Object();
            this.f14007b = dVar;
        }

        public final FileChannel a() throws IOException {
            if (this.f14006a == null) {
                synchronized (this.f14008c) {
                    try {
                        if (this.f14006a == null) {
                            this.f14006a = this.f14007b.a();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return this.f14006a;
        }

        @Override // org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            FileChannel fileChannel = this.f14006a;
            if (fileChannel != null) {
                fileChannel.close();
            }
        }

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() throws IOException {
            return a().size();
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            FileChannel fileChannelA = a();
            int i11 = 0;
            while (i11 == 0) {
                int i12 = fileChannelA.read(byteBuffer);
                if (i12 == -1) {
                    break;
                } else {
                    i11 += i12;
                }
            }
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) throws IOException {
            a().position(0L);
            uploadDataSink.onRewindSucceeded();
        }
    }

    public static UploadDataProvider a(ParcelFileDescriptor parcelFileDescriptor) {
        return new e(new b(parcelFileDescriptor));
    }

    public static UploadDataProvider b(File file) {
        return new e(new C0140a(file));
    }

    public static UploadDataProvider c(ByteBuffer byteBuffer) {
        return new c(byteBuffer.slice());
    }

    public static UploadDataProvider d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static UploadDataProvider e(byte[] bArr, int i11, int i12) {
        return new c(ByteBuffer.wrap(bArr, i11, i12).slice());
    }
}
