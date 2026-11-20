package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public abstract class i extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final o f8345b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f8344a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short f8346c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short f8347d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f8348f = 1.0f;

    public i(@NonNull o oVar) {
        androidx.core.util.i.h(oVar, "rasterizer cannot be null");
        this.f8345b = oVar;
    }

    @NonNull
    public final o a() {
        return this.f8345b;
    }

    public final int b() {
        return this.f8346c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i11, int i12, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f8344a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f8344a;
        this.f8348f = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f8345b.e();
        this.f8347d = (short) (this.f8345b.e() * this.f8348f);
        short sI = (short) (this.f8345b.i() * this.f8348f);
        this.f8346c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f8344a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
