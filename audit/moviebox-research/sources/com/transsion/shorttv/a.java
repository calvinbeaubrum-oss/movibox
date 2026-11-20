package com.transsion.shorttv;

import com.transsion.player.ui.ORPlayerView;
import kotlin.Metadata;

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
public interface a extends com.transsion.player.orplayer.e {

    /* JADX INFO: renamed from: com.transsion.shorttv.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0596a {
        public static /* synthetic */ void a(a aVar, qx.d dVar, ShortTvBaseListFragment shortTvBaseListFragment, Integer num, boolean z11, String str, String str2, boolean z12, boolean z13, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setData");
            }
            aVar.setData(dVar, shortTvBaseListFragment, num, z11, str, str2, (i11 & 64) != 0 ? false : z12, (i11 & 128) != 0 ? false : z13);
        }
    }

    long getProgress();

    void onPageRelease(int i11);

    void onPageSelected(com.transsion.player.orplayer.f fVar, ORPlayerView oRPlayerView, qx.d dVar);

    void setData(qx.d dVar, ShortTvBaseListFragment shortTvBaseListFragment, Integer num, boolean z11, String str, String str2, boolean z12, boolean z13);
}
