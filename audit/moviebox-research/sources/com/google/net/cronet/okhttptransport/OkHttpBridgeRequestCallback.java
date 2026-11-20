package com.google.net.cronet.okhttptransport;

import cm.d;
import com.google.common.base.m;
import com.google.common.util.concurrent.b0;
import com.google.common.util.concurrent.s;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Buffer;
import okio.Source;
import okio.Timeout;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class OkHttpBridgeRequestCallback extends UrlRequest.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b0<Source> f41109f = b0.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f41110g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f41111h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BlockingQueue<b> f41112i = new ArrayBlockingQueue(2);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b0<UrlResponseInfo> f41113j = b0.b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f41114k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f41115l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile UrlRequest f41116m;

    /* JADX INFO: compiled from: source.java */
    public enum CallbackStep {
        ON_READ_COMPLETED,
        ON_SUCCESS,
        ON_FAILED,
        ON_CANCELED
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41117a;

        static {
            int[] iArr = new int[CallbackStep.values().length];
            f41117a = iArr;
            try {
                iArr[CallbackStep.ON_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41117a[CallbackStep.ON_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41117a[CallbackStep.ON_CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41117a[CallbackStep.ON_READ_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CallbackStep f41118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteBuffer f41119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CronetException f41120c;

        public b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException) {
            this.f41118a = callbackStep;
            this.f41119b = byteBuffer;
            this.f41120c = cronetException;
        }

        public /* synthetic */ b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException, a aVar) {
            this(callbackStep, byteBuffer, cronetException);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class c implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteBuffer f41121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f41122b;

        public c() {
            this.f41121a = ByteBuffer.allocateDirect(32768);
            this.f41122b = false;
        }

        public /* synthetic */ c(OkHttpBridgeRequestCallback okHttpBridgeRequestCallback, a aVar) {
            this();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f41122b) {
                return;
            }
            this.f41122b = true;
            if (OkHttpBridgeRequestCallback.this.f41110g.get()) {
                return;
            }
            OkHttpBridgeRequestCallback.this.f41116m.cancel();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            b bVar;
            if (OkHttpBridgeRequestCallback.this.f41111h.get()) {
                throw new IOException("The request was canceled!");
            }
            m.e(buffer != null, "sink == null");
            m.i(j11 >= 0, "byteCount < 0: %s", j11);
            m.w(!this.f41122b, "closed");
            if (OkHttpBridgeRequestCallback.this.f41110g.get()) {
                return -1L;
            }
            if (j11 < this.f41121a.limit()) {
                this.f41121a.limit((int) j11);
            }
            OkHttpBridgeRequestCallback.this.f41116m.read(this.f41121a);
            try {
                bVar = (b) OkHttpBridgeRequestCallback.this.f41112i.poll(OkHttpBridgeRequestCallback.this.f41114k, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                bVar = null;
            }
            if (bVar == null) {
                OkHttpBridgeRequestCallback.this.f41116m.cancel();
                throw new CronetTimeoutException();
            }
            int i11 = a.f41117a[bVar.f41118a.ordinal()];
            if (i11 == 1) {
                OkHttpBridgeRequestCallback.this.f41110g.set(true);
                this.f41121a = null;
                throw new IOException(bVar.f41120c);
            }
            if (i11 == 2) {
                OkHttpBridgeRequestCallback.this.f41110g.set(true);
                this.f41121a = null;
                return -1L;
            }
            if (i11 == 3) {
                this.f41121a = null;
                throw new IOException("The request was canceled!");
            }
            if (i11 != 4) {
                throw new AssertionError("The switch block above is exhaustive!");
            }
            bVar.f41119b.flip();
            int iWrite = buffer.write(bVar.f41119b);
            bVar.f41119b.clear();
            return iWrite;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    public OkHttpBridgeRequestCallback(long j11, d dVar) {
        m.d(j11 >= 0);
        if (j11 == 0) {
            this.f41114k = 2147483647L;
        } else {
            this.f41114k = j11;
        }
        this.f41115l = dVar;
    }

    public s<Source> f() {
        return this.f41109f;
    }

    public s<UrlResponseInfo> g() {
        return this.f41113j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f41111h.set(true);
        this.f41112i.add(new b(CallbackStep.ON_CANCELED, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
        IOException iOException = new IOException("The request was canceled!");
        this.f41113j.setException(iOException);
        this.f41109f.setException(iOException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        if (this.f41113j.setException(cronetException) && this.f41109f.setException(cronetException)) {
            return;
        }
        this.f41112i.add(new b(CallbackStep.ON_FAILED, null, cronetException, 0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        this.f41112i.add(new b(CallbackStep.ON_READ_COMPLETED, byteBuffer, null, 0 == true ? 1 : 0));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        if (!this.f41115l.b()) {
            m.v(this.f41113j.set(urlResponseInfo));
            m.v(this.f41109f.set(new Buffer()));
            urlRequest.cancel();
        } else {
            if (urlResponseInfo.getUrlChain().size() <= this.f41115l.c()) {
                urlRequest.followRedirect();
                return;
            }
            urlRequest.cancel();
            ProtocolException protocolException = new ProtocolException("Too many follow-up requests: " + (this.f41115l.c() + 1));
            this.f41113j.setException(protocolException);
            this.f41109f.setException(protocolException);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f41116m = urlRequest;
        m.v(this.f41113j.set(urlResponseInfo));
        m.v(this.f41109f.set(new c(this, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f41112i.add(new b(CallbackStep.ON_SUCCESS, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
    }
}
