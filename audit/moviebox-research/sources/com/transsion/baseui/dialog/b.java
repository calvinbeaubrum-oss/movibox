package com.transsion.baseui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.w;
import com.blankj.utilcode.util.d;
import com.blankj.utilcode.util.d0;
import com.transsion.baseui.R$color;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import com.transsion.baseui.R$style;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import so.c;

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
public final class b extends w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ProgressBar f51351g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R$style.BaseTranslucentDialogStyle);
        Intrinsics.g(context, "context");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        ProgressBar progressBar = this.f51351g;
        if (progressBar != null) {
            c.g(progressBar);
        }
    }

    @Override // androidx.appcompat.app.w, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        ProgressBar progressBar = this.f51351g;
        if (progressBar != null) {
            c.g(progressBar);
        }
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.base_dialog_loading);
        this.f51351g = (ProgressBar) findViewById(R$id.load_view);
        com.transsion.baseui.util.a aVar = com.transsion.baseui.util.a.f51450a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        int iA = (int) aVar.a(context, 28.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 49;
        int iA2 = (d0.a() / 2) - d.c();
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        layoutParams.topMargin = iA2 - ((int) aVar.a(context2, 54.0f));
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(17);
            window.setWindowAnimations(0);
            window.setBackgroundDrawableResource(R$color.base_transparent);
            window.setDimAmount(0.0f);
            window.clearFlags(2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = d0.e();
            attributes.height = d0.a();
            window.setAttributes(attributes);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        ProgressBar progressBar = this.f51351g;
        if (progressBar != null) {
            c.k(progressBar);
        }
    }
}
