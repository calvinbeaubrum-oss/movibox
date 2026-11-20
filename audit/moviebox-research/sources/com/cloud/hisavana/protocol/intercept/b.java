package com.cloud.hisavana.protocol.intercept;

import com.cloud.sdk.commonutil.util.c;
import iq.h;
import java.net.UnknownHostException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f29045a;

    public b(Map<String, String> hostMap) {
        Intrinsics.g(hostMap, "hostMap");
        this.f29045a = hostMap;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Intrinsics.g(chain, "chain");
        try {
            Response responseProceed = chain.proceed(chain.request());
            Intrinsics.f(responseProceed, "chain.proceed(chain.request())");
            return responseProceed;
        } catch (Exception e11) {
            HttpUrl httpUrlUrl = chain.request().url();
            String str = this.f29045a.get(httpUrlUrl.host());
            if (str == null || !(e11 instanceof UnknownHostException)) {
                throw e11;
            }
            Request requestBuild = chain.request().newBuilder().url(httpUrlUrl.newBuilder().host(str).build()).build();
            c.netLog("request downgrade, domain failed, failed url is:" + chain.request().url());
            h hVar = h.f67653a;
            Intrinsics.f(requestBuild, "this");
            hVar.a(chain, requestBuild, 1005);
            Response responseProceed2 = chain.proceed(requestBuild);
            Intrinsics.f(responseProceed2, "chain.proceed(buildRequest)");
            return responseProceed2;
        }
    }
}
