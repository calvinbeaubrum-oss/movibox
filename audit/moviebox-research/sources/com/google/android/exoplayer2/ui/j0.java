package com.google.android.exoplayer2.ui;

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
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j0 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f35150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f35151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f35152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f35153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f35154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextPaint f35155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f35156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f35157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public CharSequence f35158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Layout.Alignment f35159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public Bitmap f35160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f35161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f35162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f35163n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f35164o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f35165p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f35166q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f35167r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f35168s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f35169t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f35170u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f35171v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f35172w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f35173x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f35174y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f35175z;

    public j0(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f35154e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f35153d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f35150a = fRound;
        this.f35151b = fRound;
        this.f35152c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f35155f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f35156g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f35157h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public static boolean a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    public void b(vh.b bVar, c cVar, float f11, float f12, float f13, Canvas canvas, int i11, int i12, int i13, int i14) {
        int i15;
        boolean z11 = bVar.f78821d == null;
        if (!z11) {
            i15 = ViewCompat.MEASURED_STATE_MASK;
        } else if (TextUtils.isEmpty(bVar.f78818a)) {
            return;
        } else {
            i15 = bVar.f78829m ? bVar.f78830n : cVar.f35097c;
        }
        if (a(this.f35158i, bVar.f78818a) && com.google.android.exoplayer2.util.o0.c(this.f35159j, bVar.f78819b) && this.f35160k == bVar.f78821d && this.f35161l == bVar.f78822f && this.f35162m == bVar.f78823g && com.google.android.exoplayer2.util.o0.c(Integer.valueOf(this.f35163n), Integer.valueOf(bVar.f78824h)) && this.f35164o == bVar.f78825i && com.google.android.exoplayer2.util.o0.c(Integer.valueOf(this.f35165p), Integer.valueOf(bVar.f78826j)) && this.f35166q == bVar.f78827k && this.f35167r == bVar.f78828l && this.f35168s == cVar.f35095a && this.f35169t == cVar.f35096b && this.f35170u == i15 && this.f35172w == cVar.f35098d && this.f35171v == cVar.f35099e && com.google.android.exoplayer2.util.o0.c(this.f35155f.getTypeface(), cVar.f35100f) && this.f35173x == f11 && this.f35174y == f12 && this.f35175z == f13 && this.A == i11 && this.B == i12 && this.C == i13 && this.D == i14) {
            d(canvas, z11);
            return;
        }
        this.f35158i = bVar.f78818a;
        this.f35159j = bVar.f78819b;
        this.f35160k = bVar.f78821d;
        this.f35161l = bVar.f78822f;
        this.f35162m = bVar.f78823g;
        this.f35163n = bVar.f78824h;
        this.f35164o = bVar.f78825i;
        this.f35165p = bVar.f78826j;
        this.f35166q = bVar.f78827k;
        this.f35167r = bVar.f78828l;
        this.f35168s = cVar.f35095a;
        this.f35169t = cVar.f35096b;
        this.f35170u = i15;
        this.f35172w = cVar.f35098d;
        this.f35171v = cVar.f35099e;
        this.f35155f.setTypeface(cVar.f35100f);
        this.f35173x = f11;
        this.f35174y = f12;
        this.f35175z = f13;
        this.A = i11;
        this.B = i12;
        this.C = i13;
        this.D = i14;
        if (z11) {
            com.google.android.exoplayer2.util.a.e(this.f35158i);
            g();
        } else {
            com.google.android.exoplayer2.util.a.e(this.f35160k);
            f();
        }
        d(canvas, z11);
    }

    public final void c(Canvas canvas) {
        canvas.drawBitmap(this.f35160k, (Rect) null, this.J, this.f35157h);
    }

    public final void d(Canvas canvas, boolean z11) {
        if (z11) {
            e(canvas);
            return;
        }
        com.google.android.exoplayer2.util.a.e(this.J);
        com.google.android.exoplayer2.util.a.e(this.f35160k);
        c(canvas);
    }

    public final void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f35170u) > 0) {
            this.f35156g.setColor(this.f35170u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f35156g);
        }
        int i11 = this.f35172w;
        if (i11 == 1) {
            this.f35155f.setStrokeJoin(Paint.Join.ROUND);
            this.f35155f.setStrokeWidth(this.f35150a);
            this.f35155f.setColor(this.f35171v);
            this.f35155f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i11 == 2) {
            TextPaint textPaint = this.f35155f;
            float f11 = this.f35151b;
            float f12 = this.f35152c;
            textPaint.setShadowLayer(f11, f12, f12, this.f35171v);
        } else if (i11 == 3 || i11 == 4) {
            boolean z11 = i11 == 3;
            int i12 = z11 ? -1 : this.f35171v;
            int i13 = z11 ? this.f35171v : -1;
            float f13 = this.f35151b / 2.0f;
            this.f35155f.setColor(this.f35168s);
            this.f35155f.setStyle(Paint.Style.FILL);
            float f14 = -f13;
            this.f35155f.setShadowLayer(this.f35151b, f14, f14, i12);
            staticLayout2.draw(canvas);
            this.f35155f.setShadowLayer(this.f35151b, f13, f13, i13);
        }
        this.f35155f.setColor(this.f35168s);
        this.f35155f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f35155f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005b  */
    /* JADX WARN: Code duplicated, block: B:16:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0060  */
    public final void f() {
        float f11;
        int i11;
        float f12;
        Bitmap bitmap = this.f35160k;
        int i12 = this.C;
        int i13 = this.A;
        int i14 = this.D;
        int i15 = this.B;
        float f13 = i12 - i13;
        float f14 = i13 + (this.f35164o * f13);
        float f15 = i14 - i15;
        float f16 = i15 + (this.f35161l * f15);
        int iRound = Math.round(f13 * this.f35166q);
        float f17 = this.f35167r;
        int iRound2 = f17 != -3.4028235E38f ? Math.round(f15 * f17) : Math.round(iRound * (bitmap.getHeight() / bitmap.getWidth()));
        int i16 = this.f35165p;
        if (i16 != 2) {
            if (i16 == 1) {
                f11 = iRound / 2;
            }
            int iRound3 = Math.round(f14);
            i11 = this.f35163n;
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
        i11 = this.f35163n;
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

    public final void g() {
        int i11;
        int i12;
        int iMax;
        int iMin;
        int iRound;
        int i13;
        CharSequence charSequence = this.f35158i;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(this.f35158i);
        int i14 = this.C - this.A;
        int i15 = this.D - this.B;
        this.f35155f.setTextSize(this.f35173x);
        int i16 = (int) ((this.f35173x * 0.125f) + 0.5f);
        int i17 = i16 * 2;
        int i18 = i14 - i17;
        float f11 = this.f35166q;
        if (f11 != -3.4028235E38f) {
            i18 = (int) (i18 * f11);
        }
        int i19 = i18;
        if (i19 <= 0) {
            com.google.android.exoplayer2.util.s.i("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.f35174y > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.f35174y), 0, spannableStringBuilder.length(), 16711680);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.f35172w == 1) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (Color.alpha(this.f35169t) > 0) {
            int i21 = this.f35172w;
            if (i21 == 0 || i21 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f35169t), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.f35169t), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.f35159j;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.f35155f, i19, alignment2, this.f35153d, this.f35154e, true);
        this.E = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.E.getLineCount();
        int iMax2 = 0;
        for (int i22 = 0; i22 < lineCount; i22++) {
            iMax2 = Math.max((int) Math.ceil(this.E.getLineWidth(i22)), iMax2);
        }
        if (this.f35166q == -3.4028235E38f || iMax2 >= i19) {
            i19 = iMax2;
        }
        int i23 = i19 + i17;
        float f12 = this.f35164o;
        if (f12 != -3.4028235E38f) {
            int iRound2 = Math.round(i14 * f12);
            int i24 = this.A;
            int i25 = iRound2 + i24;
            int i26 = this.f35165p;
            i11 = 1;
            if (i26 != 1) {
                i12 = 2;
                if (i26 == 2) {
                    i25 -= i23;
                }
            } else {
                i12 = 2;
                i25 = ((i25 * 2) - i23) / 2;
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
            com.google.android.exoplayer2.util.s.i("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f13 = this.f35161l;
        if (f13 != -3.4028235E38f) {
            if (this.f35162m == 0) {
                iRound = Math.round(i15 * f13) + this.B;
                int i28 = this.f35163n;
                if (i28 == i12) {
                    iRound -= height;
                } else if (i28 == i11) {
                    iRound = ((iRound * 2) - height) / i12;
                }
            } else {
                int lineBottom = this.E.getLineBottom(0) - this.E.getLineTop(0);
                float f14 = this.f35161l;
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
                this.E = new StaticLayout(spannableStringBuilder, this.f35155f, i27, alignment2, this.f35153d, this.f35154e, true);
                this.F = new StaticLayout(spannableStringBuilder2, this.f35155f, i27, alignment2, this.f35153d, this.f35154e, true);
                this.G = iMax;
                this.H = i13;
                this.I = i16;
            }
            iRound = i31 - height;
        } else {
            iRound = (this.D - height) - ((int) (i15 * this.f35175z));
        }
        i13 = iRound;
        this.E = new StaticLayout(spannableStringBuilder, this.f35155f, i27, alignment2, this.f35153d, this.f35154e, true);
        this.F = new StaticLayout(spannableStringBuilder2, this.f35155f, i27, alignment2, this.f35153d, this.f35154e, true);
        this.G = iMax;
        this.H = i13;
        this.I = i16;
    }
}
