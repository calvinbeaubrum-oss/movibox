package fr;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.audio.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65239d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65245k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f65246l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f65247m;

    public d(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull AppCompatImageView appCompatImageView5, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f65236a = constraintLayout;
        this.f65237b = constraintLayout2;
        this.f65238c = constraintLayout3;
        this.f65239d = constraintLayout4;
        this.f65240f = appCompatImageView;
        this.f65241g = appCompatImageView2;
        this.f65242h = appCompatImageView3;
        this.f65243i = appCompatImageView4;
        this.f65244j = appCompatImageView5;
        this.f65245k = progressBar;
        this.f65246l = textView;
        this.f65247m = textView2;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.clExpansion;
        ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.clPackUp;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
            if (constraintLayout2 != null) {
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                i11 = R$id.iv_history;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.iv_next;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.ivPackUp;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.iv_play;
                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView4 != null) {
                                i11 = R$id.iv_remove;
                                AppCompatImageView appCompatImageView5 = (AppCompatImageView) n6.b.a(view, i11);
                                if (appCompatImageView5 != null) {
                                    i11 = R$id.pbSubject;
                                    ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                                    if (progressBar != null) {
                                        i11 = R$id.tvAudioName;
                                        TextView textView = (TextView) n6.b.a(view, i11);
                                        if (textView != null) {
                                            i11 = R$id.tvAudioTime;
                                            TextView textView2 = (TextView) n6.b.a(view, i11);
                                            if (textView2 != null) {
                                                return new d(constraintLayout3, constraintLayout, constraintLayout2, constraintLayout3, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, progressBar, textView, textView2);
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

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f65236a;
    }
}
