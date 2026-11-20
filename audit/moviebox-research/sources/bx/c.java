package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.hisavana.mediation.ad.TAdNativeView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f14444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f14445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ProgressBar f14446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14447d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f14448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f14450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f14451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f14452j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f14453k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f14454l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f14455m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f14456n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f14457o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final TAdNativeView f14458p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final TextView f14459q;

    public c(@NonNull NestedScrollView nestedScrollView, @NonNull RecyclerView recyclerView, @NonNull ProgressBar progressBar, @NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView2, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull View view, @NonNull MagicIndicator magicIndicator, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout, @NonNull ViewPager2 viewPager2, @NonNull NestedScrollView nestedScrollView2, @NonNull TAdNativeView tAdNativeView, @NonNull TextView textView2) {
        this.f14444a = nestedScrollView;
        this.f14445b = recyclerView;
        this.f14446c = progressBar;
        this.f14447d = constraintLayout;
        this.f14448f = recyclerView2;
        this.f14449g = constraintLayout2;
        this.f14450h = imageView;
        this.f14451i = textView;
        this.f14452j = view;
        this.f14453k = magicIndicator;
        this.f14454l = imageView2;
        this.f14455m = relativeLayout;
        this.f14456n = viewPager2;
        this.f14457o = nestedScrollView2;
        this.f14458p = tAdNativeView;
        this.f14459q = textView2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        View viewA;
        int i11 = R$id.everyone_search_rv;
        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.progress_bar;
            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.rl_tips;
                ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                if (constraintLayout != null) {
                    i11 = R$id.rv_history;
                    RecyclerView recyclerView2 = (RecyclerView) n6.b.a(view, i11);
                    if (recyclerView2 != null) {
                        i11 = R$id.search_hot_everyone_linear;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
                        if (constraintLayout2 != null) {
                            i11 = R$id.search_hot_everyone_title_image;
                            ImageView imageView = (ImageView) n6.b.a(view, i11);
                            if (imageView != null) {
                                i11 = R$id.search_hot_everyone_title_text;
                                TextView textView = (TextView) n6.b.a(view, i11);
                                if (textView != null && (viewA = n6.b.a(view, (i11 = R$id.search_hot_rank_indicator_linear))) != null) {
                                    i11 = R$id.search_hot_rank_magic_indicator;
                                    MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                                    if (magicIndicator != null) {
                                        i11 = R$id.search_hot_rank_magic_indicator_image;
                                        ImageView imageView2 = (ImageView) n6.b.a(view, i11);
                                        if (imageView2 != null) {
                                            i11 = R$id.search_hot_rank_magic_indicator_ll;
                                            RelativeLayout relativeLayout = (RelativeLayout) n6.b.a(view, i11);
                                            if (relativeLayout != null) {
                                                i11 = R$id.search_hot_rank_view_pager;
                                                ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                                if (viewPager2 != null) {
                                                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                                                    i11 = R$id.tAdNativeView;
                                                    TAdNativeView tAdNativeView = (TAdNativeView) n6.b.a(view, i11);
                                                    if (tAdNativeView != null) {
                                                        i11 = R$id.tv_clear;
                                                        TextView textView2 = (TextView) n6.b.a(view, i11);
                                                        if (textView2 != null) {
                                                            return new c(nestedScrollView, recyclerView, progressBar, constraintLayout, recyclerView2, constraintLayout2, imageView, textView, viewA, magicIndicator, imageView2, relativeLayout, viewPager2, nestedScrollView, tAdNativeView, textView2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_hot_search, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f14444a;
    }
}
