package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.transsion.baseui.widget.NestedSwipeRefreshLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.widget.CommunityRoomsView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class l implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final NestedSwipeRefreshLayout f76550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f76551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f76552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f76553d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final NestedSwipeRefreshLayout f76554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final CollapsingToolbarLayout f76555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final CommunityRoomsView f76556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f76557i;

    public l(@NonNull NestedSwipeRefreshLayout nestedSwipeRefreshLayout, @NonNull AppBarLayout appBarLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull MagicIndicator magicIndicator, @NonNull NestedSwipeRefreshLayout nestedSwipeRefreshLayout2, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull CommunityRoomsView communityRoomsView, @NonNull ViewPager2 viewPager2) {
        this.f76550a = nestedSwipeRefreshLayout;
        this.f76551b = appBarLayout;
        this.f76552c = appCompatImageView;
        this.f76553d = magicIndicator;
        this.f76554f = nestedSwipeRefreshLayout2;
        this.f76555g = collapsingToolbarLayout;
        this.f76556h = communityRoomsView;
        this.f76557i = viewPager2;
    }

    @NonNull
    public static l a(@NonNull View view) {
        int i11 = R$id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
        if (appBarLayout != null) {
            i11 = R$id.iv_publish;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.magic_indicator;
                MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                if (magicIndicator != null) {
                    NestedSwipeRefreshLayout nestedSwipeRefreshLayout = (NestedSwipeRefreshLayout) view;
                    i11 = R$id.toolbar_layout;
                    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) n6.b.a(view, i11);
                    if (collapsingToolbarLayout != null) {
                        i11 = R$id.v_recommend_rooms;
                        CommunityRoomsView communityRoomsView = (CommunityRoomsView) n6.b.a(view, i11);
                        if (communityRoomsView != null) {
                            i11 = R$id.view_pager;
                            ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                            if (viewPager2 != null) {
                                return new l(nestedSwipeRefreshLayout, appBarLayout, appCompatImageView, magicIndicator, nestedSwipeRefreshLayout, collapsingToolbarLayout, communityRoomsView, viewPager2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static l c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static l d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_room_home, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedSwipeRefreshLayout getRoot() {
        return this.f76550a;
    }
}
