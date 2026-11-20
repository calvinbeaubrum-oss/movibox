package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.w;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class k extends Dialog implements androidx.lifecycle.u, s, f6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f6.d f637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OnBackPressedDispatcher f638c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public k(Context context, int i11) {
        super(context, i11);
        Intrinsics.g(context, "context");
        this.f637b = f6.d.f64645d.a(this);
        this.f638c = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                k.d(this.f635a);
            }
        });
    }

    public /* synthetic */ k(Context context, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? 0 : i11);
    }

    public static final void d(k this$0) {
        Intrinsics.g(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.g(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    public final w b() {
        w wVar = this.f636a;
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this);
        this.f636a = wVar2;
        return wVar2;
    }

    @CallSuper
    public void c() {
        Window window = getWindow();
        Intrinsics.d(window);
        View decorView = window.getDecorView();
        Intrinsics.f(decorView, "window!!.decorView");
        ViewTreeLifecycleOwner.b(decorView, this);
        Window window2 = getWindow();
        Intrinsics.d(window2);
        View decorView2 = window2.getDecorView();
        Intrinsics.f(decorView2, "window!!.decorView");
        u.a(decorView2, this);
        Window window3 = getWindow();
        Intrinsics.d(window3);
        View decorView3 = window3.getDecorView();
        Intrinsics.f(decorView3, "window!!.decorView");
        ViewTreeSavedStateRegistryOwner.b(decorView3, this);
    }

    @Override // androidx.lifecycle.u
    public Lifecycle getLifecycle() {
        return b();
    }

    @Override // androidx.activity.s
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f638c;
    }

    @Override // f6.e
    public f6.c getSavedStateRegistry() {
        return this.f637b.b();
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onBackPressed() {
        this.f638c.l();
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f638c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            Intrinsics.f(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.o(onBackInvokedDispatcher);
        }
        this.f637b.d(bundle);
        b().i(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.f(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f637b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onStart() {
        super.onStart();
        b().i(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onStop() {
        b().i(Lifecycle.Event.ON_DESTROY);
        this.f636a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i11) {
        c();
        super.setContentView(i11);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        Intrinsics.g(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.g(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
