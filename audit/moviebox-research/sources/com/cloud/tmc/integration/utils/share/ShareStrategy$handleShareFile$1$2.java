package com.cloud.tmc.integration.utils.share;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "com.cloud.tmc.integration.utils.share.ShareStrategy$handleShareFile$1$2", f = "ShareStrategy.kt", l = {92}, m = "invokeSuspend")
public final class ShareStrategy$handleShareFile$1$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $block;
    final /* synthetic */ Context $context;
    final /* synthetic */ File $file;
    final /* synthetic */ c $shareParams;
    Object L$0;
    int label;
    final /* synthetic */ ShareStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareStrategy$handleShareFile$1$2(c cVar, ShareStrategy shareStrategy, Context context, File file, Function0<Unit> function0, Continuation<? super ShareStrategy$handleShareFile$1$2> continuation) {
        super(2, continuation);
        this.$shareParams = cVar;
        this.this$0 = shareStrategy;
        this.$context = context;
        this.$file = file;
        this.$block = function0;
    }

    public static final void d(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareStrategy$handleShareFile$1$2(this.$shareParams, this.this$0, this.$context, this.$file, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShareStrategy$handleShareFile$1$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        c cVar;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            c cVar2 = this.$shareParams;
            ShareStrategy shareStrategy = this.this$0;
            Context context = this.$context;
            File file = this.$file;
            this.L$0 = cVar2;
            this.label = 1;
            Object objJ = shareStrategy.j(context, file, this);
            if (objJ == objE) {
                return objE;
            }
            cVar = cVar2;
            obj = objJ;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) this.L$0;
            ResultKt.b(obj);
        }
        cVar.l((Uri) obj);
        Handler handler = ShareStrategy.f31112b;
        final Function0<Unit> function0 = this.$block;
        handler.post(new Runnable() { // from class: com.cloud.tmc.integration.utils.share.f
            @Override // java.lang.Runnable
            public final void run() {
                ShareStrategy$handleShareFile$1$2.d(function0);
            }
        });
        return Unit.f68710a;
    }
}
