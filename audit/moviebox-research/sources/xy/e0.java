package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TnTextView f80790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f80792d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TnTextView f80794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f80795h;

    public e0(@NonNull ConstraintLayout constraintLayout, @NonNull TnTextView tnTextView, @NonNull AppCompatTextView appCompatTextView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull TnTextView tnTextView2, @NonNull View view) {
        this.f80789a = constraintLayout;
        this.f80790b = tnTextView;
        this.f80791c = appCompatTextView;
        this.f80792d = imageView;
        this.f80793f = linearLayout;
        this.f80794g = tnTextView2;
        this.f80795h = view;
    }

    @NonNull
    public static e0 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.btnTv;
        TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
        if (tnTextView != null) {
            i11 = R$id.desTv;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.icIV;
                ImageView imageView = (ImageView) n6.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.llBottom;
                    LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.titleTv;
                        TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                        if (tnTextView2 != null && (viewA = n6.b.a(view, (i11 = R$id.vTopGuideline))) != null) {
                            return new e0((ConstraintLayout) view, tnTextView, appCompatTextView, imageView, linearLayout, tnTextView2, viewA);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static e0 c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.mine_item_novel_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80789a;
    }
}
