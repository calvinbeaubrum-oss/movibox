package com.transsion.home.viewmodel;

import androidx.core.view.MotionEventCompat;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.RankAllData;
import com.transsion.moviedetailapi.bean.Pager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.k;
import kotlinx.coroutines.k0;
import rt.c;
import uo.b;

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
@DebugMetadata(c = "com.transsion.home.viewmodel.RankAllViewModel$startRequest$1", f = "RankAllViewModel.kt", l = {MotionEventCompat.AXIS_GENERIC_15}, m = "invokeSuspend")
public final class RankAllViewModel$startRequest$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    int label;
    final /* synthetic */ RankAllViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankAllViewModel$startRequest$1(boolean z11, RankAllViewModel rankAllViewModel, Continuation<? super RankAllViewModel$startRequest$1> continuation) {
        super(2, continuation);
        this.$isLoadMore = z11;
        this.this$0 = rankAllViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RankAllViewModel$startRequest$1(this.$isLoadMore, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((RankAllViewModel$startRequest$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Pager pager;
        String page;
        Integer numL;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                int i12 = this.$isLoadMore ? this.this$0.f52749c + 1 : this.this$0.f52749c;
                c cVar = this.this$0.f52750d;
                String str = this.this$0.f52751f;
                int i13 = this.this$0.f52752g;
                this.label = 1;
                obj = c.a.a(cVar, null, i13, str, i12, 0, this, 17, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            this.this$0.l((RankAllData) baseDto.getData());
            if (this.$isLoadMore) {
                this.this$0.h().n((RankAllData) baseDto.getData());
                RankAllViewModel rankAllViewModel = this.this$0;
                RankAllData rankAllData = (RankAllData) baseDto.getData();
                rankAllViewModel.f52749c = (rankAllData == null || (pager = rankAllData.getPager()) == null || (page = pager.getPage()) == null || (numL = k.l(page)) == null) ? this.this$0.f52749c + 1 : numL.intValue();
            } else {
                this.this$0.i().n(baseDto.getData());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            b.a aVar = b.f78622a;
            String simpleName = RankAllViewModel.class.getSimpleName();
            Intrinsics.f(simpleName, "RankAllViewModel::class.java.simpleName");
            aVar.h(simpleName, "exceptionHandler " + e11.getMessage(), true);
            if (this.$isLoadMore) {
                this.this$0.h().n(null);
            } else {
                this.this$0.i().n(null);
            }
        }
        return Unit.f68710a;
    }
}
