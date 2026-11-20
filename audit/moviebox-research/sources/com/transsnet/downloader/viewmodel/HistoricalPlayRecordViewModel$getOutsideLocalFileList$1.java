package com.transsnet.downloader.viewmodel;

import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.j;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
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
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getOutsideLocalFileList$1", f = "HistoricalPlayRecordViewModel.kt", l = {183}, m = "invokeSuspend")
@SourceDebugExtension
public final class HistoricalPlayRecordViewModel$getOutsideLocalFileList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ HistoricalPlayRecordViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoricalPlayRecordViewModel$getOutsideLocalFileList$1(HistoricalPlayRecordViewModel historicalPlayRecordViewModel, Continuation<? super HistoricalPlayRecordViewModel$getOutsideLocalFileList$1> continuation) {
        super(2, continuation);
        this.this$0 = historicalPlayRecordViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoricalPlayRecordViewModel$getOutsideLocalFileList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HistoricalPlayRecordViewModel$getOutsideLocalFileList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long j11;
        List list;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            long jCurrentTimeMillis = System.currentTimeMillis();
            c.f61276a.x("获取本地视频列表 --> 开始 开始 开始 ");
            ArrayList arrayList = new ArrayList();
            HistoricalPlayRecordViewModel historicalPlayRecordViewModel = this.this$0;
            this.L$0 = arrayList;
            this.J$0 = jCurrentTimeMillis;
            this.label = 1;
            if (historicalPlayRecordViewModel.B(arrayList, this) == objE) {
                return objE;
            }
            j11 = jCurrentTimeMillis;
            list = arrayList;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j11 = this.J$0;
            list = (List) this.L$0;
            ResultKt.b(obj);
        }
        if (list.size() > 1) {
            j.z(list, new Comparator() { // from class: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getOutsideLocalFileList$1$invokeSuspend$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return kotlin.comparisons.b.d(((HistoricalPlayRecordBean) t12).getUpdateTimeStamp(), ((HistoricalPlayRecordBean) t11).getUpdateTimeStamp());
                }
            });
        }
        List<HistoricalPlayRecordMultipleEntity> listO = HistoricalPlayRecordViewModel.o(this.this$0, list, false, 2, null);
        this.this$0.w().n(listO);
        c.f61276a.x("获取本地视频列表 --> 结束 结束 结束 耗时 = " + (System.currentTimeMillis() - j11) + "， orginalSize:" + list.size() + ",size：" + listO.size());
        return Unit.f68710a;
    }
}
