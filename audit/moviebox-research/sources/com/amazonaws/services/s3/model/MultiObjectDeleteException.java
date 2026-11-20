package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MultiObjectDeleteException extends AmazonS3Exception {
    private static final long serialVersionUID = -2004213552302446866L;
    private final List<DeleteObjectsResult.DeletedObject> deletedObjects;
    private final List<DeleteError> errors;

    /* JADX INFO: compiled from: source.java */
    public static class DeleteError {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f16031d;

        public void a(String str) {
            this.f16030c = str;
        }

        public void b(String str) {
            this.f16028a = str;
        }

        public void c(String str) {
            this.f16031d = str;
        }

        public void d(String str) {
            this.f16029b = str;
        }
    }

    public MultiObjectDeleteException(Collection<DeleteError> collection, Collection<DeleteObjectsResult.DeletedObject> collection2) {
        super("One or more objects could not be deleted");
        ArrayList arrayList = new ArrayList();
        this.errors = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.deletedObjects = arrayList2;
        arrayList2.addAll(collection2);
        arrayList.addAll(collection);
    }

    public List<DeleteObjectsResult.DeletedObject> getDeletedObjects() {
        return this.deletedObjects;
    }

    @Override // com.amazonaws.AmazonServiceException
    public String getErrorCode() {
        return super.getErrorCode();
    }

    public List<DeleteError> getErrors() {
        return this.errors;
    }
}
