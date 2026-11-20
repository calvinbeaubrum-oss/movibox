package com.vungle.warren.downloader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.logging.type.LogSeverity;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.utility.NetworkProvider;
import com.vungle.warren.utility.i;
import com.vungle.warren.utility.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@SuppressLint({"LogNotTimber"})
public class AssetDownloader implements Downloader {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f61958p = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f61959q = AssetDownloader.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final f f61960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f61961b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NetworkProvider f61965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f61966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OkHttpClient f61967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ExecutorService f61968i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f61962c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f61963d = 10;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f61964e = LogSeverity.NOTICE_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, DownloadRequestMediator> f61969j = new ConcurrentHashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<e> f61970k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f61971l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile int f61972m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f61973n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final NetworkProvider.b f61974o = new a();

    /* JADX INFO: compiled from: source.java */
    public static abstract class DownloadPriorityRunnable implements Comparable, Runnable {
        private static final AtomicInteger seq = new AtomicInteger();
        private final DownloadRequestMediator mediator;
        private final int order;
        private final b priority;

        public DownloadPriorityRunnable(DownloadRequestMediator downloadRequestMediator) {
            this.order = seq.incrementAndGet();
            this.mediator = downloadRequestMediator;
            this.priority = downloadRequestMediator.priority;
            downloadRequestMediator.setRunnable(this);
        }

        public DownloadPriorityRunnable(b bVar) {
            this.order = seq.incrementAndGet();
            this.priority = bVar;
            this.mediator = null;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull Object obj) {
            if (!(obj instanceof DownloadPriorityRunnable)) {
                return -1;
            }
            DownloadPriorityRunnable downloadPriorityRunnable = (DownloadPriorityRunnable) obj;
            int iCompareTo = getPriority().compareTo(downloadPriorityRunnable.getPriority());
            return iCompareTo == 0 ? Integer.valueOf(this.order).compareTo(Integer.valueOf(downloadPriorityRunnable.order)) : iCompareTo;
        }

