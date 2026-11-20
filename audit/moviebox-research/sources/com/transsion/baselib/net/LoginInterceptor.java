package com.transsion.baselib.net;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.g0;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LoginInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f51221b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f51222a = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.baselib.net.LoginInterceptor$mLogin$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
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

    public final String a() {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String reverse = g0.e(strValueOf);
        qp.a.C0819a c0819a = qp.a.f74869a;
        Intrinsics.f(reverse, "reverse");
        return strValueOf + "," + c0819a.a(reverse);
    }

    public final ILoginApi b() {
        return (ILoginApi) this.f51222a.getValue();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.g(chain, "chain");
        Request request = chain.request();
        UserInfo userInfoP = b().P();
        if (userInfoP == null || TextUtils.isEmpty(userInfoP.getToken())) {
            request = request.newBuilder().header("X-Client-Token", a()).build();
        } else {
            String token = userInfoP.getToken();
            if (token != null) {
                request = request.newBuilder().header(HttpHeaders.AUTHORIZATION, ap.a.f13586a.a(token)).build();
            }
        }
        Response responseProceed = chain.proceed(request);
        b().J(responseProceed);
        return responseProceed;
    }
}
