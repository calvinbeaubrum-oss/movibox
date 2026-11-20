package com.transsion.usercenter.net;

import com.tn.lib.net.dns.or.CacheIpPool;
import com.tn.lib.net.interceptor.HttpLoggingInterceptor;
import com.tn.lib.thread.e;
import com.transsion.usercenter.net.HostServiceGenerator;
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
import retrofit2.c0;
import w30.g;
import y30.f;
import y30.o;
import yo.b;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class HostServiceGenerator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f59489c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<HostServiceGenerator> f59490d = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<HostServiceGenerator>() { // from class: com.transsion.usercenter.net.HostServiceGenerator$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HostServiceGenerator invoke() {
            return new HostServiceGenerator();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f59491e = "one_room_net_thread";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OkHttpClient f59492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f59493b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HostServiceGenerator a() {
            return (HostServiceGenerator) HostServiceGenerator.f59490d.getValue();
        }
    }

    public HostServiceGenerator() {
        CacheIpPool.f49384a.c();
        this.f59492a = i();
        c0.b bVarC = new c0.b().c(f());
        OkHttpClient okHttpClient = this.f59492a;
        Intrinsics.d(okHttpClient);
        this.f59493b = bVarC.g(okHttpClient).b(bp.a.f()).a(g.d(q10.a.a(e.f49439g.a(6).b(f59491e).c(10).a()))).e();
    }

    public static final Object d(yo.a newApi, HostServiceGenerator this$0, Object obj, Method method, Object[] objArr) {
        Intrinsics.g(newApi, "$newApi");
        Intrinsics.g(this$0, "this$0");
        Annotation[] annotations = method.getAnnotations();
        Intrinsics.f(annotations, "annotations");
        String strG = "";
        for (Annotation it : annotations) {
            Intrinsics.f(it, "it");
            strG = this$0.g(it);
        }
        for (Annotation it2 : annotations) {
            Intrinsics.f(it2, "it");
            this$0.j(it2, strG);
        }
        return method.invoke(newApi, Arrays.copyOf(objArr, objArr.length));
    }

    public final <T> T c(final yo.a aVar) {
        return (T) Proxy.newProxyInstance(aVar.getClass().getClassLoader(), aVar.getClass().getInterfaces(), new InvocationHandler() { // from class: gz.a
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return HostServiceGenerator.d(aVar, this, obj, method, objArr);
            }
        });
    }

    public final <T> T e(Class<T> cls) {
        return (T) new c0.b().e().b(cls);
    }

    public final String f() {
        return wo.a.f79569a.d() ? "https://test.paynicorn.com" : "https://api.paynicorn.com";
    }

    public final String g(Annotation annotation) {
        if (annotation instanceof f) {
            return ((f) annotation).value();
        }
        return annotation instanceof o ? ((o) annotation).value() : "";
    }

    public final <T> T h(Class<T> service) {
        yo.a aVar;
        Intrinsics.g(service, "service");
        c0 c0Var = this.f59493b;
        if (c0Var == null || (aVar = (T) c0Var.b(service)) == null) {
            aVar = (T) e(service);
        }
        try {
            k();
            return aVar instanceof yo.a ? (T) c(aVar) : (T) aVar;
        } catch (Exception e11) {
            e11.printStackTrace();
            return (T) aVar;
        }
    }

    public final OkHttpClient i() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new com.tn.lib.net.interceptor.a());
        httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
        java.net.Proxy proxy = wo.a.f79569a.c() ? null : java.net.Proxy.NO_PROXY;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory sSLSocketFactoryA = hp.a.a();
        Intrinsics.f(sSLSocketFactoryA, "createSSLSocketFactory()");
        builder.sslSocketFactory(sSLSocketFactoryA, new hp.a()).hostnameVerifier(new hp.a.C0701a());
        OkHttpClient.Builder builderProxy = builder.proxy(proxy);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builderProxy.connectTimeout(40L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit).addInterceptor(fp.a.f65207a.a()).addInterceptor(new ep.a());
        Iterator<T> it = c.f64339a.b().iterator();
        while (it.hasNext()) {
            builder.addInterceptor((Interceptor) it.next());
        }
        return builder.addInterceptor(httpLoggingInterceptor).build();
    }

    public final void j(Annotation annotation, String str) {
        if (!(annotation instanceof d)) {
            if (annotation instanceof b) {
                xo.a.f80651a.a(str, ((b) annotation).type());
            }
        } else {
            xo.b bVar = xo.b.f80653a;
            d dVar = (d) annotation;
            bVar.a(dVar.retryCount());
            bVar.b(dVar.timestamp());
        }
    }

    public final void k() {
        xo.b bVar = xo.b.f80653a;
        bVar.a(0);
        bVar.b(0L);
    }
}
