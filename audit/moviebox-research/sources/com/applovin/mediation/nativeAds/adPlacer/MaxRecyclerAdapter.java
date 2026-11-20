package com.applovin.mediation.nativeAds.adPlacer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.applovin.impl.hl;
import com.applovin.mediation.MaxAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.a0> implements MaxAdPlacer.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxAdPlacer f25023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RecyclerView.Adapter f25024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f25025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RecyclerView f25026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private hl f25027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxAdPlacer.Listener f25028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AdPositionBehavior f25030h;

    /* JADX INFO: compiled from: source.java */
    public enum AdPositionBehavior {
        DYNAMIC_EXCEPT_ON_APPEND,
        DYNAMIC,
        FIXED
    }

    /* JADX INFO: compiled from: source.java */
    public static class MaxAdRecyclerViewHolder extends RecyclerView.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f25032a;

        public MaxAdRecyclerViewHolder(View view) {
            super(view);
            this.f25032a = (ViewGroup) view.findViewById(R.id.applovin_native_ad_view_container);
        }

        public ViewGroup getContainerView() {
            return this.f25032a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements hl.a {
        public a() {
        }

        @Override // com.applovin.impl.hl.a
        public void a(int i11, int i12) {
            MaxRecyclerAdapter.this.f25023a.updateFillablePositions(i11, Math.min(i12 + MaxRecyclerAdapter.this.f25029g, MaxRecyclerAdapter.this.getItemCount() - 1));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends RecyclerView.g {
        private b() {
        }

        public /* synthetic */ b(MaxRecyclerAdapter maxRecyclerAdapter, a aVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onChanged() {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeChanged(int i11, int i12) {
            int adjustedPosition = MaxRecyclerAdapter.this.f25023a.getAdjustedPosition(i11);
            MaxRecyclerAdapter.this.notifyItemRangeChanged(adjustedPosition, (MaxRecyclerAdapter.this.f25023a.getAdjustedPosition((i11 + i12) - 1) - adjustedPosition) + 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeInserted(int i11, int i12) {
            boolean z11 = i11 + i12 >= MaxRecyclerAdapter.this.f25024b.getItemCount();
            if (MaxRecyclerAdapter.this.f25030h == AdPositionBehavior.FIXED || (MaxRecyclerAdapter.this.f25030h == AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND && z11)) {
                MaxRecyclerAdapter.this.notifyDataSetChanged();
                return;
            }
            int adjustedPosition = MaxRecyclerAdapter.this.f25023a.getAdjustedPosition(i11);
            for (int i13 = 0; i13 < i12; i13++) {
                MaxRecyclerAdapter.this.f25023a.insertItem(adjustedPosition);
            }
            MaxRecyclerAdapter.this.notifyItemRangeInserted(adjustedPosition, i12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeMoved(int i11, int i12, int i13) {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeRemoved(int i11, int i12) {
            int itemCount = MaxRecyclerAdapter.this.f25024b.getItemCount();
            boolean z11 = i11 + i12 >= itemCount;
            if (MaxRecyclerAdapter.this.f25030h == AdPositionBehavior.FIXED || (MaxRecyclerAdapter.this.f25030h == AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND && z11)) {
                MaxRecyclerAdapter.this.notifyDataSetChanged();
                return;
            }
            int adjustedPosition = MaxRecyclerAdapter.this.f25023a.getAdjustedPosition(i11);
            int adjustedCount = MaxRecyclerAdapter.this.f25023a.getAdjustedCount(itemCount + i12);
            for (int i13 = 0; i13 < i12; i13++) {
                MaxRecyclerAdapter.this.f25023a.removeItem(adjustedPosition);
            }
            int adjustedCount2 = MaxRecyclerAdapter.this.f25023a.getAdjustedCount(itemCount);
            int size = adjustedCount - adjustedCount2;
            Collection<Integer> collectionClearTrailingAds = MaxRecyclerAdapter.this.f25023a.clearTrailingAds(adjustedCount2 - 1);
            if (!collectionClearTrailingAds.isEmpty()) {
                size += collectionClearTrailingAds.size();
            }
            MaxRecyclerAdapter.this.notifyItemRangeRemoved(adjustedPosition - (size - i12), size);
        }
    }

    public MaxRecyclerAdapter(MaxAdPlacerSettings maxAdPlacerSettings, RecyclerView.Adapter adapter, Activity activity) {
        b bVar = new b(this, null);
        this.f25025c = bVar;
        this.f25029g = 8;
        this.f25030h = AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND;
        MaxAdPlacer maxAdPlacer = new MaxAdPlacer(maxAdPlacerSettings, activity);
        this.f25023a = maxAdPlacer;
        maxAdPlacer.setListener(this);
        super.setHasStableIds(adapter.hasStableIds());
        this.f25024b = adapter;
        adapter.registerAdapterDataObserver(bVar);
    }

    private int a(int i11) {
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.f25026d.getContext(), this.f25026d.getWidth());
        RecyclerView.m layoutManager = this.f25026d.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            return layoutManager instanceof StaggeredGridLayoutManager ? iPxToDp / ((StaggeredGridLayoutManager) layoutManager).getSpanCount() : iPxToDp;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        return (iPxToDp / gridLayoutManager.getSpanCount()) * gridLayoutManager.getSpanSizeLookup().f(i11);
    }

    public void destroy() {
        try {
            this.f25024b.unregisterAdapterDataObserver(this.f25025c);
        } catch (Exception unused) {
        }
        this.f25023a.destroy();
        hl hlVar = this.f25027e;
        if (hlVar != null) {
            hlVar.a();
        }
    }

    public MaxAdPlacer getAdPlacer() {
        return this.f25023a;
    }

    public int getAdjustedPosition(int i11) {
        return this.f25023a.getAdjustedPosition(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f25023a.getAdjustedCount(this.f25024b.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i11) {
        if (this.f25024b.hasStableIds()) {
            return this.f25023a.isFilledPosition(i11) ? this.f25023a.getAdItemId(i11) : this.f25024b.getItemId(this.f25023a.getOriginalPosition(i11));
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        if (this.f25023a.isAdPosition(i11)) {
            return -42;
        }
        return this.f25024b.getItemViewType(this.f25023a.getOriginalPosition(i11));
    }

    public int getOriginalPosition(int i11) {
        return this.f25023a.getOriginalPosition(i11);
    }

    public void loadAds() {
        this.f25023a.loadAds();
    }

    @Override // com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.Listener
    public void onAdClicked(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.f25028f;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    @Override // com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.Listener
    public void onAdLoaded(int i11) {
        notifyItemChanged(i11);
        MaxAdPlacer.Listener listener = this.f25028f;
        if (listener != null) {
            listener.onAdLoaded(i11);
        }
    }

    @Override // com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.Listener
    public void onAdRemoved(int i11) {
        MaxAdPlacer.Listener listener = this.f25028f;
        if (listener != null) {
            listener.onAdRemoved(i11);
        }
    }

    @Override // com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.Listener
    public void onAdRevenuePaid(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.f25028f;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f25026d = recyclerView;
        hl hlVar = new hl(recyclerView);
        this.f25027e = hlVar;
        hlVar.a(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.a0 a0Var, int i11) {
        this.f25027e.a(a0Var.itemView, i11);
        if (!this.f25023a.isAdPosition(i11)) {
            this.f25024b.onBindViewHolder(a0Var, this.f25023a.getOriginalPosition(i11));
            return;
        }
        AppLovinSdkUtils.Size adSize = this.f25023a.getAdSize(i11, a(i11));
        ViewGroup containerView = ((MaxAdRecyclerViewHolder) a0Var).getContainerView();
        ViewGroup.LayoutParams layoutParams = containerView.getLayoutParams();
        if (adSize == AppLovinSdkUtils.Size.ZERO) {
            layoutParams.width = -2;
            layoutParams.height = -2;
            containerView.setLayoutParams(layoutParams);
        } else {
            layoutParams.width = adSize.getWidth() < 0 ? adSize.getWidth() : AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getWidth());
            layoutParams.height = adSize.getHeight() < 0 ? adSize.getHeight() : AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getHeight());
            containerView.setLayoutParams(layoutParams);
            this.f25023a.renderAd(i11, containerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.a0 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        if (i11 != -42) {
            return this.f25024b.onCreateViewHolder(viewGroup, i11);
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.max_native_ad_recycler_view_item, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
        RecyclerView.m layoutManager = this.f25026d.getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            layoutParams.width = -1;
            layoutParams.height = -2;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        viewInflate.setLayoutParams(layoutParams);
        return new MaxAdRecyclerViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f25026d = null;
        hl hlVar = this.f25027e;
        if (hlVar != null) {
            hlVar.a();
            this.f25027e = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.a0 a0Var) {
        return a0Var instanceof MaxAdRecyclerViewHolder ? super.onFailedToRecycleView(a0Var) : this.f25024b.onFailedToRecycleView(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.a0 a0Var) {
        if (a0Var instanceof MaxAdRecyclerViewHolder) {
            super.onViewAttachedToWindow(a0Var);
        } else {
            this.f25024b.onViewAttachedToWindow(a0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.a0 a0Var) {
        if (a0Var instanceof MaxAdRecyclerViewHolder) {
            super.onViewDetachedFromWindow(a0Var);
        } else {
            this.f25024b.onViewDetachedFromWindow(a0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.a0 a0Var) {
        hl hlVar = this.f25027e;
        if (hlVar != null) {
            hlVar.b(a0Var.itemView);
        }
        if (!(a0Var instanceof MaxAdRecyclerViewHolder)) {
            this.f25024b.onViewRecycled(a0Var);
            return;
        }
        if (this.f25023a.isFilledPosition(a0Var.getBindingAdapterPosition())) {
            ((MaxAdRecyclerViewHolder) a0Var).getContainerView().removeAllViews();
        }
        super.onViewRecycled(a0Var);
    }

    public void setAdPositionBehavior(AdPositionBehavior adPositionBehavior) {
        this.f25030h = adPositionBehavior;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z11) {
        super.setHasStableIds(z11);
        this.f25024b.unregisterAdapterDataObserver(this.f25025c);
        this.f25024b.setHasStableIds(z11);
        this.f25024b.registerAdapterDataObserver(this.f25025c);
    }

    public void setListener(MaxAdPlacer.Listener listener) {
        this.f25028f = listener;
    }

    public void setLookAhead(int i11) {
        this.f25029g = i11;
    }
}
