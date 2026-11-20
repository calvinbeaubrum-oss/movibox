package com.transsion.audio.viewmodel;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsnet.downloader.bean.DownloadListBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1", f = "HistoryListManager.kt", l = {146}, m = "invokeSuspend")
public final class HistoryListManager$getResourcePosition$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    final /* synthetic */ int $resourceNum;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX INFO: renamed from: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$1", f = "HistoryListManager.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS, 140, 142}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super DownloadListBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $postId;
        final /* synthetic */ int $resourceNum;
        final /* synthetic */ String $subjectId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ HistoryListManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HistoryListManager historyListManager, String str, String str2, int i11, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = historyListManager;
            this.$subjectId = str;
            this.$postId = str2;
            this.$resourceNum = i11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$subjectId, this.$postId, this.$resourceNum, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super DownloadListBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            b bVar;
            DownloadListBean downloadListBean;
            List<DownloadItem> items;
            Object objE = a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    bVar = (b) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2 && i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            bVar = (b) this.L$0;
            gr.a aVarN = this.this$0.n();
            String strA = cp.a.f62775a.a();
            String str = this.$subjectId;
            String str2 = this.$postId;
            int i12 = this.$resourceNum;
            this.L$0 = bVar;
            this.label = 1;
            obj = aVarN.a(strA, str, str2, i12, this);
            if (obj == objE) {
                return objE;
            }
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.b(baseDto.getCode(), "0") && ((downloadListBean = (DownloadListBean) baseDto.getData()) == null || (items = downloadListBean.getItems()) == null || !items.isEmpty())) {
                Object data = baseDto.getData();
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit(data, this) == objE) {
                    return objE;
                }
            } else {
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit(null, this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$2", f = "HistoryListManager.kt", l = {145}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<b<? super DownloadListBean>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super DownloadListBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                b bVar = (b) this.L$0;
                this.label = 1;
                if (bVar.emit(null, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass3<T> implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HistoryListManager f50908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f50909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f50910c;

        public AnonymousClass3(HistoryListManager historyListManager, String str, String str2) {
            this.f50908a = historyListManager;
            this.f50909b = str;
            this.f50910c = str2;
        }

        /* JADX WARN: Code duplicated, block: B:37:0x009a  */
        /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(DownloadListBean downloadListBean, Continuation<? super Unit> continuation) throws Throwable {
            HistoryListManager$getResourcePosition$1$3$emit$1 historyListManager$getResourcePosition$1$3$emit$1;
            AnonymousClass3<T> anonymousClass3;
            AudioBean audioBean;
            rr.a aVarJ;
            List<DownloadItem> items;
            if (continuation instanceof HistoryListManager$getResourcePosition$1$3$emit$1) {
                historyListManager$getResourcePosition$1$3$emit$1 = (HistoryListManager$getResourcePosition$1$3$emit$1) continuation;
                int i11 = historyListManager$getResourcePosition$1$3$emit$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    historyListManager$getResourcePosition$1$3$emit$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    historyListManager$getResourcePosition$1$3$emit$1 = new HistoryListManager$getResourcePosition$1$3$emit$1(this, continuation);
                }
            } else {
                historyListManager$getResourcePosition$1$3$emit$1 = new HistoryListManager$getResourcePosition$1$3$emit$1(this, continuation);
            }
            Object objG = historyListManager$getResourcePosition$1$3$emit$1.result;
            Object objE = a.e();
            int i12 = historyListManager$getResourcePosition$1$3$emit$1.label;
            if (i12 != 0) {
                if (i12 == 1) {
                    downloadListBean = (DownloadListBean) historyListManager$getResourcePosition$1$3$emit$1.L$1;
                    anonymousClass3 = (AnonymousClass3) historyListManager$getResourcePosition$1$3$emit$1.L$0;
                    ResultKt.b(objG);
                } else {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objG);
                }
                return Unit.f68710a;
            }
            ResultKt.b(objG);
            HistoryListManager.a aVar = HistoryListManager.f50901e;
            if (!aVar.a()) {
                this.f50908a.o().n(downloadListBean);
                aVar.c(true);
            } else if (downloadListBean != null) {
                this.f50908a.o().n(downloadListBean);
            }
            rr.a aVarJ2 = this.f50908a.j();
            if (aVarJ2 != null) {
                String str = this.f50909b;
                String str2 = this.f50910c;
                historyListManager$getResourcePosition$1$3$emit$1.L$0 = this;
                historyListManager$getResourcePosition$1$3$emit$1.L$1 = downloadListBean;
                historyListManager$getResourcePosition$1$3$emit$1.label = 1;
                objG = aVarJ2.g(str, str2, historyListManager$getResourcePosition$1$3$emit$1);
                if (objG == objE) {
                    return objE;
                }
                anonymousClass3 = this;
            } else {
                anonymousClass3 = this;
                audioBean = null;
            }
            if (downloadListBean != null && (items = downloadListBean.getItems()) != null && (true ^ items.isEmpty())) {
                if (audioBean != null) {
                    audioBean.setSe(items.get(0).getSe());
                }
                if (audioBean != null) {
                    audioBean.setEp(items.get(0).getEp());
                }
            }
            if (audioBean != null || (aVarJ = anonymousClass3.f50908a.j()) == null) {
                return Unit.f68710a;
            }
            historyListManager$getResourcePosition$1$3$emit$1.L$0 = null;
            historyListManager$getResourcePosition$1$3$emit$1.L$1 = null;
            historyListManager$getResourcePosition$1$3$emit$1.label = 2;
            if (aVarJ.f(audioBean, historyListManager$getResourcePosition$1$3$emit$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
            audioBean = (AudioBean) objG;
            if (downloadListBean != null) {
                if (audioBean != null) {
                    audioBean.setSe(items.get(0).getSe());
                }
                if (audioBean != null) {
                    audioBean.setEp(items.get(0).getEp());
                }
            }
            if (audioBean != null) {
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryListManager$getResourcePosition$1(HistoryListManager historyListManager, String str, String str2, int i11, Continuation<? super HistoryListManager$getResourcePosition$1> continuation) {
        super(2, continuation);
        this.this$0 = historyListManager;
        this.$subjectId = str;
        this.$postId = str2;
        this.$resourceNum = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$getResourcePosition$1(this.this$0, this.$subjectId, this.$postId, this.$resourceNum, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HistoryListManager$getResourcePosition$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = c.e(c.o(new AnonymousClass1(this.this$0, this.$subjectId, this.$postId, this.$resourceNum, null)), new AnonymousClass2(null));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$subjectId, this.$postId);
            this.label = 1;
            if (aVarE.a(anonymousClass3, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
