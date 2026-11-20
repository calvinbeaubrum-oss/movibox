package com.google.android.libraries.places.internal;

import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzbwi {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = Logger.getLogger("okio.Okio");

    public static final boolean zza(AssertionError assertionError) {
        String message;
        Intrinsics.g(assertionError, "<this>");
        return (assertionError.getCause() == null || (message = assertionError.getMessage()) == null || !StringsKt__StringsKt.Q(message, "getsockname failed", false, 2, null)) ? false : true;
    }
}
