package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f80729d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f80730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f80731g;

    public c(@NonNull LinearLayout linearLayout, @NonNull EditTextWithClear editTextWithClear, @NonNull EditTextWithClear editTextWithClear2, @NonNull EditTextWithClear editTextWithClear3, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f80726a = linearLayout;
        this.f80727b = editTextWithClear;
        this.f80728c = editTextWithClear2;
        this.f80729d = editTextWithClear3;
        this.f80730f = textView;
        this.f80731g = textView2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i11 = R$id.edDeeplink;
        EditTextWithClear editTextWithClear = (EditTextWithClear) n6.b.a(view, i11);
        if (editTextWithClear != null) {
            i11 = R$id.etAppId;
            EditTextWithClear editTextWithClear2 = (EditTextWithClear) n6.b.a(view, i11);
            if (editTextWithClear2 != null) {
                i11 = R$id.etSceneId;
                EditTextWithClear editTextWithClear3 = (EditTextWithClear) n6.b.a(view, i11);
                if (editTextWithClear3 != null) {
                    i11 = R$id.tvApiOpen;
                    TextView textView = (TextView) n6.b.a(view, i11);
                    if (textView != null) {
                        i11 = R$id.tvDpOpen;
                        TextView textView2 = (TextView) n6.b.a(view, i11);
                        if (textView2 != null) {
                            return new c((LinearLayout) view, editTextWithClear, editTextWithClear2, editTextWithClear3, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_lab_miniapp_sdk, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f80726a;
    }
}
