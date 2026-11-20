package com.transsion.push.notification;

import android.graphics.Bitmap;
import com.google.logging.type.LogSeverity;
import com.transsion.push.bean.ToolbarNoticeItem;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.push.notification.ToolbarNotificationUtils$loadImages$1", f = "ToolbarNotificationUtils.kt", l = {299, LogSeverity.NOTICE_VALUE}, m = "invokeSuspend")
public final class ToolbarNotificationUtils$loadImages$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Bitmap, Bitmap, Unit> $callback;
    final /* synthetic */ Pair<ToolbarNoticeItem, ToolbarNoticeItem> $pair;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ToolbarNotificationUtils$loadImages$1(Function2<? super Bitmap, ? super Bitmap, Unit> function2, Pair<ToolbarNoticeItem, ToolbarNoticeItem> pair, Continuation<? super ToolbarNotificationUtils$loadImages$1> continuation) {
        super(2, continuation);
        this.$callback = function2;
        this.$pair = pair;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ToolbarNotificationUtils$loadImages$1 toolbarNotificationUtils$loadImages$1 = new ToolbarNotificationUtils$loadImages$1(this.$callback, this.$pair, continuation);
        toolbarNotificationUtils$loadImages$1.L$0 = obj;
        return toolbarNotificationUtils$loadImages$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ToolbarNotificationUtils$loadImages$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        o0 o0Var;
        Bitmap bitmap;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    o0Var = (o0) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bitmap = (Bitmap) this.L$0;
                    ResultKt.b(obj);
                }
                this.$callback.invoke(bitmap, (Bitmap) obj);
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            k0 k0Var = (k0) this.L$0;
            o0 o0VarB = j.b(k0Var, w0.b(), null, new ToolbarNotificationUtils$loadImages$1$image1Deferred$1(this.$pair, null), 2, null);
            o0 o0VarB2 = j.b(k0Var, w0.b(), null, new ToolbarNotificationUtils$loadImages$1$image2Deferred$1(this.$pair, null), 2, null);
            this.L$0 = o0VarB2;
            this.label = 1;
            Object objC = o0VarB.c(this);
            if (objC == objE) {
                return objE;
            }
            o0Var = o0VarB2;
            obj = objC;
            Bitmap bitmap2 = (Bitmap) obj;
            this.L$0 = bitmap2;
            this.label = 2;
            Object objC2 = o0Var.c(this);
            if (objC2 == objE) {
                return objE;
            }
            bitmap = bitmap2;
            obj = objC2;
            this.$callback.invoke(bitmap, (Bitmap) obj);
            return Unit.f68710a;
        } catch (TimeoutCancellationException unused) {
            this.$callback.invoke(null, null);
        }
    }
}
