public class Introduction {
    public static void main(String[] args) {
        System.out.println("Nguyen Xuan Loc" + "\t" + "24020204" + "\t" + "K69I-IT6" + "\t" + "24020204nxl" + "\t" + "24020204@vnu.edu.vn" + "\n");
        for (int i = 9; i >= 0; i--) {
            if(i == 0) {
                System.out.println("No more bottles of beer on the wall.");
                break;
            }
            System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer." + "\n");
            System.out.println("Take one down, pass it around, " + "\n");
        }
    }
}
