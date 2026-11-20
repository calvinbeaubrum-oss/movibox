package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77582d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f77585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f77586i;

    public q(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull View view, @NonNull View view2) {
        this.f77579a = constraintLayout;
        this.f77580b = frameLayout;
        this.f77581c = appCompatImageView;
        this.f77582d = appCompatTextView;
        this.f77583f = appCompatTextView2;
        this.f77584g = appCompatTextView3;
        this.f77585h = view;
        this.f77586i = view2;
    }

    @NonNull
    public static q a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.ivCollection;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tvMovieInfo;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tvMovieTitle;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.tvTag;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView3 != null && (viewA = n6.b.a(view, (i11 = R$id.v_detail_hot_zone))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_line))) != null) {
                            return new q((ConstraintLayout) view, frameLayout, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, viewA, viewA2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static q c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static q d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subject_edu_music_header, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77579a;
    }
}
