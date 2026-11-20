package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.TnButton;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class n0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TnButton f80878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f80879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f80880d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TitleLayout f80881f;

    public n0(@NonNull LinearLayout linearLayout, @NonNull TnButton tnButton, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull TitleLayout titleLayout) {
        this.f80877a = linearLayout;
        this.f80878b = tnButton;
        this.f80879c = textView;
        this.f80880d = recyclerView;
        this.f80881f = titleLayout;
    }

    @NonNull
    public static n0 a(@NonNull View view) {
        int i11 = R$id.btn_login;
        TnButton tnButton = (TnButton) n6.b.a(view, i11);
        if (tnButton != null) {
            i11 = R$id.deviceInfoTv;
            TextView textView = (TextView) n6.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.f59294rv;
                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tool_bar;
                    TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                    if (titleLayout != null) {
                        return new n0((LinearLayout) view, tnButton, textView, recyclerView, titleLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static n0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static n0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.user_activity_setting, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f80877a;
    }
}
