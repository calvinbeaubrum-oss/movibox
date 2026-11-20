package com.transsion.commercialization.pslink;

import androidx.core.view.MotionEventCompat;
import com.transsion.ad.ps.PSDistributionRequestManager;
import com.transsion.ad.ps.model.PsLinkDto;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
@DebugMetadata(c = "com.transsion.commercialization.pslink.PsLinkViewModel$getPsLinkList$1", f = "PsLinkViewModel.kt", l = {MotionEventCompat.AXIS_GENERIC_13}, m = "invokeSuspend")
public final class PsLinkViewModel$getPsLinkList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ String $pushModel;
    final /* synthetic */ boolean $retry;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ PsLinkViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.commercialization.pslink.PsLinkViewModel$getPsLinkList$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.commercialization.pslink.PsLinkViewModel$getPsLinkList$1$1", f = "PsLinkViewModel.kt", l = {MotionEventCompat.AXIS_GENERIC_14}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageIndex;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $pushModel;
        final /* synthetic */ boolean $retry;
        final /* synthetic */ String $scene;
        int label;
        final /* synthetic */ PsLinkViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i11, boolean z11, int i12, String str, String str2, PsLinkViewModel psLinkViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pageIndex = i11;
            this.$retry = z11;
            this.$pageSize = i12;
            this.$scene = str;
            this.$pushModel = str2;
            this.this$0 = psLinkViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$pageIndex, this.$retry, this.$pageSize, this.$scene, this.$pushModel, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                PSDistributionRequestManager pSDistributionRequestManager = PSDistributionRequestManager.f50548a;
                int i12 = this.$pageIndex;
                boolean z11 = this.$retry;
                int i13 = this.$pageSize;
                String str = this.$scene;
                String str2 = this.$pushModel;
                final PsLinkViewModel psLinkViewModel = this.this$0;
                Function1<PsLinkDto, Unit> function1 = new Function1<PsLinkDto, Unit>() { // from class: com.transsion.commercialization.pslink.PsLinkViewModel.getPsLinkList.1.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PsLinkDto psLinkDto) {
                        invoke2(psLinkDto);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PsLinkDto psLinkDto) {
                        psLinkViewModel.f51723a.n(psLinkDto);
                    }
                };
                this.label = 1;
                if (pSDistributionRequestManager.c(i12, z11, i13, str, str2, function1, this) == objE) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PsLinkViewModel$getPsLinkList$1(int i11, boolean z11, int i12, String str, String str2, PsLinkViewModel psLinkViewModel, Continuation<? super PsLinkViewModel$getPsLinkList$1> continuation) {
        super(2, continuation);
        this.$pageIndex = i11;
        this.$retry = z11;
        this.$pageSize = i12;
        this.$scene = str;
        this.$pushModel = str2;
        this.this$0 = psLinkViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PsLinkViewModel$getPsLinkList$1(this.$pageIndex, this.$retry, this.$pageSize, this.$scene, this.$pushModel, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PsLinkViewModel$getPsLinkList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            CoroutineDispatcher coroutineDispatcherB = w0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pageIndex, this.$retry, this.$pageSize, this.$scene, this.$pushModel, this.this$0, null);
            this.label = 1;
            if (h.g(coroutineDispatcherB, anonymousClass1, this) == objE) {
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
