import java.util.*;

import jakarta.persistence.*;
import model.*;
import model.Package;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Pack;

import javax.swing.text.View;

public class App {

    private static void Instantiate() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Project3DB");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

//--------------------features----------------\\
        Feature LeatherSeats = new Feature("leather seats");

        Feature HybridEngine = new Feature("plug-in hybrid engine");

        Feature PowerSlidingDoors = new Feature("power sliding doors");

        Feature HandsFreeSlidingDoors = new Feature("hands-free sliding doors");

        Feature FireTV = new Feature("Amazon FireTV");

        Feature RearScreens = new Feature("rear-seat entertainment screens");

        Feature AWD = new Feature("all-wheel drive");

        Feature CruiseControl = new Feature("adaptive cruise control");

        Set<Feature> featureSet = new HashSet<Feature>(Arrays.asList(LeatherSeats,
                HybridEngine,PowerSlidingDoors,HandsFreeSlidingDoors,FireTV,RearScreens,AWD,CruiseControl));
        for (Feature fs : featureSet){
            em.persist(fs);
        }



//----------------models----------------\\

        Model pacifica = new Model("Pacifica", 2022);

        Model pacificaHybrid22 = new Model("Pacifica Hybrid", 2022);

        Model pacificaHybrid21 = new Model("Pacifica Hybrid", 2021);


//----------------moodel features----------------\\

        HashSet<Feature> pacificaFeatures = new HashSet<Feature>();
        pacificaFeatures.add(PowerSlidingDoors);
        pacifica.setFeatures(pacificaFeatures);

        HashSet<Feature> pacificaH22Features = new HashSet<Feature>();
        pacificaH22Features.add(PowerSlidingDoors);
        pacificaH22Features.add(HybridEngine);
        pacificaHybrid22.setFeatures(pacificaH22Features);

        HashSet<Feature> pacificaH21Features = new HashSet<Feature>();
        pacificaH21Features.add(PowerSlidingDoors);
        pacificaH21Features.add(HybridEngine);
        pacificaHybrid21.setFeatures(pacificaH21Features);

//----------------packages----------------\\
        HashSet<Feature> Theater = new HashSet<Feature>();
        Package theater = new Package("Theater Package");
        HashSet<Feature> Amazon = new HashSet<Feature>();
        Package amazon = new Package("Amazon Theater Package");
        HashSet<Feature> Safety = new HashSet<Feature>();
        Package safety = new Package("Safety Package");

        Theater.add(RearScreens);
        Amazon.add(FireTV);
        Amazon.add(RearScreens);
        Safety.add(CruiseControl);

        theater.setFeatures(Theater);
        amazon.setFeatures(Amazon);
        safety.setFeatures(Safety);


//----------------trims----------------\\
//PACIFICA 2022
        HashSet<Package> trimtouring1 = new HashSet<Package>();
        Trim touring1 = new Trim("Touring", 30000, pacifica);
        trimtouring1.add(safety);

        HashSet<Package> trimlimited1 = new HashSet<Package>();
        HashSet<Feature> trimlimited1F = new HashSet<Feature>();
        Trim limited1 = new Trim("Limited", 34000, pacifica);
        trimlimited1.add(amazon);
        trimlimited1F.add(LeatherSeats);
        trimlimited1F.add(HandsFreeSlidingDoors);
        limited1.setFeatures(trimlimited1F);

        HashSet<Feature> trimpinnacle1F = new HashSet<Feature>();
        Trim pinnacle1 = new Trim("Pinnacle", 42000, pacifica);
        trimpinnacle1F.add(LeatherSeats);
        trimpinnacle1F.add(HandsFreeSlidingDoors);
        trimpinnacle1F.add(RearScreens);
        trimpinnacle1F.add(FireTV);
        trimpinnacle1F.add(AWD);
        pinnacle1.setFeatures(trimpinnacle1F);


//PACIFICA Hybrid 2022

        Trim touring2 = new Trim("Touring", 43000, pacificaHybrid22);


        HashSet<Package> trimlimited2 = new HashSet<Package>();
        HashSet<Feature> trimlimited2F = new HashSet<Feature>();
        Trim limited2 = new Trim("Limited", 48000, pacifica);
        trimlimited2.add(amazon);
        trimlimited2F.add(LeatherSeats);
        trimlimited2F.add(HandsFreeSlidingDoors);
        limited2.setFeatures(trimlimited2F);

        HashSet<Feature> trimpinnacle2F = new HashSet<Feature>();
        Trim pinnacle2 = new Trim("Pinnacle", 34000, pacificaHybrid22);
        trimpinnacle2F.add(LeatherSeats);
        trimpinnacle2F.add(HandsFreeSlidingDoors);
        trimpinnacle2F.add(RearScreens);
        trimpinnacle2F.add(FireTV);
        pinnacle2.setFeatures(trimpinnacle2F);



//PACIFICA Hybrid 2021
        HashSet<Package> trimtouring3 = new HashSet<Package>();
        Trim touring3 = new Trim("Touring", 41000, pacificaHybrid21);
        trimtouring3.add(safety);

