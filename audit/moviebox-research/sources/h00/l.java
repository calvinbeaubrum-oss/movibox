package h00;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class l implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CircleProgressBar f65930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65932d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f65933f;

    public l(@NonNull FrameLayout frameLayout, @NonNull CircleProgressBar circleProgressBar, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull View view) {
        this.f65929a = frameLayout;
        this.f65930b = circleProgressBar;
        this.f65931c = appCompatTextView;
        this.f65932d = appCompatTextView2;
        this.f65933f = view;
    }

    @NonNull
    public static l a(@NonNull View view) {
        View viewA;
        int i11 = R$id.progress_bar;
        CircleProgressBar circleProgressBar = (CircleProgressBar) n6.b.a(view, i11);
        if (circleProgressBar != null) {
            i11 = R$id.tv_progress;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_tips;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null && (viewA = n6.b.a(view, (i11 = R$id.v_bg))) != null) {
                    return new l((FrameLayout) view, circleProgressBar, appCompatTextView, appCompatTextView2, viewA);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f65929a;
    }
}
