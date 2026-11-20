package xx;

import android.view.ViewGroup;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.subtitle.helper.d;
import java.util.List;
import kotlin.Metadata;

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
public interface b {
    SimpleSubtitleView a();

    void b(boolean z11);

    void c(String str);

    SimpleSubtitleView d();

    void e(boolean z11);

    boolean f();

    void g(DubsInfo dubsInfo);

    ViewGroup getSubtitleViewGroup();

    d h();

    List<vx.a> i();

    void j(vx.a aVar, long j11);

    boolean k();

    void l(vx.a aVar, vx.a aVar2, boolean z11);
}
