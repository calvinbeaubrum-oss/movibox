package com.transsnet.downloader.view;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.j;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.view.DownloadingTipsDialogFragment$showAd$1", f = "DownloadingTipsDialogFragment.kt", l = {230}, m = "invokeSuspend")
public final class DownloadingTipsDialogFragment$showAd$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadingTipsDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadingTipsDialogFragment$showAd$1(DownloadingTipsDialogFragment downloadingTipsDialogFragment, Continuation<? super DownloadingTipsDialogFragment$showAd$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadingTipsDialogFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadingTipsDialogFragment$showAd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadingTipsDialogFragment$showAd$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String genre;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (this.this$0.f61173c == null) {
                this.this$0.f61173c = new com.transsion.ad.bidding.nativead.c();
                com.transsion.ad.bidding.nativead.c cVar = this.this$0.f61173c;
                if (cVar != null) {
                    cVar.m0("DownloadPopupScene");
                }
                com.transsion.ad.bidding.nativead.c cVar2 = this.this$0.f61173c;
                if (cVar2 != null) {
                    com.transsion.ad.strategy.b bVar = com.transsion.ad.strategy.b.f50584a;
                    DownloadBean downloadBean = this.this$0.f61180k;
                    if (downloadBean == null || (genre = downloadBean.getGenre()) == null) {
                        genre = "";
                    }
                    cVar2.k0(bVar.a(genre));
                }
                com.transsion.ad.bidding.nativead.c cVar3 = this.this$0.f61173c;
                if (cVar3 != null) {
                    final DownloadingTipsDialogFragment downloadingTipsDialogFragment = this.this$0;
                    cVar3.l0(new jq.a() { // from class: com.transsnet.downloader.view.DownloadingTipsDialogFragment$showAd$1.1
                        @Override // jq.a
                        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                            super.h(biddingIntermediateMaterialBean);
                            FragmentActivity activity = downloadingTipsDialogFragment.getActivity();
                            if (activity != null) {
                                j.d(v.a(activity), null, null, new DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1(downloadingTipsDialogFragment, activity, null), 3, null);
                            }
                        }
                    });
                }
            }
            com.transsion.ad.bidding.nativead.c cVar4 = this.this$0.f61173c;
            if (cVar4 != null) {
                this.label = 1;
                if (cVar4.T(this) == objE) {
                    return objE;
                }
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
