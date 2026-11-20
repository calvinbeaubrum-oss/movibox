package com.cloud.tmc.integration.ui.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.structure.Page;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a {
    @Nullable
    TmcFragment a(Page page);

    void b();

    boolean c(Page page, boolean z11, boolean z12);

    @Nullable
    TmcFragment d(Page page);

    void e(List<Page> list);

    @Nullable
    TmcFragment f(String str);

    @NonNull
    TmcFragment g(Page page);

    void h(Page page, TmcFragment tmcFragment);

    boolean i(@Nullable Page page);

    Set<TmcFragment> j();

    void k(@NonNull Page page, TmcFragment tmcFragment, boolean z11, boolean z12);

    @Nullable
    TmcFragment l();

    boolean m(@Nullable Page page, boolean z11);

    boolean onBackPressed();

    void release();
}
