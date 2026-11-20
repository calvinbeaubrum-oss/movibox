package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FlexboxLayoutManager extends RecyclerView.m implements com.google.android.flexbox.a, RecyclerView.w.b {
    public static final Rect B = new Rect();
    public com.google.android.flexbox.c.b A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36003d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<com.google.android.flexbox.b> f36007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.android.flexbox.c f36008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView.t f36009k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView.x f36010l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f36011m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f36012n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OrientationHelper f36013o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OrientationHelper f36014p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SavedState f36015q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f36016r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f36017s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f36018t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f36019u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f36020v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SparseArray<View> f36021w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Context f36022x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f36023y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f36024z;

    /* JADX INFO: compiled from: source.java */
    public static class LayoutParams extends RecyclerView.n implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i11) {
                return new LayoutParams[i11];
            }
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(RecyclerView.n nVar) {
            super(nVar);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.n) layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        public void setAlignSelf(int i11) {
            this.mAlignSelf = i11;
        }

        public void setFlexBasisPercent(float f11) {
            this.mFlexBasisPercent = f11;
        }

        public void setFlexGrow(float f11) {
            this.mFlexGrow = f11;
        }

        public void setFlexShrink(float f11) {
            this.mFlexShrink = f11;
        }

        public void setHeight(int i11) {
            ((ViewGroup.MarginLayoutParams) this).height = i11;
        }

        public void setMaxHeight(int i11) {
            this.mMaxHeight = i11;
        }

        public void setMaxWidth(int i11) {
            this.mMaxWidth = i11;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i11) {
            this.mMinHeight = i11;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i11) {
            this.mMinWidth = i11;
        }

        public void setOrder(int i11) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        public void setWidth(int i11) {
            ((ViewGroup.MarginLayoutParams) this).width = i11;
        }

        public void setWrapBefore(boolean z11) {
            this.mWrapBefore = z11;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int mAnchorOffset;
        private int mAnchorPosition;

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
            this.mAnchorOffset = parcel.readInt();
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean g(int i11) {
            int i12 = this.mAnchorPosition;
            return i12 >= 0 && i12 < i11;
        }

        public final void h() {
            this.mAnchorPosition = -1;
        }

        @NonNull
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f36026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f36027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f36028d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f36029e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f36030f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f36031g;

        public b() {
            this.f36028d = 0;
        }

        public static /* synthetic */ int l(b bVar, int i11) {
            int i12 = bVar.f36028d + i11;
            bVar.f36028d = i12;
            return i12;
        }

        public final void r() {
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f36005g) {
                this.f36027c = this.f36029e ? FlexboxLayoutManager.this.f36013o.getEndAfterPadding() : FlexboxLayoutManager.this.f36013o.getStartAfterPadding();
            } else {
                this.f36027c = this.f36029e ? FlexboxLayoutManager.this.f36013o.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.f36013o.getStartAfterPadding();
            }
        }

        public final void s(View view) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.f36001b == 0 ? FlexboxLayoutManager.this.f36014p : FlexboxLayoutManager.this.f36013o;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f36005g) {
                if (this.f36029e) {
                    this.f36027c = orientationHelper.getDecoratedEnd(view) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.f36027c = orientationHelper.getDecoratedStart(view);
                }
            } else if (this.f36029e) {
                this.f36027c = orientationHelper.getDecoratedStart(view) + orientationHelper.getTotalSpaceChange();
            } else {
                this.f36027c = orientationHelper.getDecoratedEnd(view);
            }
            this.f36025a = FlexboxLayoutManager.this.getPosition(view);
            this.f36031g = false;
            int[] iArr = FlexboxLayoutManager.this.f36008j.f36063c;
            int i11 = this.f36025a;
            if (i11 == -1) {
                i11 = 0;
            }
            int i12 = iArr[i11];
            this.f36026b = i12 != -1 ? i12 : 0;
            if (FlexboxLayoutManager.this.f36007i.size() > this.f36026b) {
                this.f36025a = ((com.google.android.flexbox.b) FlexboxLayoutManager.this.f36007i.get(this.f36026b)).f36057o;
            }
        }

        public final void t() {
            this.f36025a = -1;
            this.f36026b = -1;
            this.f36027c = Integer.MIN_VALUE;
            this.f36030f = false;
            this.f36031g = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.f36001b == 0) {
                    this.f36029e = FlexboxLayoutManager.this.f36000a == 1;
                    return;
                } else {
                    this.f36029e = FlexboxLayoutManager.this.f36001b == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f36001b == 0) {
                this.f36029e = FlexboxLayoutManager.this.f36000a == 3;
            } else {
                this.f36029e = FlexboxLayoutManager.this.f36001b == 2;
            }
        }

        @NonNull
        public String toString() {
            return "AnchorInfo{mPosition=" + this.f36025a + ", mFlexLinePosition=" + this.f36026b + ", mCoordinate=" + this.f36027c + ", mPerpendicularCoordinate=" + this.f36028d + ", mLayoutFromEnd=" + this.f36029e + ", mValid=" + this.f36030f + ", mAssignedFromSavedState=" + this.f36031g + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f36034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f36035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f36036d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f36037e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f36038f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f36039g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f36040h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f36041i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f36042j;

        public c() {
            this.f36040h = 1;
            this.f36041i = 1;
        }

        public static /* synthetic */ int c(c cVar, int i11) {
            int i12 = cVar.f36037e + i11;
            cVar.f36037e = i12;
            return i12;
        }

        public static /* synthetic */ int d(c cVar, int i11) {
            int i12 = cVar.f36037e - i11;
            cVar.f36037e = i12;
            return i12;
        }

        public static /* synthetic */ int i(c cVar, int i11) {
            int i12 = cVar.f36033a - i11;
            cVar.f36033a = i12;
            return i12;
        }

        public static /* synthetic */ int l(c cVar) {
            int i11 = cVar.f36035c;
            cVar.f36035c = i11 + 1;
            return i11;
        }

        public static /* synthetic */ int m(c cVar) {
            int i11 = cVar.f36035c;
            cVar.f36035c = i11 - 1;
            return i11;
        }

        public static /* synthetic */ int n(c cVar, int i11) {
            int i12 = cVar.f36035c + i11;
            cVar.f36035c = i12;
            return i12;
        }

        public static /* synthetic */ int q(c cVar, int i11) {
            int i12 = cVar.f36038f + i11;
            cVar.f36038f = i12;
            return i12;
        }

        public static /* synthetic */ int u(c cVar, int i11) {
            int i12 = cVar.f36036d + i11;
            cVar.f36036d = i12;
            return i12;
        }

        public static /* synthetic */ int v(c cVar, int i11) {
            int i12 = cVar.f36036d - i11;
            cVar.f36036d = i12;
            return i12;
        }

        public final boolean D(RecyclerView.x xVar, List<com.google.android.flexbox.b> list) {
            int i11;
            int i12 = this.f36036d;
            return i12 >= 0 && i12 < xVar.b() && (i11 = this.f36035c) >= 0 && i11 < list.size();
        }

        @NonNull
        public String toString() {
            return "LayoutState{mAvailable=" + this.f36033a + ", mFlexLinePosition=" + this.f36035c + ", mPosition=" + this.f36036d + ", mOffset=" + this.f36037e + ", mScrollingOffset=" + this.f36038f + ", mLastScrollDelta=" + this.f36039g + ", mItemDirection=" + this.f36040h + ", mLayoutDirection=" + this.f36041i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public FlexboxLayoutManager(Context context, int i11, int i12) {
        this.f36004f = -1;
        this.f36007i = new ArrayList();
        this.f36008j = new com.google.android.flexbox.c(this);
        this.f36012n = new b();
        this.f36016r = -1;
        this.f36017s = Integer.MIN_VALUE;
        this.f36018t = Integer.MIN_VALUE;
        this.f36019u = Integer.MIN_VALUE;
        this.f36021w = new SparseArray<>();
        this.f36024z = -1;
        this.A = new com.google.android.flexbox.c.b();
        P(i11);
        Q(i12);
        O(4);
        this.f36022x = context;
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.f36004f = -1;
        this.f36007i = new ArrayList();
        this.f36008j = new com.google.android.flexbox.c(this);
        this.f36012n = new b();
        this.f36016r = -1;
        this.f36017s = Integer.MIN_VALUE;
        this.f36018t = Integer.MIN_VALUE;
        this.f36019u = Integer.MIN_VALUE;
        this.f36021w = new SparseArray<>();
        this.f36024z = -1;
        this.A = new com.google.android.flexbox.c.b();
        RecyclerView.m.d properties = RecyclerView.m.getProperties(context, attributeSet, i11, i12);
        int i13 = properties.f12545a;
        if (i13 != 0) {
            if (i13 == 1) {
                if (properties.f12547c) {
                    P(3);
                } else {
                    P(2);
                }
            }
        } else if (properties.f12547c) {
            P(1);
        } else {
            P(0);
        }
        Q(1);
        O(4);
        this.f36022x = context;
    }

    private void ensureLayoutState() {
        if (this.f36011m == null) {
            this.f36011m = new c();
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    public static boolean isMeasurementUpToDate(int i11, int i12, int i13) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        if (i13 > 0 && i11 != i13) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i11;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i11;
        }
        return true;
    }

    private boolean shouldMeasureChild(View view, int i11, int i12, RecyclerView.n nVar) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i11, ((ViewGroup.MarginLayoutParams) nVar).width) && isMeasurementUpToDate(view.getHeight(), i12, ((ViewGroup.MarginLayoutParams) nVar).height)) ? false : true;
    }

    @NonNull
    public List<com.google.android.flexbox.b> A() {
        ArrayList arrayList = new ArrayList(this.f36007i.size());
        int size = this.f36007i.size();
        for (int i11 = 0; i11 < size; i11++) {
            com.google.android.flexbox.b bVar = this.f36007i.get(i11);
            if (bVar.b() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public int B(int i11) {
        return this.f36008j.f36063c[i11];
    }

    public final int C(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        o();
        int i12 = 1;
        this.f36011m.f36042j = true;
        boolean z11 = !isMainAxisDirectionHorizontal() && this.f36005g;
        if (!z11 ? i11 <= 0 : i11 >= 0) {
            i12 = -1;
        }
        int iAbs = Math.abs(i11);
        X(i12, iAbs);
        int iP = this.f36011m.f36038f + p(tVar, xVar, this.f36011m);
        if (iP < 0) {
            return 0;
        }
        if (z11) {
            if (iAbs > iP) {
                i11 = (-i12) * iP;
            }
        } else if (iAbs > iP) {
            i11 = i12 * iP;
        }
        this.f36013o.offsetChildren(-i11);
        this.f36011m.f36039g = i11;
        return i11;
    }

    public final int D(int i11) {
        int iMin;
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        o();
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.f36023y;
        int width = zIsMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = zIsMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i11);
            if (i11 < 0) {
                iMin = Math.min((width2 + this.f36012n.f36028d) - width, iAbs);
            } else {
                if (this.f36012n.f36028d + i11 <= 0) {
                    return i11;
                }
                iMin = this.f36012n.f36028d;
            }
        } else {
            if (i11 > 0) {
                return Math.min((width2 - this.f36012n.f36028d) - width, i11);
            }
            if (this.f36012n.f36028d + i11 >= 0) {
                return i11;
            }
            iMin = this.f36012n.f36028d;
        }
        return -iMin;
    }

    public boolean E() {
        return this.f36005g;
    }

    public final boolean F(View view, boolean z11) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int iX = x(view);
        int iZ = z(view);
        int iY = y(view);
        int iW = w(view);
        boolean z12 = paddingLeft <= iX && width >= iY;
        boolean z13 = iX >= width || iY >= paddingLeft;
        boolean z14 = paddingTop <= iZ && height >= iW;
        boolean z15 = iZ >= height || iW >= paddingTop;
        if (z11) {
            return z12 && z14;
        }
        return z13 && z15;
    }

    public final int G(com.google.android.flexbox.b bVar, c cVar) {
        return isMainAxisDirectionHorizontal() ? H(bVar, cVar) : I(bVar, cVar);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:45:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:50:0x0110  */
    /* JADX WARN: Code duplicated, block: B:53:0x0131  */
    /* JADX WARN: Code duplicated, block: B:54:0x0151  */
    /* JADX WARN: Code duplicated, block: B:61:0x0194 A[SYNTHETIC] */
    public final int H(com.google.android.flexbox.b bVar, c cVar) {
        float f11;
        float f12;
        float f13;
        float measuredWidth;
        float measuredWidth2;
        float fMax;
        int iB;
        int i11;
        int i12;
        View flexItemAt;
        int iY;
        int iX;
        LayoutParams layoutParams;
        float leftDecorationWidth;
        float rightDecorationWidth;
        int topDecorationHeight;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i13 = cVar.f36037e;
        if (cVar.f36041i == -1) {
            i13 -= bVar.f36049g;
        }
        int i14 = i13;
        int i15 = cVar.f36036d;
        int i16 = this.f36002c;
        int i17 = 1;
        if (i16 != 0) {
            if (i16 == 1) {
                int i18 = bVar.f36047e;
                float f14 = (width - i18) + paddingRight;
                f13 = 0.0f;
                f12 = i18 - paddingLeft;
                f11 = f14;
            } else if (i16 == 2) {
                int i19 = bVar.f36047e;
                f11 = paddingLeft + ((width - i19) / 2.0f);
                f12 = (width - paddingRight) - ((width - i19) / 2.0f);
            } else if (i16 == 3) {
                f11 = paddingLeft;
                int i21 = bVar.f36050h;
                f13 = (width - bVar.f36047e) / (i21 != 1 ? i21 - 1 : 1.0f);
                f12 = width - paddingRight;
            } else if (i16 == 4) {
                int i22 = bVar.f36050h;
                f13 = i22 != 0 ? (width - bVar.f36047e) / i22 : 0.0f;
                float f15 = f13 / 2.0f;
                f11 = paddingLeft + f15;
                f12 = (width - paddingRight) - f15;
            } else {
                if (i16 != 5) {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.f36002c);
                }
                int i23 = bVar.f36050h;
                f13 = i23 != 0 ? (width - bVar.f36047e) / (i23 + 1) : 0.0f;
                f11 = paddingLeft + f13;
                f12 = (width - paddingRight) - f13;
            }
            measuredWidth = f11 - this.f36012n.f36028d;
            measuredWidth2 = f12 - this.f36012n.f36028d;
            fMax = Math.max(f13, 0.0f);
            iB = bVar.b();
            i11 = 0;
            i12 = i15;
            while (i12 < i15 + iB) {
                flexItemAt = getFlexItemAt(i12);
                if (flexItemAt != null) {
                    if (cVar.f36041i == i17) {
                        calculateItemDecorationsForChild(flexItemAt, B);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, B);
                        addView(flexItemAt, i11);
                        i11++;
                    }
                    int i24 = i11;
                    com.google.android.flexbox.c cVar2 = this.f36008j;
                    long j11 = cVar2.f36064d[i12];
                    iY = cVar2.y(j11);
                    iX = this.f36008j.x(j11);
                    layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, iY, iX, layoutParams)) {
                        flexItemAt.measure(iY, iX);
                    }
                    leftDecorationWidth = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + getLeftDecorationWidth(flexItemAt);
                    rightDecorationWidth = measuredWidth2 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt));
                    topDecorationHeight = i14 + getTopDecorationHeight(flexItemAt);
                    if (this.f36005g) {
                        this.f36008j.Q(flexItemAt, bVar, Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    } else {
                        this.f36008j.Q(flexItemAt, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + flexItemAt.getMeasuredWidth(), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    }
                    i11 = i24;
                    measuredWidth = leftDecorationWidth + flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt) + fMax;
                    measuredWidth2 = rightDecorationWidth - (((flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(flexItemAt)) + fMax);
                }
                i12++;
                i17 = 1;
            }
            c.n(cVar, this.f36011m.f36041i);
            return bVar.a();
        }
        f11 = paddingLeft;
        f12 = width - paddingRight;
        f13 = 0.0f;
        measuredWidth = f11 - this.f36012n.f36028d;
        measuredWidth2 = f12 - this.f36012n.f36028d;
        fMax = Math.max(f13, 0.0f);
        iB = bVar.b();
        i11 = 0;
        i12 = i15;
        while (i12 < i15 + iB) {
            flexItemAt = getFlexItemAt(i12);
            if (flexItemAt != null) {
                if (cVar.f36041i == i17) {
                    calculateItemDecorationsForChild(flexItemAt, B);
                    addView(flexItemAt);
                } else {
                    calculateItemDecorationsForChild(flexItemAt, B);
                    addView(flexItemAt, i11);
                    i11++;
                }
                int i25 = i11;
                com.google.android.flexbox.c cVar3 = this.f36008j;
                long j12 = cVar3.f36064d[i12];
                iY = cVar3.y(j12);
                iX = this.f36008j.x(j12);
                layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                if (shouldMeasureChild(flexItemAt, iY, iX, layoutParams)) {
                    flexItemAt.measure(iY, iX);
                }
                leftDecorationWidth = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + getLeftDecorationWidth(flexItemAt);
                rightDecorationWidth = measuredWidth2 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt));
                topDecorationHeight = i14 + getTopDecorationHeight(flexItemAt);
                if (this.f36005g) {
                    this.f36008j.Q(flexItemAt, bVar, Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                } else {
                    this.f36008j.Q(flexItemAt, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + flexItemAt.getMeasuredWidth(), topDecorationHeight + flexItemAt.getMeasuredHeight());
                }
                i11 = i25;
                measuredWidth = leftDecorationWidth + flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt) + fMax;
                measuredWidth2 = rightDecorationWidth - (((flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(flexItemAt)) + fMax);
            }
            i12++;
            i17 = 1;
        }
        c.n(cVar, this.f36011m.f36041i);
        return bVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00db  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:45:0x0102  */
    /* JADX WARN: Code duplicated, block: B:48:0x0120  */
    /* JADX WARN: Code duplicated, block: B:50:0x012b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0146  */
    /* JADX WARN: Code duplicated, block: B:55:0x014a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0173  */
    /* JADX WARN: Code duplicated, block: B:57:0x0199  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x01c1  */
    public final int I(com.google.android.flexbox.b bVar, c cVar) {
        float f11;
        float f12;
        float f13;
        float measuredHeight;
        float measuredHeight2;
        float fMax;
        int iB;
        int i11;
        int i12;
        View flexItemAt;
        float f14;
        int iY;
        int iX;
        LayoutParams layoutParams;
        float topDecorationHeight;
        float bottomDecorationHeight;
        int leftDecorationWidth;
        int rightDecorationWidth;
        boolean z11;
        View view;
        int i13;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i14 = cVar.f36037e;
        int i15 = cVar.f36037e;
        if (cVar.f36041i == -1) {
            int i16 = bVar.f36049g;
            i14 -= i16;
            i15 += i16;
        }
        int i17 = i14;
        int i18 = i15;
        int i19 = cVar.f36036d;
        int i21 = this.f36002c;
        if (i21 != 0) {
            if (i21 == 1) {
                int i22 = bVar.f36047e;
                float f15 = (height - i22) + paddingBottom;
                f13 = 0.0f;
                f12 = i22 - paddingTop;
                f11 = f15;
            } else if (i21 == 2) {
                int i23 = bVar.f36047e;
                f11 = paddingTop + ((height - i23) / 2.0f);
                f12 = (height - paddingBottom) - ((height - i23) / 2.0f);
            } else if (i21 == 3) {
                f11 = paddingTop;
                int i24 = bVar.f36050h;
                f13 = (height - bVar.f36047e) / (i24 != 1 ? i24 - 1 : 1.0f);
                f12 = height - paddingBottom;
            } else if (i21 == 4) {
                int i25 = bVar.f36050h;
                f13 = i25 != 0 ? (height - bVar.f36047e) / i25 : 0.0f;
                float f16 = f13 / 2.0f;
                f11 = paddingTop + f16;
                f12 = (height - paddingBottom) - f16;
            } else {
                if (i21 != 5) {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.f36002c);
                }
                int i26 = bVar.f36050h;
                f13 = i26 != 0 ? (height - bVar.f36047e) / (i26 + 1) : 0.0f;
                f11 = paddingTop + f13;
                f12 = (height - paddingBottom) - f13;
            }
            measuredHeight = f11 - this.f36012n.f36028d;
            measuredHeight2 = f12 - this.f36012n.f36028d;
            fMax = Math.max(f13, 0.0f);
            iB = bVar.b();
            i11 = 0;
            i12 = i19;
            while (i12 < i19 + iB) {
                flexItemAt = getFlexItemAt(i12);
                if (flexItemAt == null) {
                    i13 = i12;
                    f14 = fMax;
                } else {
                    com.google.android.flexbox.c cVar2 = this.f36008j;
                    f14 = fMax;
                    long j11 = cVar2.f36064d[i12];
                    iY = cVar2.y(j11);
                    iX = this.f36008j.x(j11);
                    layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, iY, iX, layoutParams)) {
                        flexItemAt.measure(iY, iX);
                    }
                    topDecorationHeight = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getTopDecorationHeight(flexItemAt);
                    bottomDecorationHeight = measuredHeight2 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getBottomDecorationHeight(flexItemAt));
                    if (cVar.f36041i == 1) {
                        calculateItemDecorationsForChild(flexItemAt, B);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, B);
                        addView(flexItemAt, i11);
                        i11++;
                    }
                    int i27 = i11;
                    leftDecorationWidth = i17 + getLeftDecorationWidth(flexItemAt);
                    rightDecorationWidth = i18 - getRightDecorationWidth(flexItemAt);
                    z11 = this.f36005g;
                    if (z11) {
                        view = flexItemAt;
                        i13 = i12;
                        if (this.f36006h) {
                            this.f36008j.R(view, bVar, z11, leftDecorationWidth, Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                        } else {
                            this.f36008j.R(view, bVar, z11, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), Math.round(topDecorationHeight) + view.getMeasuredHeight());
                        }
                    } else if (this.f36006h) {
                        view = flexItemAt;
                        i13 = i12;
                        this.f36008j.R(flexItemAt, bVar, z11, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                    } else {
                        view = flexItemAt;
                        i13 = i12;
                        this.f36008j.R(view, bVar, z11, rightDecorationWidth - view.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Math.round(topDecorationHeight) + view.getMeasuredHeight());
                    }
                    View view2 = view;
                    measuredHeight = topDecorationHeight + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getBottomDecorationHeight(view2) + f14;
                    i11 = i27;
                    measuredHeight2 = bottomDecorationHeight - (((view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getTopDecorationHeight(view2)) + f14);
                }
                i12 = i13 + 1;
                fMax = f14;
            }
            c.n(cVar, this.f36011m.f36041i);
            return bVar.a();
        }
        f11 = paddingTop;
        f12 = height - paddingBottom;
        f13 = 0.0f;
        measuredHeight = f11 - this.f36012n.f36028d;
        measuredHeight2 = f12 - this.f36012n.f36028d;
        fMax = Math.max(f13, 0.0f);
        iB = bVar.b();
        i11 = 0;
        i12 = i19;
        while (i12 < i19 + iB) {
            flexItemAt = getFlexItemAt(i12);
            if (flexItemAt == null) {
                i13 = i12;
                f14 = fMax;
            } else {
                com.google.android.flexbox.c cVar3 = this.f36008j;
                f14 = fMax;
                long j12 = cVar3.f36064d[i12];
                iY = cVar3.y(j12);
                iX = this.f36008j.x(j12);
                layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                if (shouldMeasureChild(flexItemAt, iY, iX, layoutParams)) {
                    flexItemAt.measure(iY, iX);
                }
                topDecorationHeight = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getTopDecorationHeight(flexItemAt);
                bottomDecorationHeight = measuredHeight2 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getBottomDecorationHeight(flexItemAt));
                if (cVar.f36041i == 1) {
                    calculateItemDecorationsForChild(flexItemAt, B);
                    addView(flexItemAt);
                } else {
                    calculateItemDecorationsForChild(flexItemAt, B);
                    addView(flexItemAt, i11);
                    i11++;
                }
                int i28 = i11;
                leftDecorationWidth = i17 + getLeftDecorationWidth(flexItemAt);
                rightDecorationWidth = i18 - getRightDecorationWidth(flexItemAt);
                z11 = this.f36005g;
                if (z11) {
                    view = flexItemAt;
                    i13 = i12;
                    if (this.f36006h) {
                        this.f36008j.R(view, bVar, z11, leftDecorationWidth, Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.f36008j.R(view, bVar, z11, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), Math.round(topDecorationHeight) + view.getMeasuredHeight());
                    }
                } else if (this.f36006h) {
                    view = flexItemAt;
                    i13 = i12;
                    this.f36008j.R(flexItemAt, bVar, z11, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                } else {
                    view = flexItemAt;
                    i13 = i12;
                    this.f36008j.R(view, bVar, z11, rightDecorationWidth - view.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Math.round(topDecorationHeight) + view.getMeasuredHeight());
                }
                View view3 = view;
                measuredHeight = topDecorationHeight + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getBottomDecorationHeight(view3) + f14;
                i11 = i28;
                measuredHeight2 = bottomDecorationHeight - (((view3.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getTopDecorationHeight(view3)) + f14);
            }
            i12 = i13 + 1;
            fMax = f14;
        }
        c.n(cVar, this.f36011m.f36041i);
        return bVar.a();
    }

    public final void J(RecyclerView.t tVar, c cVar) {
        if (cVar.f36042j) {
            if (cVar.f36041i == -1) {
                K(tVar, cVar);
            } else {
                L(tVar, cVar);
            }
        }
    }

    public final void K(RecyclerView.t tVar, c cVar) {
        int childCount;
        int i11;
        View childAt;
        int i12;
        if (cVar.f36038f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt((i11 = childCount - 1))) == null || (i12 = this.f36008j.f36063c[getPosition(childAt)]) == -1) {
            return;
        }
        com.google.android.flexbox.b bVar = this.f36007i.get(i12);
        for (int i13 = i11; i13 >= 0; i13--) {
            View childAt2 = getChildAt(i13);
            if (childAt2 != null) {
                if (!l(childAt2, cVar.f36038f)) {
                    break;
                }
                if (bVar.f36057o != getPosition(childAt2)) {
                    continue;
                } else if (i12 <= 0) {
                    childCount = i13;
                    break;
                } else {
                    i12 += cVar.f36041i;
                    bVar = this.f36007i.get(i12);
                    childCount = i13;
                }
            }
        }
        recycleChildren(tVar, childCount, i11);
    }

    public final void L(RecyclerView.t tVar, c cVar) {
        int childCount;
        View childAt;
        if (cVar.f36038f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i11 = this.f36008j.f36063c[getPosition(childAt)];
        int i12 = -1;
        if (i11 == -1) {
            return;
        }
        com.google.android.flexbox.b bVar = this.f36007i.get(i11);
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2 != null) {
                if (!m(childAt2, cVar.f36038f)) {
                    break;
                }
                if (bVar.f36058p != getPosition(childAt2)) {
                    continue;
                } else if (i11 >= this.f36007i.size() - 1) {
                    i12 = i13;
                    break;
                } else {
                    i11 += cVar.f36041i;
                    bVar = this.f36007i.get(i11);
                    i12 = i13;
                }
            }
        }
        recycleChildren(tVar, 0, i12);
    }

    public final void M() {
        int heightMode = isMainAxisDirectionHorizontal() ? getHeightMode() : getWidthMode();
        this.f36011m.f36034b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    public final void N() {
        int layoutDirection = getLayoutDirection();
        int i11 = this.f36000a;
        if (i11 == 0) {
            this.f36005g = layoutDirection == 1;
            this.f36006h = this.f36001b == 2;
            return;
        }
        if (i11 == 1) {
            this.f36005g = layoutDirection != 1;
            this.f36006h = this.f36001b == 2;
            return;
        }
        if (i11 == 2) {
            boolean z11 = layoutDirection == 1;
            this.f36005g = z11;
            if (this.f36001b == 2) {
                this.f36005g = !z11;
            }
            this.f36006h = false;
            return;
        }
        if (i11 != 3) {
            this.f36005g = false;
            this.f36006h = false;
            return;
        }
        boolean z12 = layoutDirection == 1;
        this.f36005g = z12;
        if (this.f36001b == 2) {
            this.f36005g = !z12;
        }
        this.f36006h = true;
    }

    public void O(int i11) {
        int i12 = this.f36003d;
        if (i12 != i11) {
            if (i12 == 4 || i11 == 4) {
                removeAllViews();
                n();
            }
            this.f36003d = i11;
            requestLayout();
        }
    }

    public void P(int i11) {
        if (this.f36000a != i11) {
            removeAllViews();
            this.f36000a = i11;
            this.f36013o = null;
            this.f36014p = null;
            n();
            requestLayout();
        }
    }

    public void Q(int i11) {
        if (i11 == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i12 = this.f36001b;
        if (i12 != i11) {
            if (i12 == 0 || i11 == 0) {
                removeAllViews();
                n();
            }
            this.f36001b = i11;
            this.f36013o = null;
            this.f36014p = null;
            requestLayout();
        }
    }

    public void R(int i11) {
        if (this.f36002c != i11) {
            this.f36002c = i11;
            requestLayout();
        }
    }

    public final boolean S(RecyclerView.x xVar, b bVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View viewS = bVar.f36029e ? s(xVar.b()) : q(xVar.b());
        if (viewS == null) {
            return false;
        }
        bVar.s(viewS);
        if (xVar.e() || !supportsPredictiveItemAnimations()) {
            return true;
        }
        if (this.f36013o.getDecoratedStart(viewS) < this.f36013o.getEndAfterPadding() && this.f36013o.getDecoratedEnd(viewS) >= this.f36013o.getStartAfterPadding()) {
            return true;
        }
        bVar.f36027c = bVar.f36029e ? this.f36013o.getEndAfterPadding() : this.f36013o.getStartAfterPadding();
        return true;
    }

    public final boolean T(RecyclerView.x xVar, b bVar, SavedState savedState) {
        int i11;
        View childAt;
        if (!xVar.e() && (i11 = this.f36016r) != -1) {
            if (i11 >= 0 && i11 < xVar.b()) {
                bVar.f36025a = this.f36016r;
                bVar.f36026b = this.f36008j.f36063c[bVar.f36025a];
                SavedState savedState2 = this.f36015q;
                if (savedState2 != null && savedState2.g(xVar.b())) {
                    bVar.f36027c = this.f36013o.getStartAfterPadding() + savedState.mAnchorOffset;
                    bVar.f36031g = true;
                    bVar.f36026b = -1;
                    return true;
                }
                if (this.f36017s != Integer.MIN_VALUE) {
                    if (isMainAxisDirectionHorizontal() || !this.f36005g) {
                        bVar.f36027c = this.f36013o.getStartAfterPadding() + this.f36017s;
                    } else {
                        bVar.f36027c = this.f36017s - this.f36013o.getEndPadding();
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.f36016r);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                        bVar.f36029e = this.f36016r < getPosition(childAt);
                    }
                    bVar.r();
                } else {
                    if (this.f36013o.getDecoratedMeasurement(viewFindViewByPosition) > this.f36013o.getTotalSpace()) {
                        bVar.r();
                        return true;
                    }
                    if (this.f36013o.getDecoratedStart(viewFindViewByPosition) - this.f36013o.getStartAfterPadding() < 0) {
                        bVar.f36027c = this.f36013o.getStartAfterPadding();
                        bVar.f36029e = false;
                        return true;
                    }
                    if (this.f36013o.getEndAfterPadding() - this.f36013o.getDecoratedEnd(viewFindViewByPosition) < 0) {
                        bVar.f36027c = this.f36013o.getEndAfterPadding();
                        bVar.f36029e = true;
                        return true;
                    }
                    bVar.f36027c = bVar.f36029e ? this.f36013o.getDecoratedEnd(viewFindViewByPosition) + this.f36013o.getTotalSpaceChange() : this.f36013o.getDecoratedStart(viewFindViewByPosition);
                }
                return true;
            }
            this.f36016r = -1;
            this.f36017s = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void U(RecyclerView.x xVar, b bVar) {
        if (T(xVar, bVar, this.f36015q) || S(xVar, bVar)) {
            return;
        }
        bVar.r();
        bVar.f36025a = 0;
        bVar.f36026b = 0;
    }

    public final void V(int i11) {
        if (i11 >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.f36008j.t(childCount);
        this.f36008j.u(childCount);
        this.f36008j.s(childCount);
        if (i11 >= this.f36008j.f36063c.length) {
            return;
        }
        this.f36024z = i11;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.f36016r = getPosition(childClosestToStart);
        if (isMainAxisDirectionHorizontal() || !this.f36005g) {
            this.f36017s = this.f36013o.getDecoratedStart(childClosestToStart) - this.f36013o.getStartAfterPadding();
        } else {
            this.f36017s = this.f36013o.getDecoratedEnd(childClosestToStart) + this.f36013o.getEndPadding();
        }
    }

    public final void W(int i11) {
        int i12;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z11 = false;
        if (isMainAxisDirectionHorizontal()) {
            int i13 = this.f36018t;
            if (i13 != Integer.MIN_VALUE && i13 != width) {
                z11 = true;
            }
            i12 = this.f36011m.f36034b ? this.f36022x.getResources().getDisplayMetrics().heightPixels : this.f36011m.f36033a;
        } else {
            int i14 = this.f36019u;
            if (i14 != Integer.MIN_VALUE && i14 != height) {
                z11 = true;
            }
            i12 = this.f36011m.f36034b ? this.f36022x.getResources().getDisplayMetrics().widthPixels : this.f36011m.f36033a;
        }
        int i15 = i12;
        this.f36018t = width;
        this.f36019u = height;
        int i16 = this.f36024z;
        if (i16 == -1 && (this.f36016r != -1 || z11)) {
            if (this.f36012n.f36029e) {
                return;
            }
            this.f36007i.clear();
            this.A.a();
            if (isMainAxisDirectionHorizontal()) {
                this.f36008j.e(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i15, this.f36012n.f36025a, this.f36007i);
            } else {
                this.f36008j.h(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i15, this.f36012n.f36025a, this.f36007i);
            }
            this.f36007i = this.A.f36066a;
            this.f36008j.p(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.f36008j.X();
            b bVar = this.f36012n;
            bVar.f36026b = this.f36008j.f36063c[bVar.f36025a];
            this.f36011m.f36035c = this.f36012n.f36026b;
            return;
        }
        int iMin = i16 != -1 ? Math.min(i16, this.f36012n.f36025a) : this.f36012n.f36025a;
        this.A.a();
        if (isMainAxisDirectionHorizontal()) {
            if (this.f36007i.size() > 0) {
                this.f36008j.j(this.f36007i, iMin);
                this.f36008j.b(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i15, iMin, this.f36012n.f36025a, this.f36007i);
            } else {
                this.f36008j.s(i11);
                this.f36008j.d(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i15, 0, this.f36007i);
            }
        } else if (this.f36007i.size() > 0) {
            this.f36008j.j(this.f36007i, iMin);
            this.f36008j.b(this.A, iMakeMeasureSpec2, iMakeMeasureSpec, i15, iMin, this.f36012n.f36025a, this.f36007i);
        } else {
            this.f36008j.s(i11);
            this.f36008j.g(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i15, 0, this.f36007i);
        }
        this.f36007i = this.A.f36066a;
        this.f36008j.q(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
        this.f36008j.Y(iMin);
    }

    public final void X(int i11, int i12) {
        this.f36011m.f36041i = i11;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z11 = !zIsMainAxisDirectionHorizontal && this.f36005g;
        if (i11 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.f36011m.f36037e = this.f36013o.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewT = t(childAt, this.f36007i.get(this.f36008j.f36063c[position]));
            this.f36011m.f36040h = 1;
            c cVar = this.f36011m;
            cVar.f36036d = position + cVar.f36040h;
            if (this.f36008j.f36063c.length <= this.f36011m.f36036d) {
                this.f36011m.f36035c = -1;
            } else {
                c cVar2 = this.f36011m;
                cVar2.f36035c = this.f36008j.f36063c[cVar2.f36036d];
            }
            if (z11) {
                this.f36011m.f36037e = this.f36013o.getDecoratedStart(viewT);
                this.f36011m.f36038f = (-this.f36013o.getDecoratedStart(viewT)) + this.f36013o.getStartAfterPadding();
                c cVar3 = this.f36011m;
                cVar3.f36038f = Math.max(cVar3.f36038f, 0);
            } else {
                this.f36011m.f36037e = this.f36013o.getDecoratedEnd(viewT);
                this.f36011m.f36038f = this.f36013o.getDecoratedEnd(viewT) - this.f36013o.getEndAfterPadding();
            }
            if ((this.f36011m.f36035c == -1 || this.f36011m.f36035c > this.f36007i.size() - 1) && this.f36011m.f36036d <= getFlexItemCount()) {
                int i13 = i12 - this.f36011m.f36038f;
                this.A.a();
                if (i13 > 0) {
                    if (zIsMainAxisDirectionHorizontal) {
                        this.f36008j.d(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i13, this.f36011m.f36036d, this.f36007i);
                    } else {
                        this.f36008j.g(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i13, this.f36011m.f36036d, this.f36007i);
                    }
                    this.f36008j.q(iMakeMeasureSpec, iMakeMeasureSpec2, this.f36011m.f36036d);
                    this.f36008j.Y(this.f36011m.f36036d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.f36011m.f36037e = this.f36013o.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewR = r(childAt2, this.f36007i.get(this.f36008j.f36063c[position2]));
            this.f36011m.f36040h = 1;
            int i14 = this.f36008j.f36063c[position2];
            if (i14 == -1) {
                i14 = 0;
            }
            if (i14 > 0) {
                this.f36011m.f36036d = position2 - this.f36007i.get(i14 - 1).b();
            } else {
                this.f36011m.f36036d = -1;
            }
            this.f36011m.f36035c = i14 > 0 ? i14 - 1 : 0;
            if (z11) {
                this.f36011m.f36037e = this.f36013o.getDecoratedEnd(viewR);
                this.f36011m.f36038f = this.f36013o.getDecoratedEnd(viewR) - this.f36013o.getEndAfterPadding();
                c cVar4 = this.f36011m;
                cVar4.f36038f = Math.max(cVar4.f36038f, 0);
            } else {
                this.f36011m.f36037e = this.f36013o.getDecoratedStart(viewR);
                this.f36011m.f36038f = (-this.f36013o.getDecoratedStart(viewR)) + this.f36013o.getStartAfterPadding();
            }
        }
        c cVar5 = this.f36011m;
        cVar5.f36033a = i12 - cVar5.f36038f;
    }

    public final void Y(b bVar, boolean z11, boolean z12) {
        if (z12) {
            M();
        } else {
            this.f36011m.f36034b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f36005g) {
            this.f36011m.f36033a = this.f36013o.getEndAfterPadding() - bVar.f36027c;
        } else {
            this.f36011m.f36033a = bVar.f36027c - getPaddingRight();
        }
        this.f36011m.f36036d = bVar.f36025a;
        this.f36011m.f36040h = 1;
        this.f36011m.f36041i = 1;
        this.f36011m.f36037e = bVar.f36027c;
        this.f36011m.f36038f = Integer.MIN_VALUE;
        this.f36011m.f36035c = bVar.f36026b;
        if (!z11 || this.f36007i.size() <= 1 || bVar.f36026b < 0 || bVar.f36026b >= this.f36007i.size() - 1) {
            return;
        }
        com.google.android.flexbox.b bVar2 = this.f36007i.get(bVar.f36026b);
        c.l(this.f36011m);
        c.u(this.f36011m, bVar2.b());
    }

    public final void Z(b bVar, boolean z11, boolean z12) {
        if (z12) {
            M();
        } else {
            this.f36011m.f36034b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f36005g) {
            this.f36011m.f36033a = bVar.f36027c - this.f36013o.getStartAfterPadding();
        } else {
            this.f36011m.f36033a = (this.f36023y.getWidth() - bVar.f36027c) - this.f36013o.getStartAfterPadding();
        }
        this.f36011m.f36036d = bVar.f36025a;
        this.f36011m.f36040h = 1;
        this.f36011m.f36041i = -1;
        this.f36011m.f36037e = bVar.f36027c;
        this.f36011m.f36038f = Integer.MIN_VALUE;
        this.f36011m.f36035c = bVar.f36026b;
        if (!z11 || bVar.f36026b <= 0 || this.f36007i.size() <= bVar.f36026b) {
            return;
        }
        com.google.android.flexbox.b bVar2 = this.f36007i.get(bVar.f36026b);
        c.m(this.f36011m);
        c.v(this.f36011m, bVar2.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollHorizontally() {
        if (this.f36001b == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.f36023y;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollVertically() {
        if (this.f36001b == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.f36023y;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean checkLayoutParams(RecyclerView.n nVar) {
        return nVar instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.x xVar) {
        return computeScrollExtent(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.x xVar) {
        return computeScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollRange(@NonNull RecyclerView.x xVar) {
        return computeScrollRange(xVar);
    }

    public final int computeScrollExtent(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int iB = xVar.b();
        o();
        View viewQ = q(iB);
        View viewS = s(iB);
        if (xVar.b() == 0 || viewQ == null || viewS == null) {
            return 0;
        }
        return Math.min(this.f36013o.getTotalSpace(), this.f36013o.getDecoratedEnd(viewS) - this.f36013o.getDecoratedStart(viewQ));
    }

    public final int computeScrollOffset(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int iB = xVar.b();
        View viewQ = q(iB);
        View viewS = s(iB);
        if (xVar.b() != 0 && viewQ != null && viewS != null) {
            int position = getPosition(viewQ);
            int position2 = getPosition(viewS);
            int iAbs = Math.abs(this.f36013o.getDecoratedEnd(viewS) - this.f36013o.getDecoratedStart(viewQ));
            int[] iArr = this.f36008j.f36063c;
            int i11 = iArr[position];
            if (i11 != 0 && i11 != -1) {
                return Math.round((i11 * (iAbs / ((iArr[position2] - i11) + 1))) + (this.f36013o.getStartAfterPadding() - this.f36013o.getDecoratedStart(viewQ)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int iB = xVar.b();
        View viewQ = q(iB);
        View viewS = s(iB);
        if (xVar.b() == 0 || viewQ == null || viewS == null) {
            return 0;
        }
        return (int) ((Math.abs(this.f36013o.getDecoratedEnd(viewS) - this.f36013o.getDecoratedStart(viewQ)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition()) + 1)) * xVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w.b
    public PointF computeScrollVectorForPosition(int i11) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i12 = i11 < getPosition(childAt) ? -1 : 1;
        return isMainAxisDirectionHorizontal() ? new PointF(0.0f, i12) : new PointF(i12, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollExtent(@NonNull RecyclerView.x xVar) {
        return computeScrollExtent(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollOffset(@NonNull RecyclerView.x xVar) {
        return computeScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollRange(@NonNull RecyclerView.x xVar) {
        return computeScrollRange(xVar);
    }

    public int findFirstVisibleItemPosition() {
        View viewU = u(0, getChildCount(), false);
        if (viewU == null) {
            return -1;
        }
        return getPosition(viewU);
    }

    public int findLastVisibleItemPosition() {
        View viewU = u(getChildCount() - 1, -1, false);
        if (viewU == null) {
            return -1;
        }
        return getPosition(viewU);
    }

    public final int fixLayoutEndGap(int i11, RecyclerView.t tVar, RecyclerView.x xVar, boolean z11) {
        int iC;
        int endAfterPadding;
        if (isMainAxisDirectionHorizontal() || !this.f36005g) {
            int endAfterPadding2 = this.f36013o.getEndAfterPadding() - i11;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iC = -C(-endAfterPadding2, tVar, xVar);
        } else {
            int startAfterPadding = i11 - this.f36013o.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iC = C(startAfterPadding, tVar, xVar);
        }
        int i12 = i11 + iC;
        if (!z11 || (endAfterPadding = this.f36013o.getEndAfterPadding() - i12) <= 0) {
            return iC;
        }
        this.f36013o.offsetChildren(endAfterPadding);
        return endAfterPadding + iC;
    }

    public final int fixLayoutStartGap(int i11, RecyclerView.t tVar, RecyclerView.x xVar, boolean z11) {
        int iC;
        int startAfterPadding;
        if (isMainAxisDirectionHorizontal() || !this.f36005g) {
            int startAfterPadding2 = i11 - this.f36013o.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iC = -C(startAfterPadding2, tVar, xVar);
        } else {
            int endAfterPadding = this.f36013o.getEndAfterPadding() - i11;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iC = C(-endAfterPadding, tVar, xVar);
        }
        int i12 = i11 + iC;
        if (!z11 || (startAfterPadding = i12 - this.f36013o.getStartAfterPadding()) <= 0) {
            return iC;
        }
        this.f36013o.offsetChildren(-startAfterPadding);
        return iC - startAfterPadding;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f36003d;
    }

    @Override // com.google.android.flexbox.a
    public int getChildHeightMeasureSpec(int i11, int i12, int i13) {
        return RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), i12, i13, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getChildWidthMeasureSpec(int i11, int i12, int i13) {
        return RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), i12, i13, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthMainAxis(View view, int i11, int i12) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f36000a;
    }

    @Override // com.google.android.flexbox.a
    public View getFlexItemAt(int i11) {
        View view = this.f36021w.get(i11);
        return view != null ? view : this.f36009k.o(i11);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.f36010l.b();
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.f36007i;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.f36001b;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.f36007i.size() == 0) {
            return 0;
        }
        int size = this.f36007i.size();
        int iMax = Integer.MIN_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            iMax = Math.max(iMax, this.f36007i.get(i11).f36047e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f36004f;
    }

    @Override // com.google.android.flexbox.a
    public View getReorderedFlexItemAt(int i11) {
        return getFlexItemAt(i11);
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.f36007i.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += this.f36007i.get(i12).f36049g;
        }
        return i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.google.android.flexbox.a
    public boolean isMainAxisDirectionHorizontal() {
        int i11 = this.f36000a;
        return i11 == 0 || i11 == 1;
    }

    public final boolean l(View view, int i11) {
        if (isMainAxisDirectionHorizontal() || !this.f36005g) {
            return this.f36013o.getDecoratedStart(view) >= this.f36013o.getEnd() - i11;
        }
        return this.f36013o.getDecoratedEnd(view) <= i11;
    }

    public final boolean m(View view, int i11) {
        if (isMainAxisDirectionHorizontal() || !this.f36005g) {
            return this.f36013o.getDecoratedEnd(view) <= i11;
        }
        return this.f36013o.getEnd() - this.f36013o.getDecoratedStart(view) <= i11;
    }

    public final void n() {
        this.f36007i.clear();
        this.f36012n.t();
        this.f36012n.f36028d = 0;
    }

    public final void o() {
        if (this.f36013o != null) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            if (this.f36001b == 0) {
                this.f36013o = OrientationHelper.createHorizontalHelper(this);
                this.f36014p = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.f36013o = OrientationHelper.createVerticalHelper(this);
                this.f36014p = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f36001b == 0) {
            this.f36013o = OrientationHelper.createVerticalHelper(this);
            this.f36014p = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.f36013o = OrientationHelper.createHorizontalHelper(this);
            this.f36014p = OrientationHelper.createVerticalHelper(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f36023y = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        if (this.f36020v) {
            removeAndRecycleAllViews(tVar);
            tVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i11, int i12) {
        super.onItemsAdded(recyclerView, i11, i12);
        V(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i11, int i12, int i13) {
        super.onItemsMoved(recyclerView, i11, i12, i13);
        V(Math.min(i11, i12));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i11, int i12) {
        super.onItemsRemoved(recyclerView, i11, i12);
        V(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i11, int i12) {
        super.onItemsUpdated(recyclerView, i11, i12);
        V(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i11, int i12, Object obj) {
        super.onItemsUpdated(recyclerView, i11, i12, obj);
        V(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        int i11;
        int i12;
        this.f36009k = tVar;
        this.f36010l = xVar;
        int iB = xVar.b();
        if (iB == 0 && xVar.e()) {
            return;
        }
        N();
        o();
        ensureLayoutState();
        this.f36008j.t(iB);
        this.f36008j.u(iB);
        this.f36008j.s(iB);
        this.f36011m.f36042j = false;
        SavedState savedState = this.f36015q;
        if (savedState != null && savedState.g(iB)) {
            this.f36016r = this.f36015q.mAnchorPosition;
        }
        if (!this.f36012n.f36030f || this.f36016r != -1 || this.f36015q != null) {
            this.f36012n.t();
            U(xVar, this.f36012n);
            this.f36012n.f36030f = true;
        }
        detachAndScrapAttachedViews(tVar);
        if (this.f36012n.f36029e) {
            Z(this.f36012n, false, true);
        } else {
            Y(this.f36012n, false, true);
        }
        W(iB);
        p(tVar, xVar, this.f36011m);
        if (this.f36012n.f36029e) {
            i12 = this.f36011m.f36037e;
            Y(this.f36012n, true, false);
            p(tVar, xVar, this.f36011m);
            i11 = this.f36011m.f36037e;
        } else {
            i11 = this.f36011m.f36037e;
            Z(this.f36012n, true, false);
            p(tVar, xVar, this.f36011m);
            i12 = this.f36011m.f36037e;
        }
        if (getChildCount() > 0) {
            if (this.f36012n.f36029e) {
                fixLayoutStartGap(i12 + fixLayoutEndGap(i11, tVar, xVar, true), tVar, xVar, false);
            } else {
                fixLayoutEndGap(i11 + fixLayoutStartGap(i12, tVar, xVar, true), tVar, xVar, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutCompleted(RecyclerView.x xVar) {
        super.onLayoutCompleted(xVar);
        this.f36015q = null;
        this.f36016r = -1;
        this.f36017s = Integer.MIN_VALUE;
        this.f36024z = -1;
        this.f36012n.t();
        this.f36021w.clear();
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexItemAdded(View view, int i11, int i12, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, B);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.f36047e += leftDecorationWidth;
            bVar.f36048f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            bVar.f36047e += topDecorationHeight;
            bVar.f36048f += topDecorationHeight;
        }
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexLineAdded(com.google.android.flexbox.b bVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f36015q = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable onSaveInstanceState() {
        if (this.f36015q != null) {
            return new SavedState(this.f36015q);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.f36013o.getDecoratedStart(childClosestToStart) - this.f36013o.getStartAfterPadding();
        } else {
            savedState.h();
        }
        return savedState;
    }

    public final int p(RecyclerView.t tVar, RecyclerView.x xVar, c cVar) {
        if (cVar.f36038f != Integer.MIN_VALUE) {
            if (cVar.f36033a < 0) {
                c.q(cVar, cVar.f36033a);
            }
            J(tVar, cVar);
        }
        int i11 = cVar.f36033a;
        int iA = cVar.f36033a;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iG = 0;
        while (true) {
            if ((iA <= 0 && !this.f36011m.f36034b) || !cVar.D(xVar, this.f36007i)) {
                break;
            }
            com.google.android.flexbox.b bVar = this.f36007i.get(cVar.f36035c);
            cVar.f36036d = bVar.f36057o;
            iG += G(bVar, cVar);
            if (zIsMainAxisDirectionHorizontal || !this.f36005g) {
                c.c(cVar, bVar.a() * cVar.f36041i);
            } else {
                c.d(cVar, bVar.a() * cVar.f36041i);
            }
            iA -= bVar.a();
        }
        c.i(cVar, iG);
        if (cVar.f36038f != Integer.MIN_VALUE) {
            c.q(cVar, iG);
            if (cVar.f36033a < 0) {
                c.q(cVar, cVar.f36033a);
            }
            J(tVar, cVar);
        }
        return i11 - cVar.f36033a;
    }

    public final View q(int i11) {
        View viewV = v(0, getChildCount(), i11);
        if (viewV == null) {
            return null;
        }
        int i12 = this.f36008j.f36063c[getPosition(viewV)];
        if (i12 == -1) {
            return null;
        }
        return r(viewV, this.f36007i.get(i12));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    public final View r(View view, com.google.android.flexbox.b bVar) {
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i11 = bVar.f36050h;
        for (int i12 = 1; i12 < i11; i12++) {
            View childAt = getChildAt(i12);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f36005g || zIsMainAxisDirectionHorizontal) {
                    if (this.f36013o.getDecoratedStart(view) > this.f36013o.getDecoratedStart(childAt)) {
                        view = childAt;
                    }
                } else if (this.f36013o.getDecoratedEnd(view) < this.f36013o.getDecoratedEnd(childAt)) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void recycleChildren(RecyclerView.t tVar, int i11, int i12) {
        while (i12 >= i11) {
            removeAndRecycleViewAt(i12, tVar);
            i12--;
        }
    }

    public final View s(int i11) {
        View viewV = v(getChildCount() - 1, -1, i11);
        if (viewV == null) {
            return null;
        }
        return t(viewV, this.f36007i.get(this.f36008j.f36063c[getPosition(viewV)]));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (!isMainAxisDirectionHorizontal() || this.f36001b == 0) {
            int iC = C(i11, tVar, xVar);
            this.f36021w.clear();
            return iC;
        }
        int iD = D(i11);
        b.l(this.f36012n, iD);
        this.f36014p.offsetChildren(-iD);
        return iD;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void scrollToPosition(int i11) {
        this.f36016r = i11;
        this.f36017s = Integer.MIN_VALUE;
        SavedState savedState = this.f36015q;
        if (savedState != null) {
            savedState.h();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (isMainAxisDirectionHorizontal() || (this.f36001b == 0 && !isMainAxisDirectionHorizontal())) {
            int iC = C(i11, tVar, xVar);
            this.f36021w.clear();
            return iC;
        }
        int iD = D(i11);
        b.l(this.f36012n, iD);
        this.f36014p.offsetChildren(-iD);
        return iD;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.f36007i = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i11) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i11);
        startSmoothScroll(hVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    public final View t(View view, com.google.android.flexbox.b bVar) {
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - bVar.f36050h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f36005g || zIsMainAxisDirectionHorizontal) {
                    if (this.f36013o.getDecoratedEnd(view) < this.f36013o.getDecoratedEnd(childAt)) {
                        view = childAt;
                    }
                } else if (this.f36013o.getDecoratedStart(view) > this.f36013o.getDecoratedStart(childAt)) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final View u(int i11, int i12, boolean z11) {
        int i13 = i12 > i11 ? 1 : -1;
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (F(childAt, z11)) {
                return childAt;
            }
            i11 += i13;
        }
        return null;
    }

    @Override // com.google.android.flexbox.a
    public void updateViewCache(int i11, View view) {
        this.f36021w.put(i11, view);
    }

    public final View v(int i11, int i12, int i13) {
        int position;
        o();
        ensureLayoutState();
        int startAfterPadding = this.f36013o.getStartAfterPadding();
        int endAfterPadding = this.f36013o.getEndAfterPadding();
        int i14 = i12 > i11 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < i13) {
                if (((RecyclerView.n) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f36013o.getDecoratedStart(childAt) >= startAfterPadding && this.f36013o.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i11 += i14;
        }
        return view != null ? view : view2;
    }

    public final int w(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).bottomMargin;
    }

    public final int x(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).leftMargin;
    }

    public final int y(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).rightMargin;
    }

    public final int z(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).topMargin;
    }
}
