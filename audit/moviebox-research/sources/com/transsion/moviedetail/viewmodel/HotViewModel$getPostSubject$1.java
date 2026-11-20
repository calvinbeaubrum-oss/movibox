package com.transsion.moviedetail.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.Worker;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
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
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.HotViewModel$getPostSubject$1", f = "HotViewModel.kt", l = {Worker.WHAT_SYNC_DATA}, m = "invokeSuspend")
public final class HotViewModel$getPostSubject$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $page;
    final /* synthetic */ int $perPage;
    final /* synthetic */ String $sortType;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ boolean $with;
    int label;
    final /* synthetic */ HotViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.moviedetail.viewmodel.HotViewModel$getPostSubject$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.HotViewModel$getPostSubject$1$1", f = "HotViewModel.kt", l = {97, 100}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super PostSubjectBean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $page;
        final /* synthetic */ int $perPage;
        final /* synthetic */ String $sortType;
        final /* synthetic */ String $subjectId;
        final /* synthetic */ boolean $with;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ HotViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HotViewModel hotViewModel, String str, String str2, int i11, String str3, boolean z11, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = hotViewModel;
            this.$subjectId = str;
            this.$page = str2;
            this.$perPage = i11;
            this.$sortType = str3;
            this.$with = z11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$subjectId, this.$page, this.$perPage, this.$sortType, this.$with, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super PostSubjectBean> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            b bVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    bVar = (b) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            bVar = (b) this.L$0;
            vu.a aVarP = this.this$0.P();
            String strA = cp.a.f62775a.a();
            String str = this.$subjectId;
            if (str == null) {
                str = "";
            }
            String str2 = this.$page;
            int i12 = this.$perPage;
            String str3 = this.$sortType;
            boolean z11 = this.$with;
            this.L$0 = bVar;
            this.label = 1;
            obj = aVarP.e(strA, str, str2, i12, str3, z11, this);
            if (obj == objE) {
                return objE;
            }
            Object data = ((BaseDto) obj).getData();
            this.L$0 = null;
            this.label = 2;
            if (bVar.emit(data, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.moviedetail.viewmodel.HotViewModel$getPostSubject$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.HotViewModel$getPostSubject$1$2", f = "HotViewModel.kt", l = {102}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<b<? super PostSubjectBean>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super PostSubjectBean> bVar, Throwable th2, Continuation<? super Unit> continuation) {
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
        public final /* synthetic */ HotViewModel f53846a;

        public a(HotViewModel hotViewModel) {
            this.f53846a = hotViewModel;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(PostSubjectBean postSubjectBean, Continuation<? super Unit> continuation) {
            String nextPage;
            Integer perPage;
            if (postSubjectBean != null) {
                HotViewModel hotViewModel = this.f53846a;
                Pager pager = postSubjectBean.getPager();
                hotViewModel.S((pager == null || (perPage = pager.getPerPage()) == null) ? 10 : perPage.intValue());
                Pager pager2 = postSubjectBean.getPager();
                if (pager2 == null || (nextPage = pager2.getNextPage()) == null) {
                    nextPage = "0";
                }
                hotViewModel.f53842n = nextPage;
            }
            this.f53846a.p().q(postSubjectBean);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotViewModel$getPostSubject$1(HotViewModel hotViewModel, String str, String str2, int i11, String str3, boolean z11, Continuation<? super HotViewModel$getPostSubject$1> continuation) {
        super(2, continuation);
        this.this$0 = hotViewModel;
        this.$subjectId = str;
        this.$page = str2;
        this.$perPage = i11;
        this.$sortType = str3;
        this.$with = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotViewModel$getPostSubject$1(this.this$0, this.$subjectId, this.$page, this.$perPage, this.$sortType, this.$with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HotViewModel$getPostSubject$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = c.e(c.q(c.o(new AnonymousClass1(this.this$0, this.$subjectId, this.$page, this.$perPage, this.$sortType, this.$with, null)), w0.b()), new AnonymousClass2(null));
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
