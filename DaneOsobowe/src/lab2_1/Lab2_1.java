package lab2_1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Osoba implements Comparable<Osoba> {

    String nazwisko;
    float srednia;
    String uwagi;
    
        //Dodane potrzebne(uzywane) konstruktory
    public Osoba()
    {
    this.nazwisko=null;
    this.srednia=0;
    this.uwagi=null;
    }
    
    public Osoba (String s, int wybor)
    {
     if(wybor==0) {this.nazwisko=s; this.srednia=0; this.uwagi="";}
     else if(wybor==1) {this.nazwisko=""; this.srednia=Float.parseFloat(s); this.uwagi="";}
     else if(wybor==2) {this.nazwisko=""; this.srednia=0; this.uwagi=s;}
     else {this.nazwisko=""; this.srednia=0; this.uwagi="";}
    }
    //-----------------------------------------------------------------
    
    
    public void Nadaj_nazwisko(String lan) {
        nazwisko = lan;
    }

    public String Podaj_nazwisko() {
        return nazwisko;
    }

    public void Nadaj_uwagi(String lan) {
        uwagi = lan;
    }

    public String Podaj_uwagi() {
        return uwagi;
    }

    public void Nadaj_srednia(float srednia_) {
        srednia = srednia_;
    }

    public float Podaj_srednia() {
        return srednia;
    }

    @Override
    public String toString() {
        String napis = "";
        napis += "Nazwisko: " + nazwisko;
        napis += " srednia: " + srednia;
        napis += " uwagi: " + uwagi;
        return napis;
    }

    /*public boolean SzukajNazw(String s) {
        return nazwisko.equals(s);
    }*/
 
  public boolean equals(Osoba o) //uzywane do porownywania obiektow, potzrebne podzcas pozbywania sie duplikatow
  {
      if(this.nazwisko == o.nazwisko && this.uwagi == o.uwagi && this.srednia == o.srednia)
      {return true;}
      else
          return false;
  }
    
 @Override
  public int compareTo(Osoba o) {
   int p1 = nazwisko.compareTo(o.nazwisko);
   int p2 = String.valueOf(srednia).compareTo(String.valueOf(o.srednia));
   int p3 = uwagi.compareTo(o.uwagi);
   return p1+p2+p3;  
   }
  
  public boolean Szukaj(String N, int n)
  {
      if (n==1)
      {
       return nazwisko.equals(N);
      }
      if (n==2)
      {
        float R = Float.parseFloat(N);  
        return srednia==R;
      }
      if (n==3)
      {
        return uwagi.equals(N);
      }
      return true;
  }
}
   
/*class Tablica {

    Osoba Dane[] = null;
    int ile = 0;

    public boolean Pusta() {
        return ile == 0;
    }

    public boolean Pelna() {
        return ile == Dane.length;
    }

    public int Podaj_ile() {
        return ile;
    }

    public void Wykonaj_tablice(int N) {
        ile = 0;
        Dane = new Osoba[N]; //utworzenie tablicy
    }

    public void Wstaw(String nazwisko_, float srednia, String uwagi_) {
        Osoba dana = new Osoba();
        dana.Nadaj_nazwisko(nazwisko_);
        dana.Nadaj_srednia(srednia);
        dana.Nadaj_uwagi(uwagi_);
        Dane[ile] = dana;
        ile++;
    }

    public Osoba Wyszukaj(String s) {
        for (int i = 0; i < ile; i++) {
            if (Dane[i].SzukajNazw(s)) {
                return Dane[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < ile; i++) {
            s += Dane[i].toString() + "\n";
        }
        return s;
    }
}
*/

/*-----------------------------------------------------------------------
1.1*/
class Kolekcja {
    List<Osoba> Dane;
    int ktory;

    public boolean Pusta() {
      return Dane.size() == 0;
    }
    
    public boolean Pelna() {
      return Dane.size() == Dane.size();
    }
    
    public int Podaj_ile() {
      return Dane.size();
    }
    
    public void Wykonaj_kolekcje() {
      Dane = new ArrayList<Osoba>(); //utworzenie tablicy
    }
    //1.1 ----------------------------------------------------------------------
 public void Wstaw (String nazwisko_, float srednia, String uwagi_) {
    Osoba Nowa = new Osoba();
    Nowa.Nadaj_nazwisko(nazwisko_);
    Nowa.Nadaj_srednia(srednia);
    Nowa.Nadaj_uwagi(uwagi_);   
    if(!Dane.contains(Nowa)) 
// metoda contains kolekcji u�ywa metody equals przedefiniowanej po metodzie equals z klasy Object
       Dane.add(Nowa);
}
    
