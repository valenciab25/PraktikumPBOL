import java.util.Scanner;
   class Biodata{
    public static void main(String args[]){
    Scanner input = new Scanner(System.in);
     
    String nama, nim;
    System.out.println("Isi Biodata : ");
    System.out.print("Nama: ");
    nama = input.nextLine();
     
    System.out.print("NIM: ");
    nim = input.nextLine();

    System.out.println("Data Mahasiswa : ");
    System.out.println("Nama: " + nama);
    System.out.println("NIM: " + nim);
     }
   }