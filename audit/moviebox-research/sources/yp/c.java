package yp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.TnTextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f81582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f81583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TnTextView f81584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f81585d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TitleLayout f81586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TnTextView f81587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TnTextView f81588h;

    public c(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull TnTextView tnTextView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TitleLayout titleLayout, @NonNull TnTextView tnTextView2, @NonNull TnTextView tnTextView3) {
        this.f81582a = view;
        this.f81583b = appCompatImageView;
        this.f81584c = tnTextView;
        this.f81585d = linearLayoutCompat;
        this.f81586f = titleLayout;
        this.f81587g = tnTextView2;
        this.f81588h = tnTextView3;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i11 = R$id.bg_no_connection;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.go_to_setting;
            TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
            if (tnTextView != null) {
                i11 = R$id.ll_no_connection_tip;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                if (linearLayoutCompat != null) {
                    i11 = R$id.ll_title;
                    TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                    if (titleLayout != null) {
                        i11 = R$id.no_connection_title;
                        TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                        if (tnTextView2 != null) {
                            i11 = R$id.retry;
                            TnTextView tnTextView3 = (TnTextView) n6.b.a(view, i11);
                            if (tnTextView3 != null) {
                                return new c(view, appCompatImageView, tnTextView, linearLayoutCompat, titleLayout, tnTextView2, tnTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static c b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_no_connection, viewGroup);
        return a(viewGroup);
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f81582a;
    }
}
