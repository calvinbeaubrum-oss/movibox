package com.transsion.publish.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.publish.R$layout;
import com.transsion.room.api.bean.LocationPlace;
import kotlin.Metadata;
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
public final class SelectLocationAdapter extends BaseQuickAdapter<LocationPlace, SelectLocationItemVH> {
    public Double H;
    public Double I;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class SelectLocationItemVH extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ew.j f56365b;

        /* JADX WARN: Illegal instructions before constructor call */
        public SelectLocationItemVH(ew.j viewBinding) {
            Intrinsics.g(viewBinding, "viewBinding");
            ConstraintLayout root = viewBinding.getRoot();
            Intrinsics.f(root, "viewBinding.root");
            super(root);
            this.f56365b = viewBinding;
        }

        public final ew.j e() {
            return this.f56365b;
        }
    }

    public SelectLocationAdapter() {
        super(R$layout.item_select_location, null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0086  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(SelectLocationItemVH holder, LocationPlace item) {
        String strA;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        holder.e().f64449c.setText(item.getName());
        String distance = item.getDistance();
        if (distance == null || distance.length() == 0) {
            Double d11 = this.H;
            if ((d11 != null ? d11.doubleValue() : 0.0d) <= 0.0d) {
                strA = item.getDistance();
            } else {
                Double d12 = this.I;
                if ((d12 != null ? d12.doubleValue() : 0.0d) <= 0.0d) {
                    strA = item.getDistance();
                } else if (this.H == null || this.I == null || item.getLat() == null || item.getLon() == null) {
                    strA = null;
                } else {
                    com.transsion.baselib.utils.l lVar = com.transsion.baselib.utils.l.f51319a;
                    Double d13 = this.H;
                    Intrinsics.d(d13);
                    double dDoubleValue = d13.doubleValue();
                    Double d14 = this.I;
                    Intrinsics.d(d14);
                    double dDoubleValue2 = d14.doubleValue();
                    Double lat = item.getLat();
                    Intrinsics.d(lat);
                    double dDoubleValue3 = lat.doubleValue();
                    Double lon = item.getLon();
                    Intrinsics.d(lon);
                    strA = lVar.a(dDoubleValue, dDoubleValue2, dDoubleValue3, lon.doubleValue());
                }
            }
        } else {
            strA = item.getDistance();
        }
        StringBuilder sb2 = new StringBuilder();
        if (strA != null && strA.length() != 0) {
            sb2.append(item.getDistance());
            sb2.append("·");
        }
        sb2.append(item.getAddress());
        holder.e().f64448b.setText(sb2);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public SelectLocationItemVH f0(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        ew.j jVarC = ew.j.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.f(jVarC, "inflate(LayoutInflater.f…(context), parent, false)");
        return new SelectLocationItemVH(jVarC);
    }

    public final void I0(Double d11, Double d12) {
        this.H = d11;
        this.I = d12;
    }
}
