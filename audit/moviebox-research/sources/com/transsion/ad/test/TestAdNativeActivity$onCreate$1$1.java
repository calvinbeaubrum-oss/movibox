package com.transsion.ad.test;

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
@DebugMetadata(c = "com.transsion.ad.test.TestAdNativeActivity$onCreate$1$1", f = "TestAdNativeActivity.kt", l = {63}, m = "invokeSuspend")
public final class TestAdNativeActivity$onCreate$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdNativeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdNativeActivity$onCreate$1$1(TestAdNativeActivity testAdNativeActivity, Continuation<? super TestAdNativeActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdNativeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdNativeActivity$onCreate$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TestAdNativeActivity$onCreate$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            com.transsion.ad.bidding.nativead.c cVar = this.this$0.f50621a;
            com.transsion.ad.bidding.nativead.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.y("nativeManager");
                cVar = null;
            }
            cVar.m0("MBNativeTestId");
            com.transsion.ad.bidding.nativead.c cVar3 = this.this$0.f50621a;
            if (cVar3 == null) {
                Intrinsics.y("nativeManager");
                cVar3 = null;
            }
            cVar3.k0(null);
            com.transsion.ad.bidding.nativead.c cVar4 = this.this$0.f50621a;
            if (cVar4 == null) {
                Intrinsics.y("nativeManager");
                cVar4 = null;
            }
            cVar4.j0(this.this$0);
            com.transsion.ad.bidding.nativead.c cVar5 = this.this$0.f50621a;
            if (cVar5 == null) {
                Intrinsics.y("nativeManager");
                cVar5 = null;
            }
            cVar5.l0(this.this$0.f50623c);
            com.transsion.ad.bidding.nativead.c cVar6 = this.this$0.f50621a;
            if (cVar6 == null) {
                Intrinsics.y("nativeManager");
            } else {
                cVar2 = cVar6;
            }
            this.label = 1;
            if (cVar2.T(this) == objE) {
                return objE;
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
