package jt;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VideoDetailPlayBean f68132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Subject f68133b;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public a(VideoDetailPlayBean videoDetailPlayBean, Subject subject) {
        this.f68132a = videoDetailPlayBean;
        this.f68133b = subject;
    }

    public /* synthetic */ a(VideoDetailPlayBean videoDetailPlayBean, Subject subject, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : videoDetailPlayBean, (i11 & 2) != 0 ? null : subject);
    }

    public final VideoDetailPlayBean a() {
        return this.f68132a;
    }

    public final Subject b() {
        return this.f68133b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f68132a, aVar.f68132a) && Intrinsics.b(this.f68133b, aVar.f68133b);
    }

    public int hashCode() {
        VideoDetailPlayBean videoDetailPlayBean = this.f68132a;
        int iHashCode = (videoDetailPlayBean == null ? 0 : videoDetailPlayBean.hashCode()) * 31;
        Subject subject = this.f68133b;
        return iHashCode + (subject != null ? subject.hashCode() : 0);
    }

    public String toString() {
        return "HonorAdapterBean(history=" + this.f68132a + ", subject=" + this.f68133b + ")";
    }
}
