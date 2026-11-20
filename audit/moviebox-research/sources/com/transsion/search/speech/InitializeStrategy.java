package com.transsion.search.speech;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class InitializeStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f57643c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f57644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57645b = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.search.speech.InitializeStrategy$mHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void j(InitializeStrategy this$0) {
        Intrinsics.g(this$0, "this$0");
        RoomAppMMKV.f51271a.a().putString("initialize_strategy", "initialize_two");
        d.f57673a.a(this$0.b() + " --> startListening() --> 标记当前不支持第一种策略 --> 回调给场景重新加载对象");
        Function0<Unit> function0 = this$0.f57644a;
        if (function0 != null) {
            function0.invoke();
        }
        m.f57684a.f();
    }

    public final String b() {
        String simpleName = InitializeStrategy.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Handler c() {
        return (Handler) this.f57645b.getValue();
    }

    public final SpeechRecognizer d(Context context) {
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        if (TextUtils.isEmpty(roomAppMMKV.a().getString("initialize_one_affirm", ""))) {
            if (TextUtils.equals("TECNO AC8", Build.MODEL)) {
                return f(context);
            }
            String string = roomAppMMKV.a().getString("initialize_strategy", "initialize_one");
            if (!Intrinsics.b(string, "initialize_one") && Intrinsics.b(string, "initialize_two")) {
                return f(context);
            }
            return e(context);
        }
        d.f57673a.a(b() + " --> getSpeechRecognizer() --> 确定了支持第一种策略，直接返回");
        return e(context);
    }

    public final SpeechRecognizer e(Context context) {
        d.f57673a.a(b() + " --> getSpeechRecognizerOneParameterStrategy() --> deviceModel = " + Build.MODEL + " --> 采用第一种策略");
        return SpeechRecognizer.createSpeechRecognizer(context);
    }

    public final SpeechRecognizer f(Context context) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            d dVar = d.f57673a;
            String strB = b();
            String str = Build.MODEL;
            dVar.a(strB + " --> deviceModel = " + str + " --> 采用第二种策略");
            List<ResolveInfo> listQueryIntentServices = Utils.a().getPackageManager().queryIntentServices(new Intent("android.speech.RecognitionService"), 0);
            Intrinsics.f(listQueryIntentServices, "getApp().packageManager.…TERFACE), 0\n            )");
            ResolveInfo resolveInfo = listQueryIntentServices.get(0);
            dVar.a(b() + " --> getSpeechRecognizerTwoParameterStrategy() --> packageName = " + resolveInfo.serviceInfo.packageName + " --> name = info.serviceInfo.name --> info = " + resolveInfo + " --> deviceModel = " + str);
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            objM163constructorimpl = Result.m163constructorimpl(SpeechRecognizer.createSpeechRecognizer(context, new ComponentName(serviceInfo.packageName, serviceInfo.name)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = null;
        }
        return (SpeechRecognizer) objM163constructorimpl;
    }

    public final void g() {
        c().removeCallbacksAndMessages(null);
        d.f57673a.a(b() + " --> onReadyForSpeech() --> 当前策略起作用了");
        RoomAppMMKV.f51271a.a().putString("initialize_strategy_affirm", "initialize_one_affirm");
    }

    public final void h(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f57644a = callback;
    }

    public final void i() {
        if (TextUtils.equals(RoomAppMMKV.f51271a.a().getString("initialize_strategy", "initialize_one"), "initialize_two")) {
            d.f57673a.a(b() + " --> startListening() --> 当前策略已经是第二种策略了");
            return;
        }
        c().removeCallbacksAndMessages(null);
        c().postDelayed(new Runnable() { // from class: com.transsion.search.speech.a
            @Override // java.lang.Runnable
            public final void run() {
                InitializeStrategy.j(this.f57670a);
            }
        }, 3000L);
        d.f57673a.a(b() + " --> startListening() --> 开启倒计时");
    }
}
