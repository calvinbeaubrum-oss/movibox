package gq;

import android.app.Application;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.tracking.TrackingKey;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.device.TNDeviceHelper;
import com.transsion.push.PushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a implements Interceptor {
    public final String a() {
        Application applicationA = Utils.a();
        String str = applicationA.getPackageManager().getPackageInfo(applicationA.getPackageName(), 0).versionName;
        Intrinsics.f(str, "it.packageManager.getPac…ckageName, 0).versionName");
        return str;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.g(chain, "chain");
        List<Pair> listQ = g.q(TuplesKt.a(PushConstants.PROVIDER_FIELD_SDK_VERSION, TranPay.f50043a.d()), TuplesKt.a("appVersion", a()), TuplesKt.a("deviceId", TNDeviceHelper.f50078a.b()), TuplesKt.a(TrackingKey.PLATFORM, "android"), TuplesKt.a(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8"));
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        for (Pair pair : listQ) {
            builderNewBuilder.header((String) pair.getFirst(), (String) pair.getSecond());
        }
        return chain.proceed(builderNewBuilder.build());
    }
}
