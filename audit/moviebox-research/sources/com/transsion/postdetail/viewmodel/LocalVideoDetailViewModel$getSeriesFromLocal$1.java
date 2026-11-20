package com.transsion.postdetail.viewmodel;

import androidx.core.view.MotionEventCompat;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import uo.b;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel$getSeriesFromLocal$1", f = "LocalVideoDetailViewModel.kt", l = {MotionEventCompat.AXIS_GENERIC_13}, m = "invokeSuspend")
@SourceDebugExtension
public final class LocalVideoDetailViewModel$getSeriesFromLocal$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $curBean;
    int label;
    final /* synthetic */ LocalVideoDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoDetailViewModel$getSeriesFromLocal$1(DownloadBean downloadBean, LocalVideoDetailViewModel localVideoDetailViewModel, Continuation<? super LocalVideoDetailViewModel$getSeriesFromLocal$1> continuation) {
        super(2, continuation);
        this.$curBean = downloadBean;
        this.this$0 = localVideoDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailViewModel$getSeriesFromLocal$1(this.$curBean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoDetailViewModel$getSeriesFromLocal$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String subjectId;
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            DownloadBean downloadBean = this.$curBean;
            if (downloadBean == null || (subjectId = downloadBean.getSubjectId()) == null) {
                subjectId = "";
            }
            this.label = 1;
            obj = downloadEsHelperA.C(subjectId, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            LocalVideoDetailViewModel localVideoDetailViewModel = this.this$0;
            DownloadBean downloadBean2 = this.$curBean;
            int i12 = 0;
            for (Object obj2 : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    g.u();
                }
                DownloadBean downloadBean3 = (DownloadBean) obj2;
                b.a.f(b.f78622a, localVideoDetailViewModel.f56263a, "on get series, episode = " + downloadBean3.getEpse() + ", cur epse = " + (downloadBean2 != null ? downloadBean2.getEpse() : -1) + ", index = " + i12, false, 4, null);
                if (downloadBean3.isSeries()) {
                    if (!Intrinsics.b(downloadBean2 != null ? downloadBean2.getResourceId() : null, downloadBean3.getResourceId())) {
                        downloadBean3.setPlaying(false);
                    }
                    arrayList.add(downloadBean3);
                }
                i12 = i13;
            }
        }
        this.this$0.h().n(arrayList);
        return Unit.f68710a;
    }
}
