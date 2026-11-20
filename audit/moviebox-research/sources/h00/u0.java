package h00;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class u0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f66038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f66039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Group f66040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66041d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f66042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f66043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f66044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f66045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f66046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f66047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f66048l;

    public u0(@NonNull View view, @NonNull ConstraintLayout constraintLayout, @NonNull Group group, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.f66038a = view;
        this.f66039b = constraintLayout;
        this.f66040c = group;
        this.f66041d = appCompatImageView;
        this.f66042f = linearLayout;
        this.f66043g = textView;
        this.f66044h = textView2;
        this.f66045i = textView3;
        this.f66046j = textView4;
        this.f66047k = textView5;
        this.f66048l = textView6;
    }

    @NonNull
    public static u0 a(@NonNull View view) {
        int i11 = R$id.cl_permission;
        ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.group_permission;
            Group group = (Group) n6.b.a(view, i11);
            if (group != null) {
                i11 = R$id.iv_icon;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ll_content;
                    LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.tv_available_size;
                        TextView textView = (TextView) n6.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.tv_change;
                            TextView textView2 = (TextView) n6.b.a(view, i11);
                            if (textView2 != null) {
                                i11 = R$id.tv_path_name;
                                TextView textView3 = (TextView) n6.b.a(view, i11);
                                if (textView3 != null) {
                                    i11 = R$id.tv_permission_btn;
                                    TextView textView4 = (TextView) n6.b.a(view, i11);
                                    if (textView4 != null) {
                                        i11 = R$id.tv_permission_tips;
                                        TextView textView5 = (TextView) n6.b.a(view, i11);
                                        if (textView5 != null) {
                                            i11 = R$id.tv_permission_title;
                                            TextView textView6 = (TextView) n6.b.a(view, i11);
                                            if (textView6 != null) {
                                                return new u0(view, constraintLayout, group, appCompatImageView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6);
                                            }
                                        }
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

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f66038a;
    }
}
