package xy;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class l implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80849d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80855k;

    public l(@NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull EditTextWithClear editTextWithClear, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatTextView appCompatTextView7, @NonNull AppCompatTextView appCompatTextView8) {
        this.f80846a = linearLayout;
        this.f80847b = appCompatTextView;
        this.f80848c = appCompatTextView2;
        this.f80849d = editTextWithClear;
        this.f80850f = appCompatTextView3;
        this.f80851g = appCompatTextView4;
        this.f80852h = appCompatTextView5;
        this.f80853i = appCompatTextView6;
        this.f80854j = appCompatTextView7;
        this.f80855k = appCompatTextView8;
    }

    @NonNull
    public static l a(@NonNull View view) {
        int i11 = R$id.btn_close;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_custom_brand;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_custom_brand;
                EditTextWithClear editTextWithClear = (EditTextWithClear) n6.b.a(view, i11);
                if (editTextWithClear != null) {
                    i11 = R$id.tv_lane_cur;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_lane_infinix;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_lane_itel;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView5 != null) {
                                i11 = R$id.tv_lane_samsung;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView6 != null) {
                                    i11 = R$id.tv_lane_tecno;
                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView7 != null) {
                                        i11 = R$id.tv_reset;
                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView8 != null) {
                                            return new l((LinearLayout) view, appCompatTextView, appCompatTextView2, editTextWithClear, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8);
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

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f80846a;
    }
}
