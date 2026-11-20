package xi;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f80564i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f80565j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f80566k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f80567l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Paint f80568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Paint f80569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Paint f80570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f80571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f80572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f80573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f80574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f80575h;

    public a() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public a(int i11) {
        this.f80574g = new Path();
        Paint paint = new Paint();
        this.f80575h = paint;
        this.f80568a = new Paint();
        d(i11);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f80569b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f80570c = new Paint(paint2);
    }

    public void a(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i11, float f11, float f12) {
        boolean z11 = f12 < 0.0f;
        Path path = this.f80574g;
        if (z11) {
            int[] iArr = f80566k;
            iArr[0] = 0;
            iArr[1] = this.f80573f;
            iArr[2] = this.f80572e;
            iArr[3] = this.f80571d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f11, f12);
            path.close();
            float f13 = -i11;
            rectF.inset(f13, f13);
            int[] iArr2 = f80566k;
            iArr2[0] = 0;
            iArr2[1] = this.f80571d;
            iArr2[2] = this.f80572e;
            iArr2[3] = this.f80573f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f14 = 1.0f - (i11 / fWidth);
        float[] fArr = f80567l;
        fArr[1] = f14;
        fArr[2] = ((1.0f - f14) / 2.0f) + f14;
        this.f80569b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f80566k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z11) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f80575h);
        }
        canvas.drawArc(rectF, f11, f12, true, this.f80569b);
        canvas.restore();
    }

    public void b(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i11) {
        rectF.bottom += i11;
        rectF.offset(0.0f, -i11);
        int[] iArr = f80564i;
        iArr[0] = this.f80573f;
        iArr[1] = this.f80572e;
        iArr[2] = this.f80571d;
        Paint paint = this.f80570c;
        float f11 = rectF.left;
        paint.setShader(new LinearGradient(f11, rectF.top, f11, rectF.bottom, iArr, f80565j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f80570c);
        canvas.restore();
    }

    @NonNull
    public Paint c() {
        return this.f80568a;
    }

    public void d(int i11) {
        this.f80571d = c3.b.k(i11, 68);
        this.f80572e = c3.b.k(i11, 20);
        this.f80573f = c3.b.k(i11, 0);
        this.f80568a.setColor(this.f80571d);
    }
}
