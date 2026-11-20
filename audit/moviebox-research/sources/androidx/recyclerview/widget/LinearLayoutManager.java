package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.m implements RecyclerView.w.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    /* JADX INFO: compiled from: source.java */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState() {
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0;
        }

        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrientationHelper f12512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12515d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12516e;

        public a() {
            e();
        }

        public void a() {
            this.f12514c = this.f12515d ? this.f12512a.getEndAfterPadding() : this.f12512a.getStartAfterPadding();
        }

        public void b(View view, int i11) {
            if (this.f12515d) {
                this.f12514c = this.f12512a.getDecoratedEnd(view) + this.f12512a.getTotalSpaceChange();
            } else {
                this.f12514c = this.f12512a.getDecoratedStart(view);
            }
            this.f12513b = i11;
        }

        public void c(View view, int i11) {
            int totalSpaceChange = this.f12512a.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                b(view, i11);
                return;
            }
            this.f12513b = i11;
            if (this.f12515d) {
                int endAfterPadding = (this.f12512a.getEndAfterPadding() - totalSpaceChange) - this.f12512a.getDecoratedEnd(view);
                this.f12514c = this.f12512a.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.f12514c - this.f12512a.getDecoratedMeasurement(view);
                    int startAfterPadding = this.f12512a.getStartAfterPadding();
                    int iMin = decoratedMeasurement - (startAfterPadding + Math.min(this.f12512a.getDecoratedStart(view) - startAfterPadding, 0));
                    if (iMin < 0) {
                        this.f12514c += Math.min(endAfterPadding, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.f12512a.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.f12512a.getStartAfterPadding();
            this.f12514c = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.f12512a.getEndAfterPadding() - Math.min(0, (this.f12512a.getEndAfterPadding() - totalSpaceChange) - this.f12512a.getDecoratedEnd(view))) - (decoratedStart + this.f12512a.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.f12514c -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        public boolean d(View view, RecyclerView.x xVar) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return !nVar.isItemRemoved() && nVar.getViewLayoutPosition() >= 0 && nVar.getViewLayoutPosition() < xVar.b();
        }

        public void e() {
            this.f12513b = -1;
            this.f12514c = Integer.MIN_VALUE;
            this.f12515d = false;
            this.f12516e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f12513b + ", mCoordinate=" + this.f12514c + ", mLayoutFromEnd=" + this.f12515d + ", mValid=" + this.f12516e + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12520d;

        public void a() {
            this.f12517a = 0;
            this.f12518b = false;
            this.f12519c = false;
            this.f12520d = false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12524d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12525e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12526f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12527g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f12531k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f12533m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12521a = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f12528h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f12529i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f12530j = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<RecyclerView.a0> f12532l = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f12524d = -1;
            } else {
                this.f12524d = ((RecyclerView.n) viewF.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public boolean c(RecyclerView.x xVar) {
            int i11 = this.f12524d;
            return i11 >= 0 && i11 < xVar.b();
        }

        public View d(RecyclerView.t tVar) {
            if (this.f12532l != null) {
                return e();
            }
            View viewO = tVar.o(this.f12524d);
            this.f12524d += this.f12525e;
            return viewO;
        }

        public final View e() {
            int size = this.f12532l.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = this.f12532l.get(i11).itemView;
                RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
                if (!nVar.isItemRemoved() && this.f12524d == nVar.getViewLayoutPosition()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int viewLayoutPosition;
            int size = this.f12532l.size();
            View view2 = null;
            int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i12 = 0; i12 < size; i12++) {
                View view3 = this.f12532l.get(i12).itemView;
                RecyclerView.n nVar = (RecyclerView.n) view3.getLayoutParams();
                if (view3 != view && !nVar.isItemRemoved() && (viewLayoutPosition = (nVar.getViewLayoutPosition() - this.f12524d) * this.f12525e) >= 0 && viewLayoutPosition < i11) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i11 = viewLayoutPosition;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context, int i11, boolean z11) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i11);
        setReverseLayout(z11);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.m.d properties = RecyclerView.m.getProperties(context, attributeSet, i11, i12);
        setOrientation(properties.f12545a);
        setReverseLayout(properties.f12547c);
        setStackFromEnd(properties.f12548d);
    }

    private int computeScrollExtent(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return o.a(xVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return o.b(xVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return o.c(xVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i11, RecyclerView.t tVar, RecyclerView.x xVar, boolean z11) {
        int endAfterPadding;
        int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - i11;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i12 = -scrollBy(-endAfterPadding2, tVar, xVar);
        int i13 = i11 + i12;
        if (!z11 || (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i13) <= 0) {
            return i12;
        }
        this.mOrientationHelper.offsetChildren(endAfterPadding);
        return endAfterPadding + i12;
    }

    private int fixLayoutStartGap(int i11, RecyclerView.t tVar, RecyclerView.x xVar, boolean z11) {
        int startAfterPadding;
        int startAfterPadding2 = i11 - this.mOrientationHelper.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i12 = -scrollBy(startAfterPadding2, tVar, xVar);
        int i13 = i11 + i12;
        if (!z11 || (startAfterPadding = i13 - this.mOrientationHelper.getStartAfterPadding()) <= 0) {
            return i12;
        }
        this.mOrientationHelper.offsetChildren(-startAfterPadding);
        return i12 - startAfterPadding;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.t tVar, RecyclerView.x xVar, int i11, int i12) {
        if (!xVar.g() || getChildCount() == 0 || xVar.e() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.a0> listK = tVar.k();
        int size = listK.size();
        int position = getPosition(getChildAt(0));
        int decoratedMeasurement = 0;
        int decoratedMeasurement2 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView.a0 a0Var = listK.get(i13);
            if (!a0Var.isRemoved()) {
                if ((a0Var.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                    decoratedMeasurement += this.mOrientationHelper.getDecoratedMeasurement(a0Var.itemView);
                } else {
                    decoratedMeasurement2 += this.mOrientationHelper.getDecoratedMeasurement(a0Var.itemView);
                }
            }
        }
        this.mLayoutState.f12532l = listK;
        if (decoratedMeasurement > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i11);
            c cVar = this.mLayoutState;
            cVar.f12528h = decoratedMeasurement;
            cVar.f12523c = 0;
            cVar.a();
            fill(tVar, this.mLayoutState, xVar, false);
        }
        if (decoratedMeasurement2 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i12);
            c cVar2 = this.mLayoutState;
            cVar2.f12528h = decoratedMeasurement2;
            cVar2.f12523c = 0;
            cVar2.a();
            fill(tVar, this.mLayoutState, xVar, false);
        }
        this.mLayoutState.f12532l = null;
    }

    private void logChildren() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("item ");
            sb2.append(getPosition(childAt));
            sb2.append(", coord:");
            sb2.append(this.mOrientationHelper.getDecoratedStart(childAt));
        }
    }

    private void recycleByLayoutState(RecyclerView.t tVar, c cVar) {
        if (!cVar.f12521a || cVar.f12533m) {
            return;
        }
        int i11 = cVar.f12527g;
        int i12 = cVar.f12529i;
        if (cVar.f12526f == -1) {
            recycleViewsFromEnd(tVar, i11, i12);
        } else {
            recycleViewsFromStart(tVar, i11, i12);
        }
    }

    private void recycleChildren(RecyclerView.t tVar, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        if (i12 <= i11) {
            while (i11 > i12) {
                removeAndRecycleViewAt(i11, tVar);
                i11--;
            }
        } else {
            for (int i13 = i12 - 1; i13 >= i11; i13--) {
                removeAndRecycleViewAt(i13, tVar);
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.t tVar, int i11, int i12) {
        int childCount = getChildCount();
        if (i11 < 0) {
            return;
        }
        int end = (this.mOrientationHelper.getEnd() - i11) + i12;
        if (this.mShouldReverseLayout) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (this.mOrientationHelper.getDecoratedStart(childAt) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt) < end) {
                    recycleChildren(tVar, 0, i13);
                    return;
                }
            }
            return;
        }
        int i14 = childCount - 1;
        for (int i15 = i14; i15 >= 0; i15--) {
            View childAt2 = getChildAt(i15);
            if (this.mOrientationHelper.getDecoratedStart(childAt2) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) < end) {
                recycleChildren(tVar, i14, i15);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.t tVar, int i11, int i12) {
        if (i11 < 0) {
            return;
        }
        int i13 = i11 - i12;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (this.mOrientationHelper.getDecoratedEnd(childAt) > i13 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > i13) {
                    recycleChildren(tVar, 0, i14);
                    return;
                }
            }
            return;
        }
        int i15 = childCount - 1;
        for (int i16 = i15; i16 >= 0; i16--) {
            View childAt2 = getChildAt(i16);
            if (this.mOrientationHelper.getDecoratedEnd(childAt2) > i13 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) > i13) {
                recycleChildren(tVar, i15, i16);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.t tVar, RecyclerView.x xVar, a aVar) {
        View viewFindReferenceChild;
        boolean z11 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.d(focusedChild, xVar)) {
            aVar.c(focusedChild, getPosition(focusedChild));
            return true;
        }
        boolean z12 = this.mLastStackFromEnd;
        boolean z13 = this.mStackFromEnd;
        if (z12 != z13 || (viewFindReferenceChild = findReferenceChild(tVar, xVar, aVar.f12515d, z13)) == null) {
            return false;
        }
        aVar.b(viewFindReferenceChild, getPosition(viewFindReferenceChild));
        if (!xVar.e() && supportsPredictiveItemAnimations()) {
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(viewFindReferenceChild);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(viewFindReferenceChild);
            int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
            int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
            boolean z14 = decoratedEnd <= startAfterPadding && decoratedStart < startAfterPadding;
            if (decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding) {
                z11 = true;
            }
            if (z14 || z11) {
                if (aVar.f12515d) {
                    startAfterPadding = endAfterPadding;
                }
                aVar.f12514c = startAfterPadding;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.x xVar, a aVar) {
        int i11;
        if (!xVar.e() && (i11 = this.mPendingScrollPosition) != -1) {
            if (i11 >= 0 && i11 < xVar.b()) {
                aVar.f12513b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    boolean z11 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    aVar.f12515d = z11;
                    if (z11) {
                        aVar.f12514c = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        aVar.f12514c = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z12 = this.mShouldReverseLayout;
                    aVar.f12515d = z12;
                    if (z12) {
                        aVar.f12514c = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f12514c = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0) {
                        aVar.f12515d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    aVar.a();
                } else {
                    if (this.mOrientationHelper.getDecoratedMeasurement(viewFindViewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                        aVar.a();
                        return true;
                    }
                    if (this.mOrientationHelper.getDecoratedStart(viewFindViewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                        aVar.f12514c = this.mOrientationHelper.getStartAfterPadding();
                        aVar.f12515d = false;
                        return true;
                    }
                    if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(viewFindViewByPosition) < 0) {
                        aVar.f12514c = this.mOrientationHelper.getEndAfterPadding();
                        aVar.f12515d = true;
                        return true;
                    }
                    aVar.f12514c = aVar.f12515d ? this.mOrientationHelper.getDecoratedEnd(viewFindViewByPosition) + this.mOrientationHelper.getTotalSpaceChange() : this.mOrientationHelper.getDecoratedStart(viewFindViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.t tVar, RecyclerView.x xVar, a aVar) {
        if (updateAnchorFromPendingData(xVar, aVar) || updateAnchorFromChildren(tVar, xVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f12513b = this.mStackFromEnd ? xVar.b() - 1 : 0;
    }

    private void updateLayoutState(int i11, int i12, boolean z11, RecyclerView.x xVar) {
        int startAfterPadding;
        this.mLayoutState.f12533m = resolveIsInfinite();
        this.mLayoutState.f12526f = i11;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(xVar, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z12 = i11 == 1;
        c cVar = this.mLayoutState;
        int i13 = z12 ? iMax2 : iMax;
        cVar.f12528h = i13;
        if (!z12) {
            iMax = iMax2;
        }
        cVar.f12529i = iMax;
        if (z12) {
            cVar.f12528h = i13 + this.mOrientationHelper.getEndPadding();
            View childClosestToEnd = getChildClosestToEnd();
            c cVar2 = this.mLayoutState;
            cVar2.f12525e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(childClosestToEnd);
            c cVar3 = this.mLayoutState;
            cVar2.f12524d = position + cVar3.f12525e;
            cVar3.f12522b = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            startAfterPadding = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f12528h += this.mOrientationHelper.getStartAfterPadding();
            c cVar4 = this.mLayoutState;
            cVar4.f12525e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(childClosestToStart);
            c cVar5 = this.mLayoutState;
            cVar4.f12524d = position2 + cVar5.f12525e;
            cVar5.f12522b = this.mOrientationHelper.getDecoratedStart(childClosestToStart);
            startAfterPadding = (-this.mOrientationHelper.getDecoratedStart(childClosestToStart)) + this.mOrientationHelper.getStartAfterPadding();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f12523c = i12;
        if (z11) {
            cVar6.f12523c = i12 - startAfterPadding;
        }
        cVar6.f12527g = startAfterPadding;
    }

    private void updateLayoutStateToFillEnd(int i11, int i12) {
        this.mLayoutState.f12523c = this.mOrientationHelper.getEndAfterPadding() - i12;
        c cVar = this.mLayoutState;
        cVar.f12525e = this.mShouldReverseLayout ? -1 : 1;
        cVar.f12524d = i11;
        cVar.f12526f = 1;
        cVar.f12522b = i12;
        cVar.f12527g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f12513b, aVar.f12514c);
    }

    private void updateLayoutStateToFillStart(int i11, int i12) {
        this.mLayoutState.f12523c = i12 - this.mOrientationHelper.getStartAfterPadding();
        c cVar = this.mLayoutState;
        cVar.f12524d = i11;
        cVar.f12525e = this.mShouldReverseLayout ? 1 : -1;
        cVar.f12526f = -1;
        cVar.f12522b = i12;
        cVar.f12527g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f12513b, aVar.f12514c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(@NonNull RecyclerView.x xVar, @NonNull int[] iArr) {
        int i11;
        int extraLayoutSpace = getExtraLayoutSpace(xVar);
        if (this.mLayoutState.f12526f == -1) {
            i11 = 0;
        } else {
            i11 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i11, int i12, RecyclerView.x xVar, RecyclerView.m.c cVar) {
        if (this.mOrientation != 0) {
            i11 = i12;
        }
        if (getChildCount() == 0 || i11 == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i11 > 0 ? 1 : -1, Math.abs(i11), true, xVar);
        collectPrefetchPositionsForLayoutState(xVar, this.mLayoutState, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i11, RecyclerView.m.c cVar) {
        boolean z11;
        int i12;
        SavedState savedState = this.mPendingSavedState;
        if (savedState == null || !savedState.hasValidAnchor()) {
            resolveShouldLayoutReverse();
            z11 = this.mShouldReverseLayout;
            i12 = this.mPendingScrollPosition;
            if (i12 == -1) {
                i12 = z11 ? i11 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z11 = savedState2.mAnchorLayoutFromEnd;
            i12 = savedState2.mAnchorPosition;
        }
        int i13 = z11 ? -1 : 1;
        for (int i14 = 0; i14 < this.mInitialPrefetchItemCount && i12 >= 0 && i12 < i11; i14++) {
            cVar.a(i12, 0);
            i12 += i13;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.x xVar, c cVar, RecyclerView.m.c cVar2) {
        int i11 = cVar.f12524d;
        if (i11 < 0 || i11 >= xVar.b()) {
            return;
        }
        cVar2.a(i11, Math.max(0, cVar.f12527g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.x xVar) {
        return computeScrollExtent(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.x xVar) {
        return computeScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.x xVar) {
        return computeScrollRange(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w.b
    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i11) {
        if (getChildCount() == 0) {
            return null;
        }
        int i12 = (i11 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i12, 0.0f) : new PointF(0.0f, i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.x xVar) {
        return computeScrollExtent(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.x xVar) {
        return computeScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.x xVar) {
        return computeScrollRange(xVar);
    }

    public int convertFocusDirectionToLayoutDirection(int i11) {
        if (i11 == 1) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i11 == 2) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i11 == 17) {
            return this.mOrientation == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i11 == 33) {
            return this.mOrientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i11 != 66) {
            return (i11 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.mOrientation == 0 ? 1 : Integer.MIN_VALUE;
    }

    public c createLayoutState() {
        return new c();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.t tVar, c cVar, RecyclerView.x xVar, boolean z11) {
        int i11 = cVar.f12523c;
        int i12 = cVar.f12527g;
        if (i12 != Integer.MIN_VALUE) {
            if (i11 < 0) {
                cVar.f12527g = i12 + i11;
            }
            recycleByLayoutState(tVar, cVar);
        }
        int i13 = cVar.f12523c + cVar.f12528h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.f12533m && i13 <= 0) || !cVar.c(xVar)) {
                break;
            }
            bVar.a();
            layoutChunk(tVar, xVar, cVar, bVar);
            if (!bVar.f12518b) {
                cVar.f12522b += bVar.f12517a * cVar.f12526f;
                if (!bVar.f12519c || cVar.f12532l != null || !xVar.e()) {
                    int i14 = cVar.f12523c;
                    int i15 = bVar.f12517a;
                    cVar.f12523c = i14 - i15;
                    i13 -= i15;
                }
                int i16 = cVar.f12527g;
                if (i16 != Integer.MIN_VALUE) {
                    int i17 = i16 + bVar.f12517a;
                    cVar.f12527g = i17;
                    int i18 = cVar.f12523c;
                    if (i18 < 0) {
                        cVar.f12527g = i17 + i18;
                    }
                    recycleByLayoutState(tVar, cVar);
                }
                if (z11 && bVar.f12520d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i11 - cVar.f12523c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z11, boolean z12) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z11, z12) : findOneVisibleChild(getChildCount() - 1, -1, z11, z12);
    }

    public View findFirstVisibleChildClosestToStart(boolean z11, boolean z12) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z11, z12) : findOneVisibleChild(0, getChildCount(), z11, z12);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i11, int i12) {
        int i13;
        int i14;
        ensureLayoutState();
        if (i12 <= i11 && i12 >= i11) {
            return getChildAt(i11);
        }
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(i11)) < this.mOrientationHelper.getStartAfterPadding()) {
            i13 = 16644;
            i14 = 16388;
        } else {
            i13 = 4161;
            i14 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i11, i12, i13, i14) : this.mVerticalBoundCheck.a(i11, i12, i13, i14);
    }

    public View findOneVisibleChild(int i11, int i12, boolean z11, boolean z12) {
        ensureLayoutState();
        int i13 = z11 ? 24579 : 320;
        int i14 = z12 ? 320 : 0;
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i11, i12, i13, i14) : this.mVerticalBoundCheck.a(i11, i12, i13, i14);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    public View findReferenceChild(RecyclerView.t tVar, RecyclerView.x xVar, boolean z11, boolean z12) {
        int i11;
        int childCount;
        int i12;
        ensureLayoutState();
        int childCount2 = getChildCount();
        if (z12) {
            childCount = getChildCount() - 1;
            i11 = -1;
            i12 = -1;
        } else {
            i11 = childCount2;
            childCount = 0;
            i12 = 1;
        }
        int iB = xVar.b();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (childCount != i11) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(childAt);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(childAt);
            if (position >= 0 && position < iB) {
                if (!((RecyclerView.n) childAt.getLayoutParams()).isItemRemoved()) {
                    boolean z13 = decoratedEnd <= startAfterPadding && decoratedStart < startAfterPadding;
                    boolean z14 = decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding;
                    if (!z13 && !z14) {
                        return childAt;
                    }
                    if (z11) {
                        if (z14) {
                            view2 = childAt;
                        } else if (view == null) {
                            view = childAt;
                        }
                    } else if (z13) {
                        view2 = childAt;
                    } else if (view == null) {
                        view = childAt;
                    }
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            childCount += i12;
        }
        if (view != null) {
            return view;
        }
        return view2 != null ? view2 : view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i11) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i11 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i11) {
                return childAt;
            }
        }
        return super.findViewByPosition(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public RecyclerView.n generateDefaultLayoutParams() {
        return new RecyclerView.n(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.x xVar) {
        if (xVar.d()) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.t tVar, RecyclerView.x xVar, c cVar, b bVar) {
        int i11;
        int i12;
        int i13;
        int paddingLeft;
        int decoratedMeasurementInOther;
        View viewD = cVar.d(tVar);
        if (viewD == null) {
            bVar.f12518b = true;
            return;
        }
        RecyclerView.n nVar = (RecyclerView.n) viewD.getLayoutParams();
        if (cVar.f12532l == null) {
            if (this.mShouldReverseLayout == (cVar.f12526f == -1)) {
                addView(viewD);
            } else {
                addView(viewD, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f12526f == -1)) {
                addDisappearingView(viewD);
            } else {
                addDisappearingView(viewD, 0);
            }
        }
        measureChildWithMargins(viewD, 0, 0);
        bVar.f12517a = this.mOrientationHelper.getDecoratedMeasurement(viewD);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                decoratedMeasurementInOther = getWidth() - getPaddingRight();
                paddingLeft = decoratedMeasurementInOther - this.mOrientationHelper.getDecoratedMeasurementInOther(viewD);
            } else {
                paddingLeft = getPaddingLeft();
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(viewD) + paddingLeft;
            }
            if (cVar.f12526f == -1) {
                int i14 = cVar.f12522b;
                i13 = i14;
                i12 = decoratedMeasurementInOther;
                i11 = i14 - bVar.f12517a;
            } else {
                int i15 = cVar.f12522b;
                i11 = i15;
                i12 = decoratedMeasurementInOther;
                i13 = bVar.f12517a + i15;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(viewD) + paddingTop;
            if (cVar.f12526f == -1) {
                int i16 = cVar.f12522b;
                i12 = i16;
                i11 = paddingTop;
                i13 = decoratedMeasurementInOther2;
                paddingLeft = i16 - bVar.f12517a;
            } else {
                int i17 = cVar.f12522b;
                i11 = paddingTop;
                i12 = bVar.f12517a + i17;
                i13 = decoratedMeasurementInOther2;
                paddingLeft = i17;
            }
        }
        layoutDecoratedWithMargins(viewD, paddingLeft, i11, i12, i13);
        if (nVar.isItemRemoved() || nVar.isItemChanged()) {
            bVar.f12519c = true;
        }
        bVar.f12520d = viewD.hasFocusable();
    }

    public void onAnchorReady(RecyclerView.t tVar, RecyclerView.x xVar, a aVar, int i11) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(tVar);
            tVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        int iConvertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, xVar);
        c cVar = this.mLayoutState;
        cVar.f12527g = Integer.MIN_VALUE;
        cVar.f12521a = false;
        fill(tVar, cVar, xVar, true);
        View viewFindPartiallyOrCompletelyInvisibleChildClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? findPartiallyOrCompletelyInvisibleChildClosestToStart() : findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View childClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        if (!childClosestToStart.hasFocusable()) {
            return viewFindPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (viewFindPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int iFixLayoutEndGap;
        int i15;
        View viewFindViewByPosition;
        int decoratedStart;
        int endAfterPadding;
        int i16 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && xVar.b() == 0) {
            removeAndRecycleAllViews(tVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.f12521a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (!aVar.f12516e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.f12515d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(tVar, xVar, aVar2);
            this.mAnchorInfo.f12516e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) <= this.mOrientationHelper.getStartAfterPadding())) {
            this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f12526f = cVar.f12531k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(xVar, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        int iMax2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        if (xVar.e() && (i15 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i15)) != null) {
            if (this.mShouldReverseLayout) {
                endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(viewFindViewByPosition);
                decoratedStart = this.mPendingScrollPositionOffset;
            } else {
                decoratedStart = this.mOrientationHelper.getDecoratedStart(viewFindViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                endAfterPadding = this.mPendingScrollPositionOffset;
            }
            int i17 = endAfterPadding - decoratedStart;
            if (i17 > 0) {
                iMax += i17;
            } else {
                iMax2 -= i17;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.f12515d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i16 = 1;
        }
        onAnchorReady(tVar, xVar, aVar3, i16);
        detachAndScrapAttachedViews(tVar);
        this.mLayoutState.f12533m = resolveIsInfinite();
        this.mLayoutState.f12530j = xVar.e();
        this.mLayoutState.f12529i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.f12515d) {
            updateLayoutStateToFillStart(aVar4);
            c cVar2 = this.mLayoutState;
            cVar2.f12528h = iMax;
            fill(tVar, cVar2, xVar, false);
            c cVar3 = this.mLayoutState;
            i12 = cVar3.f12522b;
            int i18 = cVar3.f12524d;
            int i19 = cVar3.f12523c;
            if (i19 > 0) {
                iMax2 += i19;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.f12528h = iMax2;
            cVar4.f12524d += cVar4.f12525e;
            fill(tVar, cVar4, xVar, false);
            c cVar5 = this.mLayoutState;
            i11 = cVar5.f12522b;
            int i21 = cVar5.f12523c;
            if (i21 > 0) {
                updateLayoutStateToFillStart(i18, i12);
                c cVar6 = this.mLayoutState;
                cVar6.f12528h = i21;
                fill(tVar, cVar6, xVar, false);
                i12 = this.mLayoutState.f12522b;
            }
        } else {
            updateLayoutStateToFillEnd(aVar4);
            c cVar7 = this.mLayoutState;
            cVar7.f12528h = iMax2;
            fill(tVar, cVar7, xVar, false);
            c cVar8 = this.mLayoutState;
            i11 = cVar8.f12522b;
            int i22 = cVar8.f12524d;
            int i23 = cVar8.f12523c;
            if (i23 > 0) {
                iMax += i23;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.f12528h = iMax;
            cVar9.f12524d += cVar9.f12525e;
            fill(tVar, cVar9, xVar, false);
            c cVar10 = this.mLayoutState;
            i12 = cVar10.f12522b;
            int i24 = cVar10.f12523c;
            if (i24 > 0) {
                updateLayoutStateToFillEnd(i22, i11);
                c cVar11 = this.mLayoutState;
                cVar11.f12528h = i24;
                fill(tVar, cVar11, xVar, false);
                i11 = this.mLayoutState.f12522b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(i11, tVar, xVar, true);
                i13 = i12 + iFixLayoutEndGap2;
                i14 = i11 + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i13, tVar, xVar, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i12, tVar, xVar, true);
                i13 = i12 + iFixLayoutStartGap;
                i14 = i11 + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i14, tVar, xVar, false);
            }
            i12 = i13 + iFixLayoutEndGap;
            i11 = i14 + iFixLayoutEndGap;
        }
        layoutForPredictiveAnimations(tVar, xVar, i12, i11);
        if (xVar.e()) {
            this.mAnchorInfo.e();
        } else {
            this.mOrientationHelper.onLayoutComplete();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.x xVar) {
        super.onLayoutCompleted(xVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z11 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z11;
            if (z11) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                savedState.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.mAnchorPosition = getPosition(childClosestToStart);
                savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i11, int i12) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        byte b11 = position < position2 ? (byte) 1 : (byte) -1;
        if (this.mShouldReverseLayout) {
            if (b11 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view2) + this.mOrientationHelper.getDecoratedMeasurement(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
                return;
            }
        }
        if (b11 == -1) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0;
    }

    public int scrollBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f12521a = true;
        int i12 = i11 > 0 ? 1 : -1;
        int iAbs = Math.abs(i11);
        updateLayoutState(i12, iAbs, true, xVar);
        c cVar = this.mLayoutState;
        int iFill = cVar.f12527g + fill(tVar, cVar, xVar, false);
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i11 = i12 * iFill;
        }
        this.mOrientationHelper.offsetChildren(-i11);
        this.mLayoutState.f12531k = i11;
        return i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i11, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void scrollToPosition(int i11) {
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i11, int i12) {
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = i12;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i11, tVar, xVar);
    }

    public void setInitialPrefetchItemCount(int i11) {
        this.mInitialPrefetchItemCount = i11;
    }

    public void setOrientation(int i11) {
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i11);
        }
        assertNotInLayoutOrScroll(null);
        if (i11 != this.mOrientation || this.mOrientationHelper == null) {
            OrientationHelper orientationHelperCreateOrientationHelper = OrientationHelper.createOrientationHelper(this, i11);
            this.mOrientationHelper = orientationHelperCreateOrientationHelper;
            this.mAnchorInfo.f12512a = orientationHelperCreateOrientationHelper;
            this.mOrientation = i11;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z11) {
        this.mRecycleChildrenOnDetach = z11;
    }

    public void setReverseLayout(boolean z11) {
        assertNotInLayoutOrScroll(null);
        if (z11 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z11;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z11) {
        this.mSmoothScrollbarEnabled = z11;
    }

    public void setStackFromEnd(boolean z11) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z11) {
            return;
        }
        this.mStackFromEnd = z11;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i11) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i11);
        startSmoothScroll(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("validating child count ");
        sb2.append(getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i11 = 1; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                int position2 = getPosition(childAt);
                int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("detected invalid position. loc invalid? ");
                    sb3.append(decoratedStart2 < decoratedStart);
                    throw new RuntimeException(sb3.toString());
                }
                if (decoratedStart2 > decoratedStart) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i12 = 1; i12 < getChildCount(); i12++) {
            View childAt2 = getChildAt(i12);
            int position3 = getPosition(childAt2);
            int decoratedStart3 = this.mOrientationHelper.getDecoratedStart(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("detected invalid position. loc invalid? ");
                sb4.append(decoratedStart3 < decoratedStart);
                throw new RuntimeException(sb4.toString());
            }
            if (decoratedStart3 < decoratedStart) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }
}
