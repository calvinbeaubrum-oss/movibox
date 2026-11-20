package com.transsion.home.adapter.trending;

import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.MonopolyAdPlanProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import uo.b;
import xq.j;

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
@DebugMetadata(c = "com.transsion.home.adapter.trending.BannerADDataHelper$fetchData$1", f = "BannerADDataHelper.kt", l = {26}, m = "invokeSuspend")
public final class BannerADDataHelper$fetchData$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;

    public BannerADDataHelper$fetchData$1(Continuation<? super BannerADDataHelper$fetchData$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BannerADDataHelper$fetchData$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((BannerADDataHelper$fetchData$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            BannerADDataHelper bannerADDataHelper = BannerADDataHelper.f52219a;
            MonopolyAdPlanProvider monopolyAdPlanProvider = MonopolyAdPlanProvider.f50544a;
            Map<String, ? extends Object> mapH = s.h();
            this.label = 1;
            obj = monopolyAdPlanProvider.b("TrendingBannerScene", mapH, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        BannerADDataHelper.f52220b = (AdPlans) obj;
        BannerADDataHelper bannerADDataHelper2 = BannerADDataHelper.f52219a;
        bannerADDataHelper2.h(j.f80681a.b());
        MonopolyAdPlanProvider monopolyAdPlanProvider2 = MonopolyAdPlanProvider.f50544a;
        AdPlans adPlans = BannerADDataHelper.f52220b;
        monopolyAdPlanProvider2.l("TrendingBannerScene", adPlans != null ? adPlans.getId() : null, bannerADDataHelper2.g());
        BannerADDataHelper.f52221c = wq.a.f(wq.a.f79581a, "TrendingBannerScene", 0, 2, null);
        b.a.f(b.f78622a, "BannerADDataHelper", "fetchADData----adIndex:" + BannerADDataHelper.f52221c + " adPlan:" + BannerADDataHelper.f52220b, false, 4, null);
        return Unit.f68710a;
    }
}
