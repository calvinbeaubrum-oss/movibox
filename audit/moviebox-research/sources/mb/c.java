package mb;

import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.net.GatewayBean;
import com.cloud.tmc.integration.net.TmcResponseCallbackKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.hisavana.common.tracking.TrackingKey;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Cookie;
import org.json.JSONObject;

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
@SourceDebugExtension
public abstract class c<T> implements wc.b {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(c cVar, BaseResponse baseResponse, Map map, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFail");
        }
        if ((i11 & 2) != 0) {
            map = null;
        }
        cVar.e(baseResponse, map);
    }

    @Override // wc.b
    public void a(int i11, String str, Map<String, String> map, List<Cookie> list, String str2) {
        try {
            if (str == null) {
                e(new BaseResponse<>(-2, null, "response body is null", str2), map);
                po.b.f73956a.g("onResponse body is null");
            } else if (StringsKt__StringsKt.Q(str, TrackingKey.ERROR_CODE, false, 2, null)) {
                Object objE = TmcGsonUtils.e(str, TmcResponseCallbackKt.b());
                ((GatewayBean) objE).setCallbackId(str2);
                e(c((GatewayBean) objE), map);
            } else if (i11 == 200) {
                JSONObject jSONObject = new JSONObject(str);
                int i12 = jSONObject.getInt(TrackingKey.CODE);
                if (i12 == 0) {
                    Object objE2 = TmcGsonUtils.e(str, d());
                    ((BaseResponse) objE2).setCallbackId(str2);
                    g((BaseResponse) objE2, map);
                } else {
                    e(new BaseResponse<>(i12, null, jSONObject.getString("message"), str2), map);
                }
            } else {
                Object objE3 = TmcGsonUtils.e(str, TmcResponseCallbackKt.a());
                ((BaseResponse) objE3).setCallbackId(str2);
                e((BaseResponse) objE3, map);
            }
        } catch (Exception e11) {
            po.b.f73956a.g("onResponse e = " + e11);
            e(new BaseResponse<>(-3, null, "response Exception : " + e11, str2), map);
        }
    }

    @Override // wc.b
    public void b(String errCode, String str, String str2) {
        Intrinsics.g(errCode, "errCode");
        try {
            po.b.f73956a.c(str);
            f(this, new BaseResponse(-1, null, str, str2), null, 2, null);
        } catch (Exception e11) {
            TmcLogger.e(e11.getMessage());
        }
    }

    public final BaseResponse<Object> c(GatewayBean gatewayBean) {
        return new BaseResponse<>(-4, null, gatewayBean.getErrorMessage(), gatewayBean.getCallbackId());
    }

    public abstract Type d();

    public abstract void e(BaseResponse<? extends Object> baseResponse, Map<String, String> map);

    public abstract void g(BaseResponse<? extends T> baseResponse, Map<String, String> map);
}
