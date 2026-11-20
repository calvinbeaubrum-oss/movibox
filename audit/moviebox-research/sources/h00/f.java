package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final s0 f65832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65834d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TnTextView f65837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TnTextView f65840k;

    public f(@NonNull ConstraintLayout constraintLayout, @NonNull s0 s0Var, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ProgressBar progressBar, @NonNull TnTextView tnTextView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull TnTextView tnTextView2) {
        this.f65831a = constraintLayout;
        this.f65832b = s0Var;
        this.f65833c = constraintLayout2;
        this.f65834d = appCompatImageView;
        this.f65835f = appCompatImageView2;
        this.f65836g = progressBar;
        this.f65837h = tnTextView;
        this.f65838i = appCompatTextView;
        this.f65839j = appCompatTextView2;
        this.f65840k = tnTextView2;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.card_cover;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            s0 s0VarA = s0.a(viewA);
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.iv_more;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_state_bg;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.pb_download;
                    ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                    if (progressBar != null) {
                        i11 = R$id.tv_ep;
                        TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                        if (tnTextView != null) {
                            i11 = R$id.tv_name;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_state_progress;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.tv_time_or_status;
                                    TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                                    if (tnTextView2 != null) {
                                        return new f(constraintLayout, s0VarA, constraintLayout, appCompatImageView, appCompatImageView2, progressBar, tnTextView, appCompatTextView, appCompatTextView2, tnTextView2);
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
    public static f c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.adapter_downloading_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f65831a;
    }
}
