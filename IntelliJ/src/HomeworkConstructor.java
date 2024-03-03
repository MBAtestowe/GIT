public class HomeworkConstructor {
    public String marka;
    public String model;
    public int dataprodukcji;
    public int przebieg;

    public HomeworkConstructor (String marka,String model, int dataprodukcji, int przebieg ){
        this.marka = marka;
        this.model = model;
        this.dataprodukcji = dataprodukcji;
        this.przebieg = przebieg;
    }
    public void jedz (){
        System.out.println("Ruszam.");
    }
    public void hamuj (){
        System.out.println("Hamuję.");
    }
    public void info (){
        System.out.println("Marka to: " + marka + ", Model to: "+ model +
                ", Data produkcji to: " + dataprodukcji + ", Przebieg to:" +przebieg);
    }
}
