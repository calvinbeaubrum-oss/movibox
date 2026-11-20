package com.facebook.biddingkit.auction;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends d {

    /* JADX INFO: compiled from: source.java */
    public static class a implements Callable<wf.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f32417a;

        public a(wf.b bVar, String str) {
            this.f32417a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public wf.a call() {
            throw null;
        }
    }

    public static List<Object> a(String str, wf.b bVar, b bVar2) {
        xf.a.f80480c.submit(new a(bVar, str));
        new com.facebook.biddingkit.logging.e();
        throw null;
    }
}
