package com.cloud.tmc.integration.structure.app;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.proxy.IFragmentManagerFactory;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.n;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Class, Object> f30927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f30928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f30929g;

    public b(App app, ViewGroup viewGroup, ViewGroup viewGroup2, FragmentActivity fragmentActivity) {
        super(app, fragmentActivity);
        this.f30927e = new HashMap();
        this.f30929g = viewGroup;
        this.f30928f = viewGroup2;
    }

    @Override // com.cloud.tmc.integration.structure.app.a, tb.b
    public boolean b() {
        return (n.a(j()) && i() != null && i().isTaskRoot()) ? i().moveTaskToBack(false) : super.b();
    }

    @Override // com.cloud.tmc.integration.structure.app.a, tb.b
    public void e(@NonNull Page page) {
        super.e(page);
    }

    @Override // com.cloud.tmc.integration.structure.app.a, tb.b
    public boolean f(@NonNull Page page) {
        return super.f(page);
    }

    @Override // com.cloud.tmc.integration.structure.app.a
    public com.cloud.tmc.integration.ui.fragment.a h() {
        return ((IFragmentManagerFactory) tc.a.a(IFragmentManagerFactory.class)).createFragmentManager(i());
    }

    @Override // com.cloud.tmc.integration.structure.app.a
    public ViewGroup l() {
        return this.f30928f;
    }

    @Override // com.cloud.tmc.integration.structure.app.a
    public void m() {
        super.m();
    }
}
