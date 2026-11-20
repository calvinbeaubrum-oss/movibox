package org.chromium.net;

import com.applovin.impl.lz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d extends ICronetEngineBuilder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Integer> f73062d = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 3)));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f73063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f73064b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ICronetEngineBuilder f73065c;

    /* JADX INFO: compiled from: source.java */
    @FunctionalInterface
    public interface a {
        void a(JSONObject jSONObject) throws JSONException;
    }

    public d(ICronetEngineBuilder iCronetEngineBuilder) {
        this.f73065c = iCronetEngineBuilder;
    }

    public static JSONObject d(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            try {
                jSONObject.put(str, jSONObjectOptJSONObject);
            } catch (JSONException e11) {
                throw new IllegalArgumentException("Failed adding a default object for key [" + str + "]", e11);
            }
        }
        return jSONObjectOptJSONObject;
    }

    public static /* synthetic */ void e(ConnectionMigrationOptions connectionMigrationOptions, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectD = d(jSONObject, "QUIC");
        if (connectionMigrationOptions.getEnableDefaultNetworkMigration() != null) {
            jSONObjectD.put("migrate_sessions_on_network_change_v2", connectionMigrationOptions.getEnableDefaultNetworkMigration());
        }
        if (connectionMigrationOptions.getAllowServerMigration() != null) {
            jSONObjectD.put("allow_server_migration", connectionMigrationOptions.getAllowServerMigration());
        }
        if (connectionMigrationOptions.getMigrateIdleConnections() != null) {
            jSONObjectD.put("migrate_idle_sessions", connectionMigrationOptions.getMigrateIdleConnections());
        }
        if (connectionMigrationOptions.getIdleMigrationPeriodSeconds() != null) {
            jSONObjectD.put("idle_session_migration_period_seconds", connectionMigrationOptions.getIdleMigrationPeriodSeconds());
        }
        if (connectionMigrationOptions.getRetryPreHandshakeErrorsOnAlternateNetwork() != null) {
            jSONObjectD.put("retry_on_alternate_network_before_handshake", connectionMigrationOptions.getRetryPreHandshakeErrorsOnAlternateNetwork());
        }
        if (connectionMigrationOptions.getMaxTimeOnNonDefaultNetworkSeconds() != null) {
            jSONObjectD.put("max_time_on_non_default_network_seconds", connectionMigrationOptions.getMaxTimeOnNonDefaultNetworkSeconds());
        }
        if (connectionMigrationOptions.getMaxPathDegradingEagerMigrationsCount() != null) {
            jSONObjectD.put("max_migrations_to_non_default_network_on_path_degrading", connectionMigrationOptions.getMaxPathDegradingEagerMigrationsCount());
        }
        if (connectionMigrationOptions.getMaxWriteErrorEagerMigrationsCount() != null) {
            jSONObjectD.put("max_migrations_to_non_default_network_on_write_error", connectionMigrationOptions.getMaxWriteErrorEagerMigrationsCount());
        }
        if (connectionMigrationOptions.getEnablePathDegradationMigration() != null) {
            boolean zBooleanValue = connectionMigrationOptions.getEnablePathDegradationMigration().booleanValue();
            if (connectionMigrationOptions.getAllowNonDefaultNetworkUsage() != null) {
                boolean zBooleanValue2 = connectionMigrationOptions.getAllowNonDefaultNetworkUsage().booleanValue();
                if (!zBooleanValue && zBooleanValue2) {
                    throw new IllegalArgumentException("Unable to turn on non-default network usage without path degradation migration!");
                }
                if (zBooleanValue && zBooleanValue2) {
                    jSONObjectD.put("migrate_sessions_early_v2", true);
                    return;
                }
                jSONObjectD.put("migrate_sessions_early_v2", false);
            }
            jSONObjectD.put("allow_port_migration", zBooleanValue);
        }
    }

    public static /* synthetic */ void f(DnsOptions dnsOptions, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectD = d(jSONObject, "AsyncDNS");
        if (dnsOptions.getUseBuiltInDnsResolver() != null) {
            jSONObjectD.put("enable", dnsOptions.getUseBuiltInDnsResolver());
        }
        JSONObject jSONObjectD2 = d(jSONObject, "StaleDNS");
        if (dnsOptions.getEnableStaleDns() != null) {
            jSONObjectD2.put("enable", dnsOptions.getEnableStaleDns());
        }
        if (dnsOptions.getPersistHostCache() != null) {
            jSONObjectD2.put("persist_to_disk", dnsOptions.getPersistHostCache());
        }
        if (dnsOptions.getPersistHostCachePeriodMillis() != null) {
            jSONObjectD2.put("persist_delay_ms", dnsOptions.getPersistHostCachePeriodMillis());
        }
        if (dnsOptions.getStaleDnsOptions() != null) {
            DnsOptions.StaleDnsOptions staleDnsOptions = dnsOptions.getStaleDnsOptions();
            if (staleDnsOptions.getAllowCrossNetworkUsage() != null) {
                jSONObjectD2.put("allow_other_network", staleDnsOptions.getAllowCrossNetworkUsage());
            }
            if (staleDnsOptions.getFreshLookupTimeoutMillis() != null) {
                jSONObjectD2.put("delay_ms", staleDnsOptions.getFreshLookupTimeoutMillis());
            }
            if (staleDnsOptions.getUseStaleOnNameNotResolved() != null) {
                jSONObjectD2.put("use_stale_on_name_not_resolved", staleDnsOptions.getUseStaleOnNameNotResolved());
            }
            if (staleDnsOptions.getMaxExpiredDelayMillis() != null) {
                jSONObjectD2.put("max_expired_time_ms", staleDnsOptions.getMaxExpiredDelayMillis());
            }
        }
        JSONObject jSONObjectD3 = d(jSONObject, "QUIC");
        if (dnsOptions.getPreestablishConnectionsToStaleDnsResults() != null) {
            jSONObjectD3.put("race_stale_dns_on_connection", dnsOptions.getPreestablishConnectionsToStaleDnsResults());
        }
    }

    public static /* synthetic */ void g(QuicOptions quicOptions, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectD = d(jSONObject, "QUIC");
        if (!quicOptions.getQuicHostAllowlist().isEmpty()) {
            jSONObjectD.put("host_whitelist", lz.a(",", quicOptions.getQuicHostAllowlist()));
        }
        if (!quicOptions.getEnabledQuicVersions().isEmpty()) {
            jSONObjectD.put("quic_version", lz.a(",", quicOptions.getEnabledQuicVersions()));
        }
        if (!quicOptions.getConnectionOptions().isEmpty()) {
            jSONObjectD.put("connection_options", lz.a(",", quicOptions.getConnectionOptions()));
        }
        if (!quicOptions.getClientConnectionOptions().isEmpty()) {
            jSONObjectD.put("client_connection_options", lz.a(",", quicOptions.getClientConnectionOptions()));
        }
        if (!quicOptions.getExtraQuicheFlags().isEmpty()) {
            jSONObjectD.put("set_quic_flags", lz.a(",", quicOptions.getExtraQuicheFlags()));
        }
        if (quicOptions.getInMemoryServerConfigsCacheSize() != null) {
            jSONObjectD.put("max_server_configs_stored_in_properties", quicOptions.getInMemoryServerConfigsCacheSize());
        }
        if (quicOptions.getHandshakeUserAgent() != null) {
            jSONObjectD.put("user_agent_id", quicOptions.getHandshakeUserAgent());
        }
        if (quicOptions.getRetryWithoutAltSvcOnQuicErrors() != null) {
            jSONObjectD.put("retry_without_alt_svc_on_quic_errors", quicOptions.getRetryWithoutAltSvcOnQuicErrors());
        }
        if (quicOptions.getEnableTlsZeroRtt() != null) {
            jSONObjectD.put("disable_tls_zero_rtt", !quicOptions.getEnableTlsZeroRtt().booleanValue());
        }
        if (quicOptions.getPreCryptoHandshakeIdleTimeoutSeconds() != null) {
            jSONObjectD.put("max_idle_time_before_crypto_handshake_seconds", quicOptions.getPreCryptoHandshakeIdleTimeoutSeconds());
        }
        if (quicOptions.getCryptoHandshakeTimeoutSeconds() != null) {
            jSONObjectD.put("max_time_before_crypto_handshake_seconds", quicOptions.getCryptoHandshakeTimeoutSeconds());
        }
        if (quicOptions.getIdleConnectionTimeoutSeconds() != null) {
            jSONObjectD.put("idle_connection_timeout_seconds", quicOptions.getIdleConnectionTimeoutSeconds());
        }
        if (quicOptions.getRetransmittableOnWireTimeoutMillis() != null) {
            jSONObjectD.put("retransmittable_on_wire_timeout_milliseconds", quicOptions.getRetransmittableOnWireTimeoutMillis());
        }
        if (quicOptions.getCloseSessionsOnIpChange() != null) {
            jSONObjectD.put("close_sessions_on_ip_change", quicOptions.getCloseSessionsOnIpChange());
        }
        if (quicOptions.getGoawaySessionsOnIpChange() != null) {
            jSONObjectD.put("goaway_sessions_on_ip_change", quicOptions.getGoawaySessionsOnIpChange());
        }
        if (quicOptions.getInitialBrokenServicePeriodSeconds() != null) {
            jSONObjectD.put("initial_delay_for_broken_alternative_service_seconds", quicOptions.getInitialBrokenServicePeriodSeconds());
        }
        if (quicOptions.getIncreaseBrokenServicePeriodExponentially() != null) {
            jSONObjectD.put("exponential_backoff_on_initial_delay", quicOptions.getIncreaseBrokenServicePeriodExponentially());
        }
        if (quicOptions.getDelayJobsWithAvailableSpdySession() != null) {
            jSONObjectD.put("delay_main_job_with_available_spdy_session", quicOptions.getDelayJobsWithAvailableSpdySession());
        }
    }

    public static JSONObject h(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e11) {
            throw new IllegalArgumentException("Experimental options parsing failed", e11);
        }
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder addPublicKeyPins(String str, Set<byte[]> set, boolean z11, Date date) {
        this.f73065c.addPublicKeyPins(str, set, z11, date);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder addQuicHint(String str, int i11, int i12) {
        this.f73065c.addQuicHint(str, i11, i12);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ExperimentalCronetEngine build() {
        if (this.f73063a == null && this.f73064b.isEmpty()) {
            return this.f73065c.build();
        }
        if (this.f73063a == null) {
            this.f73063a = new JSONObject();
        }
        Iterator<a> it = this.f73064b.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(this.f73063a);
            } catch (JSONException e11) {
                throw new IllegalStateException("Unable to apply JSON patch!", e11);
            }
        }
        this.f73065c.setExperimentalOptions(this.f73063a.toString());
        return this.f73065c.build();
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableBrotli(boolean z11) {
        this.f73065c.enableBrotli(z11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableHttp2(boolean z11) {
        this.f73065c.enableHttp2(z11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableHttpCache(int i11, long j11) {
        this.f73065c.enableHttpCache(i11, j11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean z11) {
        this.f73065c.enableNetworkQualityEstimator(z11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z11) {
        this.f73065c.enablePublicKeyPinningBypassForLocalTrustAnchors(z11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableQuic(boolean z11) {
        this.f73065c.enableQuic(z11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableSdch(boolean z11) {
        this.f73065c.enableSdch(z11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public String getDefaultUserAgent() {
        return this.f73065c.getDefaultUserAgent();
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public Set<Integer> getSupportedConfigOptions() {
        return f73062d;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setConnectionMigrationOptions(final ConnectionMigrationOptions connectionMigrationOptions) {
        if (this.f73065c.getSupportedConfigOptions().contains(1)) {
            this.f73065c.setConnectionMigrationOptions(connectionMigrationOptions);
            return this;
        }
        this.f73064b.add(new a() { // from class: org.chromium.net.c
            @Override // org.chromium.net.d.a
            public final void a(JSONObject jSONObject) throws JSONException {
                d.e(connectionMigrationOptions, jSONObject);
            }
        });
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setDnsOptions(final DnsOptions dnsOptions) {
        if (this.f73065c.getSupportedConfigOptions().contains(2)) {
            this.f73065c.setDnsOptions(dnsOptions);
            return this;
        }
        this.f73064b.add(new a() { // from class: org.chromium.net.a
            @Override // org.chromium.net.d.a
            public final void a(JSONObject jSONObject) throws JSONException {
                d.f(dnsOptions, jSONObject);
            }
        });
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setExperimentalOptions(String str) {
        if (str == null || str.isEmpty()) {
            this.f73063a = null;
        } else {
            this.f73063a = h(str);
        }
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
        this.f73065c.setLibraryLoader(libraryLoader);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setQuicOptions(final QuicOptions quicOptions) {
        if (this.f73065c.getSupportedConfigOptions().contains(3)) {
            this.f73065c.setQuicOptions(quicOptions);
            return this;
        }
        this.f73064b.add(new a() { // from class: org.chromium.net.b
            @Override // org.chromium.net.d.a
            public final void a(JSONObject jSONObject) throws JSONException {
                d.g(quicOptions, jSONObject);
            }
        });
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setStoragePath(String str) {
        this.f73065c.setStoragePath(str);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setThreadPriority(int i11) {
        this.f73065c.setThreadPriority(i11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setUserAgent(String str) {
        this.f73065c.setUserAgent(str);
        return this;
    }
}
