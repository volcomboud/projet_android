package com.example.tp_final_fb;

public class Database {

    Guichet banque=new Guichet();

    Compte c_admin=new Cheque(1,0,0);

    Cheque chk_lena=new Cheque(1,100000,75);
    Cheque chk_boud=new Cheque(1,200,20);
    Cheque chk_ced=new Cheque(1,13000,34);

    Epargne ep_lena=new Epargne(1,500450,75);


    Client admin=new Client("Pierre-Karl","Pédal'eau","admin",true,c_admin);
    Client boud= new Client("Francis","Boud","volcomboud",false,chk_boud);
    Client lena= new Client("Lena","Aufschneider","petitepatate",false, chk_lena, ep_lena);
    Client ced= new Client("Cedrik","Raymond","raymoon",false,chk_ced);

    Database(){

        innitialisationDatabase();
    }

    private void innitialisationDatabase(){
        this.banque.ajouterClient(boud);
        this.banque.ajouterClient(lena);
        this.banque.ajouterClient(ced);
        this.banque.ajouterClient(admin);

        this.banque.ajouterCheque(chk_boud);
        this.banque.ajouterCheque(chk_ced);
        this.banque.ajouterCheque(chk_lena);
        this.banque.ajouterEpargne(ep_lena);

    }
}
