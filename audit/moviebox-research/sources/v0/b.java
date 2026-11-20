package v0;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f78670a;

    public b() {
        Paint paint = new Paint();
        this.f78670a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f78670a.setAntiAlias(true);
        this.f78670a.setColor(-5592406);
    }

    public void a(int i11) {
        this.f78670a.setColor(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f78670a.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f78670a.setColorFilter(colorFilter);
    }
}
