package inf353;

public class DictionnaireNaif implements Dictionnaire {
    private char[][] dictionnaire;
    private int taille; //taille maximale du teableau 
    private int N;  //nombre de mots

    public DictionnaireNaif(){

        /* 
            constructeur qui défine le nombre maximal à 1000 (par défaut) si  l'utilisateur l'entre pas
            et initialise les attributs de la classe

            Versions:
            ----------
            spécification : Ahmed Adel BEREKSI REGUIG V-1.0 (09/11/2023)
            implémentation : Ahmed Adel BEREKSI REGUIG  V-1.0 (09/11/2023)

        */

        this.dictionnaire = new char[1000][40];
        this.N = 0;
        this.taille = 1000;

        for (int i = 0 ; i < 1000 ; i++){

            this.dictionnaire[i][0] = '0';
        }
    }
    
    public DictionnaireNaif(int n){

        /* 
            constructeur qui défine le nombre maximal à n (définé par l'utilisateur de la classe)
            et initialise les attributs de la classe
            
            Parametères:
            -----------
            n : le nombre maximal des mot de notre dictionnaire 'this.taille' (Int)

            Versions:
            ----------
            spécification : Ahmed Adel BEREKSI REGUIG V-1.0 (09/11/2023)
            implémentation : Ahmed Adel BEREKSI REGUIG  V-1.0 (09/11/2023)

        */

        this.dictionnaire = new char[n][40];
        this.N = 0;
        this.taille = n;

        for (int i = 0 ; i < n ; i++){

            this.dictionnaire[i][0] = '0';
        }
    }


    @Override 
    public void vider(){

        // Définir tout le contenu du dictionnaire par défaut
        for (int i = 0 ; i < this.taille; i++) {
            for(int j = 0 ; j < 40 ; j++) {
                this.dictionnaire[i][j] = '0';
            }
        }

        this.N=0; //Définir le nombre de mots du dictionnaire sur 0
    };


    @Override 
    public void ajouterMot(String m){

        boolean motExiste = false;
        if (m.length() > 40) {
            System.out.println("error: Le mot est trop long (plus de 40 caractères).");
        }
        else {

            // Parcourir le tableau de mots
            for (int i = 0; i < this.taille; i++) {
                
                String mot = "";
                for (int index = 0 ; index < 40 ; index++) {
                    
                    if (this.dictionnaire[i][index] != '0') {
                        mot += this.dictionnaire[i][index];
                    }
                    else {
                        break;
                    }
                }
                
                if (dictionnaire[i][0] != '0' && mot.equals(m)) {
                    
                    motExiste = true;
                    break;
                }
            }
            
            // Si le mot n'existe pas et que le tableau n'est pas plein, l'ajouter au premier emplacement libre
            if (! motExiste && this.N < this.taille && m.length() <= 40) {
                
                for (int i = 0; i < this.taille ; i++) {
                    
                    int j = 0;
                    while (j < m.length()){
                        
                        this.dictionnaire[i][j] =  m.charAt(j);     
                    }
                    this.dictionnaire[i][j+1] = 0;
                    this.N++;
                    break;
                }
                
            } else {
                
                System.out.println("Le mot existe déjà ou le dictionnaire est plein.");
            }
        }
    };


    @Override 
    public int indiceMot(String m){

        int i = 0;

        for (int line = 0 ; line < this.taille ; line ++) {

            String mot = "";
            for (int column = 0 ; column < 40 ; column++){

                mot += this.dictionnaire[line][column];
            }

            if (mot == m) {
                return line;
            }
        }

        return -1;
           
    };


    @Override 
    public String motIndice(int i){
        /* 
            fonction retourne le mot de l'indice 'i' dans notre dictionnaire
            
            Parametères:
            -----------
            i : l'indice du mot (Int)

            Retournes:
            --------
            mot : le mot de  l'indice 'i' (Str)

            Versions:
            ----------
            spécification : Ahmed Adel BEREKSI REGUIG V-1.0 (09/11/2023)
            implémentation : Ahmed Adel BEREKSI REGUIG  V-1.0 (09/11/2023)
            implémentation : Ahmed Adel BEREKSI REGUIG  V-1.1 (14/11/2023)

        */


        //si le i ne dépasse pas la taille maximal du dictionnaire et aussi le premier élément dans la ligne 'i' n'est pas '0'
        if (i < this.taille && this.dictionnaire[i][0]!= '0'){
            
            //initialisation de la variable 'mot' par le mot vide
            String mot = "";
            int j=0;   
            
            // tant que (la case précédente est '\' et la case courante est '0') ou bien (la case courante est déffirente de '0') alors entrer dans la boucle
            while ( (j != 0 && ( this.dictionnaire[i][j-1] == '\\' && this.dictionnaire[i][j] == '0') ) || (this.dictionnaire[i][j]!= '0') ){
               
                //construire le mot de cette ligne dans le variable 'mot'
                mot += this.dictionnaire[i][j];
                j++;
            }

            return mot;
        }
        else {

            if ( i < this.taille && this.dictionnaire[i][0]== '0') {

                return "";
            }
            else {

                return "erreur : l'indice dépasse la taille";
            }
        } 
        
    }


    @Override 
    public boolean contient(String m){
        
        //parcourir les lignes (tous les mots)
        for( int line = 0 ; line < this.taille ; line++){

            String mot = motIndice(line);
            if (mot == m) {

                return true;
            }
        
        }
        return false;
    };

    @Override 
    public int nbMots(){
        
        return this.N;
    };
    @Override 
    public boolean contientPrefixe(String p){

        //parcourir les lignes (tous les mots)
        for( int line = 0 ; line < this.taille ; line++){

            String mot = motIndice(line);
            if (mot.startsWith(p)) {

                return true;
            }
        
        }
        return false;
        
    };
    @Override 
    public String plusLongPrefixeDe(String mot){
       
        /* 
            fonction retourne le plus grand préfixe dans notre dictionnaire 
            et qui est au même temp un mot dans le dictionnaire.
            
            Parametères:
            -----------
            mot : le mot cherché qui contient le préfixe (Str)

            Retournes:
            --------
            prefixe : le plus grand préfixe du dictionnaire (Str)

            Versions:
            ----------
            spécification : Ahmed Adel BEREKSI REGUIG V-1.0 (12/11/2023)
            implémentation : Ahmed Adel BEREKSI REGUIG  V-1.0 (12/11/2023)
            implémentation : Ahmed Adel BEREKSI REGUIG  V-1.1 (14/11/2023)

        */

        

        String prefixe = mot;

        //variant :    préfixe courant = ancient préfixe sauf le dernier caractère    et é.i: ancient préfixe = mot
        while (prefixe != "") {

            //parcourire tous les mot du dictionnaire 
            for (int line = 0 ; line < this.taille ; line++) {

                //extrraire le mot de cette ligne
                String mot_tmp = motIndice(line);

                //si ce mot == préfixe donc c'est le plus grand préfixe
                if (mot_tmp == prefixe){

                    return prefixe;
                }
            }

            //préfixe courant = ancient préfixe sauf le dernier caractère 
            prefixe = prefixe.substring(0,prefixe.length() - 1);

        }

        //le plus grand préfixe est le mot vide "" donc il n'existe pas
        return prefixe;
    };



}