package com.transsion.subtitle;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsnet.downloader.manager.DownloadEsHelper;
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
@DebugMetadata(c = "com.transsion.subtitle.VideoSubtitleControl$saveSelectedFlag$1", f = "VideoSubtitleControl.kt", l = {843, 848}, m = "invokeSuspend")
public final class VideoSubtitleControl$saveSelectedFlag$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ vx.a $bean;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoSubtitleControl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoSubtitleControl$saveSelectedFlag$1(VideoSubtitleControl videoSubtitleControl, vx.a aVar, Continuation<? super VideoSubtitleControl$saveSelectedFlag$1> continuation) {
        super(2, continuation);
        this.this$0 = videoSubtitleControl;
        this.$bean = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideoSubtitleControl$saveSelectedFlag$1 videoSubtitleControl$saveSelectedFlag$1 = new VideoSubtitleControl$saveSelectedFlag$1(this.this$0, this.$bean, continuation);
        videoSubtitleControl$saveSelectedFlag$1.L$0 = obj;
        return videoSubtitleControl$saveSelectedFlag$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((VideoSubtitleControl$saveSelectedFlag$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String resourceId;
        SubtitleDownloadTable subtitleDownloadTableB;
        String id2;
        String subjectId;
        SubtitleDownloadTable subtitleDownloadTableB2;
        String id3;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            k0 k0Var = (k0) this.L$0;
            DownloadBean downloadBean = this.this$0.f58094p;
            String str = "";
            if (downloadBean == null || !downloadBean.isStreamVideoDetail()) {
                a.f58119a.a(k0Var.getClass().getSimpleName() + " --> saveSelectedFlag() --> saveSelectedFlag -- download");
                DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                DownloadBean downloadBean2 = this.this$0.f58094p;
                if (downloadBean2 == null || (resourceId = downloadBean2.getResourceId()) == null) {
                    resourceId = "";
                }
                vx.a aVar = this.$bean;
                if (aVar != null && (subtitleDownloadTableB = aVar.b()) != null && (id2 = subtitleDownloadTableB.getId()) != null) {
                    str = id2;
                }
                this.label = 2;
                if (downloadEsHelperA.V(resourceId, str, this) == objE) {
                    return objE;
                }
            } else {
                a.f58119a.a(k0Var.getClass().getSimpleName() + " --> saveSelectedFlag() --> saveSelectedFlag -- dash");
                VideoDetailPlayDao videoDetailPlayDaoF = this.this$0.F();
                DownloadBean downloadBean3 = this.this$0.f58094p;
                if (downloadBean3 == null || (subjectId = downloadBean3.getSubjectId()) == null) {
                    subjectId = "";
                }
                vx.a aVar2 = this.$bean;
                if (aVar2 != null && (subtitleDownloadTableB2 = aVar2.b()) != null && (id3 = subtitleDownloadTableB2.getId()) != null) {
                    str = id3;
                }
                this.label = 1;
                if (videoDetailPlayDaoF.c(subjectId, str, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 1 && i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
