package com.transsion.edcation.list;

import androidx.core.view.MotionEventCompat;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$string;
import com.transsion.edcation.bean.CourseBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
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
@DebugMetadata(c = "com.transsion.edcation.list.CourseListAdapter$convert$2", f = "CourseListAdapter.kt", l = {MotionEventCompat.AXIS_GENERIC_14, 54}, m = "invokeSuspend")
public final class CourseListAdapter$convert$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseViewHolder $holder;
    final /* synthetic */ CourseBean $item;
    int label;
    final /* synthetic */ CourseListAdapter this$0;

    /* JADX INFO: renamed from: com.transsion.edcation.list.CourseListAdapter$convert$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.edcation.list.CourseListAdapter$convert$2$1", f = "CourseListAdapter.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ BaseViewHolder $holder;
        final /* synthetic */ String $percentStr;
        int label;
        final /* synthetic */ CourseListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BaseViewHolder baseViewHolder, CourseListAdapter courseListAdapter, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$holder = baseViewHolder;
            this.this$0 = courseListAdapter;
            this.$percentStr = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$holder, this.this$0, this.$percentStr, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$holder.setText(R$id.item_progress, this.this$0.getContext().getString(R$string.course_learn_progress, this.$percentStr));
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseListAdapter$convert$2(CourseListAdapter courseListAdapter, CourseBean courseBean, BaseViewHolder baseViewHolder, Continuation<? super CourseListAdapter$convert$2> continuation) {
        super(2, continuation);
        this.this$0 = courseListAdapter;
        this.$item = courseBean;
        this.$holder = baseViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseListAdapter$convert$2(this.this$0, this.$item, this.$holder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((CourseListAdapter$convert$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
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
        VideoDetailPlayDao videoDetailPlayDaoK0 = this.this$0.K0();
        String subjectId = this.$item.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        this.label = 1;
        obj = videoDetailPlayDaoK0.f(subjectId, this);
        if (obj == objE) {
            return objE;
        }
        Long l11 = (Long) obj;
        long jLongValue = l11 != null ? l11.longValue() : 0L;
        Integer durationSeconds = this.$item.getDurationSeconds();
        int iIntValue = durationSeconds != null ? durationSeconds.intValue() : 0;
        float f11 = iIntValue > 0 ? (jLongValue / 10.0f) / iIntValue : 0.0f;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format("%.0f", Arrays.copyOf(new Object[]{Boxing.c(kotlin.ranges.a.f(f11, 100.0f))}, 1));
        Intrinsics.f(str, "format(...)");
        a2 a2VarC = w0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$holder, this.this$0, str, null);
        this.label = 2;
        if (h.g(a2VarC, anonymousClass1, this) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }
}
