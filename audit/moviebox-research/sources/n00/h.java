package n00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.phone.widget.LoginPwdEditText;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f71420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LoginPwdEditText f71421d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final l f71422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ViewStub f71425i;

    public h(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatButton appCompatButton, @NonNull LoginPwdEditText loginPwdEditText, @NonNull l lVar, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull ViewStub viewStub) {
        this.f71418a = linearLayout;
        this.f71419b = appCompatImageView;
        this.f71420c = appCompatButton;
        this.f71421d = loginPwdEditText;
        this.f71422f = lVar;
        this.f71423g = appCompatTextView;
        this.f71424h = appCompatTextView2;
        this.f71425i = viewStub;
    }

    @NonNull
    public static h a(@NonNull View view) {
        View viewA;
        int i11 = R$id.btn_eye;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.btn_login;
            AppCompatButton appCompatButton = (AppCompatButton) n6.b.a(view, i11);
            if (appCompatButton != null) {
                i11 = R$id.et_pwd;
                LoginPwdEditText loginPwdEditText = (LoginPwdEditText) n6.b.a(view, i11);
                if (loginPwdEditText != null && (viewA = n6.b.a(view, (i11 = R$id.title))) != null) {
                    l lVarA = l.a(viewA);
                    i11 = R$id.tv_tips;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_welcome;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.vs_invitation_code;
                            ViewStub viewStub = (ViewStub) n6.b.a(view, i11);
                            if (viewStub != null) {
                                return new h((LinearLayout) view, appCompatImageView, appCompatButton, loginPwdEditText, lVarA, appCompatTextView, appCompatTextView2, viewStub);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static h c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.login_activity_phone_set_pwd, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f71418a;
    }
}
