package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f80797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Button f80798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f80799d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final RecyclerView f80801g;

    public f(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView) {
        this.f80796a = linearLayout;
        this.f80797b = button;
        this.f80798c = button2;
        this.f80799d = appCompatEditText;
        this.f80800f = linearLayout2;
        this.f80801g = recyclerView;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.btnCustomInformation;
        Button button = (Button) n6.b.a(view, i11);
        if (button != null) {
            i11 = R$id.btnReset;
            Button button2 = (Button) n6.b.a(view, i11);
            if (button2 != null) {
                i11 = R$id.f59292et;
                AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
                if (appCompatEditText != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i11 = R$id.f59294rv;
                    RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                    if (recyclerView != null) {
                        return new f(linearLayout, button, button2, appCompatEditText, linearLayout, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_mcc, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f80796a;
    }
}
