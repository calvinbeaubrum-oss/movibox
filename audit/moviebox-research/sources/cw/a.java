package cw;

import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.api.LinkEntity;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.room.api.bean.LocationPlace;
import java.util.List;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f62822a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f62823b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<PhotoEntity> f62824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioEntity f62825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VsMediaInfo f62826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinkEntity f62827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PhotoEntity f62828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Subject f62829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GroupBean f62830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LocationPlace f62831j;

    public final AudioEntity a() {
        return this.f62825d;
    }

    public final PhotoEntity b() {
        return this.f62828g;
    }

    public final GroupBean c() {
        return this.f62830i;
    }

    public final Integer d() {
        return this.f62823b;
    }

    public final Integer e() {
        return this.f62822a;
    }

    public final LinkEntity f() {
        return this.f62827f;
    }

    public final LocationPlace g() {
        return this.f62831j;
    }

    public final List<PhotoEntity> h() {
        return this.f62824c;
    }

    public final Subject i() {
        return this.f62829h;
    }

    public final VsMediaInfo j() {
        return this.f62826e;
    }

    public final void k(AudioEntity audioEntity) {
        this.f62825d = audioEntity;
    }

    public final void l(PhotoEntity photoEntity) {
        this.f62828g = photoEntity;
    }

    public final void m(GroupBean groupBean) {
        this.f62830i = groupBean;
    }

    public final void n(Integer num) {
        this.f62823b = num;
    }

    public final void o(Integer num) {
        this.f62822a = num;
    }

    public final void p(LinkEntity linkEntity) {
        this.f62827f = linkEntity;
    }

    public final void q(LocationPlace locationPlace) {
        this.f62831j = locationPlace;
    }

    public final void r(List<PhotoEntity> list) {
        this.f62824c = list;
    }

    public final void s(Subject subject) {
        this.f62829h = subject;
    }

    public final void t(VsMediaInfo vsMediaInfo) {
        this.f62826e = vsMediaInfo;
    }
}
