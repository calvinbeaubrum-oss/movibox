package com.transsnet.downloader.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.R$mipmap;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import h00.z0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DownloadInfoExtendView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f61300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z0 f61301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f61302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f61303d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadInfoExtendView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadInfoExtendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadInfoExtendView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        g();
        this.f61300a = true;
        this.f61303d = 3;
    }

    private final void e() {
        AppCompatTextView appCompatTextView;
        this.f61300a = true;
        z0 z0Var = this.f61301b;
        if (z0Var != null && (appCompatTextView = z0Var.f66109b) != null) {
            appCompatTextView.setText(appCompatTextView.getContext().getString(R$string.str_hide));
            Drawable drawable = appCompatTextView.getContext().getDrawable(R$mipmap.libui_ic_up_hide);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            appCompatTextView.setCompoundDrawables(null, null, drawable, null);
        }
        z0 z0Var2 = this.f61301b;
        AppCompatTextView appCompatTextView2 = z0Var2 != null ? z0Var2.f66110c : null;
        if (appCompatTextView2 == null) {
            return;
        }
        appCompatTextView2.setText(this.f61302c);
    }

    private final void g() {
        AppCompatTextView appCompatTextView;
        z0 z0VarA = z0.a(View.inflate(getContext(), R$layout.view_download_info_extend_layout, this));
        this.f61301b = z0VarA;
        if (z0VarA == null || (appCompatTextView = z0VarA.f66109b) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadInfoExtendView.h(this.f61380a, view);
            }
        });
    }

    private final String getNewTextByConfig() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        String str = this.f61302c;
        if (str == null) {
            str = "";
        }
        z0 z0Var = this.f61301b;
        if (z0Var == null || (appCompatTextView = z0Var.f66110c) == null) {
            return str;
        }
        TextPaint paint = appCompatTextView.getPaint();
        Intrinsics.f(paint, "paint");
        StaticLayout staticLayoutBuild = Build.VERSION.SDK_INT > 23 ? StaticLayout.Builder.obtain(str, 0, str.length(), paint, appCompatTextView.getWidth()).build() : new StaticLayout(str, paint, appCompatTextView.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        Intrinsics.f(staticLayoutBuild, "if (Build.VERSION.SDK_IN…          )\n            }");
        if (staticLayoutBuild.getLineCount() <= this.f61303d) {
            if (f()) {
                return str;
            }
            z0 z0Var2 = this.f61301b;
            appCompatTextView2 = z0Var2 != null ? z0Var2.f66109b : null;
            if (appCompatTextView2 == null) {
                return str;
            }
            appCompatTextView2.setVisibility(8);
            return str;
        }
        z0 z0Var3 = this.f61301b;
        appCompatTextView2 = z0Var3 != null ? z0Var3.f66109b : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setVisibility(appCompatTextView.getVisibility());
        }
        return ((Object) str.subSequence(0, staticLayoutBuild.getLineEnd(this.f61303d - 1) - 3)) + "...";
    }

    public static final void h(DownloadInfoExtendView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f61300a) {
            this$0.i();
        } else {
            this$0.e();
        }
    }

    public static final void j(DownloadInfoExtendView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.l();
    }

    public static final void k(DownloadInfoExtendView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.l();
    }

    private final void l() {
        i();
    }

    public final boolean f() {
        return false;
    }

    public final void i() {
        AppCompatTextView appCompatTextView;
        this.f61300a = false;
        z0 z0Var = this.f61301b;
        if (z0Var != null && (appCompatTextView = z0Var.f66109b) != null) {
            appCompatTextView.setText(appCompatTextView.getContext().getString(R$string.str_more));
            Drawable drawable = appCompatTextView.getContext().getDrawable(R$mipmap.libui_ic_down_more);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            appCompatTextView.setCompoundDrawables(null, null, drawable, null);
        }
        z0 z0Var2 = this.f61301b;
        AppCompatTextView appCompatTextView2 = z0Var2 != null ? z0Var2.f66110c : null;
        if (appCompatTextView2 == null) {
            return;
        }
        appCompatTextView2.setText(getNewTextByConfig());
    }

    public final void showData(Subject subject) {
        String description;
        ConstraintLayout root;
        if (subject == null || (description = subject.getDescription()) == null) {
            description = "";
        }
        this.f61302c = description;
        z0 z0Var = this.f61301b;
        if (z0Var == null || (root = z0Var.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsnet.downloader.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                DownloadInfoExtendView.j(this.f61383a);
            }
        });
    }

    public final void showData(String str) {
        ConstraintLayout root;
        if (str == null) {
            str = "";
        }
        this.f61302c = str;
        z0 z0Var = this.f61301b;
        if (z0Var == null || (root = z0Var.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsnet.downloader.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                DownloadInfoExtendView.k(this.f61382a);
            }
        });
    }
}
