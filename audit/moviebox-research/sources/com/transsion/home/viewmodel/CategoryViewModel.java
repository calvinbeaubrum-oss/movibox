package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.home.bean.CategoryBean;
import com.transsion.moviedetailapi.bean.CategoryItemBean;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;
import rt.a;

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
public final class CategoryViewModel extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f52733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f52734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f52735d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f52736f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f52733b = 1;
        this.f52734c = 10;
        this.f52735d = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.home.viewmodel.CategoryViewModel$service$2
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return (a) NetServiceGenerator.f49399d.a().i(a.class);
            }
        });
        this.f52736f = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<CategoryBean>>>() { // from class: com.transsion.home.viewmodel.CategoryViewModel$categoryLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<BaseDto<CategoryBean>> invoke() {
                return new c0<>();
            }
        });
    }

    public final void f(String type) {
        Intrinsics.g(type, "type");
        j.d(u0.a(this), w0.b(), null, new CategoryViewModel$getCategoryList$1(type, this, null), 2, null);
    }

    public final c0<BaseDto<CategoryBean>> g() {
        return (c0) this.f52736f.getValue();
    }

    public final int h() {
        return this.f52733b;
    }

    public final a i() {
        return (a) this.f52735d.getValue();
    }

    public final void j(CategoryBean categoryBean) {
        List<CategoryItemBean> list;
        if (categoryBean == null || (list = categoryBean.getList()) == null) {
            return;
        }
        for (CategoryItemBean categoryItemBean : list) {
            Subject subject = categoryItemBean.getSubject();
            String ops = subject != null ? subject.getOps() : null;
            if (ops == null || ops.length() == 0) {
                Subject subject2 = categoryItemBean.getSubject();
                if (subject2 != null) {
                    subject2.setOps(categoryBean.getOps());
                }
            }
        }
    }

    public final void k(int i11) {
        this.f52733b = i11;
    }
}
