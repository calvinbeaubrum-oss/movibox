package com.transsion.home.adapter.suboperate.provider;

import com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1$emit$2$1", f = "SubHorizontalBannerProvider.kt", l = {}, m = "invokeSuspend")
public final class SubHorizontalBannerProvider$registerCourse$1$1$emit$2$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubHorizontalBannerProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubHorizontalBannerProvider$registerCourse$1$1$emit$2$1(SubHorizontalBannerProvider subHorizontalBannerProvider, Continuation<? super SubHorizontalBannerProvider$registerCourse$1$1$emit$2$1> continuation) {
        super(2, continuation);
        this.this$0 = subHorizontalBannerProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubHorizontalBannerProvider$registerCourse$1$1$emit$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubHorizontalBannerProvider$registerCourse$1$1$emit$2$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        SubHorizontalViewPagerAdapter subHorizontalViewPagerAdapter = this.this$0.f52141q;
        if (subHorizontalViewPagerAdapter == null) {
            return null;
        }
        subHorizontalViewPagerAdapter.notifyDataSetChanged();
        return Unit.f68710a;
    }
}
