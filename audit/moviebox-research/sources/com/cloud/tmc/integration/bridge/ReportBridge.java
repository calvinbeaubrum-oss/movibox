package com.cloud.tmc.integration.bridge;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportFactoryProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.g0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class ReportBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
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

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void report(@cc.g({"tag"}) String tag, @cc.g({"reportData"}) String reportData, @cc.g({"reportType"}) Integer num, @cc.g({"athenaAppId"}) Integer num2, @cc.c bc.a aVar, @cc.f(App.class) App app) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(reportData, "reportData");
        if (com.cloud.tmc.kernel.utils.n.a(tag)) {
            com.cloud.tmc.kernel.utils.p.e(ReportBridge.class.getSimpleName(), "tag is empty");
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (com.cloud.tmc.kernel.utils.n.a(reportData)) {
            com.cloud.tmc.kernel.utils.p.e(ReportBridge.class.getSimpleName(), "reportData is empty");
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            Map<String, ? extends Object> _dataMap = (Map) new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.integration.bridge.ReportBridge$report$gson$1
            }.getType(), new g0()).serializeNulls().create().fromJson(reportData, new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.integration.bridge.ReportBridge$report$_dataMap$1
            }.getType());
            Bundle bundle = new Bundle();
            com.cloud.tmc.integration.utils.l lVar = com.cloud.tmc.integration.utils.l.f31069a;
            Intrinsics.f(_dataMap, "_dataMap");
            lVar.a(_dataMap, bundle);
            ((ReportFactoryProxy) tc.a.a(ReportFactoryProxy.class)).report(app != null ? app.getAppId() : null, tag, bundle, num, num2);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Exception unused) {
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
