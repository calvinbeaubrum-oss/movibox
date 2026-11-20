package com.transsion.edcation;

import com.transsion.edcation.bean.CourseBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.v0;
import kotlinx.coroutines.k0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.edcation.CourseManager$updateCourseList$1", f = "CourseManager.kt", l = {220, 221}, m = "invokeSuspend")
public final class CourseManager$updateCourseList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CourseBean> $list;
    final /* synthetic */ String $page;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseManager$updateCourseList$1(String str, List<CourseBean> list, Continuation<? super CourseManager$updateCourseList$1> continuation) {
        super(2, continuation);
        this.$page = str;
        this.$list = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$updateCourseList$1(this.$page, this.$list, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((CourseManager$updateCourseList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<CourseBean> value;
        List<CourseBean> list;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                list = (List) this.L$0;
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
        if (Intrinsics.b(this.$page, "1")) {
            value = this.$list;
        } else {
            value = CourseManager.f51853a.f().getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            List<CourseBean> list2 = this.$list;
            if (list2 != null) {
                value.addAll(list2);
            }
        }
        list = value;
        v0<List<CourseBean>> v0VarF = CourseManager.f51853a.f();
        this.L$0 = list;
        this.label = 1;
        if (v0VarF.emit(list, this) == objE) {
            return objE;
        }
        v0<CourseBean> v0VarJ = CourseManager.f51853a.j();
        CourseBean courseBean = list != null ? (CourseBean) CollectionsKt___CollectionsKt.g0(list) : null;
        this.L$0 = null;
        this.label = 2;
        if (v0VarJ.emit(courseBean, this) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }
}
