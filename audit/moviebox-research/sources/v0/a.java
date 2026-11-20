package v0;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f78667b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f78668c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f78669d = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (this.f78667b != iWidth || this.f78668c != iHeight) {
            this.f78669d.reset();
            float f11 = (iWidth * 30) / 225;
            float f12 = f11 * 0.70710677f;
            float f13 = f11 / 0.70710677f;
            float f14 = iWidth;
            float f15 = f14 / 2.0f;
            float f16 = iHeight;
            this.f78669d.moveTo(f15, f16);
            float f17 = f16 / 2.0f;
            this.f78669d.lineTo(0.0f, f17);
            float f18 = f17 - f12;
            this.f78669d.lineTo(f12, f18);
            float f19 = f11 / 2.0f;
            float f21 = f15 - f19;
            float f22 = (f16 - f13) - f19;
            this.f78669d.lineTo(f21, f22);
            this.f78669d.lineTo(f21, 0.0f);
            float f23 = f15 + f19;
            this.f78669d.lineTo(f23, 0.0f);
            this.f78669d.lineTo(f23, f22);
            this.f78669d.lineTo(f14 - f12, f18);
            this.f78669d.lineTo(f14, f17);
            this.f78669d.close();
            this.f78667b = iWidth;
            this.f78668c = iHeight;
        }
        canvas.drawPath(this.f78669d, this.f78670a);
    }
}
