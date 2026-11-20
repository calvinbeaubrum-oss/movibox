package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.tn.lib.view.FlowLayout;
import h20.c;
import i20.a;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class TestPagerIndicator extends View implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f71850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f71853d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f71854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<a> f71855g;

    public TestPagerIndicator(Context context) {
        super(context);
        this.f71853d = new RectF();
        this.f71854f = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f71850a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f71851b = FlowLayout.SPACING_AUTO;
        this.f71852c = -16711936;
    }

    public int getInnerRectColor() {
        return this.f71852c;
    }

    public int getOutRectColor() {
        return this.f71851b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f71850a.setColor(this.f71851b);
        canvas.drawRect(this.f71853d, this.f71850a);
        this.f71850a.setColor(this.f71852c);
        canvas.drawRect(this.f71854f, this.f71850a);
    }

    @Override // h20.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // h20.c
    public void onPageScrolled(int i11, float f11, int i12) {
        List<a> list = this.f71855g;
        if (list == null || list.isEmpty()) {
            return;
        }
        a aVarA = e20.a.a(this.f71855g, i11);
        a aVarA2 = e20.a.a(this.f71855g, i11 + 1);
        RectF rectF = this.f71853d;
        int i13 = aVarA.f66885a;
        rectF.left = i13 + ((aVarA2.f66885a - i13) * f11);
        int i14 = aVarA.f66886b;
        rectF.top = i14 + ((aVarA2.f66886b - i14) * f11);
        int i15 = aVarA.f66887c;
        rectF.right = i15 + ((aVarA2.f66887c - i15) * f11);
        int i16 = aVarA.f66888d;
        rectF.bottom = i16 + ((aVarA2.f66888d - i16) * f11);
        RectF rectF2 = this.f71854f;
        int i17 = aVarA.f66889e;
        rectF2.left = i17 + ((aVarA2.f66889e - i17) * f11);
        int i18 = aVarA.f66890f;
        rectF2.top = i18 + ((aVarA2.f66890f - i18) * f11);
        int i19 = aVarA.f66891g;
        rectF2.right = i19 + ((aVarA2.f66891g - i19) * f11);
        int i21 = aVarA.f66892h;
        rectF2.bottom = i21 + ((aVarA2.f66892h - i21) * f11);
        invalidate();
    }

    @Override // h20.c
    public void onPageSelected(int i11) {
    }

    @Override // h20.c
    public void onPositionDataProvide(List<a> list) {
        this.f71855g = list;
    }

    public void setInnerRectColor(int i11) {
        this.f71852c = i11;
    }

    public void setOutRectColor(int i11) {
        this.f71851b = i11;
    }
}
