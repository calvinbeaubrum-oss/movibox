package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class k implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f14505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f14506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TabLayout f14507d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f14508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f14509g;

    public k(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull RecyclerView recyclerView, @NonNull TabLayout tabLayout, @NonNull View view, @NonNull ViewPager2 viewPager2) {
        this.f14504a = constraintLayout;
        this.f14505b = appBarLayout;
        this.f14506c = recyclerView;
        this.f14507d = tabLayout;
        this.f14508f = view;
        this.f14509g = viewPager2;
    }

    @NonNull
    public static k a(@NonNull View view) {
        View viewA;
        int i11 = R$id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
        if (appBarLayout != null) {
            i11 = R$id.rvRank;
            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.tabs;
                TabLayout tabLayout = (TabLayout) n6.b.a(view, i11);
                if (tabLayout != null && (viewA = n6.b.a(view, (i11 = R$id.viewLine))) != null) {
                    i11 = R$id.viewPager;
                    ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                    if (viewPager2 != null) {
                        return new k((ConstraintLayout) view, appBarLayout, recyclerView, tabLayout, viewA, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static k c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static k d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_search_values_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f14504a;
    }
}
