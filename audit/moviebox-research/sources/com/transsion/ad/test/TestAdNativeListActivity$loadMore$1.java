package com.transsion.ad.test;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;

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
@DebugMetadata(c = "com.transsion.ad.test.TestAdNativeListActivity$loadMore$1", f = "TestAdNativeListActivity.kt", l = {68}, m = "invokeSuspend")
public final class TestAdNativeListActivity$loadMore$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdNativeListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdNativeListActivity$loadMore$1(TestAdNativeListActivity testAdNativeListActivity, Continuation<? super TestAdNativeListActivity$loadMore$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdNativeListActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdNativeListActivity$loadMore$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TestAdNativeListActivity$loadMore$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        h9.f fVarQ;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (r0.a(1000L, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < 5; i12++) {
            arrayList.add(new TestAdNativeListActivity.b("", null));
        }
        TestAdNativeListActivity.a aVar = this.this$0.f50626b;
        if (aVar != null) {
            aVar.m(arrayList);
        }
        TestAdNativeListActivity.a aVar2 = this.this$0.f50626b;
        if (aVar2 != null && (fVarQ = aVar2.Q()) != null) {
            fVarQ.r();
        }
        return Unit.f68710a;
    }
}
