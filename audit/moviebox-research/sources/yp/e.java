package yp;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.widget.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f81595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f81596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ProgressBar f81597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f81598d;

    public e(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull ProgressBar progressBar, @NonNull AppCompatTextView appCompatTextView) {
        this.f81595a = view;
        this.f81596b = appCompatImageView;
        this.f81597c = progressBar;
        this.f81598d = appCompatTextView;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.iv_join;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.tv_join;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    return new e(view, appCompatImageView, progressBar, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f81595a;
    }
}
