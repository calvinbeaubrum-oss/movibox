package com.transsion.postdetail.ui.fragment.preload;

import androidx.lifecycle.c0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import lu.b;

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
public final class VideoImmersiveDataLoader extends b<PostSubjectBean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImmVideoRequestEntity f55916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f55917g = LazyKt__LazyJVMKt.b(new Function0<xv.b>() { // from class: com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoader$service$2
        @Override // kotlin.jvm.functions.Function0
        public final xv.b invoke() {
            return (xv.b) NetServiceGenerator.f49399d.a().i(xv.b.class);
        }
    });

    public VideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity) {
        this.f55916f = immVideoRequestEntity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xv.b m() {
        return (xv.b) this.f55917g.getValue();
    }

    @Override // lu.b
    public void h(c0<PostSubjectBean> c0Var) {
        j(j.d(l0.a(w0.b()), null, null, new VideoImmersiveDataLoader$loadDataFromService$1(this, null), 3, null));
    }

    public final ImmVideoRequestEntity l() {
        return this.f55916f;
    }
}
