package com.transsion.edcation;

import android.util.Log;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.edcation.bean.CourseBody;
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
@DebugMetadata(c = "com.transsion.edcation.CourseManager$subscribeCourseById$1", f = "CourseManager.kt", l = {}, m = "invokeSuspend")
public final class CourseManager$subscribeCourseById$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $status;
    final /* synthetic */ String $subjectId;
    int label;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T, R> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T, R> f51869a = new a<>();

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
        public final /* synthetic */ int f51870d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f51871f;

        public b(int i11, String str) {
            this.f51870d = i11;
            this.f51871f = str;
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
            int i11 = this.f51870d;
            if (i11 == 0) {
                CourseManager.f51853a.l(new CourseBean(this.f51871f, null, i11, null, null, null, null, null, null, 0L, null, 2042, null));
                com.tn.lib.widget.toast.core.h.f50034a.k(R$string.course_remove_success);
            } else {
                CourseManager.n(CourseManager.f51853a, null, this.f51871f, 1, null);
                com.tn.lib.widget.toast.core.h.f50034a.k(R$string.course_add_success);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseManager$subscribeCourseById$1(Integer num, String str, Continuation<? super CourseManager$subscribeCourseById$1> continuation) {
        super(2, continuation);
        this.$status = num;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$subscribeCourseById$1(this.$status, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((CourseManager$subscribeCourseById$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Integer num = this.$status;
        String str = this.$subjectId;
        try {
            Result.Companion companion = Result.Companion;
            int i11 = (num != null && num.intValue() == 0) ? 1 : 0;
            com.transsion.edcation.a.C0564a.d(CourseManager.f51853a.i(), null, new CourseBody(str, i11), 1, null).r(q10.a.b()).t(a.f51869a).e(d.f82109a.c()).subscribe(new b(i11, str));
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Unit unit = (Unit) (Result.m169isFailureimpl(objM163constructorimpl) ? null : objM163constructorimpl);
        if (unit != null) {
            Log.e("subscribeCourse", "error: " + unit);
        }
        return Unit.f68710a;
    }
}
