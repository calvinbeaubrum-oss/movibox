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
@DebugMetadata(c = "com.transsion.ad.test.TestAdVideoActivity$onCreate$1$1", f = "TestAdVideoActivity.kt", l = {54}, m = "invokeSuspend")
public final class TestAdVideoActivity$onCreate$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdVideoActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdVideoActivity$onCreate$1$1(TestAdVideoActivity testAdVideoActivity, Continuation<? super TestAdVideoActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdVideoActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdVideoActivity$onCreate$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TestAdVideoActivity$onCreate$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            com.transsion.ad.bidding.video.f fVar = this.this$0.f50638a;
            com.transsion.ad.bidding.video.f fVar2 = null;
            if (fVar == null) {
                Intrinsics.y("videoManager");
                fVar = null;
            }
            fVar.m0("MemberPageVideoTaskScene");
            com.transsion.ad.bidding.video.f fVar3 = this.this$0.f50638a;
            if (fVar3 == null) {
                Intrinsics.y("videoManager");
                fVar3 = null;
            }
            fVar3.k0(null);
            com.transsion.ad.bidding.video.f fVar4 = this.this$0.f50638a;
            if (fVar4 == null) {
                Intrinsics.y("videoManager");
                fVar4 = null;
            }
            fVar4.j0(this.this$0);
            com.transsion.ad.bidding.video.f fVar5 = this.this$0.f50638a;
            if (fVar5 == null) {
                Intrinsics.y("videoManager");
                fVar5 = null;
            }
            fVar5.l0(this.this$0.f50640c);
            com.transsion.ad.bidding.video.f fVar6 = this.this$0.f50638a;
            if (fVar6 == null) {
                Intrinsics.y("videoManager");
            } else {
                fVar2 = fVar6;
            }
            this.label = 1;
            if (fVar2.T(this) == objE) {
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
