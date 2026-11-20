package com.transsion.videofloat.manager;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.subtitle.VideoSubtitleManager;
import com.transsion.videofloat.bean.FloatPlayType;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.videofloat.manager.VideoFloatSubtitleControl$initSubtitle$2", f = "VideoFloatSubtitleControl.kt", l = {75, 78, 82, 84}, m = "invokeSuspend")
@SourceDebugExtension
public final class VideoFloatSubtitleControl$initSubtitle$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ VideoFloatSubtitleControl this$0;

    /* JADX INFO: renamed from: com.transsion.videofloat.manager.VideoFloatSubtitleControl$initSubtitle$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.videofloat.manager.VideoFloatSubtitleControl$initSubtitle$2$1", f = "VideoFloatSubtitleControl.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<vx.a> $list;
        final /* synthetic */ String $subtitleSavedSelectId;
        int label;
        final /* synthetic */ VideoFloatSubtitleControl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<vx.a> list, VideoFloatSubtitleControl videoFloatSubtitleControl, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = videoFloatSubtitleControl;
            this.$subtitleSavedSelectId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$list, this.this$0, this.$subtitleSavedSelectId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
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
                this.this$0.k(this.$subtitleSavedSelectId, this.$list);
                this.this$0.q(this.$list);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoFloatSubtitleControl$initSubtitle$2(VideoFloatSubtitleControl videoFloatSubtitleControl, Continuation<? super VideoFloatSubtitleControl$initSubtitle$2> continuation) {
        super(2, continuation);
        this.this$0 = videoFloatSubtitleControl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoFloatSubtitleControl$initSubtitle$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((VideoFloatSubtitleControl$initSubtitle$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0061  */
    /* JADX WARN: Code duplicated, block: B:23:0x0067  */
    /* JADX WARN: Code duplicated, block: B:31:0x0088  */
    /* JADX WARN: Code duplicated, block: B:32:0x008d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ff A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        VideoDetailPlayBean videoDetailPlayBean;
        String subtitleSelectId;
        String str;
        DownloadBean downloadBean;
        String subtitleSelectId2;
        List list;
        Integer numD;
        a2 a2VarC;
        AnonymousClass1 anonymousClass1;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (this.this$0.f60037b.h() == FloatPlayType.STREAM) {
                VideoDetailPlayDao videoDetailPlayDaoI = this.this$0.i();
                String strQ = this.this$0.f60037b.q();
                this.label = 1;
                obj = videoDetailPlayDaoI.d(strQ, this);
                if (obj == objE) {
                    return objE;
                }
                videoDetailPlayBean = (VideoDetailPlayBean) obj;
                if (videoDetailPlayBean != null) {
                    subtitleSelectId = videoDetailPlayBean.getSubtitleSelectId();
                    str = subtitleSelectId;
                }
                VideoSubtitleManager videoSubtitleManagerA = VideoSubtitleManager.f58109a.a();
                String strS = this.this$0.f60037b.s();
                this.L$0 = str;
                this.label = 3;
                obj = videoSubtitleManagerA.a(strS, this);
                if (obj == objE) {
                    return objE;
                }
                list = (List) obj;
                uo.b.a aVar = uo.b.f78622a;
                String str2 = this.this$0.f60038c;
                String strS2 = this.this$0.f60037b.s();
                if (list != null) {
                    numD = Boxing.d(list.size());
                } else {
                    numD = null;
                }
                aVar.c(str2, "float subtitle----loadFromDB id:" + strS2 + ", size:" + numD, true);
                a2VarC = w0.c();
                anonymousClass1 = new AnonymousClass1(list, this.this$0, str, null);
                this.L$0 = null;
                this.label = 4;
                if (kotlinx.coroutines.h.g(a2VarC, anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                String strO = this.this$0.f60037b.o();
                if (strO != null) {
                    tr.c cVarG = this.this$0.g();
                    this.label = 2;
                    obj = cVarG.b(strO, this);
                    if (obj == objE) {
                        return objE;
                    }
                    downloadBean = (DownloadBean) obj;
                    if (downloadBean != null) {
                        subtitleSelectId2 = downloadBean.getSubtitleSelectId();
                    } else {
                        subtitleSelectId2 = null;
                    }
                    if (subtitleSelectId2 != null) {
                        subtitleSelectId = "";
                        str = subtitleSelectId;
                    }
                }
                VideoSubtitleManager videoSubtitleManagerA2 = VideoSubtitleManager.f58109a.a();
                String strS3 = this.this$0.f60037b.s();
                this.L$0 = str;
                this.label = 3;
                obj = videoSubtitleManagerA2.a(strS3, this);
                if (obj == objE) {
                    return objE;
                }
                list = (List) obj;
                uo.b.a aVar2 = uo.b.f78622a;
                String str3 = this.this$0.f60038c;
                String strS4 = this.this$0.f60037b.s();
                if (list != null) {
                    numD = Boxing.d(list.size());
                } else {
                    numD = null;
                }
                aVar2.c(str3, "float subtitle----loadFromDB id:" + strS4 + ", size:" + numD, true);
                a2VarC = w0.c();
                anonymousClass1 = new AnonymousClass1(list, this.this$0, str, null);
                this.L$0 = null;
                this.label = 4;
                if (kotlinx.coroutines.h.g(a2VarC, anonymousClass1, this) == objE) {
                    return objE;
                }
            }
            str = null;
            VideoSubtitleManager videoSubtitleManagerA3 = VideoSubtitleManager.f58109a.a();
            String strS5 = this.this$0.f60037b.s();
            this.L$0 = str;
            this.label = 3;
            obj = videoSubtitleManagerA3.a(strS5, this);
            if (obj == objE) {
                return objE;
            }
            list = (List) obj;
            uo.b.a aVar3 = uo.b.f78622a;
            String str4 = this.this$0.f60038c;
            String strS6 = this.this$0.f60037b.s();
            if (list != null) {
                numD = Boxing.d(list.size());
            } else {
                numD = null;
            }
            aVar3.c(str4, "float subtitle----loadFromDB id:" + strS6 + ", size:" + numD, true);
            a2VarC = w0.c();
            anonymousClass1 = new AnonymousClass1(list, this.this$0, str, null);
            this.L$0 = null;
            this.label = 4;
            if (kotlinx.coroutines.h.g(a2VarC, anonymousClass1, this) == objE) {
                return objE;
            }
        } else if (i11 == 1) {
            ResultKt.b(obj);
            videoDetailPlayBean = (VideoDetailPlayBean) obj;
            if (videoDetailPlayBean != null) {
                subtitleSelectId = videoDetailPlayBean.getSubtitleSelectId();
                str = subtitleSelectId;
            } else {
                str = null;
            }
            VideoSubtitleManager videoSubtitleManagerA4 = VideoSubtitleManager.f58109a.a();
            String strS7 = this.this$0.f60037b.s();
            this.L$0 = str;
            this.label = 3;
            obj = videoSubtitleManagerA4.a(strS7, this);
            if (obj == objE) {
                return objE;
            }
            list = (List) obj;
            uo.b.a aVar4 = uo.b.f78622a;
            String str5 = this.this$0.f60038c;
            String strS8 = this.this$0.f60037b.s();
            if (list != null) {
                numD = Boxing.d(list.size());
            } else {
                numD = null;
            }
            aVar4.c(str5, "float subtitle----loadFromDB id:" + strS8 + ", size:" + numD, true);
            a2VarC = w0.c();
            anonymousClass1 = new AnonymousClass1(list, this.this$0, str, null);
            this.L$0 = null;
            this.label = 4;
            if (kotlinx.coroutines.h.g(a2VarC, anonymousClass1, this) == objE) {
                return objE;
            }
        } else if (i11 == 2) {
            ResultKt.b(obj);
            downloadBean = (DownloadBean) obj;
            if (downloadBean != null) {
                subtitleSelectId2 = downloadBean.getSubtitleSelectId();
            } else {
                subtitleSelectId2 = null;
            }
            if (subtitleSelectId2 != null) {
                subtitleSelectId = "";
                str = subtitleSelectId;
            } else {
                str = null;
            }
            VideoSubtitleManager videoSubtitleManagerA5 = VideoSubtitleManager.f58109a.a();
            String strS9 = this.this$0.f60037b.s();
            this.L$0 = str;
            this.label = 3;
            obj = videoSubtitleManagerA5.a(strS9, this);
            if (obj == objE) {
                return objE;
            }
            list = (List) obj;
            uo.b.a aVar5 = uo.b.f78622a;
            String str6 = this.this$0.f60038c;
            String strS10 = this.this$0.f60037b.s();
            if (list != null) {
                numD = Boxing.d(list.size());
            } else {
                numD = null;
            }
            aVar5.c(str6, "float subtitle----loadFromDB id:" + strS10 + ", size:" + numD, true);
            a2VarC = w0.c();
            anonymousClass1 = new AnonymousClass1(list, this.this$0, str, null);
            this.L$0 = null;
            this.label = 4;
            if (kotlinx.coroutines.h.g(a2VarC, anonymousClass1, this) == objE) {
                return objE;
            }
        } else if (i11 == 3) {
            str = (String) this.L$0;
            ResultKt.b(obj);
            list = (List) obj;
            uo.b.a aVar6 = uo.b.f78622a;
            String str7 = this.this$0.f60038c;
            String strS11 = this.this$0.f60037b.s();
            if (list != null) {
                numD = Boxing.d(list.size());
            } else {
                numD = null;
            }
            aVar6.c(str7, "float subtitle----loadFromDB id:" + strS11 + ", size:" + numD, true);
            a2VarC = w0.c();
            anonymousClass1 = new AnonymousClass1(list, this.this$0, str, null);
            this.L$0 = null;
            this.label = 4;
            if (kotlinx.coroutines.h.g(a2VarC, anonymousClass1, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
