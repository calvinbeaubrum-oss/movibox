package cy;

import com.transsion.subtitle_download.bean.SubtitleItem;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f62834a = new a();

    public final SubtitleDownloadTable a(SubtitleItem subtitleItem, String str, String str2, String str3, int i11, int i12, int i13) {
        String id2 = subtitleItem.getId();
        String str4 = id2 == null ? "" : id2;
        String lan = subtitleItem.getLan();
        String lanName = subtitleItem.getLanName();
        String name = subtitleItem.getName();
        String url = subtitleItem.getUrl();
        Long size = subtitleItem.getSize();
        Long delay = subtitleItem.getDelay();
        Integer downloads = subtitleItem.getDownloads();
        Integer type = subtitleItem.getType();
        int iIntValue = type != null ? type.intValue() : 1;
        String str5 = str == null ? "" : str;
        Integer episode = subtitleItem.getEpisode();
        int iIntValue2 = episode != null ? episode.intValue() : i12;
        Integer season = subtitleItem.getSeason();
        return new SubtitleDownloadTable(str4, i11, str5, lan, lanName, url, size, delay, downloads, iIntValue, "", name, str2, iIntValue2, season != null ? season.intValue() : i13, 0, str3, 0, null, "", null, null, 0, 7602176, null);
    }

    public final SubtitleDownloadTable b(String str, String str2, String str3, int i11, int i12, int i13, SubtitleItem subtitleItem) {
        Intrinsics.g(subtitleItem, "subtitleItem");
        return a(subtitleItem, str2, str, str3, i11, i12, i13);
    }
}
