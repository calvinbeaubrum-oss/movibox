package com.amazonaws.services.s3.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReplicationRule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplicationDestinationConfig f16086c;

    public void a(ReplicationDestinationConfig replicationDestinationConfig) {
        if (replicationDestinationConfig == null) {
            throw new IllegalArgumentException("Destination cannot be null in the replication rule");
        }
        this.f16086c = replicationDestinationConfig;
    }

    public void b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix cannot be null for a replication rule");
        }
        this.f16084a = str;
    }

    public void c(String str) {
        this.f16085b = str;
    }
}
