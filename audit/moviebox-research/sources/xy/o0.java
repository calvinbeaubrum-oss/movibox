package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class o0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f80889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f80890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f80891d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f80892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f80893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TitleLayout f80895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80899m;

    public o0(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull LinearLayout linearLayout, @NonNull TitleLayout titleLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4) {
        this.f80888a = constraintLayout;
        this.f80889b = appCompatButton;
        this.f80890c = appCompatEditText;
        this.f80891d = appCompatEditText2;
        this.f80892f = appCompatImageView;
        this.f80893g = appCompatImageView2;
        this.f80894h = linearLayout;
        this.f80895i = titleLayout;
        this.f80896j = appCompatTextView;
        this.f80897k = appCompatTextView2;
        this.f80898l = appCompatTextView3;
        this.f80899m = appCompatTextView4;
    }

    @NonNull
    public static o0 a(@NonNull View view) {
        int i11 = R$id.btn_submit;
        AppCompatButton appCompatButton = (AppCompatButton) n6.b.a(view, i11);
        if (appCompatButton != null) {
            i11 = R$id.et_desc;
            AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
            if (appCompatEditText != null) {
                i11 = R$id.et_phone;
                AppCompatEditText appCompatEditText2 = (AppCompatEditText) n6.b.a(view, i11);
                if (appCompatEditText2 != null) {
                    i11 = R$id.img_background;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.iv_add_image;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.ll_input;
                            LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.toolbar;
                                TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                                if (titleLayout != null) {
                                    i11 = R$id.tv_desc_num;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView != null) {
                                        i11 = R$id.tv_phone_country_code;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            i11 = R$id.tv_title_desc;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView3 != null) {
                                                i11 = R$id.whatsapp_hint;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView4 != null) {
                                                    return new o0((ConstraintLayout) view, appCompatButton, appCompatEditText, appCompatEditText2, appCompatImageView, appCompatImageView2, linearLayout, titleLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
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

    @NonNull
    public static o0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static o0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.user_activity_setting_feedback, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80888a;
    }
}
