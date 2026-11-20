package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c extends BaseAdSceneCtxExprHandler {
    @Override // com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler
    public String h(String sceneId, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> ctxMap) {
        Intrinsics.g(sceneId, "sceneId");
        Intrinsics.g(ctxMap, "ctxMap");
        if (mbAdDbPlans != null) {
            return mbAdDbPlans.getCtxEnableExpr();
        }
        return null;
    }

    @Override // com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler
    public String i() {
        return "命中 白名单,当前广告计划 满足展示条件";
    }

    @Override // com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler
    public String j() {
        return "未命中 白名单,当前广告计划 不满足展示条件";
    }

    @Override // com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler
    public boolean k(boolean z11) {
        return z11;
    }
}
