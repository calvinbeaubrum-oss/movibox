package com.transsnet.downloader.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.fragment.DownloadMultiListFragment;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public final class h extends FragmentStateAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g00.c f60368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<ResourcesSeason> f60369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Subject f60370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f60371l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f60372m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f60373n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f60374o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f60375p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f60376q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f60377r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f60378s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<Integer, WeakReference<DownloadMultiListFragment>> f60379t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FragmentActivity activity, g00.c tabControl) {
        super(activity);
        Intrinsics.g(activity, "activity");
        Intrinsics.g(tabControl, "tabControl");
        this.f60368i = tabControl;
        this.f60379t = new LinkedHashMap();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        ResourcesSeason resourcesSeasonE = e(i11);
        DownloadMultiListFragment downloadMultiListFragmentA = DownloadMultiListFragment.X.a(this.f60372m, this.f60373n, this.f60370k, this.f60371l, this.f60374o, this.f60375p, 0, i11, this.f60378s, false, resourcesSeasonE != null ? resourcesSeasonE.getSe() : 0, this.f60376q, i11);
        downloadMultiListFragmentA.g2(this.f60369j);
        downloadMultiListFragmentA.h2(this.f60368i);
        this.f60379t.put(Integer.valueOf(i11), new WeakReference<>(downloadMultiListFragmentA));
        return downloadMultiListFragmentA;
    }

    public final DownloadMultiListFragment d(int i11) {
        WeakReference<DownloadMultiListFragment> weakReference = this.f60379t.get(Integer.valueOf(i11));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final ResourcesSeason e(int i11) {
        List<ResourcesSeason> list = this.f60369j;
        if (list != null) {
            return list.get(i11);
        }
        return null;
    }

    public final void f(List<ResourcesSeason> list) {
        this.f60369j = list;
    }

    public final void g(String str) {
        this.f60371l = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ResourcesSeason> list = this.f60369j;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void h(String str) {
        this.f60373n = str;
    }

    public final void i(String str) {
        this.f60374o = str;
    }

    public final void j(String str) {
        this.f60372m = str;
    }

    public final void k(Integer num) {
        this.f60377r = num;
    }

    public final void l(boolean z11) {
        this.f60378s = z11;
    }

    public final void m(Subject subject) {
        this.f60370k = subject;
    }

    public final void n(String str) {
        this.f60375p = str;
    }

    public final void o(int i11) {
        this.f60376q = i11;
    }
}
