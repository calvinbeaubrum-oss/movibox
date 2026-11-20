package com.amazonaws.services.s3.model;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class GetObjectTaggingResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Tag> f16014b;

    public GetObjectTaggingResult(List<Tag> list) {
        this.f16014b = list;
    }

    public void a(String str) {
        this.f16013a = str;
    }
}
