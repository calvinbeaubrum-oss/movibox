package com.transsion.subroom.deeplink;

import androidx.annotation.Keep;
import com.tn.lib.net.bean.BaseDto;
import io.reactivex.rxjava3.core.j;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y30.f;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface ILaunchApi {

    /* JADX INFO: compiled from: source.java */
    @Keep
    @Metadata
    public static final class UrlBean implements Serializable {
        private String url;

        public UrlBean(String str) {
            this.url = str;
        }

        public static /* synthetic */ UrlBean copy$default(UrlBean urlBean, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = urlBean.url;
            }
            return urlBean.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final UrlBean copy(String str) {
            return new UrlBean(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UrlBean) && Intrinsics.b(this.url, ((UrlBean) obj).url);
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public String toString() {
            return "UrlBean(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ j a(ILaunchApi iLaunchApi, String str, String str2, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWholeUrl");
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return iLaunchApi.a(str, str2);
        }
    }

    @f("/wefeed-mobile-bff/share/longurl")
    j<BaseDto<UrlBean>> a(@t("url") String str, @t("host") String str2);
}
