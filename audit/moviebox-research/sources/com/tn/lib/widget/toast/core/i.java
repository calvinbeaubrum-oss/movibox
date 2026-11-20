package com.tn.lib.widget.toast.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class i implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f50039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ToastImpl f50040b;

    public i(Activity activity) {
        this.f50039a = activity;
    }

    public final Activity a() {
        return this.f50039a;
    }

    public final void b(ToastImpl toastImpl) {
        this.f50040b = toastImpl;
        Activity activity = this.f50039a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Intrinsics.d(activity);
            activity.registerActivityLifecycleCallbacks(this);
        } else {
            Intrinsics.d(activity);
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    public final void c() {
        this.f50040b = null;
        Activity activity = this.f50039a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Intrinsics.d(activity);
            activity.unregisterActivityLifecycleCallbacks(this);
        } else {
            Intrinsics.d(activity);
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.g(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.g(activity, "activity");
        if (this.f50039a != activity) {
            return;
        }
        ToastImpl toastImpl = this.f50040b;
        if (toastImpl != null) {
            Intrinsics.d(toastImpl);
            toastImpl.e();
        }
        c();
        this.f50039a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ToastImpl toastImpl;
        Intrinsics.g(activity, "activity");
        if (this.f50039a == activity && (toastImpl = this.f50040b) != null) {
            Intrinsics.d(toastImpl);
            toastImpl.e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.g(activity, "activity");
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
}
