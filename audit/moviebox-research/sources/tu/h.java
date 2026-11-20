package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsnet.downloader.widget.DownloadView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BubbleTextView f77483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f77484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final DownloadView f77485d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f77486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77492l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final mv.g f77493m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f77494n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f77495o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77496p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77497q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final CollapsingToolbarLayout f77498r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final View f77499s;

    public h(@NonNull ConstraintLayout constraintLayout, @NonNull BubbleTextView bubbleTextView, @NonNull AppBarLayout appBarLayout, @NonNull DownloadView downloadView, @NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull mv.g gVar, @NonNull MagicIndicator magicIndicator, @NonNull ViewPager2 viewPager2, @NonNull FrameLayout frameLayout5, @NonNull FrameLayout frameLayout6, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull View view) {
        this.f77482a = constraintLayout;
        this.f77483b = bubbleTextView;
        this.f77484c = appBarLayout;
        this.f77485d = downloadView;
        this.f77486f = coordinatorLayout;
        this.f77487g = frameLayout;
        this.f77488h = frameLayout2;
        this.f77489i = frameLayout3;
        this.f77490j = frameLayout4;
        this.f77491k = appCompatImageView;
        this.f77492l = appCompatImageView2;
        this.f77493m = gVar;
        this.f77494n = magicIndicator;
        this.f77495o = viewPager2;
        this.f77496p = frameLayout5;
        this.f77497q = frameLayout6;
        this.f77498r = collapsingToolbarLayout;
        this.f77499s = view;
    }

    @NonNull
    public static h a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.activity_tip;
        BubbleTextView bubbleTextView = (BubbleTextView) n6.b.a(view, i11);
        if (bubbleTextView != null) {
            i11 = R$id.appBar;
            AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
            if (appBarLayout != null) {
                i11 = R$id.btn_download;
                DownloadView downloadView = (DownloadView) n6.b.a(view, i11);
                if (downloadView != null) {
                    i11 = R$id.cdl;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
                    if (coordinatorLayout != null) {
                        i11 = R$id.fl_bottom_dialog_container;
                        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                        if (frameLayout != null) {
                            i11 = R$id.fl_full_player_container;
                            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                            if (frameLayout2 != null) {
                                i11 = R$id.fl_player;
                                FrameLayout frameLayout3 = (FrameLayout) n6.b.a(view, i11);
                                if (frameLayout3 != null) {
                                    i11 = R$id.game_container;
                                    FrameLayout frameLayout4 = (FrameLayout) n6.b.a(view, i11);
                                    if (frameLayout4 != null) {
                                        i11 = R$id.ivBack;
                                        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                                        if (appCompatImageView != null) {
                                            i11 = R$id.iv_publish;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                            if (appCompatImageView2 != null && (viewA = n6.b.a(view, (i11 = R$id.layout_sync_adjust))) != null) {
                                                mv.g gVarA = mv.g.a(viewA);
                                                i11 = R$id.magic_indicator;
                                                MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                                                if (magicIndicator != null) {
                                                    i11 = R$id.rec_view_pager;
                                                    ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                                    if (viewPager2 != null) {
                                                        i11 = R$id.resourceDetectorGroup;
                                                        FrameLayout frameLayout5 = (FrameLayout) n6.b.a(view, i11);
                                                        if (frameLayout5 != null) {
                                                            i11 = R$id.subjectDetailLayout;
                                                            FrameLayout frameLayout6 = (FrameLayout) n6.b.a(view, i11);
                                                            if (frameLayout6 != null) {
                                                                i11 = R$id.toolbar_layout;
                                                                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) n6.b.a(view, i11);
                                                                if (collapsingToolbarLayout != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_top_space))) != null) {
                                                                    return new h((ConstraintLayout) view, bubbleTextView, appBarLayout, downloadView, coordinatorLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4, appCompatImageView, appCompatImageView2, gVarA, magicIndicator, viewPager2, frameLayout5, frameLayout6, collapsingToolbarLayout, viewA2);
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
    public static h c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_movie_detail_v2_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77482a;
    }
}
