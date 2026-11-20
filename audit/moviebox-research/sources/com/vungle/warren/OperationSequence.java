package com.vungle.warren;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class OperationSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue<a> f61769a = new PriorityQueue<>(11, new Comparator<a>() { // from class: com.vungle.warren.OperationSequence.1
        @Override // java.util.Comparator
        public int compare(a aVar, a aVar2) {
            int iCompareTo = Integer.valueOf(aVar.f61772b.f61743k).compareTo(Integer.valueOf(aVar2.f61772b.f61743k));
            return iCompareTo == 0 ? Integer.valueOf(aVar.f61771a).compareTo(Integer.valueOf(aVar2.f61771a)) : iCompareTo;
        }
    });

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final AtomicInteger f61770c = new AtomicInteger();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f61771a = f61770c.incrementAndGet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public AdLoader.c f61772b;

        public a(@NonNull AdLoader.c cVar) {
            this.f61772b = cVar;
        }
    }

    public boolean a(a aVar) {
        return this.f61769a.offer(aVar);
    }

    public a b() {
        return this.f61769a.poll();
    }

    @Nullable
    public a c(AdRequest adRequest) {
        for (a aVar : this.f61769a) {
            if (aVar.f61772b.f61733a.equals(adRequest)) {
                this.f61769a.remove(aVar);
                return aVar;
            }
        }
        aVar = null;
        this.f61769a.remove(aVar);
        return aVar;
    }

    public List<a> d() {
        ArrayList arrayList = new ArrayList();
        while (!this.f61769a.isEmpty()) {
            a aVarPoll = this.f61769a.poll();
            if (aVarPoll != null) {
                arrayList.add(aVarPoll);
            }
        }
        return arrayList;
    }
}
