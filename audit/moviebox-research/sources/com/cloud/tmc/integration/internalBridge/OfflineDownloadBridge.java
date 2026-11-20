package com.cloud.tmc.integration.internalBridge;

import cc.c;
import cc.g;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy;
import com.google.gson.JsonObject;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.push.PushConstants;
import dd.f;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class OfflineDownloadBridge implements BridgeExtension {
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

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void downloadPkg(@g({MBridgeConstans.DYNAMIC_VIEW_WX_APP}) String app, @g({"group"}) String group, @g(stringDefault = "strong", value = {NetworkBridge.KEY_NETWORK_TYPE}) String networkType, @g({"pkgEncrypted"}) String pkgEncrypted, @g({"pkgUrl"}) String pkgUrl, @g({"paths"}) String paths, @c final bc.a aVar) {
        Intrinsics.g(app, "app");
        Intrinsics.g(group, "group");
        Intrinsics.g(networkType, "networkType");
        Intrinsics.g(pkgEncrypted, "pkgEncrypted");
        Intrinsics.g(pkgUrl, "pkgUrl");
        Intrinsics.g(paths, "paths");
        if (app.length() != 0 && group.length() != 0 && networkType.length() != 0 && pkgEncrypted.length() != 0 && pkgUrl.length() != 0 && paths.length() != 0) {
            ((IOfflineManagerProxy) tc.a.a(IOfflineManagerProxy.class)).downloadPkg(app, group, networkType, pkgEncrypted, pkgUrl, paths, new Function1<JsonObject, Unit>() { // from class: com.cloud.tmc.integration.internalBridge.OfflineDownloadBridge.downloadPkg.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonObject jsonObject) {
                    invoke2(jsonObject);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonObject jsonObject) {
                    if (jsonObject == null) {
                        bc.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.b();
                            return;
                        }
                        return;
                    }
                    bc.a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.d(jsonObject);
                    }
                }
            });
        } else if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @e(ExecutorType.NORMAL)
    public final void downloadPkgFromPlatform(@g({"packageName"}) String packageName, @c bc.a aVar) {
        Intrinsics.g(packageName, "packageName");
        if (packageName.length() == 0) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            ((IOfflineManagerProxy) tc.a.a(IOfflineManagerProxy.class)).downloadPkgFromPlatform(packageName, false);
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void getOfflinePkgCachePath(@g({"group"}) String group, @g({"pkgUrl"}) String pkgUrl, @c final bc.a aVar) {
        Intrinsics.g(group, "group");
        Intrinsics.g(pkgUrl, "pkgUrl");
        if (group.length() != 0 && pkgUrl.length() != 0) {
            ((IOfflineManagerProxy) tc.a.a(IOfflineManagerProxy.class)).getOfflinePkgCachePath(group, pkgUrl, new Function1<JsonObject, Unit>() { // from class: com.cloud.tmc.integration.internalBridge.OfflineDownloadBridge.getOfflinePkgCachePath.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonObject jsonObject) {
                    invoke2(jsonObject);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonObject jsonObject) {
                    if (jsonObject == null) {
                        bc.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.b();
                            return;
                        }
                        return;
                    }
                    bc.a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.d(jsonObject);
                    }
                }
            });
        } else if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void getOfflineResources(@g({PushConstants.PROVIDER_FIELD_APP_ID}) String appId, @g({"url"}) String url, @c bc.a aVar) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(url, "url");
        try {
            if (appId.length() != 0 && url.length() != 0) {
                File offlineResources = ((IOfflineManagerProxy) tc.a.a(IOfflineManagerProxy.class)).getOfflineResources(appId, url);
                if (!FileUtil.c(offlineResources)) {
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
                String strH = oe.a.h(offlineResources);
                Intrinsics.f(strH, "readFile2String(offlineResources)");
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty(AppLovinEventTypes.USER_VIEWED_CONTENT, strH);
                    aVar.d(jsonObject);
                    return;
                }
                return;
            }
            if (aVar != null) {
                aVar.b();
            }
        } catch (Throwable th2) {
            TmcLogger.h("OfflineDownloadBridge", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("OfflineDownloadBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("OfflineDownloadBridge", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public f permit() {
        return null;
    }
}
