package oz;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.version.diffupdate.R$id;
import n6.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f73451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ScrollView f73452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f73453d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f73454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f73455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f73456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f73457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f73458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f73459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f73460l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatCheckBox f73461m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f73462n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f73463o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f73464p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final View f73465q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final TextView f73466r;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull ScrollView scrollView, @NonNull View view, @NonNull View view2, @NonNull TextView textView, @NonNull View view3, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull View view4, @NonNull TextView textView3, @NonNull AppCompatCheckBox appCompatCheckBox, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatButton appCompatButton2, @NonNull TextView textView4, @NonNull View view5, @NonNull TextView textView5) {
        this.f73450a = constraintLayout;
        this.f73451b = linearLayout;
        this.f73452c = scrollView;
        this.f73453d = view;
        this.f73454f = view2;
        this.f73455g = textView;
        this.f73456h = view3;
        this.f73457i = textView2;
        this.f73458j = linearLayout2;
        this.f73459k = view4;
        this.f73460l = textView3;
        this.f73461m = appCompatCheckBox;
        this.f73462n = appCompatButton;
        this.f73463o = appCompatButton2;
        this.f73464p = textView4;
        this.f73465q = view5;
        this.f73466r = textView5;
    }

    @NonNull
    public static a a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        int i11 = R$id.bottom_layout;
        LinearLayout linearLayout = (LinearLayout) b.a(view, i11);
        if (linearLayout != null) {
            i11 = R$id.contentScrollView;
            ScrollView scrollView = (ScrollView) b.a(view, i11);
            if (scrollView != null && (viewA = b.a(view, (i11 = R$id.contentScrollViewBottom))) != null && (viewA2 = b.a(view, (i11 = R$id.contentScrollViewTop))) != null) {
                i11 = R$id.currentVersionTv;
                TextView textView = (TextView) b.a(view, i11);
                if (textView != null && (viewA3 = b.a(view, (i11 = R$id.guideline))) != null) {
                    i11 = R$id.ignoreUpdateTips;
                    TextView textView2 = (TextView) b.a(view, i11);
                    if (textView2 != null) {
                        i11 = R$id.ll_ignore;
                        LinearLayout linearLayout2 = (LinearLayout) b.a(view, i11);
                        if (linearLayout2 != null && (viewA4 = b.a(view, (i11 = R$id.updateBottomDivider))) != null) {
                            i11 = R$id.updateContentTv;
                            TextView textView3 = (TextView) b.a(view, i11);
                            if (textView3 != null) {
                                i11 = R$id.updateIgnoreCb;
                                AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) b.a(view, i11);
                                if (appCompatCheckBox != null) {
                                    i11 = R$id.updateNegativeBtn;
                                    AppCompatButton appCompatButton = (AppCompatButton) b.a(view, i11);
                                    if (appCompatButton != null) {
                                        i11 = R$id.updatePositiveBtn;
                                        AppCompatButton appCompatButton2 = (AppCompatButton) b.a(view, i11);
                                        if (appCompatButton2 != null) {
                                            i11 = R$id.updateTitleTv;
                                            TextView textView4 = (TextView) b.a(view, i11);
                                            if (textView4 != null && (viewA5 = b.a(view, (i11 = R$id.updateTop))) != null) {
                                                i11 = R$id.updateVersionTv;
                                                TextView textView5 = (TextView) b.a(view, i11);
                                                if (textView5 != null) {
                                                    return new a((ConstraintLayout) view, linearLayout, scrollView, viewA, viewA2, textView, viewA3, textView2, linearLayout2, viewA4, textView3, appCompatCheckBox, appCompatButton, appCompatButton2, textView4, viewA5, textView5);
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
    public ConstraintLayout getRoot() {
        return this.f73450a;
    }
}
