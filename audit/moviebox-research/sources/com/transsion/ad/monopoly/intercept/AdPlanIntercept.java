package com.transsion.ad.monopoly.intercept;

import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

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
public final class AdPlanIntercept {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdPlanIntercept f50523a = new AdPlanIntercept();

    /* JADX WARN: Code duplicated, block: B:25:0x00c8 A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:11:0x0026, B:23:0x00c4, B:25:0x00c8, B:26:0x00cf, B:18:0x0039, B:20:0x00bb), top: B:34:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) {
        AdPlanIntercept$isHit$1 adPlanIntercept$isHit$1;
        Object objM163constructorimpl;
        Throwable thM166exceptionOrNullimpl;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof AdPlanIntercept$isHit$1) {
            adPlanIntercept$isHit$1 = (AdPlanIntercept$isHit$1) continuation;
            int i11 = adPlanIntercept$isHit$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                adPlanIntercept$isHit$1.label = i11 - Integer.MIN_VALUE;
            } else {
                adPlanIntercept$isHit$1 = new AdPlanIntercept$isHit$1(this, continuation);
            }
        } else {
            adPlanIntercept$isHit$1 = new AdPlanIntercept$isHit$1(this, continuation);
        }
        Object objB = adPlanIntercept$isHit$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = adPlanIntercept$isHit$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(objB);
                Result.Companion companion = Result.Companion;
                a aVarB = new a.C0547a().a(new ShowOnNetworkStateHandler()).a(new SceneInWhitelistHandler()).a(new CountryInWhitelistHandler()).a(new InDenyBrandHandler()).a(new BrandInWhitelistHandler()).a(new InDenyModelHandler()).a(new ModelInWhitelistHandler()).a(new ValidTimeHandler()).a(new ValidDispatchTimeHandler()).a(new ValidTimesHandler()).a(new c()).a(new b()).a(new AdResourceDownloadedHandler()).b();
                if (aVarB != null) {
                    adPlanIntercept$isHit$1.label = 1;
                    objB = aVarB.b(str, mbAdDbPlans, map, adPlanIntercept$isHit$1);
                    if (objB == objE) {
                        return objE;
                    }
                } else {
                    adPlansHitResponse = new AdPlansHitResponse(false, TmcEngineFactory.ENGINE_TYPE_DEFAULT);
                }
                objM163constructorimpl = Result.m163constructorimpl(adPlansHitResponse);
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl == null) {
                    return objM163constructorimpl;
                }
                return new AdPlansHitResponse(false, thM166exceptionOrNullimpl.getMessage());
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objB);
            adPlansHitResponse = (AdPlansHitResponse) objB;
            if (adPlansHitResponse == null) {
                adPlansHitResponse = new AdPlansHitResponse(false, TmcEngineFactory.ENGINE_TYPE_DEFAULT);
            }
            objM163constructorimpl = Result.m163constructorimpl(adPlansHitResponse);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return objM163constructorimpl;
        }
        return new AdPlansHitResponse(false, thM166exceptionOrNullimpl.getMessage());
    }
}
