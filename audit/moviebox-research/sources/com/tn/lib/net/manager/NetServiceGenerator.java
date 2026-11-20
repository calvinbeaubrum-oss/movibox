package com.tn.lib.net.manager;

import android.util.Log;
import cm.b;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.tn.lib.net.interceptor.DynamicHostInterceptor;
import com.tn.lib.net.interceptor.HttpLoggingInterceptor;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.thread.e;
import com.transsion.api.gateway.interceptor.GatewayInterceptor;
import ep.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.chromium.net.CronetEngine;
import retrofit2.c0;
import w30.g;
import y30.f;
import y30.o;
import yo.d;

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
@SourceDebugExtension
public final class NetServiceGenerator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f49399d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<NetServiceGenerator> f49400e = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<NetServiceGenerator>() { // from class: com.tn.lib.net.manager.NetServiceGenerator$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NetServiceGenerator invoke() {
            return new NetServiceGenerator();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f49401f = "one_room_net_thread";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f49402a = "NetServiceGenerator";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OkHttpClient f49403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0 f49404c;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NetServiceGenerator a() {
            return (NetServiceGenerator) NetServiceGenerator.f49400e.getValue();
        }
    }

    public NetServiceGenerator() {
        CacheIpPool.f49384a.c();
        this.f49403b = k();
        c0.b bVarC = new c0.b().c(cp.a.f62775a.a());
        OkHttpClient okHttpClient = this.f49403b;
        Intrinsics.d(okHttpClient);
        this.f49404c = bVarC.g(okHttpClient).b(bp.a.f()).a(g.d(q10.a.a(e.f49439g.a(6).b(f49401f).c(10).a()))).e();
    }

    public static final Object d(yo.a newApi, NetServiceGenerator this$0, Object obj, Method method, Object[] objArr) {
        Intrinsics.g(newApi, "$newApi");
        Intrinsics.g(this$0, "this$0");
        Annotation[] annotations = method.getAnnotations();
        Intrinsics.f(annotations, "annotations");
        String strH = "";
        for (Annotation it : annotations) {
            Intrinsics.f(it, "it");
            strH = this$0.h(it);
        }
        for (Annotation it2 : annotations) {
            Intrinsics.f(it2, "it");
            this$0.l(it2, strH);
        }
        return method.invoke(newApi, Arrays.copyOf(objArr, objArr.length));
    }

    public final <T> T c(final yo.a aVar) {
        return (T) Proxy.newProxyInstance(aVar.getClass().getClassLoader(), aVar.getClass().getInterfaces(), new InvocationHandler() { // from class: gp.a
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return NetServiceGenerator.d(aVar, this, obj, method, objArr);
            }
        });
    }

    public final <T> T e(Class<T> cls) {
        return (T) new c0.b().e().b(cls);
    }

    public final Interceptor f() {
        try {
            CronetEngine.Builder builder = new CronetEngine.Builder(Utils.a());
            builder.enableQuic(true).enableQuic(true).enableBrotli(true).addQuicHint("api3.aoneroom.com", 443, 443).addQuicHint("api4.aoneroom.com", 443, 443).addQuicHint("api4sg.aoneroom.com", 443, 443).addQuicHint("api5.aoneroom.com", 443, 443).addQuicHint("api6.aoneroom.com", 443, 443).addQuicHint("api6sg.aoneroom.com", 443, 443).addQuicHint("api.inmoviebox.com", 443, 443).addQuicHint("test-mse-api.aoneroom.com", 443, 443);
            CronetEngine cronetEngineBuild = builder.build();
            Intrinsics.f(cronetEngineBuild, "builder.build()");
            return (Interceptor) b.d(cronetEngineBuild).a();
        } catch (Throwable th2) {
            Log.e("error", "e " + th2.getMessage());
            return null;
        }
    }

    public final OkHttpClient g() {
        return this.f49403b;
    }

    public final String h(Annotation annotation) {
        if (annotation instanceof f) {
            return ((f) annotation).value();
        }
        return annotation instanceof o ? ((o) annotation).value() : "";
    }

    public final <T> T i(Class<T> service) {
        yo.a aVar;
        Intrinsics.g(service, "service");
        c0 c0Var = this.f49404c;
        if (c0Var == null || (aVar = (T) c0Var.b(service)) == null) {
            aVar = (T) e(service);
        }
        try {
            m();
            return aVar instanceof yo.a ? (T) c(aVar) : (T) aVar;
        } catch (Exception e11) {
            e11.printStackTrace();
            return (T) aVar;
        }
    }

    public final OkHttpClient j() {
        com.tn.lib.net.interceptor.a aVar = new com.tn.lib.net.interceptor.a();
        aVar.a("HttpLogInterceptor_glide");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(aVar);
        httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BASIC);
        java.net.Proxy proxy = wo.a.f79569a.c() ? null : java.net.Proxy.NO_PROXY;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory sSLSocketFactoryA = hp.a.a();
        Intrinsics.f(sSLSocketFactoryA, "createSSLSocketFactory()");
        builder.sslSocketFactory(sSLSocketFactoryA, new hp.a()).hostnameVerifier(new hp.a.C0701a());
        OkHttpClient.Builder builderProxy = builder.proxy(proxy);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builderProxy.connectTimeout(40L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit).addInterceptor(httpLoggingInterceptor).build();
    }

    public final OkHttpClient k() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new com.tn.lib.net.interceptor.a());
        httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
        java.net.Proxy proxy = wo.a.f79569a.c() ? null : java.net.Proxy.NO_PROXY;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory sSLSocketFactoryA = hp.a.a();
        Intrinsics.f(sSLSocketFactoryA, "createSSLSocketFactory()");
        builder.sslSocketFactory(sSLSocketFactoryA, new hp.a()).hostnameVerifier(new hp.a.C0701a());
        OkHttpClient.Builder builderProxy = builder.proxy(proxy);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builderProxy.connectTimeout(40L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit).addInterceptor(fp.a.f65207a.a()).addInterceptor(new DynamicHostInterceptor()).addInterceptor(new GatewayInterceptor()).addInterceptor(new ep.a());
        Iterator<T> it = c.f64339a.b().iterator();
        while (it.hasNext()) {
            builder.addInterceptor((Interceptor) it.next());
        }
        OkHttpClient.Builder builderAddInterceptor = builder.addInterceptor(httpLoggingInterceptor);
        Interceptor interceptorF = f();
        if (interceptorF != null) {
            builderAddInterceptor.addInterceptor(interceptorF);
        }
        return builderAddInterceptor.build();
    }

    public final void l(Annotation annotation, String str) {
        if (!(annotation instanceof d)) {
            if (annotation instanceof yo.b) {
                xo.a.f80651a.a(str, ((yo.b) annotation).type());
            }
        } else {
            xo.b bVar = xo.b.f80653a;
            d dVar = (d) annotation;
            bVar.a(dVar.retryCount());
            bVar.b(dVar.timestamp());
        }
    }

    public final void m() {
        xo.b bVar = xo.b.f80653a;
        bVar.a(0);
        bVar.b(0L);
    }
}
