package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class PagerTabStrip extends PagerTitleStrip {
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public float E;
    public float F;
    public int G;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13076r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13077s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13078t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13079u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13080v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13081w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Paint f13082x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f13083y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13084z;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f13089a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f13089a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(@NonNull Context context) {
        this(context, null);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f13082x = paint;
        this.f13083y = new Rect();
        this.f13084z = 255;
        this.A = false;
        this.B = false;
        int i11 = this.f13102o;
        this.f13076r = i11;
        paint.setColor(i11);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.f13077s = (int) ((3.0f * f11) + 0.5f);
        this.f13078t = (int) ((6.0f * f11) + 0.5f);
        this.f13079u = (int) (64.0f * f11);
        this.f13081w = (int) ((16.0f * f11) + 0.5f);
        this.C = (int) ((1.0f * f11) + 0.5f);
        this.f13080v = (int) ((f11 * 32.0f) + 0.5f);
        this.G = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f13090b.setFocusable(true);
        this.f13090b.setOnClickListener(new a());
        this.f13092d.setFocusable(true);
        this.f13092d.setOnClickListener(new b());
        if (getBackground() == null) {
            this.A = true;
        }
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void c(int i11, float f11, boolean z11) {
        Rect rect = this.f13083y;
        int height = getHeight();
        int left = this.f13091c.getLeft() - this.f13081w;
        int right = this.f13091c.getRight() + this.f13081w;
        int i12 = height - this.f13077s;
        rect.set(left, i12, right, height);
        super.c(i11, f11, z11);
        this.f13084z = (int) (Math.abs(f11 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f13091c.getLeft() - this.f13081w, i12, this.f13091c.getRight() + this.f13081w, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.A;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f13080v);
    }

    public int getTabIndicatorColor() {
        return this.f13076r;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f13091c.getLeft() - this.f13081w;
        int right = this.f13091c.getRight() + this.f13081w;
        int i11 = height - this.f13077s;
        this.f13082x.setColor((this.f13084z << 24) | (this.f13076r & 16777215));
        float f11 = height;
        canvas.drawRect(left, i11, right, f11, this.f13082x);
        if (this.A) {
            this.f13082x.setColor((this.f13076r & 16777215) | ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect(getPaddingLeft(), height - this.C, getWidth() - getPaddingRight(), f11, this.f13082x);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.D) {
            return false;
        }
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (action == 0) {
            this.E = x11;
            this.F = y11;
            this.D = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x11 - this.E) > this.G || Math.abs(y11 - this.F) > this.G)) {
                this.D = true;
            }
        } else if (x11 < this.f13091c.getLeft() - this.f13081w) {
            ViewPager viewPager = this.f13089a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x11 > this.f13091c.getRight() + this.f13081w) {
            ViewPager viewPager2 = this.f13089a;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        super.setBackgroundColor(i11);
        if (this.B) {
            return;
        }
        this.A = (i11 & ViewCompat.MEASURED_STATE_MASK) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.B) {
            return;
        }
        this.A = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i11) {
        super.setBackgroundResource(i11);
        if (this.B) {
            return;
        }
        this.A = i11 == 0;
    }

    public void setDrawFullUnderline(boolean z11) {
        this.A = z11;
        this.B = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
        int i15 = this.f13078t;
        if (i14 < i15) {
            i14 = i15;
        }
        super.setPadding(i11, i12, i13, i14);
    }

    public void setTabIndicatorColor(int i11) {
        this.f13076r = i11;
        this.f13082x.setColor(i11);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i11) {
        setTabIndicatorColor(z2.a.getColor(getContext(), i11));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i11) {
        int i12 = this.f13079u;
        if (i11 < i12) {
            i11 = i12;
        }
        super.setTextSpacing(i11);
    }
}
