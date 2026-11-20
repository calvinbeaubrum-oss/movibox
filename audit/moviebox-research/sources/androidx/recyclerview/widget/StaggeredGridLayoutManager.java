package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.m implements RecyclerView.w.b {
    static final boolean DEBUG = false;

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private int mFullSizeSpec;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;

    @NonNull
    private final g mLayoutState;
    private int mOrientation;
    private SavedState mPendingSavedState;
    private int[] mPrefetchDistances;

    @NonNull
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;

    @NonNull
    OrientationHelper mSecondaryOrientation;
    private int mSizePerSpan;
    c[] mSpans;
    private int mSpanCount = -1;
    boolean mReverseLayout = false;
    boolean mShouldReverseLayout = false;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    LazySpanLookup mLazySpanLookup = new LazySpanLookup();
    private int mGapStrategy = 2;
    private final Rect mTmpRect = new Rect();
    private final a mAnchorInfo = new a();
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mSmoothScrollbarEnabled = true;
    private final Runnable mCheckForGapsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
        }
    };

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class LazySpanLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f12597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<FullSpanItem> f12598b;

        /* JADX INFO: compiled from: source.java */
        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f12599a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f12600b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int[] f12601c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f12602d;

            /* JADX INFO: compiled from: source.java */
            public class a implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i11) {
                    return new FullSpanItem[i11];
                }
            }

            public FullSpanItem() {
            }

            public FullSpanItem(Parcel parcel) {
                this.f12599a = parcel.readInt();
                this.f12600b = parcel.readInt();
                this.f12602d = parcel.readInt() == 1;
                int i11 = parcel.readInt();
                if (i11 > 0) {
                    int[] iArr = new int[i11];
                    this.f12601c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i11) {
                int[] iArr = this.f12601c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i11];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f12599a + ", mGapDir=" + this.f12600b + ", mHasUnwantedGapAfter=" + this.f12602d + ", mGapPerSpan=" + Arrays.toString(this.f12601c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(this.f12599a);
                parcel.writeInt(this.f12600b);
                parcel.writeInt(this.f12602d ? 1 : 0);
                int[] iArr = this.f12601c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f12601c);
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f12598b == null) {
                this.f12598b = new ArrayList();
            }
            int size = this.f12598b.size();
            for (int i11 = 0; i11 < size; i11++) {
                FullSpanItem fullSpanItem2 = this.f12598b.get(i11);
                if (fullSpanItem2.f12599a == fullSpanItem.f12599a) {
                    this.f12598b.remove(i11);
                }
                if (fullSpanItem2.f12599a >= fullSpanItem.f12599a) {
                    this.f12598b.add(i11, fullSpanItem);
                    return;
                }
            }
            this.f12598b.add(fullSpanItem);
        }

        public void b() {
            int[] iArr = this.f12597a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f12598b = null;
        }

        public void c(int i11) {
            int[] iArr = this.f12597a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i11, 10) + 1];
                this.f12597a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i11 >= iArr.length) {
                int[] iArr3 = new int[o(i11)];
                this.f12597a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f12597a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i11) {
            List<FullSpanItem> list = this.f12598b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f12598b.get(size).f12599a >= i11) {
                        this.f12598b.remove(size);
                    }
                }
            }
            return h(i11);
        }

        public FullSpanItem e(int i11, int i12, int i13, boolean z11) {
            List<FullSpanItem> list = this.f12598b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i14 = 0; i14 < size; i14++) {
                FullSpanItem fullSpanItem = this.f12598b.get(i14);
                int i15 = fullSpanItem.f12599a;
                if (i15 >= i12) {
                    return null;
                }
                if (i15 >= i11 && (i13 == 0 || fullSpanItem.f12600b == i13 || (z11 && fullSpanItem.f12602d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i11) {
            List<FullSpanItem> list = this.f12598b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f12598b.get(size);
                if (fullSpanItem.f12599a == i11) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public int g(int i11) {
            int[] iArr = this.f12597a;
            if (iArr == null || i11 >= iArr.length) {
                return -1;
            }
            return iArr[i11];
        }

        public int h(int i11) {
            int[] iArr = this.f12597a;
            if (iArr == null || i11 >= iArr.length) {
                return -1;
            }
            int i12 = i(i11);
            if (i12 == -1) {
                int[] iArr2 = this.f12597a;
                Arrays.fill(iArr2, i11, iArr2.length, -1);
                return this.f12597a.length;
            }
            int iMin = Math.min(i12 + 1, this.f12597a.length);
            Arrays.fill(this.f12597a, i11, iMin, -1);
            return iMin;
        }

        public final int i(int i11) {
            if (this.f12598b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemF = f(i11);
            if (fullSpanItemF != null) {
                this.f12598b.remove(fullSpanItemF);
            }
            int size = this.f12598b.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    i12 = -1;
                    break;
                }
                if (this.f12598b.get(i12).f12599a >= i11) {
                    break;
                }
                i12++;
            }
            if (i12 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f12598b.get(i12);
            this.f12598b.remove(i12);
            return fullSpanItem.f12599a;
        }

        public void j(int i11, int i12) {
            int[] iArr = this.f12597a;
            if (iArr == null || i11 >= iArr.length) {
                return;
            }
            int i13 = i11 + i12;
            c(i13);
            int[] iArr2 = this.f12597a;
            System.arraycopy(iArr2, i11, iArr2, i13, (iArr2.length - i11) - i12);
            Arrays.fill(this.f12597a, i11, i13, -1);
            l(i11, i12);
        }

        public void k(int i11, int i12) {
            int[] iArr = this.f12597a;
            if (iArr == null || i11 >= iArr.length) {
                return;
            }
            int i13 = i11 + i12;
            c(i13);
            int[] iArr2 = this.f12597a;
            System.arraycopy(iArr2, i13, iArr2, i11, (iArr2.length - i11) - i12);
            int[] iArr3 = this.f12597a;
            Arrays.fill(iArr3, iArr3.length - i12, iArr3.length, -1);
            m(i11, i12);
        }

        public final void l(int i11, int i12) {
            List<FullSpanItem> list = this.f12598b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f12598b.get(size);
                int i13 = fullSpanItem.f12599a;
                if (i13 >= i11) {
                    fullSpanItem.f12599a = i13 + i12;
                }
            }
        }

        public final void m(int i11, int i12) {
            List<FullSpanItem> list = this.f12598b;
            if (list == null) {
                return;
            }
            int i13 = i11 + i12;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f12598b.get(size);
                int i14 = fullSpanItem.f12599a;
                if (i14 >= i11) {
                    if (i14 < i13) {
                        this.f12598b.remove(size);
                    } else {
                        fullSpanItem.f12599a = i14 - i12;
                    }
                }
            }
        }

        public void n(int i11, c cVar) {
            c(i11);
            this.f12597a[i11] = cVar.f12616e;
        }

        public int o(int i11) {
            int length = this.f12597a.length;
            while (length <= i11) {
                length *= 2;
            }
            return length;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        /* JADX INFO: compiled from: source.java */
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
            this.mVisibleAnchorPosition = parcel.readInt();
            int i11 = parcel.readInt();
            this.mSpanOffsetsSize = i11;
            if (i11 > 0) {
                int[] iArr = new int[i11];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int i12 = parcel.readInt();
            this.mSpanLookupSize = i12;
            if (i12 > 0) {
                int[] iArr2 = new int[i12];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f12608f;

        public a() {
            c();
        }

        public void a() {
            this.f12604b = this.f12605c ? StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() : StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
        }

        public void b(int i11) {
            if (this.f12605c) {
                this.f12604b = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - i11;
            } else {
                this.f12604b = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + i11;
            }
        }

        public void c() {
            this.f12603a = -1;
            this.f12604b = Integer.MIN_VALUE;
            this.f12605c = false;
            this.f12606d = false;
            this.f12607e = false;
            int[] iArr = this.f12608f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f12608f;
            if (iArr == null || iArr.length < length) {
                this.f12608f = new int[StaggeredGridLayoutManager.this.mSpans.length];
            }
            for (int i11 = 0; i11 < length; i11++) {
                this.f12608f[i11] = cVarArr[i11].u(Integer.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class b extends RecyclerView.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f12610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12611b;

        public b(int i11, int i12) {
            super(i11, i12);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int c() {
            c cVar = this.f12610a;
            if (cVar == null) {
                return -1;
            }
            return cVar.f12616e;
        }

        public boolean d() {
            return this.f12611b;
        }

        public void e(boolean z11) {
            this.f12611b = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<View> f12612a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12613b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12614c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12615d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12616e;

        public c(int i11) {
            this.f12616e = i11;
        }

        public void A(int i11) {
            this.f12613b = i11;
            this.f12614c = i11;
        }

        public void a(View view) {
            b bVarS = s(view);
            bVarS.f12610a = this;
            this.f12612a.add(view);
            this.f12614c = Integer.MIN_VALUE;
            if (this.f12612a.size() == 1) {
                this.f12613b = Integer.MIN_VALUE;
            }
            if (bVarS.isItemRemoved() || bVarS.isItemChanged()) {
                this.f12615d += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        public void b(boolean z11, int i11) {
            int iQ = z11 ? q(Integer.MIN_VALUE) : u(Integer.MIN_VALUE);
            e();
            if (iQ == Integer.MIN_VALUE) {
                return;
            }
            if (!z11 || iQ >= StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) {
                if (z11 || iQ <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()) {
                    if (i11 != Integer.MIN_VALUE) {
                        iQ += i11;
                    }
                    this.f12614c = iQ;
                    this.f12613b = iQ;
                }
            }
        }

        public void c() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            ArrayList<View> arrayList = this.f12612a;
            View view = arrayList.get(arrayList.size() - 1);
            b bVarS = s(view);
            this.f12614c = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (bVarS.f12611b && (fullSpanItemF = StaggeredGridLayoutManager.this.mLazySpanLookup.f(bVarS.getViewLayoutPosition())) != null && fullSpanItemF.f12600b == 1) {
                this.f12614c += fullSpanItemF.a(this.f12616e);
            }
        }

        public void d() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = this.f12612a.get(0);
            b bVarS = s(view);
            this.f12613b = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (bVarS.f12611b && (fullSpanItemF = StaggeredGridLayoutManager.this.mLazySpanLookup.f(bVarS.getViewLayoutPosition())) != null && fullSpanItemF.f12600b == -1) {
                this.f12613b -= fullSpanItemF.a(this.f12616e);
            }
        }

        public void e() {
            this.f12612a.clear();
            v();
            this.f12615d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? n(this.f12612a.size() - 1, -1, true) : n(0, this.f12612a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? m(this.f12612a.size() - 1, -1, true) : m(0, this.f12612a.size(), true);
        }

        public int h() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? n(this.f12612a.size() - 1, -1, false) : n(0, this.f12612a.size(), false);
        }

        public int i() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? n(0, this.f12612a.size(), true) : n(this.f12612a.size() - 1, -1, true);
        }

        public int j() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? m(0, this.f12612a.size(), true) : m(this.f12612a.size() - 1, -1, true);
        }

        public int k() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? n(0, this.f12612a.size(), false) : n(this.f12612a.size() - 1, -1, false);
        }

        public int l(int i11, int i12, boolean z11, boolean z12, boolean z13) {
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            int i13 = i12 > i11 ? 1 : -1;
            while (i11 != i12) {
                View view = this.f12612a.get(i11);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                boolean z14 = false;
                boolean z15 = !z13 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding;
                if (!z13 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z14 = true;
                }
                if (z15 && z14) {
                    if (z11 && z12) {
                        if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z12) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i11 += i13;
            }
            return -1;
        }

        public int m(int i11, int i12, boolean z11) {
            return l(i11, i12, false, false, z11);
        }

        public int n(int i11, int i12, boolean z11) {
            return l(i11, i12, z11, true, false);
        }

        public int o() {
            return this.f12615d;
        }

        public int p() {
            int i11 = this.f12614c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            c();
            return this.f12614c;
        }

        public int q(int i11) {
            int i12 = this.f12614c;
            if (i12 != Integer.MIN_VALUE) {
                return i12;
            }
            if (this.f12612a.size() == 0) {
                return i11;
            }
            c();
            return this.f12614c;
        }

        public View r(int i11, int i12) {
            View view = null;
            if (i12 != -1) {
                int size = this.f12612a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f12612a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= i11) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view2) <= i11) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f12612a.size();
                int i13 = 0;
                while (i13 < size2) {
                    View view3 = this.f12612a.get(i13);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view3) <= i11) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view3) >= i11) || !view3.hasFocusable()) {
                        break;
                    }
                    i13++;
                    view = view3;
                }
            }
            return view;
        }

        public b s(View view) {
            return (b) view.getLayoutParams();
        }

        public int t() {
            int i11 = this.f12613b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            d();
            return this.f12613b;
        }

        public int u(int i11) {
            int i12 = this.f12613b;
            if (i12 != Integer.MIN_VALUE) {
                return i12;
            }
            if (this.f12612a.size() == 0) {
                return i11;
            }
            d();
            return this.f12613b;
        }

        public void v() {
            this.f12613b = Integer.MIN_VALUE;
            this.f12614c = Integer.MIN_VALUE;
        }

        public void w(int i11) {
            int i12 = this.f12613b;
            if (i12 != Integer.MIN_VALUE) {
                this.f12613b = i12 + i11;
            }
            int i13 = this.f12614c;
            if (i13 != Integer.MIN_VALUE) {
                this.f12614c = i13 + i11;
            }
        }

        public void x() {
            int size = this.f12612a.size();
            View viewRemove = this.f12612a.remove(size - 1);
            b bVarS = s(viewRemove);
            bVarS.f12610a = null;
            if (bVarS.isItemRemoved() || bVarS.isItemChanged()) {
                this.f12615d -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(viewRemove);
            }
            if (size == 1) {
                this.f12613b = Integer.MIN_VALUE;
            }
            this.f12614c = Integer.MIN_VALUE;
        }

        public void y() {
            View viewRemove = this.f12612a.remove(0);
            b bVarS = s(viewRemove);
            bVarS.f12610a = null;
            if (this.f12612a.size() == 0) {
                this.f12614c = Integer.MIN_VALUE;
            }
            if (bVarS.isItemRemoved() || bVarS.isItemChanged()) {
                this.f12615d -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(viewRemove);
            }
            this.f12613b = Integer.MIN_VALUE;
        }

        public void z(View view) {
            b bVarS = s(view);
            bVarS.f12610a = this;
            this.f12612a.add(0, view);
            this.f12613b = Integer.MIN_VALUE;
            if (this.f12612a.size() == 1) {
                this.f12614c = Integer.MIN_VALUE;
            }
            if (bVarS.isItemRemoved() || bVarS.isItemChanged()) {
                this.f12615d += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }
    }

    public StaggeredGridLayoutManager(int i11, int i12) {
        this.mOrientation = i12;
        setSpanCount(i11);
        this.mLayoutState = new g();
        createOrientationHelpers();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        RecyclerView.m.d properties = RecyclerView.m.getProperties(context, attributeSet, i11, i12);
        setOrientation(properties.f12545a);
        setSpanCount(properties.f12546b);
        setReverseLayout(properties.f12547c);
        this.mLayoutState = new g();
        createOrientationHelpers();
    }

    private void appendViewToAllSpans(View view) {
        for (int i11 = this.mSpanCount - 1; i11 >= 0; i11--) {
            this.mSpans[i11].a(view);
        }
    }

    private void applyPendingSavedState(a aVar) {
        SavedState savedState = this.mPendingSavedState;
        int i11 = savedState.mSpanOffsetsSize;
        if (i11 > 0) {
            if (i11 == this.mSpanCount) {
                for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                    this.mSpans[i12].e();
                    SavedState savedState2 = this.mPendingSavedState;
                    int endAfterPadding = savedState2.mSpanOffsets[i12];
                    if (endAfterPadding != Integer.MIN_VALUE) {
                        endAfterPadding += savedState2.mAnchorLayoutFromEnd ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
                    }
                    this.mSpans[i12].A(endAfterPadding);
                }
            } else {
                savedState.invalidateSpanInfo();
                SavedState savedState3 = this.mPendingSavedState;
                savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
            }
        }
        SavedState savedState4 = this.mPendingSavedState;
        this.mLastLayoutRTL = savedState4.mLastLayoutRTL;
        setReverseLayout(savedState4.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.mPendingSavedState;
        int i13 = savedState5.mAnchorPosition;
        if (i13 != -1) {
            this.mPendingScrollPosition = i13;
            aVar.f12605c = savedState5.mAnchorLayoutFromEnd;
        } else {
            aVar.f12605c = this.mShouldReverseLayout;
        }
        if (savedState5.mSpanLookupSize > 1) {
            LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
            lazySpanLookup.f12597a = savedState5.mSpanLookup;
            lazySpanLookup.f12598b = savedState5.mFullSpanItems;
        }
    }

    private void attachViewToSpans(View view, b bVar, g gVar) {
        if (gVar.f12664e == 1) {
            if (bVar.f12611b) {
                appendViewToAllSpans(view);
                return;
            } else {
                bVar.f12610a.a(view);
                return;
            }
        }
        if (bVar.f12611b) {
            prependViewToAllSpans(view);
        } else {
            bVar.f12610a.z(view);
        }
    }

    private int calculateScrollDirectionForPosition(int i11) {
        if (getChildCount() == 0) {
            return this.mShouldReverseLayout ? 1 : -1;
        }
        return (i11 < getFirstChildPosition()) != this.mShouldReverseLayout ? -1 : 1;
    }

    private boolean checkSpanForGap(c cVar) {
        if (this.mShouldReverseLayout) {
            if (cVar.p() < this.mPrimaryOrientation.getEndAfterPadding()) {
                ArrayList<View> arrayList = cVar.f12612a;
                return !cVar.s(arrayList.get(arrayList.size() - 1)).f12611b;
            }
        } else if (cVar.t() > this.mPrimaryOrientation.getStartAfterPadding()) {
            return !cVar.s(cVar.f12612a.get(0)).f12611b;
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return o.a(xVar, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return o.b(xVar, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return o.c(xVar, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int convertFocusDirectionToLayoutDirection(int i11) {
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

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int i11) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f12601c = new int[this.mSpanCount];
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            fullSpanItem.f12601c[i12] = i11 - this.mSpans[i12].q(i11);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int i11) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f12601c = new int[this.mSpanCount];
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            fullSpanItem.f12601c[i12] = this.mSpans[i12].u(i11) - i11;
        }
        return fullSpanItem;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int fill(RecyclerView.t tVar, g gVar, RecyclerView.x xVar) {
        int i11;
        int maxEnd;
        c nextSpan;
        int decoratedMeasurement;
        int i12;
        int decoratedMeasurement2;
        int decoratedMeasurement3;
        ?? r11 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.f12668i) {
            i11 = gVar.f12664e == 1 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : Integer.MIN_VALUE;
        } else {
            i11 = gVar.f12664e == 1 ? gVar.f12666g + gVar.f12661b : gVar.f12665f - gVar.f12661b;
        }
        updateAllRemainingSpans(gVar.f12664e, i11);
        int endAfterPadding = this.mShouldReverseLayout ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
        boolean z11 = false;
        while (gVar.a(xVar) && (this.mLayoutState.f12668i || !this.mRemainingSpans.isEmpty())) {
            View viewB = gVar.b(tVar);
            b bVar = (b) viewB.getLayoutParams();
            int viewLayoutPosition = bVar.getViewLayoutPosition();
            int iG = this.mLazySpanLookup.g(viewLayoutPosition);
            boolean z12 = iG == -1;
            if (z12) {
                nextSpan = bVar.f12611b ? this.mSpans[r11] : getNextSpan(gVar);
                this.mLazySpanLookup.n(viewLayoutPosition, nextSpan);
            } else {
                nextSpan = this.mSpans[iG];
            }
            c cVar = nextSpan;
            bVar.f12610a = cVar;
            if (gVar.f12664e == 1) {
                addView(viewB);
            } else {
                addView(viewB, r11);
            }
            measureChildWithDecorationsAndMargin(viewB, bVar, r11);
            if (gVar.f12664e == 1) {
                int maxEnd2 = bVar.f12611b ? getMaxEnd(endAfterPadding) : cVar.q(endAfterPadding);
                int decoratedMeasurement4 = this.mPrimaryOrientation.getDecoratedMeasurement(viewB) + maxEnd2;
                if (z12 && bVar.f12611b) {
                    LazySpanLookup.FullSpanItem fullSpanItemCreateFullSpanItemFromEnd = createFullSpanItemFromEnd(maxEnd2);
                    fullSpanItemCreateFullSpanItemFromEnd.f12600b = -1;
                    fullSpanItemCreateFullSpanItemFromEnd.f12599a = viewLayoutPosition;
                    this.mLazySpanLookup.a(fullSpanItemCreateFullSpanItemFromEnd);
                }
                i12 = decoratedMeasurement4;
                decoratedMeasurement = maxEnd2;
            } else {
                int minStart = bVar.f12611b ? getMinStart(endAfterPadding) : cVar.u(endAfterPadding);
                decoratedMeasurement = minStart - this.mPrimaryOrientation.getDecoratedMeasurement(viewB);
                if (z12 && bVar.f12611b) {
                    LazySpanLookup.FullSpanItem fullSpanItemCreateFullSpanItemFromStart = createFullSpanItemFromStart(minStart);
                    fullSpanItemCreateFullSpanItemFromStart.f12600b = 1;
                    fullSpanItemCreateFullSpanItemFromStart.f12599a = viewLayoutPosition;
                    this.mLazySpanLookup.a(fullSpanItemCreateFullSpanItemFromStart);
                }
                i12 = minStart;
            }
            if (bVar.f12611b && gVar.f12663d == -1) {
                if (z12) {
                    this.mLaidOutInvalidFullSpan = true;
                } else {
                    if (!(gVar.f12664e == 1 ? areAllEndsEqual() : areAllStartsEqual())) {
                        LazySpanLookup.FullSpanItem fullSpanItemF = this.mLazySpanLookup.f(viewLayoutPosition);
                        if (fullSpanItemF != null) {
                            fullSpanItemF.f12602d = true;
                        }
                        this.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            attachViewToSpans(viewB, bVar, gVar);
            if (isLayoutRTL() && this.mOrientation == 1) {
                int endAfterPadding2 = bVar.f12611b ? this.mSecondaryOrientation.getEndAfterPadding() : this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - cVar.f12616e) * this.mSizePerSpan);
                decoratedMeasurement3 = endAfterPadding2;
                decoratedMeasurement2 = endAfterPadding2 - this.mSecondaryOrientation.getDecoratedMeasurement(viewB);
            } else {
                int startAfterPadding = bVar.f12611b ? this.mSecondaryOrientation.getStartAfterPadding() : (cVar.f12616e * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
                decoratedMeasurement2 = startAfterPadding;
                decoratedMeasurement3 = this.mSecondaryOrientation.getDecoratedMeasurement(viewB) + startAfterPadding;
            }
            if (this.mOrientation == 1) {
                layoutDecoratedWithMargins(viewB, decoratedMeasurement2, decoratedMeasurement, decoratedMeasurement3, i12);
            } else {
                layoutDecoratedWithMargins(viewB, decoratedMeasurement, decoratedMeasurement2, i12, decoratedMeasurement3);
            }
            if (bVar.f12611b) {
                updateAllRemainingSpans(this.mLayoutState.f12664e, i11);
            } else {
                updateRemainingSpans(cVar, this.mLayoutState.f12664e, i11);
            }
            recycle(tVar, this.mLayoutState);
            if (this.mLayoutState.f12667h && viewB.hasFocusable()) {
                if (bVar.f12611b) {
                    this.mRemainingSpans.clear();
                } else {
                    this.mRemainingSpans.set(cVar.f12616e, false);
                }
            }
            z11 = true;
            r11 = 0;
        }
        if (!z11) {
            recycle(tVar, this.mLayoutState);
        }
        if (this.mLayoutState.f12664e == -1) {
            maxEnd = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
        } else {
            maxEnd = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        }
        if (maxEnd > 0) {
            return Math.min(gVar.f12661b, maxEnd);
        }
        return 0;
    }

    private int findFirstReferenceChildPosition(int i11) {
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            int position = getPosition(getChildAt(i12));
            if (position >= 0 && position < i11) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i11) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i11) {
                return position;
            }
        }
        return 0;
    }

    private void fixEndGap(RecyclerView.t tVar, RecyclerView.x xVar, boolean z11) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i11 = endAfterPadding - (-scrollBy(-endAfterPadding, tVar, xVar));
            if (!z11 || i11 <= 0) {
                return;
            }
            this.mPrimaryOrientation.offsetChildren(i11);
        }
    }

    private void fixStartGap(RecyclerView.t tVar, RecyclerView.x xVar, boolean z11) {
        int startAfterPadding;
        int minStart = getMinStart(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int iScrollBy = startAfterPadding - scrollBy(startAfterPadding, tVar, xVar);
            if (!z11 || iScrollBy <= 0) {
                return;
            }
            this.mPrimaryOrientation.offsetChildren(-iScrollBy);
        }
    }

    private int getMaxEnd(int i11) {
        int iQ = this.mSpans[0].q(i11);
        for (int i12 = 1; i12 < this.mSpanCount; i12++) {
            int iQ2 = this.mSpans[i12].q(i11);
            if (iQ2 > iQ) {
                iQ = iQ2;
            }
        }
        return iQ;
    }

    private int getMaxStart(int i11) {
        int iU = this.mSpans[0].u(i11);
        for (int i12 = 1; i12 < this.mSpanCount; i12++) {
            int iU2 = this.mSpans[i12].u(i11);
            if (iU2 > iU) {
                iU = iU2;
            }
        }
        return iU;
    }

    private int getMinEnd(int i11) {
        int iQ = this.mSpans[0].q(i11);
        for (int i12 = 1; i12 < this.mSpanCount; i12++) {
            int iQ2 = this.mSpans[i12].q(i11);
            if (iQ2 < iQ) {
                iQ = iQ2;
            }
        }
        return iQ;
    }

    private int getMinStart(int i11) {
        int iU = this.mSpans[0].u(i11);
        for (int i12 = 1; i12 < this.mSpanCount; i12++) {
            int iU2 = this.mSpans[i12].u(i11);
            if (iU2 < iU) {
                iU = iU2;
            }
        }
        return iU;
    }

    private c getNextSpan(g gVar) {
        int i11;
        int i12;
        int i13;
        if (preferLastSpan(gVar.f12664e)) {
            i12 = this.mSpanCount - 1;
            i11 = -1;
            i13 = -1;
        } else {
            i11 = this.mSpanCount;
            i12 = 0;
            i13 = 1;
        }
        c cVar = null;
        if (gVar.f12664e == 1) {
            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            int i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            while (i12 != i11) {
                c cVar2 = this.mSpans[i12];
                int iQ = cVar2.q(startAfterPadding);
                if (iQ < i14) {
                    cVar = cVar2;
                    i14 = iQ;
                }
                i12 += i13;
            }
            return cVar;
        }
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int i15 = Integer.MIN_VALUE;
        while (i12 != i11) {
            c cVar3 = this.mSpans[i12];
            int iU = cVar3.u(endAfterPadding);
            if (iU > i15) {
                cVar = cVar3;
                i15 = iU;
            }
            i12 += i13;
        }
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0026  */
    /* JADX WARN: Code duplicated, block: B:17:0x0029 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0037  */
    /* JADX WARN: Code duplicated, block: B:21:0x003d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    private void handleUpdate(int i11, int i12, int i13) {
        int i14;
        int i15;
        int lastChildPosition;
        int lastChildPosition2 = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
        if (i13 == 8) {
            if (i11 < i12) {
                i14 = i12 + 1;
            } else {
                i14 = i11 + 1;
                i15 = i12;
            }
            this.mLazySpanLookup.h(i15);
            if (i13 != 1) {
                this.mLazySpanLookup.j(i11, i12);
            } else if (i13 != 2) {
                this.mLazySpanLookup.k(i11, i12);
            } else if (i13 == 8) {
                this.mLazySpanLookup.k(i11, 1);
                this.mLazySpanLookup.j(i12, 1);
            }
            if (i14 <= lastChildPosition2) {
                return;
            }
            if (this.mShouldReverseLayout) {
                lastChildPosition = getFirstChildPosition();
            } else {
                lastChildPosition = getLastChildPosition();
            }
            if (i15 <= lastChildPosition) {
                requestLayout();
            }
        }
        i14 = i11 + i12;
        i15 = i11;
        this.mLazySpanLookup.h(i15);
        if (i13 != 1) {
            this.mLazySpanLookup.j(i11, i12);
        } else if (i13 != 2) {
            this.mLazySpanLookup.k(i11, i12);
        } else if (i13 == 8) {
            this.mLazySpanLookup.k(i11, 1);
            this.mLazySpanLookup.j(i12, 1);
        }
        if (i14 <= lastChildPosition2) {
            return;
        }
        if (this.mShouldReverseLayout) {
            lastChildPosition = getFirstChildPosition();
        } else {
            lastChildPosition = getLastChildPosition();
        }
        if (i15 <= lastChildPosition) {
            requestLayout();
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, int i11, int i12, boolean z11) {
        calculateItemDecorationsForChild(view, this.mTmpRect);
        b bVar = (b) view.getLayoutParams();
        int i13 = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
        Rect rect = this.mTmpRect;
        int iUpdateSpecWithExtra = updateSpecWithExtra(i11, i13 + rect.left, ((ViewGroup.MarginLayoutParams) bVar).rightMargin + rect.right);
        int i14 = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
        Rect rect2 = this.mTmpRect;
        int iUpdateSpecWithExtra2 = updateSpecWithExtra(i12, i14 + rect2.top, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin + rect2.bottom);
        if (z11 ? shouldReMeasureChild(view, iUpdateSpecWithExtra, iUpdateSpecWithExtra2, bVar) : shouldMeasureChild(view, iUpdateSpecWithExtra, iUpdateSpecWithExtra2, bVar)) {
            view.measure(iUpdateSpecWithExtra, iUpdateSpecWithExtra2);
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, b bVar, boolean z11) {
        if (bVar.f12611b) {
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) bVar).height, true), z11);
                return;
            } else {
                measureChildWithDecorationsAndMargin(view, RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) bVar).width, true), this.mFullSizeSpec, z11);
                return;
            }
        }
        if (this.mOrientation == 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView.m.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) bVar).width, false), RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) bVar).height, true), z11);
        } else {
            measureChildWithDecorationsAndMargin(view, RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) bVar).width, true), RecyclerView.m.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) bVar).height, false), z11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0155  */
    private void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar, boolean z11) {
        boolean z12;
        SavedState savedState;
        a aVar = this.mAnchorInfo;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && xVar.b() == 0) {
            removeAndRecycleAllViews(tVar);
            aVar.c();
            return;
        }
        boolean z13 = (aVar.f12607e && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) ? false : true;
        if (z13) {
            aVar.c();
            if (this.mPendingSavedState != null) {
                applyPendingSavedState(aVar);
            } else {
                resolveShouldLayoutReverse();
                aVar.f12605c = this.mShouldReverseLayout;
            }
            updateAnchorInfoForLayout(xVar, aVar);
            aVar.f12607e = true;
        }
        if (this.mPendingSavedState == null && this.mPendingScrollPosition == -1 && (aVar.f12605c != this.mLastLayoutFromEnd || isLayoutRTL() != this.mLastLayoutRTL)) {
            this.mLazySpanLookup.b();
            aVar.f12606d = true;
        }
        if (getChildCount() > 0 && ((savedState = this.mPendingSavedState) == null || savedState.mSpanOffsetsSize < 1)) {
            if (aVar.f12606d) {
                for (int i11 = 0; i11 < this.mSpanCount; i11++) {
                    this.mSpans[i11].e();
                    int i12 = aVar.f12604b;
                    if (i12 != Integer.MIN_VALUE) {
                        this.mSpans[i11].A(i12);
                    }
                }
            } else if (z13 || this.mAnchorInfo.f12608f == null) {
                for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                    this.mSpans[i13].b(this.mShouldReverseLayout, aVar.f12604b);
                }
                this.mAnchorInfo.d(this.mSpans);
            } else {
                for (int i14 = 0; i14 < this.mSpanCount; i14++) {
                    c cVar = this.mSpans[i14];
                    cVar.e();
                    cVar.A(this.mAnchorInfo.f12608f[i14]);
                }
            }
        }
        detachAndScrapAttachedViews(tVar);
        this.mLayoutState.f12660a = false;
        this.mLaidOutInvalidFullSpan = false;
        updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
        updateLayoutState(aVar.f12603a, xVar);
        if (aVar.f12605c) {
            setLayoutStateDirection(-1);
            fill(tVar, this.mLayoutState, xVar);
            setLayoutStateDirection(1);
            g gVar = this.mLayoutState;
            gVar.f12662c = aVar.f12603a + gVar.f12663d;
            fill(tVar, gVar, xVar);
        } else {
            setLayoutStateDirection(1);
            fill(tVar, this.mLayoutState, xVar);
            setLayoutStateDirection(-1);
            g gVar2 = this.mLayoutState;
            gVar2.f12662c = aVar.f12603a + gVar2.f12663d;
            fill(tVar, gVar2, xVar);
        }
        repositionToWrapContentIfNecessary();
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout) {
                fixEndGap(tVar, xVar, true);
                fixStartGap(tVar, xVar, false);
            } else {
                fixStartGap(tVar, xVar, true);
                fixEndGap(tVar, xVar, false);
            }
        }
        if (z11 && !xVar.e() && this.mGapStrategy != 0 && getChildCount() > 0 && (this.mLaidOutInvalidFullSpan || hasGapsToFix() != null)) {
            removeCallbacks(this.mCheckForGapsRunnable);
            z12 = checkForGaps();
        }
        if (xVar.e()) {
            this.mAnchorInfo.c();
        }
        this.mLastLayoutFromEnd = aVar.f12605c;
        this.mLastLayoutRTL = isLayoutRTL();
        if (z12) {
            this.mAnchorInfo.c();
            onLayoutChildren(tVar, xVar, false);
        }
    }

    private boolean preferLastSpan(int i11) {
        if (this.mOrientation == 0) {
            return (i11 == -1) != this.mShouldReverseLayout;
        }
        return ((i11 == -1) == this.mShouldReverseLayout) == isLayoutRTL();
    }

    private void prependViewToAllSpans(View view) {
        for (int i11 = this.mSpanCount - 1; i11 >= 0; i11--) {
            this.mSpans[i11].z(view);
        }
    }

    private void recycle(RecyclerView.t tVar, g gVar) {
        int iMin;
        if (!gVar.f12660a || gVar.f12668i) {
            return;
        }
        if (gVar.f12661b == 0) {
            if (gVar.f12664e == -1) {
                recycleFromEnd(tVar, gVar.f12666g);
                return;
            } else {
                recycleFromStart(tVar, gVar.f12665f);
                return;
            }
        }
        if (gVar.f12664e == -1) {
            int i11 = gVar.f12665f;
            int maxStart = i11 - getMaxStart(i11);
            recycleFromEnd(tVar, maxStart < 0 ? gVar.f12666g : gVar.f12666g - Math.min(maxStart, gVar.f12661b));
        } else {
            int minEnd = getMinEnd(gVar.f12666g) - gVar.f12666g;
            if (minEnd < 0) {
                iMin = gVar.f12665f;
            } else {
                iMin = Math.min(minEnd, gVar.f12661b) + gVar.f12665f;
            }
            recycleFromStart(tVar, iMin);
        }
    }

    private void recycleFromEnd(RecyclerView.t tVar, int i11) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) < i11 || this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) < i11) {
                return;
            }
            b bVar = (b) childAt.getLayoutParams();
            if (bVar.f12611b) {
                for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                    if (this.mSpans[i12].f12612a.size() == 1) {
                        return;
                    }
                }
                for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                    this.mSpans[i13].x();
                }
            } else if (bVar.f12610a.f12612a.size() == 1) {
                return;
            } else {
                bVar.f12610a.x();
            }
            removeAndRecycleView(childAt, tVar);
        }
    }

    private void recycleFromStart(RecyclerView.t tVar, int i11) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > i11 || this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) > i11) {
                return;
            }
            b bVar = (b) childAt.getLayoutParams();
            if (bVar.f12611b) {
                for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                    if (this.mSpans[i12].f12612a.size() == 1) {
                        return;
                    }
                }
                for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                    this.mSpans[i13].y();
                }
            } else if (bVar.f12610a.f12612a.size() == 1) {
                return;
            } else {
                bVar.f12610a.y();
            }
            removeAndRecycleView(childAt, tVar);
        }
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            float decoratedMeasurement = this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
            if (decoratedMeasurement >= fMax) {
                if (((b) childAt.getLayoutParams()).d()) {
                    decoratedMeasurement = (decoratedMeasurement * 1.0f) / this.mSpanCount;
                }
                fMax = Math.max(fMax, decoratedMeasurement);
            }
        }
        int i12 = this.mSizePerSpan;
        int iRound = Math.round(fMax * this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.mSecondaryOrientation.getTotalSpace());
        }
        updateMeasureSpecs(iRound);
        if (this.mSizePerSpan == i12) {
            return;
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            b bVar = (b) childAt2.getLayoutParams();
            if (!bVar.f12611b) {
                if (isLayoutRTL() && this.mOrientation == 1) {
                    int i14 = this.mSpanCount;
                    int i15 = bVar.f12610a.f12616e;
                    childAt2.offsetLeftAndRight(((-((i14 - 1) - i15)) * this.mSizePerSpan) - ((-((i14 - 1) - i15)) * i12));
                } else {
                    int i16 = bVar.f12610a.f12616e;
                    int i17 = this.mSizePerSpan * i16;
                    int i18 = i16 * i12;
                    if (this.mOrientation == 1) {
                        childAt2.offsetLeftAndRight(i17 - i18);
                    } else {
                        childAt2.offsetTopAndBottom(i17 - i18);
                    }
                }
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

    private void setLayoutStateDirection(int i11) {
        g gVar = this.mLayoutState;
        gVar.f12664e = i11;
        gVar.f12663d = this.mShouldReverseLayout != (i11 == -1) ? -1 : 1;
    }

    private void updateAllRemainingSpans(int i11, int i12) {
        for (int i13 = 0; i13 < this.mSpanCount; i13++) {
            if (!this.mSpans[i13].f12612a.isEmpty()) {
                updateRemainingSpans(this.mSpans[i13], i11, i12);
            }
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.x xVar, a aVar) {
        aVar.f12603a = this.mLastLayoutFromEnd ? findLastReferenceChildPosition(xVar.b()) : findFirstReferenceChildPosition(xVar.b());
        aVar.f12604b = Integer.MIN_VALUE;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    /* JADX WARN: Code duplicated, block: B:18:0x004e  */
    private void updateLayoutState(int i11, RecyclerView.x xVar) {
        int totalSpace;
        int totalSpace2;
        int iC;
        g gVar = this.mLayoutState;
        boolean z11 = false;
        gVar.f12661b = 0;
        gVar.f12662c = i11;
        if (isSmoothScrolling() && (iC = xVar.c()) != -1) {
            if (this.mShouldReverseLayout == (iC < i11)) {
                totalSpace = this.mPrimaryOrientation.getTotalSpace();
            } else {
                totalSpace2 = this.mPrimaryOrientation.getTotalSpace();
                totalSpace = 0;
            }
            if (getClipToPadding()) {
                this.mLayoutState.f12665f = this.mPrimaryOrientation.getStartAfterPadding() - totalSpace2;
                this.mLayoutState.f12666g = this.mPrimaryOrientation.getEndAfterPadding() + totalSpace;
            } else {
                this.mLayoutState.f12666g = this.mPrimaryOrientation.getEnd() + totalSpace;
                this.mLayoutState.f12665f = -totalSpace2;
            }
            g gVar2 = this.mLayoutState;
            gVar2.f12667h = false;
            gVar2.f12660a = true;
            if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
                z11 = true;
            }
            gVar2.f12668i = z11;
        }
        totalSpace = 0;
        totalSpace2 = 0;
        if (getClipToPadding()) {
            this.mLayoutState.f12665f = this.mPrimaryOrientation.getStartAfterPadding() - totalSpace2;
            this.mLayoutState.f12666g = this.mPrimaryOrientation.getEndAfterPadding() + totalSpace;
        } else {
            this.mLayoutState.f12666g = this.mPrimaryOrientation.getEnd() + totalSpace;
            this.mLayoutState.f12665f = -totalSpace2;
        }
        g gVar3 = this.mLayoutState;
        gVar3.f12667h = false;
        gVar3.f12660a = true;
        if (this.mPrimaryOrientation.getMode() == 0) {
            z11 = true;
        }
        gVar3.f12668i = z11;
    }

    private void updateRemainingSpans(c cVar, int i11, int i12) {
        int iO = cVar.o();
        if (i11 == -1) {
            if (cVar.t() + iO <= i12) {
                this.mRemainingSpans.set(cVar.f12616e, false);
            }
        } else if (cVar.p() - iO >= i12) {
            this.mRemainingSpans.set(cVar.f12616e, false);
        }
    }

    private int updateSpecWithExtra(int i11, int i12, int i13) {
        if (i12 == 0 && i13 == 0) {
            return i11;
        }
        int mode = View.MeasureSpec.getMode(i11);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i11) - i12) - i13), mode) : i11;
    }

    public boolean areAllEndsEqual() {
        int iQ = this.mSpans[0].q(Integer.MIN_VALUE);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            if (this.mSpans[i11].q(Integer.MIN_VALUE) != iQ) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllStartsEqual() {
        int iU = this.mSpans[0].u(Integer.MIN_VALUE);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            if (this.mSpans[i11].u(Integer.MIN_VALUE) != iU) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public boolean checkForGaps() {
        int firstChildPosition;
        int lastChildPosition;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            firstChildPosition = getLastChildPosition();
            lastChildPosition = getFirstChildPosition();
        } else {
            firstChildPosition = getFirstChildPosition();
            lastChildPosition = getLastChildPosition();
        }
        if (firstChildPosition == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.mLaidOutInvalidFullSpan) {
            return false;
        }
        int i11 = this.mShouldReverseLayout ? -1 : 1;
        int i12 = lastChildPosition + 1;
        LazySpanLookup.FullSpanItem fullSpanItemE = this.mLazySpanLookup.e(firstChildPosition, i12, i11, true);
        if (fullSpanItemE == null) {
            this.mLaidOutInvalidFullSpan = false;
            this.mLazySpanLookup.d(i12);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemE2 = this.mLazySpanLookup.e(firstChildPosition, fullSpanItemE.f12599a, i11 * (-1), true);
        if (fullSpanItemE2 == null) {
            this.mLazySpanLookup.d(fullSpanItemE.f12599a);
        } else {
            this.mLazySpanLookup.d(fullSpanItemE2.f12599a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean checkLayoutParams(RecyclerView.n nVar) {
        return nVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void collectAdjacentPrefetchPositions(int i11, int i12, RecyclerView.x xVar, RecyclerView.m.c cVar) {
        int iQ;
        int iU;
        if (this.mOrientation != 0) {
            i11 = i12;
        }
        if (getChildCount() == 0 || i11 == 0) {
            return;
        }
        prepareLayoutStateForDelta(i11, xVar);
        int[] iArr = this.mPrefetchDistances;
        if (iArr == null || iArr.length < this.mSpanCount) {
            this.mPrefetchDistances = new int[this.mSpanCount];
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.mSpanCount; i14++) {
            g gVar = this.mLayoutState;
            if (gVar.f12663d == -1) {
                iQ = gVar.f12665f;
                iU = this.mSpans[i14].u(iQ);
            } else {
                iQ = this.mSpans[i14].q(gVar.f12666g);
                iU = this.mLayoutState.f12666g;
            }
            int i15 = iQ - iU;
            if (i15 >= 0) {
                this.mPrefetchDistances[i13] = i15;
                i13++;
            }
        }
        Arrays.sort(this.mPrefetchDistances, 0, i13);
        for (int i16 = 0; i16 < i13 && this.mLayoutState.a(xVar); i16++) {
            cVar.a(this.mLayoutState.f12662c, this.mPrefetchDistances[i16]);
            g gVar2 = this.mLayoutState;
            gVar2.f12662c += gVar2.f12663d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollExtent(RecyclerView.x xVar) {
        return computeScrollExtent(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollOffset(RecyclerView.x xVar) {
        return computeScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollRange(RecyclerView.x xVar) {
        return computeScrollRange(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w.b
    public PointF computeScrollVectorForPosition(int i11) {
        int iCalculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i11);
        PointF pointF = new PointF();
        if (iCalculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = iCalculateScrollDirectionForPosition;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iCalculateScrollDirectionForPosition;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollExtent(RecyclerView.x xVar) {
        return computeScrollExtent(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollOffset(RecyclerView.x xVar) {
        return computeScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollRange(RecyclerView.x xVar) {
        return computeScrollRange(xVar);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].f();
        }
        return iArr;
    }

    public View findFirstVisibleItemClosestToEnd(boolean z11) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z11) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View findFirstVisibleItemClosestToStart(boolean z11) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z11) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public int findFirstVisibleItemPositionInt() {
        View viewFindFirstVisibleItemClosestToEnd = this.mShouldReverseLayout ? findFirstVisibleItemClosestToEnd(true) : findFirstVisibleItemClosestToStart(true);
        if (viewFindFirstVisibleItemClosestToEnd == null) {
            return -1;
        }
        return getPosition(viewFindFirstVisibleItemClosestToEnd);
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].h();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].i();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].k();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
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

    public int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x0097  */
    /* JADX WARN: Code duplicated, block: B:40:0x0099  */
    /* JADX WARN: Code duplicated, block: B:42:0x009c  */
    /* JADX WARN: Code duplicated, block: B:43:0x009e  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2 A[SYNTHETIC] */
    public View hasGapsToFix() {
        int i11;
        boolean z11;
        boolean z12;
        int childCount = getChildCount();
        int i12 = childCount - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(0, this.mSpanCount, true);
        byte b11 = (this.mOrientation == 1 && isLayoutRTL()) ? (byte) 1 : (byte) -1;
        if (this.mShouldReverseLayout) {
            childCount = -1;
        } else {
            i12 = 0;
        }
        int i13 = i12 < childCount ? 1 : -1;
        while (i12 != childCount) {
            View childAt = getChildAt(i12);
            b bVar = (b) childAt.getLayoutParams();
            if (bitSet.get(bVar.f12610a.f12616e)) {
                if (checkSpanForGap(bVar.f12610a)) {
                    return childAt;
                }
                bitSet.clear(bVar.f12610a.f12616e);
            }
            if (!bVar.f12611b && (i11 = i12 + i13) != childCount) {
                View childAt2 = getChildAt(i11);
                if (this.mShouldReverseLayout) {
                    int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                    if (decoratedEnd == decoratedEnd2) {
                        if (bVar.f12610a.f12616e - ((b) childAt2.getLayoutParams()).f12610a.f12616e < 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (b11 < 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z11 != z12) {
                            return childAt;
                        }
                    } else {
                        continue;
                    }
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                    int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                    if (decoratedStart == decoratedStart2) {
                        if (bVar.f12610a.f12616e - ((b) childAt2.getLayoutParams()).f12610a.f12616e < 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (b11 < 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z11 != z12) {
                            return childAt;
                        }
                    } else {
                        continue;
                    }
                }
            }
            i12 += i13;
        }
        return null;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean isAutoMeasureEnabled() {
        return this.mGapStrategy != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void offsetChildrenHorizontal(int i11) {
        super.offsetChildrenHorizontal(i11);
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            this.mSpans[i12].w(i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void offsetChildrenVertical(int i11) {
        super.offsetChildrenVertical(i11);
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            this.mSpans[i12].w(i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onAdapterChanged(@Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2) {
        this.mLazySpanLookup.b();
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            this.mSpans[i11].e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            this.mSpans[i11].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @Nullable
    public View onFocusSearchFailed(View view, int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        View viewFindContainingItemView;
        View viewR;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11);
        if (iConvertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) viewFindContainingItemView.getLayoutParams();
        boolean z11 = bVar.f12611b;
        c cVar = bVar.f12610a;
        int lastChildPosition = iConvertFocusDirectionToLayoutDirection == 1 ? getLastChildPosition() : getFirstChildPosition();
        updateLayoutState(lastChildPosition, xVar);
        setLayoutStateDirection(iConvertFocusDirectionToLayoutDirection);
        g gVar = this.mLayoutState;
        gVar.f12662c = gVar.f12663d + lastChildPosition;
        gVar.f12661b = (int) (this.mPrimaryOrientation.getTotalSpace() * MAX_SCROLL_FACTOR);
        g gVar2 = this.mLayoutState;
        gVar2.f12667h = true;
        gVar2.f12660a = false;
        fill(tVar, gVar2, xVar);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!z11 && (viewR = cVar.r(lastChildPosition, iConvertFocusDirectionToLayoutDirection)) != null && viewR != viewFindContainingItemView) {
            return viewR;
        }
        if (preferLastSpan(iConvertFocusDirectionToLayoutDirection)) {
            for (int i12 = this.mSpanCount - 1; i12 >= 0; i12--) {
                View viewR2 = this.mSpans[i12].r(lastChildPosition, iConvertFocusDirectionToLayoutDirection);
                if (viewR2 != null && viewR2 != viewFindContainingItemView) {
                    return viewR2;
                }
            }
        } else {
            for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                View viewR3 = this.mSpans[i13].r(lastChildPosition, iConvertFocusDirectionToLayoutDirection);
                if (viewR3 != null && viewR3 != viewFindContainingItemView) {
                    return viewR3;
                }
            }
        }
        boolean z12 = (this.mReverseLayout ^ true) == (iConvertFocusDirectionToLayoutDirection == -1);
        if (!z11) {
            View viewFindViewByPosition = findViewByPosition(z12 ? cVar.g() : cVar.j());
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (preferLastSpan(iConvertFocusDirectionToLayoutDirection)) {
            for (int i14 = this.mSpanCount - 1; i14 >= 0; i14--) {
                if (i14 != cVar.f12616e) {
                    View viewFindViewByPosition2 = findViewByPosition(z12 ? this.mSpans[i14].g() : this.mSpans[i14].j());
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i15 = 0; i15 < this.mSpanCount; i15++) {
                View viewFindViewByPosition3 = findViewByPosition(z12 ? this.mSpans[i15].g() : this.mSpans[i15].j());
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewFindFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View viewFindFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (viewFindFirstVisibleItemClosestToStart == null || viewFindFirstVisibleItemClosestToEnd == null) {
                return;
            }
            int position = getPosition(viewFindFirstVisibleItemClosestToStart);
            int position2 = getPosition(viewFindFirstVisibleItemClosestToEnd);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        handleUpdate(i11, i12, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        handleUpdate(i11, i12, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        handleUpdate(i11, i12, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        handleUpdate(i11, i12, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        onLayoutChildren(tVar, xVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutCompleted(RecyclerView.x xVar) {
        super.onLayoutCompleted(xVar);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchorPositionInfo();
                this.mPendingSavedState.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable onSaveInstanceState() {
        int iU;
        int startAfterPadding;
        int[] iArr;
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f12597a) == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = iArr;
            savedState.mSpanLookupSize = iArr.length;
            savedState.mFullSpanItems = lazySpanLookup.f12598b;
        }
        if (getChildCount() > 0) {
            savedState.mAnchorPosition = this.mLastLayoutFromEnd ? getLastChildPosition() : getFirstChildPosition();
            savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
            int i11 = this.mSpanCount;
            savedState.mSpanOffsetsSize = i11;
            savedState.mSpanOffsets = new int[i11];
            for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                if (this.mLastLayoutFromEnd) {
                    iU = this.mSpans[i12].q(Integer.MIN_VALUE);
                    if (iU != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                        iU -= startAfterPadding;
                    }
                } else {
                    iU = this.mSpans[i12].u(Integer.MIN_VALUE);
                    if (iU != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                        iU -= startAfterPadding;
                    }
                }
                savedState.mSpanOffsets[i12] = iU;
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrollStateChanged(int i11) {
        if (i11 == 0) {
            checkForGaps();
        }
    }

    public void prepareLayoutStateForDelta(int i11, RecyclerView.x xVar) {
        int firstChildPosition;
        int i12;
        if (i11 > 0) {
            firstChildPosition = getLastChildPosition();
            i12 = 1;
        } else {
            firstChildPosition = getFirstChildPosition();
            i12 = -1;
        }
        this.mLayoutState.f12660a = true;
        updateLayoutState(firstChildPosition, xVar);
        setLayoutStateDirection(i12);
        g gVar = this.mLayoutState;
        gVar.f12662c = firstChildPosition + gVar.f12663d;
        gVar.f12661b = Math.abs(i11);
    }

    public int scrollBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i11, xVar);
        int iFill = fill(tVar, this.mLayoutState, xVar);
        if (this.mLayoutState.f12661b >= iFill) {
            i11 = i11 < 0 ? -iFill : iFill;
        }
        this.mPrimaryOrientation.offsetChildren(-i11);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        g gVar = this.mLayoutState;
        gVar.f12661b = 0;
        recycle(tVar, gVar);
        return i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        return scrollBy(i11, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void scrollToPosition(int i11) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mAnchorPosition != i11) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i11, int i12) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = i12;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        return scrollBy(i11, tVar, xVar);
    }

    public void setGapStrategy(int i11) {
        assertNotInLayoutOrScroll(null);
        if (i11 == this.mGapStrategy) {
            return;
        }
        if (i11 != 0 && i11 != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.mGapStrategy = i11;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void setMeasuredDimension(Rect rect, int i11, int i12) {
        int iChooseSize;
        int iChooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView.m.chooseSize(i12, rect.height() + paddingTop, getMinimumHeight());
            iChooseSize = RecyclerView.m.chooseSize(i11, (this.mSizePerSpan * this.mSpanCount) + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.m.chooseSize(i11, rect.width() + paddingLeft, getMinimumWidth());
            iChooseSize2 = RecyclerView.m.chooseSize(i12, (this.mSizePerSpan * this.mSpanCount) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setOrientation(int i11) {
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i11 == this.mOrientation) {
            return;
        }
        this.mOrientation = i11;
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = orientationHelper;
        requestLayout();
    }

    public void setReverseLayout(boolean z11) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mReverseLayout != z11) {
            savedState.mReverseLayout = z11;
        }
        this.mReverseLayout = z11;
        requestLayout();
    }

    public void setSpanCount(int i11) {
        assertNotInLayoutOrScroll(null);
        if (i11 != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i11;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new c[this.mSpanCount];
            for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                this.mSpans[i12] = new c(i12);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i11) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i11);
        startSmoothScroll(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }

    public boolean updateAnchorFromPendingData(RecyclerView.x xVar, a aVar) {
        int i11;
        if (!xVar.e() && (i11 = this.mPendingScrollPosition) != -1) {
            if (i11 >= 0 && i11 < xVar.b()) {
                SavedState savedState = this.mPendingSavedState;
                if (savedState == null || savedState.mAnchorPosition == -1 || savedState.mSpanOffsetsSize < 1) {
                    View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (viewFindViewByPosition != null) {
                        aVar.f12603a = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
                        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                            if (aVar.f12605c) {
                                aVar.f12604b = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(viewFindViewByPosition);
                            } else {
                                aVar.f12604b = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.mPrimaryOrientation.getDecoratedMeasurement(viewFindViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                            aVar.f12604b = aVar.f12605c ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
                            return true;
                        }
                        int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(viewFindViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                        if (decoratedStart < 0) {
                            aVar.f12604b = -decoratedStart;
                            return true;
                        }
                        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(viewFindViewByPosition);
                        if (endAfterPadding < 0) {
                            aVar.f12604b = endAfterPadding;
                            return true;
                        }
                        aVar.f12604b = Integer.MIN_VALUE;
                    } else {
                        int i12 = this.mPendingScrollPosition;
                        aVar.f12603a = i12;
                        int i13 = this.mPendingScrollPositionOffset;
                        if (i13 == Integer.MIN_VALUE) {
                            aVar.f12605c = calculateScrollDirectionForPosition(i12) == 1;
                            aVar.a();
                        } else {
                            aVar.b(i13);
                        }
                        aVar.f12606d = true;
                    }
                } else {
                    aVar.f12604b = Integer.MIN_VALUE;
                    aVar.f12603a = this.mPendingScrollPosition;
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    public void updateAnchorInfoForLayout(RecyclerView.x xVar, a aVar) {
        if (updateAnchorFromPendingData(xVar, aVar) || updateAnchorFromChildren(xVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f12603a = 0;
    }

    public void updateMeasureSpecs(int i11) {
        this.mSizePerSpan = i11 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(i11, this.mSecondaryOrientation.getMode());
    }
}
