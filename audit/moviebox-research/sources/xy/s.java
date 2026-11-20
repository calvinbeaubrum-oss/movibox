package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class s implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80955d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80962l;

    public s(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull EditTextWithClear editTextWithClear, @NonNull EditTextWithClear editTextWithClear2, @NonNull EditTextWithClear editTextWithClear3, @NonNull EditTextWithClear editTextWithClear4, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6) {
        this.f80952a = constraintLayout;
        this.f80953b = appCompatTextView;
        this.f80954c = appCompatTextView2;
        this.f80955d = editTextWithClear;
        this.f80956f = editTextWithClear2;
        this.f80957g = editTextWithClear3;
        this.f80958h = editTextWithClear4;
        this.f80959i = appCompatTextView3;
        this.f80960j = appCompatTextView4;
        this.f80961k = appCompatTextView5;
        this.f80962l = appCompatTextView6;
    }

    @NonNull
    public static s a(@NonNull View view) {
        int i11 = R$id.btn_ok;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_rest;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_address;
                EditTextWithClear editTextWithClear = (EditTextWithClear) n6.b.a(view, i11);
                if (editTextWithClear != null) {
                    i11 = R$id.et_lat;
                    EditTextWithClear editTextWithClear2 = (EditTextWithClear) n6.b.a(view, i11);
                    if (editTextWithClear2 != null) {
                        i11 = R$id.et_lon;
                        EditTextWithClear editTextWithClear3 = (EditTextWithClear) n6.b.a(view, i11);
                        if (editTextWithClear3 != null) {
                            i11 = R$id.et_name;
                            EditTextWithClear editTextWithClear4 = (EditTextWithClear) n6.b.a(view, i11);
                            if (editTextWithClear4 != null) {
                                i11 = R$id.tv_address;
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView3 != null) {
                                    i11 = R$id.tv_lat;
                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView4 != null) {
                                        i11 = R$id.tv_lon;
                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView5 != null) {
                                            i11 = R$id.tv_name;
                                            AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView6 != null) {
                                                return new s((ConstraintLayout) view, appCompatTextView, appCompatTextView2, editTextWithClear, editTextWithClear2, editTextWithClear3, editTextWithClear4, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6);
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
    public static s c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_lab_location, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80952a;
    }
}
