package com.transsion.startup.pref.al;

import com.transsion.lib.diffupdate.c;
import com.transsion.lib.diffupdate.download.DownloadEncryptKt;
import com.transsion.version.updatediff.DiffUpdateConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import okhttp3.internal.ws.WebSocketProtocol;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.startup.pref.al.UpdateUtils$startCheckDiffUpdate$1$1$blockUpdate$1", f = "UpdateUtils.kt", l = {WebSocketProtocol.PAYLOAD_SHORT}, m = "invokeSuspend")
public final class UpdateUtils$startCheckDiffUpdate$1$1$blockUpdate$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $checkCall;
    final /* synthetic */ c $remoteVersionInfo;
    int label;

    /* JADX INFO: renamed from: com.transsion.startup.pref.al.UpdateUtils$startCheckDiffUpdate$1$1$blockUpdate$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.startup.pref.al.UpdateUtils$startCheckDiffUpdate$1$1$blockUpdate$1$1", f = "UpdateUtils.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $checkCall;
        final /* synthetic */ boolean $res;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Boolean, Unit> function1, boolean z11, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$checkCall = function1;
            this.$res = z11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$checkCall, this.$res, continuation);
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
            this.$checkCall.invoke(Boxing.a(this.$res));
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UpdateUtils$startCheckDiffUpdate$1$1$blockUpdate$1(c cVar, Function1<? super Boolean, Unit> function1, Continuation<? super UpdateUtils$startCheckDiffUpdate$1$1$blockUpdate$1> continuation) {
        super(2, continuation);
        this.$remoteVersionInfo = cVar;
        this.$checkCall = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateUtils$startCheckDiffUpdate$1$1$blockUpdate$1(this.$remoteVersionInfo, this.$checkCall, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((UpdateUtils$startCheckDiffUpdate$1$1$blockUpdate$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DiffUpdateConfig diffUpdateConfig = DiffUpdateConfig.f59770a;
            String strF = diffUpdateConfig.f();
            boolean zB = false;
            if (strF != null && strF.length() != 0) {
                if (new File(strF).exists()) {
                    zB = Intrinsics.b(this.$remoteVersionInfo.b(), DownloadEncryptKt.a(new File(strF)));
                } else {
                    diffUpdateConfig.a("");
                }
            }
            a2 a2VarC = w0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$checkCall, zB, null);
            this.label = 1;
            if (h.g(a2VarC, anonymousClass1, this) == objE) {
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
