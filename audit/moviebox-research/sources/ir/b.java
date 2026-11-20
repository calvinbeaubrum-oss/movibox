package ir;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.f0;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.banner.R$id;
import com.transsion.banner.banner.holder.BannerImageHolder;
import java.util.List;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b<T> extends a<T, BannerImageHolder> {
    public b(List<T> list) {
        super(list);
    }

    public abstract boolean k();

    @Override // kr.a
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public BannerImageHolder b(ViewGroup viewGroup, int i11) {
        ImageView appCompatImageView;
        if (k()) {
            ShapeableImageView shapeableImageView = new ShapeableImageView(viewGroup.getContext());
            shapeableImageView.setShapeAppearanceModel(new n().w(f0.a(4.0f)));
            appCompatImageView = shapeableImageView;
        } else {
            appCompatImageView = new AppCompatImageView(viewGroup.getContext());
        }
        appCompatImageView.setId(R$id.image);
        appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerImageHolder(appCompatImageView);
    }
}
