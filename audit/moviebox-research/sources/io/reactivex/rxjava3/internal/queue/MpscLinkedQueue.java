package io.reactivex.rxjava3.internal.queue;

import java.util.concurrent.atomic.AtomicReference;
import m10.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class MpscLinkedQueue<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f67459a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f67460b = new AtomicReference<>();

    /* JADX INFO: compiled from: source.java */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        public LinkedQueueNode() {
        }

        public LinkedQueueNode(E e11) {
            spValue(e11);
        }

        public E getAndNullValue() {
            E eLpValue = lpValue();
            spValue(null);
            return eLpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e11) {
            this.value = e11;
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    public LinkedQueueNode<T> a() {
        return this.f67460b.get();
    }

    public LinkedQueueNode<T> b() {
        return this.f67460b.get();
    }

    public LinkedQueueNode<T> c() {
        return this.f67459a.get();
    }

    @Override // m10.g
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    public void d(LinkedQueueNode<T> linkedQueueNode) {
        this.f67460b.lazySet(linkedQueueNode);
    }

    public LinkedQueueNode<T> e(LinkedQueueNode<T> linkedQueueNode) {
        return this.f67459a.getAndSet(linkedQueueNode);
    }

    @Override // m10.g
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // m10.g
    public boolean offer(T t11) {
        if (t11 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t11);
        e(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // m10.f, m10.g
    public T poll() {
        LinkedQueueNode<T> linkedQueueNodeLvNext;
        LinkedQueueNode<T> linkedQueueNodeA = a();
        LinkedQueueNode<T> linkedQueueNodeLvNext2 = linkedQueueNodeA.lvNext();
        if (linkedQueueNodeLvNext2 != null) {
            T andNullValue = linkedQueueNodeLvNext2.getAndNullValue();
            d(linkedQueueNodeLvNext2);
            return andNullValue;
        }
        if (linkedQueueNodeA == c()) {
            return null;
        }
        do {
            linkedQueueNodeLvNext = linkedQueueNodeA.lvNext();
        } while (linkedQueueNodeLvNext == null);
        T andNullValue2 = linkedQueueNodeLvNext.getAndNullValue();
        d(linkedQueueNodeLvNext);
        return andNullValue2;
    }
}
