package com.transsion.player.longvideo.ui.dialog;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$setLongVdPlayerBean$1", f = "LongVodPlayerViewAdHelper.kt", l = {230}, m = "invokeSuspend")
public final class LongVodPlayerViewAdHelper$setLongVdPlayerBean$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ lv.a $bean;
    Object L$0;
    int label;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodPlayerViewAdHelper$setLongVdPlayerBean$1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, lv.a aVar, Continuation<? super LongVodPlayerViewAdHelper$setLongVdPlayerBean$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerViewAdHelper;
        this.$bean = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerViewAdHelper$setLongVdPlayerBean$1(this.this$0, this.$bean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LongVodPlayerViewAdHelper$setLongVdPlayerBean$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper;
        Long lastAdEndTimeStamp;
        Long lastAdStartTimeStamp;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.this$0.f54530b = this.$bean;
            LongVodPlayerViewAdHelper longVodPlayerViewAdHelper2 = this.this$0;
            VideoDetailPlayDao videoDetailPlayDaoR1 = longVodPlayerViewAdHelper2.r1();
            String strM = this.$bean.m();
            int iK = this.$bean.k();
            int iD = this.$bean.d();
            this.L$0 = longVodPlayerViewAdHelper2;
            this.label = 1;
            Object objK = videoDetailPlayDaoR1.k(strM, iK, iD, this);
            if (objK == objE) {
                return objE;
            }
            longVodPlayerViewAdHelper = longVodPlayerViewAdHelper2;
            obj = objK;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            longVodPlayerViewAdHelper = (LongVodPlayerViewAdHelper) this.L$0;
            ResultKt.b(obj);
        }
        longVodPlayerViewAdHelper.f54531c = (VideoDetailPlayBean) obj;
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper3 = this.this$0;
        int iP1 = longVodPlayerViewAdHelper3.p1();
        VideoDetailPlayBean videoDetailPlayBean = this.this$0.f54531c;
        long jLongValue = 0;
        longVodPlayerViewAdHelper3.f54543o = longVodPlayerViewAdHelper3.y1(iP1, (videoDetailPlayBean == null || (lastAdStartTimeStamp = videoDetailPlayBean.getLastAdStartTimeStamp()) == null) ? 0L : lastAdStartTimeStamp.longValue());
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper4 = this.this$0;
        int iZ0 = longVodPlayerViewAdHelper4.Z0();
        VideoDetailPlayBean videoDetailPlayBean2 = this.this$0.f54531c;
        if (videoDetailPlayBean2 != null && (lastAdEndTimeStamp = videoDetailPlayBean2.getLastAdEndTimeStamp()) != null) {
            jLongValue = lastAdEndTimeStamp.longValue();
        }
        longVodPlayerViewAdHelper4.f54544p = longVodPlayerViewAdHelper4.y1(iZ0, jLongValue);
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, this.this$0.X0() + " --> setLongVdPlayerBean() --> isShowStartAd = " + this.this$0.f54543o + " --> isShowEndAd = " + this.this$0.f54544p + " --> videoDetailPlayBean = " + this.this$0.f54531c, false, 2, null);
        this.this$0.e2();
        this.this$0.w1(this.$bean);
        return Unit.f68710a;
    }
}
