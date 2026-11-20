package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.DownloadInfoExtendView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g0 implements n6.a {

    @NonNull
    public final AppCompatTextView A;

    @NonNull
    public final AppCompatTextView B;

    @NonNull
    public final AppCompatTextView C;

    @NonNull
    public final AppCompatTextView D;

    @NonNull
    public final AppCompatTextView E;

    @NonNull
    public final View F;

    @NonNull
    public final View G;

    @NonNull
    public final BLView H;

    @NonNull
    public final ProgressBar I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLConstraintLayout f65853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f65854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f65855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f65856d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f65857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLFrameLayout f65858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final DownloadInfoExtendView f65861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65863l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final ImageView f65864m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f65865n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final BLImageView f65866o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final BLImageView f65867p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65868q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65869r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final RecyclerView f65870s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final RecyclerView f65871t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final TabLayout f65872u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final View f65873v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65874w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65875x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final TextView f65876y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65877z;

    public g0(@NonNull BLConstraintLayout bLConstraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull CoordinatorLayout coordinatorLayout, @NonNull BLFrameLayout bLFrameLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull DownloadInfoExtendView downloadInfoExtendView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ImageView imageView, @NonNull ShapeableImageView shapeableImageView, @NonNull BLImageView bLImageView, @NonNull BLImageView bLImageView2, @NonNull ProgressBar progressBar, @NonNull ProgressBar progressBar2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull TabLayout tabLayout, @NonNull View view2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull TextView textView, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatTextView appCompatTextView7, @NonNull AppCompatTextView appCompatTextView8, @NonNull View view3, @NonNull View view4, @NonNull BLView bLView, @NonNull ProgressBar progressBar3) {
        this.f65853a = bLConstraintLayout;
        this.f65854b = appBarLayout;
        this.f65855c = view;
        this.f65856d = linearLayoutCompat;
        this.f65857f = coordinatorLayout;
        this.f65858g = bLFrameLayout;
        this.f65859h = frameLayout;
        this.f65860i = frameLayout2;
        this.f65861j = downloadInfoExtendView;
        this.f65862k = appCompatImageView;
        this.f65863l = appCompatImageView2;
        this.f65864m = imageView;
        this.f65865n = shapeableImageView;
        this.f65866o = bLImageView;
        this.f65867p = bLImageView2;
        this.f65868q = progressBar;
        this.f65869r = progressBar2;
        this.f65870s = recyclerView;
        this.f65871t = recyclerView2;
        this.f65872u = tabLayout;
        this.f65873v = view2;
        this.f65874w = appCompatTextView;
        this.f65875x = appCompatTextView2;
        this.f65876y = textView;
        this.f65877z = appCompatTextView3;
        this.A = appCompatTextView4;
        this.B = appCompatTextView5;
        this.C = appCompatTextView6;
        this.D = appCompatTextView7;
        this.E = appCompatTextView8;
        this.F = view3;
        this.G = view4;
        this.H = bLView;
        this.I = progressBar3;
    }

    @NonNull
    public static g0 a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i11 = R$id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
        if (appBarLayout != null && (viewA = n6.b.a(view, (i11 = R$id.bottom_line))) != null) {
            i11 = R$id.btn_download;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.cl_root;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
                if (coordinatorLayout != null) {
                    i11 = R$id.fl_download_loading;
                    BLFrameLayout bLFrameLayout = (BLFrameLayout) n6.b.a(view, i11);
                    if (bLFrameLayout != null) {
                        i11 = R$id.fl_select_all_bg;
                        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                        if (frameLayout != null) {
                            i11 = R$id.fl_state;
                            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                            if (frameLayout2 != null) {
                                i11 = R$id.iev_info;
                                DownloadInfoExtendView downloadInfoExtendView = (DownloadInfoExtendView) n6.b.a(view, i11);
                                if (downloadInfoExtendView != null) {
                                    i11 = R$id.iv_btn_download_icon;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                                    if (appCompatImageView != null) {
                                        i11 = R$id.iv_check;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                        if (appCompatImageView2 != null) {
                                            i11 = R$id.iv_close;
                                            ImageView imageView = (ImageView) n6.b.a(view, i11);
                                            if (imageView != null) {
                                                i11 = R$id.iv_cover;
                                                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                                                if (shapeableImageView != null) {
                                                    i11 = R$id.iv_favorite;
                                                    BLImageView bLImageView = (BLImageView) n6.b.a(view, i11);
                                                    if (bLImageView != null) {
                                                        i11 = R$id.iv_share;
                                                        BLImageView bLImageView2 = (BLImageView) n6.b.a(view, i11);
                                                        if (bLImageView2 != null) {
                                                            i11 = R$id.progress_bar_btn_download;
                                                            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                                                            if (progressBar != null) {
                                                                i11 = R$id.progress_bar_select_all;
                                                                ProgressBar progressBar2 = (ProgressBar) n6.b.a(view, i11);
                                                                if (progressBar2 != null) {
                                                                    i11 = R$id.recycler_view;
                                                                    RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                                                    if (recyclerView != null) {
                                                                        i11 = R$id.recycler_view_tags;
                                                                        RecyclerView recyclerView2 = (RecyclerView) n6.b.a(view, i11);
                                                                        if (recyclerView2 != null) {
                                                                            i11 = R$id.tab_ep_title;
                                                                            TabLayout tabLayout = (TabLayout) n6.b.a(view, i11);
                                                                            if (tabLayout != null && (viewA2 = n6.b.a(view, (i11 = R$id.title_line))) != null) {
                                                                                i11 = R$id.tv_btn_download;
                                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                                                if (appCompatTextView != null) {
                                                                                    i11 = R$id.tv_download_ep_count;
                                                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                    if (appCompatTextView2 != null) {
                                                                                        i11 = R$id.tv_download_title;
                                                                                        TextView textView = (TextView) n6.b.a(view, i11);
                                                                                        if (textView != null) {
                                                                                            i11 = R$id.tv_genre;
                                                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                            if (appCompatTextView3 != null) {
                                                                                                i11 = R$id.tv_play_title;
                                                                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                                if (appCompatTextView4 != null) {
                                                                                                    i11 = R$id.tv_select_all;
                                                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                                    if (appCompatTextView5 != null) {
                                                                                                        i11 = R$id.tv_tips;
                                                                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                                        if (appCompatTextView6 != null) {
                                                                                                            i11 = R$id.tv_title;
                                                                                                            AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                                            if (appCompatTextView7 != null) {
                                                                                                                i11 = R$id.tv_title_2;
                                                                                                                AppCompatTextView appCompatTextView8 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                                                if (appCompatTextView8 != null && (viewA3 = n6.b.a(view, (i11 = R$id.v_bottom))) != null && (viewA4 = n6.b.a(view, (i11 = R$id.v_content_gap))) != null) {
                                                                                                                    i11 = R$id.v_play;
                                                                                                                    BLView bLView = (BLView) n6.b.a(view, i11);
                                                                                                                    if (bLView != null) {
                                                                                                                        i11 = R$id.view_load;
                                                                                                                        ProgressBar progressBar3 = (ProgressBar) n6.b.a(view, i11);
                                                                                                                        if (progressBar3 != null) {
                                                                                                                            return new g0((BLConstraintLayout) view, appBarLayout, viewA, linearLayoutCompat, coordinatorLayout, bLFrameLayout, frameLayout, frameLayout2, downloadInfoExtendView, appCompatImageView, appCompatImageView2, imageView, shapeableImageView, bLImageView, bLImageView2, progressBar, progressBar2, recyclerView, recyclerView2, tabLayout, viewA2, appCompatTextView, appCompatTextView2, textView, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, viewA3, viewA4, bLView, progressBar3);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static g0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static g0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_res_short_tv, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f65853a;
    }
}
