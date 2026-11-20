package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ListNextBatchOfVersionsRequest extends AmazonWebServiceRequest implements Serializable {
    private VersionListing previousVersionListing;

    public ListNextBatchOfVersionsRequest(VersionListing versionListing) {
        setPreviousVersionListing(versionListing);
    }

    public VersionListing getPreviousVersionListing() {
        return null;
    }

    public void setPreviousVersionListing(VersionListing versionListing) {
        throw new IllegalArgumentException("The parameter previousVersionListing must be specified.");
    }

    public ListVersionsRequest toListVersionsRequest() {
        throw null;
    }

    public ListNextBatchOfVersionsRequest withPreviousVersionListing(VersionListing versionListing) {
        setPreviousVersionListing(versionListing);
        return this;
    }
}
