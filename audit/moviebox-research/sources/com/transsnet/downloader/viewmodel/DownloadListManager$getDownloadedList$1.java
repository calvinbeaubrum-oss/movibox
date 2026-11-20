package com.transsnet.downloader.viewmodel;

import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.c0;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadListManager$getDownloadedList$1", f = "DownloadListManager.kt", l = {InputDeviceCompat.SOURCE_KEYBOARD, 258}, m = "invokeSuspend")
public final class DownloadListManager$getDownloadedList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DownloadListManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadListManager$getDownloadedList$1(DownloadListManager downloadListManager, Continuation<? super DownloadListManager$getDownloadedList$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadListManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadListManager$getDownloadedList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadListManager$getDownloadedList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        c0 c0Var;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c0Var = (c0) this.L$0;
                ResultKt.b(obj);
            }
            c0Var.n(obj);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        this.label = 1;
        obj = DownloadEsHelper.w(downloadEsHelperA, false, this, 1, null);
        if (obj == objE) {
            return objE;
        }
        c0<List<DownloadBean>> c0VarU = this.this$0.u();
        DownloadListManager downloadListManager = this.this$0;
        this.L$0 = c0VarU;
        this.label = 2;
        obj = downloadListManager.m((List) obj, this);
        if (obj == objE) {
            return objE;
        }
        c0Var = c0VarU;
        c0Var.n(obj);
        return Unit.f68710a;
    }
}
