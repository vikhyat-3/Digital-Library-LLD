import java.util.*;
public class Main
{
    enum Song_Type{
        HIPHOP,
        POP,
        KPOP,
        ROCK,
        JAZZ,
        WESTERN_CLASSICAL,
        HINDUSTANI,
        CARNATIC
    }
    enum Movie_Type{
        ACTION,
        DRAMA,
        HORROR,
        ROMANCE,
        COMEDY,
        THRILLER
    }
    enum Language{
        HINDI,
        ENGLISH,
        ARABIC,
        ITALIAN,
        FRENCH,
        KANNADA,
        KOREAN,
        JAPANESE
    }
    public static class Item{
        private String item_id;//M-Num for movie and S-num for songs
        private double price;//in USD
        private int duration;//in seconds
        private Language lang;
        private String creators[];
        private String getID(){
            return this.item_id;
        }
        public void setID(String id){
            this.item_id=id;
        }
        public double getPrice(){
            return this.price;
        }
        public void setPrice(double price){
            this.price=price;
        }
        public int getDuration(){
            return this.duration;
        }
        public void setDuration(int duration){
            this.duration=duration;
        }
        public Language getLang(){
            return this.lang;
        }
        public void setLang(Language lang){
            this.lang=lang;
        }
        public String[] getCreators(){
            return this.creators;
        }
        public void setCreators(String [] creators){
            this.creators=creators;
        }
    }
    public static class Movie extends Item{
        private Movie_Type genre;
        public Movie_Type getMovieGenre(){
            return this.genre;
        }
        public void setMovieGenre(Movie_Type g){
            this.genre=g;
        }
        Movie(String id,double price,int duration,Movie_Type genre,Language lang,String creators[]){
            setID(id);
            setPrice(price);
            setDuration(duration);
            setMovieGenre(genre);
            setLang(lang);
            setCreators(creators);
        }
	}
	public static class Song extends Item{
        private Song_Type genre;
        public Song_Type getSongGenre(){
            return this.genre;
        }
        public void setSongGenre(Song_Type g){
            this.genre=g;
        }
        Song(String id,double price,int duration,Song_Type genre,Language lang,String creators[]){
            setID(id);
            setPrice(price);
            setDuration(duration);
            setSongGenre(genre);
            setLang(lang);
            setCreators(creators);
        }
	}
	public static class User{
	    private String custID;
	    private String name;
	    private String phone;
	    private int premium;
	    private HashMap<Item, Date[]> rented;
	    private HashMap<Item, Date[]> pastRented;
	    User(String custID,String name,	String phone){
	        this.custID=custID;
	        this.name=name;
	        this.phone=phone;
	        this.premium=0;
	        rented=new HashMap<>();
	        pastRented = new HashMap<>();
	   }
	   public void rent(Item i,Date date){
	       int num=30;
	       if (this.premium==1){
	           num=45;
	       }
	       Date d[]={date,new Date(date.getTime()+(num*24*60*60*1000))};
	       this.rented.put(i,d);
	       this.pastRented.put(i,d);
    	   
	   }
	   public boolean hasRented(Item i){
    	   return (this.rented.containsKey(i));
	   }
	}
	
    public static void main(String[] args) {
		System.out.println("Hello World");
		String c[]={"John","Helen"};
		Movie a= new Movie("M001",20.0,3600,Movie_Type.DRAMA,Language.ENGLISH,c);
		c[0]="NOOB";
		Movie b= new Movie("M002",50.0,7200,Movie_Type.ACTION,Language.HINDI,c);
		User jack=new User("U001","Jack","9999999999");
		jack.rent(a,new Date());
		System.out.println(jack.hasRented(a));
		System.out.println(jack.hasRented(b));
    }
}
