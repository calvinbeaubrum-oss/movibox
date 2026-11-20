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
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77570d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final View f77578m;

    public p(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayout linearLayout, @NonNull CustomTextViewGroup customTextViewGroup, @NonNull AppCompatTextView appCompatTextView, @NonNull CustomTextViewGroup customTextViewGroup2, @NonNull CustomTextViewGroup customTextViewGroup3, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull CustomTextViewGroup customTextViewGroup4, @NonNull View view) {
        this.f77567a = constraintLayout;
        this.f77568b = frameLayout;
        this.f77569c = appCompatImageView;
        this.f77570d = linearLayout;
        this.f77571f = customTextViewGroup;
        this.f77572g = appCompatTextView;
        this.f77573h = customTextViewGroup2;
        this.f77574i = customTextViewGroup3;
        this.f77575j = appCompatTextView2;
        this.f77576k = appCompatTextView3;
        this.f77577l = customTextViewGroup4;
        this.f77578m = view;
    }

    @NonNull
    public static p a(@NonNull View view) {
        View viewA;
        int i11 = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.ivMovieContent;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.ll_score;
                LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                if (linearLayout != null) {
                    i11 = R$id.tv_category;
                    CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) n6.b.a(view, i11);
                    if (customTextViewGroup != null) {
                        i11 = R$id.tvDes;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_duration;
                            CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) n6.b.a(view, i11);
                            if (customTextViewGroup2 != null) {
                                i11 = R$id.tv_genre;
                                CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) n6.b.a(view, i11);
                                if (customTextViewGroup3 != null) {
                                    i11 = R$id.tvMovieInfo;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.tvMovieTitle;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            i11 = R$id.tv_students;
                                            CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) n6.b.a(view, i11);
                                            if (customTextViewGroup4 != null && (viewA = n6.b.a(view, (i11 = R$id.v_detail_hot_zone))) != null) {
                                                return new p((ConstraintLayout) view, frameLayout, appCompatImageView, linearLayout, customTextViewGroup, appCompatTextView, customTextViewGroup2, customTextViewGroup3, appCompatTextView2, appCompatTextView3, customTextViewGroup4, viewA);
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
    public static p c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static p d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subject_edu_header, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77567a;
    }
}
