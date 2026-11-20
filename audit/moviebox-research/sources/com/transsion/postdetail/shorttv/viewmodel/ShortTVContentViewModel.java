package com.transsion.postdetail.shorttv.viewmodel;

import android.app.Application;
import android.net.Uri;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.a;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.report.o;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
@SourceDebugExtension
public final class ShortTVContentViewModel extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f55419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f55420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<ShortTVRespData> f55421d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<ShortTVRespData> f55422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<ShortTVRespData> f55423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<ShortTVRespData> f55424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<List<Subject>> f55425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0<List<Subject>> f55426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f55427k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVContentViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f55419b = LazyKt__LazyJVMKt.b(new Function0<xv.b>() { // from class: com.transsion.postdetail.shorttv.viewmodel.ShortTVContentViewModel$service$2
            @Override // kotlin.jvm.functions.Function0
            public final xv.b invoke() {
                return (xv.b) NetServiceGenerator.f49399d.a().i(xv.b.class);
            }
        });
        this.f55420c = LazyKt__LazyJVMKt.b(new Function0<ShortTVPlayDao>() { // from class: com.transsion.postdetail.shorttv.viewmodel.ShortTVContentViewModel$shortTVPlayDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShortTVPlayDao invoke() {
                Application applicationA = a.f49452a.a();
                if (applicationA != null) {
                    return AppDatabase.f51036p.b(applicationA).K0();
                }
                return null;
            }
        });
        this.f55421d = new c0<>();
        this.f55422f = new c0<>();
        this.f55423g = new c0<>();
        this.f55424h = new c0<>();
        this.f55425i = new c0<>();
        this.f55426j = new c0<>();
        this.f55427k = LazyKt__LazyJVMKt.b(new Function0<k0>() { // from class: com.transsion.postdetail.shorttv.viewmodel.ShortTVContentViewModel$coroutineScopeIO$2
            @Override // kotlin.jvm.functions.Function0
            public final k0 invoke() {
                return l0.a(w0.b());
            }
        });
    }

    public final c0<ShortTVRespData> d() {
        return this.f55423g;
    }

    public final c0<ShortTVRespData> e() {
        return this.f55424h;
    }

    public final c0<List<Subject>> f() {
        return this.f55426j;
    }

    public final xv.b g() {
        return (xv.b) this.f55419b.getValue();
    }

    public final void h() {
        i("1", 8, false);
    }

    public final void i(String nextPage, int i11, boolean z11) {
        Intrinsics.g(nextPage, "nextPage");
        j.d(u0.a(this), null, null, new ShortTVContentViewModel$getShortTVFavoriteList$1(this, nextPage, i11, z11, null), 3, null);
    }

    public final void j(String nextPage, int i11, boolean z11) {
        String string;
        Intrinsics.g(nextPage, "nextPage");
        ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
        immVideoRequestEntity.setPage(nextPage);
        immVideoRequestEntity.setPerPage(i11);
        immVideoRequestEntity.setSessionId(fp.b.f65208a.h());
        Uri uriA = o.f51281a.a();
        if (uriA == null || (string = uriA.toString()) == null) {
            string = "";
        }
        immVideoRequestEntity.setDeepLink(string);
        immVideoRequestEntity.setLatest_events(new ds.a(ds.b.f63534a.e()));
        j.d(u0.a(this), null, null, new ShortTVContentViewModel$getShortTVTrending$1(immVideoRequestEntity, this, z11, null), 3, null);
    }

    public final c0<ShortTVRespData> k() {
        return this.f55422f;
    }
}
