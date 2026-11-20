package li;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70292a;

    /* JADX INFO: compiled from: source.java */
    public class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarouselLayoutManager f70293b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i11, CarouselLayoutManager carouselLayoutManager) {
            super(i11, null);
            this.f70293b = carouselLayoutManager;
        }

        @Override // li.e
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f11 = rectF2.top;
            float f12 = rectF3.top;
            if (f11 < f12 && rectF2.bottom > f12) {
                float f13 = f12 - f11;
                rectF.top += f13;
                rectF3.top += f13;
            }
            float f14 = rectF2.bottom;
            float f15 = rectF3.bottom;
            if (f14 <= f15 || rectF2.top >= f15) {
                return;
            }
            float f16 = f14 - f15;
            rectF.bottom = Math.max(rectF.bottom - f16, rectF.top);
            rectF2.bottom = Math.max(rectF2.bottom - f16, rectF2.top);
        }

        @Override // li.e
        public float e(RecyclerView.n nVar) {
            return ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }

        @Override // li.e
        public RectF f(float f11, float f12, float f13, float f14) {
            return new RectF(0.0f, f13, f12, f11 - f13);
        }

        @Override // li.e
        public int g() {
            return this.f70293b.getHeight();
        }

        @Override // li.e
        public int h() {
            return g();
        }

        @Override // li.e
        public int i() {
            return this.f70293b.getPaddingLeft();
        }

        @Override // li.e
        public int j() {
            return this.f70293b.getWidth() - this.f70293b.getPaddingRight();
        }

        @Override // li.e
        public int k() {
            return l();
        }

        @Override // li.e
        public int l() {
            return 0;
        }

        @Override // li.e
        public void m(View view, int i11, int i12) {
            int i13 = i();
            this.f70293b.layoutDecoratedWithMargins(view, i13, i11, i13 + p(view), i12);
        }

        @Override // li.e
        public void n(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.bottom <= rectF3.top) {
                float fFloor = ((float) Math.floor(rectF.bottom)) - 1.0f;
                rectF.bottom = fFloor;
                rectF.top = Math.min(rectF.top, fFloor);
            }
            if (rectF2.top >= rectF3.bottom) {
                float fCeil = ((float) Math.ceil(rectF.top)) + 1.0f;
                rectF.top = fCeil;
                rectF.bottom = Math.max(fCeil, rectF.bottom);
            }
        }

        @Override // li.e
        public void o(View view, Rect rect, float f11, float f12) {
            view.offsetTopAndBottom((int) (f12 - (rect.top + f11)));
        }

        public int p(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.f70293b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarouselLayoutManager f70294b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i11, CarouselLayoutManager carouselLayoutManager) {
            super(i11, null);
            this.f70294b = carouselLayoutManager;
        }

        @Override // li.e
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f11 = rectF2.left;
            float f12 = rectF3.left;
            if (f11 < f12 && rectF2.right > f12) {
                float f13 = f12 - f11;
                rectF.left += f13;
                rectF2.left += f13;
            }
            float f14 = rectF2.right;
            float f15 = rectF3.right;
            if (f14 <= f15 || rectF2.left >= f15) {
                return;
            }
            float f16 = f14 - f15;
            rectF.right = Math.max(rectF.right - f16, rectF.left);
            rectF2.right = Math.max(rectF2.right - f16, rectF2.left);
        }

        @Override // li.e
        public float e(RecyclerView.n nVar) {
            return ((ViewGroup.MarginLayoutParams) nVar).rightMargin + ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
        }

        @Override // li.e
        public RectF f(float f11, float f12, float f13, float f14) {
            return new RectF(f14, 0.0f, f12 - f14, f11);
        }

        @Override // li.e
        public int g() {
            return this.f70294b.getHeight() - this.f70294b.getPaddingBottom();
        }

        @Override // li.e
        public int h() {
            return this.f70294b.P() ? i() : j();
        }

        @Override // li.e
        public int i() {
            return 0;
        }

        @Override // li.e
        public int j() {
            return this.f70294b.getWidth();
        }

        @Override // li.e
        public int k() {
            return this.f70294b.P() ? j() : i();
        }

        @Override // li.e
        public int l() {
            return this.f70294b.getPaddingTop();
        }

        @Override // li.e
        public void m(View view, int i11, int i12) {
            int iL = l();
            this.f70294b.layoutDecoratedWithMargins(view, i11, iL, i12, iL + p(view));
        }

        @Override // li.e
        public void n(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.right <= rectF3.left) {
                float fFloor = ((float) Math.floor(rectF.right)) - 1.0f;
                rectF.right = fFloor;
                rectF.left = Math.min(rectF.left, fFloor);
            }
            if (rectF2.left >= rectF3.right) {
                float fCeil = ((float) Math.ceil(rectF.left)) + 1.0f;
                rectF.left = fCeil;
                rectF.right = Math.max(fCeil, rectF.right);
            }
        }

        @Override // li.e
        public void o(View view, Rect rect, float f11, float f12) {
            view.offsetLeftAndRight((int) (f12 - (rect.left + f11)));
        }

        public int p(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.f70294b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }
    }

    public e(int i11) {
        this.f70292a = i11;
    }

    public /* synthetic */ e(int i11, a aVar) {
        this(i11);
    }

    public static e b(CarouselLayoutManager carouselLayoutManager) {
        return new b(0, carouselLayoutManager);
    }

    public static e c(CarouselLayoutManager carouselLayoutManager, int i11) {
        if (i11 == 0) {
            return b(carouselLayoutManager);
        }
        if (i11 == 1) {
            return d(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static e d(CarouselLayoutManager carouselLayoutManager) {
        return new a(1, carouselLayoutManager);
    }

    public abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract float e(RecyclerView.n nVar);

    public abstract RectF f(float f11, float f12, float f13, float f14);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract void m(View view, int i11, int i12);

    public abstract void n(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract void o(View view, Rect rect, float f11, float f12);
}
