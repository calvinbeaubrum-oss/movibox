package androidx.work.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ExistingWorkPolicy;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends androidx.work.p {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13549j = androidx.work.j.i("WorkContinuationImpl");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f13550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExistingWorkPolicy f13552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<? extends androidx.work.r> f13553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f13554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f13555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<w> f13556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public androidx.work.l f13558i;

    public w(@NonNull d0 d0Var, @Nullable String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<? extends androidx.work.r> list) {
        this(d0Var, str, existingWorkPolicy, list, null);
    }

    public w(@NonNull d0 d0Var, @Nullable String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<? extends androidx.work.r> list, @Nullable List<w> list2) {
        this.f13550a = d0Var;
        this.f13551b = str;
        this.f13552c = existingWorkPolicy;
        this.f13553d = list;
        this.f13556g = list2;
        this.f13554e = new ArrayList(list.size());
        this.f13555f = new ArrayList();
        if (list2 != null) {
            Iterator<w> it = list2.iterator();
            while (it.hasNext()) {
                this.f13555f.addAll(it.next().f13555f);
            }
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            String strB = list.get(i11).b();
            this.f13554e.add(strB);
            this.f13555f.add(strB);
        }
    }

    public w(@NonNull d0 d0Var, @NonNull List<? extends androidx.work.r> list) {
        this(d0Var, null, ExistingWorkPolicy.KEEP, list, null);
    }

    public static boolean i(@NonNull w wVar, @NonNull Set<String> set) {
        set.addAll(wVar.c());
        Set<String> setL = l(wVar);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (setL.contains(it.next())) {
                return true;
            }
        }
        List<w> listE = wVar.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator<w> it2 = listE.iterator();
            while (it2.hasNext()) {
                if (i(it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(wVar.c());
        return false;
    }

    @NonNull
    public static Set<String> l(@NonNull w wVar) {
        HashSet hashSet = new HashSet();
        List<w> listE = wVar.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator<w> it = listE.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().c());
            }
        }
        return hashSet;
    }

    @Override // androidx.work.p
    @NonNull
    public androidx.work.l a() {
        if (this.f13557h) {
            androidx.work.j.e().k(f13549j, "Already enqueued work ids (" + TextUtils.join(", ", this.f13554e) + ")");
        } else {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.f13550a.v().c(enqueueRunnable);
            this.f13558i = enqueueRunnable.getOperation();
        }
        return this.f13558i;
    }

    @NonNull
    public ExistingWorkPolicy b() {
        return this.f13552c;
    }

    @NonNull
    public List<String> c() {
        return this.f13554e;
    }

    @Nullable
    public String d() {
        return this.f13551b;
    }

    @Nullable
    public List<w> e() {
        return this.f13556g;
    }

    @NonNull
    public List<? extends androidx.work.r> f() {
        return this.f13553d;
    }

    @NonNull
    public d0 g() {
        return this.f13550a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f13557h;
    }

    public void k() {
        this.f13557h = true;
    }
}
