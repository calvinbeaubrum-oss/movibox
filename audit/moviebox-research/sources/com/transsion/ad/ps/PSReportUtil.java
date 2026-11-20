package com.transsion.ad.ps;

import com.cloud.tmc.integration.permission.PermissionConstant;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.LinkedHashMap;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PSReportUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PSReportUtil f50550a = new PSReportUtil();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum ItemResourceEnum {
        ITEM_RES_HI("hi"),
        ITEM_RES_PS("ps");

        private final String value;

        ItemResourceEnum(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum PSRequestState {
        REQUEST_TRIGGER("trigger"),
        REQUEST_SUCCESS("success"),
        REQUEST_FAIL("fail");

        private final String value;

        PSRequestState(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum PsDistributeSceneEnum {
        PS_DISTRIBUTE_SCENE_DOWNLOAD_INTERCEPT("download_intercept"),
        PS_DISTRIBUTE_SCENE_APP_CENTER("app_center"),
        PS_DISTRIBUTE_SCENE_DOWNLOAD_CENTER_APP("download_center_app"),
        PS_DISTRIBUTE_SCENE_AD_PLAN("ad_plan");

        private final String value;

        PsDistributeSceneEnum(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public final void a(PSRequestState psState, RecommendInfo recommendInfo, String sceneStr, String adPlanId) {
        Intrinsics.g(psState, "psState");
        Intrinsics.g(sceneStr, "sceneStr");
        Intrinsics.g(adPlanId, "adPlanId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("scene", sceneStr);
        linkedHashMap.put("ad_planId", adPlanId);
        linkedHashMap.put("ps_state", psState.getValue());
        linkedHashMap.put("id", recommendInfo != null ? Long.valueOf(recommendInfo.getId()).toString() : null);
        linkedHashMap.put("action", "material");
        vq.a.f79051a.c("ad_link", linkedHashMap, "ps_distribute");
    }

    public final void b(PSRequestState psState, Integer num, String str, String str2, String scene) {
        Intrinsics.g(psState, "psState");
        Intrinsics.g(scene, "scene");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ps_state", psState.getValue());
        linkedHashMap.put("count", String.valueOf(num));
        linkedHashMap.put("error_msg", String.valueOf(str));
        linkedHashMap.put("ps_scene", String.valueOf(str2));
        linkedHashMap.put("scene", scene);
        linkedHashMap.put("action", PermissionConstant.ACTION_REQUEST);
        vq.a.f79051a.c("ad_link", linkedHashMap, "ps_distribute");
    }
}
