#!/usr/bin/env node
// Vérification one-shot du catalogue : JSON valide, identifiants uniques,
// URLs HTTPS sur des hôtes autorisés (aucune adresse locale/réservée), fichiers présents.
const fs = require('fs');
const path = require('path');
const { URL } = require('url');

const ALLOWED_HOSTS = ['archive.org'];
const cat = JSON.parse(
  fs.readFileSync(path.join(__dirname, '..', 'app', 'src', 'main', 'assets', 'catalog.json'), 'utf8')
);

let errors = [];
const seen = new Set();
let files = 0;

for (const item of cat.items) {
  if (!item.id || seen.has(item.id)) errors.push('id dupliqué ou vide: ' + item.id);
  seen.add(item.id);
  if (!item.title) errors.push('titre manquant: ' + item.id);
  if (!Array.isArray(item.files) || item.files.length === 0) errors.push('aucun fichier: ' + item.id);
  for (const f of item.files || []) {
    files++;
    let u;
    try { u = new URL(f.url); } catch { errors.push('URL invalide (' + item.id + '): ' + f.url); continue; }
    if (u.protocol !== 'https:') errors.push('URL non-HTTPS (' + item.id + '): ' + f.url);
    if (!ALLOWED_HOSTS.includes(u.hostname)) errors.push('hôte non autorisé (' + item.id + '): ' + u.hostname);
    if (/^(localhost|127\.|10\.|192\.168\.|169\.254\.|0\.|\[::1\])/.test(u.hostname)) errors.push('hôte local interdit: ' + u.hostname);
  }
  if (item.poster) {
    try {
      const p = new URL(item.poster);
      if (p.protocol !== 'https:' || !ALLOWED_HOSTS.includes(p.hostname)) errors.push('poster non autorisé (' + item.id + '): ' + item.poster);
    } catch { errors.push('poster URL invalide (' + item.id + ')'); }
  }
}

console.log('Films:', cat.items.length, '| Fichiers vidéo:', files);
if (errors.length) { console.error('ÉCHEC:\n' + errors.join('\n')); process.exit(1); }
console.log('OK — catalogue valide, toutes les URLs HTTPS sur hôtes autorisés.');
