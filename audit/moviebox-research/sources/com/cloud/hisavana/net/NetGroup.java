package com.cloud.hisavana.net;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.cloud.hisavana.protocol.intercept.CronetRetryInterceptor;
import com.cloud.hisavana.protocol.intercept.b;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.f;
import iq.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.r;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.chromium.net.CronetEngine;
import org.chromium.net.RequestFinishedInfo;

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
public final class NetGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetGroup f28940a = new NetGroup();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f28941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f28942c;

    private NetGroup() {
    }

    @JvmStatic
    public static final boolean a(String str) {
        if (str == null || l.y(str)) {
            return false;
        }
        return StringsKt__StringsKt.O(str, "api.hisavana.com", true) || StringsKt__StringsKt.O(str, "api-quic.hisavana.com", true);
    }

    public static final boolean c() {
        return f28941b;
    }

    public static final int d() {
        return f28942c;
    }

    @JvmStatic
    public static final int e() {
        f28941b = da.a.d().c("abTestEnable", false);
        f28942c = 0;
        c.netLog("NetGroup Net Init：abTestEnable = " + f28941b + " \t groupBucketId = " + f28942c);
        return f28942c;
    }

    @JvmStatic
    public static final OkHttpClient.Builder f(OkHttpClient.Builder builder, g gVar, int i11) {
        if (gVar != null) {
            gVar.a("1013");
        }
        switch (i11) {
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                if (gVar != null) {
                    gVar.a("1014");
                }
                if (builder != null) {
                    return builder.addInterceptor(new b(r.f(new Pair("api.hisavana.com", "api-quic.hisavana.com"))));
                }
                break;
            case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /* 1015 */:
                NetGroup netGroup = f28940a;
                Context contextA = f.a();
                Intrinsics.f(contextA, "getContext()");
                CronetEngine cronetEngineB = netGroup.b(contextA, "1015");
                if (cronetEngineB == null) {
                    return builder;
                }
                if (gVar != null) {
                    gVar.a("1015");
                }
                if (gVar != null) {
                    gVar.b(true);
                }
                if (builder != null) {
                    builder.addInterceptor(new com.cloud.hisavana.protocol.intercept.a(r.f(new Pair("api.hisavana.com", "api-quic.hisavana.com"))));
                }
                if (builder != null) {
                    return builder.addInterceptor((Interceptor) q9.b.d(cronetEngineB).a());
                }
                break;
            case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW /* 1016 */:
                NetGroup netGroup2 = f28940a;
                Context contextA2 = f.a();
                Intrinsics.f(contextA2, "getContext()");
                CronetEngine cronetEngineB2 = netGroup2.b(contextA2, "1016");
                if (cronetEngineB2 == null) {
                    return builder;
                }
                if (gVar != null) {
                    gVar.a("1016");
                }
                if (builder != null) {
                    builder.addInterceptor(new com.cloud.hisavana.protocol.intercept.a(r.f(new Pair("api.hisavana.com", "api-quic.hisavana.com"))));
                }
                if (builder != null) {
                    return builder.addInterceptor(new CronetRetryInterceptor.a(cronetEngineB2).i(r.f(new Pair("api-quic.hisavana.com", "api.hisavana.com"))).h(new o9.b() { // from class: com.cloud.hisavana.net.NetGroup$getWrapBuilder$1
                        @Override // o9.b
                        public boolean a(int i12) {
                            return i12 == 1005;
                        }
                    }).b(gVar).a());
                }
                break;
            default:
                return builder;
        }
        return null;
    }

    public static final void g(boolean z11) {
        f28941b = z11;
    }

    public final CronetEngine b(Context context, final String str) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            CronetEngine cronetEngineBuild = new CronetEngine.Builder(context).enableHttp2(true).enableQuic(true).addQuicHint("api-quic.hisavana.com", 443, 443).addQuicHint("creative.eagllwin.com", 443, 443).addQuicHint("hisavana-adx.transacme.com", 443, 443).build();
            final ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            cronetEngineBuild.addRequestFinishedListener(new RequestFinishedInfo.Listener(executorServiceNewSingleThreadExecutor) { // from class: com.cloud.hisavana.net.NetGroup$buildCronetEngine$1$1$1
                @Override // org.chromium.net.RequestFinishedInfo.Listener
                public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
                    if (requestFinishedInfo == null) {
                        return;
                    }
                    iq.b.f67593a.b(requestFinishedInfo, 0, "All", str, CommonOkHttpClient.f28925a, (96 & 32) != 0 ? false : false, (96 & 64) != 0 ? false : false);
                }
            });
            objM163constructorimpl = Result.m163constructorimpl(cronetEngineBuild);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m169isFailureimpl(objM163constructorimpl)) {
            objM163constructorimpl = null;
        }
        return (CronetEngine) objM163constructorimpl;
    }
}
