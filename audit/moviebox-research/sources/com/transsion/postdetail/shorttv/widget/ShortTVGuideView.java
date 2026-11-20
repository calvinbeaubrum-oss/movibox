package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$color;
import com.transsion.postdetail.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.c0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShortTVGuideView extends ConstraintLayout {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f55483a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVGuideView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVGuideView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.layout_post_short_tv_guide, this);
        c0 c0VarA = c0.a(this);
        Intrinsics.f(c0VarA, "bind(this)");
        this.f55483a = c0VarA;
        setBackgroundColor(z2.a.getColor(context, R$color.black_50));
        setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVGuideView.c(this.f55507a, view);
            }
        });
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new View.OnKeyListener() { // from class: com.transsion.postdetail.shorttv.widget.f
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i12, KeyEvent keyEvent) {
                return ShortTVGuideView.e(this.f55508a, view, i12, keyEvent);
            }
        });
    }

    public static final void c(ShortTVGuideView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.removeGuide();
    }

    public static final boolean e(ShortTVGuideView this$0, View view, int i11, KeyEvent keyEvent) {
        Intrinsics.g(this$0, "this$0");
        if (i11 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this$0.removeGuide();
        return false;
    }

    public final void removeGuide() {
        if (getParent() != null) {
            ViewParent parent = getParent();
            Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
    }

    public final void setEp(String epText) {
        Intrinsics.g(epText, "epText");
        this.f55483a.f77709d.setText(epText);
    }

    public final void setPage(boolean z11) {
        ViewGroup.LayoutParams layoutParams = this.f55483a.f77710f.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = f0.a(z11 ? 90.0f : 64.0f);
        this.f55483a.f77710f.setLayoutParams(bVar);
    }
}
