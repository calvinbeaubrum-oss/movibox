package com.transsion.search.speech;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.wrapperad.R$color;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class SpeechRecognizerDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InitializeStrategy f57646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f57647d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public bx.b f57648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super String, Unit> f57649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SpeechRecognizer f57650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f57651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f57652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.transsion.baselib.report.h f57653k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements RecognitionListener {
        public a() {
        }

        @Override // android.speech.RecognitionListener
        public void onBeginningOfSpeech() {
            d.f57673a.a(SpeechRecognizerDialog.this.g0() + " --> onBeginningOfSpeech() --> 当开始说话时调用");
        }

        @Override // android.speech.RecognitionListener
        public void onBufferReceived(byte[] bArr) {
            d.f57673a.a(SpeechRecognizerDialog.this.g0() + " --> onBufferReceived() --> 当接收到音频数据时调用");
        }

        @Override // android.speech.RecognitionListener
        public void onEndOfSpeech() {
            d.f57673a.a(SpeechRecognizerDialog.this.g0() + " --> onEndOfSpeech() --> 当说话结束时调用");
        }

        @Override // android.speech.RecognitionListener
        public void onError(int i11) {
            SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
            if (!TextUtils.isEmpty(SpeechRecognizerDialog.this.f57647d)) {
                SpeechRecognizerDialog speechRecognizerDialog = SpeechRecognizerDialog.this;
                speechRecognizerDialog.F0(speechRecognizerDialog.f57647d);
                return;
            }
            SpeechRecognizerDialog.this.G0();
            c cVar = c.f57672a;
            String strA = cVar.a(i11);
            d.f57673a.a(SpeechRecognizerDialog.this.g0() + " --> onError() --> 当发生错误时调用 --> error = " + i11 + " -- msg = " + strA);
            SpeechRecognizerDialog.this.O0(strA, true);
            if (SpeechRecognizerDialog.this.f57651i) {
                m.f57684a.c(cVar.a(16), 16);
            } else {
                m.f57684a.c(strA, i11);
            }
            bx.b bVar = SpeechRecognizerDialog.this.f57648f;
            if (bVar != null && (speechRecognizerVolumeCircleView = bVar.f14443h) != null) {
                speechRecognizerVolumeCircleView.setMicState(SpeechRecognizerVolumeCircleView.MicState.NORMAL);
            }
            bx.b bVar2 = SpeechRecognizerDialog.this.f57648f;
            AppCompatTextView appCompatTextView = bVar2 != null ? bVar2.f14441f : null;
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setText(Utils.a().getResources().getString(R$string.search_sr_tap_microphone_try_again));
        }

        @Override // android.speech.RecognitionListener
        public void onEvent(int i11, Bundle bundle) {
            d.f57673a.a(SpeechRecognizerDialog.this.g0() + " --> onEvent() --> 当发生其他事件时调用 --> eventType = " + i11 + " --> params = " + bundle);
        }

        @Override // android.speech.RecognitionListener
        public void onPartialResults(Bundle bundle) {
            ArrayList<String> stringArrayList;
            if (bundle == null || (stringArrayList = bundle.getStringArrayList("results_recognition")) == null) {
                return;
            }
            SpeechRecognizerDialog speechRecognizerDialog = SpeechRecognizerDialog.this;
            if (!stringArrayList.isEmpty()) {
                speechRecognizerDialog.f57647d = stringArrayList.get(0);
                String str = stringArrayList.get(0);
                Intrinsics.f(str, "it[0]");
                SpeechRecognizerDialog.P0(speechRecognizerDialog, str, false, 2, null);
            }
            SpeechRecognizerDialog.M0(speechRecognizerDialog, 0L, 1, null);
        }

        @Override // android.speech.RecognitionListener
        public void onReadyForSpeech(Bundle bundle) {
            d.f57673a.a(SpeechRecognizerDialog.this.g0() + " --> onReadyForSpeech() --> 当语音识别准备好时调用 --> params = " + bundle);
            m.f57684a.d();
            InitializeStrategy initializeStrategy = SpeechRecognizerDialog.this.f57646c;
            if (initializeStrategy != null) {
                initializeStrategy.g();
            }
        }

        @Override // android.speech.RecognitionListener
        public void onResults(Bundle bundle) {
            ArrayList<String> stringArrayList;
            if (bundle == null || (stringArrayList = bundle.getStringArrayList("results_recognition")) == null) {
                return;
            }
            SpeechRecognizerDialog speechRecognizerDialog = SpeechRecognizerDialog.this;
            if (!stringArrayList.isEmpty()) {
                String resultStr = stringArrayList.get(0);
                Intrinsics.f(resultStr, "resultStr");
                SpeechRecognizerDialog.P0(speechRecognizerDialog, resultStr, false, 2, null);
                d.f57673a.a(speechRecognizerDialog.g0() + " --> onResults() --> 当获得语音识别结果时调用 = " + resultStr);
                speechRecognizerDialog.F0(resultStr);
            }
        }

        @Override // android.speech.RecognitionListener
        public void onRmsChanged(float f11) {
        }
    }

    public SpeechRecognizerDialog() {
        super(R$layout.dialog_speech_recognizer_layout);
        this.f57647d = "";
        this.f57652j = new Handler(Looper.getMainLooper());
        this.f57653k = new com.transsion.baselib.report.h("sr_dialog", false, 2, null);
    }

    private final int C0() {
        int i11 = Utils.a().getResources().getDisplayMetrics().heightPixels;
        return i11 - (i11 / 3);
    }

    public static final void E0(SpeechRecognizerDialog this$0, SpeechRecognizerVolumeCircleView it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "$it");
        InitializeStrategy initializeStrategy = this$0.f57646c;
        if (initializeStrategy != null) {
            initializeStrategy.i();
        }
        it.performClick();
    }

    private final void I0() {
        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
        AppCompatImageView appCompatImageView;
        bx.b bVar = this.f57648f;
        if (bVar != null && (appCompatImageView = bVar.f14438b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.speech.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpeechRecognizerDialog.J0(this.f57677a, view);
                }
            });
        }
        bx.b bVar2 = this.f57648f;
        if (bVar2 == null || (speechRecognizerVolumeCircleView = bVar2.f14443h) == null) {
            return;
        }
        speechRecognizerVolumeCircleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.speech.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeechRecognizerDialog.K0(this.f57678a, view);
            }
        });
    }

    public static final void J0(SpeechRecognizerDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        m.f57684a.a();
        this$0.dismissAllowingStateLoss();
    }

    public static final void K0(SpeechRecognizerDialog this$0, View view) {
        Unit unit;
        Intrinsics.g(this$0, "this$0");
        if (this$0.f57651i) {
            SpeechRecognizer speechRecognizer = this$0.f57650h;
            if (speechRecognizer != null) {
                speechRecognizer.stopListening();
            }
            this$0.G0();
        } else {
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault().toLanguageTag());
            intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
            try {
                Result.Companion companion = Result.Companion;
                SpeechRecognizer speechRecognizer2 = this$0.f57650h;
                if (speechRecognizer2 != null) {
                    speechRecognizer2.startListening(intent);
                    unit = Unit.f68710a;
                } else {
                    unit = null;
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            M0(this$0, 0L, 1, null);
            this$0.initView();
        }
        this$0.f57651i = !this$0.f57651i;
    }

    public static /* synthetic */ void M0(SpeechRecognizerDialog speechRecognizerDialog, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = 5000;
        }
        speechRecognizerDialog.L0(j11);
    }

    public static final void N0(SpeechRecognizerDialog this$0) {
        Intrinsics.g(this$0, "this$0");
        SpeechRecognizer speechRecognizer = this$0.f57650h;
        if (speechRecognizer != null) {
            speechRecognizer.stopListening();
        }
        d.f57673a.a(this$0.g0() + " --> setSpeechTimeout() --> 语音识别超时");
    }

    public static /* synthetic */ void P0(SpeechRecognizerDialog speechRecognizerDialog, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        speechRecognizerDialog.O0(str, z11);
    }

    private final void initView() {
        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView2;
        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView3;
        String string = Utils.a().getResources().getString(R$string.search_sr_speak_now);
        Intrinsics.f(string, "getApp().resources.getSt…ring.search_sr_speak_now)");
        O0(string, false);
        bx.b bVar = this.f57648f;
        if (bVar != null && (speechRecognizerVolumeCircleView3 = bVar.f14443h) != null) {
            speechRecognizerVolumeCircleView3.setMicState(SpeechRecognizerVolumeCircleView.MicState.ACTIVE);
        }
        bx.b bVar2 = this.f57648f;
        AppCompatTextView appCompatTextView = bVar2 != null ? bVar2.f14441f : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(Utils.a().getResources().getString(R$string.search_sr_tap_try_tip_avatar));
        }
        bx.b bVar3 = this.f57648f;
        if (bVar3 != null && (speechRecognizerVolumeCircleView2 = bVar3.f14443h) != null) {
            speechRecognizerVolumeCircleView2.setActiveCircleColor(Utils.a().getResources().getColor(R$color.white_40));
        }
        bx.b bVar4 = this.f57648f;
        if (bVar4 == null || (speechRecognizerVolumeCircleView = bVar4.f14443h) == null) {
            return;
        }
        speechRecognizerVolumeCircleView.setLoadingGradientColors(new int[]{Color.parseColor("#2166E5"), Color.parseColor("#1DD171")});
    }

    public final void D0() {
        final SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            SpeechRecognizer speechRecognizer = this.f57650h;
            if (speechRecognizer != null) {
                speechRecognizer.cancel();
            }
            SpeechRecognizer speechRecognizer2 = this.f57650h;
            if (speechRecognizer2 != null) {
                speechRecognizer2.destroy();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        InitializeStrategy initializeStrategy = this.f57646c;
        SpeechRecognizer speechRecognizerD = initializeStrategy != null ? initializeStrategy.d(getContext()) : null;
        this.f57650h = speechRecognizerD;
        if (speechRecognizerD != null) {
            speechRecognizerD.setRecognitionListener(new a());
        }
        bx.b bVar = this.f57648f;
        if (bVar == null || (speechRecognizerVolumeCircleView = bVar.f14443h) == null) {
            return;
        }
        speechRecognizerVolumeCircleView.post(new Runnable() { // from class: com.transsion.search.speech.f
            @Override // java.lang.Runnable
            public final void run() {
                SpeechRecognizerDialog.E0(this.f57675a, speechRecognizerVolumeCircleView);
            }
        });
    }

    public final void F0(String str) {
        m.f57684a.e();
        kotlinx.coroutines.j.d(v.a(this), null, null, new SpeechRecognizerDialog$onResult$1(this, str, null), 3, null);
    }

    public final void G0() {
        this.f57652j.removeCallbacksAndMessages(null);
    }

    public final SpeechRecognizerDialog H0(Function1<? super String, Unit> function1) {
        this.f57649g = function1;
        return this;
    }

    public final void L0(long j11) {
        G0();
        this.f57652j.postDelayed(new Runnable() { // from class: com.transsion.search.speech.i
            @Override // java.lang.Runnable
            public final void run() {
                SpeechRecognizerDialog.N0(this.f57679a);
            }
        }, j11);
    }

    public final void O0(String str, boolean z11) {
        if (z11) {
            this.f57651i = false;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bx.b bVar = this.f57648f;
        AppCompatTextView appCompatTextView = bVar != null ? bVar.f14440d : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(str);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, com.transsion.baselib.report.e
    public com.transsion.baselib.report.h getLogViewConfig() {
        return this.f57653k;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
        d.f57673a.a(g0() + " --> onCreate() --> 展示弹窗组件");
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Unit unit;
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        try {
            Result.Companion companion = Result.Companion;
            SpeechRecognizer speechRecognizer = this.f57650h;
            if (speechRecognizer != null) {
                speechRecognizer.destroy();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        Function1<? super String, Unit> function1 = this.f57649g;
        if (function1 != null) {
            function1.invoke(null);
        }
        this.f57649g = null;
        d.f57673a.a(g0() + " --> onDismiss() --> 语音识别弹窗关闭 释放资源");
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SpeechRecognizer speechRecognizer = this.f57650h;
        if (speechRecognizer != null) {
            speechRecognizer.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(80);
            window.setDimAmount(0.5f);
            window.setBackgroundDrawable(null);
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
            window.setLayout(-1, -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.height = C0();
        }
        this.f57648f = bx.b.a(view);
        initView();
        I0();
        InitializeStrategy initializeStrategy = new InitializeStrategy();
        this.f57646c = initializeStrategy;
        initializeStrategy.h(new Function0<Unit>() { // from class: com.transsion.search.speech.SpeechRecognizerDialog.onViewCreated.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SpeechRecognizerDialog.this.f57651i = false;
                d.f57673a.a(SpeechRecognizerDialog.this.g0() + " --> onViewCreated() --> setCallback{} --> 重新获取语音识别对象 --> initSpeechRecognizer()");
                SpeechRecognizerDialog.this.D0();
            }
        });
        D0();
        d.f57673a.b(g0() + " --> onViewCreated() --> 语音识别是否可用 = " + e.f57674a.a());
    }
}
