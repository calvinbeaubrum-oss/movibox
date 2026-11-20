package com.transsion.push.notification;

import android.graphics.Bitmap;
import com.transsion.push.bean.ToolbarNoticeItem;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.push.notification.ToolbarNotificationUtils$loadImages$1$image2Deferred$1", f = "ToolbarNotificationUtils.kt", l = {296}, m = "invokeSuspend")
public final class ToolbarNotificationUtils$loadImages$1$image2Deferred$1 extends SuspendLambda implements Function2<k0, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Pair<ToolbarNoticeItem, ToolbarNoticeItem> $pair;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarNotificationUtils$loadImages$1$image2Deferred$1(Pair<ToolbarNoticeItem, ToolbarNoticeItem> pair, Continuation<? super ToolbarNotificationUtils$loadImages$1$image2Deferred$1> continuation) {
        super(2, continuation);
        this.$pair = pair;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ToolbarNotificationUtils$loadImages$1$image2Deferred$1(this.$pair, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Bitmap> continuation) {
        return ((ToolbarNotificationUtils$loadImages$1$image2Deferred$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            String cover = this.$pair.getSecond().getCover();
            if (cover == null || cover.length() == 0) {
                return null;
            }
            ToolbarNotificationUtils toolbarNotificationUtils = ToolbarNotificationUtils.f56927a;
            String cover2 = this.$pair.getSecond().getCover();
            Intrinsics.d(cover2);
            this.label = 1;
            obj = toolbarNotificationUtils.v(cover2, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return (Bitmap) obj;
    }
}
