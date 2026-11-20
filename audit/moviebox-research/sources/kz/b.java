package kz;

import com.transsion.usercenter.setting.bean.UserSettingType;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserSettingType f69711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f69712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f69713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f69714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f69715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f69716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f69717h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f69718i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f69719j;

    public b(int i11, UserSettingType userSettingType, String str, Integer num, int i12, String str2, boolean z11, boolean z12, boolean z13) {
        this.f69710a = i11;
        this.f69711b = userSettingType;
        this.f69712c = str;
        this.f69713d = num;
        this.f69714e = i12;
        this.f69715f = str2;
        this.f69716g = z11;
        this.f69717h = z12;
        this.f69718i = z13;
    }

    public /* synthetic */ b(int i11, UserSettingType userSettingType, String str, Integer num, int i12, String str2, boolean z11, boolean z12, boolean z13, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i13 & 2) != 0 ? null : userSettingType, (i13 & 4) != 0 ? null : str, (i13 & 8) != 0 ? null : num, (i13 & 16) != 0 ? 1 : i12, (i13 & 32) == 0 ? str2 : null, (i13 & 64) != 0 ? false : z11, (i13 & 128) == 0 ? z12 : false, (i13 & 256) == 0 ? z13 : true);
    }

    public final Integer a() {
        return this.f69713d;
    }

    public final String b() {
        return this.f69712c;
    }

    public final boolean c() {
        return this.f69719j;
    }

    public final boolean d() {
        return this.f69718i;
    }

    public final boolean e() {
        return this.f69717h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f69710a == bVar.f69710a && this.f69711b == bVar.f69711b && Intrinsics.b(this.f69712c, bVar.f69712c) && Intrinsics.b(this.f69713d, bVar.f69713d) && this.f69714e == bVar.f69714e && Intrinsics.b(this.f69715f, bVar.f69715f) && this.f69716g == bVar.f69716g && this.f69717h == bVar.f69717h && this.f69718i == bVar.f69718i;
    }

    public final String f() {
        return this.f69715f;
    }

    public final boolean g() {
        return this.f69716g;
    }

    public final int h() {
        return this.f69710a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int i11 = this.f69710a * 31;
        UserSettingType userSettingType = this.f69711b;
        int iHashCode = (i11 + (userSettingType == null ? 0 : userSettingType.hashCode())) * 31;
        String str = this.f69712c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.f69713d;
        int iHashCode3 = (((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.f69714e) * 31;
        String str2 = this.f69715f;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z11 = this.f69716g;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i12 = (iHashCode4 + r11) * 31;
        boolean z12 = this.f69717h;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i13 = (i12 + r12) * 31;
        boolean z13 = this.f69718i;
        return i13 + (z13 ? 1 : z13);
    }

    public final UserSettingType i() {
        return this.f69711b;
    }

    public final int j() {
        return this.f69714e;
    }

    public final void k(Integer num) {
        this.f69713d = num;
    }

    public final void l(String str) {
        this.f69712c = str;
    }

    public final void m(boolean z11) {
        this.f69719j = z11;
    }

    public final void n(boolean z11) {
        this.f69717h = z11;
    }

    public final void o(String str) {
        this.f69715f = str;
    }

    public String toString() {
        return "UserSettingEntity(titleResId=" + this.f69710a + ", type=" + this.f69711b + ", content=" + this.f69712c + ", bgId=" + this.f69713d + ", uiType=" + this.f69714e + ", tips=" + this.f69715f + ", tipsLinearColor=" + this.f69716g + ", switch=" + this.f69717h + ", showDivider=" + this.f69718i + ")";
    }
}
