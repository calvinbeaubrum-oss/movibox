package xy;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class n implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80872d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80876i;

    public n(@NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull EditTextWithClear editTextWithClear, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6) {
        this.f80869a = linearLayout;
        this.f80870b = appCompatTextView;
        this.f80871c = appCompatTextView2;
        this.f80872d = editTextWithClear;
        this.f80873f = appCompatTextView3;
        this.f80874g = appCompatTextView4;
        this.f80875h = appCompatTextView5;
        this.f80876i = appCompatTextView6;
    }

    @NonNull
    public static n a(@NonNull View view) {
        int i11 = R$id.btn_close;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_custom_lane;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_custom_cn;
                EditTextWithClear editTextWithClear = (EditTextWithClear) n6.b.a(view, i11);
                if (editTextWithClear != null) {
                    i11 = R$id.tv_lane_cur;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_lane_ke;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_lane_ng;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView5 != null) {
                                i11 = R$id.tv_reset;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView6 != null) {
                                    return new n((LinearLayout) view, appCompatTextView, appCompatTextView2, editTextWithClear, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6);
                                }
                            }
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
    public LinearLayout getRoot() {
        return this.f80869a;
    }
}
