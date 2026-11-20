package com.transsion.ad.monopoly.intercept;

import android.text.TextUtils;
import com.blankj.utilcode.util.n;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import com.transsion.ad.monopoly.model.CtxAttributeConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import org.mvel2.d;

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
public abstract class BaseAdSceneCtxExprHandler extends a {
    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code duplicated, block: B:88:0x018e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0194  */
    /* JADX WARN: Code duplicated, block: B:92:0x019f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:96:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:98:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b2  */
    public static /* synthetic */ Object g(BaseAdSceneCtxExprHandler baseAdSceneCtxExprHandler, String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        BaseAdSceneCtxExprHandler$doHandle$1 baseAdSceneCtxExprHandler$doHandle$1;
        String str2;
        boolean zBooleanValue;
        String strJ;
        a aVarC;
        AdPlansHitResponse adPlansHitResponse;
        AdPlansHitResponse adPlansHitResponse2;
        AdPlansHitResponse adPlansHitResponse3;
        AdPlansHitResponse adPlansHitResponse4;
        BaseAdSceneCtxExprHandler baseAdSceneCtxExprHandler2 = baseAdSceneCtxExprHandler;
        if (continuation instanceof BaseAdSceneCtxExprHandler$doHandle$1) {
            baseAdSceneCtxExprHandler$doHandle$1 = (BaseAdSceneCtxExprHandler$doHandle$1) continuation;
            int i11 = baseAdSceneCtxExprHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                baseAdSceneCtxExprHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                baseAdSceneCtxExprHandler$doHandle$1 = new BaseAdSceneCtxExprHandler$doHandle$1(baseAdSceneCtxExprHandler2, continuation);
            }
        } else {
            baseAdSceneCtxExprHandler$doHandle$1 = new BaseAdSceneCtxExprHandler$doHandle$1(baseAdSceneCtxExprHandler2, continuation);
        }
        Object objB = baseAdSceneCtxExprHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = baseAdSceneCtxExprHandler$doHandle$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                baseAdSceneCtxExprHandler2 = (BaseAdSceneCtxExprHandler) baseAdSceneCtxExprHandler$doHandle$1.L$0;
                ResultKt.b(objB);
                adPlansHitResponse = (AdPlansHitResponse) objB;
                if (adPlansHitResponse != null) {
                    return adPlansHitResponse;
                }
                return baseAdSceneCtxExprHandler2.e();
            }
            if (i12 == 2) {
                baseAdSceneCtxExprHandler2 = (BaseAdSceneCtxExprHandler) baseAdSceneCtxExprHandler$doHandle$1.L$0;
                ResultKt.b(objB);
                adPlansHitResponse2 = (AdPlansHitResponse) objB;
                if (adPlansHitResponse2 != null) {
                    return adPlansHitResponse2;
                }
                return baseAdSceneCtxExprHandler2.e();
            }
            if (i12 == 3) {
                baseAdSceneCtxExprHandler2 = (BaseAdSceneCtxExprHandler) baseAdSceneCtxExprHandler$doHandle$1.L$0;
                ResultKt.b(objB);
                adPlansHitResponse3 = (AdPlansHitResponse) objB;
                if (adPlansHitResponse3 != null) {
                    return adPlansHitResponse3;
                }
                return baseAdSceneCtxExprHandler2.e();
            }
            if (i12 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            baseAdSceneCtxExprHandler2 = (BaseAdSceneCtxExprHandler) baseAdSceneCtxExprHandler$doHandle$1.L$0;
            ResultKt.b(objB);
            adPlansHitResponse4 = (AdPlansHitResponse) objB;
            if (adPlansHitResponse4 != null) {
                return adPlansHitResponse4;
            }
            return baseAdSceneCtxExprHandler2.e();
        }
        ResultKt.b(objB);
        if (map.isEmpty()) {
            a aVarC2 = baseAdSceneCtxExprHandler.c();
            if (aVarC2 != null) {
                baseAdSceneCtxExprHandler$doHandle$1.L$0 = baseAdSceneCtxExprHandler2;
                baseAdSceneCtxExprHandler$doHandle$1.label = 1;
                objB = aVarC2.b(str, mbAdDbPlans, map, baseAdSceneCtxExprHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                adPlansHitResponse = (AdPlansHitResponse) objB;
                if (adPlansHitResponse != null) {
                    return adPlansHitResponse;
                }
            }
            return baseAdSceneCtxExprHandler2.e();
        }
        CtxAttributeConfig ctxAttributeConfig = (CtxAttributeConfig) n.d(mbAdDbPlans != null ? mbAdDbPlans.getCtxAttributeConfig() : null, CtxAttributeConfig.class);
        if (ctxAttributeConfig == null) {
            a aVarC3 = baseAdSceneCtxExprHandler.c();
            if (aVarC3 != null) {
                baseAdSceneCtxExprHandler$doHandle$1.L$0 = baseAdSceneCtxExprHandler2;
                baseAdSceneCtxExprHandler$doHandle$1.label = 2;
                objB = aVarC3.b(str, mbAdDbPlans, map, baseAdSceneCtxExprHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                adPlansHitResponse2 = (AdPlansHitResponse) objB;
                if (adPlansHitResponse2 != null) {
                    return adPlansHitResponse2;
                }
            }
            return baseAdSceneCtxExprHandler2.e();
        }
        String strH = baseAdSceneCtxExprHandler.h(str, mbAdDbPlans, map);
        if (TextUtils.isEmpty(strH)) {
            a aVarC4 = baseAdSceneCtxExprHandler.c();
            if (aVarC4 != null) {
                baseAdSceneCtxExprHandler$doHandle$1.L$0 = baseAdSceneCtxExprHandler2;
                baseAdSceneCtxExprHandler$doHandle$1.label = 3;
                objB = aVarC4.b(str, mbAdDbPlans, map, baseAdSceneCtxExprHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                adPlansHitResponse3 = (AdPlansHitResponse) objB;
                if (adPlansHitResponse3 != null) {
                    return adPlansHitResponse3;
                }
            }
            return baseAdSceneCtxExprHandler2.e();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<String> attrs = ctxAttributeConfig.getAttrs();
        if (attrs != null) {
            Iterator<T> it = attrs.iterator();
            while (it.hasNext()) {
                linkedHashMap.put((String) it.next(), "");
            }
        }
        Object obj = map.get("genre");
        String str3 = obj instanceof String ? (String) obj : null;
        if (!TextUtils.isEmpty(str3)) {
            if ((str3 == null || !StringsKt__StringsKt.Q(str3, ", ", false, 2, null)) && (str3 == null || !StringsKt__StringsKt.Q(str3, ",", false, 2, null))) {
                str2 = "null cannot be cast to non-null type kotlin.Boolean";
            } else {
                zBooleanValue = false;
                for (String str4 : StringsKt__StringsKt.E0(l.F(str3, " ", "", false, 4, null), new String[]{","}, false, 0, 6, null)) {
                    linkedHashMap.putAll(map);
                    linkedHashMap.put("genre", str4);
                    Object objN = d.n(strH, linkedHashMap);
                    Intrinsics.e(objN, "null cannot be cast to non-null type kotlin.Boolean");
                    if (((Boolean) objN).booleanValue()) {
                        zBooleanValue = true;
                    }
                }
            }
            if (baseAdSceneCtxExprHandler2.k(zBooleanValue)) {
                if (zBooleanValue) {
                    strJ = baseAdSceneCtxExprHandler.i();
                } else {
                    strJ = baseAdSceneCtxExprHandler.j();
                }
                return new AdPlansHitResponse(false, strJ);
            }
            aVarC = baseAdSceneCtxExprHandler.c();
            if (aVarC != null) {
                baseAdSceneCtxExprHandler$doHandle$1.L$0 = baseAdSceneCtxExprHandler2;
                baseAdSceneCtxExprHandler$doHandle$1.label = 4;
                objB = aVarC.b(str, mbAdDbPlans, map, baseAdSceneCtxExprHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                adPlansHitResponse4 = (AdPlansHitResponse) objB;
                if (adPlansHitResponse4 != null) {
                    return adPlansHitResponse4;
                }
            }
            return baseAdSceneCtxExprHandler2.e();
        }
        str2 = "null cannot be cast to non-null type kotlin.Boolean";
        linkedHashMap.putAll(map);
        Object objN2 = d.n(strH, linkedHashMap);
        Intrinsics.e(objN2, str2);
        zBooleanValue = ((Boolean) objN2).booleanValue();
        if (baseAdSceneCtxExprHandler2.k(zBooleanValue)) {
            if (zBooleanValue) {
                strJ = baseAdSceneCtxExprHandler.i();
            } else {
                strJ = baseAdSceneCtxExprHandler.j();
            }
            return new AdPlansHitResponse(false, strJ);
        }
        aVarC = baseAdSceneCtxExprHandler.c();
        if (aVarC != null) {
            baseAdSceneCtxExprHandler$doHandle$1.L$0 = baseAdSceneCtxExprHandler2;
            baseAdSceneCtxExprHandler$doHandle$1.label = 4;
            objB = aVarC.b(str, mbAdDbPlans, map, baseAdSceneCtxExprHandler$doHandle$1);
            if (objB == objE) {
                return objE;
            }
            adPlansHitResponse4 = (AdPlansHitResponse) objB;
            if (adPlansHitResponse4 != null) {
                return adPlansHitResponse4;
            }
        }
        return baseAdSceneCtxExprHandler2.e();
    }

    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) {
        return g(this, str, mbAdDbPlans, map, continuation);
    }

    public abstract String h(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map);

    public abstract String i();

    public abstract String j();

    public abstract boolean k(boolean z11);
}
