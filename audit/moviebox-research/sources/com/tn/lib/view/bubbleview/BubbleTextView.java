package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BubbleTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BubbleDrawable f49822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f49823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49825d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f49826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f49828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BubbleDrawable.ArrowLocation f49829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f49830j;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49831a;

        static {
            int[] iArr = new int[BubbleDrawable.ArrowLocation.values().length];
            f49831a = iArr;
            try {
                iArr[BubbleDrawable.ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49831a[BubbleDrawable.ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49831a[BubbleDrawable.ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49831a[BubbleDrawable.ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BubbleTextView(Context context) {
        super(context);
        a(null);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f49823b = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f49708u);
            this.f49825d = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f49709v);
            this.f49824c = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f49710w);
            this.f49826f = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f49711x);
            this.f49827g = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f49712y);
            this.f49829i = BubbleDrawable.ArrowLocation.mapIntToValue(typedArrayObtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f49830j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            this.f49828h = typedArrayObtainStyledAttributes.getInt(R$styleable.BubbleView_bubbleAlpha, 255);
            typedArrayObtainStyledAttributes.recycle();
        }
        e();
    }

    private void b() {
        c(getWidth(), getHeight());
    }

    private void c(int i11, int i12) {
        d(0, i11, 0, i12);
    }

    private void d(int i11, int i12, int i13, int i14) {
        this.f49822a = new BubbleDrawable.b().B(new RectF(i11, i13, i12, i14)).t(this.f49829i).z(BubbleDrawable.BubbleType.COLOR).q(this.f49824c).p(this.f49828h).s(this.f49825d).v(this.f49823b).x(this.f49827g).u(this.f49826f).r(this.f49830j).A();
    }

    public final void e() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i11 = a.f49831a[this.f49829i.ordinal()];
        if (i11 == 1) {
            paddingLeft = (int) (paddingLeft + this.f49823b);
        } else if (i11 == 2) {
            paddingRight = (int) (paddingRight + this.f49823b);
        } else if (i11 == 3) {
            paddingTop = (int) (paddingTop + this.f49825d);
        } else if (i11 == 4) {
            paddingBottom = (int) (paddingBottom + this.f49825d);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        b();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        BubbleDrawable bubbleDrawable = this.f49822a;
        if (bubbleDrawable != null) {
            bubbleDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        c(i11, i12);
    }

    public void setArrowPosition(float f11) {
        this.f49826f = f11;
        b();
    }
}
