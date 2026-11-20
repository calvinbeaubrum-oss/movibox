package su;

import com.transsion.memberapi.MemberTaskRewardInfo;
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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f76463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f76464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f76465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f76466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MemberTaskRewardInfo f76467e;

    public d(int i11, String rewardId, int i12, int i13, MemberTaskRewardInfo memberTaskRewardInfo) {
        Intrinsics.g(rewardId, "rewardId");
        this.f76463a = i11;
        this.f76464b = rewardId;
        this.f76465c = i12;
        this.f76466d = i13;
        this.f76467e = memberTaskRewardInfo;
    }

    public final int a() {
        return this.f76463a;
    }

    public final MemberTaskRewardInfo b() {
        return this.f76467e;
    }

    public final int c() {
        return this.f76465c;
    }

    public final String d() {
        return this.f76464b;
    }

    public final int e() {
        return this.f76466d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f76463a == dVar.f76463a && Intrinsics.b(this.f76464b, dVar.f76464b) && this.f76465c == dVar.f76465c && this.f76466d == dVar.f76466d && Intrinsics.b(this.f76467e, dVar.f76467e);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f76463a * 31) + this.f76464b.hashCode()) * 31) + this.f76465c) * 31) + this.f76466d) * 31;
        MemberTaskRewardInfo memberTaskRewardInfo = this.f76467e;
        return iHashCode + (memberTaskRewardInfo == null ? 0 : memberTaskRewardInfo.hashCode());
    }

    public String toString() {
        return "MemberTaskRewardData(index=" + this.f76463a + ", rewardId=" + this.f76464b + ", rewardAmount=" + this.f76465c + ", rewardType=" + this.f76466d + ", info=" + this.f76467e + ")";
    }
}
