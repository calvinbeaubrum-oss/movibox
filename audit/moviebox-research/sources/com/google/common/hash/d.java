package com.google.common.hash;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface d {
    <T> HashCode hashObject(T t11, Funnel<? super T> funnel);

    e newHasher();
}
