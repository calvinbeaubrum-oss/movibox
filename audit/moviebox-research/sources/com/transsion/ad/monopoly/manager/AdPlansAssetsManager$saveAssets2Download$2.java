package com.transsion.ad.monopoly.manager;

import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.blankj.utilcode.util.n;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.strategy.AdMmkv;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import xq.d;

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
@DebugMetadata(c = "com.transsion.ad.monopoly.manager.AdPlansAssetsManager$saveAssets2Download$2", f = "AdPlansAssetsManager.kt", l = {33, MotionEventCompat.AXIS_GENERIC_16}, m = "invokeSuspend")
public final class AdPlansAssetsManager$saveAssets2Download$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public AdPlansAssetsManager$saveAssets2Download$2(Continuation<? super AdPlansAssetsManager$saveAssets2Download$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdPlansAssetsManager$saveAssets2Download$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((AdPlansAssetsManager$saveAssets2Download$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009e A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:7:0x0014, B:31:0x0090, B:33:0x009e, B:35:0x00a4, B:37:0x00b5, B:39:0x00bb, B:41:0x00c5, B:43:0x00cb, B:45:0x00d1, B:47:0x010d, B:13:0x0024, B:19:0x0038, B:21:0x003e, B:24:0x0045, B:25:0x0063, B:27:0x0071, B:46:0x00f1, B:16:0x002b), top: B:56:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cb A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:7:0x0014, B:31:0x0090, B:33:0x009e, B:35:0x00a4, B:37:0x00b5, B:39:0x00bb, B:41:0x00c5, B:43:0x00cb, B:45:0x00d1, B:47:0x010d, B:13:0x0024, B:19:0x0038, B:21:0x003e, B:24:0x0045, B:25:0x0063, B:27:0x0071, B:46:0x00f1, B:16:0x002b), top: B:56:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:53:0x0125  */
    /* JADX WARN: Instruction removed from duplicated block: B:53:0x0125, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Throwable thM166exceptionOrNullimpl;
        MbAdPlansDto mbAdPlansDto;
        MbAdPlansBean data;
        String version;
        MbAdPlansBean data2;
        Integer numD;
        MbAdPlansBean data3;
        List<AdPlans> adPlans;
        List<AdPlans> adPlans2;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mbAdPlansDto = (MbAdPlansDto) this.L$0;
                    ResultKt.b(obj);
                }
                MMKV mmkvB = AdMmkv.f50558a.b();
                data = mbAdPlansDto.getData();
                if (data != null) {
                    version = data.getVersion();
                } else {
                    version = null;
                }
                mmkvB.putString("non_ad_plan_version", version);
                com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
                String strE = AdPlansAssetsManager.f50529a.e();
                data2 = mbAdPlansDto.getData();
                if (data2 != null || (adPlans2 = data2.getAdPlans()) == null) {
                    numD = null;
                } else {
                    numD = Boxing.d(adPlans2.size());
                }
                data3 = mbAdPlansDto.getData();
                if (data3 != null) {
                    adPlans = data3.getAdPlans();
                } else {
                    adPlans = null;
                }
                com.transsion.ad.a.b(aVar, strE + " --> saveAssets2Download() --> success --> adPlans?.size -- " + numD + " --> adPlans = " + adPlans, false, 2, null);
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    com.transsion.ad.a.d(com.transsion.ad.a.f50276a, AdPlansAssetsManager.f50529a.e() + " --> saveAssets2Download() --> 保存本地数据异常 -- error error error --> it = " + thM166exceptionOrNullimpl, false, 2, null);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            Result.Companion companion = Result.Companion;
            AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f50532a;
            this.label = 1;
            obj = adPlansStorageManager.h(this);
            if (obj == objE) {
                return objE;
            }
            List list = (List) obj;
            if (list == null || list.isEmpty()) {
                String strB = d.f80669a.b("local_non_ad_plan.json");
                if (TextUtils.isEmpty(strB)) {
                    com.transsion.ad.a.d(com.transsion.ad.a.f50276a, AdPlansAssetsManager.f50529a.e() + " --> saveAssets2Download() --> assets数据 -- 保存数据库失败 -- fail fail fail -- readAssets = null", false, 2, null);
                } else {
                    MbAdPlansDto analysisMbAdPlansDto = (MbAdPlansDto) n.d(strB, MbAdPlansDto.class);
                    AdPlansAssetsManager adPlansAssetsManager = AdPlansAssetsManager.f50529a;
                    Intrinsics.f(analysisMbAdPlansDto, "analysisMbAdPlansDto");
                    MbAdPlansDto mbAdPlansDtoD = adPlansAssetsManager.d(analysisMbAdPlansDto);
                    this.L$0 = mbAdPlansDtoD;
                    this.label = 2;
                    if (adPlansAssetsManager.f(mbAdPlansDtoD, this) == objE) {
                        return objE;
                    }
                    mbAdPlansDto = mbAdPlansDtoD;
                    MMKV mmkvB2 = AdMmkv.f50558a.b();
                    data = mbAdPlansDto.getData();
                    if (data != null) {
                        version = data.getVersion();
                    } else {
                        version = null;
                    }
                    mmkvB2.putString("non_ad_plan_version", version);
                    com.transsion.ad.a aVar2 = com.transsion.ad.a.f50276a;
                    String strE2 = AdPlansAssetsManager.f50529a.e();
                    data2 = mbAdPlansDto.getData();
                    if (data2 != null) {
                        numD = null;
                    } else {
                        numD = null;
                    }
                    data3 = mbAdPlansDto.getData();
                    if (data3 != null) {
                        adPlans = data3.getAdPlans();
                    } else {
                        adPlans = null;
                    }
                    com.transsion.ad.a.b(aVar2, strE2 + " --> saveAssets2Download() --> success --> adPlans?.size -- " + numD + " --> adPlans = " + adPlans, false, 2, null);
                }
            } else {
                com.transsion.ad.a.b(com.transsion.ad.a.f50276a, AdPlansAssetsManager.f50529a.e() + " --> saveAssets2Download() --> 本地存在非标广告计划，不需要从assets下载", false, 2, null);
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            com.transsion.ad.a.d(com.transsion.ad.a.f50276a, AdPlansAssetsManager.f50529a.e() + " --> saveAssets2Download() --> 保存本地数据异常 -- error error error --> it = " + thM166exceptionOrNullimpl, false, 2, null);
        }
        return Unit.f68710a;
    }
}
