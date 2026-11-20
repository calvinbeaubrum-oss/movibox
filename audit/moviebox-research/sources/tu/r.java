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
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77590d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f77594i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77595j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77596k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77597l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77598m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77599n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77600o;

    public r(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull LinearLayout linearLayout, @NonNull CustomTextViewGroup customTextViewGroup, @NonNull AppCompatTextView appCompatTextView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull CustomTextViewGroup customTextViewGroup2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatTextView appCompatTextView2, @NonNull CustomTextViewGroup customTextViewGroup3, @NonNull CustomTextViewGroup customTextViewGroup4, @NonNull CustomTextViewGroup customTextViewGroup5) {
        this.f77587a = constraintLayout;
        this.f77588b = frameLayout;
        this.f77589c = appCompatImageView;
        this.f77590d = appCompatImageView2;
        this.f77591f = linearLayout;
        this.f77592g = customTextViewGroup;
        this.f77593h = appCompatTextView;
        this.f77594i = linearLayoutCompat;
        this.f77595j = customTextViewGroup2;
        this.f77596k = appCompatImageView3;
        this.f77597l = appCompatTextView2;
        this.f77598m = customTextViewGroup3;
        this.f77599n = customTextViewGroup4;
        this.f77600o = customTextViewGroup5;
    }

    @NonNull
    public static r a(@NonNull View view) {
        int i11 = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.ivMovieContent;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_score;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.ll_score;
                    LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.tv_country;
                        CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) n6.b.a(view, i11);
                        if (customTextViewGroup != null) {
                            i11 = R$id.tvMovieTitle;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_movie_title_container;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                                if (linearLayoutCompat != null) {
                                    i11 = R$id.tv_restrict;
                                    CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) n6.b.a(view, i11);
                                    if (customTextViewGroup2 != null) {
                                        i11 = R$id.tv_right;
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                        if (appCompatImageView3 != null) {
                                            i11 = R$id.tv_score;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView2 != null) {
                                                i11 = R$id.tv_seasons;
                                                CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                if (customTextViewGroup3 != null) {
                                                    i11 = R$id.tv_time;
                                                    CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                    if (customTextViewGroup4 != null) {
                                                        i11 = R$id.tv_type;
                                                        CustomTextViewGroup customTextViewGroup5 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                        if (customTextViewGroup5 != null) {
                                                            return new r((ConstraintLayout) view, frameLayout, appCompatImageView, appCompatImageView2, linearLayout, customTextViewGroup, appCompatTextView, linearLayoutCompat, customTextViewGroup2, appCompatImageView3, appCompatTextView2, customTextViewGroup3, customTextViewGroup4, customTextViewGroup5);
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
    public static r c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static r d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
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
        return this.f77587a;
    }
}
