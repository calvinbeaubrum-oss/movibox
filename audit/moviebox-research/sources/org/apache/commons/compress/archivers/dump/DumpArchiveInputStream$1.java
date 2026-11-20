package org.apache.commons.compress.archivers.dump;

import com.google.android.gms.common.api.Api;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
class DumpArchiveInputStream$1 implements Comparator<DumpArchiveEntry> {
    final /* synthetic */ a this$0;

    public DumpArchiveInputStream$1(a aVar) {
    }

    @Override // java.util.Comparator
    public int compare(DumpArchiveEntry dumpArchiveEntry, DumpArchiveEntry dumpArchiveEntry2) {
        return (dumpArchiveEntry.b() == null || dumpArchiveEntry2.b() == null) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : dumpArchiveEntry.b().compareTo(dumpArchiveEntry2.b());
    }
}
