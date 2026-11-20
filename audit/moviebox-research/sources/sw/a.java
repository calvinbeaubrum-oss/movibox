package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.TitleLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f76473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f76474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f76475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76476d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TitleLayout f76477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76480i;

    public a(@NonNull NestedScrollView nestedScrollView, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull ShapeableImageView shapeableImageView, @NonNull TitleLayout titleLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3) {
        this.f76473a = nestedScrollView;
        this.f76474b = appCompatEditText;
        this.f76475c = appCompatEditText2;
        this.f76476d = shapeableImageView;
        this.f76477f = titleLayout;
        this.f76478g = appCompatTextView;
        this.f76479h = appCompatTextView2;
        this.f76480i = appCompatTextView3;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i11 = R$id.et_community_desc;
        AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
        if (appCompatEditText != null) {
            i11 = R$id.et_community_name;
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) n6.b.a(view, i11);
            if (appCompatEditText2 != null) {
                i11 = R$id.iv_avatar;
                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.tool_bar;
                    TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                    if (titleLayout != null) {
                        i11 = R$id.tv_comfirm;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_desc;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView2 != null) {
                                i11 = R$id.tv_name;
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView3 != null) {
                                    return new a((NestedScrollView) view, appCompatEditText, appCompatEditText2, shapeableImageView, titleLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_create_room, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f76473a;
    }
}
