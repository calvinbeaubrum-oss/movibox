package n00;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.login.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class k implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f71442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f71444d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71446g;

    public k(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatImageView appCompatImageView, @NonNull View view, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f71441a = constraintLayout;
        this.f71442b = appCompatEditText;
        this.f71443c = appCompatImageView;
        this.f71444d = view;
        this.f71445f = appCompatTextView;
        this.f71446g = appCompatTextView2;
    }

    @NonNull
    public static k a(@NonNull View view) {
        View viewA;
        int i11 = R$id.et_code;
        AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
        if (appCompatEditText != null) {
            i11 = R$id.iv_help;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null && (viewA = n6.b.a(view, (i11 = R$id.line))) != null) {
                i11 = R$id.tv_hava_invitation_code;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_tips;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        return new k((ConstraintLayout) view, appCompatEditText, appCompatImageView, viewA, appCompatTextView, appCompatTextView2);
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
        return this.f71441a;
    }
}
