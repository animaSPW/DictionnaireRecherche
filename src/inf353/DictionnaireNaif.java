package inf353;

public class DictionnaireNaif implements Dictionnaire {
    public char[][] dictionnaire;
    public int taille; //taille maximale du mot
    public int N;  //nombre de mots

    DictionnaireNaif(){

        this.dictionnaire = new char[1000][40];
        this.N = 0;
        this.taille = 0;
        for (int i = 0 ; i < 100 ; i++){
            this.dictionnaire[i][0] = '0';
        }
    }
    
    //n est la taille maximal du dictionnaire
    DictionnaireNaif(int n){

        this.dictionnaire = new char[n][40];
        this.N = 0;
        this.taille = 0;
        for (int i = 0 ; i < n ; i++){
            this.dictionnaire[i][0] = '0';
        }
    }

    @Override 
    public void vider(){
        //content
    };
    @Override 
    public void ajouterMot(String m){};

    @Override 
    public int indiceMot(String m){
        //content
        return 0;
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
        //content
        return true;
    };
    @Override 
    public int nbMots(){
        //content
        return 0;
    };
    @Override 
    public boolean contientPrefixe(String p){
        //content
        return true;
    };
    @Override 
    public String plusLongPrefixeDe(String mot){
        //content
        return "";
    };
}