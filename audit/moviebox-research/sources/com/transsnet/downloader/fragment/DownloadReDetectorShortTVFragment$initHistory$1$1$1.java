package com.transsnet.downloader.fragment;

import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsnet.downloader.R$string;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initHistory$1$1$1", f = "DownloadReDetectorShortTVFragment.kt", l = {}, m = "invokeSuspend")
public final class DownloadReDetectorShortTVFragment$initHistory$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShortTVPlayBean $history;
    int label;
    final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadReDetectorShortTVFragment$initHistory$1$1$1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, ShortTVPlayBean shortTVPlayBean, Continuation<? super DownloadReDetectorShortTVFragment$initHistory$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadReDetectorShortTVFragment;
        this.$history = shortTVPlayBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadReDetectorShortTVFragment$initHistory$1$1$1(this.this$0, this.$history, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadReDetectorShortTVFragment$initHistory$1$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        h00.g0 g0Var = (h00.g0) this.this$0.getMViewBinding();
        AppCompatTextView appCompatTextView = g0Var != null ? g0Var.A : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(this.$history != null ? Utils.a().getString(R$string.continue_watch) : Utils.a().getString(com.transsion.baseui.R$string.play));
        }
        return Unit.f68710a;
    }
}
