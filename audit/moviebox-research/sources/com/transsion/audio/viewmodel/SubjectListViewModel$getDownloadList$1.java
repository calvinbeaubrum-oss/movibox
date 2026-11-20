package com.transsion.audio.viewmodel;

import androidx.core.view.MotionEventCompat;
import com.tn.lib.net.bean.BaseDto;
import com.transsnet.downloader.bean.DownloadListBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1", f = "SubjectListViewModel.kt", l = {52}, m = "invokeSuspend")
public final class SubjectListViewModel$getDownloadList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $endPosition;
    final /* synthetic */ boolean $loadMore;
    final /* synthetic */ String $nextPage;
    final /* synthetic */ int $pagerMode;
    final /* synthetic */ int $perPage;
    final /* synthetic */ int $startPosition;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ SubjectListViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1$1", f = "SubjectListViewModel.kt", l = {35, MotionEventCompat.AXIS_GENERIC_14, 48}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super DownloadListBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $endPosition;
        final /* synthetic */ boolean $loadMore;
        final /* synthetic */ String $nextPage;
        final /* synthetic */ int $pagerMode;
        final /* synthetic */ int $perPage;
        final /* synthetic */ int $startPosition;
        final /* synthetic */ String $subjectId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SubjectListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SubjectListViewModel subjectListViewModel, String str, String str2, int i11, int i12, int i13, int i14, boolean z11, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = subjectListViewModel;
            this.$subjectId = str;
            this.$nextPage = str2;
            this.$perPage = i11;
            this.$startPosition = i12;
            this.$endPosition = i13;
            this.$pagerMode = i14;
            this.$loadMore = z11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$subjectId, this.$nextPage, this.$perPage, this.$startPosition, this.$endPosition, this.$pagerMode, this.$loadMore, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super DownloadListBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC;
            Object obj2;
            b bVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    b bVar2 = (b) this.L$0;
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
            b bVar3 = (b) this.L$0;
            i00.a aVarF = this.this$0.f();
            String strA = cp.a.f62775a.a();
            String str = this.$subjectId;
            String str2 = this.$nextPage;
            int i12 = this.$perPage;
            int i13 = this.$startPosition;
            int i14 = this.$endPosition;
            int i15 = this.$pagerMode;
            this.L$0 = bVar3;
            this.label = 1;
            objC = i00.a.C0703a.c(aVarF, strA, str, str2, i12, 0, i13, i14, i15, null, 0, 0, 0, this, 3856, null);
            obj2 = objE;
            if (objC == obj2) {
                return obj2;
            }
            bVar = bVar3;
            BaseDto baseDto = (BaseDto) objC;
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                DownloadListBean downloadListBean = (DownloadListBean) baseDto.getData();
                if (downloadListBean != null) {
                    downloadListBean.setLoadMore(this.$loadMore);
                }
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

    /* JADX INFO: renamed from: com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1$2", f = "SubjectListViewModel.kt", l = {51}, m = "invokeSuspend")
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
            Object objE = kotlin.coroutines.intrinsics.a.e();
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubjectListViewModel f50914a;

        public a(SubjectListViewModel subjectListViewModel) {
            this.f50914a = subjectListViewModel;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(DownloadListBean downloadListBean, Continuation<? super Unit> continuation) {
            this.f50914a.c().n(downloadListBean);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListViewModel$getDownloadList$1(SubjectListViewModel subjectListViewModel, String str, String str2, int i11, int i12, int i13, int i14, boolean z11, Continuation<? super SubjectListViewModel$getDownloadList$1> continuation) {
        super(2, continuation);
        this.this$0 = subjectListViewModel;
        this.$subjectId = str;
        this.$nextPage = str2;
        this.$perPage = i11;
        this.$startPosition = i12;
        this.$endPosition = i13;
        this.$pagerMode = i14;
        this.$loadMore = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListViewModel$getDownloadList$1(this.this$0, this.$subjectId, this.$nextPage, this.$perPage, this.$startPosition, this.$endPosition, this.$pagerMode, this.$loadMore, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubjectListViewModel$getDownloadList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = c.e(c.o(new AnonymousClass1(this.this$0, this.$subjectId, this.$nextPage, this.$perPage, this.$startPosition, this.$endPosition, this.$pagerMode, this.$loadMore, null)), new AnonymousClass2(null));
            a aVar = new a(this.this$0);
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
