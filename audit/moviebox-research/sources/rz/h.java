package rz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f75843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f75846d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f75849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f75850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f75853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f75855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75856o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f75857p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f75858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final View f75859r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final View f75860s;

    public h(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull LinearLayout linearLayout, @NonNull CustomTextViewGroup customTextViewGroup, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull CustomTextViewGroup customTextViewGroup2, @NonNull AppCompatTextView appCompatTextView3, @NonNull CustomTextViewGroup customTextViewGroup3, @NonNull AppCompatTextView appCompatTextView4, @NonNull CustomTextViewGroup customTextViewGroup4, @NonNull CustomTextViewGroup customTextViewGroup5, @NonNull View view, @NonNull View view2) {
        this.f75843a = constraintLayout;
        this.f75844b = frameLayout;
        this.f75845c = appCompatImageView;
        this.f75846d = shapeableImageView;
        this.f75847f = appCompatImageView2;
        this.f75848g = appCompatImageView3;
        this.f75849h = linearLayout;
        this.f75850i = customTextViewGroup;
        this.f75851j = appCompatTextView;
        this.f75852k = appCompatTextView2;
        this.f75853l = customTextViewGroup2;
        this.f75854m = appCompatTextView3;
        this.f75855n = customTextViewGroup3;
        this.f75856o = appCompatTextView4;
        this.f75857p = customTextViewGroup4;
        this.f75858q = customTextViewGroup5;
        this.f75859r = view;
        this.f75860s = view2;
    }

    @NonNull
    public static h a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.ivMovieContent;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.ivMovieCover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.iv_preview;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.iv_score;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.ll_score;
                            LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.tv_country;
                                CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) n6.b.a(view, i11);
                                if (customTextViewGroup != null) {
                                    i11 = R$id.tvMovieInfo;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView != null) {
                                        i11 = R$id.tvMovieTitle;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            i11 = R$id.tv_restrict;
                                            CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) n6.b.a(view, i11);
                                            if (customTextViewGroup2 != null) {
                                                i11 = R$id.tv_score;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView3 != null) {
                                                    i11 = R$id.tv_seasons;
                                                    CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                    if (customTextViewGroup3 != null) {
                                                        i11 = R$id.tv_seasons_2;
                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView4 != null) {
                                                            i11 = R$id.tv_time;
                                                            CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                            if (customTextViewGroup4 != null) {
                                                                i11 = R$id.tv_type;
                                                                CustomTextViewGroup customTextViewGroup5 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                                if (customTextViewGroup5 != null && (viewA = n6.b.a(view, (i11 = R$id.v_detail_hot_zone))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_seasons_line_2))) != null) {
                                                                    return new h((ConstraintLayout) view, frameLayout, appCompatImageView, shapeableImageView, appCompatImageView2, appCompatImageView3, linearLayout, customTextViewGroup, appCompatTextView, appCompatTextView2, customTextViewGroup2, appCompatTextView3, customTextViewGroup3, appCompatTextView4, customTextViewGroup4, customTextViewGroup5, viewA, viewA2);
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
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subject_header, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75843a;
    }
}
