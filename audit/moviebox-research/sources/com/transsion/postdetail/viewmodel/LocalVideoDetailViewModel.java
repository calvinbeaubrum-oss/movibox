package com.transsion.postdetail.viewmodel;

import android.util.Log;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Subject;
import h10.b;
import i00.a;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;
import zo.d;

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
public final class LocalVideoDetailViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56263a = "LocalVideoViewModel";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f56264b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel$serviceDownload$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0<List<DownloadBean>> f56265c = new c0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0<DownloadBean> f56266d = new c0<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c0<DownloadBean> f56267f = new c0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<Subject> f56268g = new c0<>();

    private final a i() {
        return (a) this.f56264b.getValue();
    }

    public final void c(String str) {
        if (str == null || str.length() == 0) {
            this.f56268g.n(null);
        } else if (f.f49475a.e()) {
            i().a(cp.a.f62775a.a(), str).e(d.f82109a.c()).subscribe(new zo.a<Subject>() { // from class: com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel$fetchMovieData$1
                @Override // zo.a
                public void a(String str2, String str3) {
                    this.f56269d.f().n(null);
                    Log.e(this.f56269d.f56263a, "message:" + str3);
                }

                @Override // zo.a
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public void c(Subject subject) {
                    j.d(u0.a(this.f56269d), null, null, new LocalVideoDetailViewModel$fetchMovieData$1$onSuccess$1(this.f56269d, subject, null), 3, null);
                }

                @Override // zo.a, io.reactivex.rxjava3.core.o
                public void onSubscribe(b d11) {
                    Intrinsics.g(d11, "d");
                    super.onSubscribe(d11);
                }
            });
        } else {
            this.f56268g.n(null);
        }
    }

    public final c0<DownloadBean> d() {
        return this.f56266d;
    }

    public final c0<DownloadBean> e() {
        return this.f56267f;
    }

    public final c0<Subject> f() {
        return this.f56268g;
    }

    public final void g(DownloadBean downloadBean) {
        j.d(u0.a(this), w0.b(), null, new LocalVideoDetailViewModel$getSeriesFromLocal$1(downloadBean, this, null), 2, null);
    }

    public final c0<List<DownloadBean>> h() {
        return this.f56265c;
    }
}
