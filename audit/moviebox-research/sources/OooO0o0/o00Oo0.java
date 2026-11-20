package OooO0o0;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import j.z;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o00Oo0 extends com.cloud.tmc.miniapp.ui.adapter.a<z> {

    /* JADX INFO: compiled from: source.java */
    public final class OooO00o extends com.cloud.tmc.miniapp.ui.adapter.a<z>.AbstractC0347a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f129d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Lazy f130f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Lazy f131g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Lazy f132h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Lazy f133i;

        /* JADX INFO: compiled from: source.java */
        public static final class OooO extends Lambda implements Function0<AppCompatTextView> {
            public OooO() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public AppCompatTextView invoke() {
                return (AppCompatTextView) OooO00o.this.findViewById(R$id.tv_image_album_remark);
            }
        }

        /* JADX INFO: renamed from: OooO0o0.o00Oo0$OooO00o$OooO00o, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0010OooO00o extends Lambda implements Function0<ImageLoaderProxy> {
            public static final C0010OooO00o OooO00o = new C0010OooO00o();

            public C0010OooO00o() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public ImageLoaderProxy invoke() {
                return (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0O0 extends Lambda implements Function0<AppCompatImageView> {
            public OooO0O0() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public AppCompatImageView invoke() {
                return (AppCompatImageView) OooO00o.this.findViewById(R$id.iv_image_album);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0OO extends Lambda implements Function0<LinearLayout> {
            public OooO0OO() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public LinearLayout invoke() {
                return (LinearLayout) OooO00o.this.findViewById(R$id.ll_album_item);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0o extends Lambda implements Function0<AppCompatTextView> {
            public OooO0o() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public AppCompatTextView invoke() {
                return (AppCompatTextView) OooO00o.this.findViewById(R$id.tv_image_album_name);
            }
        }

        public OooO00o() {
            super(R$layout.item_mini_image_album);
            this.f129d = LazyKt__LazyJVMKt.b(C0010OooO00o.OooO00o);
            this.f130f = LazyKt__LazyJVMKt.b(new OooO0O0());
            this.f131g = LazyKt__LazyJVMKt.b(new OooO0OO());
            this.f132h = LazyKt__LazyJVMKt.b(new OooO0o());
            this.f133i = LazyKt__LazyJVMKt.b(new OooO());
        }

        @Override // com.cloud.tmc.miniapp.base.BaseAdapter.a
        public void g(int i11) {
            z item = o00Oo0.this.getItem(i11);
            if (item != null) {
                o00Oo0 o00oo0 = o00Oo0.this;
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f130f.getValue();
                if (appCompatImageView != null) {
                    Object value = this.f129d.getValue();
                    Intrinsics.f(value, "<get-imageLoder>(...)");
                    ((ImageLoaderProxy) value).loadImgRoundCornersCenterCrop(o00oo0.getContext(), item.f67795a, appCompatImageView, 8);
                }
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f132h.getValue();
                if (appCompatTextView != null) {
                    appCompatTextView.setText(item.f67796b);
                }
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) this.f133i.getValue();
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setText(item.f67798d);
                }
                if (item.f67799e) {
                    LinearLayout linearLayout = (LinearLayout) this.f131g.getValue();
                    if (linearLayout != null) {
                        linearLayout.setBackgroundColor(o00oo0.n(R$color.mini_color_0affffff));
                        return;
                    }
                    return;
                }
                LinearLayout linearLayout2 = (LinearLayout) this.f131g.getValue();
                if (linearLayout2 != null) {
                    linearLayout2.setBackgroundColor(0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o00Oo0(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.a0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return new OooO00o();
    }
}
