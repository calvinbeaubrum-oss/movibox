package com.transsion.home.adapter.suboperate.provider;

import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.KotlinNothingValueException;
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
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1", f = "SubFeedsEducationProvider.kt", l = {169}, m = "invokeSuspend")
public final class SubFeedsEducationProvider$MyViewHolder$registerCourse$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubFeedsEducationProvider.MyViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubFeedsEducationProvider$MyViewHolder$registerCourse$1(SubFeedsEducationProvider.MyViewHolder myViewHolder, Continuation<? super SubFeedsEducationProvider$MyViewHolder$registerCourse$1> continuation) {
        super(2, continuation);
        this.this$0 = myViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubFeedsEducationProvider$MyViewHolder$registerCourse$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubFeedsEducationProvider$MyViewHolder$registerCourse$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            u0<CourseBean> u0VarH = CourseManager.f51853a.h();
            final SubFeedsEducationProvider.MyViewHolder myViewHolder = this.this$0;
            kotlinx.coroutines.flow.b<CourseBean> bVar = new kotlinx.coroutines.flow.b<CourseBean>() { // from class: com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1.1
                @Override // kotlinx.coroutines.flow.b
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(CourseBean courseBean, Continuation<? super Unit> continuation) {
                    Subject feedsSubject;
                    OperateItem operateItem = myViewHolder.f52121d;
                    if (!Intrinsics.b((operateItem == null || (feedsSubject = operateItem.getFeedsSubject()) == null) ? null : feedsSubject.getSubjectId(), courseBean.getSubjectId())) {
                        return Unit.f68710a;
                    }
                    OperateItem operateItem2 = myViewHolder.f52121d;
                    Subject feedsSubject2 = operateItem2 != null ? operateItem2.getFeedsSubject() : null;
                    if (feedsSubject2 != null) {
                        feedsSubject2.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                    }
                    Object objG = kotlinx.coroutines.h.g(w0.c(), new SubFeedsEducationProvider$MyViewHolder$registerCourse$1$1$emit$2(myViewHolder, null), continuation);
                    return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
                }
            };
            this.label = 1;
            if (u0VarH.a(bVar, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
