package inf353;

public class DictionnaireNaif implements Dictionnaire {
    public char[][] dictionnaire;
    public int taille; //taille maximale du teableau 
    public int N;  //nombre de mots

    public DictionnaireNaif(){

        this.dictionnaire = new char[1000][40];
        this.N = 0;
        this.taille = 1000;
        for (int i = 0 ; i < 1000 ; i++){
            this.dictionnaire[i][0] = '0';
        }
    }
    
    //n est la taille maximal du dictionnaire
    public DictionnaireNaif(int n){

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
        for (int i = 0 ; i < N; i++) {
            for(int j = 0 ; j < taille ; j++) {
                this.dictionnaire[i][j] = '0';
            }
        }

        N=0; //Définir le nombre de mots du dictionnaire sur 0
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
/*
        while (i < N) {

            i=i+1;
            String elementCourant = new String(dictionnaire[i]);
            if (elementCourant.equals(m)) {
                return i;
            }
        }
        return -1 ;   
        */              
    };
    @Override 
    public String motIndice(int i){

        if (i < N){
            
            String mot = "";
            int j=0;   
            
            while (this.dictionnaire[i][j]!= '0' ){
                mot += this.dictionnaire[i][j];
                j++;
            }
            return mot;
        }
        else {

            return "erreur : l'indice dépasse la taille";
        } 
        
    }
    @Override 
    public boolean contient(String m){
        int i = 0;
        while ( i < N) {

            i=i+1;
            String elementCourant = new String(dictionnaire[i]);
            if (elementCourant.equals(m)) {
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
        if (p == null || p.isEmpty()) {
            return false;
        }

        for (int i = 0; i < dictionnaire.length; i++) {
            if (dictionnaire[i][0] != '0' && new String(dictionnaire[i]).startsWith(p)) {
                return true;
            }
        }

        return false;
    };
    @Override 
    public String plusLongPrefixeDe(String mot){
       
        /* 
            fonction returns the bigest prefix of all words in the dictionary 
            
            Parameters:
            -----------
            mot : word that have the biggest prefix (Str)

            Returns:
            --------
            prefixe : the biggest prefix in dictionary (Str)

            Versions:
            ----------
            specefication : Ahmed Adel BEREKSI REGUIG V-1.0 (12/11/2023)
            implementation : Ahmed Adel BEREKSI REGUIG  V-1.0 (12/11/2023)

        */


        String prefixe = "";
        
        //parcourir toutes les lignes (chaque ligne représente un mot)
        for (int line = 0 ; line < this.taille ; line++) {

            String mot_temporaire = "";

            //lire le mot de cette ligne
            for (int column = 0 ; column < 40 ; column++){

                //si on trouve la marque de fin du mot
                if ( this.dictionnaire[line][column] == '0' ){
                    break;
                }
                //sinon on fait la concaténation de ce caractère avec la variable mot_temporaire
                else {
                    mot_temporaire += this.dictionnaire[line][column];
                }
            }

            //si le mot_temporaire contient le mot (donc il existe un préfixe)
            if (mot_temporaire.contains(mot)) {

                String prefixe_temporaire = "";

                //extraire le préfixe temporaire 
                prefixe_temporaire = mot_temporaire.substring(0, mot_temporaire.indexOf(mot) -1);

                //affecter le préfixe le plus grand à la variable prefixe
                if (prefixe_temporaire.length() >= prefixe.length()) {

                    prefixe = prefixe_temporaire;
                }
            }


        }

        return prefixe;
    };



}