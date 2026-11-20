package com.transsion.ad.monopoly.intercept;

import android.text.TextUtils;
import com.blankj.utilcode.util.n;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class SceneInWhitelistHandler extends a {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        SceneInWhitelistHandler$doHandle$1 sceneInWhitelistHandler$doHandle$1;
        SceneInWhitelistHandler sceneInWhitelistHandler;
        if (continuation instanceof SceneInWhitelistHandler$doHandle$1) {
            sceneInWhitelistHandler$doHandle$1 = (SceneInWhitelistHandler$doHandle$1) continuation;
            int i11 = sceneInWhitelistHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                sceneInWhitelistHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                sceneInWhitelistHandler$doHandle$1 = new SceneInWhitelistHandler$doHandle$1(this, continuation);
            }
        } else {
            sceneInWhitelistHandler$doHandle$1 = new SceneInWhitelistHandler$doHandle$1(this, continuation);
        }
        Object objB = sceneInWhitelistHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = sceneInWhitelistHandler$doHandle$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            String[] scenesFromJson = (String[]) n.d(mbAdDbPlans != null ? mbAdDbPlans.getScenes() : null, String[].class);
            if (scenesFromJson == null || scenesFromJson.length == 0) {
                booleanRef.element = true;
            } else {
                Intrinsics.f(scenesFromJson, "scenesFromJson");
                for (String str2 : scenesFromJson) {
                    Locale locale = Locale.ROOT;
                    String lowerCase = str2.toLowerCase(locale);
                    Intrinsics.f(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = str.toLowerCase(locale);
                    Intrinsics.f(lowerCase2, "toLowerCase(...)");
                    if (TextUtils.equals(lowerCase, lowerCase2)) {
                        booleanRef.element = true;
                    }
                }
            }
            if (!booleanRef.element) {
                return new AdPlansHitResponse(false, "当前场景不在白名单中");
            }
            a aVarC = c();
            if (aVarC != null) {
                sceneInWhitelistHandler$doHandle$1.L$0 = this;
                sceneInWhitelistHandler$doHandle$1.label = 1;
                objB = aVarC.b(str, mbAdDbPlans, map, sceneInWhitelistHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                sceneInWhitelistHandler = this;
            } else {
                sceneInWhitelistHandler = this;
            }
            return sceneInWhitelistHandler.e();
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        sceneInWhitelistHandler = (SceneInWhitelistHandler) sceneInWhitelistHandler$doHandle$1.L$0;
        ResultKt.b(objB);
        AdPlansHitResponse adPlansHitResponse = (AdPlansHitResponse) objB;
        if (adPlansHitResponse != null) {
            return adPlansHitResponse;
        }
        return sceneInWhitelistHandler.e();
    }
}
