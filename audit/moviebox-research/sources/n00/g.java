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
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.phone.widget.LoginPwdEditText;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageButton f71405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71406d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f71408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f71409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final LoginPwdEditText f71410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71415n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71416o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final View f71417p;

    public g(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageButton appCompatImageButton, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatEditText appCompatEditText, @NonNull LoginPwdEditText loginPwdEditText, @NonNull AppCompatImageView appCompatImageView3, @NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull View view) {
        this.f71403a = linearLayout;
        this.f71404b = appCompatImageView;
        this.f71405c = appCompatImageButton;
        this.f71406d = appCompatTextView;
        this.f71407f = appCompatImageView2;
        this.f71408g = appCompatButton;
        this.f71409h = appCompatEditText;
        this.f71410i = loginPwdEditText;
        this.f71411j = appCompatImageView3;
        this.f71412k = constraintLayout;
        this.f71413l = appCompatTextView2;
        this.f71414m = appCompatTextView3;
        this.f71415n = appCompatTextView4;
        this.f71416o = appCompatTextView5;
        this.f71417p = view;
    }

    @NonNull
    public static g a(@NonNull View view) {
        View viewA;
        int i11 = R$id.btn_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.btn_clear;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) n6.b.a(view, i11);
            if (appCompatImageButton != null) {
                i11 = R$id.btn_email;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.btn_eye;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.btn_login;
                        AppCompatButton appCompatButton = (AppCompatButton) n6.b.a(view, i11);
                        if (appCompatButton != null) {
                            i11 = R$id.et_phone;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
                            if (appCompatEditText != null) {
                                i11 = R$id.et_pwd;
                                LoginPwdEditText loginPwdEditText = (LoginPwdEditText) n6.b.a(view, i11);
                                if (loginPwdEditText != null) {
                                    i11 = R$id.iv_arrow;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                    if (appCompatImageView3 != null) {
                                        i11 = R$id.ll_input;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                                        if (constraintLayout != null) {
                                            i11 = R$id.tv_forget_pwd;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView2 != null) {
                                                i11 = R$id.tv_phone_country_code;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView3 != null) {
                                                    i11 = R$id.tv_privacy;
                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                    if (appCompatTextView4 != null) {
                                                        i11 = R$id.tv_tips;
                                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView5 != null && (viewA = n6.b.a(view, (i11 = R$id.v_line))) != null) {
                                                            return new g((LinearLayout) view, appCompatImageView, appCompatImageButton, appCompatTextView, appCompatImageView2, appCompatButton, appCompatEditText, loginPwdEditText, appCompatImageView3, constraintLayout, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, viewA);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static g c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.login_activity_phone_pwd, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f71403a;
    }
}
