package nx;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.transsion.shorttv.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f72166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f72167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ProgressBar f72169d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f72170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TabLayout f72171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f72174j;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull TabLayout tabLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull View view) {
        this.f72166a = constraintLayout;
        this.f72167b = frameLayout;
        this.f72168c = appCompatImageView;
        this.f72169d = progressBar;
        this.f72170f = recyclerView;
        this.f72171g = tabLayout;
        this.f72172h = appCompatTextView;
        this.f72173i = appCompatTextView2;
        this.f72174j = view;
    }

    @NonNull
    public static a a(@NonNull View view) {
        View viewA;
        int i11 = R$id.fl_auto;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.pb_loading;
                ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                if (progressBar != null) {
                    i11 = R$id.f57762rv;
                    RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                    if (recyclerView != null) {
                        i11 = R$id.tab;
                        TabLayout tabLayout = (TabLayout) n6.b.a(view, i11);
                        if (tabLayout != null) {
                            i11 = R$id.tv_auto_unlock;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_title;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null && (viewA = n6.b.a(view, (i11 = R$id.view_line))) != null) {
                                    return new a((ConstraintLayout) view, frameLayout, appCompatImageView, progressBar, recyclerView, tabLayout, appCompatTextView, appCompatTextView2, viewA);
                                }
                            }
                        }
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
        return this.f72166a;
    }
}
