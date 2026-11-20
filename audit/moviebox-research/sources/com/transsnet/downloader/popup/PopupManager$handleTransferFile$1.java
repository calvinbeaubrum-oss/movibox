package com.transsnet.downloader.popup;

import android.content.Context;
import com.transsnet.downloader.dialog.DownloadReDetectorSaveDialog;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.popup.PopupManager$handleTransferFile$1", f = "PopupManager.kt", l = {382, 458}, m = "invokeSuspend")
public final class PopupManager$handleTransferFile$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $checkTransferFailed;
    final /* synthetic */ Context $context;
    final /* synthetic */ f00.b $info;
    final /* synthetic */ DownloadReDetectorSaveDialog $loadingDialog;
    final /* synthetic */ Function2<Boolean, Integer, Unit> $resultCallback;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PopupManager this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.popup.PopupManager$handleTransferFile$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.popup.PopupManager$handleTransferFile$1$1", f = "PopupManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $checkTransferFailed;
        final /* synthetic */ DownloadReDetectorSaveDialog $loadingDialog;
        int label;
        final /* synthetic */ PopupManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DownloadReDetectorSaveDialog downloadReDetectorSaveDialog, PopupManager popupManager, boolean z11, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$loadingDialog = downloadReDetectorSaveDialog;
            this.this$0 = popupManager;
            this.$checkTransferFailed = z11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$loadingDialog, this.this$0, this.$checkTransferFailed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            uo.b.f78622a.c("resource_save", "剧集存储全不符合，都跳过，直接成功", true);
            if (this.$loadingDialog.isAdded()) {
                this.$loadingDialog.dismissAllowingStateLoss();
            }
            zp.b.f82110a.e(this.this$0.s(this.$checkTransferFailed));
            this.$loadingDialog.L0(100);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PopupManager$handleTransferFile$1(PopupManager popupManager, boolean z11, Context context, f00.b bVar, DownloadReDetectorSaveDialog downloadReDetectorSaveDialog, Function2<? super Boolean, ? super Integer, Unit> function2, Continuation<? super PopupManager$handleTransferFile$1> continuation) {
        super(2, continuation);
        this.this$0 = popupManager;
        this.$checkTransferFailed = z11;
        this.$context = context;
        this.$info = bVar;
        this.$loadingDialog = downloadReDetectorSaveDialog;
        this.$resultCallback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PopupManager$handleTransferFile$1(this.this$0, this.$checkTransferFailed, this.$context, this.$info, this.$loadingDialog, this.$resultCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PopupManager$handleTransferFile$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x013f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0172  */
    /* JADX WARN: Code duplicated, block: B:49:0x017b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0181  */
    /* JADX WARN: Code duplicated, block: B:55:0x019e  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x01ff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x0200  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0200 -> B:61:0x0201). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            Method dump skipped, instruction units count: 751
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.popup.PopupManager$handleTransferFile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
