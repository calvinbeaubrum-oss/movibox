package com.transsion.lib.diffupdate;

import com.transsion.lib.diffupdate.download.DownloadEncryptKt;
import com.transsion.lib.diffupdate.exception.CancelReason;
import com.transsion.lib.diffupdate.exception.UpdateException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.lib.diffupdate.DiffUpdateManager$startUpdate$2", f = "DiffUpdateManager.kt", l = {}, m = "invokeSuspend")
public final class DiffUpdateManager$startUpdate$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiffUpdateManager this$0;

    /* JADX INFO: renamed from: com.transsion.lib.diffupdate.DiffUpdateManager$startUpdate$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.lib.diffupdate.DiffUpdateManager$startUpdate$2$1", f = "DiffUpdateManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DiffUpdateManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DiffUpdateManager diffUpdateManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = diffUpdateManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            b bVar = this.this$0.f53014n;
            if (bVar != null) {
                bVar.d(new UpdateException(400001, "load update info error", null, 4, null));
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.lib.diffupdate.DiffUpdateManager$startUpdate$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.lib.diffupdate.DiffUpdateManager$startUpdate$2$2", f = "DiffUpdateManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ c $versionInfo;
        int label;
        final /* synthetic */ DiffUpdateManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DiffUpdateManager diffUpdateManager, c cVar, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = diffUpdateManager;
            this.$versionInfo = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$versionInfo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final b bVar = this.this$0.f53014n;
            if (bVar != null) {
                final c cVar = this.$versionInfo;
                final DiffUpdateManager diffUpdateManager = this.this$0;
                bVar.b(cVar, new Function1<Boolean, Unit>() { // from class: com.transsion.lib.diffupdate.DiffUpdateManager$startUpdate$2$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z11) {
                        if (z11) {
                            bVar.e(CancelReason.REASON_BLOCK);
                        } else {
                            diffUpdateManager.A(cVar);
                        }
                    }
                });
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffUpdateManager$startUpdate$2(DiffUpdateManager diffUpdateManager, Continuation<? super DiffUpdateManager$startUpdate$2> continuation) {
        super(2, continuation);
        this.this$0 = diffUpdateManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiffUpdateManager$startUpdate$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DiffUpdateManager$startUpdate$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        c cVarA = fu.a.f65287a.a(DownloadEncryptKt.a(this.this$0.f53007g));
        if (cVarA == null) {
            j.d(this.this$0.f53004d, w0.c(), null, new AnonymousClass1(this.this$0, null), 2, null);
        } else if (this.this$0.f53014n == null) {
            this.this$0.A(cVarA);
        } else {
            j.d(this.this$0.f53004d, w0.c(), null, new AnonymousClass2(this.this$0, cVarA, null), 2, null);
        }
        return Unit.f68710a;
    }
}
