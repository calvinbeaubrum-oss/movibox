package com.applovin.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.ViewCompat;
import com.applovin.impl.b1;
import com.applovin.impl.b5;
import com.applovin.impl.pc;
import com.applovin.impl.x2;
import com.applovin.impl.xp;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class g {
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f17363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f17364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f17365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f17366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f17367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextPaint f17368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f17369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f17370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f17371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Layout.Alignment f17372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Bitmap f17373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f17374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f17375m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f17376n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f17377o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f17378p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f17379q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f17380r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f17381s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f17382t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f17383u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f17384v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f17385w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f17386x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f17387y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f17388z;

    public g(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f17367e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f17366d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f17363a = fRound;
        this.f17364b = fRound;
        this.f17365c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f17368f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f17369g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f17370h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005b  */
    /* JADX WARN: Code duplicated, block: B:16:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0060  */
    private void a() {
        float f11;
        int i11;
        float f12;
        Bitmap bitmap = this.f17373k;
        int i12 = this.C;
        int i13 = this.A;
        int i14 = this.D;
        int i15 = this.B;
        float f13 = i12 - i13;
        float f14 = i13 + (this.f17377o * f13);
        float f15 = i14 - i15;
        float f16 = i15 + (this.f17374l * f15);
        int iRound = Math.round(f13 * this.f17379q);
        float f17 = this.f17380r;
        int iRound2 = f17 != -3.4028235E38f ? Math.round(f15 * f17) : Math.round(iRound * (bitmap.getHeight() / bitmap.getWidth()));
        int i16 = this.f17378p;
        if (i16 != 2) {
            if (i16 == 1) {
                f11 = iRound / 2;
            }
            int iRound3 = Math.round(f14);
            i11 = this.f17376n;
            if (i11 == 2) {
                if (i11 == 1) {
                    f12 = iRound2 / 2;
                }
                int iRound4 = Math.round(f16);
                this.J = new Rect(iRound3, iRound4, iRound + iRound3, iRound2 + iRound4);
            }
            f12 = iRound2;
            f16 -= f12;
            int iRound5 = Math.round(f16);
            this.J = new Rect(iRound3, iRound5, iRound + iRound3, iRound2 + iRound5);
        }
        f11 = iRound;
        f14 -= f11;
        int iRound6 = Math.round(f14);
        i11 = this.f17376n;
        if (i11 == 2) {
            if (i11 == 1) {
                f12 = iRound2 / 2;
            }
            int iRound7 = Math.round(f16);
            this.J = new Rect(iRound6, iRound7, iRound + iRound6, iRound2 + iRound7);
        }
        f12 = iRound2;
        f16 -= f12;
        int iRound8 = Math.round(f16);
        this.J = new Rect(iRound6, iRound8, iRound + iRound6, iRound2 + iRound8);
    }

    private void a(Canvas canvas) {
        canvas.drawBitmap(this.f17373k, (Rect) null, this.J, this.f17370h);
    }

    private void a(Canvas canvas, boolean z11) {
        if (z11) {
            b(canvas);
            return;
        }
        b1.a(this.J);
        b1.a(this.f17373k);
        a(canvas);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    private void b() {
        int i11;
        int i12;
        int iMax;
        int iMin;
        int iRound;
        int i13;
        CharSequence charSequence = this.f17371i;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(this.f17371i);
        int i14 = this.C - this.A;
        int i15 = this.D - this.B;
        this.f17368f.setTextSize(this.f17386x);
        int i16 = (int) ((this.f17386x * 0.125f) + 0.5f);
        int i17 = i16 * 2;
        int i18 = i14 - i17;
        float f11 = this.f17379q;
        if (f11 != -3.4028235E38f) {
            i18 = (int) (i18 * f11);
        }
        int i19 = i18;
        if (i19 <= 0) {
            pc.d("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.f17387y > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.f17387y), 0, spannableStringBuilder.length(), 16711680);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.f17385w == 1) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (Color.alpha(this.f17382t) > 0) {
            int i21 = this.f17385w;
            if (i21 == 0 || i21 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f17382t), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.f17382t), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.f17372j;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.f17368f, i19, alignment2, this.f17366d, this.f17367e, true);
        this.E = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.E.getLineCount();
        int iMax2 = 0;
        for (int i22 = 0; i22 < lineCount; i22++) {
            iMax2 = Math.max((int) Math.ceil(this.E.getLineWidth(i22)), iMax2);
        }
        if (this.f17379q == -3.4028235E38f || iMax2 >= i19) {
            i19 = iMax2;
        }
        int i23 = i19 + i17;
        float f12 = this.f17377o;
        if (f12 != -3.4028235E38f) {
            int iRound2 = Math.round(i14 * f12);
            int i24 = this.A;
            int i25 = iRound2 + i24;
            int i26 = this.f17378p;
            i11 = 1;
            i12 = 2;
            if (i26 == 1) {
                i25 = ((i25 * 2) - i23) / 2;
            } else if (i26 == 2) {
                i25 -= i23;
            }
            iMax = Math.max(i25, i24);
            iMin = Math.min(i23 + iMax, this.C);
        } else {
            i11 = 1;
            i12 = 2;
            iMax = ((i14 - i23) / 2) + this.A;
            iMin = iMax + i23;
        }
        int i27 = iMin - iMax;
        if (i27 <= 0) {
            pc.d("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f13 = this.f17374l;
        if (f13 != -3.4028235E38f) {
            if (this.f17375m == 0) {
                iRound = Math.round(i15 * f13) + this.B;
                int i28 = this.f17376n;
                if (i28 == i12) {
                    iRound -= height;
                } else if (i28 == i11) {
                    iRound = ((iRound * 2) - height) / i12;
                }
            } else {
                int lineBottom = this.E.getLineBottom(0) - this.E.getLineTop(0);
                float f14 = this.f17374l;
                if (f14 >= 0.0f) {
                    iRound = Math.round(f14 * lineBottom) + this.B;
                } else {
                    iRound = Math.round((f14 + 1.0f) * lineBottom) + this.D;
                    iRound -= height;
                }
            }
            int i29 = iRound + height;
            int i31 = this.D;
            if (i29 <= i31) {
                int i32 = this.B;
                if (iRound < i32) {
                    i13 = i32;
                }
                this.E = new StaticLayout(spannableStringBuilder, this.f17368f, i27, alignment2, this.f17366d, this.f17367e, true);
                this.F = new StaticLayout(spannableStringBuilder2, this.f17368f, i27, alignment2, this.f17366d, this.f17367e, true);
                this.G = iMax;
                this.H = i13;
                this.I = i16;
            }
            iRound = i31 - height;
        } else {
            iRound = (this.D - height) - ((int) (i15 * this.f17388z));
        }
        i13 = iRound;
        this.E = new StaticLayout(spannableStringBuilder, this.f17368f, i27, alignment2, this.f17366d, this.f17367e, true);
        this.F = new StaticLayout(spannableStringBuilder2, this.f17368f, i27, alignment2, this.f17366d, this.f17367e, true);
        this.G = iMax;
        this.H = i13;
        this.I = i16;
    }

    private void b(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f17383u) > 0) {
            this.f17369g.setColor(this.f17383u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f17369g);
        }
        int i11 = this.f17385w;
        if (i11 == 1) {
            this.f17368f.setStrokeJoin(Paint.Join.ROUND);
            this.f17368f.setStrokeWidth(this.f17363a);
            this.f17368f.setColor(this.f17384v);
            this.f17368f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i11 == 2) {
            TextPaint textPaint = this.f17368f;
            float f11 = this.f17364b;
            float f12 = this.f17365c;
            textPaint.setShadowLayer(f11, f12, f12, this.f17384v);
        } else if (i11 == 3 || i11 == 4) {
            boolean z11 = i11 == 3;
            int i12 = z11 ? -1 : this.f17384v;
            int i13 = z11 ? this.f17384v : -1;
            float f13 = this.f17364b / 2.0f;
            this.f17368f.setColor(this.f17381s);
            this.f17368f.setStyle(Paint.Style.FILL);
            float f14 = -f13;
            this.f17368f.setShadowLayer(this.f17364b, f14, f14, i12);
            staticLayout2.draw(canvas);
            this.f17368f.setShadowLayer(this.f17364b, f13, f13, i13);
        }
        this.f17368f.setColor(this.f17381s);
        this.f17368f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f17368f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    public void a(b5 b5Var, x2 x2Var, float f11, float f12, float f13, Canvas canvas, int i11, int i12, int i13, int i14) {
        int i15;
        boolean z11 = b5Var.f17835d == null;
        if (!z11) {
            i15 = ViewCompat.MEASURED_STATE_MASK;
        } else if (TextUtils.isEmpty(b5Var.f17832a)) {
            return;
        } else {
            i15 = b5Var.f17843m ? b5Var.f17844n : x2Var.f24207c;
        }
        if (a(this.f17371i, b5Var.f17832a) && xp.a(this.f17372j, b5Var.f17833b) && this.f17373k == b5Var.f17835d && this.f17374l == b5Var.f17836f && this.f17375m == b5Var.f17837g && xp.a(Integer.valueOf(this.f17376n), Integer.valueOf(b5Var.f17838h)) && this.f17377o == b5Var.f17839i && xp.a(Integer.valueOf(this.f17378p), Integer.valueOf(b5Var.f17840j)) && this.f17379q == b5Var.f17841k && this.f17380r == b5Var.f17842l && this.f17381s == x2Var.f24205a && this.f17382t == x2Var.f24206b && this.f17383u == i15 && this.f17385w == x2Var.f24208d && this.f17384v == x2Var.f24209e && xp.a(this.f17368f.getTypeface(), x2Var.f24210f) && this.f17386x == f11 && this.f17387y == f12 && this.f17388z == f13 && this.A == i11 && this.B == i12 && this.C == i13 && this.D == i14) {
            a(canvas, z11);
            return;
        }
        this.f17371i = b5Var.f17832a;
        this.f17372j = b5Var.f17833b;
        this.f17373k = b5Var.f17835d;
        this.f17374l = b5Var.f17836f;
        this.f17375m = b5Var.f17837g;
        this.f17376n = b5Var.f17838h;
        this.f17377o = b5Var.f17839i;
        this.f17378p = b5Var.f17840j;
        this.f17379q = b5Var.f17841k;
        this.f17380r = b5Var.f17842l;
        this.f17381s = x2Var.f24205a;
        this.f17382t = x2Var.f24206b;
        this.f17383u = i15;
        this.f17385w = x2Var.f24208d;
        this.f17384v = x2Var.f24209e;
        this.f17368f.setTypeface(x2Var.f24210f);
        this.f17386x = f11;
        this.f17387y = f12;
        this.f17388z = f13;
        this.A = i11;
        this.B = i12;
        this.C = i13;
        this.D = i14;
        if (z11) {
            b1.a(this.f17371i);
            b();
        } else {
            b1.a(this.f17373k);
            a();
        }
        a(canvas, z11);
    }
}
