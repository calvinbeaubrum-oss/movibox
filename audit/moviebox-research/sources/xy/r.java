package xy;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class r implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80934d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80940k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80941l;

    public r(@NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull EditTextWithClear editTextWithClear, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatTextView appCompatTextView7, @NonNull AppCompatTextView appCompatTextView8, @NonNull AppCompatTextView appCompatTextView9) {
        this.f80931a = linearLayout;
        this.f80932b = appCompatTextView;
        this.f80933c = appCompatTextView2;
        this.f80934d = editTextWithClear;
        this.f80935f = appCompatTextView3;
        this.f80936g = appCompatTextView4;
        this.f80937h = appCompatTextView5;
        this.f80938i = appCompatTextView6;
        this.f80939j = appCompatTextView7;
        this.f80940k = appCompatTextView8;
        this.f80941l = appCompatTextView9;
    }

    @NonNull
    public static r a(@NonNull View view) {
        int i11 = R$id.btn_close;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_custom_lane;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_custom_lane;
                EditTextWithClear editTextWithClear = (EditTextWithClear) n6.b.a(view, i11);
                if (editTextWithClear != null) {
                    i11 = R$id.tv_lane_1;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_lane_2;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_lane_3;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView5 != null) {
                                i11 = R$id.tv_lane_4;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView6 != null) {
                                    i11 = R$id.tv_lane_5;
                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView7 != null) {
                                        i11 = R$id.tv_lane_cur;
                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView8 != null) {
                                            i11 = R$id.tv_reset;
                                            AppCompatTextView appCompatTextView9 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView9 != null) {
                                                return new r((LinearLayout) view, appCompatTextView, appCompatTextView2, editTextWithClear, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9);
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
        return this.f80931a;
    }
}
