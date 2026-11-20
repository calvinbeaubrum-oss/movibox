package com.transsion.lib.diffupdate;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "com.transsion.lib.diffupdate.DiffUpdateManager$startBackupDownloader$3$onSuccess$2", f = "DiffUpdateManager.kt", l = {390}, m = "invokeSuspend")
public final class DiffUpdateManager$startBackupDownloader$3$onSuccess$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileMd5;
    final /* synthetic */ Ref.IntRef $retryCount;
    int label;
    final /* synthetic */ DiffUpdateManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffUpdateManager$startBackupDownloader$3$onSuccess$2(DiffUpdateManager diffUpdateManager, Ref.IntRef intRef, String str, Continuation<? super DiffUpdateManager$startBackupDownloader$3$onSuccess$2> continuation) {
        super(2, continuation);
        this.this$0 = diffUpdateManager;
        this.$retryCount = intRef;
        this.$fileMd5 = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiffUpdateManager$startBackupDownloader$3$onSuccess$2(this.this$0, this.$retryCount, this.$fileMd5, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DiffUpdateManager$startBackupDownloader$3$onSuccess$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            long jIntValue = ((long) this.this$0.f53012l[kotlin.ranges.a.g(this.$retryCount.element, this.this$0.f53012l.length - 1)].intValue()) * 1000;
            this.label = 1;
            if (r0.a(jIntValue, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        DiffUpdateManager.v(this.this$0, "startUpdate: restart download intact package " + this.$retryCount.element + ",errorSimpleMsg:verify md5 failed, cur md5:" + this.$fileMd5, 0, 2, null);
        Ref.IntRef intRef = this.$retryCount;
        intRef.element = intRef.element + 1;
        com.transsion.lib.diffupdate.download.a aVar = this.this$0.f53011k;
        if (aVar != null) {
            aVar.a();
        }
        com.transsion.lib.diffupdate.download.a aVar2 = this.this$0.f53011k;
        if (aVar2 != null) {
            aVar2.start();
        }
        return Unit.f68710a;
    }
}
