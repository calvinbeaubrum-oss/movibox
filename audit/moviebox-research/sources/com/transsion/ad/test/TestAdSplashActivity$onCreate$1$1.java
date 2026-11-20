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
@DebugMetadata(c = "com.transsion.ad.test.TestAdSplashActivity$onCreate$1$1", f = "TestAdSplashActivity.kt", l = {64}, m = "invokeSuspend")
public final class TestAdSplashActivity$onCreate$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdSplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdSplashActivity$onCreate$1$1(TestAdSplashActivity testAdSplashActivity, Continuation<? super TestAdSplashActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdSplashActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdSplashActivity$onCreate$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TestAdSplashActivity$onCreate$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            nq.b bVar = this.this$0.f50634a;
            nq.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.y("splashManager");
                bVar = null;
            }
            bVar.m0("ColdStartScene");
            nq.b bVar3 = this.this$0.f50634a;
            if (bVar3 == null) {
                Intrinsics.y("splashManager");
                bVar3 = null;
            }
            bVar3.k0(null);
            nq.b bVar4 = this.this$0.f50634a;
            if (bVar4 == null) {
                Intrinsics.y("splashManager");
                bVar4 = null;
            }
            bVar4.j0(this.this$0);
            nq.b bVar5 = this.this$0.f50634a;
            if (bVar5 == null) {
                Intrinsics.y("splashManager");
                bVar5 = null;
            }
            bVar5.l0(this.this$0.f50636c);
            nq.b bVar6 = this.this$0.f50634a;
            if (bVar6 == null) {
                Intrinsics.y("splashManager");
            } else {
                bVar2 = bVar6;
            }
            this.label = 1;
            if (bVar2.T(this) == objE) {
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
