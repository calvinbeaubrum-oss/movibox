package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.InfoExtendView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final InfoExtendView f77550d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f77553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f77558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77560o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77561p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77563r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77564s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final View f77565t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final View f77566u;

    public o(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull InfoExtendView infoExtendView, @NonNull AppCompatImageView appCompatImageView, @NonNull ShapeableImageView shapeableImageView, @NonNull View view, @NonNull AppCompatImageView appCompatImageView2, @NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView3, @NonNull CustomTextViewGroup customTextViewGroup, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatTextView appCompatTextView, @NonNull CustomTextViewGroup customTextViewGroup2, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull CustomTextViewGroup customTextViewGroup3, @NonNull CustomTextViewGroup customTextViewGroup4, @NonNull View view2, @NonNull View view3) {
        this.f77547a = constraintLayout;
        this.f77548b = frameLayout;
        this.f77549c = frameLayout2;
        this.f77550d = infoExtendView;
        this.f77551f = appCompatImageView;
        this.f77552g = shapeableImageView;
        this.f77553h = view;
        this.f77554i = appCompatImageView2;
        this.f77555j = linearLayout;
        this.f77556k = appCompatImageView3;
        this.f77557l = customTextViewGroup;
        this.f77558m = linearLayoutCompat;
        this.f77559n = appCompatTextView;
        this.f77560o = customTextViewGroup2;
        this.f77561p = appCompatTextView2;
        this.f77562q = appCompatTextView3;
        this.f77563r = customTextViewGroup3;
        this.f77564s = customTextViewGroup4;
        this.f77565t = view2;
        this.f77566u = view3;
    }

    @NonNull
    public static o a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i11 = R$id.fl_starring;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.game_container;
            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout2 != null) {
                i11 = R$id.infoExtendView;
                InfoExtendView infoExtendView = (InfoExtendView) n6.b.a(view, i11);
                if (infoExtendView != null) {
                    i11 = R$id.ivMovieContent;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ivMovieCover;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                        if (shapeableImageView != null && (viewA = n6.b.a(view, (i11 = R$id.ivMovieCoverMask))) != null) {
                            i11 = R$id.iv_score;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.ll_score;
                                LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                if (linearLayout != null) {
                                    i11 = R$id.tv_close;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                    if (appCompatImageView3 != null) {
                                        i11 = R$id.tv_country;
                                        CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) n6.b.a(view, i11);
                                        if (customTextViewGroup != null) {
                                            i11 = R$id.tv_header_toolbar;
                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                                            if (linearLayoutCompat != null) {
                                                i11 = R$id.tvMovieTitle;
                                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView != null) {
                                                    i11 = R$id.tv_restrict;
                                                    CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                    if (customTextViewGroup2 != null) {
                                                        i11 = R$id.tv_score;
                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView2 != null) {
                                                            i11 = R$id.tv_seasons;
                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                            if (appCompatTextView3 != null) {
                                                                i11 = R$id.tv_time;
                                                                CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                                if (customTextViewGroup3 != null) {
                                                                    i11 = R$id.tv_type;
                                                                    CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                                    if (customTextViewGroup4 != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_seasons_line))) != null && (viewA3 = n6.b.a(view, (i11 = R$id.view_separator))) != null) {
                                                                        return new o((ConstraintLayout) view, frameLayout, frameLayout2, infoExtendView, appCompatImageView, shapeableImageView, viewA, appCompatImageView2, linearLayout, appCompatImageView3, customTextViewGroup, linearLayoutCompat, appCompatTextView, customTextViewGroup2, appCompatTextView2, appCompatTextView3, customTextViewGroup3, customTextViewGroup4, viewA2, viewA3);
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
    public static o c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static o d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subject_detail_info_dialog, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77547a;
    }
}
