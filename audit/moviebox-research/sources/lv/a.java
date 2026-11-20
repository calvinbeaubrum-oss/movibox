package lv;

import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.p006enum.PlayMimeType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
    public final String f70547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlayMimeType f70548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f70549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f70550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f70551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f70552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f70553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f70554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f70555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<c> f70556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f70557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f70558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f70559m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f70560n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f70561o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f70562p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f70563q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f70564r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Subject f70565s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<DubsInfo> f70566t;

    public a(String subjectId, PlayMimeType videoFormat, long j11, int i11, int i12, String subjectName, String str, String pageFrom, String pageName, List<c> playSteams, String cover, String thumbnail, String averageHueLight, int i13, Integer num, boolean z11, String str2, String str3) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(videoFormat, "videoFormat");
        Intrinsics.g(subjectName, "subjectName");
        Intrinsics.g(pageFrom, "pageFrom");
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(playSteams, "playSteams");
        Intrinsics.g(cover, "cover");
        Intrinsics.g(thumbnail, "thumbnail");
        Intrinsics.g(averageHueLight, "averageHueLight");
        this.f70547a = subjectId;
        this.f70548b = videoFormat;
        this.f70549c = j11;
        this.f70550d = i11;
        this.f70551e = i12;
        this.f70552f = subjectName;
        this.f70553g = str;
        this.f70554h = pageFrom;
        this.f70555i = pageName;
        this.f70556j = playSteams;
        this.f70557k = cover;
        this.f70558l = thumbnail;
        this.f70559m = averageHueLight;
        this.f70560n = i13;
        this.f70561o = num;
        this.f70562p = z11;
        this.f70563q = str2;
        this.f70564r = str3;
        this.f70566t = new ArrayList();
    }

    public /* synthetic */ a(String str, PlayMimeType playMimeType, long j11, int i11, int i12, String str2, String str3, String str4, String str5, List list, String str6, String str7, String str8, int i13, Integer num, boolean z11, String str9, String str10, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, playMimeType, (i14 & 4) != 0 ? 0L : j11, (i14 & 8) != 0 ? 0 : i11, (i14 & 16) != 0 ? 0 : i12, str2, (i14 & 64) != 0 ? null : str3, str4, str5, (i14 & 512) != 0 ? new ArrayList() : list, str6, str7, str8, i13, (i14 & 16384) != 0 ? 1 : num, (32768 & i14) != 0 ? false : z11, str9, (i14 & 131072) != 0 ? null : str10);
    }

    public final List<DubsInfo> a() {
        return this.f70566t;
    }

    public final String b() {
        return this.f70559m;
    }

    public final String c() {
        return this.f70557k;
    }

    public final int d() {
        return this.f70550d;
    }

    public final String e() {
        return this.f70553g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f70547a, aVar.f70547a) && this.f70548b == aVar.f70548b && this.f70549c == aVar.f70549c && this.f70550d == aVar.f70550d && this.f70551e == aVar.f70551e && Intrinsics.b(this.f70552f, aVar.f70552f) && Intrinsics.b(this.f70553g, aVar.f70553g) && Intrinsics.b(this.f70554h, aVar.f70554h) && Intrinsics.b(this.f70555i, aVar.f70555i) && Intrinsics.b(this.f70556j, aVar.f70556j) && Intrinsics.b(this.f70557k, aVar.f70557k) && Intrinsics.b(this.f70558l, aVar.f70558l) && Intrinsics.b(this.f70559m, aVar.f70559m) && this.f70560n == aVar.f70560n && Intrinsics.b(this.f70561o, aVar.f70561o) && this.f70562p == aVar.f70562p && Intrinsics.b(this.f70563q, aVar.f70563q) && Intrinsics.b(this.f70564r, aVar.f70564r);
    }

    public final boolean f() {
        return this.f70562p;
    }

    public final String g() {
        return this.f70554h;
    }

    public final String h() {
        return this.f70555i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28, types: [int] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v37 */
    public int hashCode() {
        int iHashCode = ((((((((((this.f70547a.hashCode() * 31) + this.f70548b.hashCode()) * 31) + p.a(this.f70549c)) * 31) + this.f70550d) * 31) + this.f70551e) * 31) + this.f70552f.hashCode()) * 31;
        String str = this.f70553g;
        int iHashCode2 = (((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f70554h.hashCode()) * 31) + this.f70555i.hashCode()) * 31) + this.f70556j.hashCode()) * 31) + this.f70557k.hashCode()) * 31) + this.f70558l.hashCode()) * 31) + this.f70559m.hashCode()) * 31) + this.f70560n) * 31;
        Integer num = this.f70561o;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z11 = this.f70562p;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode3 + r11) * 31;
        String str2 = this.f70563q;
        int iHashCode4 = (i11 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f70564r;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final List<c> i() {
        return this.f70556j;
    }

    public final long j() {
        return this.f70549c;
    }

    public final int k() {
        return this.f70551e;
    }

    public final int l() {
        return this.f70560n;
    }

    public final String m() {
        return this.f70547a;
    }

    public final String n() {
        return this.f70552f;
    }

    public final String o() {
        return this.f70564r;
    }

    public final Integer p() {
        return this.f70561o;
    }

    public final String q() {
        return this.f70558l;
    }

    public final String r() {
        return this.f70563q;
    }

    public final PlayMimeType s() {
        return this.f70548b;
    }

    public final boolean t() {
        PlayMimeType playMimeType = this.f70548b;
        if (playMimeType != PlayMimeType.DEFAULT) {
            return playMimeType == PlayMimeType.HLS && this.f70556j.size() > 1;
        }
        return true;
    }

    public String toString() {
        return "LongVdPlayerBean(subjectId=" + this.f70547a + ", videoFormat=" + this.f70548b + ", progress=" + this.f70549c + ", ep=" + this.f70550d + ", se=" + this.f70551e + ", subjectName=" + this.f70552f + ", episodeTitle=" + this.f70553g + ", pageFrom=" + this.f70554h + ", pageName=" + this.f70555i + ", playSteams=" + this.f70556j + ", cover=" + this.f70557k + ", thumbnail=" + this.f70558l + ", averageHueLight=" + this.f70559m + ", subjectDurationSeconds=" + this.f70560n + ", subjectType=" + this.f70561o + ", hasDelete=" + this.f70562p + ", titleName=" + this.f70563q + ", subjectOps=" + this.f70564r + ")";
    }

    public final void u(long j11) {
        this.f70549c = j11;
    }

    public final void v(Subject subject) {
        this.f70565s = subject;
    }
}
