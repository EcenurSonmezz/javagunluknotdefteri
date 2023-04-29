import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> notes = new ArrayList<>();
        FileHandler fileHandler = new FileHandler("notes.txt");

        try {
            fileHandler.createFile();
            notes = fileHandler.readFile();
        } catch (IOException e) {
            System.out.println("Dosya işlemleri sırasında bir hata oluştu: " + e.getMessage());
        }

        int choice = 0;

        while (choice != 4) {
            System.out.println("1. Not Ekle");
            System.out.println("2. Notları Görüntüle");
            System.out.println("3. Not Sil");
            System.out.println("4. Çıkış");

            System.out.print("Seçiminiz: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Başlık: ");
                    String title = scanner.next();

                    System.out.print("Not: ");
                    String note = scanner.next();

                    notes.add(title + ": " + note);
                    try {
                        fileHandler.writeFile(title + ": " + note);
                        System.out.println("Not başarıyla eklendi.\n");
                    } catch (IOException e) {
                        System.out.println("Dosya işlemleri sırasında bir hata oluştu: " + e.getMessage());
                    }
                    break;
                case 2:
                    if (notes.size() == 0) {
                        System.out.println("Henüz hiç not eklenmedi.\n");
                    } else {
                        System.out.println("Notlar:");
                        System.out.println("------");

                        for (String n : notes) {
                            System.out.println(n);
                        }

                        System.out.println();
                    }
                    break;
                case 3:
                    if (notes.size() == 0) {
                        System.out.println("Henüz hiç not eklenmedi.\n");
                    } else {
                        System.out.print("Silmek istediğiniz notun başlığını girin: ");
                        String titleToDelete = scanner.next();

                        boolean found = false;

                        for (String n : notes) {
                            if (n.startsWith(titleToDelete + ": ")) {
                                notes.remove(n);
                                try {
                                    fileHandler.createFile();
                                    for (String line : notes) {
                                        fileHandler.writeFile(line);
                                    }
                                } catch (IOException e) {
                                    System.out.println("dosya işlemleri sırasında bir hata oluştu: \" + e.getMessage());\r\n"
                                    		+ "                                }\r\n"
                                    		+ "\r\n"
                                    		+ "                                found = true;\r\n"
                                    		+ "                                System.out.println(\"Not başarıyla silindi.\\n\");\r\n"
                                    		+ "                                break;\r\n"
                                    		+ "                            }\r\n"
                                    		+ "                        }\r\n"
                                    		+ "\r\n"
                                    		+ "                        if (!found) {\r\n"
                                    		+ "                            System.out.println(\"Belirtilen başlığa sahip bir not bulunamadı.\\n\");\r\n"
                                    		+ "                        }\r\n"
                                    		+ "                    }\r\n"
                                    		+ "                    break;\r\n"
                                    		+ "                case 4:\r\n"
                                    		+ "                    System.out.println(\"Programdan çıkılıyor...\");\r\n"
                                    		+ "                    break;\r\n"
                                    		+ "                default:\r\n"
                                    		+ "                    System.out.println(\"Geçersiz seçim. Lütfen tekrar deneyin.\\n\");\r\n"
                                    		+ "                    break;\r\n"
                                    		+ "            }\r\n"
                                    		+ "        }\r\n"
                                    		+ "\r\n"
                                    		+ "        scanner.close();\r\n"
                                    		+ "    }\r\n"
                                    		+ "}\r\n"
                                    		+ "
