package n00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageButton f71364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f71365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f71366d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final l f71367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71369h;

    public b(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageButton appCompatImageButton, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatEditText appCompatEditText, @NonNull l lVar, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f71363a = linearLayout;
        this.f71364b = appCompatImageButton;
        this.f71365c = appCompatButton;
        this.f71366d = appCompatEditText;
        this.f71367f = lVar;
        this.f71368g = appCompatTextView;
        this.f71369h = appCompatTextView2;
    }

    @NonNull
    public static b a(@NonNull View view) {
        View viewA;
        int i11 = R$id.btn_clear;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) n6.b.a(view, i11);
        if (appCompatImageButton != null) {
            i11 = R$id.btn_next;
            AppCompatButton appCompatButton = (AppCompatButton) n6.b.a(view, i11);
            if (appCompatButton != null) {
                i11 = R$id.et_email;
                AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
                if (appCompatEditText != null && (viewA = n6.b.a(view, (i11 = R$id.title))) != null) {
                    l lVarA = l.a(viewA);
                    i11 = R$id.tv_privacy;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_tips;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            return new b((LinearLayout) view, appCompatImageButton, appCompatButton, appCompatEditText, lVarA, appCompatTextView, appCompatTextView2);
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
        View viewInflate = layoutInflater.inflate(R$layout.login_activity_email, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f71363a;
    }
}
