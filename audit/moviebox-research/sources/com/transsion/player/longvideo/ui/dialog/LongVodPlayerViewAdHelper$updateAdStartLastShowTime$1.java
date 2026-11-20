package com.transsion.player.longvideo.ui.dialog;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1", f = "LongVodPlayerViewAdHelper.kt", l = {472, 474}, m = "invokeSuspend")
public final class LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, Continuation<? super LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerViewAdHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper;
        VideoDetailPlayBean videoDetailPlayBean;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                videoDetailPlayBean = (VideoDetailPlayBean) this.L$1;
                longVodPlayerViewAdHelper = (LongVodPlayerViewAdHelper) this.L$0;
                ResultKt.b(obj);
            }
            longVodPlayerViewAdHelper.f54543o = false;
            com.transsion.ad.a.j(com.transsion.ad.a.f50276a, longVodPlayerViewAdHelper.X0() + " --> isShowStartAd() --> 保存启播广告时间戳 --> videoDetailPlayBean = " + videoDetailPlayBean, false, 2, null);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper2 = this.this$0;
        this.label = 1;
        obj = longVodPlayerViewAdHelper2.q1(this);
        if (obj == objE) {
            return objE;
        }
        VideoDetailPlayBean videoDetailPlayBean2 = (VideoDetailPlayBean) obj;
        if (videoDetailPlayBean2 != null) {
            longVodPlayerViewAdHelper = this.this$0;
            videoDetailPlayBean2.setLastAdStartTimeStamp(Boxing.e(System.currentTimeMillis()));
            VideoDetailPlayDao videoDetailPlayDaoR1 = longVodPlayerViewAdHelper.r1();
            this.L$0 = longVodPlayerViewAdHelper;
            this.L$1 = videoDetailPlayBean2;
            this.label = 2;
            if (videoDetailPlayDaoR1.q(videoDetailPlayBean2, this) == objE) {
                return objE;
            }
            videoDetailPlayBean = videoDetailPlayBean2;
            longVodPlayerViewAdHelper.f54543o = false;
            com.transsion.ad.a.j(com.transsion.ad.a.f50276a, longVodPlayerViewAdHelper.X0() + " --> isShowStartAd() --> 保存启播广告时间戳 --> videoDetailPlayBean = " + videoDetailPlayBean, false, 2, null);
        }
        return Unit.f68710a;
    }
}
