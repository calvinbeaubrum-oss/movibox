package com.transsnet.downloader.fragment;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import com.transsnet.downloader.manager.DownloadEsHelper;
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
@DebugMetadata(c = "com.transsnet.downloader.fragment.TransferReceivedListFragment$deleteItem$1", f = "TransferReceivedListFragment.kt", l = {133, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend")
public final class TransferReceivedListFragment$deleteItem$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ HistoricalPlayRecordMultipleEntity $entity;
    int label;
    final /* synthetic */ TransferReceivedListFragment this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.TransferReceivedListFragment$deleteItem$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.TransferReceivedListFragment$deleteItem$1$1", f = "TransferReceivedListFragment.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            zp.b.f82110a.d(R$string.download_delete_success);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferReceivedListFragment$deleteItem$1(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, TransferReceivedListFragment transferReceivedListFragment, Continuation<? super TransferReceivedListFragment$deleteItem$1> continuation) {
        super(2, continuation);
        this.$entity = historicalPlayRecordMultipleEntity;
        this.this$0 = transferReceivedListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransferReceivedListFragment$deleteItem$1(this.$entity, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TransferReceivedListFragment$deleteItem$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0064 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HistoricalPlayRecordBean historical;
        kotlinx.coroutines.a2 a2VarC;
        AnonymousClass1 anonymousClass1;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else if (i11 == 2) {
                ResultKt.b(obj);
                a2VarC = kotlinx.coroutines.w0.c();
                anonymousClass1 = new AnonymousClass1(null);
                this.label = 3;
                if (kotlinx.coroutines.h.g(a2VarC, anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.this$0.h1().A();
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity = this.$entity;
        DownloadBean video = (historicalPlayRecordMultipleEntity == null || (historical = historicalPlayRecordMultipleEntity.getHistorical()) == null) ? null : historical.getVideo();
        this.label = 1;
        if (downloadEsHelperA.i(video, this) == objE) {
            return objE;
        }
        this.label = 2;
        if (kotlinx.coroutines.r0.a(300L, this) == objE) {
            return objE;
        }
        a2VarC = kotlinx.coroutines.w0.c();
        anonymousClass1 = new AnonymousClass1(null);
        this.label = 3;
        if (kotlinx.coroutines.h.g(a2VarC, anonymousClass1, this) == objE) {
            return objE;
        }
        this.this$0.h1().A();
        return Unit.f68710a;
    }
}
