package com.transsnet.login.country.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tn.lib.widget.R$color;
import com.transsnet.login.R$dimen;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class SideBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f61466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextPaint f61467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f61468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f61469d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f61470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f61471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f61472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f61473i;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void t(String str);
    }

    public SideBar(Context context) {
        super(context.getApplicationContext());
        this.f61468c = -1;
        this.f61470f = -1.0f;
        this.f61471g = -1;
        this.f61472h = -1;
        this.f61473i = -1.0f;
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        this.f61468c = -1;
        this.f61470f = -1.0f;
        this.f61471g = -1;
        this.f61472h = -1;
        this.f61473i = -1.0f;
        setBackgroundColor(0);
    }

    public final void a(Canvas canvas) {
        if (this.f61471g < 0) {
            this.f61471g = getContext().getResources().getDimensionPixelSize(R$dimen.side_bar_txt_size);
            this.f61472h = z2.a.getColor(getContext(), R$color.text_03);
            this.f61470f = this.f61471g * 1.5f;
        }
        int i11 = 0;
        for (String str : this.f61466a) {
            this.f61467b.setTextSize(this.f61471g);
            this.f61467b.setAntiAlias(true);
            this.f61467b.setColor(this.f61472h);
            if (i11 == this.f61468c) {
                this.f61467b.setColor(z2.a.getColor(getContext(), R$color.text_01));
                this.f61467b.setFakeBoldText(true);
            }
            if (this.f61473i < 0.0f) {
                this.f61473i = ((getWidth() * 1.0f) / 2.0f) - (this.f61467b.measureText(str) / 2.0f);
            }
            float f11 = this.f61470f;
            canvas.drawText(str, this.f61473i, (i11 * f11) + f11, this.f61467b);
            this.f61467b.reset();
            i11++;
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f61466a == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        motionEvent.getX();
        float y11 = motionEvent.getY();
        int i11 = this.f61468c;
        int height = (int) ((y11 / getHeight()) * this.f61466a.size());
        if (action == 1 || action == 3) {
            setBackgroundColor(0);
            invalidate();
        } else {
            setBackgroundColor(0);
            if (i11 != height && height >= 0 && height < this.f61466a.size()) {
                a aVar = this.f61469d;
                if (aVar != null) {
                    aVar.t(this.f61466a.get(height));
                }
                this.f61468c = height;
                invalidate();
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<String> list = this.f61466a;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f61467b == null) {
            this.f61467b = new TextPaint(1);
        }
        a(canvas);
    }

    public void setIndexs(List<String> list) {
        this.f61466a = list;
        if (this.f61471g < 0) {
            this.f61471g = getContext().getResources().getDimensionPixelSize(R$dimen.side_bar_txt_size);
            this.f61472h = z2.a.getColor(getContext(), R$color.text_03);
            this.f61470f = this.f61471g * 1.5f;
        }
        if (list != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (int) (this.f61470f * list.size());
            setLayoutParams(layoutParams);
        }
        invalidate();
    }

    public void setScrollerListener(a aVar) {
        this.f61469d = aVar;
    }

    public void updateIndex(int i11) {
        this.f61468c = i11;
        invalidate();
    }
}
