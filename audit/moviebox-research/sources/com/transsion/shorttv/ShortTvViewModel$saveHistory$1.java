package com.transsion.shorttv;

import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.shorttv.ShortTvViewModel$saveHistory$1", f = "ShortTvViewModel.kt", l = {504, 505}, m = "invokeSuspend")
public final class ShortTvViewModel$saveHistory$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $progress;
    final /* synthetic */ ShortTVItem $shortTVItem;
    final /* synthetic */ Subject $subject;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$saveHistory$1(ShortTvViewModel shortTvViewModel, Subject subject, ShortTVItem shortTVItem, long j11, Continuation<? super ShortTvViewModel$saveHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvViewModel;
        this.$subject = subject;
        this.$shortTVItem = shortTVItem;
        this.$progress = j11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvViewModel$saveHistory$1(this.this$0, this.$subject, this.$shortTVItem, this.$progress, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$saveHistory$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
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
        com.transsion.shorttv.episode.a aVarY = this.this$0.y();
        Subject subject = this.$subject;
        ShortTVItem shortTVItem = this.$shortTVItem;
        long j11 = this.$progress;
        this.label = 1;
        if (aVarY.g(subject, shortTVItem, j11, this) == objE) {
            return objE;
        }
        ox.a aVarW = this.this$0.w();
        String subjectId = this.$subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        String str = subjectId;
        int ep2 = this.$shortTVItem.getEp();
        long j12 = this.$progress;
        this.label = 2;
        if (aVarW.b(str, ep2, j12, this) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }
}
