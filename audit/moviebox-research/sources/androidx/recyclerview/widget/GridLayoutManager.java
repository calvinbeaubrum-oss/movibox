package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    c mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i11, int i12) {
            return i11 % i12;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            return 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class b extends RecyclerView.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12501b;

        public b(int i11, int i12) {
            super(i11, i12);
            this.f12500a = -1;
            this.f12501b = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12500a = -1;
            this.f12501b = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12500a = -1;
            this.f12501b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f12500a = -1;
            this.f12501b = 0;
        }

        public int c() {
            return this.f12500a;
        }

        public int d() {
            return this.f12501b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseIntArray f12502a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseIntArray f12503b = new SparseIntArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12504c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12505d = false;

        public static int a(SparseIntArray sparseIntArray, int i11) {
            int size = sparseIntArray.size() - 1;
            int i12 = 0;
            while (i12 <= size) {
                int i13 = (i12 + size) >>> 1;
                if (sparseIntArray.keyAt(i13) < i11) {
                    i12 = i13 + 1;
                } else {
                    size = i13 - 1;
                }
            }
            int i14 = i12 - 1;
            if (i14 < 0 || i14 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i14);
        }

        public int b(int i11, int i12) {
            if (!this.f12505d) {
                return d(i11, i12);
            }
            int i13 = this.f12503b.get(i11, -1);
            if (i13 != -1) {
                return i13;
            }
            int iD = d(i11, i12);
            this.f12503b.put(i11, iD);
            return iD;
        }

        public int c(int i11, int i12) {
            if (!this.f12504c) {
                return e(i11, i12);
            }
            int i13 = this.f12502a.get(i11, -1);
            if (i13 != -1) {
                return i13;
            }
            int iE = e(i11, i12);
            this.f12502a.put(i11, iE);
            return iE;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x002e  */
        /* JADX WARN: Code duplicated, block: B:15:0x0035  */
        /* JADX WARN: Code duplicated, block: B:16:0x0039 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x003b  */
        /* JADX WARN: Code duplicated, block: B:21:0x0044  */
        /* JADX WARN: Code duplicated, block: B:26:0x003e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
        public int d(int i11, int i12) {
            int i13;
            int iC;
            int i14;
            int iF;
            int iF2;
            int iA;
            if (this.f12505d && (iA = a(this.f12503b, i11)) != -1) {
                i14 = this.f12503b.get(iA);
                i13 = iA + 1;
                iC = c(iA, i12) + f(iA);
                i14 = iC == i12 ? i14 + 1 : 0;
                iF = f(i11);
                while (i13 < i11) {
                    iF2 = f(i13);
                    iC += iF2;
                    if (iC == i12) {
                        i14++;
                        iC = 0;
                    } else if (iC > i12) {
                        i14++;
                        iC = iF2;
                    }
                    i13++;
                }
                if (iC + iF > i12) {
                    return i14 + 1;
                }
                return i14;
            }
            i13 = 0;
            iC = 0;
            iF = f(i11);
            while (i13 < i11) {
                iF2 = f(i13);
                iC += iF2;
                if (iC == i12) {
                    i14++;
                    iC = 0;
                } else if (iC > i12) {
                    i14++;
                    iC = iF2;
                }
                i13++;
            }
            if (iC + iF > i12) {
                return i14 + 1;
            }
            return i14;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0024  */
        /* JADX WARN: Code duplicated, block: B:14:0x002b  */
        /* JADX WARN: Code duplicated, block: B:15:0x002d A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:16:0x002f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f12504c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f12502a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f12502a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = 0
                r3 = 0
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = 0
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.e(int, int):int");
        }

        public abstract int f(int i11);

        public void g() {
            this.f12503b.clear();
        }

        public void h() {
            this.f12502a.clear();
        }
    }

    public GridLayoutManager(Context context, int i11) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(i11);
    }

    public GridLayoutManager(Context context, int i11, int i12, boolean z11) {
        super(context, i12, z11);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(i11);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.m.getProperties(context, attributeSet, i11, i12).f12546b);
    }

    private void assignSpans(RecyclerView.t tVar, RecyclerView.x xVar, int i11, boolean z11) {
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        if (z11) {
            i13 = i11;
            i12 = 0;
            i14 = 1;
        } else {
            i12 = i11 - 1;
            i13 = -1;
            i14 = -1;
        }
        while (i12 != i13) {
            View view = this.mSet[i12];
            b bVar = (b) view.getLayoutParams();
            int spanSize = getSpanSize(tVar, xVar, getPosition(view));
            bVar.f12501b = spanSize;
            bVar.f12500a = i15;
            i15 += spanSize;
            i12 += i14;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            b bVar = (b) getChildAt(i11).getLayoutParams();
            int viewLayoutPosition = bVar.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, bVar.d());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, bVar.c());
        }
    }

    private void calculateItemBorders(int i11) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i11);
    }

    public static int[] calculateItemBorders(int[] iArr, int i11, int i12) {
        int i13;
        if (iArr == null || iArr.length != i11 + 1 || iArr[iArr.length - 1] != i12) {
            iArr = new int[i11 + 1];
        }
        int i14 = 0;
        iArr[0] = 0;
        int i15 = i12 / i11;
        int i16 = i12 % i11;
        int i17 = 0;
        for (int i18 = 1; i18 <= i11; i18++) {
            i14 += i16;
            if (i14 <= 0 || i11 - i14 >= i16) {
                i13 = i15;
            } else {
                i13 = i15 + 1;
                i14 -= i11;
            }
            i17 += i13;
            iArr[i18] = i17;
        }
        return iArr;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.x xVar) {
        if (getChildCount() != 0 && xVar.b() != 0) {
            ensureLayoutState();
            boolean zIsSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!zIsSmoothScrollbarEnabled, true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!zIsSmoothScrollbarEnabled, true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                int iB = this.mSpanSizeLookup.b(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount);
                int iB2 = this.mSpanSizeLookup.b(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount);
                int iMax = this.mShouldReverseLayout ? Math.max(0, ((this.mSpanSizeLookup.b(xVar.b() - 1, this.mSpanCount) + 1) - Math.max(iB, iB2)) - 1) : Math.max(0, Math.min(iB, iB2));
                if (zIsSmoothScrollbarEnabled) {
                    return Math.round((iMax * (Math.abs(this.mOrientationHelper.getDecoratedEnd(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(viewFindFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.b(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.b(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(viewFindFirstVisibleChildClosestToStart)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.x xVar) {
        if (getChildCount() != 0 && xVar.b() != 0) {
            ensureLayoutState();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.b(xVar.b() - 1, this.mSpanCount) + 1;
                }
                return (int) (((this.mOrientationHelper.getDecoratedEnd(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(viewFindFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.b(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.b(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)) * (this.mSpanSizeLookup.b(xVar.b() - 1, this.mSpanCount) + 1));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.t tVar, RecyclerView.x xVar, LinearLayoutManager.a aVar, int i11) {
        boolean z11 = i11 == 1;
        int spanIndex = getSpanIndex(tVar, xVar, aVar.f12513b);
        if (z11) {
            while (spanIndex > 0) {
                int i12 = aVar.f12513b;
                if (i12 <= 0) {
                    return;
                }
                int i13 = i12 - 1;
                aVar.f12513b = i13;
                spanIndex = getSpanIndex(tVar, xVar, i13);
            }
            return;
        }
        int iB = xVar.b() - 1;
        int i14 = aVar.f12513b;
        while (i14 < iB) {
            int i15 = i14 + 1;
            int spanIndex2 = getSpanIndex(tVar, xVar, i15);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i14 = i15;
            spanIndex = spanIndex2;
        }
        aVar.f12513b = i14;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView.t tVar, RecyclerView.x xVar, int i11) {
        if (!xVar.e()) {
            return this.mSpanSizeLookup.b(i11, this.mSpanCount);
        }
        int iF = tVar.f(i11);
        if (iF != -1) {
            return this.mSpanSizeLookup.b(iF, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i11);
        return 0;
    }

    private int getSpanIndex(RecyclerView.t tVar, RecyclerView.x xVar, int i11) {
        if (!xVar.e()) {
            return this.mSpanSizeLookup.c(i11, this.mSpanCount);
        }
        int i12 = this.mPreLayoutSpanIndexCache.get(i11, -1);
        if (i12 != -1) {
            return i12;
        }
        int iF = tVar.f(i11);
        if (iF != -1) {
            return this.mSpanSizeLookup.c(iF, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i11);
        return 0;
    }

    private int getSpanSize(RecyclerView.t tVar, RecyclerView.x xVar, int i11) {
        if (!xVar.e()) {
            return this.mSpanSizeLookup.f(i11);
        }
        int i12 = this.mPreLayoutSpanSizeCache.get(i11, -1);
        if (i12 != -1) {
            return i12;
        }
        int iF = tVar.f(i11);
        if (iF != -1) {
            return this.mSpanSizeLookup.f(iF);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i11);
        return 1;
    }

    private void guessMeasurement(float f11, int i11) {
        calculateItemBorders(Math.max(Math.round(f11 * this.mSpanCount), i11));
    }

    private void measureChild(View view, int i11, boolean z11) {
        int childMeasureSpec;
        int childMeasureSpec2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.mDecorInsets;
        int i12 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i13 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(bVar.f12500a, bVar.f12501b);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = RecyclerView.m.getChildMeasureSpec(spaceForSpanRange, i11, i13, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            childMeasureSpec = RecyclerView.m.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i12, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int childMeasureSpec3 = RecyclerView.m.getChildMeasureSpec(spaceForSpanRange, i11, i12, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int childMeasureSpec4 = RecyclerView.m.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i13, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        measureChildWithDecorationsAndMargin(view, childMeasureSpec2, childMeasureSpec, z11);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i11, int i12, boolean z11) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        if (z11 ? shouldReMeasureChild(view, i11, i12, nVar) : shouldMeasureChild(view, i11, i12, nVar)) {
            view.measure(i11, i12);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean checkLayoutParams(RecyclerView.n nVar) {
        return nVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.x xVar, LinearLayoutManager.c cVar, RecyclerView.m.c cVar2) {
        int iF = this.mSpanCount;
        for (int i11 = 0; i11 < this.mSpanCount && cVar.c(xVar) && iF > 0; i11++) {
            int i12 = cVar.f12524d;
            cVar2.a(i12, Math.max(0, cVar.f12527g));
            iF -= this.mSpanSizeLookup.f(i12);
            cVar.f12524d += cVar.f12525e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollOffset(RecyclerView.x xVar) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(xVar) : super.computeHorizontalScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollRange(RecyclerView.x xVar) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(xVar) : super.computeHorizontalScrollRange(xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollOffset(RecyclerView.x xVar) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(xVar) : super.computeVerticalScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollRange(RecyclerView.x xVar) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(xVar) : super.computeVerticalScrollRange(xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.t tVar, RecyclerView.x xVar, boolean z11, boolean z12) {
        int i11;
        int childCount;
        int childCount2 = getChildCount();
        int i12 = 1;
        if (z12) {
            childCount = getChildCount() - 1;
            i11 = -1;
            i12 = -1;
        } else {
            i11 = childCount2;
            childCount = 0;
        }
        int iB = xVar.b();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (childCount != i11) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            if (position >= 0 && position < iB && getSpanIndex(tVar, xVar, position) == 0) {
                if (((RecyclerView.n) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            childCount += i12;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int getColumnCountForAccessibility(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (xVar.b() < 1) {
            return 0;
        }
        return getSpanGroupIndex(tVar, xVar, xVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int getRowCountForAccessibility(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (xVar.b() < 1) {
            return 0;
        }
        return getSpanGroupIndex(tVar, xVar, xVar.b() - 1) + 1;
    }

    public int getSpaceForSpanRange(int i11, int i12) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i12 + i11] - iArr[i11];
        }
        int[] iArr2 = this.mCachedBorders;
        int i13 = this.mSpanCount;
        return iArr2[i13 - i11] - iArr2[(i13 - i11) - i12];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public c getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void layoutChunk(RecyclerView.t tVar, RecyclerView.x xVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int decoratedMeasurementInOther;
        int i16;
        int decoratedMeasurementInOther2;
        int decoratedMeasurementInOther3;
        int i17;
        int childMeasureSpec;
        int childMeasureSpec2;
        View viewD;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        boolean z11 = modeInOther != 1073741824;
        int i18 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z11) {
            updateMeasurements();
        }
        boolean z12 = cVar.f12525e == 1;
        int spanIndex = this.mSpanCount;
        if (!z12) {
            spanIndex = getSpanIndex(tVar, xVar, cVar.f12524d) + getSpanSize(tVar, xVar, cVar.f12524d);
        }
        int i19 = 0;
        while (i19 < this.mSpanCount && cVar.c(xVar) && spanIndex > 0) {
            int i21 = cVar.f12524d;
            int spanSize = getSpanSize(tVar, xVar, i21);
            if (spanSize > this.mSpanCount) {
                throw new IllegalArgumentException("Item at position " + i21 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
            spanIndex -= spanSize;
            if (spanIndex < 0 || (viewD = cVar.d(tVar)) == null) {
                break;
            }
            this.mSet[i19] = viewD;
            i19++;
        }
        if (i19 == 0) {
            bVar.f12518b = true;
            return;
        }
        assignSpans(tVar, xVar, i19, z12);
        float f11 = 0.0f;
        int i22 = 0;
        for (int i23 = 0; i23 < i19; i23++) {
            View view = this.mSet[i23];
            if (cVar.f12532l == null) {
                if (z12) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z12) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, false);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i22) {
                i22 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther4 = (this.mOrientationHelper.getDecoratedMeasurementInOther(view) * 1.0f) / ((b) view.getLayoutParams()).f12501b;
            if (decoratedMeasurementInOther4 > f11) {
                f11 = decoratedMeasurementInOther4;
            }
        }
        if (z11) {
            guessMeasurement(f11, i18);
            i22 = 0;
            for (int i24 = 0; i24 < i19; i24++) {
                View view2 = this.mSet[i24];
                measureChild(view2, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i22) {
                    i22 = decoratedMeasurement2;
                }
            }
        }
        for (int i25 = 0; i25 < i19; i25++) {
            View view3 = this.mSet[i25];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i22) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.mDecorInsets;
                int i26 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i27 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(bVar2.f12500a, bVar2.f12501b);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = RecyclerView.m.getChildMeasureSpec(spaceForSpanRange, 1073741824, i27, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i22 - i26, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i22 - i27, 1073741824);
                    childMeasureSpec = RecyclerView.m.getChildMeasureSpec(spaceForSpanRange, 1073741824, i26, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        bVar.f12517a = i22;
        if (this.mOrientation == 1) {
            if (cVar.f12526f == -1) {
                decoratedMeasurementInOther = cVar.f12522b;
                i17 = decoratedMeasurementInOther - i22;
            } else {
                i17 = cVar.f12522b;
                decoratedMeasurementInOther = i17 + i22;
            }
            i14 = i17;
            i15 = 0;
            i13 = 0;
        } else {
            if (cVar.f12526f == -1) {
                i12 = cVar.f12522b;
                i11 = i12 - i22;
            } else {
                i11 = cVar.f12522b;
                i12 = i11 + i22;
            }
            i13 = i11;
            i14 = 0;
            i15 = i12;
            decoratedMeasurementInOther = 0;
        }
        int i28 = 0;
        while (i28 < i19) {
            View view4 = this.mSet[i28];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - bVar3.f12500a];
                    decoratedMeasurementInOther2 = paddingLeft;
                    decoratedMeasurementInOther3 = paddingLeft - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[bVar3.f12500a];
                    decoratedMeasurementInOther3 = paddingLeft2;
                    decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingLeft2;
                }
                i16 = i14;
            } else {
                int paddingTop = getPaddingTop() + this.mCachedBorders[bVar3.f12500a];
                i16 = paddingTop;
                decoratedMeasurementInOther2 = i15;
                decoratedMeasurementInOther3 = i13;
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingTop;
            }
            layoutDecoratedWithMargins(view4, decoratedMeasurementInOther3, i16, decoratedMeasurementInOther2, decoratedMeasurementInOther);
            if (bVar3.isItemRemoved() || bVar3.isItemChanged()) {
                bVar.f12519c = true;
            }
            bVar.f12520d |= view4.hasFocusable();
            i28++;
            decoratedMeasurementInOther = decoratedMeasurementInOther;
            i15 = decoratedMeasurementInOther2;
            i13 = decoratedMeasurementInOther3;
            i14 = i16;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.t tVar, RecyclerView.x xVar, LinearLayoutManager.a aVar, int i11) {
        super.onAnchorReady(tVar, xVar, aVar, i11);
        updateMeasurements();
        if (xVar.b() > 0 && !xVar.e()) {
            ensureAnchorIsInCorrectSpan(tVar, xVar, aVar, i11);
        }
        ensureViewSet();
    }

    /* JADX WARN: Code duplicated, block: B:72:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:73:0x010f  */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view, int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        int childCount;
        int childCount2;
        int i12;
        View view2;
        View view3;
        int i13;
        int i14;
        int i15;
        int i16;
        RecyclerView.t tVar2 = tVar;
        RecyclerView.x xVar2 = xVar;
        View viewFindContainingItemView = findContainingItemView(view);
        View view4 = null;
        if (viewFindContainingItemView == null) {
            return null;
        }
        b bVar = (b) viewFindContainingItemView.getLayoutParams();
        int i17 = bVar.f12500a;
        int i18 = bVar.f12501b + i17;
        if (super.onFocusSearchFailed(view, i11, tVar, xVar) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i11) == 1) != this.mShouldReverseLayout) {
            childCount2 = getChildCount() - 1;
            childCount = -1;
            i12 = -1;
        } else {
            childCount = getChildCount();
            childCount2 = 0;
            i12 = 1;
        }
        boolean z11 = this.mOrientation == 1 && isLayoutRTL();
        int spanGroupIndex = getSpanGroupIndex(tVar2, xVar2, childCount2);
        int i19 = childCount2;
        int iMin = 0;
        int i21 = -1;
        int i22 = -1;
        int iMin2 = 0;
        View view5 = null;
        while (i19 != childCount) {
            int spanGroupIndex2 = getSpanGroupIndex(tVar2, xVar2, i19);
            View childAt = getChildAt(i19);
            if (childAt == viewFindContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || spanGroupIndex2 == spanGroupIndex) {
                b bVar2 = (b) childAt.getLayoutParams();
                int i23 = bVar2.f12500a;
                view2 = viewFindContainingItemView;
                int i24 = bVar2.f12501b + i23;
                if (childAt.hasFocusable() && i23 == i17 && i24 == i18) {
                    return childAt;
                }
                if (!(childAt.hasFocusable() && view4 == null) && (childAt.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int iMin3 = Math.min(i24, i18) - Math.max(i23, i17);
                    if (!childAt.hasFocusable()) {
                        if (view4 == null) {
                            i13 = iMin;
                            i14 = childCount;
                            if (isViewPartiallyVisible(childAt, false, true)) {
                                i15 = iMin2;
                                if (iMin3 > i15) {
                                    i16 = i22;
                                } else if (iMin3 == i15) {
                                    i16 = i22;
                                    if (z11 == (i23 > i16)) {
                                    }
                                    i19 += i12;
                                    tVar2 = tVar;
                                    xVar2 = xVar;
                                    viewFindContainingItemView = view2;
                                    childCount = i14;
                                } else {
                                    i16 = i22;
                                }
                                if (childAt.hasFocusable()) {
                                    i21 = bVar2.f12500a;
                                    i22 = i16;
                                    iMin2 = i15;
                                    view5 = view3;
                                    view4 = childAt;
                                    iMin = Math.min(i24, i18) - Math.max(i23, i17);
                                } else {
                                    int i25 = bVar2.f12500a;
                                    iMin2 = Math.min(i24, i18) - Math.max(i23, i17);
                                    i22 = i25;
                                    iMin = i13;
                                    view5 = childAt;
                                }
                                i19 += i12;
                                tVar2 = tVar;
                                xVar2 = xVar;
                                viewFindContainingItemView = view2;
                                childCount = i14;
                            }
                            i22 = i16;
                            iMin2 = i15;
                            iMin = i13;
                            view5 = view3;
                            i19 += i12;
                            tVar2 = tVar;
                            xVar2 = xVar;
                            viewFindContainingItemView = view2;
                            childCount = i14;
                        }
                        i16 = i22;
                        i15 = iMin2;
                        i22 = i16;
                        iMin2 = i15;
                        iMin = i13;
                        view5 = view3;
                        i19 += i12;
                        tVar2 = tVar;
                        xVar2 = xVar;
                        viewFindContainingItemView = view2;
                        childCount = i14;
                    } else if (iMin3 <= iMin) {
                        if (iMin3 == iMin) {
                        }
                    }
                } else {
                    view3 = view5;
                }
                i13 = iMin;
                i14 = childCount;
                i16 = i22;
                i15 = iMin2;
                if (childAt.hasFocusable()) {
                    i21 = bVar2.f12500a;
                    i22 = i16;
                    iMin2 = i15;
                    view5 = view3;
                    view4 = childAt;
                    iMin = Math.min(i24, i18) - Math.max(i23, i17);
                } else {
                    int i26 = bVar2.f12500a;
                    iMin2 = Math.min(i24, i18) - Math.max(i23, i17);
                    i22 = i26;
                    iMin = i13;
                    view5 = childAt;
                }
                i19 += i12;
                tVar2 = tVar;
                xVar2 = xVar;
                viewFindContainingItemView = view2;
                childCount = i14;
            } else {
                if (view4 != null) {
                    break;
                }
                view2 = viewFindContainingItemView;
                view3 = view5;
            }
            i13 = iMin;
            i14 = childCount;
            i16 = i22;
            i15 = iMin2;
            i22 = i16;
            iMin2 = i15;
            iMin = i13;
            view5 = view3;
            i19 += i12;
            tVar2 = tVar;
            xVar2 = xVar;
            viewFindContainingItemView = view2;
            childCount = i14;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.t tVar, @NonNull RecyclerView.x xVar, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(tVar, xVar, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.t tVar, RecyclerView.x xVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        b bVar = (b) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(tVar, xVar, bVar.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(bVar.c(), bVar.d(), spanGroupIndex, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, bVar.c(), bVar.d(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        this.mSpanSizeLookup.h();
        this.mSpanSizeLookup.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.h();
        this.mSpanSizeLookup.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        this.mSpanSizeLookup.h();
        this.mSpanSizeLookup.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        this.mSpanSizeLookup.h();
        this.mSpanSizeLookup.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        this.mSpanSizeLookup.h();
        this.mSpanSizeLookup.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (xVar.e()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(tVar, xVar);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutCompleted(RecyclerView.x xVar) {
        super.onLayoutCompleted(xVar);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i11, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i11, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void setMeasuredDimension(Rect rect, int i11, int i12) {
        int iChooseSize;
        int iChooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i11, i12);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView.m.chooseSize(i12, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            iChooseSize = RecyclerView.m.chooseSize(i11, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.m.chooseSize(i11, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            iChooseSize2 = RecyclerView.m.chooseSize(i12, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setSpanCount(int i11) {
        if (i11 == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i11 >= 1) {
            this.mSpanCount = i11;
            this.mSpanSizeLookup.h();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i11);
        }
    }

    public void setSpanSizeLookup(c cVar) {
        this.mSpanSizeLookup = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z11) {
        if (z11) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z11) {
        this.mUsingSpansToEstimateScrollBarDimensions = z11;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }
}
