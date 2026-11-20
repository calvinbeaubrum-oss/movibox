package com.transsion.ninegridview.preview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.R$drawable;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;
import com.transsion.photoview.PhotoView;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class l extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ImageInfo> f53998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f53999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f54000c;

    /* JADX INFO: compiled from: source.java */
    public class a implements com.transsion.photoview.i {
        public a() {
        }

        @Override // com.transsion.photoview.i
        public void a() {
            ((ImagePreviewActivity) l.this.f53999b).finish();
        }
    }

    public l(Context context, @NonNull List<ImageInfo> list) {
        this.f53998a = list;
        this.f53999b = context;
    }

    public PhotoView d() {
        return (PhotoView) this.f54000c.findViewById(R$id.f53942pv);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public ImageView e() {
        return (ImageView) this.f54000c.findViewById(R$id.thumb);
    }

    public View f() {
        return this.f54000c;
    }

    public final /* synthetic */ void g(View view) {
        ((ImagePreviewActivity) this.f53999b).finishActivityAnim();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<ImageInfo> list = this.f53998a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final /* synthetic */ void h(View view) {
        ((ImagePreviewActivity) this.f53999b).finishActivityAnim();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        View viewInflate = LayoutInflater.from(this.f53999b).inflate(R$layout.item_photoview, viewGroup, false);
        viewInflate.findViewById(R$id.root).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f53996a.g(view);
            }
        });
        ImageInfo imageInfo = this.f53998a.get(i11);
        if (imageInfo == null) {
            return viewInflate;
        }
        try {
            float f11 = imageInfo.imageViewWidth;
            tp.f fVar = tp.f.f77260a;
            if (f11 > fVar.e(this.f53999b) || imageInfo.imageViewHeight > fVar.c(this.f53999b)) {
                float f12 = imageInfo.imageViewWidth / imageInfo.imageViewHeight;
                imageInfo.imageViewWidth = fVar.e(this.f53999b);
                imageInfo.imageViewHeight = fVar.e(this.f53999b) / f12;
            }
        } catch (Exception unused) {
        }
        PhotoView photoView = (PhotoView) viewInflate.findViewById(R$id.f53942pv);
        photoView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f53997a.h(view);
            }
        });
        photoView.setSlideUpAndDownListener(new a());
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = this.f53999b;
        String str = imageInfo.bigImageUrl;
        if (str == null) {
            str = "";
        }
        companion.o(context, photoView, str, R$drawable.ic_default_color, (int) imageInfo.imageViewWidth, (int) imageInfo.imageViewHeight, 0, true, "", true, false, false, false, false, 0);
        viewGroup.addView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i11, Object obj) {
        super.setPrimaryItem(viewGroup, i11, obj);
        this.f54000c = (View) obj;
    }
}
