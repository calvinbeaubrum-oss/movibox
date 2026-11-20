package com.transsion.ad.middle.icon;

import android.widget.TextView;
import com.blankj.utilcode.util.i;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.RecommendInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.ad.middle.icon.BuyOutIconView$showData$4", f = "BuyOutIconView.kt", l = {}, m = "invokeSuspend")
public final class BuyOutIconView$showData$4 extends SuspendLambda implements Function2<k0, Continuation<? super TextView>, Object> {
    final /* synthetic */ com.transsion.ad.strategy.c $adLayoutProvider;
    final /* synthetic */ RecommendInfo $recommendInfo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyOutIconView$showData$4(com.transsion.ad.strategy.c cVar, RecommendInfo recommendInfo, Continuation<? super BuyOutIconView$showData$4> continuation) {
        super(2, continuation);
        this.$adLayoutProvider = cVar;
        this.$recommendInfo = recommendInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BuyOutIconView$showData$4(this.$adLayoutProvider, this.$recommendInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super TextView> continuation) {
        return ((BuyOutIconView$showData$4) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Integer numA;
        ItemDetail detail;
        String sourceSize;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        com.transsion.ad.strategy.c cVar = this.$adLayoutProvider;
        if (cVar == null || (numA = cVar.a()) == null) {
            return null;
        }
        com.transsion.ad.strategy.c cVar2 = this.$adLayoutProvider;
        RecommendInfo recommendInfo = this.$recommendInfo;
        TextView textView = (TextView) cVar2.f().findViewById(numA.intValue());
        if (textView == null) {
            return null;
        }
        Intrinsics.f(textView, "findViewById<TextView>(apkSizeId)");
        textView.setText(i.b((recommendInfo == null || (detail = recommendInfo.getDetail()) == null || (sourceSize = detail.getSourceSize()) == null) ? 0L : Long.parseLong(sourceSize), 1));
        return textView;
    }
}
