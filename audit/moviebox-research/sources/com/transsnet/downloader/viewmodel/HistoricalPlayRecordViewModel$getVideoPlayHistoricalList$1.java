package com.transsnet.downloader.viewmodel;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getVideoPlayHistoricalList$1", f = "HistoricalPlayRecordViewModel.kt", l = {105, 107}, m = "invokeSuspend")
@SourceDebugExtension
public final class HistoricalPlayRecordViewModel$getVideoPlayHistoricalList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefreshAll;
    final /* synthetic */ boolean $isWhole;
    Object L$0;
    int label;
    final /* synthetic */ HistoricalPlayRecordViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoricalPlayRecordViewModel$getVideoPlayHistoricalList$1(boolean z11, HistoricalPlayRecordViewModel historicalPlayRecordViewModel, boolean z12, Continuation<? super HistoricalPlayRecordViewModel$getVideoPlayHistoricalList$1> continuation) {
        super(2, continuation);
        this.$isRefreshAll = z11;
        this.this$0 = historicalPlayRecordViewModel;
        this.$isWhole = z12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoricalPlayRecordViewModel$getVideoPlayHistoricalList$1(this.$isRefreshAll, this.this$0, this.$isWhole, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HistoricalPlayRecordViewModel$getVideoPlayHistoricalList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list;
        List<VideoDetailPlayBean> list2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            if (this.$isRefreshAll) {
                VideoDetailPlayDao videoDetailPlayDaoG = this.this$0.G();
                int iZ = this.this$0.z();
                this.L$0 = arrayList;
                this.label = 1;
                Object objN = videoDetailPlayDaoG.n(0, iZ, this);
                if (objN == objE) {
                    return objE;
                }
                list = arrayList;
                obj = objN;
                list2 = (List) obj;
            } else {
                VideoDetailPlayDao videoDetailPlayDaoG2 = this.this$0.G();
                int iZ2 = this.this$0.z();
                int i12 = this.this$0.f61265o;
                this.L$0 = arrayList;
                this.label = 2;
                Object objN2 = videoDetailPlayDaoG2.n(iZ2, i12, this);
                if (objN2 == objE) {
                    return objE;
                }
                list = arrayList;
                obj = objN2;
                list2 = (List) obj;
            }
        } else if (i11 == 1) {
            list = (List) this.L$0;
            ResultKt.b(obj);
            list2 = (List) obj;
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) this.L$0;
            ResultKt.b(obj);
            list2 = (List) obj;
        }
        if (list2 != null) {
            for (VideoDetailPlayBean videoDetailPlayBean : list2) {
                Integer subjectType = videoDetailPlayBean.getSubjectType();
                list.add(new HistoricalPlayRecordBean((subjectType != null && subjectType.intValue() == 6) ? 6 : 7, Boxing.e(videoDetailPlayBean.getTimeStamp()), TimeUtilKt.h(videoDetailPlayBean.getTimeStamp()), c.f61276a.E(videoDetailPlayBean.getTimeStamp()), null, null, null, videoDetailPlayBean, 64, null));
            }
        }
        if (this.$isRefreshAll) {
            this.this$0.Q(0);
        }
        HistoricalPlayRecordViewModel historicalPlayRecordViewModel = this.this$0;
        historicalPlayRecordViewModel.Q(historicalPlayRecordViewModel.z() + list.size());
        this.this$0.v().n(this.this$0.n(list, this.$isWhole));
        return Unit.f68710a;
    }
}
