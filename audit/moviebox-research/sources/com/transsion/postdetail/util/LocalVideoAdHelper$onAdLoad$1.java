package com.transsion.postdetail.util;

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
@DebugMetadata(c = "com.transsion.postdetail.util.LocalVideoAdHelper$onAdLoad$1", f = "LocalVideoAdHelper.kt", l = {}, m = "invokeSuspend")
public final class LocalVideoAdHelper$onAdLoad$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ LocalVideoAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoAdHelper$onAdLoad$1(String str, LocalVideoAdHelper localVideoAdHelper, Continuation<? super LocalVideoAdHelper$onAdLoad$1> continuation) {
        super(2, continuation);
        this.$sceneId = str;
        this.this$0 = localVideoAdHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoAdHelper$onAdLoad$1(this.$sceneId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoAdHelper$onAdLoad$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String str = this.$sceneId;
        switch (str.hashCode()) {
            case -1994104145:
                if (str.equals("LandscapePauseSceneNew")) {
                    this.this$0.C0();
                }
                break;
            case -73588874:
                if (str.equals("VideoStartBidScene")) {
                    this.this$0.D0(this.$sceneId);
                }
                break;
            case 354873452:
                if (str.equals("VerticalPauseScene")) {
                    this.this$0.I0();
                }
                break;
            case 2049503279:
                if (str.equals("VideoEndBidScene")) {
                    this.this$0.D0(this.$sceneId);
                }
                break;
        }
        return Unit.f68710a;
    }
}
