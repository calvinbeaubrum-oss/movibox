package com.transsion.ad.test;

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
@DebugMetadata(c = "com.transsion.ad.test.TestAdBannerActivity$onCreate$1$1", f = "TestAdBannerActivity.kt", l = {60}, m = "invokeSuspend")
public final class TestAdBannerActivity$onCreate$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdBannerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdBannerActivity$onCreate$1$1(TestAdBannerActivity testAdBannerActivity, Continuation<? super TestAdBannerActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdBannerActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdBannerActivity$onCreate$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TestAdBannerActivity$onCreate$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kq.a aVar = this.this$0.f50614b;
            if (aVar != null) {
                aVar.F();
            }
            this.this$0.f50614b = new kq.a();
            kq.a aVar2 = this.this$0.f50614b;
            if (aVar2 != null) {
                aVar2.m0("TrendingBannerScene");
            }
            kq.a aVar3 = this.this$0.f50614b;
            if (aVar3 != null) {
                aVar3.k0(null);
            }
            kq.a aVar4 = this.this$0.f50614b;
            if (aVar4 != null) {
                aVar4.j0(this.this$0);
            }
            kq.a aVar5 = this.this$0.f50614b;
            if (aVar5 != null) {
                aVar5.l0(this.this$0.f50615c);
            }
            kq.a aVar6 = this.this$0.f50614b;
            if (aVar6 != null) {
                this.label = 1;
                if (aVar6.T(this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
