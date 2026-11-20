package com.tn.tranpay.activity;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.tranpay.R$color;
import hq.b;
import hq.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n6.a;

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
public abstract class BaseActivity<T extends a> extends AppCompatActivity implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f50062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f50063b = "CommonInfo";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f50064c = LazyKt__LazyJVMKt.b(new Function0<c>(this) { // from class: com.tn.tranpay.activity.BaseActivity$logViewConfig$2
        final /* synthetic */ BaseActivity<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c invoke() {
            return this.this$0.R();
        }
    });

    public static /* synthetic */ void M(BaseActivity baseActivity, String str, Activity activity, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loggerPause");
        }
        if ((i11 & 1) != 0) {
            str = baseActivity.f50063b;
        }
        baseActivity.L(str, activity);
    }

    public static /* synthetic */ void Q(BaseActivity baseActivity, String str, Activity activity, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loggerResume");
        }
        if ((i11 & 1) != 0) {
            str = baseActivity.f50063b;
        }
        baseActivity.O(str, activity);
    }

    public final void L(String str, Activity activity) {
        fq.a.f65215a.f(str, activity.getLocalClassName() + " onPause");
    }

    public final void O(String str, Activity activity) {
        fq.a.f65215a.f(str, activity.getLocalClassName() + " onResume");
    }

    public c R() {
        return b.a.a(this);
    }

    @Override // hq.b
    public c getLogViewConfig() {
        return (c) this.f50064c.getValue();
    }

    public abstract T getViewBinding();

    public void initView(Bundle bundle) {
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return true;
    }

    public boolean isTranslucent() {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMViewBinding(getViewBinding());
        initView(bundle);
        setStatusBar();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b.a.b(this);
        M(this, null, this, 1, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b.a.c(this);
        Q(this, null, this, 1, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public boolean setImmersionStatusBar() {
        return true;
    }

    public final void setMViewBinding(T t11) {
        Intrinsics.g(t11, "<set-?>");
        this.f50062a = t11;
    }

    public void setStatusBar() {
        if (setImmersionStatusBar()) {
            ImmersionBar immersionBarFullScreen = ImmersionBar.with(this).fullScreen(true);
            if (isChangeStatusBar()) {
                immersionBarFullScreen.statusBarColor(statusColor());
            }
            immersionBarFullScreen.hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR);
            if (isTranslucent()) {
                immersionBarFullScreen.statusBarAlpha(0.0f);
            } else {
                immersionBarFullScreen.statusBarAlpha(1.0f);
            }
            if (isStatusDark()) {
                immersionBarFullScreen.statusBarDarkFont(true);
            }
            immersionBarFullScreen.init();
        }
    }

    public int statusColor() {
        return R$color.white;
    }
}
