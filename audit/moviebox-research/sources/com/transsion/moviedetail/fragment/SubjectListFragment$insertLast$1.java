package com.transsion.moviedetail.fragment;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "com.transsion.moviedetail.fragment.SubjectListFragment$insertLast$1", f = "SubjectListFragment.kt", l = {}, m = "invokeSuspend")
public final class SubjectListFragment$insertLast$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PostSubjectItem> $dataList;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX INFO: renamed from: com.transsion.moviedetail.fragment.SubjectListFragment$insertLast$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.moviedetail.fragment.SubjectListFragment$insertLast$1$2", f = "SubjectListFragment.kt", l = {1075}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SubjectListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SubjectListFragment subjectListFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = subjectListFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                com.transsion.ad.bidding.nativead.c cVar = this.this$0.f53562m;
                if (cVar != null) {
                    this.label = 1;
                    if (cVar.T(this) == objE) {
                        return objE;
                    }
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
    public static final class a extends jq.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubjectListFragment f53581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<PostSubjectItem> f53582b;

        public a(SubjectListFragment subjectListFragment, List<PostSubjectItem> list) {
            this.f53581a = subjectListFragment;
            this.f53582b = list;
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit> function2R;
            super.h(biddingIntermediateMaterialBean);
            com.transsion.ad.bidding.nativead.c cVar = this.f53581a.f53562m;
            if (cVar != null) {
                SubjectListFragment subjectListFragment = this.f53581a;
                List<PostSubjectItem> list = this.f53582b;
                BiddingListManager biddingListManager = subjectListFragment.f53561l;
                if (biddingListManager != null && (function2R = biddingListManager.r()) != null) {
                    function2R.invoke(Integer.valueOf(list.size()), cVar);
                }
                BiddingListManager biddingListManager2 = subjectListFragment.f53561l;
                if (biddingListManager2 == null) {
                    return;
                }
                biddingListManager2.D(null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListFragment$insertLast$1(SubjectListFragment subjectListFragment, List<PostSubjectItem> list, Continuation<? super SubjectListFragment$insertLast$1> continuation) {
        super(2, continuation);
        this.this$0 = subjectListFragment;
        this.$dataList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$insertLast$1(this.this$0, this.$dataList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubjectListFragment$insertLast$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.this$0.f53562m = new com.transsion.ad.bidding.nativead.c();
        com.transsion.ad.bidding.nativead.c cVar = this.this$0.f53562m;
        if (cVar != null) {
            cVar.m0("SubjectDetailRecommendScene");
        }
        com.transsion.ad.bidding.nativead.c cVar2 = this.this$0.f53562m;
        if (cVar2 != null) {
            cVar2.l0(new a(this.this$0, this.$dataList));
        }
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.this$0), null, null, new AnonymousClass2(this.this$0, null), 3, null);
        return Unit.f68710a;
    }
}
