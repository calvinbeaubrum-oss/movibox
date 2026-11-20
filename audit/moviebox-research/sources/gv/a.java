package gv;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
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
public final class a {
    public static final Subject a(DownloadBean downloadBean) {
        if (downloadBean == null) {
            return null;
        }
        String subjectId = downloadBean.getSubjectId();
        int subjectType = downloadBean.getSubjectType();
        Long duration = downloadBean.getDuration();
        String string = duration != null ? duration.toString() : null;
        String titleNameAppendResolution = downloadBean.getTitleNameAppendResolution();
        Cover cover = new Cover(null, null, null, downloadBean.getCover(), null, downloadBean.getThumbnail(), null, null, null, 471, null);
        String ops = downloadBean.getOps();
        String genre = downloadBean.getGenre();
        String restrictLevel = downloadBean.getRestrictLevel();
        String releaseDate = downloadBean.getReleaseDate();
        String countryName = downloadBean.getCountryName();
        Integer seNum = downloadBean.getSeNum();
        String subtitles = downloadBean.getSubtitles();
        return new Subject(subjectId, Integer.valueOf(subjectType), titleNameAppendResolution, countryName, cover, releaseDate, null, string, null, genre, null, null, downloadBean.getImdbRate(), null, null, null, null, null, Boolean.TRUE, ops, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, seNum, 0, null, subtitles, null, null, restrictLevel, null, null, -791232, 3596287, null);
    }
}
