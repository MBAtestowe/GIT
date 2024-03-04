public class AppChecker {
/*  Stwórz klasę bazową App - zawiera pole name i metodę appInfo,
    dodaj konstruktor do którego przekażesz wartość name
    Stwórz klasy potomne AndroidApp i IphoneApp - zawierają odpowiednio
    metody runAndroidApp i runIphoneApp*/
public static void main(String[] args) {
    AndroidApp android = new AndroidApp("Android", "1.23a");
    android.runAndroidApp();
    android.appInfo();

    IphoneApp iphone = new IphoneApp("Iphone", "3.33b");
    iphone.runIphoneApp();
    iphone.appInfo();
}
}