        HashSet<Package> trimlimited3 = new HashSet<Package>();
        HashSet<Feature> trimlimited3F = new HashSet<Feature>();
        Trim limited3 = new Trim("Limited", 46000, pacificaHybrid21);
        trimlimited3.add(theater);
        trimlimited3.add(safety);
        trimlimited3F.add(LeatherSeats);
        trimlimited3F.add(HandsFreeSlidingDoors);
        limited3.setFeatures(trimlimited3F);

        HashSet<Feature> trimpinnacle3F = new HashSet<Feature>();
        Trim pinnacle3 = new Trim("Pinnacle", 52000, pacificaHybrid21);
        trimpinnacle3F.add(LeatherSeats);
        trimpinnacle3F.add(HandsFreeSlidingDoors);
        trimpinnacle3F.add(RearScreens);
        trimpinnacle3F.add(CruiseControl);
        pinnacle3.setFeatures(trimpinnacle3F);


//---------------------available packages ----------------------------------------------\\
        AvailablePackage AP1 = new AvailablePackage(safety,3000,touring1);
        AvailablePackage AP2 = new AvailablePackage(theater,2500,limited1);
        AvailablePackage AP3 = new AvailablePackage(theater,2500,limited2);
        AvailablePackage AP4 = new AvailablePackage(safety,3000,touring3);
        AvailablePackage AP5 = new AvailablePackage(theater,2500,limited3);
        AvailablePackage AP6 = new AvailablePackage(safety,2000,limited3);

//---------Automobiles-----------\\

        Set<AvailablePackage> chosen1 = new HashSet<AvailablePackage>();
        Automobile car1 = new Automobile("12345abcde",limited1);
        chosen1.add(AP1);
        car1.setAvailablePackages(chosen1);

        Set<AvailablePackage> chosen2 = new HashSet<AvailablePackage>();
        Automobile car2 = new Automobile("67890abcde",pinnacle2);

        Set<AvailablePackage> chosen3 = new HashSet<AvailablePackage>();
        Automobile car3 = new Automobile("99999aaaaa",pinnacle3);

        Set<AvailablePackage> chosen4 = new HashSet<AvailablePackage>();
        Automobile car4 = new Automobile("aaaaa88888",touring3);
        chosen1.add(AP4);
        car4.setAvailablePackages(chosen4);

        Set<AvailablePackage> chosen5 = new HashSet<AvailablePackage>();
        Automobile car5 = new Automobile("bbbbb77777",limited3);
        chosen1.add(AP5);
        chosen1.add(AP6);
        car5.setAvailablePackages(chosen5);





//---------PERSISTING-----------\\
        em.persist(pacifica);
        em.persist(pacificaHybrid22);
        em.persist(pacificaHybrid21);
        em.persist(theater);
        em.persist(amazon);
        em.persist(safety);
        em.persist(touring1);
        em.persist(limited1);
        em.persist(pinnacle1);
        em.persist(touring2);
        em.persist(limited2);
        em.persist(pinnacle2);
        em.persist(touring3);
        em.persist(limited3);
        em.persist(pinnacle3);
        em.persist(AP1);
        em.persist(AP2);
        em.persist(AP3);
        em.persist(AP4);
        em.persist(AP5);
        em.persist(AP6);
        em.persist(car1);
        em.persist(car2);
        em.persist(car3);
        em.persist(car4);
        em.persist(car5);
        em.getTransaction().commit();
    }
    public static void VINlookUp()
    {
        Scanner scanny = new Scanner(System.in);
        System.out.println("Enter the VIN of desired automobile ");
        String VIN = scanny.nextLine();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Project3DB");
        EntityManager em = factory.createEntityManager();


        var namedAutomobile = em.createQuery("SELECT m FROM Automobiles m WHERE "
                + "m.VIN = ?1", Automobile.class);
        namedAutomobile.setParameter(1, VIN);
        try {
            Automobile requested = namedAutomobile.getSingleResult();
            System.out.println("Your requested : " + requested);
        }
        catch (NoResultException ex) {
            System.out.println("Museum with name '" + VIN + "' not found.");
        }
    }
    public static void main(String[] args) throws Exception {

        Instantiate();
        Scanner scanny = new Scanner(System.in);
        System.out.println("Enter your choice: \n" + "1. Instantiate model \n" + "2. Automobile lookup \n" + "3. Feature search \n");
        int choice = scanny.nextInt();
        if(choice == 1)
        {
            Instantiate();
        }
        else if(choice ==2)
        {
            VINlookUp();
        }
    }
}



