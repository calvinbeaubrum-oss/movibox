package tz;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity;
import java.util.List;
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
public final class b extends DiffUtil.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MusicLikedMultiItemEntity> f78083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<MusicLikedMultiItemEntity> f78084b;

    public b(List<MusicLikedMultiItemEntity> oldList, List<MusicLikedMultiItemEntity> newList) {
        Intrinsics.g(oldList, "oldList");
        Intrinsics.g(newList, "newList");
        this.f78083a = oldList;
        this.f78084b = newList;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.a
    public boolean a(int i11, int i12) {
        return Intrinsics.b(this.f78083a.get(i11), this.f78084b.get(i12));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.a
    public boolean b(int i11, int i12) {
        MusicLikedDbBean musicLikedDbBean = this.f78083a.get(i11).getMusicLikedDbBean();
        String subjectId = musicLikedDbBean != null ? musicLikedDbBean.getSubjectId() : null;
        MusicLikedDbBean musicLikedDbBean2 = this.f78084b.get(i12).getMusicLikedDbBean();
        return TextUtils.equals(subjectId, musicLikedDbBean2 != null ? musicLikedDbBean2.getSubjectId() : null);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.a
    public int d() {
        return this.f78084b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.a
    public int e() {
        return this.f78083a.size();
    }
}
