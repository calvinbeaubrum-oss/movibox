package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import com.transsion.ad.ps.PsAdPlanRetryManager;
import com.transsion.ad.strategy.AdMmkv;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import xq.f;

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
public final class AdResourceDownloadedHandler extends a {
    /* JADX WARN: Code duplicated, block: B:43:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:45:0x00de  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:55:0x0100  */
    /* JADX WARN: Code duplicated, block: B:60:0x010e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0116  */
    /* JADX WARN: Code duplicated, block: B:65:0x0141  */
    /* JADX WARN: Code duplicated, block: B:68:0x014a  */
    /* JADX WARN: Code duplicated, block: B:70:0x0150  */
    /* JADX WARN: Code duplicated, block: B:72:0x0162 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0163  */
    /* JADX WARN: Code duplicated, block: B:76:0x0168  */
    /* JADX WARN: Code duplicated, block: B:78:0x016e  */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:62:0x0116, please report this as an issue */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        AdResourceDownloadedHandler$doHandle$1 adResourceDownloadedHandler$doHandle$1;
        Ref.BooleanRef booleanRef;
        Object objF;
        AdResourceDownloadedHandler adResourceDownloadedHandler;
        AdResourceDownloadedHandler adResourceDownloadedHandler2;
        AdPlansHitResponse adPlansHitResponse;
        AdPlans adPlans;
        a aVarC;
        AdResourceDownloadedHandler adResourceDownloadedHandler3;
        AdPlanSourceManager adPlanSourceManager;
        List<AdMaterialList> adMaterialList;
        MbAdVideo video;
        String path;
        boolean zC;
        MbAdImage image;
        String path2;
        AdPlansHitResponse adPlansHitResponse2;
        String str2 = str;
        MbAdDbPlans mbAdDbPlans2 = mbAdDbPlans;
        Map<String, ? extends Object> map2 = map;
        if (continuation instanceof AdResourceDownloadedHandler$doHandle$1) {
            adResourceDownloadedHandler$doHandle$1 = (AdResourceDownloadedHandler$doHandle$1) continuation;
            int i11 = adResourceDownloadedHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                adResourceDownloadedHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                adResourceDownloadedHandler$doHandle$1 = new AdResourceDownloadedHandler$doHandle$1(this, continuation);
            }
        } else {
            adResourceDownloadedHandler$doHandle$1 = new AdResourceDownloadedHandler$doHandle$1(this, continuation);
        }
        Object objB = adResourceDownloadedHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = adResourceDownloadedHandler$doHandle$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            booleanRef = new Ref.BooleanRef();
            if (AdPlanSourceManager.f50540a.c(mbAdDbPlans2)) {
                a aVarC2 = c();
                if (aVarC2 != null) {
                    adResourceDownloadedHandler$doHandle$1.L$0 = this;
                    adResourceDownloadedHandler$doHandle$1.label = 1;
                    objB = aVarC2.b(str2, mbAdDbPlans2, map2, adResourceDownloadedHandler$doHandle$1);
                    if (objB == objE) {
                        return objE;
                    }
                    adResourceDownloadedHandler2 = this;
                    adPlansHitResponse = (AdPlansHitResponse) objB;
                    if (adPlansHitResponse != null) {
                        return adPlansHitResponse;
                    }
                } else {
                    adResourceDownloadedHandler2 = this;
                }
                return adResourceDownloadedHandler2.e();
            }
            AdPlansTransform adPlansTransform = AdPlansTransform.f50542a;
            adResourceDownloadedHandler$doHandle$1.L$0 = this;
            adResourceDownloadedHandler$doHandle$1.L$1 = str2;
            adResourceDownloadedHandler$doHandle$1.L$2 = mbAdDbPlans2;
            adResourceDownloadedHandler$doHandle$1.L$3 = map2;
            adResourceDownloadedHandler$doHandle$1.L$4 = booleanRef;
            adResourceDownloadedHandler$doHandle$1.label = 2;
            objF = adPlansTransform.f(mbAdDbPlans2, adResourceDownloadedHandler$doHandle$1);
            if (objF == objE) {
                return objE;
            }
            adResourceDownloadedHandler = this;
            adPlans = (AdPlans) objF;
            if (adPlans != null) {
                for (AdMaterialList adMaterialList2 : adMaterialList) {
                    if (Intrinsics.b(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_TEXT)) {
                        f fVar = f.f80673a;
                        image = adMaterialList2.getImage();
                        if (image != null) {
                            path2 = "";
                        } else {
                            path2 = "";
                        }
                        zC = fVar.c(path2);
                    } else {
                        f fVar2 = f.f80673a;
                        video = adMaterialList2.getVideo();
                        if (video != null) {
                            path = "";
                        } else {
                            path = "";
                        }
                        zC = fVar2.c(path);
                    }
                    booleanRef.element = zC;
                }
            }
            if (!booleanRef.element) {
                adPlanSourceManager = AdPlanSourceManager.f50540a;
                if (adPlanSourceManager.a(mbAdDbPlans2)) {
                    AdMmkv.f50558a.b().putString("non_ad_plan_version", "");
                    com.transsion.ad.a.d(com.transsion.ad.a.f50276a, adResourceDownloadedHandler.d() + " --> hasResource() --> 用户可能手动将文件删除了，这个时候需要重新请求。 --> 包断广告版本号 重置", false, 2, null);
                }
                if (adPlanSourceManager.f(mbAdDbPlans2)) {
                    PsAdPlanRetryManager.f50551a.b(mbAdDbPlans2);
                }
            }
            if (booleanRef.element) {
                return new AdPlansHitResponse(false, "广告资源未下载完成");
            }
            aVarC = adResourceDownloadedHandler.c();
            if (aVarC != null) {
                adResourceDownloadedHandler$doHandle$1.L$0 = adResourceDownloadedHandler;
                adResourceDownloadedHandler$doHandle$1.L$1 = null;
                adResourceDownloadedHandler$doHandle$1.L$2 = null;
                adResourceDownloadedHandler$doHandle$1.L$3 = null;
                adResourceDownloadedHandler$doHandle$1.L$4 = null;
                adResourceDownloadedHandler$doHandle$1.label = 3;
                objB = aVarC.b(str2, mbAdDbPlans2, map2, adResourceDownloadedHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                adResourceDownloadedHandler3 = adResourceDownloadedHandler;
                adPlansHitResponse2 = (AdPlansHitResponse) objB;
                if (adPlansHitResponse2 == null) {
                    return adPlansHitResponse2;
                }
                adResourceDownloadedHandler = adResourceDownloadedHandler3;
            }
        } else {
            if (i12 == 1) {
                adResourceDownloadedHandler2 = (AdResourceDownloadedHandler) adResourceDownloadedHandler$doHandle$1.L$0;
                ResultKt.b(objB);
                adPlansHitResponse = (AdPlansHitResponse) objB;
                if (adPlansHitResponse != null) {
                    return adPlansHitResponse;
                }
                return adResourceDownloadedHandler2.e();
            }
            if (i12 == 2) {
                Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) adResourceDownloadedHandler$doHandle$1.L$4;
                Map<String, ? extends Object> map3 = (Map) adResourceDownloadedHandler$doHandle$1.L$3;
                MbAdDbPlans mbAdDbPlans3 = (MbAdDbPlans) adResourceDownloadedHandler$doHandle$1.L$2;
                String str3 = (String) adResourceDownloadedHandler$doHandle$1.L$1;
                adResourceDownloadedHandler = (AdResourceDownloadedHandler) adResourceDownloadedHandler$doHandle$1.L$0;
                ResultKt.b(objB);
                booleanRef = booleanRef2;
                str2 = str3;
                objF = objB;
                map2 = map3;
                mbAdDbPlans2 = mbAdDbPlans3;
                adPlans = (AdPlans) objF;
                if (adPlans != null && (adMaterialList = adPlans.getAdMaterialList()) != null) {
                    while (r7.hasNext()) {
                        if (Intrinsics.b(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_TEXT)) {
                            f fVar3 = f.f80673a;
                            image = adMaterialList2.getImage();
                            if (image != null || (path2 = image.getPath()) == null) {
                                path2 = "";
                            }
                            zC = fVar3.c(path2);
                        } else {
                            f fVar4 = f.f80673a;
                            video = adMaterialList2.getVideo();
                            if (video != null || (path = video.getPath()) == null) {
                                path = "";
                            }
                            zC = fVar4.c(path);
                        }
                        booleanRef.element = zC;
                    }
                }
                if (!booleanRef.element) {
                    adPlanSourceManager = AdPlanSourceManager.f50540a;
                    if (adPlanSourceManager.a(mbAdDbPlans2)) {
                        AdMmkv.f50558a.b().putString("non_ad_plan_version", "");
                        com.transsion.ad.a.d(com.transsion.ad.a.f50276a, adResourceDownloadedHandler.d() + " --> hasResource() --> 用户可能手动将文件删除了，这个时候需要重新请求。 --> 包断广告版本号 重置", false, 2, null);
                    }
                    if (adPlanSourceManager.f(mbAdDbPlans2)) {
                        PsAdPlanRetryManager.f50551a.b(mbAdDbPlans2);
                    }
                }
                if (booleanRef.element) {
                    return new AdPlansHitResponse(false, "广告资源未下载完成");
                }
                aVarC = adResourceDownloadedHandler.c();
                if (aVarC != null) {
                    adResourceDownloadedHandler$doHandle$1.L$0 = adResourceDownloadedHandler;
                    adResourceDownloadedHandler$doHandle$1.L$1 = null;
                    adResourceDownloadedHandler$doHandle$1.L$2 = null;
                    adResourceDownloadedHandler$doHandle$1.L$3 = null;
                    adResourceDownloadedHandler$doHandle$1.L$4 = null;
                    adResourceDownloadedHandler$doHandle$1.label = 3;
                    objB = aVarC.b(str2, mbAdDbPlans2, map2, adResourceDownloadedHandler$doHandle$1);
                    if (objB == objE) {
                        return objE;
                    }
                    adResourceDownloadedHandler3 = adResourceDownloadedHandler;
                }
            } else {
                if (i12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                adResourceDownloadedHandler3 = (AdResourceDownloadedHandler) adResourceDownloadedHandler$doHandle$1.L$0;
                ResultKt.b(objB);
            }
            adPlansHitResponse2 = (AdPlansHitResponse) objB;
            if (adPlansHitResponse2 == null) {
                return adPlansHitResponse2;
            }
            adResourceDownloadedHandler = adResourceDownloadedHandler3;
        }
        return adResourceDownloadedHandler.e();
    }
}
