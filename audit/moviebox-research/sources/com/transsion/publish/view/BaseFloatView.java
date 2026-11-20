package com.transsion.publish.view;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
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
public class BaseFloatView extends ConstraintLayout implements Application.ActivityLifecycleCallbacks {
    public static final a Companion = new a(null);
    public static final int MSG_AUTO_DISMISS_DOWNLOAD_STATUS_VIEW = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout.b f56623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f56624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f56625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f56626d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SuppressLint({"HandlerLeak"})
    public static final class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.g(msg, "msg");
            super.handleMessage(msg);
            if (msg.what == 1) {
                BaseFloatView.this.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFloatView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f56626d = new b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f56626d = new b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFloatView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f56626d = new b();
    }

    public final void a(Activity activity) {
        if (!this.f56624b || TextUtils.equals(activity.getClass().getSimpleName(), "LaunchActivity") || Intrinsics.b(this.f56625c, activity)) {
            return;
        }
        this.f56625c = activity;
        FrameLayout frameLayoutC = c(activity);
        if (frameLayoutC != null) {
            if (getParent() instanceof ViewGroup) {
                ViewParent parent = getParent();
                Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(this);
            }
            ConstraintLayout.b bVar = this.f56623a;
            if (bVar == null) {
                frameLayoutC.addView(this);
            } else {
                frameLayoutC.addView(this, bVar);
            }
        }
    }

    public final void b(Activity activity) {
        if ((activity == null || Intrinsics.b(this.f56625c, activity)) && (getParent() instanceof ViewGroup)) {
            ViewParent parent = getParent();
            Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
        this.f56625c = null;
    }

    public final FrameLayout c(Activity activity) {
        try {
            View viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
            Intrinsics.e(viewFindViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
            return (FrameLayout) viewFindViewById;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public void dismiss() {
        Application application;
        try {
            this.f56624b = false;
            Activity activity = this.f56625c;
            if (activity != null && (application = activity.getApplication()) != null) {
                application.unregisterActivityLifecycleCallbacks(this);
            }
            b(null);
            this.f56626d.removeCallbacksAndMessages(null);
        } catch (Exception e11) {
            uo.b.a.f(uo.b.f78622a, UploadView.Companion.a(), "dismiss:" + e11.getMessage(), false, 4, null);
        }
    }

    public final Activity getActivity() {
        return this.f56625c;
    }

    public final Handler getH() {
        return this.f56626d;
    }

    @Override // android.view.View
    public final ConstraintLayout.b getLayoutParams() {
        return this.f56623a;
    }

    public final boolean isShow() {
        return this.f56624b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.g(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.g(activity, "activity");
        if (Intrinsics.b(this.f56625c, activity)) {
            dismiss();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.g(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.g(activity, "activity");
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.g(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.g(activity, "activity");
    }

    public final void setActivity(Activity activity) {
        this.f56625c = activity;
    }

    public final void setH(Handler handler) {
        Intrinsics.g(handler, "<set-?>");
        this.f56626d = handler;
    }

    public final void setLayoutParams(ConstraintLayout.b bVar) {
        this.f56623a = bVar;
    }

    public final void setShow(boolean z11) {
        this.f56624b = z11;
    }

    public void show(Activity activity) {
        Intrinsics.g(activity, "activity");
        this.f56624b = true;
        a(activity);
        activity.getApplication().registerActivityLifecycleCallbacks(this);
    }
}
