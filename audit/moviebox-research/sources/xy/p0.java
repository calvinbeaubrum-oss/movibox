package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class p0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SwitchButton f80913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TitleLayout f80914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f80915d;

    public p0(@NonNull ConstraintLayout constraintLayout, @NonNull SwitchButton switchButton, @NonNull TitleLayout titleLayout, @NonNull View view) {
        this.f80912a = constraintLayout;
        this.f80913b = switchButton;
        this.f80914c = titleLayout;
        this.f80915d = view;
    }

    @NonNull
    public static p0 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.switch_button;
        SwitchButton switchButton = (SwitchButton) n6.b.a(view, i11);
        if (switchButton != null) {
            i11 = R$id.tool_bar;
            TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
            if (titleLayout != null && (viewA = n6.b.a(view, (i11 = R$id.v_notice_bg))) != null) {
                return new p0((ConstraintLayout) view, switchButton, titleLayout, viewA);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static p0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static p0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.user_activity_setting_notice, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80912a;
    }
}
