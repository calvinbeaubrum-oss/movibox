package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Barrier f77602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f77603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77604d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f77606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77611l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77612m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77613n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77614o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77615p;

    public s(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull ShapeableImageView shapeableImageView, @NonNull View view2, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6) {
        this.f77601a = constraintLayout;
        this.f77602b = barrier;
        this.f77603c = view;
        this.f77604d = appCompatImageView;
        this.f77605f = shapeableImageView;
        this.f77606g = view2;
        this.f77607h = appCompatImageView2;
        this.f77608i = appCompatImageView3;
        this.f77609j = linearLayout;
        this.f77610k = appCompatTextView;
        this.f77611l = appCompatTextView2;
        this.f77612m = appCompatTextView3;
        this.f77613n = appCompatTextView4;
        this.f77614o = appCompatTextView5;
        this.f77615p = appCompatTextView6;
    }

    @NonNull
    public static s a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.barrierMovieCoverBottom;
        Barrier barrier = (Barrier) n6.b.a(view, i11);
        if (barrier != null && (viewA = n6.b.a(view, (i11 = R$id.ivCoverZoom))) != null) {
            i11 = R$id.ivMovieContent;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.ivMovieCover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                if (shapeableImageView != null && (viewA2 = n6.b.a(view, (i11 = R$id.ivMovieCoverMask))) != null) {
                    i11 = R$id.iv_score;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.iv_subtitle_tag;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.ll_score;
                            LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.tvMovieContent;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.tvMovieTitle;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.tv_score;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            i11 = R$id.tv_subtitle_more;
                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView4 != null) {
                                                i11 = R$id.tv_subtitle_tag;
                                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView5 != null) {
                                                    i11 = R$id.tv_time;
                                                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                    if (appCompatTextView6 != null) {
                                                        return new s((ConstraintLayout) view, barrier, viewA, appCompatImageView, shapeableImageView, viewA2, appCompatImageView2, appCompatImageView3, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6);
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
    public static s c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static s d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subject_movie_header, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77601a;
    }
}
