package boogie;


import java.sql.Date;
import java.sql.Time;

/**
 * Created by larsd on 23-May-16.
 */
public class ServiceProvider {

    private static Date date = new Date(0);
    private static Time time = new Time(0);

    private static Liedje liedje = new Liedje(-1,"NULL","NULL","NULL","NULL");
    private static Activiteit activiteit = new Activiteit(-1,"NULL");
    private static Gelegenheid gelegenheid = new Gelegenheid(-1,"NULL");
    private static Prijs prijs = new Prijs(-1,-1,-1,-1,-1,date,date,date);
    private static Filmer filmer = new Filmer(-1,"NULL","NULL","NULL",-1,-1,-1,"NULL","NULL","NULL");
    private static Kosten kosten = new Kosten(-1,-1,-1,-1,-1,-1,-1);
    private static Groepstype groepstype = new Groepstype(-1,"NULL");
    private static Instantie instantie = new Instantie(-1,"NULL",-1,groepstype);
    private static Edit edit = new Edit(-1,"NULL","NULL","NULL",date);
    private static Evenement evenement = new Evenement(-1,-1,date,time,time,"NULL",-1,"NULL","NULL","NULL",instantie,liedje,gelegenheid,activiteit,prijs,kosten,edit);
    private static Deelnemer deelnemer = new Deelnemer(-1,"NULL","NULL","NULL",false,instantie);
    private static Filmt filmt = new Filmt(-1,evenement,filmer);
    
    private static LiedjeDAO liedjeDAO = new LiedjeDAO();
    private static ActiviteitDAO activiteitDAO = new ActiviteitDAO();
    private static GelegenheidDAO gelegenheidDAO = new GelegenheidDAO();
    private static PrijsDAO prijsDAO = new PrijsDAO();
    private static FilmerDAO filmerDAO = new FilmerDAO();
    private static KostenDAO kostenDAO = new KostenDAO();
    private static GroepstypeDAO groepstypeDAO = new GroepstypeDAO();
    private static InstantieDAO instantieDAO = new InstantieDAO();
    private static EditDAO editDAO = new EditDAO();
    private static EvenementDAO evenementDAO = new EvenementDAO();
    private static DeelnemerDAO deelnemerDAO = new DeelnemerDAO();
    private static FilmtDAO filmtDAO = new FilmtDAO();


    public static Date getDate() {
        return date;
    }

    public static Time getTime() {
        return time;
    }

    public static Liedje getLiedje() {
        return liedje;
    }

    public static Activiteit getActiviteit() {
        return activiteit;
    }

    public static Gelegenheid getGelegenheid() {
        return gelegenheid;
    }

    public static Prijs getPrijs() {
        return prijs;
    }

    public static Filmer getFilmer() {
        return filmer;
    }

    public static Kosten getKosten() {
        return kosten;
    }

    public static Groepstype getGroepstype() {
        return groepstype;
    }

    public static Instantie getInstantie() {
        return instantie;
    }

    public static Edit getEdit() {
        return edit;
    }

    public static Evenement getEvenement() {
        return evenement;
    }

    public static Deelnemer getDeelnemer() {
        return deelnemer;
    }

    public static Filmt getFilmt() {
        return filmt;
    }


    public static LiedjeDAO getLiedjeDAO() {
        return liedjeDAO;
    }

    public static ActiviteitDAO getActiviteitDAO() {
        return activiteitDAO;
    }

    public static GelegenheidDAO getGelegenheidDAO() {
        return gelegenheidDAO;
    }

    public static PrijsDAO getPrijsDAO() {
        return prijsDAO;
    }

    public static FilmerDAO getFilmerDAO() {
        return filmerDAO;
    }

    public static KostenDAO getKostenDAO() {
        return kostenDAO;
    }

    public static GroepstypeDAO getGroepstypeDAO() {
        return groepstypeDAO;
    }

    public static InstantieDAO getInstantieDAO() {
        return instantieDAO;
    }

    public static EditDAO getEditDAO() {
        return editDAO;
    }

    public static EvenementDAO getEvenementDAO() {
        return evenementDAO;
    }

    public static DeelnemerDAO getDeelnemerDAO() {
        return deelnemerDAO;
    }

    public static FilmtDAO getFilmtDAO() {
        return filmtDAO;
    }
}
