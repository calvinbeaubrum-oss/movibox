package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.NetworkUtils;
import com.tn.lib.widget.R$mipmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class NoNetworkSmallView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yp.d f49559a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkSmallView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkSmallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoNetworkSmallView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f49559a = yp.d.b(LayoutInflater.from(context), this);
        setBackgroundResource(R$mipmap.bg_network_view);
    }

    public static final void e(Function0 settingListener, View view) {
        Intrinsics.g(settingListener, "$settingListener");
        NetworkUtils.w();
        settingListener.invoke();
    }

    public static final void f(Function0 retryListener, final yp.d this_apply, NoNetworkSmallView this$0, View view) {
        Intrinsics.g(retryListener, "$retryListener");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        retryListener.invoke();
        AppCompatTextView retry = this_apply.f81592d;
        Intrinsics.f(retry, "retry");
        so.c.g(retry);
        AppCompatTextView goToSetting = this_apply.f81590b;
        Intrinsics.f(goToSetting, "goToSetting");
        so.c.g(goToSetting);
        AppCompatTextView tvTitle = this_apply.f81594g;
        Intrinsics.f(tvTitle, "tvTitle");
        so.c.g(tvTitle);
        ProgressBar progressBar = this_apply.f81591c;
        Intrinsics.f(progressBar, "progressBar");
        so.c.k(progressBar);
        this$0.postDelayed(new Runnable() { // from class: com.tn.lib.view.o
            @Override // java.lang.Runnable
            public final void run() {
                NoNetworkSmallView.g(this_apply);
            }
        }, 1000L);
    }

    public static final void g(yp.d this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        AppCompatTextView retry = this_apply.f81592d;
        Intrinsics.f(retry, "retry");
        so.c.k(retry);
        AppCompatTextView goToSetting = this_apply.f81590b;
        Intrinsics.f(goToSetting, "goToSetting");
        so.c.k(goToSetting);
        AppCompatTextView tvTitle = this_apply.f81594g;
        Intrinsics.f(tvTitle, "tvTitle");
        so.c.k(tvTitle);
        ProgressBar progressBar = this_apply.f81591c;
        Intrinsics.f(progressBar, "progressBar");
        so.c.g(progressBar);
    }

    public final void goToSetting(final Function0<Unit> settingListener) {
        AppCompatTextView appCompatTextView;
        Intrinsics.g(settingListener, "settingListener");
        yp.d dVar = this.f49559a;
        if (dVar == null || (appCompatTextView = dVar.f81590b) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NoNetworkSmallView.e(settingListener, view);
            }
        });
    }

    public final void retry(final Function0<Unit> retryListener) {
        Intrinsics.g(retryListener, "retryListener");
        final yp.d dVar = this.f49559a;
        if (dVar != null) {
            dVar.f81592d.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NoNetworkSmallView.f(retryListener, dVar, this, view);
                }
            });
        }
    }
}
