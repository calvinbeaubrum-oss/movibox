package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.m;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@ViewPager.c
public class PagerTitleStrip extends ViewGroup {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f13087p = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f13088q = {R.attr.textAllCaps};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f13089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f13090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f13091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f13092d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f13094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f13099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeakReference<PagerAdapter> f13100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13101n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13102o;

    /* JADX INFO: compiled from: source.java */
    public class a extends DataSetObserver implements ViewPager.h, ViewPager.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13103a;

        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.g
        public void a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.a(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.b(pagerTitleStrip.f13089a.getCurrentItem(), PagerTitleStrip.this.f13089a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f11 = pagerTitleStrip2.f13094g;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            pagerTitleStrip2.c(pagerTitleStrip2.f13089a.getCurrentItem(), f11, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageScrollStateChanged(int i11) {
            this.f13103a = i11;
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageScrolled(int i11, float f11, int i12) {
            if (f11 > 0.5f) {
                i11++;
            }
            PagerTitleStrip.this.c(i11, f11, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageSelected(int i11) {
            if (this.f13103a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.b(pagerTitleStrip.f13089a.getCurrentItem(), PagerTitleStrip.this.f13089a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f11 = pagerTitleStrip2.f13094g;
                if (f11 < 0.0f) {
                    f11 = 0.0f;
                }
                pagerTitleStrip2.c(pagerTitleStrip2.f13089a.getCurrentItem(), f11, true);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Locale f13105a;

        public b(Context context) {
            this.f13105a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f13105a);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x00c0  */
    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13093f = -1;
        this.f13094g = -1.0f;
        this.f13099l = new a();
        TextView textView = new TextView(context);
        this.f13090b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f13091c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f13092d = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f13087p);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            m.p(this.f13090b, resourceId);
            m.p(this.f13091c, resourceId);
            m.p(this.f13092d, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            this.f13090b.setTextColor(color);
            this.f13091c.setTextColor(color);
            this.f13092d.setTextColor(color);
        }
        this.f13096i = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.f13102o = this.f13091c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextView textView4 = this.f13090b;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.f13091c.setEllipsize(truncateAt);
        this.f13092d.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f13088q);
            boolean z11 = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
            if (z11) {
                setSingleLineAllCaps(this.f13090b);
                setSingleLineAllCaps(this.f13091c);
                setSingleLineAllCaps(this.f13092d);
            } else {
                this.f13090b.setSingleLine();
                this.f13091c.setSingleLine();
                this.f13092d.setSingleLine();
            }
        } else {
            this.f13090b.setSingleLine();
            this.f13091c.setSingleLine();
            this.f13092d.setSingleLine();
        }
        this.f13095h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.f13099l);
            this.f13100m = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.f13099l);
            this.f13100m = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.f13089a;
        if (viewPager != null) {
            this.f13093f = -1;
            this.f13094g = -1.0f;
            b(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    public void b(int i11, PagerAdapter pagerAdapter) {
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.f13097j = true;
        CharSequence pageTitle = null;
        this.f13090b.setText((i11 < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i11 - 1));
        this.f13091c.setText((pagerAdapter == null || i11 >= count) ? null : pagerAdapter.getPageTitle(i11));
        int i12 = i11 + 1;
        if (i12 < count && pagerAdapter != null) {
            pageTitle = pagerAdapter.getPageTitle(i12);
        }
        this.f13092d.setText(pageTitle);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f13090b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f13091c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f13092d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f13093f = i11;
        if (!this.f13098k) {
            c(i11, this.f13094g, false);
        }
        this.f13097j = false;
    }

    public void c(int i11, float f11, boolean z11) {
        int i12;
        int i13;
        int i14;
        int i15;
        if (i11 != this.f13093f) {
            b(i11, this.f13089a.getAdapter());
        } else if (!z11 && f11 == this.f13094g) {
            return;
        }
        this.f13098k = true;
        int measuredWidth = this.f13090b.getMeasuredWidth();
        int measuredWidth2 = this.f13091c.getMeasuredWidth();
        int measuredWidth3 = this.f13092d.getMeasuredWidth();
        int i16 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i17 = paddingRight + i16;
        int i18 = (width - (paddingLeft + i16)) - i17;
        float f12 = 0.5f + f11;
        if (f12 > 1.0f) {
            f12 -= 1.0f;
        }
        int i19 = ((width - i17) - ((int) (i18 * f12))) - i16;
        int i21 = measuredWidth2 + i19;
        int baseline = this.f13090b.getBaseline();
        int baseline2 = this.f13091c.getBaseline();
        int baseline3 = this.f13092d.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i22 = iMax - baseline;
        int i23 = iMax - baseline2;
        int i24 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.f13090b.getMeasuredHeight() + i22, this.f13091c.getMeasuredHeight() + i23), this.f13092d.getMeasuredHeight() + i24);
        int i25 = this.f13096i & 112;
        if (i25 != 16) {
            if (i25 != 80) {
                i13 = i22 + paddingTop;
                i14 = i23 + paddingTop;
                i15 = paddingTop + i24;
            } else {
                i12 = (height - paddingBottom) - iMax2;
            }
            TextView textView = this.f13091c;
            textView.layout(i19, i14, i21, textView.getMeasuredHeight() + i14);
            int iMin = Math.min(paddingLeft, (i19 - this.f13095h) - measuredWidth);
            TextView textView2 = this.f13090b;
            textView2.layout(iMin, i13, measuredWidth + iMin, textView2.getMeasuredHeight() + i13);
            int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i21 + this.f13095h);
            TextView textView3 = this.f13092d;
            textView3.layout(iMax3, i15, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i15);
            this.f13094g = f11;
            this.f13098k = false;
        }
        i12 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        i13 = i22 + i12;
        i14 = i23 + i12;
        i15 = i12 + i24;
        TextView textView4 = this.f13091c;
        textView4.layout(i19, i14, i21, textView4.getMeasuredHeight() + i14);
        int iMin2 = Math.min(paddingLeft, (i19 - this.f13095h) - measuredWidth);
        TextView textView5 = this.f13090b;
        textView5.layout(iMin2, i13, measuredWidth + iMin2, textView5.getMeasuredHeight() + i13);
        int iMax4 = Math.max((width - paddingRight) - measuredWidth3, i21 + this.f13095h);
        TextView textView6 = this.f13092d;
        textView6.layout(iMax4, i15, iMax4 + measuredWidth3, textView6.getMeasuredHeight() + i15);
        this.f13094g = f11;
        this.f13098k = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f13095h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        viewPager.setInternalPageChangeListener(this.f13099l);
        viewPager.addOnAdapterChangeListener(this.f13099l);
        this.f13089a = viewPager;
        WeakReference<PagerAdapter> weakReference = this.f13100m;
        a(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f13089a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), null);
            this.f13089a.setInternalPageChangeListener(null);
            this.f13089a.removeOnAdapterChangeListener(this.f13099l);
            this.f13089a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        if (this.f13089a != null) {
            float f11 = this.f13094g;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            c(this.f13093f, f11, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int iMax;
        if (View.MeasureSpec.getMode(i11) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i12, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i11);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, (int) (size * 0.2f), -2);
        this.f13090b.measure(childMeasureSpec2, childMeasureSpec);
        this.f13091c.measure(childMeasureSpec2, childMeasureSpec);
        this.f13092d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i12) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i12);
        } else {
            iMax = Math.max(getMinHeight(), this.f13091c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i12, this.f13091c.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f13097j) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i11) {
        this.f13096i = i11;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f11) {
        int i11 = ((int) (f11 * 255.0f)) & 255;
        this.f13101n = i11;
        int i12 = (i11 << 24) | (this.f13102o & 16777215);
        this.f13090b.setTextColor(i12);
        this.f13092d.setTextColor(i12);
    }

    public void setTextColor(int i11) {
        this.f13102o = i11;
        this.f13091c.setTextColor(i11);
        int i12 = (this.f13101n << 24) | (this.f13102o & 16777215);
        this.f13090b.setTextColor(i12);
        this.f13092d.setTextColor(i12);
    }

    public void setTextSize(int i11, float f11) {
        this.f13090b.setTextSize(i11, f11);
        this.f13091c.setTextSize(i11, f11);
        this.f13092d.setTextSize(i11, f11);
    }

    public void setTextSpacing(int i11) {
        this.f13095h = i11;
        requestLayout();
    }
}
