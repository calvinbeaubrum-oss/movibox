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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class j implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageButton f71433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f71434d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f71435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f71436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71440k;

    public j(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageButton appCompatImageButton, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatButton appCompatButton2, @NonNull AppCompatEditText appCompatEditText, @NonNull LinearLayout linearLayout2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3) {
        this.f71431a = linearLayout;
        this.f71432b = appCompatImageView;
        this.f71433c = appCompatImageButton;
        this.f71434d = appCompatButton;
        this.f71435f = appCompatButton2;
        this.f71436g = appCompatEditText;
        this.f71437h = linearLayout2;
        this.f71438i = appCompatTextView;
        this.f71439j = appCompatTextView2;
        this.f71440k = appCompatTextView3;
    }

    @NonNull
    public static j a(@NonNull View view) {
        int i11 = R$id.btn_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.btn_clear;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) n6.b.a(view, i11);
            if (appCompatImageButton != null) {
                i11 = R$id.btn_email;
                AppCompatButton appCompatButton = (AppCompatButton) n6.b.a(view, i11);
                if (appCompatButton != null) {
                    i11 = R$id.btn_login;
                    AppCompatButton appCompatButton2 = (AppCompatButton) n6.b.a(view, i11);
                    if (appCompatButton2 != null) {
                        i11 = R$id.et_phone;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
                        if (appCompatEditText != null) {
                            i11 = R$id.ll_input;
                            LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.tv_phone_country_code;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.tv_privacy;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.tv_tips;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            return new j((LinearLayout) view, appCompatImageView, appCompatImageButton, appCompatButton, appCompatButton2, appCompatEditText, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
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

    @NonNull
    public static j c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static j d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.login_fragment_phone, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f71431a;
    }
}
