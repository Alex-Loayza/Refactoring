package refactoring;

import java.util.ArrayList;

public class Client {

    private String nif;
    private String nom;
    private String telefon;
    private ArrayList<Lloguer> lloguers;
    // String informe;

    public Client(String nif, String nom, String telefon,
            ArrayList<Lloguer> lloguers) {

        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = lloguers;
    }

    public String getNif() {
        return nif;
    }

    public String getNom() {
        return nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void afegeix(Lloguer lloguer) {
        if (!lloguers.contains(lloguer)) {
            lloguers.add(lloguer);
        }
    }

    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer)) {
            lloguers.remove(lloguer);
        }
    }

    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public ArrayList<Lloguer> getLloguers() {
        return lloguers;
    }

    public int totalLloguers(Client c) {
        int num = c.getLloguers().size();
        return num;
    }

    public String informe() {
        return composaCapsalera()
                + composaDetall()
                + composaPreu();
    }

    public String informeHTML() {
        return composaCapsaleraHTML()
                + composaDetallHTML()
                + composaPreuHTML();
    }

    public String composaCapsaleraHTML() {

        String resultat = "<h1> Informe de lloguers </h1>\n"
                + "<p> Informe de lloguers del client <em> " + getNom() + "</em> ( <strong>" + getNif() + "</strong> ) </p>\n";
        return resultat;
    }

    public String composaDetallHTML() {
        String resultat = "<table>\n"
                + "<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>\n";
        for (Lloguer lloguer : lloguers) {
            resultat += "\t<tr><td>" + lloguer.getVehicle().getMarca() + "</td><td>" + lloguer.getVehicle().getMarca() + "</td><td>" + (lloguer.quantitat() * 30) + "</td></tr>\n";
        }
        resultat += "</table>\n";
        return resultat;
    }

    public String composaPreuHTML() {
        String resultat = "<p>Import a pagar: <em>" + importTotal() + "</em></p>\n";
        resultat += "<p> Punts guanyats: <em>" + bonificacionsTotals() + "</em></p>\n";
        return resultat;
    }

    public double importTotal() {
        double total = 0;
        for (Lloguer lloguer : lloguers) {
            double preu = lloguer.quantitat();
            total += preu * 30;
        }
        return total;
    }

    public int bonificacionsTotals() {
        int bonificacions = 0;
        for (Lloguer lloguer : lloguers) {
            bonificacions += lloguer.bonificacions();
        }
        return bonificacions;
    }

    public String composaCapsalera() {
        String resultat = "Informe de lloguers del client "
                + getNom()
                + " (" + getNif() + ")\n";
        return resultat;
    }

    public String composaDetall() {
        int bonificacions = 0;
        String resultat = "";
        for (Lloguer lloguer : lloguers) {
            bonificacions += lloguer.bonificacions();
            resultat += "\t"
                    + lloguer.getVehicle().getMarca()
                    + " "
                    + lloguer.getVehicle().getModel() + ": "
                    + (lloguer.quantitat() * 30) + "€" + "\n";
        }

        return resultat;
    }

    public String composaPreu() {
        String resultat;
        resultat = "Import a pagar: " + importTotal() + "€\n"
                + "Punts guanyats: " + bonificacionsTotals() + "\n";
        return resultat;
    }
}
