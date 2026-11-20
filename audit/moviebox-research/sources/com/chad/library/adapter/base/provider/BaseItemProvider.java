package com.chad.library.adapter.base.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import i9.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public abstract class BaseItemProvider<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f28851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<BaseProviderMultiAdapter<T>> f28852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f28853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f28854d;

    public BaseItemProvider() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f28853c = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<ArrayList<Integer>>() { // from class: com.chad.library.adapter.base.provider.BaseItemProvider$clickViewIds$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
        this.f28854d = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<ArrayList<Integer>>() { // from class: com.chad.library.adapter.base.provider.BaseItemProvider$longClickViewIds$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
    }

    public abstract void a(BaseViewHolder baseViewHolder, T t11);

    public void b(BaseViewHolder helper, T t11, List<? extends Object> payloads) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(payloads, "payloads");
    }

    public BaseProviderMultiAdapter<T> c() {
        WeakReference<BaseProviderMultiAdapter<T>> weakReference = this.f28852b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final ArrayList<Integer> d() {
        return f();
    }

    public final ArrayList<Integer> e() {
        return j();
    }

    public final ArrayList<Integer> f() {
        return (ArrayList) this.f28853c.getValue();
    }

    public final Context g() {
        Context context = this.f28851a;
        if (context != null) {
            return context;
        }
        Intrinsics.y("context");
        return null;
    }

    public abstract int h();

    public abstract int i();

    public final ArrayList<Integer> j() {
        return (ArrayList) this.f28854d.getValue();
    }

    public void k(BaseViewHolder helper, View view, T t11, int i11) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(view, "view");
    }

    public boolean l(BaseViewHolder helper, View view, T t11, int i11) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(view, "view");
        return false;
    }

    public void m(BaseViewHolder helper, View view, T t11, int i11) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(view, "view");
    }

    public BaseViewHolder n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return new BaseViewHolder(a.a(parent, i()));
    }

    public boolean o(BaseViewHolder helper, View view, T t11, int i11) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(view, "view");
        return false;
    }

    public void p(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
    }

    public void q(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
    }

    public void r(BaseViewHolder viewHolder, int i11) {
        Intrinsics.g(viewHolder, "viewHolder");
    }

    public final void s(BaseProviderMultiAdapter<T> adapter) {
        Intrinsics.g(adapter, "adapter");
        this.f28852b = new WeakReference<>(adapter);
    }

    public final void t(Context context) {
        Intrinsics.g(context, "<set-?>");
        this.f28851a = context;
    }
}
