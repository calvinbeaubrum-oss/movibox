package com.transsion.videodetail;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.videodetail.util.StreamFloatManager;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchHistory$1", f = "VideoDetailViewModel.kt", l = {120}, m = "invokeSuspend")
public final class VideoDetailViewModel$fetchHistory$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ VideoDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailViewModel$fetchHistory$1(VideoDetailViewModel videoDetailViewModel, String str, Continuation<? super VideoDetailViewModel$fetchHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDetailViewModel;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDetailViewModel$fetchHistory$1(this.this$0, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((VideoDetailViewModel$fetchHistory$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            VideoDetailPlayDao videoDetailPlayDaoY = this.this$0.y();
            String str = this.$subjectId;
            this.label = 1;
            objD = videoDetailPlayDaoY.d(str, this);
            if (objD == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            objD = obj;
        }
        VideoDetailPlayBean videoDetailPlayBean = (VideoDetailPlayBean) objD;
        if (videoDetailPlayBean != null) {
            String str2 = this.$subjectId + "+" + videoDetailPlayBean.getSe() + "+" + videoDetailPlayBean.getEp();
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "VideoDetail", "fetchHistory--key:" + str2, false, 4, null);
            Long lE = StreamFloatManager.f60006b.e(str2);
            if (lE != null) {
                long jLongValue = lE.longValue();
                uo.b.a.o(aVar, "VideoDetail", new String[]{"update--key:" + str2 + ", value:" + jLongValue + ",last:" + videoDetailPlayBean.getProgress()}, false, 4, null);
                if (jLongValue > 0 && jLongValue != videoDetailPlayBean.getProgress()) {
                    videoDetailPlayBean.setProgress(jLongValue);
                }
            }
        }
        uo.b.a.o(uo.b.f78622a, "VideoDetail", new String[]{"fetchHistory  subjectId:" + this.$subjectId + ",history:" + videoDetailPlayBean}, false, 4, null);
        this.this$0.f59865h.q(videoDetailPlayBean);
        return Unit.f68710a;
    }
}
