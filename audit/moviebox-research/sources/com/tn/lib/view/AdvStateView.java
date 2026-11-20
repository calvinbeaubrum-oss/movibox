package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.R$styleable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AdvStateView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f49487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f49488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f49489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49490d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f49491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49492g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvStateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        this.f49490d = -1;
        this.f49491f = -1;
        this.f49492g = -1;
        c(attrs);
        d();
    }

    public static final void f(AdvStateView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.getClass();
    }

    public static final void g(AdvStateView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.getClass();
    }

    private final void getEmptyView() {
        setVisibility(0);
        if (this.f49488b == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f49491f, (ViewGroup) null);
            this.f49488b = viewInflate;
            addView(viewInflate, layoutParams);
        }
    }

    private final void getErrorView() {
        setVisibility(0);
        if (this.f49489c == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f49490d, (ViewGroup) null);
            this.f49489c = viewInflate;
            addView(viewInflate, layoutParams);
        }
    }

    private final void getProgressView() {
        setVisibility(0);
        if (this.f49487a == null) {
            this.f49487a = LayoutInflater.from(getContext()).inflate(this.f49492g, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(this.f49487a, layoutParams);
        }
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.advstateview);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…R.styleable.advstateview)");
        try {
            try {
                this.f49492g = typedArrayObtainStyledAttributes.getResourceId(R$styleable.advstateview_layout_progress, R$layout.adv_layout_progress);
                this.f49491f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.advstateview_layout_empty, R$layout.adv_layout_empty);
                this.f49490d = typedArrayObtainStyledAttributes.getResourceId(R$styleable.advstateview_layout_error, R$layout.adv_layout_error);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void d() {
    }

    public final void e(boolean z11) {
        setVisibility(z11 ? 8 : 0);
    }

    public final a getOnClickListener() {
        return null;
    }

    public final void setOnClickListener(a aVar) {
    }

    public final void setOnStateClickListener(a listenr) {
        Intrinsics.g(listenr, "listenr");
    }

    public final void showData() {
        e(true);
    }

    public final void showEmpty() {
        getEmptyView();
        View view = this.f49489c;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.f49488b;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.f49487a;
        if (view3 != null) {
            view3.setVisibility(4);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                AdvStateView.f(this.f49834a, view4);
            }
        });
    }

    public final void showError() {
        getErrorView();
        View view = this.f49489c;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f49488b;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.f49487a;
        if (view3 != null) {
            view3.setVisibility(4);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                AdvStateView.g(this.f49832a, view4);
            }
        });
    }

    public final void showProgress() {
        getProgressView();
        View view = this.f49489c;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.f49488b;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.f49487a;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(0);
    }
}
