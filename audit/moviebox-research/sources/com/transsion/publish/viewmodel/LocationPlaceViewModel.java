package com.transsion.publish.viewmodel;

import android.app.Application;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.place.PlaceDao;
import com.transsion.room.api.bean.LocationPlace;
import hw.a;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LocationPlaceViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f56803a = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.publish.viewmodel.LocationPlaceViewModel$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f56804b = LazyKt__LazyJVMKt.b(new Function0<PlaceDao>() { // from class: com.transsion.publish.viewmodel.LocationPlaceViewModel$placeDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PlaceDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).I0();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<List<LocationPlace>> f56805c = new c0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<List<LocationPlace>> f56806d = new c0<>();

    public final void f() {
        j.d(u0.a(this), w0.b(), null, new LocationPlaceViewModel$clearCache$1(this, null), 2, null);
    }

    public final void g() {
        j.d(u0.a(this), null, null, new LocationPlaceViewModel$getCache$1(this, null), 3, null);
    }

    public final c0<List<LocationPlace>> h() {
        return this.f56806d;
    }

    public final void i(Double d11, Double d12) {
        j.d(u0.a(this), null, null, new LocationPlaceViewModel$getLocationPlaceList$1(this, d11, d12, null), 3, null);
    }

    public final c0<List<LocationPlace>> j() {
        return this.f56805c;
    }

    public final PlaceDao k() {
        return (PlaceDao) this.f56804b.getValue();
    }

    public final a l() {
        return (a) this.f56803a.getValue();
    }

    public final void m(List<LocationPlace> list) {
        Intrinsics.g(list, "list");
        j.d(u0.a(this), w0.b(), null, new LocationPlaceViewModel$insertCache$1(list, this, null), 2, null);
    }
}
