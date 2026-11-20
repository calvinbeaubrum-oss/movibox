package com.tn.tranpay.network;

import com.tn.tranpay.TranPayConfiguration;
import gq.a;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.c0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RetrofitClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RetrofitClient f50182a = new RetrofitClient();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f50183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f50184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f50185d;

    static {
        f50183b = TranPayConfiguration.f50046a.q() ? "https://api.paynicorn.com" : "https://test.paynicorn.com/";
        f50184c = LazyKt__LazyJVMKt.b(new Function0<OkHttpClient>() { // from class: com.tn.tranpay.network.RetrofitClient$okHttpClient$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder builderAddNetworkInterceptor = new OkHttpClient.Builder().addNetworkInterceptor(new a()).addNetworkInterceptor(httpLoggingInterceptor);
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return builderAddNetworkInterceptor.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
            }
        });
        f50185d = LazyKt__LazyJVMKt.b(new Function0<c0>() { // from class: com.tn.tranpay.network.RetrofitClient$retrofit$2
            @Override // kotlin.jvm.functions.Function0
            public final c0 invoke() {
                return new c0.b().c(RetrofitClient.f50183b).g(RetrofitClient.f50182a.c()).b(x30.a.f()).e();
            }
        });
    }

    public final OkHttpClient c() {
        return (OkHttpClient) f50184c.getValue();
    }

    public final c0 d() {
        Object value = f50185d.getValue();
        Intrinsics.f(value, "<get-retrofit>(...)");
        return (c0) value;
    }
}
