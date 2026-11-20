package h00;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class q0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f65995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Group f65996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f65998d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TnTextView f65999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TnTextView f66000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final BLView f66001h;

    public q0(@NonNull View view, @NonNull Group group, @NonNull AppCompatImageView appCompatImageView, @NonNull RecyclerView recyclerView, @NonNull TnTextView tnTextView, @NonNull TnTextView tnTextView2, @NonNull BLView bLView) {
        this.f65995a = view;
        this.f65996b = group;
        this.f65997c = appCompatImageView;
        this.f65998d = recyclerView;
        this.f65999f = tnTextView;
        this.f66000g = tnTextView2;
        this.f66001h = bLView;
    }

    @NonNull
    public static q0 a(@NonNull View view) {
        int i11 = R$id.group_refresh;
        Group group = (Group) n6.b.a(view, i11);
        if (group != null) {
            i11 = R$id.iv_refresh_progress;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_refresh;
                    TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                    if (tnTextView != null) {
                        i11 = R$id.tv_title;
                        TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                        if (tnTextView2 != null) {
                            i11 = R$id.v_refresh;
                            BLView bLView = (BLView) n6.b.a(view, i11);
                            if (bLView != null) {
                                return new q0(view, group, appCompatImageView, recyclerView, tnTextView, tnTextView2, bLView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f65995a;
    }
}
