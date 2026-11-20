package n00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.transsnet.login.phone.widget.LoginPwdEditText;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageButton f71372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71373d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f71374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f71376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final LoginPwdEditText f71377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f71378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71381m;

    public c(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageButton appCompatImageButton, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatEditText appCompatEditText, @NonNull LoginPwdEditText loginPwdEditText, @NonNull FrameLayout frameLayout, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4) {
        this.f71370a = linearLayout;
        this.f71371b = appCompatImageView;
        this.f71372c = appCompatImageButton;
        this.f71373d = appCompatImageView2;
        this.f71374f = appCompatButton;
        this.f71375g = appCompatTextView;
        this.f71376h = appCompatEditText;
        this.f71377i = loginPwdEditText;
        this.f71378j = frameLayout;
        this.f71379k = appCompatTextView2;
        this.f71380l = appCompatTextView3;
        this.f71381m = appCompatTextView4;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i11 = R$id.btn_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.btn_clear;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) n6.b.a(view, i11);
            if (appCompatImageButton != null) {
                i11 = R$id.btn_eye;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.btn_login;
                    AppCompatButton appCompatButton = (AppCompatButton) n6.b.a(view, i11);
                    if (appCompatButton != null) {
                        i11 = R$id.btn_phone_login;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.et_mail;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
                            if (appCompatEditText != null) {
                                i11 = R$id.et_pwd;
                                LoginPwdEditText loginPwdEditText = (LoginPwdEditText) n6.b.a(view, i11);
                                if (loginPwdEditText != null) {
                                    i11 = R$id.ll_input;
                                    FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                                    if (frameLayout != null) {
                                        i11 = R$id.tv_forget_pwd;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            i11 = R$id.tv_privacy;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView3 != null) {
                                                i11 = R$id.tv_tips;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView4 != null) {
                                                    return new c((LinearLayout) view, appCompatImageView, appCompatImageButton, appCompatImageView2, appCompatButton, appCompatTextView, appCompatEditText, loginPwdEditText, frameLayout, appCompatTextView2, appCompatTextView3, appCompatTextView4);
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
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.login_activity_email_pwd, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f71370a;
    }
}
