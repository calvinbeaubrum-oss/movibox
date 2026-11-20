package com.cloud.hisavana.net;

import com.cloud.hisavana.net.disklrucache.listener.LruCleanCallBack;
import com.cloud.hisavana.net.impl.IHttpCallback;
import com.cloud.hisavana.net.utils.CommonWorkThread;
import com.cloud.sdk.commonutil.util.c;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Request;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HttpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HttpRequest f28935a = new HttpRequest();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<LruCleanCallBack> f28936b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f28937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f28938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f28939e;

    private HttpRequest() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, com.cloud.hisavana.net.RequestParams] */
    @JvmStatic
    public static final void c(String str, RequestParams requestParams, final IHttpCallback iHttpCallback) {
        try {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = requestParams;
            if (requestParams == 0) {
                objectRef.element = new RequestParams();
            }
            ((RequestParams) objectRef.element).h("isDownload", "true");
            final Request requestA = CommonRequest.a(str, (RequestParams) objectRef.element, iHttpCallback);
            if (requestA != null) {
                CommonWorkThread.a().b(new Runnable() { // from class: com.cloud.hisavana.net.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        HttpRequest.d(objectRef, requestA, iHttpCallback);
                    }
                });
            } else {
                c.netLog("getRequest:  create request is null");
            }
        } catch (Exception unused) {
            c.netLog("downloadImage:  post request is error");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(Ref.ObjectRef tempParams, Request request, IHttpCallback iHttpCallback) {
        Intrinsics.g(tempParams, "$tempParams");
        CommonOkHttpClient.h((RequestParams) tempParams.element, request, iHttpCallback);
    }

    @JvmStatic
    public static final void j(String str, RequestParams requestParams, IHttpCallback iHttpCallback) {
        if (requestParams == null) {
            try {
                requestParams = new RequestParams();
            } catch (Exception unused) {
                c.netLog("postRequest:  post request is error");
                return;
            }
        }
        requestParams.h("isDownload", "false");
        Request requestB = CommonRequest.b(str, requestParams, iHttpCallback);
        if (requestB != null) {
            CommonOkHttpClient.l(requestB, iHttpCallback);
        } else {
            c.netLog("postRequest:  create request is null");
        }
    }

    public final void b(LruCleanCallBack lruCleanCallBack) {
        if (lruCleanCallBack == null) {
            return;
        }
        f28936b.add(lruCleanCallBack);
    }

    public final int e() {
        return f28937c;
    }

    public final int f() {
        return f28939e;
    }

    public final CopyOnWriteArrayList<LruCleanCallBack> g() {
        return f28936b;
    }

    public final void h(String str, RequestParams requestParams, IHttpCallback iHttpCallback) {
        if (requestParams == null) {
            try {
                requestParams = new RequestParams();
            } catch (Exception unused) {
                c.netLog("postRequest:  post request is error");
                return;
            }
        }
        requestParams.h("isDownload", "false");
        Request requestA = CommonRequest.a(str, requestParams, iHttpCallback);
        if (requestA != null) {
            CommonOkHttpClient.i(requestA, iHttpCallback);
        } else {
            c.netLog("getRequest:  create request is null");
        }
    }

    public final int i() {
        return f28938d;
    }

    public final void k(int i11) {
        f28939e = i11;
    }
}
