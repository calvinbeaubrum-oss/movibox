package bq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c implements aq.c<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aq.c<?> f14312b;

    public c(int i11, aq.c<?> cVar) {
        this.f14311a = i11;
        this.f14312b = cVar;
    }

    @Override // aq.c
    public View a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(this.f14311a, (ViewGroup) null);
        Intrinsics.f(viewInflate, "from(context).inflate(mLayoutId, null)");
        return viewInflate;
    }

    @Override // aq.c
    public int getGravity() {
        aq.c<?> cVar = this.f14312b;
        if (cVar != null) {
            return cVar.getGravity();
        }
        return 17;
    }

    @Override // aq.c
    public float getHorizontalMargin() {
        aq.c<?> cVar = this.f14312b;
        if (cVar != null) {
            return cVar.getHorizontalMargin();
        }
        return 0.0f;
    }

    @Override // aq.c
    public float getVerticalMargin() {
        aq.c<?> cVar = this.f14312b;
        if (cVar != null) {
            return cVar.getVerticalMargin();
        }
        return 0.0f;
    }

    @Override // aq.c
    public int getXOffset() {
        aq.c<?> cVar = this.f14312b;
        if (cVar != null) {
            return cVar.getXOffset();
        }
        return 0;
    }

    @Override // aq.c
    public int getYOffset() {
        aq.c<?> cVar = this.f14312b;
        if (cVar != null) {
            return cVar.getYOffset();
        }
        return 0;
    }
}
