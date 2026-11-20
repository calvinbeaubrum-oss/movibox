package com.cloud.tmc.integration.bridge;

import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class PayBridge implements BridgeExtension {
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void unificationFailedCallBack$default(PayBridge payBridge, bc.a aVar, String str, boolean z11, JsonObject jsonObject, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        if ((i11 & 8) != 0) {
            jsonObject = null;
        }
        payBridge.a(aVar, str, z11, jsonObject);
    }

    public final void a(bc.a aVar, String str, boolean z11, JsonObject jsonObject) {
        if (aVar != null) {
            z.a aVarB = z.b(jsonObject);
            if (str == null) {
                str = "Unknown error, Please contact the official: P001";
            }
            aVar.e(aVarB.d("errMsg", str).e());
        }
        if (!z11 || aVar == null) {
            return;
        }
        aVar.close();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public final void convertUsdToLocal(@cc.f(Page.class) Page page, @cc.g({"apiKey"}) String apiKey, @cc.g({"cpId"}) String cpId, @cc.g({"orderNum"}) String orderNum, @cc.g({"data"}) String data, @cc.c bc.a aVar) {
        Intrinsics.g(apiKey, "apiKey");
        Intrinsics.g(cpId, "cpId");
        Intrinsics.g(orderNum, "orderNum");
        Intrinsics.g(data, "data");
        unificationFailedCallBack$default(this, aVar, null, false, null, 14, null);
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public final void getPayInfos(@cc.c bc.a aVar) {
        unificationFailedCallBack$default(this, aVar, null, false, null, 14, null);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("PayBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("PayBridge", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public final void requestPayment(@cc.f(Page.class) Page page, @cc.g({"apiKey"}) String apiKey, @cc.g({"cpId"}) String cpId, @cc.g({"orderNum"}) String orderNum, @cc.g({"amount"}) double d11, @cc.g({"payMode"}) String payMode, @cc.c(isSticky = true) bc.a aVar) {
        Intrinsics.g(apiKey, "apiKey");
        Intrinsics.g(cpId, "cpId");
        Intrinsics.g(orderNum, "orderNum");
        Intrinsics.g(payMode, "payMode");
        unificationFailedCallBack$default(this, aVar, null, true, z.a().d(NotificationCompat.CATEGORY_STATUS, "fail").e(), 2, null);
    }
}
