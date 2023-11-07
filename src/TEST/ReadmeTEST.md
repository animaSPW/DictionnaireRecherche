En premier lieu , on a pris un moment de réflexion , ou on a essayer de Brainstorm les differents cas de Test pour les méthodes qui vont etre realiser aujourd'hui ,on a pu conclure ceci : 

methode vider : ei : this.dictionnaire remplie
                ef: this.dictionnaire vide

                ei : this.dictionnaire vide
                ef : this.dictionnaire vide ( sans erreurs)



methode ajouterMot : EI : dictionnaire quit ne contient pas m
                     EF : dictionnaire a m comme dernier élement.

                     EI : dictionnaire contient deja M
                     EF : retourne dictionnaire sans changement

                     EI: dictionnaire avec mot nul ou >40 Char
                     EF : dictionnaire sans changement

                     Ei: dictionnaire avec N mots ( nombre maximale de mots)
                     EF : dictionnaire sans changements
        

methode indiceMot: Ei : dictionnaire avec mot a l'indice i
                   EF : pas de changements , on retourne I

                   EI: dictionnaire avec m n'existe pas dans ce dernier
                   EF : sans changements, on retourne " mot non existant"

                   EI : dictionnaire avec mot null ou > 40 CHAR
                   EF: renvoie erreur mot non conforme


methode motIndice: Ei : dictionnaire avec indice du mot i
                   EF : pas de changements , on retourne le mot

                   EI: dictionnaire avec la case d'indice est vide 
                   EF : sans changements, on retourne " mot non existant"
                   
                   EI : dictionnaire avec l'indice > N ou <0
                   EF: renvoie erreur indice corrompu
                   