package xy;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class v implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80978d;

    public v(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull EditTextWithClear editTextWithClear, @NonNull AppCompatTextView appCompatTextView2) {
        this.f80975a = constraintLayout;
        this.f80976b = appCompatTextView;
        this.f80977c = editTextWithClear;
        this.f80978d = appCompatTextView2;
    }

    @NonNull
    public static v a(@NonNull View view) {
        int i11 = R$id.btn_ok;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.et_web;
            EditTextWithClear editTextWithClear = (EditTextWithClear) n6.b.a(view, i11);
            if (editTextWithClear != null) {
                i11 = R$id.tv_title;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    return new v((ConstraintLayout) view, appCompatTextView, editTextWithClear, appCompatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80975a;
    }
}
