package is;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f67699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f67700b = 0;

    public f(float f11) {
        this.f67699a = f11;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Rect rect;
        view.getGlobalVisibleRect(new Rect());
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = this.f67700b;
        if (i11 == 1) {
            rect = new Rect(0, 0, (int) Math.ceil(measuredWidth + (this.f67699a * 2.0f)), measuredHeight);
        } else if (i11 == 2) {
            rect = new Rect((int) Math.floor(this.f67699a * (-2.0f)), 0, measuredWidth, measuredHeight);
        } else if (i11 == 3) {
            rect = new Rect(0, 0, measuredWidth, (int) Math.ceil(measuredHeight + (this.f67699a * 2.0f)));
        } else {
            rect = i11 == 4 ? new Rect(0, (int) Math.floor(this.f67699a * (-2.0f)), measuredWidth, measuredHeight) : new Rect(0, 0, measuredWidth, measuredHeight);
        }
        outline.setRoundRect(rect, this.f67699a);
    }
}
