package com.mbridge.msdk.dycreator.bus;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class PendingPost {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<PendingPost> f43650d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f43651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Subscription f43652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    PendingPost f43653c;

    private PendingPost(Object obj, Subscription subscription) {
        this.f43651a = obj;
        this.f43652b = subscription;
    }

    public static PendingPost a(Subscription subscription, Object obj) {
        List<PendingPost> list = f43650d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new PendingPost(obj, subscription);
                }
                PendingPost pendingPostRemove = list.remove(size - 1);
                pendingPostRemove.f43651a = obj;
                pendingPostRemove.f43652b = subscription;
                pendingPostRemove.f43653c = null;
                return pendingPostRemove;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(PendingPost pendingPost) {
        pendingPost.f43651a = null;
        pendingPost.f43652b = null;
        pendingPost.f43653c = null;
        List<PendingPost> list = f43650d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(pendingPost);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
