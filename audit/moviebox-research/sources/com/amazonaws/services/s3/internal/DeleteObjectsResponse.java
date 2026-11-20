package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class DeleteObjectsResponse implements S3RequesterChargedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<DeleteObjectsResult.DeletedObject> f15946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<MultiObjectDeleteException.DeleteError> f15947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15948c;

    public DeleteObjectsResponse() {
        this(new ArrayList(), new ArrayList());
    }

    public DeleteObjectsResponse(List<DeleteObjectsResult.DeletedObject> list, List<MultiObjectDeleteException.DeleteError> list2) {
        this.f15946a = list;
        this.f15947b = list2;
    }

    public List<DeleteObjectsResult.DeletedObject> a() {
        return this.f15946a;
    }

    public List<MultiObjectDeleteException.DeleteError> b() {
        return this.f15947b;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z11) {
        this.f15948c = z11;
    }
}
