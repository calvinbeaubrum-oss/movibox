package com.transsion.edcation;

import android.util.Log;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.edcation.bean.CourseBody;
import com.transsion.moviedetailapi.bean.Subject;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import k10.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import zo.d;

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
@DebugMetadata(c = "com.transsion.edcation.CourseManager$subscribeCourse$1", f = "CourseManager.kt", l = {}, m = "invokeSuspend")
public final class CourseManager$subscribeCourse$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Subject $course;
    final /* synthetic */ Boolean $subscribeStatus;
    int label;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T, R> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T, R> f51866a = new a<>();

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m<? extends BaseDto<String>> apply(Throwable it) {
            Intrinsics.g(it, "it");
            return j.i(it);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends zo.a<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Subject f51867d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f51868f;

        public b(Subject subject, int i11) {
            this.f51867d = subject;
            this.f51868f = i11;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error: ");
            sb2.append(str);
            sb2.append(", msg:");
            sb2.append(str2);
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.course_default_failed);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("data:");
            sb2.append(str);
            this.f51867d.setSeenStatus(Integer.valueOf(this.f51868f));
            CourseManager.f51853a.l(at.a.a(this.f51867d));
            if (this.f51868f == 1) {
                com.tn.lib.widget.toast.core.h.f50034a.k(R$string.course_add_success);
            } else {
                com.tn.lib.widget.toast.core.h.f50034a.k(R$string.course_remove_success);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseManager$subscribeCourse$1(Subject subject, Boolean bool, Continuation<? super CourseManager$subscribeCourse$1> continuation) {
        super(2, continuation);
        this.$course = subject;
        this.$subscribeStatus = bool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$subscribeCourse$1(this.$course, this.$subscribeStatus, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((CourseManager$subscribeCourse$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0035  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        int i11;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Subject subject = this.$course;
        Boolean bool = this.$subscribeStatus;
        try {
            Result.Companion companion = Result.Companion;
            String subjectId = subject.getSubjectId();
            if (subjectId == null) {
                return Unit.f68710a;
            }
            if (bool == null) {
                Integer seenStatus = subject.getSeenStatus();
                if (seenStatus != null && seenStatus.intValue() == 0) {
                    i11 = 1;
                } else {
                    i11 = 0;
                }
            } else if (bool.booleanValue()) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            com.transsion.edcation.a.C0564a.d(CourseManager.f51853a.i(), null, new CourseBody(subjectId, i11), 1, null).r(q10.a.b()).t(a.f51866a).e(d.f82109a.c()).subscribe(new b(subject, i11));
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            Unit unit = (Unit) (Result.m169isFailureimpl(objM163constructorimpl) ? null : objM163constructorimpl);
            if (unit != null) {
                Log.e("subscribeCourse", "error: " + unit);
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
    }
}
