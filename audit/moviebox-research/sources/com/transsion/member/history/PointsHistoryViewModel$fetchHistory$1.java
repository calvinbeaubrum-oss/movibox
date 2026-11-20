package com.transsion.member.history;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.member.bean.PointsHistoryData;
import com.transsion.member.bean.PointsHistoryItem;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import java.util.List;
import k10.h;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.transsion.member.history.PointsHistoryViewModel$fetchHistory$1", f = "PointsHistoryViewModel.kt", l = {}, m = "invokeSuspend")
public final class PointsHistoryViewModel$fetchHistory$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $page;
    int label;
    final /* synthetic */ PointsHistoryViewModel this$0;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T, R> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T, R> f53341a = new a<>();

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m<? extends BaseDto<PointsHistoryData>> apply(Throwable it) {
            Intrinsics.g(it, "it");
            return j.i(it);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends zo.a<PointsHistoryData> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PointsHistoryViewModel f53342d;

        public b(PointsHistoryViewModel pointsHistoryViewModel) {
            this.f53342d = pointsHistoryViewModel;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error: ");
            sb2.append(str);
            sb2.append(", msg:");
            sb2.append(str2);
            this.f53342d.d().q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PointsHistoryData pointsHistoryData) {
            List<PointsHistoryItem> list;
            super.c(pointsHistoryData);
            Boolean boolValueOf = (pointsHistoryData == null || (list = pointsHistoryData.getList()) == null) ? null : Boolean.valueOf(list.isEmpty());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("list is empty: ");
            sb2.append(boolValueOf);
            this.f53342d.d().q(pointsHistoryData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointsHistoryViewModel$fetchHistory$1(PointsHistoryViewModel pointsHistoryViewModel, String str, Continuation<? super PointsHistoryViewModel$fetchHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = pointsHistoryViewModel;
        this.$page = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PointsHistoryViewModel$fetchHistory$1(this.this$0, this.$page, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PointsHistoryViewModel$fetchHistory$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        pu.a.C0809a.g(this.this$0.e(), this.$page, 0, null, 6, null).r(q10.a.b()).t(a.f53341a).e(d.f82109a.c()).subscribe(new b(this.this$0));
        return Unit.f68710a;
    }
}
