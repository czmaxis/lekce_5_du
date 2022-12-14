import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;




    public Plant (String name,String notes,LocalDate planted,LocalDate watering,int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
//        this.watering = watering;
        setWatering(watering);
//        this.frequencyOfWatering = frequencyOfWatering;
        setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant (String name, LocalDate planted,int frequencyOfWatering){
        this.name = name;
        this.notes = "  ";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;
    }
    public Plant (String name){
        this.name = name;
        this.notes = "  ";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
    }

    public static Plant parsePlant(String data)throws PlantException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

        String[] items = null;
        String name = items[0];
        String notes = items[1];
        LocalDate planted = LocalDate.parse(items[5]);
        LocalDate watering = LocalDate.parse(items[4]);
        int frequencyOfWatering = Integer.parseInt(items[3]);


        Plant result = new Plant (name, notes, planted, watering, frequencyOfWatering);
        return result;

    }



    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering)throws PlantException {
        if (watering.isBefore(planted)){
            throw new PlantException("Datum posledn?? z??livky je p??ed zasazen??m rostliny ");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering)throws PlantException {
        if (frequencyOfWatering <= 0) {

            throw new PlantException("frekvence zal??v??n?? mus?? b??t v??t???? jak 0 dn??. " + frequencyOfWatering);
        }
        else {
            this.frequencyOfWatering = frequencyOfWatering;
        }
    }
    public String getWateringInfo(){
//        this.name = name;
//        this.watering = watering;
//        this.frequencyOfWatering  = frequencyOfWatering;

        return getName() + " Datum poslend?? z??livky: " + getWatering() + " Frekvence z??livky: " + getFrequencyOfWatering();
    }




}
