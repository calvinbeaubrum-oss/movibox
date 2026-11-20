package jw;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class f extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f68163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f68164c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(View itemView) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        this.f68163b = itemView;
        View viewFindViewById = itemView.findViewById(R$id.image);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.image)");
        this.f68164c = (ImageView) viewFindViewById;
    }

    public final ImageView e() {
        return this.f68164c;
    }

    public final View f() {
        return this.f68163b;
    }
}
