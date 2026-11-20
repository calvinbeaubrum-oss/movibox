package vz;

import android.view.ViewGroup;
import com.transsion.player.orplayer.f;
import com.transsion.player.p006enum.PlayMimeType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.videofloat.bean.FloatPlayType;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ORPlayerView f79126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f79127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f79128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FloatPlayType f79129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f79130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f79131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f79132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f79133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f79134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f79135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f79136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PlayMimeType f79137l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f79138m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f79139n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f79140o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f79141p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f79142q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f79143r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f79144s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f79145t;

    public a(ORPlayerView playerView, f orPlayer, ViewGroup viewGroup, FloatPlayType playType, String subjectId, int i11, int i12, String str, String pageName) {
        Intrinsics.g(playerView, "playerView");
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(playType, "playType");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(pageName, "pageName");
        this.f79126a = playerView;
        this.f79127b = orPlayer;
        this.f79128c = viewGroup;
        this.f79129d = playType;
        this.f79130e = subjectId;
        this.f79131f = i11;
        this.f79132g = i12;
        this.f79133h = str;
        this.f79134i = pageName;
        this.f79145t = playType == FloatPlayType.LOCAL || playType == FloatPlayType.STREAM;
    }

    public final void A(boolean z11) {
        this.f79144s = z11;
    }

    public final void B(String str) {
        this.f79140o = str;
    }

    public final void C(long j11) {
        this.f79135j = j11;
    }

    public final void D(String str) {
        this.f79136k = str;
    }

    public final void E(int i11) {
        this.f79131f = i11;
    }

    public final void F(PlayMimeType playMimeType) {
        this.f79137l = playMimeType;
    }

    public final void G(Integer num) {
        this.f79138m = num;
    }

    public final boolean a() {
        return this.f79142q;
    }

    public final int b() {
        return this.f79132g;
    }

    public final boolean c() {
        PlayMimeType playMimeType = this.f79137l;
        return playMimeType == PlayMimeType.DASH || playMimeType == PlayMimeType.HLS;
    }

    public final String d() {
        return this.f79139n;
    }

    public final f e() {
        return this.f79127b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f79126a, aVar.f79126a) && Intrinsics.b(this.f79127b, aVar.f79127b) && Intrinsics.b(this.f79128c, aVar.f79128c) && this.f79129d == aVar.f79129d && Intrinsics.b(this.f79130e, aVar.f79130e) && this.f79131f == aVar.f79131f && this.f79132g == aVar.f79132g && Intrinsics.b(this.f79133h, aVar.f79133h) && Intrinsics.b(this.f79134i, aVar.f79134i);
    }

    public final String f() {
        return this.f79141p;
    }

    public final String g() {
        return this.f79134i;
    }

    public final FloatPlayType h() {
        return this.f79129d;
    }

    public int hashCode() {
        int iHashCode = ((this.f79126a.hashCode() * 31) + this.f79127b.hashCode()) * 31;
        ViewGroup viewGroup = this.f79128c;
        int iHashCode2 = (((((((((iHashCode + (viewGroup == null ? 0 : viewGroup.hashCode())) * 31) + this.f79129d.hashCode()) * 31) + this.f79130e.hashCode()) * 31) + this.f79131f) * 31) + this.f79132g) * 31;
        String str = this.f79133h;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.f79134i.hashCode();
    }

    public final String i() {
        return this.f79143r;
    }

    public final String j() {
        FloatPlayType floatPlayType = this.f79129d;
        if (floatPlayType != FloatPlayType.LOCAL) {
            return floatPlayType.name() + this.f79130e;
        }
        return floatPlayType.name() + this.f79130e + this.f79131f + this.f79132g;
    }

    public final ORPlayerView k() {
        return this.f79126a;
    }

    public final String l() {
        return this.f79140o;
    }

    public final long m() {
        return this.f79135j;
    }

    public final String n() {
        return this.f79133h;
    }

    public final String o() {
        return this.f79136k;
    }

    public final int p() {
        return this.f79131f;
    }

    public final String q() {
        return this.f79130e;
    }

    public final Integer r() {
        return this.f79138m;
    }

    public final String s() {
        return this.f79130e + "_" + this.f79131f + "_" + this.f79132g + "_en_" + (c() ? 2 : 1);
    }

    public final ViewGroup t() {
        return this.f79128c;
    }

    public String toString() {
        return "VideoFloatBean(playerView=" + this.f79126a + ", orPlayer=" + this.f79127b + ", subtitleViewGroup=" + this.f79128c + ", playType=" + this.f79129d + ", subjectId=" + this.f79130e + ", se=" + this.f79131f + ", ep=" + this.f79132g + ", resolution=" + this.f79133h + ", pageName=" + this.f79134i + ")";
    }

    public final boolean u() {
        return this.f79144s;
    }

    public final boolean v() {
        return this.f79145t;
    }

    public final void w(int i11) {
        this.f79132g = i11;
    }

    public final void x(String str) {
        this.f79139n = str;
    }

    public final void y(String str) {
        this.f79141p = str;
    }

    public final void z(String str) {
        this.f79143r = str;
    }
}
