# MovieBox v3.0.16 — code source et audit

> Dépôt **privé**, usage d'audit personnel. Code propriétaire du groupe Transsion (studio Nox) — peut etre diffusé a qui a accès au sepot .

## Identité de l'application

| Champ | Valeur |
|---|---|
| Fichier source | `moviebox-v-3.0.16.0708.03.apk` |
| Package | `com.community.oneroom` |
| Version | 3.0.16.0708.03 |
| Taille APK | 65 916 806 octets (~63 Mo) |
| SHA-256 APK | `fa2acf749122de64ea491452a247f9444b86a0cf05deafe7836bd25b0a1f2101` |
| Signature | `META-INF/ONEROOM.RSA` (PalmPlay / Transsion) |

Inventaire certifié REA (reverse-engineer-anything) : **5 831 fichiers**, inventaire complet, **0 contradiction d'intégrité** (Evidence REA `ev_d3222dae…1854b`, graphe `agm_2f89a4f1…16133ad3`, 5 418 nœuds).

## ⚠️ Découverte principale : l'application est désormais protégée par le packer Ijiami

La version 3.0.15 (audit de septembre 2026) (42 206 fichiers Java obtenus avec jadx). **La 3.0.16 ne l'est plus** : le vrai code applicatif est chiffré.

Fait établi par l'analyse :

1. Le fichier `classes.dex` (61,5 Mo) ne contient en réalité qu'un **stub DEX valide de ~26 Ko avec 4 classes** (`gj.hfr.xal.*`) : un chargeur qui détourne `AppComponentFactory` et `Application`.
2. Derrière ce stub, au-delà de l'octet 26 936, se trouve un **payload chiffré de 61,4 Mo** : un bloc `ijiami.dat` (packer commercial **Ijiami**, 爱加密), contenant le vrai DEX de l'application.
3. Les bibliothèques natives du packer sont cachées dans `assets/MSDvUDPFc/<abi>/` sous des noms aléatoires : `libxybzvgn.so` (748 Ko), `libukdb5pgj.so` (215 Ko), `librpgi1i.so` (6 Ko). Le déchiffrement du payload s'effectue dans ces librairies (méthodes natives `b2b`, `al`, et `com.ijm.dataencryption.DETool.loadDEso`).
4. La classe `Application` réelle de l'app — masquée par le stub — est `com.transsion.subroom.app.SubRoomApp`.

Détails techniques complets : voir [`AUDIT/analyse-packer-ijiami.md`](AUDIT/analyse-packer-ijiami.md).

## Contenu du dépôt

| Dossier | Contenu |
|---|---|
| `sources/` | Code Java décompilé (jadx 1.5.6) — les 6 seules classes visibles : le chargeur Ijiami + `R.java` |
| `resources/` | Toutes les ressources décodées de l'APK (6 236 fichiers) : `AndroidManifest.xml` lisible, XML, assets, libs natives |
| `AUDIT/` | Analyse du packer Ijiami + les 3 librairies natives du packer extraites |
| `outils/` | Scripts Node réutilisables (déchiffreur de chaînes du stub, scans du payload) |

**Ce qui manque et pourquoi** : les ~42 000 classes Java de l'application. Elles sont dans le payload `ijiami.dat` chiffré par les librairies natives du packer. Les tentatives de cassage statique menées (XOR à clé courte, algorithme maison du stub réappliqué au payload) sont documentées et négatives ; la suite nécessite l'analyse de `libxybzvgn.so` (ARM64) ou un dump mémoire à l'exécution.

## Version épurée — sans publicité (25 octobre 2026)

Le dépôt a été **épuré de toute trace publicitaire** par **calvinbeaubrum-oss** (voir `SIGNATURE.md`) :
**455 fichiers supprimés** (ressources Mintegral/Pangle/Hisavana/SSP, libs natives Pangle, OMID, config AdMob), **59 blocs du manifeste** (composants des SDK pub + permissions `AD_ID`/`ADSERVICES` : 57 → 54 permissions) et **~1 050 entrées `res/values/`**. Liste exhaustive et conservations volontaires dans [`AUDIT/NETTOYAGE.md`](AUDIT/NETTOYAGE.md).

**Limite** : le code Java des SDK publicitaires est dans le DEX chiffré par Ijiami — il n'a jamais été présent dans cet arbre. Cette épuration rend la consultation du dépôt propre ; elle ne constitue pas une application utilisable sans pub. L'état d'origine est conservé dans l'historique git (commit `e9d292c`).

## Permissions : 57 en 3.0.16 (44 en 3.0.15)

L'app a **ajouté 13 permissions** entre les deux versions. Les plus problématiques, toujours présentes :

- `REQUEST_INSTALL_PACKAGES` — peut installer d'autres APK (pubs « téléchargez cette app »)
- `SYSTEM_ALERT_WINDOW` — pubs flottantes par-dessus toutes les applications
- `USE_FULL_SCREEN_INTENT` — pubs plein écran même écran verrouillé
- `READ_CALENDAR` + `WRITE_CALENDAR` — calendrier lu ET écrit, sans rapport avec la vidéo
- `RECORD_AUDIO`, `CAMERA`, `ACCESS_FINE_LOCATION` (via Wi-Fi scanning)
- `READ_MEDIA_IMAGES/AUDIO/VIDEO` — scan de toute la médiathèque
- `GET_ACCOUNTS` / `AUTHENTICATE_ACCOUNTS`, `WRITE_SETTINGS`
- `RECEIVE_BOOT_COMPLETED` + `WAKE_LOCK` + `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` — démarrage auto, arrière-plan permanent
- `usesCleartextTraffic="true"` — trafic HTTP non chiffré autorisé (seul bon point : `allowBackup="false"`)

Nouveautés 3.0.16 notables : `POST_NOTIFICATIONS`, `FOREGROUND_SERVICE_MEDIA_PLAYBACK`, `MANAGE_WIFI_NETWORK_SELECTION`, `NEARBY_WIFI_DEVICES`, `READ_MEDIA_VISUAL_USER_SELECTED`.

L'app embarque toujours 6 réseaux publicitaires (AdMob, Pangle, Mintegral, Hisavana, EagllWin/TMC, Meta Bidding) et la télémétrie APMInsight/Crashlytics — voir les librairies dans `resources/lib/` et l'audit 3.0.15 pour les domaines à bloquer.

## Reproduire l'analyse

```bash
# Inventaire certifié (REA MCP) : open_binary sur l'APK puis inspect_artifact
# Décompilation des parties visibles
jadx -d sortie moviebox-v-3.0.16.0708.03.apk
# Déchiffrement des chaînes du chargeur Ijiami
node outils/decrypt-strings.js
# Scan du payload chiffré (magic DEX, entropie)
node outils/scan-dex.js classes.dex
```

Audit précédent (3.0.15, non packée) : voir le document d'audit local de septembre 2026. Les recommandations de blocage DNS/pare-feu (AdGuard DNS + RethinkDNS) restent valables telles quelles.
