package xy;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class t implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditText f80966d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextInputLayout f80967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80968g;

    public t(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull EditText editText, @NonNull TextInputLayout textInputLayout, @NonNull AppCompatTextView appCompatTextView3) {
        this.f80963a = constraintLayout;
        this.f80964b = appCompatTextView;
        this.f80965c = appCompatTextView2;
        this.f80966d = editText;
        this.f80967f = textInputLayout;
        this.f80968g = appCompatTextView3;
    }

    @NonNull
    public static t a(@NonNull View view) {
        int i11 = R$id.btn_cancel;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_ok;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_pwd;
                EditText editText = (EditText) n6.b.a(view, i11);
                if (editText != null) {
                    i11 = R$id.til_pwd;
                    TextInputLayout textInputLayout = (TextInputLayout) n6.b.a(view, i11);
                    if (textInputLayout != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            return new t((ConstraintLayout) view, appCompatTextView, appCompatTextView2, editText, textInputLayout, appCompatTextView3);
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
        return this.f80963a;
    }
}
