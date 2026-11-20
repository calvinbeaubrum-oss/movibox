package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends q {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;

    @Nullable
    private OrientationHelper mHorizontalHelper;

    @Nullable
    private OrientationHelper mVerticalHelper;

    /* JADX INFO: compiled from: source.java */
    public class a extends h {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.h, androidx.recyclerview.widget.RecyclerView.w
        public void o(@NonNull View view, @NonNull RecyclerView.x xVar, @NonNull RecyclerView.w.a aVar) {
            m mVar = m.this;
            int[] iArrCalculateDistanceToFinalSnap = mVar.calculateDistanceToFinalSnap(mVar.mRecyclerView.getLayoutManager(), view);
            int i11 = iArrCalculateDistanceToFinalSnap[0];
            int i12 = iArrCalculateDistanceToFinalSnap[1];
            int iW = w(Math.max(Math.abs(i11), Math.abs(i12)));
            if (iW > 0) {
                aVar.d(i11, i12, iW, this.f12670j);
            }
        }

        @Override // androidx.recyclerview.widget.h
        public float v(@NonNull DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.h
        public int x(int i11) {
            return Math.min(100, super.x(i11));
        }
    }

    private int distanceToCenter(@NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    @Nullable
    private View findCenterView(RecyclerView.m mVar, OrientationHelper orientationHelper) {
        int childCount = mVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = mVar.getChildAt(i12);
            int iAbs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (iAbs < i11) {
                view = childAt;
                i11 = iAbs;
            }
        }
        return view;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.m mVar) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != mVar) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(mVar);
        }
        return this.mHorizontalHelper;
    }

    @Nullable
    private OrientationHelper getOrientationHelper(RecyclerView.m mVar) {
        if (mVar.canScrollVertically()) {
            return getVerticalHelper(mVar);
        }
        if (mVar.canScrollHorizontally()) {
            return getHorizontalHelper(mVar);
        }
        return null;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.m mVar) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != mVar) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(mVar);
        }
        return this.mVerticalHelper;
    }

    private boolean isForwardFling(RecyclerView.m mVar, int i11, int i12) {
        if (mVar.canScrollHorizontally()) {
            return i11 > 0;
        }
        return i12 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView.m mVar) {
        PointF pointFComputeScrollVectorForPosition;
        int itemCount = mVar.getItemCount();
        if (!(mVar instanceof RecyclerView.w.b) || (pointFComputeScrollVectorForPosition = ((RecyclerView.w.b) mVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return pointFComputeScrollVectorForPosition.x < 0.0f || pointFComputeScrollVectorForPosition.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.q
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.m mVar, @NonNull View view) {
        int[] iArr = new int[2];
        if (mVar.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(view, getHorizontalHelper(mVar));
        } else {
            iArr[0] = 0;
        }
        if (mVar.canScrollVertically()) {
            iArr[1] = distanceToCenter(view, getVerticalHelper(mVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.q
    @Nullable
    public RecyclerView.w createScroller(@NonNull RecyclerView.m mVar) {
        if (mVar instanceof RecyclerView.w.b) {
            return new a(this.mRecyclerView.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.q
    @Nullable
    @SuppressLint({"UnknownNullness"})
    public View findSnapView(RecyclerView.m mVar) {
        if (mVar.canScrollVertically()) {
            return findCenterView(mVar, getVerticalHelper(mVar));
        }
        if (mVar.canScrollHorizontally()) {
            return findCenterView(mVar, getHorizontalHelper(mVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.q
    @SuppressLint({"UnknownNullness"})
    public int findTargetSnapPosition(RecyclerView.m mVar, int i11, int i12) {
        OrientationHelper orientationHelper;
        int itemCount = mVar.getItemCount();
        if (itemCount == 0 || (orientationHelper = getOrientationHelper(mVar)) == null) {
            return -1;
        }
        int childCount = mVar.getChildCount();
        View view = null;
        View view2 = null;
        int i13 = Integer.MIN_VALUE;
        int i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = mVar.getChildAt(i15);
            if (childAt != null) {
                int iDistanceToCenter = distanceToCenter(childAt, orientationHelper);
                if (iDistanceToCenter <= 0 && iDistanceToCenter > i13) {
                    view2 = childAt;
                    i13 = iDistanceToCenter;
                }
                if (iDistanceToCenter >= 0 && iDistanceToCenter < i14) {
                    view = childAt;
                    i14 = iDistanceToCenter;
                }
            }
        }
        boolean zIsForwardFling = isForwardFling(mVar, i11, i12);
        if (zIsForwardFling && view != null) {
            return mVar.getPosition(view);
        }
        if (!zIsForwardFling && view2 != null) {
            return mVar.getPosition(view2);
        }
        if (zIsForwardFling) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = mVar.getPosition(view) + (isReverseLayout(mVar) == zIsForwardFling ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }
}
