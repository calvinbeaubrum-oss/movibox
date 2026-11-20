package yw;

import android.app.Application;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.Season;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tp.f;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a extends BaseQuickAdapter<Season, BaseViewHolder> {
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public boolean O;

    public a(int i11) {
        super(i11, null, 2, null);
        int iA = f0.a(104.0f);
        this.H = iA;
        int iA2 = f0.a(32.0f);
        this.I = iA2;
        int iA3 = f0.a(40.0f);
        this.J = iA3;
        f fVar = f.f77260a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        int iE = fVar.e(applicationA);
        this.K = iE;
        int i12 = (iE - iA3) / 3;
        this.L = i12;
        this.M = (int) (i12 * ((iA2 * 1.0f) / iA));
        this.N = 5;
        this.O = true;
    }

    public /* synthetic */ a(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? R$layout.item_accurate_subject_seasons : i11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Season item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        int iP = P(item);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) layoutParams)).height = this.M;
        if (iP >= this.N && this.O) {
            holder.setVisible(R$id.tvName, false);
            holder.setVisible(R$id.tvMore, true);
        } else {
            holder.setVisible(R$id.tvName, true);
            holder.setVisible(R$id.tvMore, false);
            holder.setText(R$id.tvName, getContext().getString(R$string.seasons, String.valueOf(item.getSe())));
        }
    }

    public final void H0(boolean z11) {
        this.O = z11;
    }
}
