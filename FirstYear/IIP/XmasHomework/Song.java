
public class Song
{
  private String name;
  private String artist;
  private String genre;
  private boolean fav;
  private int seconds;
  private Song[] list;
  private int lastSong =0;
  private Song[] randomList;
  private int[] artistIndex;
  private int[] genreIndex;
  private int[] letterIndex;
  private int[] favoriteList;
  public Song(String n,String a,String g,boolean f, int s){
    name = n; artist = a; genre = g; fav = f; seconds = s;
        }
  
  public void createSong(String n,String a,String g,boolean f, int s, Song[] lista){
    lista[lastSong]=new Song(n,a,g,f,s);
    lastSong++;}
    
  public void createList(int len, Song[] lista){
    lista = new Song[len];}
          
  public Song[] createRandomList(int number){
    randomList = new Song[number];
    for(int count =0;count < number; count++){
    randomList[count]=list[(int)(Math.random()*list.length)-1];
    
    }
     return randomList;  
    }
    
 public int[] searchForArtist(String artista){
    int searchArt = 0;
     artistIndex= new int[list.length-1];
     for(int count = 0;count < artistIndex.length;count++){
        artistIndex[count]=-1;
        }
     for(int count = 0;count < artistIndex.length;count++){
        if(list[count].getArtist().equals(artista)){
         artistIndex[count]=count; }
        searchArt++;
        }
       return artistIndex; 
        }  
        
 public int[] searchForGenre(String genero){
    int searchGen =0;
     genreIndex= new int[list.length-1];
     for(int count = 0;count < artistIndex.length;count++){
        genreIndex[count]=-1;
        }
     for(int count = 0;count < artistIndex.length;count++){
        if(list[count].getGenre().equals(genero)){
         genreIndex[count]=count; }
        searchGen++;
        }
       return genreIndex; 
        } 
  public int[] searchForLetter(char letter){
  
     letterIndex= new int[list.length-1];
     for(int count = 0;count < letterIndex.length;count++){
        letterIndex[count]=-1;
        }
     for(int count = 0;count < letterIndex.length;count++){
        if((list[count].getName().charAt(0))==letter){
         letterIndex[count]=count; }
        
        }
       return letterIndex; 
        }        
  public int[] createFavoriteList(){
  
     favoriteList= new int[list.length-1];
     for(int count = 0;count < favoriteList.length;count++){
        favoriteList[count]=-1;
        }
     for(int count = 0;count < favoriteList.length;count++){
        if((list[count].getFav()==true)){
         favoriteList[count]=count; }
        
        }
       return favoriteList; 
        }        
  public void removeFromFavorite(Song s){
    for(int count = 0;count < list.length;count++){
    if(list[count]==s){
        list[count].setFav(false);
    for(int count2 = 0;count2 < list.length;count++){
    if(favoriteList[count]==count){favoriteList[count]=-1;}
    }
    }
    }   }           
        
          
  public void setName(String n){name = n;}
  public void setArtist(String a){artist = a;}     
  public void setGenre(String g){genre = g;}     
  public void setFav(boolean f){fav =f;}
  public void setSeconds(int s){seconds=s;}  
  
  public String getName(){return name;}
  public String getArtist(){return artist;}     
  public String getGenre(){return genre;}     
  public boolean getFav(){return fav;}
  public int getSeconds(){return seconds;}  
  
  
    
    
  
    }
