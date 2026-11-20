package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.noober.background.view.BLFrameLayout;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f65754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f65755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final BLFrameLayout f65756d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f65760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f65761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f65762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65763l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65764m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final TabLayout f65765n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65766o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65767p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65768q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65769r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65770s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65771t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final View f65772u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final View f65773v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65774w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f65775x;

    public c0(@NonNull FrameLayout frameLayout, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull CoordinatorLayout coordinatorLayout, @NonNull BLFrameLayout bLFrameLayout, @NonNull FrameLayout frameLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ImageView imageView, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull ProgressBar progressBar2, @NonNull TabLayout tabLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull View view2, @NonNull View view3, @NonNull ProgressBar progressBar3, @NonNull ViewPager2 viewPager2) {
        this.f65753a = frameLayout;
        this.f65754b = linearLayoutCompat;
        this.f65755c = coordinatorLayout;
        this.f65756d = bLFrameLayout;
        this.f65757f = frameLayout2;
        this.f65758g = appCompatImageView;
        this.f65759h = appCompatImageView2;
        this.f65760i = imageView;
        this.f65761j = view;
        this.f65762k = linearLayout;
        this.f65763l = progressBar;
        this.f65764m = progressBar2;
        this.f65765n = tabLayout;
        this.f65766o = appCompatTextView;
        this.f65767p = appCompatTextView2;
        this.f65768q = appCompatTextView3;
        this.f65769r = appCompatTextView4;
        this.f65770s = appCompatTextView5;
        this.f65771t = appCompatTextView6;
        this.f65772u = view2;
        this.f65773v = view3;
        this.f65774w = progressBar3;
        this.f65775x = viewPager2;
    }

    @NonNull
    public static c0 a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i11 = R$id.btn_download;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
        if (linearLayoutCompat != null) {
            i11 = R$id.cl_root;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
            if (coordinatorLayout != null) {
                i11 = R$id.fl_loading;
                BLFrameLayout bLFrameLayout = (BLFrameLayout) n6.b.a(view, i11);
                if (bLFrameLayout != null) {
                    i11 = R$id.fl_select_all_bg;
                    FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.iv_btn_download_icon;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.iv_check;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.iv_close;
                                ImageView imageView = (ImageView) n6.b.a(view, i11);
                                if (imageView != null && (viewA = n6.b.a(view, (i11 = R$id.line))) != null) {
                                    i11 = R$id.ll_not_net;
                                    LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                    if (linearLayout != null) {
                                        i11 = R$id.progress_bar_btn_download;
                                        ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                                        if (progressBar != null) {
                                            i11 = R$id.progress_bar_select_all;
                                            ProgressBar progressBar2 = (ProgressBar) n6.b.a(view, i11);
                                            if (progressBar2 != null) {
                                                i11 = R$id.subjectTab;
                                                TabLayout tabLayout = (TabLayout) n6.b.a(view, i11);
                                                if (tabLayout != null) {
                                                    i11 = R$id.tv_btn_download;
                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                    if (appCompatTextView != null) {
                                                        i11 = R$id.tv_no_network_content;
                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView2 != null) {
                                                            i11 = R$id.tv_retry;
                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                            if (appCompatTextView3 != null) {
                                                                i11 = R$id.tv_select_all;
                                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView4 != null) {
                                                                    i11 = R$id.tv_tips;
                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                                    if (appCompatTextView5 != null) {
                                                                        i11 = R$id.tv_title;
                                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                                        if (appCompatTextView6 != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_bottom))) != null && (viewA3 = n6.b.a(view, (i11 = R$id.v_content_gap))) != null) {
                                                                            i11 = R$id.view_load;
                                                                            ProgressBar progressBar3 = (ProgressBar) n6.b.a(view, i11);
                                                                            if (progressBar3 != null) {
                                                                                i11 = R$id.vp_content;
                                                                                ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                                                                if (viewPager2 != null) {
                                                                                    return new c0((FrameLayout) view, linearLayoutCompat, coordinatorLayout, bLFrameLayout, frameLayout, appCompatImageView, appCompatImageView2, imageView, viewA, linearLayout, progressBar, progressBar2, tabLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, viewA2, viewA3, progressBar3, viewPager2);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static c0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static c0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_res_multi, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f65753a;
    }
}
