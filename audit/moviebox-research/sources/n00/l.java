package n00;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.login.R$id;
import com.transsnet.login.widget.LoginProgressBar;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class l implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LoginProgressBar f71449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71450d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71451f;

    public l(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull LoginProgressBar loginProgressBar, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f71447a = constraintLayout;
        this.f71448b = appCompatImageView;
        this.f71449c = loginProgressBar;
        this.f71450d = appCompatTextView;
        this.f71451f = appCompatTextView2;
    }

    @NonNull
    public static l a(@NonNull View view) {
        int i11 = R$id.btn_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.progress;
            LoginProgressBar loginProgressBar = (LoginProgressBar) n6.b.a(view, i11);
            if (loginProgressBar != null) {
                i11 = R$id.tv_progress;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        return new l((ConstraintLayout) view, appCompatImageView, loginProgressBar, appCompatTextView, appCompatTextView2);
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
        return this.f71447a;
    }
}
