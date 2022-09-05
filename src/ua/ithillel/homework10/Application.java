package ua.ithillel.homework10;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {
        FileData fileData1 = new FileData("file1", 205, "src\\ua\\ithillel\\homework10\\resources");
        FileData fileData2 = new FileData("file2", 250, "src\\ua\\ithillel\\homework10\\resources");
        FileData fileData3 = new FileData("file3", 320, "src\\ua\\ithillel\\homework10\\resources");
        FileData fileData4 = new FileData("photo1", 120, "src\\ua\\ithillel\\homework10\\resources");
        FileData fileData5 = new FileData("photo2", 220, "src\\ua\\ithillel\\homework12\\resources");
        FileData fileData6 = new FileData("photo3", 330, "src\\ua\\ithillel\\homework13\\resources");

        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("src\\ua\\ithillel\\homework10\\resources", fileData1);
        fileNavigator.add("src\\ua\\ithillel\\homework10\\resources", fileData2);
        fileNavigator.add("src\\ua\\ithillel\\homework10\\resources", fileData3);
        fileNavigator.add("src\\ua\\ithillel\\homework10\\resources", fileData4);
        fileNavigator.add("src\\ua\\ithillel\\homework12\\resources", fileData5);
        fileNavigator.add("src\\ua\\ithillel\\homework13\\resources", fileData6);

        System.out.println(fileNavigator.filterBySize(210));
        System.out.println(fileNavigator.sortBySize());
        System.out.println(fileNavigator.find("src\\ua\\ithillel\\homework10\\resources"));

        fileNavigator.remove("src\\ua\\ithillel\\homework13\\resources");
    }
}
