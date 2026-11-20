package ex;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class d extends BaseProviderMultiAdapter<ex.a> implements j {
    public static final a M = new a(null);
    public Function0<Unit> I;
    public boolean J;
    public boolean K;
    public int L;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class b extends BaseItemProvider<ex.a> {
        public b() {
        }

        public static final void w(d this$0, int i11, View view) {
            Intrinsics.g(this$0, "this$0");
            if (this$0.J && i11 == this$0.L) {
                Function0 function0 = this$0.I;
                if (function0 != null) {
                    function0.invoke();
                }
                jx.b.f68176a.d(!this$0.K);
            }
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 1;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.item_search_history_word;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public void a(BaseViewHolder helper, ex.a item) {
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
            final int iP = d.this.P(item);
            helper.setText(R$id.search_history_text, item.a());
            boolean z11 = d.this.J && iP == d.this.L;
            View view = helper.getView(R$id.search_hot_history_more_image);
            final d dVar = d.this;
            ImageView imageView = (ImageView) view;
            imageView.setVisibility(z11 ? 0 : 8);
            imageView.setImageResource(dVar.K ? R$drawable.ic_hide : R$drawable.ic_more);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ex.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d.b.w(dVar, iP, view2);
                }
            });
            helper.getView(R$id.search_history_item_divider).setVisibility(z11 ? 8 : 0);
        }
    }

    public d() {
        super(null, 1, null);
        K0(new b());
        this.L = -1;
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends ex.a> data, int i11) {
        Intrinsics.g(data, "data");
        return data.get(i11).b();
    }

    public final void Z0(Function0<Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.I = listener;
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }

    @SuppressLint({"Range"})
    public final void a1(boolean z11, boolean z12, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setShowMoreMode, moreShow:");
        sb2.append(z11);
        sb2.append(", isExpand:");
        sb2.append(z12);
        sb2.append(",  moreIndex:");
        sb2.append(i11);
        if (getItemCount() > 0 && i11 >= 0) {
            this.J = z11;
            this.K = z12;
            this.L = i11;
            int itemCount = z11 ? i11 + 1 : getItemCount();
            for (int i12 = 0; i12 < itemCount; i12++) {
                if (i12 < getItemCount()) {
                    jx.b.f68176a.e(getItem(i12).a(), i12);
                }
            }
        }
    }
}
