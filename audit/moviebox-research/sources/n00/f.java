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
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f71396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f71398d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f71399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final l f71400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71402i;

    public f(@NonNull LinearLayout linearLayout, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatEditText appCompatEditText, @NonNull FrameLayout frameLayout, @NonNull l lVar, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3) {
        this.f71395a = linearLayout;
        this.f71396b = appCompatButton;
        this.f71397c = appCompatTextView;
        this.f71398d = appCompatEditText;
        this.f71399f = frameLayout;
        this.f71400g = lVar;
        this.f71401h = appCompatTextView2;
        this.f71402i = appCompatTextView3;
    }

    @NonNull
    public static f a(@NonNull View view) {
        View viewA;
        int i11 = R$id.btn_login;
        AppCompatButton appCompatButton = (AppCompatButton) n6.b.a(view, i11);
        if (appCompatButton != null) {
            i11 = R$id.btn_resend;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.et_code;
                AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
                if (appCompatEditText != null) {
                    i11 = R$id.ll_input;
                    FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout != null && (viewA = n6.b.a(view, (i11 = R$id.title))) != null) {
                        l lVarA = l.a(viewA);
                        i11 = R$id.tv_code_tips;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tv_tips;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView3 != null) {
                                return new f((LinearLayout) view, appCompatButton, appCompatTextView, appCompatEditText, frameLayout, lVarA, appCompatTextView2, appCompatTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.login_activity_phone_code, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f71395a;
    }
}
