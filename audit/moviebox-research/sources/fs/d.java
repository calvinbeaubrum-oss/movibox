package fs;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65266d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65268g;

    public d(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull ProgressBar progressBar) {
        this.f65263a = constraintLayout;
        this.f65264b = constraintLayout2;
        this.f65265c = appCompatImageView;
        this.f65266d = appCompatImageView2;
        this.f65267f = appCompatImageView3;
        this.f65268g = progressBar;
    }

    @NonNull
    public static d a(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.ivBackward;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivCenterPause;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivForward;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.progressBar;
                    ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                    if (progressBar != null) {
                        return new d(constraintLayout, constraintLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, progressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f65263a;
    }
}