        public b getPriority() {
            DownloadRequestMediator downloadRequestMediator = this.mediator;
            return downloadRequestMediator != null ? downloadRequestMediator.getPriority() : this.priority;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements NetworkProvider.b {
        public a() {
        }

        @Override // com.vungle.warren.utility.NetworkProvider.b
        public void a(int i11) {
            String unused = AssetDownloader.f61959q;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Network changed: ");
            sb2.append(i11);
            AssetDownloader.this.q0(i11);
        }
    }

    public AssetDownloader(@Nullable f fVar, long j11, @NonNull NetworkProvider networkProvider, @NonNull w wVar, @NonNull ExecutorService executorService) {
        this.f61960a = fVar;
        this.f61961b = j11;
        this.f61966g = wVar;
        this.f61965f = networkProvider;
        this.f61968i = executorService;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f61967h = builder.readTimeout(30L, timeUnit).connectTimeout(30L, timeUnit).cache(null).followRedirects(true).followSslRedirects(true).build();
    }

    public static /* synthetic */ void A(AssetDownloader assetDownloader, File file, DownloadRequestMediator downloadRequestMediator) {
        assetDownloader.s0(file, downloadRequestMediator);
    }

    public static /* synthetic */ void B(AssetDownloader assetDownloader, com.vungle.warren.downloader.a.C0629a c0629a, DownloadRequestMediator downloadRequestMediator) {
        assetDownloader.p0(c0629a, downloadRequestMediator);
    }

    public static /* synthetic */ void C(AssetDownloader assetDownloader, DownloadRequestMediator downloadRequestMediator) {
        assetDownloader.o0(downloadRequestMediator);
    }

    public static /* synthetic */ void D(AssetDownloader assetDownloader, DownloadRequestMediator downloadRequestMediator) {
        assetDownloader.v0(downloadRequestMediator);
    }

    public static /* synthetic */ void E(AssetDownloader assetDownloader) {
        assetDownloader.w0();
    }

    public static /* synthetic */ f G(AssetDownloader assetDownloader) {
        return assetDownloader.f61960a;
    }

    public static /* synthetic */ String H(AssetDownloader assetDownloader, DownloadRequestMediator downloadRequestMediator) {
        return assetDownloader.S(downloadRequestMediator);
    }

    public static /* synthetic */ boolean I(AssetDownloader assetDownloader, DownloadRequestMediator downloadRequestMediator) {
        return assetDownloader.d0(downloadRequestMediator);
    }

    public static /* synthetic */ HashMap J(AssetDownloader assetDownloader, File file) {
        return assetDownloader.Y(file);
    }

    public static /* synthetic */ boolean K(AssetDownloader assetDownloader, DownloadRequestMediator downloadRequestMediator, File file, Map map) {
        return assetDownloader.B0(downloadRequestMediator, file, map);
    }

    public static /* synthetic */ void L(AssetDownloader assetDownloader, long j11, File file, HashMap map, Request.Builder builder) {
        assetDownloader.O(j11, file, map, builder);
    }

    public static /* synthetic */ OkHttpClient M(AssetDownloader assetDownloader) {
        return assetDownloader.f61967h;
    }

    public static /* synthetic */ String j() {
        return f61959q;
    }

    public static /* synthetic */ long l(AssetDownloader assetDownloader, Response response) {
        return assetDownloader.b0(response);
    }

    public static /* synthetic */ boolean m(AssetDownloader assetDownloader, File file, Response response, DownloadRequestMediator downloadRequestMediator, HashMap map) {
        return assetDownloader.m0(file, response, downloadRequestMediator, map);
    }

    public static /* synthetic */ boolean n(AssetDownloader assetDownloader, DownloadRequestMediator downloadRequestMediator, File file, Map map, int i11) {
        return assetDownloader.A0(downloadRequestMediator, file, map, i11);
    }

    public static /* synthetic */ void o(AssetDownloader assetDownloader, File file, HashMap map) throws Throwable {
        assetDownloader.y0(file, map);
    }

    public static /* synthetic */ boolean p(AssetDownloader assetDownloader, long j11, int i11, Response response, DownloadRequestMediator downloadRequestMediator) {
        return assetDownloader.t0(j11, i11, response, downloadRequestMediator);
    }

    public static /* synthetic */ void q(AssetDownloader assetDownloader, File file, File file2, boolean z11) {
        assetDownloader.U(file, file2, z11);
    }

    public static /* synthetic */ void r(AssetDownloader assetDownloader, File file, File file2, Headers headers) throws IOException {
        assetDownloader.P(file, file2, headers);
    }

    public static /* synthetic */ HashMap s(AssetDownloader assetDownloader, File file, Headers headers, String str) {
        return assetDownloader.i0(file, headers, str);
    }

    public static /* synthetic */ ResponseBody t(AssetDownloader assetDownloader, Response response) {
        return assetDownloader.T(response);
    }

    public static /* synthetic */ void u(AssetDownloader assetDownloader, DownloadRequestMediator downloadRequestMediator, com.vungle.warren.downloader.a.b bVar) {
        assetDownloader.r0(downloadRequestMediator, bVar);
    }

    public static /* synthetic */ int w(AssetDownloader assetDownloader) {
        return assetDownloader.f61972m;
    }

    public static /* synthetic */ int x(AssetDownloader assetDownloader, Throwable th2, boolean z11) {
        return assetDownloader.k0(th2, z11);
    }

    public static /* synthetic */ void y(AssetDownloader assetDownloader, long j11) {
        assetDownloader.z0(j11);
    }

    public static /* synthetic */ boolean z(AssetDownloader assetDownloader, DownloadRequestMediator downloadRequestMediator, com.vungle.warren.downloader.a.b bVar, com.vungle.warren.downloader.a.C0629a c0629a) {
        return assetDownloader.u0(downloadRequestMediator, bVar, c0629a);
    }

    public final boolean A0(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map, int i11) {
        return this.f61960a != null && downloadRequestMediator.isCacheable && i11 != 200 && i11 != 416 && i11 != 206 && Boolean.parseBoolean(map.get("DOWNLOAD_COMPLETE")) && file.exists() && file.length() > 0;
    }

    public final boolean B0(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map) {
        String str;
        if (map == null || this.f61960a == null || !downloadRequestMediator.isCacheable || (str = map.get("Last-Cache-Verification")) == null || !file.exists() || !Boolean.parseBoolean(map.get("DOWNLOAD_COMPLETE"))) {
            return false;
        }
        try {
            long j11 = Long.parseLong(str);
            long j12 = this.f61961b;
            return j12 >= Long.MAX_VALUE - j11 || j11 + j12 >= System.currentTimeMillis();
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final void N() {
        this.f61965f.d(this.f61974o);
    }

    public final void O(long j11, @NonNull File file, @NonNull HashMap<String, String> map, @NonNull Request.Builder builder) {
        builder.addHeader("Accept-Encoding", "identity");
        if (!file.exists() || map.isEmpty()) {
            return;
        }
        String str = map.get("ETag");
        String str2 = map.get(HttpHeaders.LAST_MODIFIED);
        if (Boolean.parseBoolean(map.get("DOWNLOAD_COMPLETE"))) {
            if (!TextUtils.isEmpty(str)) {
                builder.addHeader("If-None-Match", str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            builder.addHeader("If-Modified-Since", str2);
            return;
        }
        if ("bytes".equalsIgnoreCase(map.get("Accept-Ranges"))) {
            if (map.get(HttpHeaders.CONTENT_ENCODING) == null || "identity".equalsIgnoreCase(map.get(HttpHeaders.CONTENT_ENCODING))) {
                builder.addHeader("Range", "bytes=" + j11 + "-");
                if (!TextUtils.isEmpty(str)) {
                    builder.addHeader("If-Range", str);
                } else {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    builder.addHeader("If-Range", str2);
                }
            }
        }
    }

    public final void P(File file, File file2, Headers headers) throws IOException {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        if (str == null || "gzip".equalsIgnoreCase(str) || "identity".equalsIgnoreCase(str)) {
            return;
        }
        U(file, file2, false);
        VungleLogger.c("AssetDownloader#checkEncoding; loadAd sequence", String.format("unknown %1$s %2$s ", HttpHeaders.CONTENT_ENCODING, str));
        throw new IOException("Unknown Content-Encoding");
    }

    public final void Q(File file, File file2, androidx.core.util.e<e, com.vungle.warren.downloader.a> eVar) throws Throwable {
        FileOutputStream fileOutputStream;
        IOException e11;
        FileInputStream fileInputStream;
        if (file2.exists()) {
            i.c(file2);
        }
        if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        channel.transferTo(0L, channel.size(), fileOutputStream.getChannel());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Copying: finished ");
                        sb2.append(eVar.f7889a.f61994b);
                        sb2.append(" copying to ");
                        sb2.append(file2.getPath());
                    } catch (IOException e12) {
                        e11 = e12;
                        VungleLogger.c("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", file.getPath(), eVar.f7889a.f61994b, file2.getPath(), e11));
                        V(eVar.f7889a, eVar.f7890b, new com.vungle.warren.downloader.a.C0629a(-1, e11, 2));
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Copying: error");
                        sb3.append(eVar.f7889a.f61994b);
                        sb3.append(" copying to ");
                        sb3.append(file2.getPath());
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    i.a(fileInputStream2);
                    i.a(fileOutputStream);
                    throw th;
                }
            } catch (IOException e13) {
                fileOutputStream = null;
                e11 = e13;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                i.a(fileInputStream2);
                i.a(fileOutputStream);
                throw th;
            }
        } catch (IOException e14) {
            fileOutputStream = null;
            e11 = e14;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            i.a(fileInputStream2);
            i.a(fileOutputStream);
            throw th;
        }
        i.a(fileInputStream);
        i.a(fileOutputStream);
    }

    public final String R(e eVar) {
        return ", single request url - " + eVar.f61994b + ", path - " + eVar.f61995c + ", th - " + Thread.currentThread().getName() + "id " + eVar.f61998f;
    }

    public final String S(DownloadRequestMediator downloadRequestMediator) {
        return ", mediator url - " + downloadRequestMediator.url + ", path - " + downloadRequestMediator.filePath + ", th - " + Thread.currentThread().getName() + "id " + downloadRequestMediator;
    }

    public final ResponseBody T(Response response) {
        if (!"gzip".equalsIgnoreCase(response.header(HttpHeaders.CONTENT_ENCODING)) || !okhttp3.internal.http.HttpHeaders.hasBody(response) || response.body() == null) {
            return response.body();
        }
        return new RealResponseBody(response.header(HttpHeaders.CONTENT_TYPE), -1L, Okio.buffer(new GzipSource(response.body().source())));
    }

    public final void U(File file, File file2, boolean z11) {
        if (file == null) {
            return;
        }
        i.c(file);
        if (file2 != null) {
            i.c(file2);
        }
        if (this.f61960a == null || !e0()) {
            return;
        }
        if (z11) {
            this.f61960a.g(file);
        } else {
            this.f61960a.deleteContents(file);
        }
    }

    public final void V(@Nullable final e eVar, @Nullable final com.vungle.warren.downloader.a aVar, @NonNull final com.vungle.warren.downloader.a.C0629a c0629a) {
        Object[] objArr = new Object[2];
        objArr[0] = c0629a;
        objArr[1] = eVar != null ? R(eVar) : "null";
        VungleLogger.c("AssetDownloader#deliverError; loadAd sequence", String.format("Delivering error %1$s; request %2$s", objArr));
        if (aVar != null) {
            this.f61968i.execute(new Runnable() { // from class: com.vungle.warren.downloader.AssetDownloader.6
                @Override // java.lang.Runnable
                public void run() {
                    aVar.b(c0629a, eVar);
                }
            });
        }
    }

    public final void W(final com.vungle.warren.downloader.a.b bVar, final e eVar, final com.vungle.warren.downloader.a aVar) {
        if (aVar != null) {
            this.f61968i.execute(new Runnable() { // from class: com.vungle.warren.downloader.AssetDownloader.7
                @Override // java.lang.Runnable
                public void run() {
                    String unused = AssetDownloader.f61959q;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("On progress ");
                    sb2.append(eVar);
                    aVar.c(bVar, eVar);
                }
            });
        }
    }

    public final void X(androidx.core.util.e<e, com.vungle.warren.downloader.a> eVar, File file) {
        com.vungle.warren.downloader.a aVar = eVar.f7890b;
        if (aVar != null) {
            aVar.a(file, eVar.f7889a);
        }
    }

    public final HashMap<String, String> Y(File file) {
        return i.f(file.getPath());
    }

    public final synchronized DownloadRequestMediator Z(e eVar) {
        ArrayList<DownloadRequestMediator> arrayList = new ArrayList(2);
        arrayList.add(this.f61969j.get(a0(eVar)));
        arrayList.add(this.f61969j.get(c0(eVar)));
        for (DownloadRequestMediator downloadRequestMediator : arrayList) {
            if (downloadRequestMediator != null) {
                Iterator<e> it = downloadRequestMediator.requests().iterator();
                while (it.hasNext()) {
                    if (it.next().equals(eVar)) {
                        return downloadRequestMediator;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.vungle.warren.downloader.Downloader
    public synchronized void a() {
        f fVar = this.f61960a;
        if (fVar != null) {
            fVar.clear();
        }
    }

    public final String a0(e eVar) {
        return eVar.f61994b;
    }

    @Override // com.vungle.warren.downloader.Downloader
    public synchronized void b() {
        try {
            for (e eVar : this.f61970k) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cancel in transtiotion ");
                sb2.append(eVar.f61994b);
                h(eVar);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cancel in mediator ");
            sb3.append(this.f61969j.values().size());
            for (DownloadRequestMediator downloadRequestMediator : this.f61969j.values()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Cancel in mediator ");
                sb4.append(downloadRequestMediator.key);
                o0(downloadRequestMediator);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final long b0(Response response) {
        if (response == null) {
            return -1L;
        }
        String str = response.headers().get(HttpHeaders.CONTENT_LENGTH);
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    @Override // com.vungle.warren.downloader.Downloader
    public boolean c(@Nullable String str) {
        f fVar = this.f61960a;
        if (fVar != null && str != null) {
            try {
                File fileA = fVar.a(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Deleting ");
                sb2.append(fileA.getPath());
                return this.f61960a.g(fileA);
            } catch (IOException e11) {
                VungleLogger.c("AssetDownloader#dropCache; loadAd sequence", String.format("Error %1$s occured", e11));
                Log.e(f61959q, "There was an error to get file", e11);
            }
        }
        return false;
    }

    public final String c0(e eVar) {
        return eVar.f61994b + " " + eVar.f61995c;
    }

    @Override // com.vungle.warren.downloader.Downloader
    public synchronized List<e> d() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = new ArrayList(this.f61969j.values()).iterator();
            while (it.hasNext()) {
                arrayList.addAll(((DownloadRequestMediator) it.next()).requests());
            }
            arrayList.addAll(this.f61970k);
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
    }

    public final boolean d0(DownloadRequestMediator downloadRequestMediator) {
        for (e eVar : downloadRequestMediator.requests()) {
            if (eVar != null && f0(eVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.vungle.warren.downloader.Downloader
    public boolean e(@Nullable e eVar, long j11) {
        if (eVar == null) {
            return false;
        }
        h(eVar);
        long jCurrentTimeMillis = System.currentTimeMillis() + Math.max(0L, j11);
        while (System.currentTimeMillis() < jCurrentTimeMillis) {
            DownloadRequestMediator downloadRequestMediatorZ = Z(eVar);
            synchronized (this) {
                try {
                    if (this.f61970k.contains(eVar) || (downloadRequestMediatorZ != null && downloadRequestMediatorZ.requests().contains(eVar))) {
                    }
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            z0(10L);
        }
        return false;
    }

    public synchronized boolean e0() {
        return this.f61960a != null && this.f61973n;
    }

    @Override // com.vungle.warren.downloader.Downloader
    public synchronized void f(final e eVar, final com.vungle.warren.downloader.a aVar) {
        try {
            if (eVar == null) {
                VungleLogger.c("AssetDownloader#download; loadAd sequence", "downloadRequest is null");
                if (aVar != null) {
                    V(null, aVar, new com.vungle.warren.downloader.a.C0629a(-1, new IllegalArgumentException("DownloadRequest is null"), 1));
                }
            } else {
                VungleLogger.i(true, f61959q, "ttDownloadContext", String.format("Waiting for download asset %1$s, at: %2$d", eVar, Long.valueOf(System.currentTimeMillis())));
                this.f61970k.add(eVar);
                this.f61966g.a(new DownloadPriorityRunnable(new b(-2147483647, 0)) { // from class: com.vungle.warren.downloader.AssetDownloader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VungleLogger.i(true, AssetDownloader.f61959q, "ttDownloadContext", String.format("Start to download asset %1$s, at: %2$d", eVar, Long.valueOf(System.currentTimeMillis())));
                        try {
                            AssetDownloader.this.g0(eVar, aVar);
                        } catch (IOException e11) {
                            VungleLogger.c("AssetDownloader#download; loadAd sequence", "cannot launch request due to " + e11);
                            Log.e(AssetDownloader.f61959q, "Error on launching request", e11);
                            AssetDownloader.this.V(eVar, aVar, new com.vungle.warren.downloader.a.C0629a(-1, e11, 1));
                        }
                    }
                }, new Runnable() { // from class: com.vungle.warren.downloader.AssetDownloader.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AssetDownloader.this.V(eVar, aVar, new com.vungle.warren.downloader.a.C0629a(-1, new VungleException(39), 1));
                    }
                });
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0026  */
    /* JADX WARN: Code duplicated, block: B:21:0x0028  */
    @TargetApi(21)
    public final boolean f0(@NonNull e eVar) {
        int i11;
        int iE = this.f61965f.e();
        if (iE >= 0 && eVar.f61993a == 3) {
            return true;
        }
        if (iE == 0) {
            i11 = 1;
        } else if (iE == 1) {
            i11 = 2;
        } else if (iE == 4) {
            i11 = 1;
        } else if (iE == 9) {
            i11 = 2;
        } else if (iE == 17) {
            i11 = 1;
        } else if (iE == 6) {
            i11 = 2;
        } else if (iE != 7) {
            i11 = -1;
        } else {
            i11 = 1;
        }
        boolean z11 = i11 > 0 && (eVar.f61993a & i11) == i11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("checking pause for type: ");
        sb2.append(iE);
        sb2.append(" connected ");
        sb2.append(z11);
        sb2.append(R(eVar));
        return z11;
    }

    @Override // com.vungle.warren.downloader.Downloader
    public synchronized void g(boolean z11) {
        this.f61973n = z11;
    }

    public final void g0(e eVar, com.vungle.warren.downloader.a aVar) throws IOException {
        synchronized (this.f61971l) {
            synchronized (this) {
                if (eVar.d()) {
                    this.f61970k.remove(eVar);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Request ");
                    sb2.append(eVar.f61994b);
                    sb2.append(" is cancelled before starting");
                    new com.vungle.warren.downloader.a.b().f61979a = 3;
                    V(eVar, aVar, new com.vungle.warren.downloader.a.C0629a(-1, new IOException("Cancelled"), 1));
                    return;
                }
                DownloadRequestMediator downloadRequestMediator = this.f61969j.get(l0(eVar));
                if (downloadRequestMediator == null) {
                    this.f61970k.remove(eVar);
                    DownloadRequestMediator downloadRequestMediatorJ0 = j0(eVar, aVar);
                    this.f61969j.put(downloadRequestMediatorJ0.key, downloadRequestMediatorJ0);
                    h0(downloadRequestMediatorJ0);
                    return;
                }
                try {
                    downloadRequestMediator.lock();
                    synchronized (this) {
                        try {
                            this.f61970k.remove(eVar);
                            if (downloadRequestMediator.is(6) || (downloadRequestMediator.is(3) && !eVar.d())) {
                                DownloadRequestMediator downloadRequestMediatorJ1 = j0(eVar, aVar);
                                this.f61969j.put(downloadRequestMediator.key, downloadRequestMediatorJ1);
                                h0(downloadRequestMediatorJ1);
                            } else if (downloadRequestMediator.isCacheable) {
                                downloadRequestMediator.add(eVar, aVar);
                                if (downloadRequestMediator.is(2)) {
                                    h0(downloadRequestMediator);
                                }
                            } else {
                                VungleLogger.j("AssetDownloader#launchRequest; loadAd sequence", "request " + eVar + " is already running");
                                V(eVar, aVar, new com.vungle.warren.downloader.a.C0629a(-1, new IllegalArgumentException("DownloadRequest is already running"), 1));
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    downloadRequestMediator.unlock();
                } catch (Throwable th3) {
                    downloadRequestMediator.unlock();
                    throw th3;
                }
            }
        }
    }

    @Override // com.vungle.warren.downloader.Downloader
    public synchronized void h(@Nullable e eVar) {
        if (eVar == null) {
            return;
        }
        n0(eVar);
    }

    public final synchronized void h0(final DownloadRequestMediator downloadRequestMediator) {
        N();
        downloadRequestMediator.set(1);
        this.f61966g.a(new DownloadPriorityRunnable(downloadRequestMediator) { // from class: com.vungle.warren.downloader.AssetDownloader.3
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:657:? -> B:466:0x0b8e). Please report as a decompilation issue!!! */
            /*  JADX ERROR: Type inference failed
                jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 34851. Try increasing type updates limit count.
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
                */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    Method dump skipped, instruction units count: 3485
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.AnonymousClass3.run():void");
            }
        }, new Runnable() { // from class: com.vungle.warren.downloader.AssetDownloader.4
            @Override // java.lang.Runnable
            public void run() {
                AssetDownloader.this.p0(new com.vungle.warren.downloader.a.C0629a(-1, new VungleException(39), 1), downloadRequestMediator);
            }
        });
    }

    @Override // com.vungle.warren.downloader.Downloader
    public void i(e eVar) {
        Runnable runnable;
        final DownloadRequestMediator downloadRequestMediatorZ = Z(eVar);
        if (downloadRequestMediatorZ == null || (runnable = downloadRequestMediatorZ.getRunnable()) == null || !this.f61966g.remove(runnable)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("prio: updated to ");
        sb2.append(downloadRequestMediatorZ.getPriority());
        this.f61966g.a(runnable, new Runnable() { // from class: com.vungle.warren.downloader.AssetDownloader.8
            @Override // java.lang.Runnable
            public void run() {
                AssetDownloader.this.p0(new com.vungle.warren.downloader.a.C0629a(-1, new VungleException(39), 1), downloadRequestMediatorZ);
            }
        });
    }

    public final HashMap<String, String> i0(File file, Headers headers, String str) throws Throwable {
        HashMap<String, String> map = new HashMap<>();
        map.put("Download_URL", str);
        map.put("ETag", headers.get("ETag"));
        map.put(HttpHeaders.LAST_MODIFIED, headers.get(HttpHeaders.LAST_MODIFIED));
        map.put("Accept-Ranges", headers.get("Accept-Ranges"));
        map.put(HttpHeaders.CONTENT_ENCODING, headers.get(HttpHeaders.CONTENT_ENCODING));
        y0(file, map);
        return map;
    }

    @Override // com.vungle.warren.downloader.Downloader
    public synchronized void init() {
        f fVar = this.f61960a;
        if (fVar != null) {
            fVar.init();
        }
    }

    public final DownloadRequestMediator j0(e eVar, com.vungle.warren.downloader.a aVar) throws IOException {
        File fileA;
        File fileD;
        String str;
        boolean z11;
        if (e0()) {
            fileA = this.f61960a.a(eVar.f61994b);
            fileD = this.f61960a.d(fileA);
            str = eVar.f61994b;
            z11 = true;
        } else {
            fileA = new File(eVar.f61995c);
            fileD = new File(fileA.getPath() + ".vng_meta");
            str = eVar.f61994b + " " + eVar.f61995c;
            z11 = false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Destination file ");
        sb2.append(fileA.getPath());
        return new DownloadRequestMediator(eVar, aVar, fileA.getPath(), fileD.getPath(), z11, str);
    }

    public final int k0(Throwable th2, boolean z11) {
        if (th2 instanceof RuntimeException) {
            return 4;
        }
        if (!z11 || (th2 instanceof SocketException) || (th2 instanceof SocketTimeoutException)) {
            return 0;
        }
        return ((th2 instanceof UnknownHostException) || (th2 instanceof SSLException)) ? 1 : 2;
    }

    public final String l0(@NonNull e eVar) {
        return e0() ? a0(eVar) : c0(eVar);
    }

    public final boolean m0(@NonNull File file, @Nullable Response response, @NonNull DownloadRequestMediator downloadRequestMediator, @NonNull HashMap<String, String> map) {
        if (response != null && file.exists() && file.length() > 0 && downloadRequestMediator.isCacheable) {
            int iCode = response.code();
            if (Boolean.parseBoolean(map.get("DOWNLOAD_COMPLETE")) && iCode == 304) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("304 code, data size matches file size ");
                sb2.append(S(downloadRequestMediator));
                return true;
            }
        }
        return false;
    }

    public final void n0(@NonNull e eVar) {
        if (eVar.d()) {
            return;
        }
        eVar.a();
        DownloadRequestMediator downloadRequestMediatorZ = Z(eVar);
        if (downloadRequestMediatorZ != null && downloadRequestMediatorZ.getStatus() != 3) {
            androidx.core.util.e<e, com.vungle.warren.downloader.a> eVarRemove = downloadRequestMediatorZ.remove(eVar);
            e eVar2 = eVarRemove == null ? null : eVarRemove.f7889a;
            com.vungle.warren.downloader.a aVar = eVarRemove != null ? eVarRemove.f7890b : null;
            if (downloadRequestMediatorZ.values().isEmpty()) {
                downloadRequestMediatorZ.set(3);
            }
            if (eVar2 == null) {
                return;
            }
            com.vungle.warren.downloader.a.b bVar = new com.vungle.warren.downloader.a.b();
            bVar.f61979a = 3;
            W(bVar, eVar2, aVar);
        }
        w0();
    }

    public final synchronized void o0(@NonNull DownloadRequestMediator downloadRequestMediator) {
        Iterator<e> it = downloadRequestMediator.requests().iterator();
        while (it.hasNext()) {
            n0(it.next());
        }
    }

    public final void p0(@Nullable com.vungle.warren.downloader.a.C0629a c0629a, @NonNull DownloadRequestMediator downloadRequestMediator) {
        VungleLogger.c("AssetDownloader#onErrorMediator; loadAd sequence", String.format("Error %1$s occured; mediator %2$s", c0629a, S(downloadRequestMediator)));
        if (c0629a == null) {
            c0629a = new com.vungle.warren.downloader.a.C0629a(-1, new RuntimeException(), 4);
        }
        try {
            downloadRequestMediator.lock();
            for (androidx.core.util.e<e, com.vungle.warren.downloader.a> eVar : downloadRequestMediator.values()) {
                V(eVar.f7889a, eVar.f7890b, c0629a);
            }
            v0(downloadRequestMediator);
            downloadRequestMediator.set(6);
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    public final synchronized void q0(int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Num of connections: ");
        sb2.append(this.f61969j.values().size());
        for (DownloadRequestMediator downloadRequestMediator : this.f61969j.values()) {
            if (!downloadRequestMediator.is(3)) {
                boolean zD0 = d0(downloadRequestMediator);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Connected = ");
                sb3.append(zD0);
                sb3.append(" for ");
                sb3.append(i11);
                downloadRequestMediator.setConnected(zD0);
                if (downloadRequestMediator.isPausable() && zD0 && downloadRequestMediator.is(2)) {
                    h0(downloadRequestMediator);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("resumed ");
                    sb4.append(downloadRequestMediator.key);
                    sb4.append(" ");
                    sb4.append(downloadRequestMediator);
                }
            }
        }
    }

    public final void r0(DownloadRequestMediator downloadRequestMediator, com.vungle.warren.downloader.a.b bVar) {
        if (downloadRequestMediator == null) {
            return;
        }
        com.vungle.warren.downloader.a.b bVarA = com.vungle.warren.downloader.a.b.a(bVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Progress ");
        sb2.append(bVar.f61980b);
        sb2.append(" status ");
        sb2.append(bVar.f61979a);
        sb2.append(" ");
        sb2.append(downloadRequestMediator);
        sb2.append(" ");
        sb2.append(downloadRequestMediator.filePath);
        for (androidx.core.util.e<e, com.vungle.warren.downloader.a> eVar : downloadRequestMediator.values()) {
            W(bVarA, eVar.f7889a, eVar.f7890b);
        }
    }

    public final void s0(@NonNull File file, @NonNull DownloadRequestMediator downloadRequestMediator) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("OnComplete - Removing connections and listener ");
        sb2.append(downloadRequestMediator);
        try {
            downloadRequestMediator.lock();
            List<androidx.core.util.e<e, com.vungle.warren.downloader.a>> listValues = downloadRequestMediator.values();
            if (!file.exists()) {
                VungleLogger.c("AssetDownloader#onSuccessMediator; loadAd sequence", String.format("File %1$s does not exist; mediator %2$s ", file.getPath(), S(downloadRequestMediator)));
                p0(new com.vungle.warren.downloader.a.C0629a(-1, new IOException("File is deleted"), 2), downloadRequestMediator);
                return;
            }
            f fVar = this.f61960a;
            if (fVar != null && downloadRequestMediator.isCacheable) {
                fVar.c(file, listValues.size());
                this.f61960a.b(file, System.currentTimeMillis());
            }
            for (androidx.core.util.e<e, com.vungle.warren.downloader.a> eVar : listValues) {
                File file2 = new File(eVar.f7889a.f61995c);
                if (file2.equals(file)) {
                    file2 = file;
                } else {
                    Q(file, file2, eVar);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Deliver success:");
                sb3.append(eVar.f7889a.f61994b);
                sb3.append(" dest file: ");
                sb3.append(file2.getPath());
                X(eVar, file2);
            }
            v0(downloadRequestMediator);
            downloadRequestMediator.set(6);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Finished ");
            sb4.append(S(downloadRequestMediator));
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    public final boolean t0(long j11, int i11, Response response, DownloadRequestMediator downloadRequestMediator) {
        return (i11 == 206 && !x0(response, j11, downloadRequestMediator)) || i11 == 416;
    }

    public final boolean u0(DownloadRequestMediator downloadRequestMediator, com.vungle.warren.downloader.a.b bVar, com.vungle.warren.downloader.a.C0629a c0629a) {
        if (downloadRequestMediator.is(3) || d0(downloadRequestMediator)) {
            return false;
        }
        bVar.f61979a = 2;
        com.vungle.warren.downloader.a.b bVarA = com.vungle.warren.downloader.a.b.a(bVar);
        boolean z11 = false;
        for (androidx.core.util.e<e, com.vungle.warren.downloader.a> eVar : downloadRequestMediator.values()) {
            e eVar2 = eVar.f7889a;
            if (eVar2 != null) {
                if (eVar2.f61996d) {
                    downloadRequestMediator.set(2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Pausing download ");
                    sb2.append(R(eVar2));
                    W(bVarA, eVar.f7889a, eVar.f7890b);
                    z11 = true;
                } else {
                    downloadRequestMediator.remove(eVar2);
                    V(eVar2, eVar.f7890b, c0629a);
                }
            }
        }
        if (!z11) {
            downloadRequestMediator.set(5);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Attempted to pause - ");
        sb3.append(downloadRequestMediator.getStatus() == 2);
        return z11;
    }

    public final synchronized void v0(DownloadRequestMediator downloadRequestMediator) {
        this.f61969j.remove(downloadRequestMediator.key);
    }

    public final void w0() {
        if (this.f61969j.isEmpty()) {
            this.f61965f.j(this.f61974o);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002f  */
    public final boolean x0(Response response, long j11, DownloadRequestMediator downloadRequestMediator) {
        boolean z11;
        h hVar = new h(response.headers().get("Content-Range"));
        if (response.code() == 206 && "bytes".equalsIgnoreCase(hVar.f62005a)) {
            long j12 = hVar.f62006b;
            if (j12 < 0 || j11 != j12) {
                z11 = false;
            } else {
                z11 = true;
            }
        } else {
            z11 = false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("satisfies partial download: ");
        sb2.append(z11);
        sb2.append(" ");
        sb2.append(S(downloadRequestMediator));
        return z11;
    }

    public final void y0(@NonNull File file, @NonNull HashMap<String, String> map) throws Throwable {
        i.i(file.getPath(), map);
    }

    public final void z0(long j11) {
        try {
            Thread.sleep(Math.max(0L, j11));
        } catch (InterruptedException e11) {
            Log.e(f61959q, "InterruptedException ", e11);
            Thread.currentThread().interrupt();
        }
    }
}
