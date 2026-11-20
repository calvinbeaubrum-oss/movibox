package com.cloud.tmc.integration.bridge;

import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.JsonObject;
import java.util.Timer;
import java.util.TimerTask;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class OfflineAppBridge implements BridgeExtension {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements OfflineAppProxy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JsonObject f30565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f30566b;

        public a(JsonObject jsonObject, bc.a aVar) {
            this.f30565a = jsonObject;
            this.f30566b = aVar;
        }

        @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy.a
        public void onSuccess(String data) {
            Intrinsics.g(data, "data");
            this.f30565a.addProperty("data", data);
            this.f30566b.d(this.f30565a);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void getOfflineApps(@cc.g({"isCache"}) Boolean bool, @cc.g({"timeout"}) Long l11, @cc.f(App.class) App app, @cc.c final bc.a callback) {
        boolean zBooleanValue;
        Intrinsics.g(app, "app");
        Intrinsics.g(callback, "callback");
        if (bool != null) {
            try {
                zBooleanValue = bool.booleanValue();
            } catch (Throwable th2) {
                callbackFail(callback, String.valueOf(th2.getMessage()), Boolean.FALSE);
                return;
            }
        } else {
            zBooleanValue = false;
        }
        ((OfflineAppProxy) tc.a.a(OfflineAppProxy.class)).getOfflineAppsForBridgeApi(zBooleanValue, new a(new JsonObject(), callback));
        new Timer().schedule(new TimerTask() { // from class: com.cloud.tmc.integration.bridge.OfflineAppBridge$getOfflineApps$timerTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.callbackFail(callback, "timeout", Boolean.FALSE);
            }
        }, l11 != null ? l11.longValue() : 1000L);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public /* bridge */ /* synthetic */ dd.f permit() {
        return (dd.f) m122permit();
    }

    /* JADX INFO: renamed from: permit, reason: collision with other method in class */
    public Void m122permit() {
        return null;
    }
}
