package com.cloud.hisavana.protocol.okhttptransport;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.t;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.c0;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.u;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;
import q9.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f29065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f29066b;

    /* JADX INFO: renamed from: com.cloud.hisavana.protocol.okhttptransport.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class C0319a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29067a;

        static {
            int[] iArr = new int[UploadBodyDataBroker.ReadResult.values().length];
            f29067a = iArr;
            try {
                iArr[UploadBodyDataBroker.ReadResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29067a[UploadBodyDataBroker.ReadResult.END_OF_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements e {

        /* JADX INFO: renamed from: com.cloud.hisavana.protocol.okhttptransport.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0320a extends UploadDataProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public volatile boolean f29068a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Buffer f29069b = new Buffer();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f29070c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RequestBody f29071d;

            public C0320a(long j11, RequestBody requestBody) {
                this.f29070c = j11;
                this.f29071d = requestBody;
            }

            @Override // org.chromium.net.UploadDataProvider
            public long getLength() {
                return this.f29070c;
            }

            @Override // org.chromium.net.UploadDataProvider
            public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
                if (!this.f29068a) {
                    this.f29071d.writeTo(this.f29069b);
                    this.f29069b.flush();
                    this.f29068a = true;
                    long length = getLength();
                    long size = this.f29069b.size();
                    if (size != length) {
                        throw new IOException("Expected " + length + " bytes but got " + size);
                    }
                }
                if (this.f29069b.read(byteBuffer) == -1) {
                    throw new IllegalStateException("The source has been exhausted but we expected more!");
                }
                uploadDataSink.onReadSucceeded(false);
            }

            @Override // org.chromium.net.UploadDataProvider
            public void rewind(UploadDataSink uploadDataSink) {
                uploadDataSink.onRewindError(new UnsupportedOperationException());
            }
        }

        @Override // q9.e
        public UploadDataProvider a(RequestBody requestBody, int i11) throws IOException {
            long jContentLength = requestBody.contentLength();
            if (jContentLength >= 0 && jContentLength <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                return new C0320a(jContentLength, requestBody);
            }
            throw new IOException("Expected definite length less than 1048576but got " + jContentLength);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f29073a;

        /* JADX INFO: renamed from: com.cloud.hisavana.protocol.okhttptransport.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0321a extends UploadDataProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final RequestBody f29074a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final UploadBodyDataBroker f29075b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final u f29076c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final long f29077d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public s<?> f29078f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public long f29079g;

            /* JADX INFO: renamed from: com.cloud.hisavana.protocol.okhttptransport.a$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0322a implements o<Object> {
                public C0322a() {
                }

                @Override // com.google.common.util.concurrent.o
                public void a(Throwable th2) {
                    C0321a.this.f29075b.d(th2);
                }

                @Override // com.google.common.util.concurrent.o
                public void onSuccess(Object obj) {
                }
            }

            public C0321a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j11) {
                this.f29074a = requestBody;
                this.f29075b = uploadBodyDataBroker;
                if (executorService instanceof u) {
                    this.f29076c = (u) executorService;
                } else {
                    this.f29076c = MoreExecutors.b(executorService);
                }
                this.f29077d = j11 == 0 ? 2147483647L : j11;
            }

            public /* synthetic */ C0321a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j11, C0319a c0319a) {
                this(requestBody, uploadBodyDataBroker, executorService, j11);
            }

            public static IOException g(long j11, long j12) {
                return new IOException("Expected " + j11 + " bytes but got at least " + j12);
            }

            public final void c() {
                if (this.f29078f == null) {
                    s<?> sVarSubmit = this.f29076c.submit(new Callable() { // from class: q9.f
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.f74467a.e();
                        }
                    });
                    this.f29078f = sVarSubmit;
                    Futures.a(sVarSubmit, new C0322a(), MoreExecutors.a());
                }
            }

            public final void d(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws ExecutionException, TimeoutException, IOException {
                int iPosition = byteBuffer.position();
                byteBuffer.position(0);
                if (!h(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY)) {
                    throw g(getLength(), this.f29079g);
                }
                t.a(byteBuffer.position() == 0, "END_OF_BODY reads shouldn't write anything to the buffer", new Object[0]);
                byteBuffer.position(iPosition);
                uploadDataSink.onReadSucceeded(false);
            }

            public final /* synthetic */ Void e() throws Exception {
                BufferedSink bufferedSinkBuffer = Okio.buffer(this.f29075b);
                this.f29074a.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.flush();
                this.f29075b.c();
                return null;
            }

            @Override // org.chromium.net.UploadDataProvider
            public long getLength() throws IOException {
                return this.f29074a.contentLength();
            }

            public final UploadBodyDataBroker.ReadResult h(ByteBuffer byteBuffer) throws ExecutionException, TimeoutException {
                int iPosition = byteBuffer.position();
                UploadBodyDataBroker.ReadResult readResult = (UploadBodyDataBroker.ReadResult) c0.b(this.f29075b.a(byteBuffer), this.f29077d, TimeUnit.MILLISECONDS);
                this.f29079g += (long) (byteBuffer.position() - iPosition);
                return readResult;
            }

            public final void i(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
                try {
                    UploadBodyDataBroker.ReadResult readResultH = h(byteBuffer);
                    if (this.f29079g > getLength()) {
                        throw g(getLength(), this.f29079g);
                    }
                    if (this.f29079g >= getLength()) {
                        d(uploadDataSink, byteBuffer);
                        return;
                    }
                    int i11 = C0319a.f29067a[readResultH.ordinal()];
                    if (i11 == 1) {
                        uploadDataSink.onReadSucceeded(false);
                    } else if (i11 == 2) {
                        throw new IOException("The source has been exhausted but we expected more data!");
                    }
                } catch (ExecutionException e11) {
                    e = e11;
                    this.f29078f.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                } catch (TimeoutException e12) {
                    e = e12;
                    this.f29078f.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                }
            }

            public final void j(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                try {
                    uploadDataSink.onReadSucceeded(h(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY));
                } catch (ExecutionException | TimeoutException e11) {
                    this.f29078f.cancel(true);
                    uploadDataSink.onReadError(new IOException(e11));
                }
            }

            @Override // org.chromium.net.UploadDataProvider
            public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
                c();
                if (getLength() == -1) {
                    j(uploadDataSink, byteBuffer);
                } else {
                    i(uploadDataSink, byteBuffer);
                }
            }

            @Override // org.chromium.net.UploadDataProvider
            public void rewind(UploadDataSink uploadDataSink) {
                uploadDataSink.onRewindError(new UnsupportedOperationException("Rewind is not supported!"));
            }
        }

        public c(ExecutorService executorService) {
            this.f29073a = executorService;
        }

        @Override // q9.e
        public UploadDataProvider a(RequestBody requestBody, int i11) {
            return new C0321a(requestBody, new UploadBodyDataBroker(), this.f29073a, i11, null);
        }
    }

    public a(b bVar, c cVar) {
        this.f29065a = bVar;
        this.f29066b = cVar;
    }

    public static a b(ExecutorService executorService) {
        return new a(new b(), new c(executorService));
    }

    @Override // q9.e
    public UploadDataProvider a(RequestBody requestBody, int i11) throws IOException {
        long jContentLength = requestBody.contentLength();
        return (jContentLength == -1 || jContentLength > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) ? this.f29066b.a(requestBody, i11) : this.f29065a.a(requestBody, i11);
    }
}
