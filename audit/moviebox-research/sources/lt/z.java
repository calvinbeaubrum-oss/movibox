package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.FlowLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class z implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f70536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FlowLayout f70537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f70538c;

    public z(@NonNull LinearLayout linearLayout, @NonNull FlowLayout flowLayout, @NonNull AppCompatTextView appCompatTextView) {
        this.f70536a = linearLayout;
        this.f70537b = flowLayout;
        this.f70538c = appCompatTextView;
    }

    @NonNull
    public static z a(@NonNull View view) {
        int i11 = R$id.flow_layout;
        FlowLayout flowLayout = (FlowLayout) n6.b.a(view, i11);
        if (flowLayout != null) {
            i11 = R$id.tvExpand;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                return new z((LinearLayout) view, flowLayout, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static z c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.layout_filter_expand_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f70536a;
    }
}
