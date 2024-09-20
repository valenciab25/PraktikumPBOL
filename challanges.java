import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", NIM: " + nim;
    }
}

public class challanges {
    private static ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
           System.out.println("\nMenu CRUD Mahasiswa:");
            System.out.println("1. C Mahasiswa");
            System.out.println("2. R Mahasiswa");
            System.out.println("3. U Mahasiswa");
            System.out.println("4. D Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih 1-5: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 


            switch (choice) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    lihatMahasiswa();
                    break;
                case 3:
                    updateMahasiswa();
                    break;
                case 4:
                    hapusMahasiswa();
                    break;
                case 5:
                    System.out.println("Bye.");
                    break;
                default:
                    System.out.println("Pilih 1-5.");
            }
        } while (choice != 5);
    }

    private static void tambahMahasiswa() {
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        mahasiswaList.add(new Mahasiswa(nama, nim));
        System.out.println("Added.");
    }

    private static void lihatMahasiswa() {
        if (mahasiswaList.isEmpty()) {
            System.out.println("Tidak ada.");
        } else {
            for (int i = 0; i < mahasiswaList.size(); i++) {
                System.out.println((i + 1) + ". " + mahasiswaList.get(i));
            }
        }
    }

    private static void updateMahasiswa() {
        lihatMahasiswa();
        int index = scanner.nextInt() - 1;
            System.out.print("Masukkan Nama Baru: ");
            String namaBaru = scanner.nextLine();
            System.out.print("Masukkan NIM Baru: ");
            String nimBaru = scanner.nextLine();
            mahasiswaList.set(index, new Mahasiswa(namaBaru, nimBaru));
            System.out.println("Data diupdate.");
    }

    private static void hapusMahasiswa() {
        lihatMahasiswa();
        System.out.print("Pilih nomor mahasiswa yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        
        if (index >= 0 && index < mahasiswaList.size()) {
            mahasiswaList.remove(index);
            System.out.println("Data mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }
}
