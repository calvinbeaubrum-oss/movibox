package xy;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class p implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80903d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80908j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80910l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80911m;

    public p(@NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull EditTextWithClear editTextWithClear, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatTextView appCompatTextView7, @NonNull AppCompatTextView appCompatTextView8, @NonNull AppCompatTextView appCompatTextView9, @NonNull AppCompatTextView appCompatTextView10) {
        this.f80900a = linearLayout;
        this.f80901b = appCompatTextView;
        this.f80902c = appCompatTextView2;
        this.f80903d = editTextWithClear;
        this.f80904f = appCompatTextView3;
        this.f80905g = appCompatTextView4;
        this.f80906h = appCompatTextView5;
        this.f80907i = appCompatTextView6;
        this.f80908j = appCompatTextView7;
        this.f80909k = appCompatTextView8;
        this.f80910l = appCompatTextView9;
        this.f80911m = appCompatTextView10;
    }

    @NonNull
    public static p a(@NonNull View view) {
        int i11 = R$id.btn_close;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_custom_host;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_custom_host;
                EditTextWithClear editTextWithClear = (EditTextWithClear) n6.b.a(view, i11);
                if (editTextWithClear != null) {
                    i11 = R$id.tv_host_1;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_host_2;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_host_3;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView5 != null) {
                                i11 = R$id.tv_host_4;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView6 != null) {
                                    i11 = R$id.tv_host_5;
                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView7 != null) {
                                        i11 = R$id.tv_host_6;
                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView8 != null) {
                                            i11 = R$id.tv_host_cur;
                                            AppCompatTextView appCompatTextView9 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView9 != null) {
                                                i11 = R$id.tv_reset;
                                                AppCompatTextView appCompatTextView10 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView10 != null) {
                                                    return new p((LinearLayout) view, appCompatTextView, appCompatTextView2, editTextWithClear, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, appCompatTextView10);
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

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f80900a;
    }
}
