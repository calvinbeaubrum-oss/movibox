package com.transsion.baseui.fragment;

import com.tn.lib.util.networkinfo.f;
import kotlin.Metadata;
import n6.a;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class LazyFragment<T extends n6.a> extends PageStatusFragment<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f51353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f51354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f51355m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f51356n;

    public final void Q0() {
        if (!this.f51353k && this.f51354l && this.f51355m) {
            this.f51353k = true;
            if (f.f49475a.e()) {
                lazyLoadData();
            }
            String simpleName = getClass().getSimpleName();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TraditionLazyFragment --> ");
            sb2.append(simpleName);
            sb2.append(" lazyInit:!!!!!!!");
        }
    }

    public abstract void lazyLoadData();

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f51353k = false;
        this.f51354l = false;
        this.f51356n = false;
        this.f51355m = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        this.f51354l = !z11;
        Q0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f51355m = true;
        if (!this.f51356n) {
            this.f51354l = true ^ isHidden();
        }
        Q0();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        this.f51354l = z11;
        this.f51356n = true;
        Q0();
    }
}
