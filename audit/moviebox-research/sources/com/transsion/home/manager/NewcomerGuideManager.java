package com.transsion.home.manager;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.d;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.widget.NewcomerGuideView;
import com.transsion.home.R$id;
import com.transsion.home.R$string;
import com.transsion.home.manager.NewcomerGuideManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import so.c;
import uo.b;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class NewcomerGuideManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f52637h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f52638i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<NewcomerGuideManager> f52639j = LazyKt__LazyJVMKt.b(new Function0<NewcomerGuideManager>() { // from class: com.transsion.home.manager.NewcomerGuideManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NewcomerGuideManager invoke() {
            return new NewcomerGuideManager();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f52642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f52643d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f52645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f52646g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52640a = "NewcomerGuide";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f52641b = d0.c() - d.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f52644e = true;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NewcomerGuideManager a() {
            return (NewcomerGuideManager) NewcomerGuideManager.f52639j.getValue();
        }
    }

    public static final void f(NewcomerGuideView guideView, View targetView, int i11) {
        Intrinsics.g(guideView, "$guideView");
        Intrinsics.g(targetView, "$targetView");
        NewcomerGuideView.setTargetView$default(guideView, targetView, i11, 3, 0, 8, null);
    }

    public static final void g(int i11, NewcomerGuideManager this$0, FrameLayout frameLayout, NewcomerGuideView guideView, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(guideView, "$guideView");
        if (i11 == 1) {
            View view2 = this$0.f52642c;
            if (view2 != null) {
                this$0.e(view2, 2);
            }
        } else if (i11 == 2) {
            View view3 = this$0.f52643d;
            if (view3 != null) {
                this$0.e(view3, 3);
            }
            this$0.f52642c = null;
        } else if (i11 == 3) {
            this$0.f52646g = false;
            this$0.f52643d = null;
        }
        frameLayout.removeView(guideView);
    }

    public static final void j(NewcomerGuideManager this$0, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(view, "$view");
        b.a.f(b.f78622a, this$0.f52640a, "addGuideView~~, position = " + i11, false, 4, null);
        this$0.h(view);
    }

    public final void e(final View view, final int i11) {
        Context context = view.getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
        final FrameLayout frameLayout = (FrameLayout) ((Activity) context).findViewById(R.id.content);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Context context2 = view.getContext();
        Intrinsics.f(context2, "targetView.context");
        final NewcomerGuideView newcomerGuideView = new NewcomerGuideView(context2);
        frameLayout.addView(newcomerGuideView, layoutParams);
        if (i11 == 1) {
            frameLayout.postDelayed(new Runnable() { // from class: qt.b
                @Override // java.lang.Runnable
                public final void run() {
                    NewcomerGuideManager.f(newcomerGuideView, view, i11);
                }
            }, 200L);
        } else {
            newcomerGuideView.setTargetView(view, i11, 3, i11 == 3 ? f0.a(4.0f) : 0);
        }
        if (i11 == 1) {
            newcomerGuideView.setTipsText(R$string.newcomer_guide_tips_step_1);
        } else if (i11 == 2) {
            newcomerGuideView.setTipsText(R$string.newcomer_guide_tips_step_2);
        } else if (i11 == 3) {
            newcomerGuideView.setTipsText(R$string.newcomer_guide_tips_step_3);
        }
        newcomerGuideView.setOnClickListener(new View.OnClickListener() { // from class: qt.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NewcomerGuideManager.g(i11, this, frameLayout, newcomerGuideView, view2);
            }
        });
    }

    public final void h(View view) {
        if (view.getMeasuredWidth() == 0) {
            b.a.f(b.f78622a, this.f52640a, "addGuideView~~, measuredWidth is 0~", false, 4, null);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height = iArr[1] + view.getHeight();
        int i11 = this.f52641b;
        if (height > i11) {
            b.a.f(b.f78622a, this.f52640a, "addGuideView~~, beyond the screen~, screenHeight = " + i11 + ", y= " + iArr[1] + ", height = " + view.getHeight(), false, 4, null);
            return;
        }
        b.a.f(b.f78622a, this.f52640a, "addGuideView~~ , screenHeight = " + i11 + ", y= " + iArr[1] + ", height = " + view.getHeight(), false, 4, null);
        this.f52644e = true;
        this.f52645f = false;
        e(view, 1);
        RoomAppMMKV.f51271a.a().putBoolean("key_newcomer_guide", true);
    }

    public final void i(BaseViewHolder holder, final int i11) {
        Intrinsics.g(holder, "holder");
        if (this.f52645f) {
            b.a.f(b.f78622a, this.f52640a, "onViewHolderShow, skip, position = " + i11, false, 4, null);
            return;
        }
        if (this.f52644e) {
            b.a.f(b.f78622a, this.f52640a, "onViewHolderShow, guide has shown~，  position = " + i11 + " ", false, 4, null);
            return;
        }
        if (!this.f52646g) {
            final View viewOrNull = holder.getViewOrNull(R$id.ll_download);
            if (viewOrNull != null && c.i(viewOrNull)) {
                this.f52646g = true;
                viewOrNull.post(new Runnable() { // from class: qt.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewcomerGuideManager.j(this.f74885a, i11, viewOrNull);
                    }
                });
                return;
            }
            return;
        }
        b.a.f(b.f78622a, this.f52640a, "onViewHolderShow, task is running~，  position = " + i11 + " ", false, 4, null);
    }
}
