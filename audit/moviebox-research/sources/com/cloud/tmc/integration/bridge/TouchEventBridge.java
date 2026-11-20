package com.cloud.tmc.integration.bridge;

import android.graphics.Point;
import android.view.View;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.l0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class TouchEventBridge implements BridgeExtension {
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

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("TouchEventBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("TouchEventBridge", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public final void simulateTouchEvent(@cc.f(Page.class) Page page, @cc.g({"coordinates"}) JsonArray jsonArray, @cc.c bc.a aVar) {
        ArrayList arrayList;
        if (page == null || jsonArray == null || jsonArray.isEmpty()) {
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "Parameter error: T11001");
                aVar.e(jsonObject);
                return;
            }
            return;
        }
        try {
            String string = jsonArray.toString();
            Intrinsics.f(string, "coordinates.toString()");
            Type type = new TypeToken<ArrayList<Point>>() { // from class: com.cloud.tmc.integration.bridge.TouchEventBridge$simulateTouchEvent$points$1
            }.getType();
            Intrinsics.f(type, "object : TypeToken<ArrayList<Point>>() {}.type");
            arrayList = (ArrayList) TmcGsonUtils.e(string, type);
        } catch (Throwable th2) {
            TmcLogger.g("TouchEventBridge", "json parse error", th2);
            arrayList = new ArrayList();
        }
        if (arrayList.isEmpty()) {
            TmcLogger.c("TouchEventBridge", "points is empty");
            if (aVar != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "Parameter error: T11001");
                aVar.e(jsonObject2);
                return;
            }
            return;
        }
        zc.i render = page.getRender();
        View view = render != null ? render.getView() : null;
        if (view != null) {
            l0.a(view, arrayList);
            if (aVar != null) {
                aVar.g();
                return;
            }
            return;
        }
        TmcLogger.f("TouchEventBridge", "system view is null");
        if (aVar != null) {
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("errMsg", "System view error: T11002");
            aVar.e(jsonObject3);
        }
    }
}
