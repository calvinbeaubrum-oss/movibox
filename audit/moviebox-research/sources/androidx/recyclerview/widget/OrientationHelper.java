package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class OrientationHelper {
    public static final int HORIZONTAL = 0;
    private static final int INVALID_SIZE = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    private int mLastTotalSpace;
    protected final RecyclerView.m mLayoutManager;
    final Rect mTmpRect;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends OrientationHelper {
        public a(RecyclerView.m mVar) {
            super(mVar, null);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedEnd(View view) {
            return this.mLayoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurement(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurementInOther(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedStart(View view) {
            return this.mLayoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEnd() {
            return this.mLayoutManager.getWidth();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndAfterPadding() {
            return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndPadding() {
            return this.mLayoutManager.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getMode() {
            return this.mLayoutManager.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getModeInOther() {
            return this.mLayoutManager.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTotalSpace() {
            return (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedEndWithDecoration(View view) {
            this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
            return this.mTmpRect.right;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedStartWithDecoration(View view) {
            this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
            return this.mTmpRect.left;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChild(View view, int i11) {
            view.offsetLeftAndRight(i11);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChildren(int i11) {
            this.mLayoutManager.offsetChildrenHorizontal(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b extends OrientationHelper {
        public b(RecyclerView.m mVar) {
            super(mVar, null);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedEnd(View view) {
            return this.mLayoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurement(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurementInOther(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedStart(View view) {
            return this.mLayoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEnd() {
            return this.mLayoutManager.getHeight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndAfterPadding() {
            return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndPadding() {
            return this.mLayoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getMode() {
            return this.mLayoutManager.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getModeInOther() {
            return this.mLayoutManager.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTotalSpace() {
            return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedEndWithDecoration(View view) {
            this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
            return this.mTmpRect.bottom;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedStartWithDecoration(View view) {
            this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
            return this.mTmpRect.top;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChild(View view, int i11) {
            view.offsetTopAndBottom(i11);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChildren(int i11) {
            this.mLayoutManager.offsetChildrenVertical(i11);
        }
    }

    private OrientationHelper(RecyclerView.m mVar) {
        this.mLastTotalSpace = Integer.MIN_VALUE;
        this.mTmpRect = new Rect();
        this.mLayoutManager = mVar;
    }

    public /* synthetic */ OrientationHelper(RecyclerView.m mVar, a aVar) {
        this(mVar);
    }

    public static OrientationHelper createHorizontalHelper(RecyclerView.m mVar) {
        return new a(mVar);
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.m mVar, int i11) {
        if (i11 == 0) {
            return createHorizontalHelper(mVar);
        }
        if (i11 == 1) {
            return createVerticalHelper(mVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static OrientationHelper createVerticalHelper(RecyclerView.m mVar) {
        return new b(mVar);
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public RecyclerView.m getLayoutManager() {
        return this.mLayoutManager;
    }

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        if (Integer.MIN_VALUE == this.mLastTotalSpace) {
            return 0;
        }
        return getTotalSpace() - this.mLastTotalSpace;
    }

    public abstract int getTransformedEndWithDecoration(View view);

    public abstract int getTransformedStartWithDecoration(View view);

    public abstract void offsetChild(View view, int i11);

    public abstract void offsetChildren(int i11);

    public void onLayoutComplete() {
        this.mLastTotalSpace = getTotalSpace();
    }
}
