package com.mbridge.msdk.dycreator.bus;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f43662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SubscriberMethod f43663b;

    public Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.f43662a = obj;
        this.f43663b = subscriberMethod;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return this.f43662a == subscription.f43662a && this.f43663b.equals(subscription.f43663b);
    }

    public final int hashCode() {
        return this.f43662a.hashCode() + this.f43663b.f43659d.hashCode();
    }
}
