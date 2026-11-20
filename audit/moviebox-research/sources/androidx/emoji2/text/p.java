package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public final class p extends i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public static Paint f8378h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public TextPaint f8379g;

    public p(@NonNull o oVar) {
        super(oVar);
    }

    @NonNull
    public static Paint e() {
        if (f8378h == null) {
            TextPaint textPaint = new TextPaint();
            f8378h = textPaint;
            textPaint.setColor(EmojiCompat.c().d());
            f8378h.setStyle(Paint.Style.FILL);
        }
        return f8378h;
    }

    @Nullable
    public final TextPaint c(@Nullable CharSequence charSequence, int i11, int i12, Paint paint) {
        if (!(charSequence instanceof Spanned)) {
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        }
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i11, i12, CharacterStyle.class);
        if (characterStyleArr.length != 0) {
            if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                TextPaint textPaint = this.f8379g;
                if (textPaint == null) {
                    textPaint = new TextPaint();
                    this.f8379g = textPaint;
                }
                textPaint.set(paint);
                for (CharacterStyle characterStyle : characterStyleArr) {
                    characterStyle.updateDrawState(textPaint);
                }
                return textPaint;
            }
        }
        if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        }
        return null;
    }

    public void d(Canvas canvas, TextPaint textPaint, float f11, float f12, float f13, float f14) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f11, f13, f12, f14, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, @NonNull Paint paint) {
        Paint paint2 = paint;
        TextPaint textPaintC = c(charSequence, i11, i12, paint2);
        if (textPaintC != null && textPaintC.bgColor != 0) {
            d(canvas, textPaintC, f11, f11 + b(), i13, i15);
        }
        if (EmojiCompat.c().j()) {
            canvas.drawRect(f11, i13, f11 + b(), i15, e());
        }
        o oVarA = a();
        float f12 = i14;
        if (textPaintC != null) {
            paint2 = textPaintC;
        }
        oVarA.a(canvas, f11, f12, paint2);
    }
}
