package com.google.net.cronet.okhttptransport;

import android.support.v4.media.session.PlaybackStateCompat;
import cm.e;
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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f41127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f41128b;

    /* JADX INFO: renamed from: com.google.net.cronet.okhttptransport.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class C0454a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41129a;

        static {
            int[] iArr = new int[UploadBodyDataBroker.ReadResult.values().length];
            f41129a = iArr;
            try {
                iArr[UploadBodyDataBroker.ReadResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41129a[UploadBodyDataBroker.ReadResult.END_OF_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements e {

        /* JADX INFO: renamed from: com.google.net.cronet.okhttptransport.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0455a extends UploadDataProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public volatile boolean f41130a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Buffer f41131b = new Buffer();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f41132c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RequestBody f41133d;

            public C0455a(long j11, RequestBody requestBody) {
                this.f41132c = j11;
                this.f41133d = requestBody;
            }

            @Override // org.chromium.net.UploadDataProvider
            public long getLength() {
                return this.f41132c;
            }

            @Override // org.chromium.net.UploadDataProvider
            public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
                if (!this.f41130a) {
                    this.f41133d.writeTo(this.f41131b);
                    this.f41131b.flush();
                    this.f41130a = true;
                    long length = getLength();
                    long size = this.f41131b.size();
                    if (size != length) {
                        throw new IOException("Expected " + length + " bytes but got " + size);
                    }
                }
                if (this.f41131b.read(byteBuffer) == -1) {
                    throw new IllegalStateException("The source has been exhausted but we expected more!");
                }
                uploadDataSink.onReadSucceeded(false);
            }

            @Override // org.chromium.net.UploadDataProvider
            public void rewind(UploadDataSink uploadDataSink) {
                uploadDataSink.onRewindError(new UnsupportedOperationException());
            }
        }

        @Override // cm.e
        public UploadDataProvider a(RequestBody requestBody, int i11) throws IOException {
            long jContentLength = requestBody.contentLength();
            if (jContentLength >= 0 && jContentLength <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                return new C0455a(jContentLength, requestBody);
            }
            throw new IOException("Expected definite length less than 1048576but got " + jContentLength);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f41135a;

        /* JADX INFO: renamed from: com.google.net.cronet.okhttptransport.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0456a extends UploadDataProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final RequestBody f41136a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final UploadBodyDataBroker f41137b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final u f41138c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final long f41139d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public s<?> f41140f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public long f41141g;

            /* JADX INFO: renamed from: com.google.net.cronet.okhttptransport.a$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0457a implements o<Object> {
                public C0457a() {
                }

                @Override // com.google.common.util.concurrent.o
                public void a(Throwable th2) {
                    C0456a.this.f41137b.d(th2);
                }

                @Override // com.google.common.util.concurrent.o
                public void onSuccess(Object obj) {
                }
            }

            public C0456a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j11) {
                this.f41136a = requestBody;
                this.f41137b = uploadBodyDataBroker;
                if (executorService instanceof u) {
                    this.f41138c = (u) executorService;
                } else {
                    this.f41138c = MoreExecutors.b(executorService);
                }
                this.f41139d = j11 == 0 ? 2147483647L : j11;
            }

            public /* synthetic */ C0456a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j11, C0454a c0454a) {
                this(requestBody, uploadBodyDataBroker, executorService, j11);
            }

            private void c() {
                if (this.f41140f == null) {
                    s<?> sVarSubmit = this.f41138c.submit(new Callable() { // from class: cm.f
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.f14982a.e();
                        }
                    });
                    this.f41140f = sVarSubmit;
                    Futures.a(sVarSubmit, new C0457a(), MoreExecutors.a());
                }
            }

            private void d(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws ExecutionException, TimeoutException, IOException {
                int iPosition = byteBuffer.position();
                byteBuffer.position(0);
                if (!h(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY)) {
                    throw g(getLength(), this.f41141g);
                }
                t.a(byteBuffer.position() == 0, "END_OF_BODY reads shouldn't write anything to the buffer", new Object[0]);
                byteBuffer.position(iPosition);
                uploadDataSink.onReadSucceeded(false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ Void e() throws Exception {
                BufferedSink bufferedSinkBuffer = Okio.buffer(this.f41137b);
                this.f41136a.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.flush();
                this.f41137b.c();
                return null;
            }

            private static IOException g(long j11, long j12) {
                return new IOException("Expected " + j11 + " bytes but got at least " + j12);
            }

            private void i(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
                try {
                    UploadBodyDataBroker.ReadResult readResultH = h(byteBuffer);
                    if (this.f41141g > getLength()) {
                        throw g(getLength(), this.f41141g);
                    }
                    if (this.f41141g >= getLength()) {
                        d(uploadDataSink, byteBuffer);
                        return;
                    }
                    int i11 = C0454a.f41129a[readResultH.ordinal()];
                    if (i11 == 1) {
                        uploadDataSink.onReadSucceeded(false);
                    } else if (i11 == 2) {
                        throw new IOException("The source has been exhausted but we expected more data!");
                    }
                } catch (ExecutionException e11) {
                    e = e11;
                    this.f41140f.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                } catch (TimeoutException e12) {
                    e = e12;
                    this.f41140f.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                }
            }

            private void j(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                try {
                    uploadDataSink.onReadSucceeded(h(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY));
                } catch (ExecutionException | TimeoutException e11) {
                    this.f41140f.cancel(true);
                    uploadDataSink.onReadError(new IOException(e11));
                }
            }

            @Override // org.chromium.net.UploadDataProvider
            public long getLength() throws IOException {
                return this.f41136a.contentLength();
            }

            public final UploadBodyDataBroker.ReadResult h(ByteBuffer byteBuffer) throws ExecutionException, TimeoutException {
                int iPosition = byteBuffer.position();
                UploadBodyDataBroker.ReadResult readResult = (UploadBodyDataBroker.ReadResult) c0.b(this.f41137b.a(byteBuffer), this.f41139d, TimeUnit.MILLISECONDS);
                this.f41141g += (long) (byteBuffer.position() - iPosition);
                return readResult;
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
            this.f41135a = executorService;
        }

        @Override // cm.e
        public UploadDataProvider a(RequestBody requestBody, int i11) {
            return new C0456a(requestBody, new UploadBodyDataBroker(), this.f41135a, i11, null);
        }
    }

    public a(b bVar, c cVar) {
        this.f41127a = bVar;
        this.f41128b = cVar;
    }

    public static a b(ExecutorService executorService) {
        return new a(new b(), new c(executorService));
    }

    @Override // cm.e
    public UploadDataProvider a(RequestBody requestBody, int i11) throws IOException {
        long jContentLength = requestBody.contentLength();
        return (jContentLength == -1 || jContentLength > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) ? this.f41128b.a(requestBody, i11) : this.f41127a.a(requestBody, i11);
    }
}
