package com.cloud.tmc.integration.bridge;

import com.cloud.tmc.integration.model.AppStoreInfo;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.LatestUseUtils;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.transsion.push.PushConstants;
import java.util.Iterator;
import java.util.List;
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
public final class LatestUseBridge implements BridgeExtension {
    public static final a Companion = new a(null);
    public static final String TAG = "LatestUseBridge";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final JsonObject a(JsonArray jsonArray) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("data", jsonArray);
        return jsonObject;
    }

    public final JsonArray b(List<AppStoreInfo> list, Integer num) {
        JsonArray jsonArray = new JsonArray();
        if (list == null) {
            return jsonArray;
        }
        try {
            list.size();
            if (num != null && num.intValue() != -1) {
                Math.min(num.intValue(), list.size());
            }
            Iterator<AppStoreInfo> it = list.iterator();
            while (it.hasNext()) {
                JsonElement string = JsonParser.parseString(com.cloud.tmc.miniutils.util.k.j(it.next()));
                Intrinsics.e(string, "null cannot be cast to non-null type com.google.gson.JsonObject");
                jsonArray.add((JsonObject) string);
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
        }
        return jsonArray;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void deleteLatestUseApp(@cc.f(App.class) App app, @cc.g({PushConstants.PROVIDER_FIELD_APP_ID}) String str, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else if (str == null || str.length() == 0) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            LatestUseUtils.b(str);
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getLatestUseApps(@cc.f(App.class) App app, @cc.g({"total"}) Integer num, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        JsonArray jsonArrayB = b(LatestUseUtils.d(), num);
        if (aVar != null) {
            aVar.d(a(jsonArrayB));
        }
        TmcLogger.c(TAG, "getLatestUseApps = " + jsonArrayB + ", total =" + num);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }
}
