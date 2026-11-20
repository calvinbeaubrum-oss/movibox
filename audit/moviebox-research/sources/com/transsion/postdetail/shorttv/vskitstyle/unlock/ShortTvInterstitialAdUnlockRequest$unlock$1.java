package com.transsion.postdetail.shorttv.vskitstyle.unlock;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import rx.c;
import rx.e;
import rx.f;

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
@DebugMetadata(c = "com.transsion.postdetail.shorttv.vskitstyle.unlock.ShortTvInterstitialAdUnlockRequest$unlock$1", f = "ShortTvInterstitialAdUnlockRequest.kt", l = {49}, m = "invokeSuspend")
public final class ShortTvInterstitialAdUnlockRequest$unlock$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ f $params;
    int label;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends jq.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f55453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.transsion.ad.bidding.interstitial.a f55454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f55455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f55456d;

        public a(Context context, com.transsion.ad.bidding.interstitial.a aVar, e eVar, f fVar) {
            this.f55453a = context;
            this.f55454b = aVar;
            this.f55455c = eVar;
            this.f55456d = fVar;
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            this.f55455c.a(new c(tAdErrorCode != null ? tAdErrorCode.getErrorCode() : c.f75753d.a(), tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null, this.f55456d));
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            Context context = this.f55453a;
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null) {
                this.f55454b.n0(fragmentActivity);
            }
        }

        @Override // jq.a
        public void j(int i11) {
            super.j(i11);
            this.f55454b.F();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvInterstitialAdUnlockRequest$unlock$1(Context context, e eVar, f fVar, Continuation<? super ShortTvInterstitialAdUnlockRequest$unlock$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$callback = eVar;
        this.$params = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvInterstitialAdUnlockRequest$unlock$1(this.$context, this.$callback, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvInterstitialAdUnlockRequest$unlock$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            com.transsion.ad.bidding.interstitial.a aVar = new com.transsion.ad.bidding.interstitial.a();
            aVar.m0("ShortTvInterstitialScene");
            aVar.l0(new a(this.$context, aVar, this.$callback, this.$params));
            this.label = 1;
            if (aVar.T(this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
