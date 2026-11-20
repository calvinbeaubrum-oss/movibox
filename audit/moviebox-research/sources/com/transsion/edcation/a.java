package com.transsion.edcation;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.edcation.bean.CourseBody;
import com.transsion.edcation.bean.CourseListResp;
import com.transsion.edcation.bean.EducationInterestResp;
import com.transsion.edcation.bean.InterestBody;
import io.reactivex.rxjava3.core.j;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import y30.f;
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

    /* JADX INFO: renamed from: com.transsion.edcation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0564a {
        public static /* synthetic */ j a(a aVar, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInterestList");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.b(str);
        }

        public static /* synthetic */ j b(a aVar, String str, String str2, int i11, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyCourse");
            }
            if ((i12 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            if ((i12 & 4) != 0) {
                i11 = 20;
            }
            return aVar.a(str, str2, i11);
        }

        public static /* synthetic */ Object c(a aVar, String str, InterestBody interestBody, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postInterest");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.d(str, interestBody, continuation);
        }

        public static /* synthetic */ j d(a aVar, String str, CourseBody courseBody, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCourse");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.c(str, courseBody);
        }
    }

    @f("/wefeed-mobile-bff/learning/my-course")
    j<BaseDto<CourseListResp>> a(@t("host") String str, @t("page") String str2, @t("perPage") int i11);

    @f("/wefeed-mobile-bff/learning/prefer-options")
    j<BaseDto<EducationInterestResp>> b(@t("host") String str);

    @o("/wefeed-mobile-bff/learning/add-course")
    j<BaseDto<String>> c(@t("host") String str, @y30.a CourseBody courseBody);

    @o("/wefeed-mobile-bff/learning/submit-prefer")
    Object d(@t("host") String str, @y30.a InterestBody interestBody, Continuation<? super BaseDto<String>> continuation);
}
