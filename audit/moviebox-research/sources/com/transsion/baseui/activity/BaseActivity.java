package com.transsion.baseui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.locale.LocaleManager;
import com.transsion.baselib.report.e;
import com.transsion.baselib.report.h;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import com.transsion.room.api.IFloatingApi;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class BaseActivity<T extends n6.a> extends BaseMusicFloatActivity<T> implements e {
    public static final int $stable = 8;
    private float downY;
    private final Lazy logViewConfig$delegate = LazyKt__LazyJVMKt.b(new Function0<h>(this) { // from class: com.transsion.baseui.activity.BaseActivity$logViewConfig$2
        final /* synthetic */ BaseActivity<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final h invoke() {
            return this.this$0.newLogViewConfig();
        }
    });
    private float moveY;

    public static /* synthetic */ void changeStatusFontColor$default(BaseActivity baseActivity, boolean z11, boolean z12, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeStatusFontColor");
        }
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        baseActivity.changeStatusFontColor(z11, z12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getEmptyView$lambda$5$lambda$4(BaseActivity this$0, DefaultView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.retryLoadData();
        this_apply.setVisibility(8);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Unit unit;
        if (context != null) {
            LocaleManager.b bVar = LocaleManager.f51198f;
            super.attachBaseContext(bVar.k(context, bVar.e().i()));
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.attachBaseContext(context);
        }
    }

    public void changeStatusFontColor(boolean z11, boolean z12) {
        ImmersionBar immersionBarWith = ImmersionBar.with(this);
        boolean z13 = false;
        if (!z11 && !o.f51321a.a()) {
            z13 = true;
        }
        immersionBarWith.statusBarDarkFont(z13);
        immersionBarWith.init();
    }

    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            this.downY = motionEvent.getRawY();
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            float rawY = motionEvent.getRawY();
            this.moveY = rawY;
            if (Math.abs(rawY - this.downY) > 50.0f) {
                ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).X();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final View getEmptyView(Context context, boolean z11) {
        Intrinsics.g(context, "context");
        final DefaultView defaultView = new DefaultView(context);
        defaultView.setDefaultImageViewVisibility(0);
        if (z11) {
            defaultView.setDefaultImage(R$mipmap.ic_no_network);
            String string = context.getString(R$string.no_network_toast);
            Intrinsics.f(string, "context.getString(com.tn….string.no_network_toast)");
            defaultView.setDescText(string);
        } else {
            defaultView.setDefaultImage(R$mipmap.ic_no_content);
            String string2 = context.getString(R$string.no_content);
            Intrinsics.f(string2, "context.getString(com.tn…dget.R.string.no_content)");
            defaultView.setDescText(string2);
        }
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string3 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.f(string3, "context.getString(com.tr…seui.R.string.retry_text)");
        defaultView.setBtnText(string3);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.activity.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseActivity.getEmptyView$lambda$5$lambda$4(this.f51335a, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    @Override // com.transsion.baselib.report.e
    public h getLogViewConfig() {
        return (h) this.logViewConfig$delegate.getValue();
    }

    public void initView(Bundle bundle) {
    }

    public boolean isAttach() {
        return true;
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

    public h newLogViewConfig() {
        return e.a.a(this);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStatusBar();
        initView(bundle);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        e.a.b(this);
    }

    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e.a.c(this);
        if (isAttach()) {
            ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).r0(new WeakReference<>(this));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).W0(new WeakReference<>(this));
    }

    public void retryLoadData() {
    }

    public boolean setImmersionStatusBar() {
        return true;
    }

    public void setStatusBar() {
        if (setImmersionStatusBar()) {
            ImmersionBar immersionBarWith = ImmersionBar.with(this);
            if (isChangeStatusBar()) {
                immersionBarWith.statusBarColor(statusColor());
            }
            if (isTranslucent()) {
                immersionBarWith.statusBarAlpha(0.0f);
            } else {
                immersionBarWith.statusBarAlpha(1.0f);
            }
            if (isStatusDark()) {
                immersionBarWith.statusBarDarkFont(true);
            }
            immersionBarWith.init();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public void setView() {
        setContentView(R$layout.base_layout_with_no_network);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.llRootView);
        if (frameLayout != null) {
            frameLayout.addView(getMViewBinding().getRoot());
        }
    }

    public int statusColor() {
        return R$color.bg_01;
    }
}
