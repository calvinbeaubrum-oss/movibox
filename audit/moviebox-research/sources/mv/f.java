package mv;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.transsion.player.longvideo.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f71210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f71211d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f71212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f71213g;

    public f(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view) {
        this.f71208a = linearLayout;
        this.f71209b = linearLayout2;
        this.f71210c = textView;
        this.f71211d = textView2;
        this.f71212f = textView3;
        this.f71213g = view;
    }

    @NonNull
    public static f a(@NonNull View view) {
        View viewA;
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R$id.tvCountDown;
        TextView textView = (TextView) n6.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.tvEnterAd;
            TextView textView2 = (TextView) n6.b.a(view, i11);
            if (textView2 != null) {
                i11 = R$id.tvGoAdFree;
                TextView textView3 = (TextView) n6.b.a(view, i11);
                if (textView3 != null && (viewA = n6.b.a(view, (i11 = R$id.view))) != null) {
                    return new f(linearLayout, linearLayout, textView, textView2, textView3, viewA);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f71208a;
    }
}
