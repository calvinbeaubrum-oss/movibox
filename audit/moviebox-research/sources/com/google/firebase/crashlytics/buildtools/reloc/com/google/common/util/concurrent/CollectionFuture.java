package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    /* JADX INFO: compiled from: source.java */
    public abstract class CollectionFutureRunningState extends AggregateFuture<V, C>.RunningState {
        final /* synthetic */ CollectionFuture this$0;
        private List<Optional<V>> values;

        public CollectionFutureRunningState(CollectionFuture collectionFuture, ImmutableCollection<? extends i0<? extends V>> immutableCollection, boolean z11) {
            super(immutableCollection, z11, true);
            this.values = immutableCollection.isEmpty() ? ImmutableList.of() : Lists.k(immutableCollection.size());
            for (int i11 = 0; i11 < immutableCollection.size(); i11++) {
                this.values.add(null);
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void collectOneValue(boolean z11, int i11, V v11) {
            List<Optional<V>> list = this.values;
            if (list != null) {
                list.set(i11, Optional.fromNullable(v11));
            } else {
                if (!z11) {
                    throw null;
                }
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.u(true, "Future was done before all dependencies completed");
            }
        }

        public abstract C combine(List<Optional<V>> list);

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void handleAllCompleted() {
            List<Optional<V>> list = this.values;
            list.getClass();
            combine(list);
            throw null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            super.releaseResourcesAfterFailure();
            this.values = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class ListFuture<V> extends CollectionFuture<V, List<V>> {

        /* JADX INFO: compiled from: source.java */
        public final class ListFutureRunningState extends CollectionFuture<V, List<V>>.CollectionFutureRunningState {
            final /* synthetic */ ListFuture this$0;

            public ListFutureRunningState(ListFuture listFuture, ImmutableCollection<? extends i0<? extends V>> immutableCollection, boolean z11) {
                super(listFuture, immutableCollection, z11);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CollectionFuture.CollectionFutureRunningState
            public List<V> combine(List<Optional<V>> list) {
                ArrayList arrayListK = Lists.k(list.size());
                Iterator<Optional<V>> it = list.iterator();
                while (it.hasNext()) {
                    Optional<V> next = it.next();
                    arrayListK.add(next != null ? next.orNull() : null);
                }
                return Collections.unmodifiableList(arrayListK);
            }
        }
    }
}
