package et;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.fission.R$id;
import com.transsion.fission.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f64350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatButton f64351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f64352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TitleLayout f64353d;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatEditText appCompatEditText, @NonNull TitleLayout titleLayout) {
        this.f64350a = constraintLayout;
        this.f64351b = appCompatButton;
        this.f64352c = appCompatEditText;
        this.f64353d = titleLayout;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i11 = R$id.btn_submit;
        AppCompatButton appCompatButton = (AppCompatButton) n6.b.a(view, i11);
        if (appCompatButton != null) {
            i11 = R$id.et_invitation_code;
            AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
            if (appCompatEditText != null) {
                i11 = R$id.tool_bar;
                TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                if (titleLayout != null) {
                    return new a((ConstraintLayout) view, appCompatButton, appCompatEditText, titleLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fission_activity_invitation_code, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64350a;
    }
}
