package com.transsion.postdetail.shorttv.vskitstyle;

import com.transsion.postdetail.shorttv.vskitstyle.provider.ShortTvDownloadProvider;
import com.transsion.postdetail.shorttv.vskitstyle.provider.ShortTvEpisodeProvider;
import com.transsion.postdetail.shorttv.vskitstyle.provider.c;
import com.transsion.postdetail.shorttv.vskitstyle.provider.f;
import com.transsion.shorttv.favorite.IShortTvFavoriteProvider;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b implements qx.a {
    @Override // qx.a
    public com.transsion.shorttv.episode.a a() {
        return new ShortTvEpisodeProvider();
    }

    @Override // qx.a
    public ox.a b() {
        return new ShortTvDownloadProvider();
    }

    @Override // qx.a
    public px.a c() {
        return new com.transsion.postdetail.shorttv.vskitstyle.provider.b();
    }

    @Override // qx.a
    public qx.b d() {
        return new c();
    }

    @Override // qx.a
    public rx.a e() {
        return new f();
    }

    @Override // qx.a
    public IShortTvFavoriteProvider f() {
        return new com.transsion.postdetail.shorttv.vskitstyle.provider.a();
    }
}
