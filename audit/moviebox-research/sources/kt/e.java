package kt;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.CategoryItemBean;
import com.transsion.moviedetailapi.bean.Subject;
import h9.j;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class e extends BaseProviderMultiAdapter<CategoryItemBean> implements j {
    public static final a K = new a(null);
    public static final int L = 8;
    public final nt.b I;
    public final String J;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(List<CategoryItemBean> datas, String pageName, nt.b bVar, String str) {
        super(datas);
        Intrinsics.g(datas, "datas");
        Intrinsics.g(pageName, "pageName");
        this.I = bVar;
        this.J = str;
        K0(new f(pageName));
        K0(new g(pageName, Intrinsics.b(str, "2")));
        K0(new d());
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends CategoryItemBean> data, int i11) {
        Intrinsics.g(data, "data");
        Subject subject = data.get(i11).getSubject();
        if (subject == null) {
            return 1;
        }
        if (subject.getNonAdDelegate() != null) {
            return 3;
        }
        Integer subjectType = subject.getSubjectType();
        return ((subjectType != null && subjectType.intValue() == SubjectType.MUSIC.getValue()) || Intrinsics.b(this.J, "3") || Intrinsics.b(this.J, "2")) ? 2 : 1;
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter, com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        nt.b bVar = this.I;
        if (bVar != null) {
            RecyclerView.m layoutManager = W().getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            bVar.h((LinearLayoutManager) layoutManager, holder.getAdapterPosition(), true);
        }
    }
}
