package com.transsion.player.longvideo.helper;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.subtitle.VideoSubtitleManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1", f = "LongVodSubtitleHelper.kt", l = {180, 182, PsExtractor.PRIVATE_STREAM_1}, m = "invokeSuspend")
public final class LongVodSubtitleHelper$loadFromDB$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $bean;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LongVodSubtitleHelper this$0;

    /* JADX INFO: renamed from: com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1$2", f = "LongVodSubtitleHelper.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadBean $bean;
        final /* synthetic */ List<vx.a> $list;
        int label;
        final /* synthetic */ LongVodSubtitleHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<vx.a> list, LongVodSubtitleHelper longVodSubtitleHelper, DownloadBean downloadBean, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = longVodSubtitleHelper;
            this.$bean = downloadBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$list, this.this$0, this.$bean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            List<vx.a> list = this.$list;
            if (list != null && !list.isEmpty()) {
                this.this$0.f54374g.clear();
                this.this$0.f54374g.addAll(this.$list);
                this.this$0.f54375h.e0(this.$list);
            }
            if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                this.this$0.n(this.$bean);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodSubtitleHelper$loadFromDB$1(DownloadBean downloadBean, LongVodSubtitleHelper longVodSubtitleHelper, Continuation<? super LongVodSubtitleHelper$loadFromDB$1> continuation) {
        super(2, continuation);
        this.$bean = downloadBean;
        this.this$0 = longVodSubtitleHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodSubtitleHelper$loadFromDB$1(this.$bean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LongVodSubtitleHelper$loadFromDB$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0072  */
    /* JADX WARN: Code duplicated, block: B:28:0x009e  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f0 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list;
        List list2;
        DownloadBean downloadBean;
        Integer numD;
        a2 a2VarC;
        AnonymousClass2 anonymousClass2;
        VideoDetailPlayBean videoDetailPlayBean;
        String subtitleSelectId;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else if (i11 == 2) {
                downloadBean = (DownloadBean) this.L$1;
                list2 = (List) this.L$0;
                ResultKt.b(obj);
                videoDetailPlayBean = (VideoDetailPlayBean) obj;
                if (videoDetailPlayBean != null) {
                    subtitleSelectId = videoDetailPlayBean.getSubtitleSelectId();
                } else {
                    subtitleSelectId = null;
                }
                downloadBean.setSubtitleSelectId(subtitleSelectId);
                list = list2;
                this.this$0.f54371d.f(this.$bean.getSubtitleSelectId());
                uo.b.a aVar = uo.b.f78622a;
                String subtitleSelectId2 = this.$bean.getSubtitleSelectId();
                String subjectId = this.$bean.getSubjectId();
                String subtitleResId = this.$bean.getSubtitleResId();
                if (list != null) {
                    numD = Boxing.d(list.size());
                } else {
                    numD = null;
                }
                uo.b.a.f(aVar, LongVodPlayerView.TAG, "loadFromDB subtitleSelectId:" + subtitleSelectId2 + ", subjectId:" + subjectId + ", id:" + subtitleResId + ", size:" + numD, false, 4, null);
                a2VarC = w0.c();
                anonymousClass2 = new AnonymousClass2(list, this.this$0, this.$bean, null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
                if (kotlinx.coroutines.h.g(a2VarC, anonymousClass2, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        VideoSubtitleManager videoSubtitleManagerA = VideoSubtitleManager.f58109a.a();
        String subtitleResId2 = this.$bean.getSubtitleResId();
        this.label = 1;
        obj = videoSubtitleManagerA.a(subtitleResId2, this);
        if (obj == objE) {
            return objE;
        }
        list = (List) obj;
        String subjectId2 = this.$bean.getSubjectId();
        if (subjectId2 != null) {
            DownloadBean downloadBean2 = this.$bean;
            VideoDetailPlayDao videoDetailPlayDaoT = this.this$0.t();
            this.L$0 = list;
            this.L$1 = downloadBean2;
            this.label = 2;
            Object objD = videoDetailPlayDaoT.d(subjectId2, this);
            if (objD == objE) {
                return objE;
            }
            list2 = list;
            obj = objD;
            downloadBean = downloadBean2;
            videoDetailPlayBean = (VideoDetailPlayBean) obj;
            if (videoDetailPlayBean != null) {
                subtitleSelectId = videoDetailPlayBean.getSubtitleSelectId();
            } else {
                subtitleSelectId = null;
            }
            downloadBean.setSubtitleSelectId(subtitleSelectId);
            list = list2;
        }
        this.this$0.f54371d.f(this.$bean.getSubtitleSelectId());
        uo.b.a aVar2 = uo.b.f78622a;
        String subtitleSelectId3 = this.$bean.getSubtitleSelectId();
        String subjectId3 = this.$bean.getSubjectId();
        String subtitleResId3 = this.$bean.getSubtitleResId();
        if (list != null) {
            numD = Boxing.d(list.size());
        } else {
            numD = null;
        }
        uo.b.a.f(aVar2, LongVodPlayerView.TAG, "loadFromDB subtitleSelectId:" + subtitleSelectId3 + ", subjectId:" + subjectId3 + ", id:" + subtitleResId3 + ", size:" + numD, false, 4, null);
        a2VarC = w0.c();
        anonymousClass2 = new AnonymousClass2(list, this.this$0, this.$bean, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (kotlinx.coroutines.h.g(a2VarC, anonymousClass2, this) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }
}
