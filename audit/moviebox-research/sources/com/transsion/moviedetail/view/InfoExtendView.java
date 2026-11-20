package com.transsion.moviedetail.view;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tu.z;

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
public final class InfoExtendView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f53809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f53810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f53811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f53812d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InfoExtendView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InfoExtendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoExtendView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        c();
        this.f53809a = true;
        this.f53812d = 3;
    }

    private final void c() {
        this.f53810b = z.a(View.inflate(getContext(), R$layout.view_info_extend_layout, this));
    }

    public static final void e(InfoExtendView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.g();
    }

    public static final void f(InfoExtendView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.g();
    }

    private final String getNewTextByConfig() {
        AppCompatTextView appCompatTextView;
        String str = this.f53811c;
        if (str == null) {
            str = "";
        }
        z zVar = this.f53810b;
        if (zVar == null || (appCompatTextView = zVar.f77660f) == null) {
            return str;
        }
        TextPaint paint = appCompatTextView.getPaint();
        Intrinsics.f(paint, "paint");
        StaticLayout staticLayoutBuild = Build.VERSION.SDK_INT > 23 ? StaticLayout.Builder.obtain(str, 0, str.length(), paint, appCompatTextView.getWidth()).build() : new StaticLayout(str, paint, appCompatTextView.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        Intrinsics.f(staticLayoutBuild, "if (Build.VERSION.SDK_IN…          )\n            }");
        int lineCount = staticLayoutBuild.getLineCount();
        int i11 = this.f53812d;
        if (lineCount <= i11) {
            return str;
        }
        return ((Object) str.subSequence(0, staticLayoutBuild.getLineEnd(i11 - 1) - 3)) + "...";
    }

    public final void g() {
        z zVar = this.f53810b;
        AppCompatTextView appCompatTextView = zVar != null ? zVar.f77660f : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(this.f53811c);
    }

    public final void showData(Subject subject) {
        String description;
        ConstraintLayout root;
        if (subject == null || (description = subject.getDescription()) == null) {
            description = "";
        }
        this.f53811c = description;
        z zVar = this.f53810b;
        if (zVar == null || (root = zVar.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.moviedetail.view.j
            @Override // java.lang.Runnable
            public final void run() {
                InfoExtendView.e(this.f53834a);
            }
        });
    }

    public final void showData(String str) {
        ConstraintLayout root;
        if (str == null) {
            str = "";
        }
        this.f53811c = str;
        z zVar = this.f53810b;
        if (zVar == null || (root = zVar.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.moviedetail.view.i
            @Override // java.lang.Runnable
            public final void run() {
                InfoExtendView.f(this.f53833a);
            }
        });
    }
}
