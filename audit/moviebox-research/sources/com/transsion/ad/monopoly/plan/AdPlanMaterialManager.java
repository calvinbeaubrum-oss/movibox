package com.transsion.ad.monopoly.plan;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
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
public final class AdPlanMaterialManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdPlanMaterialManager f50539a = new AdPlanMaterialManager();

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(MbAdDbPlans mbAdDbPlans, Continuation<? super Boolean> continuation) throws Throwable {
        AdPlanMaterialManager$hasRes$1 adPlanMaterialManager$hasRes$1;
        Ref.BooleanRef booleanRef;
        List<AdMaterialList> adMaterialList;
        boolean zC;
        String path;
        String path2;
        if (continuation instanceof AdPlanMaterialManager$hasRes$1) {
            adPlanMaterialManager$hasRes$1 = (AdPlanMaterialManager$hasRes$1) continuation;
            int i11 = adPlanMaterialManager$hasRes$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                adPlanMaterialManager$hasRes$1.label = i11 - Integer.MIN_VALUE;
            } else {
                adPlanMaterialManager$hasRes$1 = new AdPlanMaterialManager$hasRes$1(this, continuation);
            }
        } else {
            adPlanMaterialManager$hasRes$1 = new AdPlanMaterialManager$hasRes$1(this, continuation);
        }
        Object obj = adPlanMaterialManager$hasRes$1.result;
        Object objE = a.e();
        int i12 = adPlanMaterialManager$hasRes$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            AdPlansTransform adPlansTransform = AdPlansTransform.f50542a;
            adPlanMaterialManager$hasRes$1.L$0 = booleanRef2;
            adPlanMaterialManager$hasRes$1.label = 1;
            Object objF = adPlansTransform.f(mbAdDbPlans, adPlanMaterialManager$hasRes$1);
            if (objF == objE) {
                return objE;
            }
            obj = objF;
            booleanRef = booleanRef2;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef = (Ref.BooleanRef) adPlanMaterialManager$hasRes$1.L$0;
            ResultKt.b(obj);
        }
        AdPlans adPlans = (AdPlans) obj;
        if (adPlans != null && (adMaterialList = adPlans.getAdMaterialList()) != null) {
            for (AdMaterialList adMaterialList2 : adMaterialList) {
                String str = "";
                if (Intrinsics.b(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_TEXT)) {
                    f fVar = f.f80673a;
                    MbAdImage image = adMaterialList2.getImage();
                    if (image != null && (path2 = image.getPath()) != null) {
                        str = path2;
                    }
                    zC = fVar.c(str);
                } else {
                    f fVar2 = f.f80673a;
                    MbAdVideo video = adMaterialList2.getVideo();
                    if (video != null && (path = video.getPath()) != null) {
                        str = path;
                    }
                    zC = fVar2.c(str);
                }
                booleanRef.element = zC;
            }
        }
        return Boxing.a(booleanRef.element);
    }
}
