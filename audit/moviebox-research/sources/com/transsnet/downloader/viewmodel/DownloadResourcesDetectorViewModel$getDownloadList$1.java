package com.transsnet.downloader.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsnet.downloader.bean.DownloadListBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel$getDownloadList$1", f = "DownloadResourcesDetectorViewModel.kt", l = {318}, m = "invokeSuspend")
public final class DownloadResourcesDetectorViewModel$getDownloadList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $endPosition;
    final /* synthetic */ int $epFrom;
    final /* synthetic */ int $epTo;
    final /* synthetic */ String $nextPage;
    final /* synthetic */ int $pagerMode;
    final /* synthetic */ int $perPage;
    final /* synthetic */ int $resolution;
    final /* synthetic */ int $se;
    final /* synthetic */ int $startPosition;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ String $subjectTitle;
    int label;
    final /* synthetic */ DownloadResourcesDetectorViewModel this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel$getDownloadList$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel$getDownloadList$1$1", f = "DownloadResourcesDetectorViewModel.kt", l = {304, 312, 314}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super DownloadListBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $endPosition;
        final /* synthetic */ int $epFrom;
        final /* synthetic */ int $epTo;
        final /* synthetic */ String $nextPage;
        final /* synthetic */ int $pagerMode;
        final /* synthetic */ int $perPage;
        final /* synthetic */ int $resolution;
        final /* synthetic */ int $se;
        final /* synthetic */ int $startPosition;
        final /* synthetic */ String $subjectId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DownloadResourcesDetectorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel, String str, String str2, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = downloadResourcesDetectorViewModel;
            this.$subjectId = str;
            this.$nextPage = str2;
            this.$perPage = i11;
            this.$startPosition = i12;
            this.$endPosition = i13;
            this.$pagerMode = i14;
            this.$resolution = i15;
            this.$se = i16;
            this.$epFrom = i17;
            this.$epTo = i18;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$subjectId, this.$nextPage, this.$perPage, this.$startPosition, this.$endPosition, this.$pagerMode, this.$resolution, this.$se, this.$epFrom, this.$epTo, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.b<? super DownloadListBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC;
            Object obj2;
            kotlinx.coroutines.flow.b bVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    kotlinx.coroutines.flow.b bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                    ResultKt.b(obj);
                    bVar = bVar2;
                    obj2 = objE;
                    objC = obj;
                } else {
                    if (i11 != 2 && i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b bVar3 = (kotlinx.coroutines.flow.b) this.L$0;
            i00.a aVarB = this.this$0.B();
            String strA = cp.a.f62775a.a();
            String str = this.$subjectId;
            String str2 = this.$nextPage;
            int i12 = this.$perPage;
            int i13 = this.$startPosition;
            int i14 = this.$endPosition;
            int i15 = this.$pagerMode;
            Integer numD = Boxing.d(this.$resolution);
            int i16 = this.$se;
            int i17 = this.$epFrom;
            int i18 = this.$epTo;
            this.L$0 = bVar3;
            this.label = 1;
            objC = i00.a.C0703a.c(aVarB, strA, str, str2, i12, 0, i13, i14, i15, numD, i16, i17, i18, this, 16, null);
            obj2 = objE;
            if (objC == obj2) {
                return obj2;
            }
            bVar = bVar3;
            BaseDto baseDto = (BaseDto) objC;
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                Object data = baseDto.getData();
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit(data, this) == obj2) {
                    return obj2;
                }
            } else {
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit(null, this) == obj2) {
                    return obj2;
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel$getDownloadList$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel$getDownloadList$1$2", f = "DownloadResourcesDetectorViewModel.kt", l = {317}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super DownloadListBean>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.b<? super DownloadListBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f61229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DownloadResourcesDetectorViewModel f61230b;

        public a(String str, DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel) {
            this.f61229a = str;
            this.f61230b = downloadResourcesDetectorViewModel;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(DownloadListBean downloadListBean, Continuation<? super Unit> continuation) {
            List<DownloadItem> items;
            Integer numD = null;
            String title = downloadListBean != null ? downloadListBean.getTitle() : null;
            if ((title == null || title.length() == 0) && downloadListBean != null) {
                downloadListBean.setTitle(this.f61229a);
            }
            uo.b.a aVar = uo.b.f78622a;
            if (downloadListBean != null && (items = downloadListBean.getItems()) != null) {
                numD = Boxing.d(items.size());
            }
            uo.b.a.f(aVar, "DownloadReDetector", "getBottomList, on get data , size= " + numD, false, 4, null);
            this.f61230b.r().n(downloadListBean);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadResourcesDetectorViewModel$getDownloadList$1(int i11, String str, int i12, int i13, int i14, DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel, String str2, int i15, int i16, int i17, int i18, String str3, Continuation<? super DownloadResourcesDetectorViewModel$getDownloadList$1> continuation) {
        super(2, continuation);
        this.$resolution = i11;
        this.$subjectId = str;
        this.$startPosition = i12;
        this.$endPosition = i13;
        this.$pagerMode = i14;
        this.this$0 = downloadResourcesDetectorViewModel;
        this.$nextPage = str2;
        this.$perPage = i15;
        this.$se = i16;
        this.$epFrom = i17;
        this.$epTo = i18;
        this.$subjectTitle = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadResourcesDetectorViewModel$getDownloadList$1(this.$resolution, this.$subjectId, this.$startPosition, this.$endPosition, this.$pagerMode, this.this$0, this.$nextPage, this.$perPage, this.$se, this.$epFrom, this.$epTo, this.$subjectTitle, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadResourcesDetectorViewModel$getDownloadList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            uo.b.a.s(uo.b.f78622a, "DownloadReDetector", "getBottomList, resolution：" + this.$resolution + ",subjectId:" + this.$subjectId + ", start:" + this.$startPosition + ", end:" + this.$endPosition + ", pagerMode:" + this.$pagerMode + " ", false, 4, null);
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.o(new AnonymousClass1(this.this$0, this.$subjectId, this.$nextPage, this.$perPage, this.$startPosition, this.$endPosition, this.$pagerMode, this.$resolution, this.$se, this.$epFrom, this.$epTo, null)), new AnonymousClass2(null));
            a aVar = new a(this.$subjectTitle, this.this$0);
            this.label = 1;
            if (aVarE.a(aVar, this) == objE) {
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
