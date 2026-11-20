package com.amazonaws.auth;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class DefaultAWSCredentialsProviderChain extends AWSCredentialsProviderChain {
    public DefaultAWSCredentialsProviderChain() {
        super(new SystemPropertiesCredentialsProvider(), new ClasspathPropertiesFileCredentialsProvider());
    }
}
