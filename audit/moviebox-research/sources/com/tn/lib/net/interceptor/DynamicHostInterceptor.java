package com.tn.lib.net.interceptor;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tn.lib.net.dns.or.CacheIpPool;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import uo.b;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DynamicHostInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f49393b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f49394a = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.tn.lib.net.interceptor.DynamicHostInterceptor$handler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.g(chain, "chain");
        Request request = chain.request();
        HttpUrl.Builder builderNewBuilder = request.url().newBuilder();
        String strHost = request.url().host();
        CacheIpPool cacheIpPool = CacheIpPool.f49384a;
        if (TextUtils.equals(strHost, cacheIpPool.g()) && TextUtils.equals(request.url().scheme(), cacheIpPool.h())) {
            builderNewBuilder.removeAllQueryParameters("host");
        } else {
            builderNewBuilder.scheme(cacheIpPool.h()).host(cacheIpPool.g()).removeAllQueryParameters("host");
        }
        Request requestBuild = request.newBuilder().url(builderNewBuilder.build()).build();
        Response responseProceed = chain.proceed(requestBuild);
        b.f78622a.n("HttpTag", new String[]{"DynamicHostInterceptor response " + responseProceed.code() + " : " + requestBuild.url() + " protocol: " + responseProceed.protocol() + " "}, true);
        return responseProceed;
    }
}
