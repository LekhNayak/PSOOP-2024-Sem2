import java.util.*;

//Creating a class named Production
class Production {
  private String title;
  private String director;
  private String writer;
  
  //Creating a paramterized constructor for Production class to initialize the attributes
  Production(String title, String director, String writer) {
    this.title = title;
    this.director = director;
    this.writer = writer;
  }
  
  //Getter methods for private attributes of Production class
  String getTitle() {
    return title;
  }
  String getDirector() {
    return director;
  }
  String getWriter() {
    return writer;
  }
  
  //Setter methods for private attributes of production class
  void setTitle(String title) {
    this.title = title;
  }
  void setDirector(String director) {
    this.director = director;
  }
  void setWriter(String writer) {
    this.writer = writer;
  }
  
  //toString method
  public String toString() {
      return "Title: " + title + ", Director: " + director + ", Writer: " + writer;
  }
}

class Play extends Production {
  private int performances;
  private int seatsBooked;
  
  Play(String title, String director, String writer, int performances, int seatsBooked) {
        super(title, director, writer);
        this.performances = performances;
        this.seatsBooked = seatsBooked;
  }
  
  //getter methods for private attributes in Play class
  int getPerformances() {
    return performances;
  }
  int getSeatsBooked() {
    return seatsBooked;
  }
    
  //setter methods for private attributes in play class
  void setPerformances(int performances) {
      this.performances = performances;
  }

  public void setSeatsBooked(int seatsBooked) {
      this.seatsBooked = seatsBooked;
  }
    
  // Override toString method
  public String toString() {
      return super.toString() + ", Performances: " + performances + ", Seats Booked: " + seatsBooked;
  }
}

class Musical extends Play {
  private String composer;
  private String lyricist;
  
  Musical(String title, String director, String writer, String composer, String lyricist, int performances, int seatsBooked) {     
    super(title, director, writer, performances, seatsBooked);
    this.composer = composer;
    this.lyricist = lyricist;
    }

    //getter methods for private attributes in Musical production
    String getComposer() {
        return composer;
    }
    String getLyricist() {
        return lyricist;
    }

    //setter methods for private attributes in Musical production
    void setComposer(String composer) {
        this.composer = composer;
    }
    void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    // Override toString method
    public String toString() {
        return super.toString() + ", Composer: " + composer + ", Lyricist: " + lyricist;
    }
}

public class Tester {
    public static void main(String[] args) {
        // Create objects
        Play play1 = new Play("Play 1", "Director 1", "Writer 1", 0, 0);
        Play play2 = new Play("Play 2", "Director 2", "Writer 2", 0, 0);
        Play play3 = new Play("Play 3", "Director 3", "Writer 3", 0, 0);

        Musical musical1 = new Musical("Musical 1", "Director 4", "Writer 4", "Composer 1", "Lyricist 1", 0, 0);
        Musical musical2 = new Musical("Musical 2", "Director 5", "Writer 5", "Composer 2", "Lyricist 2", 0, 0);

        // Increment performances
        play1.setPerformances(play1.getPerformances() + 1);
        play2.setPerformances(play2.getPerformances() + 1);
        play3.setPerformances(play3.getPerformances() + 1);
        musical1.setPerformances(musical1.getPerformances() + 1);
        musical2.setPerformances(musical2.getPerformances() + 1);

        // Book seats
        play1.setSeatsBooked(100);
        play2.setSeatsBooked(150);
        play3.setSeatsBooked(200);
        musical1.setSeatsBooked(120);
        musical2.setSeatsBooked(180);

        // Calculate box office collection
        int seatCostPlay = 500;
        int seatCostMusical = 800;

        int totalCollection = (play1.getSeatsBooked() + play2.getSeatsBooked() + play3.getSeatsBooked()) * seatCostPlay +
                              (musical1.getSeatsBooked() + musical2.getSeatsBooked()) * seatCostMusical;

        // Display total performances and box office collection
        int totalPerformances = play1.getPerformances() + play2.getPerformances() + play3.getPerformances() +
                                musical1.getPerformances() + musical2.getPerformances();

        System.out.println("Total No. of performances: " + totalPerformances);
        System.out.println("Total Box Office Collection: Rs " + totalCollection);
    }
}

