package com.amazonaws.services.s3.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class RoutingRule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RoutingRuleCondition f16087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RedirectRule f16088b;

    public void a(RoutingRuleCondition routingRuleCondition) {
        this.f16087a = routingRuleCondition;
    }

    public void b(RedirectRule redirectRule) {
        this.f16088b = redirectRule;
    }
}
