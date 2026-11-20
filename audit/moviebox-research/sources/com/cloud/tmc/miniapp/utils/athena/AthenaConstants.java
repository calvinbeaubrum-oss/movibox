package com.cloud.tmc.miniapp.utils.athena;

import java.util.concurrent.atomic.AtomicBoolean;
import rc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AthenaConstants extends b {
    public static AtomicBoolean currentProcessIsInitAthena = new AtomicBoolean(false);
    public static AtomicBoolean mainProcessIsInitAthena = new AtomicBoolean(false);
    public static AtomicBoolean delay = new AtomicBoolean(false);
}
