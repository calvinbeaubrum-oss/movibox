package com.transsion.search.speech;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import com.permissionx.guolindev.PermissionX;
import com.tn.lib.widget.R$color;
import com.transsion.search.R$drawable;
import com.transsion.search.R$mipmap;
import com.transsion.search.R$string;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class SpeechRecognizerView extends AppCompatImageView implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super String, Unit> f57655a;

    /* JADX INFO: renamed from: com.transsion.search.speech.SpeechRecognizerView$onClick$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        public static final void c(SpeechRecognizerView this$0, com.permissionx.guolindev.request.d scope, List deniedList, boolean z11, boolean z12) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(scope, "scope");
            Intrinsics.g(deniedList, "deniedList");
            if (z11) {
                if (z12) {
                    scope.c(deniedList, new co.a(null, this$0.getResources().getString(R$string.search_sr_permission_tip), this$0.getResources().getString(R$string.search_sr_permission_setting), Integer.valueOf(R$mipmap.sr_icon_active), Integer.valueOf(R$color.white_20), 1, null));
                } else {
                    scope.b(deniedList);
                }
            }
        }

        public static final void d(SpeechRecognizerView this$0, AppCompatActivity it, boolean z11, List grantedList, List deniedList) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(it, "$it");
            Intrinsics.g(grantedList, "grantedList");
            Intrinsics.g(deniedList, "deniedList");
            d.f57673a.a(this$0.getClassTag() + " --> allGranted = " + z11);
            if (z11) {
                SpeechRecognizerDialog speechRecognizerDialogH0 = new SpeechRecognizerDialog().H0(this$0.f57655a);
                FragmentManager supportFragmentManager = it.getSupportFragmentManager();
                Intrinsics.f(supportFragmentManager, "it.supportFragmentManager");
                speechRecognizerDialogH0.show(supportFragmentManager, "SpeechRecognizerDialog");
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            m.f57684a.b();
            Context context = SpeechRecognizerView.this.getContext();
            Unit unit = null;
            final AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
            if (appCompatActivity != null) {
                final SpeechRecognizerView speechRecognizerView = SpeechRecognizerView.this;
                PermissionX.f48641a.d(appCompatActivity).b("android.permission.RECORD_AUDIO").a().c(new ao.b() { // from class: com.transsion.search.speech.j
                    @Override // ao.b
                    public final void a(com.permissionx.guolindev.request.d dVar, List list, boolean z11, boolean z12) {
                        SpeechRecognizerView.AnonymousClass1.c(speechRecognizerView, dVar, list, z11, z12);
                    }
                }).b(new ao.c() { // from class: com.transsion.search.speech.k
                    @Override // ao.c
                    public final void a(boolean z11, List list, List list2) {
                        SpeechRecognizerView.AnonymousClass1.d(speechRecognizerView, appCompatActivity, z11, list, list2);
                    }
                });
                unit = Unit.f68710a;
            }
            if (unit == null) {
                SpeechRecognizerView speechRecognizerView2 = SpeechRecognizerView.this;
                d.f57673a.a(speechRecognizerView2.getClassTag() + " --> context as? AppCompatActivity == null");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SpeechRecognizerView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpeechRecognizerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        setOnClickListener(this);
        setBackgroundResource(R$drawable.sr_icon_microphone);
    }

    public /* synthetic */ SpeechRecognizerView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = SpeechRecognizerView.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setCallback$default(SpeechRecognizerView speechRecognizerView, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = null;
        }
        speechRecognizerView.setCallback(function1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.transsion.baseui.util.d.a(1000L, new AnonymousClass1());
    }

    public final void setCallback(Function1<? super String, Unit> function1) {
        this.f57655a = function1;
    }
}
