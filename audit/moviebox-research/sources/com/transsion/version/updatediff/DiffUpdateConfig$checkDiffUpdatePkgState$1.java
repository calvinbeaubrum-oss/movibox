package com.transsion.version.updatediff;

import com.blankj.utilcode.util.Utils;
import com.transsion.lib.diffupdate.download.DownloadEncryptKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.version.updatediff.DiffUpdateConfig$checkDiffUpdatePkgState$1", f = "DiffUpdateConfig.kt", l = {124}, m = "invokeSuspend")
public final class DiffUpdateConfig$checkDiffUpdatePkgState$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $resCall;
    int label;

    /* JADX INFO: renamed from: com.transsion.version.updatediff.DiffUpdateConfig$checkDiffUpdatePkgState$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.version.updatediff.DiffUpdateConfig$checkDiffUpdatePkgState$1$2", f = "DiffUpdateConfig.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $newTag;
        final /* synthetic */ Function1<Boolean, Unit> $resCall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super Boolean, Unit> function1, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$resCall = function1;
            this.$newTag = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$resCall, this.$newTag, continuation);
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
            this.$resCall.invoke(Boxing.a(this.$newTag.element));
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DiffUpdateConfig$checkDiffUpdatePkgState$1(Function1<? super Boolean, Unit> function1, Continuation<? super DiffUpdateConfig$checkDiffUpdatePkgState$1> continuation) {
        super(2, continuation);
        this.$resCall = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiffUpdateConfig$checkDiffUpdatePkgState$1(this.$resCall, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DiffUpdateConfig$checkDiffUpdatePkgState$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            DiffUpdateConfig diffUpdateConfig = DiffUpdateConfig.f59770a;
            String strF = diffUpdateConfig.f();
            if (strF != null) {
                File file = new File(strF);
                if (strF.length() <= 0 || !file.exists()) {
                    diffUpdateConfig.a("");
                    booleanRef.element = false;
                } else if (Intrinsics.b(DownloadEncryptKt.a(file), DownloadEncryptKt.a(new File(Utils.a().getPackageResourcePath())))) {
                    String absolutePath = file.getAbsolutePath();
                    File parentFile = file.getParentFile();
                    String absolutePath2 = parentFile != null ? parentFile.getAbsolutePath() : null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("checkDiffUpdatePkgState: ");
                    sb2.append(absolutePath);
                    sb2.append(", - ");
                    sb2.append(absolutePath2);
                    File parentFile2 = file.getParentFile();
                    if (parentFile2 != null) {
                        Intrinsics.f(parentFile2, "parentFile");
                        Boxing.a(FilesKt__UtilsKt.s(parentFile2));
                    }
                    c.f59779a.f();
                    diffUpdateConfig.a("");
                    booleanRef.element = false;
                } else {
                    booleanRef.element = true;
                }
            }
            a2 a2VarC = w0.c();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$resCall, booleanRef, null);
            this.label = 1;
            if (h.g(a2VarC, anonymousClass2, this) == objE) {
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
