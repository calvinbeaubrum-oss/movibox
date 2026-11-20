package rz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f75828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Barrier f75829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f75831d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f75832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f75835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f75836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75841o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75842p;

    public g(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull AppCompatImageView appCompatImageView, @NonNull ShapeableImageView shapeableImageView, @NonNull View view, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull LinearLayout linearLayout, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6) {
        this.f75828a = constraintLayout;
        this.f75829b = barrier;
        this.f75830c = appCompatImageView;
        this.f75831d = shapeableImageView;
        this.f75832f = view;
        this.f75833g = appCompatImageView2;
        this.f75834h = appCompatImageView3;
        this.f75835i = linearLayout;
        this.f75836j = linearLayoutCompat;
        this.f75837k = appCompatTextView;
        this.f75838l = appCompatTextView2;
        this.f75839m = appCompatTextView3;
        this.f75840n = appCompatTextView4;
        this.f75841o = appCompatTextView5;
        this.f75842p = appCompatTextView6;
    }

    @NonNull
    public static g a(@NonNull View view) {
        View viewA;
        int i11 = R$id.barrierMovieCoverBottom;
        Barrier barrier = (Barrier) n6.b.a(view, i11);
        if (barrier != null) {
            i11 = R$id.ivMovieContent;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.ivMovieCover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                if (shapeableImageView != null && (viewA = n6.b.a(view, (i11 = R$id.ivMovieCoverMask))) != null) {
                    i11 = R$id.iv_score;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.iv_subtitle_tag;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.ll_score;
                            LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.tv_header_toolbar;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                                if (linearLayoutCompat != null) {
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
                                                            return new g((ConstraintLayout) view, barrier, appCompatImageView, shapeableImageView, viewA, appCompatImageView2, appCompatImageView3, linearLayout, linearLayoutCompat, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6);
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
    public static g c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subject_detail_info, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75828a;
    }
}
