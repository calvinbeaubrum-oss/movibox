package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MockView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f7203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f7204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f7205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7206d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f7209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7213l;

    public MockView(Context context) {
        super(context);
        this.f7203a = new Paint();
        this.f7204b = new Paint();
        this.f7205c = new Paint();
        this.f7206d = true;
        this.f7207f = true;
        this.f7208g = null;
        this.f7209h = new Rect();
        this.f7210i = Color.argb(255, 0, 0, 0);
        this.f7211j = Color.argb(255, 200, 200, 200);
        this.f7212k = Color.argb(255, 50, 50, 50);
        this.f7213l = 4;
        a(context, null);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7203a = new Paint();
        this.f7204b = new Paint();
        this.f7205c = new Paint();
        this.f7206d = true;
        this.f7207f = true;
        this.f7208g = null;
        this.f7209h = new Rect();
        this.f7210i = Color.argb(255, 0, 0, 0);
        this.f7211j = Color.argb(255, 200, 200, 200);
        this.f7212k = Color.argb(255, 50, 50, 50);
        this.f7213l = 4;
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7203a = new Paint();
        this.f7204b = new Paint();
        this.f7205c = new Paint();
        this.f7206d = true;
        this.f7207f = true;
        this.f7208g = null;
        this.f7209h = new Rect();
        this.f7210i = Color.argb(255, 0, 0, 0);
        this.f7211j = Color.argb(255, 200, 200, 200);
        this.f7212k = Color.argb(255, 50, 50, 50);
        this.f7213l = 4;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MockView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MockView_mock_label) {
                    this.f7208g = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MockView_mock_showDiagonals) {
                    this.f7206d = typedArrayObtainStyledAttributes.getBoolean(index, this.f7206d);
                } else if (index == R$styleable.MockView_mock_diagonalsColor) {
                    this.f7210i = typedArrayObtainStyledAttributes.getColor(index, this.f7210i);
                } else if (index == R$styleable.MockView_mock_labelBackgroundColor) {
                    this.f7212k = typedArrayObtainStyledAttributes.getColor(index, this.f7212k);
                } else if (index == R$styleable.MockView_mock_labelColor) {
                    this.f7211j = typedArrayObtainStyledAttributes.getColor(index, this.f7211j);
                } else if (index == R$styleable.MockView_mock_showLabel) {
                    this.f7207f = typedArrayObtainStyledAttributes.getBoolean(index, this.f7207f);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f7208g == null) {
            try {
                this.f7208g = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f7203a.setColor(this.f7210i);
        this.f7203a.setAntiAlias(true);
        this.f7204b.setColor(this.f7211j);
        this.f7204b.setAntiAlias(true);
        this.f7205c.setColor(this.f7212k);
        this.f7213l = Math.round(this.f7213l * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f7206d) {
            width--;
            height--;
            float f11 = width;
            float f12 = height;
            canvas.drawLine(0.0f, 0.0f, f11, f12, this.f7203a);
            canvas.drawLine(0.0f, f12, f11, 0.0f, this.f7203a);
            canvas.drawLine(0.0f, 0.0f, f11, 0.0f, this.f7203a);
            canvas.drawLine(f11, 0.0f, f11, f12, this.f7203a);
            canvas.drawLine(f11, f12, 0.0f, f12, this.f7203a);
            canvas.drawLine(0.0f, f12, 0.0f, 0.0f, this.f7203a);
        }
        String str = this.f7208g;
        if (str == null || !this.f7207f) {
            return;
        }
        this.f7204b.getTextBounds(str, 0, str.length(), this.f7209h);
        float fWidth = (width - this.f7209h.width()) / 2.0f;
        float fHeight = ((height - this.f7209h.height()) / 2.0f) + this.f7209h.height();
        this.f7209h.offset((int) fWidth, (int) fHeight);
        Rect rect = this.f7209h;
        int i11 = rect.left;
        int i12 = this.f7213l;
        rect.set(i11 - i12, rect.top - i12, rect.right + i12, rect.bottom + i12);
        canvas.drawRect(this.f7209h, this.f7205c);
        canvas.drawText(this.f7208g, fWidth, fHeight, this.f7204b);
    }
}
