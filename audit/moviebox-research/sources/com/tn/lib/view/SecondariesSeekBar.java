package com.tn.lib.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tn.lib.widget.R$styleable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class SecondariesSeekBar extends View {
    public Map<Integer, Integer> A;
    public Rect B;
    public Rect C;
    public final boolean D;
    public boolean E;
    public p F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f49588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f49589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f49590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f49591d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f49592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f49593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f49594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f49595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f49596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f49597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49598l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f49599m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f49600n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f49601o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f49602p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f49603q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f49604r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f49605s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f49606t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f49607u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f49608v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f49609w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f49610x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f49611y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f49612z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SecondariesSeekBar(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SecondariesSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecondariesSeekBar(Context context, AttributeSet attributeSet, int i11) {
        int[] iArr;
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f49588a = "SecondariesSeekBar";
        this.f49589b = 100L;
        this.f49604r = 1.5f;
        this.A = new LinkedHashMap();
        this.B = new Rect();
        this.C = new Rect();
        boolean rightToLeft = getRightToLeft();
        this.D = rightToLeft;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SecondariesSeekBar);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.SecondariesSeekBar)");
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.SecondariesSeekBar_ssb_bar_start_color, -1);
        int color2 = typedArrayObtainStyledAttributes.getColor(R$styleable.SecondariesSeekBar_ssb_bar_center_color, -1);
        int color3 = typedArrayObtainStyledAttributes.getColor(R$styleable.SecondariesSeekBar_ssb_bar_end_color, -1);
        if (color2 > 0) {
            iArr = new int[3];
            iArr[rightToLeft ? (char) 2 : (char) 0] = color;
            iArr[1] = color2;
            iArr[rightToLeft ? (char) 0 : (char) 2] = color3;
        } else {
            iArr = new int[2];
            iArr[rightToLeft ? 1 : 0] = color;
            iArr[!rightToLeft ? 1 : 0] = color3;
        }
        this.f49596j = iArr;
        this.f49597k = typedArrayObtainStyledAttributes.getColor(R$styleable.SecondariesSeekBar_ssb_secondaries_color, -1);
        this.f49598l = typedArrayObtainStyledAttributes.getColor(R$styleable.SecondariesSeekBar_ssb_bg_color, -1);
        this.f49605s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SecondariesSeekBar_ssb_seek_enable, true);
        this.f49600n = typedArrayObtainStyledAttributes.getColor(R$styleable.SecondariesSeekBar_ssb_thumb_color, -1);
        this.f49599m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SecondariesSeekBar_ssb_progress_size, d(context, 2.0f));
        this.f49601o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SecondariesSeekBar_ssb_thumb_size, d(context, 8.0f));
        this.f49589b = typedArrayObtainStyledAttributes.getInt(R$styleable.SecondariesSeekBar_ssb_max, 100);
        this.f49590c = typedArrayObtainStyledAttributes.getInt(R$styleable.SecondariesSeekBar_ssb_progress, 0);
        float f11 = typedArrayObtainStyledAttributes.getFloat(R$styleable.SecondariesSeekBar_ssb_thumb_enlarge, 1.5f);
        this.f49604r = f11;
        if (f11 < 1.0f) {
            this.f49604r = 1.0f;
        } else if (f11 > 2.0f) {
            this.f49604r = 2.0f;
        }
        int i12 = this.f49601o;
        int i13 = this.f49599m;
        if (i12 < i13) {
            this.f49601o = i13;
        }
        int i14 = (int) (this.f49601o / 2.0f);
        this.f49602p = i14;
        this.f49603q = (int) (i14 * this.f49604r);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setColor(this.f49598l);
        paint.setStrokeWidth(this.f49599m);
        this.f49592f = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(cap);
        paint2.setColor(this.f49597k);
        paint2.setStrokeWidth(this.f49599m);
        this.f49593g = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStrokeCap(cap);
        paint3.setStrokeWidth(this.f49599m);
        this.f49594h = paint3;
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        paint4.setColor(this.f49600n);
        this.f49595i = paint4;
    }

    private final boolean getRightToLeft() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public final float a(MotionEvent motionEvent) {
        int paddingRight;
        if (motionEvent.getX() < getPaddingLeft() + this.f49603q) {
            paddingRight = getPaddingLeft() + this.f49603q;
        } else {
            if (motionEvent.getX() <= (this.f49607u - getPaddingRight()) - this.f49603q) {
                return motionEvent.getX();
            }
            paddingRight = (this.f49607u - getPaddingRight()) - this.f49603q;
        }
        return paddingRight;
    }

    public final long b(float f11) {
        this.f49591d = this.f49590c;
        long paddingLeft = (long) ((this.f49589b * ((f11 - getPaddingLeft()) - this.f49603q)) / this.f49608v);
        this.f49590c = paddingLeft;
        return paddingLeft;
    }

    public final float c(float f11) {
        return this.D ? ((getPaddingLeft() + (this.f49603q * 2)) + this.f49608v) - f11 : f11;
    }

    public final int d(Context context, float f11) {
        return (int) TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics());
    }

    public final void e(Canvas canvas) {
        Paint paint = this.f49594h;
        Rect rect = this.C;
        paint.setShader(new LinearGradient(rect.left, rect.top, rect.right, rect.bottom, this.f49596j, (float[]) null, Shader.TileMode.CLAMP));
        Rect rect2 = this.C;
        canvas.drawLine(rect2.left, rect2.top, rect2.right, rect2.bottom, this.f49594h);
    }

    public final void f(Canvas canvas) {
        Rect rect = this.B;
        canvas.drawLine(rect.left, rect.top, rect.right, rect.bottom, this.f49592f);
    }

    public final void g(Canvas canvas) {
        int i11;
        int i12;
        int i13 = -1;
        for (Map.Entry<Integer, Integer> entry : this.A.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            i13++;
            if (i13 == 0 && iIntValue < (i12 = this.B.left)) {
                iIntValue = i12;
            }
            if (i13 == this.A.size() - 1 && iIntValue2 > (i11 = this.B.right)) {
                iIntValue2 = i11;
            }
            float f11 = iIntValue;
            Rect rect = this.C;
            canvas.drawLine(f11, rect.top, iIntValue2, rect.bottom, this.f49593g);
        }
    }

    public final long getMaxProgress() {
        return this.f49589b;
    }

    public final long getProgress() {
        return this.f49590c;
    }

    public final void h(Canvas canvas) {
        if (this.D) {
            Rect rect = this.C;
            canvas.drawCircle(rect.left, rect.top, this.E ? this.f49603q : this.f49602p, this.f49595i);
        } else {
            Rect rect2 = this.C;
            canvas.drawCircle(rect2.right, rect2.top, this.E ? this.f49603q : this.f49602p, this.f49595i);
        }
    }

    public final void i() {
        int i11 = this.f49607u;
        int i12 = this.f49610x;
        int i13 = this.f49609w;
        int i14 = this.f49603q;
        this.f49608v = ((i11 - i12) - i13) - (i14 * 2);
        Rect rect = this.B;
        int i15 = i13 + i14;
        rect.left = i15;
        int i16 = (i11 - i12) - i14;
        rect.right = i16;
        if (this.D) {
            this.C.right = i16;
        } else {
            this.C.right = i15;
        }
        int i17 = this.f49606t / 2;
        rect.top = i17;
        Rect rect2 = this.C;
        rect2.top = i17;
        rect.bottom = i17;
        rect2.bottom = i17;
        l();
        m();
    }

    public final void j(long j11) {
        long j12 = this.f49589b;
        if (j11 >= j12) {
            j11 = j12;
        }
        this.f49590c = j11;
        if (this.f49591d == j11) {
            return;
        }
        this.f49591d = j11;
        l();
    }

    public final void k(MotionEvent motionEvent) {
        long jB = b(c(a(motionEvent)));
        j(jB);
        p pVar = this.F;
        if (pVar != null) {
            pVar.b(this, jB, true);
        }
        invalidate();
    }

    public final void l() {
        float f11 = (this.f49590c * 1.0f) / this.f49589b;
        int i11 = this.f49608v;
        int i12 = (int) (f11 * i11);
        if (this.D) {
            Rect rect = this.C;
            int i13 = this.f49609w;
            int i14 = this.f49603q;
            rect.left = ((i13 + i14) + i11) - i12;
            rect.right = i13 + i14 + i11;
            return;
        }
        Rect rect2 = this.C;
        int i15 = this.f49609w;
        int i16 = this.f49603q;
        rect2.left = i15 + i16;
        rect2.right = i15 + i16 + i12;
    }

    public final void m() {
        if (!this.A.isEmpty()) {
            int iIntValue = ((Number) CollectionsKt___CollectionsKt.d0(this.A.keySet())).intValue();
            Integer num = this.A.get(Integer.valueOf(iIntValue));
            int iIntValue2 = ((Number) CollectionsKt___CollectionsKt.p0(this.A.keySet())).intValue();
            Integer num2 = this.A.get(Integer.valueOf(iIntValue));
            if ((num2 != null ? num2.intValue() : 0) > this.B.right) {
                this.A.put(Integer.valueOf(iIntValue2), Integer.valueOf(this.C.right));
            }
            if (iIntValue < this.B.left) {
                this.A.remove(Integer.valueOf(iIntValue));
                this.A.put(Integer.valueOf(this.B.left), Integer.valueOf(num != null ? num.intValue() : this.B.left));
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        super.onDraw(canvas);
        f(canvas);
        g(canvas);
        e(canvas);
        if (this.f49605s) {
            h(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f49609w = getPaddingLeft();
        this.f49610x = getPaddingRight();
        this.f49611y = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        this.f49612z = paddingBottom;
        this.f49606t = (this.f49603q * 6) + this.f49611y + paddingBottom;
        Context context = getContext();
        Intrinsics.f(context, "context");
        int iResolveSize = View.resolveSize(d(context, 170.0f), i11);
        this.f49607u = iResolveSize;
        setMeasuredDimension(iResolveSize, this.f49606t);
        i();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        p pVar;
        Intrinsics.g(event, "event");
        if (!this.f49605s) {
            return super.onTouchEvent(event);
        }
        int action = event.getAction();
        if (action == 0) {
            this.E = true;
            p pVar2 = this.F;
            if (pVar2 != null) {
                pVar2.c(this);
            }
            k(event);
            return true;
        }
        if (action == 1) {
            this.E = false;
            pVar = this.F;
            if (pVar != null) {
                pVar.a(this);
            }
        } else if (action == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.E = true;
            k(event);
        } else if (action == 3) {
            this.E = false;
            pVar = this.F;
            if (pVar != null) {
                pVar.a(this);
            }
        }
        return super.onTouchEvent(event);
    }

    public final void seekEnable(boolean z11) {
        this.f49605s = z11;
    }

    public final void setMax(long j11) {
        this.f49589b = j11;
    }

    public final void setOnSeekBarChangeListener(p listener) {
        Intrinsics.g(listener, "listener");
        this.F = listener;
    }

    public final void setProgress(long j11) {
        j(j11);
        p pVar = this.F;
        if (pVar != null) {
            pVar.b(this, j11, false);
        }
        invalidate();
    }

    public final void setSecondariesProgress(Map<Integer, Integer> progress) {
        Intrinsics.g(progress, "progress");
        this.A.clear();
        for (Map.Entry<Integer, Integer> entry : progress.entrySet()) {
            if (entry.getValue().intValue() >= entry.getKey().intValue()) {
                float fIntValue = ((entry.getValue().intValue() - entry.getKey().intValue()) * 1.0f) / this.f49589b;
                int i11 = this.f49608v;
                int i12 = (int) (fIntValue * i11);
                int iFloatValue = this.D ? ((this.f49609w + this.f49603q) + i11) - ((int) (((entry.getKey().floatValue() * 1.0f) / this.f49589b) * this.f49608v)) : this.f49609w + this.f49603q + ((int) (((entry.getKey().floatValue() * 1.0f) / this.f49589b) * this.f49608v));
                this.A.put(Integer.valueOf(iFloatValue), Integer.valueOf(this.D ? iFloatValue - i12 : iFloatValue + i12));
            }
        }
        invalidate();
    }
}
