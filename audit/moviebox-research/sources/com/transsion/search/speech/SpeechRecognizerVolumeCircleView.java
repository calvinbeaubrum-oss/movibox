package com.transsion.search.speech;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tn.lib.view.FlowLayout;
import com.transsion.search.R$mipmap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
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
public final class SpeechRecognizerVolumeCircleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MicState f57656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f57657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f57658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f57659d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f57660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f57661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f57662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f57663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Bitmap f57664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bitmap f57665k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f57666l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f57667m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ValueAnimator f57668n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum MicState {
        NORMAL,
        ACTIVE,
        LOADING
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57669a;

        static {
            int[] iArr = new int[MicState.values().length];
            try {
                iArr[MicState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MicState.ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f57669a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SpeechRecognizerVolumeCircleView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpeechRecognizerVolumeCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f57656a = MicState.NORMAL;
        this.f57659d = 1000L;
        this.f57660f = b(80);
        this.f57663i = new int[]{Color.parseColor("#2166E5"), Color.parseColor("#1DD171")};
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R$mipmap.sr_icon_normal);
        Intrinsics.f(bitmapDecodeResource, "decodeResource(context.r… R.mipmap.sr_icon_normal)");
        this.f57664j = bitmapDecodeResource;
        Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(context.getResources(), R$mipmap.sr_icon_active);
        Intrinsics.f(bitmapDecodeResource2, "decodeResource(context.r… R.mipmap.sr_icon_active)");
        this.f57665k = bitmapDecodeResource2;
        Paint paint = new Paint();
        paint.setColor(FlowLayout.SPACING_AUTO);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(context.getResources().getDisplayMetrics().density);
        paint.setAntiAlias(true);
        this.f57666l = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(style);
        paint2.setStrokeWidth(b(2));
        paint2.setAntiAlias(true);
        this.f57667m = paint2;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.search.speech.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SpeechRecognizerVolumeCircleView.c(this.f57683a, valueAnimator2);
            }
        });
        this.f57668n = valueAnimator;
        int i11 = this.f57660f;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeResource, i11, i11, true);
        Intrinsics.f(bitmapCreateScaledBitmap, "createScaledBitmap(mMicI…Size, mMicIconSize, true)");
        this.f57661g = bitmapCreateScaledBitmap;
        int i12 = this.f57660f;
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeResource2, i12, i12, true);
        Intrinsics.f(bitmapCreateScaledBitmap2, "createScaledBitmap(mMicI…Size, mMicIconSize, true)");
        this.f57662h = bitmapCreateScaledBitmap2;
        setLoadingGradientColors(this.f57663i);
    }

    public /* synthetic */ SpeechRecognizerVolumeCircleView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void c(SpeechRecognizerVolumeCircleView this$0, ValueAnimator animation) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f57657b = ((Float) animatedValue).floatValue();
        double animatedFraction = animation.getAnimatedFraction();
        this$0.f57666l.setAlpha((int) (animatedFraction <= 0.5d ? ((double) 255) * (((double) 1) - (animatedFraction * 0.5d)) : ((double) 255) * (0.5d - ((animatedFraction - 0.5d) * 0.5d))));
        this$0.invalidate();
    }

    public final int b(int i11) {
        return (int) TypedValue.applyDimension(1, i11, getContext().getResources().getDisplayMetrics());
    }

    public final void d() {
        this.f57668n.setFloatValues(this.f57660f / 2, (Math.min(getWidth(), getHeight()) / 2) - (this.f57666l.getStrokeWidth() / 2));
        this.f57668n.setDuration(this.f57659d);
        this.f57668n.setRepeatCount(-1);
        this.f57668n.start();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f57668n.cancel();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        super.onDraw(canvas);
        int i11 = a.f57669a[this.f57656a.ordinal()];
        if (i11 == 1) {
            float width = getWidth() / 2;
            float height = getHeight() / 2;
            float f11 = this.f57660f / 2;
            canvas.drawArc(width - f11, height - f11, width + f11, height + f11, this.f57658c, 270.0f, false, this.f57667m);
            float f12 = this.f57658c + 5.0f;
            this.f57658c = f12;
            if (f12 > 360.0f) {
                this.f57658c = 0.0f;
            }
            postInvalidateOnAnimation();
            return;
        }
        if (i11 != 2) {
            canvas.drawBitmap(this.f57661g, (getWidth() - this.f57660f) / 2, (getHeight() - this.f57660f) / 2, (Paint) null);
            return;
        }
        Bitmap bitmap = this.f57662h;
        int width2 = (getWidth() - this.f57660f) / 2;
        int height2 = getHeight();
        int i12 = this.f57660f;
        int i13 = (height2 - i12) / 2;
        canvas.drawCircle((i12 / 2) + width2, (i12 / 2) + i13, this.f57657b, this.f57666l);
        canvas.drawBitmap(bitmap, width2, i13, (Paint) null);
    }

    public final void setActiveAnimationDuration(long j11) {
        this.f57659d = j11;
    }

    public final void setActiveCircleColor(int i11) {
        this.f57666l.setColor(i11);
        invalidate();
    }

    public final void setActiveStrokeWidth(int i11) {
        this.f57666l.setStrokeWidth(b(i11));
        invalidate();
    }

    public final void setLoadingGradientColors(int[] colors) {
        Intrinsics.g(colors, "colors");
        this.f57663i = colors;
        float width = getWidth() / 2;
        float height = getHeight() / 2;
        Paint paint = this.f57667m;
        int i11 = colors[0];
        int i12 = colors[1];
        paint.setShader(new SweepGradient(width, height, new int[]{i11, i12, i12, i11}, new float[]{0.0f, 0.5f, 0.75f, 1.0f}));
        invalidate();
    }

    public final void setLoadingStrokeWidth(int i11) {
        this.f57667m.setStrokeWidth(b(i11));
        invalidate();
    }

    public final void setMicIconSize(int i11) {
        int iB = b(i11);
        this.f57660f = iB;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.f57664j, iB, iB, true);
        Intrinsics.f(bitmapCreateScaledBitmap, "createScaledBitmap(mMicI…Size, mMicIconSize, true)");
        this.f57661g = bitmapCreateScaledBitmap;
        Bitmap bitmap = this.f57665k;
        int i12 = this.f57660f;
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, i12, i12, true);
        Intrinsics.f(bitmapCreateScaledBitmap2, "createScaledBitmap(mMicI…Size, mMicIconSize, true)");
        this.f57662h = bitmapCreateScaledBitmap2;
        invalidate();
    }

    public final void setMicState(MicState state) {
        Intrinsics.g(state, "state");
        this.f57656a = state;
        if (state == MicState.ACTIVE) {
            d();
        } else {
            this.f57668n.cancel();
        }
        invalidate();
    }
}
