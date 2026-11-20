package com.transsion.ad.bidding.nativead;

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
@DebugMetadata(c = "com.transsion.ad.bidding.nativead.BiddingListManager$getDelegate$1$1", f = "BiddingListManager.kt", l = {233}, m = "invokeSuspend")
public final class BiddingListManager$getDelegate$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $nativeManager;
    int label;
    final /* synthetic */ BiddingListManager this$0;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends jq.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BiddingListManager f50366a;

        public a(BiddingListManager biddingListManager) {
            this.f50366a = biddingListManager;
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            com.transsion.ad.a.L(com.transsion.ad.a.f50276a, this.f50366a.p() + " --> 广告加载失败 废弃当前的重新创建一个对象进行加载 -- p0 = " + tAdErrorCode, false, 2, null);
            c cVar = this.f50366a.f50353c;
            if (cVar != null) {
                cVar.F();
            }
            this.f50366a.f50353c = null;
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            if (this.f50366a.f50359i) {
                this.f50366a.w();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiddingListManager$getDelegate$1$1(c cVar, BiddingListManager biddingListManager, Continuation<? super BiddingListManager$getDelegate$1$1> continuation) {
        super(2, continuation);
        this.$nativeManager = cVar;
        this.this$0 = biddingListManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiddingListManager$getDelegate$1$1(this.$nativeManager, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((BiddingListManager$getDelegate$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.$nativeManager.k0(this.this$0.f50351a);
            this.$nativeManager.m0(this.this$0.f50360j);
            this.$nativeManager.l0(new a(this.this$0));
            c cVar = this.$nativeManager;
            this.label = 1;
            if (cVar.T(this) == objE) {
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
