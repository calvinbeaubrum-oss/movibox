package com.amazonaws;

import com.amazonaws.auth.RegionAwareSigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.HttpClient;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Classes;
import com.amazonaws.util.StringUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AmazonWebServiceClient {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Log f15604k = LogFactory.b(AmazonWebServiceClient.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile URI f15605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f15606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ClientConfiguration f15607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AmazonHttpClient f15608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<RequestHandler2> f15609e = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Signer f15611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f15612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f15613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile Region f15614j;

    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.f15607c = clientConfiguration;
        this.f15608d = new AmazonHttpClient(clientConfiguration, httpClient);
    }

    @Deprecated
    public static boolean r() {
        return System.getProperty("com.amazonaws.sdk.enableRuntimeProfiling") != null;
    }

    public final String g() {
        int i11;
        String simpleName = Classes.childClassOf(AmazonWebServiceClient.class, this).getSimpleName();
        String serviceName = ServiceNameFactory.getServiceName(simpleName);
        if (serviceName != null) {
            return serviceName;
        }
        int iIndexOf = simpleName.indexOf("JavaClient");
        if (iIndexOf == -1 && (iIndexOf = simpleName.indexOf("Client")) == -1) {
            throw new IllegalStateException("Unrecognized suffix for the AWS http client class name " + simpleName);
        }
        int iIndexOf2 = simpleName.indexOf("Amazon");
        if (iIndexOf2 == -1) {
            iIndexOf2 = simpleName.indexOf("AWS");
            if (iIndexOf2 == -1) {
                throw new IllegalStateException("Unrecognized prefix for the AWS http client class name " + simpleName);
            }
            i11 = 3;
        } else {
            i11 = 6;
        }
        if (iIndexOf2 < iIndexOf) {
            return StringUtils.b(simpleName.substring(iIndexOf2 + i11, iIndexOf));
        }
        throw new IllegalStateException("Unrecognized AWS http client class name " + simpleName);
    }

    public final Signer h(String str, String str2, String str3, boolean z11) {
        String strE = this.f15607c.e();
        Signer signerB = strE == null ? SignerFactory.b(str, str2) : SignerFactory.c(strE, str);
        if (signerB instanceof RegionAwareSigner) {
            RegionAwareSigner regionAwareSigner = (RegionAwareSigner) signerB;
            if (str3 != null) {
                regionAwareSigner.c(str3);
            } else if (str2 != null && z11) {
                regionAwareSigner.c(str2);
            }
        }
        synchronized (this) {
            this.f15614j = Region.f(str2);
        }
        return signerB;
    }

    public final Signer i(URI uri, String str, boolean z11) {
        if (uri == null) {
            throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
        }
        String strO = o();
        return h(strO, AwsHostNameUtils.a(uri.getHost(), strO), str, z11);
    }

    @Deprecated
    public final void j(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response) {
        k(aWSRequestMetrics, request, response, false);
    }

    @Deprecated
    public final void k(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response, boolean z11) {
        if (request != null) {
            aWSRequestMetrics.b(AWSRequestMetrics.Field.ClientExecuteTime);
            aWSRequestMetrics.c().c();
            l(request).a(request, response);
        }
        if (z11) {
            aWSRequestMetrics.e();
        }
    }

    @Deprecated
    public final RequestMetricCollector l(Request<?> request) {
        RequestMetricCollector requestMetricCollector = request.m().getRequestMetricCollector();
        if (requestMetricCollector != null) {
            return requestMetricCollector;
        }
        RequestMetricCollector requestMetricCollectorN = n();
        return requestMetricCollectorN == null ? AwsSdkMetrics.getRequestMetricCollector() : requestMetricCollectorN;
    }

    public String m() {
        return this.f15613i;
    }

    @Deprecated
    public RequestMetricCollector n() {
        return this.f15608d.f();
    }

    public String o() {
        if (this.f15612h == null) {
            synchronized (this) {
                try {
                    if (this.f15612h == null) {
                        this.f15612h = g();
                        return this.f15612h;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f15612h;
    }

    public Signer p(URI uri) {
        return i(uri, this.f15606b, true);
    }

    public final String q() {
        return this.f15606b;
    }

    @Deprecated
    public final boolean s() {
        RequestMetricCollector requestMetricCollectorU = u();
        return requestMetricCollectorU != null && requestMetricCollectorU.b();
    }

    @Deprecated
    public final boolean t(AmazonWebServiceRequest amazonWebServiceRequest) {
        RequestMetricCollector requestMetricCollector = amazonWebServiceRequest.getRequestMetricCollector();
        if (requestMetricCollector == null || !requestMetricCollector.b()) {
            return s();
        }
        return true;
    }

    @Deprecated
    public RequestMetricCollector u() {
        RequestMetricCollector requestMetricCollectorF = this.f15608d.f();
        return requestMetricCollectorF == null ? AwsSdkMetrics.getRequestMetricCollector() : requestMetricCollectorF;
    }

    public void v(String str) {
        URI uriX = x(str);
        Signer signerI = i(uriX, this.f15606b, false);
        synchronized (this) {
            this.f15605a = uriX;
            this.f15611g = signerI;
        }
    }

    public void w(Region region) {
        String strG;
        if (region == null) {
            throw new IllegalArgumentException("No region provided");
        }
        String strO = o();
        if (region.i(strO)) {
            strG = region.g(strO);
            int iIndexOf = strG.indexOf("://");
            if (iIndexOf >= 0) {
                strG = strG.substring(iIndexOf + 3);
            }
        } else {
            strG = String.format("%s.%s.%s", m(), region.d(), region.a());
        }
        URI uriX = x(strG);
        Signer signerH = h(strO, region.d(), this.f15606b, false);
        synchronized (this) {
            this.f15605a = uriX;
            this.f15611g = signerH;
        }
    }

    public final URI x(String str) {
        if (!str.contains("://")) {
            str = this.f15607c.c().toString() + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e11) {
            throw new IllegalArgumentException(e11);
        }
    }
}
