package xy;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f80825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f80826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f80827d;

    public i0(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f80824a = constraintLayout;
        this.f80825b = textView;
        this.f80826c = textView2;
        this.f80827d = textView3;
    }

    @NonNull
    public static i0 a(@NonNull View view) {
        int i11 = R$id.tvDes;
        TextView textView = (TextView) n6.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.tvJump;
            TextView textView2 = (TextView) n6.b.a(view, i11);
            if (textView2 != null) {
                i11 = R$id.tvTitle;
                TextView textView3 = (TextView) n6.b.a(view, i11);
                if (textView3 != null) {
                    return new i0((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80824a;
    }
}
