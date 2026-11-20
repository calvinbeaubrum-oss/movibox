package com.transsion.lib.diffupdate;

import com.transsion.lib.diffupdate.bsdiff.BsDiffLib;
import com.transsion.lib.diffupdate.download.DownloadEncryptKt;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.lib.diffupdate.DiffUpdateManager$applyPatch$1", f = "DiffUpdateManager.kt", l = {298}, m = "invokeSuspend")
public final class DiffUpdateManager$applyPatch$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $patchPackageFile;
    final /* synthetic */ c $versionInfo;
    int label;
    final /* synthetic */ DiffUpdateManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffUpdateManager$applyPatch$1(DiffUpdateManager diffUpdateManager, File file, c cVar, Continuation<? super DiffUpdateManager$applyPatch$1> continuation) {
        super(2, continuation);
        this.this$0 = diffUpdateManager;
        this.$patchPackageFile = file;
        this.$versionInfo = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiffUpdateManager$applyPatch$1(this.this$0, this.$patchPackageFile, this.$versionInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DiffUpdateManager$applyPatch$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            final File file = this.this$0.f53006f;
            if (file != null) {
                final DiffUpdateManager diffUpdateManager = this.this$0;
                final File file2 = this.$patchPackageFile;
                final c cVar = this.$versionInfo;
                boolean zBooleanValue = ((Boolean) gu.b.a(diffUpdateManager.f53002b, new Function0<Boolean>() { // from class: com.transsion.lib.diffupdate.DiffUpdateManager$applyPatch$1$1$success$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() throws NoSuchAlgorithmException, IOException {
                        boolean z11;
                        BsDiffLib bsDiffLib = BsDiffLib.f53024a;
                        String absolutePath = diffUpdateManager.f53007g.getAbsolutePath();
                        Intrinsics.f(absolutePath, "basePackageFile.absolutePath");
                        String absolutePath2 = file2.getAbsolutePath();
                        Intrinsics.f(absolutePath2, "patchPackageFile.absolutePath");
                        String absolutePath3 = file.getAbsolutePath();
                        Intrinsics.f(absolutePath3, "apkFile.absolutePath");
                        int iPatch = bsDiffLib.patch(absolutePath, absolutePath2, absolutePath3);
                        String strA = DownloadEncryptKt.a(file);
                        if (Intrinsics.b(strA, cVar.b()) && iPatch == 0) {
                            z11 = true;
                        } else {
                            DiffUpdateManager.v(diffUpdateManager, "applyPatch: bspatch processing and merge patch error, supervise bspatch res:" + iPatch + " and md5:" + strA, 0, 2, null);
                            z11 = false;
                        }
                        return Boolean.valueOf(z11);
                    }
                })).booleanValue();
                FilesKt__UtilsKt.s(file2);
                a2 a2VarC = w0.c();
                DiffUpdateManager$applyPatch$1$1$1 diffUpdateManager$applyPatch$1$1$1 = new DiffUpdateManager$applyPatch$1$1$1(zBooleanValue, diffUpdateManager, file, cVar, null);
                this.label = 1;
                if (h.g(a2VarC, diffUpdateManager$applyPatch$1$1$1, this) == objE) {
                    return objE;
                }
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
