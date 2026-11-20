package com.transsnet.downloader.manager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
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
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f61065c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f61066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f61067b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e() {
        this.f61066a = true;
        this.f61066a = xq.c.f80663a.d();
    }

    public static final void f(View guideView) {
        Intrinsics.g(guideView, "$guideView");
        if (guideView.getParent() != null) {
            ViewParent parent = guideView.getParent();
            Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(guideView);
        }
    }

    public static final void g(View guideView, View view) {
        Intrinsics.g(guideView, "$guideView");
        if (guideView.getParent() != null) {
            ViewParent parent = guideView.getParent();
            Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(guideView);
        }
    }

    public final View c(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_downloading_play_guide, (ViewGroup) null);
        Intrinsics.f(viewInflate, "from(context).inflate(R.…loading_play_guide, null)");
        return viewInflate;
    }

    public final void d(FrameLayout fragmentRootView, BaseViewHolder holder, long j11) {
        View viewOrNull;
        Intrinsics.g(fragmentRootView, "fragmentRootView");
        Intrinsics.g(holder, "holder");
        if (this.f61066a && !this.f61067b && (viewOrNull = holder.getViewOrNull(R$id.iv_cover)) != null && so.c.i(viewOrNull)) {
            this.f61067b = true;
            e(fragmentRootView, viewOrNull);
        }
    }

    public final void e(FrameLayout frameLayout, View view) {
        int iA = f0.a(106.0f);
        int iA2 = f0.a(16.0f);
        Context context = view.getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
        final View viewC = c((Activity) context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f0.a(230.0f), -2);
        layoutParams.topMargin = iA;
        layoutParams.setMarginStart(iA2);
        frameLayout.addView(viewC, layoutParams);
        viewC.postDelayed(new Runnable() { // from class: com.transsnet.downloader.manager.c
            @Override // java.lang.Runnable
            public final void run() {
                e.f(viewC);
            }
        }, 3000L);
        viewC.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.manager.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.g(viewC, view2);
            }
        });
        this.f61066a = false;
        xq.c.f80663a.f();
    }
}
