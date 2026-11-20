package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface PeekingIterator<E> extends Iterator<E> {
    @Override // java.util.Iterator
    E next();

    E peek();
}
