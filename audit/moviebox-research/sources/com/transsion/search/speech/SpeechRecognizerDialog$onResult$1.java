package com.transsion.search.speech;

import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.search.speech.SpeechRecognizerDialog$onResult$1", f = "SpeechRecognizerDialog.kt", l = {207}, m = "invokeSuspend")
public final class SpeechRecognizerDialog$onResult$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $resultStr;
    int label;
    final /* synthetic */ SpeechRecognizerDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeechRecognizerDialog$onResult$1(SpeechRecognizerDialog speechRecognizerDialog, String str, Continuation<? super SpeechRecognizerDialog$onResult$1> continuation) {
        super(2, continuation);
        this.this$0 = speechRecognizerDialog;
        this.$resultStr = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpeechRecognizerDialog$onResult$1(this.this$0, this.$resultStr, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SpeechRecognizerDialog$onResult$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            bx.b bVar = this.this$0.f57648f;
            if (bVar != null && (speechRecognizerVolumeCircleView = bVar.f14443h) != null) {
                speechRecognizerVolumeCircleView.setMicState(SpeechRecognizerVolumeCircleView.MicState.LOADING);
            }
            bx.b bVar2 = this.this$0.f57648f;
            AppCompatTextView appCompatTextView = bVar2 != null ? bVar2.f14441f : null;
            if (appCompatTextView != null) {
                appCompatTextView.setText("");
            }
            this.label = 1;
            if (r0.a(1500L, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Function1 function1 = this.this$0.f57649g;
        if (function1 != null) {
        }
        this.this$0.f57649g = null;
        this.this$0.dismissAllowingStateLoss();
        return Unit.f68710a;
    }
}
