package com.cloud.hisavana.protocol.okhttptransport;

import com.google.common.base.m;
import com.google.common.util.concurrent.b0;
import com.google.common.util.concurrent.s;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import q9.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class OkHttpBridgeRequestCallback extends UrlRequest.Callback {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f29051k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f29053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile UrlRequest f29054n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b0<Source> f29046f = b0.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f29047g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f29048h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BlockingQueue<b> f29049i = new ArrayBlockingQueue(2);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b0<UrlResponseInfo> f29050j = b0.b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<UrlResponseInfo> f29052l = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public enum CallbackStep {
        ON_READ_COMPLETED,
        ON_SUCCESS,
        ON_FAILED,
        ON_CANCELED
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29055a;

        static {
            int[] iArr = new int[CallbackStep.values().length];
            f29055a = iArr;
            try {
                iArr[CallbackStep.ON_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29055a[CallbackStep.ON_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29055a[CallbackStep.ON_CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29055a[CallbackStep.ON_READ_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CallbackStep f29056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteBuffer f29057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CronetException f29058c;

        public b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException) {
            this.f29056a = callbackStep;
            this.f29057b = byteBuffer;
            this.f29058c = cronetException;
        }

        public /* synthetic */ b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException, a aVar) {
            this(callbackStep, byteBuffer, cronetException);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteBuffer f29059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f29060b;

        public c() {
            this.f29059a = ByteBuffer.allocateDirect(32768);
            this.f29060b = false;
        }

        public /* synthetic */ c(OkHttpBridgeRequestCallback okHttpBridgeRequestCallback, a aVar) {
            this();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f29060b) {
                return;
            }
            this.f29060b = true;
            if (OkHttpBridgeRequestCallback.this.f29047g.get()) {
                return;
            }
            OkHttpBridgeRequestCallback.this.f29054n.cancel();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            b bVar;
            if (OkHttpBridgeRequestCallback.this.f29048h.get()) {
                throw new IOException("The request was canceled!");
            }
            m.e(buffer != null, "sink == null");
            m.i(j11 >= 0, "byteCount < 0: %s", j11);
            m.w(!this.f29060b, "closed");
            if (OkHttpBridgeRequestCallback.this.f29047g.get()) {
                return -1L;
            }
            if (j11 < this.f29059a.limit()) {
                this.f29059a.limit((int) j11);
            }
            OkHttpBridgeRequestCallback.this.f29054n.read(this.f29059a);
            try {
                bVar = (b) OkHttpBridgeRequestCallback.this.f29049i.poll(OkHttpBridgeRequestCallback.this.f29051k, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                bVar = null;
            }
            if (bVar == null) {
                OkHttpBridgeRequestCallback.this.f29054n.cancel();
                throw new CronetTimeoutException();
            }
            int i11 = a.f29055a[bVar.f29056a.ordinal()];
            if (i11 == 1) {
                OkHttpBridgeRequestCallback.this.f29047g.set(true);
                this.f29059a = null;
                throw new IOException(bVar.f29058c);
            }
            if (i11 == 2) {
                OkHttpBridgeRequestCallback.this.f29047g.set(true);
                this.f29059a = null;
                return -1L;
            }
            if (i11 == 3) {
                this.f29059a = null;
                throw new IOException("The request was canceled!");
            }
            if (i11 != 4) {
                throw new AssertionError("The switch block above is exhaustive!");
            }
            bVar.f29057b.flip();
            int iWrite = buffer.write(bVar.f29057b);
            bVar.f29057b.clear();
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
            this.f29051k = 2147483647L;
        } else {
            this.f29051k = j11;
        }
        this.f29053m = dVar;
    }

    public s<Source> f() {
        return this.f29046f;
    }

    public s<UrlResponseInfo> g() {
        return this.f29050j;
    }

    public List<UrlResponseInfo> h() {
        return Collections.unmodifiableList(this.f29052l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f29048h.set(true);
        this.f29049i.add(new b(CallbackStep.ON_CANCELED, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
        IOException iOException = new IOException("The request was canceled!");
        this.f29050j.setException(iOException);
        this.f29046f.setException(iOException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        if (this.f29050j.setException(cronetException) && this.f29046f.setException(cronetException)) {
            return;
        }
        this.f29049i.add(new b(CallbackStep.ON_FAILED, null, cronetException, 0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        this.f29049i.add(new b(CallbackStep.ON_READ_COMPLETED, byteBuffer, null, 0 == true ? 1 : 0));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        if (!this.f29053m.b()) {
            m.v(this.f29050j.set(urlResponseInfo));
            m.v(this.f29046f.set(new Buffer()));
            urlRequest.cancel();
            return;
        }
        this.f29052l.add(urlResponseInfo);
        if (urlResponseInfo.getUrlChain().size() <= this.f29053m.c()) {
            urlRequest.followRedirect();
            return;
        }
        urlRequest.cancel();
        ProtocolException protocolException = new ProtocolException("Too many follow-up requests: " + (this.f29053m.c() + 1));
        this.f29050j.setException(protocolException);
        this.f29046f.setException(protocolException);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f29054n = urlRequest;
        m.v(this.f29050j.set(urlResponseInfo));
        m.v(this.f29046f.set(new c(this, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.chromium.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.f29049i.add(new b(CallbackStep.ON_SUCCESS, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
    }
}
