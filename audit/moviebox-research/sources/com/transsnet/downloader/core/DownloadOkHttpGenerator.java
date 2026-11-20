package com.transsnet.downloader.core;

import com.blankj.utilcode.util.n;
import com.tn.lib.net.cons.PrefetchDnsUrls;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadOkHttpGenerator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f60434c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<DownloadOkHttpGenerator> f60435d = LazyKt__LazyJVMKt.b(new Function0<DownloadOkHttpGenerator>() { // from class: com.transsnet.downloader.core.DownloadOkHttpGenerator$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadOkHttpGenerator invoke() {
            return new DownloadOkHttpGenerator();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile OkHttpClient f60436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f60437b = g.q("vcdn.hakunaymatata.com", "v2cdn.hakunaymatata.com");

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadOkHttpGenerator a() {
            return (DownloadOkHttpGenerator) DownloadOkHttpGenerator.f60435d.getValue();
        }
    }

    public DownloadOkHttpGenerator() {
        PrefetchDnsUrls prefetchDnsUrls;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("prefetch_dns_hosts", false);
        String value = configBeanB != null ? configBeanB.getValue() : null;
        if (value != null) {
            try {
                if (value.length() <= 0 || (prefetchDnsUrls = (PrefetchDnsUrls) n.d(value, PrefetchDnsUrls.class)) == null || !(!prefetchDnsUrls.getHosts().isEmpty())) {
                    return;
                }
                this.f60437b.clear();
                this.f60437b.addAll(prefetchDnsUrls.getHosts());
            } catch (Throwable unused) {
            }
        }
    }

    public final OkHttpClient b() {
        OkHttpClient okHttpClientC = this.f60436a;
        if (okHttpClientC == null) {
            synchronized (this) {
                okHttpClientC = this.f60436a;
                if (okHttpClientC == null) {
                    okHttpClientC = c();
                    this.f60436a = okHttpClientC;
                }
            }
        }
        return okHttpClientC;
    }

    public final OkHttpClient c() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory sSLSocketFactoryA = hp.a.a();
        Intrinsics.f(sSLSocketFactoryA, "createSSLSocketFactory()");
        OkHttpClient.Builder builderHostnameVerifier = builder.sslSocketFactory(sSLSocketFactoryA, new hp.a()).hostnameVerifier(new hp.a.C0701a());
        TimeUnit timeUnit = TimeUnit.MINUTES;
        OkHttpClient.Builder timeout = builderHostnameVerifier.connectionPool(new ConnectionPool(16, 5L, timeUnit)).connectTimeout(1L, timeUnit).retryOnConnectionFailure(true).writeTimeout(1L, timeUnit).readTimeout(1L, timeUnit);
        List<? extends Protocol> listSingletonList = Collections.singletonList(Protocol.HTTP_1_1);
        Intrinsics.f(listSingletonList, "singletonList(Protocol.HTTP_1_1)");
        return timeout.protocols(listSingletonList).build();
    }
}
