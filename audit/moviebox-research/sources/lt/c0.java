package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.widget.TnTextView;
import com.transsion.banner.view.HRecyclerView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f70402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TnTextView f70403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f70405d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final HRecyclerView f70406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f70407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TnTextView f70409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TnTextView f70410j;

    public c0(@NonNull View view, @NonNull TnTextView tnTextView, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull HRecyclerView hRecyclerView, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull AppCompatImageView appCompatImageView2, @NonNull TnTextView tnTextView2, @NonNull TnTextView tnTextView3) {
        this.f70402a = view;
        this.f70403b = tnTextView;
        this.f70404c = appCompatImageView;
        this.f70405d = linearLayoutCompat;
        this.f70406f = hRecyclerView;
        this.f70407g = linearLayoutCompat2;
        this.f70408h = appCompatImageView2;
        this.f70409i = tnTextView2;
        this.f70410j = tnTextView3;
    }

    @NonNull
    public static c0 a(@NonNull View view) {
        int i11 = R$id.check_list;
        TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
        if (tnTextView != null) {
            i11 = R$id.iv_tag;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.play_list_title;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                if (linearLayoutCompat != null) {
                    i11 = R$id.rv_list;
                    HRecyclerView hRecyclerView = (HRecyclerView) n6.b.a(view, i11);
                    if (hRecyclerView != null) {
                        i11 = R$id.tag_group;
                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) n6.b.a(view, i11);
                        if (linearLayoutCompat2 != null) {
                            i11 = R$id.tag_icon;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.tag_name;
                                TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                                if (tnTextView2 != null) {
                                    i11 = R$id.tv_title;
                                    TnTextView tnTextView3 = (TnTextView) n6.b.a(view, i11);
                                    if (tnTextView3 != null) {
                                        return new c0(view, tnTextView, appCompatImageView, linearLayoutCompat, hRecyclerView, linearLayoutCompat2, appCompatImageView2, tnTextView2, tnTextView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static c0 b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_op_play_list, viewGroup);
        return a(viewGroup);
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f70402a;
    }
}
