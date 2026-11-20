package com.cloud.tmc.miniapp.base;

import OooO0o0.OooO0OO;
import OooO0o0.o000000O;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.base.BaseActivity;
import id.c;
import id.d;
import id.e;
import id.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public abstract class BaseActivity extends AppCompatActivity implements id.a, d, e, f, c {
    private OooO0OO dialog;
    private int dialogCount;
    private int initDataChannel;
    private boolean mResumed;
    private Bundle savedInstance;
    private final Lazy activityCallbacks$delegate = LazyKt__LazyJVMKt.b(new Function0<SparseArray<a>>() { // from class: com.cloud.tmc.miniapp.base.BaseActivity$activityCallbacks$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SparseArray<BaseActivity.a> invoke() {
            return new SparseArray<>(1);
        }
    });
    private boolean mStarted = true;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(int i11, Intent intent);
    }

    private final SparseArray<a> getActivityCallbacks() {
        return (SparseArray) this.activityCallbacks$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSoftKeyboard$lambda$1(BaseActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.hideKeyboard(this$0.getCurrentFocus());
    }

    private final boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        if (!(view instanceof EditText) && !(view instanceof WebView)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        return motionEvent.getX() <= ((float) i11) || motionEvent.getX() >= ((float) (view.getWidth() + i11)) || motionEvent.getY() <= ((float) i12) || motionEvent.getY() >= ((float) (view.getHeight() + i12));
    }

    public static /* synthetic */ void showLoadingDialog$default(BaseActivity baseActivity, String str, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingDialog");
        }
        if ((i11 & 1) != 0) {
            str = "";
        }
        baseActivity.showLoadingDialog(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoadingDialog$lambda$0(BaseActivity this$0, String str) {
        TextView textView;
        Intrinsics.g(this$0, "this$0");
        if (this$0.dialogCount <= 0 || this$0.isFinishing() || this$0.isDestroyed()) {
            return;
        }
        if (this$0.dialog == null) {
            this$0.dialog = new o000000O(this$0).k(false).h();
        }
        if (str == null || str.length() <= 0) {
            OooO0OO oooO0OO = this$0.dialog;
            textView = oooO0OO != null ? (TextView) oooO0OO.findViewById(R$id.tv_wait_message) : null;
            if (textView != null) {
                textView.setText(this$0.getString(R$string.dialog_loading_tv));
            }
        } else {
            OooO0OO oooO0OO2 = this$0.dialog;
            textView = oooO0OO2 != null ? (TextView) oooO0OO2.findViewById(R$id.tv_wait_message) : null;
            if (textView != null) {
                textView.setText(str);
            }
        }
        OooO0OO oooO0OO3 = this$0.dialog;
        Intrinsics.d(oooO0OO3);
        if (oooO0OO3.isShowing()) {
            return;
        }
        OooO0OO oooO0OO4 = this$0.dialog;
        Intrinsics.d(oooO0OO4);
        oooO0OO4.show();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev2) {
        Intrinsics.g(ev2, "ev");
        if (ev2.getActionMasked() == 0) {
            View currentFocus = getCurrentFocus();
            if (isShouldHideInput(currentFocus, ev2)) {
                hideKeyboard(currentFocus);
            }
        }
        return super.dispatchTouchEvent(ev2);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        hideKeyboard(getCurrentFocus());
    }

    public Activity getActivity() {
        return id.a.C0709a.a(this);
    }

    public boolean getBoolean(String str) {
        return c.a.a(this, str);
    }

    @Override // id.c
    public boolean getBoolean(String str, boolean z11) {
        return c.a.b(this, str, z11);
    }

    @Override // id.c
    public Bundle getBundle() {
        return getIntent().getExtras();
    }

    public ViewGroup getContentView() {
        return (ViewGroup) findViewById(R.id.content);
    }

    @Override // id.a, id.h
    public final Context getContext() {
        return this;
    }

    public double getDouble(String str) {
        return c.a.c(this, str);
    }

    @Override // id.c
    public double getDouble(String str, double d11) {
        return c.a.d(this, str, d11);
    }

    public float getFloat(String str) {
        return c.a.e(this, str);
    }

    @Override // id.c
    public float getFloat(String str, float f11) {
        return c.a.f(this, str, f11);
    }

    public Handler getHandler() {
        return e.b.a(this);
    }

    public final int getInitDataChannel() {
        return this.initDataChannel;
    }

    public int getInt(String str) {
        return c.a.g(this, str);
    }

    @Override // id.c
    public int getInt(String str, int i11) {
        return c.a.h(this, str, i11);
    }

    public ArrayList<Integer> getIntegerArrayList(String str) {
        return c.a.i(this, str);
    }

    public abstract int getLayoutId();

    public long getLong(String str) {
        return c.a.j(this, str);
    }

    @Override // id.c
    public long getLong(String str, long j11) {
        return c.a.k(this, str, j11);
    }

    public final boolean getMResumed() {
        return this.mResumed;
    }

    public final boolean getMStarted() {
        return this.mStarted;
    }

    public <P extends Parcelable> P getParcelable(String str) {
        return (P) c.a.l(this, str);
    }

    public final Bundle getSavedInstance() {
        return this.savedInstance;
    }

    public <S extends Serializable> S getSerializable(String str) {
        return (S) c.a.m(this, str);
    }

    public String getString(String str) {
        return c.a.n(this, str);
    }

    public ArrayList<String> getStringArrayList(String str) {
        return c.a.o(this, str);
    }

    public void hideKeyboard(View view) {
        f.a.a(this, view);
    }

    public void hideLoadingDialog() {
        OooO0OO oooO0OO;
        OooO0OO oooO0OO2;
        if (isFinishing() || isDestroyed()) {
            return;
        }
        int i11 = this.dialogCount;
        if (i11 > 0) {
            this.dialogCount = i11 - 1;
        }
        if (this.dialogCount != 0 || (oooO0OO = this.dialog) == null) {
            return;
        }
        Intrinsics.d(oooO0OO);
        if (oooO0OO.isShowing() && (oooO0OO2 = this.dialog) != null) {
            oooO0OO2.dismiss();
        }
    }

    public abstract void hideStatusLoading();

    public void initActivity() {
        initLayout();
        Bundle bundle = getBundle();
        if (bundle == null || !bundle.getBoolean("enableQuickMode")) {
            showStatusLoading();
        }
        initView();
        this.initDataChannel = 0;
        initData();
    }

    public abstract void initData();

    public void initLayout() {
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            initSoftKeyboard();
            e0.b(this);
        }
    }

    public void initSoftKeyboard() {
        ViewGroup contentView = getContentView();
        if (contentView != null) {
            contentView.setOnClickListener(new View.OnClickListener() { // from class: kd.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseActivity.initSoftKeyboard$lambda$1(this.f68527a, view);
                }
            });
        }
    }

    public abstract void initView();

    public boolean isShowDialog() {
        OooO0OO oooO0OO = this.dialog;
        if (oooO0OO != null) {
            Intrinsics.d(oooO0OO);
            if (oooO0OO.isShowing()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        a aVar = getActivityCallbacks().get(i11);
        a aVar2 = aVar;
        if (aVar == null) {
            super.onActivityResult(i11, i12, intent);
            return;
        }
        if (aVar2 != null) {
            aVar2.a(i12, intent);
        }
        getActivityCallbacks().remove(i11);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.a(this, view);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.savedInstance = bundle;
        super.onCreate(bundle);
        initActivity();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        removeCallbacks();
        if (isShowDialog()) {
            hideLoadingDialog();
        }
        this.dialog = null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            this.mResumed = true;
        } catch (Throwable th2) {
            TmcLogger.g("BaseActivity", "onResume", th2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    public boolean post(Runnable runnable) {
        return e.b.b(this, runnable);
    }

    @Override // id.e
    public boolean postAtTime(Runnable runnable, long j11) {
        return e.b.c(this, runnable, j11);
    }

    public boolean postDelayed(Object obj, long j11, Runnable runnable) {
        return e.b.d(this, obj, j11, runnable);
    }

    @Override // id.e
    public boolean postDelayed(Runnable runnable, long j11) {
        return e.b.e(this, runnable, j11);
    }

    public void removeCallbacks() {
        e.b.f(this);
    }

    public void removeCallbacks(Runnable runnable) {
        e.b.g(this, runnable);
    }

    public void removeCallbacksAndMessages(Object obj) {
        e.b.h(this, obj);
    }

    public final void setInitDataChannel(int i11) {
        this.initDataChannel = i11;
    }

    public final void setMResumed(boolean z11) {
        this.mResumed = z11;
    }

    public final void setMStarted(boolean z11) {
        this.mStarted = z11;
    }

    @Override // id.d
    public void setOnClickListener(View.OnClickListener onClickListener, int... iArr) {
        d.a.b(this, onClickListener, iArr);
    }

    @Override // id.d
    public void setOnClickListener(View.OnClickListener onClickListener, View... viewArr) {
        d.a.c(this, onClickListener, viewArr);
    }

    public void setOnClickListener(int... iArr) {
        d.a.d(this, iArr);
    }

    public void setOnClickListener(View... viewArr) {
        d.a.e(this, viewArr);
    }

    public final void setSavedInstance(Bundle bundle) {
        this.savedInstance = bundle;
    }

    public void showKeyboard(View view) {
        f.a.b(this, view);
    }

    @JvmOverloads
    public final void showLoadingDialog() {
        showLoadingDialog$default(this, null, 1, null);
    }

    @JvmOverloads
    public void showLoadingDialog(final String str) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.dialogCount++;
        postDelayed(new Runnable() { // from class: kd.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showLoadingDialog$lambda$0(this.f68525a, str);
            }
        }, 300L);
    }

    public abstract void showStatusLoading();

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Intrinsics.g(intent, "intent");
        super.startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i11, Bundle bundle) {
        Intrinsics.g(intent, "intent");
        hideKeyboard(getCurrentFocus());
        super.startActivityForResult(intent, i11, bundle);
    }

    public void startActivityForResult(Intent intent, Bundle bundle, a aVar) {
        Intrinsics.g(intent, "intent");
        int iNextInt = new Random().nextInt((int) Math.pow(2.0d, 16.0d));
        getActivityCallbacks().put(iNextInt, aVar);
        startActivityForResult(intent, iNextInt, bundle);
    }

    public void startActivityForResult(Intent intent, a aVar) {
        Intrinsics.g(intent, "intent");
        startActivityForResult(intent, (Bundle) null, aVar);
    }

    public void startActivityForResult(Class<? extends Activity> clazz, a aVar) {
        Intrinsics.g(clazz, "clazz");
        startActivityForResult(new Intent(this, clazz), (Bundle) null, aVar);
    }

    public void toggleSoftInput(View view) {
        f.a.c(this, view);
    }

    public final void updateLoadingContent(String str) {
        OooO0OO oooO0OO = this.dialog;
        if (oooO0OO != null) {
            Intrinsics.d(oooO0OO);
            if (oooO0OO.isShowing()) {
                OooO0OO oooO0OO2 = this.dialog;
                TextView textView = oooO0OO2 != null ? (TextView) oooO0OO2.findViewById(R$id.tv_wait_message) : null;
                if (textView == null) {
                    return;
                }
                textView.setText(str);
            }
        }
    }
}
