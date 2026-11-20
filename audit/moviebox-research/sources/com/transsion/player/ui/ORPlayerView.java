package com.transsion.player.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.player.config.RenderType;
import com.transsion.player.ui.render.SurfaceRenderView;
import com.transsion.player.ui.render.TextureRenderView;
import iv.b;
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
public final class ORPlayerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureRenderView f54822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceRenderView f54823b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54824a;

        static {
            int[] iArr = new int[RenderType.values().length];
            try {
                iArr[RenderType.SURFACE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderType.TEXTURE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f54824a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ORPlayerView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ORPlayerView(Context context, AttributeSet attributeSet, int i11, RenderType renderType) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        setBackgroundColor(Color.parseColor("#FF000000"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        int i12 = renderType != null ? a.f54824a[renderType.ordinal()] : -1;
        if (i12 == 1) {
            SurfaceRenderView surfaceRenderView = new SurfaceRenderView(context);
            this.f54823b = surfaceRenderView;
            addView(surfaceRenderView, layoutParams);
        } else if (i12 == 2) {
            TextureRenderView textureRenderView = new TextureRenderView(context);
            this.f54822a = textureRenderView;
            addView(textureRenderView, layoutParams);
        } else if (b.f67716a.b()) {
            SurfaceRenderView surfaceRenderView2 = new SurfaceRenderView(context);
            this.f54823b = surfaceRenderView2;
            addView(surfaceRenderView2, layoutParams);
        } else {
            TextureRenderView textureRenderView2 = new TextureRenderView(context);
            this.f54822a = textureRenderView2;
            addView(textureRenderView2, layoutParams);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ORPlayerView(Context context, AttributeSet attributeSet, RenderType renderType) {
        this(context, attributeSet, 0, renderType);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ORPlayerView(Context context, RenderType renderType) {
        this(context, null, renderType);
        Intrinsics.g(context, "context");
    }

    public final SurfaceView getSurface() {
        return this.f54823b;
    }

    public final TextureView getTextureView() {
        return this.f54822a;
    }

    public final void updateSurface(ViewGroup.LayoutParams lp2) {
        Intrinsics.g(lp2, "lp");
        if (b.f67716a.b()) {
            SurfaceRenderView surfaceRenderView = this.f54823b;
            if (surfaceRenderView == null) {
                return;
            }
            surfaceRenderView.setLayoutParams(lp2);
            return;
        }
        TextureRenderView textureRenderView = this.f54822a;
        if (textureRenderView == null) {
            return;
        }
        textureRenderView.setLayoutParams(lp2);
    }
}
