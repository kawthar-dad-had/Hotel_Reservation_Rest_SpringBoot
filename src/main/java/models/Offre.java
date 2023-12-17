package models;

public class Offre {
    private int id;

    private int nombreLits;
    private String typeChambre;
    private double prix ;
    private Hotel hotel;
    private String imageUrl;

    public Offre(int id , String typeChambre , int nombreLits , double prix , String imageUrl , String nom , int nombreEtoiles) {
        this.setId(id);
        this.setTypeChambre(typeChambre);
        this.setNombreLits(nombreLits);
        this.setPrix(prix);
        this.setImageUrl(imageUrl);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTypeChambre() {
        return typeChambre;
    }
    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }
    public int getNombreLits() {
        return nombreLits;
    }
    public void setNombreLits(int nombreLits) {
        this.nombreLits = nombreLits;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
