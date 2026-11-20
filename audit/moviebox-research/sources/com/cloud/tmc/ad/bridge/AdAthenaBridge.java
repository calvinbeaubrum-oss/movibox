package com.cloud.tmc.ad.bridge;

import android.os.Bundle;
import bc.a;
import cc.c;
import cc.g;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.g0;
import com.cloud.tmc.integration.utils.l;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.n;
import com.cloud.tmc.kernel.utils.p;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dd.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zb.e;

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
public final class AdAthenaBridge implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f30338a = AdAthenaBridge.class.getSimpleName();

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public /* bridge */ /* synthetic */ f permit() {
        return (f) m118permit();
    }

    /* JADX INFO: renamed from: permit, reason: collision with other method in class */
    public Void m118permit() {
        return null;
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void reportAdLog(@cc.f(App.class) App app, @g({"tag"}) String tag, @g({"athenaData"}) String athenaData, @c a aVar) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(athenaData, "athenaData");
        if (n.a(tag)) {
            p.e(AdAthenaBridge.class.getSimpleName(), "tag is empty");
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (n.a(athenaData)) {
            p.e(AdAthenaBridge.class.getSimpleName(), "athenaData is empty");
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            Map<String, ? extends Object> _dataMap = (Map) new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.ad.bridge.AdAthenaBridge$reportAdLog$gson$1
            }.getType(), new g0()).serializeNulls().create().fromJson(athenaData, new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.ad.bridge.AdAthenaBridge$reportAdLog$_dataMap$1
            }.getType());
            Bundle bundle = new Bundle();
            l lVar = l.f31069a;
            Intrinsics.f(_dataMap, "_dataMap");
            lVar.a(_dataMap, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForAd(app != null ? app.getAppId() : null, tag, "", bundle);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Exception e11) {
            p.c(this.f30338a, "reportAdLog  parse data fail: " + e11);
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
