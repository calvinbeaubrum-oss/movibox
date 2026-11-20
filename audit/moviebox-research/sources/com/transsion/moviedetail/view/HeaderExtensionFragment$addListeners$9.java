package com.transsion.moviedetail.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.u0;
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
@DebugMetadata(c = "com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9", f = "HeaderExtensionFragment.kt", l = {201}, m = "invokeSuspend")
public final class HeaderExtensionFragment$addListeners$9 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HeaderExtensionFragment this$0;

    /* JADX INFO: renamed from: com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9$1", f = "HeaderExtensionFragment.kt", l = {202}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HeaderExtensionFragment this$0;

        /* JADX INFO: renamed from: com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9$1$1", f = "HeaderExtensionFragment.kt", l = {}, m = "invokeSuspend")
        public static final class C05771 extends SuspendLambda implements Function2<CourseBean, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ HeaderExtensionFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C05771(HeaderExtensionFragment headerExtensionFragment, Continuation<? super C05771> continuation) {
                super(2, continuation);
                this.this$0 = headerExtensionFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C05771 c05771 = new C05771(this.this$0, continuation);
                c05771.L$0 = obj;
                return c05771;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CourseBean courseBean, Continuation<? super Unit> continuation) {
                return ((C05771) create(courseBean, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                CourseBean courseBean = (CourseBean) this.L$0;
                String subjectId = courseBean.getSubjectId();
                Subject subject = this.this$0.f53801k;
                if (Intrinsics.b(subjectId, subject != null ? subject.getSubjectId() : null)) {
                    Subject subject2 = this.this$0.f53801k;
                    if (subject2 != null) {
                        subject2.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                    }
                    this.this$0.s1(Boxing.d(courseBean.getSeenStatus()));
                }
                return Unit.f68710a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HeaderExtensionFragment headerExtensionFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = headerExtensionFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                u0<CourseBean> u0VarH = CourseManager.f51853a.h();
                C05771 c05771 = new C05771(this.this$0, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.h(u0VarH, c05771, this) == objE) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderExtensionFragment$addListeners$9(HeaderExtensionFragment headerExtensionFragment, Continuation<? super HeaderExtensionFragment$addListeners$9> continuation) {
        super(2, continuation);
        this.this$0 = headerExtensionFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeaderExtensionFragment$addListeners$9(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HeaderExtensionFragment$addListeners$9) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            HeaderExtensionFragment headerExtensionFragment = this.this$0;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(headerExtensionFragment, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(headerExtensionFragment, state, anonymousClass1, this) == objE) {
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
