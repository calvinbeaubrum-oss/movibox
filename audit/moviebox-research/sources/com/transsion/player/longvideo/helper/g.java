package com.transsion.player.longvideo.helper;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.player.longvideo.ui.LongVodUiType;
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
public final class g extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f54415d;

    public static final void g(g this$0, mv.i viewBinding, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(viewBinding, "$viewBinding");
        this$0.f54415d = true;
        FrameLayout frameLayout = viewBinding.f71242o.f71260h;
        Intrinsics.f(frameLayout, "viewBinding.layoutLand.gameContainer");
        so.c.g(frameLayout);
        AppCompatImageView appCompatImageView = viewBinding.f71242o.f71263k;
        Intrinsics.f(appCompatImageView, "viewBinding.layoutLand.ivGameClose");
        so.c.g(appCompatImageView);
    }

    public static final void i(g this$0) {
        mv.j jVar;
        AppCompatImageView appCompatImageView;
        Intrinsics.g(this$0, "this$0");
        mv.i iVarB = this$0.b();
        if (iVarB == null || (jVar = iVarB.f71242o) == null || (appCompatImageView = jVar.f71263k) == null) {
            return;
        }
        so.c.k(appCompatImageView);
    }

    @Override // com.transsion.player.longvideo.helper.d
    public void c(String str, final mv.i viewBinding) {
        Intrinsics.g(viewBinding, "viewBinding");
        super.c(str, viewBinding);
        viewBinding.f71242o.f71263k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.g(this.f54413a, viewBinding, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(LongVodUiType uiType) {
        kv.a.b bVarA;
        View viewF;
        ViewGroup viewGroup;
        mv.j jVar;
        FrameLayout frameLayout;
        mv.j jVar2;
        FrameLayout frameLayout2;
        mv.j jVar3;
        FrameLayout frameLayout3;
        mv.j jVar4;
        AppCompatImageView ivGameClose;
        mv.j jVar5;
        FrameLayout gameContainer;
        ViewGroup viewGroup2;
        Intrinsics.g(uiType, "uiType");
        kv.a.b bVarA2 = a();
        if (bVarA2 != null) {
            bVarA2.e(uiType);
        }
        if (uiType == LongVodUiType.MIDDLE || this.f54415d || (bVarA = a()) == null || (viewF = bVarA.f()) == 0) {
            return;
        }
        ViewParent parent = viewF.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup2 = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup = viewGroup2;
            viewGroup.removeView(viewF);
        }
        viewGroup = viewGroup2;
        ss.a aVar = viewF instanceof ss.a ? (ss.a) viewF : null;
        if (aVar != null) {
            aVar.setPageStyle("fullscreen");
        }
        mv.i iVarB = b();
        if (iVarB != null && (jVar5 = iVarB.f71242o) != null && (gameContainer = jVar5.f71260h) != null) {
            Intrinsics.f(gameContainer, "gameContainer");
            so.c.k(gameContainer);
        }
        mv.i iVarB2 = b();
        if (iVarB2 != null && (jVar4 = iVarB2.f71242o) != null && (ivGameClose = jVar4.f71263k) != null) {
            Intrinsics.f(ivGameClose, "ivGameClose");
            so.c.g(ivGameClose);
        }
        mv.i iVarB3 = b();
        if (iVarB3 != null && (jVar3 = iVarB3.f71242o) != null && (frameLayout3 = jVar3.f71260h) != null) {
            frameLayout3.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.i(this.f54412a);
                }
            }, 3000L);
        }
        mv.i iVarB4 = b();
        if (iVarB4 != null && (jVar2 = iVarB4.f71242o) != null && (frameLayout2 = jVar2.f71260h) != null) {
            frameLayout2.removeAllViews();
        }
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        mv.i iVarB5 = b();
        if (iVarB5 == null || (jVar = iVarB5.f71242o) == null || (frameLayout = jVar.f71260h) == null) {
            return;
        }
        frameLayout.addView(viewF, layoutParams);
    }
}
