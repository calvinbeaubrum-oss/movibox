package com.cloud.tmc.integration.bridge;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.JsonObject;
import kotlin.Metadata;

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
public final class CommunicationBridge implements BridgeExtension {
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

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void openByteBridge(@cc.c bc.a aVar) {
        String strE = MiniAppConfigHelper.f30370a.e("byteBridge", "{\"open\":false}");
        if (strE == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("data", strE);
            aVar.d(jsonObject);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public /* bridge */ /* synthetic */ dd.f permit() {
        return (dd.f) m121permit();
    }

    /* JADX INFO: renamed from: permit, reason: collision with other method in class */
    public Void m121permit() {
        return null;
    }
}
