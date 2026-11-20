package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.InfoExtendView;
import com.transsion.moviedetail.view.MovieDetailShareView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f77441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f77442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final InfoExtendView f77443d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final MovieDetailShareView f77447i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77448j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77449k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final RecyclerView f77450l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final Space f77451m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final Toolbar f77452n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final CollapsingToolbarLayout f77453o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f77454p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77455q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77456r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77457s;

    public c(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull InfoExtendView infoExtendView, @NonNull AppCompatImageView appCompatImageView, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull MovieDetailShareView movieDetailShareView, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull RecyclerView recyclerView, @NonNull Space space, @NonNull Toolbar toolbar, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull TextView textView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3) {
        this.f77440a = constraintLayout;
        this.f77441b = appBarLayout;
        this.f77442c = coordinatorLayout;
        this.f77443d = infoExtendView;
        this.f77444f = appCompatImageView;
        this.f77445g = shapeableImageView;
        this.f77446h = appCompatImageView2;
        this.f77447i = movieDetailShareView;
        this.f77448j = appCompatImageView3;
        this.f77449k = appCompatImageView4;
        this.f77450l = recyclerView;
        this.f77451m = space;
        this.f77452n = toolbar;
        this.f77453o = collapsingToolbarLayout;
        this.f77454p = textView;
        this.f77455q = appCompatTextView;
        this.f77456r = appCompatTextView2;
        this.f77457s = appCompatTextView3;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i11 = R$id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
        if (appBarLayout != null) {
            i11 = R$id.cdl;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
            if (coordinatorLayout != null) {
                i11 = R$id.infoExtendView;
                InfoExtendView infoExtendView = (InfoExtendView) n6.b.a(view, i11);
                if (infoExtendView != null) {
                    i11 = R$id.ivBack;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ivCoverSmall;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                        if (shapeableImageView != null) {
                            i11 = R$id.ivDownload;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.ivShare;
                                MovieDetailShareView movieDetailShareView = (MovieDetailShareView) n6.b.a(view, i11);
                                if (movieDetailShareView != null) {
                                    i11 = R$id.iv_staff;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                    if (appCompatImageView3 != null) {
                                        i11 = R$id.iv_want_see;
                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                                        if (appCompatImageView4 != null) {
                                            i11 = R$id.f53421rv;
                                            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                            if (recyclerView != null) {
                                                i11 = R$id.f53422sp;
                                                Space space = (Space) n6.b.a(view, i11);
                                                if (space != null) {
                                                    i11 = R$id.toolbar;
                                                    Toolbar toolbar = (Toolbar) n6.b.a(view, i11);
                                                    if (toolbar != null) {
                                                        i11 = R$id.toolbar_layout;
                                                        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) n6.b.a(view, i11);
                                                        if (collapsingToolbarLayout != null) {
                                                            i11 = R$id.tv_filmography;
                                                            TextView textView = (TextView) n6.b.a(view, i11);
                                                            if (textView != null) {
                                                                i11 = R$id.tv_staff_desc;
                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView != null) {
                                                                    i11 = R$id.tv_staff_name;
                                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                                    if (appCompatTextView2 != null) {
                                                                        i11 = R$id.tvTitle;
                                                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                                        if (appCompatTextView3 != null) {
                                                                            return new c((ConstraintLayout) view, appBarLayout, coordinatorLayout, infoExtendView, appCompatImageView, shapeableImageView, appCompatImageView2, movieDetailShareView, appCompatImageView3, appCompatImageView4, recyclerView, space, toolbar, collapsingToolbarLayout, textView, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_movie_staff, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77440a;
    }
}
