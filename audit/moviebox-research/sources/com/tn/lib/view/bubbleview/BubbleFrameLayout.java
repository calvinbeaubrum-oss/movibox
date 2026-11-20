package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BubbleFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BubbleDrawable f49734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f49735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49737d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f49738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f49739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f49740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f49741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f49742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BubbleDrawable.ArrowLocation f49743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f49745m;

    public BubbleFrameLayout(Context context) {
        super(context);
        b(null);
    }

    public BubbleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public final void b(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f49735b = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.f49736c = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.f49737d = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.f49738f = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.f49739g = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f49708u);
            this.f49741i = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f49709v);
            this.f49740h = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f49710w);
            this.f49742j = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f49711x);
            this.f49744l = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f49712y);
            this.f49743k = BubbleDrawable.ArrowLocation.mapIntToValue(typedArrayObtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f49745m = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void c(int i11, int i12) {
        d((int) ((getPaddingLeft() + this.f49735b) - this.f49737d), (int) (((i11 - getPaddingRight()) - this.f49735b) - this.f49737d), (int) ((getPaddingTop() + this.f49735b) - this.f49738f), (int) (((i12 - getPaddingBottom()) - this.f49735b) - this.f49738f));
        setBackgroundDrawable(this.f49734a);
    }

    public final void d(int i11, int i12, int i13, int i14) {
        if (i12 < i11 || i14 < i13) {
            return;
        }
        this.f49734a = new BubbleDrawable.b().B(new RectF(i11, i13, i12, i14)).t(this.f49743k).z(BubbleDrawable.BubbleType.COLOR).q(this.f49740h).s(this.f49741i).v(this.f49739g).u(this.f49742j).x(this.f49744l).r(this.f49745m).F(this.f49735b).C(this.f49736c).D(this.f49737d).E(this.f49738f).A();
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
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleFrameLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleFrameLayout bubbleFrameLayout = BubbleFrameLayout.this;
                bubbleFrameLayout.c(bubbleFrameLayout.getWidth(), BubbleFrameLayout.this.getHeight());
            }
        });
    }
}
