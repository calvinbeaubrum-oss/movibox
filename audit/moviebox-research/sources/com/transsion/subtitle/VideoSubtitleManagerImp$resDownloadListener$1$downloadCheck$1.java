package com.transsion.subtitle;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
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
@DebugMetadata(c = "com.transsion.subtitle.VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1", f = "VideoSubtitleManagerImp.kt", l = {90}, m = "invokeSuspend")
public final class VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $bean;
    final /* synthetic */ boolean $isSuccess;
    int label;
    final /* synthetic */ VideoSubtitleManagerImp this$0;
    final /* synthetic */ VideoSubtitleManagerImp$resDownloadListener$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(VideoSubtitleManagerImp videoSubtitleManagerImp, DownloadBean downloadBean, boolean z11, VideoSubtitleManagerImp$resDownloadListener$1 videoSubtitleManagerImp$resDownloadListener$1, Continuation<? super VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1> continuation) {
        super(2, continuation);
        this.this$0 = videoSubtitleManagerImp;
        this.$bean = downloadBean;
        this.$isSuccess = z11;
        this.this$1 = videoSubtitleManagerImp$resDownloadListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(this.this$0, this.$bean, this.$isSuccess, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            VideoSubtitleManagerImp videoSubtitleManagerImp = this.this$0;
            String subtitleResId = this.$bean.getSubtitleResId();
            this.label = 1;
            obj = videoSubtitleManagerImp.a(subtitleResId, this);
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
        String str = this.$isSuccess ? "下载完成" : "资源继续下载";
        if (list.isEmpty()) {
            uo.b.f78622a.r(com.transsion.baselib.report.a.f51248a.a(), this.this$0.f58115d + " " + str + "，数据库为空，执行检测 titleName:" + this.$bean.getTitleName() + ", ep:" + this.$bean.getEp() + " se:" + this.$bean.getSe(), true);
            VideoSubtitleManagerImp.p(this.this$0, this.$bean, null, 2, null);
        } else if (this.this$1.f(list)) {
            uo.b.f78622a.r(com.transsion.baselib.report.a.f51248a.a(), this.this$0.f58115d + " " + str + "，有失败，执行检测 titleName:" + this.$bean.getTitleName() + ", ep:" + this.$bean.getEp() + " se:" + this.$bean.getSe(), true);
            VideoSubtitleManagerImp.p(this.this$0, this.$bean, null, 2, null);
        } else {
            uo.b.f78622a.r(com.transsion.baselib.report.a.f51248a.a(), this.this$0.f58115d + " " + str + "，有字幕无需检测 titleName:" + this.$bean.getTitleName() + ", ep:" + this.$bean.getEp() + " se:" + this.$bean.getSe(), true);
        }
        return Unit.f68710a;
    }
}
