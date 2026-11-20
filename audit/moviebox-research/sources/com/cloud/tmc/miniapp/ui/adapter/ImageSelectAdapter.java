package com.cloud.tmc.miniapp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ImageSelectAdapter extends a<String> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<String> f31769p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f31770q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f31771r;

    /* JADX INFO: compiled from: source.java */
    public final class ViewHolder extends a<String>.AbstractC0347a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f31772d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Lazy f31773f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Lazy f31774g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Lazy f31775h;

        public ViewHolder() {
            super(R$layout.item_image_select);
            this.f31772d = LazyKt__LazyJVMKt.b(new Function0<ImageView>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImageSelectAdapter$ViewHolder$imageView$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageView invoke() {
                    return (ImageView) this.this$0.findViewById(R$id.iv_image_select);
                }
            });
            this.f31773f = LazyKt__LazyJVMKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImageSelectAdapter$ViewHolder$checkBox$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) this.this$0.findViewById(R$id.cb_image_select_check);
                }
            });
            this.f31774g = LazyKt__LazyJVMKt.b(new Function0<View>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImageSelectAdapter$ViewHolder$viewMask$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final View invoke() {
                    return this.this$0.findViewById(R$id.view_mask);
                }
            });
            this.f31775h = LazyKt__LazyJVMKt.b(new Function0<AppCompatImageView>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImageSelectAdapter$ViewHolder$ivQrPreview$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final AppCompatImageView invoke() {
                    return (AppCompatImageView) this.this$0.findViewById(R$id.iv_qr_preview);
                }
            });
        }

        private final TextView h() {
            return (TextView) this.f31773f.getValue();
        }

        private final ImageView i() {
            return (ImageView) this.f31772d.getValue();
        }

        @Override // com.cloud.tmc.miniapp.base.BaseAdapter.a
        public void g(int i11) {
            String item = ImageSelectAdapter.this.getItem(i11);
            ImageSelectAdapter imageSelectAdapter = ImageSelectAdapter.this;
            String str = item;
            ImageView imageViewI = i();
            if (imageViewI != null) {
                imageSelectAdapter.y().loadImg(imageSelectAdapter.getContext(), str, imageViewI);
            }
            if (imageSelectAdapter.z() == 1) {
                TextView textViewH = h();
                if (textViewH != null) {
                    textViewH.setVisibility(8);
                }
                AppCompatImageView appCompatImageViewJ = j();
                if (appCompatImageViewJ == null) {
                    return;
                }
                appCompatImageViewJ.setVisibility(0);
                return;
            }
            TextView textViewH2 = h();
            if (textViewH2 != null) {
                textViewH2.setVisibility(0);
            }
            int iA = imageSelectAdapter.A(str);
            if (iA != 0) {
                TextView textViewH3 = h();
                if (textViewH3 != null) {
                    textViewH3.setSelected(true);
                }
                TextView textViewH4 = h();
                if (textViewH4 != null) {
                    textViewH4.setText(String.valueOf(iA));
                }
                View viewK = k();
                if (viewK != null) {
                    viewK.setBackgroundColor(imageSelectAdapter.n(R$color.mini_black50));
                    return;
                }
                return;
            }
            TextView textViewH5 = h();
            if (textViewH5 != null) {
                textViewH5.setSelected(false);
            }
            TextView textViewH6 = h();
            if (textViewH6 != null) {
                textViewH6.setText("");
            }
            View viewK2 = k();
            if (viewK2 != null) {
                viewK2.setBackgroundColor(imageSelectAdapter.n(R$color.mini_black6));
            }
        }

        public final AppCompatImageView j() {
            return (AppCompatImageView) this.f31775h.getValue();
        }

        public final View k() {
            return (View) this.f31774g.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageSelectAdapter(Context context, List<String> mSelectImages) {
        super(context);
        Intrinsics.g(context, "context");
        Intrinsics.g(mSelectImages, "mSelectImages");
        this.f31769p = mSelectImages;
        this.f31770q = LazyKt__LazyJVMKt.b(new Function0<ImageLoaderProxy>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImageSelectAdapter$imageLoder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageLoaderProxy invoke() {
                return (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
            }
        });
        this.f31771r = 1;
    }

    public final int A(String imagePath) {
        Intrinsics.g(imagePath, "imagePath");
        return this.f31769p.indexOf(imagePath) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public a<String>.AbstractC0347a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return new ViewHolder();
    }

    public final void C(int i11) {
        this.f31771r = i11;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter
    public RecyclerView.m k(Context context) {
        Intrinsics.g(context, "context");
        return new GridLayoutManager(context, 3);
    }

    public final ImageLoaderProxy y() {
        Object value = this.f31770q.getValue();
        Intrinsics.f(value, "<get-imageLoder>(...)");
        return (ImageLoaderProxy) value;
    }

    public final int z() {
        return this.f31771r;
    }
}
