package tv;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f77757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f77758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TnTextView f77759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TnTextView f77760d;

    public h0(@NonNull View view, @NonNull RecyclerView recyclerView, @NonNull TnTextView tnTextView, @NonNull TnTextView tnTextView2) {
        this.f77757a = view;
        this.f77758b = recyclerView;
        this.f77759c = tnTextView;
        this.f77760d = tnTextView2;
    }

    @NonNull
    public static h0 a(@NonNull View view) {
        int i11 = R$id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.tv_title;
            TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
            if (tnTextView != null) {
                i11 = R$id.tv_title_trending;
                TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                if (tnTextView2 != null) {
                    return new h0(view, recyclerView, tnTextView, tnTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f77757a;
    }
}
