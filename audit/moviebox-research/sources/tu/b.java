package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77431d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RecyclerView f77434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f77435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77438l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f77439m;

    public b(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull NestedScrollView nestedScrollView, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull TextView textView) {
        this.f77428a = constraintLayout;
        this.f77429b = appCompatImageView;
        this.f77430c = appCompatImageView2;
        this.f77431d = appCompatImageView3;
        this.f77432f = appCompatImageView4;
        this.f77433g = linearLayout;
        this.f77434h = recyclerView;
        this.f77435i = nestedScrollView;
        this.f77436j = constraintLayout2;
        this.f77437k = appCompatTextView;
        this.f77438l = appCompatTextView2;
        this.f77439m = textView;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i11 = R$id.ivBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivCover;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivDownload;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.ivShare;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView4 != null) {
                        i11 = R$id.llContent;
                        LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                        if (linearLayout != null) {
                            i11 = R$id.rvStaff;
                            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                            if (recyclerView != null) {
                                i11 = R$id.scrollView;
                                NestedScrollView nestedScrollView = (NestedScrollView) n6.b.a(view, i11);
                                if (nestedScrollView != null) {
                                    i11 = R$id.topLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                                    if (constraintLayout != null) {
                                        i11 = R$id.tvMovieDesc;
                                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView != null) {
                                            i11 = R$id.tvMovieName;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView2 != null) {
                                                i11 = R$id.tvStaffTitle;
                                                TextView textView = (TextView) n6.b.a(view, i11);
                                                if (textView != null) {
                                                    return new b((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, linearLayout, recyclerView, nestedScrollView, constraintLayout, appCompatTextView, appCompatTextView2, textView);
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
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_movie_poster_detail, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77428a;
    }
}