    /*--------------------------------------------------------------------------

    1.3 ----------------------------------------------------------------------*/
  public Osoba Wyszukaj(String s, int d)
    {
        for(int i=0; i<Dane.size(); i++)
          if(Dane.get(i).Szukaj(s, d))
             {
               ktory=i;
               return Dane.get(i);                 
             }
         return null;
    }

public boolean Usun(String dana, int kryterium)
    {
        Osoba od=Wyszukaj(dana, kryterium);//ustalony indeks ktory usuwanego elementu
        if(od!=null)
         { Dane.remove(ktory);
           return true;
         }
       return false;
    }
    /*--------------------------------------------------------------------------
    
    1.4 ----------------------------------------------------------------------*/
    @Override
    public String toString() {
        Iterator itr = Dane.iterator();
        String s = "";
        
        for (;itr.hasNext()==true;) {
        Object element = itr.next();
        s+=element+"\n";
        }
        return s;
    }
    
    
    
}
//------------------------------------------------------------------------

public class Lab2_1 {
    
    protected String dana;
    protected int kryterium;
    protected Kolekcja tablica = new Kolekcja();

    public void Wyswietl() {
        if (tablica.Pusta())//jesli tablica istnieje, to mo�na wyswietlac
        {
            JOptionPane.showMessageDialog(null, "Brak danych");
        } else {
            JOptionPane.showMessageDialog(null, tablica.toString());
        }
    }

    public void Setdana(String d) {dana=d;}
    public void Setkryterium(int i) {kryterium=i;}
    
    public void Wypelnij() {

        String S1, S2, S3, N;
            N = JOptionPane.showInputDialog(null, "Podaj ilosc osob do wpisania");
                tablica.Wykonaj_kolekcje(); //utworzenie tablicy
        while (tablica.Dane.size()!=Integer.parseInt(N)) //dopoki nie jest rowne N
        {
            S1 = JOptionPane.showInputDialog(null, "Podaj nazwisko");
            S2 = JOptionPane.showInputDialog(null, "Podaj srednia");
            S3 = JOptionPane.showInputDialog(null, "Podaj uwagi");
            tablica.Wstaw(S1, Float.parseFloat(S2), S3);//dopisanie danych na końcu danych
        }
    }

    public boolean Podaj_Dane (String n)
    {
        String i,d;
        if (n.equals("Wyszukiwanie"))
        {
        i = JOptionPane.showInputDialog(null, "Podaj kryterium szukania");
        d = JOptionPane.showInputDialog(null, "Podaj dane do wyszukania");
        int N = Integer.parseInt(i);
        Setkryterium(N); 
        Setdana(d);
        return true;
        }
        else if(n.equals("Usuwanie"))
        {
        i = JOptionPane.showInputDialog(null, "Podaj kryterium szukania");
        d = JOptionPane.showInputDialog(null, "Podaj dane do wyszukania");
        int N = Integer.parseInt(i);
        Setkryterium(N); 
        Setdana(d);
        return true;
        }

    return false;
    }
    
    public void Wyszukaj() {
  if(Podaj_Dane("Wyszukiwanie"))
  {
    Object osoba=tablica.Wyszukaj(dana,kryterium);
    if(osoba!=null)
      JOptionPane.showMessageDialog(null,osoba.toString());
    else
      JOptionPane.showMessageDialog(null,"Brak osoby");
    }
} 
 
    
    public void Usun(){
    if(Podaj_Dane("Usuwanie"))
  {
    boolean jak=tablica.Usun(dana,kryterium);
    if(jak)
      JOptionPane.showMessageDialog(null,"Usunieto");
    else
      JOptionPane.showMessageDialog(null,"Brak osoby");
    }
}

    static public void main(String args[]) {
        Lab2_1 baza1 = new Lab2_1(); //referencja do tablicy, kt�ra jest tworzona w opcji 1
        char ch;
        String s;
        do {
            s = JOptionPane.showInputDialog(null, "Progam nie jest zabezpieczony przed\n"
                    + "złym formatem danych\n i naciskaniem Cancel w okienkach dialogowych\n"
                    + "Podaj wybor"
                    + "\n1 - Wypelnij tablice,"
                    + "\n2 - Wyswietl dane osob"
                    + "\n3 - Wyszukaj osobe i wyswietl jej dane"
                    + "\n4 - Usun podany rekord"
                    + "\nk - Koniec programu");
            ch = s.charAt(0);  //pobranie opcji
            switch (ch) {
                case '1':
                    baza1.Wypelnij();
                    break;
                case '2':
                    baza1.Wyswietl();
                    break;
                case '3':
                    baza1.Wyszukaj();
                    break;
                case '4':
                    baza1.Usun();
                    break;
                case 'k':
                    JOptionPane.showMessageDialog(null, "Koniec programu");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Zla opcja");
            }
        } while (ch != 'k');
        System.exit(0);
    }
}
