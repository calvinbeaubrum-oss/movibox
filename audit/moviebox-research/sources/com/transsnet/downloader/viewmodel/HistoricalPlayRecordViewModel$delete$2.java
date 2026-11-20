package com.transsnet.downloader.viewmodel;

import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$delete$2", f = "HistoricalPlayRecordViewModel.kt", l = {315}, m = "invokeSuspend")
public final class HistoricalPlayRecordViewModel$delete$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ HistoricalPlayRecordMultipleEntity $section;
    Object L$0;
    int label;
    final /* synthetic */ HistoricalPlayRecordViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoricalPlayRecordViewModel$delete$2(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, HistoricalPlayRecordViewModel historicalPlayRecordViewModel, Function0<Unit> function0, Continuation<? super HistoricalPlayRecordViewModel$delete$2> continuation) {
        super(2, continuation);
        this.$section = historicalPlayRecordMultipleEntity;
        this.this$0 = historicalPlayRecordViewModel;
        this.$callback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoricalPlayRecordViewModel$delete$2(this.$section, this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HistoricalPlayRecordViewModel$delete$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HistoricalPlayRecordBean historical;
        Function0<Unit> function0;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity = this.$section;
            if (historicalPlayRecordMultipleEntity != null && (historical = historicalPlayRecordMultipleEntity.getHistorical()) != null) {
                HistoricalPlayRecordViewModel historicalPlayRecordViewModel = this.this$0;
                Function0<Unit> function1 = this.$callback;
                this.L$0 = function1;
                this.label = 1;
                if (historicalPlayRecordViewModel.K(historical, this) == objE) {
                    return objE;
                }
                function0 = function1;
            }
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function0 = (Function0) this.L$0;
        ResultKt.b(obj);
        function0.invoke();
        return Unit.f68710a;
    }
}
