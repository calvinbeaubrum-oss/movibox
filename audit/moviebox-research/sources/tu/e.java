package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.InfoExtendView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Flow f77467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final InfoExtendView f77468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77469d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f77475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final CustomTextViewGroup f77477m;

    public e(@NonNull ConstraintLayout constraintLayout, @NonNull Flow flow, @NonNull InfoExtendView infoExtendView, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayout linearLayout, @NonNull CustomTextViewGroup customTextViewGroup, @NonNull AppCompatImageView appCompatImageView2, @NonNull CustomTextViewGroup customTextViewGroup2, @NonNull CustomTextViewGroup customTextViewGroup3, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatTextView appCompatTextView, @NonNull CustomTextViewGroup customTextViewGroup4) {
        this.f77466a = constraintLayout;
        this.f77467b = flow;
        this.f77468c = infoExtendView;
        this.f77469d = appCompatImageView;
        this.f77470f = linearLayout;
        this.f77471g = customTextViewGroup;
        this.f77472h = appCompatImageView2;
        this.f77473i = customTextViewGroup2;
        this.f77474j = customTextViewGroup3;
        this.f77475k = linearLayoutCompat;
        this.f77476l = appCompatTextView;
        this.f77477m = customTextViewGroup4;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.flow;
        Flow flow = (Flow) n6.b.a(view, i11);
        if (flow != null) {
            i11 = R$id.infoExtendView;
            InfoExtendView infoExtendView = (InfoExtendView) n6.b.a(view, i11);
            if (infoExtendView != null) {
                i11 = R$id.ivMovieContent;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ll_score;
                    LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.tv_category;
                        CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) n6.b.a(view, i11);
                        if (customTextViewGroup != null) {
                            i11 = R$id.tv_close;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.tv_duration;
                                CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) n6.b.a(view, i11);
                                if (customTextViewGroup2 != null) {
                                    i11 = R$id.tv_genre;
                                    CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) n6.b.a(view, i11);
                                    if (customTextViewGroup3 != null) {
                                        i11 = R$id.tv_header_toolbar;
                                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                                        if (linearLayoutCompat != null) {
                                            i11 = R$id.tvMovieTitle;
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView != null) {
                                                i11 = R$id.tv_students;
                                                CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) n6.b.a(view, i11);
                                                if (customTextViewGroup4 != null) {
                                                    return new e((ConstraintLayout) view, flow, infoExtendView, appCompatImageView, linearLayout, customTextViewGroup, appCompatImageView2, customTextViewGroup2, customTextViewGroup3, linearLayoutCompat, appCompatTextView, customTextViewGroup4);
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
    public static e c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_edu_info_dialog, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77466a;
    }
}
