package androidx.media3.datasource.cronet;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.c0;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.HttpDataSource;
import c4.j;
import c4.o;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.base.n;
import com.google.common.primitives.Longs;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import z3.d;
import z3.g;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class CronetDataSource extends c4.a implements HttpDataSource {
    public boolean A;
    public volatile long B;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UrlRequest.Callback f9735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CronetEngine f9736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Executor f9737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f9740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f9741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f9742l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final String f9743m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public final HttpDataSource.b f9744n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HttpDataSource.b f9745o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final g f9746p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f9747q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public n<String> f9748r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f9749s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f9750t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f9751u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public UrlRequest f9752v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public c4.g f9753w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public ByteBuffer f9754x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public UrlResponseInfo f9755y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public IOException f9756z;

    /* JADX INFO: compiled from: source.java */
    public static final class OpenException extends HttpDataSource.HttpDataSourceException {
        public final int cronetConnectionStatus;

        public OpenException(c4.g gVar, int i11, int i12) {
            super(gVar, i11, 1);
            this.cronetConnectionStatus = i12;
        }

        @Deprecated
        public OpenException(IOException iOException, c4.g gVar, int i11) {
            super(iOException, gVar, 2000, 1);
            this.cronetConnectionStatus = i11;
        }

        public OpenException(IOException iOException, c4.g gVar, int i11, int i12) {
            super(iOException, gVar, i11, 1);
            this.cronetConnectionStatus = i12;
        }

        @Deprecated
        public OpenException(String str, c4.g gVar, int i11) {
            super(str, gVar, 2000, 1);
            this.cronetConnectionStatus = i11;
        }

        public OpenException(String str, c4.g gVar, int i11, int i12) {
            super(str, gVar, i11, 1);
            this.cronetConnectionStatus = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends UrlRequest.StatusListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f9757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f9758b;

        public a(int[] iArr, g gVar) {
            this.f9757a = iArr;
            this.f9758b = gVar;
        }

        @Override // org.chromium.net.UrlRequest.StatusListener
        public void onStatus(int i11) {
            this.f9757a[0] = i11;
            this.f9758b.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements HttpDataSource.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final CronetEngine f9759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f9760b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public HttpDataSource.a f9763e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public n<String> f9764f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public o f9765g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f9766h;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f9770l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f9771m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f9772n;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HttpDataSource.b f9761c = new HttpDataSource.b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final androidx.media3.datasource.c.b f9762d = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f9767i = 3;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f9768j = 8000;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f9769k = 8000;

        public b(CronetEngine cronetEngine, Executor executor) {
            this.f9759a = (CronetEngine) z3.a.e(cronetEngine);
            this.f9760b = executor;
        }

        @Override // androidx.media3.datasource.a.InterfaceC0090a
        public HttpDataSource createDataSource() {
            if (this.f9759a == null) {
                HttpDataSource.a aVar = this.f9763e;
                return aVar != null ? aVar.createDataSource() : ((androidx.media3.datasource.c.b) z3.a.e(this.f9762d)).createDataSource();
            }
            CronetDataSource cronetDataSource = new CronetDataSource(this.f9759a, this.f9760b, this.f9767i, this.f9768j, this.f9769k, this.f9770l, this.f9771m, this.f9766h, this.f9761c, this.f9764f, this.f9772n);
            o oVar = this.f9765g;
            if (oVar != null) {
                cronetDataSource.c(oVar);
            }
            return cronetDataSource;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c extends UrlRequest.Callback {
        public c() {
        }

        public /* synthetic */ c(CronetDataSource cronetDataSource, a aVar) {
            this();
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            try {
                if (urlRequest != CronetDataSource.this.f9752v) {
                    return;
                }
                if ((cronetException instanceof NetworkException) && ((NetworkException) cronetException).getErrorCode() == 1) {
                    CronetDataSource.this.f9756z = new UnknownHostException();
                } else {
                    CronetDataSource.this.f9756z = cronetException;
                }
                CronetDataSource.this.f9746p.f();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            if (urlRequest != CronetDataSource.this.f9752v) {
                return;
            }
            CronetDataSource.this.f9746p.f();
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            if (urlRequest != CronetDataSource.this.f9752v) {
                return;
            }
            UrlRequest urlRequest2 = (UrlRequest) z3.a.e(CronetDataSource.this.f9752v);
            c4.g gVar = (c4.g) z3.a.e(CronetDataSource.this.f9753w);
            int httpStatusCode = urlResponseInfo.getHttpStatusCode();
            if (gVar.f14600c == 2 && (httpStatusCode == 307 || httpStatusCode == 308)) {
                CronetDataSource.this.f9756z = new HttpDataSource.InvalidResponseCodeException(httpStatusCode, urlResponseInfo.getHttpStatusText(), null, urlResponseInfo.getAllHeaders(), gVar, u0.f81843f);
                CronetDataSource.this.f9746p.f();
                return;
            }
            if (CronetDataSource.this.f9741k) {
                CronetDataSource.this.E();
            }
            boolean z11 = CronetDataSource.this.f9749s && gVar.f14600c == 2 && httpStatusCode == 302;
            if (!z11 && !CronetDataSource.this.f9742l) {
                urlRequest.followRedirect();
                return;
            }
            String strB = CronetDataSource.B(urlResponseInfo.getAllHeaders().get("Set-Cookie"));
            if (!z11 && TextUtils.isEmpty(strB)) {
                urlRequest.followRedirect();
                return;
            }
            urlRequest2.cancel();
            try {
                UrlRequest.Builder builderW = CronetDataSource.this.w((z11 || gVar.f14600c != 2) ? gVar.g(Uri.parse(str)) : gVar.a().j(str).d(1).c(null).a());
                CronetDataSource.u(builderW, strB);
                CronetDataSource.this.f9752v = builderW.build();
                CronetDataSource.this.f9752v.start();
            } catch (IOException e11) {
                CronetDataSource.this.f9756z = e11;
            }
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (urlRequest != CronetDataSource.this.f9752v) {
                return;
            }
            CronetDataSource.this.f9755y = urlResponseInfo;
            CronetDataSource.this.f9746p.f();
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (urlRequest != CronetDataSource.this.f9752v) {
                return;
            }
            CronetDataSource.this.A = true;
            CronetDataSource.this.f9746p.f();
        }
    }

    static {
        c0.a("media3.datasource.cronet");
    }

    public CronetDataSource(CronetEngine cronetEngine, Executor executor, int i11, int i12, int i13, boolean z11, boolean z12, @Nullable String str, @Nullable HttpDataSource.b bVar, @Nullable n<String> nVar, boolean z13) {
        super(true);
        this.f9736f = (CronetEngine) z3.a.e(cronetEngine);
        this.f9737g = (Executor) z3.a.e(executor);
        this.f9738h = i11;
        this.f9739i = i12;
        this.f9740j = i13;
        this.f9741k = z11;
        this.f9742l = z12;
        this.f9743m = str;
        this.f9744n = bVar;
        this.f9748r = nVar;
        this.f9749s = z13;
        this.f9747q = d.f81767a;
        this.f9735e = new c(this, null);
        this.f9745o = new HttpDataSource.b();
        this.f9746p = new g();
    }

    public static boolean A(UrlResponseInfo urlResponseInfo) {
        for (Map.Entry<String, String> entry : urlResponseInfo.getAllHeadersAsList()) {
            if (entry.getKey().equalsIgnoreCase(HttpHeaders.CONTENT_ENCODING)) {
                return !entry.getValue().equalsIgnoreCase("identity");
            }
        }
        return false;
    }

    @Nullable
    public static String B(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return TextUtils.join(";", list);
    }

    private void F(long j11, c4.g gVar) throws HttpDataSource.HttpDataSourceException {
        if (j11 == 0) {
            return;
        }
        ByteBuffer byteBufferY = y();
        while (j11 > 0) {
            try {
                this.f9746p.d();
                byteBufferY.clear();
                C(byteBufferY, gVar);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (this.A) {
                    throw new OpenException(gVar, 2008, 14);
                }
                byteBufferY.flip();
                z3.a.g(byteBufferY.hasRemaining());
                int iMin = (int) Math.min(byteBufferY.remaining(), j11);
                byteBufferY.position(byteBufferY.position() + iMin);
                j11 -= (long) iMin;
            } catch (IOException e11) {
                if (e11 instanceof HttpDataSource.HttpDataSourceException) {
                    throw ((HttpDataSource.HttpDataSourceException) e11);
                }
                throw new OpenException(e11, gVar, e11 instanceof SocketTimeoutException ? 2002 : 2001, 14);
            }
        }
    }

    public static void u(UrlRequest.Builder builder, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.addHeader("Cookie", str);
    }

    @Nullable
    public static String x(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static int z(UrlRequest urlRequest) throws InterruptedException {
        g gVar = new g();
        int[] iArr = new int[1];
        urlRequest.getStatus(new a(iArr, gVar));
        gVar.a();
        return iArr[0];
    }

    public final void C(ByteBuffer byteBuffer, c4.g gVar) throws HttpDataSource.HttpDataSourceException {
        ((UrlRequest) u0.i(this.f9752v)).read(byteBuffer);
        try {
            if (!this.f9746p.b(this.f9740j)) {
                throw new SocketTimeoutException();
            }
        } catch (InterruptedException unused) {
            if (byteBuffer == this.f9754x) {
                this.f9754x = null;
            }
            Thread.currentThread().interrupt();
            this.f9756z = new InterruptedIOException();
        } catch (SocketTimeoutException e11) {
            if (byteBuffer == this.f9754x) {
                this.f9754x = null;
            }
            this.f9756z = new HttpDataSource.HttpDataSourceException(e11, gVar, 2002, 2);
        }
        IOException iOException = this.f9756z;
        if (iOException != null) {
            if (!(iOException instanceof HttpDataSource.HttpDataSourceException)) {
                throw HttpDataSource.HttpDataSourceException.createForIOException(iOException, gVar, 2);
            }
            throw ((HttpDataSource.HttpDataSourceException) iOException);
        }
    }

    public final byte[] D() throws IOException {
        byte[] bArrCopyOf = u0.f81843f;
        ByteBuffer byteBufferY = y();
        while (!this.A) {
            this.f9746p.d();
            byteBufferY.clear();
            C(byteBufferY, (c4.g) u0.i(this.f9753w));
            byteBufferY.flip();
            if (byteBufferY.remaining() > 0) {
                int length = bArrCopyOf.length;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length + byteBufferY.remaining());
                byteBufferY.get(bArrCopyOf, length, byteBufferY.remaining());
            }
        }
        return bArrCopyOf;
    }

    public final void E() {
        this.B = this.f9747q.elapsedRealtime() + ((long) this.f9739i);
    }

    @Override // androidx.media3.datasource.a
    public long a(c4.g gVar) throws HttpDataSource.HttpDataSourceException {
        byte[] bArrD;
        String strX;
        z3.a.e(gVar);
        z3.a.g(!this.f9750t);
        this.f9746p.d();
        E();
        this.f9753w = gVar;
        try {
            UrlRequest urlRequestBuild = w(gVar).build();
            this.f9752v = urlRequestBuild;
            urlRequestBuild.start();
            f(gVar);
            try {
                boolean zV = v();
                IOException iOException = this.f9756z;
                if (iOException != null) {
                    String message = iOException.getMessage();
                    if (message == null || !com.google.common.base.a.e(message).contains("err_cleartext_not_permitted")) {
                        throw new OpenException(iOException, gVar, 2001, z(urlRequestBuild));
                    }
                    throw new HttpDataSource.CleartextNotPermittedException(iOException, gVar);
                }
                if (!zV) {
                    throw new OpenException(new SocketTimeoutException(), gVar, 2002, z(urlRequestBuild));
                }
                UrlResponseInfo urlResponseInfo = (UrlResponseInfo) z3.a.e(this.f9755y);
                int httpStatusCode = urlResponseInfo.getHttpStatusCode();
                Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
                long j11 = 0;
                if (httpStatusCode < 200 || httpStatusCode > 299) {
                    if (httpStatusCode == 416) {
                        if (gVar.f14604g == j.c(x(allHeaders, "Content-Range"))) {
                            this.f9750t = true;
                            g(gVar);
                            long j12 = gVar.f14605h;
                            if (j12 != -1) {
                                return j12;
                            }
                            return 0L;
                        }
                    }
                    try {
                        bArrD = D();
                    } catch (IOException unused) {
                        bArrD = u0.f81843f;
                    }
                    throw new HttpDataSource.InvalidResponseCodeException(httpStatusCode, urlResponseInfo.getHttpStatusText(), httpStatusCode == 416 ? new DataSourceException(2008) : null, allHeaders, gVar, bArrD);
                }
                n<String> nVar = this.f9748r;
                if (nVar != null && (strX = x(allHeaders, HttpHeaders.CONTENT_TYPE)) != null && !nVar.apply(strX)) {
                    throw new HttpDataSource.InvalidContentTypeException(strX, gVar);
                }
                if (httpStatusCode == 200) {
                    long j13 = gVar.f14604g;
                    if (j13 != 0) {
                        j11 = j13;
                    }
                }
                if (A(urlResponseInfo)) {
                    this.f9751u = gVar.f14605h;
                } else {
                    long j14 = gVar.f14605h;
                    if (j14 != -1) {
                        this.f9751u = j14;
                    } else {
                        long jB = j.b(x(allHeaders, HttpHeaders.CONTENT_LENGTH), x(allHeaders, "Content-Range"));
                        this.f9751u = jB != -1 ? jB - j11 : -1L;
                    }
                }
                this.f9750t = true;
                g(gVar);
                F(j11, gVar);
                return this.f9751u;
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                throw new OpenException(new InterruptedIOException(), gVar, 1004, -1);
            }
        } catch (IOException e11) {
            if (e11 instanceof HttpDataSource.HttpDataSourceException) {
                throw ((HttpDataSource.HttpDataSourceException) e11);
            }
            throw new OpenException(e11, gVar, 2000, 0);
        }
    }

    @Override // androidx.media3.datasource.a
    public synchronized void close() {
        try {
            UrlRequest urlRequest = this.f9752v;
            if (urlRequest != null) {
                urlRequest.cancel();
                this.f9752v = null;
            }
            ByteBuffer byteBuffer = this.f9754x;
            if (byteBuffer != null) {
                byteBuffer.limit(0);
            }
            this.f9753w = null;
            this.f9755y = null;
            this.f9756z = null;
            this.A = false;
            if (this.f9750t) {
                this.f9750t = false;
                e();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // c4.a, androidx.media3.datasource.a
    public Map<String, List<String>> getResponseHeaders() {
        UrlResponseInfo urlResponseInfo = this.f9755y;
        return urlResponseInfo == null ? Collections.emptyMap() : urlResponseInfo.getAllHeaders();
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        UrlResponseInfo urlResponseInfo = this.f9755y;
        if (urlResponseInfo == null) {
            return null;
        }
        return Uri.parse(urlResponseInfo.getUrl());
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws HttpDataSource.HttpDataSourceException {
        z3.a.g(this.f9750t);
        if (i12 == 0) {
            return 0;
        }
        if (this.f9751u == 0) {
            return -1;
        }
        ByteBuffer byteBufferY = y();
        if (!byteBufferY.hasRemaining()) {
            this.f9746p.d();
            byteBufferY.clear();
            C(byteBufferY, (c4.g) u0.i(this.f9753w));
            if (this.A) {
                this.f9751u = 0L;
                return -1;
            }
            byteBufferY.flip();
            z3.a.g(byteBufferY.hasRemaining());
        }
        long[] jArr = new long[3];
        long j11 = this.f9751u;
        if (j11 == -1) {
            j11 = Long.MAX_VALUE;
        }
        jArr[0] = j11;
        jArr[1] = byteBufferY.remaining();
        jArr[2] = i12;
        int i13 = (int) Longs.i(jArr);
        byteBufferY.get(bArr, i11, i13);
        long j12 = this.f9751u;
        if (j12 != -1) {
            this.f9751u = j12 - ((long) i13);
        }
        d(i13);
        return i13;
    }

    public final boolean v() throws InterruptedException {
        long jElapsedRealtime = this.f9747q.elapsedRealtime();
        boolean zB = false;
        while (!zB && jElapsedRealtime < this.B) {
            zB = this.f9746p.b((this.B - jElapsedRealtime) + 5);
            jElapsedRealtime = this.f9747q.elapsedRealtime();
        }
        return zB;
    }

    public UrlRequest.Builder w(c4.g gVar) throws IOException {
        UrlRequest.Builder builderAllowDirectExecutor = this.f9736f.newUrlRequestBuilder(gVar.f14598a.toString(), this.f9735e, this.f9737g).setPriority(this.f9738h).allowDirectExecutor();
        HashMap map = new HashMap();
        HttpDataSource.b bVar = this.f9744n;
        if (bVar != null) {
            map.putAll(bVar.b());
        }
        map.putAll(this.f9745o.b());
        map.putAll(gVar.f14602e);
        for (Map.Entry entry : map.entrySet()) {
            builderAllowDirectExecutor.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        if (gVar.f14601d != null && !map.containsKey(HttpHeaders.CONTENT_TYPE)) {
            throw new OpenException("HTTP request with non-empty body must set Content-Type", gVar, 1004, 0);
        }
        String strA = j.a(gVar.f14604g, gVar.f14605h);
        if (strA != null) {
            builderAllowDirectExecutor.addHeader("Range", strA);
        }
        String str = this.f9743m;
        if (str != null) {
            builderAllowDirectExecutor.addHeader("User-Agent", str);
        }
        builderAllowDirectExecutor.setHttpMethod(gVar.b());
        byte[] bArr = gVar.f14601d;
        if (bArr != null) {
            builderAllowDirectExecutor.setUploadDataProvider(new androidx.media3.datasource.cronet.a(bArr), this.f9737g);
        }
        return builderAllowDirectExecutor;
    }

    public final ByteBuffer y() {
        if (this.f9754x == null) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32768);
            this.f9754x = byteBufferAllocateDirect;
            byteBufferAllocateDirect.limit(0);
        }
        return this.f9754x;
    }
}
