package day01;

import org.junit.jupiter.api.*;

public class Test03 {
    @BeforeAll
    public static void setUp(){
    System.out.println("Test işlemi Başlatılıyor");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("Tüm testler başarıyla çalıştırıldı");
    }

    @BeforeEach
    public void before(){
        System.out.println("Sıradaki Test Çalıştırılıyor");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Tamamlandı. Sıradaki Teste Geçiliyor");
    }

    @Test

    public void testA(){
        System.out.println("Rana Nur Ülker");
    }


    @Test

    public void testC(){
        System.out.println("Levent Kadir Seflek");
    }

    @Test

    public void testB(){
        System.out.println("Can Yılmaz");
    }
}
