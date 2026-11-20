package com.transsion.player.longvideo.ui.dialog;

import android.content.Context;
import android.view.View;
import com.transsion.player.longvideo.R$string;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$onRewardInterceptAdShowError$1", f = "LongVodPlayerViewAdHelper.kt", l = {}, m = "invokeSuspend")
public final class LongVodPlayerViewAdHelper$onRewardInterceptAdShowError$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodPlayerViewAdHelper$onRewardInterceptAdShowError$1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, Continuation<? super LongVodPlayerViewAdHelper$onRewardInterceptAdShowError$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerViewAdHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerViewAdHelper$onRewardInterceptAdShowError$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LongVodPlayerViewAdHelper$onRewardInterceptAdShowError$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        View root;
        Context context;
        View root2;
        Context context2;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String str = this.this$0.R;
        if (Intrinsics.b(str, "StreamVideoInterceptRewarded")) {
            this.this$0.T0();
            String string = null;
            if (this.this$0.A1()) {
                this.this$0.S1();
                zp.b.a aVar = zp.b.f82110a;
                mv.i iVar = this.this$0.f54536h;
                if (iVar != null && (root2 = iVar.getRoot()) != null && (context2 = root2.getContext()) != null) {
                    string = context2.getString(R$string.long_vod_reward_intercept_skip);
                }
                aVar.e(string);
            } else {
                this.this$0.Y1();
                zp.b.a aVar2 = zp.b.f82110a;
                mv.i iVar2 = this.this$0.f54536h;
                if (iVar2 != null && (root = iVar2.getRoot()) != null && (context = root.getContext()) != null) {
                    string = context.getString(com.tn.lib.widget.R$string.common_failed);
                }
                aVar2.e(string);
            }
        } else if (Intrinsics.b(str, "StreamVideoInterceptInterstitial")) {
            this.this$0.x1();
        }
        return Unit.f68710a;
    }
}
