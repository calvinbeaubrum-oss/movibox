package ps;

import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.bean.GameInfoType;
import com.transsion.commercialization.gameres.aha.c;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GameInfoType f74047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecommendInfo f74048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f74049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient String f74050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient String f74051e;

    /* JADX INFO: renamed from: ps.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class C0808a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f74052a;

        static {
            int[] iArr = new int[GameInfoType.values().length];
            try {
                iArr[GameInfoType.AHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GameInfoType.PS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f74052a = iArr;
        }
    }

    public a(GameInfoType type, RecommendInfo recommendInfo, c cVar) {
        Intrinsics.g(type, "type");
        this.f74047a = type;
        this.f74048b = recommendInfo;
        this.f74049c = cVar;
    }

    public final c a() {
        return this.f74049c;
    }

    public final String b() {
        String categoryName;
        RecommendInfo recommendInfo = this.f74048b;
        if (recommendInfo != null && (categoryName = recommendInfo.getCategoryName()) != null) {
            return categoryName;
        }
        c cVar = this.f74049c;
        String strB = cVar != null ? cVar.b() : null;
        return strB == null ? "" : strB;
    }

    public final String c() {
        String iconUrl;
        RecommendInfo recommendInfo = this.f74048b;
        if (recommendInfo != null && (iconUrl = recommendInfo.getIconUrl()) != null) {
            return iconUrl;
        }
        c cVar = this.f74049c;
        String strC = cVar != null ? cVar.c() : null;
        return strC == null ? "" : strC;
    }

    public final String d() {
        String name;
        RecommendInfo recommendInfo = this.f74048b;
        if (recommendInfo != null && (name = recommendInfo.getName()) != null) {
            return name;
        }
        c cVar = this.f74049c;
        String strF = cVar != null ? cVar.f() : null;
        return strF == null ? "" : strF;
    }

    public final String e() {
        String strD;
        int i11 = C0808a.f74052a[this.f74047a.ordinal()];
        if (i11 == 1) {
            c cVar = this.f74049c;
            return (cVar == null || (strD = cVar.d()) == null) ? "" : strD;
        }
        if (i11 != 2) {
            return "";
        }
        RecommendInfo recommendInfo = this.f74048b;
        if ((recommendInfo != null ? recommendInfo.getSize() : 0L) <= 0) {
            return "";
        }
        RecommendInfo recommendInfo2 = this.f74048b;
        return tp.a.a(recommendInfo2 != null ? recommendInfo2.getSize() : 0L, 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f74047a == aVar.f74047a && Intrinsics.b(this.f74048b, aVar.f74048b) && Intrinsics.b(this.f74049c, aVar.f74049c);
    }

    public final String f() {
        Double dE;
        String star;
        RecommendInfo recommendInfo = this.f74048b;
        if (recommendInfo != null && (star = recommendInfo.getStar()) != null) {
            return star;
        }
        c cVar = this.f74049c;
        return (cVar == null || (dE = cVar.e()) == null) ? "" : dE.toString();
    }

    public final String g() {
        return this.f74051e;
    }

    public final String h() {
        return this.f74050d;
    }

    public int hashCode() {
        int iHashCode = this.f74047a.hashCode() * 31;
        RecommendInfo recommendInfo = this.f74048b;
        int iHashCode2 = (iHashCode + (recommendInfo == null ? 0 : recommendInfo.hashCode())) * 31;
        c cVar = this.f74049c;
        return iHashCode2 + (cVar != null ? cVar.hashCode() : 0);
    }

    public final RecommendInfo i() {
        return this.f74048b;
    }

    public final GameInfoType j() {
        return this.f74047a;
    }

    public final void k(String str) {
        this.f74051e = str;
    }

    public final void l(String str) {
        this.f74050d = str;
    }

    public String toString() {
        return "GameResInfo(type=" + this.f74047a + ", psInfo=" + this.f74048b + ", ahaInfo=" + this.f74049c + ")";
    }
}
