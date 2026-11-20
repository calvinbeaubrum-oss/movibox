package com.tmc.network;

import com.tmc.network.strategy.LocalDnsStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.CertificatePinner;
import okhttp3.Dns;
import okhttp3.Interceptor;

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
public final class HttpClientConfig {
    public static final long DEFAULT_CONNECT_TIMEOUT = 10000;
    public static final long DEFAULT_KEEP_ALIVE_DURATION_MINUTES = 5;
    public static final int DEFAULT_MAX_IDLE_CONNECTIONS = 5;
    public static final long DEFAULT_READ_TIMEOUT = 30000;
    public static final long DEFAULT_WRITE_TIMEOUT = 30000;
    private CertificatePinner certificatePinner;
    private ExecutorService executorService;
    private List<Interceptor> interceptors;
    private long keepAliveDuration;
    private TimeUnit keepAliveTimeUnit;
    private Dns localDns;
    private int maxIdleConnections;
    private List<Interceptor> networkInterceptors;
    private long timeoutConnect;
    private long timeoutRead;
    private long timeoutWrite;
    public static final Companion Companion = new Companion(null);
    private static final TimeUnit DEFAULT_KEEP_ALIVE_DURATION_TIME_UNIT = TimeUnit.MINUTES;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TimeUnit getDEFAULT_KEEP_ALIVE_DURATION_TIME_UNIT() {
            return HttpClientConfig.DEFAULT_KEEP_ALIVE_DURATION_TIME_UNIT;
        }
    }

    @JvmOverloads
    public HttpClientConfig() {
        this(0, 0L, null, 7, null);
    }

    @JvmOverloads
    public HttpClientConfig(int i11) {
        this(i11, 0L, null, 6, null);
    }

    @JvmOverloads
    public HttpClientConfig(int i11, long j11) {
        this(i11, j11, null, 4, null);
    }

    @JvmOverloads
    public HttpClientConfig(int i11, long j11, TimeUnit timeUnit) {
        List<Interceptor> list;
        this.maxIdleConnections = i11;
        this.keepAliveDuration = j11;
        this.keepAliveTimeUnit = timeUnit;
        this.timeoutConnect = 10000L;
        this.timeoutRead = 30000L;
        this.timeoutWrite = 30000L;
        ArrayList arrayList = new ArrayList();
        this.interceptors = arrayList;
        arrayList.add(new LogInterceptor());
        if (HttpClient.Companion.isForceUseCacheMode() && (list = this.interceptors) != null) {
            list.add(new NetCacheInterceptor());
        }
        ArrayList arrayList2 = new ArrayList();
        this.networkInterceptors = arrayList2;
        arrayList2.add(new InitNetworkInterceptor());
        this.localDns = LocalDnsStrategy.f49355c.a();
    }

    public /* synthetic */ HttpClientConfig(int i11, long j11, TimeUnit timeUnit, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 5 : i11, (i12 & 2) != 0 ? 5L : j11, (i12 & 4) != 0 ? DEFAULT_KEEP_ALIVE_DURATION_TIME_UNIT : timeUnit);
    }

    public final HttpClientConfig addInterceptor(Interceptor interceptor) {
        if (interceptor == null) {
            return this;
        }
        if (this.interceptors == null) {
            this.interceptors = new ArrayList();
        }
        List<Interceptor> list = this.interceptors;
        if (list != null) {
            list.add(interceptor);
        }
        return this;
    }

    public final HttpClientConfig addNetInterceptor(Interceptor interceptor) {
        if (interceptor == null) {
            return this;
        }
        if (this.networkInterceptors == null) {
            this.networkInterceptors = new ArrayList();
        }
        List<Interceptor> list = this.networkInterceptors;
        if (list != null) {
            list.add(interceptor);
        }
        return this;
    }

    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final long getKeepAliveDuration() {
        return this.keepAliveDuration;
    }

    public final TimeUnit getKeepAliveTimeUnit() {
        return this.keepAliveTimeUnit;
    }

    public final Dns getLocalDns() {
        return this.localDns;
    }

    public final int getMaxIdleConnections() {
        return this.maxIdleConnections;
    }

    public final List<Interceptor> getNetworkInterceptors() {
        return this.networkInterceptors;
    }

    public final long getTimeoutConnect() {
        return this.timeoutConnect;
    }

    public final long getTimeoutRead() {
        return this.timeoutRead;
    }

    public final long getTimeoutWrite() {
        return this.timeoutWrite;
    }

    public final HttpClientConfig setCertificatePinner(CertificatePinner certificatePinner) {
        this.certificatePinner = certificatePinner;
        return this;
    }

    public final HttpClientConfig setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
        return this;
    }

    public final HttpClientConfig setInterceptors(List<Interceptor> list) {
        this.interceptors = list;
        return this;
    }

    public final HttpClientConfig setKeepAliveDuration(long j11) {
        this.keepAliveDuration = j11;
        return this;
    }

    public final HttpClientConfig setKeepAliveTimeUnit(TimeUnit timeUnit) {
        this.keepAliveTimeUnit = timeUnit;
        return this;
    }

    public final HttpClientConfig setMaxIdleConnections(int i11) {
        this.maxIdleConnections = i11;
        return this;
    }

    public final HttpClientConfig setNetworkInterceptors(List<Interceptor> list) {
        this.networkInterceptors = list;
        return this;
    }

    public final HttpClientConfig setTimeout(long j11, long j12, long j13) {
        this.timeoutConnect = j11;
        this.timeoutRead = j12;
        this.timeoutWrite = j13;
        return this;
    }
}
