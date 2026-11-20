package com.tmc.network;

import android.os.Environment;
import android.util.Log;
import com.tmc.network.log.LogLevel;
import com.transsion.api.gateway.GateWaySdk;
import com.transsion.api.gateway.interceptor.GatewayInterceptor;
import java.io.File;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class HttpClient {
    public static final Companion Companion = new Companion(null);
    private static boolean ifForceUseCache;
    private static boolean ifInitAnalytics;
    private static boolean ifTestMode;
    private static boolean ifUseCache;
    private static List<Interceptor> initInterceptors;
    private static ProgressListener progressListener;
    private HttpClientConfig config;
    private OkHttpClient mOkHttpClient;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void addInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                return;
            }
            if (HttpClient.initInterceptors == null) {
                HttpClient.initInterceptors = new ArrayList();
            }
            List list = HttpClient.initInterceptors;
            if (list == null) {
                return;
            }
            list.add(interceptor);
        }

        public final boolean isForceUseCacheMode() {
            return HttpClient.ifUseCache && HttpClient.ifForceUseCache;
        }

        public final void setCacheMode(boolean z11, boolean z12) {
            HttpClient.ifUseCache = z11;
            HttpClient.ifForceUseCache = z12;
        }

        public final void setIfInitAnalytics(boolean z11) {
            HttpClient.ifInitAnalytics = z11;
        }

        public final void setIfTestMode(boolean z11) {
            HttpClient.ifTestMode = z11;
        }

        public final void setProgressListener(ProgressListener progressListener) {
            HttpClient.progressListener = progressListener;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public HttpClient() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public HttpClient(HttpClientConfig httpClientConfig) {
        setConfig(httpClientConfig == null ? new HttpClientConfig(0, 0L, null, 7, null) : httpClientConfig);
    }

    public /* synthetic */ HttpClient(HttpClientConfig httpClientConfig, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new HttpClientConfig(0, 0L, null, 7, null) : httpClientConfig);
    }

    private final SSLSocketFactory createSSLSocketFactory(TrustManager[] trustManagerArr) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
            return null;
        }
    }

    public final HttpClientConfig getConfig() {
        return this.config;
    }

    public final synchronized OkHttpClient getOkHttpClient() {
        return this.mOkHttpClient;
    }

    public final synchronized Call newCall(Request request) {
        Call callNewCall;
        OkHttpClient okHttpClient = this.mOkHttpClient;
        if (okHttpClient == null) {
            callNewCall = null;
        } else {
            Intrinsics.d(request);
            callNewCall = okHttpClient.newCall(request);
        }
        return callNewCall;
    }

    public final synchronized void resetHttpClient() {
        Dns localDns;
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpClientConfig httpClientConfig = this.config;
            Intrinsics.d(httpClientConfig);
            long timeoutConnect = httpClientConfig.getTimeoutConnect();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder builderConnectTimeout = builder.connectTimeout(timeoutConnect, timeUnit);
            HttpClientConfig httpClientConfig2 = this.config;
            Intrinsics.d(httpClientConfig2);
            OkHttpClient.Builder builderWriteTimeout = builderConnectTimeout.writeTimeout(httpClientConfig2.getTimeoutWrite(), timeUnit);
            HttpClientConfig httpClientConfig3 = this.config;
            Intrinsics.d(httpClientConfig3);
            OkHttpClient.Builder timeout = builderWriteTimeout.readTimeout(httpClientConfig3.getTimeoutRead(), timeUnit);
            HttpClientConfig httpClientConfig4 = this.config;
            Intrinsics.d(httpClientConfig4);
            int maxIdleConnections = httpClientConfig4.getMaxIdleConnections();
            HttpClientConfig httpClientConfig5 = this.config;
            Intrinsics.d(httpClientConfig5);
            long keepAliveDuration = httpClientConfig5.getKeepAliveDuration();
            HttpClientConfig httpClientConfig6 = this.config;
            CertificatePinner certificatePinner = null;
            TimeUnit keepAliveTimeUnit = httpClientConfig6 == null ? null : httpClientConfig6.getKeepAliveTimeUnit();
            Intrinsics.d(keepAliveTimeUnit);
            OkHttpClient.Builder builderConnectionPool = timeout.connectionPool(new ConnectionPool(maxIdleConnections, keepAliveDuration, keepAliveTimeUnit));
            if (ifUseCache) {
                builderConnectionPool = builderConnectionPool.cache(new Cache(new File(Environment.getExternalStorageDirectory(), "s_cache"), ((Long) 10485760).longValue()));
            }
            HttpClientConfig httpClientConfig7 = this.config;
            if ((httpClientConfig7 == null ? null : httpClientConfig7.getInterceptors()) != null) {
                builderConnectionPool.addInterceptor(new GatewayInterceptor());
                ProgressListener progressListener2 = progressListener;
                if (progressListener2 != null) {
                    builderConnectionPool.addNetworkInterceptor(new DownloadInterceptor(progressListener2));
                }
                HttpClientConfig httpClientConfig8 = this.config;
                List<Interceptor> interceptors = httpClientConfig8 == null ? null : httpClientConfig8.getInterceptors();
                Intrinsics.d(interceptors);
                for (Interceptor interceptor : interceptors) {
                    if (interceptor != null) {
                        builderConnectionPool.addInterceptor(interceptor);
                    }
                }
            }
            if (Log.isLoggable("mininetwork", 3)) {
                mo.b bVar = new mo.b(new mo.a());
                LogLevel logLevel = LogLevel.BODY;
                bVar.e(logLevel);
                bVar.f(logLevel);
                builderConnectionPool.addNetworkInterceptor(bVar);
            }
            List<Interceptor> list = initInterceptors;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    builderConnectionPool.addInterceptor((Interceptor) it.next());
                }
            }
            HttpClientConfig httpClientConfig9 = this.config;
            if ((httpClientConfig9 == null ? null : httpClientConfig9.getNetworkInterceptors()) != null) {
                HttpClientConfig httpClientConfig10 = this.config;
                List<Interceptor> networkInterceptors = httpClientConfig10 == null ? null : httpClientConfig10.getNetworkInterceptors();
                Intrinsics.d(networkInterceptors);
                for (Interceptor interceptor2 : networkInterceptors) {
                    if (interceptor2 != null) {
                        builderConnectionPool.addNetworkInterceptor(interceptor2);
                    }
                }
            }
            HttpClientConfig httpClientConfig11 = this.config;
            if ((httpClientConfig11 == null ? null : httpClientConfig11.getExecutorService()) != null) {
                HttpClientConfig httpClientConfig12 = this.config;
                ExecutorService executorService = httpClientConfig12 == null ? null : httpClientConfig12.getExecutorService();
                Intrinsics.d(executorService);
                builderConnectionPool.dispatcher(new Dispatcher(executorService));
            }
            HttpClientConfig httpClientConfig13 = this.config;
            if ((httpClientConfig13 == null ? null : httpClientConfig13.getCertificatePinner()) != null) {
                HttpClientConfig httpClientConfig14 = this.config;
                if (httpClientConfig14 != null) {
                    certificatePinner = httpClientConfig14.getCertificatePinner();
                }
                Intrinsics.d(certificatePinner);
                builderConnectionPool.certificatePinner(certificatePinner);
            }
            builderConnectionPool.eventListenerFactory(lo.b.f70347c.a());
            HttpClientConfig httpClientConfig15 = this.config;
            if (httpClientConfig15 != null && (localDns = httpClientConfig15.getLocalDns()) != null) {
                builderConnectionPool.dns(localDns);
            }
            if (ifTestMode) {
                TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.tmc.network.HttpClient$resetHttpClient$trustAllCerts$1
                    @Override // javax.net.ssl.X509TrustManager
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s11) throws CertificateException {
                        Intrinsics.g(x509Certificates, "x509Certificates");
                        Intrinsics.g(s11, "s");
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s11) throws CertificateException {
                        Intrinsics.g(x509Certificates, "x509Certificates");
                        Intrinsics.g(s11, "s");
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }};
                SSLSocketFactory sSLSocketFactoryCreateSSLSocketFactory = createSSLSocketFactory(trustManagerArr);
                Intrinsics.d(sSLSocketFactoryCreateSSLSocketFactory);
                TrustManager trustManager = trustManagerArr[0];
                if (trustManager == null) {
                    throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                }
                builderConnectionPool.sslSocketFactory(sSLSocketFactoryCreateSSLSocketFactory, (X509TrustManager) trustManager);
                builderConnectionPool.hostnameVerifier(new HostnameVerifier() { // from class: com.tmc.network.HttpClient.resetHttpClient.3
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str, SSLSession sSLSession) {
                        return true;
                    }
                });
            }
            OkHttpClient okHttpClientBuild = builderConnectionPool.build();
            this.mOkHttpClient = okHttpClientBuild;
            GateWaySdk.setOkHttpClient(okHttpClientBuild);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void setConfig(HttpClientConfig httpClientConfig) {
        if (httpClientConfig == null) {
            return;
        }
        this.config = httpClientConfig;
        resetHttpClient();
    }
}
