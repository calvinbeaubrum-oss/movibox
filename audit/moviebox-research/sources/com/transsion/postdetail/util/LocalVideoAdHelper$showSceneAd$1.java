package com.transsion.postdetail.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "com.transsion.postdetail.util.LocalVideoAdHelper$showSceneAd$1", f = "LocalVideoAdHelper.kt", l = {322, 326}, m = "invokeSuspend")
public final class LocalVideoAdHelper$showSceneAd$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ Function0<Unit> $onFail;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ LocalVideoAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoAdHelper$showSceneAd$1(String str, LocalVideoAdHelper localVideoAdHelper, Function0<Unit> function0, Function0<Unit> function1, Continuation<? super LocalVideoAdHelper$showSceneAd$1> continuation) {
        super(2, continuation);
        this.$sceneId = str;
        this.this$0 = localVideoAdHelper;
        this.$callback = function0;
        this.$onFail = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoAdHelper$showSceneAd$1(this.$sceneId, this.this$0, this.$callback, this.$onFail, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoAdHelper$showSceneAd$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (Intrinsics.b(this.$sceneId, "LandscapePauseSceneNew")) {
                LocalVideoAdHelper localVideoAdHelper = this.this$0;
                String str = this.$sceneId;
                Function0<Unit> function0 = this.$callback;
                Function0<Unit> function1 = this.$onFail;
                this.label = 1;
                if (localVideoAdHelper.e0(str, function0, function1, this) == objE) {
                    return objE;
                }
            } else {
                LocalVideoAdHelper localVideoAdHelper2 = this.this$0;
                String str2 = this.$sceneId;
                Function0<Unit> function2 = this.$callback;
                Function0<Unit> function3 = this.$onFail;
                this.label = 2;
                if (localVideoAdHelper2.f0(str2, function2, function3, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 1 && i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
