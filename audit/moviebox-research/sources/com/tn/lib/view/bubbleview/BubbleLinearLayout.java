package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BubbleLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BubbleDrawable f49810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f49811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49813d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f49814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f49815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f49816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f49817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f49818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BubbleDrawable.ArrowLocation f49819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f49821m;

    public BubbleLinearLayout(Context context) {
        super(context);
        b(null);
    }

    public BubbleLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public final void b(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f49811b = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.f49812c = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.f49813d = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.f49814f = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.f49815g = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f49708u);
            this.f49817i = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f49709v);
            this.f49816h = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f49710w);
            this.f49818j = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f49711x);
            this.f49820l = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f49712y);
            this.f49819k = BubbleDrawable.ArrowLocation.mapIntToValue(typedArrayObtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f49821m = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void c(int i11, int i12) {
        d((int) ((getPaddingLeft() + this.f49811b) - this.f49813d), (int) (((i11 - getPaddingRight()) - this.f49811b) - this.f49813d), (int) ((getPaddingTop() + this.f49811b) - this.f49814f), (int) (((i12 - getPaddingBottom()) - this.f49811b) - this.f49814f));
        setBackgroundDrawable(this.f49810a);
    }

    public final void d(int i11, int i12, int i13, int i14) {
        if (i12 < i11 || i14 < i13) {
            return;
        }
        this.f49810a = new BubbleDrawable.b().B(new RectF(i11, i13, i12, i14)).t(this.f49819k).z(BubbleDrawable.BubbleType.COLOR).q(this.f49816h).s(this.f49817i).v(this.f49815g).u(this.f49818j).x(this.f49820l).r(this.f49821m).F(this.f49811b).C(this.f49812c).D(this.f49813d).E(this.f49814f).A();
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        c(i11, i12);
    }

    public void setUpBubbleDrawable() {
        setBackgroundDrawable(null);
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleLinearLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleLinearLayout bubbleLinearLayout = BubbleLinearLayout.this;
                bubbleLinearLayout.c(bubbleLinearLayout.getWidth(), BubbleLinearLayout.this.getHeight());
            }
        });
    }
}
