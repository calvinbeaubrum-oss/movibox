package com.transsion.ad.bidding.base;

import android.os.Handler;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsion.ad.bidding.base.AbsAdBidding$loadAd$2", f = "AbsAdBidding.kt", l = {505}, m = "invokeSuspend")
public final class AbsAdBidding$loadAd$2 extends SuspendLambda implements Function2<k0, Continuation<? super Object>, Object> {
    int label;
    final /* synthetic */ AbsAdBidding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsAdBidding$loadAd$2(AbsAdBidding absAdBidding, Continuation<? super AbsAdBidding$loadAd$2> continuation) {
        super(2, continuation);
        this.this$0 = absAdBidding;
    }

    public static final void d(AbsAdBidding absAdBidding) {
        absAdBidding.X();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsAdBidding$loadAd$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k0 k0Var, Continuation<? super Object> continuation) {
        return invoke2(k0Var, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k0 k0Var, Continuation<Object> continuation) {
        return ((AbsAdBidding$loadAd$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.label = 1;
            obj = AdPlansStorageManager.f50532a.b(this.this$0.Q(), this.this$0.L(), new AdPlanSourceManager.AdPlanEnum[0], this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        if (list.isEmpty()) {
            this.this$0.g(new TAdErrorCode(105, "there are currently no plans available"));
            return Unit.f68710a;
        }
        Pair pairH = this.this$0.H(list);
        this.this$0.f50288h = (List) pairH.getFirst();
        boolean zBooleanValue = ((Boolean) pairH.getSecond()).booleanValue();
        AbsAdBidding absAdBidding = this.this$0;
        String strQ = absAdBidding.Q();
        Map<String, Object> mapL = this.this$0.L();
        int size = list.size();
        List list2 = this.this$0.f50288h;
        absAdBidding.a0(3, "loadAd() --> 开始竞价 --> sceneId = " + strQ + " --> ctxMap = " + mapL + " --> planList?.size = " + size + " --> hasHiAdPlan = " + zBooleanValue + " --> biddingPlanList.size = " + (list2 != null ? Boxing.d(list2.size()) : null));
        if (!zBooleanValue) {
            this.this$0.X();
            return Unit.f68710a;
        }
        Handler handler = this.this$0.f50287g;
        final AbsAdBidding absAdBidding2 = this.this$0;
        return Boxing.a(handler.postDelayed(new Runnable() { // from class: com.transsion.ad.bidding.base.j
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding$loadAd$2.d(absAdBidding2);
            }
        }, this.this$0.J()));
    }
}
