package com.transsion.lib.diffupdate;

import java.io.File;
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
@DebugMetadata(c = "com.transsion.lib.diffupdate.DiffUpdateManager$applyPatch$1$1$1", f = "DiffUpdateManager.kt", l = {}, m = "invokeSuspend")
public final class DiffUpdateManager$applyPatch$1$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $apkFile;
    final /* synthetic */ boolean $success;
    final /* synthetic */ c $versionInfo;
    int label;
    final /* synthetic */ DiffUpdateManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffUpdateManager$applyPatch$1$1$1(boolean z11, DiffUpdateManager diffUpdateManager, File file, c cVar, Continuation<? super DiffUpdateManager$applyPatch$1$1$1> continuation) {
        super(2, continuation);
        this.$success = z11;
        this.this$0 = diffUpdateManager;
        this.$apkFile = file;
        this.$versionInfo = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiffUpdateManager$applyPatch$1$1$1(this.$success, this.this$0, this.$apkFile, this.$versionInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DiffUpdateManager$applyPatch$1$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.$success) {
            this.this$0.w(this.$apkFile);
            DiffUpdateManager.v(this.this$0, "applyPatch: bspatch finish, go install", 0, 2, null);
        } else {
            DiffUpdateManager.v(this.this$0, "applyPatch: bspatch error, errormsg: patch error ,abort bspatch process and launch downgrade update process", 0, 2, null);
            this.this$0.y(this.$versionInfo);
        }
        return Unit.f68710a;
    }
}
