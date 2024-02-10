package kuis_sd;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Kuis_SD {
    private String nama;
    private String asal;
    private int skor;
    private String mode;
    private String soal1;
    private String soal2;
    private String soal3;
    private String soal4;
    private String soal5;
    
    public Kuis_SD(String nama, String asal, int skor, String mode, String soal1, String soal2, String soal3, String soal4, String soal5){
        this.nama = nama;
        this.asal = asal;
        this.skor = skor;
        this.mode = mode;
        this.soal1 = soal1;
        this.soal2 = soal2;
        this.soal3 = soal3;
        this.soal4 = soal4;
        this.soal5 = soal5;
    }
    
    public record Player(String nama, String asal, int nilai, String mode){} 
    public record Soal(String soalnya, String a, String b, String c){}
    public record Koreksi(String nama, String soal1, String soal2, String soal3, String soal4, String soal5){}
    private ArrayList<Player> APlayer = new ArrayList<>(); //UNTUK MENYIMPAN DATA PERINGKAT KESELURUHAN
    private LinkedList<Player> LPlayer = new LinkedList<>(); //UNTUK MENYIMPAN DATA RIWAYAT
    private ArrayList<Player> EPlayer = new ArrayList<>(); //UNTUK MENYIMPAN DATA PERINGKAT EASY
    private ArrayList<Player> MPlayer = new ArrayList<>(); //UNTUK MENYIMPAN DATA PERINGKAT MEDIUM
    private ArrayList<Player> HPlayer = new ArrayList<>(); //UNTUK MENYIMPAN DATA PERINGKAT HARD
    private ArrayList<Koreksi> Cek = new ArrayList<>(); //UNTUK MENYIMPAN DATA BENAR SALAH
    private Scanner input = new Scanner(System.in);
    
    public void MenuUtama(){
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("│                    Kuis Kita Juara                    │");
        System.out.println("├───────────────────────────────────────────────────────┤");
        System.out.println("│ 1.  MULAI PERMAINAN                                   │");
        System.out.println("│ 2.  RIWAYAT PERMAINAN                                 │");
        System.out.println("│ 3.  LIHAT PERINGKAT                                   │");
        System.out.println("├───────────────────────────────────────────────────────┤");
        System.out.println("│ 9.  KELUAR                                            │");
        System.out.println("└───────────────────────────────────────────────────────┘");
        System.out.print("PILIH MENU : ");
        int opsi = input.nextInt();
        input.nextLine();
        switch (opsi){
            case 1 :
                Permainan();
                break;
            case 2 :
                Riwayat();
                break;
            case 3 :
                Peringkat();
            case 9 :
                System.exit(0);
                break;
            default :
                MenuUtama();
        }
    }
    
    public void Permainan(){
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("│                    Kuis Kita Juara                    │");
        System.out.println("└───────────────────────────────────────────────────────┘");
        System.out.print("Masukkan Nama : ");
        nama = input.next();
        System.out.print("Masukkan Asal : ");
        asal = input.next();
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("│                    MODE PERMAINAN                     │");
        System.out.println("├───────────────────────────────────────────────────────┤");
        System.out.println("│ 1. EASY                                               │");
        System.out.println("│ 2. MEDIUM                                             │");
        System.out.println("│ 3. HARD                                               │");
        System.out.println("├───────────────────────────────────────────────────────┤");  
        System.out.println("│ 0. KEMBALI                                            │");
        System.out.println("└───────────────────────────────────────────────────────┘");
        System.out.print("Masukkan Opsi : ");
        int opsi = input.nextInt();
        input.nextLine();
        switch (opsi){
            case 1 :
                PertanyaanEasy();
                break;
            case 2 :
                PertanyaanMedium();
                break;
            case 3 :
                PertanyaanHard();
                break;
            case 0 :
                MenuUtama();
                break;
            default :
                System.out.println("Pilihan tidak sesuai");
                Permainan();
                break;
        }
        
        
    }
    
    public void PertanyaanEasy(){
        mode = "EASY";
        Soal[] soal = new Soal[5];
        soal[0] = new Soal("Apa danau terbesar di dunia?", "Kaspia", "Amazon", "Nil");
        soal[1] = new Soal("Planet apa yang dijuluki sebagai Bintang Kejora?", "Saturnus", "Venus", "Uranus");
        soal[2] = new Soal("Tanggal berapa Leonardo Da Vinci lahir?", "12 April", "17 April", "15 April");
        soal[3] = new Soal("Apa Nama Ibu Kota Prancis?", "Paris", "Manila", "New York");
        soal[4] = new Soal("Apa lambang dari zodiak Leo?", "Singa", "Kalajengking", "Sapi");

        System.out.println("1. "+soal[0].soalnya());
        System.out.println("a. "+soal[0].a());
        System.out.println("b. "+soal[0].b());
        System.out.println("c. "+soal[0].c());
        System.out.print("Pilih : ");
        String pilih = input.next();
        if (pilih.equalsIgnoreCase("a")) {
            skor = 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal1 = "BENAR";
        }else{
            skor = 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH A");
            soal1 = "SALAH";
        }
        System.out.println();

        System.out.println("2. "+soal[1].soalnya());
        System.out.println("a. "+soal[1].a());
        System.out.println("b. "+soal[1].b());
        System.out.println("c. "+soal[1].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("b")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal2 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH B");
            soal2 = "SALAH";
        }
        System.out.println();

        System.out.println("3. "+soal[2].soalnya());
        System.out.println("a. "+soal[2].a());
        System.out.println("b. "+soal[2].b());
        System.out.println("c. "+soal[2].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("c")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal3 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH C");
            soal3 = "SALAH"; 
        }
        System.out.println();

        System.out.println("4. "+soal[3].soalnya());
        System.out.println("a. "+soal[3].a());
        System.out.println("b. "+soal[3].b());
        System.out.println("c. "+soal[3].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("a")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal4 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH A");
            soal4 = "SALAH"; 
        }
        System.out.println();

        System.out.println("5. "+soal[4].soalnya());
        System.out.println("a. "+soal[4].a());
        System.out.println("b. "+soal[4].b());
        System.out.println("c. "+soal[4].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("a")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal5 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH A");
            soal5 = "SALAH"; 
        }
        System.out.println();
        
        System.out.println("SKOR ANDA : "+skor);
        Player ply = new Player(nama, asal, skor, mode);
        APlayer.add(ply);
        LPlayer.add(ply);
        EPlayer.add(ply);
        Koreksi krk = new Koreksi(nama, soal1, soal2, soal3, soal4, soal5);
        Cek.add(krk);
        MenuUtama();
    }
   
    public void PertanyaanMedium(){
        mode = "MEDIUM";
        Soal[] soal = new Soal[5];
        soal[0] = new Soal("Negara manakah yang terkenal dengan Taj Mahal", "Kazakhstan", "India", "Roma");
        soal[1] = new Soal("Siapa nama ilmuwan yang merumuskan hukum gravitasi?", "Alexander Graham Bell", "Baden Powell", "Sir Isaac Newton");
        soal[2] = new Soal("Siapa nama tokoh dalam mitologi Yunani yang merupakan dewa petir", "Medusa", "Hercules", "Zeus");
        soal[3] = new Soal("Apa nama ilmiah dari manusia modern purba yang hidup sekitar 40.000 tahun yang lalu?", "Homo Sapiens Neanderthalensis", "Homo Piens Derthalensis", "Homo Sapiens");
        soal[4] = new Soal("Apa warna dari bendera Amerika Serikat?", "Merah, Putih, Hijau", "Merah, Biru, Ungu", "Merah, Putih, Biru");

        System.out.println("1. "+soal[0].soalnya());
        System.out.println("a. "+soal[0].a());
        System.out.println("b. "+soal[0].b());
        System.out.println("c. "+soal[0].c());
        System.out.print("Pilih : ");
        String pilih = input.next();
        if (pilih.equalsIgnoreCase("b")) {
            skor = 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal1 = "BENAR";
        }else{
            skor = 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH B");
            soal1 = "SALAH";
        }
        System.out.println();

        System.out.println("2. "+soal[1].soalnya());
        System.out.println("a. "+soal[1].a());
        System.out.println("b. "+soal[1].b());
        System.out.println("c. "+soal[1].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("c")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal2 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH C");
            soal2 = "SALAH";
        }
        System.out.println();

        System.out.println("3. "+soal[2].soalnya());
        System.out.println("a. "+soal[2].a());
        System.out.println("b. "+soal[2].b());
        System.out.println("c. "+soal[2].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("c")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal3 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH C");
            soal3 = "SALAH";
        }
        System.out.println();

        System.out.println("4. "+soal[3].soalnya());
        System.out.println("a. "+soal[3].a());
        System.out.println("b. "+soal[3].b());
        System.out.println("c. "+soal[3].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("a")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal4 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH A");
            soal4 = "SALAH";
        }
        System.out.println();

        System.out.println("5. "+soal[4].soalnya());
        System.out.println("a. "+soal[4].a());
        System.out.println("b. "+soal[4].b());
        System.out.println("c. "+soal[4].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("c")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal5 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH C");
            soal5 = "SALAH";
        }
        System.out.println();
        
        
        System.out.println("SKOR ANDA : "+skor);
        Player ply = new Player(nama, asal, skor, mode);
        APlayer.add(ply);
        LPlayer.add(ply);
        MPlayer.add(ply);
        Koreksi krk = new Koreksi (nama, soal1, soal2, soal3, soal4, soal5);
        Cek.add(krk);
        MenuUtama();
    }

    public void PertanyaanHard(){
        mode = "HARD";
        Soal[] soal = new Soal[5];
        soal[0] = new Soal("Sejarah manakah yang dianggap sebagai 'Zaman Emas Islam'?", "Abad ke-8 hingga abad ke-14", "Abad ke-7 hingga abad ke-12", "Abad ke-5 hingga abad ke-10");
        soal[1] = new Soal("Peningkatan suhu di atmosfer bumi karena peningkatan konsentrasi gas-gas seperti C02 disebut..", "Efek Rumah Kaca", "Efek Greenhouse", "Efek Greenland");
        soal[2] = new Soal("Siapakah Ilmuwan yang menemukan elektron?", "Sir Isaac Newton", "Albert Einsten", "J.J. Thomson");
        soal[3] = new Soal("Apa nama ilmiah dari burung yang terkenal dengan kemampuan mimikrinya?", "Bupati (Bubo Philippensis)", "Golejra (Sativa Fanreak)", "Pipit (Reanosis Reolaafs)");
        soal[4] = new Soal("Siapakah tokoh terkenal dalam filsafat China dengan ajaran Taoisme?", "Liang Chen", "Lao Tzu", "Ding Yuan");

        System.out.println("1. "+soal[0].soalnya());
        System.out.println("a. "+soal[0].a());
        System.out.println("b. "+soal[0].b());
        System.out.println("c. "+soal[0].c());
        System.out.print("Pilih : ");
        String pilih = input.next();
        if (pilih.equalsIgnoreCase("c")) {
            skor = 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal1 = "BENAR";
        }else{
            skor = 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH  C");
            soal1 = "SALAH";
        }
        System.out.println();

        System.out.println("2. "+soal[1].soalnya());
        System.out.println("a. "+soal[1].a());
        System.out.println("b. "+soal[1].b());
        System.out.println("c. "+soal[1].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("b")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal2 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH B");
            soal2 = "SALAH";
        }
        System.out.println();

        System.out.println("3. "+soal[2].soalnya());
        System.out.println("a. "+soal[2].a());
        System.out.println("b. "+soal[2].b());
        System.out.println("c. "+soal[2].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("c")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal3 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH C");
            soal3 = "SALAH";
        }
        System.out.println();

        System.out.println("4. "+soal[3].soalnya());
        System.out.println("a. "+soal[3].a());
        System.out.println("b. "+soal[3].b());
        System.out.println("c. "+soal[3].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("a")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal4 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH A");
            soal4 = "SALAH";
        }
        System.out.println();

        System.out.println("5. "+soal[4].soalnya());
        System.out.println("a. "+soal[4].a());
        System.out.println("b. "+soal[4].b());
        System.out.println("c. "+soal[4].c());
        System.out.print("Pilih : ");
        pilih = input.next();
        if (pilih.equalsIgnoreCase("b")) {
            skor += 20;
            System.out.println("JAWABAN ANDA BENAR");
            soal5 = "BENAR";
        }else{
            skor += 0;
            System.out.println("JAWABAN ANDA SALAH");
            System.out.println("JAWABAN YANG BENAR ADALAH B");
            soal5 = "SALAH";
        }
        System.out.println();
        

        System.out.println("SKOR ANDA : "+skor);
        Player ply = new Player(nama, asal, skor, mode);
        APlayer.add(ply);
        LPlayer.add(ply);
        HPlayer.add(ply);
        Koreksi krk = new Koreksi (nama, soal1, soal2, soal3, soal4, soal5);
        Cek.add(krk);
        MenuUtama();
    }
    
    
    public void Riwayat(){
        String lagi;
        if (LPlayer.isEmpty()){
            System.out.println("┌───────────────────────────────────────────────────────┐");
            System.out.println("│                 BELUM ADA PERMAINAN                   │");
            System.out.println("└───────────────────────────────────────────────────────┘");  
        }else{
            System.out.println("┌───────────────────────────────────────────────────────┐");
            System.out.println("│                  HISTORI PERMAINAN                    │");
            System.out.println("├───────────────────────────────────────────────────────┤");  
            System.out.printf("%s%-12s%s%-12s%s%-12s%s%-11s%s\n","│ ","MODE","│ ", "NAMA","│ ", "ASAL","│ ", "SKOR", " │");
            for (Player histori : LPlayer){
                System.out.printf("%s%-12s%s%-12s%s%-12s%s%-11s%s\n", "│ ", histori.mode(), "│ ", histori.nama(), "│ ", histori.asal(), "│ ", histori.nilai(), " │");
            }
            
            System.out.println();
            System.out.println("1. Cari Histori, Selain 1 Kembali");
            System.out.print("Masukkan Opsi : ");
            int opsi = input.nextInt();
            input.nextLine();
            do{
                switch (opsi){
                    case 1 :
                        System.out.print("Masukkan kata kunci : ");
                        String katakunci = input.nextLine();
                        Cari(katakunci);
                        break;
                    default :
                        MenuUtama();
                        break;
                }
                System.out.println();
                System.out.println("1. Cari Lagi, Selain 1 Kembali");
                System.out.print("Masukkan Opsi : ");
                lagi = input.next();
                input.nextLine();
            }while(lagi.equalsIgnoreCase("1"));
            
        }
        MenuUtama();
    }
    
    public void Cari(String nama){
        boolean ada = false;
        
        for (Player ppp : LPlayer){
            if (ppp.nama().contains(nama)){
                ada = true;
                break;
            }
        }
        
        if (ada){
            System.out.println("HASIL");
        }
        
        for (Koreksi xxx : Cek){
            if (xxx.nama().contains(nama)){
                System.out.println("┌───────────────────────────────────────────────────────┐");
                System.out.println("│                    HASIL PENCARIAN                    │");
                System.out.println("├───────────────────────────────────────────────────────┤");
                System.out.printf("%s%-25s%s%-26s%s\n", "│ ", "NAMA", "│ ", xxx.nama(), " │");
                System.out.printf("%s%-25s%s%-26s%s\n", "│ ", "SOAL 1", "│ ", xxx.soal1(), " │");
                System.out.printf("%s%-25s%s%-26s%s\n", "│ ", "SOAL 2", "│ ", xxx.soal2(), " │");
                System.out.printf("%s%-25s%s%-26s%s\n", "│ ", "SOAL 3", "│ ", xxx.soal3(), " │");
                System.out.printf("%s%-25s%s%-26s%s\n", "│ ", "SOAL 4", "│ ", xxx.soal4(), " │");
                System.out.printf("%s%-25s%s%-26s%s\n", "│ ", "SOAL 5", "│ ", xxx.soal5(), " │");
                System.out.println("└───────────────────────────────────────────────────────┘");
            }
        }
        
        if (!ada){
            System.out.println("┌───────────────────────────────────────────────────────┐");
            System.out.println("│                HISTORI TIDAK DITEMUKAN                │");
            System.out.println("└───────────────────────────────────────────────────────┘");
        }
    }
    
    public void Peringkat(){
        if (APlayer.isEmpty()){
            System.out.println("┌───────────────────────────────────────────────────────┐");
            System.out.println("│                  BELUM ADA PERMAINAN                  │");
            System.out.println("└───────────────────────────────────────────────────────┘");
        }else{
            System.out.println("┌───────────────────────────────────────────────────────┐");
            System.out.println("│                    LIHAT PERINGKAT                    │");
            System.out.println("├───────────────────────────────────────────────────────┤");
            System.out.println("│ 1. EASY                                               │");
            System.out.println("│ 2. MEDIUM                                             │");
            System.out.println("│ 3. HARD                                               │");
            System.out.println("├───────────────────────────────────────────────────────┤");  
            System.out.println("│ 0. KEMBALI                                            │");
            System.out.println("└───────────────────────────────────────────────────────┘");
            System.out.print("MASUKKAN OPSI : ");  
            int opsi = input.nextInt();
            input.nextLine();
            switch (opsi){
                case 1 :
                    ArrayList<Player> rankE = new ArrayList<>(EPlayer);
                    rankE.sort(Comparator.comparingInt(Player::nilai).reversed());
                    System.out.println("┌───────────────────────────────────────────────────────┐");
                    System.out.println("│                 PERINGKAT PERMAINAN                   │");
                    System.out.println("├───────────────────────────────────────────────────────┤");     
                    System.out.printf("%s%-12s%s%-12s%s%-12s%s%-11s%s\n","│ ","RANGKING","│ ", "NAMA","│ ", "ASAL","│ ", "SKOR", " │");
                    for (Player erangking : rankE){
                        System.out.printf("%s%-12s%s%-12s%s%-12s%s%-11s%s\n","│ ",(rankE.indexOf(erangking)+1),"│ ",erangking.nama(),"│ ",erangking.asal(),"│ ",erangking.nilai(), " │");
                    }
                    break;
                case 2 :
                    ArrayList<Player> rankM = new ArrayList<>(MPlayer);
                    rankM.sort(Comparator.comparingInt(Player::nilai).reversed());
                    System.out.println("┌───────────────────────────────────────────────────────┐");
                    System.out.println("│                 PERINGKAT PERMAINAN                   │");
                    System.out.println("├───────────────────────────────────────────────────────┤");
                    System.out.printf("%s%-12s%s%-12s%s%-12s%s%-11s%s\n","│ ","RANGKING","│ ", "NAMA","│ ", "ASAL","│ ", "SKOR", " │");
                    for (Player mrangking : rankM){
                        System.out.printf("%s%-12s%s%-12s%s%-12s%s%-11s%s\n","│ ",(rankM.indexOf(mrangking)+1),"│ ",mrangking.nama(),"│ ",mrangking.asal(),"│ ",mrangking.nilai(), " │");
                    }
                    break;
                case 3 :
                    ArrayList<Player> rankH = new ArrayList<>(HPlayer);
                    rankH.sort(Comparator.comparingInt(Player::nilai).reversed());
                    System.out.println("┌───────────────────────────────────────────────────────┐");
                    System.out.println("│                 PERINGKAT PERMAINAN                   │");
                    System.out.println("├───────────────────────────────────────────────────────┤");
                    System.out.printf("%s%-12s%s%-12s%s%-12s%s%-11s%s\n","│ ","RANGKING","│ ", "NAMA","│ ", "ASAL","│ ", "SKOR", " │");
                    for (Player hrangking : rankH){
                        System.out.printf("%s%-12s%s%-12s%s%-12s%s%-11s%s\n","│ ",(rankH.indexOf(hrangking)+1),"│ ",hrangking.nama(),"│ ",hrangking.asal(),"│ ",hrangking.nilai(), " │");
                    }
                    break;
                case 0 :
                    MenuUtama();
                    break;
                default :
                    Peringkat();
                    
            }
            
        }
        MenuUtama();
    }
    
    public static void main(String[] args) {
        Kuis_SD mulai = new Kuis_SD(null, null, 0, null, null, null, null, null, null);
        mulai.MenuUtama();
    }
    
}