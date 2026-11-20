package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.logging.type.LogSeverity;
import com.transsion.postdetail.R$drawable;
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
public final class ClipLoading extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f55951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f55952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ClipDrawable f55953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f55954d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f55955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f55956g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClipLoading(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClipLoading(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipLoading(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f55952b = 10000;
        this.f55954d = 13L;
        a();
    }

    private final void a() {
        Drawable drawable = z2.a.getDrawable(getContext(), R$drawable.post_detail_imm_video_clip_progress);
        Intrinsics.e(drawable, "null cannot be cast to non-null type android.graphics.drawable.ClipDrawable");
        ClipDrawable clipDrawable = (ClipDrawable) drawable;
        this.f55953c = clipDrawable;
        setImageDrawable(clipDrawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f55955f) {
            return;
        }
        if (this.f55951a >= this.f55952b) {
            this.f55956g = 20;
            this.f55951a = 0;
        }
        int i11 = this.f55956g;
        if (i11 > 0) {
            this.f55956g = i11 - 1;
        } else {
            this.f55951a += LogSeverity.NOTICE_VALUE;
        }
        ClipDrawable clipDrawable = this.f55953c;
        if (clipDrawable != null) {
            clipDrawable.setLevel(this.f55951a);
        }
        postInvalidateDelayed(this.f55954d);
    }

    public final void start() {
        this.f55951a = 0;
        this.f55955f = false;
        postInvalidate();
    }

    public final void stop() {
        this.f55951a = 0;
        this.f55955f = true;
    }
}
