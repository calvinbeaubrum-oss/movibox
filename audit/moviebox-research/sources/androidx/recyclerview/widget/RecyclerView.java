package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static boolean sDebugAssertionsEnabled = false;
    static final y sDefaultEdgeEffectFactory;
    static final Interpolator sQuinticInterpolator;
    static boolean sVerboseLoggingEnabled = false;
    androidx.recyclerview.widget.n mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    androidx.recyclerview.widget.a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private h mChildDrawingOrderCallback;
    androidx.recyclerview.widget.e mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;

    @NonNull
    private i mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private q mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    j mItemAnimator;
    private j.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<l> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    m mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final v mObserver;
    private List<o> mOnChildAttachStateListeners;
    private p mOnFlingListener;
    private final ArrayList<q> mOnItemTouchListeners;
    final List<a0> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    GapWorker.a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final t mRecycler;
    u mRecyclerListener;
    final List<u> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private r mScrollListener;
    private List<r> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final x mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final androidx.recyclerview.widget.t.b mViewInfoProcessCallback;
    final androidx.recyclerview.widget.t mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: compiled from: source.java */
    public static abstract class Adapter<VH extends a0> {
        private final f mObservable = new f();
        private boolean mHasStableIds = false;
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        /* JADX INFO: compiled from: source.java */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(@NonNull VH vh2, int i11) {
            boolean z11 = vh2.mBindingAdapter == null;
            if (z11) {
                vh2.mPosition = i11;
                if (hasStableIds()) {
                    vh2.mItemId = getItemId(i11);
                }
                vh2.setFlags(1, 519);
                androidx.core.os.r.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh2.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled) {
                if (vh2.itemView.getParent() == null && ViewCompat.isAttachedToWindow(vh2.itemView) != vh2.isTmpDetached()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + vh2.isTmpDetached() + ", attached to window: " + ViewCompat.isAttachedToWindow(vh2.itemView) + ", holder: " + vh2);
                }
                if (vh2.itemView.getParent() == null && ViewCompat.isAttachedToWindow(vh2.itemView)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + vh2);
                }
            }
            onBindViewHolder(vh2, i11, vh2.getUnmodifiedPayloads());
            if (z11) {
                vh2.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh2.itemView.getLayoutParams();
                if (layoutParams instanceof n) {
                    ((n) layoutParams).mInsetsDirty = true;
                }
                androidx.core.os.r.b();
            }
        }

        public boolean canRestoreState() {
            int i11 = e.f12537a[this.mStateRestorationPolicy.ordinal()];
            if (i11 != 1) {
                return i11 != 2 || getItemCount() > 0;
            }
            return false;
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i11) {
            try {
                androidx.core.os.r.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH vh2 = (VH) onCreateViewHolder(viewGroup, i11);
                if (vh2.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh2.mItemViewType = i11;
                androidx.core.os.r.b();
                return vh2;
            } catch (Throwable th2) {
                androidx.core.os.r.b();
                throw th2;
            }
        }

        public int findRelativeAdapterPositionIn(@NonNull Adapter<? extends a0> adapter, @NonNull a0 a0Var, int i11) {
            if (adapter == this) {
                return i11;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i11) {
            return -1L;
        }

        public int getItemViewType(int i11) {
            return 0;
        }

        @NonNull
        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i11) {
            this.mObservable.d(i11, 1);
        }

        public final void notifyItemChanged(int i11, @Nullable Object obj) {
            this.mObservable.e(i11, 1, obj);
        }

        public final void notifyItemInserted(int i11) {
            this.mObservable.f(i11, 1);
        }

        public final void notifyItemMoved(int i11, int i12) {
            this.mObservable.c(i11, i12);
        }

        public final void notifyItemRangeChanged(int i11, int i12) {
            this.mObservable.d(i11, i12);
        }

        public final void notifyItemRangeChanged(int i11, int i12, @Nullable Object obj) {
            this.mObservable.e(i11, i12, obj);
        }

        public final void notifyItemRangeInserted(int i11, int i12) {
            this.mObservable.f(i11, i12);
        }

        public final void notifyItemRangeRemoved(int i11, int i12) {
            this.mObservable.g(i11, i12);
        }

        public final void notifyItemRemoved(int i11) {
            this.mObservable.g(i11, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(@NonNull VH vh2, int i11);

        public void onBindViewHolder(@NonNull VH vh2, int i11, @NonNull List<Object> list) {
            onBindViewHolder(vh2, i11);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@NonNull VH vh2) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH vh2) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh2) {
        }

        public void onViewRecycled(@NonNull VH vh2) {
        }

        public void registerAdapterDataObserver(@NonNull g gVar) {
            this.mObservable.registerObserver(gVar);
        }

        public void setHasStableIds(boolean z11) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z11;
        }

        public void setStateRestorationPolicy(@NonNull StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(@NonNull g gVar) {
            this.mObservable.unregisterObserver(gVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        Parcelable mLayoutState;

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? m.class.getClassLoader() : classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeParcelable(this.mLayoutState, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback;

        public ViewFlinger() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = interpolator;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int computeScrollDuration(int i11, int i12) {
            int iAbs = Math.abs(i11);
            int iAbs2 = Math.abs(i12);
            boolean z11 = iAbs > iAbs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z11 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z11) {
                iAbs = iAbs2;
            }
            return Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }

        private void internalPostOnAnimation() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void fling(int i11, int i12) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator interpolator = this.mInterpolator;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.mInterpolator = interpolator2;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.mOverScroller.fling(0, 0, i11, i12, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            postOnAnimation();
        }

        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i11;
            int i12;
            int i13;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i14 = currX - this.mLastFlingX;
                int i15 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                int iConsumeFlingInHorizontalStretch = RecyclerView.this.consumeFlingInHorizontalStretch(i14);
                int iConsumeFlingInVerticalStretch = RecyclerView.this.consumeFlingInVerticalStretch(i15);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    iConsumeFlingInHorizontalStretch -= iArr2[0];
                    iConsumeFlingInVerticalStretch -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i12 = iArr4[0];
                    i11 = iArr4[1];
                    iConsumeFlingInHorizontalStretch -= i12;
                    iConsumeFlingInVerticalStretch -= i11;
                    w wVar = recyclerView4.mLayout.mSmoothScroller;
                    if (wVar != null && !wVar.g() && wVar.h()) {
                        int iB = RecyclerView.this.mState.b();
                        if (iB == 0) {
                            wVar.r();
                        } else if (wVar.f() >= iB) {
                            wVar.p(iB - 1);
                            wVar.j(i12, i11);
                        } else {
                            wVar.j(i12, i11);
                        }
                    }
                } else {
                    i11 = 0;
                    i12 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i12, i11, iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i16 = iConsumeFlingInHorizontalStretch - iArr6[0];
                int i17 = iConsumeFlingInVerticalStretch - iArr6[1];
                if (i12 != 0 || i11 != 0) {
                    recyclerView6.dispatchOnScrolled(i12, i11);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z11 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i16 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i17 != 0));
                w wVar2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((wVar2 == null || !wVar2.g()) && z11) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i16 < 0) {
                            i13 = -currVelocity;
                        } else {
                            i13 = i16 > 0 ? currVelocity : 0;
                        }
                        if (i17 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i17 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i13, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.b();
                    }
                } else {
                    postOnAnimation();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView7.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView7, i12, i11);
                    }
                }
            }
            w wVar3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (wVar3 != null && wVar3.g()) {
                wVar3.j(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }

        public void smoothScrollBy(int i11, int i12, int i13, @Nullable Interpolator interpolator) {
            if (i13 == Integer.MIN_VALUE) {
                i13 = computeScrollDuration(i11, i12);
            }
            int i14 = i13;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i11, i12, i14);
            if (Build.VERSION.SDK_INT < 23) {
                this.mOverScroller.computeScrollOffset();
            }
            postOnAnimation();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class a0 {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

        @NonNull
        public final View itemView;
        Adapter<? extends a0> mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        a0 mShadowedHolder = null;
        a0 mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        t mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public a0(@NonNull View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i11) {
            this.mFlags = i11 | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        public void flagRemovedAndOffsetPosition(int i11, int i12, boolean z11) {
            addFlags(8);
            offsetPosition(i12, z11);
            this.mPosition = i11;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        @Nullable
        public final Adapter<? extends a0> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i11 = this.mPreLayoutPosition;
            return i11 == -1 ? this.mPosition : i11;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i11 = this.mPreLayoutPosition;
            return i11 == -1 ? this.mPosition : i11;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i11) {
            return (i11 & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i11, boolean z11) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z11) {
                this.mPreLayoutPosition += i11;
            }
            this.mPosition += i11;
            if (this.itemView.getLayoutParams() != null) {
                ((n) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i11 = this.mPendingAccessibilityState;
            if (i11 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i11;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            if (RecyclerView.sDebugAssertionsEnabled && isTmpDetached()) {
                throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
            }
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i11, int i12) {
            this.mFlags = (i11 & i12) | (this.mFlags & (~i12));
        }

        public final void setIsRecyclable(boolean z11) {
            int i11 = this.mIsRecyclableCount;
            int i12 = z11 ? i11 - 1 : i11 + 1;
            this.mIsRecyclableCount = i12;
            if (i12 < 0) {
                this.mIsRecyclableCount = 0;
                if (RecyclerView.sDebugAssertionsEnabled) {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z11 && i12 == 1) {
                this.mFlags |= 16;
            } else if (z11 && i12 == 0) {
                this.mFlags &= -17;
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setIsRecyclable val:");
                sb2.append(z11);
                sb2.append(":");
                sb2.append(this);
            }
        }

        public void setScrapContainer(t tVar, boolean z11) {
            this.mScrapContainer = tVar;
            this.mInChangeScrap = z11;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb2.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        public void unScrap() {
            this.mScrapContainer.O(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b implements androidx.recyclerview.widget.t.b {
        public b() {
        }

        @Override // androidx.recyclerview.widget.t.b
        public void a(a0 a0Var, j.c cVar, j.c cVar2) {
            RecyclerView.this.animateAppearance(a0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.t.b
        public void b(a0 a0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mLayout.removeAndRecycleView(a0Var.itemView, recyclerView.mRecycler);
        }

        @Override // androidx.recyclerview.widget.t.b
        public void c(a0 a0Var, @NonNull j.c cVar, @Nullable j.c cVar2) {
            RecyclerView.this.mRecycler.O(a0Var);
            RecyclerView.this.animateDisappearance(a0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.t.b
        public void d(a0 a0Var, @NonNull j.c cVar, @NonNull j.c cVar2) {
            a0Var.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mDataSetHasChangedAfterLayout) {
                if (recyclerView.mItemAnimator.animateChange(a0Var, a0Var, cVar, cVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            } else if (recyclerView.mItemAnimator.animatePersistence(a0Var, cVar, cVar2)) {
                RecyclerView.this.postAnimationRunner();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c implements androidx.recyclerview.widget.e.b {
        public c() {
        }

        @Override // androidx.recyclerview.widget.e.b
        public void a(View view) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.e.b
        public void addView(View view, int i11) {
            RecyclerView.this.addView(view, i11);
            RecyclerView.this.dispatchChildAttached(view);
        }

        @Override // androidx.recyclerview.widget.e.b
        public a0 b(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void c(int i11) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("tmpDetach ");
                        sb2.append(childViewHolderInt);
                    }
                    childViewHolderInt.addFlags(256);
                }
            } else if (RecyclerView.sDebugAssertionsEnabled) {
                throw new IllegalArgumentException("No view at offset " + i11 + RecyclerView.this.exceptionLabel());
            }
            RecyclerView.this.detachViewFromParent(i11);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void d() {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.e.b
        public int e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void f(View view) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.e.b
        public void g(int i11) {
            View childAt = RecyclerView.this.getChildAt(i11);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i11);
        }

        @Override // androidx.recyclerview.widget.e.b
        public View getChildAt(int i11) {
            return RecyclerView.this.getChildAt(i11);
        }

        @Override // androidx.recyclerview.widget.e.b
        public int getChildCount() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.e.b
        public void h(View view, int i11, ViewGroup.LayoutParams layoutParams) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                if (RecyclerView.sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("reAttach ");
                    sb2.append(childViewHolderInt);
                }
                childViewHolderInt.clearTmpDetachFlag();
            } else if (RecyclerView.sDebugAssertionsEnabled) {
                throw new IllegalArgumentException("No ViewHolder found for child: " + view + ", index: " + i11 + RecyclerView.this.exceptionLabel());
            }
            RecyclerView.this.attachViewToParent(view, i11, layoutParams);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d implements androidx.recyclerview.widget.a.InterfaceC0115a {
        public d() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void a(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForMove(i11, i12);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void b(androidx.recyclerview.widget.a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void c(androidx.recyclerview.widget.a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void d(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForRemove(i11, i12, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void e(int i11, int i12, Object obj) {
            RecyclerView.this.viewRangeUpdate(i11, i12, obj);
            RecyclerView.this.mItemsChanged = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public a0 f(int i11) {
            a0 a0VarFindViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i11, true);
            if (a0VarFindViewHolderForPosition == null) {
                return null;
            }
            if (!RecyclerView.this.mChildHelper.n(a0VarFindViewHolderForPosition.itemView)) {
                return a0VarFindViewHolderForPosition;
            }
            int i12 = RecyclerView.HORIZONTAL;
            return null;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void g(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForInsert(i11, i12);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void h(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForRemove(i11, i12, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f12583d += i12;
        }

        public void i(androidx.recyclerview.widget.a.b bVar) {
            int i11 = bVar.f12626a;
            if (i11 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.onItemsAdded(recyclerView, bVar.f12627b, bVar.f12629d);
                return;
            }
            if (i11 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.onItemsRemoved(recyclerView2, bVar.f12627b, bVar.f12629d);
            } else if (i11 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.onItemsUpdated(recyclerView3, bVar.f12627b, bVar.f12629d, bVar.f12628c);
            } else {
                if (i11 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.onItemsMoved(recyclerView4, bVar.f12627b, bVar.f12629d, 1);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12537a;

        static {
            int[] iArr = new int[Adapter.StateRestorationPolicy.values().length];
            f12537a = iArr;
            try {
                iArr[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12537a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class f extends Observable<g> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void c(int i11, int i12) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i11, i12, 1);
            }
        }

        public void d(int i11, int i12) {
            e(i11, i12, null);
        }

        public void e(int i11, int i12, @Nullable Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i11, i12, obj);
            }
        }

        public void f(int i11, int i12) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i11, i12);
            }
        }

        public void g(int i11, int i12) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i11, i12);
            }
        }

        public void h() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class g {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i11, int i12) {
        }

        public void onItemRangeChanged(int i11, int i12, @Nullable Object obj) {
            onItemRangeChanged(i11, i12);
        }

        public void onItemRangeInserted(int i11, int i12) {
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
        }

        public void onItemRangeRemoved(int i11, int i12) {
        }

        public void onStateRestorationPolicyChanged() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface h {
        int a(int i11, int i12);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class i {
        @NonNull
        public EdgeEffect a(@NonNull RecyclerView recyclerView, int i11) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class j {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private b mListener = null;
        private ArrayList<a> mFinishedListeners = new ArrayList<>();
        private long mAddDuration = 120;
        private long mRemoveDuration = 120;
        private long mMoveDuration = 250;
        private long mChangeDuration = 250;

        /* JADX INFO: compiled from: source.java */
        public interface a {
            void a();
        }

        /* JADX INFO: compiled from: source.java */
        public interface b {
            void a(@NonNull a0 a0Var);
        }

        /* JADX INFO: compiled from: source.java */
        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f12538a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f12539b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f12540c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f12541d;

            @NonNull
            public c a(@NonNull a0 a0Var) {
                return b(a0Var, 0);
            }

            @NonNull
            public c b(@NonNull a0 a0Var, int i11) {
                View view = a0Var.itemView;
                this.f12538a = view.getLeft();
                this.f12539b = view.getTop();
                this.f12540c = view.getRight();
                this.f12541d = view.getBottom();
                return this;
            }
        }

        public static int buildAdapterChangeFlagsForAnimations(a0 a0Var) {
            int i11 = a0Var.mFlags;
            int i12 = i11 & 14;
            if (a0Var.isInvalid()) {
                return 4;
            }
            if ((i11 & 4) != 0) {
                return i12;
            }
            int oldPosition = a0Var.getOldPosition();
            int absoluteAdapterPosition = a0Var.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i12 : i12 | 2048;
        }

        public abstract boolean animateAppearance(@NonNull a0 a0Var, @Nullable c cVar, @NonNull c cVar2);

        public abstract boolean animateChange(@NonNull a0 a0Var, @NonNull a0 a0Var2, @NonNull c cVar, @NonNull c cVar2);

        public abstract boolean animateDisappearance(@NonNull a0 a0Var, @NonNull c cVar, @Nullable c cVar2);

        public abstract boolean animatePersistence(@NonNull a0 a0Var, @NonNull c cVar, @NonNull c cVar2);

        public boolean canReuseUpdatedViewHolder(@NonNull a0 a0Var) {
            return true;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull a0 a0Var, @NonNull List<Object> list) {
            return canReuseUpdatedViewHolder(a0Var);
        }

        public final void dispatchAnimationFinished(@NonNull a0 a0Var) {
            onAnimationFinished(a0Var);
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.a(a0Var);
            }
        }

        public final void dispatchAnimationStarted(@NonNull a0 a0Var) {
            onAnimationStarted(a0Var);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mFinishedListeners.get(i11).a();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(@NonNull a0 a0Var);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable a aVar) {
            boolean zIsRunning = isRunning();
            if (aVar != null) {
                if (zIsRunning) {
                    this.mFinishedListeners.add(aVar);
                } else {
                    aVar.a();
                }
            }
            return zIsRunning;
        }

        @NonNull
        public c obtainHolderInfo() {
            return new c();
        }

        public void onAnimationFinished(@NonNull a0 a0Var) {
        }

        public void onAnimationStarted(@NonNull a0 a0Var) {
        }

        @NonNull
        public c recordPostLayoutInformation(@NonNull x xVar, @NonNull a0 a0Var) {
            return obtainHolderInfo().a(a0Var);
        }

        @NonNull
        public c recordPreLayoutInformation(@NonNull x xVar, @NonNull a0 a0Var, int i11, @NonNull List<Object> list) {
            return obtainHolderInfo().a(a0Var);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j11) {
            this.mAddDuration = j11;
        }

        public void setChangeDuration(long j11) {
            this.mChangeDuration = j11;
        }

        public void setListener(b bVar) {
            this.mListener = bVar;
        }

        public void setMoveDuration(long j11) {
            this.mMoveDuration = j11;
        }

        public void setRemoveDuration(long j11) {
            this.mRemoveDuration = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class k implements j.b {
        public k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j.b
        public void a(a0 a0Var) {
            a0Var.setIsRecyclable(true);
            if (a0Var.mShadowedHolder != null && a0Var.mShadowingHolder == null) {
                a0Var.mShadowedHolder = null;
            }
            a0Var.mShadowingHolder = null;
            if (a0Var.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(a0Var.itemView) || !a0Var.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(a0Var.itemView, false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class l {
        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i11, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull x xVar) {
            getItemOffsets(rect, ((n) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull x xVar) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull x xVar) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class m {
        boolean mAutoMeasure;
        androidx.recyclerview.widget.e mChildHelper;
        private int mHeight;
        private int mHeightMode;
        androidx.recyclerview.widget.s mHorizontalBoundCheck;
        private final androidx.recyclerview.widget.s.b mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;

        @Nullable
        w mSmoothScroller;
        androidx.recyclerview.widget.s mVerticalBoundCheck;
        private final androidx.recyclerview.widget.s.b mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        /* JADX INFO: compiled from: source.java */
        public class a implements androidx.recyclerview.widget.s.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.s.b
            public int a(View view) {
                return m.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.s.b
            public int b() {
                return m.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.s.b
            public int c() {
                return m.this.getWidth() - m.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.s.b
            public int d(View view) {
                return m.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.s.b
            public View getChildAt(int i11) {
                return m.this.getChildAt(i11);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b implements androidx.recyclerview.widget.s.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.s.b
            public int a(View view) {
                return m.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.s.b
            public int b() {
                return m.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.s.b
            public int c() {
                return m.this.getHeight() - m.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.s.b
            public int d(View view) {
                return m.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.s.b
            public View getChildAt(int i11) {
                return m.this.getChildAt(i11);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public interface c {
            void a(int i11, int i12);
        }

        /* JADX INFO: compiled from: source.java */
        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f12545a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f12546b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f12547c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f12548d;
        }

        public m() {
            a aVar = new a();
            this.mHorizontalBoundCheckCallback = aVar;
            b bVar = new b();
            this.mVerticalBoundCheckCallback = bVar;
            this.mHorizontalBoundCheck = new androidx.recyclerview.widget.s(aVar);
            this.mVerticalBoundCheck = new androidx.recyclerview.widget.s(bVar);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View view, int i11, boolean z11) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z11 || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            n nVar = (n) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.c(view, i11, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int iM = this.mChildHelper.m(view);
                if (i11 == -1) {
                    i11 = this.mChildHelper.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                }
                if (iM != i11) {
                    this.mRecyclerView.mLayout.moveView(iM, i11);
                }
            } else {
                this.mChildHelper.a(view, i11, false);
                nVar.mInsetsDirty = true;
                w wVar = this.mSmoothScroller;
                if (wVar != null && wVar.h()) {
                    this.mSmoothScroller.k(view);
                }
            }
            if (nVar.mPendingInvalidate) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("consuming pending invalidate on child ");
                    sb2.append(nVar.mViewHolder);
                }
                childViewHolderInt.itemView.invalidate();
                nVar.mPendingInvalidate = false;
            }
        }

        public static int chooseSize(int i11, int i12, int i13) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i12, i13) : size;
            }
            return Math.min(size, Math.max(i12, i13));
        }

        private void detachViewInternal(int i11, @NonNull View view) {
            this.mChildHelper.d(i11);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001b  */
        /* JADX WARN: Code duplicated, block: B:5:0x0010  */
        public static int getChildMeasureSpec(int i11, int i12, int i13, int i14, boolean z11) {
            int iMax = Math.max(0, i11 - i13);
            if (z11) {
                if (i14 >= 0) {
                    i12 = 1073741824;
                } else if (i14 != -1 || (i12 != Integer.MIN_VALUE && (i12 == 0 || i12 != 1073741824))) {
                    i12 = 0;
                    i14 = 0;
                } else {
                    i14 = iMax;
                }
            } else if (i14 >= 0) {
                i12 = 1073741824;
            } else {
                if (i14 != -1) {
                    if (i14 == -2) {
                        i12 = (i12 == Integer.MIN_VALUE || i12 == 1073741824) ? Integer.MIN_VALUE : 0;
                    } else {
                        i12 = 0;
                        i14 = 0;
                    }
                }
                i14 = iMax;
            }
            return View.MeasureSpec.makeMeasureSpec(i14, i12);
        }

        /* JADX WARN: Code duplicated, block: B:5:0x000c  */
        /* JADX WARN: Code duplicated, block: B:6:0x000f  */
        @Deprecated
        public static int getChildMeasureSpec(int i11, int i12, int i13, boolean z11) {
            int i14 = i11 - i12;
            int i15 = 0;
            int iMax = Math.max(0, i14);
            if (z11) {
                if (i13 >= 0) {
                    i15 = 1073741824;
                } else {
                    i13 = 0;
                }
            } else if (i13 >= 0) {
                i15 = 1073741824;
            } else {
                if (i13 == -1) {
                    i15 = 1073741824;
                } else if (i13 == -2) {
                    i15 = Integer.MIN_VALUE;
                } else {
                    i13 = 0;
                }
                i13 = iMax;
            }
            return View.MeasureSpec.makeMeasureSpec(i13, i15);
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i11 = left - paddingLeft;
            int iMin = Math.min(0, i11);
            int i12 = top - paddingTop;
            int iMin2 = Math.min(0, i12);
            int i13 = iWidth - width;
            int iMax = Math.max(0, i13);
            int iMax2 = Math.max(0, iHeight - height);
            if (getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i11, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i13);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i12, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public static d getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i11, i12);
            dVar.f12545a = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            dVar.f12546b = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            dVar.f12547c = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            dVar.f12548d = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i11, int i12) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i11 < width && rect.right - i11 > paddingLeft && rect.top - i12 < height && rect.bottom - i12 > paddingTop;
        }

        private static boolean isMeasurementUpToDate(int i11, int i12, int i13) {
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

        private void scrapOrRecycleView(t tVar, int i11, View view) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ignoring view ");
                    sb2.append(childViewHolderInt);
                    return;
                }
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i11);
                tVar.H(childViewHolderInt);
            } else {
                detachViewAt(i11);
                tVar.I(view);
                this.mRecyclerView.mViewInfoStore.k(childViewHolderInt);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view, int i11) {
            addViewInt(view, i11, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view) {
            addView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view, int i11) {
            addViewInt(view, i11, false);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(@NonNull View view) {
            attachView(view, -1);
        }

        public void attachView(@NonNull View view, int i11) {
            attachView(view, i11, (n) view.getLayoutParams());
        }

        public void attachView(@NonNull View view, int i11, n nVar) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            this.mChildHelper.c(view, i11, nVar, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(n nVar) {
            return nVar != null;
        }

        @SuppressLint({"UnknownNullness"})
        public void collectAdjacentPrefetchPositions(int i11, int i12, x xVar, c cVar) {
        }

        @SuppressLint({"UnknownNullness"})
        public void collectInitialPrefetchPositions(int i11, c cVar) {
        }

        public int computeHorizontalScrollExtent(@NonNull x xVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull x xVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull x xVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull x xVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull x xVar) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull x xVar) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull t tVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(tVar, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull t tVar) {
            scrapOrRecycleView(tVar, this.mChildHelper.m(view), view);
        }

        public void detachAndScrapViewAt(int i11, @NonNull t tVar) {
            scrapOrRecycleView(tVar, i11, getChildAt(i11));
        }

        public void detachView(@NonNull View view) {
            int iM = this.mChildHelper.m(view);
            if (iM >= 0) {
                detachViewInternal(iM, view);
            }
        }

        public void detachViewAt(int i11) {
            detachViewInternal(i11, getChildAt(i11));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, t tVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, tVar);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View view) {
            j jVar = this.mRecyclerView.mItemAnimator;
            if (jVar != null) {
                jVar.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            View viewFindContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.n(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        @Nullable
        public View findViewByPosition(int i11) {
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i11 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.e() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public abstract n generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public n generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new n(context, attributeSet);
        }

        @SuppressLint({"UnknownNullness"})
        public n generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof n) {
                return new n((n) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new n((ViewGroup.MarginLayoutParams) layoutParams) : new n(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View view) {
            return ((n) view.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
        public View getChildAt(int i11) {
            androidx.recyclerview.widget.e eVar = this.mChildHelper;
            if (eVar != null) {
                return eVar.f(i11);
            }
            return null;
        }

        public int getChildCount() {
            androidx.recyclerview.widget.e eVar = this.mChildHelper;
            if (eVar != null) {
                return eVar.g();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(@NonNull t tVar, @NonNull x xVar) {
            return -1;
        }

        public int getDecoratedBottom(@NonNull View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(@NonNull View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            Rect rect = ((n) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            Rect rect = ((n) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(@NonNull View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(@NonNull View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            return ((n) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(@NonNull View view) {
            return ((n) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View view) {
            return ((n) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(@NonNull t tVar, @NonNull x xVar) {
            return -1;
        }

        public int getSelectionModeForAccessibility(@NonNull t tVar, @NonNull x xVar) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            return ((n) view.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z11, @NonNull Rect rect) {
            Matrix matrix;
            if (z11) {
                Rect rect2 = ((n) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i11).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.q(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull t tVar, @NonNull x xVar) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            w wVar = this.mSmoothScroller;
            return wVar != null && wVar.h();
        }

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z11, boolean z12) {
            boolean z13 = this.mHorizontalBoundCheck.b(view, 24579) && this.mVerticalBoundCheck.b(view, 24579);
            return z11 ? z13 : !z13;
        }

        public void layoutDecorated(@NonNull View view, int i11, int i12, int i13, int i14) {
            Rect rect = ((n) view.getLayoutParams()).mDecorInsets;
            view.layout(i11 + rect.left, i12 + rect.top, i13 - rect.right, i14 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i11, int i12, int i13, int i14) {
            n nVar = (n) view.getLayoutParams();
            Rect rect = nVar.mDecorInsets;
            view.layout(i11 + rect.left + ((ViewGroup.MarginLayoutParams) nVar).leftMargin, i12 + rect.top + ((ViewGroup.MarginLayoutParams) nVar).topMargin, (i13 - rect.right) - ((ViewGroup.MarginLayoutParams) nVar).rightMargin, (i14 - rect.bottom) - ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
        }

        public void measureChild(@NonNull View view, int i11, int i12) {
            n nVar = (n) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i13 = i11 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i14 = i12 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i13, ((ViewGroup.MarginLayoutParams) nVar).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i14, ((ViewGroup.MarginLayoutParams) nVar).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, nVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(@NonNull View view, int i11, int i12) {
            n nVar = (n) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i13 = i11 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i14 = i12 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin + i13, ((ViewGroup.MarginLayoutParams) nVar).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin + i14, ((ViewGroup.MarginLayoutParams) nVar).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, nVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i11, int i12) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                detachViewAt(i11);
                attachView(childAt, i12);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i11 + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(int i11) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i11);
            }
        }

        public void offsetChildrenVertical(int i11) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i11);
            }
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i11, int i12) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @SuppressLint({"UnknownNullness"})
        @CallSuper
        public void onDetachedFromWindow(RecyclerView recyclerView, t tVar) {
            onDetachedFromWindow(recyclerView);
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view, int i11, @NonNull t tVar, @NonNull x xVar) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(@NonNull t tVar, @NonNull x xVar, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z11 = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z11 = false;
            }
            accessibilityEvent.setScrollable(z11);
            Adapter adapter = this.mRecyclerView.mAdapter;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull t tVar, @NonNull x xVar, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(tVar, xVar), getColumnCountForAccessibility(tVar, xVar), isLayoutHierarchical(tVar, xVar), getSelectionModeForAccessibility(tVar, xVar)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.n(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull t tVar, @NonNull x xVar, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i11) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i11, int i12) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i11, int i12, int i13) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i11, int i12) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i11, int i12) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i11, int i12, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i11, i12);
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutChildren(t tVar, x xVar) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutCompleted(x xVar) {
        }

        public void onMeasure(@NonNull t tVar, @NonNull x xVar, int i11, int i12) {
            this.mRecyclerView.defaultOnMeasure(i11, i12);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull x xVar, @NonNull View view, @Nullable View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        @SuppressLint({"UnknownNullness"})
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i11) {
        }

        public void onSmoothScrollerStopped(w wVar) {
            if (this.mSmoothScroller == wVar) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i11, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i11, bundle);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0067 A[PHI: r9
  0x0067: PHI (r9v8 int) = (r9v5 int), (r9v11 int) binds: [B:29:0x0084, B:20:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
        public boolean performAccessibilityAction(@NonNull t tVar, @NonNull x xVar, int i11, @Nullable Bundle bundle) {
            int paddingTop;
            int paddingLeft;
            int i12;
            int i13;
            if (this.mRecyclerView == null) {
                return false;
            }
            int height = getHeight();
            int width = getWidth();
            Rect rect = new Rect();
            if (this.mRecyclerView.getMatrix().isIdentity() && this.mRecyclerView.getGlobalVisibleRect(rect)) {
                height = rect.height();
                width = rect.width();
            }
            if (i11 == 4096) {
                paddingTop = this.mRecyclerView.canScrollVertically(1) ? (height - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
                    i12 = paddingTop;
                    i13 = paddingLeft;
                } else {
                    i12 = paddingTop;
                    i13 = 0;
                }
            } else if (i11 != 8192) {
                i13 = 0;
                i12 = 0;
            } else {
                paddingTop = this.mRecyclerView.canScrollVertically(-1) ? -((height - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    paddingLeft = -((width - getPaddingLeft()) - getPaddingRight());
                    i12 = paddingTop;
                    i13 = paddingLeft;
                } else {
                    i12 = paddingTop;
                    i13 = 0;
                }
            }
            if (i12 == 0 && i13 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i13, i12, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean performAccessibilityActionForItem(@NonNull View view, int i11, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i11, bundle);
        }

        public boolean performAccessibilityActionForItem(@NonNull t tVar, @NonNull x xVar, @NonNull View view, int i11, @Nullable Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.q(childCount);
            }
        }

        public void removeAndRecycleAllViews(@NonNull t tVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, tVar);
                }
            }
        }

        public void removeAndRecycleScrapInt(t tVar) {
            int iJ = tVar.j();
            for (int i11 = iJ - 1; i11 >= 0; i11--) {
                View viewN = tVar.n(i11);
                a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(viewN);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(viewN, false);
                    }
                    j jVar = this.mRecyclerView.mItemAnimator;
                    if (jVar != null) {
                        jVar.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    tVar.D(viewN);
                }
            }
            tVar.e();
            if (iJ > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(@NonNull View view, @NonNull t tVar) {
            removeView(view);
            tVar.G(view);
        }

        public void removeAndRecycleViewAt(int i11, @NonNull t tVar) {
            View childAt = getChildAt(i11);
            removeViewAt(i11);
            tVar.G(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(@NonNull View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View view) {
            this.mChildHelper.p(view);
        }

        public void removeViewAt(int i11) {
            if (getChildAt(i11) != null) {
                this.mChildHelper.q(i11);
            }
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z11) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z11, false);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z11, boolean z12) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i11 = childRectangleOnScreenScrollAmount[0];
            int i12 = childRectangleOnScreenScrollAmount[1];
            if ((z12 && !isFocusedChildVisibleAfterScrolling(recyclerView, i11, i12)) || (i11 == 0 && i12 == 0)) {
                return false;
            }
            if (z11) {
                recyclerView.scrollBy(i11, i12);
            } else {
                recyclerView.smoothScrollBy(i11, i12);
            }
            return true;
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollHorizontallyBy(int i11, t tVar, x xVar) {
            return 0;
        }

        public void scrollToPosition(int i11) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.e(RecyclerView.TAG, "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollVerticallyBy(int i11, t tVar, x xVar) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z11) {
            this.mAutoMeasure = z11;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z11) {
            if (z11 != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z11;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.P();
                }
            }
        }

        public void setMeasureSpecs(int i11, int i12) {
            this.mWidth = View.MeasureSpec.getSize(i11);
            int mode = View.MeasureSpec.getMode(i11);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i12);
            int mode2 = View.MeasureSpec.getMode(i12);
            this.mHeightMode = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        public void setMeasuredDimension(int i11, int i12) {
            this.mRecyclerView.setMeasuredDimension(i11, i12);
        }

        public void setMeasuredDimension(Rect rect, int i11, int i12) {
            setMeasuredDimension(chooseSize(i11, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i12, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i11, int i12) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i11, i12);
                return;
            }
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE;
            int i15 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i16 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i18 = rect.left;
                if (i18 < i15) {
                    i15 = i18;
                }
                int i19 = rect.right;
                if (i19 > i13) {
                    i13 = i19;
                }
                int i21 = rect.top;
                if (i21 < i16) {
                    i16 = i21;
                }
                int i22 = rect.bottom;
                if (i22 > i14) {
                    i14 = i22;
                }
            }
            this.mRecyclerView.mTempRect.set(i15, i16, i13, i14);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i11, i12);
        }

        public void setMeasurementCacheEnabled(boolean z11) {
            this.mMeasurementCacheEnabled = z11;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int i11, int i12, n nVar) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i11, ((ViewGroup.MarginLayoutParams) nVar).width) && isMeasurementUpToDate(view.getHeight(), i12, ((ViewGroup.MarginLayoutParams) nVar).height)) ? false : true;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i11, int i12, n nVar) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i11, ((ViewGroup.MarginLayoutParams) nVar).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i12, ((ViewGroup.MarginLayoutParams) nVar).height)) ? false : true;
        }

        @SuppressLint({"UnknownNullness"})
        public void smoothScrollToPosition(RecyclerView recyclerView, x xVar, int i11) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(w wVar) {
            w wVar2 = this.mSmoothScroller;
            if (wVar2 != null && wVar != wVar2 && wVar2.h()) {
                this.mSmoothScroller.r();
            }
            this.mSmoothScroller = wVar;
            wVar.q(this.mRecyclerView, this);
        }

        public void stopIgnoringView(@NonNull View view) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            w wVar = this.mSmoothScroller;
            if (wVar != null) {
                wVar.r();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class n extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        a0 mViewHolder;

        public n(int i11, int i12) {
            super(i11, i12);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public n(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public n(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public n(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public n(n nVar) {
            super((ViewGroup.LayoutParams) nVar);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface o {
        void onChildViewAttachedToWindow(@NonNull View view);

        void onChildViewDetachedFromWindow(@NonNull View view);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class p {
        public abstract boolean onFling(int i11, int i12);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface q {
        void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        boolean b(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void c(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class r {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i11) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray<a> f12549a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12550b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set<Adapter<?>> f12551c = Collections.newSetFromMap(new IdentityHashMap());

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList<a0> f12552a = new ArrayList<>();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f12553b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f12554c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f12555d = 0;
        }

        public void a() {
            this.f12550b++;
        }

        public void b(@NonNull Adapter<?> adapter) {
            this.f12551c.add(adapter);
        }

        public void c() {
            for (int i11 = 0; i11 < this.f12549a.size(); i11++) {
                a aVarValueAt = this.f12549a.valueAt(i11);
                Iterator<a0> it = aVarValueAt.f12552a.iterator();
                while (it.hasNext()) {
                    k3.a.b(it.next().itemView);
                }
                aVarValueAt.f12552a.clear();
            }
        }

        public void d() {
            this.f12550b--;
        }

        public void e(@NonNull Adapter<?> adapter, boolean z11) {
            this.f12551c.remove(adapter);
            if (this.f12551c.size() != 0 || z11) {
                return;
            }
            for (int i11 = 0; i11 < this.f12549a.size(); i11++) {
                SparseArray<a> sparseArray = this.f12549a;
                ArrayList<a0> arrayList = sparseArray.get(sparseArray.keyAt(i11)).f12552a;
                for (int i12 = 0; i12 < arrayList.size(); i12++) {
                    k3.a.b(arrayList.get(i12).itemView);
                }
            }
        }

        public void f(int i11, long j11) {
            a aVarI = i(i11);
            aVarI.f12555d = l(aVarI.f12555d, j11);
        }

        public void g(int i11, long j11) {
            a aVarI = i(i11);
            aVarI.f12554c = l(aVarI.f12554c, j11);
        }

        @Nullable
        public a0 h(int i11) {
            a aVar = this.f12549a.get(i11);
            if (aVar == null || aVar.f12552a.isEmpty()) {
                return null;
            }
            ArrayList<a0> arrayList = aVar.f12552a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public final a i(int i11) {
            a aVar = this.f12549a.get(i11);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f12549a.put(i11, aVar2);
            return aVar2;
        }

        public void j(Adapter<?> adapter, Adapter<?> adapter2, boolean z11) {
            if (adapter != null) {
                d();
            }
            if (!z11 && this.f12550b == 0) {
                c();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void k(a0 a0Var) {
            int itemViewType = a0Var.getItemViewType();
            ArrayList<a0> arrayList = i(itemViewType).f12552a;
            if (this.f12549a.get(itemViewType).f12553b <= arrayList.size()) {
                k3.a.b(a0Var.itemView);
            } else {
                if (RecyclerView.sDebugAssertionsEnabled && arrayList.contains(a0Var)) {
                    throw new IllegalArgumentException("this scrap item already exists");
                }
                a0Var.resetInternal();
                arrayList.add(a0Var);
            }
        }

        public long l(long j11, long j12) {
            return j11 == 0 ? j12 : ((j11 / 4) * 3) + (j12 / 4);
        }

        public void m(int i11, int i12) {
            a aVarI = i(i11);
            aVarI.f12553b = i12;
            ArrayList<a0> arrayList = aVarI.f12552a;
            while (arrayList.size() > i12) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public boolean n(int i11, long j11, long j12) {
            long j13 = i(i11).f12555d;
            return j13 == 0 || j11 + j13 < j12;
        }

        public boolean o(int i11, long j11, long j12) {
            long j13 = i(i11).f12554c;
            return j13 == 0 || j11 + j13 < j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<a0> f12556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<a0> f12557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<a0> f12558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<a0> f12559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12560e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12561f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public s f12562g;

        public t() {
            ArrayList<a0> arrayList = new ArrayList<>();
            this.f12556a = arrayList;
            this.f12557b = null;
            this.f12558c = new ArrayList<>();
            this.f12559d = Collections.unmodifiableList(arrayList);
            this.f12560e = 2;
            this.f12561f = 2;
        }

        public void A() {
            for (int i11 = 0; i11 < this.f12558c.size(); i11++) {
                k3.a.b(this.f12558c.get(i11).itemView);
            }
            B(RecyclerView.this.mAdapter);
        }

        public final void B(Adapter<?> adapter) {
            C(adapter, false);
        }

        public final void C(Adapter<?> adapter, boolean z11) {
            s sVar = this.f12562g;
            if (sVar != null) {
                sVar.e(adapter, z11);
            }
        }

        public void D(View view) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            H(childViewHolderInt);
        }

        public void E() {
            for (int size = this.f12558c.size() - 1; size >= 0; size--) {
                F(size);
            }
            this.f12558c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.b();
            }
        }

        public void F(int i11) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Recycling cached view at index ");
                sb2.append(i11);
            }
            a0 a0Var = this.f12558c.get(i11);
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("CachedViewHolder to be recycled: ");
                sb3.append(a0Var);
            }
            a(a0Var, true);
            this.f12558c.remove(i11);
        }

        public void G(@NonNull View view) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            H(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
        }

        public void H(a0 a0Var) {
            boolean z11;
            boolean z12 = false;
            boolean z13 = true;
            if (a0Var.isScrap() || a0Var.itemView.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(a0Var.isScrap());
                sb2.append(" isAttached:");
                sb2.append(a0Var.itemView.getParent() != null);
                sb2.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb2.toString());
            }
            if (a0Var.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + a0Var + RecyclerView.this.exceptionLabel());
            }
            if (a0Var.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
            boolean zDoesTransientStatePreventRecycling = a0Var.doesTransientStatePreventRecycling();
            Adapter adapter = RecyclerView.this.mAdapter;
            boolean z14 = adapter != null && zDoesTransientStatePreventRecycling && adapter.onFailedToRecycleView(a0Var);
            if (RecyclerView.sDebugAssertionsEnabled && this.f12558c.contains(a0Var)) {
                throw new IllegalArgumentException("cached view received recycle internal? " + a0Var + RecyclerView.this.exceptionLabel());
            }
            if (z14 || a0Var.isRecyclable()) {
                if (this.f12561f <= 0 || a0Var.hasAnyOfTheFlags(526)) {
                    z11 = false;
                } else {
                    int size = this.f12558c.size();
                    if (size >= this.f12561f && size > 0) {
                        F(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.d(a0Var.mPosition)) {
                        int i11 = size - 1;
                        while (i11 >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.d(this.f12558c.get(i11).mPosition)) {
                                break;
                            } else {
                                i11--;
                            }
                        }
                        size = i11 + 1;
                    }
                    this.f12558c.add(size, a0Var);
                    z11 = true;
                }
                if (z11) {
                    z12 = z11;
                } else {
                    a(a0Var, true);
                    z12 = z11;
                }
                RecyclerView.this.mViewInfoStore.q(a0Var);
                if (z12 && !z13 && zDoesTransientStatePreventRecycling) {
                    k3.a.b(a0Var.itemView);
                    a0Var.mBindingAdapter = null;
                    a0Var.mOwnerRecyclerView = null;
                    return;
                }
                return;
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists");
                sb3.append(RecyclerView.this.exceptionLabel());
            }
            z13 = false;
            RecyclerView.this.mViewInfoStore.q(a0Var);
            if (z12) {
            }
        }

        public void I(View view) {
            a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f12557b == null) {
                    this.f12557b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f12557b.add(childViewHolderInt);
                return;
            }
            if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f12556a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        public void J(s sVar) {
            B(RecyclerView.this.mAdapter);
            s sVar2 = this.f12562g;
            if (sVar2 != null) {
                sVar2.d();
            }
            this.f12562g = sVar;
            if (sVar != null && RecyclerView.this.getAdapter() != null) {
                this.f12562g.a();
            }
            u();
        }

        public void K(z zVar) {
        }

        public void L(int i11) {
            this.f12560e = i11;
            P();
        }

        public final boolean M(@NonNull a0 a0Var, int i11, int i12, long j11) {
            a0Var.mBindingAdapter = null;
            a0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = a0Var.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z11 = false;
            if (j11 != Long.MAX_VALUE && !this.f12562g.n(itemViewType, nanoTime, j11)) {
                return false;
            }
            if (a0Var.isTmpDetached()) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.attachViewToParent(a0Var.itemView, recyclerView.getChildCount(), a0Var.itemView.getLayoutParams());
                z11 = true;
            }
            RecyclerView.this.mAdapter.bindViewHolder(a0Var, i11);
            if (z11) {
                RecyclerView.this.detachViewFromParent(a0Var.itemView);
            }
            this.f12562g.f(a0Var.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(a0Var);
            if (RecyclerView.this.mState.e()) {
                a0Var.mPreLayoutPosition = i12;
            }
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:102:0x0217 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:104:0x021a  */
        /* JADX WARN: Code duplicated, block: B:18:0x0037 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:19:0x0039  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:22:0x004e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0054  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x005f  */
        /* JADX WARN: Code duplicated, block: B:61:0x010d A[PHI: r1 r4
  0x010d: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$a0) = (r1v11 androidx.recyclerview.widget.RecyclerView$a0), (r1v32 androidx.recyclerview.widget.RecyclerView$a0) binds: [B:28:0x005d, B:48:0x00c3] A[DONT_GENERATE, DONT_INLINE]
  0x010d: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:48:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:71:0x0166  */
        /* JADX WARN: Code duplicated, block: B:77:0x0192  */
        /* JADX WARN: Code duplicated, block: B:79:0x0198  */
        /* JADX WARN: Code duplicated, block: B:87:0x01ab  */
        /* JADX WARN: Code duplicated, block: B:95:0x01ed  */
        /* JADX WARN: Code duplicated, block: B:96:0x01fb  */
        /* JADX WARN: Code duplicated, block: B:98:0x0203  */
        /* JADX WARN: Code duplicated, block: B:99:0x0211  */
        @Nullable
        public a0 N(int i11, boolean z11, long j11) {
            a0 a0VarL;
            boolean z12;
            a0 a0Var;
            boolean z13;
            boolean zM;
            ViewGroup.LayoutParams layoutParams;
            n nVar;
            int iM;
            RecyclerView recyclerViewFindNestedRecyclerView;
            if (i11 < 0 || i11 >= RecyclerView.this.mState.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i11 + "(" + i11 + "). Item count:" + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
            }
            if (RecyclerView.this.mState.e()) {
                a0VarL = h(i11);
                z12 = a0VarL != null;
                if (a0VarL == null && (a0VarL = m(i11, z11)) != null) {
                    if (Q(a0VarL)) {
                        z12 = true;
                    } else {
                        if (!z11) {
                            a0VarL.addFlags(4);
                            if (a0VarL.isScrap()) {
                                RecyclerView.this.removeDetachedView(a0VarL.itemView, false);
                                a0VarL.unScrap();
                            } else if (a0VarL.wasReturnedFromScrap()) {
                                a0VarL.clearReturnedFromScrapFlag();
                            }
                            H(a0VarL);
                        }
                        a0VarL = null;
                    }
                }
                if (a0VarL == null) {
                    a0Var = a0VarL;
                } else {
                    iM = RecyclerView.this.mAdapterHelper.m(i11);
                    if (iM >= 0 || iM >= RecyclerView.this.mAdapter.getItemCount()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i11 + "(offset:" + iM + ").state:" + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
                    }
                    int itemViewType = RecyclerView.this.mAdapter.getItemViewType(iM);
                    if (RecyclerView.this.mAdapter.hasStableIds() && (a0VarL = l(RecyclerView.this.mAdapter.getItemId(iM), itemViewType, z11)) != null) {
                        a0VarL.mPosition = iM;
                        z12 = true;
                    }
                    if (a0VarL == null) {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("tryGetViewHolderForPositionByDeadline(");
                            sb2.append(i11);
                            sb2.append(") fetching from shared pool");
                        }
                        a0 a0VarH = i().h(itemViewType);
                        if (a0VarH != null) {
                            a0VarH.resetInternal();
                            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                r(a0VarH);
                            }
                        }
                        a0VarL = a0VarH;
                    }
                    if (a0VarL == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j11 != Long.MAX_VALUE && !this.f12562g.o(itemViewType, nanoTime, j11)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        a0 a0VarCreateViewHolder = recyclerView.mAdapter.createViewHolder(recyclerView, itemViewType);
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && (recyclerViewFindNestedRecyclerView = RecyclerView.findNestedRecyclerView(a0VarCreateViewHolder.itemView)) != null) {
                            a0VarCreateViewHolder.mNestedRecyclerView = new WeakReference<>(recyclerViewFindNestedRecyclerView);
                        }
                        this.f12562g.g(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                        int i12 = RecyclerView.HORIZONTAL;
                        a0Var = a0VarCreateViewHolder;
                    } else {
                        a0Var = a0VarL;
                    }
                }
                z13 = z12;
                if (z13 && !RecyclerView.this.mState.e() && a0Var.hasAnyOfTheFlags(8192)) {
                    a0Var.setFlags(0, 8192);
                    if (RecyclerView.this.mState.f12590k) {
                        int iBuildAdapterChangeFlagsForAnimations = j.buildAdapterChangeFlagsForAnimations(a0Var) | 4096;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(a0Var, recyclerView2.mItemAnimator.recordPreLayoutInformation(recyclerView2.mState, a0Var, iBuildAdapterChangeFlagsForAnimations, a0Var.getUnmodifiedPayloads()));
                    }
                }
                if (RecyclerView.this.mState.e() || !a0Var.isBound()) {
                    if (a0Var.isBound() || a0Var.needsUpdate() || a0Var.isInvalid()) {
                        if (!RecyclerView.sDebugAssertionsEnabled && a0Var.isRemoved()) {
                            throw new IllegalStateException("Removed holder should be bound and it should come here only in pre-layout. Holder: " + a0Var + RecyclerView.this.exceptionLabel());
                        }
                        zM = M(a0Var, RecyclerView.this.mAdapterHelper.m(i11), i11, j11);
                    }
                    layoutParams = a0Var.itemView.getLayoutParams();
                    if (layoutParams == null) {
                        nVar = (n) RecyclerView.this.generateDefaultLayoutParams();
                        a0Var.itemView.setLayoutParams(nVar);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        nVar = (n) layoutParams;
                    } else {
                        nVar = (n) RecyclerView.this.generateLayoutParams(layoutParams);
                        a0Var.itemView.setLayoutParams(nVar);
                    }
                    nVar.mViewHolder = a0Var;
                    nVar.mPendingInvalidate = !z13 && zM;
                    return a0Var;
                }
                a0Var.mPreLayoutPosition = i11;
                zM = false;
                layoutParams = a0Var.itemView.getLayoutParams();
                if (layoutParams == null) {
                    nVar = (n) RecyclerView.this.generateDefaultLayoutParams();
                    a0Var.itemView.setLayoutParams(nVar);
                } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                    nVar = (n) RecyclerView.this.generateLayoutParams(layoutParams);
                    a0Var.itemView.setLayoutParams(nVar);
                } else {
                    nVar = (n) layoutParams;
                }
                nVar.mViewHolder = a0Var;
                nVar.mPendingInvalidate = !z13 && zM;
                return a0Var;
            }
            a0VarL = null;
            if (a0VarL == null) {
                if (Q(a0VarL)) {
                    if (!z11) {
                        a0VarL.addFlags(4);
                        if (a0VarL.isScrap()) {
                            RecyclerView.this.removeDetachedView(a0VarL.itemView, false);
                            a0VarL.unScrap();
                        } else if (a0VarL.wasReturnedFromScrap()) {
                            a0VarL.clearReturnedFromScrapFlag();
                        }
                        H(a0VarL);
                    }
                    a0VarL = null;
                } else {
                    z12 = true;
                }
            }
            if (a0VarL == null) {
                iM = RecyclerView.this.mAdapterHelper.m(i11);
                if (iM >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i11 + "(offset:" + iM + ").state:" + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
            }
            a0Var = a0VarL;
            z13 = z12;
            if (z13) {
                a0Var.setFlags(0, 8192);
                if (RecyclerView.this.mState.f12590k) {
                    int iBuildAdapterChangeFlagsForAnimations2 = j.buildAdapterChangeFlagsForAnimations(a0Var) | 4096;
                    RecyclerView recyclerView3 = RecyclerView.this;
                    RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(a0Var, recyclerView3.mItemAnimator.recordPreLayoutInformation(recyclerView3.mState, a0Var, iBuildAdapterChangeFlagsForAnimations2, a0Var.getUnmodifiedPayloads()));
                }
            }
            if (RecyclerView.this.mState.e()) {
                if (a0Var.isBound()) {
                }
                if (!RecyclerView.sDebugAssertionsEnabled) {
                }
                zM = M(a0Var, RecyclerView.this.mAdapterHelper.m(i11), i11, j11);
            } else {
                if (a0Var.isBound()) {
                }
                if (!RecyclerView.sDebugAssertionsEnabled) {
                }
                zM = M(a0Var, RecyclerView.this.mAdapterHelper.m(i11), i11, j11);
            }
            layoutParams = a0Var.itemView.getLayoutParams();
            if (layoutParams == null) {
                nVar = (n) RecyclerView.this.generateDefaultLayoutParams();
                a0Var.itemView.setLayoutParams(nVar);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                nVar = (n) RecyclerView.this.generateLayoutParams(layoutParams);
                a0Var.itemView.setLayoutParams(nVar);
            } else {
                nVar = (n) layoutParams;
            }
            nVar.mViewHolder = a0Var;
            nVar.mPendingInvalidate = !z13 && zM;
            return a0Var;
        }

        public void O(a0 a0Var) {
            if (a0Var.mInChangeScrap) {
                this.f12557b.remove(a0Var);
            } else {
                this.f12556a.remove(a0Var);
            }
            a0Var.mScrapContainer = null;
            a0Var.mInChangeScrap = false;
            a0Var.clearReturnedFromScrapFlag();
        }

        public void P() {
            m mVar = RecyclerView.this.mLayout;
            this.f12561f = this.f12560e + (mVar != null ? mVar.mPrefetchMaxCountObserved : 0);
            for (int size = this.f12558c.size() - 1; size >= 0 && this.f12558c.size() > this.f12561f; size--) {
                F(size);
            }
        }

        public boolean Q(a0 a0Var) {
            if (a0Var.isRemoved()) {
                if (!RecyclerView.sDebugAssertionsEnabled || RecyclerView.this.mState.e()) {
                    return RecyclerView.this.mState.e();
                }
                throw new IllegalStateException("should not receive a removed view unless it is pre layout" + RecyclerView.this.exceptionLabel());
            }
            int i11 = a0Var.mPosition;
            if (i11 >= 0 && i11 < RecyclerView.this.mAdapter.getItemCount()) {
                if (RecyclerView.this.mState.e() || RecyclerView.this.mAdapter.getItemViewType(a0Var.mPosition) == a0Var.getItemViewType()) {
                    return !RecyclerView.this.mAdapter.hasStableIds() || a0Var.getItemId() == RecyclerView.this.mAdapter.getItemId(a0Var.mPosition);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + a0Var + RecyclerView.this.exceptionLabel());
        }

        public void R(int i11, int i12) {
            int i13;
            int i14 = i12 + i11;
            for (int size = this.f12558c.size() - 1; size >= 0; size--) {
                a0 a0Var = this.f12558c.get(size);
                if (a0Var != null && (i13 = a0Var.mPosition) >= i11 && i13 < i14) {
                    a0Var.addFlags(2);
                    F(size);
                }
            }
        }

        public void a(@NonNull a0 a0Var, boolean z11) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(a0Var);
            View view = a0Var.itemView;
            androidx.recyclerview.widget.n nVar = RecyclerView.this.mAccessibilityDelegate;
            if (nVar != null) {
                AccessibilityDelegateCompat accessibilityDelegateCompatA = nVar.a();
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompatA instanceof androidx.recyclerview.widget.n.a ? ((androidx.recyclerview.widget.n.a) accessibilityDelegateCompatA).a(view) : null);
            }
            if (z11) {
                g(a0Var);
            }
            a0Var.mBindingAdapter = null;
            a0Var.mOwnerRecyclerView = null;
            i().k(a0Var);
        }

        public final void b(a0 a0Var) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = a0Var.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                androidx.recyclerview.widget.n nVar = RecyclerView.this.mAccessibilityDelegate;
                if (nVar == null) {
                    return;
                }
                AccessibilityDelegateCompat accessibilityDelegateCompatA = nVar.a();
                if (accessibilityDelegateCompatA instanceof androidx.recyclerview.widget.n.a) {
                    ((androidx.recyclerview.widget.n.a) accessibilityDelegateCompatA).b(view);
                }
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompatA);
            }
        }

        public void c() {
            this.f12556a.clear();
            E();
        }

        public void d() {
            int size = this.f12558c.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f12558c.get(i11).clearOldPosition();
            }
            int size2 = this.f12556a.size();
            for (int i12 = 0; i12 < size2; i12++) {
                this.f12556a.get(i12).clearOldPosition();
            }
            ArrayList<a0> arrayList = this.f12557b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i13 = 0; i13 < size3; i13++) {
                    this.f12557b.get(i13).clearOldPosition();
                }
            }
        }

        public void e() {
            this.f12556a.clear();
            ArrayList<a0> arrayList = this.f12557b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i11) {
            if (i11 >= 0 && i11 < RecyclerView.this.mState.b()) {
                return !RecyclerView.this.mState.e() ? i11 : RecyclerView.this.mAdapterHelper.m(i11);
            }
            throw new IndexOutOfBoundsException("invalid position " + i11 + ". State item count is " + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
        }

        public void g(@NonNull a0 a0Var) {
            u uVar = RecyclerView.this.mRecyclerListener;
            if (uVar != null) {
                uVar.a(a0Var);
            }
            int size = RecyclerView.this.mRecyclerListeners.size();
            for (int i11 = 0; i11 < size; i11++) {
                RecyclerView.this.mRecyclerListeners.get(i11).a(a0Var);
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter != null) {
                adapter.onViewRecycled(a0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.q(a0Var);
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("dispatchViewRecycled: ");
                sb2.append(a0Var);
            }
        }

        public a0 h(int i11) {
            int size;
            int iM;
            ArrayList<a0> arrayList = this.f12557b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i12 = 0; i12 < size; i12++) {
                    a0 a0Var = this.f12557b.get(i12);
                    if (!a0Var.wasReturnedFromScrap() && a0Var.getLayoutPosition() == i11) {
                        a0Var.addFlags(32);
                        return a0Var;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (iM = RecyclerView.this.mAdapterHelper.m(i11)) > 0 && iM < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(iM);
                    for (int i13 = 0; i13 < size; i13++) {
                        a0 a0Var2 = this.f12557b.get(i13);
                        if (!a0Var2.wasReturnedFromScrap() && a0Var2.getItemId() == itemId) {
                            a0Var2.addFlags(32);
                            return a0Var2;
                        }
                    }
                }
            }
            return null;
        }

        public s i() {
            if (this.f12562g == null) {
                this.f12562g = new s();
                u();
            }
            return this.f12562g;
        }

        public int j() {
            return this.f12556a.size();
        }

        @NonNull
        public List<a0> k() {
            return this.f12559d;
        }

        public a0 l(long j11, int i11, boolean z11) {
            for (int size = this.f12556a.size() - 1; size >= 0; size--) {
                a0 a0Var = this.f12556a.get(size);
                if (a0Var.getItemId() == j11 && !a0Var.wasReturnedFromScrap()) {
                    if (i11 == a0Var.getItemViewType()) {
                        a0Var.addFlags(32);
                        if (a0Var.isRemoved() && !RecyclerView.this.mState.e()) {
                            a0Var.setFlags(2, 14);
                        }
                        return a0Var;
                    }
                    if (!z11) {
                        this.f12556a.remove(size);
                        RecyclerView.this.removeDetachedView(a0Var.itemView, false);
                        D(a0Var.itemView);
                    }
                }
            }
            int size2 = this.f12558c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                a0 a0Var2 = this.f12558c.get(size2);
                if (a0Var2.getItemId() == j11 && !a0Var2.isAttachedToTransitionOverlay()) {
                    if (i11 == a0Var2.getItemViewType()) {
                        if (!z11) {
                            this.f12558c.remove(size2);
                        }
                        return a0Var2;
                    }
                    if (!z11) {
                        F(size2);
                        return null;
                    }
                }
            }
        }

        public a0 m(int i11, boolean z11) {
            View viewE;
            int size = this.f12556a.size();
            for (int i12 = 0; i12 < size; i12++) {
                a0 a0Var = this.f12556a.get(i12);
                if (!a0Var.wasReturnedFromScrap() && a0Var.getLayoutPosition() == i11 && !a0Var.isInvalid() && (RecyclerView.this.mState.f12587h || !a0Var.isRemoved())) {
                    a0Var.addFlags(32);
                    return a0Var;
                }
            }
            if (!z11 && (viewE = RecyclerView.this.mChildHelper.e(i11)) != null) {
                a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(viewE);
                RecyclerView.this.mChildHelper.s(viewE);
                int iM = RecyclerView.this.mChildHelper.m(viewE);
                if (iM != -1) {
                    RecyclerView.this.mChildHelper.d(iM);
                    I(viewE);
                    childViewHolderInt.addFlags(8224);
                    return childViewHolderInt;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
            }
            int size2 = this.f12558c.size();
            for (int i13 = 0; i13 < size2; i13++) {
                a0 a0Var2 = this.f12558c.get(i13);
                if (!a0Var2.isInvalid() && a0Var2.getLayoutPosition() == i11 && !a0Var2.isAttachedToTransitionOverlay()) {
                    if (!z11) {
                        this.f12558c.remove(i13);
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("getScrapOrHiddenOrCachedHolderForPosition(");
                        sb2.append(i11);
                        sb2.append(") found match in cache: ");
                        sb2.append(a0Var2);
                    }
                    return a0Var2;
                }
            }
            return null;
        }

        public View n(int i11) {
            return this.f12556a.get(i11).itemView;
        }

        @NonNull
        public View o(int i11) {
            return p(i11, false);
        }

        public View p(int i11, boolean z11) {
            return N(i11, z11, Long.MAX_VALUE).itemView;
        }

        public final void q(ViewGroup viewGroup, boolean z11) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z11) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public final void r(a0 a0Var) {
            View view = a0Var.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        public void s() {
            int size = this.f12558c.size();
            for (int i11 = 0; i11 < size; i11++) {
                n nVar = (n) this.f12558c.get(i11).itemView.getLayoutParams();
                if (nVar != null) {
                    nVar.mInsetsDirty = true;
                }
            }
        }

        public void t() {
            int size = this.f12558c.size();
            for (int i11 = 0; i11 < size; i11++) {
                a0 a0Var = this.f12558c.get(i11);
                if (a0Var != null) {
                    a0Var.addFlags(6);
                    a0Var.addChangePayload(null);
                }
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter == null || !adapter.hasStableIds()) {
                E();
            }
        }

        public final void u() {
            if (this.f12562g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mAdapter == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                this.f12562g.b(RecyclerView.this.mAdapter);
            }
        }

        public void v(int i11, int i12) {
            int size = this.f12558c.size();
            for (int i13 = 0; i13 < size; i13++) {
                a0 a0Var = this.f12558c.get(i13);
                if (a0Var != null && a0Var.mPosition >= i11) {
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("offsetPositionRecordsForInsert cached ");
                        sb2.append(i13);
                        sb2.append(" holder ");
                        sb2.append(a0Var);
                        sb2.append(" now at position ");
                        sb2.append(a0Var.mPosition + i12);
                    }
                    a0Var.offsetPosition(i12, false);
                }
            }
        }

        public void w(int i11, int i12) {
            int i13;
            int i14;
            int i15;
            int i16;
            if (i11 < i12) {
                i13 = -1;
                i15 = i11;
                i14 = i12;
            } else {
                i13 = 1;
                i14 = i11;
                i15 = i12;
            }
            int size = this.f12558c.size();
            for (int i17 = 0; i17 < size; i17++) {
                a0 a0Var = this.f12558c.get(i17);
                if (a0Var != null && (i16 = a0Var.mPosition) >= i15 && i16 <= i14) {
                    if (i16 == i11) {
                        a0Var.offsetPosition(i12 - i11, false);
                    } else {
                        a0Var.offsetPosition(i13, false);
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("offsetPositionRecordsForMove cached child ");
                        sb2.append(i17);
                        sb2.append(" holder ");
                        sb2.append(a0Var);
                    }
                }
            }
        }

        public void x(int i11, int i12, boolean z11) {
            int i13 = i11 + i12;
            for (int size = this.f12558c.size() - 1; size >= 0; size--) {
                a0 a0Var = this.f12558c.get(size);
                if (a0Var != null) {
                    int i14 = a0Var.mPosition;
                    if (i14 >= i13) {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("offsetPositionRecordsForRemove cached ");
                            sb2.append(size);
                            sb2.append(" holder ");
                            sb2.append(a0Var);
                            sb2.append(" now at position ");
                            sb2.append(a0Var.mPosition - i12);
                        }
                        a0Var.offsetPosition(-i12, z11);
                    } else if (i14 >= i11) {
                        a0Var.addFlags(8);
                        F(size);
                    }
                }
            }
        }

        public void y(Adapter<?> adapter, Adapter<?> adapter2, boolean z11) {
            c();
            C(adapter, true);
            i().j(adapter, adapter2, z11);
            u();
        }

        public void z() {
            u();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface u {
        void a(@NonNull a0 a0Var);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class v extends g {
        public v() {
        }

        public void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f12586g = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeChanged(int i11, int i12, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.r(i11, i12, obj)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeInserted(int i11, int i12) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.s(i11, i12)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeMoved(int i11, int i12, int i13) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.t(i11, i12, i13)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeRemoved(int i11, int i12) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.u(i11, i12)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onStateRestorationPolicyChanged() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState == null || (adapter = recyclerView.mAdapter) == null || !adapter.canRestoreState()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class w {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f12566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public m f12567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12569e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f12570f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12572h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12565a = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f12571g = new a(0, 0);

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f12573a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f12574b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f12575c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f12576d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Interpolator f12577e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f12578f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f12579g;

            public a(int i11, int i12) {
                this(i11, i12, Integer.MIN_VALUE, null);
            }

            public a(int i11, int i12, int i13, @Nullable Interpolator interpolator) {
                this.f12576d = -1;
                this.f12578f = false;
                this.f12579g = 0;
                this.f12573a = i11;
                this.f12574b = i12;
                this.f12575c = i13;
                this.f12577e = interpolator;
            }

            public boolean a() {
                return this.f12576d >= 0;
            }

            public void b(int i11) {
                this.f12576d = i11;
            }

            public void c(RecyclerView recyclerView) {
                int i11 = this.f12576d;
                if (i11 >= 0) {
                    this.f12576d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i11);
                    this.f12578f = false;
                } else {
                    if (!this.f12578f) {
                        this.f12579g = 0;
                        return;
                    }
                    e();
                    recyclerView.mViewFlinger.smoothScrollBy(this.f12573a, this.f12574b, this.f12575c, this.f12577e);
                    int i12 = this.f12579g + 1;
                    this.f12579g = i12;
                    if (i12 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f12578f = false;
                }
            }

            public void d(int i11, int i12, int i13, @Nullable Interpolator interpolator) {
                this.f12573a = i11;
                this.f12574b = i12;
                this.f12575c = i13;
                this.f12577e = interpolator;
                this.f12578f = true;
            }

            public final void e() {
                if (this.f12577e != null && this.f12575c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f12575c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }
        }

        /* JADX INFO: compiled from: source.java */
        public interface b {
            @Nullable
            PointF computeScrollVectorForPosition(int i11);
        }

        @Nullable
        public PointF a(int i11) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).computeScrollVectorForPosition(i11);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i11) {
            return this.f12566b.mLayout.findViewByPosition(i11);
        }

        public int c() {
            return this.f12566b.mLayout.getChildCount();
        }

        public int d(View view) {
            return this.f12566b.getChildLayoutPosition(view);
        }

        @Nullable
        public m e() {
            return this.f12567c;
        }

        public int f() {
            return this.f12565a;
        }

        public boolean g() {
            return this.f12568d;
        }

        public boolean h() {
            return this.f12569e;
        }

        public void i(@NonNull PointF pointF) {
            float f11 = pointF.x;
            float f12 = pointF.y;
            float fSqrt = (float) Math.sqrt((f11 * f11) + (f12 * f12));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public void j(int i11, int i12) {
            PointF pointFA;
            RecyclerView recyclerView = this.f12566b;
            if (this.f12565a == -1 || recyclerView == null) {
                r();
            }
            if (this.f12568d && this.f12570f == null && this.f12567c != null && (pointFA = a(this.f12565a)) != null) {
                float f11 = pointFA.x;
                if (f11 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f11), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f12568d = false;
            View view = this.f12570f;
            if (view != null) {
                if (d(view) == this.f12565a) {
                    o(this.f12570f, recyclerView.mState, this.f12571g);
                    this.f12571g.c(recyclerView);
                    r();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f12570f = null;
                }
            }
            if (this.f12569e) {
                l(i11, i12, recyclerView.mState, this.f12571g);
                boolean zA = this.f12571g.a();
                this.f12571g.c(recyclerView);
                if (zA && this.f12569e) {
                    this.f12568d = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        public void k(View view) {
            if (d(view) == f()) {
                this.f12570f = view;
                int i11 = RecyclerView.HORIZONTAL;
            }
        }

        public abstract void l(int i11, int i12, @NonNull x xVar, @NonNull a aVar);

        public abstract void m();

        public abstract void n();

        public abstract void o(@NonNull View view, @NonNull x xVar, @NonNull a aVar);

        public void p(int i11) {
            this.f12565a = i11;
        }

        public void q(RecyclerView recyclerView, m mVar) {
            recyclerView.mViewFlinger.stop();
            if (this.f12572h) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f12566b = recyclerView;
            this.f12567c = mVar;
            int i11 = this.f12565a;
            if (i11 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.f12580a = i11;
            this.f12569e = true;
            this.f12568d = true;
            this.f12570f = b(f());
            m();
            this.f12566b.mViewFlinger.postOnAnimation();
            this.f12572h = true;
        }

        public final void r() {
            if (this.f12569e) {
                this.f12569e = false;
                n();
                this.f12566b.mState.f12580a = -1;
                this.f12570f = null;
                this.f12565a = -1;
                this.f12568d = false;
                this.f12567c.onSmoothScrollerStopped(this);
                this.f12567c = null;
                this.f12566b = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class x {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray<Object> f12581b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f12592m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f12593n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f12594o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f12595p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f12596q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12580a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12582c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12583d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12584e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12585f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f12586g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12587h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f12588i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f12589j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f12590k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f12591l = false;

        public void a(int i11) {
            if ((this.f12584e & i11) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i11) + " but it is " + Integer.toBinaryString(this.f12584e));
        }

        public int b() {
            return this.f12587h ? this.f12582c - this.f12583d : this.f12585f;
        }

        public int c() {
            return this.f12580a;
        }

        public boolean d() {
            return this.f12580a != -1;
        }

        public boolean e() {
            return this.f12587h;
        }

        public void f(Adapter adapter) {
            this.f12584e = 1;
            this.f12585f = adapter.getItemCount();
            this.f12587h = false;
            this.f12588i = false;
            this.f12589j = false;
        }

        public boolean g() {
            return this.f12591l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f12580a + ", mData=" + this.f12581b + ", mItemCount=" + this.f12585f + ", mIsMeasuring=" + this.f12589j + ", mPreviousLayoutItemCount=" + this.f12582c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f12583d + ", mStructureChanged=" + this.f12586g + ", mInPreLayout=" + this.f12587h + ", mRunSimpleAnimations=" + this.f12590k + ", mRunPredictiveAnimations=" + this.f12591l + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class y extends i {
        @Override // androidx.recyclerview.widget.RecyclerView.i
        @NonNull
        public EdgeEffect a(@NonNull RecyclerView recyclerView, int i11) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class z {
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = i11 >= 23;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new a();
        sDefaultEdgeEffectFactory = new y();
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mObserver = new v();
        this.mRecycler = new t();
        this.mViewInfoStore = new androidx.recyclerview.widget.t();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.mIsAttached) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.mLayoutSuppressed) {
                    recyclerView2.mLayoutWasDefered = true;
                } else {
                    recyclerView2.consumePendingUpdateOperations();
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = sDefaultEdgeEffectFactory;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.a() : null;
        this.mState = new x();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new k();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                j jVar = RecyclerView.this.mItemAnimator;
                if (jVar != null) {
                    jVar.runPendingAnimations();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new b();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.n(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.recyclerview.R.styleable.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i11, 0);
        String string = typedArrayObtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z11;
        if (z11) {
            initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i11, 0);
        int[] iArr = NESTED_SCROLLING_ATTRS;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i11, 0);
        boolean z12 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z12);
        k3.a.h(this, true);
    }

    private void addAnimatingView(a0 a0Var) {
        View view = a0Var.itemView;
        boolean z11 = view.getParent() == this;
        this.mRecycler.O(getChildViewHolder(view));
        if (a0Var.isTmpDetached()) {
            this.mChildHelper.c(view, -1, view.getLayoutParams(), true);
        } else if (z11) {
            this.mChildHelper.k(view);
        } else {
            this.mChildHelper.b(view, true);
        }
    }

    private void animateChange(@NonNull a0 a0Var, @NonNull a0 a0Var2, @NonNull j.c cVar, @NonNull j.c cVar2, boolean z11, boolean z12) {
        a0Var.setIsRecyclable(false);
        if (z11) {
            addAnimatingView(a0Var);
        }
        if (a0Var != a0Var2) {
            if (z12) {
                addAnimatingView(a0Var2);
            }
            a0Var.mShadowedHolder = a0Var2;
            addAnimatingView(a0Var);
            this.mRecycler.O(a0Var);
            a0Var2.setIsRecyclable(false);
            a0Var2.mShadowingHolder = a0Var;
        }
        if (this.mItemAnimator.animateChange(a0Var, a0Var2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(@NonNull a0 a0Var) {
        WeakReference<RecyclerView> weakReference = a0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == a0Var.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            a0Var.mNestedRecyclerView = null;
        }
    }

    private int consumeFlingInStretch(int i11, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i12) {
        if (i11 > 0 && edgeEffect != null && androidx.core.widget.g.b(edgeEffect) != 0.0f) {
            int iRound = Math.round(((-i12) / FLING_DESTRETCH_FACTOR) * androidx.core.widget.g.d(edgeEffect, ((-i11) * FLING_DESTRETCH_FACTOR) / i12, 0.5f));
            if (iRound != i11) {
                edgeEffect.finish();
            }
            return i11 - iRound;
        }
        if (i11 >= 0 || edgeEffect2 == null || androidx.core.widget.g.b(edgeEffect2) == 0.0f) {
            return i11;
        }
        float f11 = i12;
        int iRound2 = Math.round((f11 / FLING_DESTRETCH_FACTOR) * androidx.core.widget.g.d(edgeEffect2, (i11 * FLING_DESTRETCH_FACTOR) / f11, 0.5f));
        if (iRound2 != i11) {
            edgeEffect2.finish();
        }
        return i11 - iRound2;
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i11, int i12) {
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(m.class);
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i11), Integer.valueOf(i12)};
                } catch (NoSuchMethodException e11) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    } catch (NoSuchMethodException e12) {
                        e12.initCause(e11);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e12);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((m) constructor.newInstance(objArr));
            } catch (ClassCastException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e13);
            } catch (ClassNotFoundException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e14);
            } catch (IllegalAccessException e15) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e15);
            } catch (InstantiationException e16) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e16);
            } catch (InvocationTargetException e17) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e17);
            }
        }
    }

    private boolean didChildRangeChange(int i11, int i12) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i11 && iArr[1] == i12) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i11 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i11 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(accessibilityEventObtain, i11);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f12589j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.f();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        x xVar = this.mState;
        xVar.f12588i = xVar.f12590k && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        xVar.f12587h = xVar.f12591l;
        xVar.f12585f = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f12590k) {
            int iG = this.mChildHelper.g();
            for (int i11 = 0; i11 < iG; i11++) {
                a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i11));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.e(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, j.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f12588i && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.c(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f12591l) {
            saveOldPositions();
            x xVar2 = this.mState;
            boolean z11 = xVar2.f12586g;
            xVar2.f12586g = false;
            this.mLayout.onLayoutChildren(this.mRecycler, xVar2);
            this.mState.f12586g = z11;
            for (int i12 = 0; i12 < this.mChildHelper.g(); i12++) {
                a0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.f(i12));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.i(childViewHolderInt2)) {
                    int iBuildAdapterChangeFlagsForAnimations = j.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!zHasAnyOfTheFlags) {
                        iBuildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    j.c cVarRecordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, iBuildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, cVarRecordPreLayoutInformation);
                    } else {
                        this.mViewInfoStore.a(childViewHolderInt2, cVarRecordPreLayoutInformation);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f12584e = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.j();
        this.mState.f12585f = this.mAdapter.getItemCount();
        this.mState.f12583d = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.mLayoutState;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        x xVar = this.mState;
        xVar.f12587h = false;
        this.mLayout.onLayoutChildren(this.mRecycler, xVar);
        x xVar2 = this.mState;
        xVar2.f12586g = false;
        xVar2.f12590k = xVar2.f12590k && this.mItemAnimator != null;
        xVar2.f12584e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        x xVar = this.mState;
        xVar.f12584e = 1;
        if (xVar.f12590k) {
            for (int iG = this.mChildHelper.g() - 1; iG >= 0; iG--) {
                a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(iG));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    j.c cVarRecordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    a0 a0VarG = this.mViewInfoStore.g(changedHolderKey);
                    if (a0VarG == null || a0VarG.shouldIgnore()) {
                        this.mViewInfoStore.d(childViewHolderInt, cVarRecordPostLayoutInformation);
                    } else {
                        boolean zH = this.mViewInfoStore.h(a0VarG);
                        boolean zH2 = this.mViewInfoStore.h(childViewHolderInt);
                        if (zH && a0VarG == childViewHolderInt) {
                            this.mViewInfoStore.d(childViewHolderInt, cVarRecordPostLayoutInformation);
                        } else {
                            j.c cVarN = this.mViewInfoStore.n(a0VarG);
                            this.mViewInfoStore.d(childViewHolderInt, cVarRecordPostLayoutInformation);
                            j.c cVarM = this.mViewInfoStore.m(childViewHolderInt);
                            if (cVarN == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, a0VarG);
                            } else {
                                animateChange(a0VarG, childViewHolderInt, cVarN, cVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            this.mViewInfoStore.o(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        x xVar2 = this.mState;
        xVar2.f12582c = xVar2.f12585f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        xVar2.f12590k = false;
        xVar2.f12591l = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<a0> arrayList = this.mRecycler.f12557b;
        if (arrayList != null) {
            arrayList.clear();
        }
        m mVar = this.mLayout;
        if (mVar.mPrefetchMaxObservedInInitialPrefetch) {
            mVar.mPrefetchMaxCountObserved = 0;
            mVar.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.P();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.f();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        q qVar = this.mInterceptingOnItemTouchListener;
        if (qVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        qVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i11 = 0; i11 < size; i11++) {
            q qVar = this.mOnItemTouchListeners.get(i11);
            if (qVar.b(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = qVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int iG = this.mChildHelper.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i12 = Integer.MIN_VALUE;
        for (int i13 = 0; i13 < iG; i13++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i13));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i11) {
                    i11 = layoutPosition;
                }
                if (layoutPosition > i12) {
                    i12 = layoutPosition;
                }
            }
        }
        iArr[0] = i11;
        iArr[1] = i12;
    }

    @Nullable
    public static RecyclerView findNestedRecyclerView(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i11));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    @Nullable
    private View findNextViewToFocus() {
        a0 a0VarFindViewHolderForAdapterPosition;
        x xVar = this.mState;
        int i11 = xVar.f12592m;
        if (i11 == -1) {
            i11 = 0;
        }
        int iB = xVar.b();
        for (int i12 = i11; i12 < iB; i12++) {
            a0 a0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i12);
            if (a0VarFindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (a0VarFindViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return a0VarFindViewHolderForAdapterPosition2.itemView;
            }
        }
        int iMin = Math.min(iB, i11);
        do {
            iMin--;
            if (iMin < 0 || (a0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!a0VarFindViewHolderForAdapterPosition.itemView.hasFocusable());
        return a0VarFindViewHolderForAdapterPosition.itemView;
    }

    public static a0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((n) view.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        n nVar = (n) view.getLayoutParams();
        Rect rect2 = nVar.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) nVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id2 = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            }
        }
        return id2;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(InstructionFileId.DOT)) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private float getSplineFlingDistance(int i11) {
        double dLog = Math.log((Math.abs(i11) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION));
        float f11 = DECELERATION_RATE;
        return (float) (((double) (this.mPhysicalCoef * SCROLL_FRICTION)) * Math.exp((((double) f11) / (((double) f11) - 1.0d)) * dLog));
    }

    private void handleMissingPreInfoForChangeError(long j11, a0 a0Var, a0 a0Var2) {
        int iG = this.mChildHelper.g();
        for (int i11 = 0; i11 < iG; i11++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i11));
            if (childViewHolderInt != a0Var && getChangedHolderKey(childViewHolderInt) == j11) {
                Adapter adapter = this.mAdapter;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + a0Var + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + a0Var + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + a0Var2 + " cannot be found but it is necessary for " + a0Var + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int iG = this.mChildHelper.g();
        for (int i11 = 0; i11 < iG; i11++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i11));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.e(new c());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i11) {
        int i12;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        byte b11 = -1;
        int i13 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i14 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i15 = rect2.left;
        if ((i14 < i15 || rect.right <= i15) && rect.right < rect2.right) {
            i12 = 1;
        } else {
            int i16 = rect.right;
            int i17 = rect2.right;
            i12 = ((i16 > i17 || i14 >= i17) && i14 > i15) ? -1 : 0;
        }
        int i18 = rect.top;
        int i19 = rect2.top;
        if ((i18 < i19 || rect.bottom <= i19) && rect.bottom < rect2.bottom) {
            b11 = 1;
        } else {
            int i21 = rect.bottom;
            int i22 = rect2.bottom;
            if ((i21 <= i22 && i18 < i22) || i18 <= i19) {
                b11 = 0;
            }
        }
        if (i11 == 1) {
            return b11 < 0 || (b11 == 0 && i12 * i13 < 0);
        }
        if (i11 == 2) {
            return b11 > 0 || (b11 == 0 && i12 * i13 > 0);
        }
        if (i11 == 17) {
            return i12 < 0;
        }
        if (i11 == 33) {
            return b11 < 0;
        }
        if (i11 == 66) {
            return i12 > 0;
        }
        if (i11 == 130) {
            return b11 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i11 + exceptionLabel());
    }

    private void nestedScrollByInternal(int i11, int i12, @Nullable MotionEvent motionEvent, int i13) {
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zCanScrollHorizontally = mVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        int i14 = zCanScrollVertically ? (zCanScrollHorizontally ? 1 : 0) | 2 : zCanScrollHorizontally ? 1 : 0;
        float height = motionEvent == null ? getHeight() / 2.0f : motionEvent.getY();
        float width = motionEvent == null ? getWidth() / 2.0f : motionEvent.getX();
        int iReleaseHorizontalGlow = i11 - releaseHorizontalGlow(i11, height);
        int iReleaseVerticalGlow = i12 - releaseVerticalGlow(i12, width);
        startNestedScroll(i14, i13);
        if (dispatchNestedPreScroll(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, this.mReusableIntPair, this.mScrollOffset, i13)) {
            int[] iArr2 = this.mReusableIntPair;
            iReleaseHorizontalGlow -= iArr2[0];
            iReleaseVerticalGlow -= iArr2[1];
        }
        scrollByInternal(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, motionEvent, i13);
        GapWorker gapWorker = this.mGapWorker;
        if (gapWorker != null && (iReleaseHorizontalGlow != 0 || iReleaseVerticalGlow != 0)) {
            gapWorker.postFromTraversal(this, iReleaseHorizontalGlow, iReleaseVerticalGlow);
        }
        stopNestedScroll(i13);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i11 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i11);
            int x11 = (int) (motionEvent.getX(i11) + 0.5f);
            this.mLastTouchX = x11;
            this.mInitialTouchX = x11;
            int y11 = (int) (motionEvent.getY(i11) + 0.5f);
            this.mLastTouchY = y11;
            this.mInitialTouchY = y11;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z11;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.y();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.w();
        } else {
            this.mAdapterHelper.j();
        }
        boolean z12 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f12590k = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z11 = this.mDataSetHasChangedAfterLayout) || z12 || this.mLayout.mRequestedSimpleAnimations) && (!z11 || this.mAdapter.hasStableIds());
        x xVar = this.mState;
        xVar.f12591l = xVar.f12590k && z12 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled();
    }

    private void pullGlows(float f11, float f12, float f13, float f14) {
        boolean z11 = true;
        if (f12 < 0.0f) {
            ensureLeftGlow();
            androidx.core.widget.g.d(this.mLeftGlow, (-f12) / getWidth(), 1.0f - (f13 / getHeight()));
        } else if (f12 > 0.0f) {
            ensureRightGlow();
            androidx.core.widget.g.d(this.mRightGlow, f12 / getWidth(), f13 / getHeight());
        } else {
            z11 = false;
        }
        if (f14 < 0.0f) {
            ensureTopGlow();
            androidx.core.widget.g.d(this.mTopGlow, (-f14) / getHeight(), f11 / getWidth());
        } else if (f14 > 0.0f) {
            ensureBottomGlow();
            androidx.core.widget.g.d(this.mBottomGlow, f14 / getHeight(), 1.0f - (f11 / getWidth()));
        } else if (!z11 && f12 == 0.0f && f14 == 0.0f) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.mChildHelper.n(focusedChild)) {
                    return;
                }
            } else if (this.mChildHelper.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewFindNextViewToFocus = null;
        a0 a0VarFindViewHolderForItemId = (this.mState.f12593n == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f12593n);
        if (a0VarFindViewHolderForItemId != null && !this.mChildHelper.n(a0VarFindViewHolderForItemId.itemView) && a0VarFindViewHolderForItemId.itemView.hasFocusable()) {
            viewFindNextViewToFocus = a0VarFindViewHolderForItemId.itemView;
        } else if (this.mChildHelper.g() > 0) {
            viewFindNextViewToFocus = findNextViewToFocus();
        }
        if (viewFindNextViewToFocus != null) {
            int i11 = this.mState.f12594o;
            if (i11 != -1 && (viewFindViewById = viewFindNextViewToFocus.findViewById(i11)) != null && viewFindViewById.isFocusable()) {
                viewFindNextViewToFocus = viewFindViewById;
            }
            viewFindNextViewToFocus.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private int releaseHorizontalGlow(int i11, float f11) {
        float height = f11 / getHeight();
        float width = i11 / getWidth();
        EdgeEffect edgeEffect = this.mLeftGlow;
        float f12 = 0.0f;
        if (edgeEffect == null || androidx.core.widget.g.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (edgeEffect2 != null && androidx.core.widget.g.b(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.mRightGlow.onRelease();
                } else {
                    float fD = androidx.core.widget.g.d(this.mRightGlow, width, height);
                    if (androidx.core.widget.g.b(this.mRightGlow) == 0.0f) {
                        this.mRightGlow.onRelease();
                    }
                    f12 = fD;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.mLeftGlow.onRelease();
            } else {
                float f13 = -androidx.core.widget.g.d(this.mLeftGlow, -width, 1.0f - height);
                if (androidx.core.widget.g.b(this.mLeftGlow) == 0.0f) {
                    this.mLeftGlow.onRelease();
                }
                f12 = f13;
            }
            invalidate();
        }
        return Math.round(f12 * getWidth());
    }

    private int releaseVerticalGlow(int i11, float f11) {
        float width = f11 / getWidth();
        float height = i11 / getHeight();
        EdgeEffect edgeEffect = this.mTopGlow;
        float f12 = 0.0f;
        if (edgeEffect == null || androidx.core.widget.g.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mBottomGlow;
            if (edgeEffect2 != null && androidx.core.widget.g.b(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.mBottomGlow.onRelease();
                } else {
                    float fD = androidx.core.widget.g.d(this.mBottomGlow, height, 1.0f - width);
                    if (androidx.core.widget.g.b(this.mBottomGlow) == 0.0f) {
                        this.mBottomGlow.onRelease();
                    }
                    f12 = fD;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.mTopGlow.onRelease();
            } else {
                float f13 = -androidx.core.widget.g.d(this.mTopGlow, -height, width);
                if (androidx.core.widget.g.b(this.mTopGlow) == 0.0f) {
                    this.mTopGlow.onRelease();
                }
                f12 = f13;
            }
            invalidate();
        }
        return Math.round(f12 * getHeight());
    }

    private void requestChildOnScreen(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof n) {
            n nVar = (n) layoutParams;
            if (!nVar.mInsetsDirty) {
                Rect rect = nVar.mDecorInsets;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        x xVar = this.mState;
        xVar.f12593n = -1L;
        xVar.f12592m = -1;
        xVar.f12594o = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        int absoluteAdapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        a0 a0VarFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (a0VarFindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f12593n = this.mAdapter.hasStableIds() ? a0VarFindContainingViewHolder.getItemId() : -1L;
        x xVar = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            absoluteAdapterPosition = -1;
        } else {
            absoluteAdapterPosition = a0VarFindContainingViewHolder.isRemoved() ? a0VarFindContainingViewHolder.mOldPosition : a0VarFindContainingViewHolder.getAbsoluteAdapterPosition();
        }
        xVar.f12592m = absoluteAdapterPosition;
        this.mState.f12594o = getDeepestFocusedViewWithId(a0VarFindContainingViewHolder.itemView);
    }

    private void setAdapterInternal(@Nullable Adapter<?> adapter, boolean z11, boolean z12) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z11 || z12) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.y();
        Adapter<?> adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.y(adapter3, this.mAdapter, z11);
        this.mState.f12586g = true;
    }

    public static void setDebugAssertionsEnabled(boolean z11) {
        sDebugAssertionsEnabled = z11;
    }

    public static void setVerboseLoggingEnabled(boolean z11) {
        sVerboseLoggingEnabled = z11;
    }

    private boolean shouldAbsorb(@NonNull EdgeEffect edgeEffect, int i11, int i12) {
        if (i11 > 0) {
            return true;
        }
        return getSplineFlingDistance(-i11) < androidx.core.widget.g.b(edgeEffect) * ((float) i12);
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z11;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || androidx.core.widget.g.b(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z11 = false;
        } else {
            androidx.core.widget.g.d(this.mLeftGlow, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
            z11 = true;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && androidx.core.widget.g.b(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
            androidx.core.widget.g.d(this.mRightGlow, 0.0f, motionEvent.getY() / getHeight());
            z11 = true;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && androidx.core.widget.g.b(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
            androidx.core.widget.g.d(this.mTopGlow, 0.0f, motionEvent.getX() / getWidth());
            z11 = true;
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 == null || androidx.core.widget.g.b(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z11;
        }
        androidx.core.widget.g.d(this.mBottomGlow, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.stopSmoothScroller();
        }
    }

    public void absorbGlows(int i11, int i12) {
        if (i11 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i11);
            }
        }
        if (i12 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i12);
            }
        } else if (i12 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i12);
            }
        }
        if (i11 == 0 && i12 == 0) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        m mVar = this.mLayout;
        if (mVar == null || !mVar.onAddFocusables(this, arrayList, i11, i12)) {
            super.addFocusables(arrayList, i11, i12);
        }
    }

    public void addItemDecoration(@NonNull l lVar) {
        addItemDecoration(lVar, -1);
    }

    public void addItemDecoration(@NonNull l lVar, int i11) {
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i11 < 0) {
            this.mItemDecorations.add(lVar);
        } else {
            this.mItemDecorations.add(i11, lVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(@NonNull o oVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(oVar);
    }

    public void addOnItemTouchListener(@NonNull q qVar) {
        this.mOnItemTouchListeners.add(qVar);
    }

    public void addOnScrollListener(@NonNull r rVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(rVar);
    }

    public void addRecyclerListener(@NonNull u uVar) {
        androidx.core.util.i.b(uVar != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(uVar);
    }

    public void animateAppearance(@NonNull a0 a0Var, @Nullable j.c cVar, @NonNull j.c cVar2) {
        a0Var.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(a0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(@NonNull a0 a0Var, @NonNull j.c cVar, @Nullable j.c cVar2) {
        addAnimatingView(a0Var);
        a0Var.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(a0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public boolean canReuseUpdatedViewHolder(a0 a0Var) {
        j jVar = this.mItemAnimator;
        return jVar == null || jVar.canReuseUpdatedViewHolder(a0Var, a0Var.getUnmodifiedPayloads());
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof n) && this.mLayout.checkLayoutParams((n) layoutParams);
    }

    public void clearOldPositions() {
        int iJ = this.mChildHelper.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.d();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<o> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<r> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i11, int i12) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i11 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i11 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i12 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i12 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public int consumeFlingInHorizontalStretch(int i11) {
        return consumeFlingInStretch(i11, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    public int consumeFlingInVerticalStretch(int i11) {
        return consumeFlingInStretch(i11, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            androidx.core.os.r.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            androidx.core.os.r.b();
            return;
        }
        if (this.mAdapterHelper.p()) {
            if (!this.mAdapterHelper.o(4) || this.mAdapterHelper.o(11)) {
                if (this.mAdapterHelper.p()) {
                    androidx.core.os.r.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    androidx.core.os.r.b();
                    return;
                }
                return;
            }
            androidx.core.os.r.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.w();
            if (!this.mLayoutWasDefered) {
                if (hasUpdatedView()) {
                    dispatchLayout();
                } else {
                    this.mAdapterHelper.i();
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            androidx.core.os.r.b();
        }
    }

    public void defaultOnMeasure(int i11, int i12) {
        setMeasuredDimension(m.chooseSize(i11, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), m.chooseSize(i12, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    public void dispatchChildAttached(View view) {
        a0 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<o> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        a0 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<o> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        this.mState.f12589j = false;
        boolean z11 = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.f12584e == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else if (this.mAdapterHelper.q() || z11 || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
        }
        dispatchLayoutStep3();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        return getScrollingChildHelper().dispatchNestedFling(f11, f12, z11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f11, float f12) {
        return getScrollingChildHelper().dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i11, i12, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i11, i12, iArr, iArr2, i13);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i11, i12, i13, i14, iArr, i15, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i11, i12, i13, i14, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        return getScrollingChildHelper().dispatchNestedScroll(i11, i12, i13, i14, iArr, i15);
    }

    public void dispatchOnScrollStateChanged(int i11) {
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.onScrollStateChanged(i11);
        }
        onScrollStateChanged(i11);
        r rVar = this.mScrollListener;
        if (rVar != null) {
            rVar.onScrollStateChanged(this, i11);
        }
        List<r> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i11);
            }
        }
    }

    public void dispatchOnScrolled(int i11, int i12) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i11, scrollY - i12);
        onScrolled(i11, i12);
        r rVar = this.mScrollListener;
        if (rVar != null) {
            rVar.onScrolled(this, i11, i12);
        }
        List<r> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i11, i12);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i11;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            a0 a0Var = this.mPendingAccessibilityImportanceChange.get(size);
            if (a0Var.itemView.getParent() == this && !a0Var.shouldIgnore() && (i11 = a0Var.mPendingAccessibilityState) != -1) {
                ViewCompat.setImportantForAccessibility(a0Var.itemView, i11);
                a0Var.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z11;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z12 = false;
        for (int i11 = 0; i11 < size; i11++) {
            this.mItemDecorations.get(i11).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z11 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z11 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z11 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z11 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z12 = true;
            }
            z11 |= z12;
            canvas.restoreToCount(iSave4);
        }
        if ((z11 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) && !z11) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j11) {
        return super.drawChild(canvas, view, j11);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.mEdgeEffectFactory.a(this, 3);
        this.mBottomGlow = edgeEffectA;
        if (this.mClipToPadding) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.mEdgeEffectFactory.a(this, 0);
        this.mLeftGlow = edgeEffectA;
        if (this.mClipToPadding) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.mEdgeEffectFactory.a(this, 2);
        this.mRightGlow = edgeEffectA;
        if (this.mClipToPadding) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.mEdgeEffectFactory.a(this, 1);
        this.mTopGlow = edgeEffectA;
        if (this.mClipToPadding) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(x xVar) {
        if (getScrollState() != 2) {
            xVar.f12595p = 0;
            xVar.f12596q = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            xVar.f12595p = overScroller.getFinalX() - overScroller.getCurrX();
            xVar.f12596q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    @Nullable
    public View findChildViewUnder(float f11, float f12) {
        for (int iG = this.mChildHelper.g() - 1; iG >= 0; iG--) {
            View viewF = this.mChildHelper.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (f11 >= viewF.getLeft() + translationX && f11 <= viewF.getRight() + translationX && f12 >= viewF.getTop() + translationY && f12 <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    @Nullable
    public View findContainingItemView(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    @Nullable
    public a0 findContainingViewHolder(@NonNull View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    @Nullable
    public a0 findViewHolderForAdapterPosition(int i11) {
        a0 a0Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iJ = this.mChildHelper.j();
        for (int i12 = 0; i12 < iJ; i12++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i12));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i11) {
                if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                a0Var = childViewHolderInt;
            }
        }
        return a0Var;
    }

    public a0 findViewHolderForItemId(long j11) {
        Adapter adapter = this.mAdapter;
        a0 a0Var = null;
        if (adapter != null && adapter.hasStableIds()) {
            int iJ = this.mChildHelper.j();
            for (int i11 = 0; i11 < iJ; i11++) {
                a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j11) {
                    if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    a0Var = childViewHolderInt;
                }
            }
        }
        return a0Var;
    }

    @Nullable
    public a0 findViewHolderForLayoutPosition(int i11) {
        return findViewHolderForPosition(i11, false);
    }

    @Nullable
    @Deprecated
    public a0 findViewHolderForPosition(int i11) {
        return findViewHolderForPosition(i11, false);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x0036 A[SYNTHETIC] */
    @Nullable
    public a0 findViewHolderForPosition(int i11, boolean z11) {
        int iJ = this.mChildHelper.j();
        a0 a0Var = null;
        for (int i12 = 0; i12 < iJ; i12++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i12));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z11) {
                    if (childViewHolderInt.mPosition != i11) {
                        continue;
                    } else {
                        if (this.mChildHelper.n(childViewHolderInt.itemView)) {
                            return childViewHolderInt;
                        }
                        a0Var = childViewHolderInt;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i11) {
                    continue;
                } else {
                    if (this.mChildHelper.n(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    a0Var = childViewHolderInt;
                }
            }
        }
        return a0Var;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean fling(int i11, int i12) {
        int iMax;
        int i13;
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        int iCanScrollHorizontally = mVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (iCanScrollHorizontally == 0 || Math.abs(i11) < this.mMinFlingVelocity) {
            i11 = 0;
        }
        if (!zCanScrollVertically || Math.abs(i12) < this.mMinFlingVelocity) {
            i12 = 0;
        }
        if (i11 == 0 && i12 == 0) {
            return false;
        }
        if (i11 == 0) {
            iMax = 0;
        } else {
            EdgeEffect edgeEffect = this.mLeftGlow;
            if (edgeEffect == null || androidx.core.widget.g.b(edgeEffect) == 0.0f) {
                EdgeEffect edgeEffect2 = this.mRightGlow;
                if (edgeEffect2 == null || androidx.core.widget.g.b(edgeEffect2) == 0.0f) {
                    iMax = 0;
                } else if (shouldAbsorb(this.mRightGlow, i11, getWidth())) {
                    this.mRightGlow.onAbsorb(i11);
                    i11 = 0;
                }
            } else {
                int i14 = -i11;
                if (shouldAbsorb(this.mLeftGlow, i14, getWidth())) {
                    this.mLeftGlow.onAbsorb(i14);
                    i11 = 0;
                }
            }
            iMax = i11;
            i11 = 0;
        }
        if (i12 == 0) {
            i13 = i12;
            i12 = 0;
        } else {
            EdgeEffect edgeEffect3 = this.mTopGlow;
            if (edgeEffect3 == null || androidx.core.widget.g.b(edgeEffect3) == 0.0f) {
                EdgeEffect edgeEffect4 = this.mBottomGlow;
                if (edgeEffect4 == null || androidx.core.widget.g.b(edgeEffect4) == 0.0f) {
                    i13 = i12;
                    i12 = 0;
                } else if (shouldAbsorb(this.mBottomGlow, i12, getHeight())) {
                    this.mBottomGlow.onAbsorb(i12);
                    i12 = 0;
                }
            } else {
                int i15 = -i12;
                if (shouldAbsorb(this.mTopGlow, i15, getHeight())) {
                    this.mTopGlow.onAbsorb(i15);
                    i12 = 0;
                }
            }
            i13 = 0;
        }
        if (iMax != 0 || i12 != 0) {
            int i16 = this.mMaxFlingVelocity;
            iMax = Math.max(-i16, Math.min(iMax, i16));
            int i17 = this.mMaxFlingVelocity;
            i12 = Math.max(-i17, Math.min(i12, i17));
            this.mViewFlinger.fling(iMax, i12);
        }
        if (i11 == 0 && i13 == 0) {
            return (iMax == 0 && i12 == 0) ? false : true;
        }
        float f11 = i11;
        float f12 = i13;
        if (!dispatchNestedPreFling(f11, f12)) {
            boolean z11 = iCanScrollHorizontally != 0 || zCanScrollVertically;
            dispatchNestedFling(f11, f12, z11);
            p pVar = this.mOnFlingListener;
            if (pVar != null && pVar.onFling(i11, i13)) {
                return true;
            }
            if (z11) {
                if (zCanScrollVertically) {
                    iCanScrollHorizontally = (iCanScrollHorizontally == true ? 1 : 0) | 2;
                }
                startNestedScroll(iCanScrollHorizontally, 1);
                int i18 = this.mMaxFlingVelocity;
                int iMax2 = Math.max(-i18, Math.min(i11, i18));
                int i19 = this.mMaxFlingVelocity;
                this.mViewFlinger.fling(iMax2, Math.max(-i19, Math.min(i13, i19)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i11) {
        View viewOnFocusSearchFailed;
        boolean z11;
        View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i11);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z12 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z12 && (i11 == 2 || i11 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i12 = i11 == 2 ? TsExtractor.TS_STREAM_TYPE_HDMV_DTS : 33;
                z11 = focusFinder.findNextFocus(this, view, i12) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i11 = i12;
                }
            } else {
                z11 = false;
            }
            if (!z11 && this.mLayout.canScrollHorizontally()) {
                int i13 = (this.mLayout.getLayoutDirection() == 1) ^ (i11 == 2) ? 66 : 17;
                boolean z13 = focusFinder.findNextFocus(this, view, i13) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i11 = i13;
                }
                z11 = z13;
            }
            if (z11) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i11, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i11);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i11);
            if (viewFindNextFocus == null && z12) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i11, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed == null || viewOnFocusSearchFailed.hasFocusable()) {
            return isPreferredNextFocus(view, viewOnFocusSearchFailed, i11) ? viewOnFocusSearchFailed : super.focusSearch(view, i11);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i11);
        }
        requestChildOnScreen(viewOnFocusSearchFailed, null);
        return view;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        m mVar = this.mLayout;
        if (mVar != null) {
            return mVar.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        m mVar = this.mLayout;
        if (mVar != null) {
            return mVar.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        m mVar = this.mLayout;
        if (mVar != null) {
            return mVar.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(a0 a0Var) {
        if (a0Var.hasAnyOfTheFlags(524) || !a0Var.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.e(a0Var.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        m mVar = this.mLayout;
        return mVar != null ? mVar.getBaseline() : super.getBaseline();
    }

    public long getChangedHolderKey(a0 a0Var) {
        return this.mAdapter.hasStableIds() ? a0Var.getItemId() : a0Var.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View view) {
        a0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i11, int i12) {
        h hVar = this.mChildDrawingOrderCallback;
        return hVar == null ? super.getChildDrawingOrder(i11, i12) : hVar.a(i11, i12);
    }

    public long getChildItemId(@NonNull View view) {
        a0 childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        a0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public a0 getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public androidx.recyclerview.widget.n getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    @NonNull
    public i getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public j getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        n nVar = (n) view.getLayoutParams();
        if (!nVar.mInsetsDirty) {
            return nVar.mDecorInsets;
        }
        if (this.mState.e() && (nVar.isItemChanged() || nVar.isViewInvalid())) {
            return nVar.mDecorInsets;
        }
        Rect rect = nVar.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i11).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i12 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i12 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        nVar.mInsetsDirty = false;
        return rect;
    }

    @NonNull
    public l getItemDecorationAt(int i11) {
        int itemDecorationCount = getItemDecorationCount();
        if (i11 >= 0 && i11 < itemDecorationCount) {
            return this.mItemDecorations.get(i11);
        }
        throw new IndexOutOfBoundsException(i11 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public m getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public p getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public s getRecycledViewPool() {
        return this.mRecycler.i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i11) {
        return getScrollingChildHelper().hasNestedScrollingParent(i11);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.p();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.a(new d());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        j jVar = this.mItemAnimator;
        return jVar != null && jVar.isRunning();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public void jumpToPositionForSmoothScroller(int i11) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i11);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int iJ = this.mChildHelper.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            ((n) this.mChildHelper.i(i11).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.s();
    }

    public void markKnownViewsInvalid() {
        int iJ = this.mChildHelper.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.t();
    }

    public void nestedScrollBy(int i11, int i12) {
        nestedScrollByInternal(i11, i12, null, 1);
    }

    public void offsetChildrenHorizontal(int i11) {
        int iG = this.mChildHelper.g();
        for (int i12 = 0; i12 < iG; i12++) {
            this.mChildHelper.f(i12).offsetLeftAndRight(i11);
        }
    }

    public void offsetChildrenVertical(int i11) {
        int iG = this.mChildHelper.g();
        for (int i12 = 0; i12 < iG; i12++) {
            this.mChildHelper.f(i12).offsetTopAndBottom(i11);
        }
    }

    public void offsetPositionRecordsForInsert(int i11, int i12) {
        int iJ = this.mChildHelper.j();
        for (int i13 = 0; i13 < iJ; i13++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i13));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i11) {
                if (sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("offsetPositionRecordsForInsert attached child ");
                    sb2.append(i13);
                    sb2.append(" holder ");
                    sb2.append(childViewHolderInt);
                    sb2.append(" now at position ");
                    sb2.append(childViewHolderInt.mPosition + i12);
                }
                childViewHolderInt.offsetPosition(i12, false);
                this.mState.f12586g = true;
            }
        }
        this.mRecycler.v(i11, i12);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int iJ = this.mChildHelper.j();
        if (i11 < i12) {
            i15 = -1;
            i14 = i11;
            i13 = i12;
        } else {
            i13 = i11;
            i14 = i12;
            i15 = 1;
        }
        for (int i17 = 0; i17 < iJ; i17++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i17));
            if (childViewHolderInt != null && (i16 = childViewHolderInt.mPosition) >= i14 && i16 <= i13) {
                if (sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("offsetPositionRecordsForMove attached child ");
                    sb2.append(i17);
                    sb2.append(" holder ");
                    sb2.append(childViewHolderInt);
                }
                if (childViewHolderInt.mPosition == i11) {
                    childViewHolderInt.offsetPosition(i12 - i11, false);
                } else {
                    childViewHolderInt.offsetPosition(i15, false);
                }
                this.mState.f12586g = true;
            }
        }
        this.mRecycler.w(i11, i12);
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i11, int i12, boolean z11) {
        int i13 = i11 + i12;
        int iJ = this.mChildHelper.j();
        for (int i14 = 0; i14 < iJ; i14++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i14));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i15 = childViewHolderInt.mPosition;
                if (i15 >= i13) {
                    if (sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("offsetPositionRecordsForRemove attached child ");
                        sb2.append(i14);
                        sb2.append(" holder ");
                        sb2.append(childViewHolderInt);
                        sb2.append(" now at position ");
                        sb2.append(childViewHolderInt.mPosition - i12);
                    }
                    childViewHolderInt.offsetPosition(-i12, z11);
                    this.mState.f12586g = true;
                } else if (i15 >= i11) {
                    if (sVerboseLoggingEnabled) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("offsetPositionRecordsForRemove attached child ");
                        sb3.append(i14);
                        sb3.append(" holder ");
                        sb3.append(childViewHolderInt);
                        sb3.append(" now REMOVED");
                    }
                    childViewHolderInt.flagRemovedAndOffsetPosition(i11 - 1, -i12, z11);
                    this.mState.f12586g = true;
                }
            }
        }
        this.mRecycler.x(i11, i12, z11);
        requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0053  */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
        this.mRecycler.z();
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal<GapWorker> threadLocal = GapWorker.sGapWorker;
            GapWorker gapWorker = threadLocal.get();
            this.mGapWorker = gapWorker;
            if (gapWorker == null) {
                this.mGapWorker = new GapWorker();
                Display display = ViewCompat.getDisplay(this);
                if (isInEditMode() || display == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = display.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                GapWorker gapWorker2 = this.mGapWorker;
                gapWorker2.mFrameIntervalNs = (long) (1.0E9f / refreshRate);
                threadLocal.set(gapWorker2);
            }
            this.mGapWorker.add(this);
        }
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        j jVar = this.mItemAnimator;
        if (jVar != null) {
            jVar.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.j();
        this.mRecycler.A();
        k3.a.c(this);
        if (!ALLOW_THREAD_GAP_WORK || (gapWorker = this.mGapWorker) == null) {
            return;
        }
        gapWorker.remove(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mItemDecorations.get(i11).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    public void onExitLayoutOrScroll(boolean z11) {
        int i11 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i11;
        if (i11 < 1) {
            if (sDebugAssertionsEnabled && i11 < 0) {
                throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + exceptionLabel());
            }
            this.mLayoutOrScrollCounter = 0;
            if (z11) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f11;
        float axisValue;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f11 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.mLayout.canScrollHorizontally() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.mLayout.canScrollVertically()) {
                    f11 = -axisValue2;
                } else if (this.mLayout.canScrollHorizontally()) {
                    axisValue = axisValue2;
                    f11 = 0.0f;
                } else {
                    f11 = 0.0f;
                }
            } else {
                f11 = 0.0f;
            }
            if (f11 != 0.0f || axisValue != 0.0f) {
                nestedScrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f11 * this.mScaledVerticalScrollFactor), motionEvent, 1);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        m mVar = this.mLayout;
        if (mVar == null) {
            return false;
        }
        boolean zCanScrollHorizontally = mVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x11 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x11;
            this.mInitialTouchX = x11;
            int y11 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y11;
            this.mInitialTouchY = y11;
            if (stopGlowAnimations(motionEvent) || this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i11 = zCanScrollHorizontally;
            if (zCanScrollVertically) {
                i11 = (zCanScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i11, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x12 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y12 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i12 = x12 - this.mInitialTouchX;
                int i13 = y12 - this.mInitialTouchY;
                if (!zCanScrollHorizontally || Math.abs(i12) <= this.mTouchSlop) {
                    z11 = false;
                } else {
                    this.mLastTouchX = x12;
                    z11 = true;
                }
                if (zCanScrollVertically && Math.abs(i13) > this.mTouchSlop) {
                    this.mLastTouchY = y12;
                } else if (z11) {
                }
                setScrollState(1);
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x13 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x13;
            this.mInitialTouchX = x13;
            int y13 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y13;
            this.mInitialTouchY = y13;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        androidx.core.os.r.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.r.b();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        m mVar = this.mLayout;
        if (mVar == null) {
            defaultOnMeasure(i11, i12);
            return;
        }
        boolean z11 = false;
        if (mVar.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i11, i12);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z11 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z11;
            if (z11 || this.mAdapter == null) {
                return;
            }
            if (this.mState.f12584e == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i11, i12);
            this.mState.f12589j = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i11, i12);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f12589j = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i11, i12);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i11, i12);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            x xVar = this.mState;
            if (xVar.f12591l) {
                xVar.f12587h = true;
            } else {
                this.mAdapterHelper.j();
                this.mState.f12587h = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f12591l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            this.mState.f12585f = adapter.getItemCount();
        } else {
            this.mState.f12585f = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i11, i12);
        stopInterceptRequestLayout(false);
        this.mState.f12587h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i11, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i11, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            m mVar = this.mLayout;
            if (mVar != null) {
                savedState.mLayoutState = mVar.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i11) {
    }

    public void onScrolled(int i11, int i12) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 == i13 && i12 == i14) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00df A[PHI: r0
  0x00df: PHI (r0v37 int) = (r0v26 int), (r0v41 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i11;
        boolean z11;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
            return true;
        }
        m mVar = this.mLayout;
        if (mVar == null) {
            return false;
        }
        boolean zCanScrollHorizontally = mVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.mNestedOffsets;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.mVelocityTracker.addMovement(motionEventObtain);
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                float f11 = zCanScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                float f12 = zCanScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                if ((f11 == 0.0f && f12 == 0.0f) || !fling((int) f11, (int) f12)) {
                    setScrollState(0);
                }
                resetScroll();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (iFindPointerIndex < 0) {
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int iMax = this.mLastTouchX - x11;
                int iMax2 = this.mLastTouchY - y11;
                if (this.mScrollState != 1) {
                    if (zCanScrollHorizontally) {
                        iMax = iMax > 0 ? Math.max(0, iMax - this.mTouchSlop) : Math.min(0, iMax + this.mTouchSlop);
                        if (iMax != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    } else {
                        z11 = false;
                    }
                    if (zCanScrollVertically) {
                        iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.mTouchSlop) : Math.min(0, iMax2 + this.mTouchSlop);
                        if (iMax2 != 0) {
                            z11 = true;
                        }
                    }
                    if (z11) {
                        setScrollState(1);
                    }
                }
                if (this.mScrollState == 1) {
                    int[] iArr3 = this.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    int iReleaseHorizontalGlow = iMax - releaseHorizontalGlow(iMax, motionEvent.getY());
                    int iReleaseVerticalGlow = iMax2 - releaseVerticalGlow(iMax2, motionEvent.getX());
                    if (dispatchNestedPreScroll(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, this.mReusableIntPair, this.mScrollOffset, 0)) {
                        int[] iArr4 = this.mReusableIntPair;
                        iReleaseHorizontalGlow -= iArr4[0];
                        iReleaseVerticalGlow -= iArr4[1];
                        int[] iArr5 = this.mNestedOffsets;
                        int i12 = iArr5[0];
                        int[] iArr6 = this.mScrollOffset;
                        iArr5[0] = i12 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int i13 = iReleaseVerticalGlow;
                    int[] iArr7 = this.mScrollOffset;
                    this.mLastTouchX = x11 - iArr7[0];
                    this.mLastTouchY = y11 - iArr7[1];
                    if (scrollByInternal(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? i13 : 0, motionEvent, 0)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    GapWorker gapWorker = this.mGapWorker;
                    if (gapWorker != null && (iReleaseHorizontalGlow != 0 || i13 != 0)) {
                        gapWorker.postFromTraversal(this, iReleaseHorizontalGlow, i13);
                    }
                }
            } else if (actionMasked == 3) {
                cancelScroll();
            } else if (actionMasked == 5) {
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mLastTouchX = x12;
                this.mInitialTouchX = x12;
                int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.mLastTouchY = y12;
                this.mInitialTouchY = y12;
            } else if (actionMasked == 6) {
                onPointerUp(motionEvent);
            }
            motionEventObtain.recycle();
            return true;
        }
        this.mScrollPointerId = motionEvent.getPointerId(0);
        int x13 = (int) (motionEvent.getX() + 0.5f);
        this.mLastTouchX = x13;
        this.mInitialTouchX = x13;
        int y13 = (int) (motionEvent.getY() + 0.5f);
        this.mLastTouchY = y13;
        this.mInitialTouchY = y13;
        if (zCanScrollVertically) {
            i11 = zCanScrollHorizontally;
            i11 = (zCanScrollHorizontally ? 1 : 0) | 2;
        }
        i11 = zCanScrollHorizontally;
        startNestedScroll(i11, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    public void processDataSetCompletelyChanged(boolean z11) {
        this.mDispatchItemsChangedEvent = z11 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(a0 a0Var, j.c cVar) {
        a0Var.setFlags(0, 8192);
        if (this.mState.f12588i && a0Var.isUpdated() && !a0Var.isRemoved() && !a0Var.shouldIgnore()) {
            this.mViewInfoStore.c(getChangedHolderKey(a0Var), a0Var);
        }
        this.mViewInfoStore.e(a0Var, cVar);
    }

    public void removeAndRecycleViews() {
        j jVar = this.mItemAnimator;
        if (jVar != null) {
            jVar.endAnimations();
        }
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.c();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean zR = this.mChildHelper.r(view);
        if (zR) {
            a0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.O(childViewHolderInt);
            this.mRecycler.H(childViewHolderInt);
            if (sVerboseLoggingEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("after removing animated view: ");
                sb2.append(view);
                sb2.append(", ");
                sb2.append(this);
            }
        }
        stopInterceptRequestLayout(!zR);
        return zR;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z11) {
        a0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        } else if (sDebugAssertionsEnabled) {
            throw new IllegalArgumentException("No ViewHolder found for child: " + view + exceptionLabel());
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z11);
    }

    public void removeItemDecoration(@NonNull l lVar) {
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(lVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i11) {
        int itemDecorationCount = getItemDecorationCount();
        if (i11 >= 0 && i11 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i11));
            return;
        }
        throw new IndexOutOfBoundsException(i11 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull o oVar) {
        List<o> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(oVar);
    }

    public void removeOnItemTouchListener(@NonNull q qVar) {
        this.mOnItemTouchListeners.remove(qVar);
        if (this.mInterceptingOnItemTouchListener == qVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(@NonNull r rVar) {
        List<r> list = this.mScrollListeners;
        if (list != null) {
            list.remove(rVar);
        }
    }

    public void removeRecyclerListener(@NonNull u uVar) {
        this.mRecyclerListeners.remove(uVar);
    }

    public void repositionShadowingViews() {
        a0 a0Var;
        int iG = this.mChildHelper.g();
        for (int i11 = 0; i11 < iG; i11++) {
            View viewF = this.mChildHelper.f(i11);
            a0 childViewHolder = getChildViewHolder(viewF);
            if (childViewHolder != null && (a0Var = childViewHolder.mShadowingHolder) != null) {
                View view = a0Var.itemView;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z11) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z11) {
        int size = this.mOnItemTouchListeners.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mOnItemTouchListeners.get(i11).c(z11);
        }
        super.requestDisallowInterceptTouchEvent(z11);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int iJ = this.mChildHelper.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            a0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
            if (sDebugAssertionsEnabled && childViewHolderInt.mPosition == -1 && !childViewHolderInt.isRemoved()) {
                throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + exceptionLabel());
            }
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i11, int i12) {
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = mVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i11 = 0;
            }
            if (!zCanScrollVertically) {
                i12 = 0;
            }
            scrollByInternal(i11, i12, null, 0);
        }
    }

    public boolean scrollByInternal(int i11, int i12, MotionEvent motionEvent, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i11, i12, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i18 = iArr2[0];
            int i19 = iArr2[1];
            i14 = i19;
            i15 = i18;
            i16 = i11 - i18;
            i17 = i12 - i19;
        } else {
            i14 = 0;
            i15 = 0;
            i16 = 0;
            i17 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i15, i14, i16, i17, this.mScrollOffset, i13, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i21 = iArr4[0];
        int i22 = i16 - i21;
        int i23 = iArr4[1];
        int i24 = i17 - i23;
        boolean z11 = (i21 == 0 && i23 == 0) ? false : true;
        int i25 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i26 = iArr5[0];
        this.mLastTouchX = i25 - i26;
        int i27 = this.mLastTouchY;
        int i28 = iArr5[1];
        this.mLastTouchY = i27 - i28;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i26;
        iArr6[1] = iArr6[1] + i28;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i22, motionEvent.getY(), i24);
            }
            considerReleasingGlowsOnScroll(i11, i12);
        }
        if (i15 != 0 || i14 != 0) {
            dispatchOnScrolled(i15, i14);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z11 && i15 == 0 && i14 == 0) ? false : true;
    }

    public void scrollStep(int i11, int i12, @Nullable int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.os.r.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = i11 != 0 ? this.mLayout.scrollHorizontallyBy(i11, this.mRecycler, this.mState) : 0;
        int iScrollVerticallyBy = i12 != 0 ? this.mLayout.scrollVerticallyBy(i12, this.mRecycler, this.mState) : 0;
        androidx.core.os.r.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i11, int i12) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i11) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            mVar.scrollToPosition(i11);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@Nullable androidx.recyclerview.widget.n nVar) {
        this.mAccessibilityDelegate = nVar;
        ViewCompat.setAccessibilityDelegate(this, nVar);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable h hVar) {
        if (hVar == this.mChildDrawingOrderCallback) {
            return;
        }
        setChildrenDrawingOrderEnabled(hVar != null);
    }

    public boolean setChildImportantForAccessibilityInternal(a0 a0Var, int i11) {
        if (!isComputingLayout()) {
            ViewCompat.setImportantForAccessibility(a0Var.itemView, i11);
            return true;
        }
        a0Var.mPendingAccessibilityState = i11;
        this.mPendingAccessibilityImportanceChange.add(a0Var);
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z11) {
        if (z11 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z11;
        super.setClipToPadding(z11);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull i iVar) {
        androidx.core.util.i.g(iVar);
        this.mEdgeEffectFactory = iVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z11) {
        this.mHasFixedSize = z11;
    }

    public void setItemAnimator(@Nullable j jVar) {
        j jVar2 = this.mItemAnimator;
        if (jVar2 != null) {
            jVar2.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = jVar;
        if (jVar != null) {
            jVar.setListener(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i11) {
        this.mRecycler.L(i11);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z11) {
        suppressLayout(z11);
    }

    public void setLayoutManager(@Nullable m mVar) {
        if (mVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            j jVar = this.mItemAnimator;
            if (jVar != null) {
                jVar.endAnimations();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.c();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.c();
        }
        this.mChildHelper.o();
        this.mLayout = mVar;
        if (mVar != null) {
            if (mVar.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + mVar + " is already attached to a RecyclerView:" + mVar.mRecyclerView.exceptionLabel());
            }
            mVar.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.P();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z11) {
        getScrollingChildHelper().setNestedScrollingEnabled(z11);
    }

    public void setOnFlingListener(@Nullable p pVar) {
        this.mOnFlingListener = pVar;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable r rVar) {
        this.mScrollListener = rVar;
    }

    public void setPreserveFocusAfterLayout(boolean z11) {
        this.mPreserveFocusAfterLayout = z11;
    }

    public void setRecycledViewPool(@Nullable s sVar) {
        this.mRecycler.J(sVar);
    }

    @Deprecated
    public void setRecyclerListener(@Nullable u uVar) {
        this.mRecyclerListener = uVar;
    }

    public void setScrollState(int i11) {
        if (i11 == this.mScrollState) {
            return;
        }
        if (sVerboseLoggingEnabled) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setting scroll state to ");
            sb2.append(i11);
            sb2.append(" from ");
            sb2.append(this.mScrollState);
            new Exception();
        }
        this.mScrollState = i11;
        if (i11 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i11);
    }

    public void setScrollingTouchSlop(int i11) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i11 != 0) {
            if (i11 == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i11 + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@Nullable z zVar) {
        this.mRecycler.K(zVar);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        return true;
    }

    public void smoothScrollBy(int i11, int i12) {
        smoothScrollBy(i11, i12, null);
    }

    public void smoothScrollBy(int i11, int i12, @Nullable Interpolator interpolator) {
        smoothScrollBy(i11, i12, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i11, int i12, @Nullable Interpolator interpolator, int i13) {
        smoothScrollBy(i11, i12, interpolator, i13, false);
    }

    public void smoothScrollBy(int i11, int i12, @Nullable Interpolator interpolator, int i13, boolean z11) {
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!mVar.canScrollHorizontally()) {
            i11 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i12 = 0;
        }
        if (i11 == 0 && i12 == 0) {
            return;
        }
        if (i13 != Integer.MIN_VALUE && i13 <= 0) {
            scrollBy(i11, i12);
            return;
        }
        if (z11) {
            int i14 = i11 != 0 ? 1 : 0;
            if (i12 != 0) {
                i14 |= 2;
            }
            startNestedScroll(i14, 1);
        }
        this.mViewFlinger.smoothScrollBy(i11, i12, i13, interpolator);
    }

    public void smoothScrollToPosition(int i11) {
        if (this.mLayoutSuppressed) {
            return;
        }
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            mVar.smoothScrollToPosition(this, this.mState, i11);
        }
    }

    public void startInterceptRequestLayout() {
        int i11 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i11;
        if (i11 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i11) {
        return getScrollingChildHelper().startNestedScroll(i11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i11, int i12) {
        return getScrollingChildHelper().startNestedScroll(i11, i12);
    }

    public void stopInterceptRequestLayout(boolean z11) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            if (sDebugAssertionsEnabled) {
                throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + exceptionLabel());
            }
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z11 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z11 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i11) {
        getScrollingChildHelper().stopNestedScroll(i11);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z11) {
        if (z11 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z11) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z11) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z11);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i11, int i12, Object obj) {
        int i13;
        int iJ = this.mChildHelper.j();
        int i14 = i11 + i12;
        for (int i15 = 0; i15 < iJ; i15++) {
            View viewI = this.mChildHelper.i(i15);
            a0 childViewHolderInt = getChildViewHolderInt(viewI);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i13 = childViewHolderInt.mPosition) >= i11 && i13 < i14) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((n) viewI.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.R(i11, i12);
    }
}
