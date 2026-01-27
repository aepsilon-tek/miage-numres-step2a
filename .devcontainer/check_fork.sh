#!/bin/bash

# Récupère l'URL du dépôt distant
REMOTE_URL=$(git config --get remote.origin.url)

# Vérifie si le dépôt appartient encore au prof (vous)
if [[ $REMOTE_URL == *"aepsilon-tek"* ]]; then
  echo -e "\n\033[0;31m━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
  echo -e "⚠️  ATTENTION : TU N'AS PAS FORKÉ LE PROJET !"
  echo -e "Tu travailles actuellement sur le dépôt du professeur."
  echo -e "Tu ne pourras pas 'pusher' tes modifications."
  echo -e "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\033[0m\n"
  echo -e "Pour corriger cela :"
  echo -e "1. Fork le projet sur GitHub."
  echo -e "2. Relance un Codespace depuis TON fork.\n"
else
  echo -e "\n\033[0;32m✅ Environnement prêt. Tu travailles sur ton propre fork.\033[0m\n"
fi