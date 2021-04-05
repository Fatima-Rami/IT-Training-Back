# Projet fil rouge réalisé en formation JAVA-JEE avec IB Lille, Janvier-Mars 2021

## Description du projet

### contexte

Lors de notre formation "Java-JEE" au sein de l'organisme IB à Lille, nous avons eu l'opportunité de développer une application web dans le contexte suivant:  

"Un organisme de formation, "IT-Training", souhaite refaire entièrement son système d’information ainsi que son portail web. A cet effet, IT-Training a établi une version préliminaire du cahier des charges (CDC). Il est important de noter que ce dernier pourra tout à fait être modifié et étendu tout le long du cycle de développement et de livraison du SI ainsi que du portail web. Le délai fixé par le client est de quatre mois maximum à partir de la soumission du CDC."
  
Le projet est basé sur le développement d'une application web full-stack, en Java avec Spring web et mySQL pour la base de données pour le back-end, et node.js/angular pour la partie front-end.

### Objectifs du projet

1. Mesurer le niveau de maîtrise du développement
2. Définir l’architecture technique cible (base de données, logique de navigation, recensement
des écrans, …)
3. Mettre en pratique les connaissances acquises au travers d’un projet
4. Développer ses compétences de développeur

## Outils requis

- PC sous environnement windows avec la JDK11 ou la JRE.
- IDE java eclipse/Spring tool suit avec le framework Spring et le module JPA.
- Logiciel de gestion de base de données mySQL workbench
- Logiciel Git
- Environnement de développement Visual Studio code avec Node.js
- Navigateur web (nous conseillons Google Chrome)

## Installation du projet

1. Récupérer le projet sur github, pour cela ouvrir un invité de commande et executer la ligne : "git clone <https://github.com/tamedi/it-training-front.git>" pour la partie front-end, et "git clone <https://github.com/Fatima-Rami/it-training-back.git>" pour la partie back-end.

2. Executer MySQL workbench et configurer une nouvelle connexion sur le port localhost://3306, nom: root, password: root. Créer un nouveau schéma "projet". Laisser le programme ouvert.

3. Ouvrir Spring tool suit, importer le projet du dossier "it-training-back" (utilisera sur le port 9191 pour communiquer avec Angular), et lancer le projet en tant que Spring boot app.

4. Ourvir Visul Studio code dans le dossier it-training-front, ouvrir un invité de commande dans le même dossier et exécuter "npm i" afin d'installer toutes les dépendances. Exécuter ensuite le projet avec la commande "ng serve -o", vous serez rediriger automatiquement vers la page d'accueil du projet dans le navigateur web (sinon, rendez-vous à l'adresse localhost:4200). Le projet a été testé avec Google Chrome.

## Utilisation du projet

Le site web est divisé en plusieurs sections :

- Partie utilisateur :

L'utilisateur peut afficher la liste des formations, consulter une formation spécifique avec la liste des sessions associées.
Il peut aussi consulter la localisation des centres, ainsi qu'accéder à un formulaire de contact du groupe IT-training. Un utilisateur pourra s'enregistrer en ligne en tant qu'apprenant afin de s'inscrire à une session de formation.

- Partie administrateur :

Un administrateur peut accéder à la page de connexion pour accéder au dashboard administrateur avec ses éléments de login (email: admin@admin.com, password: 1234). Une fois authentifié, il peut ajouter, consulter, supprimer des formations, sessions ou comptes administrateurs. Ces éléments se mettent à jour en temps réel dans la base de données.

## Collaborateurs ayant participé

- Fatima Rami (<https://github.com/Fatima-Rami>)
- Ilias Tamedi (<https://github.com/tamedi>)
- Julien Prod'homme (<https://github.com/juprodho>)  
  
Au nom de l'équipe, nous vous remercions pour l'intérêt que vous porterez à ce projet .
