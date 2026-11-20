# MANIFEST.md — Archive de recherche MovieBox 3.0.05

> **Copie de recherche privée — propriété Transsion.** Usage d'audit personnel
> uniquement ; ne pas redistribuer. Aucune modification du code décompilé,
> aucun rebuild, aucun patch.

| Champ | Valeur |
|---|---|
| Application | MovieBox (com.community.oneroom) |
| Version | **3.0.05.0711.03** (versionCode 50020052) |
| APK source | `C:\Work\moviebox-v3.1.apk` (65 598 677 octets) |
| SHA-256 APK | `d8dcbe2708b82e44729cd17d2e0439b0a79b9cde19797d830c646048b0650739` |
| Date d'assemblage | 2026-11-15 |
| Outil de décompilation | **JADX 1.5.6** (`jadx --no-debug-info --show-bad-code`) |
| Périmètre | sources/ : décompilation brute complète (38 995 fichiers Java, 31 731 classes, 17 007 erreurs partielles JADX) ; refactored/ : 8 fichiers prioritaires annotés (gateway/réseau/auth/crypto/Application) ; reports/ : analyses |
| Provenance APK | historique git de `solo12345689/moviebox-internal-api`, commit `9ff0f816` (source de contexte uniquement) |

## Contenu

| Dossier | Contenu |
|---|---|
| `sources/` | Décompilation JADX brute et inchangée de l'APK v3.0.05 non packée |
| `refactored/` | 8 fichiers clés (gateway/signature/auth/réseau/Application) annotés sémantiquement — logique inchangée |
| `reports/` | `ANALYSIS_REPORT.md` (audit v3.0.05), `NATIVE_ANALYSIS.md` (packer Ijiami/SM4 — concerne la 3.0.16), `glossary.json` (protocole + renommages), `security_findings.txt` (scan redacté) |

## Binaires exclus du dépôt (`.gitignore`)

`*.apk`, `*.so`, `*.dex`, `*.zip` restent hors git. Empreintes des binaires de référence :

| Binaire | SHA-256 |
|---|---|
| moviebox-v3.1.apk (v3.0.05.0711.03) | `d8dcbe2708b82e44729cd17d2e0439b0a79b9cde19797d830c646048b0650739` |
| (aucun .so/.dex séparé dans cette archive — ils restent dans l'APK) | — |

## Notes de sécurité

- `security_findings.txt` est **redacté** (4 premiers caractères uniquement).
- Les **sources décompilées contiennent les secrets intégrés à l'APK** (clés gateway
  HMAC-MD5, clés AIza Google) : c'est la décompilation brute d'un binaire distribué à
  ~300 M d'exemplaires ; ces valeurs sont déjà publiques (extraites de l'APK par quiconque,
  et publiées dans la documentation du dépôt de référence). Elles sont citées ici pour
  transparence ; les rapports, le MANIFEST et les messages de commit ne les reprennent pas.
- `session_mbox.json` (identifiants de l'auteur du dépôt de référence) : **jamais lu,
  jamais copié** dans cette archive.
- Dépôt GitHub cible : **strictement privé**, sans collaborateur ni fork.
