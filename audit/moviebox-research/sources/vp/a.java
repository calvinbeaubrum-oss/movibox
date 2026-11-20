package vp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Uri f79031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f79032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f79033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<Drawable> f79034d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f79035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f79036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f79037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f79038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f79039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f79040k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f79041l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f79042m;

    public a(Context context, int i11, int i12, int i13, float f11, int i14, boolean z11) {
        this.f79033c = context;
        this.f79032b = i11;
        this.f79035f = i13;
        this.f79036g = i12;
        this.f79037h = a(context, i14);
        this.f79039j = a(context, 1.0f);
        this.f79040k = a(context, 1.0f);
        this.f79038i = a(context, 4.0f);
        this.f79041l = f11;
        this.f79042m = z11;
    }

    public static int a(Context context, float f11) {
        return tp.f.f77260a.a(context, f11);
    }

    public final Drawable b() {
        WeakReference<Drawable> weakReference = this.f79034d;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawableC = c();
        this.f79034d = new WeakReference<>(drawableC);
        return drawableC;
    }

    public Drawable c() {
        Drawable drawable = null;
        try {
            if (this.f79031a != null) {
                InputStream inputStreamOpenInputStream = this.f79033c.getContentResolver().openInputStream(this.f79031a);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f79033c.getResources(), BitmapFactory.decodeStream(inputStreamOpenInputStream));
                try {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    inputStreamOpenInputStream.close();
                    return bitmapDrawable;
                } catch (Exception unused) {
                    drawable = bitmapDrawable;
                }
            } else if (this.f79032b != -111) {
                drawable = this.f79033c.getResources().getDrawable(this.f79032b);
                drawable.setColorFilter(this.f79036g, PorterDuff.Mode.SRC_IN);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
        } catch (Exception unused2) {
        }
        return drawable;
    }

    public final int d() {
        Drawable drawableB = b();
        if (drawableB == null) {
            return 0;
        }
        return drawableB.getIntrinsicWidth();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, @NonNull Paint paint) {
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        paint.setColor(this.f79035f);
        boolean z11 = this.f79042m;
        int i16 = z11 ? 0 : 6;
        int i17 = z11 ? 6 : 0;
        float f12 = i16;
        float size = f11 + getSize(paint, charSequence, i11, i12, paint.getFontMetricsInt());
        RectF rectF = new RectF(f11 + f12, i13 + this.f79039j, size - i17, i15 - this.f79040k);
        int i18 = this.f79038i;
        canvas.drawRoundRect(rectF, i18, i18, paint);
        paint.setColor(this.f79036g);
        paint.setTextSize(this.f79041l);
        canvas.drawText(charSequence, i11, i12, f11 + this.f79037h, i14 - ((this.f79039j + this.f79040k) / 2), paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
        Drawable drawableB = b();
        if (drawableB != null) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i19 = (i14 + ((fontMetricsInt.descent + fontMetricsInt.ascent) / 2)) - (drawableB.getBounds().bottom / 2);
            canvas.save();
            canvas.translate(((size - this.f79037h) - d()) + f12, i19);
            drawableB.draw(canvas);
            canvas.restore();
        }
    }

    public int e(@NonNull Paint paint, CharSequence charSequence, CharSequence charSequence2) {
        int iD = (this.f79037h * 2) + d();
        if (!TextUtils.isEmpty(charSequence)) {
            iD += (int) paint.measureText(charSequence, 0, charSequence.length());
        }
        if (TextUtils.isEmpty(charSequence2)) {
            return iD;
        }
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f79041l);
        int iMeasureText = iD + ((int) paint.measureText(charSequence2, 0, charSequence2.length()));
        paint.setTextSize(textSize);
        return iMeasureText;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i11, int i12, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f79041l);
        int iMeasureText = ((int) paint.measureText(charSequence, i11, i12)) + (this.f79037h * 2) + d();
        paint.setTextSize(textSize);
        return iMeasureText;
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f79041l * textPaint.density);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f79041l * textPaint.density);
    }
}
