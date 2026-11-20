package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.v0;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f12335a = new ReentrantLock(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0<List<NavBackStackEntry>> f12336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v0<Set<NavBackStackEntry>> f12337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f1<List<NavBackStackEntry>> f12339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f1<Set<NavBackStackEntry>> f12340f;

    public r() {
        v0<List<NavBackStackEntry>> v0VarA = g1.a(kotlin.collections.g.l());
        this.f12336b = v0VarA;
        v0<Set<NavBackStackEntry>> v0VarA2 = g1.a(w.f());
        this.f12337c = v0VarA2;
        this.f12339e = kotlinx.coroutines.flow.c.b(v0VarA);
        this.f12340f = kotlinx.coroutines.flow.c.b(v0VarA2);
    }

    public abstract NavBackStackEntry a(NavDestination navDestination, Bundle bundle);

    public final f1<List<NavBackStackEntry>> b() {
        return this.f12339e;
    }

    public final f1<Set<NavBackStackEntry>> c() {
        return this.f12340f;
    }

    public final boolean d() {
        return this.f12338d;
    }

    public void e(NavBackStackEntry entry) {
        Intrinsics.g(entry, "entry");
        v0<Set<NavBackStackEntry>> v0Var = this.f12337c;
        v0Var.setValue(x.j(v0Var.getValue(), entry));
    }

    @CallSuper
    public void f(NavBackStackEntry backStackEntry) {
        Intrinsics.g(backStackEntry, "backStackEntry");
        v0<List<NavBackStackEntry>> v0Var = this.f12336b;
        v0Var.setValue(CollectionsKt___CollectionsKt.y0(CollectionsKt___CollectionsKt.v0(v0Var.getValue(), CollectionsKt___CollectionsKt.q0(this.f12336b.getValue())), backStackEntry));
    }

    public void g(NavBackStackEntry popUpTo, boolean z11) {
        Intrinsics.g(popUpTo, "popUpTo");
        ReentrantLock reentrantLock = this.f12335a;
        reentrantLock.lock();
        try {
            v0<List<NavBackStackEntry>> v0Var = this.f12336b;
            List<NavBackStackEntry> value = v0Var.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (!(!Intrinsics.b((NavBackStackEntry) obj, popUpTo))) {
                    break;
                } else {
                    arrayList.add(obj);
                }
            }
            v0Var.setValue(arrayList);
            Unit unit = Unit.f68710a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void h(NavBackStackEntry backStackEntry) {
        Intrinsics.g(backStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.f12335a;
        reentrantLock.lock();
        try {
            v0<List<NavBackStackEntry>> v0Var = this.f12336b;
            v0Var.setValue(CollectionsKt___CollectionsKt.y0(v0Var.getValue(), backStackEntry));
            Unit unit = Unit.f68710a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void i(boolean z11) {
        this.f12338d = z11;
    }
}
