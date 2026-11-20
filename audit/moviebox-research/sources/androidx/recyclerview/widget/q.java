package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class q extends RecyclerView.p {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.r mScrollListener = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12691a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 == 0 && this.f12691a) {
                this.f12691a = false;
                q.this.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            if (i11 == 0 && i12 == 0) {
                return;
            }
            this.f12691a = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends h {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.h, androidx.recyclerview.widget.RecyclerView.w
        public void o(View view, RecyclerView.x xVar, RecyclerView.w.a aVar) {
            q qVar = q.this;
            RecyclerView recyclerView = qVar.mRecyclerView;
            if (recyclerView == null) {
                return;
            }
            int[] iArrCalculateDistanceToFinalSnap = qVar.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
            int i11 = iArrCalculateDistanceToFinalSnap[0];
            int i12 = iArrCalculateDistanceToFinalSnap[1];
            int iW = w(Math.max(Math.abs(i11), Math.abs(i12)));
            if (iW > 0) {
                aVar.d(i11, i12, iW, this.f12670j);
            }
        }

        @Override // androidx.recyclerview.widget.h
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
    }

    private boolean snapFromFling(@NonNull RecyclerView.m mVar, int i11, int i12) {
        RecyclerView.w wVarCreateScroller;
        int iFindTargetSnapPosition;
        if (!(mVar instanceof RecyclerView.w.b) || (wVarCreateScroller = createScroller(mVar)) == null || (iFindTargetSnapPosition = findTargetSnapPosition(mVar, i11, i12)) == -1) {
            return false;
        }
        wVarCreateScroller.p(iFindTargetSnapPosition);
        mVar.startSmoothScroll(wVarCreateScroller);
        return true;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
            snapToTargetExistingView();
        }
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.m mVar, @NonNull View view);

    @SuppressLint({"UnknownNullness"})
    public int[] calculateScrollDistance(int i11, int i12) {
        this.mGravityScroller.fling(0, 0, i11, i12, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    @Nullable
    public RecyclerView.w createScroller(@NonNull RecyclerView.m mVar) {
        return createSnapScroller(mVar);
    }

    @Nullable
    @Deprecated
    public h createSnapScroller(@NonNull RecyclerView.m mVar) {
        if (mVar instanceof RecyclerView.w.b) {
            return new b(this.mRecyclerView.getContext());
        }
        return null;
    }

    @Nullable
    @SuppressLint({"UnknownNullness"})
    public abstract View findSnapView(RecyclerView.m mVar);

    @SuppressLint({"UnknownNullness"})
    public abstract int findTargetSnapPosition(RecyclerView.m mVar, int i11, int i12);

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean onFling(int i11, int i12) {
        RecyclerView.m layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        return (Math.abs(i12) > minFlingVelocity || Math.abs(i11) > minFlingVelocity) && snapFromFling(layoutManager, i11, i12);
    }

    public void snapToTargetExistingView() {
        RecyclerView.m layoutManager;
        View viewFindSnapView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewFindSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, viewFindSnapView);
        int i11 = iArrCalculateDistanceToFinalSnap[0];
        if (i11 == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(i11, iArrCalculateDistanceToFinalSnap[1]);
    }
}
