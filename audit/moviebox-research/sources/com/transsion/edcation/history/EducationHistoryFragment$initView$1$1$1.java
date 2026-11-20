package com.transsion.edcation.history;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import h9.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
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
@DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$initView$1$1$1", f = "EducationHistoryFragment.kt", l = {55, DownloadBean.STATUS_COMPLETED_REMOVED}, m = "invokeSuspend")
public final class EducationHistoryFragment$initView$1$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EducationHistoryFragment this$0;

    /* JADX INFO: renamed from: com.transsion.edcation.history.EducationHistoryFragment$initView$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$initView$1$1$1$1", f = "EducationHistoryFragment.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<VideoDetailPlayBean> $list;
        int label;
        final /* synthetic */ EducationHistoryFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<VideoDetailPlayBean> list, EducationHistoryFragment educationHistoryFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = educationHistoryFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$list, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            f fVarQ;
            f fVarQ2;
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (!this.$list.isEmpty()) {
                EducationHistoryAdapter educationHistoryAdapter = this.this$0.f51885a;
                if (educationHistoryAdapter != null) {
                    educationHistoryAdapter.m(this.$list);
                }
                EducationHistoryAdapter educationHistoryAdapter2 = this.this$0.f51885a;
                if (educationHistoryAdapter2 != null && (fVarQ2 = educationHistoryAdapter2.Q()) != null) {
                    fVarQ2.r();
                }
            } else {
                EducationHistoryAdapter educationHistoryAdapter3 = this.this$0.f51885a;
                if (educationHistoryAdapter3 != null && (fVarQ = educationHistoryAdapter3.Q()) != null) {
                    f.t(fVarQ, false, 1, null);
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EducationHistoryFragment$initView$1$1$1(EducationHistoryFragment educationHistoryFragment, Continuation<? super EducationHistoryFragment$initView$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = educationHistoryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EducationHistoryFragment$initView$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((EducationHistoryFragment$initView$1$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
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
        EducationHistoryFragment educationHistoryFragment = this.this$0;
        this.label = 1;
        obj = educationHistoryFragment.m0(false, this);
        if (obj == objE) {
            return objE;
        }
        a2 a2VarC = w0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1((List) obj, this.this$0, null);
        this.label = 2;
        if (h.g(a2VarC, anonymousClass1, this) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }
}
