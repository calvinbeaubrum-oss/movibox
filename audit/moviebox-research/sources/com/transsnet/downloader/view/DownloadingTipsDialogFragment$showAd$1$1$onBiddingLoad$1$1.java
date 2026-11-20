package com.transsnet.downloader.view;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import h00.s;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.view.DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1", f = "DownloadingTipsDialogFragment.kt", l = {}, m = "invokeSuspend")
public final class DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $it;
    int label;
    final /* synthetic */ DownloadingTipsDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1(DownloadingTipsDialogFragment downloadingTipsDialogFragment, FragmentActivity fragmentActivity, Continuation<? super DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadingTipsDialogFragment;
        this.$it = fragmentActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        NativeWrapperAdView nativeWrapperAdView;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        s sVar = this.this$0.f61174d;
        CardView cardView = sVar != null ? sVar.f66010c : null;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        d00.b bVar = d00.b.f62855a;
        FragmentActivity it = this.$it;
        Intrinsics.f(it, "it");
        com.transsion.ad.bidding.nativead.c cVar = this.this$0.f61173c;
        zq.b bVarA = bVar.a(it, cVar != null ? cVar.Q() : null);
        s sVar2 = this.this$0.f61174d;
        if (sVar2 != null && (nativeWrapperAdView = sVar2.f66009b) != null) {
            nativeWrapperAdView.bindNativeView(this.this$0.f61173c, bVarA);
        }
        return Unit.f68710a;
    }
}
