package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ClasspathPropertiesFileCredentialsProvider implements AWSCredentialsProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f15692b = "AwsCredentials.properties";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15693a;

    public ClasspathPropertiesFileCredentialsProvider() {
        this(f15692b);
    }

    public ClasspathPropertiesFileCredentialsProvider(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Credentials file path cannot be null");
        }
        if (str.startsWith("/")) {
            this.f15693a = str;
            return;
        }
        this.f15693a = "/" + str;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        InputStream resourceAsStream = getClass().getResourceAsStream(this.f15693a);
        if (resourceAsStream == null) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.f15693a + " file on the classpath");
        }
        try {
            return new PropertiesCredentials(resourceAsStream);
        } catch (IOException e11) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.f15693a + " file on the classpath", e11);
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f15693a + ")";
    }
}
