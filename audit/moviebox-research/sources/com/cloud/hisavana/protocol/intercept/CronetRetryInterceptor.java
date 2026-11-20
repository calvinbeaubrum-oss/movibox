package com.cloud.hisavana.protocol.intercept;

import com.cloud.sdk.commonutil.util.c;
import iq.g;
import iq.h;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.chromium.net.CronetEngine;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CronetRetryInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q9.b f29034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o9.a f29035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f29036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f29037d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o9.b f29038f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q9.b f29039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o9.a f29040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f29041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g f29042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public o9.b f29043e;

        public a(CronetEngine engine) {
            Intrinsics.g(engine, "engine");
            Object objA = q9.b.d(engine).a();
            Intrinsics.f(objA, "newBuilder(engine).build()");
            this.f29039a = (q9.b) objA;
            this.f29040b = new o9.a();
        }

        public final CronetRetryInterceptor a() {
            return new CronetRetryInterceptor(this, null);
        }

        public final a b(g gVar) {
            if (gVar == null) {
                return this;
            }
            gVar.b(true);
            this.f29042d = gVar;
            return this;
        }

        public final q9.b c() {
            return this.f29039a;
        }

        public final o9.a d() {
            return this.f29040b;
        }

        public final o9.b e() {
            return this.f29043e;
        }

        public final g f() {
            return this.f29042d;
        }

        public final Map<String, String> g() {
            return this.f29041c;
        }

        public final a h(o9.b policy) {
            Intrinsics.g(policy, "policy");
            this.f29043e = policy;
            return this;
        }

        public final a i(Map<String, String> map) {
            this.f29041c = map;
            return this;
        }
    }

    public CronetRetryInterceptor(a aVar) {
        this.f29034a = aVar.c();
        this.f29035b = aVar.d();
        this.f29036c = aVar.g();
        this.f29037d = aVar.f();
        this.f29038f = aVar.e();
    }

    public /* synthetic */ CronetRetryInterceptor(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public final Request b(Request request) {
        HttpUrl httpUrlUrl = request.url();
        String strHost = httpUrlUrl.host();
        Map<String, String> map = this.f29036c;
        String str = map != null ? map.get(strHost) : null;
        if (str == null) {
            return request;
        }
        Request requestBuild = request.newBuilder().url(httpUrlUrl.newBuilder().host(str).build()).build();
        Intrinsics.f(requestBuild, "{\n            request.ne…       .build()\n        }");
        return requestBuild;
    }

    public final Response c(Response response, int i11, Interceptor.Chain chain) {
        if (!p9.a.a(response)) {
            return response;
        }
        h();
        return i11 != -1 ? f(chain, i11) : response;
    }

    public final Response d(Response response, Interceptor.Chain chain, int i11, o9.b bVar) {
        if (i11 == -1 || !bVar.a(i11)) {
            return response;
        }
        h();
        return f(chain, i11);
    }

    public final Response e(Interceptor.Chain chain, int i11) {
        h();
        return f(chain, i11);
    }

    public final Response f(Interceptor.Chain chain, int i11) throws IOException {
        Request request = chain.request();
        Intrinsics.f(request, "chain.request()");
        Request requestB = b(request);
        h.f67653a.a(chain, requestB, i11);
        Response responseProceed = chain.proceed(requestB);
        Intrinsics.f(responseProceed, "chain.proceed(buildRequest)");
        return responseProceed;
    }

    public final void g() {
        this.f29035b.b();
    }

    public final void h() {
        this.f29035b.c(new Function0<Unit>() { // from class: com.cloud.hisavana.protocol.intercept.CronetRetryInterceptor$triggerDownCount$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                g gVar = this.this$0.f29037d;
                if (gVar != null) {
                    gVar.b(false);
                }
            }
        });
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Intrinsics.g(chain, "chain");
        if (this.f29035b.a()) {
            c.netLog("request downgrade, cause failed count exceed limit, failed url is:" + chain.request().url());
            Request request = chain.request();
            Intrinsics.f(request, "chain.request()");
            Response responseProceed = chain.proceed(b(request));
            Intrinsics.f(responseProceed, "chain.proceed(buildRequest)");
            return responseProceed;
        }
        try {
            Response response = this.f29034a.intercept(chain);
            if (response.isSuccessful()) {
                g();
                Intrinsics.f(response, "response");
                return response;
            }
            c.netLog("request downgrade, cause domain failed1, failed url is:" + chain.request().url());
            Intrinsics.f(response, "response");
            int iC = p9.a.c(response);
            o9.b bVar = this.f29038f;
            return bVar != null ? d(response, chain, iC, bVar) : c(response, iC, chain);
        } catch (Exception e11) {
            int iB = p9.a.b(e11);
            if (iB == -1) {
                throw e11;
            }
            c.netLog("request downgrade, cause domain failed, failed url is:" + chain.request().url());
            o9.b bVar2 = this.f29038f;
            if (bVar2 != null && !bVar2.a(iB)) {
                throw e11;
            }
            return e(chain, iB);
        }
    }
}
