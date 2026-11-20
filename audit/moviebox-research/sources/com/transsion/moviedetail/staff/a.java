package com.transsion.moviedetail.staff;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetail.staff.bean.MovieStaffList;
import com.transsion.moviedetail.staff.bean.MovieStaffSubjectList;
import com.transsion.moviedetailapi.bean.Staff;
import kotlin.Metadata;
import okhttp3.RequestBody;
import y30.o;
import y30.t;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: com.transsion.moviedetail.staff.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0576a {
        public static /* synthetic */ io.reactivex.rxjava3.core.j a(a aVar, String str, String str2, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMovieStaffInfo");
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return aVar.d(str, str2);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j b(a aVar, String str, String str2, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMovieStaffRelated");
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return aVar.c(str, str2);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j c(a aVar, String str, int i11, int i12, int i13, String str2, int i14, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMovieStaffSubjectList");
            }
            int i15 = (i14 & 8) != 0 ? 1 : i13;
            if ((i14 & 16) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return aVar.a(str, i11, i12, i15, str2);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j d(a aVar, RequestBody requestBody, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMovieStaffWantToSee");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.b(requestBody, str);
        }
    }

    @y30.f("/wefeed-mobile-bff/subject-api/staff-subject-list")
    io.reactivex.rxjava3.core.j<BaseDto<MovieStaffSubjectList>> a(@t("staffId") String str, @t("start") int i11, @t(TtmlNode.END) int i12, @t("pagerMode") int i13, @t("host") String str2);

    @o("/wefeed-mobile-bff/subject-api/want-to-see-staff")
    io.reactivex.rxjava3.core.j<BaseDto<String>> b(@y30.a RequestBody requestBody, @t("host") String str);

    @y30.f("/wefeed-mobile-bff/subject-api/staff-related")
    io.reactivex.rxjava3.core.j<BaseDto<MovieStaffList>> c(@t("staffId") String str, @t("host") String str2);

    @y30.f("/wefeed-mobile-bff/subject-api/staff-info")
    io.reactivex.rxjava3.core.j<BaseDto<Staff>> d(@t("staffId") String str, @t("host") String str2);
}
