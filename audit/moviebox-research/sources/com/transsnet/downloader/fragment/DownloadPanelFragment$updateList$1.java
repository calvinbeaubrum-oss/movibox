package com.transsnet.downloader.fragment;

import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadPanelFragment$updateList$1", f = "DownloadPanelFragment.kt", l = {}, m = "invokeSuspend")
public final class DownloadPanelFragment$updateList$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadPanelFragment this$0;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends jq.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadPanelFragment f60685a;

        public a(DownloadPanelFragment downloadPanelFragment) {
            this.f60685a = downloadPanelFragment;
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            DownloadListManager.a aVar = DownloadListManager.f61186m;
            DownloadListManager.x(aVar.a(), aVar.a().J(), false, this.f60685a.Q0(), 2, null);
            this.f60685a.f60672s = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadPanelFragment$updateList$1(DownloadPanelFragment downloadPanelFragment, Continuation<? super DownloadPanelFragment$updateList$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadPanelFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadPanelFragment$updateList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadPanelFragment$updateList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        com.transsion.ad.bidding.nativead.c cVarQ0 = this.this$0.Q0();
        if (cVarQ0 != null) {
            DownloadPanelFragment downloadPanelFragment = this.this$0;
            cVarQ0.m0("DownloadListScene");
            cVarQ0.l0(new a(downloadPanelFragment));
        }
        return Unit.f68710a;
    }
}
