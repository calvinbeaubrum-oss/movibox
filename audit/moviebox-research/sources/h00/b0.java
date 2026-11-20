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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.transsion.wrapperad.view.DownloadMovieAdView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.DownloadGridTabView;
import com.transsnet.downloader.widget.DownloadResolutionTabView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b0 implements n6.a {

    @NonNull
    public final ProgressBar A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f65723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLConstraintLayout f65724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f65725d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLFrameLayout f65727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65729i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65730j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f65731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final View f65732l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f65733m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65734n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65735o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65736p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65737q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65738r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65739s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65740t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65741u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65742v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final View f65743w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final DownloadGridTabView f65744x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final DownloadResolutionTabView f65745y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final DownloadMovieAdView f65746z;

    public b0(@NonNull FrameLayout frameLayout, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull BLConstraintLayout bLConstraintLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout frameLayout2, @NonNull BLFrameLayout bLFrameLayout, @NonNull FrameLayout frameLayout3, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ImageView imageView, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull ProgressBar progressBar2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull ConstraintLayout constraintLayout, @NonNull View view2, @NonNull DownloadGridTabView downloadGridTabView, @NonNull DownloadResolutionTabView downloadResolutionTabView, @NonNull DownloadMovieAdView downloadMovieAdView, @NonNull ProgressBar progressBar3) {
        this.f65722a = frameLayout;
        this.f65723b = linearLayoutCompat;
        this.f65724c = bLConstraintLayout;
        this.f65725d = coordinatorLayout;
        this.f65726f = frameLayout2;
        this.f65727g = bLFrameLayout;
        this.f65728h = frameLayout3;
        this.f65729i = appCompatImageView;
        this.f65730j = appCompatImageView2;
        this.f65731k = imageView;
        this.f65732l = view;
        this.f65733m = linearLayout;
        this.f65734n = progressBar;
        this.f65735o = progressBar2;
        this.f65736p = appCompatTextView;
        this.f65737q = appCompatTextView2;
        this.f65738r = appCompatTextView3;
        this.f65739s = appCompatTextView4;
        this.f65740t = appCompatTextView5;
        this.f65741u = appCompatTextView6;
        this.f65742v = constraintLayout;
        this.f65743w = view2;
        this.f65744x = downloadGridTabView;
        this.f65745y = downloadResolutionTabView;
        this.f65746z = downloadMovieAdView;
        this.A = progressBar3;
    }

    @NonNull
    public static b0 a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.btn_download;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
        if (linearLayoutCompat != null) {
            i11 = R$id.cl_content;
            BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) n6.b.a(view, i11);
            if (bLConstraintLayout != null) {
                i11 = R$id.cl_root;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
                if (coordinatorLayout != null) {
                    i11 = R$id.fl_content;
                    FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.fl_loading;
                        BLFrameLayout bLFrameLayout = (BLFrameLayout) n6.b.a(view, i11);
                        if (bLFrameLayout != null) {
                            i11 = R$id.fl_select_all_bg;
                            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                            if (frameLayout2 != null) {
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
                                                                            if (appCompatTextView6 != null) {
                                                                                i11 = R$id.v_bottom;
                                                                                ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                                                                                if (constraintLayout != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_content_gap))) != null) {
                                                                                    i11 = R$id.vGridTab;
                                                                                    DownloadGridTabView downloadGridTabView = (DownloadGridTabView) n6.b.a(view, i11);
                                                                                    if (downloadGridTabView != null) {
                                                                                        i11 = R$id.v_language_resolution;
                                                                                        DownloadResolutionTabView downloadResolutionTabView = (DownloadResolutionTabView) n6.b.a(view, i11);
                                                                                        if (downloadResolutionTabView != null) {
                                                                                            i11 = R$id.viewAd;
                                                                                            DownloadMovieAdView downloadMovieAdView = (DownloadMovieAdView) n6.b.a(view, i11);
                                                                                            if (downloadMovieAdView != null) {
                                                                                                i11 = R$id.view_load;
                                                                                                ProgressBar progressBar3 = (ProgressBar) n6.b.a(view, i11);
                                                                                                if (progressBar3 != null) {
                                                                                                    return new b0((FrameLayout) view, linearLayoutCompat, bLConstraintLayout, coordinatorLayout, frameLayout, bLFrameLayout, frameLayout2, appCompatImageView, appCompatImageView2, imageView, viewA, linearLayout, progressBar, progressBar2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, constraintLayout, viewA2, downloadGridTabView, downloadResolutionTabView, downloadMovieAdView, progressBar3);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static b0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static b0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_res_group_main, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f65722a;
    }
}
