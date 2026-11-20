package com.transsion.player.ui.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.transsion.player.config.RenderType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv.a;

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
public final class TextureRenderView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f54857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceTexture f54858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f54859c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextureRenderView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureRenderView(Context context, AttributeSet attributeSet, int i11, RenderType renderType) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f54857a = new a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextureRenderView(Context context, AttributeSet attributeSet, RenderType renderType) {
        this(context, attributeSet, 0, renderType);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextureRenderView(Context context, RenderType renderType) {
        this(context, null, renderType);
        Intrinsics.g(context, "context");
    }

    public Bitmap doScreenShot() {
        return getBitmap();
    }

    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int[] iArrA = this.f54857a.a(i11, i12);
        setMeasuredDimension(iArrA[0], iArrA[1]);
    }

    public void release() {
        Surface surface = this.f54859c;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.f54858b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public void setScaleType(RenderScaleMode scaleType) {
        Intrinsics.g(scaleType, "scaleType");
        this.f54857a.b(scaleType);
        requestLayout();
    }

    public void setVideoRotation(int i11) {
        this.f54857a.c(i11);
        setRotation(i11);
    }

    public void setVideoSize(int i11, int i12) {
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        this.f54857a.d(i11, i12);
        requestLayout();
    }
}
