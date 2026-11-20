package com.cloud.tmc.miniapp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cloud.tmc.integration.utils.v;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter;
import com.cloud.tmc.miniapp.widget.photoview.PhotoView;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import q0.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ImagePreviewAdapter extends a<String> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<String> f31762p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f31763q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f31764r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f31765s;

    /* JADX INFO: compiled from: source.java */
    public final class ViewHolder extends a<String>.AbstractC0347a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f31766d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Lazy f31767f;

        public ViewHolder() {
            super(R$layout.item_image_preview);
            this.f31766d = LazyKt__LazyJVMKt.b(new Function0<PhotoView>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter$ViewHolder$photoView$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PhotoView invoke() {
                    return (PhotoView) this.this$0.findViewById(R$id.photoview);
                }
            });
            this.f31767f = LazyKt__LazyJVMKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter$ViewHolder$checkBox$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) this.this$0.findViewById(R$id.cb_image_select_check);
                }
            });
        }

        public static final void l(ImagePreviewAdapter this$0, View view, float f11, float f12) {
            Intrinsics.g(this$0, "this$0");
            Context context = this$0.getContext();
            BaseActivity baseActivity = context instanceof BaseActivity ? (BaseActivity) context : null;
            if (baseActivity != null) {
                baseActivity.finish();
                baseActivity.overridePendingTransition(R$anim.activity_fast_fade_in, R$anim.activity_fast_fade_out);
            }
        }

        @Override // com.cloud.tmc.miniapp.base.BaseAdapter.a
        public void g(int i11) {
            TextView textViewI;
            String absolutePath;
            PhotoView photoViewJ = j();
            if (photoViewJ != null) {
                final ImagePreviewAdapter imagePreviewAdapter = ImagePreviewAdapter.this;
                photoViewJ.setOnViewTapListener(new h() { // from class: rd.a
                    @Override // q0.h
                    public final void a(View view, float f11, float f12) {
                        ImagePreviewAdapter.ViewHolder.l(imagePreviewAdapter, view, f11, f12);
                    }
                });
            }
            String item = ImagePreviewAdapter.this.getItem(i11);
            if (item != null) {
                ImagePreviewAdapter imagePreviewAdapter2 = ImagePreviewAdapter.this;
                try {
                    PhotoView photoViewJ2 = j();
                    if (photoViewJ2 != null) {
                        if (StringsKt__StringsKt.Q(item, ".miniapp.transsion.com", false, 2, null)) {
                            String strA = v.f31133a.a(item);
                            if (strA == null) {
                                strA = "";
                            }
                            File file = imagePreviewAdapter2.z().get(item, strA);
                            absolutePath = file != null ? file.getAbsolutePath() : null;
                            if (absolutePath == null) {
                                absolutePath = "";
                            } else {
                                Intrinsics.f(absolutePath, "baseResourceManager.get(…ppId)?.absolutePath ?: \"\"");
                            }
                        } else {
                            absolutePath = item;
                        }
                        imagePreviewAdapter2.A().loadImg(imagePreviewAdapter2.getContext(), absolutePath, photoViewJ2);
                    }
                } catch (Throwable th2) {
                    TmcLogger.h("onBindView", th2);
                }
                int iB = imagePreviewAdapter2.B();
                if (iB == 1) {
                    TextView textViewI2 = i();
                    if (textViewI2 == null) {
                        return;
                    }
                    textViewI2.setVisibility(8);
                    return;
                }
                if (iB != 2) {
                    if (iB == 3 && (textViewI = i()) != null) {
                        textViewI.setVisibility(8);
                        return;
                    }
                    return;
                }
                TextView textViewI3 = i();
                if (textViewI3 != null) {
                    textViewI3.setVisibility(0);
                }
                int iK = k(item);
                if (iK != 0) {
                    TextView textViewI4 = i();
                    if (textViewI4 != null) {
                        textViewI4.setSelected(true);
                    }
                    TextView textViewI5 = i();
                    if (textViewI5 == null) {
                        return;
                    }
                    textViewI5.setText(String.valueOf(iK));
                    return;
                }
                TextView textViewI6 = i();
                if (textViewI6 != null) {
                    textViewI6.setSelected(false);
                }
                TextView textViewI7 = i();
                if (textViewI7 == null) {
                    return;
                }
                textViewI7.setText("");
            }
        }

        public final TextView i() {
            return (TextView) this.f31767f.getValue();
        }

        public final PhotoView j() {
            return (PhotoView) this.f31766d.getValue();
        }

        public final int k(String imagePath) {
            Intrinsics.g(imagePath, "imagePath");
            return ImagePreviewAdapter.this.f31762p.indexOf(imagePath) + 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewAdapter(Context context, List<String> mSelectImages) {
        super(context);
        Intrinsics.g(context, "context");
        Intrinsics.g(mSelectImages, "mSelectImages");
        this.f31762p = mSelectImages;
        this.f31763q = LazyKt__LazyJVMKt.b(new Function0<ImageLoaderProxy>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter$imageLoder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageLoaderProxy invoke() {
                return (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
            }
        });
        this.f31764r = LazyKt__LazyJVMKt.b(new Function0<IResourceProcessor>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter$baseResourceManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IResourceProcessor invoke() {
                return (IResourceProcessor) tc.a.a(IResourceProcessor.class);
            }
        });
        this.f31765s = 1;
    }

    public final ImageLoaderProxy A() {
        Object value = this.f31763q.getValue();
        Intrinsics.f(value, "<get-imageLoder>(...)");
        return (ImageLoaderProxy) value;
    }

    public final int B() {
        return this.f31765s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a<String>.AbstractC0347a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return new ViewHolder();
    }

    public final void D(int i11) {
        this.f31765s = i11;
    }

    public final IResourceProcessor z() {
        Object value = this.f31764r.getValue();
        Intrinsics.f(value, "<get-baseResourceManager>(...)");
        return (IResourceProcessor) value;
    }
}
