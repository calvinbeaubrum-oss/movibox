package com.transsion.videodetail;

import androidx.lifecycle.c0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.player.p006enum.PlayMimeType;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.videodetail.bean.VideoDetailStream;
import com.transsion.videodetail.bean.VideoDetailStreamList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$getPlayInfo$2", f = "VideoDetailViewModel.kt", l = {270}, m = "invokeSuspend")
@SourceDebugExtension
public final class VideoDetailViewModel$getPlayInfo$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $ep;
    final /* synthetic */ String $key;
    final /* synthetic */ int $se;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ VideoDetailMediaSource $videoDetailMediaSource;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailViewModel$getPlayInfo$2(VideoDetailViewModel videoDetailViewModel, String str, int i11, int i12, VideoDetailMediaSource videoDetailMediaSource, String str2, Continuation<? super VideoDetailViewModel$getPlayInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = videoDetailViewModel;
        this.$subjectId = str;
        this.$se = i11;
        this.$ep = i12;
        this.$videoDetailMediaSource = videoDetailMediaSource;
        this.$key = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideoDetailViewModel$getPlayInfo$2 videoDetailViewModel$getPlayInfo$2 = new VideoDetailViewModel$getPlayInfo$2(this.this$0, this.$subjectId, this.$se, this.$ep, this.$videoDetailMediaSource, this.$key, continuation);
        videoDetailViewModel$getPlayInfo$2.L$0 = obj;
        return videoDetailViewModel$getPlayInfo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((VideoDetailViewModel$getPlayInfo$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        String path;
        Object next;
        Object objA;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                VideoDetailViewModel videoDetailViewModel = this.this$0;
                String str = this.$subjectId;
                int i12 = this.$se;
                int i13 = this.$ep;
                Result.Companion companion = Result.Companion;
                b bVarX = videoDetailViewModel.x();
                this.label = 1;
                objA = b.a.a(bVarX, str, i12, i13, null, this, 8, null);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objA = obj;
            }
            objM163constructorimpl = Result.m163constructorimpl((BaseDto) objA);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        VideoDetailViewModel videoDetailViewModel2 = this.this$0;
        int i14 = this.$se;
        int i15 = this.$ep;
        VideoDetailMediaSource videoDetailMediaSource = this.$videoDetailMediaSource;
        String str2 = this.$key;
        if (Result.m170isSuccessimpl(objM163constructorimpl)) {
            BaseDto baseDto = (BaseDto) objM163constructorimpl;
            c0 c0Var = videoDetailViewModel2.f59860b;
            VideoDetailStreamList videoDetailStreamList = (VideoDetailStreamList) baseDto.getData();
            if (videoDetailStreamList != null) {
                videoDetailStreamList.setSe(i14);
                videoDetailStreamList.setEp(i15);
                DownloadBean downloadBean = videoDetailMediaSource.getDownloadBean();
                if (downloadBean != null && (path = downloadBean.getPath()) != null) {
                    Iterator<T> it = videoDetailStreamList.getStreams().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        VideoDetailStream videoDetailStream = (VideoDetailStream) next;
                        if (Intrinsics.b(videoDetailStream.getFormat(), PlayMimeType.DEFAULT.name()) && Intrinsics.b(videoDetailStream.getResolutions(), String.valueOf(downloadBean.getResolution()))) {
                            break;
                        }
                    }
                    VideoDetailStream videoDetailStream2 = (VideoDetailStream) next;
                    if (videoDetailStream2 != null) {
                        videoDetailStream2.setUrl(path);
                        uo.b.a.f(uo.b.f78622a, "CommonInfo", "getVideoPlayInfo 有下载地址，直接用下载地址", false, 4, null);
                    }
                }
                VideoDetailStreamList videoDetailStreamList2 = (VideoDetailStreamList) baseDto.getData();
                if (videoDetailStreamList2 != null) {
                    videoDetailViewModel2.f59864g.put(str2, videoDetailStreamList2);
                }
            } else {
                videoDetailStreamList = null;
            }
            c0Var.q(videoDetailStreamList);
        }
        VideoDetailViewModel videoDetailViewModel3 = this.this$0;
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            videoDetailViewModel3.f59860b.q(null);
        }
        return Unit.f68710a;
    }
}
