package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.config.utils.ConstantsKt;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.h0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.google.gson.JsonObject;
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
public final class GlobalStorageBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    @zb.a
    @zb.e(ExecutorType.IO)
    public final void clearCommonResStorage(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        String templateMiniappId;
        if (app != null) {
            try {
                AppModel appModel = app.getAppModel();
                if (appModel != null) {
                    templateMiniappId = appModel.getTemplateMiniappId();
                } else {
                    templateMiniappId = null;
                }
            } catch (Throwable unused) {
                return;
            }
        } else {
            templateMiniappId = null;
        }
        clearGlobalStorage(templateMiniappId + "_web", app, aVar);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void clearGlobalStorage(@cc.g({"globalFlag"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        String strValueOf;
        Context context;
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(aVar, "globalFlag is null or empty", Boolean.FALSE);
            return;
        }
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(context, str);
                    if (aVar != null) {
                        aVar.g();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                strValueOf = String.valueOf(th2.getMessage());
            }
        }
        strValueOf = "app error";
        callbackFail(aVar, strValueOf, Boolean.FALSE);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getCommonResStorage(@cc.g({"key"}) String str, @cc.g({"dataType"}) String str2, @cc.g({"defaultValue"}) String str3, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        String templateMiniappId;
        if (app != null) {
            try {
                AppModel appModel = app.getAppModel();
                if (appModel != null) {
                    templateMiniappId = appModel.getTemplateMiniappId();
                } else {
                    templateMiniappId = null;
                }
            } catch (Throwable unused) {
                return;
            }
        } else {
            templateMiniappId = null;
        }
        getGlobalStorage(templateMiniappId + "_web", str, str2, str3, app, aVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:57:0x00e0  */
    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getGlobalStorage(@cc.g({"globalFlag"}) String str, @cc.g({"key"}) String str2, @cc.g({"dataType"}) String str3, @cc.g({"defaultValue"}) String str4, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        String strValueOf;
        Context context;
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(aVar, "globalFlag is null or empty", Boolean.FALSE);
            return;
        }
        if (str2 == null || TextUtils.isEmpty(str2)) {
            callbackFail(aVar, "key is null or empty", Boolean.FALSE);
            return;
        }
        if (str3 == null || TextUtils.isEmpty(str3)) {
            callbackFail(aVar, "dataType is null or empty", Boolean.FALSE);
            return;
        }
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    switch (str3) {
                        case "String":
                            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, str, str2);
                            if (aVar != null) {
                                JsonObject jsonObject = new JsonObject();
                                jsonObject.addProperty("data", string);
                                aVar.d(jsonObject);
                            }
                            break;
                        case "Int":
                            int i11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, str, str2);
                            if (aVar != null) {
                                JsonObject jsonObject2 = new JsonObject();
                                jsonObject2.addProperty("data", Integer.valueOf(i11));
                                aVar.d(jsonObject2);
                            }
                            break;
                        case "Long":
                            long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, str, str2);
                            if (aVar != null) {
                                JsonObject jsonObject3 = new JsonObject();
                                jsonObject3.addProperty("data", Long.valueOf(j11));
                                aVar.d(jsonObject3);
                            }
                            break;
                        case "Boolean":
                            boolean z11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, str, str2, str4 != null ? Boolean.parseBoolean(str4) : false);
                            if (aVar != null) {
                                JsonObject jsonObject4 = new JsonObject();
                                jsonObject4.addProperty("data", Boolean.valueOf(z11));
                                aVar.d(jsonObject4);
                            }
                            break;
                        default:
                            if (str3.equals("String")) {
                                String string2 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, str, str2);
                                if (aVar != null) {
                                    JsonObject jsonObject5 = new JsonObject();
                                    jsonObject5.addProperty("data", string2);
                                    aVar.d(jsonObject5);
                                }
                                break;
                            }
                            strValueOf = "dataType is not in (String, Int, Long, Boolean)";
                            break;
                    }
                }
                strValueOf = "app error";
            } catch (Throwable th2) {
                strValueOf = String.valueOf(th2.getMessage());
            }
        } else {
            strValueOf = "app error";
        }
        callbackFail(aVar, strValueOf, Boolean.FALSE);
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

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    @zb.a
    @zb.e(ExecutorType.IO)
    public final void removeCommonResStorage(@cc.g({"key"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        String templateMiniappId;
        if (app != null) {
            try {
                AppModel appModel = app.getAppModel();
                if (appModel != null) {
                    templateMiniappId = appModel.getTemplateMiniappId();
                } else {
                    templateMiniappId = null;
                }
            } catch (Throwable unused) {
                return;
            }
        } else {
            templateMiniappId = null;
        }
        removeGlobalStorage(templateMiniappId + "_web", str, app, aVar);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void removeGlobalStorage(@cc.g({"globalFlag"}) String str, @cc.g({"key"}) String str2, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        String strValueOf;
        Context context;
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(aVar, "globalFlag is null or empty", Boolean.FALSE);
            return;
        }
        if (str2 == null || TextUtils.isEmpty(str2)) {
            callbackFail(aVar, "key is null or empty", Boolean.FALSE);
            return;
        }
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(context, str, str2);
                    if (aVar != null) {
                        aVar.g();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                strValueOf = String.valueOf(th2.getMessage());
            }
        }
        strValueOf = "app error";
        callbackFail(aVar, strValueOf, Boolean.FALSE);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    @zb.a
    @zb.e(ExecutorType.IO)
    public final void setCommonResStorage(@cc.g({"key"}) String str, @cc.g({"data"}) String str2, @cc.g({"dataType"}) String str3, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        String templateMiniappId;
        if (app != null) {
            try {
                AppModel appModel = app.getAppModel();
                if (appModel != null) {
                    templateMiniappId = appModel.getTemplateMiniappId();
                } else {
                    templateMiniappId = null;
                }
            } catch (Throwable unused) {
                return;
            }
        } else {
            templateMiniappId = null;
        }
        setGlobalStorage(templateMiniappId + "_web", str, str2, str3, app, aVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:64:0x00db  */
    @zb.a
    @zb.e(ExecutorType.IO)
    public final void setGlobalStorage(@cc.g({"globalFlag"}) String str, @cc.g({"key"}) String str2, @cc.g({"data"}) String str3, @cc.g({"dataType"}) String str4, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        String strValueOf;
        Context context;
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(aVar, "globalFlag is null or empty", Boolean.FALSE);
            return;
        }
        if (str2 == null || TextUtils.isEmpty(str2)) {
            callbackFail(aVar, "key is null or empty", Boolean.FALSE);
            return;
        }
        if (str4 == null || TextUtils.isEmpty(str4)) {
            callbackFail(aVar, "dataType is null or empty", Boolean.FALSE);
            return;
        }
        if (str3 == null) {
            callbackFail(aVar, ConstantsKt.ERROR_1000_MESSAGE, Boolean.FALSE);
            return;
        }
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    switch (str4) {
                        case "String":
                            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, str, str2, str3);
                            if (aVar != null) {
                                aVar.g();
                            }
                            break;
                        case "Int":
                            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, str, str2, Integer.parseInt(str3));
                            if (aVar != null) {
                                aVar.g();
                            }
                            break;
                        case "Long":
                            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, str, str2, Long.parseLong(str3));
                            if (aVar != null) {
                                aVar.g();
                            }
                            break;
                        case "Boolean":
                            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, str, str2, Boolean.parseBoolean(str3));
                            if (aVar != null) {
                                aVar.g();
                            }
                            if (Intrinsics.b("100000", str) && Intrinsics.b("privacy_agreement", str2) && Boolean.parseBoolean(str3)) {
                                h0.f31062a.a(context);
                                break;
                            }
                        default:
                            if (str4.equals("String")) {
                                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, str, str2, str3);
                                if (aVar != null) {
                                    aVar.g();
                                }
                                break;
                            }
                            strValueOf = "dataType is not in (String, Int, Long, Boolean)";
                            break;
                    }
                    return;
                }
                strValueOf = "app error";
            } catch (Throwable th2) {
                strValueOf = String.valueOf(th2.getMessage());
            }
        } else {
            strValueOf = "app error";
        }
        callbackFail(aVar, strValueOf, Boolean.FALSE);
    }
}
