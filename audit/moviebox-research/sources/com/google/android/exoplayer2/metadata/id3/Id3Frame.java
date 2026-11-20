package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.z1;
import gh.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f33579id;

    public Id3Frame(String str) {
        this.f33579id = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return a.a(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ m1 getWrappedMetadataFormat() {
        return a.b(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void populateMediaMetadata(z1.b bVar) {
        a.c(this, bVar);
    }

    public String toString() {
        return this.f33579id;
    }
}
